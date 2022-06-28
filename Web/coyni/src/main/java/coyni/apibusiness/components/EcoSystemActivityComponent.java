package coyni.apibusiness.components;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class EcoSystemActivityComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("");
	private By txtActivityDashboard = By.xpath("");
	private By transactionType = By.xpath("");
	private By transCount = By.xpath("");
	private By volume = By.xpath("");
	private By slectDropDownWallets = By.xpath("");
	private By slectDropDownDeposits = By.xpath("");
	private By dateRangeDropDown = By.xpath("");
	private By lnkViewTransHistory = By.xpath("//p[text()='View Full Transaction History']");
	private By lblDateTime = By.xpath("//span[text()='Date & Time']");
	private By lblType = By.xpath("//span[text()='Type']");
	private By lblSubType = By.xpath("//span[text()='SUB TYPE']");
	private By lblDescription = By.xpath("//span[text()='Description']");
	private By lblAmount = By.xpath("//span[text()='Amount']");
	private By lblBalance = By.xpath("//span[text()='Balance']");
	private By lblStatus = By.xpath("//span[text()='Status']");
	private By lblPostedTransactions = By.xpath("//div[@class='posted-txn']");
	private By lblYourTransactions = By.xpath("//h2[contains(text(),'Your Transactions')]");
	// private By transaction = By.xpath("(//tr[@class=' hovered'])[1]");
	private By lblItemsPerPage = By.cssSelector(".entries-container .entries-message");
//	private By rows = By.cssSelector(".custom-table-wrapper>tbody>tr");
	private By transaction = By.xpath("//tr[@class='  hovered']");
	private By lblBracesCount = By.cssSelector(".posted-txn .posted");
	private By defaultEntries = By
			.xpath("//div[@class='custom-pagination-select__single-value css-1uccc91-singleValue']");
	private By lblEntriesMessage = By.xpath("//span[contains(@class,'entries-message')]");
	private By pagination = By.xpath("//li[@class='paginator__pagination__item active']");
	private By entriesPerPageDropDown = By.xpath(
			"//div[@class='custom-pagination-select__indicator custom-pagination-select__dropdown-indicator css-tlfecz-indicatorContainer']");
	private By lblApiCallHistory = By.xpath("//h1[text()= 'API Call History']");
	private By lblMethod = By.xpath("//span[text()='METHOD']");
	private By lblIpAddress = By.xpath("//span[text()='IP ADDRESS']");
	private By lblUserName = By.xpath("//span[text()='USERNAME']");

	public String getBracesCount() {
		String str = getText(lblBracesCount, "braces Count");
		return str;

	}

	private By firstPage = By.xpath("//a[contains(@aria-label, 'first page') or text() = '«']");

	private By seconPage = By.xpath("//a[@aria-label='Go to page number 2']");

	private By prevPage = By.xpath("//a[contains(@aria-label, 'previous page') or text() = '❮']");

	private By nextPage = By.xpath("//a[contains(@aria-label, 'next page') or text() = '❯']");

	private By lastPage = By.xpath("//a[contains(@aria-label, 'last page') and text() = '»']");

	public void clickGoToFirstPage() {
		click(firstPage, "first page '«'");
	}

	public void clickGoToPreviousPage() {
		click(prevPage, "previous page '❮'");
	}

	public void clickGoToNextPage() {
		click(nextPage, "next page '❯'");
	}

	public void clickGoToLastPage() {
		click(lastPage, "last page '»'");
	}

	public boolean isNextButtonEnabled() {
		return getElement(nextPage, "next page '❯'").isEnabled();
	}

	public String getAvailableBalance() {
		return getText(lblAmount, "Available Balance");

	}

	public void verifyAmount() {
		new CommonFunctions().elementView(lblAmount, "Amount");
	}

	public void verifyTransactionList() {
//			List<WebElement> elements = getElementsList(lblPostedTransactions, "Posted Transactions List");
//			int noOfTransactions = elements.size();
//			for (int i = 0; i < noOfTransactions; i++) {
//				elements.get(i);
		//
//			}
		new CommonFunctions().elementView(lblPostedTransactions, "Posted Transaction");
	}

	public String getItemsPerPage() {
		return getText(lblItemsPerPage, "entries per page");
	}

	public void verifyPostedTransactions(String expCount) {
		int page1 = getElementsList(transaction, "page transaction count").size();
		int count = Integer.parseInt(expCount);
		if (page1 == count) {
			ExtentTestManager.setPassMessageInReport("No of Entries" + page1);

		} else {
			ExtentTestManager.setFailMessageInReport("Not Entries" + page1);

		}

	}

	public void verifyPageNumbersWithCount() {
		int actCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		int page = getElementsList(transaction, "page transaction count").size();
		int pageNumber = actCount / page;
		int remainder = actCount % page;
		if (!(remainder == 0)) {
			pageNumber++;
			if (!(pageNumber == 0)) {
				ExtentTestManager.setPassMessageInReport("No of pages is" + pageNumber);
			} else if (remainder == 0) {
				ExtentTestManager.setPassMessageInReport("No of pages is" + pageNumber);
			}
		} else {
			ExtentTestManager.setFailMessageInReport("No of Page is Null");
		}

	}

	public void verifyBracesCount(String query) throws SQLException {
		int expCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		int count = DBConnection.getDbCon().getCount(String.format(query));
		if (expCount == count) {
			ExtentTestManager.setPassMessageInReport("Braces are " + count);
		} else {
			ExtentTestManager.setFailMessageInReport("Braces are not" + count);
		}
	}

	public void verifyPageNumberHighlighted(String cssProp, String expValue, String expColor) {

		if (verifyElementDisplayed(nextPage, "Next Page")) {
			click(nextPage, "Clicked Next Page");
			new CommonFunctions().verifyChangedColor(seconPage, "Second Page", cssProp, expValue, expColor);
			ExtentTestManager.setPassMessageInReport("Page is Highlighted when clicked on Page number");
		} else {
			ExtentTestManager.setWarningMessageInReport("Page is Not Highlighted");
		}
	}

	public void verifyTableItemsCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(String.format(query));
		int expCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(
					"Number of transactions in table matches with number of entries selected i.e ");
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Number of transactions in table doesnot match with numer of entries selected");
		}
	}

	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Ecosysyem Activity");
	}

	public void verifyActivityDashBoard() {
		new CommonFunctions().elementView(txtActivityDashboard, "ActivityDashBoard");
	}

	public void verifyTransactionType() {
		new CommonFunctions().elementView(transactionType, "TransactionType");
	}

	public void verifyTransCount() {
		new CommonFunctions().elementView(transCount, "TransCount");
	}

	public void verifyVolume() {
		new CommonFunctions().elementView(volume, "Volume");
	}

	public void clickWallets() {
		click(slectDropDownWallets, "Wallets");
	}

	public void clickDeposits() {
		click(slectDropDownDeposits, "Deposits");
	}

	public void clickDateRange() {
		click(dateRangeDropDown, "DateRange");
	}

	public void clickTransHistory() {
		new CommonFunctions().elementView(lnkViewTransHistory, "Transaction History");
	}

	public void verifyLabelYourTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblYourTransactions, "Your Transactions", expHeading);
		new CommonFunctions().elementView(lblYourTransactions, "Your Transactions");
	}

	public void verifyLabelPostedTransactions(String expPostedTranasactionHeading) {
		new CommonFunctions().verifyLabelText(lblPostedTransactions, "Posted Transactions",
				expPostedTranasactionHeading);
		new CommonFunctions().elementView(lblPostedTransactions, "Posted Transactions");

	}

	public void verifyLabelTransactionListDetails() {
		new CommonFunctions().elementView(lblDateTime, "Date and Time");
		new CommonFunctions().elementView(lblType, "Type");
		new CommonFunctions().elementView(lblSubType, "SubType");
		new CommonFunctions().elementView(lblDescription, "Description");
		new CommonFunctions().elementView(lblAmount, "Amount");
		new CommonFunctions().elementView(lblBalance, "Balance");
		new CommonFunctions().elementView(lblStatus, "Status");
	}

	public String getDefaultEntriesPerPage() {
		return getText(defaultEntries, "Default Entries");

	}

	public String getEntriesMessage() {
		return getText(lblEntriesMessage, "Entries Message");
	}

	public void clickOnPages() {
		click(pagination, "Pagination");
	}

	public void clickDropDownEntriesPage() {
		click(entriesPerPageDropDown, "Entries Per Page");
		// new CommonFunctions().elementView(defaultEntries, "Default Entries");

	}

	public void verifyEntriesMessage() {
		new CommonFunctions().elementView(lblEntriesMessage, "Entries Message");
	}

	public void verifyAPIHeading(String apiCallHistory) {
		new CommonFunctions().verifyLabelText(lblApiCallHistory, apiCallHistory, "API Call History");
	}

	public void verifyLabelAPICallsHistory() {
		new CommonFunctions().elementView(lblMethod, "Method");
		new CommonFunctions().elementView(lblIpAddress, "IP Address");
		new CommonFunctions().elementView(lblUserName, "UserName");
	}
}
