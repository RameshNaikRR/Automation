package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class LandingPage extends MobileFunctions {

	private By btnGetStarted = MobileBy.xpath("");
	private By btnLogin = MobileBy.xpath("");

	public void clickGetStarted() {
		click(btnGetStarted, "Get Started");
	}

	public void clickLogin() {
		click(btnLogin, "Get Started");
	}

}
