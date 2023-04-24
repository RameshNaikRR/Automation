package coyni.merchant.components;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class FilterComponent extends BrowserFunctions {

	private By txtStartDate = By
			.cssSelector("custom-date-picker-filter relative mb-0 flex items-center justify-between group  Date");
	private By txtEndDate = By.cssSelector(
			"custom-date-picker-filter relative mb-0 flex items-center justify-between group  relative Date");
	private By lnkClearCreatedDate = By.xpath("//label[text()='Date']/button");
	private By lnkClearAllTransactionType = By.xpath("//span[text()='Transaction Type']/button");
//	private By lnkClearSenderName = By.xpath("//label[text()='Sender Name']/button");
	private By lnkResetAllFilters = By.xpath("//button[text()='Reset all filters']");
	private By lnkClearAllTransactionSubtype = By.xpath("//span[text()='Transaction Subtype']/button");
	private By txtFromAmount = By.cssSelector("div[class $='group__from']>input");
	private By btnResetFilters = By.xpath("//button[text()='Reset all filters']");
	private By txtToAmount = By.cssSelector("div[class $='group__to']>input");
	private By txtSenderName = By.xpath("//input[@placeholder='Sender Name']");
	private By txtReceiverName = By.xpath("//input[@placeholder='Receiver Name']");
	private By lnkClearTransactionAmount = By.xpath("//label[text()='Transaction Amount']/button");
	private By lnkClearAllTransactionStatus = By.xpath("//span[text()='Transaction Status']/button");
	private By txtReferenceID = By.name("gbxTransactionId");
	private By lnkClearReferenceID = By.xpath("//label[text()='Reference ID']/button");
	private By txtReferencrID = By.xpath("//label[text()='Reference ID']");
	private By btnFilter = By.xpath("//button[text()='Filter']");
	private By btnApplyFilters = By.xpath("//button[text()='Apply Filters']");
	private By tableRows = By.cssSelector(".custom-table-wrapper>tbody>tr");
	private By msgNoRecoreds = By.cssSelector(".message");
	private By lblNoFilterData = By.xpath("//span[text()='No Filter Data Found']");
	private By lblShowingItems = By.xpath("//span[@class='entries-message']");
	private By btnRecord = By.cssSelector("tbody>tr:nth-of-type(2)>td:nth-of-type(1)");
	private By lnkClearDate = By.xpath("//label[text()='Date']//button[text()='Clear']");
	private By lnkClearReference = By.xpath("//label[text()='Reference ID']//button[text()='Clear']");
	private By lnkClearAllTxnType = By.xpath("//span[text()='Transaction Type']//button[text()='Clear All']");
	private By lblNoTrasactons = By.xpath("//span[contains(text(),'You do not have any transactions.')]");
	private By lnkClearAllTxnSubType = By.xpath("//span[text()='Transaction SubType']//button[text()='Clear All']");
	private By lnkClearTxnStatus = By.xpath("//span[text()='Transaction Status']//button[text()='Clear All']");
	private By lnkClearSenderName = By.xpath("//span[text()='Sender Name']//button[text()='Clear']");
	private By lnkClearReceiverName = By.xpath("//span[text()='Sender Name']//button[text()='Clear']");

	private By getCheckBoxes(String checkBox) {
		return By.xpath(String.format("//span[text()='%s']/preceding-sibling::input", checkBox));
	}

	public void clickOnRecord() {
		click(btnRecord, "Record");
	}

	public int noFilterData() {
		int size = getElementsList(lblNoFilterData, "").size();
		return size;
	}

	public String getTotalPendingTransaction() {
		String text = getText(lblShowingItems, "Total Pending Transction");
		String[] split = text.split(" ");
		String string = split[3];
		return string;
	}

	public void getTotalCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getTotalPendingTransaction());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void clickResetFilters() {
		click(btnResetFilters, "Reset Filters");
	}

	public void clickCheckBox(String checkBox) {
		By checkCheckBoxes = By.xpath(String
				.format("//input[@type='checkbox']/following::span[text()='%s']/preceding-sibling::input", checkBox));
		click(checkCheckBoxes, checkBox + "Check Box ");
	}

	public void clickOnMerchantPayOut() {
		click(getCheckBox("Merchant Payout"), "Merchant Payout");
	}

	public void clickOnBuyToken() {
		click(getCheckBox("Buy Token"), "Buy Token");
	}

	public void clickOnWithdraw() {
		click(getCheckBox("Withdraw"), "Withdraw");
	}

	public void clickOnReserveRelease() {
		click(getCheckBox("Reserve Release"), "Reserve Release");
	}

	public void clickOnSaleOrder() {
		click(getCheckBox("Sale Order"), "Sale Order");
	}

	public void clickOnRefund() {
		click(getCheckBox("Refund"), "Refund");
	}

	public void clickOnPartialRefund() {
		click(getCheckBox("Partial Refund"), "Partial Refund");
	}

	public void clear() {
		click(lnkClearDate, "Clear");
	}

	public void clearSenderName() {
		click(lnkClearSenderName, "Clear");
	}

	public void clearReceiverName() {
		click(lnkClearReceiverName, "Clear");
	}

	public void clearAllTxnType() {
		click(lnkClearAllTxnType, "Clear All");
	}

	public void clearAllTxnStatus() {
		click(lnkClearTxnStatus, "Clear All");
	}

	public void clearAllTxnSubType() {
		click(lnkClearAllTxnSubType, "Clear All");
	}

	public void clickOnBankAccount() {
		click(getCheckBox("Bank Account"), "Bank Account");
	}

	public void clickOnInstantPay() {
		click(getCheckBox("Instant Pay"), "Instant Pay");
	}

	public void clickOnCogent() {
		click(getCheckBox("Cogent"), "Cogent");
	}

	public void clickOnMonthlyServiceFee() {
		click(getCheckBox("Monthly Service Fee"), "Monthly Service Fee");
	}

	public void clickOnGiftCard() {
		click(getCheckBox("Gift Card"), "Gift Card");
	}

	public void clickOnSaleOrderEmobile() {
		click(getCheckBox("Sale Order: Retail / Mobile"), "Sale Order: Retail / Mobile");
	}

	public void clickOnSaleOrderECommerce() {
		click(getCheckBox("Sale Order: eCommerce"), "Sale Order: eCommerce");
	}

	public void ClickOnPending() {
		click(getCheckBox("Pending"), "Pending");

	}

	public void ClickOnCompleted() {
		click(getCheckBox("Completed"), "Completed");

	}

	public void ClickOnCancelled() {
		click(getCheckBox("Cancelled"), "Cancelled");

	}

	public void ClickOnInProgress() {
		click(getCheckBox("In Progress"), "In Progress");

	}

	public void ClickOnFailed() {
		click(getCheckBox("Failed"), "Failed");

	}

	public void selectFilter(String type) {
		click(getCheckBox(type), type);
	}

	private By getCheckBox(String elementName) {
		return By.xpath(String.format("//span[text()='%s']//preceding-sibling::input", elementName));
	}

	public void clickStartDate() {
		click(txtStartDate, "Start Date");
	}

	public void clickEndDate() {
		click(txtEndDate, "End Date");
	}

	public void clickClearCreatedDate() {
		click(lnkClearCreatedDate, "Clear Created Date");
	}

	// Transaction Type
	public void clickPayRequestCheckBox() {
		click(getCheckBoxes("Pay / Request"), "Pay / Request");
	}

	public void clickBuyTokenCheckBox() {
		click(getCheckBoxes("Buy Token"), "Buy Token");
	}

	public void clickWithdrawCheckBox() {
		click(getCheckBoxes("Withdraw"), "Withdraw");
	}

	public void clickClearAllTransactionType() {
		click(lnkClearAllTransactionType, "All Transction Type");
	}

	public void clickClearAllTransactionStatus() {
		click(lnkClearAllTransactionStatus, "All Transction Status");
	}

	public void clickClearSenderName() {
		click(lnkClearSenderName, "Sender Name");
	}

	public void clickBankAccountCheckBox() {
		click(getCheckBoxes("Bank Account"), "Bank Account");
	}

	public void clickInstantPayCheckBox() {
		click(getCheckBoxes("Instant Pay"), "Instant Pay");
	}

	public void clickGiftCardCheckBox() {
		click(getCheckBoxes("Gift Card"), "Gift Card");
	}

	public void clickCreditCardCheckBox() {
		click(getCheckBoxes("Credit Card"), "Credit Card");
	}

	public void clickDebitCardCheckBox() {
		click(getCheckBoxes("Debit Card"), "Debit Card");
	}

	public void clickSentCheckBox() {
		click(getCheckBoxes("Sent"), "Sent");
	}

	public void clickReceivedCheckBox() {
		click(getCheckBoxes("Received"), "Received");
	}

	public void clickClearAllTransactionSubType() {
		click(lnkClearAllTransactionSubtype, "All Transaction SubType");
	}

	public void fillFromAmount(String amount) {
		enterText(txtFromAmount, amount, "Amount");

	}

	public void fillSender(String sender) {
		enterText(txtSenderName, sender, "Sender");

	}

	public void fillReceiver(String receiver) {
		enterText(txtReceiverName, receiver, "Receiver");

	}

	public void fillToAmount(String amount) {
		enterText(txtToAmount, amount, "Amount");
	}

	public void clickClearTransactionAmount() {
		click(lnkClearTransactionAmount, "Transaction Amount");
	}

	public void fillReferenceID(String referenceID) {
		copyDataToClipboard(referenceID);
		enterText(txtReferenceID, referenceID, "Reference ID");
	}

	public void clickClearReferenceID() {
		click(lnkClearReferenceID, "Reference ID");
	}

	public void clickPendingCheckBox() {
		click(getCheckBoxes("Pending"), "Pending");
	}

	public void clickCompletedCheckBox() {
		click(getCheckBoxes("Completed"), "Completed");
	}

	public void clickCanceledCheckBox() {
		click(getCheckBoxes("Cancelled"), "Cancelled");
	}

	public void clickFailedCheckBox() {
		click(getCheckBoxes("Failed"), "Failed");
	}

	public void clickInProgressCheckBox() {
		click(getCheckBoxes("In Progress"), "In Progress");
	}

	public void clickApplyFilters() {
		scrollToElement(btnApplyFilters, "Apply Filters");
		click(btnApplyFilters, "Apply Filters");
	}

	public void clickFilters() {
		if (getElement(btnFilter, "Enabled").isDisplayed()) {
			scrollToElement(btnFilter, "Filter");
			click(btnFilter, "Filter");
		} else {
			ExtentTestManager.setPassMessageInReport("Filter button is Disabled");
		}

	}

	public void verifyMouseAction() {
		new CommonFunctions().verifyCursorAction(btnFilter, "Filter");
	}

	public boolean verifyTransactions() {
		WebElement ele = getElement(lblNoTrasactons, "");
		boolean displayed = ele.isDisplayed();
		return displayed;
	}

	public int verifyTransactionss() {
		int ele = getElementsList(lblNoTrasactons, "").size();
		return ele;
	}

	public void verifyNoTrasactionsFound() {
		new CommonFunctions().elementView(lblNoTrasactons, "No Trasactions");
//		return getText(lblNoTrasactons, "No Trasactions");
	}

	public int verifyFilters() {
		return getElementsList(lblNoTrasactons, "").size();
	}

	public void clickResetAllFilters() {
		click(lnkResetAllFilters, "Reset All Filters");
	}

	public void scroolDownToElement() {
		scrollToElement(txtReferenceID, "Reference ID");
	}

	public CalendarComponponent calendarComponponent() {
		return new CalendarComponponent();
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

	public FilterCalenderComponent filterCalenderComponent() {
		return new FilterCalenderComponent();
	}

	public void getNoRecordsFound() {
		if (getElementsList(msgNoRecoreds, "No Records Found").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Table contains Records");
		} else {
			ExtentTestManager.setInfoMessageInReport("Table does not contains any records");
		}
	}

}
