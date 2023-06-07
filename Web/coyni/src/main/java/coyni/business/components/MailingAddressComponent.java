package coyni.business.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class MailingAddressComponent extends BrowserFunctions {

	private By txtAddress1 = By.xpath("");
	private By txtAddress2 = By.xpath("");
	private By txtCity = By.xpath("");
	private By txtZipCode = By.xpath("");
	private By drpdwnCountry = By.xpath("");
	private By btnSave = By.xpath("");

	public void fillAddress1(String address1) {
		enterText(txtAddress1, address1, "Address line 1");
	}

	public void fillAddress2(String address2) {
		enterText(txtAddress2, address2, "Address line 2");
	}

	public void fillCity(String city) {
		enterText(txtCity, city, "City");
	}

	public void fillZipCode(String zipCode) {
		enterText(txtZipCode, zipCode, "Zip Code");
	}

	public void selectCountry(String country) {
		click(drpdwnCountry, "Country");
		By countryName = By.xpath(String.format("", country));
		click(countryName, country);
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
			ExtentTestManager.setPassMessageInReport("Save Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Save Button is Disabled");
		}
	}

}