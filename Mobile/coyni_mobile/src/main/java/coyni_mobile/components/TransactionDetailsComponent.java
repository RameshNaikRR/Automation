package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TransactionDetailsComponent extends MobileFunctions {

	private By transactions = MobileBy.xpath("//*[contains(@text,'Transaction Details')]|//*[contains(@resource-id,'headerTV')]");
	private By buyTokenBankTransactions = MobileBy.xpath("//*[contains(@resource-id,'btbankheaderTV')]");
	private By buyTokenDebitTransactions = MobileBy.xpath("//*[contains(@resource-id,'headTV')]");
	private By withdrawBankTransactions = MobileBy.xpath("//*[contains(@resource-id,'withbankheaderTV')]");
	private By withdrawInstantPayTransactions = MobileBy.xpath("//*[contains(@resource-id,'withinheaderTV')]");
	private By withdrawGiftCardTransactions =MobileBy.xpath("//*[contains(@resource-id,'withGiftheadTV')]");
	private By lblStatus = MobileBy.xpath("//*[@text='Status']");
	private By lblDateTime = MobileBy.xpath("//*[@text='Date & Time']");
	private By lblAccountBalance = MobileBy.xpath("//*[@text='Account Balance']");
	private By lblReferenceID = MobileBy.xpath("//*[@text='Reference ID']");
	private By referenceID = MobileBy.xpath("//*[contains(@resource-id,'refidTV')]");
	private By lblUserName = MobileBy.xpath("//*[@text='User Name']");
	private By lblAccountAddress = MobileBy.xpath("//*[@text='Account Address']");
	private By lblProcessingFee = MobileBy.xpath("//*[@text='Processing Fee']");
	private By lblTotalAmount = MobileBy.xpath("//*[@text='Total Amount']");
	private By lblGiftCardName = MobileBy.xpath("//*[@text='Gift Card Name']");
	private By lblSubTotal = MobileBy.xpath("//*[@text='Sub Total']");
	private By lblGrandTotal = MobileBy.xpath("//*[@text='Grand Total']");
	private By lblWithdrawID = MobileBy.xpath("//*[@text='Withdraw ID']");
	private By lblRecipientName = MobileBy.xpath("//*[@text='Recipient Name']");
	private By lblRecipientEmail = MobileBy.xpath("//*[@text='Recipient Email']");
	private By lblWithdrawAmount = MobileBy.xpath("//*[@text='Withdraw Amount']");
	private By lblCardHolderName = MobileBy.xpath("//*[@text='Card Holder Name']");
	private By lblCardNumber = MobileBy.xpath("//*[@text='Card Number']");
	private By lblExpirationDate = MobileBy.xpath("//*[@text='Expiration Date']");
	private By lblPurchaseAmount = MobileBy.xpath("//*[@text='Purchase Amount']");
	private By lblDepositID = MobileBy.xpath("//*[@text='Deposit ID']");
	private By lblDescriptorName = MobileBy.xpath("//*[@text='Descriptor Name']");
	private By lblNameOnAccount = MobileBy.xpath("//*[@text='Name on Account']");
	private By lblBankName = MobileBy.xpath("//*[@text='Bank Name']");
	private By lblBankAccountNumber = MobileBy.xpath("//*[@text='Bank Account #']");

	private By backIconSent = MobileBy.xpath("//*[contains(@resource-id,'lyPRClose')]");
	private By backIconReceive = MobileBy.xpath("//*[contains(@resource-id,'lyPRClose')]");
	private By backIconBuyTokenBank = MobileBy.xpath("//*[contains(@resource-id,'btbankprevious')]");
	private By backIconBuyTokenDebitCard = MobileBy.xpath("//*[contains(@resource-id,'previous')]");
	private By backIconBuyTokenCreditCard = MobileBy.xpath("//*[contains(@resource-id,'previous')]");
	private By backIconWIthdrawInstantPay = MobileBy.xpath("//*[contains(@resource-id,'withInstantprevious')]");
	private By backIconWithdrawBank = MobileBy.xpath("//*[contains(@resource-id,'withbankCloseLL')]");
	private By backIconWithdrawGiftCard = MobileBy.xpath("//*[contains(@resource-id,'withGiftprevious')]");

	public void verifySentTransactionDetails(String transactionHeading) {
		new CommonFunctions().verifyLabelText(transactions, "Transaction Heading", transactionHeading);
		new CommonFunctions().elementView(lblStatus, "Status");
		new CommonFunctions().elementView(lblDateTime, "Date & Time");
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
		new CommonFunctions().elementView(lblTotalAmount, "Total Amount");
		new CommonFunctions().elementView(lblAccountBalance, "Account Balance");
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		new CommonFunctions().elementView(lblUserName, "User Name");
		new CommonFunctions().elementView(lblAccountAddress, "Account Address");
		click(referenceID, "Reference ID");
	}

	public void verifyReceiveTransactionDetails(String transactionHeading) {
		new CommonFunctions().verifyLabelText(transactions, "Transaction Heading", transactionHeading);
		new CommonFunctions().elementView(lblStatus, "Status");
		new CommonFunctions().elementView(lblDateTime, "Date & Time");
		new CommonFunctions().elementView(lblAccountBalance, "Account Balance");
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		new CommonFunctions().elementView(lblUserName, "User Name");
		new CommonFunctions().elementView(lblAccountAddress, "Account Address");
		click(referenceID, "Reference ID");
	}

	public void verifyWithdrawInstantPayTransactionDetails(String transactionHeading) {
		new CommonFunctions().verifyLabelText(withdrawInstantPayTransactions, "Transaction Heading", transactionHeading);
		new CommonFunctions().elementView(lblStatus, "Status");
		new CommonFunctions().elementView(lblDateTime, "Date & Time");
		new CommonFunctions().elementView(lblWithdrawAmount, "Withdraw Amount");
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
		new CommonFunctions().elementView(lblTotalAmount, "Total Amount");
		new CommonFunctions().elementView(lblAccountBalance, "Account Balance");
		new CommonFunctions().elementView(lblWithdrawID, "Withdraw ID");
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		new CommonFunctions().elementView(lblCardHolderName, "Card Holder Name");
		new CommonFunctions().elementView(lblCardNumber, "Card Number");
		new CommonFunctions().elementView(lblExpirationDate, "Expiration Date");
	}

	public void verifyWithdrawGiftCardTransactionDetails(String transactionHeading) {
		new CommonFunctions().verifyLabelText(withdrawGiftCardTransactions, "Transaction Heading", transactionHeading);
		new CommonFunctions().elementView(lblStatus, "Status");
		new CommonFunctions().elementView(lblDateTime, "Date & Time");
		new CommonFunctions().elementView(lblGiftCardName, "Gift Card Name");
		new CommonFunctions().elementView(lblSubTotal, "Sub Total");
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
		new CommonFunctions().elementView(lblGrandTotal, "Grand Total ");
		new CommonFunctions().elementView(lblWithdrawID, "Withdraw ID");
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		new CommonFunctions().elementView(lblRecipientName, "Recipient Name");
		new CommonFunctions().elementView(lblRecipientEmail, "Recipient Email");
	}

	public void verifyWithdrawBankTransactionDetails(String transactionHeading) {
		new CommonFunctions().verifyLabelText(withdrawBankTransactions, "Transaction Heading", transactionHeading);
		new CommonFunctions().elementView(lblStatus, "Status");
		new CommonFunctions().elementView(lblDateTime, "Date & Time");
		new CommonFunctions().elementView(lblWithdrawAmount, "Withdraw Amount");
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
		new CommonFunctions().elementView(lblTotalAmount, "Total Amount");
		new CommonFunctions().elementView(lblAccountBalance, "Account Balance");
		new CommonFunctions().elementView(lblWithdrawID, "Withdraw ID");
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		new CommonFunctions().elementView(lblNameOnAccount, "Name On Account");
		new CommonFunctions().elementView(lblBankName, "Bank Name");
		new CommonFunctions().elementView(lblBankAccountNumber, "Bank Account Number");
	}

	public void verifyBuyTokenBankTransactionDetails(String transactionHeading) {
		new CommonFunctions().verifyLabelText(buyTokenBankTransactions, "Transaction Heading", transactionHeading);
		new CommonFunctions().elementView(lblStatus, "Status");
		new CommonFunctions().elementView(lblDateTime, "Date & Time");
		new CommonFunctions().elementView(lblPurchaseAmount, "Purchase Amount");
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
		new CommonFunctions().elementView(lblTotalAmount, "Total Amount");
		new CommonFunctions().elementView(lblDepositID, "Deposit ID");
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		new CommonFunctions().elementView(lblDescriptorName, "Descriptor Name");
		new CommonFunctions().elementView(lblNameOnAccount, "Name On Account");
		new CommonFunctions().elementView(lblBankName, "Bank Name");
		new CommonFunctions().elementView(lblBankAccountNumber, "Bank Account Number");
	}

	public void verifyBuyTokenDebitCardTransactionDetails(String transactionHeading) {
		new CommonFunctions().verifyLabelText(buyTokenDebitTransactions, "Transaction Heading", transactionHeading);
		new CommonFunctions().elementView(lblStatus, "Status");
		new CommonFunctions().elementView(lblDateTime, "Date & Time");
		new CommonFunctions().elementView(lblPurchaseAmount, "Purchase Amount");
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
		new CommonFunctions().elementView(lblTotalAmount, "Total Amount");
		new CommonFunctions().elementView(lblAccountBalance, "Account Balance");
		new CommonFunctions().elementView(lblDepositID, "Deposit ID");
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		new CommonFunctions().elementView(lblDescriptorName, "Descriptor Name");
		new CommonFunctions().elementView(lblCardHolderName, "Card Holder Name");
		new CommonFunctions().elementView(lblCardNumber, "Card Number");
		new CommonFunctions().elementView(lblExpirationDate, "Expiration Date");
		click(referenceID, "Reference ID");
	}

	public void verifyBuyTokenCreditCardTransactionDetails(String transactionHeading) {
		new CommonFunctions().verifyLabelText(buyTokenDebitTransactions, "Transaction Heading", transactionHeading);
		new CommonFunctions().elementView(lblStatus, "Status");
		new CommonFunctions().elementView(lblDateTime, "Date & Time");
		new CommonFunctions().elementView(lblPurchaseAmount, "Purchase Amount");
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
		new CommonFunctions().elementView(lblTotalAmount, "Total Amount");
		new CommonFunctions().elementView(lblAccountBalance, "Account Balance");
		new CommonFunctions().elementView(lblDepositID, "Deposit ID");
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		new CommonFunctions().elementView(lblDescriptorName, "Descriptor Name");
		new CommonFunctions().elementView(lblCardHolderName, "Card Holder Name");
		new CommonFunctions().elementView(lblCardNumber, "Card Number");
		new CommonFunctions().elementView(lblExpirationDate, "Expiration Date");
		click(referenceID, "Reference ID");
	}

	public void clickSentBackIcon() {
		click(backIconSent, "Sent Back Icon");
	}

	public void clickReceiveBackIcon() {
		click(backIconReceive, "Receive Back Icon");
	}

	public void clickBuyTokenBankBackIcon() {
		click(backIconBuyTokenBank, "Buy Token Bank Back Icon");
	}

	public void clickBuyTokenDebitBackIcon() {
		click(backIconBuyTokenDebitCard, "Buy Token Debit Back Icon");
	}

	public void clickBuyTokenCreditBackIcon() {
		click(backIconBuyTokenCreditCard, "Buy Token Credit Back Icon");
	}

	public void clickWithdrawBankBackIcon() {
		click(backIconWithdrawBank, "Withdraw Bank Back Icon");
	}

	public void clickWithdrawInstantPayBackIcon() {
		click(backIconWIthdrawInstantPay, "Withdraw Instant Pay Back Icon");
	}

	public void clickWithdrawGiftCardBackIcon() {
		click(backIconWithdrawGiftCard, "Withdraw Instant Pay Back Icon");
	}
}
