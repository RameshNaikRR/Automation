package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyNewPhoneNumberPage  extends MobileFunctions{
	private By heading = MobileBy.xpath("");
	private By lblPhoneNumber =MobileBy.xpath("");
    private By txtPin =MobileBy.xpath("");
    private By lnkResend =MobileBy.xpath("");
	
    public void verifyHeading(String expHeading) {
		// new CommonFunctions().verifyLabelText(expHeading, expHeading, expHeading);
	 }
 public void verifyPhoneNumber(String expPhoneNumber) {
	// 
 }

 public void fillPin(String pin) {
	 
 }
 public void clickResend() {
	 click(lnkResend, "click Resend");
 }
 
}
