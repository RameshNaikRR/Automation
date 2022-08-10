package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.utilities.FileHelper;

public class BusinessImageLogoPopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[contains(text(),'Account Profile Image')]");
	private By lnkRemoveImage = By.xpath("//span[contains(text(),'Remove Image')]");
	private By btnUploadNewImage = By.xpath("//button[contains(text(),'Upload New Image')]");

	public void clickRemove() {
		click(lnkRemoveImage, "Remove image");
	}

	private By getUploadDocumentElement() {
		return By.xpath(String.format("//*[contains(@class,'font-bold text-cwhite')]/../input"));
	}

	public void uploadSelectImage(String folderName, String fileName) {
		getElement(getUploadDocumentElement(), "select Image").sendKeys(FileHelper.getFilePath(folderName, fileName));
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
