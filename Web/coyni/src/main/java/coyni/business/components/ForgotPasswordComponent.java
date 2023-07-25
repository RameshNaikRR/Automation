package coyni.business.components;

import java.awt.AWTException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.business.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ForgotPasswordComponent extends BrowserFunctions {

	private By heading = By.xpath("//span[@data-ui-auto='forgot_password']");
	private By txtEmail = By.xpath("//input[@data-ui-auto='email']");
	private By btnNext = By.xpath("//button[@data-ui-auto='next_button']");
	private By btnBackToLogin = By.xpath("//button[@data-ui-auto='back_to_login']");
	private By emailHeading = By.xpath("//div[text()='Email Verification']");
	private By lblEmail = By.cssSelector(".text-base ");
	private By lnkResend = By.cssSelector(".text-cm3");
	private By createPasswordHeading = By.xpath("//span[text()='Create New Password']");
	private By txtEnterPassword = By.xpath("//input[@name='enter_password']");
	private By txtConfirmPassword = By.xpath("//input[@name='confirm_password']");
	private By btnSubmit = By.xpath("//button[contains(text(),'Submit')]");
	private By btnLogin = By.cssSelector(".w-60");
	private By inputBox = By.cssSelector("input[class *= 'verification-input']");
	private By successHEading = By.xpath("//span[text()='Password Changed']");
	private By btnIcon = By.cssSelector(".icon-button");
	private By lblMessage = By.cssSelector("span[class*='VerifyYourIdentity_two_step'],span.text-crd5");
	// Added
//	private By contentForgotScreen = By.className("forgot-password__sub-title");
//	public void contentForgotScreen(String expHeading) {
//		new CommonFunctions().verifyLabelText(contentForgotScreen, "Forgot Password Content", expHeading);
//	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Forgot Password Heading", expHeading);
	}

	public void fillEmail(String email) throws Exception {
		enterText(txtEmail, email, "Email");
		clickTab();
	}

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickBackToLogin() {
		click(btnBackToLogin, "Back To Login");
	}

//	

	public void verifyEmailVerificationHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(emailHeading, "Email verification Heading", expHeading);
	}

	public void verifyEmail(String email) {
		new CommonFunctions().verifyLabelText(lblEmail, "Label Email", email);
	}

	public void clickResend() {
		click(lnkResend, "Resend");
	}

	public void verifyCreatePasswordHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(createPasswordHeading, "Create Password Heading", expHeading);
	}

//	public void fillPassword(String password) {
//		enterText(txtEnterPassword, "Enter Password", password);
//	}

	public void fillConfirmPassword(String confirmPassword) throws Exception {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
		clickTab();
	}

	public void clickSubmit() {
		if (getElement(btnSubmit, "Sunmit").isEnabled()) {
			click(btnSubmit, "Submit");
		} else {
			ExtentTestManager.setPassMessageInReport("Submit button is Disabled");
		}
	}

	public void clickLogin() {
		click(btnLogin, "Click Login");
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
		//
	}

//	public void clickTab() throws AWTException {
//		new LoginPage().clickTab();
//	}

	private By reddot = By.cssSelector(".red-dot");
	private By greendot = By.cssSelector(".green-dot");

	public void fillPassword(String newPassword) {
		int initialRedDot = getElementsList(reddot, "red dot").size();
		int initialGreenDot = getElementsList(greendot, "green dot").size();
		enterText(txtEnterPassword, newPassword, "New Password");
		int finalRedDot = getElementsList(reddot, "red dot").size();
		int finalGreenDot = getElementsList(greendot, "green dot").size();
		if (initialGreenDot == 0 && initialRedDot == 6 && finalRedDot == 0 && finalGreenDot == 6) {
			ExtentTestManager.setPassMessageInReport("password is valid");
		}
	}

	public void verifySuccessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(successHEading, "Password Changed Heading", expHeading);
	}

//	public void validateOTPField(String singleChar, String specialCharacters) {
//		new CommonFunctions().validateFieldWithalphabet(inputBox, "OTP", singleChar);
//		new CommonFunctions().validateFieldWithSpecialchar(inputBox, "OTP", specialCharacters);
//
//	}

	public void verifyMessage(String expMessage) {
		waitForCondition(e -> e.findElement(lblMessage).getText().contains("Verification"),
				"verification message is displayed");
		new CommonFunctions().verifyLabelText(lblMessage, "Sucess/Failure Message", expMessage);
	}

	public void clickIcon() {
		click(btnIcon, "Eye Icon");
	}

	public void clickTab() throws AWTException {
		new CommonFunctions().clickOutSideElement();
	}

	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(txtEnterPassword, attribute, password);
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
