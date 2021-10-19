package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.web.actions.WaitForElement;

public class EditEmailAddressPopup extends BrowserFunctions {
	
	private By txtOldEmailAddress = By.cssSelector("");
	private By txtNewEmailAddress = By.cssSelector("");
	private By btnSendcode = By.cssSelector("");
	
	public void VerifyOldEmailAddress(String EmailAddress) {
	    new CommonFunctions().verifyLabelText(txtOldEmailAddress, EmailAddress, "EmailAddress");
   }
	public void EnterNewEmailAddress(String newNumber) {
		waitForElement(txtNewEmailAddress, waittime, WaitForElement.visibility);
		enterText(txtNewEmailAddress, newNumber, "NewNumber");
	}
	public void clickSendCode() {
		click(btnSendcode, "SendCode");
	}

}
