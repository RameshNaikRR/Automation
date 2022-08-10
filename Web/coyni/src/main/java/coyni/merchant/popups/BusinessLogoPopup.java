package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessLogoPopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[contains(text(),'Account Profile Image')]");
	private By lnkRemoveImage = By.xpath("//span[contains(text(),'Remove Image')]");
	private By btnUploadNewImage = By.xpath("//button[contains(text(),'Upload New Image')]");

	public void clickRemove() {
		click(lnkRemoveImage, "Remove image");
	}

	public void clickUploadNewImage() {
		click(btnUploadNewImage, "Upload New Image");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public RemoveProfileImagePopup removeProfileImagePopup() {
		return new RemoveProfileImagePopup();
	}

	public CropYourImagePopup cropYourImagePopup() {
		return new CropYourImagePopup();
	}

	public RemoveBusinessLogoPopup removeBusinessLogoPopup() {
		return new RemoveBusinessLogoPopup();
	}
}
