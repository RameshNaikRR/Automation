package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PleaseCompleteVerificationPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Please Complete Verification']");
	private By lblDesc = By.xpath("//p[contains(text(),'We require users')]");
	private By btnAccountVerify = By.xpath("//button[text()='Account Verification']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Please Complete Verificaction", Heading);
	}

	public void verifyDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDesc, "Description", description);
	}

	public void clickAccountVerification() {
		click(btnAccountVerify, "Account Verification");
	}

}