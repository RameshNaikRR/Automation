package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EditProfileComponent extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'action_bar_title')]");
	private By btnEditProfile = MobileBy.xpath("//*[contains(@resource-id,'dba_editProfileIV')]");
	private By lnkChooseFromLibrary = MobileBy.xpath("//*[contains(@text,'Library')]");
	private By lnkTakeAPhoto = MobileBy.xpath("//*[contains(@text,'Photo')]");
	private By lnkCancel=MobileBy.xpath("//*[contains(@resource-id,'action_cancel')]");
	private By btnSelectPictures=MobileBy.xpath("//*[contains(@resource-id,'gallery_root')]");
	private By btnSelectPicture=MobileBy.xpath("//*[contains(@resource-id,'gl_root_view')]");
	private By btnRotate=MobileBy.xpath("//*[contains(@resource-id,'rotate')]");
	private By btnCrop=MobileBy.xpath("//*[contains(@resource-id,'crop_image_menu_crop')]");
	private By btnFlip=MobileBy.xpath("//*[contains(@resource-id,'flip')]");
	private By lnkHorizontalFlip=MobileBy.xpath("(//*[contains(@resource-id,'title')])[1]");
	private By lnkVerticalFlip=MobileBy.xpath("(//*[contains(@resource-id,'title')])[2]");
	private By btnCamera=MobileBy.xpath("//*[contains(@resource-id,'shutter_button')]");
	private By btnYes=MobileBy.xpath("//*[contains(@resource-id,'done_button')]");
	private By btnNo=MobileBy.xpath("//*[contains(@resource-id,'cancel_button')]");
	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Choose form Library Heading", expHeading);
	}
	public void clickEditProfile() {
		click(btnEditProfile, "Edit Profile");
	}
	public void clickChoosefromLibrary() {
		click(lnkChooseFromLibrary, "Profile Choose from Library");
	}
	public void clickTakeAPhoto() {
		click(lnkTakeAPhoto, "Take A Photo");
	}
	public void clickCancel() {
		click(lnkCancel, "Cancel");
	}
	public void clickSelectPictures() {
		click(btnSelectPictures, "Select Pictures");
	}
	public void clickSelectPicture() {
		click(btnSelectPicture, "Select Picture");
	}
	public void clickCrop() {
		click(btnCrop, "Crop");
	}
	public void clickFlip() {
		click(btnFlip, "Flip");
	}
	public void clickHorizontalFlip() {
		click(lnkHorizontalFlip, "Horizontal Flip");
	}
	public void clickVerticalFlip() {
		click(lnkVerticalFlip, "Vertical Flip");
	}
	public void clickRotate() {
		click(btnRotate, "Rotate");
	}
	public void clickCamera() {
		click(btnCamera, "Camera");
	}
	public void clickYes() {
		click(btnYes, "Yes");
	}
	public void clickNo() {
		click(btnNo, "No");
	}
}
