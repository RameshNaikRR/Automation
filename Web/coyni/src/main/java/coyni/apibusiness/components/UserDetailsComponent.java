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

	private By lblHeading = By.cssSelector("");
	private By editUserImage = By.cssSelector("");
	private By editUserImgToolTip = By.xpath("");
//	private By lnkRemoveImage = By.cssSelector("");
//	private By btnRemove = By.cssSelector("");
//	private By btnUploadNewImage = By.cssSelector("");
//	private By btnSave = By.cssSelector("");
	private By lblUserName = By.xpath("");
	private By lblAccountStatus = By.xpath("");
	private By lblEmail = By.cssSelector("");
//	private By lblAddress = By.cssSelector("");
	private By lnkEditAccountEmail = By.xpath("");
	private By lnkEditAccountPhNum = By.xpath("");
//	private By lnkEditAccountAddress = By.xpath("");
	private By iconEditEmail = By.cssSelector("");
	private By iconEditPhNum = By.xpath("");
	private By lblEditPhoneNumber = By.xpath("");
//	private By iconEditAddress = By.xpath("");
//	private By userImg = By.xpath("");
	private By imgPhone = By.xpath("");
	private By accountId = By.xpath("");
	private By lblPhoneNum = By.xpath(" ");
	private By lblEmailAuth = By.xpath("");
	private By lblVerificationCodeDescription = By.cssSelector("");
	private By txtCode = By.cssSelector("");
	private By txtNewPhoneNumber = By.cssSelector("");
	private By btnCross = By.cssSelector("");
	private By headingUserDetais = By.xpath("");
	private By lblCurrentPhoneNumberDescriptionText = By.xpath("");
	private By btnBackButton = By.xpath("");
	private By lblVerificationSuccesful = By.xpath("");
	private By lblNewPhoneNumberHeading = By.xpath("");
	private By headingEditAccountPhone = By.xpath("");

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		ExtentTestManager.setInfoMessageInReport("clicked on tab");
	}

	public void verifyUserDetailsView() {
		new CommonFunctions().elementView(lblHeading, "User Details Screen ");
	}

	public void verifyEditImageView() {
		new CommonFunctions().elementView(editUserImage, "Edit User Img icon");
		new CommonFunctions().verifyCursorAction(editUserImage, "Edit User Img icon");
	}

	public void verifyEditImageToolTip(String expToolTip) {
		new CommonFunctions().verifyCursorAction(editUserImgToolTip, "Edit User Img");
		// moveToElement(editUserImgToolTip, "Edit User Img");
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

//	public void verifyEmailAddressView() {
//		new CommonFunctions().elementView(lblEmailAddress, "EmailAddress");
//	}
//
//	public void verifyAccountAddressView() {
//		new CommonFunctions().elementView(lblAccountAddress, "AccountAddress");
//	}

	public VerifyCurrentPhoneNumberPopup verifyCurrentPhoneNumberPopup() {
		return new VerifyCurrentPhoneNumberPopup();
	}

	public void clickEditUserImage() {
		click(editUserImage, "Edit User Image");
	}

//	public void clickRemoveImage() {
//		click(lnkRemoveImage, "Remove Image");
//	}
//
//	public void clickRemove() {
//		click(btnRemove, "Remove Button");
//	}
//
//	public void clickUploadNewImage() {
//		click(btnUploadNewImage, "Upload New Image Button");
//	}
//
//	public void clickSave() {
//		click(btnSave, "Save Button");
//	}

	public void verifyUserName(String expUserName) {
		new CommonFunctions().verifyLabelText(lblUserName, "UserName", expUserName);
	}

	public void verifyAccountStatus(String expAccountStatus) {
		new CommonFunctions().verifyLabelText(lblAccountStatus, "Account Status", expAccountStatus);
	}

	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "Email", expEmail);
	}

//	public void verifyAddress(String expAddress) {
//		new CommonFunctions().verifyLabelText(lblAddress, "Address", expAddress);
//	}

	public void clickEditAccountEmail() {
		click(lnkEditAccountEmail, "Click Edit Email");
	}

	public void clickEditAccountPhNumber() {
		click(lnkEditAccountPhNum, "Click Edit PhoneNumber");
	}

//	public void clickEditAccountAddress() {
//		click(lnkEditAccountAddress, "Click Edit Address");
//	}

	public void clickIconEditEmail() {
		moveToElement(lblEmail, "Edit Email");
		click(iconEditEmail, "Click Edit Email Icon");
	}

	public void clickIconEditPhNum() {
		click(iconEditPhNum, "Click Edit Phone Icon");
	}

//	public void clickIconEditAddress() {
//		click(iconEditAddress, "Click Edit Address Icon");
//	}

//	public void verifyEditEmailAddress(String expheading) {
//		new CommonFunctions().verifyLabelText(lblEmailAddress, "Edit Email Address PopUp Heading", expheading);
//	}

	public void verifyEditEmailAddressAuthentication(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmailAuth, "Edit Email Address Authentication PopUp Heading",
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

	public void verifyEditPhoneNumberIconView() {
		moveToElement(imgPhone, "Moved to Edit PhoneNumber");
		click(iconEditPhNum, "Clciked Edit Phone Number Icon");
	}

	public void verifyVerificationCodeDescriptionText(String expVerificationCodeDescriptionText) {
		new CommonFunctions().verifyLabelText(lblVerificationCodeDescription, "Edit Phone Number Description Text",
				expVerificationCodeDescriptionText);
	}

	public void verifyVerificationTextCodeBoxBorderColorAndDescription(String expColor, String expVerificationmsg) {

		new CommonFunctions().verifyTextBoxBorderColor(expColor);
		new CommonFunctions().verifyLabelText(lblVerificationSuccesful, "Verificational Succesful", expVerificationmsg);
	}

//    public void verifyVerificationCodeWithNumber(String expCode) {
//    	new CommonFunctions().validateFieldWithNumber(txtCode, "Verification", expCode);
//    		
//    }

	public void verifyNewPhoneField(String expNewPhoneNumber) {
		new CommonFunctions().validateTextFeild(txtNewPhoneNumber, expNewPhoneNumber, "New Phone Number");
	}

	public void enterCode(String expCode) {
		enterText(txtCode, expCode, "Verification Code");
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
		new CommonFunctions().verifyLabelText(lblCurrentPhoneNumberDescriptionText,
				"Verify Current Phone Number Description Text", expVerifyPhoneNumberDescriptionText);

	}

	public void verifyNewPhoneNumberHeading(String expNewPhoneNumberHeading) {
		new CommonFunctions().verifyLabelText(lblNewPhoneNumberHeading, "New Phone Number Verification",
				expNewPhoneNumberHeading);
	}

	public void clickBackButton() {
		click(btnBackButton, "");
	}

//	public void verifyEditPhoneNumberScreen(String expHeading) {
//		new CommonFunctions().verifyLabelText(headingEditPhoneNumber, "Edit Phone Number", expHeading);
//
//	}

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

	public void verifyUserdetailsScreen(String expUserDetailsHeading) {
		new CommonFunctions().verifyLabelText(headingUserDetais, "User Details Heading", expUserDetailsHeading);

	}

}
