package coyni.admin.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawCasePopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[text()='Withdraw Case']");
	private By btnYes = By.xpath("//button[text()='Yes']");
	private By txtReason = By.xpath("//textarea[@name='reason']");
	
	public void verifyHeading() {
		String str = getText(heading, "Heading");
		ExtentTestManager.setInfoMessageInReport("The Heading is " + str);
	}
	public void clickYes() {
		click(btnYes, "Yes");
	}
	
	public void enterReason(String reason) {
	 enterText(txtReason, reason, "Reason");	
	}
}
