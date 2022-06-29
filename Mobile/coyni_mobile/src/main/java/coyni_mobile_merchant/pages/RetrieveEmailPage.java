package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.components.PhoneAndEmailVerificationComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class RetrieveEmailPage extends MobileFunctions {
	private By lnkRetrieveEmail = MobileBy.xpath("//*[contains(@resource-id,'tvRetEmail')]");
	private By lblHeading = MobileBy.xpath("//*[@text='Retrieve Email']");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'To help')]");
	private By txtPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By lblErrorMessage = By.xpath("//*[contains(@resource-id,'ErrorTV')]");
	private By txtFirstName = MobileBy.xpath("//*[contains(@resource-id,'reFirstNameET')]");
	private By txtLastName = MobileBy.xpath("//*[contains(@resource-id,'reLastNameET')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'reCardViewNextBtn')]");
	private By iconCross = MobileBy.xpath("//*[contains(@resource-id,'imgREClose')]");

	public void clickRetrieveEmail() {
		click(lnkRetrieveEmail, "Retrieve Email");
	}

	public void verifyErrorMessage() {
		new CommonFunctions().elementView(lblErrorMessage, "Error Message");
	}

	public void verifyPhoneNumberView() {
		new CommonFunctions().elementView(txtPhoneNumber, "Phone Number");
	}

	public void verifyFirstNameViewView() {
		new CommonFunctions().elementView(txtFirstName, "First Name");
	}

	public void verifyLastNameView() {
		new CommonFunctions().elementView(txtLastName, "Last Name");
	}

	public void verifyNextButtonView() {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().elementView(btnNext, "Next");
	}

	public void verifyNextButtonDisabled() {
		new CommonFunctions().elementEnabled(btnNext, "Next Button");
	}

	public void verifyCrossIconView() {
		new CommonFunctions().elementView(iconCross, "Cross Icon");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
		DriverFactory.getDriver().hideKeyboard();
	}

	public void verifyDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", expDescription);
	}

	public void fillPhoneNumber(String PhoneNumber) {
		click(txtPhoneNumber, "Phone Number");
		enterText(txtPhoneNumber, PhoneNumber, "Phone Number");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillFirstName(String FirstName) {
		click(txtFirstName, "First Name");
		enterText(txtFirstName, FirstName, "First Name");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillLastName(String LastName) {
		click(txtLastName, "Last Name");
		enterText(txtLastName, LastName, "Last Name");
		new CommonFunctions().clickTab();
		DriverFactory.getDriver().hideKeyboard();
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickCrossIcon() {
		click(iconCross, "CrossIcon");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}

	public AccountNotFoundPage accountNotFoundPage() {
		return new AccountNotFoundPage();
	}
}
