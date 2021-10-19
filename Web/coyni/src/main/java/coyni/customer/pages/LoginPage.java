package coyni.customer.pages;

import org.openqa.selenium.By;


import ilabs.WebFramework.BrowserFunctions;

public class LoginPage extends BrowserFunctions{
	
	private By txtEmail = By.name("email");
	private By txtPassword = By.name("password");
	private By lnkForgotEmail = By.name(" ");
	private By lnkForgotPassword = By.name("");
	private By btnNext = By.name("");
	private By lnkSignUp = By.name(" ");
	private By heading = By.name("");
	private By lnkBackToLogin = By.name(" ");
	private By txtPhoneNumber = By.name("");
	
	
	public void fillEmail(String userName) {
		enterText(txtEmail, userName, "Email");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
	}
	public void clickForgotEmail(String Email) {
		click(lnkForgotEmail, "ForgotEmail");
	}
    public void clickForgotPassword(String ForgotPassword) {
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
//		new CommonFunctions().verifyLabelText(heading, "autentication heading", expHeading);
	}
	
//	public ToastComponent toastComponent() {
//		return new ToastComponent();}
//  public AuthyComponent authyComponent() {
//    return new AuthyComponent();}

}
