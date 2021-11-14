package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyCurrentEmailPage extends MobileFunctions {
	 private By heading = MobileBy.xpath("");
     private By lblEmail =MobileBy.xpath("");
     private By txtPin =MobileBy.xpath("");
     private By lnkResend =MobileBy.xpath("");
	 
	 
	 public void verifyHeading(String expHeading) {
		 new CommonFunctions().verifyLabelText(heading, "Verify Current Email", expHeading);
		 }
	 public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "Email", expEmail);
	 }

	 public void fillPin(String pin) {
		 enterText(txtPin, pin, "pin");
	 }
	 public void verifyPinView() {
		 new CommonFunctions().elementView(txtPin, "pin");
	 }
	 public void clickResend() {
		 click(lnkResend, "click Resend");
	 }
	 public void verifyResendView() {
		 new CommonFunctions().elementView(lnkResend, "Resend");
	 }
	 public VerifyNewEmailPage verifyNewEmailPage() {
		 return new VerifyNewEmailPage();
	 }
	 public NavigationComponent navigationComponent() {
	    	return new NavigationComponent();	
	    	}
}
