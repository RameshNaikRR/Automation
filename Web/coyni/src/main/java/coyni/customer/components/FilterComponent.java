package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class FilterComponent extends BrowserFunctions{
	
	private By txtStartDate = By.cssSelector("");
	private By txtEndDate = By.cssSelector("");
	private By lnkClearCreatedDate = By.cssSelector("");
	private By chkBxSent = By.cssSelector("");
	private By chkBxReceived = By.cssSelector("");
	private By chkBxPurchased = By.cssSelector("");
	private By chkBxPayRequest = By.cssSelector("");
	private By chkBxBuyToken = By.cssSelector("");
	private By chkBxWithdraw = By.cssSelector("");
	private By chkBxAccountTransfer = By.cssSelector("");
	private By chkBxSaleOrder = By.cssSelector("");
	private By chkBxPaidOrders = By.cssSelector("");
	private By lnkClearAllTransactionType = By.cssSelector("");
	private By chkBxInstantPay = By.cssSelector("");
	private By chkBxGiftCard = By.cssSelector("");
	private By chkBxCreditCard = By.cssSelector("");
	private By chkBxDebitCard = By.cssSelector("");
	private By chkBxchkBxSaleOrderToken = By.cssSelector("");
	private By lnkClearAllTransactionSubtype = By.cssSelector("");
	private By chkBxBankAccount = By.cssSelector("");
	private By txtFromAmount = By.cssSelector("");
	private By txtToAmount = By.cssSelector("");
	private By lnkClearTransactionAmount = By.cssSelector("");
	private By txtReferenceID = By.cssSelector("");
	private By lnkClearReferenceID = By.cssSelector("");
	private By txtMerchantName = By.cssSelector("");
	private By lnkClearMerchantName = By.cssSelector("");
	private By chkBxPending = By.cssSelector("");
	private By chkBxCompleted = By.cssSelector("");
	private By chkBxCanceled = By.cssSelector("");
	private By chkBxFailed = By.cssSelector("");
	private By chkBxInProgress = By.cssSelector("");
	private By lnkClearAllTrasactionStatus = By.cssSelector("");
	private By btnResetAllFilters = By.cssSelector("");
	private By btnApplyFilters = By.cssSelector("");
	
	public void clickStartDate() {
		click(txtStartDate, "Start Date");
	}
	public void clickEndDate() {
		click(txtEndDate, "End Date");
	}
	public void clickClearCreatedDate() {
		click(lnkClearCreatedDate, "Clear Created Date");
	}
	public void clickSentCheckBox() {
		click(chkBxSent,"Sent");
		
	}
	public void clickReceivedCheckBox() {
		click(chkBxReceived, "Received");
	}
	public void clickPurchasedCheckBox() {
		click(chkBxPurchased, "Purchased");
	}
	public void clickPayRequestCheckBox() {
		click(chkBxPayRequest, "Pay/Request");
	}
	public void clickBuyTokenCheckBox() {
		click(chkBxBuyToken, "Buy Token");
	}
	public void clickWithdrawCheckBox() {
		click(chkBxWithdraw, "Withdraw");
	}
	public void clickAccountTransferCheckBox() {
		click(chkBxAccountTransfer, "Account Transfer");
	}
	public void clickSaleOrderCheckBox() {
		click(chkBxSaleOrder, "Sale Order");
	}
	public void clickPaidOrersCheckBox() {
		click(chkBxPaidOrders, "Paid Order");
	}
	public void clickClearAllTransactionType() {
        click(lnkClearAllTransactionType, "All Transction Type");
	}
	public void clickInstantPayCheckBox() {
		click(chkBxInstantPay, "Instant Pay");
	}
	public void clickGiftCardCheckBox() {
		click(chkBxGiftCard, "Gift Card");
	}
	public void clickCreditCardCheckBox() {
		click(chkBxCreditCard, "Credit Card");
	}
	public void clickDebitCardCheckBox() {
		click(chkBxDebitCard, "Debit Card");
	}
	public void clickSalesOrderTokenCheckBox() {
		click(chkBxchkBxSaleOrderToken, "Sales Order Token");
	}
	public void clickclickClearAllTransactionSubType() {
		click(lnkClearAllTransactionSubtype, "All Transaction SubType");
	}
	public void clickBankAccountCheckBox() {
		click(chkBxBankAccount, "Bank Account");
	}
	public void fillFromAmount(String amount) {
		enterText(txtFromAmount, amount, "Amount");
	
	}
	public void fillToAmount(String amount) {
		enterText(txtToAmount, amount, "Amount");
	}
	public void clickClearTransactionAmount() {
		click(lnkClearTransactionAmount, "Transaction Amount");
	}
	public void fillReferenceID(String referenceID) {
		enterText(txtReferenceID, referenceID, "Reference ID");
	}
	public void clickClearReferenceID() {
		click(lnkClearReferenceID, "Reference ID");
	}
	public void fillMerchantName(String merchantName) {
		enterText(txtMerchantName, merchantName, "Merchant Name");
	}
	public void clickClearMerchantName() {
		click(lnkClearMerchantName, "Merchant Name");
	}
	public void clickPendingCheckBox() {
		click(chkBxPending, "Pending");
	}
	public void clickCompletedCheckBox() {
		click(chkBxCompleted, "Completed");
	}
	public void clickCanceledCheckBox() {
		click(chkBxCanceled, "Cancel");
	}
	public void clickFailedCheckBox() {
		click(chkBxFailed, "Failed");
	}
	public void clickInProgressCheckBox() {
		click(chkBxInProgress, "In Progress");
	}
	public void clickClearAllTransactionStatus() {
		click(lnkClearAllTrasactionStatus, "All Transaction Status");
	}
	public void clickResetAllFilters() {
		click(btnResetAllFilters, "Reset All Filters");
	}
	public void clickApplyFilters() {
		click(btnApplyFilters, "Apply Filters");
	}
}
