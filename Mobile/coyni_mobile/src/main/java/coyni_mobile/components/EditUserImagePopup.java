package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditUserImagePopup  extends MobileFunctions{

	private By lnkChooseFromLibrary =MobileBy.xpath("//*[@name='Choose From Library']");
	private By lnkTakeAPhoto =MobileBy.xpath("//*[@name='Take a Photo']");
	
	public void clickChooseFromLibrary() {
		click(lnkChooseFromLibrary, "Click Choose From Library");
	}
	public void clickTakeAphoto() {
		click(lnkTakeAPhoto, "Click Take A Photo");
	}
	public void verifyChooseFromLibraryView() {
		new CommonFunctions().elementView(lnkChooseFromLibrary, "Choose From Library");
	}
	public void verifyTakeAPhotoView() {
		new CommonFunctions().elementView(lnkTakeAPhoto	,"Take A Photo" );
	}
	public ChooseFromLibraryPopup chooseFromLibraryPopup() {
		return new ChooseFromLibraryPopup();
	}
}
