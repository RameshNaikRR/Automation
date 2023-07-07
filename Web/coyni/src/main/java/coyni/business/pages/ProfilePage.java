package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.business.components.AgreementsComponent;
import coyni.business.components.MailingAddressComponent;
import coyni.business.components.PhoneVerificationComponent;
import coyni.business.popups.EditEmailAddressPopup;
import coyni.business.popups.EditPhoneNumberPopup;
import coyni.business.popups.ReconfigureTwoStepAuthenticationPoup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ProfilePage extends BrowserFunctions {

	private By lblProfile = By.xpath("");
	private By lblCustomerName = By.xpath("");
	private By lblAccountID = By.xpath("");
	private By lblTwoStepAuthentication = By.xpath("");
	private By lnkReconfigure = By.xpath("");
	private By lblAdministrator = By.xpath("");
	private By iconEditPhoneNumber = By.xpath("");
	private By iconEditEmailAddress = By.xpath("");
	private By iconEditMailingAddress = By.xpath("");
	private By permissionRole = By.xpath("");

	public void verifyProfile() {
		String str = getText(lblProfile, "Profile");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyCustomerName() {
		String str = getText(lblCustomerName, "customer name");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyAccountID() {
		String str = getText(lblAccountID, "Account ID");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyPermissionRole() {
		String str = getText(permissionRole, "");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyTwoStepAuthentication(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTwoStepAuthentication, "Text is : ", expHeading);
	}

	public void clickReconfigure() {
		new CommonFunctions().verifyCursorAction(lnkReconfigure, "Reconfigure");
		click(lnkReconfigure, "Reconfigure");
	}

	public void verifyAdministrator(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAdministrator, "Role is : ", expHeading);
	}

	public void clickEditPhoneNumber() {
		new CommonFunctions().verifyCursorAction(iconEditPhoneNumber, "Edit Phone Number");
		click(iconEditPhoneNumber, "Edit Phone Number");
	}

	public void clickEditEmailAddress() {
		new CommonFunctions().verifyCursorAction(iconEditEmailAddress, "Edit Email Address");
		click(iconEditEmailAddress, "Edit Email Address");
	}

	public void clickEditMailingAddress() {
		new CommonFunctions().verifyCursorAction(iconEditMailingAddress, "Edit Mailing Address");
		click(iconEditMailingAddress, "Edit Mailing Address");
	}

	public EditPhoneNumberPopup editPhoneNumberPopup() {
		return new EditPhoneNumberPopup();
	}

	public EditEmailAddressPopup editEmailAddressPopup() {
		return new EditEmailAddressPopup();
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public ReconfigureTwoStepAuthenticationPoup recongAuthenticationPoup() {
		return new ReconfigureTwoStepAuthenticationPoup();
	}

	public AgreementsComponent agreementsComponent() {
		return new AgreementsComponent();
	}

	public PreferencesPage preferencespage() {
		return new PreferencesPage();
	}

}
