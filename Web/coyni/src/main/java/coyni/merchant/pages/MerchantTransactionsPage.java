package coyni.merchant.pages;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.merchant.components.FilterComponent;

import coyni.merchant.components.ExportComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class MerchantTransactionsPage extends BrowserFunctions {

	private By headingTransactionList = By.xpath("//span[text()='Merchant Transactions']");

	private By lblDateTime = By.xpath("//span[text()='Date / Time']");

	private By lblType = By.xpath("//span[text()='Type']");

	private By lblSender = By.xpath("//span[text()='Sender']");

	private By lblReceiver = By.xpath("//span[text()='Receiver']");

	private By lblAmount = By.xpath("//span[text()='Amount']");

	private By lblStatus = By.xpath("//span[text()='Status']");

	private By pagination = By.xpath("//li[@class='paginator__pagination__item active']");

	private By lblItemsPerPage = By.cssSelector(".entries-container .entries-message");

	private By lblEntriesMessage = By.xpath("//span[@class='entries-message']");

	private By defaultEntries = By
			.xpath("//div[@class='custom-pagination-select__single-value css-1uccc91-singleValue']");

	private By transaction = By.xpath("//tr[@class='  hovered']");

	private By btnExport = By.xpath("//button[text()='Export']");

	private By entriesPerPageDropDown = By.xpath(
			"//div[@class='custom-pagination-select__indicator custom-pagination-select__dropdown-indicator css-tlfecz-indicatorContainer']");

	public void verifyTransactionHeading(String heading) {
		new CommonFunctions().verifyLabelText(headingTransactionList, "Transaction Heading", heading);
	}

	public void clickExport() {
		click(btnExport, "Export");
	}

	public void verifyLabelTransactionListDetails() {
		new CommonFunctions().elementView(lblDateTime, "Date and Time");
		new CommonFunctions().elementView(lblType, "Type");
		new CommonFunctions().elementView(lblAmount, "Amount");
		new CommonFunctions().elementView(lblStatus, "Status");
	}

	public String getDefaultEntriesPerPage() {
		return getText(defaultEntries, "Default Entries");

	}

	public String getItemsPerPage() {
		return getText(lblItemsPerPage, "entries per page");
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

	public void verifyEntriesMessage() {
		new CommonFunctions().elementView(lblEntriesMessage, "Entries Message");
	}

	public String getEntriesMessage() {
		return getText(lblEntriesMessage, "Entries Message");
	}

	public void clickOnPages() {
		click(pagination, "Pagination");
	}

	public void clickDropDownEntriesPage() {
		click(entriesPerPageDropDown, "Entries Per Page");

	}

	public void getDateAndTime() {
		ExtentTestManager.setPassMessageInReport("Date/Time is " + getElement(lblDateTime, "Date/Time"));
	}

	public void getType() {
		ExtentTestManager.setPassMessageInReport("Type is " + getElement(lblType, "Type"));
	}

	public void getSender() {
		ExtentTestManager.setPassMessageInReport("Sender is " + getElement(lblSender, "Sender"));
	}

	public void getReceiver() {
		ExtentTestManager.setPassMessageInReport("Receiver is " + getElement(lblReceiver, "Receiver"));
	}

	public void getAmount() {
		ExtentTestManager.setPassMessageInReport("Amount is " + getElement(lblAmount, "Amount"));
	}

	public void getStatus() {
		ExtentTestManager.setPassMessageInReport("Status is " + getElement(lblStatus, "Status"));
	}

//	public PaginationAndEntriesComponent paginationAndEntriesComponent() {
//		return new PaginationAndEntriesComponent();
//	}

	public ExportfilesPage exportfilesPage() {
		return new ExportfilesPage();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}
}
