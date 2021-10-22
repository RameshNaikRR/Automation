package coyni.customer.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	private By txtFirstName =By.cssSelector("");
	private By txtLastName =By.cssSelector("");
	private By lblPhoneNumber =By.cssSelector("");
	private By lblEmail =By.cssSelector("");
	private By lnkResend =By.cssSelector("");
	private By lnkGoBack =By.cssSelector("");
	private By txtOTP=By.cssSelector("");
	
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
	
	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
	}
	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
	}
	
	public void clickResend() {
		click(lnkResend, "click send");
	}
	public void clickGoBack() {
		click(lnkGoBack, "click goback");
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
	
	public void verifyPhoneNumber(String expPhonenumber) {
		new CommonFunctions().verifyLabelText(lblPhoneNumber, "exp phonenumber", expPhonenumber);
	}
	
	public void verifyResendMessage(String expResendMsg) {
		new CommonFunctions().verifyLabelText(lnkResend, "exp resend Msg", expResendMsg);
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
	
	
	public ToastComponent toastComponent() {
		return new ToastComponent();}
  public AuthyComponent authyComponent() {
    return new AuthyComponent();}

}
