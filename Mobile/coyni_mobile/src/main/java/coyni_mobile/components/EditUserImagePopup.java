package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditUserImagePopup  extends MobileFunctions{

	private By lnkChooseFromLibrary =MobileBy.xpath("//*[contains(@resource-id,'chooseLL')]");
	private By lnkTakeAPhoto =MobileBy.xpath("//*[contains(@resource-id,'PhotoLL')]");
	private By btnCancel =MobileBy.xpath("//*[contains(@resource-id,'action_cancel')]");
	public void clickChooseFromLibrary() {
		click(lnkChooseFromLibrary, "Click Choose From Library");
		click(btnCancel, "Cancel");
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
