package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AuthorizationFailedPage extends MobileFunctions {
	
	private By btnTryAgain = MobileBy.xpath("");
	
	public void clickTryAgain() {
		click(btnTryAgain, "Try Again");
	}

}
