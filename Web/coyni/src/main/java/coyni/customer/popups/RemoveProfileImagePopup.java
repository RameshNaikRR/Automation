package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class RemoveProfileImagePopup extends BrowserFunctions{
	
	private By btnRemoveImage     = By.cssSelector("");
	
	public void clickOnRemoveImage() {
		click(btnRemoveImage, "Click RemoveImage");
	}

}
