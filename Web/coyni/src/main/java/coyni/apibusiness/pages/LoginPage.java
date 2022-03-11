package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.admin.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class LoginPage extends BrowserFunctions {
	private By lblHeading = By.cssSelector(".business-login__title");
	private By lblDescription = By.cssSelector(".business-login__sub_title");
	private By txtEmail = By.cssSelector("#Email");
	private By txtPassword = By.cssSelector("#Password");
	private By eyeIcon = By.xpath("//button[@type='button']");
	private By btnNext = By.cssSelector(".business-login__login-button");
	private By lnkForgotEmail = By.xpath("//span[.='Forgot Email?']");
	private By lnkForgotPassword = By.xpath("//span[.='Forgot Password?']");

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
	
	public void verifyPasswordMaskedView() {
		new CommonFunctions().verifyPasswordMaskedView(txtPassword, "password");
	}
//	public void clickNext() {
//		click(btnNext, "Next");
//	}
	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
		}
		else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
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
