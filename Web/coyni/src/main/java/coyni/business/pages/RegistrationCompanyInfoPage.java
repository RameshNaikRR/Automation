package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.business.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class RegistrationCompanyInfoPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector("");
	private By lblDescription = By.cssSelector("");
	private By txtCompanyName = By.cssSelector("");
	private By drpdwnBusinessEntity = By.xpath("");
	private By txtSSN_EIN_TIN = By.cssSelector("");
	private By txtTaxNumber = By.xpath("");
	private By txtCompanyEmail = By.cssSelector("");
	private By txtPhoneNumber = By.cssSelector("");
//	private By btnUploadImage =By.xpath("(//div[contains(@class,'FormFile_form_file')]/input)[1]");
//	private By btnRemoveImage =By.xpath("(//span[contains(@class,'FormFile_file_cross')])[1]");
	private By btnNext = By.xpath("");
	private By lnkExit = By.xpath("");
	private By btnCancel = By.xpath("");
	private By businessStartDate = By.xpath("");

	private By getUploadDocumentElement(String num) {
		return By.xpath(String.format("(//button[contains(@class,'FormFile_form_file')]/input)[%s]", num));
	}

	private By getRemoveDocumentElement(String num) {
		return By.xpath(String.format("(//span[contains(@class,'FormFile_file_cross__jNPjD')])[%s]", num));
	}

	public By getElement(String state) {
		return By.xpath(String.format("//div[text()='%s']", state));
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

//	private By getOptions(String optionNum) {
//		return By.xpath(String.format("((//div[contains(@class,'FormField_selected_option')])[1]/following-sibling::div/div)[%s]", optionNum));
//	}
	public void selectBusinessEntity(String businessEntity) {
		// click(getOptions("1"), "1");
		click(getElement(businessEntity), businessEntity);
	}

	public void fillSSN_EIN_TIN(String ssn_ein_tin) {
		enterText(txtSSN_EIN_TIN, ssn_ein_tin, "SSN-EIN/TIN");
	}

	public void fillCompanyEmail(String companyEmail) {
		enterText(txtCompanyEmail, companyEmail, "Comapny Email");
	}

	public void fillCompanyPhoneNumber(String companyPhoneNumber) {
		enterText(txtPhoneNumber, companyPhoneNumber, "Comapny Phone Number");
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
