package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class RegistrationDBAInformationPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector("div[class*='DbaInformation']>h4");
	private By lblPageDescription = By.cssSelector("div[class*='DbaInformation']>p");
	private By lblInfo = By.cssSelector("div[class*='DbaInformation']>div>p");
	private By btnYes = By.xpath("//button/span[text()='Yes']");
	private By btnNo = By.xpath("//button/span[text()='No']");
	private By lblYesDes = By.xpath("//span[text()='Yes']/following-sibling::*[1]");
	private By lblNoDes = By.xpath("//span[text()='No']/following-sibling::*[1]");
	private By btnBack = By.xpath("//button[text()='Back']");
	private By btnExit = By.xpath("//button[text()='Exit']");
	private By lblMessage = By.xpath("//span[contains(text(),'All completed')]");
	private By lblDBAInformation = By.xpath("//h6[text()='DBA Information']");
	private By txtDBAName = By.cssSelector("#dba-name");
	private By drpdwnBusinessType = By.xpath("//div[text()='Business Type']/following-sibling::div");
	private By radBtnRetailLocation = By.xpath("//span[text()='Retail Location']/..");
	private By radBtneCommerce = By.xpath("//span[text()='eCommerce']/..");
	private By txtCompanyEmail = By.xpath("(//input[@name='email'])[2]");
	private By txtphoneNumber = By.cssSelector("#phone-number");
	private By txtWebsite = By.cssSelector("#website");
	private By txtMonthlyProcessingVolume = By.cssSelector("#monthly-processing-volume");
	private By txtHighTicket = By.cssSelector("#high-ticket");
	private By txtAvgTicket = By.cssSelector("#average-ticket");
	private By drpdwnTimeZone = By.xpath("//div[text()='Select Time Zone']/..");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By btnUploadFile = By.cssSelector("//span[.='DBA Filing']");
	private By btnRemoveFile = By.cssSelector("span[class*='FormFile_file_cross']");

	public void fillDBAName(String dbaName) throws InterruptedException {
		clearText(txtDBAName, "DBA Name");
		enterText(txtDBAName, dbaName, "DBA Name");
	}

	public void fillCompanyEmail(String companyName) throws InterruptedException {
		//clearText(txtCompanyEmail, "Company Email");
		enterText(txtCompanyEmail, companyName, "Company Name");
	}

	public void fillPhoneNumber(String phoneNumber) throws InterruptedException {
		clearText(txtphoneNumber, "Phone Number");
		enterText(txtphoneNumber, phoneNumber, "Phone Number");
	}

	public void fillWebsite(String website) throws InterruptedException {
		clearText(txtWebsite, "Website");
		enterText(txtWebsite, website, "Website");
	}

	public void clickDBAInformation() {
		click(lblDBAInformation, "DBA Information");
	}

	public void fillMonthlyProcessingVolume(String processingVolume) throws InterruptedException {
		clearText(txtMonthlyProcessingVolume, "Processing Volume");
		enterText(txtMonthlyProcessingVolume, processingVolume, "Processing Volume");
	}

	public void fillHighTicket(String highTicket) throws InterruptedException {
		clearText(txtHighTicket, "High Ticket");
		enterText(txtHighTicket, highTicket, "High Ticket");
	}

	public void fillAverageTicket(String averageTicket) throws InterruptedException {
		clearText(txtAvgTicket, "Average Ticket");
		enterText(txtAvgTicket, averageTicket, "Avergare Ticket");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickBusinessTypeDropdown() {
		click(drpdwnBusinessType, "Business Type Drop down");
	}

	private By getElement(String businessType) {
		return By.xpath(String.format("//div[text()='%s']", businessType));
	}

	private By timeZone(String timeZone) {
		return By.xpath(String.format("//span[normalize-space()='%s']", timeZone));
	}

	public void selectBusinessType(String businessType) {
		click(drpdwnBusinessType, "Business Type Drop down");
		click(getElement(businessType), businessType);
	}

	public void clickRetailLocation() {
		click(radBtnRetailLocation, "Retail Location");
	}

	public void clickeCommerce() {
		click(radBtneCommerce, "eCommerce");
	}

	public void clickTimeZoneDropdown() {
		click(drpdwnTimeZone, "TimeZone Drop down");

	}

	public void selectTimeZone(String timeZone) throws InterruptedException {
		click(drpdwnTimeZone, "TimeZone Drop down");
		Thread.sleep(3000);
		click(timeZone(timeZone), timeZone);
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
		if (verifyElementDisplayed(btnNo, "No")) {
			click(btnNo, "No");
		} else {
			ExtentTestManager.setInfoMessageInReport("Next button is in disabled mode");
		}
	}

	public int getSize() {
		return getElementsList(btnNo, "No").size();
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickExit() {
		click(btnExit, "Exit");
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

	public void verifyDBAName(String DBAName) throws InterruptedException {
		// verifyElementDisable(txtDBAName, "DBA Name");
		clearText(txtDBAName, "DBA Name");
		verifyTextBoxValue(txtDBAName, "DBAName", DBAName);
	}

	public void verifyCompanyEmail(String companyEmail) {
		// verifyElementDisable(txtCompanyEmail, "Company Service Email");
		verifyTextBoxValue(txtCompanyEmail, "Company Email", companyEmail);
	}

	public void verifyPhoneNumber(String phoneNumber) {
		// verifyElementDisable(txtphoneNumber, "phone Number");
		verifyTextBoxValue(txtphoneNumber, "Phone Number", phoneNumber);
	}

	public void uploadFile(String folderName, String fileName) {
		getElement(btnUploadFile, "select File").sendKeys(FileHelper.getFilePath(folderName, fileName));
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
