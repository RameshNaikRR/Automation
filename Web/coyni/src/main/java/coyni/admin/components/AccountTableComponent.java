package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountTableComponent extends BrowserFunctions{
	
	private By lblWithdrawlist = By.cssSelector("");
	private By lblDepoditlist = By.cssSelector("");
	private By drpdwn = By.cssSelector("");
	private By txtBatchId = By.cssSelector("");
	private By btnSearch = By.cssSelector("");
	private By tabBankAccount = By.cssSelector("");
	private By tabSignetAccount  = By.cssSelector("");
	private By tabInstantPay = By.cssSelector("");
	private By tabGiftCard = By.cssSelector("");
	private By tabCreditAndDebitCard = By.cssSelector("");
	
	public void verifyWithdrawView(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawlist, "Withdraw List", expHeading);
	}
	public void verifyDepositView(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDepoditlist, "Deposit List",expHeading);
	}
	public void selectBatchIdDropDown(String batchId) {
		new CommonFunctions().verifyLabelText(drpdwn, "Batch Id", batchId);
	}
	public void fillBatchId(String batchId) {
		enterText(txtBatchId, batchId, "Batch ID");
	}
	public void clickSearch() {
		click(btnSearch, "Search");
	}
	public void clickBankAccount() {
		click(tabBankAccount, "Bank Accounts");
	}
	public void clickSignetAccount() {
		click(tabSignetAccount, "Signet Accounts");
	}
	public void clickInstantPay() {
		click(tabInstantPay, "Instant Pay");
	}
	public void clickGiftCard() {
		click(tabGiftCard, "Gift Cards");
	}
	public void clickCreditAndDebitCard() {
		click(tabCreditAndDebitCard, "Credit/Debit");
	}

}
