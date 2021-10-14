package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TokensWithdrawnDetailsComponent extends BrowserFunctions {

	private By lblTokensWithdrawn =By.cssSelector("");

	private By lblTranscationsCount =By.cssSelector("");

	public String getTokensWithdrawn() {
		return getText(lblTokensWithdrawn, "Tokens Withdrawn");
	}

	public String getTransactionsCount() {
		return getText(lblTranscationsCount, "Transactions Count");
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
