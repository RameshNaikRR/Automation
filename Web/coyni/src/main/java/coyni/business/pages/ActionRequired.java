package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.business.components.NavigationComponent;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class ActionRequired extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[contains(text(),'Business Application')]");
	private By description = By.xpath("//p[contains(text(),'website content revisions')]");
	private By message = By.xpath("//p[contains(text(),'Message From coyni')]");
	private By msgtext = By.xpath("//p[@class='undefined break-words text-sm mt-2 text-cgy3 italic']");
	private By uploadFile = By.xpath("//span[text()='Upload File']");
	private By submit = By.xpath("//button[text()='Submit']");

	public void verifyHeading() {
		String str = getText(lblHeading, "Heading");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyDescription() {
		String str = getText(description, "Description");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyMessageHeading() {
		String str = getText(message, "Message Heading");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyMessage() {
		String str = getText(msgtext, "Message");
		ExtentTestManager.setPassMessageInReport(str);
	}

	private By getUploadDocumentElement = By
			.xpath(String.format("//div[@class='flex items-center justify-center']/../input"));

	public void uploadSelectImage(String folderName, String fileName) {
		moveToElement(uploadFile, "Upload File");
//      getElement(getUploadDocumentElement, "select Image").click();
		getElement(getUploadDocumentElement, "Upload Image").sendKeys(FileHelper.getFilePath(folderName, fileName));
	}

	public void clickUploadFile() {
		click(uploadFile, "upload File");
	}

	public void clickSubmit() {
		click(submit, "Submit");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
