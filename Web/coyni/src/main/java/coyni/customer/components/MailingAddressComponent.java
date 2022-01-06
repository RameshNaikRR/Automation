package coyni.customer.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.customer.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class MailingAddressComponent extends BrowserFunctions {

	private By txtAddress1 = By.name("addressLine1");
	private By txtAddress2 = By.name("addressLine2");
	private By txtCity = By.name("city");
	private By drpDwnState = By.xpath("//div[text()='State']/parent::div");
	private By txtZipCode = By.name("zipCode");
	private By labelCardBrand = By.xpath("//div[contains(@class,'absolute right-0 -top-0.5 text-3xl')]");
	private By txtCountry = By.xpath("//div[text()='Country']/following-sibling::*[1]");
	private By btnSave = By.xpath("//button[@type=\"submit\"]");
	private By lblState = By.xpath("//div[text()='State']/parent::div");
	private By zipCode = By.xpath("//input[@id='zip-code']/parent::div");
	private By txtDateOfBirth =By.cssSelector("#date-of-birth");
	private By txtSocialSecurity =By.cssSelector("#social-security-no");

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
		new CommonFunctions().selectCustomDropDown(state, "State");
	}

	public void fillZipCode(String zipCode) {
		enterText(txtZipCode, zipCode, "ZipCode");
	}

	public void verifyCountry(String country) {
		new CommonFunctions().verifyLabelText(txtCountry, country, "United States");
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

	public void FillZipCode(String ZipCode) {
		enterText(zipCode, ZipCode, "ZipCode");
	}
	public void fillDateOfBirth(String dateOfBirth) {
		enterText(txtDateOfBirth, dateOfBirth, "Date of Birth");
	}
	public void fillSocialSecurityNum(String socialSecurityNum) {
		enterText(txtSocialSecurity, socialSecurityNum, "Social Security Number");
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public BackandCrossIconComponent backandCrossIconComponent() {
		return new BackandCrossIconComponent();
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
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
		new HomePage().validateNameField(txtAddress1, "Address1", address1);
	}
	public void validateAddress2(String address2) {
		new HomePage().validateNameField(txtAddress2, "Address2", address2);
	}
	public void validateCity(String city) {
		new HomePage().validateNameField(txtCity, "City", city);
	}
	public void validateZipCode(String zipCode) {
		new HomePage().validateNameField(txtZipCode, "ZipCode", zipCode);
	}

//	public void validateAddress1(String minChar,String minCharPlus,  String maxLessChar, String maxChar, String moreThanMaxChar) {
//		new CommonFunctions().validateFieldMaxichar(txtAddress1, "Address1", moreThanMaxChar);
//		new CommonFunctions().clearText(txtAddress1, "Address1");
//		new CommonFunctions().validateField(txtAddress1, "Address1", maxChar);
//		new CommonFunctions().clearText(txtAddress1, "Address1");
//		new CommonFunctions().validateField(txtAddress1, "Address1", maxLessChar);
//		new CommonFunctions().clearText(txtAddress1, "Address1");
//		new CommonFunctions().validateField(txtAddress1, "Address1", minCharPlus);
//		new CommonFunctions().clearText(txtAddress1, "Address1");
//		new CommonFunctions().validateField(txtAddress1, "Address1", minChar);
//
//	}
//
//	public void vaidateAddress2(String minChar,String minCharPlus,  String maxLessChar, String maxChar, String moreThanMaxChar) {
//		new CommonFunctions().validateFieldMaxichar(txtAddress2, "Address2", moreThanMaxChar);
//		new CommonFunctions().clearText(txtAddress2, "Address2");
//		new CommonFunctions().validateField(txtAddress2, "Address2", maxChar);
//		new CommonFunctions().clearText(txtAddress2, "Address2");
//		new CommonFunctions().validateField(txtAddress2, "Address2", maxLessChar);
//		new CommonFunctions().clearText(txtAddress2, "Address2");
//		new CommonFunctions().validateField(txtAddress2, "Address2", minCharPlus);
//		new CommonFunctions().clearText(txtAddress2, "Address2");
//		new CommonFunctions().validateField(txtAddress2, "Address2", minChar);
//
//	}
//
//	public void validateCity(String minChar,String minCharPlus,  String maxLessChar, String maxChar, String moreThanMaxChar, String number,
//			String specialChar) {
//		new CommonFunctions().validateFieldWithSpecialchar(txtCity, "City", specialChar);
//		new CommonFunctions().clearText(txtCity, "City");
//		new CommonFunctions().validateFieldWithNumber(txtCity, "City", number);
//		new CommonFunctions().clearText(txtCity, "City");
//		new CommonFunctions().validateFieldMaxichar(txtCity, "City", moreThanMaxChar);
//		new CommonFunctions().clearText(txtCity, "City");
//		new CommonFunctions().validateField(txtCity, "City", maxChar);
//		new CommonFunctions().clearText(txtCity, "City");
//		new CommonFunctions().validateField(txtCity, "City", maxLessChar);
//		new CommonFunctions().clearText(txtCity, "City");
//		new CommonFunctions().validateField(txtCity, "City", minCharPlus);
//		new CommonFunctions().clearText(txtCity, "City");
//		new CommonFunctions().validateField(txtCity, "City", minChar);
//
//	}
//
//	public void validateZipCode(String minChar, String moreThanMaxChar, String specialChar, String alphabets) {
//		new CommonFunctions().validateFieldWithSpecialchar(txtZipCode, "ZipCode", specialChar);
//		new CommonFunctions().validateFieldWithalphabet(txtZipCode, "ZipCode", alphabets);
//		new CommonFunctions().validateField(txtZipCode, "ZipCode", minChar);
//		new CommonFunctions().clearText(txtZipCode, "ZipCode");
//		// new CommonFunctions().validateField(txtZipCode, "ZipCode", maxChar);
//		// new CommonFunctions().clearText(txtZipCode, "ZipCode");
//		new CommonFunctions().validateFieldMaxichar(txtZipCode, "ZipCode", moreThanMaxChar);
//		new CommonFunctions().clearText(txtZipCode, "ZipCode");
//	}

}