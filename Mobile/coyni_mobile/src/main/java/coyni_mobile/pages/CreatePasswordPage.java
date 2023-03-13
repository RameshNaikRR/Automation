package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CreatePasswordPage extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]|//*[@name='Create New Password']");
	private By txtNewPassword = MobileBy.xpath("//*[contains(@resource-id,'etPassword')]|//*[@name='New Password']");
	private By txtConfirmPassword = MobileBy
			.xpath("//*[contains(@resource-id,'etCPassword')]|//*[@name='Confirm Password']");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'cvSave')]|(//*[@name='Save'])[1]");
	private By lblSuccessMsg = MobileBy.xpath(
			"//*[contains(@text,'Your password has been successfully updated.')]|//*[@name='Your password has been successfully updated.']");
	private By btnLogin = MobileBy.xpath("//*[contains(@text,'Log in')]|(//*[@name='Log in'])[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Create Password Heading", expHeading);
	}

	public void fillNewPassword(String newPassword) {
		click(txtNewPassword, "New Password");
		enterText(txtNewPassword, newPassword, "New Password");
	}

	public void fillConfirmPassword(String confirmPassword) {
		click(txtConfirmPassword, "Confirm Password");
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
		if (!new CommonFunctions().isPlatformiOS()) {
			pressBack();
		}
	}

	public void scrollDown() {
		scrollDownToElement(btnSave, "Save");
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			scrollDownToElement(btnSave, "Save");
			click(btnSave, "Save");
		} else {
			ExtentTestManager.setPassMessageInReport("Save Button is disable");
		}
	}

	public void verifyMessage(String msg) {
		new CommonFunctions().verifyLabelText(lblSuccessMsg, "Message", msg);
	}

	public void clickLogin() {
		click(btnLogin, "Login");
	}

	public void verifyPassword() {
		new CommonFunctions().checkPassword(txtNewPassword, txtConfirmPassword);
	}

//	public void checkPassword() {
//		String newPassword = getText(txtNewPassword);
//		String confirmPassword = getText(txtConfirmPassword);
//		if(newPassword.equals(confirmPassword)) {
//			ExtentTestManager.setPassMessageInReport("Password is Same");
//		}
//		else {
//			ExtentTestManager.setFailMessageInReport("Password is not Same");
//		}
//	}
}
