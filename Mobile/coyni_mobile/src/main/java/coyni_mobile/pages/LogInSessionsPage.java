package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class LogInSessionsPage extends MobileFunctions{

	private By lblHeader = MobileBy.AccessibilityId("");
	private By lblDescription = MobileBy.AccessibilityId("");
	private By lnkChangePassword = MobileBy.AccessibilityId("");
	private By lblInactive = MobileBy.AccessibilityId("");
	private By lblActive = MobileBy.AccessibilityId("");
	private By btnEndAllSessions = MobileBy.AccessibilityId("");
	private By lblDeviceName = MobileBy.AccessibilityId("");
	private By lblDeviceLocation = MobileBy.AccessibilityId("");
	private By lblDate = MobileBy.AccessibilityId("");
	private By lblEndSessionHeading = MobileBy.AccessibilityId("");
	private By lblEndSessionDesc = MobileBy.AccessibilityId("");
	private By btnChangePassword = MobileBy.AccessibilityId("");

	public void viewLogInSessHeader() {
		new CommonFunctions().elementView(lblHeader, "Sessions Heading");
		new CommonFunctions().elementView(lblDescription, "Sessions Description");
	}

	public void clickChangePassword() {
		click(lnkChangePassword, "Change Password");
	}

	public void clickEndAllSessions() {
		click(btnEndAllSessions, "End All Sessions");
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}
//	public void clcikPassword() {
//		click(txtPassword, "password");
//	}
//
//	public void verifyLogin(String email, String password) {
//		if (getElement(imgCoyni, "coyni image").isDisplayed()) {
//			fillEmail(email);
//			fillPassword(password);
//			clickLogin();
//		}
//	}
//
//	public void fillPassword(String password) {
//		enterText(txtPassword, password, "password ");
//	}
//
//	public void clickRememberMe() {
//		click(chkBxRememberMe, "Remember");
//	}
//
//	public void verifyRememberMeView() {
//		new CommonFunctions().elementView(lblRememberMe, "Rememeber Me");
//	}
//
//	public void clickForgotPassword() {
//		click(lnkForgotPassword, "Forgot Password ");
//	}
//
//	public void clickRetrieveEmail() {
//		click(lnkRetrieveEmail, "Retrieve Email ");
//	}
//
//	public void verifyRetrieveEmailView() {
//		new CommonFunctions().elementView(lnkRetrieveEmail, "Retrieve Email");
//	}
	
	

}
