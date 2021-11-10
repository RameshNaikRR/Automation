package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ForgotPinPage extends MobileFunctions{
	
	private By lnkForgotPin = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	
	public void clickForgotPin() {
		click(lnkForgotPin, "ForgotPin");
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
	

}
