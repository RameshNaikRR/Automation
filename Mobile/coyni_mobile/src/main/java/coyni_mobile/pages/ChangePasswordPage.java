package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ChangePasswordPage extends MobileFunctions{
	
	private By lblHeading = MobileBy.xpath("");
	private By txtPin = MobileBy.xpath("");
	private By txtCurrentPassword = MobileBy.xpath("");
	private By iconViewPassword = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By txtNewPassword = MobileBy.xpath("");
	private By iconviewNewPassword = MobileBy.xpath("");
	private By txtConfirmPassword = MobileBy.xpath("");
	private By btnSave = MobileBy.xpath("");
	private By lblSuccessFailureMessage = MobileBy.xpath("");
	private By btnLogout = MobileBy.xpath("");
	
	public void verifyHeading(String expHeading) {
		getText(lblHeading);
	}
	public void fillPin(String pin) {
		enterText(txtPin, pin, "Pin");
	}
	public void fillCurrentPassword(String currentPassword) {
		enterText(txtCurrentPassword, currentPassword, "Current Password");
	}
	public void clickIconViewPassword() {
		click(iconViewPassword, "Icon View Password");
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
	public void fillNewPassword(String newPassword) {
		enterText(txtNewPassword, newPassword, "New Password");
	}
	public void clickIconViewNewPassword() {
		click(iconviewNewPassword, "Icon View New Password");
	}
	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "ConfirmPassword");
	}
	public void clickSave() {
		click(btnSave, "Save");
	}
	public void verifySuccessFailureMessage() {
		getText(lblSuccessFailureMessage);
	}
	public void clickLogout() {
		click(btnLogout, "Logout");
		
	}

}
