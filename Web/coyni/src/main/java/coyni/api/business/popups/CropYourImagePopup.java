package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.utilities.FileHelper;

public class CropYourImagePopup extends BrowserFunctions {
	private By heading = By.cssSelector(".UserDetails_container__50Pke>h1");
	private By btnSelectImage = By.cssSelector(".mb-20");
	private By btnSave = By.cssSelector(".UserDetails_container__50Pke>div>button");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
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
