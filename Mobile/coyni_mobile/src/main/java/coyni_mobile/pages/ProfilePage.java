package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ProfilePage extends MobileFunctions {

	/***
	 * 
	 */
	private By lblProfile = MobileBy.AccessibilityId("");
	private By btnEditUserImage = MobileBy.AccessibilityId("edit");
	private By lblName = MobileBy.AccessibilityId("");
	private By lblUserName = MobileBy.AccessibilityId("");
	private By lblEmail = MobileBy.AccessibilityId("");
	private By lblExistEmail = MobileBy.AccessibilityId("");
	private By lblPhoneNumber = MobileBy.AccessibilityId("");
	private By lblExistPhonenumber = MobileBy.AccessibilityId("");
	private By lblAddress = MobileBy.AccessibilityId("");
	private By lblExistAddress = MobileBy.AccessibilityId("");
	private By lnkEditEmail = MobileBy.AccessibilityId("");
	private By lnkEditPhoneNumber = MobileBy.AccessibilityId("");
	private By lnkEditAddress = MobileBy.AccessibilityId("");
	private By btnChange = MobileBy.AccessibilityId("");
	
	public void clickChange() {
		if(getElement(btnChange, "Change").isEnabled()) {
			click(btnChange, "Change");
		}
	}
	
	public void verifyProfileView(String heading) {
		new CommonFunctions().verifyLabelText(lblProfile, "heading", heading);
	}
	public void clickEditUserImage() {
		click(btnEditUserImage, "Edit User Image");
	}
	public void verifyUserNameView(String userName) {
		new CommonFunctions().elementView(lblName, "Name");
		new CommonFunctions().verifyLabelText(lblUserName, "userName", userName);
	}
	public void verifyEmailview(String email) {
		new CommonFunctions().elementView(lblEmail, "email");
		new CommonFunctions().verifyLabelText(lblExistEmail, "email", email);
	}
	public void verifyPhoneNumberView(String PhoneNumber) {
		new CommonFunctions().elementView(lblPhoneNumber, "PhoneNumber");
		new CommonFunctions().verifyLabelText(lblExistPhonenumber, "PhoneNumber", PhoneNumber);
	}
	public void verifyAddressView(String address) {
		new CommonFunctions().elementView(lblAddress, "Address");
		new CommonFunctions().verifyLabelText(lblExistAddress, "address", address);
	}
	
	
	public void clickEditEmail() {
		click(lnkEditEmail, "Edit Email");
	}

	public void clickEditPhoneNumber() {
		click(lnkEditPhoneNumber, "Edit Phone Number");
	}
	public void clickEditAddress() {
		click(lnkEditAddress, "click Edit Address");
	}

	
	public EditProfilePage editProfilePage() {
		return new EditProfilePage();
	}
	
	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
	public NavigationComponent navigationComponent() {
	return new NavigationComponent();	
	}

	
	
	
}
