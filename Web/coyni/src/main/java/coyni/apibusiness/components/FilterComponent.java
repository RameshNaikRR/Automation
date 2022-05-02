package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class FilterComponent extends BrowserFunctions {
	private By btnFilter = By.xpath("//button[text()='Filter']");
	private By lblDate = By.xpath("//label[text()='Date']");
	private By txtStartDate = By.xpath("//span[text()='Start Date']");
	private By txtEndDate = By.xpath("//span[text()='End Date']");
	private By lblTransactionType = By.xpath("//span[text()='Transaction Type']");
	private By lblTransactionSubType = By.xpath("//span[text()='Transaction Subtype']");
	private By lblTransactionAmt = By.xpath("//label[text()='Transaction Amount']");
	private By txtFromCYN = By.xpath("//span[text()='From (CYN)']");
	private By txtToCYN = By.xpath("//span[text()='To (CYN)']");
	private By lblReferenceID = By.xpath("//label[text()='Reference ID']");
	private By txt15CharReferenceId = By.xpath("//input[@id='txt']");
	private By lblTransactionStatus = By.xpath("//span[text()='Transaction Status']");
	private By btnResetAllFilters = By.xpath("//button[text()='Reset all filters']");
	private By btnApplyFilters = By.xpath("//button[text()='Apply Filters']");
    private By getTransactionTypeChkbx(String eleName) {
    	return By.xpath(String.format("(//div[@class='relative flex flex-wrap gap-2'])[1]//label//input[@name='%s']", eleName));
    }
    private By getTransactionSubTypeChkbx(String eleName) {
    	return By.xpath(String.format("(//div[@class='relative flex flex-wrap gap-2'])[2]//div//label//input[@name='%s']", eleName));
    }
    private By getTransactionStatusChkbx(String eleName) {
    	return By.xpath(String.format("(//div[@class='relative flex flex-wrap gap-2'])[3]//div//label//input[@name='%s']", eleName));
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
    public void verifyFilterBackgroundColor(String backGround,String border) {
    	new CommonFunctions().verifyMouseHoverAction(btnApplyFilters, "Apply filters", backGround, border);
    }
    public void verifyFilterCursorAction() {
    	new CommonFunctions().verifyCursorAction(btnApplyFilters, "Apply Filters");
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
    public void clickWalletTransferChkbx() {
    	click(getTransactionTypeChkbx("20"), "wallet Transfer");
    }
    public void verifyWalletTransferChkbxView() {
    	new CommonFunctions().elementView(getTransactionTypeChkbx("20"), "Wallet Transfer");
    }
    public void clickBuyTokenChkBx() {
    	click(getTransactionTypeChkbx("2"), "Buy Token");
    }
    public void verifyBuyTokenChkbxView() {
    	new CommonFunctions().elementView(getTransactionTypeChkbx("2"), "Buy Token");
    }
    public void clickWithdrawChkbx() {
    	click(getTransactionTypeChkbx("3"), "Withdraw");
    }
    public void verifyWithdrawChkbxView() {
    	new CommonFunctions().elementView(getTransactionTypeChkbx("3"), "Withdraw");
    }
    
    public void verifylabelTransactionAmt(String transactionAmount) {
    	new CommonFunctions().verifyLabelText(lblTransactionAmt, "Transaction Amount", transactionAmount);
    }
    public void verifyTransactionAmountView() {
    	new CommonFunctions().elementView(lblTransactionAmt, "Transaction Amount");
    }
    public void fillFromCYN() {
    	click(txtFromCYN, "FromCYN");
    }
    public void verifyFromCYNview() {
    	new CommonFunctions().elementView(txtFromCYN, "From CYN");
    }
    public void fillToCYN() {
    	click(txtToCYN, "TOCYN");
    }
    public void verifyToCYNview() {
    	new CommonFunctions().elementView(txtToCYN, "To CYN");
    }
    public void verifylabelReferenceID(String ReferenceId) {
    	new CommonFunctions().verifyLabelText(lblReferenceID, "ReferenceID", ReferenceId);
    }
    public void fill15CharReferenceId() {
    	click(txt15CharReferenceId, "Reference Id 15 Char");
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
    public void clickBankAccountChkbx() {
    	click(getTransactionSubTypeChkbx("0"), "Bank Account");
    }
    public void verifyBankAccountChkbxView() {
    	new CommonFunctions().elementView(getTransactionSubTypeChkbx("0"), "BankAccount");
    }
    public void clickInstantPayChkbx() {
    	click(getTransactionSubTypeChkbx("1"), "Instant Pay");
    }
    public void verifyInstantPayChkbxView() {
    	new CommonFunctions().elementView(getTransactionSubTypeChkbx("1"), "Instant Pay");
    }
    public void clickSignetChkbx() {
    	click(getTransactionSubTypeChkbx("7"), "Signet");
    }
    public void verifySignetChkbxView() {
    	new CommonFunctions().elementView(getTransactionSubTypeChkbx("7"), "Signet");
    }
    public void verifyLabelTransactionStatus(String TransactionStatus) {
    	new CommonFunctions().verifyLabelText(lblTransactionStatus, "TransactionStatus", TransactionStatus);
    }
    public void clickResetAllFilters() {
    	click(btnResetAllFilters, "Reset all Filters");
    }
    public void clickApplyFilter() {
    	click(btnApplyFilters, "Apply Filters");
    }
    public void clickPendingChkbx() {
    	click(getTransactionStatusChkbx("1"), "Pending");
    }
    public void clickCompletedChkbx() {
    	click(getTransactionStatusChkbx("2"), "Completed");
    }
    public void clickCancelledChkbx() {
    	click(getTransactionStatusChkbx("4"), "Cancelled");
    }
    public void clickInprogressChkbx() {
    	click(getTransactionStatusChkbx("0"), "In Progress");
    }
    public void clickFailedChkbx() {
    	click(getTransactionStatusChkbx("3"), "Failed");
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
    }



