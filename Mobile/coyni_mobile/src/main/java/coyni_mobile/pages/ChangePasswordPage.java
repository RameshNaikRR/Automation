package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ChangePasswordPage extends MobileFunctions {

	private By confirmPasswordHeading = MobileBy.xpath("//*[@text='Confirm Password']");
	// private By confirmPasswordMessage = MobileBy.xpath("");
	private By changePasswordHeading = MobileBy.xpath("//*[@text='Change Password']");
	// private By txtPin = MobileBy.xpath("");
	private By txtCurrentPassword = MobileBy.xpath("//*[contains(@resource-id,'currentPassET')]");
	private By iconViewPassword = MobileBy.xpath("//*[contains(@resource-id, 'text_input_end_icon')]");
	private By btnNext = MobileBy.xpath("//*[@text='Next']");
	private By txtNewPassword = MobileBy.xpath("//*[contains(@resource-id,'etPassword')]");
	private By txtConfirmPassword = MobileBy.xpath("//*[contains(@resource-id,'etCPassword')]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id, 'cvSave')]");
	private By lblSuccessFailureMessage = MobileBy.xpath("//*[@text='Change Password Successful']");
	private By btnLogout = MobileBy.xpath("//*[@text='Log Out']");
	private By changePasswordContent = MobileBy.xpath("//*[contains(@resource-id,'tvMessageChangePass')]");

	public void verifyChangePasswordContent(String expHeading) {
		new CommonFunctions().verifyLabelText(changePasswordContent, "Change Password", expHeading);

	}

	public void verifyHeadingConfirmPassword(String expHeading) {
		new CommonFunctions().verifyLabelText(confirmPasswordHeading, expHeading, "Confirm Password ");
	}

	public void verifyHeadingChangePassword(String expHeading) {
		new CommonFunctions().verifyLabelText(changePasswordHeading, "Change Password ", expHeading);
	}

	public void verifyPassword() {
		new CommonFunctions().checkPassword(txtNewPassword, txtConfirmPassword);
	}
//	public void fillPin(String pin) {
//		enterText(txtPin, pin, "Pin");
//	}

	public void fillCurrentPassword(String currentPassword) {
		enterText(txtCurrentPassword, currentPassword, "Current Password");
	}

	public void clickIconViewPassword() {
		click(iconViewPassword, "Icon View Password");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}

	}

	public void fillNewPassword(String newPassword) {
		enterText(txtNewPassword, newPassword, "NewPassword");
	}

// public void clickIconViewNewPassword() {
// click(iconviewNewPassword, "Icon View New Password");
// }

	public void fillConfirmPassword(String confirmPassword) {
		DriverFactory.getDriver().hideKeyboard();
		click(txtConfirmPassword, "Confirm Password");
		enterText(txtConfirmPassword, confirmPassword, "ConfirmPassword");
		DriverFactory.getDriver().hideKeyboard();
	}

//	public void save() {
//		scrollDownToElement(btnSave, "save");
//	}

	public void clickSave() {
		scrollDownToElement(btnSave, "save");
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
		} else {
			ExtentTestManager.setPassMessageInReport("save button is in disabled mode");
		}

	}

//	public void verifyPassword() {
//		new CommonFunctions().checkPassword(txtNewPassword, txtConfirmPassword);
//	}

	public void verifySuccessFailureMessage(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSuccessFailureMessage, "Success", expHeading);
	}

	public void clickLogout() {
		scrollDownToElement(btnLogout, "Scroll down to element");
		click(btnLogout, "Logout");

	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

}
