package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionDetailsComponent extends BrowserFunctions {

	private By lblHeadingTransactionDetails = By.cssSelector(".text");

	private By lblLedgerInformation = By.xpath("//span[text()='Ledger Information']");

	private By lblSenderInformation = By.xpath("//span[text()='Sender Information']");

	private By lblMessageFromSender = By.xpath("");

	private By headingRecipientInformation = By.xpath("//span[text()='Recipient Information']");

	private By headingBankInformation = By.xpath("//span[text()='Bank Information']");

	private By headingBankAccountInformation = By.xpath("//span[text()='Bank Account Information']");//Card Information
	
	private By headingCardInformation= By.xpath("//span[text()='Card Information']");

	private By lblCompleted = By.xpath("(//div[text()='Completed'])[1]");

	public void clickCompleted() {
		click(lblCompleted, "View Transaction Details");
	}

	public By getLabelItem(String Type) {
		return By.xpath(String.format(
				"//p[text()='%s']/following-sibling::div[1]/p  | //p[text()='%s']//following-sibling::span | //p[text()='%s']//following-sibling::p",
				Type, Type, Type));// | //p[text()='%s']//following-sibling::span
	}
	public void verifyCardInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(headingCardInformation, "card Information", expHeading);
	}


	public void verifyRecipientInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(headingRecipientInformation, "Recipient Information", expHeading);
	}

	public void verifyBankAccountInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(headingBankAccountInformation, "Bank Account Information", expHeading);
	}

	public void verifyBankInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(headingBankInformation, "Bank Information", expHeading);
	}

	public void verifyCardholderName() {
		ExtentTestManager.setInfoMessageInReport(
				"Cardholder Name  is " + getText(getLabelItem("Cardholder Name"), "Cardholder Name"));
	}
	//// sdfgbfdsdfv

	public void verifyCardNumber() {
		ExtentTestManager
				.setInfoMessageInReport("Card Number  is " + getText(getLabelItem("Card Number"), "Card Number"));
	}

	public void verifyExpirationDate() {
		ExtentTestManager.setInfoMessageInReport(
				"Expiration Date  is " + getText(getLabelItem("Expiration Date"), "Expiration Date"));
	}

	public void verifyProcessorID() {
		ExtentTestManager
				.setInfoMessageInReport("Processor ID" + getText(getLabelItem("Processor ID"), "Processor ID"));
	}

	public void verifyProcessorAuthCode() {
		ExtentTestManager.setInfoMessageInReport(
				"Processor Auth Code is" + getText(getLabelItem("Processor Auth Code"), "Processor Auth Code"));
	}

	public void getRecipientName() {
		ExtentTestManager.setInfoMessageInReport(
				"Recipient Name  is " + getText(getLabelItem("Recipient Name"), "Recipient Name"));
	}

	public void getRecipientEmail() {
		ExtentTestManager.setInfoMessageInReport(
				"Recipient Email  is " + getText(getLabelItem("Recipient Email"), "Recipient Email"));
	}

	public void getRecipientPhoneNumber() {
		ExtentTestManager.setInfoMessageInReport(
				"Recipient PhoneNumber  is " + getText(getLabelItem("Recipient Phone"), "Recipient PhoneNumber"));
	}

	public void getBankName() {
		ExtentTestManager.setInfoMessageInReport("Bank Name  is " + getText(getLabelItem("Bank Name"), "Bank Name"));
	}

	public void getBankAccount() {
		ExtentTestManager
				.setInfoMessageInReport("Bank Account  is " + getText(getLabelItem("Bank Account"), "Bank Account"));
	}

	public void verifyTransactionDetailsHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeadingTransactionDetails, "Transaction Heading", expHeading);
	}

	public void getTransactionType() {
		ExtentTestManager.setInfoMessageInReport(
				"Transaction Type is " + getText(getLabelItem("Transaction Type"), "TransactionType"));
	}

	public void getTransactionSubType() {
		ExtentTestManager.setInfoMessageInReport(
				"Transaction SubType is " + getText(getLabelItem("Transaction Sub-type"), "Transaction SubType"));
	}

	public void getCreatedDate() {
		ExtentTestManager
				.setInfoMessageInReport("Created Date  is " + getText(getLabelItem("Created Date"), "Created Date"));
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount  is " + getText(getLabelItem("Amount Received"), "Amount"));
	}

	public void getgiftCardAmount() {
		ExtentTestManager.setInfoMessageInReport(
				"Gift Card Amount  is " + getText(getLabelItem("Gift Card Amount"), "Gift Card Amount"));
	}

	public void verifyLedgerInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(lblLedgerInformation, "Ledger Information Heading", expHeading);

	}

	public void getReferenceID() {
		ExtentTestManager
				.setInfoMessageInReport("ReferenceID  is " + getText(getLabelItem("Reference ID"), "ReferenceID"));
	}

	public void getCordaID() {
		ExtentTestManager.setInfoMessageInReport("CordaID  is " + getText(getLabelItem("Corda ID"), "CordaID"));
	}

	public void getTransactionIPAddress() {
		ExtentTestManager.setInfoMessageInReport("Transaction IP Address  is "
				+ getText(getLabelItem("Transaction IP Address"), "TransactionIPAddress"));
	}

	public void verifySenderInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSenderInformation, "Sender Information Heading", expHeading);

	}

	public void getSenderName() {
		ExtentTestManager.setInfoMessageInReport("SenderName is " + getText(getLabelItem("Sender Name"), "SenderName"));
	}

	public void getAccountID() {
		ExtentTestManager
				.setInfoMessageInReport("AccountID  is " + getText(getLabelItem("Sender Account ID"), "AccountID"));
	}

	public void getAccountAddress() {
		ExtentTestManager.setInfoMessageInReport(
				"Account Address  is " + getText(getLabelItem("Sender Account Address"), "Sender Account Address"));
	}

	public void getSenderEmail() {
		ExtentTestManager
				.setPassMessageInReport("Sender Email  is " + getText(getLabelItem("Sender Email"), "Sender Email"));
	}

	public void getSenderPhoneNumber() {
		ExtentTestManager.setPassMessageInReport(
				"Sender PhoneNumber  is " + getText(getLabelItem("Sender Phone"), "Sender PhoneNumber"));
	}

	public void getMessageFromSender() {
		ExtentTestManager.setInfoMessageInReport(
				"Message From Sender  is " + getText(lblMessageFromSender, "Message From Sender"));
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

}
