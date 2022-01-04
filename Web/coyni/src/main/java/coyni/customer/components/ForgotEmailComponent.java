package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ForgotEmailComponent extends BrowserFunctions {

	private By forgotHeading = By.cssSelector(".forgot-email__title");
	private By lnkBackToLogin = By.xpath("//div[text()='Back to Login']");
	private By txtPhoneNumber = By.id("Phone_Number");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By txtFirstName = By.name("first_name");
	private By txtLastName = By.name("last_name");

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

//	public void validatePhoneNumber(String maxChar, String moreThanMaxChar, String alphabets, String specialChar) {
//		new CommonFunctions().validateFieldWithSpecialchar(txtPhoneNumber, "Phone Number", specialChar);
//		new CommonFunctions().validateFieldWithalphabet(txtPhoneNumber, "Phone Number", alphabets);
//		new CommonFunctions().validateFieldMaxichar(txtPhoneNumber, "Phone Number", moreThanMaxChar);
//		new CommonFunctions().clearText(txtPhoneNumber, "Name on card");
//		new CommonFunctions().validateField(txtPhoneNumber, "Phone Number", maxChar);
//
//	}
//
//	public void validateFirstName(String minChar,String minCharPlus,  String maxLessChar, String maxChar, String moreThanMaxChar, String number,
//			String specialChar)  {
//		new CommonFunctions().validateFieldWithSpecialchar(txtFirstName, "First Name", specialChar);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateFieldWithNumber(txtFirstName, "First Name", number);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateFieldMaxichar(txtFirstName, "First Name", moreThanMaxChar);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateField(txtFirstName, "First Name", maxChar);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateField(txtFirstName, "First Name", minChar);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateField(txtFirstName, "First Name",minCharPlus );
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateField(txtFirstName, "First Name", maxLessChar);
//	}
//
//	public void validateLastName(String minChar,String minCharPlus,  String maxLessChar, String maxChar, String moreThanMaxChar, String number,
//			String specialChar) {
//		new CommonFunctions().validateFieldWithSpecialchar(txtFirstName, "Last Name", specialChar);
//		new CommonFunctions().clearText(txtFirstName, "Last Name");
//		new CommonFunctions().validateFieldWithNumber(txtFirstName, "Last Name", number);
//		new CommonFunctions().clearText(txtFirstName, "Last Name");
//		new CommonFunctions().validateFieldMaxichar(txtFirstName, "Last Name", moreThanMaxChar);
//		new CommonFunctions().clearText(txtFirstName, "Last Name");
//		new CommonFunctions().validateField(txtFirstName, "Last Name", maxChar);
//		new CommonFunctions().clearText(txtFirstName, "Last Name");
//		new CommonFunctions().validateField(txtFirstName, "Last Name", minChar);
//		new CommonFunctions().clearText(txtFirstName, "Last Name");
//		new CommonFunctions().validateField(txtFirstName, "Last Name",minCharPlus );
//		new CommonFunctions().clearText(txtFirstName, "Last Name");
//		new CommonFunctions().validateField(txtFirstName, "Last Name", maxLessChar);
//	}

//	public void validateRemainingAttempts(String expAttempts) {
//		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
//		String text = getText(lblerrorMsg, "error message").replaceAll("[^0-9]", "");
//		if (expAttempts.equals(text)) {
//			ExtentTestManager.setPassMessageInReport("Number of remaining invalid password attemps are " + expAttempts);
//		} else {
//			ExtentTestManager.setFailMessageInReport("Expected of number of remaining password attempts  are "
//					+ expAttempts + " but actual are " + text);
//		}
//	}

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

}
