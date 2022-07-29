package coyni.admin.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CreateNewApiBusinessUser extends BrowserFunctions {

	private By btnNewApiBusiness = By.xpath("//div[text()='New API Business']");
	private By lblHeadingApiInvitation = By.xpath("//span[text()='API Invitation']");
	private By lblHeadingApi = By.xpath("//h1[text()='API Business Contact Information']");
	private By txtFirstName = By.id("first_Name");
	private By txtLastName = By.id("last_Name");
	private By txtEmail = By.id("Email");
	private By txtPhoneNumber = By.id("Phone_Number");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By btnCancel = By.xpath("//button[text()='Cancel']");
	private By lblBusinessHeading = By.xpath("//h1[text()='Business Fees']");
	private By lblEcoSystem = By.xpath("//h1[text()='Ecosystem User Fees']");
	private By lblBusinessLimit = By.xpath("//h1[text()='Business Account Limits']");
	private By lblEcoSystemLimit =By.xpath("//h1[text()='Ecosystem User Account Limits']");
	private By btnSend = By.xpath("//button[text()='Send']");
	public void verifyEcosystemLimit(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEcoSystemLimit, "Ecosystem User Account Limits", expHeading);
	}
	
	public void clickSend() {
		click(btnSend, "send");
	}

	public void verifyBusinessAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBusinessLimit, "Business Account Limits", expHeading);
	}

	public void verifyEcoSystem(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEcoSystem, "Ecosystem User Fees", expHeading);
	}

	public void verifyBusinessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBusinessHeading, "Business Fees", expHeading);
	}

	public By getElementDoller(String ele) {
		return By.xpath(String.format("((//*[text()='%s'])[1]/../..//input)[1]", ele));

	}

	public By getElementPercentage(String ele) {
		return By.xpath(String.format("((//*[text()='%s'])[2]/../..//input)[2]", ele));

	}

	public void fillExternalDoller(String exp) {
		enterText(getElementDoller("External Bank Account"), exp, "Amount in Doller");
	}

	public void fillBuySignetPercentage(String amount) {
		enterText(getElementPercentage("Signet Account"), amount, "Signet Account");
	}

	public void clickNewApiBusiness() {
		click(btnNewApiBusiness, "Api Business");
	}

	public void verifyApiInvitation(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeadingApiInvitation, "API Invitation", expHeading);
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeadingApi, "API Business Contact Information", expHeading);
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
	}

	public void fillLastName(String lasttName) {
		enterText(txtLastName, lasttName, "lastt Name");
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "email");
	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtPhoneNumber, phoneNumber, "phoneNumber");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setInfoMessageInReport("Next Button is disable");
		}
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}
	
	private By getLblElement(String text) {
		return By.xpath(String.format("//span[text()='%s']", text));
	}
	private By name = By.xpath("//span[contains(@class,'w-40 ml-2 font-semibold')]");
//	private By nameValue = By.xpath("//span[contains(@class,'w-40 ml-2 font-semibold')]/../following-sibling::div");
//	public void fff() {
//		List<WebElement> elementsList = getElementsList(name, "");
//		List<WebElement> elementsList2 = getElementsList(nameValue, "");
//		for (WebElement webElement : elementsList) {
//			String text = webElement.getText();
//			ExtentTestManager.setInfoMessageInReport(text);
//			for (WebElement webElement2 : elementsList2) {
//				String text2 = webElement2.getText();
//				ExtentTestManager.setInfoMessageInReport(text+" "+"Value is "+" "+ text2);
//			}
//		}
//	}
	public void ffsf() {
		List<WebElement> elementsList = getElementsList(name, "");
		for (WebElement webElement : elementsList) {
			String text = webElement.getText();
			String value = getText(By.xpath(String.format("(//span[.='%s']/../following-sibling::div)[1]", text)), "");
			ExtentTestManager.setInfoMessageInReport(text+" Value is "+value);
		}
	}
	
	public void clickXDashboard() {
		click(getLblElement("Dashboard"), "Dashboard");
	}

	public void clickTokenWallet() {
		click(getLblElement("TokenWallet(s)"), "TokenWallet(s)");
	}

	public void clickCompanyInformation() {
		click(getLblElement("Company Information"), "Company Information");
	}

	public void clickDBA() {
		click(getLblElement("DBA Information"), "DBA Information");
	}

	public void clickOwners() {
		click(getLblElement("Beneficial Owner(s)"), "Beneficial Owner(s)");
	}

	public void clickUsers() {
		click(getLblElement("Platform Users"), "Platform Users");
	}

	public void clickAccountLimits() {
		click(getLblElement("Account Limits"), "Account Limits");
	}

	public void clickAccountFee() {
		click(getLblElement("Account Fees"), "Account Fees");
	}

	public void clickIpAddress() {
		click(getLblElement("IP Addresses"), "IP Addresses");
	}

	public void clickAgreements() {
		click(getLblElement("Agreements"), "Agreements");
	}

	public void clickAPIKeys() {
		click(getLblElement("API Keys"), "API Keys");
	}

	public void clickWebhooks() {
		click(getLblElement("Webhooks"), "Webhooks");
	}
	
	
	
	
	
	
	
	
	
	
	
}
