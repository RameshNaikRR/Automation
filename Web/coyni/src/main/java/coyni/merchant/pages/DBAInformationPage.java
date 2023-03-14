package coyni.merchant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.merchant.popups.AccountProfileImagePopup;
import coyni.merchant.popups.BusinessImageLogoPopup;
import coyni.merchant.popups.BusinessLogoPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DBAInformationPage extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='DBA Information']");
	private By labelwebsite=By.xpath("//p[contains(@class,'break-words')]");

	private By getLables(String Lables) {
		return By.xpath(String.format("//p[.='%s']", Lables));
	}

	private By lblNoImage = By.xpath("//div[contains(@class,'justify-between')]//span[contains(@class,'text-cwhite')]");
	private By lblImage = By.xpath("//div[contains(@class,'justify-between')]//img[contains(@src,'profile-images')]");
	private By btnEditIcon = By.xpath("//img[contains(@class,'w-4 h-4')]");
	private By lblDBAname = By.xpath("(//div[contains(@class,'_sidehead')])[1]/following-sibling::div[1]/p");
	private By lnkCancelMerchanytAccount = By.xpath("//button[.='Cancel Merchant Account']");
	private By lblWebsiteName = By.xpath("(//div[contains(@class,'_sidehead')])[2]/following-sibling::div[1]/p");
	private By lblBusinessType = By.xpath("(//div[contains(@class,'_sidehead')])[3]/following-sibling::div[1]/p");
	private By btnSave = By.xpath("//button[.='Save']");

	private By lblCompanyName = By.xpath("//p[contains(text(),'Vishnu')]");

	private By customerServiceDetails(String csd) {
		return By.xpath(String.format("//input[@name='%s']", csd));
	}

	public void clickSave() {
		click(btnSave, "Save");
	}
	
	
	public void getwebsite() {
		new CommonFunctions().elementView(labelwebsite, "website");
	}
	
	
	
	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void verifyhandSymbolHighlightedDbaInformation(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Dba information"), "Dba information");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "Dba information", cssProp, expValue,
				expColor);
	}

	public void clickNoImage() {
		click(lblNoImage, "No Image");
	}
    
	public void getCompanyAndDBAname() {
		String companyName = getText(lblCompanyName, "Company Name");
		String DBAname = getText(lblDBAname, "DBA Name");
		if (companyName == DBAname) {
			ExtentTestManager.setInfoMessageInReport("Company Name and DBA Name is matched");

		} else {
			ExtentTestManager.setInfoMessageInReport("Company Name and DBA Name not matched");

		}

	}

	
	
	
	public void clickImage() {
		// moveToElement(lblImage, "Image");
		if (verifyElementDisplayed(lblImage, "Image")) {
			click(lblImage, "Image");
		} else {
			click(lblNoImage, "No Image");
		}
	}

	public void clickEditImage() {
		click(btnEditIcon, "Edit Icon");
	}

	private By dbaAddressDetails(String Address) {
		return By.xpath(
				String.format("(//div[contains(@class,'_sidehead')])[5]/following-sibling::div[1]/p[%s]", Address));
	}

	public void clickCancelMerchantAccountLnk() {
		click(lnkCancelMerchanytAccount, "Cancel Merchant Account");
	}

	public void verifyCancelMerchnatAccountLnk() {
		cf.elementView(lnkCancelMerchanytAccount, "Cancel Merchant Account");
	}

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDBAnameLbl() {
		cf.elementView(getLables("DBA Name"), "DBA Name label ");
	}

	public void verifyWebsiteLbl() {
		cf.elementView(getLables("Website"), "Website label ");
	}

	public void verifyBusinessTypeLbl() {
		cf.elementView(getLables("Business Type"), "Business Type label ");
	}

	public void verifyCustomerServiceLbl() {
		cf.elementView(getLables("Customer Service"), "Customer Service label ");
	}

	public void verifyAddressLbl() {
		cf.elementView(getLables("Customer Service"), "Customer Service label ");
	}

	public void getDBAname() {
		String DBAname = getText(lblDBAname, "");
		ExtentTestManager.setInfoMessageInReport("DBA name is: " + DBAname);
	}

	public void getWebsiteName() {
		String WebsiteName = getText(lblWebsiteName, "");
		ExtentTestManager.setInfoMessageInReport("DBA name is: " + WebsiteName);
	}

	public void getBusinessType() {
		String BusinessType = getText(lblBusinessType, "");
		ExtentTestManager.setInfoMessageInReport("DBA name is: " + BusinessType);
	}

	public void getPhoneNumber() {
		String PhoneNumber = getText(customerServiceDetails("phoneNumber"), "");
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
		click(customerServiceDetails("phoneNumber"), "");
		enterText(customerServiceDetails("phoneNumber"), phoneNumber, "Phone Number text field");
	}

	public void verifyPhoneNumber(String PhoneNumber) {
		click(customerServiceDetails("phoneNumber"), "");
		validateNumber(customerServiceDetails("phoneNumber"), "PhoneNumber", PhoneNumber);
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
		String email = getText(customerServiceDetails("email"), "");
		ExtentTestManager.setInfoMessageInReport("Email is: " + email);
	}

	public void verifyEmail(String email) {
		click(customerServiceDetails("email"), "");
		validateEmailField(customerServiceDetails("email"), "email", email);
	}

	public void clickEmail(String email) throws InterruptedException {
		click(customerServiceDetails("email"), "");
//		clearText(contactInformationDetails("email"), "");
		enterText(customerServiceDetails("email"), email, "Phone Number text field");

	}

	public void getAddressLine1() {
		String AddressLine1 = getText(dbaAddressDetails("1"), "");
		ExtentTestManager.setInfoMessageInReport("Address Line1 is : " + AddressLine1);
	}

	public void getAddressLine2() {
		String AddressLine2 = getText(dbaAddressDetails("2"), "");
		ExtentTestManager.setInfoMessageInReport("Address Line2 is : " + AddressLine2);
	}

	public void getState_City_Zipcode() {
		String State_City_Zipcode = getText(dbaAddressDetails("3"), "");
		ExtentTestManager.setInfoMessageInReport("State City And Zipcode is : " + State_City_Zipcode);
	}

	public void getCountry() {
		String Country = getText(dbaAddressDetails("4"), "");
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
//			ExtentTestManager.setInfoMessageInReport("Save button is in disabled mode");
//		}
//	}

	public BusinessImageLogoPopup businessImageLogoPopup() {
		return new BusinessImageLogoPopup();
	}

	public AccountProfileImagePopup accountProfileImagePopup() {
		return new AccountProfileImagePopup();
	}

	public BusinessLogoPopup businessLogoPopup() {
		return new BusinessLogoPopup();
	}
}
