package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ExportComponent extends BrowserFunctions {

	private By lblExportHeading = By.xpath("//h3[text()='Export Selected Transactions']");

	private By lblDateRange = By.xpath("//h3[text()='Date Range']");

	private By drpDwn = By.xpath("//div[@class='FormField_selected_option__dQiIf undefined']");

	private By lblColumns = By.xpath("//h3[text()='Columns']");

	private By lnkDeSelectAll = By.xpath("//span[text()='Deselect All']");

	private By btnExport = By.xpath("//button[text()='Export']");

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
		click(drpDwn, "Click Select DropDOwn");

	}

	public void clickSelectDropDownCustom() {
		click(drpDwn, "Click Select DropDOwn");

	}

	public void clickDeSelectAll() {
		click(lnkDeSelectAll, "DeSelect All");
	}

	public void verifyColumns(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblColumns, "Columns", expHeading);
	}

	public By getCheckBox(String elementName) {
		return By.xpath(String.format("//span[(contains(@class,'custom') or contains(@class,'text')) and text()='%s']",
				elementName));
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

	public void clickBusinessID() {
		click(getCheckBox("Business ID"), "Business ID");
	}

	public void clickBusinessName() {
		click(getCheckBox("Business Name"), "Business Name");
	}

	public void clickDBAName() {
		click(getCheckBox("DBA Name"), "DBA Name");
	}

	public void clickCustomerID() {
		click(getCheckBox("Customer ID"), "Customer ID");
	}

	public void clickAssignedTo() {
		click(getCheckBox("Assigned To"), "Assigned To");
	}

	public void clickCustomerName() {
		click(getCheckBox("Customer Name"), "Customer Name");
	}

	public void clickCaseID() {
		click(getCheckBox("Case ID"), "Case ID");
	}

	public void clickNameOnCard() {
		click(getCheckBox("Name On Card"), "Name On Card");
	}

	public void clickGiactReasonCode() {
		click(getCheckBox("Giact Reason Code "), "Giact Reason Code ");
	}

	public void clickMerchantName() {
		click(getCheckBox("Merchant Name"), "Merchant Name");
	}

	public void clickMerchantID() {
		click(getCheckBox("Merchant ID"), "Merchant ID");
	}

	public void clickReleaseRule() {
		click(getCheckBox("Release Rule"), "Release Rule");
	}

	public void clickReleaseType() {
		click(getCheckBox("Release Type"), "Release Type");
	}

	public void clickNextRelease() {
		click(getCheckBox("Next Release"), "Next Release");
	}

	public void clickMerchantBalance() {
		click(getCheckBox("Merchant Balance"), "Merchant Balance");
	}

	public void clickReserveBalance() {
		click(getCheckBox("Reserve Balance"), "Reserve Balance");
	}

	public void clickCaseNumber() {
		click(getCheckBox("Case Number"), "Case Number");
	}

	public void clickAccountID() {
		click(getCheckBox("Account ID"), "Account ID");
	}

	public void clickReceiveDate() {
		click(getCheckBox("Received Date"), "Received Date");
	}

	public void clickDueDate() {
		click(getCheckBox("Due Date"), "Due Date");
	}

	public void clickCreatedDate() {
		click(getCheckBox("Created Date"), "Created Date");
	}

	public void clickCBKAmount() {
		click(getCheckBox("CBk Amount"), "CBk Amount");
	}

	public void clickCBKReason() {
		click(getCheckBox("CBK Reason"), "CBK Reason");
	}

	public void clickFeePaid() {
		click(getCheckBox("Fee Paid"), "Fee Paid");
	}

	public void clickBankDescriptor() {
		click(getCheckBox("Bank Descriptor"), "Bank Descriptor");
	}

	public void clickCardBrand() {
		click(getCheckBox("Card Brand"), "Card Brand");
	}

	public void clickCardFirst6() {
		click(getCheckBox("Card First 6"), "Card First 6");
	}

	public void clickCardLast4() {
		click(getCheckBox("Card Last 4"), "Card Last 4");
	}

	public void clickOriginalTransAmount() {
		click(getCheckBox("OriginalTrans , Amount"), "OriginalTrans , Amount");
	}

	public void clickTransactionType() {
		click(getCheckBox("Transaction Type"), "Transaction Type");
	}

	public void clickTransactionSubType() {
		click(getCheckBox("Transaction SubType"), "Transaction SubType");
	}

	public void clcikOriginalTransDate() {
		click(getCheckBox("OriginalTrans , Date"), "OriginalTrans , Date");
	}

	public void btnExport() {
		click(btnExport, "Export");
	}


}
