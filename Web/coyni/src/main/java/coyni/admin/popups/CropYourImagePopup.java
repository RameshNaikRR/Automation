package coyni.admin.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class CropYourImagePopup extends BrowserFunctions {

	private By btnSelectImage = By.xpath("");
	
	public void clickSelectYourImage() {
		click(btnSelectImage,"Select Your Image");
	}
	
}
