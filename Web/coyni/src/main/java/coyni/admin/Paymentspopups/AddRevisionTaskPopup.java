package coyni.admin.Paymentspopups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddRevisionTaskPopup extends BrowserFunctions {
	
	private By heading = By.xpath("//h3[text()='Add Revision Task']");
	private By txtOldCompanyName = By.xpath("//input[@id='oldValue']");
	private By txtEnterCompanyName = By.xpath("//input[@id='editValue']");
	private By txtMessager = By.xpath("(//textarea[@name='message'])[2]");
	private By btnAdd = By.xpath("//button[text()='Add']");
	private By txtOldWebsite = By.xpath("//input[@id='oldValue']");
	private By txtEnterNewWebsite = By.xpath("//input[@id='editValue']");

	
	
	public void clickAdd() {
		click(btnAdd, "Add Button");
	}
	
	public void verifyHeading(String expHeading) {
		String str = getText(heading, "Heading");
		if(str.equals(expHeading)) {
			ExtentTestManager.setPassMessageInReport("The Heading is matched " + str);
		}
	}
	
	public void verifyOldWebsite() {
		String str = getText(txtOldWebsite, "Old Website");
		ExtentTestManager.setPassMessageInReport("The Old Website " + str);
	}
	
	public void enterWebsite(String newWebsite) {
		enterText(txtEnterNewWebsite, newWebsite, "New Website");
	}

	
	public void verofyOldCompanyName() {
		String str = getText(txtOldCompanyName, "Old Compnany Name");
		ExtentTestManager.setPassMessageInReport("The Old Compnany Name is " + str);
	}
	
	public void enterCompanyName(String newNUmber) {
		enterText(txtEnterCompanyName, newNUmber, "New Company");
	}
	
	public void enterMessage(String message) {
		enterText(txtMessager, message, "Message");
	}
			

}
