package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FailedToAddPayment extends MobileFunctions{
	
	private By lnkContactUs = MobileBy.xpath("");
	private By btnExit = MobileBy.xpath("");
	
	public void clickContactUs() {
		click(lnkContactUs, "ContactUs");
	}
	
	public void clickExit() {
		click(btnExit, "Exit");
	}

}
