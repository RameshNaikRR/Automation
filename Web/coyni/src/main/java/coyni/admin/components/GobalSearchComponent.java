package coyni.admin.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class GobalSearchComponent extends BrowserFunctions {

	private By btnGobalSearch = By.cssSelector(".Input_form_input__3qrhS");
	private By btnProfileId = By.xpath("//label[text()='Profile ID:']");
	private By btnProfileDetails = By.xpath("//label[text()='Profile Details:']");
	private By btnReferenceId = By.xpath("//label[text()='Reference ID:']");
	private By btnlast4 = By.xpath("//label[text()='Last 4:']");
	private By btnFirst6 = By.xpath("//label[text()='First 6:']");
	private By btnBankAccountNumber = By.xpath("//label[text()='BankNumber:']");
	private By btnUnderWritingCaseID = By.xpath("//label[text()='Underwriting Case ID:']");
	private By lblId = By.cssSelector(".cell-col-0");
	private By lblNoTransaction = By.xpath("//div[text()='No Search Results Found']");

	public int getTransaction() {
		return getElementsList(lblNoTransaction, "").size();
	}

	public void fillProfileDetails() {
		click(btnProfileDetails, "Profile Details");

	}

	public String getAccountID() {
		String text = getText(lblId, "");
		return text;
	}

	public void clickGobalSearch() {
		click(btnGobalSearch, "Gobal Search");
	}

	public void fillProfileID(String profileID) {
		click(btnProfileId, "Profile ID");
		enterText(btnGobalSearch, profileID, "Profile ID");
	}

	private By btnSearch = By.cssSelector(".icon-search");

	public void clickSearch() {
		click(btnSearch, "");
	}

	public void fillReferenceID(String profileDetails) {
		click(btnReferenceId, "ReferenceID");
		enterText(btnGobalSearch, profileDetails, "ReferenceId");
	}

	public void fillLast4(String profileDetails) {
		click(btnlast4, "last4");
		enterText(btnGobalSearch, profileDetails, "last4");
	}

	public void fillFirst6(String profileDetails) {
		click(btnFirst6, "First6");
		enterText(btnGobalSearch, profileDetails, "First6");
	}

	public void fillBankAccount(String profileDetails) {
		click(btnBankAccountNumber, "BankAccountNumber");
		enterText(btnGobalSearch, profileDetails, "BankAccountNumber");
	}

	public void fillUnderWritingCaseID(String profileDetails) {
		click(btnUnderWritingCaseID, "UnderWritingCaseID");
		enterText(btnGobalSearch, profileDetails, "UnderWritingCaseID");
	}

	private By lblIndividuals = By.xpath("//label[text()='Individuals']");

	public void clickIndivisuals(String profileDetails) {
		click(lblIndividuals, "");
		enterText(btnGobalSearch, profileDetails, "profile Details");
	}

	private By lblEmail = By.className("cell-col-2");

	public String getEmail() {
		String text = getText(lblEmail, "");
		return text;
	}

	private By getReferenceId = By.className("cell-col-7");

	public String getReferenceID() {
		String text = getText(getReferenceId, "");
		return text;
	}

}
