package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.ErrorMessagePopupComponent;
import coyni_mobile_merchant.components.FieldValidationsComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ConfirmPasswordPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Confirm Password')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'successfully change your password.')]");
	private By txtCurrentPassword = MobileBy.xpath("//*[contains(@resource-id,'currentPassET')]");
	private By btnEyeIcon = MobileBy.xpath("//*[contains(@resource-id,'text_input_end_icon')]");
	private By btnNext = MobileBy.xpath("//*[contains(@text,'Next')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'cpConfirmBackIV')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Confirm Password Heading ", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Confirm Password Description", expDescription);
	}

	public void fillCurrentPassword(String currentPassword) {
		new CommonFunctions().verifyAutoFocusElement(txtCurrentPassword, "Current Password");
		click(txtCurrentPassword, "Current Password");
		enterText(txtCurrentPassword, currentPassword, "Current Password");
	}

	public void clickEyeIcon() {
		click(btnEyeIcon, "Eye Icon");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickCloseIcon() {
		click(btnClose, "Close Icon");
	}

	public ChangePasswordPage changePasswordPage() {
		return new ChangePasswordPage();
	} 
	public ErrorMessagePopupComponent errorMessagePopupComponent() {
		return new ErrorMessagePopupComponent();
		
	}
	
	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
	
	}

