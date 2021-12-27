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

	private By heading =MobileBy.xpath("//*[@name='User Details']");
	private By btnEditUserImage = MobileBy.xpath("//*[@name='edit']");
	
	private By lnkEditEmail = MobileBy.xpath("//*[@name='Email']/following-sibling::*[@name='arrow right']");
	private By lblEmailTitle =MobileBy.xpath("//*[@name='Email']");
	private By lblExistingEmail =MobileBy.xpath("//*[@name='Email']/preceding-sibling::XCUIElementTypeStaticText");
	private By lnkEditPhoneNumber = MobileBy.xpath("//*[@name='Phone Number']/following-sibling::*[@name='arrow right']");
	private By lblAddressTitle =MobileBy.xpath("//*[@name='Address']");
	private By lblExistingAddress =MobileBy.xpath("//*[@name='Address']/preceding-sibling::XCUIElementTypeStaticText");
	private By lnkEditAddress = MobileBy.xpath("//*[@name='Address']/following-sibling::*[@name='arrow right']");
	private By lblPhoneNumberTitle =MobileBy.xpath("//*[@name='Phone Number']");
	private By lblExistingPhonenumber =MobileBy.xpath("//*[@name='Phone Number']/preceding-sibling::XCUIElementTypeStaticText");
	

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
