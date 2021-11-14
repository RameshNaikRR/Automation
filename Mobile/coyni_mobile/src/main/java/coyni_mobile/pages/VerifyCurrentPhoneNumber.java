package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyCurrentPhoneNumber extends MobileFunctions{
	 private By heading = MobileBy.xpath("");
     private By lblPhoneNumber =MobileBy.xpath("");
     private By txtPin =MobileBy.xpath("");
     private By lnkResend =MobileBy.xpath("");
	 
	 
	 public void verifyHeading(String expHeading) {
			new CommonFunctions().verifyLabelText(heading, "Current Phone Number heading", expHeading);
		 }
	 public void verifyPhoneNumber(String expPhoneNumber) {
		new CommonFunctions().verifyLabelText(lblPhoneNumber, "PhoneNumber", expPhoneNumber);
	 }
public void verifyPinView() {
	new CommonFunctions().elementView(txtPin, "Pin");
}
	 public void fillPin(String pin) {
		 enterText(txtPin, "pin", pin);
	 }
	 public void clickResend() {
		 click(lnkResend, "click Resend");
	 }
	 public void verifyResendView() {
		 new CommonFunctions().elementView(lnkResend, "Resend");
	 }
	 public NavigationComponent navigationComponent() {
	    	return new NavigationComponent();	
	    	}

}
