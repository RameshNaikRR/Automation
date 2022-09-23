package coyni.merchant.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.merchant.pages.RegistrationDBAInformationPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class MailingAddressComponent extends BrowserFunctions {

	private By txtFirstName = By.name("firstName");
	private By txtLastName = By.name("lastName");
	private By txtCity = By.name("city");
	private By drpDwnState = By.xpath("//div[text()='State']/parent::div");
	private By txtZipCode = By.name("zipCode");
	private By labelCardBrand = By.xpath("//div[contains(@class,'absolute right-0 -top-0.5 text-3xl')]");
	private By txtCountry = By.xpath("//div[text()='Country']/following-sibling::*[1]");
	private By btnSave = By.xpath("//button[@type=\"submit\"]");
	private By lblState = By.xpath("//div[text()='State']/parent::div");
	// private By zipCode = By.cssSelector("#zip-code");
	private By txtDateOfBirth = By.name("dateOfBirth");
	private By txtSocialSecurity = By.name("ssn");
	private By txtOwnership = By.name("ownership");
	private By txtAddress1 = By.name("addressLine1");
	private By txtAddress2 = By.name("addressLine2");
	private By lblgetState = By.xpath("//div[text()='State']/following-sibling::*[1]");

	public By getElement(String state) {
		return By.xpath(String.format("//div[text()='%s']", state));
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
	}

	public void fillAddress1(String address1) {
		enterText(txtAddress1, address1, "address line 1");
	}

	public void fillAddress2(String address2) {
		enterText(txtAddress2, address2, "address line 2");
	}

	public void fillCity(String city) {
		enterText(txtCity, city, "city");
	}

	public void selectState(String state) {
		click(drpDwnState, "State DropDown");
		click(getElement(state), state);
	}

	public void clickStateDropdown() {
		click(drpDwnState, "State DropDown");

	}

	public void fillZipCode(String zipCode) {
		enterText(txtZipCode, zipCode, "ZipCode");
	}

	public void verifyCountry(String country) {
		new CommonFunctions().verifyLabelText(txtCountry, country, "United States");
	}

	public void fillOwnerShip(String ownerShip) {
		enterText(txtOwnership, ownerShip, "ownerShip");
	}

	public void clickCountry() {
		click(txtCountry, "Country");
	}

	public void clickSave() {
		click(btnSave, "click save");
	}

	public void clickstate() {
		click(lblState, "State");
	}

//	public void FillZipCode(String ZipCode) {
//		enterText(zipCode, ZipCode, "ZipCode");
//	}
	public void fillDateOfBirth(String dateOfBirth) {
		enterText(txtDateOfBirth, dateOfBirth, "Date of Birth");
	}

	public void fillSocialSecurityNum(String socialSecurityNum) {
		enterText(txtSocialSecurity, socialSecurityNum, "Social Security Number");
	}

	public void clickTab() throws AWTException {
		new CommonFunctions().clickOutSideElement();
	}

	public void validateCardBrand(String cardType) {
		String brandClass = getAttributeValue(labelCardBrand, "class", "card brand");
		cardType = cardType.toLowerCase();
		if (brandClass.contains(cardType)) {
			ExtentTestManager.setPassMessageInReport("valid card type: " + cardType.toUpperCase());
		} else {
			ExtentTestManager.setFailMessageInReport("invalid card type: " + cardType.toUpperCase());
		}
	}

	public void validateAddress1(String address1) {
		validateTextField(txtAddress1, "Address1", address1);
	}

	public void validateAddress2(String address2) {
		validateTextField(txtAddress2, "Address2", address2);
	}

	public void validateCity(String city) {
		validateTextField(txtCity, "City", city);
	}

	public void validateZipCode(String zipCode) {
		validateNumberfield(txtZipCode, "ZipCode", zipCode);
	}

	public void verifyFirstNameView() {
		new CommonFunctions().elementView(txtFirstName, "FirstName");
	}

	public void verifyLastNameView() {
		new CommonFunctions().elementView(txtLastName, "LastName");
	}

	public void verifyDOBView() {
		new CommonFunctions().elementView(txtDateOfBirth, "Date Of Birth");
	}

	public void verifySSNView() {
		new CommonFunctions().elementView(txtSocialSecurity, "SSN");
	}

	public void verifyOwnershipView() {
		new CommonFunctions().elementView(txtOwnership, "OwnerShip");
	}

	public void verifyAddressLine1View() {
		new CommonFunctions().elementView(txtAddress1, "Mailing Address Line 1");
	}

	public void verifyAddressLine2View() {
		new CommonFunctions().elementView(txtAddress2, "Mailing AddressLine 2");
	}

	public void verifyCityView() {
		new CommonFunctions().elementView(txtCity, "City");
	}

	public void verifyDrpdwnStateView() {
		new CommonFunctions().elementView(drpDwnState, "State Dropdown");
	}

	public void verifyZipCodeView() {
		new CommonFunctions().elementView(txtZipCode, "ZipCode");
	}

	public void verifyUnitedStatesView() {
		new CommonFunctions().elementView(txtCountry, "Country-UnitedStates");
	}

	public void validateTextField(By ele, String eleName, String text) {
		String[] field = text.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
	}

	public void validateNumberfield(By ele, String elename, String text) {
		String[] field = text.split(",");
		new CommonFunctions().validateField(ele, elename, field[0]);
		new CommonFunctions().validateFieldMaxichar(ele, elename, field[1]);
	}

	public void verifyAddline1(String addline1) {
		// new RegistrationDBAInformationPage().verifyElementDisable(txtAddress1,
		// "addline1");
		new RegistrationDBAInformationPage().verifyTextBoxValue(txtAddress1, "addline1", addline1);
	}

	public void verifyAddline2(String addline2) {
		// new RegistrationDBAInformationPage().verifyElementDisable(txtAddress2,
		// "addline2");
		new RegistrationDBAInformationPage().verifyTextBoxValue(txtAddress2, "addline2", addline2);
	}

	public void verifyCity(String city) {
		// new RegistrationDBAInformationPage().verifyElementDisable(txtCity, "city");
		new RegistrationDBAInformationPage().verifyTextBoxValue(txtCity, "city", city);
	}

	public void verifyState(String state) {
		new RegistrationDBAInformationPage().verifyElementDisable(lblgetState, "state");
		if (getText(lblgetState, "").equals(state)) {
			ExtentTestManager.setPassMessageInReport(state + "is displayed");
		} else {
			ExtentTestManager.setFailMessageInReport(state + "is not displayed");
		}
	}

	public void verifyZipCode(String zipcode) {
		// new RegistrationDBAInformationPage().verifyElementDisable(txtZipCode,
		// "zipcode");
		new RegistrationDBAInformationPage().verifyTextBoxValue(txtZipCode, "zipcode", zipcode);
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}