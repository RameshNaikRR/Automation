package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TokensSentDetailsComponent extends BrowserFunctions {

	private By lblTokensSent = By.xpath("//span[text()='Tokens Sent']");

	// private By sentAmount =
	// By.xpath("(//div[@class='TokenAccountDetail_widthDivide__8Bwmr'])[1]");

	private By lblTokensSentTransactions = By.xpath("//h1[text()='Tokens Sent Transactions']");

	private By lblTranscationsCount = By.cssSelector("");

	public String getTokensSent() {
		return getText(lblTokensSent, "Tokens Sent");
	}

	public String getTransactionsCount() {
		return getText(lblTranscationsCount, "Transactions Count");
	}

	public void verifyLabelTransactionDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokensSentTransactions, "Tokens Sent Transactions", expHeading);
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
