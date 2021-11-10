package coyni.customer.components;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class ChangePasswordComponent extends BrowserFunctions {

	private By txtCurrentPassword = By.cssSelector("");
	private By txtNewPassword = By.cssSelector("");
	private By txtConfirmNewPassword = By.cssSelector("");
	private By heading = By.cssSelector("");
	private By btnSave = By.cssSelector(""); // added
	private By labelPasswordSuccess = By.cssSelector("");
	private By msgPasswordStrength = By.cssSelector("");
    private By msgValidation = By.cssSelector("");
    private By iconValidation = By.cssSelector("");

    private void printNewPasswordStrengthMessage() {
        StringBuilder message = new StringBuilder(getText(msgPasswordStrength, "password strength"));
//        String passCode = "<div class='status-avatar pass-bg'><i class='fa fa-check text-white'></i></div>";
//        String failCode = "<div class='status-avatar fail-bg'><i class='fa fa-times text-white'></i></div>";
        List<WebElement> validation_messages = getElementsList(msgValidation, "validation messages");
        List<WebElement> validation_icons = getElementsList(iconValidation, "validation icons");
        for (int i = 0; i < validation_icons.size(); i++) {
            String iconClass = validation_icons.get(i).getAttribute("class");
            String icon = iconClass.contains("success") ? "<span style='color: green'>Valid Icon</span>" : "<span style='color: red'>Error Icon</span>";
            String msg = validation_messages.get(i).getText();
            message.append(icon.concat(msg));
        }
        ExtentTestManager.setPassMessageInReport(message.toString());
    }
    
	public void fillCurrentPassword(String currentPassword) {
		enterText(txtCurrentPassword, currentPassword, "Current Password");
	}

	public void fillNewPassword(String newPassword) {
		click(txtNewPassword, "new password");
        printNewPasswordStrengthMessage();
		enterText(txtNewPassword, newPassword, "New Password");
		printNewPasswordStrengthMessage();
	}

	public void fillConfirmNewPassword(String confirmNewPassword) {
		enterText(txtConfirmNewPassword, confirmNewPassword, "Confirm New Password");
	}
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Autentication Heading", expHeading);
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void verifyUpdatePassword(String text) {
		new CommonFunctions().verifyLabelText(labelPasswordSuccess, text, "password success message");

	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();

	}
	


}
