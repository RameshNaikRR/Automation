package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class AddExternalBankAccountPopup extends BrowserFunctions {
	
	private By btnIamReady = By.cssSelector("");
	
	public void clickOnIamReady() {
		click(btnIamReady, "click IamReady");
	}
	

}
