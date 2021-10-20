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
	
	public void verifyErrorMessage(String ErrorMessage) {
	  	  new CommonFunctions().verifyLabelText(lblErrorMessage, ErrorMessage, "ErrorMessage");
	      }
	
	public void fillMessage(String Message) {
		enterText(txtMessage, Message, "Message");
		
	}
	
	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
		
	}
	
	public void clickNext() {
		click(btnNext, "Click Next");
	}
	
	public void clickConvertLink() {
		click(lnkConvert, "Click Convert");
	}
	
	public void clickDelete() {
		click(btnDelete, "Click Delete");
	}
	public WithdrawConfirmPopup withdrawConfirmPopup() {
		return new WithdrawConfirmPopup();
	}
	
}
