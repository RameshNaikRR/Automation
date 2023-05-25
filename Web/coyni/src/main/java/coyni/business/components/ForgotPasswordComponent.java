package coyni.business.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ForgotPasswordComponent extends BrowserFunctions {

	private By lblPhoneHeading = By.xpath("");
	private By lblPhonedDes = By.xpath("");
	private By txtEamil = By.xpath("");
	private By btnNext = By.xpath("");
	private By lnkBacktoLogin = By.xpath("");
	private By lblCreatePasswordHeading = By.xpath("");
	private By lblCreatePasswordDes = By.xpath("");
	private By txtEnterNewPassword = By.xpath("");
	private By txtConfirmPassword = By.xpath("");
	private By btnSubmit = By.xpath("");
	private By reddot = By.cssSelector("");
	private By greendot = By.cssSelector("");
	private By btnIcon = By.cssSelector("");
	private By successHEading = By.xpath("");
	private By btnLogIn = By.xpath("");

	public void verifyForgotPasswordHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPhoneHeading, "Heading is: ", expHeading);
	}

	public void verifyForgotPasswordDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblPhonedDes, "Description is: ", expDes);
	}

	public void fillEmail(String email) {
		new CommonFunctions().verifyCursorAction(txtEamil, "Email");
		enterText(txtEamil, email, "Email");
	}

	public void clickNext() {
		new CommonFunctions().verifyCursorAction(btnNext, "Next");
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}

	}

	public void clickBacktoLogin() {
		new CommonFunctions().verifyCursorAction(lnkBacktoLogin, "Back to Login");
		click(lnkBacktoLogin, "Back to Login");
	}

	public void clickIcon() {
		click(btnIcon, "Eye Icon");
	}

	public void verifyCreatePasswordHeading() {
		new CommonFunctions().verifyLabelText(lblCreatePasswordHeading, "Create Password heading is: ",
				getCopiedData());
	}

	public void verifyCreatePasswordDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblCreatePasswordDes, "Description is: ", expDes);
	}

	public void fillEnterNewPassword(String enterNewPassword) {
		enterText(txtEnterNewPassword, enterNewPassword, "Enter New Password");
	}

	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
	}

	public void clickSubmit() {
		new CommonFunctions().verifyCursorAction(btnSubmit, "Submit");
		if (getElement(btnSubmit, "Submit").isEnabled()) {
			click(btnSubmit, "Submit");
			ExtentTestManager.setPassMessageInReport("Submit Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Submit Button is Disabled");
		}

	}

	public void verifySuccessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(successHEading, "Password Changed Heading", expHeading);
	}

	public void fillPassword(String newPassword) {
		int initialRedDot = getElementsList(reddot, "red dot").size();
		int initialGreenDot = getElementsList(greendot, "green dot").size();
		enterText(txtEnterNewPassword, newPassword, "New Password");
		int finalRedDot = getElementsList(reddot, "red dot").size();
		int finalGreenDot = getElementsList(greendot, "green dot").size();
		if (initialGreenDot == 0 && initialRedDot == 6 && finalRedDot == 0 && finalGreenDot == 6) {
			ExtentTestManager.setPassMessageInReport("password is valid");
		}
	}

	public void clickLoginIn() {
		new CommonFunctions().verifyCursorAction(btnLogIn, "Log In");
		if (getElement(btnLogIn, "Log In").isEnabled()) {
			click(btnLogIn, "Log In");
			ExtentTestManager.setPassMessageInReport("Submit Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Submit Button is Disabled");
		}

	}

	public EmailVerificationComponent emailVerificationComponent() {
		return new EmailVerificationComponent();
	}

}
