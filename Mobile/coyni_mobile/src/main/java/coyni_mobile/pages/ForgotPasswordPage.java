package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ForgotPasswordPage extends MobileFunctions {

	private By forgotHeading = MobileBy.xpath("");
	private By txtEmail = MobileBy.xpath("");
	private By btnClose = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By verifyEmailHeading = MobileBy.xpath("");
	private By lblEmail = MobileBy.xpath("");
	private By lnkResend = MobileBy.xpath("");
	private By txtInputBoxes = MobileBy.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(forgotHeading, "Forgot Password ", expHeading);
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "Exp Email", expEmail);
	}
	
	public void verifyEmailOtp(String expHeading) {
		new CommonFunctions().verifyLabelText(verifyEmailHeading, "Verify Email Otp Screen ", expHeading);
	}

	public void clickResend() {
		click(lnkResend, "Resend");
	}

	public void fillInputBoxes(String otp) {
		enterText(txtInputBoxes, otp, "OTP");
	}
}