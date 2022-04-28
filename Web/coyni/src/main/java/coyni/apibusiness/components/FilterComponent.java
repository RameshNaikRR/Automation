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
	private By lnkClearAll = By.xpath("//span[text()='Transaction Type']//button[text()='Clear All']");
//	private By chkbxWalletTransfer = By.xpath(" ");
//	private By chkbxBuyToken = By.xpath(" ");
//	private By chkbxWithdraw = By.xpath(" ");
	private By lblTransactionSubType = By.xpath("//span[text()='Transaction Subtype']");
//	private By chkbxBankAccount = By.xpath(" ");
//	private By chkbxInstantPay = By.xpath(" ");
//	private By chkbxSignet = By.xpath(" ");
	private By lblTransactionAmt = By.xpath("//label[text()='Transaction Amount']");
	private By txtFromCYN = By.xpath("//span[text()='From (CYN)']");
	private By txtToCYN = By.xpath("//span[text()='To (CYN)']");
	private By lblReferenceID = By.xpath("//label[text()='Reference ID']");
	private By txt15CharReferenceId = By.xpath("//input[@id='txt']");
	private By lblTransactionStatus = By.xpath("//span[text()='Transaction Status']");
//	private By chkbxPending = By.xpath(" ");
//	private By chkbxCompleted = By.xpath(" ");
//	private By chkbxCancelled = By.xpath(" ");
//	private By chkbxInprogress = By.xpath(" ");
//	private By chkbxFailed = By.xpath(" ");
	private By lnkResetAllFilters = By.xpath("//button[text()='Reset all filters']");
	private By lnkApplyFilters = By.xpath("");
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
    public void clickFilter() {
    	click(btnFilter, "Filter");
    }
    public void verifyLabelDate(String date) {
    	new CommonFunctions().verifyLabelText(lblDate, "date", date);
    }
    public void fillStartDate() {
    	click(txtStartDate, "Start Date");
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
    public void clickWalletTransferChkbx() {
    	click(getTransactionTypeChkbx("20"), "wallet Transfer");
    }
    public void clickBuyTokenChkBx() {
    	click(getTransactionTypeChkbx("2"), "Buy Token");
    }
    public void clickWithdrawChkbx() {
    	click(getTransactionTypeChkbx("3"), "Withdraw");
    }
    
    public void verifylabelTransactionAmt(String transactionAmount) {
    	new CommonFunctions().verifyLabelText(lblTransactionAmt, "Transaction Amount", transactionAmount);
    }
    public void fillFromCYN() {
    	click(txtFromCYN, "FromCYN");
    }
    public void fillToCYN() {
    	click(txtToCYN, "TOCYN");
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
    public void verifyLabelTransactionSubType(String TransactionSubType) {
    	new CommonFunctions().verifyLabelText(lblTransactionSubType, "TransactionSubType", TransactionSubType);
    }
    public void clickBankAccountChkbx() {
    	click(getTransactionSubTypeChkbx("0"), getCopiedData());
    }
    public void verifyLabelTransactionStatus(String TransactionStatus) {
    	new CommonFunctions().verifyLabelText(lblTransactionStatus, "TransactionStatus", TransactionStatus);
    }
    //pending in this page
    }


