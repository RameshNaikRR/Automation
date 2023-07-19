package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanPage extends MobileFunctions {

	private By btnScanCode = MobileBy.xpath("");
	private By btnScanMe = MobileBy.xpath("");
	private By btnWhileUsingApp = MobileBy
			.xpath("//*[contains(@resource-id,'permission_allow_foreground_only_button')]");
	private By btnOnlyOneTime = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_one_time_button')]");
	private By btnDeny = MobileBy.xpath("//*[contains(@resource-id,'permission_deny_button')]");
	private By btnFlashLight = MobileBy.id("com.coyni.mapp:id/toglebtn");
	private By btnAlbum = MobileBy.id("com.coyni.mapp:id/albumIV");
	private By btnAllow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	private By lblInvalidQRCode = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'tvAction')]");
	private By lblSelectPhoto = MobileBy.id("com.google.android.apps.photos:id/image");
	private By btnPhoto = MobileBy.xpath("//*[contains(@resource-id,'gl_root_view')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'action_cancel')]");
	private By chooseImage = MobileBy
			.xpath("//*[@text='Today']/../../following-sibling::*[1]|//*[@text='Today']/../following-sibling::*[1]");
	private By selectImage = MobileBy.xpath("//*[@text='Pictures']");

	public void clickScanCode() {
		click(btnScanCode, "ScanCode");
	}

	public void clickScanMe() {
		click(btnScanMe, "ScanMe");
	}

	public void clickOnWhileUsingApp() throws InterruptedException {
		Thread.sleep(1000);
		if (getElementList(btnWhileUsingApp, "While Using App").size() > 0) {
			click(btnWhileUsingApp, "While Using App");
		}
	}

	public void clickOnlyOneTime() {
		click(btnOnlyOneTime, "only One Time");
	}

	public void clickDeny() {
		click(btnDeny, "Deny");
	}

	public void verifyScanCodeAndScanMe() {
		new CommonFunctions().elementView(btnScanCode, "Scan Code");
		new CommonFunctions().elementView(btnScanMe, "Scan Me");
	}

	public void clickFlashLight() {
		click(btnFlashLight, "FlashLight");
	}

	public void clickOnCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickOnAlbum() {
		click(btnAlbum, "Album");
	}

	public void clickAllow() throws InterruptedException {
		Thread.sleep(1000);
		if (getElementList(btnAllow, "Allow").size() > 0) {
			click(btnAllow, "Allow");
		}
	}

	public void clickPhoto() {
		click(chooseImage, "Photo");
	}

	public void clickPhotoFolder() {
		click(selectImage, "Photos Folder");
	}

	public void verifySelectPhoto() {
		new CommonFunctions().elementView(lblSelectPhoto, "Select photo");
//		new CommonFunctions().verifyLabelText(lblSelectPhoto, expStatus, "Select photo");
	}

	public void verifyScanCode() {
		new CommonFunctions().elementView(btnFlashLight, "Scan Code");
		new CommonFunctions().elementView(btnAlbum, "Album");
	}

	public void clickOk() {
		if (verifyElementDisplayed(lblInvalidQRCode, "Invalid QR Code")) {
			click(btnOk, "ok");
		}
	}
}
