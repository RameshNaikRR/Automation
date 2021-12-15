package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TokenAccountActivityComponent extends BrowserFunctions {

	private By btnTokensSentDetails = By.xpath("(//button[text()='Details'])[1]");

	private By lblTokensSent = By.xpath("//span[text()='Tokens Sent']");

	private By btnTokensReceivedDetails = By.xpath("(//button[text()='Details'])[2]");

	private By lblTokensReceived = By.xpath("//span[text()='Tokens Received']");

	private By ReceivedAmount = By.xpath("(//div[@class='TokenAccountDetail_widthDivide__8Bwmr'])[1]");

	private By ReceivedCountTxns = By.xpath("(//span[@class='text-7xl font-bold cursor-default text-cgy4'])[2]");

	private By btnTokensPurchasedDetails = By.xpath("(//button[text()='Details'])[3]");

	private By lblTokensPurchased = By.xpath("//span[text()='Token Purchased']");

	private By btnTokensWithdrawn = By.xpath("(//button[text()='Details'])[4]");

	private By lblTokensWithdrawn = By.xpath("//span[text()='Token Withdraw']");

	private By btnPaidOrdersDetails = By.xpath("(//button[text()='Details'])[5]");

	private By lblPaidOrders = By.xpath("//span[text()='Token Paid (To Business)']");

	private By lblTokensSentTransactions = By.xpath("//h1[text()='Tokens Sent Transactions']");

	private By lblTokensReceiveTransactions = By.xpath("//h1[text()='Tokens Received Transactions']");

	private By lblDateTime = By.xpath("//span[text()='Date & Time']");

	private By lblType = By.xpath("//span[text()='Type']");

	private By lblDescription = By.xpath("//span[text()='Description']");

	private By lblAmount = By.xpath("//span[text()='Amount']");

	private By lblBalance = By.xpath("//span[text()='Balance']");

	private By lblStatus = By.xpath("//span[text()='Status']");

	private By transactionDetails = By.xpath("//div[@Class='custom-table-container custom-table-container--empty']");

	private By entriesPerPageDropDown = By.xpath(
			"//div[@class='custom-pagination-select__indicator custom-pagination-select__dropdown-indicator css-tlfecz-indicatorContainer']");

	private By defaultEntries = By.xpath(
			"//div[@class=\"custom-pagination-select__value-container custom-pagination-select__value-container--has-value css-1hwfws3\"]");

	private By lblEntriesMessage = By.xpath("//span[@class='entries-message']");

	private By pagination = By.xpath("//li[@class='paginator__pagination__item active']");

	// private By iIconPaidOrders = By.cssSelector("");

	public void clickTokensSentDetails() {
		click(btnTokensSentDetails, "Click Token Sent Details");
	}

	public String getTokensSent() {
		return getText(lblTokensSent, "Tokens Sent");
	}

	public void verifyLabelTokenSentDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokensSentTransactions, "Tokens Sent Transactions", expHeading);
		new CommonFunctions().elementView(lblDateTime, "Date and Time");
		new CommonFunctions().elementView(lblType, "Type");
		new CommonFunctions().elementView(lblDescription, "Description");
		new CommonFunctions().elementView(lblAmount, "Amount");
		new CommonFunctions().elementView(lblBalance, "Balance");
		new CommonFunctions().elementView(lblStatus, "Status");
	}

	public void verifyEntriesMessage() {
		new CommonFunctions().elementView(lblEntriesMessage, "Entries Message");
	}

	public void verifyTransactionDetails() {
		new CommonFunctions().elementView(transactionDetails, "Transaction Details");
	}

	public void clickDropDownEntriesPage() {
		click(entriesPerPageDropDown, "Entries Per Page");
		new CommonFunctions().elementView(defaultEntries, "Default Entries");

	}

	public void clickOnPages() {
		click(pagination, "Pagination");
	}

	public void clickTokensReceivedDetails() {
		click(btnTokensReceivedDetails, "Click Token Received Details");

	}

	public String getTokensReceived() {
		return getText(lblTokensReceived, "Tokens Received");
	}

	public void verifyReceivedAmountAndCountTransactions() {

		new CommonFunctions().elementView(ReceivedAmount, "Received Amount");
		new CommonFunctions().elementView(ReceivedCountTxns, "Received TxnsCount");

	}

	public void verifyLabelTokenReceiveDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokensReceiveTransactions, "Tokens Received Transactions", expHeading);
		new CommonFunctions().elementView(lblDateTime, "Date and Time");
		new CommonFunctions().elementView(lblType, "Type");
		new CommonFunctions().elementView(lblDescription, "Description");
		new CommonFunctions().elementView(lblAmount, "Amount");
		new CommonFunctions().elementView(lblBalance, "Balance");
		new CommonFunctions().elementView(lblStatus, "Status");
	}

	public void clickTokensPurchasedDetails() {
		click(btnTokensPurchasedDetails, "Click Token Received Details");
	}

	public String getTokensPurchased() {
		return getText(lblTokensPurchased, "Tokens Purchased");
	}

	public void clickTokensWithdrawn() {
		click(btnTokensWithdrawn, "Click Token Withdrawn Details");
	}

	public String getTokensWithdrawn() {
		return getText(lblTokensWithdrawn, "Tokens Withdrawn");
	}

	public void clickPaidOrdersDetails() {
		click(btnPaidOrdersDetails, "Click Paid Order Details");
	}

	public String getPaidOrders() {
		return getText(lblPaidOrders, "Paid Orders");
	}

//	public String getIIconMessage() {
//		return getText(iIconPaidOrders, "I Icon Paid Orders");
//	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

}
