package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanCodePage extends MobileFunctions {

	private By btnFlashLight = MobileBy.xpath("//*[contains(@resource-id,'toglebtn')]");
	private By btnAlbum = MobileBy.xpath("//*[contains(@resource-id,'albumIV')]");

	public void clickFlashLight() {
		click(btnFlashLight, "FlashLight");
	}
	public void clickOnAlbum() {
		click(btnAlbum, "Album");

	}
	
	public void verifyScanCode() {
		new CommonFunctions().elementView(btnFlashLight, "Scan Code");
		new CommonFunctions().elementView(btnAlbum, "Album");
	}
}
