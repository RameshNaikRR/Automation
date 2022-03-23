package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ChangePasswordPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[text()='Change Password'])[2]");
	private By lblDescription = By.xpath("//p[contains(text(),'you will be logged out')]");
	private By txtCurrentPassword = By.id("CurrentPassword");
	private By txtNewPassword = By.id("NewPassword");
	private By txtConfirmNewPassword = By.id("ConfirmNewPassword");
	private By eyeIconCurrent = By.xpath("(//button[@type='button'])[1]");
	private By eyeIconNew = By.xpath("(//button[@type='button'])[2]");
	private By eyeIconConfirm = By.xpath("(//button[@type='button'])[3]");
	private By greendot = By.xpath("//span[@class='green-dot']/parent::span");
	private By greendot1 = By.xpath("(//span[@class='green-dot']/parent::span)[2]");
	private By reddot = By.cssSelector(".red-dot");
	private By btnSave = By.xpath("//button[text()='Save']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Change Password Page Heading", expHeading);
	}

	public void VerifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, " Change Password Page Description", expDescription);
	}

	public void fillCurrentPassword(String currentPassword) {
		new CommonFunctions().elementView(txtCurrentPassword, "Current Password");
		enterText(txtCurrentPassword, currentPassword, "Current Password");

	}

	public void fillNewPassword(String newPassword) {
		new CommonFunctions().elementView(txtNewPassword, "New Password");
		enterText(txtNewPassword, newPassword, "New Password");

	}

	public void verifyNewPassword(String newPassword) throws InterruptedException {
		String[] inputs = { "H", "h", "qazwsxeh", "qazwsxedcrfv", "@", "1" };
		String[] messages = { "uppercase", "lowercase", "total characters", "total characters", "special character",
				"number" };
		for (int i = 0; i < inputs.length; i++) {
			enterText(txtNewPassword, inputs[i], "New Password");
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
//			new CommonFunctions().clearText(txtNewPassword, "New Password");

			clearText(txtNewPassword, "New Password");
		}
		int initialRedDot = getElementsList(reddot, "red dot").size();
		Thread.sleep(100);
		int initialGreenDot = getElementsList(greendot, "green dot").size();
		Thread.sleep(100);
		enterText(txtNewPassword, newPassword, "New Password");
		int finalRedDot = getElementsList(reddot, "red dot").size();
		int finalGreenDot = getElementsList(greendot, "green dot").size();
		System.out.println("value: " + initialRedDot + " " + initialGreenDot + " " + finalRedDot + " " + finalGreenDot);
		if (initialGreenDot == finalRedDot && initialRedDot == finalGreenDot && finalRedDot == initialGreenDot
				&& finalGreenDot == initialRedDot) {
			newPassword = getText(txtNewPassword, "New Password");
			ExtentTestManager.setPassMessageInReport("password is valid");
		} else {
			ExtentTestManager.setFailMessageInReport("password is invalid");
		}
	}

	public void fillConfirmPassword(String confirmNewPassword) {
		new CommonFunctions().elementView(txtConfirmNewPassword, "Confirm New Password");
		enterText(txtConfirmNewPassword, confirmNewPassword, "Confirm New Password");

	}

	public void clickEyeIconCurrentPassword() {
		new CommonFunctions().elementView(eyeIconCurrent, "Current Password");
		click(eyeIconCurrent, "Eye Icon Current Password");

	}

	public void clickEyeIconNewPassowrd() {
		new CommonFunctions().elementView(eyeIconNew, "New Password");
		click(eyeIconNew, "Eye Icon New Password");

	}

	public void clickEyeIconConfirmPassword() {
		new CommonFunctions().elementView(eyeIconConfirm, "Confirm New Password");
		click(eyeIconConfirm, "Eye Icon Confirm Password");

	}

	public void verifyCurrentPasswordMaskedView() {
		new CommonFunctions().verifyPasswordMaskedView(txtCurrentPassword, "Current Password");
	}

	public void verifyNewPasswordMaskedView() {
		new CommonFunctions().verifyPasswordMaskedView(txtNewPassword, "New Password");
	}

	public void verifyConfirmPasswordMaskedView() {
		new CommonFunctions().verifyPasswordMaskedView(txtConfirmNewPassword, "Confirm New Password");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}
	public void clickOutSide() {
		new CommonFunctions().clickOutSideElement();
		
	}

}
