package coyni.merchant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CompanyInformationPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='Company Information']");

	private By getLables(String Lables) {
		return By.xpath(String.format("//p[.='%s']", Lables));
	}

	private By companyInformationDetails(String className) {
		return By.xpath(String.format("//p[contains(@class,'%s')]", className));
	}

	private By contactInformationDetails(String cf) {
		return By.xpath(String.format("//input[@name='%s']", cf));
	}

	private By addressDetails(String Address) {
		return By.xpath(String.format("(//p[@class='text-sm text-cgy8 '])[%s]", Address));
	}

	private By btnSave = By.xpath("//button[.='Save']");
	private By iconEdit = By.xpath("//div[contains(@class,'icon-edit')]");
	private By toolTipEdit = By.xpath("(//div[contains(@class,'tooltip')])[3]");

	public void clickPhoneNumberEditIcon() {
		scrollToElement(iconEdit, "Edit icon is displayed");
		click(iconEdit, "Edit icon");
	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void verifyhandSymbolHighlightedCompanyinformation(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Company information"), "Company information");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "Company information", cssProp, expValue,
				expColor);
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyCompanyInformationLbl() {
		new CommonFunctions().elementView(getLables("Company Information"), "Company Information label ");
	}

	public void verifyContactInformationLbl() {
		new CommonFunctions().elementView(getLables("Contact Information"), "Contact Information label ");
	}

	public void verifyAddressLbl() {
		new CommonFunctions().elementView(getLables("Address"), "Address label ");
	}

	public void getCompanyName() {
		String CompanyName = getText(companyInformationDetails("text-cgy8 font-bold text-xl"), "");
		ExtentTestManager.setInfoMessageInReport("Company Name is : " + CompanyName);
	}

	public void getBusinessEntity() {
		String BusinessEntity = getText(companyInformationDetails("CompanyInformation_eName"), "");
		ExtentTestManager.setInfoMessageInReport("Business Entity is : " + BusinessEntity);
	}

	public void getEINnumber() {
		String EinNumber = getText(companyInformationDetails("mt-1 text-sm text-cgy8"), "");
		ExtentTestManager.setInfoMessageInReport("EIN number is : " + EinNumber);
	}

	public void getAccountID() {
		String AccountID = getText(companyInformationDetails("mt-6 text-xs text-cgy3"), "");
		ExtentTestManager.setInfoMessageInReport("Account ID is : " + AccountID);
	}

	public void getPhoneNumber() {
		String PhoneNumber = getText(contactInformationDetails("phoneNumber"), "");
		ExtentTestManager.setInfoMessageInReport("Phone Number is: " + PhoneNumber);
	}

	/**
	 * Order:- minChar, alphabets, specialChar, spaces, maxiPlus
	 */
	private void validateNumber(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		new CommonFunctions().validateField(ele, eleName, field[0]);
		for (int i = 1; i < 4; i++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
	}

	public void clickPhoneNumber(String phoneNumber) throws InterruptedException {
		click(contactInformationDetails("phoneNumber"), "Phone Number text field");
		enterText(contactInformationDetails("phoneNumber"), phoneNumber, "Phone Number text field");
	}

	public void verifyPhoneNumber(String PhoneNumber) {
		click(contactInformationDetails("phoneNumber"), "Phone Number text field");
		validateNumber(contactInformationDetails("phoneNumber"), "PhoneNumber", PhoneNumber);
	}

	/**
	 * Order:- minChar, minCharPlus, maxCharMinus, maxChar, specialChar, Number,
	 * spaces maxiPlus
	 */
	private void validateNameField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 4; j < 7; j++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[7]);
	}

	/**
	 * Order:- minChar, minCharPlus, maxCharMinus, maxChar, maxCharPlus, spaces
	 */
	private void validateEmailField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
		// new CommonFunctions().validateTextFeild(ele, eleName, field[5]);
	}

	public void getEmail() {
		String email = getText(contactInformationDetails("email"), "");
		ExtentTestManager.setInfoMessageInReport("Email is: " + email);
	}

	public void verifyEmail(String email) {
		click(contactInformationDetails("email"), "");
		validateEmailField(contactInformationDetails("email"), "email", email);
	}

	public void clickEmail(String email) throws InterruptedException {
		click(contactInformationDetails("email"), "");
//		clearText(contactInformationDetails("email"), "");
		enterText(contactInformationDetails("email"), email, "Phone Number text field");

	}

	public void getAddressLine1() {
		String AddressLine1 = getText(addressDetails("1"), "");
		ExtentTestManager.setInfoMessageInReport("Address Line1 is : " + AddressLine1);
	}

	public void getAddressLine2() {
		String AddressLine2 = getText(addressDetails("2"), "");
		ExtentTestManager.setInfoMessageInReport("Address Line2 is : " + AddressLine2);
	}

	public void getState_City_Zipcode() {
		String State_City_Zipcode = getText(addressDetails("3"), "");
		ExtentTestManager.setInfoMessageInReport("State City And Zipcode is : " + State_City_Zipcode);
	}

	public void getCountry() {
		String Country = getText(addressDetails("4"), "");
		ExtentTestManager.setInfoMessageInReport("Country is : " + Country);
	}

	public void verifySaveBtn() {
		WebElement element = getElement(btnSave, "");
		if (element.isEnabled()) {
			click(btnSave, "Save button");
		} else {
			ExtentTestManager.setInfoMessageInReport("Save button is in disabled mode");
		}
	}

//	public void verifySaveBtn() {
//		new CommonFunctions().elementView(btnSave, "Save Button");
//		WebElement element = getElement(btnSave, "");
//		if (element.isEnabled()) {
//			ExtentTestManager.setInfoMessageInReport("Save button is in Enable mode");
//		} else {
//			ExtentTestManager.setailMessageInReport("Save button is in disabled mode");
//		}
//	}
}
