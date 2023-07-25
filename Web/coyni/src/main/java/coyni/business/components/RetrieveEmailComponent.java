package coyni.business.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RetrieveEmailComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[@data-ui-auto='retrieve_email']");
	private By lblDescription = By.xpath("//div[@data-ui-auto='retrieve_email_description']");
	private By countryCode = By.xpath("//div[@data-ui-auto='country_code']");
	private By txtPhoneNumber = By.xpath("//input[@data-ui-auto='phon_number']");
	private By txtFirstName = By.xpath("//input[@data-ui-auto='first_name']");
	private By txtLastName = By.xpath("//input[@data-ui-auto='last_name']");
	private By btnNext = By.xpath("//button[@data-ui-auto='next_button']");
	private By lnkBacktoLogin = By.xpath("//button[@data-ui-auto='back_to_login']");
	private By txtSearch = By.xpath("(//input[contains(@class,'Input_form_input__yl3pD')])[3]");
	private By countryCodes = By.xpath("//div[@data-ui-auto='Afghanistan']");

	public void verifyRetieveEmailHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading ", expHeading);
	}

	public void verifyRetrieveEmailDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description is: ", expDes);
	}

	public void selectCountryCode() {
		click(countryCode, "Country Code");
		click(countryCodes, "Country Code US");
		// enterText(txtSearch, search, "Search country code");

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
		clickOutside();
	}

	public void clickNext() {
//		new CommonFunctions().verifyCursorAction(btnNext, "Next");
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}

	public void clickOutside() {
		new CommonFunctions().clickOutSideElement();
	}

	public void clickBacktoLogin() {
		new CommonFunctions().verifyCursorAction(lnkBacktoLogin, "Back to Login");
		click(lnkBacktoLogin, "Back to Login");
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public EmailVerificationComponent emailVerificationComponent() {
		return new EmailVerificationComponent();
	}

	public void validateNameField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 4; j < 7; j++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[7]);
	}

	public void validateFirstNameField(String firstName) {
		validateNameField(txtFirstName, "First Name", firstName);
	}

	public void validateLastNameField(String LastName) {
		validateNameField(txtLastName, "Last Name", LastName);
	}

	/**
	 * Order -minChar, alphabets, specialChar, spaces, maxiPlus
	 */
	public void validateNumber(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		new CommonFunctions().validateField(ele, eleName, field[0]);
		for (int i = 1; i < 4; i++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
	}

	public void validatePhoneNumber(String phoneNumber) {
		validateNumber(txtPhoneNumber, "Phone Number", phoneNumber);
	}

}
