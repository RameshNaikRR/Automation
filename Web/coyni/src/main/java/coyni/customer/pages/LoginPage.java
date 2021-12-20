package coyni.customer.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.ForgotEmailComponent;
import coyni.customer.components.ForgotPasswordComponent;
import coyni.customer.components.PhoneVerificationComponent;
import coyni.customer.components.ToastComponent;
import coyni.customer.components.UserNameDropDownComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class LoginPage extends BrowserFunctions {

	private By txtEmail = By.name("email");
	private By txtPassword = By.name("password");
	private By lnkForgotEmail = By.xpath("//span[text()='Forgot Email?']");
	private By lnkForgotPassword = By.xpath("//span[text()='Forgot Password?']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkSignUp = By.xpath("//span[text()='Sign Up']");
	private By heading = By.cssSelector(".business-login__title,.title");

	private By lblerrorMsg = By.cssSelector("span.error");

	private By lblEmail = By.cssSelector("");

	private By txtOTP = By.cssSelector("");
	private By iconeye = By.cssSelector(".icon-button");

	public void fillEmail(String userName) {
		enterText(txtEmail, userName, "Email");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
	}

	public void clickForgotEmail() {
		click(lnkForgotEmail, "ForgotEmail");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPassword");
	}

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickSignUp() {
		click(lnkSignUp, "SignUp");
	}

	public void clickeyeIcon() {
		click(iconeye, "eye icon");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Login heading", expHeading);
	}

	public void verifySignUpView() {
		new CommonFunctions().elementView(lnkSignUp, "Sign up");
	}

	public void verifyEmailView() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}

	public void verifyPasswordView() {
		new CommonFunctions().elementView(txtPassword, "Password");
	}

	public void verifyForgotEmailView() {
		new CommonFunctions().elementView(lnkForgotEmail, "Forgot Email");
	}

	public void verifyForgotPasswordView() {
		new CommonFunctions().elementView(lnkForgotPassword, "Forgot Password");
	}

	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(txtPassword, attribute, password);
		if (attributeValue.contains("password")) {

			ExtentTestManager.setInfoMessageInReport(password + " masked with black circles");
		} else {
			ExtentTestManager.setInfoMessageInReport(password + " not masked with black circles");
		}
	}

	public void fillVerificationInput(String code) {
		List<WebElement> inputs = getElementsList(txtOTP, "OTP boxes");
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(code.charAt(i) + "");
			}
		}

	}

	public void viewEmail() {
		new CommonFunctions().elementView(txtEmail, "View Email");
	}

	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "exp email", expEmail);
	}

	public void validateRemainingAttempts(String expAttempts) {
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		String text = getText(lblerrorMsg, "error message").replaceAll("[^0-9]", "");
		if (expAttempts.equals(text)) {
			ExtentTestManager.setPassMessageInReport("Number of remaining invalid password attemps are " + expAttempts);
		} else {
			ExtentTestManager.setFailMessageInReport("Expected of number of remaining password attempts  are "
					+ expAttempts + " but actual are " + text);
		}
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public ForgotEmailComponent forgotEmailComponent() {
		return new ForgotEmailComponent();
	}
	public ForgotPasswordComponent forgotPasswordComponent() {
		return new ForgotPasswordComponent();
	}
	public UserNameDropDownComponent userNameDropDownComponent() {
		return new UserNameDropDownComponent();
	}
}
