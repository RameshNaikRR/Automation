package coyni.merchant.pages;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CreatePasswordPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span(text()='Create New Password')");
	private By txtNewPassword = By.id("Enter_Password");
	private By txtConfirmPassword = By.id("confirm_Password");
	private By btnSubmit = By.xpath("Submit");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Password Heading", expHeading);
	}

	public void fillNewPassword(String newPassword) {
		enterText(txtNewPassword, newPassword, "New Password");
	}

	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
	}

	public void clickSubmit() {
		if (getElement(btnSubmit, "Submit ").isEnabled()) {
			click(btnSubmit, "Submit");
		} else {
			ExtentTestManager.setPassMessageInReport("Submit button is disable ");
		}
	}

}
