package coyni.customer.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ChangePasswordComponent extends BrowserFunctions {

	private By txtCurrentPassword = By.id("CurrentPassword");//
	private By txtNewPassword = By.id("NewPassword");
	private By txtConfirmNewPassword = By.id("ConfirmNewPassword");
	private By headingChangePassword = By.xpath("(//span[text()='Change Password'])[2]");
	private By btnSave = By.cssSelector(".w-44"); // added
	private By labelPasswordSuccess = By.cssSelector("");
//	private By msgPasswordStrength = By.cssSelector("");
//    private By msgValidation = By.cssSelector("");
	private By iconValidation = By.className("check_password");
	private By iconView = By.cssSelector(".icon-button");

	// Authy
	private By headingAuthy = By.xpath("//h1[text()='Verify your Identity']");

	public void verifyAuthyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingAuthy, "Authy Heading", expHeading);
	}

	public void viewTickMark() {
		new CommonFunctions().elementView(iconValidation, "Green Colour Tick Mark");
	}

	private By reddot = By.cssSelector(".red-dot");
	private By greendot = By.cssSelector(".green-dot");

	public void fillNewPassword(String newPassword) {
		int initialRedDot = getElementsList(reddot, "red dot").size();
		int initialGreenDot = getElementsList(greendot, "green dot").size();
		enterText(txtNewPassword, newPassword, "New Password");
		int finalRedDot = getElementsList(reddot, "red dot").size();
		int finalGreenDot = getElementsList(greendot, "green dot").size();
		if (initialGreenDot == 0 && initialRedDot == 6 && finalRedDot == 0 && finalGreenDot == 6) {
			ExtentTestManager.setPassMessageInReport("password is valid");
		}
	}

	public void clickNewPassword() {
		click(txtNewPassword, "Click");
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void clickIcon() {
		click(iconView, "Click Icon");
	}

//    private void printNewPasswordStrengthMessage() {
//        StringBuilder message = new StringBuilder(getText(msgPasswordStrength, "password strength"));
////        String passCode = "<div class='status-avatar pass-bg'><i class='fa fa-check text-white'></i></div>";
////        String failCode = "<div class='status-avatar fail-bg'><i class='fa fa-times text-white'></i></div>";
//        List<WebElement> validation_messages = getElementsList(msgValidation, "validation messages");
//        List<WebElement> validation_icons = getElementsList(iconValidation, "validation icons");
//        for (int i = 0; i < validation_icons.size(); i++) {
//            String iconClass = validation_icons.get(i).getAttribute("class");
//            String icon = iconClass.contains("success") ? "<span style='color: green'>Valid Icon</span>" : "<span style='color: red'>Error Icon</span>";
//            String msg = validation_messages.get(i).getText();
//            message.append(icon.concat(msg));
//        }
//        ExtentTestManager.setPassMessageInReport(message.toString());
//    }

	public void fillCurrentPassword(String currentPassword) {
		enterText(txtCurrentPassword, currentPassword, "Current Password");
	}

//	public void fillNewPassword(String newPassword) {
//		click(txtNewPassword, "new password");
//        printNewPasswordStrengthMessage();
//		enterText(txtNewPassword, newPassword, "New Password");
//		printNewPasswordStrengthMessage();
//	}

	public void fillConfirmNewPassword(String confirmNewPassword) {
		enterText(txtConfirmNewPassword, confirmNewPassword, "Confirm New Password");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingChangePassword, "Change Password Heading", expHeading);
	}

	public void clickSave() {
		if (getElement(btnSave, "save").isEnabled()) {
			click(btnSave, "Save");
		} else {
			ExtentTestManager.setPassMessageInReport("Save button is enabled");
		}
	}

	public void verifyUpdatePassword(String text) {
		new CommonFunctions().verifyLabelText(labelPasswordSuccess, text, "password success message");

	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();

	}

}
