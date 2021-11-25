package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyEmailComponent extends MobileFunctions {

	private By lblEmail = MobileBy.xpath("");
	private By lnkResend = MobileBy.xpath("//*[contains(@resource-id,'resendTV')]");
	private By txtInputBoxes = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By lblverifyEmailheading = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");
	private By errOtpMsg = MobileBy.xpath("");

	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "Exp Email", expEmail);
	}

	public void verifyEmailOtpHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblverifyEmailheading, "Forgot Password ", expHeading);
	}
//	public void verifyEmailOtpHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(verifyEmailHeading, "Verify Email Otp Screen ", expHeading);
//}

	public void verifyOTPErrorMessage(String expHeading) {
		new CommonFunctions().verifyLabelText(errOtpMsg, "Incorrect Message ", expHeading);
	}

	public void clickResend() {
		click(lnkResend, "Resend");
	}

	public void fillInputBoxes(String otp) {
		enterText(txtInputBoxes, otp, "OTP");
	}

	public void clickClose() {
		click(btnClose, "click Close");
	}
}
