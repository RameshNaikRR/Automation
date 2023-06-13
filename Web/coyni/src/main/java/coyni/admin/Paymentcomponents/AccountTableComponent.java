package coyni.admin.Paymentcomponents;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.admin.Paymentspopups.ActionsPopup;
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
	private By drpdwnBatchidimg = By
			.xpath("//img[@src='/static/media/arrow-right.3014e1fb88e2fed86fbb76e783121d86.svg']");
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
	private By drpDown = By.xpath("//div[contains(text(),'Entries Per Page')]/parent::div");

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

	private By lblNoFilterRecord = By.xpath("//span[text()='No Records Found']");

	public int getNoFilterRecSize() {
		return getElementsList(lblNoFilterRecord, "No Record Found").size();
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

	private By lblNoTransaction = By.xpath("//span[text()='No Transactions Found']");

	public int notransactionFound() {

		return getElementsList(lblNoTransaction, "No Transaction ").size();

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

	public void clickEntriesOptions(String entriesOption) {
		By entries = By
				.xpath(String.format("//div[contains(@class,'menu-list')]//div[contains(text(),'%s')]", entriesOption));
		click(entries, entriesOption + "selected");
	}

	public class Entries {
		private By dropdownItemsPerPage = By.cssSelector(".entries-container .custom-pagination-select__single-value");
		private By dropdownOptions = By.cssSelector(".entries-container .custom-pagination-select>div");
		private By lblItemsPerPage = By.cssSelector(".entries-container .entries-message");

		public List<String> getEntryOptions() {

			return getElementsList(dropdownOptions, "options").stream().map(WebElement::getText)
					.collect(Collectors.toList());
		}

		public void clickDropDownItemsPerPage() {
			click(dropdownItemsPerPage, "Show Drop Down");
		}

		public void selectItemsPerPage(String num) {
			commonFunctions.selectCustomDropDown(num, "Items Per Page");
		}

		public String getItemsPerPage() {
			return getText(lblItemsPerPage, "entries per page");
		}
//		public void click25Entries() {
//			click
//		}
//		public void click50Entries() {
//			click(getEntries("50 Entries Per Page"), "50 Entries Per Page");
//		}
//		public void click75Entries() {
//			click(getEntries("75 Entries Per Page"), "75 Entries Per Page");
//		}
//		public void click100Entries() {
//			click(getEntries("100 Entries Per Page"), "100 Entries Per Page");
//		}

	}

	public Entries entries() {
		return new Entries();
	}

	public class Paginator {

		private By prevPage = By.xpath("//a[contains(@aria-label, 'Previous') or text() = '«']");
		private By nextPage = By.xpath("//a[contains(@aria-label, 'Next') or text() = '»']");

		public void clickGoToPreviousPage() {
			click(prevPage, "previou page '«'");
		}

		public void clickGoToNextPage() {
			click(nextPage, "next page '»'");
		}

		public boolean isNextButtonEnabled() {
			System.out.println(getElementsList(nextPage, "next page").size());
			if (getElementsList(nextPage, "next '»'").size() > 0) {
				return getElement(nextPage, "next '»'").isEnabled();
			} else {
				return false;
			}
		}

		public boolean isNextButtonAvailable() {
			System.out.println(getElementsList(nextPage, "next '»'").size());
			return getElementsList(nextPage, "next '»'").size() > 0;
		}
	}

	private CommonFunctions commonFunctions;
	private By tableRows = By.cssSelector(".custom-table-wrapper>tbody>tr");

	public Paginator paginator() {
		return new Paginator();
	}

	public void clickOnAction(String id, String action) {
		boolean isCustFound = false;
		while (!isCustFound && paginator().isNextButtonAvailable()) {
			List<WebElement> rows = getElementsList(tableRows, "table rows");
			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				String cid = cells.get(0).getText();
				if (cid.equalsIgnoreCase(id)) {
					isCustFound = true;
					if (action.equalsIgnoreCase("Pending")) {
						WebElement viewEle = cells.get(cells.size() - 1)
								.findElement(By.xpath("(//div[@class='chip__text--orange '][text()='Pending'])[1]"));
			//			commonFunctions.moveToElementAndClick(viewEle, "View Icon of " + cid);
//					} else if (action.equalsIgnoreCase("Paid")) {
//						WebElement editEle = cells.get(cells.size() - 1)
//								.findElement(By.cssSelector(".icon-pencil"));
//						commonFunctions.moveToElementAndClick(editEle, "Edit Icon of " + cid);
//					} else if (action.equalsIgnoreCase("In Progress")) {
//						WebElement cancelEle = cells.get(cells.size() - 1)
//								.findElement(By.cssSelector(".icon-cancel"));
//						commonFunctions.moveToElementAndClick(cancelEle, "Cancel Icon of " + cid);
					}
					break;
				}
			}
			if (!isCustFound) {
				paginator().clickGoToNextPage();
			//	commonFunctions.waitUntilLoadingCompletes();
			}
		}
		if (!isCustFound) {
			ExtentTestManager.setInfoMessageInReport(
					"Customer Account Limits ID : " + id + " not found in Customer Profiles table");
		}

	}

	public void verifyPaginations() throws InterruptedException {
		int expStart = 25;
		int expEnd = Integer.parseInt(this.entries().getItemsPerPage().split(" ")[3]);
		int page = 1;
		int total = Integer.parseInt(this.entries().getItemsPerPage().split(" ")[3]);
		while (true) {
			int start = Integer.parseInt(this.entries().getItemsPerPage().split(" ")[1]);
			int end = Integer.parseInt(this.entries().getItemsPerPage().split(" ")[3]);
			if (start == expStart && end == expEnd) {
				ExtentTestManager.setPassMessageInReport(
						String.format("Page %d contains items from %d to %d", page, start, end));
			} else {
				ExtentTestManager.setFailMessageInReport(
						String.format("Page %d should contain items from %d to %d but contains items from %d to %d",
								page, expStart, expEnd, start, end));
			}
			expStart += 25;
			expEnd += 25;
			if (expEnd > total) {
				expEnd = total;
			}
			if (expStart > total) {
				break;
			}
			page++;
			if (!this.paginator().isNextButtonEnabled()) {
				break;
			}
			this.paginator().clickGoToNextPage();
			Thread.sleep(1000);
		}
	}

	public void clickUpArrow(String columnName) {
		By btnUpArrow = By
				.xpath(String.format("//span[text()='%s']//div[contains(@class, 'sorting-arrow-up')]", columnName));
		click(btnUpArrow, columnName + " Up Arrow Button");
	}

	public void clickDownArrow(String columnName) {
		By btnUpArrow = By
				.xpath(String.format("//span[text()='%s']//div[contains(@class, 'sorting-arrow-down')]", columnName));
		click(btnUpArrow, columnName + " Down Arrow Button");
	}

	/**
	 * index 1 based
	 */
	public List<String> getColumnData(int columnNum) {
		List<String> data = getElementsList(
				By.cssSelector(String.format(".custom-table-wrapper>tbody>tr>td:nth-child(%d)", columnNum)),
				"Column " + columnNum + " values").stream().map(WebElement::getText).filter(text -> !text.equals(""))
						.collect(Collectors.toList());
		if (data.isEmpty()) {
			ExtentTestManager.setFailMessageInReport("There is no data in the column");
		}
		return data;
	}

	public By getElement(String entries) {
		return By.xpath(String.format("//div[contains(text(),'%s')]/parent::div", entries));
	}

	public void selectDropDownEntries(String entries) throws InterruptedException {
		click(drpDown, "Entries DropDown");
		click(getElement(entries), entries);
	}

//	public void verifyTableItemsCount(int expCount) {
//		int actCount = Integer.parseInt(this.entries().getItemsPerPage().split(" ")[1]);
//		int maxEntries = Integer.parseInt(this.entries().getItemsPerPage().split(" ")[3]);
//		if (expCount > maxEntries) {
//			expCount = maxEntries;
//		}
//		if (actCount == expCount) {
//			ExtentTestManager.setPassMessageInReport("Number of rows in transactions table matches with number of entries selected i.e " + actCount);
//		} else {
//           ExtentTestManager.setFailMessageInReport(String.format("Number of rows in transactions table = %d and entries selected in show drop down = %d ", expCount, actCount));
//		}
//		
//	}
	private By rows = By.cssSelector(".custom-table-wrapper>tbody>tr");
	private By drpdwnSelect = By.xpath("//div[contains(@class,'custom-pagination-select__indicator')]/div");

	public void verifyTableItemsCount() {
		int actCount = Integer.parseInt(this.entries().getItemsPerPage().split(" ")[3]);
		int rowInTable = getElementsList(rows, "Table Rows").size();
		if (actCount == rowInTable) {
			ExtentTestManager.setPassMessageInReport(
					"Number of rows in transactions table matches with number of entries selected i.e " + actCount);
		} else {
			ExtentTestManager.setFailMessageInReport(String.format(
					"Number of rows in transactions table = %s and entries selected in show drop down = %s", rowInTable,
					actCount));
		}
	}

	public void clickDropDownEntries() {
		click(drpdwnSelect, "Drop Down Clicked");
	}

}
