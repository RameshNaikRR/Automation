package coyni.customer.components;

import org.openqa.selenium.By;


import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodsComponent extends BrowserFunctions {
	
	private By btnAddNewPaymentMethod =By.cssSelector("");
	private By lblNoActivePaymentMethods =By.cssSelector("");
	
	public void clickAddNewPaymentMethod() {
		click(btnAddNewPaymentMethod, "Click Add new Payment Method");
	}
	/*
	public void verifyNoActiveMethods(String expLabel) {
		new CommonFunctions().verifyLabelText(lblNoActivePaymentMethods, "No Active Payment methods", expLabel);
	}
*/

	
	public CardsComponent cardsComponent() {
		return new CardsComponent();
	}
	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}
	/*
	 public BankAccountsComponent bankAccountsComponent(){
	 return new BankAccountsComponent();

	 }
 
	 
	 */



}
