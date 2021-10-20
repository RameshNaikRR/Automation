package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class AddExternalBankAccountPopup extends BrowserFunctions {
	
	private By btnIamReady = By.cssSelector("");
	private By lnkLearnMore = By.cssSelector(" ");
	private By btnBack = By.cssSelector(" ");
	
	public void clickIamReady() {
		click(btnIamReady, "click IamReady");
	}
	public void clickLearnMore() {
		 click(lnkLearnMore, "Learm More");
	}
	public void clickBack() {
		click(btnBack, "Back");
	}
	

}
