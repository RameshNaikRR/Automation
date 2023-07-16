package coyni.business.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.business.pages.ProfilePage;
import coyni.business.popups.AccountProfileImagePopup;
import coyni.business.popups.EditEmailAddressPopup;
import coyni.business.popups.EditPhoneNumberPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class UserDetailsComponent extends BrowserFunctions {

	CommonFunctions commonFunctions = new CommonFunctions();

	private By lblHeading = By.cssSelector(".text-base.text-cgy4");
	private By editUserImage = By.cssSelector(".w-4");
	private By editUserImgToolTip = By.xpath("//img[@class='w-4 h-4']/../following-sibling::*[1]");
	private By lnkRemoveImage = By.cssSelector("");
	private By btnRemove = By.cssSelector("");
	private By btnUploadNewImage = By.cssSelector("//button[contains(text(),'Upload New Image')]");
	private By btnSave = By.cssSelector("");
	private By lblUserName = By.xpath("//span[contains(@class,'UserDetails_largerName__NY3VX')]");
	private By lblAccountStatus = By.xpath("//div[@class='flex flex-wrap gap-1 ml-2 ']");
	private By lblEmail = By.xpath("//h3[contains(@class,'UserDetails_email_address')]");
	private By lblAddress = By.cssSelector("");
	private By lnkEditAccountEmail = By.xpath("//div[text()='Edit Account Email']");
	private By lnkEditAccountPhNum = By.xpath("//div[text()='Edit Account Phone']");
	private By lnkEditAccountAddress = By.xpath("//div[text()='Edit Account Address']");
	private By iconEditEmail = By.xpath("//div[contains(@class,'UserDetails_edit_email_icon')]");
	private By iconEditPhNum = By.xpath("//div[contains(@class,'UserDetails_edit_Phone_icon__mqwNd')]");
	private By userImg = By.xpath("//div[contains(@class,'flex flex-row')]//div[contains(@class,'bg-cm3')] \" ");
	private By imgPhone = By.xpath("//h3[contains(@class,'UserDetails_phoneNumber')]");
	private By accountId = By.xpath("//span[@class='mt-1 text-xs text-cgy2'] ");
	private By lblEmailAuth = By.xpath("//div[@class='mt-4']");
	private By lblEmailAddress = By.xpath("//div[text()='Edit Account Email']");
	private By lblAccountAddress = By
			.xpath("//div[contains(@class,'UserDetails_address__2XyBR UserDetails_city_field__2olcd')] ");
	private By txtCode = By.cssSelector("input[class *= 'verification-input']");
	private By txtNewPhoneNumber = By.xpath("//input[text()='New Phone Number']");
	private By btnCross = By.cssSelector("button[class='self-end']");
	private By headingUserDetais = By.xpath("//span[@class='text-base text-cgy4']");
	private By lblVerificationSuccesful = By.xpath("//span[text='Verification Successful']");
	private By lblNewPhoneNumberHeading = By.xpath("//h1[text()='New Phone Number']");
	private By headingEditPhoneNumber = By.xpath("//h1[text()='Edit Phone Number']");

	private By lblUserDetails = By.cssSelector("");
	private By lnkLogOut = By.xpath("");

	public void verifyUserDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblUserDetails, "Heading is: ", expHeading);
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		ExtentTestManager.setInfoMessageInReport("clicked on tab");
	}

	public By getUserDetailsItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void clickProfile() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Profile"), "Profile");
		click(getUserDetailsItems("Profile"), "Profile");
	}

	public void clickPreferences() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Preferences"), "Preferences");
		click(getUserDetailsItems("Preferences"), "Preferences");
	}

	public void clickAgreements() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Agreements"), "Agreements");
		click(getUserDetailsItems("Agreements"), "Agreements");
	}

	public void clickLoginSessions() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Login Sessions"), "Login Sessions");
		click(getUserDetailsItems("Login Sessions"), "Login Sessions");
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

	public void clickChangePassword() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Change Password"), "Change Password");
		click(getUserDetailsItems("Change Password"), "Change Password");
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

	public void verifyEditEmailAddress(String expheading) {
		new CommonFunctions().verifyLabelText(lblEmailAddress, "Edit Email Address PopUp Heading", expheading);
	}

	public void verifyEditEmailAddressAuthentication(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmailAuth, "Edit Email Address Authentication PopUp Heading",
				expHeading);
	}

	public void clickLogOut() {
		click(lnkLogOut, "Log Out");
	}

	public ProfilePage profilePage() {
		return new ProfilePage();
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
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

}
