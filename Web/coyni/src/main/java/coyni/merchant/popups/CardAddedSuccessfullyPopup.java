package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CardAddedSuccessfullyPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[contains(.,'Card')]");
	private By lblDescription = By.xpath("//p[contains(.,'Your ')]");
	private By btnWithdrawCoyni = By.xpath("//button[.='Withdraw coyni']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription() {
		String text = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyWithdrawCoyniBtn() {
		new CommonFunctions().elementView(btnWithdrawCoyni, "Withdraw coyni");
	}

	public void clickWithdrawCoyniBtn() {
		click(btnWithdrawCoyni, "Withdraw coyni");
	}
}
