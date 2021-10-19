package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class AddNewPaymentMethodPopup extends BrowserFunctions {
	
  private By btnExternalBankAccount = By.cssSelector("");
  private By btnDebitCard = By.cssSelector("");
  private By btnCreditCard = By.cssSelector("");
  private By lblExternalBankAccountCount = By.cssSelector("");
  private By lblDebitCardCount = By.cssSelector("");
  private By lblCreditCardCount = By.cssSelector("");
  
  public void addExternalBankAccount() {
	  click(btnExternalBankAccount, "Click ExternaBankAccount");
	  
  }
  public void addNewDebitCard() {
	  click(btnDebitCard, "Click DebitCard");
	  
  }
  public void addNewCreditCard() {
	click(btnCreditCard, "Click CreditCard"); 
  }
  
  public String getExternalBankAccountCount() {
	 return getText(lblExternalBankAccountCount,"External Bank Account Count");
  }
  
  public String getDebitCardCount() {
	 return getText(lblDebitCardCount, "Debit Card Count");
  }
   public String getCreditCardCount() {
	  return getText(lblCreditCardCount, "Credit Card Count");
   }
  
}
