package coyni_mobile.components;

import ilabs.MobileFramework.MobileFunctions;



import org.openqa.selenium.By;
import coyni_mobile.pages.AgreementPage;
import coyni_mobile.utilities.CommonFunctions;
import io.appium.java_client.MobileBy;

public class PhoneAndEmailVerificationComponent extends MobileFunctions{

	private By lblPhoneVerification = MobileBy.AccessibilityId("Phone Verification Heading");
	private By lblPhoneDesc = MobileBy.AccessibilityId("Phone Verification Text");
	private By txtOtp = MobileBy.AccessibilityId("");
	private By lnkResend = MobileBy.AccessibilityId("");
	private By lblEmailVerification = MobileBy.AccessibilityId("Email Verification Heading");
	private By lblEmailDesc = MobileBy.AccessibilityId("Email Verification Text");
	private By lblCurrentEmailVerification = MobileBy.AccessibilityId("");
	private By currentEmaildesc = MobileBy.AccessibilityId("");
	private By lblDontHaveAccess = MobileBy.AccessibilityId("");
	private By lnkContactUs = MobileBy.AccessibilityId("");
	private By lblNewEmailVerification = MobileBy.AccessibilityId("");
	private By NewEmailDesc = MobileBy.AccessibilityId("");
	private By lblCurrentPhoneVerification = MobileBy.AccessibilityId("");
	private By currentPhonedesc = MobileBy.AccessibilityId("");
	private By lblNewPhoneVerification = MobileBy.AccessibilityId("");
	private By NewPhoneDesc = MobileBy.AccessibilityId("");
	
	
	public void verifyPhoneVerificationView(String desc) {
		new CommonFunctions().elementView(lblPhoneVerification, "Phone verification");
		new CommonFunctions().verifyLabelText(lblPhoneDesc, "Description", desc);
	}
	public void verifyEmailVerificationView(String desc) {
		new CommonFunctions().elementView(lblEmailVerification, "Phone verification");
		new CommonFunctions().verifyLabelText(lblEmailDesc, "Description", desc);
	}
	public void verifyCurrentEmailVerificationHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblCurrentEmailVerification, "current Email Verification", hdg);
	}
	public void verifyCurrentEmailVerificationText(String text) {
		new CommonFunctions().verifyLabelText(currentEmaildesc, "current Email desc", text);
	}
	public void verifyNewEmailVerificationHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblNewEmailVerification, "New Email Verification", hdg);
	}
	public void verifyNewEmailVerificationText(String text) {
		new CommonFunctions().verifyLabelText(NewEmailDesc, "New Email desc", text);
	}
	public void verifyCurrentPhoneVerificationHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblCurrentPhoneVerification, "Current Phone Verification", hdg);
	}
	
	public void verifyCurrentPhoneVerificationText(String hdg) {
		new CommonFunctions().verifyLabelText(currentPhonedesc, "Current Phone desc", hdg);
	}
	public void verifyNewPhoneVerificationHdg(String hdg) {
		new CommonFunctions().verifyLabelText(lblNewPhoneVerification, "Current Phone desc", hdg);
	}
	public void verifyNewPhoneVerificationText(String hdg) {
		new CommonFunctions().verifyLabelText(NewPhoneDesc, "New Phone Desc", hdg);
	}
	
	public void verifyDontHaveAccess() {
		new CommonFunctions().elementView(lblDontHaveAccess, "Dont have Access");
		click(lnkContactUs, "Contact us");
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
		new CommonFunctions().elementView(lnkResend, "Resend");
	}
	
	
	
	
	
	
}
