package coyni_mobile.components;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyEmailComponent extends MobileFunctions {

	private By lblEmailHeading = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]|//*[@name='Verify Email']");
	private By lnkResend = MobileBy.xpath("(//*[@name='Resend'])[1]|//*[contains(@resource-id,'resendTV')]");
	private By txtInputBoxes = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By lblverifyEmailDescrp = MobileBy
			.xpath("//*[contains(@resource-id,'subHeaderTV')]|//*[contains(@name,'We sent you')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");
	private By errOtpMsg = MobileBy.xpath("");
	private By lblResend = MobileBy.xpath("//*[contains(@resource-id,'newCodeTV')]");
	private By lblVerifyDidntGetCode = MobileBy.xpath("//*[@text='Didn't get the code?']");
	private By lblEmailFiled = MobileBy.xpath("//*[contains(@resource-id,'resendTV')]");
	private By lblChosseYourPin = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By btnOk = MobileBy.xpath("(//*[@name='OK'])[1]|//*[contains(@resource-id,'cvAction')]");

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}

	/*
	 * public ChooseYourPinComponent chooseYouPinComponent() { return new
	 * ChooseYourPinComponent(); }
	 * 
	 * public ConfirmYourPinComponent confirmYourPinComponent() { return new
	 * ConfirmYourPinComponent(); }
	 */
	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}

	public void verifyEmailHeadingview() {
		new CommonFunctions().elementView(lblEmailHeading, "Verify Email");
	}

	public void verifyEmailOtpHeading(String expVerifyEmailDecrp) {
		new CommonFunctions().verifyLabelText(lblverifyEmailDescrp, "Forgot Password ", expVerifyEmailDecrp);
	}

	// public void verifyEmailOtpHeading(String expHeading) {
	// new CommonFunctions().verifyLabelText(verifyEmailHeading, "Verify Email Otp
	// Screen ", expHeading);
	// }
	public void verifyResendlbl(String resendlbl) {
		new CommonFunctions().verifyLabelText(lnkResend, "Resend label", resendlbl);

	}

	public void verifyNewResendlbl(String resendlbl) {
		new CommonFunctions().verifyLabelText(lblResend, "Resend label is displayed as", resendlbl);

	}

	public void verifyDidntGetCodeandResendView(String expDidntGetCodeText) {

		// new CommonFunctions().verifyLabelText(lblVerifyDidntGetCode, "Didnt Get Code
		// Heading", expDidntGetCodeText);
		new CommonFunctions().elementView(lblEmailFiled, "");
	}

	public void verifyChooseYourPinHeading(String expChooseYourPinHeading) {
		new CommonFunctions().verifyLabelText(lblChosseYourPin, "Choose your pin Heading", expChooseYourPinHeading);
	}

	public void verifyOTPErrorMessage(String expHeading) {
		new CommonFunctions().verifyLabelText(errOtpMsg, "Incorrect Message ", expHeading);
	}

	public void verifyCodeAfterTenMinutes() {
		Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MINUTES);

	}

	public void verifywithValidCode() {
		new CommonFunctions().elementView(lblEmailFiled, getCopiedData());
	}

	public void clickResend() {
		click(lnkResend, "Resend");
	}

	public void verifyInputView() {
		if (!new CommonFunctions().isPlatformiOS()) {
			new CommonFunctions().elementView(txtInputBoxes, "Input Boxes");
		} else {
			new EnterYourPINComponent().verifyPinView();
		}
	}

	public void fillInputBoxes(String otp) {
		if (!new CommonFunctions().isPlatformiOS()) {
			enterText(txtInputBoxes, otp, "OTP");
		} else {
			new EnterYourPINComponent().fillPin(otp);
		}

	}

	public void clickClose() {
		click(btnClose, "click Close");
	}

}