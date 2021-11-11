package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class LoginPage extends MobileFunctions {

	private By txtEmail = MobileBy.xpath("");
	private By txtPassword = MobileBy.xpath("");
	private By lnkRetriveEmail = MobileBy.xpath("");
	private By lnkForgotPassword = MobileBy.xpath("");
	private By chkBxRememberMe = MobileBy.xpath("");
	private By btnLogin = MobileBy.xpath("");

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email ");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "password ");
	}

	public void clickForgotEmail() {
		click(lnkRetriveEmail, "Retrieve Email ");

	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "Forgot Password ");

	}

	public void clickRememberMe() {
		click(chkBxRememberMe, "Remember");
	}

	public void clickLogin() {
		click(btnLogin, "login button");
	}

	public ForgotPasswordPage forgotPasswordPage() {
		return new ForgotPasswordPage();
	}

	public RetrieveEmailPage retrieveEmailPage() {
		return new RetrieveEmailPage();
	}

	public void verifyLoginView() {
		new CommonFunctions().elementView(btnLogin, "Login page");
	}

}