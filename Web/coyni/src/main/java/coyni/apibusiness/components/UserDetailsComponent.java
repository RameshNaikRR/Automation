package coyni.apibusiness.components;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.api.business.popups.AccountProfileImagePopup;
import coyni.api.business.popups.CurrentEmailAddressPopup;
import coyni.api.business.popups.EditEmailAddressPopup;
import coyni.api.business.popups.EmailAddressAuthenticationPopup;
import coyni.api.business.popups.NewEmailAddressPopup;
import coyni.customer.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class UserDetailsComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[@class='text-base text-cgy4']");
	private By lblUserName = By.xpath("//span[text()='Afrin Lucky']");
	private By EditUserImgToolTip = By.xpath("//img[@data-tip='Edit Image']");
	private By lblAccountID = By.xpath("//span[text()='Account ID: BAP-1104']");
	private By lblAccountStatus = By.xpath("//span[@class=' font-bold text-md  text-cgn5']");
	private By lblEditAccountPhone = By.xpath("//h3[contains(@class, 'UserDetails_phone')]");
	private By IconEditPhone = By.xpath("//div[contains(@class, 'UserDetails_edit_Phone')]");
	private By lblEditAccountEmail = By.xpath("//h3[contains(@class, 'UserDetails_email')]");
	private By IconEditEmail = By.xpath("//div[contains(@class, 'UserDetails_edit_email_icon')]");
	private By lblEditPhoneNumAuth = By.xpath("//h1[text()='Edit Phone Number']");
	private By descEditPhoneNumAuth = By.xpath("//span[contains(text(),'Please enter')]");
	private By lblEditPhoneNum = By.xpath("//h1[text()='Edit Phone Number']");
	private By lblEditPhoneNumDescription = By
			.xpath("//span[contains(text(),'Please enter a new phone number below.')]");
	private By txtNewPhoneNumber = By.xpath("//input[@id='Phone_Number']");
	private By btnPhoneSendCode = By.cssSelector(".w-60");
	private By lblCurrentPhoneNum = By.xpath("//h1[text()='Verify Current Phone Number']");
	private By lblCurrentPhoneNumDescription = By
			.xpath("//span[contains(text() ,'A text message with your verification code has been ')]");
	private By lnkResendVerificationCode = By.xpath("//button[contains(text(),'Resend Verification Code')]");
	private By lblEditEmailAddress = By.xpath("//h1[text()='Edit Email Address']");
	private By lblEditEmailAddressDescription = By.xpath("//span[contains(text(),'Please enter a new email address')]");
	private By btnCross = By.xpath("//button[@class='self-end']");
	private By lblCurrentEmailAdd = By.xpath("//h1[text()='Verify Current Email Address']");
	private By lblCurrentEmailAddressDescription = By.xpath("//span[contains(text(),'An email')]");
	private By lblNewEmail = By.xpath("//h1[text()='Verify New Email Address']");
	private By lblNewEmailDescription = By.xpath("");
	private By lblPaymentMethod = By.xpath("//span[text()='Payment Methods']");

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

	public void verifyEmailAddress(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEditAccountEmail, "Email Address", expEmail);
	}

	public void verifyEditPhoneNUmberView() {
		new CommonFunctions().elementView(lblEditPhoneNumAuth, "EmailAddress");
	}

	public void verifyEditAccountPhone(String expAccountPhone) {
		new CommonFunctions().verifyLabelText(lblEditAccountPhone, "PhoneNum", expAccountPhone);
	}

	public void verifyEditAccountEmail(String expAccountPhone) {
		new CommonFunctions().verifyLabelText(lblEditAccountEmail, "Email Address", expAccountPhone);
	}

	public void clickEditUserImage() {
		click(EditUserImgToolTip, "Edit User Image");
	}

	public void clickResendCode() {
		click(lnkResendVerificationCode, "Resend Verification Code");
	}

	public void verifyUserName(String expUserName) {
		new CommonFunctions().verifyLabelText(lblUserName, "UserName", expUserName);
	}

	public void verifyCurrentEmailAddress(String expEmailAdd) {
		new CommonFunctions().verifyLabelText(lblCurrentEmailAdd, "EmailAddress", expEmailAdd);
	}

	public void verifyCurrentEmailAddressDesc(String expDescription) {
		new CommonFunctions().verifyLabelTextContains(lblCurrentEmailAddressDescription, "EmailAddDescription",
				expDescription);
	}

	public void verifyNewEmailAdd(String expEmailAddress) {
		new CommonFunctions().verifyLabelText(lblNewEmail, "New Email Address", expEmailAddress);
	}

	public void verifyDescNewEmail(String expDescNewEmailAddress) {
		new CommonFunctions().verifyLabelText(lblNewEmailDescription, "New Email Address Desc", expDescNewEmailAddress);
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

	public void clickResendVerificationCode() {
		click(lnkResendVerificationCode, "Click Resend Verification Code");
	}

	public void verifyEditEmailAddress(String expheading) {
		new CommonFunctions().verifyLabelText(lblEditEmailAddress, "Edit Email Address PopUp Heading", expheading);
	}

	public void verifyEditEmailAddressDesc(String expheading) {
		new CommonFunctions().verifyLabelText(lblEditEmailAddressDescription, "Edit Email Address PopUp Description ",
				expheading);
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
		new CommonFunctions().verifyLabelTextContains(lblCurrentPhoneNumDescription,
				"Verify Current Phone Number Description Text", expVerifyPhoneNumberDescriptionText);

	}

	public void verifyNewPhoneNumberTextWithPreviousData() {
		String str = getText(txtNewPhoneNumber, "New Phone Number");
		if (!str.isEmpty()) {

			ExtentTestManager.setPassMessageInReport("New Phone Number Field");
		} else {
			ExtentTestManager.setFailMessageInReport("New Phone Number field With Empty");
		}
	}

	public void clickCrossButton() {
		click(btnCross, "Click Cross Button");
	}

	public void clickPhoneSendCode() {
		click(btnPhoneSendCode, "Send Code");
	}

	public void clickPaymentMethods() {
		click(lblPaymentMethod, "Payment Methods");
	}

	public void verifyAccountStatus(String expStatus) {
		String str = getText(lblAccountStatus, "Account Status");

		if (str.equals(expStatus)) {
			ExtentTestManager.setPassMessageInReport("Account status is Active");
		} else {
			ExtentTestManager.setWarningMessageInReport("Account Status is" + str);
		}
	}

	public void verifyEditPhoneNum(String expheading) {
		new CommonFunctions().verifyLabelText(lblEditPhoneNum, "Edit Phone Number  Heading", expheading);
	}

	public void verifyCurrentPhoneNum(String expheading) {
		new CommonFunctions().verifyLabelTextContains(lblCurrentPhoneNum, "Current Phone Number Heading", expheading);
	}

	public void verifyCurrentPhoneNumDesc(String expheading) {
		new CommonFunctions().verifyLabelText(lblEditPhoneNumDescription, "Current Phone Number Description ",
				expheading);
	}

	public void verifyEditPhoneNumAuthDesc(String expheading) {
		new CommonFunctions().verifyLabelTextContains(descEditPhoneNumAuth,
				"Edit Phone Number Authentication Description", expheading);
	}

	public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}

	public EmailAddressAuthenticationPopup emailAddressAuthenticationPopup() {
		return new EmailAddressAuthenticationPopup();
	}

	public EditEmailAddressPopup editEmailAddressPopup() {
		return new EditEmailAddressPopup();
	}

	public CurrentEmailAddressPopup currentEmailAddressPopup() {
		return new CurrentEmailAddressPopup();
	}

	public NewEmailAddressPopup newEmailAddressPopup() {
		return new NewEmailAddressPopup();
	}
}
