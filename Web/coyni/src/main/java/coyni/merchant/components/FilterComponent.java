package coyni.merchant.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class FilterComponent extends BrowserFunctions {

	private By txtStartDate = By
			.cssSelector("custom-date-picker-filter relative mb-0 flex items-center justify-between group  Date");
	private By txtEndDate = By.cssSelector(
			"custom-date-picker-filter relative mb-0 flex items-center justify-between group  relative Date");
	private By lnkClearCreatedDate = By.xpath("//label[text()='Date']/button");
	private By lnkClearAllTransactionType = By.xpath("//span[text()='Transaction Type']/button");
	private By lnkClearSenderName = By.xpath("//label[text()='Sender Name']/button");
	private By lnkResetAllFilters = By.xpath("//button[text()='Reset all filters']");
	private By lnkClearAllTransactionSubtype = By.xpath("//span[text()='Transaction Subtype']/button");
	private By txtFromAmount = By.cssSelector("div[class $='group__from']>input");
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

	private By getCheckBoxes(String checkBox) {
		return By.xpath(String.format("//span[text()='%s']/preceding-sibling::input", checkBox));
	}

	public void clickCheckBox(String checkBox) {
		By checkCheckBoxes = By.xpath(String
				.format("//input[@type='checkbox']/following::span[text()='%s']/preceding-sibling::input", checkBox));
		click(checkCheckBoxes, checkBox + "Check Box ");
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
		click(btnApplyFilters, "Apply Filters");
	}

	public void clickFilters() {
		scrollToElement(btnFilter, "Filter");
		click(btnFilter, "Filter");
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

	public void getNoRecordsFound() {
		if (getElementsList(msgNoRecoreds, "No Records Found").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Table contains Records");
		} else {
			ExtentTestManager.setInfoMessageInReport("Table does not contains any records");
		}
	}

}
