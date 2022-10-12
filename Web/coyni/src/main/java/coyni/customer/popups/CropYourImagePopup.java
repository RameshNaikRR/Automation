package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.utilities.FileHelper;

public class CropYourImagePopup extends BrowserFunctions {
	private By heading = By.xpath("//h1[text()='Crop Your Image']");
	private By btnSelectImage = By.xpath("//input[@type='file']");
	private By btnSave = By.xpath("//button[text()='Save']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}
	
	public void clickSelectImage() {
		click(btnSelectImage,"Select Image");
	}

	public void uploadSelectImage(String folderName,String fileName) {
		getElement(btnSelectImage, "select Image").sendKeys(FileHelper.getFilePath(folderName,fileName));
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
