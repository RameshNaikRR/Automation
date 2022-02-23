package coyni.admin.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class AccountProfileImagePopup extends BrowserFunctions {
	
	private By btnUploadNewImage = By.xpath("");
	
	public void uploadNewImage() {
		click(btnUploadNewImage,"Upload New Image");
	}
	
	public CropYourImagePopup cropYourImagePopup() {
		return new CropYourImagePopup();
	}

}
