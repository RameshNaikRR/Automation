package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class LandingPage extends MobileFunctions {

	private By btnGetStarted = MobileBy
			.xpath("//*[contains(@resource-id,'getStartedLL')]|(//*[@name='Get Started'])[1] ");
	private By btnLogin = MobileBy.xpath("//*[contains(@text,'Log in')]|//*[contains(@resource-id,'layoutLogin')]|(//*[@name='Log in'])[1]");

	public void clickGetStarted() {
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
		click(btnGetStarted, "Get Started");
	}

	public void clickLogin() {
		if (getElementList(btnLogin, "").size() > 0) {
			click(btnLogin, "login");
		}
	}
    public void verifyLoginbtnView() {
    	new  CommonFunctions().elementView(btnLogin, "Login");
    	
    }
	public void verifyLandingPage() {
		new CommonFunctions().elementView(btnGetStarted, "Landing Page ");
	}

}
