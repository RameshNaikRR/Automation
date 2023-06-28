package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TerminalPopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[contains(text(),'Terminal')]");
	private By terminalInfo = By.xpath("");
	private By btnEditTerminal = By.xpath("");
	private By btnLogin = By.xpath("");
	private By toggle = By.xpath("");
	private By btnRemoveTerminal = By.xpath("");
	private By btnLocation = By.xpath("");
	private By btnLocationEdit = By.xpath("");
	private By btnNext = By.xpath("");
	private By btnCancel = By.xpath("");
	private By btnSave = By.xpath("");
	private By btnCheckboxOnTips = By.xpath("");
	private By drpDownAssigneeTerminalLocation = By.xpath("");
	private By btnTips = By.xpath("");
	private By btnTipsEdit = By.xpath("");
	private By btnActivityLogs = By.xpath("");
	private By eyeIcon = By.xpath("");
	private By btnChange = By.xpath("");
	private By loginTerminalID = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public void clickOnLocation() {
		click(btnLocation, "Location");
	}

	public void verifyTerminalID() {
		String text = getText(loginTerminalID, "Terminal ID");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickOnLogin() {
		click(btnLocation, "Login");
	}

	public void clickOnChange() {
		click(btnChange, "Change");
	}

	public void clickOnToggle() {
		click(toggle, "Toggle");
	}

	public void clickOnEyeIcon() {
		click(eyeIcon, "Eye Icon");
	}

	public void clickActivityLogs() {
		click(btnActivityLogs, "Activity Logs");
	}

	public void clickonTips() {
		click(btnTips, "Tips");
	}

	public void clickonTipsEdit() {
		click(btnTipsEdit, "Tips Edit");
	}

	public void clickDropDownAssigneeTerminalLocation() {
		click(drpDownAssigneeTerminalLocation, "Assignee Terminal Location");
	}

	public void clickOnLocationEdit() {
		click(btnLocationEdit, "Location Edit");
	}

	public void clickOnRemoveTerminal() {
		click(btnRemoveTerminal, "Remove Terminal");
	}

	public void clickOnCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickOnSave() {
		click(btnSave, "Save");
	}

	public void clickOnEditTerminal() {
		click(btnEditTerminal, "Edit Terminal");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public RemoveTerminalPopup removeTerminalPopup() {
		return new RemoveTerminalPopup();
	}

	public CompleteTerminalSetupPopup completeTerminalSetupPopup() {
		return new CompleteTerminalSetupPopup();
	}

}
