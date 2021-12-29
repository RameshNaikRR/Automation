package coyni.customer.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PhoneVerificationComponent extends BrowserFunctions {

	private By inputBox = By.cssSelector("input[class *= 'verification-input']");
	private By heading = By.cssSelector("div[class *= 'SmsValidation_phone_validation_sub']>div:first-of-type,div[class *= 'SmsValidationTwillo_phone_validation_sub']>div:first-of-type");
	private By lblMessage = By.cssSelector("span[class*='VerificationInput_code']");
	private By lnkResend =By.xpath("//div[contains(text(),'Resend')]");
	private By lnkGoBack = By.xpath("//div[text()='Back to Login']");
	private By lblPhoneNumber =  By.cssSelector(".text-base.font-bold.text-cgy5");
	

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Phone Number Verification PopUp Heading", expHeading);
	}
	public void verifyPhoneNumber(String expPhonenumber) {
		new CommonFunctions().verifyLabelText(lblPhoneNumber, "exp phonenumber", expPhonenumber);
	}

	public void fillpin(String code) {

		new AuthyComponent().fillInput(code);
	}
	public void verifyMessage(String expMessage) {
		waitForCondition(e->e.findElement(lblMessage).getText().contains("Verification"), "verification message is displayed");
		new CommonFunctions().verifyLabelText(lblMessage, "Message", expMessage);
	}
	public void clickResend() {
		click(lnkResend, "Resend");
	}
	public void verifyResend(String expMessage) {
		new CommonFunctions().verifyLabelText(lnkResend, "Resend Message", expMessage);
	}

    public void clickGoBack() {
		click(lnkGoBack, "Back To Login");
	}
    
	public void verifyLoginWithInvalidPin(){
		
		String pageURL = getPageURL();
		if(pageURL.contains("token-account")) {
			ExtentTestManager.setInfoMessageInReport("Login success with invalid pin");
		} else {
			ExtentTestManager.setInfoMessageInReport("Login failed with invalid pin");
		}
	}
   public EmailVerificationComponent emailVerificationComponent() {
	   return new EmailVerificationComponent();
   }

}
