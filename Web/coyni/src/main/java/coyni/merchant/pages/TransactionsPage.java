package coyni.merchant.pages;

import org.openqa.selenium.By;
import coyni.merchant.components.FilterComponent;
import coyni.merchant.components.ExportComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Merchant Transactions']");

	private By lblDateTime = By.xpath("//span[text()='Date / Time']");

	private By lblType = By.xpath("//span[text()='Type']");

	private By lblSender = By.xpath("//span[text()='Sender']");

	private By lblReceiver = By.xpath("//span[text()='Receiver']");

	private By lblAmount = By.xpath("//span[text()='Amount']");

	private By lblStatus = By.xpath("//span[text()='Status']");

	private By pagination = By.xpath("//li[@class='paginator__pagination__item active']");

	private By lblEntriesMessage = By.xpath("//span[@class='entries-message']");

	private By entriesPerPageDropDown = By.xpath(
			"//div[@class='custom-pagination-select__indicator custom-pagination-select__dropdown-indicator css-tlfecz-indicatorContainer']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Transaction page Heading", expHeading);
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

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}
}
