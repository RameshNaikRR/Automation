package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ProfilePage extends MobileFunctions {

	/***
	 * 
	 */
	private By lblProfile = MobileBy.AccessibilityId("");
	private By btnEditUserImage = MobileBy.AccessibilityId("edit");
	private By lblUserName = MobileBy.xpath("(//XCUIElementTypeStaticText[@name='User Name']/../XCUIElementTypeStaticText)[1]");
	private By lblEmail = MobileBy.xpath("(//XCUIElementTypeStaticText[@name='Email']/../XCUIElementTypeStaticText)[1]");
	private By lblPhoneNumber = MobileBy.xpath("(//XCUIElementTypeStaticText[@name='Phone Number']/../XCUIElementTypeStaticText)[1]");
	private By lblAddress = MobileBy.xpath("(//XCUIElementTypeStaticText[@name='Address']/../XCUIElementTypeStaticText)[1]");
	private By lnkEditEmail = MobileBy.xpath("//*[@name='Email']/preceding-sibling::*[1]");
	private By lnkEditPhoneNumber = MobileBy.xpath("//*[@name='Phone Number']/preceding-sibling::*[1]");
	private By lnkEditAddress = MobileBy.xpath("//*[@name='Address']/preceding-sibling::*[1]");
	private By btnChange = MobileBy.AccessibilityId("");
	
	public void clickChange() {
		if(getElement(btnChange, "Change").isEnabled()) {
			click(btnChange, "Change");
		}
	}
	
	public void verifyProfileView() {
		new AndroidCommonFunctions().elementView(lblProfile, "Profile");
	}
	public void clickEditUserImage() {
		click(btnEditUserImage, "Edit User Image");
	}
	public void verifyUserNameView() {
		new AndroidCommonFunctions().elementView(lblUserName, "UserName");
	}
	public void verifyEmail() {
		ExtentTestManager.setInfoMessageInReport("The email is:" + getText(lblEmail));
	}
	public void verifyPhoneNumber() {
		ExtentTestManager.setInfoMessageInReport("The Phone Number is:" + getText(lblPhoneNumber));
	}
	public void verifyAddress() {
		ExtentTestManager.setInfoMessageInReport("The Address is:" + getText(lblAddress));
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
