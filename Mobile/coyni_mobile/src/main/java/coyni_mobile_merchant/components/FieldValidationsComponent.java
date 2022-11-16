package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FieldValidationsComponent extends MobileFunctions {
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'Email')]|//*[contains(@resource-id,'emailET')]");
	private By txtNewPassword = MobileBy.xpath("//*[contains(@resource-id,'etPassword')]");
	private By txtConfirmPassword = MobileBy
			.xpath("//*[contains(@resource-id,'etCPassword')]|//*[contains(@resource-id,'confirmPasswordET')]");
	private By txtPassword = MobileBy
			.xpath("//*[contains(@resource-id,'etPassword')] |//*[contains(@resource-id,'passwordET')]");
	private By txtPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By txtFirstName = MobileBy
			.xpath("//*[contains(@resource-id,'FirstNameET')]|//*[contains(@resource-id,'firstNameET')]");
	private By txtFirstNameInput = MobileBy
			.xpath("//*[contains(@resource-id,'textinput_placeholder')]");
	
	private By txtLastName = MobileBy.xpath(
			"//*[contains(@resource-id,'reLastNameET')]|//*[contains(@resource-id,'lastNameET')]|//*[contains(@resource-id,'astName')]");
	// Payment Methods - Bank validations
	private By txtRoutingNumber = MobileBy.xpath("//*[contains(@resource-id,'routingNumberET')]");
	private By txtConfirmRouting = MobileBy.xpath("//*[contains(@resource-id,'confirmRoutingNumberET')]");
	private By txtAccNumber = MobileBy.xpath("//*[contains(@resource-id,'checkAccNumberET')]");
	private By txtConfirmAccNumber = MobileBy.xpath("//*[contains(@resource-id,'confirmAccNumberET')]");
	private By txtNameOnBank = MobileBy.xpath("//*[contains(@resource-id,'nameOnBankET')]");

	// Payment Methods - Card validations

	private By txtNameOnCard = MobileBy.xpath("//*[contains(@resource-id,'etName')]");
	private By txtCardNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By txtCardExp = MobileBy.xpath("//*[contains(@resource-id,'etExpiry')]");
	private By txtCVVorCVC = MobileBy.xpath("//*[contains(@resource-id,'etCVV')]");
	private By txtAddressLine1 = MobileBy.xpath(
			"//*[contains(@resource-id,'etAddress1')]|//*[contains(@resource-id,'addressLineOneET')]|//*[contains(@resource-id,'companyaddressET')]");
	private By txtAddressLine2 = MobileBy.xpath(
			"//*[contains(@resource-id,'etAddress2')]|//*[contains(@resource-id,'addressLineTwoET')]|//*[contains(@resource-id,'companyaddress2ET')]");
	private By txtCity = MobileBy.xpath(
			"//*[contains(@resource-id,'etCity')]|//*[contains(@resource-id,'cityET')]|//*[contains(@resource-id,'cityET')]");
	private By txtStateSearch = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");
	private By txtZipCode = MobileBy.xpath(
			"//*[contains(@resource-id,'etZipcode') or contains(@resource-id,'etZipCode')]|//*[contains(@resource-id,'zipcodeET')]");
	private By txtSignetWalletId = MobileBy.xpath("//*[contains(@resource-id,'etWalletId')]");

	public void validateEmailField(String singleChar, String maxChar, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtEmail, "Email", singleChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateFieldMaxichar(txtEmail, "Email", moreThanMax);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateFieldWithalphabet(txtEmail, "Email", alphabet);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateFieldWithNumber(txtEmail, "Email", number);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateFieldWithSpecialchar(txtEmail, "Email", specialChar);
		new CommonFunctions().clearText(txtEmail, "Email");
	}

	public void validateNewPasswordField(String singleChar, String maxChar, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtNewPassword, "New Password", singleChar);
		new CommonFunctions().clearText(txtNewPassword, "New Password");
		new CommonFunctions().validateField(txtNewPassword, "New Password", maxChar);
		new CommonFunctions().clearText(txtNewPassword, "New Password");
		new CommonFunctions().validateFieldMaxichar(txtNewPassword, "New Password", moreThanMax);
		new CommonFunctions().clearText(txtNewPassword, "New Password");
		new CommonFunctions().validateFieldWithalphabet(txtNewPassword, "New Password", alphabet);
		new CommonFunctions().clearText(txtNewPassword, "New Password");
		new CommonFunctions().validateFieldWithNumber(txtNewPassword, "New Password", number);
		new CommonFunctions().clearText(txtNewPassword, "New Password");
		new CommonFunctions().validateFieldWithSpecialchar(txtNewPassword, "New Password", specialChar);
	}

	public void validateConfirmPasswordField(String singleChar, String maxChar, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtConfirmPassword, "Confirm Password", singleChar);
		new CommonFunctions().clearText(txtConfirmPassword, "Confirm Password");
		new CommonFunctions().validateField(txtConfirmPassword, "Confirm Password", maxChar);
		new CommonFunctions().clearText(txtConfirmPassword, "Confirm Password");
		new CommonFunctions().validateFieldMaxichar(txtConfirmPassword, "Confirm Password", moreThanMax);
		new CommonFunctions().clearText(txtConfirmPassword, "Confirm Password");
		new CommonFunctions().validateFieldWithalphabet(txtConfirmPassword, "Confirm Password", alphabet);
		new CommonFunctions().clearText(txtConfirmPassword, "Confirm Password");
		new CommonFunctions().validateFieldWithNumber(txtConfirmPassword, "Confirm Password", number);
		new CommonFunctions().clearText(txtConfirmPassword, "Confirm Password");
		new CommonFunctions().validateFieldWithSpecialchar(txtConfirmPassword, "Confirm Password", specialChar);
	}

	public void validatePasswordField(String singleChar, String maxChar, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtPassword, "password", singleChar);
		new CommonFunctions().clearText(txtPassword, "password");
		new CommonFunctions().validateField(txtPassword, "password", maxChar);
		new CommonFunctions().clearText(txtPassword, "password");
		new CommonFunctions().validateFieldMaxichar(txtPassword, "password", moreThanMax);
		new CommonFunctions().clearText(txtPassword, "password");
		new CommonFunctions().validateFieldWithalphabet(txtPassword, "password", alphabet);
		new CommonFunctions().clearText(txtPassword, "password");
		new CommonFunctions().validateFieldWithNumber(txtPassword, "password", number);
		new CommonFunctions().clearText(txtPassword, "password");
		new CommonFunctions().validateFieldWithSpecialchar(txtPassword, "password", specialChar);
	}

	public void validatePhoneNumberField(String singleDigit, String maxDigit, String moreThanMax) {
//		new CommonFunctions().enterKeys(data, typeOfData);
		new CommonFunctions().validateField(txtPhoneNumber, "Phone Number", singleDigit);
		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
		new CommonFunctions().validateField(txtPhoneNumber, "Phone Number", maxDigit);
		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
		new CommonFunctions().validateFieldMaxichar(txtPhoneNumber, "Phone Number", moreThanMax);
		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");

//		new CommonFunctions().validateFieldWithNotAcceptAlphabet(txtPhoneNumber, "Phone Number", alphabet);
//		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
//		new CommonFunctions().validateFieldWithNumber(txtPhoneNumber, "Phone Number", number);
//		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
//		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtPhoneNumber, "Phone Number", specialChar);
	}

	public void validateFirstNameField(String singleDigit, String maxDigit, String moreThanMax, String data,
			String typeOfData, String elementName) throws InterruptedException {
		new CommonFunctions().validateField(txtFirstName, "First Name", singleDigit);
		new CommonFunctions().clearText(txtFirstName, "First Name");
		new CommonFunctions().validateField(txtFirstName, "First Name", maxDigit);
		new CommonFunctions().clearText(txtFirstName, "First Name");
		new CommonFunctions().validateFieldMaxichar(txtFirstName, "First Name", moreThanMax);
		new CommonFunctions().clearText(txtFirstName, "First Name");
		new CommonFunctions().enterKeys(txtFirstName,txtFirstNameInput, data, typeOfData, elementName);
//		new CommonFunctions().validateFieldWithalphabet(txtFirstName, "First Name", alphabet);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateFieldWithNotAcceptNumber(txtFirstName, "First Name", number);
//		new CommonFunctions().clearText(txtFirstName, "First Name");
//		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtFirstName, "First Name", specialChar);
	}

	public void validateLastNameField(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtLastName, "Last Name", singleDigit);
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateField(txtLastName, "Last Name", maxDigit);
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateFieldMaxichar(txtLastName, "Last Name", moreThanMax);
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateFieldWithalphabet(txtLastName, "Last Name", alphabet);
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateFieldWithNotAcceptNumber(txtLastName, "Last Name", number);
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtLastName, "Last Name", specialChar);
	}

	// payment Method Field Validations

	public void validateConfirmAccountNumField(String singleChar, String maxChar, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtConfirmAccNumber, "Confirm Account Number", singleChar);
		new CommonFunctions().clearText(txtConfirmAccNumber, "Confirm Account Number");
		new CommonFunctions().validateField(txtConfirmAccNumber, "Confirm Account Number", maxChar);
		new CommonFunctions().clearText(txtConfirmAccNumber, "Confirm Account Number");
		new CommonFunctions().validateFieldMaxichar(txtConfirmAccNumber, "Confirm Account Number", moreThanMax);
		new CommonFunctions().clearText(txtConfirmAccNumber, "Confirm Account Number");
		new CommonFunctions().validateFieldWithalphabet(txtConfirmAccNumber, "Confirm Account Number", alphabet);
		new CommonFunctions().clearText(txtConfirmAccNumber, "Confirm Account Number");
		new CommonFunctions().validateFieldWithNumber(txtConfirmAccNumber, "Confirm Account Number", number);
		new CommonFunctions().clearText(txtConfirmAccNumber, "Confirm Account Number");
		new CommonFunctions().validateFieldWithSpecialchar(txtConfirmAccNumber, "Confirm Account Number", specialChar);
	}

	public void validateAccountNumField(String singleChar, String maxChar, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtAccNumber, "Account Number", singleChar);
		new CommonFunctions().clearText(txtAccNumber, "Account Number");
		new CommonFunctions().validateField(txtAccNumber, "Account Number", maxChar);
		new CommonFunctions().clearText(txtAccNumber, "Account Number");
		new CommonFunctions().validateFieldMaxichar(txtAccNumber, "Account Number", moreThanMax);
		new CommonFunctions().clearText(txtAccNumber, "Account Number");
		new CommonFunctions().validateFieldWithalphabet(txtAccNumber, "Account Number", alphabet);
		new CommonFunctions().clearText(txtAccNumber, "Account Number");
		new CommonFunctions().validateFieldWithNumber(txtAccNumber, "Account Number", number);
		new CommonFunctions().clearText(txtAccNumber, "Account Number");
		new CommonFunctions().validateFieldWithSpecialchar(txtAccNumber, "Account Number", specialChar);
	}

	public void validateConfirmRoutingField(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtConfirmRouting, "Confirm Routing Number", singleDigit);
		new CommonFunctions().clearText(txtConfirmRouting, "Confirm Routing Number");
		new CommonFunctions().validateField(txtConfirmRouting, "Confirm Routing Number", maxDigit);
		new CommonFunctions().clearText(txtConfirmRouting, "Confirm Routing NUmber");
		new CommonFunctions().validateFieldMaxichar(txtConfirmRouting, "Confirm Routing NUmber", moreThanMax);
		new CommonFunctions().clearText(txtConfirmRouting, "Confirm Routing NUmber");
		new CommonFunctions().validateFieldWithNotAcceptAlphabet(txtConfirmRouting, "Confirm Routing NUmber", alphabet);
		new CommonFunctions().clearText(txtConfirmRouting, "Confirm Routing NUmber");
		new CommonFunctions().validateFieldWithNumber(txtConfirmRouting, "Confirm Routing NUmber", number);
		new CommonFunctions().clearText(txtConfirmRouting, "Confirm Routing NUmber");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtConfirmRouting, "Confirm Routing NUmber",
				specialChar);
	}

	public void validateNameOnBankField(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().clearText(txtNameOnBank, "Name On Bank");
		new CommonFunctions().validateField(txtNameOnBank, "Name On Bank", singleDigit);
		new CommonFunctions().clearText(txtNameOnBank, "Name On Bank");
		new CommonFunctions().validateField(txtNameOnBank, "Name On Bank", maxDigit);
		new CommonFunctions().clearText(txtNameOnBank, "Name On Bank");
		new CommonFunctions().validateFieldMaxichar(txtNameOnBank, "Name On Bank", moreThanMax);
		new CommonFunctions().clearText(txtNameOnBank, "Name On Bank");
		new CommonFunctions().validateFieldWithalphabet(txtNameOnBank, "Name On Bank", alphabet);
		new CommonFunctions().clearText(txtNameOnBank, "Name On Bank");
		new CommonFunctions().validateFieldWithNotAcceptNumber(txtNameOnBank, "Name On Bank", number);
		new CommonFunctions().clearText(txtNameOnBank, "Name On Bank");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtNameOnBank, "Name On Bank", specialChar);
	}

	public void validateRoutingNumField(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtRoutingNumber, "Routing Number", singleDigit);
		new CommonFunctions().clearText(txtRoutingNumber, "Routing Number");
		new CommonFunctions().validateField(txtRoutingNumber, "Routing Number", maxDigit);
		new CommonFunctions().clearText(txtRoutingNumber, "Routing Number");
		new CommonFunctions().validateFieldMaxichar(txtRoutingNumber, "Routing Number", moreThanMax);
		new CommonFunctions().clearText(txtRoutingNumber, "Routing Number");
		new CommonFunctions().validateFieldWithalphabet(txtRoutingNumber, "Routing Number", alphabet);
		new CommonFunctions().clearText(txtRoutingNumber, "Routing Number");
		new CommonFunctions().validateFieldWithNotAcceptNumber(txtRoutingNumber, "Routing Number", number);
		new CommonFunctions().clearText(txtRoutingNumber, "Routing Number");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtRoutingNumber, "Routing Number", specialChar);
	}

	// Field Validations of Cards

	public void validateNameOnCardField(String singleChar, String maxChar, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtNameOnCard, "Name On Card", singleChar);
		new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
		new CommonFunctions().validateField(txtNameOnCard, "Name On Card", maxChar);
		new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
		new CommonFunctions().validateFieldMaxichar(txtNameOnCard, "Name On Card", moreThanMax);
		new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
		new CommonFunctions().validateFieldWithalphabet(txtNameOnCard, "Name On Card", alphabet);
		new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
		new CommonFunctions().validateFieldWithNumber(txtNameOnCard, "Name On Card", number);
		new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
		new CommonFunctions().validateFieldWithSpecialchar(txtNameOnCard, "Name On Card", specialChar);
	}

	public void validateCardNumberField(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtCardNumber, "Card Number", singleDigit);
		new CommonFunctions().clearText(txtCardNumber, "Card Number");
		new CommonFunctions().validateField(txtCardNumber, "Card Number", maxDigit);
		new CommonFunctions().clearText(txtCardNumber, "Card Number");
		new CommonFunctions().validateFieldMaxichar(txtCardNumber, "Card Number", moreThanMax);
		new CommonFunctions().clearText(txtCardNumber, "Card Number");
		new CommonFunctions().validateFieldWithNotAcceptAlphabet(txtCardNumber, "Card Number", alphabet);
		new CommonFunctions().clearText(txtCardNumber, "Card Number");
		new CommonFunctions().validateFieldWithNumber(txtCardNumber, "Card Number", number);
		new CommonFunctions().clearText(txtCardNumber, "Card Number");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtCardNumber, "Card Number", specialChar);
	}

	public void validateCardExpField(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtCardExp, "Card Exp", singleDigit);
		new CommonFunctions().clearText(txtCardExp, "Card Exp");
		new CommonFunctions().validateField(txtCardExp, "Card Exp", maxDigit);
		new CommonFunctions().clearText(txtCardExp, "Card Exp");
		new CommonFunctions().validateFieldMaxichar(txtCardExp, "Card Exp", moreThanMax);
		new CommonFunctions().clearText(txtCardExp, "Card Exp");
		new CommonFunctions().validateFieldWithalphabet(txtCardExp, "Card Exp", alphabet);
		new CommonFunctions().clearText(txtCardExp, "Card Exp");
		new CommonFunctions().validateFieldWithNotAcceptNumber(txtCardExp, "Card Exp", number);
		new CommonFunctions().clearText(txtCardExp, "Card Exp");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtCardExp, "Card Exp", specialChar);
	}

	public void validateAddressLine1Field(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtAddressLine1, "Address Line 1", singleDigit);
		new CommonFunctions().clearText(txtAddressLine1, "Address Line 1");
		new CommonFunctions().validateField(txtAddressLine1, "Address Line 1", maxDigit);
		new CommonFunctions().clearText(txtAddressLine1, "Address Line 1");
		new CommonFunctions().validateFieldMaxichar(txtAddressLine1, "Address Line 1", moreThanMax);
		new CommonFunctions().clearText(txtAddressLine1, "Address Line 1");
		new CommonFunctions().validateFieldWithalphabet(txtAddressLine1, "Address Line 1", alphabet);
		new CommonFunctions().clearText(txtAddressLine1, "Address Line 1");
		new CommonFunctions().validateFieldWithNotAcceptNumber(txtAddressLine1, "Address Line 1", number);
		new CommonFunctions().clearText(txtAddressLine1, "Address Line 1");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtAddressLine1, "Address Line 1", specialChar);
	}

	public void validateAddressLine2Field(String singleChar, String maxChar, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtAddressLine2, "Address Line 2", singleChar);
		new CommonFunctions().clearText(txtAddressLine2, "Address Line 2");
		new CommonFunctions().validateField(txtAddressLine2, "Address Line 2", maxChar);
		new CommonFunctions().clearText(txtAddressLine2, "Address Line 2");
		new CommonFunctions().validateFieldMaxichar(txtAddressLine2, "Address Line 2", moreThanMax);
		new CommonFunctions().clearText(txtAddressLine2, "Address Line 2");
		new CommonFunctions().validateFieldWithalphabet(txtAddressLine2, "Address Line 2", alphabet);
		new CommonFunctions().clearText(txtAddressLine2, "Address Line 2");
		new CommonFunctions().validateFieldWithNumber(txtAddressLine2, "Address Line 2", number);
		new CommonFunctions().clearText(txtAddressLine2, "Address Line 2");
		new CommonFunctions().validateFieldWithSpecialchar(txtAddressLine2, "Address Line 2", specialChar);
	}

	public void validateCityField(String singleChar, String maxChar, String moreThanMax, String alphabet, String number,
			String specialChar) {
		new CommonFunctions().validateField(txtCity, "City", singleChar);
		new CommonFunctions().clearText(txtCity, "City");
		new CommonFunctions().validateField(txtCity, "City", maxChar);
		new CommonFunctions().clearText(txtCity, "City");
		new CommonFunctions().validateFieldMaxichar(txtCity, "City", moreThanMax);
		new CommonFunctions().clearText(txtCity, "City");
		new CommonFunctions().validateFieldWithalphabet(txtCity, "City", alphabet);
		new CommonFunctions().clearText(txtCity, "City");
		new CommonFunctions().validateFieldWithNumber(txtCity, "City", number);
		new CommonFunctions().clearText(txtCity, "City");
		new CommonFunctions().validateFieldWithSpecialchar(txtCity, "City", specialChar);
	}

	public void validateStateSearchField(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().validateField(txtStateSearch, "State Search", singleDigit);
		new CommonFunctions().clearText(txtStateSearch, "State Search");
		new CommonFunctions().validateField(txtStateSearch, "State Search", maxDigit);
		new CommonFunctions().clearText(txtStateSearch, "State Search");
		new CommonFunctions().validateFieldMaxichar(txtStateSearch, "State Search", moreThanMax);
		new CommonFunctions().clearText(txtStateSearch, "State Search");
		new CommonFunctions().validateFieldWithNotAcceptAlphabet(txtStateSearch, "State Search", alphabet);
		new CommonFunctions().clearText(txtStateSearch, "State Search");
		new CommonFunctions().validateFieldWithNumber(txtStateSearch, "State Search", number);
		new CommonFunctions().clearText(txtStateSearch, "State Search");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtStateSearch, "State Search", specialChar);
	}

	public void validateZipCodeField(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		new CommonFunctions().validateField(txtZipCode, "Zip Code", singleDigit);
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		new CommonFunctions().validateField(txtZipCode, "Zip Code", maxDigit);
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		new CommonFunctions().validateFieldMaxichar(txtZipCode, "Zip Code", moreThanMax);
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		new CommonFunctions().validateFieldWithalphabet(txtZipCode, "Zip Code", alphabet);
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		new CommonFunctions().validateFieldWithNotAcceptNumber(txtZipCode, "Zip Code", number);
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtZipCode, "Zip Code", specialChar);
	}

	public void validatetSignetWalletIdField(String singleDigit, String maxDigit, String moreThanMax, String alphabet,
			String number, String specialChar) {
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");
		new CommonFunctions().validateField(txtSignetWalletId, "Signet Wallet Id", singleDigit);
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");
		new CommonFunctions().validateField(txtSignetWalletId, "Signet Wallet Id", maxDigit);
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");
		new CommonFunctions().validateFieldMaxichar(txtSignetWalletId, "Signet Wallet Id", moreThanMax);
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");
		new CommonFunctions().validateFieldWithalphabet(txtSignetWalletId, "Signet Wallet Id", alphabet);
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");
		new CommonFunctions().validateFieldWithNotAcceptNumber(txtSignetWalletId, "Signet Wallet Id", number);
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");
		new CommonFunctions().validateFieldWithNotAcceptSpecialchar(txtSignetWalletId, "Signet Wallet Id", specialChar);
	}

}
