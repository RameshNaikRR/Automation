package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountProfileImagePopup extends BrowserFunctions {

	private By heading = By.cssSelector(".UserDetails_container__50Pke>h1");
	private By lnkRemoveImage = By.cssSelector(".UserDetails_container__50Pke>div:first-of-type>span");
	private By btnUploadNewImage = By.cssSelector(".UserDetails_container__50Pke>div:nth-of-type(2)>button");

	public void clickRemove() {
		click(lnkRemoveImage, "Remove image");
		new CommonFunctions().verifyCursorAction(lnkRemoveImage, "Remove image");
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
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	public RemoveProfileImagePopup removeProfileImagePopup() {
		return new RemoveProfileImagePopup();
	}

}
