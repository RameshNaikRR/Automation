package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.admin.popups.ExportSelectedTransactionsPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ExportComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("");
	private By lnkDelectAll = By.xpath("");
	private By crossClose = By.xpath("");
	private By btnExport = By.cssSelector("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHeading);
	}

	public void clickDeselectAll() {
		click(lnkDelectAll, "Deselect All");
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

	public void clickExport() {
		if (getElement(btnExport, "Export").isEnabled()) {
			click(btnExport, "Export");
			ExtentTestManager.setPassMessageInReport("Export Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Export Button is Disabled");
		}
	}

	public By getRadioBtn(String elementName) {
		return By.xpath(String.format("//span[(contains(@class,'custom') or contains(@class,'text')) and text()='%s']",
				elementName));
	}

	public void clickToday() {
		click(getRadioBtn("Today"), "Today");
	}

	public void clickYesterday() {
		click(getRadioBtn("Yesterday"), "Yesterday");
	}

	public void clickLast7Days() {
		click(getRadioBtn("Last 7 Days"), "Last 7 Days");
	}

	public void clickMonthToDate() {
		click(getRadioBtn("Month to Date"), "Month to Date");
	}

	public void clickPreviousMonth() {
		click(getRadioBtn("Prevoius Month"), "Previous Month");
	}

	public void clickCustomDateRange() {
		click(getRadioBtn("Custom Date Range"), "Custom Date Range");
	}

	private By getCheckBox(String elementName) {
		return By.xpath(String.format("//span[text()='%s']/preceding-sibling::input", elementName));
	}

	public void clickPayoutNumber() {
		click(getCheckBox("Payout Number"), "Payout Number");
	}

	public void clickPayoutType() {
		click(getCheckBox("Payout Type"), "Payout Type");
	}

	public void clickTransactionCount() {
		click(getCheckBox("Transaction Count"), "Transaction Count");
	}

	public void clickAmount() {
		click(getCheckBox("Amount"), "Amount");
	}

	public void clickCurrency() {
		click(getCheckBox("Currency"), "Currency");
	}

	public void clickStatus() {
		click(getCheckBox("Status"), "Status");
	}

	public void clickDateAndTime() {
		click(getCheckBox("Date & Time"), "Date & Time");
	}

	public void clickReferenceID() {
		click(getCheckBox("Reference ID"), "Reference ID");
	}

	public void clickUserType() {
		click(getCheckBox("User Type"), "User Type");
	}

	public void clickTransactionType() {
		click(getCheckBox("Transaction Type"), "Transaction Type");
	}

	public void clickTransactionSubType() {
		click(getCheckBox("Transaction Subtype"), "Transaction Subtype");
	}

	public void clickDescription() {
		click(getCheckBox("Description"), "Description");
	}

	public void clickProcessingFee() {
		click(getCheckBox("Processing Fee"), "Processing Fee");

	}

	public void clickWalletType() {
		click(getCheckBox("Wallet Type"), "Wallet Type");
	}

	public void clickWalletName() {
		click(getCheckBox("Wallet Name"), "Wallet Name");
	}

	public void clickWalletId() {
		click(getCheckBox("Wallet ID"), "Wallet ID");
	}

	public void clickAccountBalance() {
		click(getCheckBox("Account Balance"), "Account Balance");
	}

	public void clickAccountName() {
		click(getCheckBox("Account Name"), "Account Name");
	}

	public SideBarComponent sideBarComponent() {
		return new SideBarComponent();
	}

	public ExportSelectedTransactionsPopup exportSelectedTransactionsPopup() {
		return new ExportSelectedTransactionsPopup();
	}

}
