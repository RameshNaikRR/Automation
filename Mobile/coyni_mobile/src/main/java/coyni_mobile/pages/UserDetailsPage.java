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

	private By heading =MobileBy.xpath("//*[@text='User Details']");
	private By btnEditUserImage = MobileBy.xpath("//*[contains(@resource-id,'editProfile')]");
	private By lblEmailTitle =MobileBy.xpath("//*[@text='Email']");
	private By lblExistingEmail =MobileBy.xpath("//*[contains(@resource-id,'/userEmailIdTV')]");
	private By lnkEditEmail = MobileBy.xpath("//*[contains(@resource-id,'/userEmailIdTV')]/../following-sibling::*[1]");
	private By lblPhoneNumberTitle =MobileBy.xpath("//*[@text='Phone Number']");
	private By lblExistingPhonenumber =MobileBy.xpath("//*[contains(@resource-id,'userPhoneNumTV')]");
	private By lnkEditPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'userPhoneNumTV')]/../following-sibling::*[1]");
	private By lblAddressTitle =MobileBy.xpath("//*[@text='Address']");
	private By lblExistingAddress =MobileBy.xpath("//*[contains(@resource-id,'userAddressTV')]");
	private By lnkEditAddress = MobileBy.xpath("//*[contains(@resource-id,'/userAddressTV')]/../following-sibling::*[1]");
	
	private By btnAlert =MobileBy.xpath("//*[contains(@resource-id,'allow_one_time_button')]");
    private By btnAllow =MobileBy.xpath("//*[contains(@resource-id,'allow_button')]");
    
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
		click(btnEditUserImage, "Edit User Image");
		click(btnAlert, "Alert Popup");
		click(btnAllow, "Allow");
	}
	

	public void clickEditEmail() {
		click(lblExistingEmail, "Edit Email");
	}

	public void clickEditPhoneNumber() {
		click(lblExistingPhonenumber, "Edit Phone Number");
	}

	public void verifyAddressTitleView() {
		new CommonFunctions().elementView(lblAddressTitle, "Address Title");
	}
	public void verifyExistingAddressView() {
		new CommonFunctions().elementView(lblExistingAddress, "Existing Address");
	}
	public void verifyAddress(String expAddress) {
		new CommonFunctions().verifyLabelText(lblExistingAddress, "Updated Address ", expAddress);
	}
	public void verifyEditAddressArrowView() {
		new CommonFunctions().elementView(lnkEditAddress, "Edit Address Arrow");
	}
	public void clickEditAddress() {
		click(lblExistingAddress, "click Edit Address");
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
