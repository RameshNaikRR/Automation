package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class MailingAddressComponent extends MobileFunctions {

	private By lblHeading = MobileBy.AccessibilityId("Please confirm your billing address");
	private By drpDwnState = MobileBy.id("com.coyni.mapp:id/imageButton");
	private By txtState = MobileBy.id("com.coyni.mapp:id/etState");
	private By txtStates = MobileBy.id("");
	private By txtAddLine1 = MobileBy.id("com.coyni.mapp:id/etAddress1");
	private By txtAddLine2 = MobileBy.id("com.coyni.mapp:id/etAddress2");
	private By txtCity = MobileBy.id("com.coyni.mapp:id/etCity");
	private By lblCountry = MobileBy.id("com.coyni.mapp:id/etCountry");
	private By txtContrySearch = MobileBy.AccessibilityId("Country Search");
	private By btnSearchClearTxt = MobileBy.id("com.coyni.mapp:id/clearTextLL");
	private By btnConfirmState = MobileBy.xpath("com.coyni.mapp:id/etState");
	private By txtZipCode = MobileBy.id("com.coyni.mapp:id/etZipCode");
	private By drpdwnStatelist = MobileBy.xpath("");
	private By lblAddressAdded = MobileBy.id("com.coyni.mapp:id/tvHeading");
	private By lblAddrDesc = MobileBy.id("com.coyni.mapp:id/tvDescription");
	private By btnAddAddress = MobileBy.id("com.coyni.mapp:id/tvButton");
	private By btnDone = MobileBy.xpath("//*[@text='Done']");
	private By lblBillingAddress = MobileBy.xpath("//*[@text='Billing Address']");
	private By lblBillingDesc = MobileBy.id("com.coyni.mapp:id/tvAddMsg");
	private By btnChBox = MobileBy.id("com.coyni.mapp:id/checkCB");

//	private By lblBillingAddress = MobileBy.id("");
//	private By lblBillDesc = MobileBy.id("");
//	private By drpDwnCountry = MobileBy.id("com.coyni.mapp:id/etCountry");
//	private By txtContrySearch = MobileBy.AccessibilityId("Country Search");
//	private By btnSearchClearTxt = MobileBy.id("com.coyni.mapp:id/clearTextLL");
//	private By txtLine1 = MobileBy.AccessibilityId("Address Line 1");
//	private By txtLine2 = MobileBy.AccessibilityId("Address Line 2 (Optional)");
//	private By lblState = MobileBy.xpath("//*[@name='State']");
//	private By lblNoStatesFound = MobileBy.AccessibilityId("No states found");
//	
//	private By chkbxSaveThisAddress = MobileBy.AccessibilityId("uncheck");
//	private By descChkbx = MobileBy.id("");
//	private By btnAddCard = MobileBy.id("");
//	private By lblToastMsg = MobileBy.id("");

//	

	public void clickAddreChkBox() {
		click(btnChBox, "Check Box");
	}

	public void verifyBillingAddress(String expDesc) {
		new CommonFunctions().verifyLabelText(lblBillingAddress, "Billing Address", expDesc);
		new CommonFunctions().elementView(lblBillingDesc, "Billing Description");
		ExtentTestManager.setPassMessageInReport(getText(lblBillingDesc));
	}

	public void clickAddAddress() {
		DriverFactory.getDriver().hideKeyboard();
		scrollDownToElement(btnAddAddress, "Add Address/Save");
		click(btnAddAddress, "Add Address/Save");
	}

	public void verifyAddressAdded(String expDesc) {
		new CommonFunctions().elementView(lblAddressAdded, "Adress Added");
		new CommonFunctions().verifyLabelText(lblAddrDesc, "Add Address Desc", expDesc);
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	/////////////////
//	public void verifyNostates(String noStates) {
//
//		new CommonFunctions().verifyLabelText(lblNoStatesFound, "nostates", noStates);
//		click(btnClose, "Close");
//
//		// click(btnDone, "Done");
//	}

	public void validateSelectCountry(String country) {
		enterText(txtContrySearch, country, "Country Search");
		click(btnSearchClearTxt, "Clear Text");
		String search = getText(txtContrySearch);
		if (search.length() == 0 || search.equals("Country / Country Code")) {
			ExtentTestManager
					.setPassMessageInReport("Search bar is clearing the text, after clicked on clear text button");
		} else {
			ExtentTestManager
					.setFailMessageInReport("Search bar is not clearing the text, after clicked on clear text button");
		}
		enterText(txtContrySearch, country, "Country Search");
		new CommonFunctions().clickEnter();
		new CommonFunctions().clickEnter();
	}

//	public void DropdownState() throws InterruptedException {
//		clickdropdown();
//		Thread.sleep(10000);
//		List<WebElement> elements = getElementList(drpdwnStatelist, "drpdwnstate");
//		System.out.println(elements);
//		int size = elements.size();
//		System.out.println("the size is : " + size);
//		for (int i = 0; i < size; i++) {
//			// clickdropdown();
//			List<WebElement> element = getElementList(drpdwnStatelist, "drpdwnstate");
//			element.get(i).click();
////			click(btnDone, "Done");
////			click(btnConfirmState, "Done");
////			ExtentTestManager.setInfoMessageInReport("selected state is: " + getAttribute(lblState, "value"));
//			// System.out.println(i);
//		}
//
//	}

	public void clickdropdown() {
		click(drpDwnState, "drop down");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "heading", expHeading);
	}

	public void fillAddLine1(String addressLine1) {
		click(txtAddLine1, "Address Line1");
		enterText(txtAddLine1, addressLine1, "Address Line1");
	}

	public void fillAddLine2(String addressLine2) {
		scrollDownToElement(txtAddLine2, "Address Line2");
		enterText(txtAddLine2, addressLine2, "Address Line2");
	}

	public void clickAddLine1() {
		click(txtAddLine1, "Address Line1");
	}

	public void clickCity() {
		click(txtCity, "City");
	}

	public void scrollToCity() {
		scrollDownToElement(txtCity, "City");
	}

	public void fillState(String state) throws InterruptedException {
		DriverFactory.getDriver().hideKeyboard();
		Thread.sleep(500);
		if (getElementList(drpDwnState, "State").size() > 0) {
			click(drpDwnState, "state drop down");
			enterText(txtContrySearch, state, "State");
			click(MobileBy.xpath(String.format("(//*[@text='%s'])[2]", state)), "state");
		} else {
			enterText(txtState, state, "State");
		}
	}

	public void scrollToState() {
		scrollDownToElement(drpDwnState, "State");
	}

	public void scrollToZipCode() {
		scrollDownToElement(txtZipCode, "ZipCode");
	}

	public void clickZipCode() {
		click(txtZipCode, "ZipCode");
	}

	public void verifyCountry(String expCountry) {
		String actualText = getAttribute(lblCountry, "value").trim();
		if (actualText.equalsIgnoreCase(expCountry)) {
			ExtentTestManager.setPassMessageInReport("Country is " + expCountry);
		} else {
			ExtentTestManager.setWarningMessageInReport("Country is not " + expCountry);
		}
	}

	public void verifyCityView(String city) {
		new CommonFunctions().elementView(txtCity, "City text field");
		new SignUpPage().validateNameField(txtCity, "city", city);
	}

	public void verifyStateView() {
		new CommonFunctions().elementView(drpDwnState, "State dropdown");
	}

	public void verifyZipCodeView() {
		new CommonFunctions().elementView(txtZipCode, "ZipCode  text field");
	}

	public PreAuthorizationComponent preAuthorizationComponent() {
		return new PreAuthorizationComponent();
	}

	public void validateCity(String city) {
		new SignUpPage().validateNameField(txtCity, "City", city);
	}

	public void validateZipCode(String textField) {
		String[] field = textField.split(",");
		new CommonFunctions().validateField(txtZipCode, "Zip Code", field[0]);
		// click(btnDone, "Done");
		new CommonFunctions().validateFieldMaxichar(txtZipCode, "Zip Code", field[1]);
		// click(btnDone, "Done");
	}

	public void validateAdd(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		new CommonFunctions().validateField(ele, eleName, field[0]);
		// click(btnDone, "Done");
		new CommonFunctions().validateField(ele, eleName, field[1]);
		// click(btnDone, "Done");
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[2]);
		// click(btnDone, "Done");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public SignUpPage signUpPage() {
		return new SignUpPage();
	}

	/******
	 * 
	 */
//
//	public void verifyAddressUpdatedMsg(String msg) {
//		if (getElementList(lblToastMsg, "ToastMsg").size() > 0) {
//			new CommonFunctions().verifyLabelText(lblToastMsg, "msg", msg);
//		}
//	}
//
//	public void verifyBillingAddressView() {
//		new CommonFunctions().elementView(lblBillingAddress, "Billing Address");
//		ExtentTestManager.setInfoMessageInReport("The text is: " + getText(lblBillDesc));
//	}

	public void clickCountryDropdown() {
		click(lblCountry, "Country Dropdown");
	}

	public void selectCountry(String state) {
		enterText(txtContrySearch, state, "Search field");
		click(MobileBy.AccessibilityId(String.format("%s", state)), "state");
	}

	public void fillCity(String city) {
		scrollDownToElement(txtCity, "City");
		click(txtCity, "City");
		enterText(txtCity, city, "City");
	}

	public void clearCity() {
		click(txtCity, "City");
		new CommonFunctions().clearText(txtCity, "City");
	}

	public void clearAddLine1() {
		click(txtAddLine1, "Address Line1");
		new CommonFunctions().clearText(txtAddLine1, "Address Line1");
	}

	public void selectState(String state) {
		scrollDownToElement(drpDwnState, "State Drop down");
		click(drpDwnState, "State Drop down");
		enterText(txtContrySearch, state, "State");
		click(MobileBy.xpath(String.format("//*[@text='%s']", state)), "state");
	}

	public void fillZipCode(String zipCode) {
		DriverFactory.getDriver().hideKeyboard();
		click(txtZipCode, "Zip Code");
		DriverFactory.getDriver().hideKeyboard();
		enterText(txtZipCode, zipCode, "Zip Code");
	}

//	public void clickAddCard() {
//		if (getElement(btnAddCard, "AddCard").isEnabled()) {
//			click(btnAddCard, "Add Card");
//		} else {
//			ExtentTestManager.setInfoMessageInReport("Add Card button is disabled");
//		}
//	}
//
//	public void clickSaveThisAddCheckBox() {
//		new CommonFunctions().elementView(descChkbx, "Check box");
//		click(chkbxSaveThisAddress, "SaveThisAddress");
//	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

}
