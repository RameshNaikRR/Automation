package coyni.admin.components;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import coyni.admin.popups.ActionsPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AccountTableComponent extends BrowserFunctions {

	private By lblWithdrawlist = By.xpath("//span[text()='Withdraw List']");
	private By lblDepoditlist = By.xpath("//span[text()='Deposits List']");
	private By drpdwn = By.xpath("//div[text()='Batch ID']//following::img");
	private By txtBatchId = By.cssSelector(".form-input-search.search-bar");
	private By btnSearch = By.xpath("//div[text()='Search']");
	private By lnkUser = By.cssSelector("tbody>tr:nth-of-type(2)>td:nth-of-type(1)");
	private By lblEnter8CharId = By.xpath("//input[@placeholder='Enter 8 Characters ID']");
	private By drpdwnBatchidimg = By.xpath("//img[@src='/static/media/arrow-right.3014e1fb88e2fed86fbb76e783121d86.svg']");
	private By drpdwnBatchId = By.xpath(
			"//div[@class='flex items-center justify-between pr-3 cursor-pointer hover:text-cm3 text-xs text-cm4 font-semibold']");
	private By drpdwnDepositId = By.xpath("//div[text()='Deposit ID']");
	private By drpdwnReferenceId = By.xpath(
			"//div[@class='flex items-center justify-between pr-3 cursor-pointer hover:text-cm3 text-xs text-cm4 font-semibold']");
	private By lblTableHeadings = By.cssSelector("thead>tr>th");
	private By lblCreditDebitBatchIdDetail = By.xpath("//p[text()='Credit/Debit Batch Detail']");
	private By lblTotalBatchAmount = By.xpath("//span[text()='Total Batch Amount']");
	private By drpdwnId = By.cssSelector("div[class*='selected_option']");
	private By lblFirstRowElements = By.cssSelector("tbody>tr:nth-of-type(2)>td");
	private By lnkFirstElement = By.cssSelector("tbody>tr:nth-of-type(2)>td:nth-of-type(1)");
	private By lblBatchDetails = By.xpath("//p[@class='breadcrumb--current']");
	private By btnAction = By.cssSelector("tbody>tr:nth-of-type(2)>td:nth-of-type(6)>div>div>div");

	public void clickDropDownId() {
		click(drpdwnId, "drop down");
	}

	private By getDropDownElements(String dropDownElementName) {
		return By.xpath(String.format("//div[contains(@class,'Select')]/div[text()='%s']", "Id"));
	}

	public void clickdrpdwnBatchId() {
		click(getDropDownElements("Batch ID"), "Batch Id");
	}

	public void clickdrpdwnDepositId() {
		click(getDropDownElements("Deposit ID"), "deposit ID");
	}

	public void clickdrpdwnRefferenceId() {
		click(getDropDownElements("Refference ID"), "Refference Id");
	}

	public void getRowElements(String columns) {
		String[] column = columns.split(",");
		List<WebElement> list = getElementsList(lblFirstRowElements, " ");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String label = list.get(i).getText();
			ExtentTestManager.setInfoMessageInReport(column[i] + ": " + label);
		}
	}

	private By lblNoRecord = By.xpath("//span[text()='No Records Found']");

	public int getNoRecSize() {
		return getElementsList(lblNoRecord, "").size();
	}

	public void verifyLabelHeading(String labelHeading) {
		new CommonFunctions().verifyLabelText(lblBatchDetails, "label heading", labelHeading);

	}

	public void clickFirstElement() {
		click(lnkFirstElement, "First Element");
	}

	public void verifyTableLabels(String labels) {
		String[] list = labels.split(",");

		List<WebElement> elements = getElementsList(lblTableHeadings, "");
		int size = elements.size();
		for (int i = 0; i < 5; i++) {
			String label = elements.get(i).getText();
			if (label.equals(list[i])) {
				ExtentTestManager.setPassMessageInReport(list[i] + " column is displayed in Table ");
			} else {
				ExtentTestManager.setFailMessageInReport(list[i] + " column is not displayed in Table ");
			}
		}
	}

	public void verifyCreditDebitBatchIdDetailView() {
		new CommonFunctions().elementView(lblCreditDebitBatchIdDetail, "CreditDebitBatchIdDetail");
	}

	public void clickUser() {
		click(lnkUser, "User");
	}

	private By getTabItemLoc(String elementName) {
		return By.xpath(String.format("//button[ text()='%s']", elementName));
	}

	public void clickBankAccount() {
		click(getTabItemLoc("Bank Accounts"), "Bank Accounts");
	}

	public void clickCogentAccount() {
		click(getTabItemLoc("Cogent Accounts"), "Cogent Accounts");
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
		new CommonFunctions().verifyLabelText(lblDepoditlist, "Deposit List", expHeading);
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

	public void verifyEnter8charIdView() { // String expBatchID

		// enterText(lblEnter8CharId, "BatchID", expBatchID);
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

	public By getTableColumns(String Type) {
		return By.xpath(
				String.format("//tr[@class=\" rounded-none\"]/th[contains(@class,'col')]/span[text()='%s']", Type));

	}

	public void verifyColumnView() {
		new CommonFunctions().elementView(getTableColumns("Date"), "Date");
		new CommonFunctions().elementView(getTableColumns("Batch Id"), "Batch Id");
		new CommonFunctions().elementView(getTableColumns("Total Batch Amt"), "Tatal batch");
		new CommonFunctions().elementView(getTableColumns("Total Count"), "Total Count");
		new CommonFunctions().elementView(getTableColumns("In Progress"), "in Progress");
		new CommonFunctions().elementView(getTableColumns("Paid"), "paid");
		new CommonFunctions().elementView(getTableColumns("Failed"), "Failed");
		// new CommonFunctions().elementView(getTableColumns("Pending"), "Pending");
		new CommonFunctions().elementView(getTableColumns("Status"), "Status");
	}

	private By clkDetails = By.cssSelector(".amount-label-deposity");

	public void clickDetails() {
		click(clkDetails, "Details");
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

	public ActionsPopup actionsPopup() {
		return new ActionsPopup();

	}

	public void clickAction() {
		click(btnAction, "Action");
	}

	private By lblText = By.xpath("//span[text()='It seems we can’t find any results based on your search.']");

	public int getSize() {
		return getElementsList(lblText, "").size();
	}
}
