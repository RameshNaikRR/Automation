package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.web.actions.WaitForElement;

public class ChangePasswordComponent extends BrowserFunctions{

	private By txtCurrentPassword = By.cssSelector("");
	private By txtNewPassword = By.cssSelector("");
	private By txtConfirmNewPassword = By.cssSelector("");

	public void fillCurrentPassword(String currentPassword){
		enterText(txtCurrentPassword, currentPassword, "Current Password");
	}
	public void fillNewPassword(String newPassword) {
		enterText(txtNewPassword, newPassword, "New Password");
	}
	public void fillConfirmNewPassword(String confirmNewPassword) {
		enterText(txtConfirmNewPassword, confirmNewPassword, "Confirm New Password");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();

	}



}
