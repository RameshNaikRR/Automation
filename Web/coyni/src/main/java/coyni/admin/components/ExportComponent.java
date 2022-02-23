package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ExportComponent extends BrowserFunctions {

	private By lblExportHeading = By.xpath("//h3[text()='Export Selected Transactions']");

	private By lblDateRange = By.xpath("");

	private By drpDwnDefault = By.xpath("");

	private By drpDwnCustom = By.xpath("");

	private By lnkDeSelectAll = By.xpath("");

	private By lblColumns = By.xpath("");

	public By getRadioBtn(String elementName) {
		return By.xpath(String.format("", elementName));
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

	public void clickLastMonth() {
		click(getRadioBtn("Last Month"), "Last Month");
	}

	public void clickCustomDateRange() {
		click(getRadioBtn("Custom Date Range"), "Custom Date Range");
	}

	public void verifyExport(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblExportHeading, "Export Heading", expHeading);
	}

	public void verifyDateRange(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblDateRange, "Date Range", expHeading);
	}

	public void clickSelectDropDownDefault() {
		click(drpDwnDefault, "Click Select DropDOwn");

	}

	public void clickSelectDropDownCustom() {
		click(drpDwnCustom, "Click Select DropDOwn");

	}

	public void clickDeSelectAll() {
		click(lnkDeSelectAll, "DeSelect All");
	}

	public void verifyColumns(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblColumns, "Columns", expHeading);
	}

	public By getCheckBox(String elementName) {
		return By.xpath(String.format("", elementName));
	}

	public void clickReferenceId() {
		click(getCheckBox("ReferenceId"), "Reference ID");
	}

	public void clickDescription() {
		click(getCheckBox("Description"), "Description");
	}

	public void clickDateandTime() {
		click(getCheckBox("Date & Time"), "Date & Time");
	}

	public void clickEmployeeName() {
		click(getCheckBox("Employee Name"), "Employee Name");
	}

	public void clickAmount() {
		click(getCheckBox("Amount"), "Amount");
	}

	public void clickBalance() {
		click(getCheckBox("Balance"), "Balance");
	}

	public void clickType() {
		click(getCheckBox("Type"), "Type");
	}

	public void clickStatus() {
		click(getCheckBox("Status"), "Status");
	}

	public void clickWithdrawId() {
		click(getCheckBox("Withdraw ID"), "Withdraw ID");
	}

	public void clickUserId() {
		click(getCheckBox("User ID"), "User ID");
	}

	public void clickBankAccountNumber() {
		click(getCheckBox("Bank Account Number"), "Bank Account Number");
	}

	public void clickReceivedAmount() {
		click(getCheckBox("Received Amount"), "Received Amount");
	}

	public void clickProcessingFee() {
		click(getCheckBox("Processing Fee"), "Processing Fee");
	}

	public void clickUserType() {
		click(getCheckBox("User Type"), "User Type");
	}

	public void clickNameOnAccount() {
		click(getCheckBox("Name On Account"), "Name On Account");
	}

	public void clickWithdrawAmount() {
		click(getCheckBox("Withdraw Amount"), "Withdraw Amount");
	}

	public void clickFirstSixDigits() {
		click(getCheckBox("First 6 Digits"), "First 6 Digits");
	}

	public void clickLastFourDigits() {
		click(getCheckBox("Last 4 Digits"), "Last 4 Digits");
	}

	public void clickCheckNumber() {
		click(getCheckBox("Check Number"), "Check Number");
	}

	public void clickFirstName() {
		click(getCheckBox("First Name"), "First Name");
	}

	public void clickLastName() {
		click(getCheckBox("Last Name"), "Last Name");
	}

	public void clickEmail() {
		click(getCheckBox("Email"), "Email");
	}

	public void clickGiftCardAmount() {
		click(getCheckBox("Gift Card Amount"), "Gift Card Amount");
	}

	public void clickGiftCardName() {
		click(getCheckBox("Gift Card Name"), "Gift Card Name");
	}

	public void clickDepositId() {
		click(getCheckBox("Deposit ID"), "Deposit ID");
	}

	public void clickDepositAmount() {
		click(getCheckBox("Deposit Amount"), "Deposit Amount");
	}

	public void clickWalletId() {
		click(getCheckBox("Wallet Id"), "Wallet Id");
	}

	public void clickNameOnCard() {
		click(getCheckBox("Name On Card"), "Name On Card");
	}

	public void btnExport() {
		click(getCheckBox("clickExport"), "clickExport");
	}

}
