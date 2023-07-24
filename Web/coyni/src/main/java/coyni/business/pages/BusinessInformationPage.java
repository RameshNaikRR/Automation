package coyni.business.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessInformationPage extends BrowserFunctions {

	private By lblHeading = By.xpath("(//span[text()='Business Information'])[2]");
	private By lblDes = By.xpath("");
	private By txtCompanyName = By.xpath("");
	private By drpdwnBusinessEntity = By.xpath("");
	private By txtBusinessStartDate = By.xpath("");
	private By txtCompanyEmail = By.xpath("//input[@name='email']");
	private By txtCompanyPhoneNumber = By.xpath("//input[@id='Phone Number']");
	private By txtCompanyAddressLine1 = By.xpath("");
	private By txtCompanyAddressLine2 = By.xpath("");
	private By txtCity = By.xpath("");
	private By drpdwnState = By.xpath("");
	private By txtZipCode = By.xpath("");
	private By lblCountry = By.xpath("");
	private By chkbxDoBusiness = By.xpath("");
	private By txtDBAName = By.xpath("");
	private By txtDBAAddressLine1 = By.xpath("");
	private By txtDBAAddressLine2 = By.xpath("");
	private By lnkExit = By.xpath("");
	private By btnNext = By.xpath("");
	private By btnSave = By.xpath("");

	// Business Settings - Business Information
	private By businessName = By.xpath("//p[@class='text-xl font-bold text-cgy8']");
	private By businessEntity = By.xpath("//div[@class='flex flex-row gap-[134px] mt-6'][1]");
	private By startDate = By.xpath("//div[@class='flex flex-row gap-[134px] mt-6'][2]");
	private By companyEmail = By.xpath("//div[@class='flex flex-row gap-[134px] mt-6'][3]");
	private By companyPhone = By.xpath("//div[@class='flex flex-row gap-[134px] mt-6'][4]");
	private By address = By.xpath("//div[@class='flex flex-row gap-[134px] mt-6'][5]");
	private By lblDBAInfo = By.xpath("//span[text()='DBA Information']");
	private By dbaName = By.xpath("//div[@class='flex flex-row gap-[134px] mt-8']");
	private By application = By.xpath("//button[contains(@class,' BusinessInformation_AgreeCard__tazms')]");
	private By accountID = By.xpath("//p[@class='text-xs text-cgy3']");
	private By status = By.xpath("//div[@class='flex flex-wrap items-center gap-2 mt-3']");
	private By editEmail = By.xpath("(//button[@class='mt-2 text-xs font-bold text-cm3 hover:underline'])[1]");
	private By editPhone = By.xpath("(//button[@class='mt-2 text-xs font-bold text-cm3 hover:underline'])[2]");
	
	public void verifyBusinessName() {
		String str = getText(businessName, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyBusinessEntity() {
		String str = getText(businessEntity, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyStartDate() {
		String str = getText(startDate, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyCompanyEmail() {
		String str = getText(companyEmail, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickEditEmail() {
		click(editEmail, "Edit");
	}

	public void verifyCompanyPhone() {
		String str = getText(companyPhone, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickEditPhone() {
		click(editPhone, "Edit Phone");
	}

	public void verifyAddress() {
		String str = getText(address, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyDBAInfo() {
		String str = getText(lblDBAInfo, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyDBAName() {
		String str = getText(dbaName, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyApplication() {
		String str = getText(application, "");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyAccountID() {
		String str = getText(accountID, "AccountID");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyStatus() {
		String str = getText(status, "Status");
		ExtentTestManager.setInfoMessageInReport("Status is " + str);
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading ", expHeading);
	}

	public void verifyDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description: ", expDes);
	}

	public void fillCompanyName(String companyName) {
		enterText(txtCompanyName, companyName, "Company Name");
	}

	public void selectBusinessEntity() {
		click(drpdwnBusinessEntity, "Business Entity");
	}

	public void fillBusinessStartDate(String startDate) {
		enterText(txtBusinessStartDate, startDate, "Business Start Date");
	}

	public void fillCompanyEmail(String companyEmail) {
		enterText(txtCompanyEmail, companyEmail, "Company Email");
	}

	public void fillCompanyPhoneNumber(String phoneNumber) {
		enterText(txtCompanyPhoneNumber, phoneNumber, "Company Phone Number");
	}

	public void fillCompanyAddress1(String address1) {
		enterText(txtCompanyAddressLine1, address1, "Company Address Line 1");
	}

	public void fillCompanyAddress2(String address2) {
		enterText(txtCompanyAddressLine2, address2, "Company Address Line 2");
	}

	public void fillCity(String city) {
		enterText(txtCity, city, "City");
	}

	public void selectState(String state) {
		click(drpdwnState, "State");
		By stateName = By.xpath(String.format("", state));
		click(stateName, state);
	}

	public void fillZipCode(String zipCode) {
		enterText(txtZipCode, zipCode, "Zip Code");
	}

	public void verifyCountry(String expCountry) {
		new CommonFunctions().verifyLabelText(lblCountry, "Country is: ", expCountry);
	}

	public void clickDoBusiness() {
		click(chkbxDoBusiness, "Do Business");
	}

	public void fillDBAName(String dbaName) {
		enterText(txtDBAName, dbaName, "DBA Name");
	}

	public void fillDBAAddress1(String address1) {
		enterText(txtDBAAddressLine1, address1, "DBA Address Line 1");
	}

	public void fillDBAAddress2(String address2) {
		enterText(txtDBAAddressLine2, address2, "DBA Address Line 2");
	}

	public void clickExit() {
		click(lnkExit, "Exit");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}

	public void viewDBAName() {
		List<WebElement> rows = getElementsList(dbaName, "DBA Name");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void clickSaveEnabled() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
		} else {
			ExtentTestManager.setPassMessageInReport("Save button is in disabled mode");
		}
	}

	public void clickTab() throws AWTException {
		new CommonFunctions().clickTab();
	}

	public void clickOutsideElement() {
		new CommonFunctions().clickOutSideElement();
	}

	public AuthorizedSignersPage authorizedSignersPage() {
		return new AuthorizedSignersPage();
	}

}
