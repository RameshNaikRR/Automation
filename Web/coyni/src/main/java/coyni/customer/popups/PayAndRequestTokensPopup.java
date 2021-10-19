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
	
	
	public void clickOnPay() {
	 click(btnPay, "Click Pay");
		
	}
    public void clickOnRequest() {
     click(btnRequest, "Click Request");
    }
    public void enterAmount(String amount) {
     enterText(txtAmount, amount, "amount");	
    }
    
    public void enterRecipientAddress(String RecipientAddress) {
    	enterText(txtRecipientsAddress, RecipientAddress,"RecipientAddress");
    	
    }
    public void clickOnPasteLink() {
    	click(lnkPaste, "Click Paste");
    }

    public void enterRecipientMessage(String RecipientMessage) {
    	enterText(txtRecipientMessage, RecipientMessage, "RecipientMessage" );
    }
    public void clickOnNext() {
    	click(btnNext, "Click Next");
    }
    public void VerifyErrorMessage(String ErrorMessage) {
  	  new CommonFunctions().verifyLabelText(lblErrorMessage, ErrorMessage, "ErrorMessage");
      }
    public String getRequestAccountHolderName() {
     return	getText(lblAccountHolderName, "Account Holder Name");
    }
}
