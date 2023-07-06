package coyni.business.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CreatePasswordPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector("");
	private By lblDescription = By.cssSelector("");
	private By txtCreatePassword = By.id("");
	private By txtConfirmPassword = By.id("");
	private By lnkLogin = By.xpath("");
	private By lnkCoyni = By.xpath("");
	private By eyeIconCreate = By.xpath("");
	private By eyeIconConfirm = By.xpath("");
	private By btnCreate = By.xpath("");
	private By greendot = By.xpath("");
	private By greendot1 = By.xpath("");
	private By reddot = By.cssSelector("");
	private By btnSubmit = By.cssSelector("");
	private By lnkBackToLogin = By.xpath("");
	private By lblSucessHeading = By.cssSelector("");
	private By lblSucessDescription = By.cssSelector("");
	private By btnLogin = By.xpath("");
	private String CreatePassword;
	private String ConfirmPassword;

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Create New Password Heading ", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Create New Password Description ", expDescription);
	}

	public void verifyCreatePasswordAutoFocus() {
		new CommonFunctions().verifyAutoFocus(txtCreatePassword, "Create Password");
	}

	public void fillInvalidCreatePassword(String createPassword) {
		enterText(txtCreatePassword, createPassword, "Create Password");
	}

	public void fillCreatePassword(String createPassword) throws InterruptedException {
		String[] inputs = { "H", "h", "qazwsxeh", "qazwsxedcrfv", "@", "1" };
		String[] messages = { "uppercase", "lowercase", "total characters", "total characters", "special character",
				"number" };
		for (int i = 0; i < inputs.length; i++) {
			enterText(txtCreatePassword, inputs[i], "Create Password");
			String text = "";
			if (inputs[i].length() >= 8) {
				text = getText(greendot1, "Validation Dot");
			} else {
				text = getText(greendot, "Validation Dot");
			}
			if (text.toLowerCase().contains(messages[i])) {
				ExtentTestManager.setPassMessageInReport("Password field satisifies strength condition : " + text);
			} else {
				ExtentTestManager
						.setFailMessageInReport("Password field does not satisifies strength condition : " + text);
			}
//			new CommonFunctions().clearText(txtCreatePassword, "Create Password");

			clearText(txtCreatePassword, "Create Password");
		}
		int initialRedDot = getElementsList(reddot, "red dot").size();
		Thread.sleep(100);
		int initialGreenDot = getElementsList(greendot, "green dot").size();
		Thread.sleep(100);
		enterText(txtCreatePassword, createPassword, "Create Password");
		int finalRedDot = getElementsList(reddot, "red dot").size();
		int finalGreenDot = getElementsList(greendot, "green dot").size();
		System.out.println("value: " + initialRedDot + " " + initialGreenDot + " " + finalRedDot + " " + finalGreenDot);
		if (initialGreenDot == finalRedDot && initialRedDot == finalGreenDot && finalRedDot == initialGreenDot
				&& finalGreenDot == initialRedDot) {
			CreatePassword = getText(txtCreatePassword, "CreatePassword");
			ExtentTestManager.setPassMessageInReport("password is valid");
		} else {
			ExtentTestManager.setFailMessageInReport("password is invalid");
		}
	}

	public void fillConfirmPassword(String confirmPassword) throws AWTException {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
		ConfirmPassword = getText(txtConfirmPassword, "Confirm Password");
		new CommonFunctions().clickTab();
	}

	public void clickLogin() {
		if (getElement(lnkLogin, "Login").isEnabled()) {
			click(lnkLogin, " Login ");
		} else {
			ExtentTestManager.setInfoMessageInReport(" Login Button is Disabled");
		}
	}

	public void clickCoyni() {
		click(lnkCoyni, "Coyni");
	}

	public void clickEyeIconCreatePassword() {
		click(eyeIconCreate, "Eye Icon Create Password");
	}

	public void clickEyeIconConfirmPassword() {
		click(eyeIconConfirm, "Eye Icon Confirm Password");
	}

	public void verifyCreatePassword() {
		new CommonFunctions().elementView(txtCreatePassword, "Create Password");
	}

	public void verifyConfirmPassword() {
		new CommonFunctions().elementView(txtConfirmPassword, "Confirm Password");
	}

	public void verifyCreatePasswordEyeIcon() {
		new CommonFunctions().elementView(eyeIconCreate, "Create Password View Eye Icon");
	}

	public void verifyConfirmPasswordEyeIcon() {
		new CommonFunctions().elementView(eyeIconConfirm, "Confirm Password View Eye Icon");
	}

	public void verifyCreatePasswordMaskedView() {
		new CommonFunctions().verifyPasswordMaskedView(txtCreatePassword, "Create Password");
	}

	public void verifyConfirmPasswordMaskedView() {
		new CommonFunctions().verifyPasswordMaskedView(txtConfirmPassword, "Confirm Password");
	}

	public void clickCreate() {
		click(btnCreate, "Create Button");
	}

	public void clickBackToLogin() {
		click(lnkBackToLogin, "Back to Login");
	}

	public void clickSubmit() {
		if (getElement(btnSubmit, "Submit").isEnabled()) {
			click(btnSubmit, "Submit");
		} else {
			ExtentTestManager.setInfoMessageInReport(" Submit Button is Disabled");
		}
	}

	public void verifySucessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessHeading, " Password Sucess Heading ", expHeading);
	}

	public void verifySucessDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblSucessDescription, "Password Sucess Description ", expDescription);
	}

	public void clickLogIn() {
		new CommonFunctions().elementView(btnLogin, "Login");
		click(btnLogin, "Log In");
	}

}
