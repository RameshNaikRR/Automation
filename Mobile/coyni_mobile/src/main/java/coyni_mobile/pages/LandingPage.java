package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
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
		new CommonFunctions().elementView(imgCoyni, "Coyni");
	}

	public void verifyCoyniDesc() {
		new CommonFunctions().elementView(descCoyni, "coyni description");
		ExtentTestManager.setPassMessageInReport("The description is : " + getText(descCoyni));
	}

	public void clickSignUp() {
		if (getElement(btnSignUp, "Sign up").isEnabled()) {
			click(btnSignUp, "Sign up");
		}
	}

	public void verifySignUpview() {
		new CommonFunctions().elementView(btnSignUp, "Signup");
	}

	public void verifyLoginView() {
		new CommonFunctions().elementView(imgCoyni, "Coyni");
		new CommonFunctions().elementView(btnSignUp, "Signup");
		new CommonFunctions().elementView(btnLogin, "Login");
	}

	public void clickLogin() {
		click(btnLogin, "login");
	}

	public void verifyLandingPageView() throws InterruptedException {
		Thread.sleep(500);
		if (getElementList(imgCoyni, "Coyni").size()==0) {
			ExtentTestManager.setPassMessageInReport("Logout button is not clicking,when screen is disabled");
		} else {
			ExtentTestManager
					.setFailMessageInReport("Logout button is clicking, when screen is disabled" + getText(descCoyni));
		}
	}

}
