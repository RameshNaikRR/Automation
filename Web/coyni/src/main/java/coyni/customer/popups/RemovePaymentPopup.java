package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class RemovePaymentPopup extends BrowserFunctions {
	
	private By lblErrorMessage = By.cssSelector("");
	private By btnRemove = By.cssSelector("");
	
	public String getErrorMessage() {
		return getText(lblErrorMessage, "Error Message");
	}
	
	public void clickOnRemove() {
		click(btnRemove, "Click Remove");
	}
}
