package coyni.apibusiness.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.apibusiness.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;
import ilabs.web.actions.WaitForElement;

public class RegistrationDBAInformationPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector("div[class*='DbaInformation']>h4");
	private By lblPageDescription = By.cssSelector("div[class*='DbaInformation']>p");
	private By lblInfo = By.cssSelector("div[class*='DbaInformation']>div>p");
	private By btnYes = By.xpath("//button/span[text()='Yes']");
	private By btnNo = By.xpath("//button/span[text()='No']");
	private By lblYesDes = By.xpath("//span[text()='Yes']/following-sibling::*[1]");
	private By lblNoDes = By.xpath("//span[text()='No']/following-sibling::*[1]");
	private By btnBack = By.xpath("//Button[text()='Back']");
	private By btnExit = By.xpath("//button[text()='Exit']");
	private By lblMessage = By.xpath("//span[contains(text(),'All completed')]");
	private By btnSave = By.xpath("//button/span[text()='Save']");
	private By lblBusinessType = By.xpath("//p[text()='Business Type']");
	private By lblAddress = By.xpath("//p[text()='Address']");
	private By lblCustomerService = By.xpath("//p[text()='Customer Service']");
	private By txtDBAName = By.cssSelector("#dba-name");
	private By drpdwnBusinessType = By.xpath("//div[text()='Business Type']/following-sibling::div");
	private By radBtnRetailLocation = By.xpath("//span[text()='Retail Location']/..");
	private By radBtneCommerce = By.xpath("//span[text()='eCommerce']/..");
	private By txtCompanyEmail = By.cssSelector("#email");
	private By txtphoneNumber = By.cssSelector("#phone-number");
	private By txtWebsite = By.cssSelector("#website");
	private By drpdwnTimeZone = By.xpath("//div[text()='Select Time Zone']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By btnUploadFile = By.xpath("//button[contains(@class,'FormFile_form_file__-SKGD')]");
	private By btnRemoveFile = By.cssSelector("span[class*='FormFile_file_cross']");
	private By btnEdit = By.xpath("");
	private By dropdwnTimeZone = By.xpath("//div[text()='Pacific (PST)'");

	private By dropdwnTimeZone(String timezone) {
		return By.xpath(String.format("//div[@class='FormField_options_wrap__wE188']", timezone));
	}

	public void fillDBAName(String dbaName) {
		enterText(txtDBAName, dbaName, "DBA Name");
	}

	public void fillCompanyEmail(String companyName) {
		enterText(txtCompanyEmail, companyName, "Company Name");
	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtphoneNumber, phoneNumber, "Phone Number");
	}

	public void fillWebsite(String website) {
		enterText(txtWebsite, website, "Website");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void clickBusinessTypeDropdown() {
		click(drpdwnBusinessType, "Business Type Drop down");
	}

	public By getElement(String businessType) {
		return By.xpath(String.format("//div[text()='%s']", businessType));
	}

	public void selectBusinessType(String businessType) {
		click(drpdwnBusinessType, "Business Type Drop down");
		click(getElement(businessType), businessType);
	}

	public void businessTypeView() {
		new CommonFunctions().elementView(lblBusinessType, "BusinessType");
	}

	public void customerServiceView() {
		new CommonFunctions().elementView(lblCustomerService, "Customer Service");
	}

	public void addressView() {
		new CommonFunctions().elementView(lblAddress, "Address");
	}

	public void clickRetailLocation() {
		click(radBtnRetailLocation, "Retail Location");
	}

	public void clickeCommerce() {
		click(radBtneCommerce, "eCommerce");
	}

	public By getElement1(String timeZone) {
		return By.xpath(String.format("//div[text()='%s']", timeZone));
	}

	public void selectTimeZone(String option, String timeZone) {
		BrowserFunctions objBrowserFunctions = new BrowserFunctions();
		click(drpdwnTimeZone, "TimeZone Drop down");
		try {
			By options = By.xpath("//div[@class='FormField_options_wrap__wE188']");
			boolean status = false;
			objBrowserFunctions.waitForElement(options, BrowserFunctions.waittime, WaitForElement.presence);
			List<WebElement> optionsEles = objBrowserFunctions.getElementsList(options, "options");
			for (WebElement optionEle : optionsEles) {
				if (optionEle.getText().equalsIgnoreCase(option)) {
					optionEle.click();
					status = true;
					break;
				}
			}
			if (status) {
				ExtentTestManager.setInfoMessageInReport(option + " selected from " + timeZone + " drop down");
			} else {
				ExtentTestManager.setFailMessageInReport(option + " not available in " + timeZone + " dropdown");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("select custom drop down failed due to exception " + e);
		}
		
//		click(getElement1(timeZone), timeZone);
//		Thread.sleep(2000);
	}

	public void clickTimeZone() {
		click(drpdwnTimeZone, "TimeZone Drop down");
		click(dropdwnTimeZone, "TimeZone Drop down");
//		click(getElement(timeZone), timeZone);
//		Thread.sleep(2000);
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPageDescription(String DBAPageDescription) {
		new CommonFunctions().verifyLabelText(lblPageDescription, "DBAPageDescription", DBAPageDescription);
	}

	public void verifyInfo(String expInfo) {
		new CommonFunctions().verifyLabelText(lblInfo, "Information", expInfo);
	}

	public void verifyLabelYes(String expYesLabel) {
		new CommonFunctions().verifyLabelText(lblYesDes, "Yes Button Description", expYesLabel);
	}

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void verifyLabelNo(String expNoLabel) {
		new CommonFunctions().verifyLabelText(lblNoDes, "Yes Button Description", expNoLabel);
	}

	public void clickNo() {
		click(btnNo, "No");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickExit() {
		click(btnExit, "Exit");
	}

	public void clickEditIcon() {
		new CommonFunctions().verifyCursorAction(btnEdit, "Edit");
	}

	public void verifyMessage(String expMessage) {
		new CommonFunctions().verifyLabelText(lblMessage, "Message", expMessage);
	}

	public void verifyTextBoxValue(By ele, String eleName, String expValue) {
		String actualText = getTextBoxValue(ele, eleName);
		if (actualText.equals(expValue)) {
			ExtentTestManager.setPassMessageInReport(eleName + "Text field contains" + expValue);
		} else {
			ExtentTestManager.setWarningMessageInReport(eleName + "Text filed doesn't contains" + expValue);
		}
	}

	public void verifyElementDisable(By ele, String eleName) {
		if (!getElement(ele, eleName).isEnabled()) {
			ExtentTestManager.setInfoMessageInReport(eleName + "is disabled");
		} else {
			ExtentTestManager.setWarningMessageInReport(eleName + "is not disabled");
		}
	}

	public void verifyDBAName(String DBAName) {
		verifyElementDisable(txtDBAName, "DBA Name");
		verifyTextBoxValue(txtDBAName, "DBAName", DBAName);

	}

	public void dBANameView() {
		new CommonFunctions().elementView(txtDBAName, "DBAName");
	}

	public void companyEmailView() {
		new CommonFunctions().elementView(txtCompanyEmail, "companyEmail");
	}

	public void phoneNumberView() {
		new CommonFunctions().elementView(txtphoneNumber, "phoneNumber");
	}

	public void verifyCompanyEmail(String companyEmail) {
		verifyElementDisable(txtCompanyEmail, "Company Service Email");
		verifyTextBoxValue(txtCompanyEmail, "Company Email", companyEmail);

	}

	public void verifyPhoneNumber(String phoneNumber) {
		verifyElementDisable(txtphoneNumber, "phone Number");
		verifyTextBoxValue(txtphoneNumber, "Phone Number", phoneNumber);

	}

	public void clickSaveEnabled() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save ");
		} else {
			ExtentTestManager.setPassMessageInReport("Save button is in disabled mode");
		}
	}

	public void uploadFile(String folderName, String fileName) throws InterruptedException {
		getElement(btnUploadFile, "select File").sendKeys(FileHelper.getFilePath(folderName, fileName));
		Thread.sleep(3000);
		ExtentTestManager.setInfoMessageInReport("upload Image");
	}

	public void removeFile() {
		click(btnRemoveFile, "Remove File");
	}

	public void validateDBAName(String dbaName) {
		new MailingAddressComponent().validateTextField(txtDBAName, "DBA Name", dbaName);
	}

	public void validateCompanyServiceEmail(String companyEmail) {
		new MailingAddressComponent().validateTextField(txtCompanyEmail, "Company Email", companyEmail);
	}

	public void validatePhoneNumber(String phoneNumber) {
		new RegistrationCompanyInfoPage().validateNumber(txtphoneNumber, "Phone Number", phoneNumber);
	}
}
