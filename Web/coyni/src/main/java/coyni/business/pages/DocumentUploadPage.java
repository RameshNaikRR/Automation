package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DocumentUploadPage extends BrowserFunctions {

	private By lblHeading = By.xpath("");
	private By lblDes = By.xpath("");
	private By btnNext = By.xpath("");
	private By lnkBack = By.xpath("");
	private By lnkExit = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHeading);
	}

	public void verifyDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description is: ", expDes);
	}

	private By getUploadDocumentElement(String num) {
		return By.xpath(String.format("(//*[contains(@class,'FormFile_form_file__-SKGD')]/input)[%s]", num));
	}

	public void uploadDocument(String folderName, String fileName) throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			String num = Integer.toString(i);
			getElement(getUploadDocumentElement(num), "select Image" + i).sendKeys(folderName, fileName);
			Thread.sleep(6000);
			ExtentTestManager.setInfoMessageInReport("upload image" + i);
		}
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

	public AccountFeesAndLimitsPage accountFeesAndLimitsPage() {
		return new AccountFeesAndLimitsPage();
	}

}
