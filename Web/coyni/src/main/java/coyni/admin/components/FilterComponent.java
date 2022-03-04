package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class FilterComponent extends BrowserFunctions {

	private By lblFilters = By.xpath("//button[text()='Filter']");
	private By lblDate = By.xpath("//label[text()='Date']");
	private By lnkClear = By.xpath("//label[text()='Date']//button[text()='Clear']");
	private By lblTransactionType = By.xpath("//span[text()='Transaction Type']");
	private By lnkClearAll = By.xpath("//span[text()='Transaction Type']//button[text()='Clear All']");
	private By lblTransactionAmount = By.xpath("//label[text()='Transaction Amount']");
	private By txtFromAmount = By.xpath("//span[text()='From (CYN)']");
	private By txtToAmount = By.xpath("//span[text()='To (CYN)']");
	private By lblReferenceId = By.xpath("//button[text()='Clear']/ancestor::label[text()='Reference ID']");
	private By txtReferenceId = By.xpath("//input[@id='Reference ID']");
	private By lblTransactionStatus = By.xpath("//span[text()='Transaction Status']");
	// private By lnkClaerAll = By.xpath("");
	private By lblEmployeeName = By.xpath("//label[text()='Employee Name']");
	private By drpdwn = By.xpath("div[class*='selected_option']");
	private By lnkResetAllFilters = By.xpath("");
	private By btnApplyFilters = By.xpath("");
	private By lblDepositId = By.xpath("//button[text()='Clear']/ancestor::label[text()='Deposit ID']");
	private By textDepositId = By.xpath("//input[@id='Deposit ID']");
	private By lblUserId = By.xpath("//button[text()='Clear']/ancestor::label[text()='User ID']");
	private By textUserId = By.xpath("//input[@id='User ID']");
	private By lblUserType = By.xpath("//button[text()='Clear All']/ancestor::span[text()='User Type']");
	private By lblBusiness = By
			.xpath("//span[text()='Business']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblPersonal = By
			.xpath("//span[text()='Personal']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblCoyniAdmin = By
			.xpath("//span[text()='Coyni Admin']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblDepositAmount = By.xpath("//label[text()='Deposit Amount']");
	private By lblNameOnAccount = By.xpath("//label[text()='Name on Account']");
	private By txtName = By.xpath("//input[@id='Name']");
	private By lblBankAccountNum = By.xpath("//label[text()='Bank Account Number']");
	private By txtAccountNum = By.xpath("//input[@id='Account Number']");
	private By lblPaid = By.xpath("//span[text()='Paid']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblFailed = By
			.xpath("//span[text()='Failed']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblInProgress = By
			.xpath("//span[text()='In Progress']/ancestor::div[@class='flex items-center mr-3 selectOption']");

	public void verifyDate(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDate, "Heading is", expHeading);
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(lblFilters, "Filters", expCssProp, expValue, expColor);
	}

	public void clickFilters() {
		click(lblFilters, "Filters");
	}

	public By getElement(String elementName) {
		return By.xpath(String.format("//button[text()='Clear']/ancestor::label[text()='%s']", elementName));
	}

	public void verifyFiltersLabelView(String elements) {
		String[] list = elements.split(",");
		for (int i = 0; i < list.length; i++) {
			new CommonFunctions().elementView(getElement(list[i]), list[i]);
		}
	}

	public void viewFilters() {
		new CommonFunctions().elementView(lblDate, "Date");
		new CommonFunctions().elementView(lblTransactionType, "Transaction Type");
		new CommonFunctions().elementView(lblTransactionAmount, "Transaction Amount");
		new CommonFunctions().elementView(lblReferenceId, "Reference ID");
		new CommonFunctions().elementView(lblTransactionStatus, "Transaction Status");
		new CommonFunctions().elementView(lblEmployeeName, "Date");
	}

	public void clickClear() {
		click(lnkClear, "Clear");
	}

	public void verifyTransactionType(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionType, "Transaction Type Heading is", expHeading);
	}

	public void clickClearAll() {
		click(lnkClearAll, "Claer All");
	}

	public void verifyTrasactionAmount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionAmount, "Transaction Amount Heading is", expHeading);
	}

	public void fillFromAmount(String fromAmount) {
		enterText(txtFromAmount, fromAmount, "From Amount");
	}

	public void fillToAmount(String toAmount) {
		enterText(txtToAmount, toAmount, "To Amount");
	}

	public void verifyReferenceId(String expGeading) {
		new CommonFunctions().verifyLabelText(lblReferenceId, "Reference ID Heading is", expGeading);
	}

	public void fillReferenceID(String referenceID) {
		enterText(txtReferenceId, referenceID, "Reference ID");
	}

	public void verifyTransactionStatus(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionStatus, "Transaction Status Heading is", expHeading);
	}

	public void verifyEmployeeName(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmployeeName, "Employee Name Heading is", expHeading);
	}

	public void selectDropDown(String employees) {
		selectDropdown(drpdwn, employees, "Employees");
	}

	public void clickResetAllFilters() {
		click(lnkResetAllFilters, "Reset All Filters");
	}

	public void clickApplyFilters() {
		click(btnApplyFilters, "Apply Filters");
	}

	public void selectFilter(String type) {
		click(getCheckBox(type), type);
	}

	private By getCheckBox(String elementName) {
		return By.xpath(String.format(
				"//span[(contains(@class,'text-sm' ) or contains(@class,'relative')) and text()='%s']", elementName));
	}

	public void clickWithdraw() {
		click(getCheckBox("Withdraw"), "Withdraw");
	}

	public void clickCommissionPayOut() {
		click(getCheckBox("Commission Payout"), "Commission Payout");
	}

	public void clickInProgress() {
		click(getCheckBox("In Progress"), "In Progress");
	}

	public void clickCompleted() {
		click(getCheckBox("Completed"), "Completed");
	}

	public void clickFailed() {
		click(getCheckBox("Failed"), "Failed");
	}

	public void clickWon() {
		click(getCheckBox("Won"), "Won");
	}

	public void clickLost() {
		click(getCheckBox("Lost"), "Lost");
	}

}
