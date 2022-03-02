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
	private By lnkUser = By.cssSelector("tbody>tr:nth-of-type(2)>td:nth-of-type(1)");
	private By lblEnter8CharId = By.xpath("//input[@placeholder='Enter 8 Characters ID']");
	private By drpdwnBatchidimg = By.xpath("//img[@src='/static/media/arrow-right.3014e1fb.svg']");
	private By drpdwnBatchId = By.xpath("//div[@class='flex items-center justify-between pr-3 cursor-pointer hover:text-cm3 text-xs text-cm4 font-semibold']");
	private By drpdwnDepositId = By.xpath("//div[text()='Deposit ID']");
	private By drpdwnReferenceId = By.xpath("//div[@class='flex items-center justify-between pr-3 cursor-pointer hover:text-cm3 text-xs text-cm4 font-semibold']");
	//axcd
	public void clickUser() {
		click(lnkUser, "User");
	}
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
	public void clickdrpdwmBatchIdImg() {
		click(drpdwnBatchidimg, "dropdown BatchId");
	}
	public void verifydrpdwnBatchIdView() {
		new CommonFunctions().elementView(drpdwnBatchId, "Batch Id");
	}
	public void verifydrpdwnDepositIdView() {
		new CommonFunctions().elementView(drpdwnDepositId, "Deposit Id");
	}
	public void verifydrpdwnReferenceIdView() {
		new CommonFunctions().elementView(drpdwnReferenceId, "Reference Id");
	}
	public void verifyEnter8charIdView(){
		new CommonFunctions().elementView(lblEnter8CharId, "Enter8CharId");
	}
	public void verifyBankAccountView() {
		new CommonFunctions().elementView(getTabItemLoc("Bank Accounts"), "Bank Accounts");
	}
   public void verifyButtonSearchView() {
	   new CommonFunctions().elementView(btnSearch, "Search");
   }
   public void verifySignetAccountView() {
	   new CommonFunctions().elementView(getTabItemLoc("Signet Accounts"), "Signet Account");
   }
   public void clickdrpdwnBatchId() {
	   click(drpdwnBatchId, "Batch Id");
   }
   public void clickdrpdwnDepositId() {
	   click(drpdwnDepositId, "deposit Id");
   }
   public void clickdrpdwnRefferenceId() {
	   click(drpdwnReferenceId, "Refference Id");
   }
   public void verifyCreditandDebitCardView() {
	   new CommonFunctions().elementView(getTabItemLoc("Credit/Debit"), "Credit/Debit");
   }
	public BatchIDComponent batchIDComponent() {
		return new BatchIDComponent();
	}
	public ProfileSideBarComponent profileSideBarComponent() {
		return new ProfileSideBarComponent();
	}
	public FilterComponent filterComponent() {
		return new FilterComponent();
	}
	public ProfileComponent profileComponent() {
		return new ProfileComponent();
	}
	
}
