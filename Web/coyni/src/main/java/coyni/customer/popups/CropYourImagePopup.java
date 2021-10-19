package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class CropYourImagePopup extends BrowserFunctions{
	
	private By btnSave = By.cssSelector("");
	
	public void clickOnSave() {
		click(btnSave, "Image cropped" );
	}

}
