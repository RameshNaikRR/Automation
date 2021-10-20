package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreAuthorizationPopup extends BrowserFunctions{
	
	private By txtAmount = By.cssSelector("");
	private By btnVerify = By.cssSelector("");
	private By lblErrorMessage = By.cssSelector("");
	
	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}
	
	public void clickOnVerify() {
		click(btnVerify, "Click Verify");
	}
	public void VerifyErrorMessage(String ErrorMessage) {
		  new CommonFunctions().verifyLabelText(lblErrorMessage, ErrorMessage, "ErrorMessage");
	    }
    public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
    	return new SuccessFailurePopupCardComponent();
    	
    }
     
}
