package coyni.api.business.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class WithdrawToBankAccountPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Withdraw to Bank Account']");
	private By lblchAccount = By.xpath("//h2[text()='Choose Your Payment Method:");
	private By rdbtnBankAccount = By.id("//input[@id='radio-BANK-128']");
	private By rdbtnBankAccount1 = By.id("//input[@id='radio-BANK-110']");
	private By lnkBnkAccount = By.xpath("");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By txtAmount = By.xpath("//input[@name='amount']");
	private By txtDescription = By.xpath("//textarea[@id='message']");
	private By wtdBankAmount = By.xpath("//div[@class='flex items-center justify-between py-1']");

	private By btnConfrim = By.xpath("//button[text()='Confirm']");

	private By lnkAddNewBankAccount = By.xpath("//span[text()='Add New Bank Account']");
	private By BankAccounts = By.xpath(" //div[@class='flex flex-col items-center justify-center mt-9']//p");

//	public void veriyHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
//	}
	public void verifyOrderPreviewForWithdraw() {
		List<WebElement> rows = getElementsList(wtdBankAmount, "Order Preview");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void clickConfrim() {
		click(btnConfrim, "confrim");
	}

	public void verifyWithdrawToBankAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "heading", expHeading);
	}

	public void verifychooseAccount(String subHeading) {
		new CommonFunctions().verifyLabelText(lblchAccount, "Choose Account", subHeading);
	}

	public void verifyBankAccount(String BankAccount) {
		new CommonFunctions().verifyLabelText(rdbtnBankAccount, "Bank Account Name", BankAccount);
	}

	public void verifyBankAccount1(String BankAccount1) {
		new CommonFunctions().verifyLabelText(rdbtnBankAccount1, "Bank Account", BankAccount1);
	}

	public void clickAddNewBankAccount() {
		click(lnkAddNewBankAccount, "Add New BankAccount");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}

	public void selectBankAccount() {
		BrowserFunctions objBrowserFunctions = new BrowserFunctions();
		objBrowserFunctions.waitForElement(BankAccounts, BrowserFunctions.waittime, WaitForElement.presence);
		List<WebElement> optionsEles = objBrowserFunctions.getElementsList(BankAccounts, "BankAccounts");
		for (WebElement optionEle : optionsEles) {
			if (optionEle.getText().contains("CashEdge Test Bank")) {
				optionEle.click();
				break;
			}
		}
	}

	public void selectSignetAccount() {
		BrowserFunctions objBrowserFunctions = new BrowserFunctions();
		objBrowserFunctions.waitForElement(BankAccounts, BrowserFunctions.waittime, WaitForElement.presence);
		List<WebElement> optionsEles = objBrowserFunctions.getElementsList(BankAccounts, "BankAccounts");
		for (WebElement optionEle : optionsEles) {
			if (!optionEle.getText().contains("CashEdge Test Bank")) {
				optionEle.click();
				break;
			}
		}
	}

	public void verifyDescription(String description) {
		new CommonFunctions().verifyLabelText(txtDescription, "Transaction Description", description);
	}

	public void verifyTotal(String total) {
		new CommonFunctions().verifyLabelText(txtAmount, "Total", total);
	}

	public void clickOutside() {
		new CommonFunctions().clickOutSideElement();
	}

}