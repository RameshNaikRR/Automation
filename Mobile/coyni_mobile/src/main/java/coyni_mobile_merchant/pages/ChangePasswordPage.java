package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.FieldValidationsComponent;
import coyni_mobile_merchant.components.SuccessFailureComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ChangePasswordPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'/tvHead')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'tvMessageChangePass')]");
	private By txtNewPassword = MobileBy.xpath("//*[contains(@resource-id,'etPassword')]");
	private By txtConfirmPassword = MobileBy.xpath("//*[contains(@resource-id,'etCPassword')]");
	private By btnNewPwdEyeIcon = MobileBy.xpath("(//*[contains(@resource-id,'text_input_end_icon')])[1]");
	private By btnConfirmPwdEyeIcon = MobileBy.xpath("(//*[contains(@resource-id,'text_input_end_icon')])[2]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'cvSave')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'imgClose')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Change Password Heading ", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Change Password Description", expDescription);
	}

	public void fillNewPassword(String newPassword) {
		click(txtNewPassword, "Confirm Password");
		enterText(txtNewPassword, newPassword, "Confirm Password");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillConfirmPassword(String confirmPassword) {
		click(txtConfirmPassword, "Confirm Password");
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void clickNewPwdEyeIcon() {
		click(btnNewPwdEyeIcon, "Eye Icon");
	}

	public void clickConfirmPwdEyeIcon() {
		click(btnConfirmPwdEyeIcon, "Eye Icon");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void clickCloseIcon() {
		click(btnClose, "Close Icon");
	}
	public void clickNewPassword() {
		click(txtNewPassword, "New Password");
		DriverFactory.getDriver().hideKeyboard();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}
	
	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
	
}
