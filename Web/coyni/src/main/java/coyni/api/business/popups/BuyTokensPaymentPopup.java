
package coyni.api.business.popups;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BuyTokensPaymentPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Buy Coyni Tokens']");
	private By lblSubheading = By.className("mt-3 text-xs text-center text-cgy2");
	private By txtAmount = By.cssSelector("#usd-amount-token");
	private By btnCovert = By.cssSelector("#flip-button");
	private By lnkChange = By.xpath("//span[text()='Change']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By btnCross = By.cssSelector(".self-end");
	private By btnBack = By.cssSelector(".self-start");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void verifySubHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSubheading, "expHeading", expHeading);
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
}
