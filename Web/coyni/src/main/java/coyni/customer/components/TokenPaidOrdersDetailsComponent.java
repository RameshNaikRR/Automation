package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TokenPaidOrdersDetailsComponent extends BrowserFunctions {

	private By lblPaidOrders = By.cssSelector("");

	private By lblTranscationsCount =By.cssSelector("");

	public String getPaidOrders() {
		return getText(lblPaidOrders, "Paid Orders");
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
