package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class NewProfileImagePopup extends BrowserFunctions {
	
	private By btnSave = By.cssSelector("");
	
	public void clickonsave() {
		click(btnSave, "Succesfully saved");
		
	}

}
