package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class FilterComponent extends BrowserFunctions {
	private By btnFilter = By.xpath("//button[text()='Filter']");
	private By lblDate = By.xpath("//label[text()='Date']");
	private By txtStartDate = By.xpath("//span[text()='Start Date']");
	private By txtEndDate = By.xpath("//span[text()='End Date']");
	private By lblTransactionType = By.xpath("//span[text()='Transaction Type']");
	private By lblTransactionSubType = By.xpath("//span[text()='Transaction Subtype']");
	private By lblTransactionAmt = By.xpath("//label[text()='Transaction Amount']");
//	private By txtFromCYN = By.xpath("//div[@class='custom-range-filter__group__from']");
//	private By txtToCYN = By.xpath("//div[@class='custom-range-filter__group__to']");
	private By txtFromCYN = By.xpath("(//input[@type='text'])[1]");
	private By txtToCYN = By.xpath("(//input[@type='text'])[2]");
	private By lblReferenceID = By.xpath("//label[text()='Reference ID']");
	private By txt15CharReferenceId = By.xpath("//input[@name='gbxTransactionId']");
	private By lblTransactionStatus = By.xpath("//span[text()='Transaction Status']");
	private By btnResetAllFilters = By.xpath("//button[text()='Reset all filters']");
	private By btnApplyFilters = By.xpath("//button[text()='Apply Filters']");

	private By transactionTypeCheckbox(String Type) {
		return By.xpath(String.format("//div[@class='flex items-center mr-3'][%s]", Type));
	}

	private By transactionSubTypeCheckbox(String SubTypecheckBox) {
		return By.xpath(String.format("(//div[@class='flex items-center mr-3'])[%s]", SubTypecheckBox));
	}

	public void clickWalletTransferChkbx() {
		click(transactionTypeCheckbox("1"), "wallet Transfer");
	}

	public void clickWithdrawChkbx() {
		click(transactionTypeCheckbox("3"), "Withdraw");
	}

	public void clickBuyTokenChkBx() {
		click(transactionTypeCheckbox("2"), "Buy Token");
	}

	public void clickBankAccountChkbx() {
		click(transactionSubTypeCheckbox("4"), "Bank Account");
	}

	public void clickInstantPayChkbx() {
		click(transactionSubTypeCheckbox("5"), "Instant Pay");
	}

	public void clickSignetChkbx() {
		click(transactionSubTypeCheckbox("6"), "Signet");
	}

	public void verifyStartDate(String expectedDate) {
		String actualDate = getText(txtStartDate, "start Date");
		if (actualDate.equals(expectedDate)) {
			ExtentTestManager.setPassMessageInReport("start Date is verified");
		} else {
			ExtentTestManager.setFailMessageInReport("start Date is not verified");
		}
	}

	public void scrollDownFilter() {
		scrollToElement(btnFilter, "Filter");
	}

	public void verifyEndDate(String expectedDate) {
		String actualDate = getText(txtEndDate, "end Date");
		if (actualDate.equals(expectedDate)) {
			ExtentTestManager.setPassMessageInReport("End date is verified");
		} else {
			ExtentTestManager.setFailMessageInReport("End Date is not verified");
		}
	}

	public By getCheckkBoxes(String text) {
		return By.xpath(String.format("//span[text()='%s']", text));
	}

	public void clickCheckBox(String text) {
		click(getCheckkBoxes(text), text);
	}

	private By getClearItems(String eleName) {
		return By.xpath(String.format("(//button[text()='Clear'])['%s']", eleName));
	}

	private By getClearAllItems(String eleName) {
		return By.xpath(String.format("(//button[text()='Clear All'])['%s']", eleName));
	}

	public void clickFilter() {
		click(btnFilter, "Filter");
	}

	public void verifyFilterBackgroundColor(String backGround, String border) {
		new CommonFunctions().verifyMouseHoverAction(btnApplyFilters, "Apply filters", backGround, border);
	}

	public void verifyFilterCursorAction() {
		new CommonFunctions().verifyCursorAction(btnFilter, "Filter");
	}

	public void verifyLabelDate(String date) {
		new CommonFunctions().verifyLabelText(lblDate, "date", date);
	}

	public void verifyDateView() {
		new CommonFunctions().elementView(lblDate, "Date");
	}

	public void fillStartDate() {
		click(txtStartDate, "Start Date");
	}

	public void verifyResetFiltersView() {
		new CommonFunctions().elementView(btnResetAllFilters, "Reset All Filters");
	}

	public void verifyApplyFiltersView() {
		new CommonFunctions().elementView(btnApplyFilters, "Apply Filters");
	}

	public void verifyTransactionDateClearView() {
		new CommonFunctions().elementView(getClearItems("2"), "Clear");
	}

	public void fillEndDate() {
		click(txtEndDate, "End Date");
	}

	public void clickDateClear() {
		click(getClearItems("1"), "Date clear");
	}

	public void clickTransactionAmntClear() {
		click(getClearItems("2"), "TransactionAmtClear");
	}

	public void clickReferenceIdClear() {
		click(getClearItems("3"), "Reference ID Clear");
	}

	public void verify15CharIdView() {
		new CommonFunctions().elementView(txt15CharReferenceId, "15 Char Reference Id");
	}

	public void verifyWalletTransferChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Wallet Transfer"), "Wallet Transfer");
	}

	public void verifyBuyTokenChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Buy Token"), "Buy Token");
	}

	public void verifyWithdrawChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Withdraw"), "Withdraw");
	}

	public void verifylabelTransactionAmt(String transactionAmount) {
		new CommonFunctions().verifyLabelText(lblTransactionAmt, "Transaction Amount", transactionAmount);
	}

	public void verifyTransactionAmountView() {
		new CommonFunctions().elementView(lblTransactionAmt, "Transaction Amount");
	}

	public void fillFromCYN(String FromCYN) {
		enterText(txtFromCYN, FromCYN, "From CYN");
	}

	public void verifyFromCYNview() {
		new CommonFunctions().elementView(txtFromCYN, "From CYN");
	}

	public void fillToCYN(String toCYN) {
		enterText(txtToCYN, toCYN, "to CYN");
	}

	public void verifyToCYNview() {
		new CommonFunctions().elementView(txtToCYN, "To CYN");
	}

	public void verifylabelReferenceID(String ReferenceId) {
		new CommonFunctions().verifyLabelText(lblReferenceID, "ReferenceID", ReferenceId);
	}

	public void fill15CharReferenceId(String referenceCharID) {
		enterText(txt15CharReferenceId, referenceCharID, "referenceCharID");
	}

	public void veriffyLabelTransactionType(String TrasactionType) {
		new CommonFunctions().verifyLabelText(lblTransactionType, "Transaction Type", TrasactionType);
	}

	public void verifyTransactionTypeView() {
		new CommonFunctions().elementView(lblTransactionType, "Trasaction Type");
	}

	public void verifyLabelTransactionSubType(String TransactionSubType) {
		new CommonFunctions().verifyLabelText(lblTransactionSubType, "TransactionSubType", TransactionSubType);
	}

	public void verifyTransactionSubtypeView() {
		new CommonFunctions().elementView(lblTransactionSubType, "Transaction subtype");
	}

	public void verifyBankAccountChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Bank Account"), "BankAccount");
	}

	public void verifyInstantPayChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Instant Pay"), "Instant Pay");
	}

	public void verifyCogentChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Cogent"), "Cogent");
	}

	public void verifyLabelTransactionStatus(String TransactionStatus) {
		new CommonFunctions().verifyLabelText(lblTransactionStatus, "TransactionStatus", TransactionStatus);
	}

	public void clickResetAllFilters() {
		click(btnResetAllFilters, "Reset all Filters");
	}

	public void clickApplyFilter() {
		if (getElement(btnApplyFilters, "Apply Filters").isEnabled()) {
			click(btnApplyFilters, "Apply Filters ");
		} else {
			ExtentTestManager.setPassMessageInReport("Apply Filters is in disabled mode");
		}
	}

	public void clickPendingChkbx() {
		click(getCheckkBoxes("Pending"), "Pending");
	}

	public void verifyPendingChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Pending"), "Pending");
	}

	public void clickCompletedChkbx() {
		click(getCheckkBoxes("Completed"), "Completed");
	}

	public void verifyCompletedChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Completed"), "Completed");
	}

	public void clickCancelledChkbx() {
		click(getCheckkBoxes("Cancelled"), "Cancelled");
	}

	public void verifyCancelledChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Cancelled"), "Cancelled");
	}

	public void clickInprogressChkbx() {
		click(getCheckkBoxes("In Progress"), "In Progress");
	}

	public void verifyInprogressChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("In Progress"), "In Progress");
	}

	public void clickFailedChkbx() {
		click(getCheckkBoxes("Failed"), "Failed");
	}

	public void verifyFailedChkbxView() {
		new CommonFunctions().elementView(getCheckkBoxes("Failed"), "Failed");
	}

	public void clickTransactionTypeClearAll() {
		click(getClearAllItems("1"), "Transaction type clear All");
	}

	public void clickTrasactionSubtypeClearAll() {
		click(getClearAllItems("2"), "Transaction subtype clear All");
	}

	public void clickTransactionStatusClearAll() {
		click(getClearAllItems("3"), "Transaction Status Clear All");
	}

	public void verifyReferenceIdView() {
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
	}

	public void verifyTransactionStatusView() {
		new CommonFunctions().elementView(lblTransactionStatus, "Transaction status");
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public void clickStartDate() {
		click(txtStartDate, "start Date");
	}

	public CalendarComponponent calendarComponponent() {
		return new CalendarComponponent();
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}
}
