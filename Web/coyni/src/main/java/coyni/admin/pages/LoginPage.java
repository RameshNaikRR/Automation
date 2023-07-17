package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
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
	private By lnkSignUp = By.xpath("//button[text()='Sign Up']");
	private By btnSms = By.xpath("//div[contains(@class,'text-x')]");
	private By btnResendVerification = By.xpath("//button[contains(@class,'text-cm3 hover:underline mt')]");
	private By btnNewVerification = By.xpath("//div[contains(@class,'text-cgn')]");
	private By lnkRetrieveEmail = By.xpath("//div[contains(@class,'text-cgn')]");
	CommonFunctions commonfunctions = new CommonFunctions();

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

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next button is Enabled");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickForgotEmail() {
		click(lnkRetrieveEmail, "ForgotEmailLink");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPasswordLink");
	}

	public void verifyEmail() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}

	public void verifyPassword() {
		new CommonFunctions().elementView(txtPassword, "Password");
	}

	public void verifyForgotEmail() {
		new CommonFunctions().elementView(lnkRetrieveEmail, "ForgotEmail");
	}

	public void verifyForgotPassword() {
		new CommonFunctions().elementView(lnkForgotPassword, "ForgotPassword");
	}

	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(txtPassword, attribute, password);
		if (attributeValue.contains("password")) {

			ExtentTestManager.setInfoMessageInReport(password + " masked with black circles");
		} else {
			ExtentTestManager.setInfoMessageInReport(password + " not masked with black circles");
		}
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}
