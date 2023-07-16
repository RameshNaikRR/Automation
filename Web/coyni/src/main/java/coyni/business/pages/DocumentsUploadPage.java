package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class DocumentsUploadPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[@data-ui-auto='upload_business_documents']");
	private By lblDescription = By.xpath("");
	private By lblArticlesOfCorporation = By.xpath("");
	private By lblCompanyW = By.xpath("");
	private By lblEINLetter = By.xpath("");
	private By lblDbaFiling = By.xpath("");
	private By lblAdditionalDocuments = By.xpath("");
	private By btnNext = By.xpath("//button[contains(text(),'Next')]");
	private By lnkBack = By.xpath("//button[@data-ui-auto='back_button']");
	private By lnkExit = By.xpath("");

	private By lnkUploadImg = By.xpath(
			"(//div[contains(@class,'BeneficialOwners_owners_wrap')]/details)[1]//p[text()='Select Identification to Upload:']/../following-sibling::*[1]/input");

	private By getUploadDocumentElement = By
			.xpath(String.format("//div[@class='flex items-center justify-center']/../input"));

	public void verifyHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is:", heading);
	}

	private By getUploadDocumentElement(String num) {
		return By.xpath(String.format("(//*[contains(@class,'FormFile_form_file__-SKGD')]/input)[%s]", num));
	}

	public void uploadDocument(String folderName, String fileName, String businessEntity) throws InterruptedException {
		if (!businessEntity.equalsIgnoreCase("Company W-9")) {
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

	public void verifyDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description is :", description);
	}

	public void verifyArticlesOfCorporation(String articlesOfCorporation) {
		new CommonFunctions().verifyLabelText(lblArticlesOfCorporation, "Articles Of Corporation: ",
				articlesOfCorporation);
	}

	public void verifyCompanyW(String company) {
		new CommonFunctions().verifyLabelText(lblCompanyW, "Company Heading :", company);
	}

	public void verifyEINLetter(String einletter) {
		new CommonFunctions().verifyLabelText(lblEINLetter, "EIN letter :", einletter);
	}

	public void verifyDbaFiling(String dbafiling) {
		new CommonFunctions().verifyLabelText(lblDbaFiling, "DBA Filing:", dbafiling);
	}

	public void verifyAdditionalDocument(String additionalDocument) {
		new CommonFunctions().verifyLabelText(lblAdditionalDocuments, "Additional Document :", additionalDocument);
	}

	public By getID(String id) {
		return By.cssSelector(String.format("#%s", id));
	}

	public void selectID(String id, int num1) {
		String i = Integer.toString(num1);
		if (id.equalsIgnoreCase("drivers license")) {
			click(getID(String.format("drivers-license-%s", i)), id);
		} else if (id.equalsIgnoreCase("state issued id")) {
			click(getID(String.format("state-id-%s", i)), id);
		} else {
			click(getID(String.format("passport-%s", i)), id);
		}
	}

	public void clickUploadImg() {
		click(lnkUploadImg, "upload Image");
	}

	public void uploadSelectImage(String folderName, String fileName) {
//      getElement(getUploadDocumentElement, "select Image").click();
		getElement(getUploadDocumentElement, "Upload Image").sendKeys(FileHelper.getFilePath(folderName, fileName));
	}

	private By getRemoveDocumentElement(String num) {
		return By.xpath(String.format("(//span[contains(@class,'FormFile_file_cross')])[%s]", num));
	}

	public void removeFile() throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			String num = Integer.toString(i);
			click(getRemoveDocumentElement("1"), "Remove File" + i);
			Thread.sleep(2000);
		}
	}

	public void clickNext() {
		new CommonFunctions().verifyCursorAction(btnNext, "Next");
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}

	public void clickBack() {
		click(lnkBack, "Back");
	}

	public void clickExit() {
		click(lnkExit, "Exit");
	}
}
