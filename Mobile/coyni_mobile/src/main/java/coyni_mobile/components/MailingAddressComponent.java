package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.AllDonePage;
import coyni_mobile.pages.PreAuthorizationPage;
import coyni_mobile.pages.SignUpPage;
import coyni_mobile.pages.TokenAccountPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class MailingAddressComponent extends MobileFunctions {

	private By txtAddressLine1 = MobileBy
			.xpath("//*[contains(@resource-id,'etAddress1')]|//*[contains(@resource-id,'addressLineOneET')]");
	private By txtAddressLine2 = MobileBy
			.xpath("//*[contains(@resource-id,'etAddress2')]|//*[contains(@resource-id,'addressLineTwoET')]");
	private By txtCity = MobileBy.xpath("//*[contains(@resource-id,'etCity')]|//*[contains(@resource-id,'cityET')]");
	private By drpDwnState = MobileBy
			.xpath("//*[contains(@resource-id,'etState')]|//*[contains(@resource-id,'stateET')]");
	private By txtZipCode = MobileBy.xpath(
			"//*[contains(@resource-id,'etZipcode') or contains(@resource-id,'etZipCode')]|//*[contains(@resource-id,'zipcodeET')]");
	private By lblCountry = MobileBy
			.xpath("//*[contains(@resource-id,'etCountry')]|//*[contains(@resource-id,'countryET')]");
	private By btnAddCard = MobileBy
			.xpath("//*[contains(@resource-id,'cvAddCard')]|//*[contains(@resource-id,'cvAdd')]|//*[contains(@resource-id,'addCardTV')]");
	private By txtState = MobileBy
			.xpath("//*[contains(@resource-id,'searchET')]|//*[contains(@resource-id,'stateET')]");
	private By btnConfirmState = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'cvSave')]");
	private By btnRemove = MobileBy.xpath("//*[contains(@resource-id,'cvRemove')]");
	private By btnNo = MobileBy.xpath("//*[contains(@resource-id,'tvNo')]");
	private By btnYes = MobileBy.xpath("//*[contains(@resource-id,'tvYes')]");
	//////////////////////// 2.3 //////////////////////////////
	private By chkAddress = MobileBy.xpath("//*[contains(@resource-id,'saveAddressCB')]");
	private By btnAddAddress = MobileBy.xpath("//*[contains(@resource-id,'editAddressSaveCV')]");
	private By lblAddressAdded = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'cvDone')]");
	private By lblAddressHeading = MobileBy.xpath("//*[@text='Add Address']");
	private By heading = MobileBy.xpath("//*[contains(@resource-id,'tvCardHead')]");
	private By lblCardDescription = MobileBy.xpath("//*[contains(@resource-id,'tvAddMsg')]");

	public void verifyHeading(String expheading) {
		new CommonFunctions().verifyLabelText(heading, "Add card Heading", expheading);
		new CommonFunctions().elementView(lblCardDescription, "Card Description");
	}

	private By txtCurrentState(String currentState) {
		return MobileBy.xpath(String.format("//*[contains(@text,'%s')]", currentState));
	}

	public void clickCurrentState() {
		click(txtCurrentState("California"), "California");
	}

	public void verifyAddress(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddressHeading, "Heading", expHeading);
	}

	public void fillAddressLine1(String addressLine1) {
		click(txtAddressLine1, "Address Line1");
		enterText(txtAddressLine1, addressLine1, "Address Line1");
		scrollUpToElement(txtAddressLine1, "Address Line1");
	}

	public void fillAddressLine2(String addressLine2) {
		scrollDownToElement(txtAddressLine2, "Address Line2");
		click(txtAddressLine2, "Address Line2");
		enterText(txtAddressLine2, addressLine2, "Address Line2");
	}

	public void fillCity(String city) {
		scrollDownToElement(txtAddressLine2, "Address Line2");
		click(txtCity, "City");
		enterText(txtCity, city, "City");
		// new CommonFunctions().clickEnter();
		DriverFactory.getDriver().hideKeyboard();
	}

	public void selectState(String state) throws InterruptedException {
//		scrollDownToElement(txtCity, "City");
//		click(drpDwnState, "State Drop down");
////		click(txtState, "state");
////		Thread.sleep(2000);
//		enterText(txtState, state, "State");
//		new CommonFunctions().clickEnter();
//		Thread.sleep(2000);
//		clickCurrentState();
//		// click(MobileBy.xpath(String.format("//*[@text='%s']", state)), "state");
////		new CommonFunctions().clickTab();
//		click(btnConfirmState, "Done");

		scrollDownToElement(txtCity, "City");
		click(drpDwnState, "State Drop down");
		enterText(txtState, state, "State");
		Thread.sleep(2000);
		new CommonFunctions().clickEnter();
		// click(MobileBy.xpath(String.format("//*[@text='%s']", state)), "state");
		new CommonFunctions().clickEnter();
		click(btnConfirmState, "Done");
	}

	public void fillZipCode(String zipCode) throws InterruptedException {
		Thread.sleep(2000);
		scrollDownToElement(txtZipCode, "zipCode");
		click(txtZipCode, "zip Code");
		enterText(txtZipCode, zipCode, "Zip Code");
		new CommonFunctions().clickTab();
		DriverFactory.getDriver().hideKeyboard();
	}

	public void scrollDownToAddress2() {
		scrollDownToElement(txtAddressLine2, "Address2");
	}

	public void scrollDownToSave() {
		scrollDownToElement(btnSave, "Save");
	}

//	public void fillZipCode(String zipCode) {
//		click(txtZipCode, "zip Code");
//		enterText(txtZipCode, zipCode, "Zip Code");
//		new CommonFunctions().clickEnter();
//		// DriverFactory.getDriver().hideKeyboard();
//
//	}

	public void verifyCountry(String expCountry) {
		scrollDownToElement(btnSave, "Save");
		new CommonFunctions().verifyLabelText(lblCountry, "Country", expCountry);
	}

	public void clickChkAddress() {
		click(chkAddress, "Save Address");
	}

	public void clickAddAddress() {
		click(btnAddAddress, "Add Address");
	}

	public void clickAddCard() {
		scrollDownToElement(btnAddCard, "Add Card");
		click(btnAddCard, "Add Card");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void clickSave() {
		scrollDownToElement(btnSave, "Save");
		click(btnSave, "Save");
	}

	public void clickRemove() {
		scrollDownToElement(btnRemove, "Remove");
		click(btnRemove, "Remove");
	}

	public void clickNo() {
		click(btnNo, "No");
	}

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void verifyAddressAdded(String expText) {
		new CommonFunctions().verifyLabelText(lblAddressAdded, "Address Added", expText);
	}

	public void verifyAddressLine1View() {
		new CommonFunctions().elementView(txtAddressLine1, "Address line1 text field");
	}

	public void verifyAddressLine2View() {
		new CommonFunctions().elementView(txtAddressLine2, "Address line2  text field");
	}

	public void verifyCityView() {
		new CommonFunctions().elementView(txtCity, "City text field");
	}

	public void verifyStateView() {
		new CommonFunctions().elementView(drpDwnState, "State dropdown");
	}

	public void verifyZipCodeView() {
		new CommonFunctions().elementView(txtZipCode, "ZipCode  text field");
	}

	public PreAuthorizationPage preAuthorizationPage() {
		return new PreAuthorizationPage();
	}

	public AllDonePage allDonePage() {
		return new AllDonePage();
	}

	public TokenAccountPage tokenAccountPage() {
		return new TokenAccountPage();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}
