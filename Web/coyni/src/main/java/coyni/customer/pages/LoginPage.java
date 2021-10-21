package coyni.customer.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class LoginPage extends BrowserFunctions{
	
	private By txtEmail = By.name("");
	private By txtPassword = By.name("");
	private By lnkForgotEmail = By.name(" ");
	private By lnkForgotPassword = By.name("");
	private By btnNext = By.name("");
	private By lnkSignUp = By.name(" ");
	private By heading = By.name("");
	private By lnkBackToLogin = By.name(" ");
	private By txtPhoneNumber = By.name("");
	private By lblerrorMsg =By.cssSelector("");
	
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
		click(btnNext, "Next");
	}
	public void clickSignUp() {
		click(lnkSignUp, "SignUp");
	}

	public void clickBackToLogin() {
		 click(lnkBackToLogin, "BackToLogin");
		 }
	public void fillPhoneNumber(String PhoneNumber) {
		 enterText(txtPhoneNumber, PhoneNumber, "PhoneNumber");
	}
	public  void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "autentication heading", expHeading);
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
	
	
	public ToastComponent toastComponent() {
		return new ToastComponent();}
  public AuthyComponent authyComponent() {
    return new AuthyComponent();}

}
