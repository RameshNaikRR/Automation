package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TokensReceivedDetailsComponent extends BrowserFunctions {

	private By lblTokensReceived = By.xpath("//span[text()='Tokens Received']");

	private By lblTranscationsCount = By.cssSelector("");

	private By lblTokensReceiveTransactions = By.xpath("//h1[text()='Tokens Received Transactions']");

//	private By ReceivedAmount = By.xpath("(//div[@class='TokenAccountDetail_widthDivide__8Bwmr'])[1]");

//	public void verifyReceivedAmountAndCountTransactions() {
//
//		new CommonFunctions().elementView(ReceivedAmount, "Received Amount");
//		new CommonFunctions().elementView(ReceivedCountTxns, "Received TxnsCount");
//
//	}

	public String getTokensReceived() {
		return getText(lblTokensReceived, "Tokens Received");
	}

	public String getTransactionsCount() {
		return getText(lblTranscationsCount, "Transactions Count");
	}

	public void verifyLabelReceiveTransactionDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokensReceiveTransactions, "Tokens Received Transactions", expHeading);
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

	public TransactionsListComponent transactionsListComponent() {
		return new TransactionsListComponent();
	}

}
