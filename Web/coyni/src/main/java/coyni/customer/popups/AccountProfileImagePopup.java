package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class AccountProfileImagePopup extends BrowserFunctions{

	
	private By lnkRemoveImage = By.cssSelector("");
	private By btnUploadNewImage = By.cssSelector("");
	
	public void clickonremovelink() {
	 click(lnkRemoveImage, "imageremoved");
    }
	
    public void uploadNewImage() {
    	click(btnUploadNewImage, "Succesfully uploaded new image");
    	
    }
  }

