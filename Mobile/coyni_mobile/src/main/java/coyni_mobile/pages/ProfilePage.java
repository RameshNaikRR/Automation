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
	private By lblProfile = MobileBy.id("com.coyni.mapp:id/profileTV");
	private By btnEditUserImage = MobileBy.id("com.coyni.mapp:id/editProfileIV");
	private By lblName = MobileBy.xpath("//*[@text='Name']");
	private By lblUserName = MobileBy.id("com.coyni.mapp:id/userNameTV");
	private By lblEmail = MobileBy.xpath("com.coyni.mapp:id/userEmailIdTV");
	private By lblExistEmail = MobileBy.id("");
	private By lblPhoneNumber = MobileBy.id("//*[@text='Phone Number']");
	private By lblExistPhonenumber = MobileBy.id("com.coyni.mapp:id/userPhoneNumTV");
	private By lblAddress = MobileBy.id("//*[@text='Address']");
	private By lblExistAddress = MobileBy.id("");
	private By lnkEditEmail = MobileBy.id("");
	private By lnkEditPhoneNumber = MobileBy.id("");
	private By lnkEditAddress = MobileBy.id("com.coyni.mapp:id/addressLL");
	private By btnChange = MobileBy.id("");

	public void clickChange() {
		if (getElement(btnChange, "Change").isEnabled()) {
			click(btnChange, "Change");
		}
	}

	public void verifyProfileView() {
		new CommonFunctions().elementView(lblProfile, "Profile");
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
