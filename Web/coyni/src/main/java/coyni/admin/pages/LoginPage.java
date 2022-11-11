package coyni.admin.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.admin.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class LoginPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[text()='Log In to coyni Admin']");
	private By lblDescription = By.xpath("//span[text()='Welcome back, let’s log in to your coyni admin account.']");
	private By txtEmail = By.cssSelector("#Email");
	private By txtPassword = By.cssSelector("#Password");
	private By eyeIcon = By.xpath("//button[(@data-for='button')]");
	private By btnNext = By.cssSelector(".business-login__login-button");
	private By lnkForgotEmail = By.xpath("//button[.='Forgot Email?']");
	private By lnkForgotPassword = By.xpath("//button[.='Forgot Password?']");

	public void verifyPageHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", heading);
	}

	public void verifyPageDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", description);
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
	}
	public void clickEyeIcon() {
		click(eyeIcon, "EyeIcon");
	}
	
	
	public void clickOutSide() throws AWTException {
		new CommonFunctions().clickTab();
	}
	
	public void verifyPasswordMaskedView() {
		new CommonFunctions().verifyPasswordMaskedView(txtPassword, "password");
	}
//	public void clickNext() {
//		click(btnNext, "Next");
//	}
	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
			
			ExtentTestManager.setPassMessageInReport("Next button is Enabled");
		}
		else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}
	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(txtPassword, attribute, password);
		if (attributeValue.contains("password")) {

			ExtentTestManager.setInfoMessageInReport(password + " masked with black circles");
		} else {
			ExtentTestManager.setInfoMessageInReport(password + " not masked with black circles");
		}
	}

	public void clickForgotEmail() {
		click(lnkForgotEmail, "ForgotEmailLink");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPasswordLink");
	}
	public void verifyEmail() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}
	public void verifyPassword()
	{
		new CommonFunctions().elementView(txtPassword, "Password");
	}
	public void verifyForgotEmail() {
		new CommonFunctions().elementView(lnkForgotEmail, "ForgotEmail");
	}
	public void verifyForgotPassword() {
		new CommonFunctions().elementView(lnkForgotPassword, "ForgotPassword");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
	
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
	public ForgotPasswordPage forgotPasswordPage() {
		return new ForgotPasswordPage();

	}

	public ForgotEmailPage forgotEmailPage() {
		return new ForgotEmailPage();

	}

}
