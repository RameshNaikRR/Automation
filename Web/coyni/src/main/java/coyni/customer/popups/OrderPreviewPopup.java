package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class OrderPreviewPopup extends BrowserFunctions {
	
	private By btnConfirm = By.cssSelector("");
	
	public void clickOnConfirm() {
		click(btnConfirm, "Click Confirm");
	}

}
