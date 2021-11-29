package coyni_mobile.components;



import org.openqa.selenium.By;



import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;



public class VerifyEmailComponent extends MobileFunctions {



private By lblEmail = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]");
private By lnkResend = MobileBy.xpath("//*[contains(@resource-id,'resendTV')]");
private By txtInputBoxes = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
private By lblverifyEmailheading = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]");
private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");
private By errOtpMsg = MobileBy.xpath("");
private By lblResend = MobileBy.xpath("//*[contains(@resource-id,'newCodeTV')]");



public void verifyEmailview() {
new CommonFunctions().elementView(lblEmail, "email");
}



public void verifyEmailOtpHeading(String expHeading) {
new CommonFunctions().verifyLabelText(lblverifyEmailheading, "Forgot Password ", expHeading);
}
// public void verifyEmailOtpHeading(String expHeading) {
// new CommonFunctions().verifyLabelText(verifyEmailHeading, "Verify Email Otp Screen ", expHeading);
//}
public void verifyResendlbl(String resendlbl) {
new CommonFunctions().verifyLabelText(lnkResend, "Resend label", resendlbl);

}
public void verifyNewResendlbl(String resendlbl) {
new CommonFunctions().verifyLabelText(lblResend, "Resend label is displayed as", resendlbl);

}

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