package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PayAndRequestTokensPopup extends BrowserFunctions {
	
	private By btnPay = By.cssSelector("");
	private By btnRequest = By.cssSelector("");
	private By txtAmount = By.cssSelector("");
	private By lblErrorMessage = By.cssSelector("");
	private By txtRecipientsAddress = By.cssSelector("");
	private By lnkPaste = By.cssSelector("");
	private By lblAccountHolderName = By.cssSelector("");
	private By txtRecipientMessage = By.cssSelector("");
	private By btnNext = By.cssSelector("");
	
	
	public void clickPay() {
	 click(btnPay, "Click Pay");
		
	}
    public void clickRequest() {
     click(btnRequest, "Click Request");
    }
    public void fillAmount(String amount) {
     enterText(txtAmount, amount, "amount");	
    }
    
    public void fillRecipientAddress(String RecipientAddress) {
    	enterText(txtRecipientsAddress, RecipientAddress,"RecipientAddress");
    	
    }
    public void clickPasteLink() {
    	click(lnkPaste, "Click Paste");
    }

    public void fillRecipientMessage(String RecipientMessage) {
    	enterText(txtRecipientMessage, RecipientMessage, "RecipientMessage" );
    }
    public void clickNext() {
    	click(btnNext, "Click Next");
    }
    public void VerifyErrorMessage(String ErrorMessage) {
  	  new CommonFunctions().verifyLabelText(lblErrorMessage, "ErrorMessage", ErrorMessage);
      }
    public void verifyAccountHolderName(String expAccountHolderName) {
     new CommonFunctions().verifyLabelText(lblAccountHolderName, "Account holder Name", expAccountHolderName);
    }
    
    public RequestingAccountHolderPopup requestingAccountHolderPopup() {
    	return new RequestingAccountHolderPopup();
    }
    public PayingAccountHolderNamePopup payingAccountHolderNamePopup() {
    	return new PayingAccountHolderNamePopup();
    }
}
