package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.utilities.FileHelper;

public class CropYourImagePopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[contains(text(),'Crop Your Image')]");
	private By btnSelectImage = By.xpath("//p[contains(text(),'Click to select Image')]");
	private By btnSave = By.xpath("//button[contains(text(),'Save')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	private By getUploadDocumentElement() {
		return By.xpath(String.format("//*[contains(@class,'font-bold text-cwhite')]/../input"));
	}

	public void uploadSelectImage(String folderName, String fileName) {
		getElement(getUploadDocumentElement(), "select Image").sendKeys(FileHelper.getFilePath(folderName, fileName));
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void verifySelectImageView() {
		new CommonFunctions().elementView(btnSelectImage, "Select Image");
	}

	public void verifySaveView() {
		new CommonFunctions().elementView(btnSave, "Save");
		new CommonFunctions().verifyCursorAction(btnSave, "Save");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
