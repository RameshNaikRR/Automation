package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditProfileComponent extends MobileFunctions {
	
	private By lnkChooseFromLibrary =MobileBy.xpath("");
	private By lnkTakeAPhoto = MobileBy.xpath("");

	public void clickChooseFromLibrary() {
		click(lnkChooseFromLibrary, "click Choose From Library");
	}
	public void clickTakeAPhoto() {
		click(lnkTakeAPhoto, "click Take a photo");
	}




}
