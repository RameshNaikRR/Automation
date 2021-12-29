package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PhoneVerificationComponent extends BrowserFunctions {

	private By inputBox = By.cssSelector("input[class *= 'verification-input']");
	private By heading = By.cssSelector(
			"div[class *= 'SmsValidation_phone_validation_sub']>div:first-of-type,div[class *= 'SmsValidationTwillo_phone_validation_sub']>div:first-of-type");
	private By lblMessage = By.cssSelector("span[class*='VerificationInput_code']");
	private By lnkResend = By.xpath("//div[contains(text(),'Resend')]");
	private By lnkGoBack = By.xpath("//div[text()='Back to Login']");
	private By lblPhoneNumber = By.cssSelector(".text-base.font-bold.text-cgy5");
	private By chooseHeading = By.xpath("//span[text()='Choose Account']");
	private By btnMail = By.cssSelector(".rounded-lg");
	private By btnReturnToLogin = By.xpath("//div[text()='Return to Login']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Phone Number Verification PopUp Heading", expHeading);
	}

	public void verifyPhoneNumber(String expPhonenumber) {
		new CommonFunctions().verifyLabelText(lblPhoneNumber, "exp phonenumber", expPhonenumber);
	}

	public void clickReturnToLogin() {
		click(btnReturnToLogin, "Return To Login");
	}

	public void fillpin(String code) {

		new AuthyComponent().fillInput(code);
	}

	public void verifyMessage(String expMessage) {
		waitForCondition(e -> e.findElement(lblMessage).getText().contains("Verification"),
				"verification message is displayed");
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

	public void verifyChooseHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(chooseHeading, "Choose Account Heading", expHeading);
	}

	public void clickEmail() {
		click(btnMail, "Click Email");
	}

	public void verifyLoginWithInvalidPin() {

		String pageURL = getPageURL();
		if (pageURL.contains("token-account")) {
			ExtentTestManager.setInfoMessageInReport("Login success with invalid pin");
		} else {
			ExtentTestManager.setInfoMessageInReport("Login failed with invalid pin");
		}
	}

	public EmailVerificationComponent emailVerificationComponent() {
		return new EmailVerificationComponent();
	}

}
