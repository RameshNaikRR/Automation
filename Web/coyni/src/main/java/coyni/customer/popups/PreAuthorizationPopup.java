package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreAuthorizationPopup extends BrowserFunctions{
	
	private By txtAmount = By.cssSelector("");
	private By btnVerify = By.cssSelector("");
	private By lblErrorMessage = By.cssSelector("");
	
	public void enterAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}
	
	public void clickOnVerify() {
		click(btnVerify, "Click Verify");
	}
	public void VerifyErrorMessage(String ErrorMessage) {
		  new CommonFunctions().verifyLabelText(lblErrorMessage, ErrorMessage, "ErrorMessage");
	    }

}
