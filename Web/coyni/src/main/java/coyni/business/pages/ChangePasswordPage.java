package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ChangePasswordPage extends BrowserFunctions {

	private By lblChangePassword = By.xpath("");
	private By lblDescription = By.xpath("");
	private By txtCurrentPassword = By.xpath("");
	private By txtNewPassowrd = By.xpath("");
	private By txtConfirmNewPassowrd = By.xpath("");
	private By btnSave = By.xpath("");
	private By iconView = By.cssSelector("");

	public void verify(String expHeading) {
		new CommonFunctions().verifyLabelText(lblChangePassword, "Heading is: ", expHeading);
	}

	public void verifyEndAllSessionsDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description is: ", expDes);
	}

	public void fillCurrentPassowrd(String currentPassowrd) {
		new CommonFunctions().verifyCursorAction(txtCurrentPassword, "Current Passowrd");
		enterText(txtCurrentPassword, currentPassowrd, "Current Password");
	}

	public void fillNewPassword(String newPassword) {
		new CommonFunctions().verifyCursorAction(txtNewPassowrd, "New Password");
		enterText(txtNewPassowrd, newPassword, "New Password");
	}

	public void fillConfirmNewPassword(String confirmNewPassowrd) {
		new CommonFunctions().verifyCursorAction(txtConfirmNewPassowrd, "ConfirmNewPassowrd");
		enterText(txtConfirmNewPassowrd, confirmNewPassowrd, "Confirm New Password");
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
			ExtentTestManager.setPassMessageInReport("Save Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Save Button is Disabled");
		}
	}

	public void clickIcon() {
		click(iconView, "Click Icon");
	}

}
