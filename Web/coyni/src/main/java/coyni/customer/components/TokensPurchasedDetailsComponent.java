package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TokensPurchasedDetailsComponent extends BrowserFunctions {

	private By lblTokensPurchased =By.cssSelector("");

	private By lblTranscationsCount =By.cssSelector("");

	public String getTokensPurchased() {
		return getText(lblTokensPurchased, "Tokens Purchased");
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
