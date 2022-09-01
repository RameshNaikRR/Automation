package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CompleteVerificationPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[contains(text(),'Please Complete Verification')]");
	private By lblDescription = By.xpath("//h1[contains(text(),'Please Complete Verification')]/..//p");
	private By btnAccount = By.xpath("//button[contains(text(),'Account Verification')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, "Heading");
	}

	public void verifyDescription() {
		ExtentTestManager.setInfoMessageInReport("Description: " + getText(lblDescription, "Description"));
	}

	public void clickAccountVerification() {
		click(btnAccount, "Account Verification");
	}

}
