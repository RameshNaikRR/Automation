package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class VerifyHeadingPopup extends BrowserFunctions {

	private By btnVerifyHeading = By.xpath("//strong[contains(text(),'Verify Address')]");
	private By lblVerifyHeading = By.xpath("//h1[contains(text(),'Verify Address')]");
	private By txtAddress1 = By.name("addressLine1");
	private By txtAddress2 = By.name("addressLine2");
	private By txtCity = By.name("city");
	private By drpDwnState = By.xpath("//div[text()='State']/parent::div");
	private By txtZipCode = By.name("zipCode");
	private By txtCountry = By.xpath("//div[text()='Country']/following-sibling::*[1]");
	private By btnSave = By.xpath("//button[contains(text(),'Save')]");
	private By lblState = By.xpath("//div[text()='State']/parent::div");
	private By zipCode = By.xpath("//input[@id='zip-code']/parent::div");

	public void clickVerifyHeading() {
		click(btnVerifyHeading, "Verify Heading");
	}

	public void verifyHeading() {
		String text = getText(lblVerifyHeading, "Verify Heading");
		System.out.println("Heading is " + text);
	}

	public void clickSave() {
		click(btnSave, "Save");
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

	public void selectState(String state) {
		click(drpDwnState, "State DropDown");
		By stateName = By.xpath(String.format("(//*[text()='%s'])[1]", state));
		click(stateName, state);
	}

	public void fillZipCode(String zipCode) {
		click(txtZipCode, "zipCode");
		enterText(txtZipCode, zipCode, "ZipCode");
	}

}
