package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddTerminalPopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[contains(text(),'Add Terminal')]");
	private By drpDownAssigneeTerminalLocation = By.xpath("");
	private By txtTerminalName = By.xpath("");
	private By chkboxTips = By.xpath("");
	private By btnNext = By.xpath("");
	private By lblTerminalInfo = By.xpath("");
	private By lblTipsInfo = By.xpath("");
	private By btnEdit = By.xpath("");
	private By btnCancel = By.xpath("");
	private By btnAddTerminal = By.xpath("");
	private By drpDownAssigneeTerminalSummary = By.xpath("");
	private By btnSave = By.xpath("");
	private By checkboxTipFormatPercent = By.xpath("");
	private By checkboxFlatCYN = By.xpath("");

	public void verifyTerminalInfoSummary() {
		String text = getText(lblTerminalInfo, "Terminal Info");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickOnAddTerminal() {
		click(btnAddTerminal, "Add Terminal");
	}

	public void clickOnCheckBoxTipFormatPercent() {
		click(checkboxTipFormatPercent, "CheckBox Tip Format");
	}
	
	public void clickOnCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickOnCheckBoxFlatCYN() {
		click(checkboxFlatCYN, "CheckBox CYN");
	}

	public void clickDropDownAssigneeTerminalLocationSummary() {
		click(drpDownAssigneeTerminalSummary, "Assignee Terminal Location");
	}

	public void fillTerminalNameSummary() {
		click(txtTerminalName, "Terminal Name");
	}

	public void clickOnSave() {
		click(btnSave, "Save");
	}

	public void clickOnEdit() {
		click(btnEdit, "Edit");
	}

	public void verifyTipsInfoSummary() {
		String text = getText(lblTipsInfo, "Tips Info");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickDropDownAssigneeTerminalLocation() {
		click(drpDownAssigneeTerminalLocation, "Assignee Terminal Location");
	}

	public void fillTerminalName() {
		click(txtTerminalName, "Terminal Name");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickOnCheckBox() {
		click(chkboxTips, "Check Box");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

}
