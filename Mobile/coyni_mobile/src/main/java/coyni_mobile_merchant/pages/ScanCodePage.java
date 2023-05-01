package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanCodePage extends MobileFunctions {

	private By btnFlashLight = MobileBy.xpath("//*[contains(@resource-id,'toglebtn')]");
	private By btnAlbum = MobileBy.id("com.coyni.mapp:id/albumIV");
	private By btnAllow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	private By btnDeny = MobileBy.xpath("//*[contains(@resource-id,'permission_deny_button')]");
	private By lblInvalidQRCode = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'tvAction')]");
	private By lblSelectPhoto = MobileBy.id("com.google.android.apps.photos:id/image");
	private By btnPhoto = MobileBy.xpath("//*[contains(@resource-id,'gl_root_view')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'action_cancel')]");

	private By chooseImage = MobileBy.xpath("//*[@text='Today']/../following-sibling::*[1]");

	public void clickFlashLight() {
		click(btnFlashLight, "FlashLight");
	}

	public void clickOnCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickOnAlbum() {
		click(btnAlbum, "Album");
	}

	public void clickAllow() {
		if (getElementList(btnAllow, "Allow").size() > 0) {
			click(btnAllow, "Allow");
		}

	}

	public void clickPhoto() {
		click(chooseImage, "Photo");
//		click(btnPhoto, "Photo");
	}

	public void verifySelectPhoto() {
		new CommonFunctions().elementView(lblSelectPhoto, "Select photo");
//		new CommonFunctions().verifyLabelText(lblSelectPhoto, expStatus, "Select photo");
	}

	public void verifyScanCode() {
		new CommonFunctions().elementView(btnFlashLight, "Scan Code");
		new CommonFunctions().elementView(btnAlbum, "Album");
	}

	public void clickDeny() {
		click(btnDeny, "Deny");

	}

	public void clickOk() {
		if (verifyElementDisplayed(lblInvalidQRCode, "Invalid QR Code")) {
			click(btnOk, "ok");
		}
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}
}
