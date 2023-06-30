package coyni_mobile.components;

import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;

import org.openqa.selenium.By;

import coyni_mobile.pages.AccountCreatedPage;
import coyni_mobile.pages.AgreementPage;
import coyni_mobile.utilities.CommonFunctions;
import io.appium.java_client.MobileBy;

public class PhoneAndEmailVerificationComponent extends MobileFunctions {

	private By lblPhoneVerification = MobileBy.xpath("//*[@text='Phone Verification']");
	private By lblPhoneDesc = MobileBy.AccessibilityId("Phone Verification Text");
	private By txtOtp = MobileBy.AccessibilityId("OTP");
	private By lnkResend = MobileBy.AccessibilityId("Resend Code");
	private By lblEmailVerification = MobileBy.AccessibilityId("Email Verification Heading");
	private By lblEmailDesc = MobileBy.AccessibilityId("Email Verification Text");
	private By lblNewCodeSent = MobileBy.AccessibilityId("New Verification Code Sent");
	private By lblInvalidCode = MobileBy.id("com.coyni.mapp:id/tvError");

//	Edit Profile Details
	private By lblCurrentEmailVerification = MobileBy.xpath("//*[@text='Current Email Verification']");
	private By currentEmaildesc = MobileBy.id("com.coyni.mapp:id/description");
	private By lblDontHaveAccess = MobileBy.xpath("");
	private By lnkContactUs = MobileBy.xpath("");
	private By lblNewEmailVerification = MobileBy.xpath("//*[@text='New Email Verification']");
	private By NewEmailDesc = MobileBy.xpath("com.coyni.mapp:id/description");
	private By lblCurrentPhoneVerification = MobileBy.xpath("");
	private By currentPhonedesc = MobileBy.xpath("");
	private By lblNewPhoneVerification = MobileBy.xpath("");
	private By NewPhoneDesc = MobileBy.xpath("");

	public void verifyLabelTextforPhNumVerifiDesc(String expText1, String expText2) {
		String[] actText = getText(lblPhoneDesc).split(":");
		String actTextPart1 = actText[0];
		System.out.println(actTextPart1);
		System.out.println(actText[1]);
		String[] actText2 = actText[1].split("(");
		System.out.println(actText2);
		String[] actText3 = actText[1].split("(");
		String actTextPart2 = actText3[1];
		if (expText1.equals(actTextPart1) && expText2.equals(actTextPart2)) {
			ExtentTestManager.setPassMessageInReport(actTextPart1 + ": " + actTextPart2);
		} else {
			ExtentTestManager.setWarningMessageInReport("The Phone Number Verification Description not as expected");

		}
	}
	public void verifyPhoneVerificationHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblPhoneVerification, "Phone Verification heading", heading);
	}

	public void verifyPhoneVerificationDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblPhoneDesc, "Phone Verification description", desc);
	}

	public void verifyEmailVerifiDesc(String desc, String email) {
		new CommonFunctions().verifyLabelTextforEmailDescription(lblEmailDesc, "Email Description", desc, email);
	}

	public void verifyEmailVerificationHeading(String desc) {
		new CommonFunctions().verifyLabelText(lblEmailVerification, "Email Verification", desc);
	}

	public void verifyInvalidCode(String expMsg) {
		new CommonFunctions().verifyLabelText(lblInvalidCode, "Invalid Code", expMsg);
	}

	public void verifyEmailVerificationScreen() throws InterruptedException {
		Thread.sleep(500);
		if (getElementList(lblEmailVerification, "Coyni").size() == 0) {
			ExtentTestManager.setPassMessageInReport("Forgot PIN button is not clicking,when screen is disabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Forgot PIN button is clicking,when screen is disabled");
		}
	}

	public void verifyCurrentEmailVerificationHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblCurrentEmailVerification, "current Email Verification", hdg);
	}

	public void verifyCurrentEmailVerificationText(String desc, String email) {
		new CommonFunctions().verifyLabelTextforEmailDescription(currentEmaildesc, "Current Email Description", desc, email);
	}

	public void verifyNewEmailVerificationHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblNewEmailVerification, "New Email Verification", hdg);
	}

	public void verifyNewEmailVerificationText(String desc, String email) {
		new CommonFunctions().verifyLabelTextforEmailDescription(NewEmailDesc, "New Email Description", desc, email);
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
		ExtentTestManager.setPassMessageInReport(getText(lblDontHaveAccess));
		click(lnkContactUs, "Contact us");
	}

	public void clickResend() {
		click(lnkResend, "Resend");
	}

	public void viewNewCodeSentMsg() {
		new CommonFunctions().elementView(lblNewCodeSent, "New Code Sent Msg");
		ExtentTestManager.setPassMessageInReport(getText(lblNewCodeSent));
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

	public AccountCreatedPage accountCreatedPage() {
		return new AccountCreatedPage();
	}

}
