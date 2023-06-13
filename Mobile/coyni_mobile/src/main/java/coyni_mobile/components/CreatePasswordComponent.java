package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy;

public class CreatePasswordComponent extends MobileFunctions {
	private By lblCreateNewPassword = MobileBy.AccessibilityId("Create Password");
	private By txtNewPassword = MobileBy.AccessibilityId("New Password");
	private By iconEye = MobileBy.AccessibilityId("");
	private By txtConfirmPassword = MobileBy.AccessibilityId("Confirm Password");
	private By lblMustHaveErrMsg = MobileBy.AccessibilityId("");
	private By btnSave = MobileBy.AccessibilityId("Save");
	/**
	 * Change Password
	 */
	private By lblCurrentPassword = MobileBy.AccessibilityId("");
	private By lblCurrentpwdDesc = MobileBy.AccessibilityId("");
	private By txtCurrentPassword = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By lblNewPassword = MobileBy.AccessibilityId("");
	private By lblNewPasswordDesc = MobileBy.AccessibilityId("");
	
	
	
	
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
		if(getElement(txtCurrentPassword, "currentPassword").isEnabled()) {
			click(btnNext, "Next");
		}else {
			ExtentTestManager.setInfoMessageInReport("Next button is disabled");
		}
	}
	public void verifyNewPasswordHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblNewPassword, "New Password", hdg);
	}
	
	public void verifyNewPasswordDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblNewPasswordDesc, "Desc", desc);
	}
	
	public void verifyCreateNewPasswordView() {
		new CommonFunctions().elementView(lblCreateNewPassword, "Create New Password");
	}
	
	public void fillNewPassword(String password) {
		enterText(txtNewPassword, password, "New Password");
	}

	public void fillConfirmPassword(String password) {
		enterText(txtNewPassword, password, "Confirm Password");
	}
	
	public void clickEye() {
		click(iconEye, "Eye");
	}
	public void verifyMustErrorMessage(String errMsg) {
		new CommonFunctions().verifyLabelText(lblMustHaveErrMsg, "error Message", errMsg);
	}
	
	public void clickSave() {
		if(getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
		}else {
			ExtentTestManager.setInfoMessageInReport("Save Button is disabled");
		}   
	}
	/**
	 * Order - minChar, max, MaxiPlus
	 * 
	 * @throws InterruptedException
	 */
	public void validateConfirmPasswordfield(String password) {
		String[] field = password.split(",");
		for (int i = 0; i < 2; i++) {
			new CommonFunctions().validateTextFeild(txtConfirmPassword, "password", field[i]);
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
			new CommonFunctions().validateTextFeild(txtNewPassword, "password", field[i]);
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
			new CommonFunctions().validateTextFeild(txtConfirmPassword, "password", field[i]);
//		new CommonFunctions().validateField(txtNewPassword, "password", field[1]);
		}
		new CommonFunctions().validateFieldMaxichar(txtConfirmPassword, "password", field[2]);
	}
}
