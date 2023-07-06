package coyni.business.components;

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
	private By txtState = By.name("state");
	private By drpdwnCountry = By.xpath("");
	private By drpDwnState = By.xpath("//div[text()='State']/parent::div");
	private By txtZipCode = By.xpath("//input[@id='zip-code-0']");
	private By txtCountry = By.xpath("//div[text()='Country']/following-sibling::*[1]");
	private By btnSave = By.xpath("//button[@type=\"submit\"]");
	private By lblState = By.xpath("//div[text()='State']/parent::div");
	private By txtDateOfBirth = By.name("dateOfBirth");
	private By txtSocialSecurity = By.name("ssn");
	private By txtOwnership = By.name("ownership");
	private By txtAddress1 = By.name("addressLine1");
	private By txtAddress2 = By.name("addressLine2");
	private By txtEmail = By.xpath("");
	private By txtPhoneNumber = By.xpath("");
	private By drpDownCountryCitizen = By.xpath("");
	private By clickCheckBox = By.xpath("");
	private By btnNext = By.xpath("");

	public void getTextField(By ele, String text, String eleName, int i) {
		List<WebElement> eleList = DriverFactory.getDriver().findElements(ele);
		eleList.get(i).sendKeys(text);
		ExtentTestManager.setInfoMessageInReport(text + "Text entered in the Text Field" + eleName);
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickCheckBox() {
		if (getElement(clickCheckBox, "checkbox").isEnabled()) {
			click(clickCheckBox, "checkbox");
		} else {
			clickNext();
		}
	}

	public void fillFirstName(String firstName, int i) {

		getTextField(txtFirstName, firstName, "firstName", i);
	}

	public void fillLastName(String lastName, int i) {
		getTextField(txtLastName, lastName, "lastName", i);
	}

	public void fillAddress1(String address1, int i) {
		getTextField(txtAddress1, address1, "address line 1", i);
	}

	public void fillAddress2(String address2, int i) {
		getTextField(txtAddress2, address2, "address line 2", i);
	}

	public void fillCity(String city, int i) {
		getTextField(txtCity, city, "city", i);
	}

	public void fillState(String state, int i) {
		getTextField(txtState, state, "State", i);
	}

	public void fillEmail(String Email) {
		enterText(txtEmail, Email, "Email");
	}

	public void fillPhoneNumber(String PhoneNumber) {
		enterText(txtPhoneNumber, PhoneNumber, "Phone Number");
	}

	public void selectCountry(String country) {
		click(drpdwnCountry, "Country");
		By countryName = By.xpath(String.format("", country));
		click(countryName, country);
	}

	public void selectCountryCitizen(String countrycitizen) {
		click(drpDownCountryCitizen, "Country");
		By countryName = By.xpath(String.format("", countrycitizen));
		click(countryName, countrycitizen);
	}

	public void selectState(String state, int i) {
		List<WebElement> eleList = DriverFactory.getDriver().findElements(drpDwnState);
		eleList.get(i).click();
		ExtentTestManager.setInfoMessageInReport("clicked on element dropdown");
		Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
		click(getElement(state), state);
	}

	public void fillZipCode(String zipCode) {
		enterText(txtZipCode, zipCode, "ZipCode");
	}

	public void verifyCountry(String country) {
		new CommonFunctions().verifyLabelText(txtCountry, "country", country);
	}

	public void fillOwnerShip(String ownerShip, int i) {
		getTextField(txtOwnership, ownerShip, "ownerShip", i);
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

	public void fillDateOfBirth(String dateOfBirth, int i) {
		getTextField(txtDateOfBirth, dateOfBirth, "Date of Birth", i);
	}

	public void fillSocialSecurityNum(String socialSecurityNum, int i) {
		getTextField(txtSocialSecurity, socialSecurityNum, "Social Security Number", i);
	}

	public By getElement(String state) {
		return By.xpath(String.format("//div[text()='%s']", state));
	}

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
