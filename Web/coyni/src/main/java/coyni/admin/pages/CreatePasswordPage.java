package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CreatePasswordPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector(".update-password-password__title");
	private By lblDescription = By.cssSelector(".update-password-password__sub-title");
	private By txtCreatePassword = By.id("Enter_Password");
	private By txtConfirmPassword = By.id("confirm_Password");
	private By lnkLogin = By.xpath("");
	private By lnkCoyni = By.xpath("");
	private By eyeIconCreate = By.xpath("(//button[@type='button'])[1]");
	private By eyeIconConfirm = By.xpath("(//button[@type='button'])[2]");
	private By btnCreate = By.xpath("");
	private By greendot = By.xpath("//span[@class='green-dot']/parent::span");
	private By greendot1 = By.xpath("(//span[@class='green-dot']/parent::span)[2]");
	private By reddot = By.cssSelector(".red-dot");
	private By btnSubmit = By.cssSelector(".update-password-password__login-button");
	private By lnkBackToLogin = By.xpath("//div[text()='Back to Login']");
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

	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
		ConfirmPassword = getText(txtConfirmPassword, "Confirm Password");
		new CommonFunctions().clickOutSideElement();
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

	public void clickOutSide() {
		new CommonFunctions().clickOutSideElement();
	}

}
