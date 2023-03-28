package coyni.admin.components;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.admin.popups.InvitationPopup;
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
	private By lblTokenWalletHeading = By.xpath("//span[text()='TOKEN WALLET']");
	private By lblBuyToken = By.xpath("//span[text()='Buy Token']");
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

	public void verifyEcoSystemHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEcoSystem, "Ecosystem User Fees", expHeading);
	}

	public void verifyBusinessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBusinessHeading, "Heading is", expHeading);
	}
	
	public void verifyTokenWalletHeading(String expTokenWalletHeading) {
		new CommonFunctions().verifyLabelText(lblTokenWalletHeading, "Sub Heading is", expTokenWalletHeading);
	}

	public void verifyBuyTokenHeading(String expBuyTokenHeading) {
		new CommonFunctions().verifyLabelText(lblBuyToken, "Sub Heading is ", expBuyTokenHeading);
	}
	
	public By getElementDoller(String ele) {
		return By.xpath(String.format("((//*[text()='%s'])[1]/../..//input)[1]", ele));

	}
	
	public By getLimitsAmount(String ele) {
		return By.xpath(String.format("((//*[text()='%s'])[1]/../..//input)[2]", ele));
	}
	
	public By getLimitAmountForBuyTokens(String ele) {
		return By.xpath(String.format("((//*[text()='%s'])[2]/../..//input)[2]", ele));
	}
	
	public By getElementDollerForBuyToken(String ele) {
		return By.xpath(String.format("((//*[text()='%s'])[2]/../..//input)[1]", ele));

	}
	
	public By getElementPercentageForBuyToken(String ele) {
		return By.xpath(String.format("((//*[text()='%s'])[2]/../..//input)[2]", ele));

	}

	public By getElementPercentage(String ele) {
		return By.xpath(String.format("((//*[text()='%s'])[1]/../..//input)[2]", ele));

	}

	public void fillExternalAmountforBusinessFees(String amount) throws InterruptedException, AWTException {
	enterText(getElementDoller("External Bank Account"), amount, "External Bank Amount is");
		new CommonFunctions().clickTab();
	}
	
	public void fillExternalBanckAccountPercentageforBusinessFees(String percentage) throws AWTException {
		enterText(getElementPercentage("External Bank Account"), percentage, "External Banck Percentage");
		new CommonFunctions().clickTab(); 
	}
	
	public void fillInstantPayAmountforBusinessFees(String amount) throws AWTException {
		enterText(getElementDoller("Instant Pay"), amount, "Instant Pay Amount is");
		new CommonFunctions().clickTab();
	}
	
	public void fillInstantPayPercentageforBusinessFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Instant Pay"), percentage, "Instant Pay Percentage");
		new CommonFunctions().clickTab();
	}
	
	public void fillCogentAccountAmountforBusinessFees(String amount) throws AWTException {
		enterText(getElementDoller("Cogent Account"), amount, "Cogent Account is");
		new CommonFunctions().clickTab();
	}
	
	public void fillCogentAccountPercentageforBusinessFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Cogent Account"), percentage, "Cogent Account Percentage");
		new CommonFunctions().clickTab();
	}
	
	public void fillGiftCardforBusinessFees(String amount) throws AWTException {
		enterText(getElementDoller("Gift Card"), amount, "Gift Card Amount is");
		new CommonFunctions().clickTab();
	}
	
	public void fillFailedBankWithdrawAmountforBusinessFees(String amount) throws AWTException {
		enterText(getElementPercentage("Failed Bank Withdraw"), amount, "Failed Bank Withdraw amount is");
		new CommonFunctions().clickTab();
	}
	
	
	public void fillFailedBankWithdrawPercentageforBusinessFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Failed Bank Withdraw"), percentage, "Failed Bank Withdraw Percentage");
		new CommonFunctions().clickTab();
	}
	
	public void fillExternalAmountBuyTokenforBusinessFees(String amount) throws AWTException {
		enterText(getElementDollerForBuyToken("External Bank Account"), amount, "External Bank Amount for BuyTokens is");
		new CommonFunctions().clickTab();
	}

	public void fillExternalPercentageBuyTokenforBusinessFees(String percentage) throws AWTException {
		enterText(getElementPercentageForBuyToken("External Bank Account"), percentage, "External Bank Percentage for BuyTokens is");
		new CommonFunctions().clickTab();
	}
	
	public void fillMonthlyFeeforBusinessFees(String amount) throws AWTException {
		enterText(getElementDoller("Monthly Fee"), amount, "Monthly Fee is");
		new CommonFunctions().clickTab();
		
	}
	
	public void fillExternalAmountforEcoSystemFees(String amount) throws AWTException {
		enterText(getElementDoller("Bank Account"), amount, "External Bank Amount is");
		new CommonFunctions().clickTab();
	}
	
	public void fillExternalBanckAccountPercentageforEcoSystemFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Bank Account"), percentage, "External Banck Percentage");
		new CommonFunctions().clickTab();
	}
	
	public void fillInstantPayAmountforEcoSystemFees(String amount) throws AWTException {
		enterText(getElementDoller("Instant Pay"), amount, "Instant Pay Amount is");
		new CommonFunctions().clickTab();
	}
	
	public void fillInstantPayPercentageforEcoSystemFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Instant Pay"), percentage, "Instant Pay Percentage");
		new CommonFunctions().clickTab();
	}
	
	public void fillCogentAccountAmountforEcoSystemFees(String amount) throws AWTException {
		enterText(getElementDoller("Cogent Account"), amount, "Cogent Account is");
		new CommonFunctions().clickTab();
	}
	
	public void fillCogentAccountPercentageforEcoSystemFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Cogent Account"), percentage, "Cogent Account Percentage");
		new CommonFunctions().clickTab();
	}
	
	public void fillGiftCardAmountforEcoSystemFees(String amount) throws AWTException {
		enterText(getElementDoller("Gift Card"), amount, "Gift Card Amount is");
		new CommonFunctions().clickTab();
	}
	
	public void fillGiftCardPercentageforEcoSystemFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Gift Card"), percentage, "Gift Card percentage is");
		new CommonFunctions().clickTab();
	}
	
	public void fillFailedBankWithdrawAmountforEcoSystemFees(String amount) throws AWTException {
		enterText(getElementPercentage("Failed Bank Withdraw"), amount, "Failed Bank Withdraw amount is");
		new CommonFunctions().clickTab();
	}
	
	
	public void fillFailedBankWithdrawPercentageforEcoSystemFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Failed Bank Withdraw"), percentage, "Failed Bank Withdraw Percentage");
		new CommonFunctions().clickTab();
	}

	public void fillExternalAmountBuyTokenforEcoSystemFees(String amount) throws AWTException {
		enterText(getElementDollerForBuyToken("Bank Account"), amount, "External Bank Amount for BuyTokens is");
		new CommonFunctions().clickTab();
	}

	public void fillExternalPercentageBuyTokenforEcoSystemFees(String percentage) throws AWTException {
		enterText(getElementPercentageForBuyToken("Bank Account"), percentage, "External Bank Percentage for BuyTokens is");
		new CommonFunctions().clickTab();
	}
	
	public void fillDebitCardAmountBuyTokenforEcoSystemFeess(String amount) throws AWTException {
		enterText(getElementDoller("Debit Card"), amount, "Debit Card Amount is");
		new CommonFunctions().clickTab();
	}
	
	public void fillDebitCardAmountPercentageBuyTokenforEcoSystemFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Debit Card"), percentage, "Debit Card Percentage");
		new CommonFunctions().clickTab();
	}
	
	public void fillCreditCardAmountBuyTokenforEcoSystemFeess(String amount) throws AWTException {
		enterText(getElementDoller("Credit Card"), amount, "Debit Card Amount is");
		new CommonFunctions().clickTab();
	}
	
	public void fillCreditCardAmountPercentageBuyTokenforEcoSystemFees(String percentage) throws AWTException {
		enterText(getElementPercentage("Credit Card"), percentage, "Debit Card Percentage");
		new CommonFunctions().clickTab();
	}
	
	public void fillExternalBankLimitforBusinessFees(String limitAmount) throws AWTException {
		enterText(getElementDoller("External Bank Account"), limitAmount, limitAmount);
		new CommonFunctions().clickTab();
		enterText(getLimitsAmount("External Bank Account"), limitAmount, "Bank Account limits is");
		
	}
	
	public void fillInstantPayLimitforBusinessFees(String limitAmount) throws AWTException {
		enterText(getElementDoller("Instant Pay"), limitAmount, limitAmount);
		new CommonFunctions().clickTab();
		enterText(getLimitsAmount("Instant Pay"), limitAmount, "Instant Pay limits is");
		
	}

	public void fillgiftCardLimitforBusinessFees(String limitAmount) throws AWTException {
		enterText(getElementDoller("Gift Card"), limitAmount, limitAmount);  
		new CommonFunctions().clickTab();
		enterText(getLimitsAmount("Gift Card"), limitAmount, "Gift Card limits is");
	}
	
	public void fillCogentLimitforBusinessFees(String limitAmount) throws AWTException {
		
		enterText(getElementDoller("Cogent"), limitAmount, limitAmount);
		new CommonFunctions().clickTab();
		enterText(getLimitsAmount("Cogent"), limitAmount, "Cogent limits is");
	}
	
	public void fillExternalBankLimitBuyTokensforBusinessFees(String limitAmount) throws AWTException {
		enterText(getElementDollerForBuyToken("External Bank Account"), limitAmount, limitAmount);
		new CommonFunctions().clickTab();
		enterText(getLimitAmountForBuyTokens("External Bank Account"), limitAmount, "Bank Amount Limit is");
	}
	
	public void fillExternalBankLimitforEcoSystemFees(String limitAmount) throws AWTException {
		enterText(getElementDoller("External Bank Account"), limitAmount, limitAmount);
		new CommonFunctions().clickTab();
		enterText(getLimitsAmount("External Bank Account"), limitAmount, "Bank Account limits is");
	}
	
	public void fillInstantPayLimitforEcoSystemFees(String limitAmount) throws AWTException {
		enterText(getElementDoller("Instant Pay"), limitAmount, limitAmount);
		new CommonFunctions().clickTab();
		enterText(getLimitsAmount("Instant Pay"), limitAmount, "Instant Pay limits is");
	}

	public void fillgiftCardLimitforEcoSystemFees(String limitAmount) throws AWTException {
		enterText(getElementDoller("Gift Card"), limitAmount, limitAmount);
		new CommonFunctions().clickTab();
		enterText(getLimitsAmount("Gift Card"), limitAmount, "Gift Card limits is");
	}
	
	public void fillExternalBankLimitBuyTokensforEcoSystemFees(String limitAmount) throws AWTException {
		enterText(getElementDollerForBuyToken("External Bank Account"), limitAmount, limitAmount);
		new CommonFunctions().clickTab();
		enterText(getLimitAmountForBuyTokens("External Bank Account"), limitAmount, "Bank Amount Limit is");
		
	}
	
	public void fillDebitAndCreditCardLimitBuyTokensforEcoSystemFees(String limitAmount) throws AWTException {
		enterText(getElementDollerForBuyToken("Debit / Credit Card"), limitAmount, limitAmount);
		new CommonFunctions().clickTab();
		enterText(getLimitAmountForBuyTokens("Debit / Credit Card"), limitAmount, "Bank Amount Limit is");
		
	}
	
	
	public void fillBuySignetPercentage(String amount) {
		enterText(getElementPercentage("Cogent Account"), amount, "Cogent Account");
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
	
	public InvitationPopup invitationPopup() {
		return new InvitationPopup();
	}
	
	
	
	
	
	
	
	
	
}
