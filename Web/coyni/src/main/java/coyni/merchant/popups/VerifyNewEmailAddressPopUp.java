package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class VerifyNewEmailAddressPopUp extends BrowserFunctions {

	private By lblNewEmailHeading = By.xpath("//h1[text()='Verify New Email Address']");
	private By lblNewEmail = By.cssSelector(".text-base.font-semibold.text-cm3");
	private By lnkResendVerificationCode = By.xpath("//button[normalize-space()='Resend Verification Code']");

	public void verifyNewEmailAddress(String newEmailHeading) {
		new CommonFunctions().verifyLabelText(lblNewEmailHeading, "New Email Address Popup Heading", newEmailHeading);
	}

	public void verifyNewEmail(String newEmail) {
		new CommonFunctions().verifyLabelText(lblNewEmail, "New Email Heading", newEmail);
	}

	public void clickOnResendVerificationCode() {
		click(lnkResendVerificationCode, "Click ResendVerificationCode");
	}

	public VerifyCurrentEmailAddressPopup verifyCurrentEmailAddressPopup() {
		return new VerifyCurrentEmailAddressPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

}
