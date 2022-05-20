package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TokensWithdrawnDetailsComponent extends BrowserFunctions {
	private By lblTranscationsCount = By.cssSelector("");

	private By lblTokensWithdrawTransactions = By.xpath("//h1[text()='Tokens Withdrawn Transactions']");

	private By lblTokensWithdrawn = By.xpath("//span[text()='Tokens Withdraw']");

	public String getTokensWithdrawn() {
		return getText(lblTokensWithdrawn, "Tokens Withdrawn");
	}

	public String getTransactionsCount() {
		return getText(lblTranscationsCount, "Transactions Count");
	}

	public void verifyLabelWithdrawTransactionDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokensWithdrawTransactions, "Tokens Withdraw Transactions",
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
