package coyni.admin.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DeclineCasePopup extends BrowserFunctions {

	 private By drpdwnChooseReason = By.xpath("//div[contains(@class,'FormField_selected_option')]");
	 private By heading = By.xpath("//h1[text()='Decline Case']");
	 private By lblReason = By.xpath("//div[text()='Merchant on MATCH']");
	 private By btnYes = By.xpath("//button[text()='Yes']");
	    
	    public void clickDropDown() {
	    	click(drpdwnChooseReason, "Choose a reason");
	    }
	    
	    public void verifyHeading() {
	    	String str = getText(heading, "Heading");
	    	ExtentTestManager.setInfoMessageInReport("The Heading is " + str);
	    }
	    
	    public void selectReasaon() {
	    	click(lblReason, "Reason");
	    }
	    
	    public void clickYes() {
	    	click(btnYes, "Yes");
	    }
}
