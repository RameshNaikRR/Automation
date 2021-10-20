package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.web.actions.WaitForElement;

public class EditPhoneNumberPopup extends BrowserFunctions {
	
	private By txtOldNumber = By.cssSelector("");
	private By txtNewNumber = By.cssSelector(" ");
	private By btnSendCode = By.cssSelector(" ");
	
	
	
	public void VerifyOldNumber(String OldNumber) {
	    new CommonFunctions().verifyLabelText(txtOldNumber, OldNumber, "OldNumber");
   }
	public void fillNewNumber(String NewNumber) {
		waitForElement(txtNewNumber, waittime, WaitForElement.visibility);
		enterText(txtNewNumber, NewNumber, "NewNumber");
	}
	public void clickSendCode() {
		click(btnSendCode, "Click SendCode");
	}
	
	
}


