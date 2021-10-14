package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TokensReceivedDetailsComponent extends BrowserFunctions {

	private By lblTokensReceived =By.cssSelector("");

	private By lblTranscationsCount =By.cssSelector("");

	public String getTokensReceived() {
		return getText(lblTokensReceived, "Tokens Received");
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
