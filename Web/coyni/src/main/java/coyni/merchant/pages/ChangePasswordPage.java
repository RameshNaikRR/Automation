package coyni.merchant.pages;

import java.awt.AWTException;
import org.openqa.selenium.By;
import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.PhoneVerificationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ChangePasswordPage extends BrowserFunctions {

	private By lblHeading = By.xpath("(//span[.='Change Password'])[2]");

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

	private By lblSuccessMsg = By.cssSelector("//h2[text()='Your Password Was Updated Successfully!']");

	public void verifyContaint(String expContent) {
		new CommonFunctions().verifyLabelText(lblSuccessMsg, expContent, "Your Password Was Updated Successfully");
	}

	private By lblContentChangePassword = By.cssSelector(".Paragraph_para_regular__2OHbq");

	public void verifyContent(String expContent) {
		new CommonFunctions().verifyLabelText(lblContentChangePassword, "Change Password Content", expContent);
	}

	// Authy
	private By headingAuthy = By.xpath("//h1[text()='Verify Your Identity']");

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

	public void viewCurrentPassword() {
		new CommonFunctions().elementView(txtCurrentPassword, "Current password");
	}

	public void clickTab() throws AWTException {
		new CommonFunctions().clickOutSideElement();
	}

	public void clickIcon() {
		click(iconView, "Click Icon");
	}

//public void passwordMatch() {
//	new CommonFunctions().pas
//}

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
		new CommonFunctions().verifyLabelText(lblHeading, "Change Password Heading", expHeading);
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

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();

	}

//	public void verifyHeading() {
//		new CommonFunctions().elementView(lblHeading, "Change Password Page ");
//	}
}
