package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawViaInstantPay extends BrowserFunctions {
	
	private By txtAmount = By.cssSelector("");
	private By lblmsg = By.cssSelector("");
	private By txtmsg = By.cssSelector("");
	private By lnkConvert = By.cssSelector("");
	private By lnkChange = By.cssSelector("");
	private By btnNext = By.cssSelector("");
	
	
	public void enterAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
		
	}
	public void enterMessage(String Message) {
		enterText(txtmsg, Message, "Message");
		
	}
	
	public void VerifyErrorMessage(String ErrorMessage) {
	  	  new CommonFunctions().verifyLabelText(lblmsg, ErrorMessage, "ErrorMessage");
	}
	
	
	public void clickOnConvertLink() {
		click(lnkConvert, "Click Convert");
	}
	
	public void clickOnChangeLink() {
		click(lnkChange, "Click Delete");
	}
	public void clickOnNext() {
		click(btnNext, "Click Next");
	}
	
}


