package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChooseFromLibraryComponent;
import coyni_mobile.components.EditProfileComponent;
import coyni_mobile.components.EnterYourPINComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class UserDetailsPage extends MobileFunctions {

	private By btnEditUserImage = MobileBy.xpath("");
	private By lnkEditEmail = MobileBy.xpath("");
	private By lnkEditPhoneNumber = MobileBy.xpath("");
	private By lnkEditAddress = MobileBy.xpath("");

	public void clickEditUserImage() {
		click(btnEditUserImage, "click Edit User Image");
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

	public ChooseFromLibraryComponent chooseFromLibraryComponent() {
		return new ChooseFromLibraryComponent();
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

}
