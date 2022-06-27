package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class EmailVerificationComponent extends BrowserFunctions {
	private By lblEmailHeading = By.xpath("//div[text()='Email Verification']");
	private By lblEmail = By.cssSelector(".text-base.font-bold.text-cgy5");
	private By lnkResendVerificationCode = By.xpath("//div[text()='Resend Verification Code']");
	private By txtFirstCodeBox = By.xpath("(//input[@class='verification-input  '])[1]");
	private By lblResendDescrp = By.xpath("//div[text()='New Verification Code Sent']");
	private By lnkGoBack = By.xpath("//div[text()='Go Back']");
	private By lblAccountCreated = By.cssSelector(".account-success__title");
	private By lblResendError  = By.xpath("//span[@class='text-base text-crd5']");
	
	public void verifyEmailHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmailHeading, "Email Verification PopUp Heading", expHeading);
	}
    
	public void verifyEmailDescription() {
		new CommonFunctions().elementView(lblEmail, "Email Verification Description");
	}
	
	public void verifyfirstCodeBoxAutoFocused() {
		new CommonFunctions().verifyAutoFocus(txtFirstCodeBox, "First Code Box is Auto Focused");
	}
	
	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "exp Email", expEmail);
	}

	public void clickResendVerificationCode() {
		click(lnkResendVerificationCode, "Resend Verification Code");
	}
	
	public void verifyResendDescription() {
		new CommonFunctions().elementView(lblResendDescrp, "Resend Description");
	}
	
	public void verifyResendError() {
		new CommonFunctions().elementView(lblResendError, "Resend Error");
	}

	public void clickGoBack() {
		click(lnkGoBack, "Go Back");
	}

	public void fillpin(String code) {
		new AuthyComponent().fillInput(code);
	}
	public void verifyAccountCreated(String expHeading) {
    	new CommonFunctions().verifyLabelText(lblAccountCreated, "Account Created PopUp Heading", expHeading);
    }
	
	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

}
