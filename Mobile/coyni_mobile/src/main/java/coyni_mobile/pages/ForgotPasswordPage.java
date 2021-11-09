package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ForgotPasswordPage extends MobileFunctions {

	private By lnkForgotPassword = MobileBy.xpath("");
	private By heading = MobileBy.xpath("");
	private By txtEmail = MobileBy.xpath("");
	private By btnClose = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By lblEmail = MobileBy.xpath("");
	private By lnkResend = MobileBy.xpath("");
	private By txtInputBoxes = MobileBy.xpath("");

	public void clickForgotPassword() {
		click(lnkForgotPassword, "Forgot Password");
	}

	public void verifyHeading(String expHeading) {
//new CommonFunctions().verifyLabelText(heading, "Forgot Password ", expHeading);
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

	public void verifyPhoneNumber(String expEmail) {
//new CommonFunctions().verifyLabelText(lblEmail, "exp Email", expEmail);
	}

	public void clickResend() {
		click(lnkResend, "Resend");
	}

	public void fillInputBoxes(String otp) {
		enterText(txtInputBoxes, otp, "OTP");
	}
}