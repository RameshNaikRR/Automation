package coyni.customer.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import coyni.customer.popups.AccountProfileImagePopup;
import coyni.customer.popups.EditEmailAddressPopup;
import coyni.customer.popups.EditPhoneNumberPopup;
import coyni.customer.popups.VerifyCurrentPhoneNumberPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class UserDetailsComponent extends BrowserFunctions {

	private By lblHeading = By.cssSelector(".text-base.text-cgy4");
	private By editUserImage = By.cssSelector(".w-4");
	private By editUserImgToolTip = By.xpath("//img[@class='w-4 h-4']/../following-sibling::*[1]");
	private By lnkRemoveImage = By.cssSelector("");
	private By btnRemove = By.cssSelector("");
	private By btnUploadNewImage = By.cssSelector("");
	private By btnSave = By.cssSelector("");
	private By lblUserName = By.xpath("//span[@class='text-2xl font-bold text-cgy8']");
	private By lblAccountStatus = By.xpath("//div[@class='flex flex-row text-md text-cgy4']");
	private By lblEmail = By.xpath("//h3[contains(@class,'UserDetails_email_address')]");
	private By lblAddress = By.cssSelector("");
	private By lnkEditAccountEmail = By.xpath("//div[text()='Edit Account Email']");
	private By lnkEditAccountPhNum = By.xpath("//div[text()='Edit Account Phone']");
	private By lnkEditAccountAddress = By.xpath("//div[text()='Edit Account Address']");
	private By iconEditEmail = By.xpath("//div[contains(@class,'UserDetails_edit_email_icon')]");
	private By iconEditPhNum = By.xpath("//div[contains(@class,'UserDetails_edit_Phone_icon')]");
	private By iconEditAddress = By.xpath("//div[@id='t14bec415-7d33-4847-85c6-9e08e7b12434']");
	private By userImg = By.xpath("//div[contains(@class,'flex flex-row')]//div[contains(@class,'bg-cm3')] \" ");
	private By imgPhone = By.xpath("//h3[contains(@class,'UserDetails_phoneNumber')]");
	private By accountId = By.xpath("//span[@class='mt-1 text-xs text-cgy2'] ");
	private By lblEmailAuth = By.xpath("//div[@class='mt-4']");
	private By lblEmailAddress = By.xpath("//h1[text()='Edit Email Address']");
	private By lblAccountAddress = By.xpath("//div[contains(@class,'UserDetails_address__2XyBR UserDetails_city_field__2olcd')] ");
	private By txtCode = By.cssSelector("input[class *= 'verification-input']");
	private By txtNewPhoneNumber = By.xpath("//input[text()='New Phone Number']");
	private By btnCross = By.cssSelector("button[class='self-end']");
	private By headingUserDetais = By.xpath("//span[@class='text-base text-cgy4']");
	private By lblVerificationSuccesful = By.xpath("//span[text='Verification Successful']");
	private By lblNewPhoneNumberHeading = By.xpath("//h1[text()='New Phone Number']");
	private By headingEditPhoneNumber = By.xpath("//h1[@text()='Edit Phone Number']");

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

	public void verifyEmailAddressView() {
		new CommonFunctions().elementView(lblEmailAddress, "EmailAddress");
	}

	public void verifyAccountAddressView() {
		new CommonFunctions().elementView(lblAccountAddress, "AccountAddress");
	}
	
	public VerifyCurrentPhoneNumberPopup verifyCurrentPhoneNumberPopup() {
		return new VerifyCurrentPhoneNumberPopup();
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
		moveToElement(lblEmail, "Edit Email");
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


	public void verifyVerificationTextCodeBoxBorderColorAndDescription(String expColor, String expVerificationmsg) {

		new CommonFunctions().verifyTextBoxBorderColor(expColor);
		new CommonFunctions().verifyLabelText(lblVerificationSuccesful, "Verificational Succesful", expVerificationmsg);
	}
	
	public void verifyNewPhoneField(String expNewPhoneNumber) {
		new CommonFunctions().validateTextFeild(txtNewPhoneNumber, expNewPhoneNumber, "New Phone Number");
	}
	
	public void enterCode(String expCode) {
		enterText(txtCode, expCode, "Verification Code");
	}
	
	public void verifyNewPhoneNumberHeading(String expNewPhoneNumberHeading) {
		new CommonFunctions().verifyLabelText(lblNewPhoneNumberHeading, "New Phone Number Verification",
				expNewPhoneNumberHeading);
	}


	public void verifyEditPhoneNumberScreen(String expHeading) {
		new CommonFunctions().verifyLabelText(headingEditPhoneNumber, "Edit Phone Number", expHeading);

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

	public void verifyUserdetailsScreen(String expUserDetailsHeading) {
		new CommonFunctions().verifyLabelText(headingUserDetais, "User Details Heading", expUserDetailsHeading);

	}

}
