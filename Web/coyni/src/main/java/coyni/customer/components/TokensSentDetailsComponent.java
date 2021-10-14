package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TokensSentDetailsComponent extends BrowserFunctions {
	
	private By lblTokensSent =By.cssSelector("");
	
	private By lblTranscationsCount =By.cssSelector("");
	
	public String getTokensSent() {
		return getText(lblTokensSent, "Tokens Sent");
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
