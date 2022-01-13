package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;



public class VerifyCurrentPhoneNumberPopup extends BrowserFunctions {

	private By btnResendVerificationCode = By.xpath("//button[@type='submit']");
	private By headingCurrentPhoneNumber = By.xpath("//h1[text()='Verify Current Phone Number']");
	private By lblResendVerificationCodeDescription = By.xpath("//span[contains(text(),'verication Code Sent')]");
	private By lblresendErrorMsg = By.xpath("//span[contains(text(),'Looks like something went wrong. Please try again')]");
	
	public VerifyNewPhoneNumberPopup verifyNewPhoneNumberPopup() {
		return new VerifyNewPhoneNumberPopup();
	}
	
	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
	
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	
	public void verifyCurrentPhoneNumberHeading(String expHeadingCurrentNumber) {
		new CommonFunctions().verifyLabelText(headingCurrentPhoneNumber, "Current Phone Number Heading is",
				expHeadingCurrentNumber);
	}

	public void clickResend() {
		click(btnResendVerificationCode, "Click Resend Verification Code");
	}

	public void verifyResendVerificationCodeDescription(String expResendVerificationCodeDescription) {
		new CommonFunctions().verifyLabelText(lblResendVerificationCodeDescription,
				"Resend Verifiation Code Description", expResendVerificationCodeDescription);
	}
	
	public void verifyMultipleResend() {
		for(int i= 0; i<=5;i++) {
			clickResend();
		}
	}
	
	public void ResendErrorMessage(String expResendErrorMsg) {
		new CommonFunctions().verifyLabelText(lblresendErrorMsg, expResendErrorMsg, "Resend Error Message");
	}
	
}
