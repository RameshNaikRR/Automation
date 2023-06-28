package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CompleteTerminalSetupPopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[contains(text(),'Complete Terminal Setup')]");
	private By terminalID = By.xpath("");
	private By btnNext = By.xpath("");
	private By newPasswordd = By.xpath("");
	private By confirmNewPasswordd = By.xpath("");
	private By btnSetPassword = By.xpath("");

	public void verifyTerminalID() {
		String text = getText(terminalID, "Terminal ID");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void fillNewPassword(String newPassword) {
		enterText(newPasswordd, newPassword, "New Password");
	}

	public void fillConfirmNewPassword(String password) {
		enterText(confirmNewPasswordd, password, "Confirm New Password");
	}

	public void clickOnSetPassword() {
		click(btnSetPassword, "Set Password");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

}
