package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanCodePage extends MobileFunctions {

	private By btnFlashLight = MobileBy.xpath("//*[contains(@resource-id,'toglebtn')]");
	private By btnAlbum = MobileBy.xpath("//*[contains(@resource-id,'albumIV')]");
	private By btnAllow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	private By btnDeny = MobileBy.xpath("//*[contains(@resource-id,'permission_deny_button')]");
	private By lblInvalidQRCode = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'tvAction')]");
	private By lblSelectPhoto = MobileBy.xpath("//*[contains(@resource-id,'action_bar_title')]");
	private By btnPhoto = MobileBy.xpath("//*[contains(@resource-id,'gl_root_view')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'action_cancel')]");

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
		click(btnAllow, "Allow");

	}

	public void clickPhoto() {
		click(btnPhoto, "Photo");
	}

	public void verifySelectPhoto(String expStatus) {
		new CommonFunctions().verifyLabelText(lblSelectPhoto, expStatus, "Select photo");
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
}
