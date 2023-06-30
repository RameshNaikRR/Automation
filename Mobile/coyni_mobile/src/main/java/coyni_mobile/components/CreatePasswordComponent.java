package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CreatePasswordComponent extends MobileFunctions {
//	Forgot Password
	private By lblCreateNewPassword = MobileBy.AccessibilityId("Create Password");
	private By txtNewPassword = MobileBy.AccessibilityId("New Password");
	private By newPassIconEye = MobileBy.xpath("//*[contains(@resource-id,'etPassword')]/following-sibling::*");
	private By confirmIconEye = MobileBy.xpath("//*[contains(@resource-id,'etCPassword')]/following-sibling::*");
	private By txtConfirmPassword = MobileBy.AccessibilityId("Confirm Password");
	private By lblMustHaveErrMsg = MobileBy.AccessibilityId("8 to 32");
	private By btnSave = MobileBy.AccessibilityId("Save");
	private By imgPassStrength = MobileBy.xpath("//*[contains(@resource-id,'strength')]");

	/**
	 * Change Password
	 */
	private By lblCurrentPassword = MobileBy.xpath("");
	private By lblCurrentpwdDesc = MobileBy.xpath("");
	private By lblCurrentIconEye = MobileBy.xpath("//*[contains(@resource-id,'etPassword')]/following-sibling::*");
	private By txtCurrentPassword = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By lblNewPassword = MobileBy.xpath("");
	private By lblNewPasswordDesc = MobileBy.xpath("");

	public void verifyCurrentPassword(String password) {
		new CommonFunctions().verifyLabelText(lblCurrentPassword, "current password", password);
	}

	public void verifyCurrentPasswordDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblCurrentpwdDesc, "current password", desc);
	}

	public void fillCurrentPassword(String pwd) {
		enterText(txtCurrentPassword, pwd, "current Password");
	}

	public void clickNext() {
		if (getElement(txtCurrentPassword, "currentPassword").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setInfoMessageInReport("Next button is disabled");
		}
	}

	public void verifyNewPasswordHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblNewPassword, "New Password", hdg);
	}

	public void verifyNewPasswordDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblNewPasswordDesc, "Desc", desc);
	}

	public void verifyCreateNewPasswordHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblCreateNewPassword, "Heading", heading);
	}

	public void fillNewPassword(String password) {
		click(txtNewPassword, "New Password");
		enterText(txtNewPassword, password, "New Password");
	}

	public void fillConfirmPassword(String password) {
		click(txtConfirmPassword, "Confirm Password");
		enterText(txtConfirmPassword, password, "Confirm Password");
	}

	public void clickNewPassIconEye() {
		click(newPassIconEye, "New Password Eye Icon");
	}

	public void clickCurrentPassIconEye() {
		click(lblCurrentIconEye, "Current Password Eye Icon");
	}

	public void clickConfirmPassIconEye() {
		click(confirmIconEye, "Confirm Password Eye Icon");
	}

	public void clickNewPassword() {
		click(txtNewPassword, "New Password");
	}

	public void clickConfirmPassword() {
		click(txtConfirmPassword, "Confirm Password");
	}

	public void viewPasswordStrength() {
		new CommonFunctions().elementView(imgPassStrength, "Password Strength Bars");
		if (getElementList(imgPassStrength, "Password Strength Bars").size() == 3) {
			ExtentTestManager.setPassMessageInReport("3 Password Strength Bars are appeared");
		} else {
			ExtentTestManager.setFailMessageInReport(
					"3 Password Strength Bars are not appeared, after giving valid password also");
		}
	}

	public void verifyMustErrorMessage(String errMsg) {
		new CommonFunctions().verifyLabelText(lblMustHaveErrMsg, "error Message", errMsg);
	}

	public void clickSave() {
			click(btnSave, "Save");
	}

	public void verifyDisableStateSave() {
		new CommonFunctions().verifyDisabledElement(btnSave, "Save");
	}

	/**
	 * Order - minChar, max, MaxiPlus
	 * 
	 * @throws InterruptedException
	 */
	public void validateConfirmPasswordfield(String password) {
		String[] field = password.split(",");
		for (int i = 0; i < 2; i++) {
//			new CommonFunctions().validateTextFeild(txtConfirmPassword, "password", field[i]);
//		new CommonFunctions().validateField(txtNewPassword, "password", field[1]);
		}
		new CommonFunctions().validateFieldMaxichar(txtConfirmPassword, "password", field[2]);
	}

	/**
	 * Order - minChar, max, MaxiPlus
	 * 
	 * @throws InterruptedException
	 */
	public void validateNewPasswordfield(String password) {
		String[] field = password.split(",");
		for (int i = 0; i < 2; i++) {
//			new CommonFunctions().validateTextFeild(txtNewPassword, "password", field[i]);
//		new CommonFunctions().validateField(txtNewPassword, "password", field[1]);
		}
		new CommonFunctions().validateFieldMaxichar(txtNewPassword, "password", field[2]);
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	/**
	 * Order - minChar, max, MaxiPlus
	 * 
	 * @throws InterruptedException
	 */
	public void validateCurrentPasswordfield(String password) {
		String[] field = password.split(",");
		for (int i = 0; i < 2; i++) {
//			new CommonFunctions().validateTextFeild(txtConfirmPassword, "password", field[i]);
//		new CommonFunctions().validateField(txtNewPassword, "password", field[1]);
		}
		new CommonFunctions().validateFieldMaxichar(txtConfirmPassword, "password", field[2]);
	}
}
