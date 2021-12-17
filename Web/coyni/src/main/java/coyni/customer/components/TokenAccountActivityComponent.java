package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenAccountActivityComponent extends BrowserFunctions {

	private By btnTokensSentDetails = By.xpath("(//button[text()='Details'])[1]");

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

	private By defaultEntries = By
			.xpath("//div[@class='custom-pagination-select__single-value css-1uccc91-singleValue']");

	private By lblEntriesMessage = By.xpath("//span[@class='entries-message']");

	// private By pagination = By.xpath("//li[@class='paginator__pagination__item
	// active']");

//	private By firstPage = By.xpath("//a[contains(@aria-label, 'first page') or text() = '«']");
//
//	private By prevPage = By.xpath("//a[contains(@aria-label, 'previous page') or text() = '❮']");
//
//	private By nextPage = By.xpath("//a[contains(@aria-label, 'next page') or text() = '❯']");
//
//	private By lastPage = By.xpath("//a[contains(@aria-label, 'last page') and text() = '»']");
//
//	public void clickGoToFirstPage() {
//		click(firstPage, "first page '«'");
//	}
//
//	public void clickGoToPreviousPage() {
//		click(prevPage, "previou page '❮'");
//	}
//
//	public void clickGoToNextPage() {
//		click(nextPage, "next page '❯'");
//	}
//
//	public void clickGoToLastPage() {
//		click(lastPage, "last page '»'");
//	}
//
//	public boolean isNextButtonEnabled() {
//		return getElement(nextPage, "next page '❯'").isEnabled();
//	}

	public void clickTokensSentDetails() {
		click(btnTokensSentDetails, "Click Token Sent Details");
	}

	public String getItemsPerPage() {
		return getText(lblItemsPerPage, "entries per page");
	}

	public void verifyTableItemsCount(String query) {
		int actCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
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

	public void verifyEntriesMessage() {
		new CommonFunctions().elementView(lblEntriesMessage, "Entries Message");
	}

	public void verifyTransactionDetails() {
		new CommonFunctions().elementView(transactionDetails, "Transaction Details");
	}

	public void clickDropDownEntriesPage() {
		click(entriesPerPageDropDown, "Entries Per Page");

	}

	public String getDefaultEntriesPerPage() {
		return getText(defaultEntries, "Default Entries");

	}

	public String getEntriesMessage() {
		return getText(lblEntriesMessage, "Entries Message");
	}

//	public void clickOnPages() {
//		click(pagination, "Pagination");
//	}

	public void clickTokensReceivedDetails() {
		click(btnTokensReceivedDetails, "Click Token Received Details");

	}

	public void clickTokensPurchasedDetails() {
		click(btnTokensPurchasedDetails, "Click Token Received Details");
	}

	public void clickTokensWithdrawn() {
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

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

}
