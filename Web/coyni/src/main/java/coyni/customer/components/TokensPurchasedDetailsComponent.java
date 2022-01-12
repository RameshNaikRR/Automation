package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TokensPurchasedDetailsComponent extends BrowserFunctions {

	private By lblTokensPurchased = By.xpath("//span[text()='Token Purchased']");

	private By lblTokensPurchaseTransactions = By.xpath("//h1[text()='Tokens Purchased Transactions']");

	private By lblTranscationsCount = By.cssSelector("");

	public String getTokensPurchased() {
		return getText(lblTokensPurchased, "Tokens Purchased");
	}

	public String getTransactionsCount() {
		return getText(lblTranscationsCount, "Transactions Count");
	}

	public void verifyLabelPurchasedTransactionDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokensPurchaseTransactions, "Tokens Purchased Transactions",
				expHeading);
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
