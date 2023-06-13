package coyni.admin.MerchantServicesPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import coyni.admin.Paymentcomponents.FilterComponent;
import coyni.admin.Paymentcomponents.PaginationAndEntriesComponent;
import coyni.admin.Paymentcomponents.TransactionDetailsComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionPage extends BrowserFunctions {
	WebDriver driver = DriverFactory.getDriver();
	private By headingTransactionList = By.xpath("//span[text()='Transaction List ']");

	private By lblHeading = By.xpath("(//span[text()='Transactions'])[2]");

	private By lblToken = By.xpath("//button[text()='Token']");

	private By lblBusiness = By.xpath("//button[text()='Business']");

	private By lblDateTime = By.xpath("//span[text()='Date & Time']");

	private By lblUserType = By.xpath("//span[text()='User Type']");

	private By lblType = By.xpath("//span[text()='Type']");

	private By lblSubType = By.xpath("//span[text()='Sub Type']");

	private By lblDescription = By.xpath("//span[text()='Description']");

	private By lblAmount = By.xpath("//span[text()='Amount']");

	private By lblStatus = By.xpath("//span[text()='Status']");

	private By pagination = By.xpath("//li[@class='paginator__pagination__item active']");

	private By lblEntriesMessage = By.xpath("//span[@class='entries-message']");

	private By entriesPerPageDropDown = By.xpath(
			"//div[@class='custom-pagination-select__indicator custom-pagination-select__dropdown-indicator css-tlfecz-indicatorContainer']");

	public void verifyTransactionHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingTransactionList, "Transaction Heading", expHeading);
	}

	public void verifyTransaction() {
		new CommonFunctions().verifyLabelText(lblHeading, "Transactions", "Transactions");
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

	public void clickToken() {
		click(lblToken, "Token");
	}

	public void clickBusiness() {
		click(lblBusiness, "Business");
	}

	public void clickDropDownEntriesPage() {
		click(entriesPerPageDropDown, "Entries Per Page");

	}

	public void getDateAndTime() {
		ExtentTestManager.setPassMessageInReport("Date/Time is " + getElement(lblDateTime, "Date/Time"));
	}

	public void getUserType() {
		ExtentTestManager.setPassMessageInReport("UserType is " + getElement(lblUserType, "UserType"));
	}

	public void getType() {
		ExtentTestManager.setPassMessageInReport("Type is " + getElement(lblType, "Type"));
	}

	public void getSubType() {
		ExtentTestManager.setPassMessageInReport("Sub Type is " + getElement(lblSubType, "Sub Type"));
	}

	public void getDescription() {
		ExtentTestManager.setPassMessageInReport("Description is " + getElement(lblDescription, "Description"));
	}

	public void getAmount() {
		ExtentTestManager.setPassMessageInReport("Amount is " + getElement(lblAmount, "Amount"));
	}

	public void getStatus() {
		ExtentTestManager.setPassMessageInReport("Status is " + getElement(lblStatus, "Status"));
	}

	public PaginationAndEntriesComponent paginationAndEntriesComponent() {
		return new PaginationAndEntriesComponent();
	}

	public TransactionDetailsComponent transactionDetailsComponent() {
		return new TransactionDetailsComponent();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	private By txtSearch = By.cssSelector(".form-input");
	private By btnSearch = By.xpath("//button[@class='icon-search']");

	public void clickSearch() {
		click(btnSearch, "");
	}

	public String copyDataToClipBoard() {
		String str = getCopiedData();
		return str;

	}

	public void fillSearch(String text) {
		click(txtSearch, "");
		enterText(txtSearch, text, "Search Data");
	}

	public void fillTransactionSearch() {
		click(txtSearch, "");
		DriverFactory.getDriver().findElement(txtSearch).sendKeys(Keys.CONTROL + "v");
	}
}
