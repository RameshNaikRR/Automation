package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.customer.popups.AddExternalBankAccountPopup;
import coyni.customer.popups.AddNewPaymentMethodPopup;
import coyni.customer.popups.PreAuthorizationPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodsComponent extends BrowserFunctions {
	
	private By btnAddNewPaymentMethod =By.cssSelector("");
	private By lblNoActivePaymentMethods =By.cssSelector("");
	private By lblPaymentMethods = By.cssSelector(" ");
	
	public void clickAddNewPaymentMethod() {
		click(btnAddNewPaymentMethod, "Click Add new Payment Method");
	}
	/*
	public void verifyNoActiveMethods(String expLabel) {
		new CommonFunctions().verifyLabelText(lblNoActivePaymentMethods, "No Active Payment methods", expLabel);
	}
*/
   public void verifyPaymentMethodsview() {
	   new CommonFunctions().elementView(lblPaymentMethods, "PaymentMethods");
   }
	
	public CardsComponent cardsComponent() {
		return new CardsComponent();
	}
	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}

	 public BankAccountsComponent bankAccountsComponent(){
	 return new BankAccountsComponent();

	 }
	 
	public AddNewPaymentMethodPopup addNewPaymentMethodPopup() {
    return new AddNewPaymentMethodPopup();
	}
	public AddExternalBankAccountPopup addExternalBankAccountPopup() {
	    return new AddExternalBankAccountPopup();
	   }
	public PreAuthorizationPopup preAuthorizationPopup() {
		return new PreAuthorizationPopup();
	}

}
