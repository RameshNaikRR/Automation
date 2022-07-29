package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class NoFundsAvailablePopup extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//h2[.='No Funds Available']");
	private By lblDescription = By.xpath("//p[contains(.,'You have no ')]");
	private By btnBuyCoyni = By.xpath("//button[.='Buy coyni']");
	private By btnClose = By.xpath("//button[@class='self-end']");

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription(String Description) {
		cf.verifyLabelText(lblDescription, "Description", Description);
	}

	public void clickBuyCoyni() {
		click(btnBuyCoyni, "Buy Coyni");
	}

	public void verifyBuyCoyniBtn() {
		cf.elementView(btnBuyCoyni, "Buy Coyni");
	}

	public void clickClose() {
		click(btnClose, "Close ");
	}

	public void verifyCloseBtn() {
		cf.elementView(btnClose, "Buy Coyni");
	}
}
