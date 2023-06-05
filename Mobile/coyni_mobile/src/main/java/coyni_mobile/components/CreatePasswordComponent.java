package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy;

public class CreatePasswordComponent extends MobileFunctions {
	private By lblCreateNewPassword = MobileBy.AccessibilityId("");
	private By txtNewPassword = MobileBy.AccessibilityId("");
	private By iconEye = MobileBy.AccessibilityId("");
	private By txtConfirmPassword = MobileBy.AccessibilityId("");
	private By lblMustHaveErrMsg = MobileBy.AccessibilityId("");
	private By btnSave = MobileBy.AccessibilityId("");
	
	
	
	
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
}
