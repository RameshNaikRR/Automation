package coyni.apibusiness.components;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;
import ilabs.web.actions.WaitForElement;

public class EcoSystemActivityComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Ecosytem Activity']");
	private By txtActivityDashboard = By.xpath("//span[text()='Activity Dashboard']");
	private By transactionType = By.xpath("//h3[text()='TRANSACTION TYPE']");
	private By transCount = By.xpath("//h3[text()='TRANS. COUNT']");
	private By volume = By.xpath("//h3[text()='VOLUME (CYN)']");
	private By slectDropDownWallets = By.xpath("");
	private By slectDropDownDeposits = By.xpath("");
	private By Today = By.xpath("(//div[text()='Today'])[1]");
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
	private By transactionHeading = By.xpath("//p[text()='Transactions']");
	private By lblItemsPerPage = By.cssSelector(".entries-container .entries-message");
//	private By rows = By.cssSelector(".custom-table-wrapper>tbody>tr");
	private By transaction = By.xpath("//tr[@class='  hovered']");
	private By lblBracesCount = By.cssSelector(".posted-txn .posted");
	private By defaultEntries = By
			.xpath("//div[@class='custom-pagination-select__single-value css-1uccc91-singleValue']");
	private By lblEntriesMessage = By.xpath("//span[contains(@class,'entries-message')]");
	private By pagination = By.xpath("//li[@class='paginator__pagination__item active']");
	private By entriesPerPage = By.xpath("//span[@class='entries-message text-cgy4']");
	private By lblApiCallHistory = By.xpath("//h1[text()= 'API Call History']");
	private By apicallscount = By.xpath("//span[@class='text-base font-bold w-80 text-cgn8']");
	private By lblMethod = By.xpath("//span[text()='METHOD']");
	private By lblIpAddress = By.xpath("//span[text()='IP ADDRESS']");
	private By lblUserName = By.xpath("//span[text()='USERNAME']");
	private By transCountValue = By.xpath(
			"//p[text()='Wallet Transfer']/following-sibling::p[@class='EcosystemActivityDashboard_subtxncount__GopYF text-center']");
	private By transCountdeposits = By.xpath(
			"//p[text()='Deposits']/following-sibling::p[@class='EcosystemActivityDashboard_subtxncount__GopYF text-center']");
	private By transCountWithdraw = By.xpath(
			"//p[text()='Withdraws']/following-sibling::p[@class='EcosystemActivityDashboard_subtxncount__GopYF text-center']");
	private By walletTransfer = By.xpath("//p[text()='Wallet Transfer']");
	private By deposits = By.xpath("//p[text()='Deposits']");
	private By withdraws = By.xpath("//p[text()='Withdraws']");
	private By dateandTimeRow = By.xpath("//table[@class='custom-table-wrapper']//thead");
	private By paginationNext = By.xpath("//span[@aria-label='Next']");
	private By paginationPrevious = By.xpath("//span[text()='Previous']");
	private By filters = By.xpath("//span[@class='icon-filter btn__custom_button__icon relative right-2']");
	private By listTransactionRows = By.xpath("//tr[@class='  hovered'][1]");

	private By activityDashboardRows(String dashboard) {
		return By
				.xpath(String.format("(//summary[@class='EcosystemActivityDashboard_summary__BBSHV'])[%s]", dashboard));
	}

	private By listDropDown = By.xpath("//ul[@class='grid cursor-pointer gap-y-2']");

	public String getBracesCount() {
		String str = getText(lblBracesCount, "braces Count");
		return str;
	}

	public void clickFilters() {
		click(filters, "Filters");
	}

	public void clickTransactionRow() {
		if (verifyElementPresence(listTransactionRows, "Transactions")) {
			click(listTransactionRows, "Transaction Rows");
		} else {
			ExtentTestManager.setInfoMessageInReport("No Filter Data Found");
		}

	}

	public void listDateAndTime() {
		String row = getText(dateandTimeRow, "Transaction Row");
		ExtentTestManager.setInfoMessageInReport(row);
		String str = getElement(dateandTimeRow, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(dateandTimeRow, "Transaction Row");
	}

	public void clickPrevious() {
		click(paginationPrevious, "Previous");
	}

	public void clickNext() throws InterruptedException {
		new CommonFunctions().verifyCursorAction(paginationNext, "Pagination next");
		Thread.sleep(2000);
		click(paginationNext, "Pagination next");
	}

	public void viewEntries() {
		String entry = getText(entriesPerPage, "Entries");
		ExtentTestManager.setInfoMessageInReport(entry);
	}

	public void DropDown() {
		new CommonFunctions().verifyCursorAction(Today, "Today");
		click(Today, "Drop Down");
//		List<WebElement> rows = getElementsList(Today, "DropDown");
//		for (WebElement row : rows) {
//			String replace = row.getText().replace("\n", "");
//			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
//		}
	}

	public void apiCallsCount() {
		String callsCount = getText(apicallscount, "");
		ExtentTestManager.setInfoMessageInReport(callsCount + " are Displayed");
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

	public void verifyHeading() {
		new CommonFunctions().elementView(transactionHeading, "Transactions");
		String str = getElement(lblHeading, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
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

	public void verifyEcosystemHeading(String expHeading) {
		String str = getElement(lblHeading, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().verifyLabelText(lblHeading, "EcoSystem Activity", expHeading);
	}

	public void verifyActivityDashBoard() {
		String str = getElement(txtActivityDashboard, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(txtActivityDashboard, "ActivityDashBoard");
	}

	public void verifyTransactionType() {
		String str = getElement(transactionType, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(transactionType, "TransactionType");
	}

	public void verifyTransCount() {
		String str = getElement(transCount, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(transCount, "TransCount");
	}

	public void verifyVolume() {
		String str = getElement(volume, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(volume, "Volume");
	}

	public void verifyWalletTransfer() {
		new CommonFunctions().verifyCursorAction(activityDashboardRows("1"), "Wallets");
		List<WebElement> rows = getElementsList(activityDashboardRows("1"), "Wallets");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void listDropDown() {
//		List<WebElement> rows = getElementsList(listDropDown, "Drop Down");
//		for (WebElement row : rows) {
//			String replace = row.getText().replace("\n", "");
//			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
//		}
		BrowserFunctions objBrowserFunctions = new BrowserFunctions();
		By options = listDropDown;
//		boolean status = false;
		objBrowserFunctions.waitForElement(options, BrowserFunctions.waittime, WaitForElement.presence);
		List<WebElement> optionsEles = objBrowserFunctions.getElementsList(options, "options");
		for (WebElement optionEle : optionsEles) {
			String s = optionEle.getText();
			optionEle.click();
			ExtentTestManager.setInfoMessageInReport(s + " selected from  drop down");
//			status = true;
			deposits();
//			break;
		}
//			if (status) {
//		ExtentTestManager.setInfoMessageInReport(optionEle + " selected from  drop down");
//			} else {
//				ExtentTestManager.setFailMessageInReport(optionEle + " not available in dropdown");
//			}
//		
	}

	public void walletTransfer() {
		String i = getText(transCountValue, "TransCount");
		int K = Integer.parseInt(i);
		if (K > 0) {
			click(walletTransfer, "Wallets Transfer");
		}
	}

	public void deposits() {
		String i = getText(transCountdeposits, "TransCount");
		int K = Integer.parseInt(i);
		if (K > 0) {
			click(deposits, "Deposits");
		}
	}

	public void Withdraw() {
		String i = getText(transCountWithdraw, "TransCount");
		int K = Integer.parseInt(i);
		if (K > 0) {
			click(withdraws, "Withdraws");
		}
	}

	public void verifyDeposits() {
		new CommonFunctions().verifyCursorAction(activityDashboardRows("2"), "Deposits");
		List<WebElement> rows = getElementsList(activityDashboardRows("2"), "Deposits");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void verifyWithdraws() {
		new CommonFunctions().verifyCursorAction(activityDashboardRows("3"), "Withdraws");
		List<WebElement> rows = getElementsList(activityDashboardRows("3"), "Withdraws");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void clickTransHistory() {
		new CommonFunctions().elementView(lnkViewTransHistory, "Transaction History");
		new CommonFunctions().verifyCursorAction(lnkViewTransHistory, "View Transaction Full History");
		new CommonFunctions().verifyTextUnderLine(lnkViewTransHistory, "View Transaction Full History");
		click(lnkViewTransHistory, "View Transaction Full History");
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

	public String getDefaultEntriesPerPage() {
		return getText(defaultEntries, "Default Entries");

	}

	public String getEntriesMessage() {
		return getText(lblEntriesMessage, "Entries Message");
	}

	public void clickOnPages() {
		click(pagination, "Pagination");
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
