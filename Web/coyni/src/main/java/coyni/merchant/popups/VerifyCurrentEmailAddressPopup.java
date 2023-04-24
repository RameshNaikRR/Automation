package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.PhoneVerificationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class VerifyCurrentEmailAddressPopup extends BrowserFunctions {

	private By lnkResendVerificationCode = By.xpath("//span[normalize-space()='Resend Verification Code']");
	private By lblCurrentEmailHeading = By.xpath("//h1[text()='Verify Current Email Address']");
	private By lblCurrentEmail = By.cssSelector(".text-base.font-semibold.text-cm3");

	public void clickOnResendVerificationCode() {
		click(lnkResendVerificationCode, "Click ResendVerificationCode");
	}

	public void verifyCurrentEmailAddressHeading(String currentEmail) {
		new CommonFunctions().verifyLabelText(lblCurrentEmailHeading, "Current Email Address Popup ", currentEmail);
	}

	public void verifyCurrentEmail(String exestingEmail) {
		new CommonFunctions().verifyLabelText(lblCurrentEmail, "Current Email", exestingEmail);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public VerifyNewEmailAddressPopUp verifyNewEmailAddressPopUp() {
		return new VerifyNewEmailAddressPopUp();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

}
