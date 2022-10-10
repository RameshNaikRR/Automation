package coyni.merchant.components;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PhoneVerificationComponent extends BrowserFunctions {

	private By inputBox = By.cssSelector("input[class *= 'verification-input']");
	private By heading = By.cssSelector(
			"div[class *= 'SmsValidation_phone_validation_sub']>div:first-of-type,div[class *= 'SmsValidationTwillo_phone_validation_sub']>div:first-of-type");
	private By lblMessage = By.cssSelector("span[class*='VerificationInput_code']");
	private By lnkResend = By.xpath("//button[contains(text(),'Resend Verification Code')]");
	private By lnkResendCode = By.xpath("//button[contains(text(),'Resend verification code.')]");
	private By lnkGoBack = By.xpath("//div[text()='Back to Login']");
	private By lblPhoneNumber = By.xpath("//p[contains(text(),'We sent you a 6-digit')]/span[1]");
	private By chooseHeading = By.xpath("//span[text()='Choose Account']");
	private By btnMail = By.cssSelector(".rounded-lg");
	private By btnLogin = By.xpath("//button[text()='Login']");
	private By btnReturnToLogin = By.xpath("//div[text()='Return to Login']");
	private By phoneVerificationHeading = By.xpath("//div[text()='Phone Verification']");
	private By phoneVerificationNumber = By.xpath("//span[@class='text-base font-bold text-cgy4']");
	private By txtFirstCodeBox = By.xpath("(//input[@class='verification-input  '])[1]");
	private By lblResendDescrp = By.xpath("//div[text()='New Verification Code Sent']");
	private By lblResendError = By.xpath("//span[@class='text-base text-crd5']");
	private By btnGoBack = By.xpath("//button[text()='Go Back']");

	public void verifyPhoneVerificationHeading() {
		new CommonFunctions().elementView(phoneVerificationHeading, "Phone Verification Heading");
	}

	public void verifPhoneVericationDescription() {
		new CommonFunctions().elementView(phoneVerificationNumber, "Phone Verification Description");
	}

	public void clickLogin() {
		click(btnLogin, "Login");
	}

	public void clickResendCode() {
		click(lnkResendCode, "Resend Code");
	}

	public void verifyPhoneVerificationNumber(String expPhoneVerificationNumber) {
		new CommonFunctions().verifyLabelText(phoneVerificationNumber, "Phone Number", expPhoneVerificationNumber);
	}

	public void verifyVerificationCodeBoxAutoFocused() {
		new CommonFunctions().verifyAutoFocus(txtFirstCodeBox, "First Text Code Box is Auto Focused");
	}

	public void verifyResendDescrp() {
		new CommonFunctions().elementView(lblResendDescrp, "Resend description");
	}

	public void verifyResendError() {
		new CommonFunctions().elementView(lblResendError, "Resend error");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Phone Number Verification PopUp Heading", expHeading);
	}

	public void verifyPhoneNumber() {
		getText(lblPhoneNumber, "Phone Number");
//		new CommonFunctions().verifyLabelText(lblPhoneNumber, "exp phonenumber", expPhonenumber);
	}

	public void clickReturnToLogin() {
		click(btnReturnToLogin, "Return To Login");
	}

	public void fillpin(String code) {

		List<WebElement> inputs = getElementsList(inputBox, "input boxes");
		int noOfInputs = inputs.size();
		if (noOfInputs == 6) {
			for (int i = 0; i < noOfInputs; i++) {
				inputs.get(i).sendKeys(code.charAt(i) + "");
			}
			ExtentTestManager.setPassMessageInReport("verification entered in text field");
		}
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

	public void clickButtonGoBack() {
		click(btnGoBack, "Click Go Back");
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

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

}
