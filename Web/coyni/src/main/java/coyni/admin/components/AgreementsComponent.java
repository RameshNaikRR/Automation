package coyni.admin.components;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class AgreementsComponent extends BrowserFunctions {

	private By heading = By.xpath("//span[contains(text(),'Agreements')]");
	private By btnPrivacyPolicy = By
			.xpath("//button[contains(@class,'w-full agreements-row')]//p[text()='Privacy Policy']");
	private By btnTermsofServices = By
			.xpath("//button[contains(@class,'w-full agreements-row')]//p[text()='Terms of Service']");
	private By lblAgreements = By.xpath("//div[contains(@class,'Agreements_content')]");
	private By headingPrivacyPolicy = By.xpath("//span[contains(text(),'Privacy Policy')]");
	private By headingTermsofService = By.xpath("//span[contains(text(),'Terms of Service')]");
	private By lblLastUpdateOfTermsOfService = By
			.xpath("(//span[contains(@class,'agreement-type-list__body__date')])[1]");
	private By txtVersion = By.xpath("(//input[contains(@class,'Input_form_input__yl3pD ')])[2]");
	private By txtChangeSummery = By
			.xpath("//div[contains(@class,'public-DraftStyleDefault-block public-DraftStyleDefault-ltr')]");
	private By uploadDocument = By.xpath("//input[contains(@class,'absolute w-60 h-60 opacity-0 cursor-pointer')]");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By btnBack = By.xpath("//button[text()='Back']");
	private By btnCancelIcon = By.xpath("//img[@alt='croxx icon']");

	private By lblTosAgreement = By.xpath("//h1[text()='Save TOS agreement']");
	private By rdMeterial = By.xpath("//span[text()='Material']");
	private By rdNonMeterial = By.xpath("//span[text()='None Material']");
	private By btnStartDate = By.xpath("(//span[text()='Select A Date'])[1]");
	private By btnEffectiveDate = By.xpath("(//span[text()='Select A Date'])[2]");
	private By btnschedule = By.xpath("//button[text()='Schedule']");
	private By btnEdit = By.xpath("//button[contains(@class,'icon-edit')]");
	private By btnViewDetails = By.xpath("(//button[text()='View Details'])[1]");

	public void clickTosViewDetails() {
		click(btnViewDetails, "View Details");
	}

	public void clickEdit() {
		click(btnEdit, "edit");
	}

	public void clickStartDate() throws InterruptedException {
		click(btnStartDate, "Start Date");
		Thread.sleep(2000);
		new DatePickerAndNextDayComponent().clickCustomDate();

	}

	public void clickEfftiveDate() throws InterruptedException {
		click(btnEffectiveDate, "Effitive Date");
		Thread.sleep(2000);
		new DatePickerAndNextDayComponent().generateDate();
	}

	public void clickSchedule() {
		if (getElement(btnschedule, "Schedule").isDisplayed()) {
			click(btnschedule, "Schedule");
		} else {
			ExtentTestManager.setFailMessageInReport("Schedule Button is Disable");
		}
	}

	public void enterVersion() throws InterruptedException {
		Thread.sleep(2000);
		clearText(txtVersion, "Clear previo");
		Thread.sleep(2000);
		enterText(txtVersion, GenerateRandomVersion(), "Version Number");
	}

	public void uploadDocument(String folderName, String fileName) {
		click(btnCancelIcon, "Cancel Icon");
		getElement(uploadDocument, "select Document").sendKeys(FileHelper.getFilePath(folderName, fileName));
	}

	public void enterSummery() throws InterruptedException {
		Thread.sleep(2000);
		clearText(txtChangeSummery, "ChangeSummery");
		Thread.sleep(2000);
		enterText(txtChangeSummery, generateStringValue(), "Summery");
	}

	public void clickSave() {
//		if (getElement(btnSave, "Save").isDisplayed()) {
		click(btnSave, "Save");
//		}
//		ExtentTestManager.setFailMessageInReport("Save Button is Disable");
	}

	public void clickBack() {
		click(btnBack, "Back Button");
	}

	public void clickMeterial() {
		click(rdMeterial, "Meterial");
	}

	public void clickNonMeterial() {
		click(rdNonMeterial, "Non Meterial");
	}

	public String generateStringValue() {
		String val = "Update value" + GenerateRandomVersion();
		return val;
	}

	public void verifyTosAgreement(String heading) {
		new CommonFunctions().verifyLabelText(lblTosAgreement, "Save TOS agreement", heading);
	}

	public void verifyTermsOfServiceLastUpdateDate() {
		String text = getText(lblLastUpdateOfTermsOfService, "");
		new CommonFunctions().elementView(lblLastUpdateOfTermsOfService, "Last Update Terms od Service is " + text);
	}

	public String verifyHeading() {
		String str = getText(heading, "Headind is");
		ExtentTestManager.setInfoMessageInReport("Heading is " + str);
		return str;
	}

	public void viewAgreement() {
		new CommonFunctions().elementView(lblAgreements, "Agreements");
	}

	public String verifyPrivacyPolicyHeading() {
		String str = getText(headingPrivacyPolicy, "Heading");
		ExtentTestManager.setInfoMessageInReport("Agreement heading is " + str);
		return str;
	}

	public String verifyTermsofServiceHeading() {
		String str = getText(headingTermsofService, "Heading");
		ExtentTestManager.setInfoMessageInReport("Agreement heading is " + str);
		return str;
	}

	public void clickPrivacyPolicy() {
		click(btnPrivacyPolicy, "Privacy Policy");
	}

	public void clickTermsofService() {
		click(btnTermsofServices, "Terms of Services");
	}

	private By lblTableHeading = By.xpath("//th[contains(@class, \"col-\")]");

	public void verifyTableHeading(String expHeading) {
		containsInList(lblTableHeading, "Agreement Heading List");
	}

	public String GenerateRandomVersion() {
		Random random = new Random();
		int nextInt = random.nextInt(1000);
		String numbers = "v1." + nextInt;
		return numbers;
	}

	public void containsInList(By listXpath, String data) {
		List<WebElement> elementsList = getElementsList(listXpath, "Agreement Heading");
		for (WebElement webElement : elementsList) {
			String text = webElement.getText();
			String[] split = data.split(",");
			int count = 0;
			for (int i = 0; i < split.length; i++) {
				if (text.equalsIgnoreCase(split[i])) {
					ExtentTestManager.setPassMessageInReport(text + " Agreement Haedings match");
					break;
				}

				else {
					count++;
					if (count == split.length) {
						ExtentTestManager.setWarningMessageInReport(text + " Agreement Haedings Not Found");
					}
				}
			}
		}
	}
}
