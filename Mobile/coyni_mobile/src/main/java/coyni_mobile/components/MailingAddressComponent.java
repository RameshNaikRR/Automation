package coyni_mobile.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.AndroidCommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class MailingAddressComponent extends MobileFunctions{
	
//	private By lblHeading =MobileBy.xpath("//*[contains(@name,'confirm your')]");
	private By lblHeading =MobileBy.AccessibilityId("Please confirm your billing address");
//	private By txtAddressLine1 = MobileBy.xpath("(//*[contains(@name,'Address Line 1')])[1]");
//	private By txtAddressLine2 = MobileBy.xpath("(//*[contains(@name,'Address Line 2')])[1]");
//	private By txtCity = MobileBy.xpath("//*[@name='City']");
	private By drpDwnState = MobileBy.xpath("//*[@name='State']/following-sibling::*[1] | //*[@name='State']");
//	private By txtZipCode = MobileBy.xpath("//*[@name='Zip Code']");
//	private By lblCountry = MobileBy.xpath("//*[@name='Country']");
	
	private By txtState = MobileBy.xpath("//*[@name='search']/following-sibling::*[1]");
	private By txtStates = MobileBy.AccessibilityId("");
//	private By btnConfirmState = MobileBy.xpath("//*[@name='search']/../following-sibling::*[@name='Done']");
	private By txtAddressLine1 = MobileBy.AccessibilityId("Billing Address Line 1");

	private By txtAddLine1 = MobileBy.AccessibilityId("Mailing Address Line 1");
	private By txtAddressLine2 = MobileBy.AccessibilityId("Billing Address Line 2 (Optional)");
	private By txtAddLine2 = MobileBy.AccessibilityId("Mailing Address Line 2(Optional)");
	
//	private By drpDwnState = MobileBy.AccessibilityId("arrow-down");
	
	private By lblCountry = MobileBy.AccessibilityId("Country");
	private By btnConfirmState = MobileBy.xpath("//*[@name='search']/../following-sibling::*[@name='Done']");
//	private By btnDone = MobileBy.xpath("//*[@name='Title']/preceding-sibling::*[1]");
	private By btnDone = MobileBy.AccessibilityId("Done");
	private By drpdwnStatelist = MobileBy.xpath("(//XCUIElementTypeTable)[3]/XCUIElementTypeCell");
	
	
	
	/////2.3//////
//	private By lblAddressAdded = MobileBy.xpath("//XCUIElementTypeStaticText[@name ='Address Added']");
	private By lblAddressAdded = MobileBy.AccessibilityId("Address Added");
	private By btnAddAddress = MobileBy.xpath("//XCUIElementTypeButton[@name='Add Address']");
	private By buttonDone = MobileBy.xpath("//XCUIElementTypeButton[@name='Done']");
	private By btnClose = MobileBy.AccessibilityId("close");
	
	
	public void clickAddAddress() {
		click(btnAddAddress, "Add Address");
	}
	public void verifyAddressAdded() {
		new AndroidCommonFunctions().elementView(lblAddressAdded, "Adress Added");
	}
	public void clickDoneButton() {
		click(buttonDone, "Done");
	}
	
	
	/////////////////
	public void verifyNostates(String noStates) {
		
		new AndroidCommonFunctions().verifyLabelText(lblNoStatesFound, "nostates", noStates);
		click(btnClose, "Close");
		
	//	click(btnDone, "Done");
	}
	public void clickDone() {
		click(btnDone, "Done");
	}

	public void DropdownState() throws InterruptedException {
		clickdropdown();
		Thread.sleep(10000);
		List<WebElement> elements = getElementList(drpdwnStatelist, "drpdwnstate");
		System.out.println(elements);
		int size = elements.size();
		System.out.println("the size is : " + size);
		for (int i = 0; i <size; i++) {
		//	clickdropdown();
			List<WebElement> element = getElementList(drpdwnStatelist, "drpdwnstate");
			element.get(i).click();
//			click(btnDone, "Done");
//			click(btnConfirmState, "Done");
//			ExtentTestManager.setInfoMessageInReport("selected state is: " + getAttribute(lblState, "value"));
		//	System.out.println(i);
		}

	}
	

	public void clickdropdown() {
		click(drpDwnState, "drop down");
	}

	public void verifyHeading(String expHeading) {
		new AndroidCommonFunctions().verifyLabelText(lblHeading, "heading", expHeading);
	}
	public void fillAddressLine1(String addressLine1) {
		click(txtAddressLine1, "addressline1");
		enterText(txtAddressLine1, addressLine1, "Address Line1");
		click(btnDone, "Done");
	}
	
	public void fillAddLine1(String addressLine1) {
		//click(txtAddressLine1, "addressline1");
		enterText(txtAddLine1, addressLine1, "Address Line1");
		click(btnDone, "Done");
	}
	public void scrollToAddressLine1() {
		scrollDownToElement(txtAddressLine1, "Address Line 1");
	}
	public void fillAddressLine2(String addressLine2) {
		enterText(txtAddressLine2, addressLine2, "Address Line2");
		click(btnDone, "Done");
	}
	public void fillAddLine2(String addressLine2) {
		enterText(txtAddLine2, addressLine2, "Address Line2");
		click(btnDone, "Done");
	}
	public void scrollToAddressLine2() {
		scrollDownToElement(txtAddressLine2, "Address Line 2");
	}
	
	public void scrollToCity() {
		scrollDownToElement(txtCity, "City");
	}
	public void fillState(String state) {
		if(getElementList(drpDwnState, "State").size()>0) {
		click(drpDwnState, "state drop down");
		enterText(txtState, state, "State");
		}else {
		  enterText(txtStates, state, "States");
		}
	}

	
	
	
	
	public void scrollToState() {
		scrollDownToElement(drpDwnState, "State");
	}
	
	public void scrollToZipCode() {
		scrollDownToElement(txtZipCode, "ZipCode");
	}
	public void verifyCountry(String expCountry) {
		String actualText =getAttribute(lblCountry, "value").trim();
		if(actualText.equalsIgnoreCase(expCountry)) {
			ExtentTestManager.setPassMessageInReport("Country is "+expCountry);
		}
		else {
			ExtentTestManager.setWarningMessageInReport("Country is not "+ expCountry);
		}
	}
	
	
//	
//   public void verifyAddressLine1View(String addline1) {
//	   new CommonFunctions().elementView(txtAddressLine1, "Address line1 text field");
//	   new SignUpPage().validateAddressField(txtAddressLine1, "address line 1", addline1 );
//   }
//   
//	
//   public void verifyAddressLine2View(String addline2) {
//	   new CommonFunctions().elementView(txtAddressLine2, "Address line2  text field");
//	   new SignUpPage().validateAddressField(txtAddressLine2, "Address line2", addline2);
//   }
//   public void verifyLine2View(String addline2) {
//	   new CommonFunctions().elementView(txtLine2, "Address line2  text field");
//	   new SignUpPage().validateAddressField(txtLine2, "Address line2", addline2);
//   }
   
   public void verifyCityView(String city) {
	   new AndroidCommonFunctions().elementView(txtCity, "City text field");
	   new SignUpPage().validateNameField(txtCity, "city", city);
   }
   public void verifyStateView() {
	   new AndroidCommonFunctions().elementView(drpDwnState, "State dropdown");
   }
   public void verifyZipCodeView() {
	   new AndroidCommonFunctions().elementView(txtZipCode, "ZipCode  text field");
   }
	public PreAuthorizationComponent preAuthorizationComponent() {
		return new PreAuthorizationComponent();
	}
	public void validateAddline1(String addressLine1) {
		validateAdd(txtAddressLine1, "Billing Address Line 1", addressLine1);
	}
	public void validateAddline2(String addressLine2) {
		validateAdd(txtAddressLine2, "Billing Address Line 2", addressLine2);
	}
	public void validateCity(String city) {
		new SignUpPage().validateNameField(txtCity, "City", city);
	}
	public void validateZipCode(String textField) {
		String[] field = textField.split(",");
		new AndroidCommonFunctions().validateField(txtZipCode, "Zip Code", field[0]);
	//	click(btnDone, "Done");
		new AndroidCommonFunctions().validateFieldMaxichar(txtZipCode, "Zip Code", field[1]);
	//		click(btnDone, "Done");
	}
	public void validateAdd(By ele,String eleName,String textField) {
		String[] field = textField.split(",");
		new AndroidCommonFunctions().validateField(ele, eleName, field[0]);
	//	click(btnDone, "Done");
		new AndroidCommonFunctions().validateField(ele, eleName, field[1]);
	//	click(btnDone, "Done");
		new AndroidCommonFunctions().validateFieldMaxichar(ele, eleName, field[2]);
	//	click(btnDone, "Done");
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
	
	private By lblBillingAddress = MobileBy.AccessibilityId("");
	private By lblBillDesc = MobileBy.AccessibilityId("");
	private By drpDwnCountry = MobileBy.AccessibilityId("");
	private By txtSearch = MobileBy.AccessibilityId("");
	private By btnSearchCross = MobileBy.AccessibilityId("");
	private By txtLine1 = MobileBy.AccessibilityId("Address Line 1");
	private By txtLine2 = MobileBy.AccessibilityId("Address Line 2 (Optional)");
	private By txtCity = MobileBy.AccessibilityId("City");
	private By lblState = MobileBy.xpath("//*[@name='State']");
	private By lblNoStatesFound = MobileBy.AccessibilityId("No states found");
	private By txtZipCode = MobileBy.AccessibilityId("Zip Code");
	private By chkbxSaveThisAddress = MobileBy.AccessibilityId("uncheck");
	private By descChkbx = MobileBy.AccessibilityId("");
	private By btnAddCard = MobileBy.AccessibilityId("");
	private By lblToastMsg = MobileBy.AccessibilityId("");
	
	
	
	public void verifyAddressUpdatedMsg(String msg) {
		if(getElementList(lblToastMsg, "ToastMsg").size()>0) {
		new CommonFunctions().verifyLabelText(lblToastMsg, "msg",msg);
	}
	}
	public void verifyBillingAddressView() {
		new AndroidCommonFunctions().elementView(lblBillingAddress, "Billing Address");
		ExtentTestManager.setInfoMessageInReport("The text is: " + getText(lblBillDesc));
	}
	public void clickCountryDropdown() {
		click(drpDwnCountry, "Country Dropdown");
	}
	
	public void selectCountry(String state) { 
		enterText(txtSearch, state, "Search field");
		click(MobileBy.xpath(String.format("//*[@name='%s']", state)), "state");
	}
	
	public void clickSearchCross() {
		click(btnSearchCross, "Cross");
	}
	
//	public void verifyLine1View(String addline1) {
//		   new CommonFunctions().elementView(txtLine1, "Address line1 text field");
//		   new SignUpPage().validateAddressField(txtLine1, "address line 1", addline1 );
//	   }
	public void fillLine1(String addressLine1) {
	//	click(txtLine1, "addressline1");
		enterText(txtLine1, addressLine1, "Address Line1");
	//	click(btnDone, "Done");
	}
	public void fillLine2(String addressLine1) {
	//	click(txtLine2, "addressline1");
		enterText(txtLine2, addressLine1, "Address Line1");
	//	click(btnDone, "Done");
	}
	public void fillCity(String city) {
		enterText(txtCity, city, "City");
	//	click(btnDone, "Done");
	}
	
	public void selectState(String state) { 
		click(drpDwnState, "State Drop down");
		enterText(txtState, state, "State");
		click(MobileBy.xpath(String.format("//*[@name='%s']", state)), "state");
		click(btnDone, "Done");
		click(btnConfirmState, "Done");
	}
	
	public void fillZipCode(String zipCode) {
		enterText(txtZipCode, zipCode, "Zip Code");
	//	click(btnDone, "Done");
		}
	public void clickAddCard() {
		if(getElement(btnAddCard, "AddCard").isEnabled()) {
		click(btnAddCard, "Add Card");
		}else {
			ExtentTestManager.setInfoMessageInReport("Add Card button is disabled");
		}
	}
	
	public void clickSaveThisAddCheckBox() {
	  new AndroidCommonFunctions().elementView(descChkbx, "Check box");
		click(chkbxSaveThisAddress, "SaveThisAddress");
	}
	
	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}
	
}
