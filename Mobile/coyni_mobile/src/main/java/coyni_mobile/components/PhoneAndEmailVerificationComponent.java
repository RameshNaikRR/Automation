package coyni_mobile.components;

import ilabs.MobileFramework.MobileFunctions;
import org.openqa.selenium.By;
import coyni_mobile.pages.AgreementPage;
import coyni_mobile.utilities.AndroidCommonFunctions;
import io.appium.java_client.MobileBy;

public class PhoneAndEmailVerificationComponent extends MobileFunctions{

	private By lblPhoneVerification = MobileBy.AccessibilityId("");
	private By lblPhoneDesc = MobileBy.AccessibilityId("");
	private By txtOtp = MobileBy.AccessibilityId("");
	private By lnkResend = MobileBy.AccessibilityId("");
	private By lblEmailVerification = MobileBy.AccessibilityId("");
	private By lblEmailDesc = MobileBy.AccessibilityId("");
	
	
	public void verifyPhoneVerificationView(String desc) {
		new AndroidCommonFunctions().elementView(lblPhoneVerification, "Phone verification");
		new AndroidCommonFunctions().verifyLabelText(lblPhoneDesc, "Description", desc);
	}
	public void verifyEmailVerificationView(String desc) {
		new AndroidCommonFunctions().elementView(lblEmailVerification, "Phone verification");
		new AndroidCommonFunctions().verifyLabelText(lblEmailDesc, "Description", desc);
	}
	public void clickResend() {
		click(lnkResend, "Resend");
	}
	public void fillOtp(String otp) {
		enterText(txtOtp, otp, "OTP");
	}
	public AgreementPage agreementPage() {
		return new AgreementPage();
	}
	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
	
	public CreatePasswordComponent createPasswordComponent() {
		return new CreatePasswordComponent();
	}
	public void verifyResendView() {
		new AndroidCommonFunctions().elementView(lnkResend, "Resend");
	}
	
	
	
	
	
	
}
