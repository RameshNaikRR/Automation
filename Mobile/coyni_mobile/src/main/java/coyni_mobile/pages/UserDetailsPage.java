package coyni_mobile.pages;

import org.openqa.selenium.By;


import coyni_mobile.components.ChooseFromLibraryPopup;
import coyni_mobile.components.EditProfileComponent;
import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class UserDetailsPage extends MobileFunctions {

	private By heading =MobileBy.xpath("");
	private By btnEditUserImage = MobileBy.xpath("");
	private By lnkChooseFromLibrary =MobileBy.xpath("");
	private By lnkTakeAPhoto =MobileBy.xpath("");
	private By lnkEditEmail = MobileBy.xpath("");
	private By lnkEditPhoneNumber = MobileBy.xpath("");
	private By lnkEditAddress = MobileBy.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
	}
	public void verifyEditUserImageView() {
		new CommonFunctions().elementView(btnEditUserImage, "Edit Image");
	}
	public void clickEditUserImage() {
		click(btnEditUserImage, "click Edit User Image");
	}
	public void clickChooseFromLibrary() {
		click(lnkChooseFromLibrary, "Click Choose From Library");
	}
	public void clickTakeAphoto() {
		click(lnkTakeAPhoto, "Click Take A Photo");
	}
	public void verifyChooseFromLibraryView() {
		new CommonFunctions().elementView(lnkChooseFromLibrary, "Choose From Library");
	}
	public void verifyTakeAPhoto() {
		new CommonFunctions().elementView(lnkTakeAPhoto	,"Take A Photo" );
	}

	public void clickEditEmail() {
		click(lnkEditEmail, "click Edit Email");
	}

	public void clickEditPhoneNumber() {
		click(lnkEditPhoneNumber, "click Edit Phone Number");
	}

	public void clickEditAddress() {
		click(lnkEditAddress, "click Edit Address");
	}

	public EditProfileComponent editProfileComponent() {
		return new EditProfileComponent();
	}

	public ChooseFromLibraryPopup chooseFromLibraryPopup() {
		return new ChooseFromLibraryPopup();
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public NavigationComponent navigationComponent() {
	return new NavigationComponent();	
	}
	
}
