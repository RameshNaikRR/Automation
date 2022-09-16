package coyni.merchant.components;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class AddBeneficialOwnersComponent extends BrowserFunctions {

	private By txtFirstName = By.name("firstName");
	private By txtLastName = By.name("lastName");
	private By txtCity = By.name("city");
	private By drpDwnState = By.xpath("//div[text()='State']/parent::div");
	private By txtZipCode = By.name("zipCode");
	private By txtCountry = By.xpath("//div[text()='Country']/following-sibling::*[1]");
	private By btnSave = By.xpath("//button[@type=\"submit\"]");
	private By lblState = By.xpath("//div[text()='State']/parent::div");
	private By txtDateOfBirth = By.name("dateOfBirth");
	private By txtSocialSecurity = By.name("ssn");
	private By txtOwnership = By.name("ownership");
	private By txtAddress1 = By.name("addressLine1");
	private By txtAddress2 = By.name("addressLine2");

//	public void getTextField(By ele, String text, String eleName, int i) {
//		List<WebElement> eleList = DriverFactory.getDriver().findElements(ele);
//		// eleList.get(i).clear();
//		eleList.get(i).sendKeys(text);
//		ExtentTestManager.setInfoMessageInReport(text + "Text entered in the Text Field" + eleName);
//	}

	public void fillFirstName(String firstName) throws InterruptedException {
		// clearText(txtFirstName, "First Name");
		enterText(txtFirstName, firstName, "First Name");
		// getTextField(txtFirstName, firstName, "firstName", i);
	}

	public void fillLastName(String lastName) throws InterruptedException {
		// clearText(txtLastName, "Last Name");
		enterText(txtLastName, lastName, "Last Name");
		// getTextField(txtLastName, lastName, "lastName", i);
	}

	public void fillAddress1(String address1) throws InterruptedException {
		// clearText(txtAddress1, "address line 1");
		enterText(txtAddress1, address1, "address line 1");
		// getTextField(txtAddress1, address1, "address line 1", i);
	}

	public void fillAddress2(String address2) throws InterruptedException {
		// clearText(txtAddress2, "address line 2");
		enterText(txtAddress2, address2, "address line 2");
		// getTextField(txtAddress2, address2, "address line 2", i);
	}

	public void fillCity(String city) throws InterruptedException {
		// clearText(txtCity, "city");
		enterText(txtCity, city, "city");
		// getTextField(txtCity, city, "city", i);
	}

	public void selectState(String state) {
		click(drpDwnState, "State DropDown");
		click(getElement(state), state);
	}

	public By getElement(String state) {
		return By.xpath(String.format("//div[text()='%s']", state));
	}

	public void selectState(String state, int i) {
		List<WebElement> eleList = DriverFactory.getDriver().findElements(drpDwnState);
		eleList.get(i).click();
		ExtentTestManager.setInfoMessageInReport("clicked on element dropdown");
		Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
		click(getElement(state), state);
	}

	public void fillZipCode(String zipCode) throws InterruptedException {
		// clearText(txtZipCode, "ZipCode");
		// enterText(txtZipCode, zipCode, "Zipcode");
		enterText(txtZipCode, zipCode, "ZipCode");
		// getTextField(txtZipCode, zipCode, "ZipCode", i);
	}

	public void verifyCountry(String country) {
		new CommonFunctions().verifyLabelText(txtCountry, "country", country);
	}

	public void fillOwnerShip(String ownerShip) throws InterruptedException {
		// clearText(txtOwnership, "Ownership");
		enterText(txtOwnership, ownerShip, "Ownership");
		// getTextField(txtOwnership, ownerShip, "ownerShip", i);
	}

	public void clickSave() {
		click(btnSave, "click save");
	}

	public void clickstate() {
		click(lblState, "State");
	}

	public void clickCountry() {
		click(txtCountry, "Country");
	}

	public void fillDateOfBirth(String dateOfBirth) throws InterruptedException {
		// clearText(txtDateOfBirth, "Date of Birth");
		enterText(txtDateOfBirth, dateOfBirth, "Date of Birth");
		// getTextField(txtDateOfBirth, dateOfBirth, "Date of Birth", i);
	}

	public void fillSocialSecurityNum(String socialSecurityNum) throws InterruptedException {
		// clearText(txtSocialSecurity, "Social Security Number");
		enterText(txtSocialSecurity, socialSecurityNum, "Social Security Number");
		// getTextField(txtSocialSecurity, socialSecurityNum, "Social Security Number",
		// i);
	}

//	public By getElement(String state) {
//		return By.xpath(String.format("//div[text()='%s']", state));
//	}

	/**
	 * Order -minChar, minCharPlus, maxCharMinus, maxChar, maxiPlus
	 */
	public void validateNameField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
	}

	public void validateFirstNameField(String firstName) {
		validateNameField(txtFirstName, "First Name", firstName);
	}

	public void validateLastNameField(String LastName) {
		validateNameField(txtLastName, "Last Name", LastName);
	}

	public void validateAddline1Field(String Addline1) {
		validateNameField(txtAddress1, "Mailing Address line 1 ", Addline1);
	}

	public void validateAddline2Field(String Addline2) {
		validateNameField(txtAddress2, "Mailing Address line 2", Addline2);
	}

	public void validateCityField(String city) {
		validateNameField(txtCity, "City", city);
	}

	public void validateSSNField(String ssn) {
		validateNumber(txtSocialSecurity, "SSN", ssn);
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
}
