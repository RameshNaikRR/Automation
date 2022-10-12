package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ForgotEmailComponent extends BrowserFunctions {

	private By forgotHeading = By.cssSelector(".forgot-email__title");
	private By lnkBackToLogin = By.xpath("//button[text()='Back to Login']");
	private By txtPhoneNumber = By.id("Phone_Number");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By txtFirstName = By.xpath("//input[@name='first_name']");
	private By txtLastName = By.xpath("//input[@name='last_name']");

	public void clickforgot() {
		if (getElement(forgotHeading, "click forgot").isDisplayed()) {
			click(forgotHeading, "Heading");
		}
	}

	public void verifyForgotHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(forgotHeading, "Forgot heading", expHeading);
	}

	public void clickBackToLogin() {
		click(lnkBackToLogin, "Back To Login");
	}

	public void fillPhoneNumber(String PhoneNumber) {
		enterText(txtPhoneNumber, PhoneNumber, "PhoneNumber");
	}

	/**
	 * Order -minChar, alphabets, specialChar, spaces, maxiPlus
	 */
	public void validatePhoneNumber(String textField) {
		String[] field = textField.split(",");
		new CommonFunctions().validateField(txtPhoneNumber, "Phone Number", field[0]);
		for (int i = 1; i < 4; i++) {
			new CommonFunctions().validateTextFeild(txtPhoneNumber, "Phone Number", field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(txtPhoneNumber, "Phone Number", field[4]);
	}

	/**
	 * Order -minChar, minCharPlus, maxCharMinus, maxChar, specialChar, Number,
	 * spaces maxiPlus
	 */

	// we,ere,hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh,hhhhhhhhhhhhhhhhhhhhhhhhhhhhh,#$,1234,
	// ,hhhdfhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
	public void validateNameField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 4; j < 6; j++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[6]);
	}

	public void validateFirstNameField(String firstName) {
		validateNameField(txtFirstName, "First Name", firstName);
	}

	public void validateLastNameField(String LastName) {
		validateNameField(txtLastName, "Last Name", LastName);
	}

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
	}

	public void verifyFirstName() {
		getTextBoxValue(txtFirstName, "verify first Name");
	}

	public void verifyLastName() {
		getTextBoxValue(txtLastName, "verify first Name");
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

}
