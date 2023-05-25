package coyni.business.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RetrieveEmailComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By txtPhoneNumber = By.xpath("");
	private By txtFirstName = By.xpath("");
	private By txtLastName = By.xpath("");
	private By btnNext = By.xpath("");
	private By lnkBacktoLogin = By.xpath("");

	public void verifyRetieveEmailHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHeading);
	}

	public void verifyRetrieveEmailDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description is: ", expDes);
	}

	public void fillPhoneNumber(String phoneNumber) {
		new CommonFunctions().verifyCursorAction(txtPhoneNumber, "Phone Number");
		enterText(txtPhoneNumber, phoneNumber, "Phone Number");
	}

	public void fillFirstName(String firstName) {
		new CommonFunctions().verifyCursorAction(txtFirstName, "First Name");
		enterText(txtFirstName, firstName, "First Name");
	}

	public void fillLastName(String lastName) {
		new CommonFunctions().verifyCursorAction(txtLastName, "Last Name");
		enterText(txtLastName, lastName, lastName);
	}

	public void clickNext() {
		new CommonFunctions().verifyCursorAction(btnNext, "Next");
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}

	public void clickBacktoLogin() {
		new CommonFunctions().verifyCursorAction(lnkBacktoLogin, "Back to Login");
		click(lnkBacktoLogin, "Back to Login");
	}
	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

}
