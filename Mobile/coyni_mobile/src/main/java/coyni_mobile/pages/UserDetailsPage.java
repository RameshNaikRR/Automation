package coyni_mobile.pages;

import org.openqa.selenium.By;


import coyni_mobile.components.ChooseFromLibraryPopup;
import coyni_mobile.components.EditProfileComponent;
import coyni_mobile.components.EditUserImagePopup;
import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class UserDetailsPage extends MobileFunctions {

	private By heading =MobileBy.xpath("");
	private By btnEditUserImage = MobileBy.xpath("");
	
	private By lnkEditEmail = MobileBy.xpath("");
	private By lblEmailTitle =MobileBy.xpath("");
	private By lblExistingEmail =MobileBy.xpath("");
	private By lnkEditPhoneNumber = MobileBy.xpath("");
	private By lblAddressTitle =MobileBy.xpath("");
	private By lblExistingAddress =MobileBy.xpath("");
	private By lnkEditAddress = MobileBy.xpath("");
	private By lblPhoneNumberTitle =MobileBy.xpath("");
	private By lblExistingPhonenumber =MobileBy.xpath("");
	

	public void verifyPhoneNumberTitleView() {
		new CommonFunctions().elementView(lblPhoneNumberTitle, "PhoneNumber Title");
	}
	public void verifyExistingPhoneNumberView() {
		new CommonFunctions().elementView(lblExistingPhonenumber, "Existing PhoneNumber");
	}
	public void verifyEditPhoneNumberArrowView() {
		new CommonFunctions().elementView(lnkEditPhoneNumber, "Edit PhoneNumber Arrow");
	}
	
	
	
	public void verifyEmailTitleView() {
		new CommonFunctions().elementView(lblEmailTitle, "Email Title");
	}
	public void verifyExistingEmailView() {
		new CommonFunctions().elementView(lblExistingEmail, "Existing Email");
	}
	public void verifyEditEmailArrowView() {
		new CommonFunctions().elementView(lnkEditEmail, "Edit Email Arrow");
	}
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
	}
	public void verifyUserDetailsPageview() {
		new CommonFunctions().elementView(heading, "User Details Page");
	}
	public void verifyEditUserImageView() {
		new CommonFunctions().elementView(btnEditUserImage, "Edit Image");
	}
	public void clickEditUserImage() {
		click(btnEditUserImage, "click Edit User Image");
	}
	

	public void clickEditEmail() {
		click(lnkEditEmail, "click Edit Email");
	}

	public void clickEditPhoneNumber() {
		click(lnkEditPhoneNumber, "click Edit Phone Number");
	}

	public void verifyAddressTitleView() {
		new CommonFunctions().elementView(lblAddressTitle, "Address Title");
	}
	public void verifyExistingAddressView() {
		new CommonFunctions().elementView(lblExistingAddress, "Existing Address");
	}
	public void verifyEditAddressArrowView() {
		new CommonFunctions().elementView(lnkEditAddress, "Edit Address Arrow");
	}
	public void clickEditAddress() {
		click(lnkEditAddress, "click Edit Address");
	}

	public EditProfileComponent editProfileComponent() {
		return new EditProfileComponent();
	}



	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public NavigationComponent navigationComponent() {
	return new NavigationComponent();	
	}
	
	public EditUserImagePopup editUserImagePopup() {
		return new EditUserImagePopup();
	}
	
}
