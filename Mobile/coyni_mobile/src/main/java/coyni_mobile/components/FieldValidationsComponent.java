package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FieldValidationsComponent extends MobileFunctions {
	private By txtEmail = MobileBy.id("com.coyni.mapp:id/emailET");
	private By txtNewEmail = MobileBy.xpath("//*[contains(@resource-id,'b_newEmailET')]");
	private By txtNewPassword = MobileBy.AccessibilityId("New Password");
	private By txtConfirmPassword = MobileBy.AccessibilityId("Confirm Password");
	private By txtPassword = MobileBy.AccessibilityId("Password");
	private By txtPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'etPhoneNo')]");
	private By txtFirstName = MobileBy.xpath(
			"//*[contains(@resource-id,'firstNameET')]|//*[contains(@resource-id,'etFName')]/descendant::android.widget.EditText");
	private By txtLastName = MobileBy.xpath(
			"//*[contains(@resource-id,'lastNameET')]|//*[contains(@resource-id,'etLName')]/descendant::android.widget.EditText|//*[contains(@resource-id,'etLName')]");
	// Payment Methods - Card validations
	private By txtAmount = MobileBy.xpath(
			"//*[contains(@resource-id,'amountET')]|//*[contains(@resource-id,'payrequestET')]|//*[contains(@resource-id,'etAmount')]");
	private By txtNameOnCard = MobileBy.id("com.coyni.mapp:id/etName");
	private By txtCardNumber = MobileBy.id("com.coyni.mapp:id/pnET");
	private By txtCardExp = MobileBy.id("com.coyni.mapp:id/etExpiry");
	private By txtCVVorCVC = MobileBy.id("com.coyni.mapp:id/etCVV");
	private By txtAddressLine1 = MobileBy.xpath(
			"//*[contains(@resource-id,'etAddress1')]|//*[contains(@resource-id,'addressLineOneET')]|//*[contains(@resource-id,'companyaddressET')]");
	private By txtAddressLine2 = MobileBy.xpath(
			"//*[contains(@resource-id,'etAddress2')]|//*[contains(@resource-id,'addressLineTwoET')]|//*[contains(@resource-id,'companyaddress2ET')]");
	private By txtCity = MobileBy.xpath(
			"//*[contains(@resource-id,'etCity')]|//*[contains(@resource-id,'cityET')]|//*[contains(@resource-id,'cityET')]");
	private By txtSearch = MobileBy
			.xpath("//*[contains(@resource-id,'searchET')]|//*[contains(@resource-id,'payoutSearchET')]");
	private By txtZipCode = MobileBy
			.xpath("//*[contains(@resource-id,'etZipCode')]|//*[contains(@resource-id,'zipcodeET')]");
	private By txtSignetWalletId = MobileBy.xpath("//*[contains(@resource-id,'etWalletId')]");

	public void validateEmailField(String singleChar, String maxChar, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", singleChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateFieldMaxichar(txtEmail, "Email", moreThanMax);
		new CommonFunctions().clearText(txtEmail, "Email");

	}

	public void validateNewEmailField(String singleChar, String maxChar, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().validateField(txtNewEmail, "New Email", singleChar);
		new CommonFunctions().clearText(txtNewEmail, "New Email");
		new CommonFunctions().validateField(txtNewEmail, "New Email", maxChar);
		new CommonFunctions().clearText(txtNewEmail, "New Email");
		new CommonFunctions().validateFieldMaxichar(txtNewEmail, "New Email", moreThanMax);
		new CommonFunctions().clearText(txtNewEmail, "New Email");

	}

	public void validateNewPasswordField(String minChar, String maxChar, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		for (int i = 0; i <= 2; i++) {
			new CommonFunctions().validateField(txtNewPassword, "New Password", minChar);
			new CommonFunctions().clearText(txtNewPassword, "New Password");
			new CommonFunctions().validateField(txtNewPassword, "New Password", maxChar);
			new CommonFunctions().clearText(txtNewPassword, "New Password");
			new CommonFunctions().validateFieldMaxichar(txtNewPassword, "New Password", moreThanMax);
		}
	}

	public void validateConfirmPasswordField(String singleChar, String maxChar, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().validateField(txtConfirmPassword, "Confirm Password", singleChar);
		new CommonFunctions().clearText(txtConfirmPassword, "Confirm Password");
		new CommonFunctions().validateField(txtConfirmPassword, "Confirm Password", maxChar);
		new CommonFunctions().clearText(txtConfirmPassword, "Confirm Password");
		new CommonFunctions().validateFieldMaxichar(txtConfirmPassword, "Confirm Password", moreThanMax);
		new CommonFunctions().clearText(txtConfirmPassword, "Confirm Password");
	}

	public void validatePasswordField(String minChar, String maxChar, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().validateField(txtPassword, "password", minChar);
		new CommonFunctions().clearText(txtPassword, "password");
		new CommonFunctions().validateField(txtPassword, "password", maxChar);
		new CommonFunctions().clearText(txtPassword, "password");
		new CommonFunctions().validateFieldMaxichar(txtPassword, "password", moreThanMax);
		new CommonFunctions().clearText(txtPassword, "password");
//		new CommonFunctions().validateField(txtPassword, "password", currentPassword);
	}

	public void validateAmountField(String singleDigit, String maxDigit, String moreThanMax)
			throws InterruptedException {
//		DriverFactory.getDriver().hideKeyboard();
//		new CommonFunctions().enterSpecialKey(txtAmount, txtAmount, "Amount");
		new CommonFunctions().validateField(txtAmount, "Amount", singleDigit);
		new CommonFunctions().clearText(txtAmount, "Amount");
		new CommonFunctions().validateField(txtAmount, "Amount", maxDigit);
		new CommonFunctions().clearText(txtAmount, "Amount");
		new CommonFunctions().validateFieldMaxichar(txtAmount, "Amount", moreThanMax);
//		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
	}

	public void validatePhoneNumberField(String singleDigit, String maxDigit, String moreThanMax)
			throws InterruptedException {
//		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
		new CommonFunctions().enterSpecialKey(txtPhoneNumber, "Phone Number");
		new CommonFunctions().validateField(txtPhoneNumber, "Phone Number", singleDigit);
		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
		new CommonFunctions().validateField(txtPhoneNumber, "Phone Number", maxDigit);
		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
		new CommonFunctions().validateFieldMaxichar(txtPhoneNumber, "Phone Number", moreThanMax);
//		new CommonFunctions().clearText(txtPhoneNumber, "Phone Number");
	}

	public void validateFirstNameField(String singleDigit, String maxDigit, String moreThanMax, String numbers,
			String keyBoardType) throws InterruptedException {
//		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clearText(txtFirstName, "First Name");
		new CommonFunctions().enterKeys(txtFirstName, numbers, keyBoardType, "First Name");
		new CommonFunctions().enterSpecialKey(txtFirstName, "First Name");
		new CommonFunctions().validateField(txtFirstName, "First Name", singleDigit);
		new CommonFunctions().clearText(txtFirstName, "First Name");
		new CommonFunctions().validateField(txtFirstName, "First Name", maxDigit);
		new CommonFunctions().clearText(txtFirstName, "First Name");
		new CommonFunctions().validateFieldMaxichar(txtFirstName, "First Name", moreThanMax);
		new CommonFunctions().clearText(txtFirstName, "First Name");
	}

	public void validateLastNameField(String singleDigit, String maxDigit, String moreThanMax, String numbers,
			String keyBoardType) throws InterruptedException {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().enterKeys(txtLastName, numbers, keyBoardType, "Last Name");
//		new CommonFunctions().enterSpecialKey(txtLastName,txtFirstNameInput,"Last Name");
		new CommonFunctions().validateField(txtLastName, "Last Name", singleDigit);
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateField(txtLastName, "Last Name", maxDigit);
		new CommonFunctions().clearText(txtLastName, "Last Name");
		new CommonFunctions().validateFieldMaxichar(txtLastName, "Last Name", moreThanMax);
		new CommonFunctions().clearText(txtLastName, "Last Name");
	}

	// Field Validations of Cards

	public void validateNameOnCardField(String singleChar, String maxChar, String moreThanMax, String numbers,
			String keyBoardType) throws InterruptedException {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
		new CommonFunctions().enterKeys(txtNameOnCard, numbers, keyBoardType, "Name On Card");
		new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
		new CommonFunctions().enterSpecialKey(txtNameOnCard, "Name On Card");
		new CommonFunctions().validateField(txtNameOnCard, "Name On Card", singleChar);
		new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
		new CommonFunctions().validateField(txtNameOnCard, "Name On Card", maxChar);
		new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
		new CommonFunctions().validateFieldMaxichar(txtNameOnCard, "Name On Card", moreThanMax);
		// new CommonFunctions().clearText(txtNameOnCard, "Name On Card");
	}

	public void validateCardNumberField(String singleDigit, String maxDigit, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clearText(txtCardNumber, "Card Number");
		new CommonFunctions().enterSpecialKey(txtCardNumber, "Card Number");
		new CommonFunctions().clearText(txtCardNumber, "Card Number");
		new CommonFunctions().validateField(txtCardNumber, "Card Number", singleDigit);
		new CommonFunctions().clearText(txtCardNumber, "Card Number");
		new CommonFunctions().validateField(txtCardNumber, "Card Number", maxDigit);
		new CommonFunctions().clearText(txtCardNumber, "Card Number");
		new CommonFunctions().validateFieldMaxichar(txtCardNumber, "Card Number", moreThanMax);
		// new CommonFunctions().clearText(txtCardNumber, "Card Number");
	}

	public void validateCvvField(String singleDigit, String maxDigit, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clearText(txtCVVorCVC, "CVVorCVC");
		new CommonFunctions().enterSpecialKey(txtCVVorCVC, "CVVorCVC");
		new CommonFunctions().clearText(txtCVVorCVC, "CVVorCVC");
		new CommonFunctions().validateField(txtCVVorCVC, "CVVorCVC", singleDigit);
		new CommonFunctions().clearText(txtCVVorCVC, "CVVorCVC");
		new CommonFunctions().validateField(txtCVVorCVC, "CVVorCVC", maxDigit);
		new CommonFunctions().clearText(txtCVVorCVC, "CVVorCVC");
		new CommonFunctions().validateFieldMaxichar(txtCVVorCVC, "CVVorCVC", moreThanMax);
	}

	public void validateCardExpField(String singleDigit, String maxDigit, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clearText(txtCardExp, "Card Exp");
		new CommonFunctions().enterSpecialKey(txtCardExp, "Card Exp");
		new CommonFunctions().clearText(txtCardExp, "Card Exp");
		new CommonFunctions().validateField(txtCardExp, "Card Exp", singleDigit);
		new CommonFunctions().clearText(txtCardExp, "Card Exp");
		new CommonFunctions().validateField(txtCardExp, "Card Exp", maxDigit);
		new CommonFunctions().clearText(txtCardExp, "Card Exp");
		new CommonFunctions().validateFieldMaxichar(txtCardExp, "Card Exp", moreThanMax);
		// new CommonFunctions().clearText(txtCardExp, "Card Exp");
	}

	public void validateAddressLine1Field(String singleDigit, String maxDigit, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().validateField(txtAddressLine1, "Address Line 1", singleDigit);
		new CommonFunctions().clearText(txtAddressLine1, "Address Line 1");
		new CommonFunctions().validateField(txtAddressLine1, "Address Line 1", maxDigit);
		new CommonFunctions().clearText(txtAddressLine1, "Address Line 1");
		new CommonFunctions().validateFieldMaxichar(txtAddressLine1, "Address Line 1", moreThanMax);
//		new CommonFunctions().clearText(txtAddressLine1, "Address Line 1");
	}

	public void validateAddressLine2Field(String singleChar, String maxChar, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().validateField(txtAddressLine2, "Address Line 2", singleChar);
		new CommonFunctions().clearText(txtAddressLine2, "Address Line 2");
		new CommonFunctions().validateField(txtAddressLine2, "Address Line 2", maxChar);
		new CommonFunctions().clearText(txtAddressLine2, "Address Line 2");
		new CommonFunctions().validateFieldMaxichar(txtAddressLine2, "Address Line 2", moreThanMax);
//		new CommonFunctions().clearText(txtAddressLine2, "Address Line 2");

	}

	public void validateCityField(String singleChar, String maxChar, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().validateField(txtCity, "City", singleChar);
		new CommonFunctions().clearText(txtCity, "City");
		new CommonFunctions().validateField(txtCity, "City", maxChar);
		new CommonFunctions().clearText(txtCity, "City");
		new CommonFunctions().validateFieldMaxichar(txtCity, "City", moreThanMax);
//		new CommonFunctions().clearText(txtCity, "City");

	}

	public void validateSearchField(String singleDigit, String maxDigit, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().validateField(txtSearch, "Search", singleDigit);
		new CommonFunctions().clearText(txtSearch, "Search");
		new CommonFunctions().validateField(txtSearch, "Search", maxDigit);
		new CommonFunctions().clearText(txtSearch, "Search");
		new CommonFunctions().validateFieldMaxichar(txtSearch, "Search", moreThanMax);
		new CommonFunctions().clearText(txtSearch, "Search");

	}

	public void validateZipCodeField(String singleDigit, String maxDigit, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		scrollDownToElement(txtZipCode, "Zip Code");
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		new CommonFunctions().validateField(txtZipCode, "Zip Code", singleDigit);
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		new CommonFunctions().validateField(txtZipCode, "Zip Code", maxDigit);
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		new CommonFunctions().validateFieldMaxichar(txtZipCode, "Zip Code", moreThanMax);
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
	}

	public void validatetCogentWalletIdField(String singleDigit, String maxDigit, String moreThanMax) {
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");
		new CommonFunctions().validateField(txtSignetWalletId, "Signet Wallet Id", singleDigit);
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");
		new CommonFunctions().validateField(txtSignetWalletId, "Signet Wallet Id", maxDigit);
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");
		new CommonFunctions().validateFieldMaxichar(txtSignetWalletId, "Signet Wallet Id", moreThanMax);
		new CommonFunctions().clearText(txtSignetWalletId, "Signet Wallet Id");

	}

}
