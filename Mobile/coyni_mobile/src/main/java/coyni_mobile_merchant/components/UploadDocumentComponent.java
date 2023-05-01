package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class UploadDocumentComponent extends MobileFunctions {

	private By lnkTakePhoto = MobileBy
			.xpath("//*[contains(@resource-id,'tvTakePhoto')]|//*[contains(@resource-id,'takePhotoTV')]");
	private By lnkBrowseFiles = MobileBy.xpath("//*[contains(@resource-id,'browseFileTV')]");
	private By lnkLibrary = MobileBy.xpath("//*[contains(@resource-id,'libraryTV')]");
	private By btnCapture = MobileBy.xpath("//*[contains(@resource-id,'capture_image_button')]");
	private By btnSelectFile = MobileBy.xpath("//*[contains(@resource-id,'icon_thumb')]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'saveLL')]");
	private By btnUsingApp = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_foreground_only_button')]");
	private By btnAllow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
//	private By btnU = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_foreground_only_button')]");
	private By btn = MobileBy.xpath("(//*[contains(@resource-id,'thumbnail')])[1]");

	public void clickTakePhoto() {
		click(lnkTakePhoto, "Take a Photo");
	}

	public void clickBrowseFiles() {
		click(lnkBrowseFiles, "Browse Files");
	}

	public void clicklnkLibrary() {
		click(lnkLibrary, "Choose From Library");
	}

	public void clickCapture() {
		click(btnCapture, "Capture Image");
	}

	public void clickSelectFile() {
		click(btnSelectFile, "Select File through browse files");
	}

	public void uploadTakePhoto() {
		clickTakePhoto();
		clickCapture();
		clickSave();
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void clickUsingApp() {
		click(btnUsingApp, "Using App");
	}

	public int verifyUsingApp() throws InterruptedException {
		Thread.sleep(2000);
		return DriverFactory.getDriver().findElements(btnUsingApp).size();
	}

	public int verifyAllow() throws InterruptedException {
		Thread.sleep(2000);
		return DriverFactory.getDriver().findElements(btnAllow).size();
	}

	public void clickAllow() {
		click(btnAllow, "Allow");
	}

	public void clickFile() {
		click(btn, "file");
	}
}
