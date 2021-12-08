package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountProfileImagePopup extends BrowserFunctions {

	private By heading = By.cssSelector("");
	private By lnkRemoveImage = By.cssSelector("");
	private By btnUploadNewImage = By.cssSelector("");

	public void clickRemovelink() {
		click(lnkRemoveImage, "imageremoved");
	}

	public void uploadNewImage() {
		click(btnUploadNewImage, "Succesfully uploaded new image");

	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public void verifyRemoveImageView() {
		new CommonFunctions().elementView(lnkRemoveImage, "Remove Image");
	}

	public void verifyUploadImageView() {
		new CommonFunctions().elementView(btnUploadNewImage, "Upload New Image");
	}

//	public NavigationComponent navigationComponent() {
//		return new NavigationComponent();
//	}
}
