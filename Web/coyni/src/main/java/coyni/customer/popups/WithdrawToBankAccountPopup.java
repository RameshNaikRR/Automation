package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawToBankAccountPopup extends BrowserFunctions{
    
	private By lblErrorMessage = By.cssSelector("");
	private By txtMessage = By.cssSelector("");
	private By txtAmount = By.cssSelector("");
	private By btnNext = By.cssSelector("");
	private By lnkConvert = By.cssSelector("");
	private By btnDelete = By.cssSelector("");
	
	public void VerifyErrorMessage(String ErrorMessage) {
	  	  new CommonFunctions().verifyLabelText(lblErrorMessage, ErrorMessage, "ErrorMessage");
	      }
	
	public void enterMessage(String Message) {
		enterText(txtMessage, Message, "Message");
		
	}
	
	public void enterAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
		
	}
	
	public void clickOnNext() {
		click(btnNext, "Click Next");
	}
	
	public void clickOnConvertLink() {
		click(lnkConvert, "Click Convert");
	}
	
	public void clickOnDelete() {
		click(btnDelete, "Click Delete");
	}
	
}
