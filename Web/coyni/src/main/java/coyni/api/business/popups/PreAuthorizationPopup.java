package coyni.api.business.popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.apibusiness.components.SuccessFailureComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreAuthorizationPopup extends BrowserFunctions {

	private By txtAmount = By.name("authAmount");
	private By btnVerify = By.xpath("//button[@type='submit']");
	private By heading = By.xpath("//h1[contains(text(),'Pre-Authorization')]");
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
    public SuccessFailureComponent successFailureComponent() {
    	return new SuccessFailureComponent();
    	
    }
    public void clickTab() throws AWTException {
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_TAB);
    	robot.keyRelease(KeyEvent.VK_TAB);
    	}
    
    public void verifyHeading() {
    	new CommonFunctions().elementView(heading, "Pre-Authorization heading");
    }
	
}
