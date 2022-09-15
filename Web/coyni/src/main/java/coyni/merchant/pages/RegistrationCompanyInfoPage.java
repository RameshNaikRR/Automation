package coyni.merchant.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.merchant.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class RegistrationCompanyInfoPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector("div[class*='CompanyInformation']>h4");
	private By lblDescription = By.cssSelector("div[class*='CompanyInformation']>p");
	private By txtCompanyName = By.cssSelector("#company-name");
	private By companyName = By.xpath("//h6[text()='Company Information']");
	private By drpdwnBusinessEntity = By.xpath("(//div[contains(@class,'FormField_selected_option')])[1]");
	private By txtSSN_EIN_TIN = By.cssSelector("input[id='ssn/ein-tin']");
	private By txtCompanyEmail = By.cssSelector("#email");
	private By txtPhoneNumber = By.cssSelector("#phone-number");
//	private By btnUploadImage =By.xpath("(//div[contains(@class,'FormFile_form_file')]/input)[1]");
//	private By btnRemoveImage =By.xpath("(//span[contains(@class,'FormFile_file_cross')])[1]");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By btnCancel = By.xpath("//button[text()='Cancel']");
	private By btnExit = By.xpath("//button[text()='Exit']");
	private By merchantApplicationSteps = By.xpath("//div[contains(@class,'BusinessApplicationProcess')]/h6");

	public void verifyCompanyInformation() {
		List<WebElement> list = getElementsList(merchantApplicationSteps, " ");
		boolean enabled = list.get(0).isEnabled();
		if (enabled) {
			ExtentTestManager.setInfoMessageInReport("The element is in enabled mode");
		} else {
			ExtentTestManager.setInfoMessageInReport("The element is in disabled mode");
		}
	}

	public void verifyDBAInformation() {
		List<WebElement> list = getElementsList(merchantApplicationSteps, " ");
		boolean enabled = list.get(1).isEnabled();
		if (enabled) {
			ExtentTestManager.setInfoMessageInReport("The element is in enabled mode");
		} else {
			ExtentTestManager.setInfoMessageInReport("The element is in disabled mode");
		}
	}

	public void verifyBeneficialOwners() {
		List<WebElement> list = getElementsList(merchantApplicationSteps, " ");
		boolean enabled = list.get(2).isEnabled();
		if (enabled) {
			ExtentTestManager.setInfoMessageInReport("The element is in enabled mode");
		} else {
			ExtentTestManager.setInfoMessageInReport("The element is in disabled mode");
		}
	}

	public void verifyBankAccountInformation() {
		List<WebElement> list = getElementsList(merchantApplicationSteps, " ");
		boolean enabled = list.get(3).isEnabled();
		if (enabled) {
			ExtentTestManager.setInfoMessageInReport("The element is in enabled mode");
		} else {
			ExtentTestManager.setInfoMessageInReport("The element is in disabled mode");
		}
	}

	public void verifyMerchantAgreements() {
		List<WebElement> list = getElementsList(merchantApplicationSteps, " ");
		boolean enabled = list.get(4).isEnabled();
		if (enabled) {
			ExtentTestManager.setInfoMessageInReport("The element is in enabled mode");
		} else {
			ExtentTestManager.setInfoMessageInReport("The element is in disabled mode");
		}
	}

	public void verifyApplicationSummary() {
		List<WebElement> list = getElementsList(merchantApplicationSteps, " ");
		boolean enabled = list.get(5).isEnabled();
		if (enabled) {
			ExtentTestManager.setInfoMessageInReport("The element is in enabled mode");
		} else {
			ExtentTestManager.setInfoMessageInReport("The element is in disabled mode");
		}
	}

	private By getUploadDocumentElement(String num) {
		return By.xpath(String.format("(//*[contains(@class,'FormFile_form_file__-SKGD')]/input)[%s]", num));
	}

	public void clickExit() {
		click(btnExit, "Exit");
	}

	public void clickCompanyName() {
		click(companyName, "Company Name");
	}

	private By getRemoveDocumentElement(String num) {
		return By.xpath(String.format("(//span[contains(@class,'FormFile_file_cross')])[%s]", num));
	}

	public By getElement(String state) {
		return By.xpath(String.format("//div[text()='%s']", state));
	}

	public void getCompanyInformation() {
		String text = getText(lblHeading, "Heading ");
		ExtentTestManager.setInfoMessageInReport("Company Information : " + text);
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
				Thread.sleep(6000);
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
				click(getRemoveDocumentElement("1"), "Remove File" + i);
				Thread.sleep(2000);
			}
		} else {
			click(getRemoveDocumentElement("1"), "Remove File");
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
		click(btnNext, "Next");
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public void validatePhoneNumber(String phoneNumber) {
		validateNumber(txtPhoneNumber, "Phone Number", phoneNumber);
	}

	public void validateCompanyName(String companyName) {
		new MailingAddressComponent().validateTextField(txtCompanyName, "Company Name", companyName);
	}

	public void validateCompanyEmail(String companyEmail) {
		new MailingAddressComponent().validateTextField(txtCompanyEmail, "Company Email", companyEmail);
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}
}
