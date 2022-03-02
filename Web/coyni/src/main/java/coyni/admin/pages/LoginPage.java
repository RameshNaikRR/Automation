package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class LoginPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[text()='Log In to Coyni Admin']");
	private By lblDescription = By.xpath("//span[text()='Welcome back, let’s log in to your coyni admin account.']");
	private By txtEmail = By.cssSelector("#Email");
	private By txtPassword = By.cssSelector("#Password");
	private By btnNext = By.cssSelector(".business-login__login-button");
	private By lnkForgotEmail = By.xpath("//span[.='Forgot Email?']");
	private By lnkForgotPassword = By.xpath("//span[.='Forgot Password?']");

	public void verifyPageHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyPageDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", Description);
	}

	public void fillEmail(String Email) {
		enterText(txtEmail, Email, "Email");
	}

	public void fillPassword(String Password) {
		enterText(txtPassword, Password, "Password");

	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickForgotEmail() {
		click(lnkForgotEmail, "ForgotEmailLink");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPasswordLink");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public ForgotPasswordPage forgotPasswordPage() {
		return new ForgotPasswordPage();

	}

}
