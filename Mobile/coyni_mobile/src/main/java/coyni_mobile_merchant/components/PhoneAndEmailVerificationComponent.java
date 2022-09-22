package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile_merchant.pages.*;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.CreatePasswordPage;
import coyni_mobile_merchant.pages.FoundAccountPage;
import coyni_mobile_merchant.popups.ErrorMessagePopup;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PhoneAndEmailVerificationComponent extends MobileFunctions {

	private By phoneHeading = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]");
	private By phoneDescription = MobileBy.xpath("//*[contains(@resource-id,'subHeaderTV')]");
	private By txtCode = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By lblDidntGetCode = MobileBy.xpath("//*[@text=\"Didn't get the code?\"]");
	private By lnkResend = MobileBy.xpath("//*[@text='Resend']");
	private By btnBackspace = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");
	private By emailHeading = MobileBy.xpath("//*[@text='Verify Email']|//*[contains(@resource-id,'headerTV')]");
	private By lblEmailText = MobileBy.xpath("//*[contains(@resource-id,'subHeaderTV')]");
//	private By lblGetCode =MobileBy.xpath("//*[@text='Didn't get the code?']");
	private By lblNewCode = MobileBy.xpath("//*[@text=' A new code has sent']");
	private By lblPopupHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblPopupMsg = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	private By errorPopuphdg = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By errorPopupDesc = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");

	public void verifyPopUpView() {
		new CommonFunctions().elementView(lblPopupHeading, "Popup");
	}

	public void verifyPopupHeading(String expPopupHeading) {
		new CommonFunctions().verifyLabelText(lblPopupMsg, "Popup Heading", expPopupHeading);
	}

	public void verifyPopupMsg(String expPopupMsg) {
		new CommonFunctions().verifyLabelText(lblPopupMsg, "Popup Message", expPopupMsg);
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}

	public void verifyErrorHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(errorPopuphdg, "Popup Heading", expHeading);
	}

	public void verifyErrorDesc(String expDesc) {
		new CommonFunctions().verifyLabelText(errorPopupDesc, "Popup Desc ", expDesc);
	}

	public void verifyPhoneHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(phoneHeading, "Page Heading", expHeading);
	}

	public void verifyEmailHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(emailHeading, "Page Heading", expHeading);
	}

	public void verifyPhoneDescription(String expText) {
		new CommonFunctions().verifyLabelText(phoneDescription, "Phone Verification Description ", expText);
	}

	public void verifyEmailText(String expText) {
		new CommonFunctions().verifyLabelText(lblEmailText, "Email Verification Description ", expText);
	}

	public void getEmailText() {
		String str = getText(lblEmailText);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getPhoneDescription() {
		String str = getText(phoneDescription);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyOtpTextFieldView() {
		new CommonFunctions().elementView(txtCode, "OTP Text field");
	}

	public void verifyGetCodeView() {
		new CommonFunctions().elementView(lblDidntGetCode, "Didn't get the code");
	}

	public void verifyResendView() {
		new CommonFunctions().elementView(lnkResend, "Resend");
	}

	public void verifyBackButtonView() {
		new CommonFunctions().elementView(btnBackspace, "Back Icon");
	}

	public void clickCloseIcon() {
		click(btnBackspace, "Back Space");
	}

	public void clickResend() {
		click(lnkResend, "Resend");
	}

	public void verifyNewCodeMsg(String expMessage) {
		new CommonFunctions().verifyLabelText(lblNewCode, "Message", expMessage);
	}

	public void verifyRemove(String invalidPin, By ele) {
		fillPin(invalidPin);
		click(btnBackspace, "Backspace");
		String text = new CommonFunctions().getTextBoxValue(ele);
		if (text.equalsIgnoreCase(invalidPin)) {
			ExtentTestManager.setPassMessageInReport("Backspace is working");
		} else {
			ExtentTestManager.setFailMessageInReport("Backspace is not working");
		}
	}

	public void verifyRemoveCode(String invalidPin) {
		verifyRemove(invalidPin, txtCode);
	}

	public void fillPin(String pin) {
		enterText(txtCode, pin, "pin");
	}

	public void verifyPhoneVerificationPage() {
		new CommonFunctions().elementView(phoneHeading, "Phone Verification Page");
	}

	public void verifyEmailVerificationPage() {
		new CommonFunctions().elementView(emailHeading, "Email Verification Page");
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public ErrorMessagePopupComponent errorMessagePopupComponent() {
		return new ErrorMessagePopupComponent();
	}

	public FoundAccountPage foundAccountPage() {
		return new FoundAccountPage();
	}

	public CreatePasswordPage createPasswordPage() {
		return new CreatePasswordPage();
	}
	public SecureAccountPage secureAccountPage() {
		return new SecureAccountPage();
	}

}
