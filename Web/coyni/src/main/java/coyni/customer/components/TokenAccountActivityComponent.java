package coyni.customer.components;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class TokenAccountActivityComponent extends BrowserFunctions {

	private By btnTokensSentDetails = By.xpath("(//button[text()='Details'])[1]");

	private By tokenSentDetailsList = By
			.xpath("(//span[@class='font-bold text-cgy4 AccountActivity_balance__dRNlX'])[1]");

	private By tokenReceivedDetailsList = By
			.xpath("(//span[@class='font-bold text-cgy4 AccountActivity_balance__dRNlX'])[2]");

	private By tokenPurchasedDetailsList = By
			.xpath("(//span[@class='font-bold text-cgy4 AccountActivity_balance__dRNlX'])[3]");

	private By tokenWithdrawDetailsList = By
			.xpath("(//span[@class='font-bold text-cgy4 AccountActivity_balance__dRNlX'])[4]");

	private By tokenPaidOrdersDetailsList = By
			.xpath("(//span[@class='font-bold text-cgy4 AccountActivity_balance__dRNlX'])[5]");

	private By btnTokensReceivedDetails = By.xpath("(//button[text()='Details'])[2]");

	private By btnTokensPurchasedDetails = By.xpath("(//button[text()='Details'])[3]");

	private By btnTokensWithdrawn = By.xpath("(//button[text()='Details'])[4]");

	private By lblTokensWithdrawn = By.xpath("//span[text()='Token Withdraw']");

	private By btnPaidOrdersDetails = By.xpath("(//button[text()='Details'])[5]");

	private By lblPaidOrders = By.xpath("//span[text()='Token Paid (To Business)']");

	private By transactionDetails = By.xpath("//div[@Class='custom-table-container custom-table-container--empty']");

	private By entriesPerPageDropDown = By.xpath(
			"//div[@class='custom-pagination-select__indicator custom-pagination-select__dropdown-indicator css-tlfecz-indicatorContainer']");

	private By lblItemsPerPage = By.cssSelector(".entries-container .entries-message");

	private By rows = By.cssSelector(".custom-table-wrapper>tbody>tr");

	private By transaction = By.xpath("//tr[@class='  ']");

	private By lblBracesCount = By.cssSelector(".posted-txn .posted");

	private By defaultEntries = By
			.xpath("//div[@class='custom-pagination-select__single-value css-1uccc91-singleValue']");

	private By lblEntriesMessage = By.xpath("//span[contains(@class,'entries-message')]");
	private By lblNoTrasactons = By.xpath("//span[contains(text(),'You do not have any transactions.')]");
	
	String s;

	// private By pagination = By.xpath("//li[@class='paginator__pagination__item
	// active']");

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

	public void clickTokensSentDetails() {
		click(btnTokensSentDetails, "Click Token Sent Details");
	}

	public String getItemsPerPage() {
		return getText(lblItemsPerPage, "entries per page");
	}

	public void verifyTableItemsCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(String.format(query));
		int expCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		if (count == expCount) {
			ExtentTestManager
					.setPassMessageInReport("Number of transactions in table matches with number of entries selected ");
		} else {
			ExtentTestManager.setWarningMessageInReport("No Transactions found");
		}
	}

	public String verifyNoTrasactionsFound() {
		new CommonFunctions().elementView(lblNoTrasactons, "No Trasactions");
	       return getText(lblNoTrasactons, "No Trasactions");
	}

//	public void verifyPaginations() throws InterruptedException {
//		int expStart = 1;
//		int expEnd = 10;
//		int page = 1;
//		int total = Integer.parseInt(getItemsPerPage().split(" ")[5]);
//		while (isNextButtonEnabled()) {
//			int start = Integer.parseInt(getItemsPerPage().split(" ")[1]);
//			int end = Integer.parseInt(getItemsPerPage().split(" ")[3]);
//			if (start == expStart && end == expEnd) {
//				ExtentTestManager.setPassMessageInReport(
//						String.format("Page %d contains items from %d to %d", page, start, end));
//			} else {
//				ExtentTestManager.setFailMessageInReport(
//						String.format("Page %d should contain items from %d to %d but contains items from %d to %d",
//								page, expStart, expEnd, start, end));
//			}
//			expStart += 10;
//			expEnd += 10;
//			if (expEnd > total) {
//				expEnd = total;
//			}
//			if (expStart > total) {
//				break;
//			}
//			page++;
//			Thread.sleep(500);
//			clickGoToNextPage();
//		}
//	}

	public void verifyPageNumberHighlighted(String cssProp, String expValue, String expColor) {

		if (verifyElementDisplayed(nextPage, "Next Page")) {
			click(nextPage, "Clicked Next Page");
			new CommonFunctions().verifyChangedColor(seconPage, "Second Page", cssProp, expValue, expColor);
			ExtentTestManager.setPassMessageInReport("Page is Highlighted when clicked on Page number");
		} else {
			ExtentTestManager.setWarningMessageInReport("Page is Not Highlighted");
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

	public int verifyTransactions() {
		return getElementsList(lblNoTrasactons, "").size();
	}

	public void verifyEntriesMessage() {
		if (verifyElementDisplayed(lblEntriesMessage, "Enteries Messages")) {
			new CommonFunctions().elementView(lblEntriesMessage, "Entries Message");
		} else {
			ExtentTestManager.setInfoMessageInReport("no data found");
		}
	}
	
	public String testGetEntriesMessage( ) {
		int i = getElementsList(lblNoTrasactons, "Entries Message").size() ;
		if (i != 0) {
			 s = verifyNoTrasactionsFound();
			verifyNoTrasactionsFound();
				
			} else {
				getEntriesMessages();
				return getEntriesMessages();
			}
		return s;
	 
	}


	public void verifyTransactionDetails() {
		new CommonFunctions().elementView(transactionDetails, "Transaction Details");
	}

	public void clickDropDownEntriesPage() {

		if (verifyElementPresence(entriesPerPageDropDown, "Enteries Dropdown")) {
			click(entriesPerPageDropDown, "Entries Per Page");
		} else {
			ExtentTestManager.setInfoMessageInReport("Default Entries is displayed as " + getDefaultEntriesPerPage());

		}
	}

	public String getTransactionSentDetailsList() {
		return getText(tokenSentDetailsList, "Transaction Sent List");
	}

	public String getTransactionReceivedDetailsList() {
		return getText(tokenReceivedDetailsList, "Transaction Received List");
	}

	public String getTransactionPurchasedDetailsList() {
		return getText(tokenPurchasedDetailsList, "Transaction Purchased List");
	}

	public String getTransactionWithdrawDetailsList() {
		return getText(tokenWithdrawDetailsList, "Transaction Withdraw List");
	}

	public String getTransactionPaidOrdersDetailsList() {
		return getText(tokenPaidOrdersDetailsList, "Transaction Paid Orders List");
	}

	public String getDefaultEntriesPerPage() {
		return getText(defaultEntries, "Default Entries");

	}

	public int getEntriesMessageCount() {
		return getElementsList(lblNoTrasactons, "Entries Message").size() ;
		
	}
	
	public String getEntriesMessages() {
		return getText(lblEntriesMessage, "Entries Message");
	}

//	public void clickOnPages() {
//		click(pagination, "Pagination");
//	}

	public void tokenAccountActivityDetails() {
		new CommonFunctions().elementView(btnTokensSentDetails, "Tokens Sent Details");
		new CommonFunctions().elementView(btnTokensReceivedDetails, "Tokens Received Details");
		new CommonFunctions().elementView(btnTokensPurchasedDetails, "Tokens Purchased Details");
		new CommonFunctions().elementView(btnTokensWithdrawn, "Tokens Withdrawn Details");
	}

	public void clickTokensReceivedDetails() {
		click(btnTokensReceivedDetails, "Click Token Received Details");

	}

	public void clickTokensPurchasedDetails() {
		click(btnTokensPurchasedDetails, "Click Token Purchased Details");
	}

	public void clickTokensWithdrawnDetails() {
		click(btnTokensWithdrawn, "Click Token Withdrawn Details");
	}

	public String getTokensWithdrawn() {
		return getText(lblTokensWithdrawn, "Tokens Withdrawn");
	}

	public void clickPaidOrdersDetails() {
		click(btnPaidOrdersDetails, "Click Paid Order Details");
	}

	public String getPaidOrders() {
		return getText(lblPaidOrders, "Paid Orders");
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public TokensSentDetailsComponent tokensSentDetailsComponent() {
		return new TokensSentDetailsComponent();
	}

	public TokensReceivedDetailsComponent tokensReceivedDetailsComponent() {
		return new TokensReceivedDetailsComponent();
	}

	public TokensPurchasedDetailsComponent tokensPurchasedDetailsComponent() {
		return new TokensPurchasedDetailsComponent();
	}

	public TokensWithdrawnDetailsComponent tokensWithdrawnDetailsComponent() {
		return new TokensWithdrawnDetailsComponent();
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}
}