
package coyni.api.business.popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BuyTokensPaymentPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Buy coyni Tokens']");
	private By lblSubheading = By.className("mt-3 text-xs text-center text-cgy2");
	private By txtAmount = By.xpath("//input[@id='cyn-amount-token']");
	private By btnCovert = By.cssSelector("#flip-button");
	private By lnkChange = By.xpath("//span[text()='Change']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By btnCross = By.cssSelector(".self-end");
	private By btnBack = By.cssSelector(".self-start");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void verifySubHeading() {
		new CommonFunctions().elementView(lblSubheading, "SubHeading");
	}

	public void clickCovert() {
		click(btnCovert, "covert");
	}

	public void clickNext() {
		click(btnNext, "next");
	}

	public void clickChange() {
		click(lnkChange, "change");
	}

	public void clickCross() {
		click(btnCross, "cross");
	}

	public void clickbtnBack() {
		click(btnBack, "Back");
	}

	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public BuyCoyniTokensPopup buyCoyniTokensPopup() {
		return new BuyCoyniTokensPopup();
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
}
