package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CreatePasswordPage extends BrowserFunctions {

	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By txtCreatePassword = By.xpath("");
	private By txtConfirmPassword = By.xpath("");
	private By lnkLogin = By.xpath("");
	private By lnkCoyni = By.xpath("");
	private By iconEyeCreate = By.xpath("");
	private By iconEyeConfirm = By.xpath("");
	private By btnCreate = By.xpath("");
	private By lblGreenDot = By.xpath("");
	private By lblRedDot = By.xpath("");
	private By btnSubmit = By.xpath("");
	private By lnkBackToLogin = By.xpath("");



	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Create New Password", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Create New Password Description ", expDescription);
	}

	public void fillCreatePassword(String createPassword) {
		enterText(txtCreatePassword, createPassword, "CreatePassword");
	}

	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "ConfirmPassword");
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
		click(iconEyeCreate, "Eye Icon Create Password");
	}

	public void clickEyeIconConfirmPassword() {
		click(iconEyeConfirm, "Eye Icon Confirm Password");
	}

	public void clickCreate() {
		click(btnCreate, "Create Button");
	}

	public void verifyPasswordStrength(String newPassword) {
		int initialRedDot = getElementsList(lblRedDot, "red dot").size();
		int initialGreenDot = getElementsList(lblGreenDot, "green dot").size();
		enterText(txtCreatePassword, newPassword, "New Password");
		int finalRedDot = getElementsList(lblRedDot, "red dot").size();
		int finalGreenDot = getElementsList(lblGreenDot, "green dot").size();
		if (initialGreenDot == 0 && initialRedDot == 6 && finalRedDot == 0 && finalGreenDot == 6) {
			ExtentTestManager.setPassMessageInReport("password is valid");
		}
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

}
