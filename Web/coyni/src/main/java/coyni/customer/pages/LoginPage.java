package coyni.customer.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.PhoneVerificationComponent;
import coyni.customer.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class LoginPage extends BrowserFunctions{
	
	private By txtEmail = By.name("email");
	private By txtPassword = By.name("password");
	private By lnkForgotEmail = By.xpath("//span[text()='Forgot Email?']");
	private By lnkForgotPassword = By.xpath("//span[text()='Forgot Password?']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkSignUp = By.xpath("//span[text()='Sign Up']");
	private By heading = By.cssSelector(".business-login__title");
	private By lnkBackToLogin = By.className("pl-1");
	private By txtPhoneNumber = By.id("Phone-Number");
	private By lblerrorMsg =By.cssSelector("span.error");
	private By txtFirstName =By.name("first_name");
	private By txtLastName =By.name("last_name");
	private By lblPhoneNumber =By.cssSelector(".text-base");
	private By lblEmail =By.cssSelector("");
	private By lnkResend =By.xpath("//div[contains(text(),'Resend')]");
	private By lnkGoBack =By.className("mt-3");
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
		if(getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
			}
			else {
				ExtentTestManager.setPassMessageInReport("Next button is Disabled" );
			}
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
		new CommonFunctions().verifyLabelText(heading, "Login heading", expHeading);
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

  public PhoneVerificationComponent phoneVerificationComponent() {
	  return new PhoneVerificationComponent();
  }
}
