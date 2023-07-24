package coyni.business.components;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import coyni.business.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class MailingAddressComponent extends BrowserFunctions {
	BrowserFunctions objBrowserFunctions = new BrowserFunctions();
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
	private By txtDateOfBirth = By.cssSelector("#date-of-birth");
	private By txtSocialSecurity = By.cssSelector("#social-security-no");
	private By btnNext = By.xpath("//button[@type='Save']");

	public By getElement(String state) {
		return By.xpath(String.format("//div[text()='%s']", state));
	}

	public void fillAddress1(String address1) {
		enterText(txtAddress1, address1, "address line 1");
	}

	public void clickOutSide() {
		new CommonFunctions().clickOutSideElement();
	}

	public void fillAddress2(String address2) {
		enterText(txtAddress2, address2, "address line 2");
	}

	public void fillCity(String city) {
		enterText(txtCity, city, "city");

	}

	public void editSelectState(String state) {
		click(drpDwnState, "State DropDown");
		By stateName = By.xpath(String.format("(//*[text()='%s'])[2]", state));
		click(stateName, state);
	}
//
//	public void selectState(String state) {
//		click(drpDwnState, "State DropDown");
//		By stateName = By.xpath(String.format("(//*[text()='%s'])[1]", state));
//		click(stateName, state);
//	}

	public void selectState(String state) {
		click(drpDwnState, "State DropDown");
		click(getElement(state), state);
	}

	public void fillZipCode(String zipCode) {
		click(txtZipCode, "zipCode");
		enterText(txtZipCode, zipCode, "ZipCode");
	}

	public void verifyCountry(String country) {
		new CommonFunctions().verifyLabelText(txtCountry, country, "United States");
	}

	public void fillCountry(String country) {
		click(txtCountry, "Country");
		enterText(txtCountry, country, "Country");
	}

	public void selectCountry(String country) {
		click(txtCountry, "Country");
	}

	public void clickSave() throws AWTException {
		new CommonFunctions().clickTab();
		click(btnNext, "click Save");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}
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

//	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
//		return new SuccessFailurePopupCardComponent();
//	}
//
//	public BackandCrossIconComponent backandCrossIconComponent() {
//		return new BackandCrossIconComponent();
//	}

	public void clickTab() throws AWTException {
		Actions action = new Actions(DriverFactory.getDriver());
		action.moveByOffset(10, 10).click().build().perform();
		ExtentTestManager.setInfoMessageInReport("clicked outside");
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

	public void validateTextFeild(By ele, String eleName, String enterText) {
		DriverFactory.getDriver().findElement(ele).clear();//
		objBrowserFunctions.enterText(ele, enterText, eleName);
//		String actualtext = objBrowserFunctions.getTextBoxValue(ele, eleName).trim();
		String actualtext = objBrowserFunctions.getTextBoxValue(ele, eleName).trim().replace("/", "").replace("-", "")
				.replace("(", "").replace(") ", "");
		if (enterText.matches("[a-zA-z]*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter alphabets in " + eleName);
			if (actualtext.length() == 0) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting  alphabets");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  alphabets");
			}
		} else if (enterText.matches("[0-9]*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter Numbers in " + eleName);
			if (actualtext.length() == 0) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting  Numbers");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  Numbers");
			}
		} else if (enterText.matches("[^A-Za-z0-9]*") && !enterText.matches(".*\\s.*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter Special characters in " + eleName);
			if (actualtext.length() == 0) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting  Special characters");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  Special characters");
			}
		} else if (enterText.matches(".*\\s.*")) {
			ExtentTestManager.setInfoMessageInReport("trying to enter spaces in " + eleName);
			System.out.println(actualtext);
			System.out.println(enterText);
			if (!actualtext.equals(enterText)) {
				ExtentTestManager.setPassMessageInReport(eleName + " is not accepting Spaces");
			} else {
				ExtentTestManager.setWarningMessageInReport(eleName + " is  accepting  Spaces");
			}
		}
	}

}