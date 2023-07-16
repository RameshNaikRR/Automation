package coyni.business.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.business.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class RegistrationCompanyInfoPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h4[@data-ui-auto='business_info']");
	private By lblDescription = By.xpath("//p[@data-ui-auto='company_info_and_doing_business']");
	private By txtCompanyName = By.xpath("//input[@data-ui-auto='company_name']");
	private By drpdwnBusinessEntity = By
			.xpath("(//div[contains(@class,'FormField_selected_option__7Rw29 text-cgy4 text-sm')])[1]");
	private By txtTaxNumber = By.xpath("//label[@data-ui-auto='business_tax_number']");
	private By txtBusinessStart = By.xpath("//input[@data-ui-auto='business_start_date']");
	private By txtCompanyEmail = By.xpath("//input[@data-ui-auto='company_email']");
	private By txtPhoneNumber = By.xpath("//input[@data-ui_auto='phone_number']");
	private By btnUploadImage = By.xpath("(//div[contains(@class,'FormFile_form_file')]/input)[1]");
	private By btnRemoveImage = By.xpath("(//span[contains(@class,'FormFile_file_cross')])[1]");
	private By txtCompanyAddressLine1 = By.xpath("//input[@data-ui-auto='company_email']");
	private By txtCompanyCity = By.xpath("//input[@data-ui-auto='company_email']");
	private By txtState = By.xpath("//input[@data-ui-auto='company_email']");
	private By txtZipcode = By.xpath("//input[@data-ui-auto='company_email']");
	private By dropDownCountry = By.xpath("//div[@data-ui-auto='country']/following-sibling::div");
	private By search = By.xpath("//input[@data-ui-auto='country']");
	private By chkbox = By.xpath("//input[@data-ui-auto='Checkbox']");
	private By txtDBAName = By.xpath("//input[@data-ui-auto='dba_name']");
	private By txtDBAAddressLine1 = By.xpath("//input[@data-ui-auto='dba_address_line_1']");
	private By txtBusinessCity = By.xpath("//input[@data-ui-auto='dba_city']");
	private By drpDownDBACountry = By.xpath("//div[@data-ui-auto='dba_country']/following-sibling::div");
	private By dbaSearch = By.xpath("//input[@data-ui-auto='dba_country']");
	private By btnNext = By.xpath("//button[@data-ui-auto='next']");
	private By lnkExit = By.xpath("//button[@data-ui-auto='exit']");
	private By btnCancel = By.xpath("");
	private By businessStartDate = By.xpath("");
	private By merchantApplicationSteps = By.xpath("//div[contains(@class,'BusinessApplicationProcess')]/h6");
	private By txtSSN_EIN_TIN = By.xpath("//input[@data-ui-auto='choose_a_business_entity']");

	private By getUploadDocumentElement(String num) {
		return By.xpath(String.format("(//button[contains(@class,'FormFile_form_file')]/input)[%s]", num));
	}

	public void fillSSN_EIN_TIN(String ssn_ein_tin) {
		enterText(txtSSN_EIN_TIN, ssn_ein_tin, "SSN-EIN/TIN");
	}

	public void verifyHeading() {
		String heading = getText(lblHeading, "Heading");
		ExtentTestManager.setInfoMessageInReport(heading + " is displayed");
	}

	public void verifyCompanyInformation() {
		List<WebElement> list = getElementsList(merchantApplicationSteps, " ");
		boolean enabled = list.get(0).isEnabled();
		if (enabled) {
			ExtentTestManager.setInfoMessageInReport("The company Information tracker is in enabled mode");
		} else {
			ExtentTestManager.setInfoMessageInReport("The company Information tracker is in disabled mode");
		}
	}

	public void selectBusinessEntity(String businessEntity) {
		// click(getOptions("1"), "1");
		click(getElement(businessEntity), businessEntity);
	}

	private By getRemoveDocumentElement(String num) {
		return By.xpath(String.format("(//span[contains(@class,'FormFile_file_cross__jNPjD')])[%s]", num));
	}

	public By getElement(String state) {
		return By.xpath(String.format("//div[@data-ui-auto='%s']", state));
	}

	public void fillTaxNumber(String taxNum) {
		enterText(txtTaxNumber, "Tax Number :", taxNum);
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPageDescription(String expDesc) {
		new CommonFunctions().verifyLabelText(lblDescription, "Page Description", expDesc);
	}

	public void fillCompanyName(String companyName) {
		enterText(txtCompanyName, companyName, "Company Name");
	}

	public void clickBusinessEntityDropdown() {
		click(drpdwnBusinessEntity, "Business Entity Dropdown");
	}

	public void fillBusinessStartDate(String businessStartdate) {
		enterText(businessStartDate, businessStartdate, "Business Start Page");
	}

	public void clickOnCountry(String searchCountry) {
		click(dropDownCountry, "Drop Down Business Information");
		enterText(search, searchCountry, "Search");

	}

	public void clickOnCheckBox() {
		click(chkbox, "Check Box");
	}

//	private By getOptions(String optionNum) {
//		return By.xpath(String.format("((//div[contains(@class,'FormField_selected_option')])[1]/following-sibling::div/div)[%s]", optionNum));
//	}
	public void fillBusinessTaxNumber(String businessEntity) {
		enterText(txtTaxNumber, businessEntity, "businessEntity");
	}

	public void fillCompanyEmail(String companyEmail) {
		enterText(txtCompanyEmail, companyEmail, "Comapny Email");
	}

	public void fillCompanyPhoneNumber(String companyPhoneNumber) {
		enterText(txtPhoneNumber, companyPhoneNumber, "Comapny Phone Number");
	}

	public void fillAddress1(String address) {
		enterText(txtCompanyAddressLine1, address, "Address Line1");
	}

	public void fillCity(String city) {
		enterText(txtBusinessCity, city, "City");
	}

	public void fillState(String state) {
		enterText(txtState, state, "State");
	}

	public void fillZipCode(String zipcode) {
		enterText(txtZipcode, zipcode, "Zipcode");
	}

	public void uploadDocument(String folderName, String fileName, String businessEntity) throws InterruptedException {
		if (!businessEntity.equalsIgnoreCase("Sole Proprietorship / Single LLC")) {
			for (int i = 1; i <= 3; i++) {
				String num = Integer.toString(i);
				getElement(getUploadDocumentElement(num), "select Image" + i)
						.sendKeys(FileHelper.getFilePath(folderName, fileName));
				Thread.sleep(3000);
				ExtentTestManager.setInfoMessageInReport("upload Image" + i);
			}
		} else {
			getElement(getUploadDocumentElement("1"), "select Image")
					.sendKeys(FileHelper.getFilePath(folderName, fileName));
			ExtentTestManager.setInfoMessageInReport("upload Image");
		}
	}

	public void removeFile(String businessEntity) throws InterruptedException {
		if (!businessEntity.equalsIgnoreCase("Sole Proprietorship / Single LLC")) {
			for (int i = 1; i <= 3; i++) {
				String num = Integer.toString(i);
				click(getRemoveDocumentElement(num), "Remove File" + i);
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("Remove Image" + i);
			}
		} else {
			click(getRemoveDocumentElement("1"), "Remove File");
			ExtentTestManager.setInfoMessageInReport("Remove Image");
		}
	}

	/**
	 * Order -minChar, alphabets, specialChar, spaces, maxiPlus
	 */
	public void validateNumber(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		new CommonFunctions().validateField(ele, eleName, field[0]);
		for (int i = 1; i < 4; i++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}
	}

	public void clickExit() {
		click(lnkExit, "Exit");
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public void validatePhoneNumber(String phoneNumber) {
		validateNumber(txtPhoneNumber, "Phone Number", phoneNumber);
	}

	public void validateCompanyName(String companyName) {
		new MailingAddressComponent().validateTextFeild(txtCompanyName, "Company Name", companyName);
	}

	public void validateCompanyEmail(String companyEmail) {
		new MailingAddressComponent().validateTextFeild(txtCompanyEmail, "Company Email", companyEmail);
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}
}
