package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionDetailsComponent extends BrowserFunctions {

	private By lblHeadingTransactionDetails = By.cssSelector(".text");

	private By record = By.cssSelector("tbody>tr:nth-of-type(2)");

	private By btnRefund = By.xpath("//span[text()='Refund']");

	private By fullAmount = By.xpath("//p[text()='Full Amount']");

	private By halfAmount = By.xpath("//p[text()='1/2 Amount']");

	private By lblNoRecords = By.xpath("//span[contains(text(),'No Filter Data Found')]");

	private By lblTransactionType = By.xpath(
			"//span[contains(text(),'Transaction Type')]/../..//p |//span[text()='Transaction Type']/../following-sibling::*[1] |//p[text()='Transaction Type']/following-sibling::*");

	private By lblTransactionSubType = By
			.xpath("//p[contains(text(),'Transaction Sub-type')]/following-sibling::*[1]/p");

	private By lblReferenceID = By.xpath(
			"//p[contains(text(),'Reference ID')]/following-sibling::*[1]/span[1] |//span[text()='Reference ID']/./following-sibling::*|//p[contains(text(),'Reference ID')]/following-sibling::*[1]");

	private By lblDepositID = By.xpath("//p[contains(text(),'Deposit')]/following-sibling::*[1]/span");

	private By lblCreatedDate = By.xpath(
			"//p[contains(text(),'Created')]/following-sibling::*[1]/span | //p[text()='Created Date']/./following-sibling::*|//p[contains(text(),'Created Date')]/following-sibling::*[1]");

	private By lblAmount = By.xpath(
			"//div[contains(text(),'Amount Received')]/following-sibling::*[1]/span[1]|//span[text()='Amount Sent']/./following-sibling::*|//p[contains(text(),'Amount')]/following-sibling::*[1]");

	private By lblPurchaseAmount = By
			.xpath("//div[contains(text(),'Purchase Amount')]/following-sibling::*[1]/span[1]");

	private By lblProceesingFee = By.xpath("//div[contains(text(),'Processing Fee')]/following-sibling::*[1]/span[1]");

	private By lblTotalAmount = By.xpath("//div[contains(text(),'Total Amount')]/following-sibling::*[1]/span[1]");

	private By lblLedgerInformation = By.xpath("//span[text()='Ledger Information']");

	private By lblSenderInformation = By.xpath("//span[text()='Sender Information']");

	private By lblMessageFromSender = By.xpath("");

	private By headingRecipientInformation = By.xpath("//span[text()='Recipient Information']");

	private By lblBankName = By.xpath("//p[text()='Bank Name']/following-sibling::*");

	private By lblBankNumber = By.xpath("//p[text()='Bank Account Number']/following-sibling::*");

	private By headingCardInformation = By.xpath("//span[text()='Card Information']");

	private By lblCompleted = By.xpath("(//div[text()='Completed'])[1]");

	private By lblPayOutID = By.xpath("//span[text()='Payout ID']/following-sibling::*[1]/span[1]");

	private By lblTotalTransactions = By.xpath("//span[text()='Total Transactions']/following-sibling::*");

	private By lblPayOutDate = By.xpath("//span[text()='Payout Date']/following-sibling::*");

	private By lblDepositTo = By.xpath("//span[text()='Deposit To']/following-sibling::*");

	private By txtReasonForRefund = By.cssSelector("#message");

	private By btnNext = By.xpath("//button[text()='Next']");

	private By btnSubmit = By.xpath("//button[text()='Submit']");

	public void fillReason(String refund) {
		enterText(txtReasonForRefund, refund, "Reason For Refund");
	}

	public void clickCompleted() {
		click(lblCompleted, "View Transaction Details");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickSubmit() {
		click(btnSubmit, "Submit");
	}

	public int verifyRecords() {
		int i = getElementsList(lblNoRecords, "").size();
		return i;
	}

	public void verifyNoRecordsFound() {
		new CommonFunctions().elementView(lblNoRecords, "No Records");
	}

	public void clickRecord() {
		if (getElement(record, "Enabled").isDisplayed()) {
			click(record, "Record");
		} else {
			ExtentTestManager.setPassMessageInReport("record is not displayed");
		}

	}

	public void clickFullAmount() {
		click(fullAmount, "Amount");
	}

	public void clickHalfAmount() {
		click(halfAmount, "Half Amount");
	}

	public void clickRefund() {
		click(btnRefund, "Refund");
	}

//	public By getLabelItem(String Type) {
//		return By.xpath(String.format(
//				"//span[text()='%s']/../following-sibling::*  | //p[text()='%s']/following-sibling::*[1]/p | //p[text()='%s']/following-sibling::*[1]/span",
//				Type, Type, Type));// | //p[text()='%s']//following-sibling::span
//	}

	public void verifyRecipientInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(headingRecipientInformation, "Recipient Information", expHeading);
	}

	public void getRecipientName() {
		ExtentTestManager.setInfoMessageInReport("Recipient Name  is " + getText(lblReferenceID, "Recipient Name"));
	}

//	public void getRecipientEmail() {
//		ExtentTestManager.setInfoMessageInReport(
//				"Recipient Email  is " + getText(getLabelItem("Recipient Email"), "Recipient Email"));
//	}
//
//	public void getRecipientPhoneNumber() {
//		ExtentTestManager.setInfoMessageInReport(
//				"Recipient PhoneNumber  is " + getText(getLabelItem("Recipient Phone"), "Recipient PhoneNumber"));
//	}

	public void getBankName() {
		String text = getText(lblBankName, "Bank Name");
		ExtentTestManager.setInfoMessageInReport("Bank Name " + text);

	}

	public void getPayOutID() {
		String text = getText(lblPayOutID, "PayOut ID");
		ExtentTestManager.setInfoMessageInReport("PayOut ID" + text);

	}

	public void getTotalTransctions() {
		String text = getText(lblTotalTransactions, "Total Transactions");
		ExtentTestManager.setInfoMessageInReport("Total Transactions" + text);

	}

	public void getPayOutDate() {
		String text = getText(lblPayOutDate, "PayOut Date");
		ExtentTestManager.setInfoMessageInReport("PayOut Date" + text);

	}

	public void getDepositTo() {
		String text = getText(lblDepositTo, "Deposit To");
		ExtentTestManager.setInfoMessageInReport("Deposit To" + text);

	}

	public void getBankAccount() {
		String text = getText(lblBankNumber, "Bank Number");
		ExtentTestManager.setInfoMessageInReport("Bank Number " + text);

	}

	public void verifyTransactionDetailsHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeadingTransactionDetails, "Transaction Heading", expHeading);
	}

	public void getTransactionType() {
		String text = getText(lblTransactionType, "Transaction Type");
		ExtentTestManager.setInfoMessageInReport("Transaction Type  " + text);
	}

	public void getTransactionSubType() {
		String text = getText(lblTransactionSubType, "Transaction Sub Type");
		ExtentTestManager.setInfoMessageInReport("Transaction Sub Type " + text);

	}

	public void getCreatedDate() {
		String text = getText(lblCreatedDate, "Created Date");
		ExtentTestManager.setInfoMessageInReport("Created Date " + text);
	}

	public void getAmount() {
		String text = getText(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Amount " + text);
	}
//
//	public void getgiftCardAmount() {
//		ExtentTestManager.setInfoMessageInReport(
//				"Gift Card Amount  is " + getText(getLabelItem("Gift Card Amount"), "Gift Card Amount"));
//	}

	public void verifyLedgerInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(lblLedgerInformation, "Ledger Information Heading", expHeading);

	}

	public void getReferenceID() {
		String text = getText(lblReferenceID, "Reference ID");
		ExtentTestManager.setInfoMessageInReport("Reference ID" + text);
	}

	public void verifySenderInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSenderInformation, "Sender Information Heading", expHeading);

	}

//	public void getSenderName() {
//		ExtentTestManager.setInfoMessageInReport("SenderName is " + getText(getLabelItem("Sender Name"), "SenderName"));
//	}
//
//	public void getAccountID() {
//		ExtentTestManager
//				.setInfoMessageInReport("AccountID  is " + getText(getLabelItem("Sender Account ID"), "AccountID"));
//	}

//	public void getAccountAddress() {
//		ExtentTestManager.setInfoMessageInReport(
//				"Account Address  is " + getText(getLabelItem("Sender Account Address"), "Sender Account Address"));
//	}
//
//	public void getSenderEmail() {
//		ExtentTestManager
//				.setPassMessageInReport("Sender Email  is " + getText(getLabelItem("Sender Email"), "Sender Email"));
//	}
//
//	public void getSenderPhoneNumber() {
//		ExtentTestManager.setPassMessageInReport(
//				"Sender PhoneNumber  is " + getText(getLabelItem("Sender Phone"), "Sender PhoneNumber"));
//	}

	public void getMessageFromSender() {
		ExtentTestManager.setInfoMessageInReport(
				"Message From Sender  is " + getText(lblMessageFromSender, "Message From Sender"));
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}
}
