package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountProfileImagePopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[text()='Account Profile Image']");
	private By lnkRemoveImage = By.xpath("//span[text()='Remove Image']");
	private By btnUploadNewImage = By.xpath("//button[text()='Upload New Image']");

	public void clickRemove() {
		click(lnkRemoveImage, "Remove image");
	}

	public void clickUploadNewImage() {
		click(btnUploadNewImage, "Upload New Image");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public void verifyRemoveImageView() {
		new CommonFunctions().elementView(lnkRemoveImage, "Remove Image");
		new CommonFunctions().verifyCursorAction(lnkRemoveImage, "Remove Image");
	}

	public void verifyUploadImageView() {
		new CommonFunctions().elementView(btnUploadNewImage, "Upload New Image");
		new CommonFunctions().verifyCursorAction(btnUploadNewImage, "Upload New Image");
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
}
