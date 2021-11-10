package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyCurrentEmailPage extends MobileFunctions {
	 private By heading = MobileBy.xpath("");
     private By lblEmail =MobileBy.xpath("");
     private By txtPin =MobileBy.xpath("");
     private By lnkResend =MobileBy.xpath("");
	 
	 
	 public void verifyHeading(String expHeading) {
			// new CommonFunctions().verifyLabelText(expHeading, expHeading, expHeading);
		 }
	 public void verifyEmail(String expEmail) {
		// new CommonFunctions().verifyLabelText(expEmail, expEmail, expEmail);
	 }

	 public void fillPin(String pin) {
		 
	 }
	 public void clickResend() {
		 click(lnkResend, "click Resend");
	 }
	 public VerifyNewEmailPage verifyNewEmailPage() {
		 return new VerifyNewEmailPage();
	 }
}
