package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.customer.popups.AccountProfileImagePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class UserDetailsComponent extends BrowserFunctions {

	private By editUserImage = By.cssSelector("");
	private By editUserImgToolTip =By.cssSelector("");
	private By lnkRemoveImage = By.cssSelector("");
	private By btnRemove = By.cssSelector("");
	private By btnUploadNewImage = By.cssSelector("");
	private By btnSave = By.cssSelector("");
	private By lblUserName = By.cssSelector("");
	private By lblAccountStatus = By.cssSelector("");
	private By lblEmail = By.cssSelector("");
	private By lblAddress = By.cssSelector("");
	private By lnkEditAccountEmail = By.cssSelector("");
	private By lnkEditAccountPhNum = By.cssSelector("");
	private By lnkEditAccountAddress = By.cssSelector("");
	private By iconEditEmail = By.cssSelector("");
	private By iconEditPhNum = By.cssSelector("");
	private By iconEditAddress = By.cssSelector("");
	private By userImg = By.cssSelector(" ");
	private By accountId = By.cssSelector(" ");
	private By lblPhoneNum = By.cssSelector(" ");
	private By lblEmailAddress = By.cssSelector("");
	private By lblAccountAddress = By.cssSelector(" ");

	public void verifyEditImageView() {
		new CommonFunctions().elementView(editUserImage, "UserImg");
	}

	public void verifyEditImageToolTip(String expToolTip) {
		new CommonFunctions().verifyCursorAction(editUserImage, "Edit User Img");	
		new CommonFunctions().verifyLabelText(editUserImgToolTip, "Edit User Img", expToolTip);
		
	}
	public void verifyViewUserName() {
		new CommonFunctions().elementView(lblUserName, "UserName");
	}

	public void verifyviewAccountId() {
		new CommonFunctions().elementView(accountId, "accountId");
	}

	public void verifyViewAccountStatus() {
		new CommonFunctions().elementView(lblAccountStatus, "accountStatus");
	}

	public void verifyViewPhoneNum() {
		new CommonFunctions().elementView(lblPhoneNum, "PhoneNum");
	}

	public void verifyViewEmailAddress() {
		new CommonFunctions().elementView(lblEmailAddress, "EmailAddress");
	}

	public void verifyViewAccountAddress() {
		new CommonFunctions().elementView(lblAccountAddress, "AccountAddress");
	}

	public void clickEditUserImage() {
		click(editUserImage, "Edit User Image");
	}

	public void clickRemoveImage() {
		click(lnkRemoveImage, "Remove Image");
	}

	public void clickRemove() {
		click(btnRemove, "Remove Button");
	}

	public void clickUploadNewImage() {
		click(btnUploadNewImage, "Upload New Image Button");
	}

	public void clickSave() {
		click(btnSave, "Save Button");
	}

	public void verifyUserName(String expUserName) {
		new CommonFunctions().verifyLabelText(lblUserName, "UserName", expUserName);
	}

	public void verifyAccountStatus(String expAccountStatus) {
		new CommonFunctions().verifyLabelText(lblAccountStatus, "Account Status", expAccountStatus);
	}

	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "Email", expEmail);
	}

	public void verifyAddress(String expAddress) {
		new CommonFunctions().verifyLabelText(lblAddress, "Address", expAddress);
	}

	public void clickEditAccountEmail() {
		click(lnkEditAccountEmail, "Click Edit Email");
	}

	public void clickEditAccountPhNumber() {
		click(lnkEditAccountPhNum, "Click Edit PhoneNumber");
	}

	public void clickEditAccountAddress() {
		click(lnkEditAccountAddress, "Click Edit Address");
	}

	public void clickIconEditEmail() {
		click(iconEditEmail, "Click Edit Email Icon");
	}

	public void clickIconEditPhNum() {
		click(iconEditPhNum, "Click Edit Phone Icon");
	}

	public void clickIconEditAddress() {
		click(iconEditAddress, "Click Edit Address Icon");
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public NotificationsComponent notificationsComponent() {
		return new NotificationsComponent();
	}

	public AccountProfileImagePopup accountProfileImagePopup() {
		return new AccountProfileImagePopup();
	}
}
