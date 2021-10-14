package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TokenAccountActivityComponent extends BrowserFunctions{
	
	private By btnTokensSentDetails = By.cssSelector("");
	
	private By lblTokensSent = By.cssSelector("");
	
	private By btnTokensReceivedDetails = By.cssSelector("");
	
	private By lblTokensReceived =By.cssSelector("");
	
	private By btnTokensPurchasedDetails = By.cssSelector("");
	
	private By lblTokensPurchased =By.cssSelector("");
	
	private By btnTokensWithdrawn =By.cssSelector("");
	
	private By lblTokensWithdrawn =By.cssSelector("");
	
	private By btnPaidOrdersDetails =By.cssSelector("");
	
	private By lblPaidOrders =By.cssSelector("");
	
	private By iIconPaidOrders =By.cssSelector("");
	
	public void clickTokensSentDetails() {
		click(btnTokensSentDetails, "Click Token Sent Details");
	}

	public String getTokensSent() {
		return getText(lblTokensSent, "Tokens Sent");
	}
	
	public void clickTokensReceivedDetails() {
		click(btnTokensReceivedDetails, "Click Token Received Details");
	}
	
	public String getTokensReceived() {
		return getText(lblTokensReceived, "Tokens Received");
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
	
	public String getIIconMessage() {
		return getText(iIconPaidOrders, "I Icon Paid Orders");
	}

   public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
	   return new DaysMonthsDropDownComponent();
   }
   
   public DatePickerComponent datePickerComponent() {
	   return new DatePickerComponent();
   }

}
