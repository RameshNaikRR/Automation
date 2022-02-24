package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionDetailsComponent extends BrowserFunctions {

	private By lblHeadingTransactionDetails = By.cssSelector(".text ");

	private By lblLedgerInformation = By.xpath("//span[text()='Ledger Information']");

	private By lblSenderInformation = By.xpath("//span[text()='Sender Information']");

	private By lblMessageFromSender = By.xpath("");

	private By headingRecipientInformation = By.xpath("//span[text()='Recipient Information']");

	public By getLabelItem(String Type) {
		return By.xpath(String.format(
				"//p[text()='%s']/following-sibling::div[1]/p | //p[text()='%s']//following-sibling::span", Type));
	}

	public void verifyRecipientInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(headingRecipientInformation, "Recipient Information", expHeading);
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
		ExtentTestManager.setInfoMessageInReport("Recipient PhoneNumber  is "
				+ getText(getLabelItem("Recipient Phone Number"), "Recipient PhoneNumber"));
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
				"Transaction SubType is " + getText(getLabelItem("Transaction Sub Type"), "Transaction SubType"));
	}

	public void getCreatedDate() {
		ExtentTestManager
				.setInfoMessageInReport("Created Date  is " + getText(getLabelItem("Date / Time"), "Created Date"));
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount  is " + getText(getLabelItem("Amount Received"), "Amount"));
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
		ExtentTestManager.setInfoMessageInReport("AccountID  is " + getText(getLabelItem("Account ID"), "AccountID"));
	}

	public void getAccountAddress() {
		ExtentTestManager.setInfoMessageInReport(
				"Account Address  is " + getText(getLabelItem("Account Address"), "AccountAddress"));
	}

	public void getSenderEmail() {
		ExtentTestManager
				.setPassMessageInReport("Sender Email  is " + getText(getLabelItem("Sender Email"), "Sender Email"));
	}

	public void getSenderPhoneNumber() {
		ExtentTestManager.setPassMessageInReport(
				"Sender PhoneNumber  is " + getText(getLabelItem("Sender Phone Number"), "Sender PhoneNumber"));
	}

	public void getMessageFromSender() {
		ExtentTestManager.setInfoMessageInReport(
				"Message From Sender  is " + getText(lblMessageFromSender, "Message From Sender"));
	}

}
