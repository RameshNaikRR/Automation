package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.AddCardComponent;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewPaymentMethodPopup extends BrowserFunctions {
	
  private By btnExternalBankAccount = By.xpath("//span[text()='Bank Account']");
  private By btnDebitCard = By.xpath("//span[text()='Debit Card']");
  private By btnCreditCard = By.xpath("//span[text()='Credit Card']");
  private By lblExternalBankAccountCount = By.xpath("(//span[@class='count'])[1]");
  private By lblDebitCardCount = By.xpath("(//span[@class='count'])[2]");
  private By lblCreditCardCount = By.xpath("(//span[@class='count'])[3]");
  
  public void clickaddExternalBankAccount() {
	  click(btnExternalBankAccount, "Click ExternaBankAccount");
	  
  }
  public void clickDebitCard() {
	  click(btnDebitCard, "Click DebitCard");
	  
  }
  public void clickCreditCard() {
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
   public AddCardComponent addCardComponent() {
	   return new AddCardComponent();
   }
   public PreAuthorizationPopup preAuthorizationPopup() {
	   return new PreAuthorizationPopup();
   }
    
  
}
