package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.customer.popups.AccountProfileImagePopup;
import coyni.customer.popups.EditEmailAddressPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class UserDetailsComponent extends BrowserFunctions {

	private By lblHeading =By.cssSelector(".text-base.text-cgy4");
	private By editUserImage = By.cssSelector(".w-4");
	private By editUserImgToolTip =By.xpath("//img[@class='w-4 h-4']/../following-sibling::*[1]");
	private By lnkRemoveImage = By.cssSelector("");
	private By btnRemove = By.cssSelector("");
	private By btnUploadNewImage = By.cssSelector("");
	private By btnSave = By.cssSelector("");
	private By lblUserName = By.xpath("//span[@class='text-2xl font-bold text-cgy8']");
	private By lblAccountStatus = By.xpath("//div[@class='flex flex-row text-md text-cgy4']");
	private By lblEmail = By.cssSelector(".UserDetails_email_address__3EjH8");
	private By lblAddress = By.cssSelector("");
	private By lnkEditAccountEmail = By.xpath("//div[text()='Edit Account Email']");
	private By lnkEditAccountPhNum = By.xpath("//div[text()='Edit Account Phone']");
	private By lnkEditAccountAddress = By.xpath("//div[text()='Edit Account Address']");
	private By iconEditEmail = By.cssSelector(".UserDetails_edit_email_icon__2RuvO");
	private By iconEditPhNum = By.xpath("//div[@id='t8d39f6c8-bba6-4463-a16b-daa4a2d0975d']");
	private By iconEditAddress = By.xpath("//div[@id='t14bec415-7d33-4847-85c6-9e08e7b12434']");
	private By userImg = By.xpath("//div[contains(@class,'flex flex-row')]//div[contains(@class,'bg-cm3')] \" ");
	private By accountId = By.xpath("//span[@class='mt-1 text-xs text-cgy2'] ");
	private By lblPhoneNum = By.xpath("//h3[@class='text-cgy4 tracking-wide Heading_heading3__3l6XX font-semibold leading-3 tracking-tightest UserDetails_phoneNumber__borc2'] ");
	private By lblEmailAuth = By.xpath("//div[@class='mt-4']");
	private By lblEmailAddress = By.xpath("//h1[text()='Edit Email Address']");
	private By lblAccountAddress = By.xpath("//div[contains(@class,'UserDetails_address__2XyBR UserDetails_city_field__2olcd')] ");

	public void verifyUserDetailsView() {
		new CommonFunctions().elementView(lblHeading, "User Details Screen ");
	}
	public void verifyEditImageView() {
		new CommonFunctions().elementView(editUserImage, "Edit User Img icon");
		new CommonFunctions().verifyCursorAction(editUserImage, "Edit User Img icon");
	}

	public void verifyEditImageToolTip(String expToolTip) {
		new CommonFunctions().verifyCursorAction(editUserImgToolTip, "Edit User Img");	
	//	moveToElement(editUserImgToolTip, "Edit User Img");
		new CommonFunctions().verifyLabelText(editUserImgToolTip, "Edit User Img", expToolTip);
		
	}
	public void verifyUserNameView() {
		new CommonFunctions().elementView(lblUserName, "UserName");
	}

	public void verifyAccountIdView() {
		new CommonFunctions().elementView(accountId, "accountId");
	}

	public void verifyAccountStatusView() {
		new CommonFunctions().elementView(lblAccountStatus, "accountStatus");
	}

	public void verifyPhoneNumView() {
		new CommonFunctions().elementView(lblPhoneNum, "PhoneNum");
	}

	public void verifyEmailAddressView() {
		new CommonFunctions().elementView(lblEmailAddress, "EmailAddress");
	}

	public void verifyAccountAddressView() {
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
	public void verifyEditEmailAddress(String expheading) {
		new CommonFunctions().verifyLabelText(lblEmailAddress, "Edit Email Address PopUp Heading", expheading);
	}
	public void verifyEditEmailAddressAuthentication(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmailAuth, "Edit Email Address Authentication PopUp Heading", expHeading);
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
	public EditEmailAddressPopup editEmailAddressPopup() {
		return new EditEmailAddressPopup();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
	
}
