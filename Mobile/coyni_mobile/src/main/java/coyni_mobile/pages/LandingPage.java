package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class LandingPage extends MobileFunctions {
	/****/
	private By btnSignUp = MobileBy.AccessibilityId("Sign Up");
	private By imgCoyni = MobileBy.AccessibilityId("coyni Logo");
	private By descCoyni = MobileBy.AccessibilityId("coyni sub heading");
	private By btnLogin = MobileBy.AccessibilityId("Log in");
	
	
	public void verifyCoyniView() {
		new AndroidCommonFunctions().elementView(imgCoyni, "Coyni");
	}
	public void verifyCoyniDesc() {
		ExtentTestManager.setInfoMessageInReport("The description is : " + getText(descCoyni));
	}
    public void clickSignUp() {
    	if(getElement(btnSignUp, "Sign up").isEnabled()) {
    		click(btnSignUp, "Sign up");
    	}
    }
    public void verifySignUpview() {
    	new AndroidCommonFunctions().elementView(btnSignUp, "Signup");
    }
    public void verifyLoginView() {
    	new AndroidCommonFunctions().elementView(btnLogin, "Login");
    }
    public void clickLogin() {
		if (getElement(btnLogin, "Log in").isEnabled()) {
			click(btnLogin, "login");
		}
	}
    
    
    
}
