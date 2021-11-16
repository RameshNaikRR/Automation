package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MailingAddressComponent extends BrowserFunctions {
	
	private By txtAddress1 = By.name("addressLine1");

	private By txtAddresss2 = By.name("addressLine2");

	private By txtCity = By.name("city");

	private By drpDwnState = By.xpath("//div[text()='State']/following-sibling::div");

	private By txtZipCode = By.name("zipCode");

	private By txtCountry = By.cssSelector("");

	private By btnSave = By.xpath("//button[text()='Next']");

	public void fillAddress1(String address1) {
		enterText(txtAddress1, address1, "address line 1");
	}

	public void fillAddress2(String address2) {
		enterText(txtAddresss2, address2, "address line 2");
	}

	public void fillCity(String city) {
		enterText(txtCity, city, "city");
	}
	public void selectState(String state) {
		click(drpDwnState, "State DropDown");
		new CommonFunctions().selectCustomDropDown(state, "State");
	}

	public void fillZipCode(String zipCode)
	{
		enterText(txtZipCode, zipCode, "ZipCode");
	}
	public void verifyCountry(String country) {
		new CommonFunctions().verifyLabelText(txtCountry, country, "country");
	}

	public void clickSave() {
		click(btnSave, "click save");
	}
	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return  new SuccessFailurePopupCardComponent();
	}




}