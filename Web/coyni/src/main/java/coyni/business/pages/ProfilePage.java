package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.business.components.MailingAddressComponent;
import coyni.business.popups.EditEmailAddressPopup;
import coyni.business.popups.EditPhoneNumberPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

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

	public void verifyProfile(String expHeading) {
		new CommonFunctions().verifyLabelText(lblProfile, "Profile Heading is: ", expHeading);
	}

	public void verifyCustomerName(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCustomerName, "Customer Name is : ", expHeading);
	}

	public void verifyAccountID(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAccountID, "Account ID is : ", expHeading);
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

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

}
