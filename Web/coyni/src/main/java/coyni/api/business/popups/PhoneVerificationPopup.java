package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.admin.components.NavigationComponent;
import coyni.admin.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PhoneVerificationPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Phone Verification']");
	private By lblDescription = By.xpath("//div[contains(text(),'We sent you a 6-digit')]");
	private By lnkResendVerification = By.xpath("//div[text()='Resend the verification code.']");
	private By lblSmsVerificationCode = By.xpath("//h2[text()='SMS Verification Code:']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Phone Verification Heading is", expHeading);
	}

	public void verifyDescription(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDescription, "Phone Verification Description is", expHeading);
	}

	public void verifySmsVerificationCode(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSmsVerificationCode, "SMS Verification Code is", expHeading);
	}

	public void resendCode() {
		click(lnkResendVerification, "Resend Verification Code");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
