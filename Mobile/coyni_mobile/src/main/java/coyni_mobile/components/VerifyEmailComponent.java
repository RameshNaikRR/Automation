package coyni_mobile.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class VerifyEmailComponent extends MobileFunctions {

	private By lblEmail = MobileBy.xpath("");
	private By lnkResend = MobileBy.xpath("//*[contains(@resource-id,'resendTV')]");
	private By txtInputBoxes = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By lblverifyEmailheading = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");
	private By errOtpMsg = MobileBy.xpath(""); // incorrect enter otp
	private By resendErrMsg = MobileBy.xpath(""); // resend Msg
	private By tryAgin = MobileBy.xpath("//*[@text='Try Again']");
	private By tryAgainHeading = MobileBy.xpath("//*[@text='Retry Create Account']");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	private By lblResentMsg = MobileBy.xpath("//*[contains(@resource-id,'newCodeTV')]");

	public void verifyResentMsg(String expContent) {
		new CommonFunctions().verifyLabelText(lblResentMsg, "Verify Resent Msg", expContent);
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}

	public void clickTryAgain() {
		click(tryAgin, "Try Again");
	}

	public void verifyTryAgainHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(tryAgainHeading, "Try Again Heading", expHeading);
	}

	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "Exp Email", expEmail);
	}

	public void verifyEmailOtpHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblverifyEmailheading, "Forgot Password ", expHeading);
	}

	public void verifyResendErrMsg(String expErrorCode) {
		new CommonFunctions().verifyLabelText(resendErrMsg, "Verify Resend Error Message ", expErrorCode);
	}

	public void verifyOTPErrorMessage(String expHeading) {
		waitForCondition(e -> e.findElement(errOtpMsg).getText().contains("Verification"),
				"verification message is displayed");
		new CommonFunctions().verifyLabelText(errOtpMsg, "Incorrect Message ", expHeading);
	}

	public void clickResend() {
		click(lnkResend, "Resend");
	}

	MobileFunctions mobileFunctions = new MobileFunctions();

	public void fillInputBoxes(String otp) {
		List<WebElement> inputs = mobileFunctions.getElementList(txtInputBoxes, "input boxes");
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(otp.charAt(i) + "");
			}
			ExtentTestManager.setPassMessageInReport("verification entered in text field");
		}

	}

	public void clickClose() {
		click(btnClose, "click Close");
	}
}
