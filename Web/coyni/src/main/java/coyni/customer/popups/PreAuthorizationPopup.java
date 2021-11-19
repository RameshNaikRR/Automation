package coyni.customer.popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.customer.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreAuthorizationPopup extends BrowserFunctions{
	
	private By txtAmount = By.name("authAmount");
	private By btnVerify = By.xpath("//button[@type='submit']");
	//private By lblErrorMessage = By.cssSelector("");
	
	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}
	
	public void clickOnVerify() {
		click(btnVerify, "Click Verify");
	}
//	public void VerifyErrorMessage(String ErrorMessage) {
//		  new CommonFunctions().verifyLabelText(lblErrorMessage, ErrorMessage, "ErrorMessage");
//	    }
    public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
    	return new SuccessFailurePopupCardComponent();
    	
    }
    public void clickTab() throws AWTException {
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_TAB);
    	robot.keyRelease(KeyEvent.VK_TAB);
    	}
    
     
}
