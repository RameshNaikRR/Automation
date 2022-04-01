package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class LoginPage extends BrowserFunctions {
	private By lblApplicationHeading = By.cssSelector(".title");
	private By lblApplicationDescription = By.cssSelector(".disclaimer");
	private By lnkLogin = By.xpath("//span[.='Log In']");
	private By lblHeading = By.cssSelector(".business-login__title");
	private By lblDescription = By.cssSelector(".business-login__sub_title");
	private By txtEmail = By.cssSelector("#Email");
	private By txtPassword = By.cssSelector("#Password");
	private By eyeIcon = By.xpath("//button[@type='button']");
	private By btnNext = By.cssSelector(".business-login__login-button");
	private By lnkForgotEmail = By.xpath("//span[.='Forgot Email?']");
	private By lnkForgotPassword = By.xpath("//span[.='Forgot Password?']");

//	public Robot robot() throws AWTException
//	{
//		return new Robot();
//	}

	public void verifyApplicationHeading(String applicationHeading) {
		new CommonFunctions().verifyLabelText(lblApplicationHeading, "applicationHeading", applicationHeading);

	}

	public void verifyApplicationDescription(String applicationDescription) {
		new CommonFunctions().verifyLabelText(lblApplicationDescription, "applicationDescription",
				applicationDescription);
	}

	public void clickLogin() {
		click(lnkLogin, "Login");
	}

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

	public void validateEmail(String email) {
		validateTextField(email, txtEmail, "Email");
	}

	public void validatePassword(String password) {
		validateTextField(password, txtPassword, "Password");
	}

	public void validateTextField(String text, By ele, String eleName) {
		String[] data = text.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, data[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, data[4]);
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
		new CommonFunctions().clickOutSideElement();
		if (getElement(btnNext, "Next button").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next button is Enabled");

		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickForgotEmail() {
		click(lnkForgotEmail, "ForgotEmailLink");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPasswordLink");
	}

	public void verifyEyeIcon() {
		new CommonFunctions().elementView(eyeIcon, "EyeIcon");
	}

	public void verifyEmail() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}

	public void verifyPassword() {
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
