package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountTableComponent extends BrowserFunctions{
	
	private By lblWithdrawlist = By.xpath("//span[text()='Withdraw List']");
	private By lblDepoditlist = By.xpath("//span[text()='Deposits List']");
	private By drpdwn = By.xpath("//div[text()='Batch ID']//following::img");
	private By txtBatchId = By.cssSelector(".form-input-search.search-bar");
	private By btnSearch = By.cssSelector("//div[text()='Search']");
	
	
	private By getTabItemLoc(String elementName) {
		return By.xpath(String.format("//div[contains(@class,'tabs__tab') and text()='%s']", elementName));
	}
	public void clickBankAccount() {
		click(getTabItemLoc("Bank Accounts"), "Bank Accounts");
	}
	public void clickSignetAccount() {
		click(getTabItemLoc("Signet Accounts"), "Signet Accounts");
	}
	public void clickInstantPay() {
		click(getTabItemLoc("Instant Pay"), "Instant Pay");
	}
	public void clickGiftCard() {
		click(getTabItemLoc("Gift Cards"), "Gift Cards");
	}
	public void clickCreditAndDebitCard() {
		click(getTabItemLoc("Credit/Debit"), "Credit/Debit");
	}
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
	
}
