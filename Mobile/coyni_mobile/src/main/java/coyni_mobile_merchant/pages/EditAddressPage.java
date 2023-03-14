package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.FieldValidationsComponent;
import coyni_mobile_merchant.components.MailingAddressComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditAddressPage extends MobileFunctions {
	private By lblEditAddressHeading = MobileBy.xpath("//*[contains(@resource-id,'b_headerTV')]");
	private By txtAddress = MobileBy.xpath("//*[contains(@resource-id,'b_addressLineOneET')]");
	private By txtCity = MobileBy.xpath("//*[contains(@resource-id,'/b_cityET')]");
	private By txtState = MobileBy.xpath("//*[contains(@resource-id,'b_stateET')]");
	private By lblCountry = MobileBy.xpath("//*[contains(@resource-id,'b_countryET')]");
	private By txtZipCode = MobileBy.xpath("//*[contains(@resource-id,'b_zipcodeET')]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'b_editAddressSaveCV')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'b_backIV')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEditAddressHeading, "Edit Address Heading", expHeading);
	}

	public void fillAddress(String expAddress) {
		new CommonFunctions().verifyAutoFocusElement(txtAddress, "Address");
		click(txtAddress, "Address");
		enterText(txtAddress, expAddress, "Address");
		DriverFactory.getDriver().hideKeyboard();

	}

	public void fillCity(String expCity) {
		click(txtCity, "City");
		enterText(txtCity, expCity, "Address");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillState(String expState) {
		click(txtState, "State");
		enterText(txtState, expState, "State");
	}

	public void fillZipCode(String expZipCode) {
		click(txtZipCode, "Zip Code");
		enterText(txtZipCode, expZipCode, "Zip Code");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void clickCity() {
		click(txtCity, "City");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void getDefaultCountry() {
		String str = getText(lblCountry);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}
