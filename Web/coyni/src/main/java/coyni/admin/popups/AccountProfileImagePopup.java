package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.admin.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountProfileImagePopup extends BrowserFunctions {
	
	private By btnUploadNewImage = By.xpath("//button[contains(text(),'Upload New Image')]");
	private By headingAccountProfileImage = By.xpath("//h1[contains(text(),'Account Profile Image')]");
	
	public void uploadNewImage() {
		click(btnUploadNewImage,"Upload New Image");
	}
     
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	
	public CropYourImagePopup cropYourImagePopup() {
		return new CropYourImagePopup();
	}
	
	public void verifyAccountProfileImageHeading() {
		new CommonFunctions().elementView(headingAccountProfileImage, "Account Profile Image");
	}

}
