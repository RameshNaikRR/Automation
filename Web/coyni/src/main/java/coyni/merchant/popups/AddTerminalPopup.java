package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.ToastComponent;
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
	private By selectTerminal = By.xpath("");
	private By TipFormatoption1 = By.xpath("");
	private By TipFormatoption2 = By.xpath("");
	private By TipFormatoption3 = By.xpath("");
	private By terminalSummaryNamee = By.xpath("");

	public void verifyTerminalInfoSummary() {
		String text = getText(lblTerminalInfo, "Terminal Info");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public void fillOption1(String option1) {
		enterText(TipFormatoption1, option1, "Option1");
	}

	public void fillOption2(String option2) {
		enterText(TipFormatoption2, option2, "Option2");
	}

	public void fillOption3(String option3) {
		enterText(TipFormatoption3, option3, "Option3");
	}

	public void clickOnSelectedTerminal() {
		click(selectTerminal, "Select Terminal");
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

	public void fillTerminalNameSummary(String terminalSummaryName) {
		enterText(terminalSummaryNamee, terminalSummaryName, "terminalSummaryName");
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

	public void fillTerminalName(String terminalName) {
		enterText(txtTerminalName, terminalName, "terminalName");

	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickOnCheckBox() {
		click(chkboxTips, "Check Box");
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
