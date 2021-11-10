package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ResetPinCodePage extends MobileFunctions{
	
	private By lblHeading = MobileBy.xpath("");
	private By txtPin = MobileBy.xpath("");
	private By txtChangePin = MobileBy.xpath("");
	private By txtConfirmPin = MobileBy.xpath("");
	
//	public void verifyHeading(String expHeading) {
//		getText(lblHeading); ------------------------------------pending
		
//	}
	
	public void fillPin(String pin) {
		enterText(txtPin, pin, "Pin");
	}
	public void fillChangePin(String newPin) {
		enterText(txtChangePin, newPin, "New Pin");
	}
	public void fillConfirmPin(String newPin) {
		enterText(txtConfirmPin, newPin, "New Pin");
	}
    public ForgotPinPage forgotPinPage() {
    	return new  ForgotPinPage(); 
    }
}
