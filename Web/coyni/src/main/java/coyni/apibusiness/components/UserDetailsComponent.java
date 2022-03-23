package coyni.apibusiness.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.customer.components.MailingAddressComponent;
import coyni.customer.components.NavigationComponent;
import coyni.customer.components.NotificationsComponent;
import coyni.customer.popups.AccountProfileImagePopup;
import coyni.customer.popups.EditEmailAddressPopup;
import coyni.customer.popups.EditPhoneNumberPopup;
import coyni.customer.popups.VerifyCurrentPhoneNumberPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class UserDetailsComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[@class='text-base text-cgy4']");
	private By lblUserName = By.xpath("//span[text()='Test API']");
	private By EditUserImgToolTip = By.xpath("//img[@data-tip='Edit Image']");
	private By lblAccountID = By.xpath("//span[text()='Account ID: BAP-510']");
	private By lblAccountStatus = By.xpath("//span[@class=' font-bold text-md  text-cgn5']");
	private By lblEditAccountPhone = By.xpath("//h3[contains(@class, 'UserDetails_phone')]");
	private By IconEditPhone = By.xpath("//div[contains(@class, 'UserDetails_edit_Phone')]");
	private By lblEditAccountEmail = By.xpath("//h3[contains(@class, 'UserDetails_email')]");
	private By IconEditEmail = By.xpath("//div[contains(@class, 'UserDetails_edit_email_icon')]");
	private By lblEditPhoneNumAuth = By.xpath("");
	private By lblEditPhoneNum = By.xpath("");
	private By descEditPhoneNum = By.xpath("");
//	private By NewPhoneNumberTextWithPreviousData = By.xpath("");
	private By txtNewPhoneNumber = By.xpath("//input[@id='Phone_Number']");
	private By btnPhoneSendCode = By.xpath(".w-60");
	private By lblCurrentPhoneNum = By.xpath("");
	private By descCurrentPhoneNum = By.xpath("");
//	private By phoneNumVerificationCode = By.xpath("");
//	private By lnkResendVerificationCode = By.xpath("");
	private By lblEmailAddressAuth = By.xpath("");
	private By descEmailAddressAuth = By.xpath("");
//	private By emailVerificationCode = By.xpath("");
	private By lblEditEmailAddress = By.xpath("");
	private By descEditEmailAddress = By.xpath("");
//	private By NewEmailTextWithPreviousData = By.xpath("");
	private By txtNewEmailAddress = By.xpath("");
	private By btnEmailSendCode = By.cssSelector(".w-60");
//	private By oldEmailVerificationCode = By.xpath("");
//	private By lnkEmailResendVerificationCode = By.xpath("");
//	private By NewEmailVerificationCode = By.xpath("");
	public By btnCross = By.xpath("//button[@class='self-end']");

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		ExtentTestManager.setInfoMessageInReport("clicked on tab");
	}

	public void verifyUserDetailsView() {
		new CommonFunctions().elementView(lblHeading, "User Details Screen ");
	}

	public void verifyEditImageToolTip(String expToolTip) {
		new CommonFunctions().verifyCursorAction(EditUserImgToolTip, "Edit User Img");
		moveToElement(EditUserImgToolTip, "Edit User Img");
		new CommonFunctions().verifyLabelText(EditUserImgToolTip, "Edit User Img", expToolTip);

	}

	public void verifyUserNameView() {
		new CommonFunctions().elementView(lblUserName, "UserName");
	}

	public void verifyAccountIdView() {
		new CommonFunctions().elementView(lblAccountID, "accountId");
	}

	public void verifyAccountStatusView() {
		new CommonFunctions().elementView(lblAccountStatus, "accountStatus");
	}

	public void verifyPhoneNumView() {
		new CommonFunctions().elementView(lblEditAccountPhone, "PhoneNum");
	}

	public void verifyEmailAddressView() {
		new CommonFunctions().elementView(lblEditEmailAddress, "EmailAddress");
	}

	public void verifyEditAccountPhone(String expAccountPhone) {
		new CommonFunctions().verifyLabelText(lblEditAccountPhone, "EditImageToolTip", expAccountPhone);
	}

	public void verifyEditAccountEmail(String expAccountPhone) {
		new CommonFunctions().verifyLabelText(lblEditAccountEmail, "EditImageToolTip", expAccountPhone);
	}

	public VerifyCurrentPhoneNumberPopup verifyCurrentPhoneNumberPopup() {
		return new VerifyCurrentPhoneNumberPopup();
	}

	public void clickEditUserImage() {
		click(EditUserImgToolTip, "Edit User Image");
	}

	public void verifyUserName(String expUserName) {
		new CommonFunctions().verifyLabelText(lblUserName, "UserName", expUserName);
	}

	public void clickEditAccountEmail() {
		click(IconEditEmail, "Click Edit Email");
	}

	public void clickIconEditEmail() {
		moveToElement(IconEditEmail, "Edit Email");
		click(IconEditEmail, "Click Edit Email Icon");
	}

	public void clickIconEditPhNum() {
		click(IconEditPhone, "Click Edit Phone Icon");
	}

	public void verifyEditEmailAddress(String expheading) {
		new CommonFunctions().verifyLabelText(lblEditEmailAddress, "Edit Email Address PopUp Heading", expheading);
	}

	public void verifyEditEmailAddressDesc(String expheading) {
		new CommonFunctions().verifyLabelText(descEditEmailAddress, "Edit Email Address PopUp Heading", expheading);
	}

	public void verifyEditEmailAddressAuthentication(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmailAddressAuth, "Edit Email Address Authentication PopUp Heading",
				expHeading);
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

	public EditPhoneNumberPopup editPhoneNumberPopup() {
		return new EditPhoneNumberPopup();
	}

	public EditEmailAddressPopup editEmailAddressPopup() {
		return new EditEmailAddressPopup();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public void verifyNewPhoneField(String expNewPhoneNumber) {
		new CommonFunctions().validateTextFeild(txtNewPhoneNumber, expNewPhoneNumber, "New Phone Number");
	}

	public void verifyNewPhoneNumberFieldWithInvalidData(String expNewPhoneNumber, String input) {
		enterText(txtNewPhoneNumber, "New Phone Number", expNewPhoneNumber);
		String actNumber = getAttributeValue(txtNewPhoneNumber, "value", "New Phone Number");
		if (!actNumber.equals(expNewPhoneNumber)) {
			ExtentTestManager.setPassMessageInReport("New Phone Number Filed is Not Accepting " + input + "Charater");
		} else {
			ExtentTestManager.setFailMessageInReport("New Phone Number Filed is  Accepting " + input + "Charater");

		}
	}

	public void verifyVerifyCurrentPhoneNumberDescriptionText(String expVerifyPhoneNumberDescriptionText) {
		new CommonFunctions().verifyLabelText(descCurrentPhoneNum, "Verify Current Phone Number Description Text",
				expVerifyPhoneNumberDescriptionText);

	}

//	public void verifyNewPhoneNumberHeading(String expNewPhoneNumberHeading) {
//		new CommonFunctions().verifyLabelText(lblNewPhoneNumberHeading, "New Phone Number Verification",
//				expNewPhoneNumberHeading);
//	}

	public void verifyNewPhoneNumberTextWithPreviousData() {
		String str = getText(txtNewPhoneNumber, "New Phone Number");
		if (!str.isEmpty()) {

			ExtentTestManager.setPassMessageInReport("New Phone Number Field");
		} else {
			ExtentTestManager.setFailMessageInReport("New Phone Number field With Empty");
		}
	}

	public void verifyNewEmailAddressTextWithPreviousData() {
		String str = getText(txtNewEmailAddress, "New Email Address");
		if (!str.isEmpty()) {

			ExtentTestManager.setPassMessageInReport("New Email Address Field");
		} else {
			ExtentTestManager.setFailMessageInReport("New Email Address field With Empty");
		}
	}

	public void clickCrossButton() {
		click(btnCross, "Click Cross Button");
	}

	public void clickPhoneSendCode() {
		click(btnPhoneSendCode, "Send Code");
	}

	public void clickEmailSendCode() {
		click(btnEmailSendCode, "Send Code");
	}

	public void verifyAccountStatus(String expStatus) {
		String str = getText(lblAccountStatus, "Account Status");

		if (str.equals(expStatus)) {
			ExtentTestManager.setPassMessageInReport("Account status is Active");
		} else {
			ExtentTestManager.setWarningMessageInReport("Account Status is" + str);
		}
	}

	public void verifyEditPhoneNumAuth(String expheading) {
		new CommonFunctions().verifyLabelText(lblEditPhoneNumAuth, "Edit Email Address Authencation Heading",
				expheading);
	}

	public void verifyEmailAddressAuth(String expheading) {
		new CommonFunctions().verifyLabelText(lblEmailAddressAuth, "Edit Email Address Authencation Heading",
				expheading);
	}

	public void verifyEmailAddressAuthDesc(String expheading) {
		new CommonFunctions().verifyLabelText(descEmailAddressAuth, "Edit Email Address Authencation Heading",
				expheading);
	}

	public void verifyEditPhoneNum(String expheading) {
		new CommonFunctions().verifyLabelText(lblEditPhoneNum, "Edit Phone Number  Heading", expheading);
	}

	public void verifyCurrentPhoneNum(String expheading) {
		new CommonFunctions().verifyLabelText(lblCurrentPhoneNum, "Current Phone Number Heading", expheading);
	}

	public void verifyCurrentPhoneNumDesc(String expheading) {
		new CommonFunctions().verifyLabelText(descEditPhoneNum, "Current Phone Number Heading", expheading);
	}

}
