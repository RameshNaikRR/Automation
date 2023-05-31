package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class TransactionDetailsComponent2 extends MobileFunctions {

	private By lblTransactionsHeading = MobileBy.xpath("//*[contains(@text,'Transaction Details')]");
	private By lblTransactions = MobileBy.xpath("//*[contains(@resource-id,'head')]|//*[contains(@resource-id,'withBankHeaderTV')]");
	private By lblTransactionAmount = MobileBy
			.xpath("//*[contains(@resource-id,'amountTV')]|//*[contains(@resource-id,'tvAmount')]|//*[contains(@resource-id,'withdrawGiftamount')]|//*[contains(@resource-id,'withBankAmount')]");
	private By lblStatus = MobileBy.xpath("//*[@text='Status']/following-sibling::*");
	private By lblDateTime = MobileBy.xpath("//*[@text='Date & Time']/following-sibling::*");
	private By lblProcessingFee = MobileBy.xpath("//*[@text='Processing Fee']/following-sibling::*");
	private By lblPurchaseAmount = MobileBy.xpath("//*[@text='Purchase Amount']/following-sibling::*");
	private By lblDepositID = MobileBy.xpath("//*[@text='Deposit ID']/following-sibling::*");
	private By lblTotalAmount = MobileBy.xpath("//*[@text='Total Amount']/../following-sibling::*");
	private By lblAccountBalance = MobileBy.xpath("//*[@text='Account Balance']/following-sibling::*");
	private By lblReferenceID = MobileBy.xpath("//*[@text='Reference ID']/following-sibling::*[1]/android.widget.TextView");
	private By lblUserName = MobileBy.xpath("//*[@text='User Name']/following-sibling::*");
	private By lblAccountAddress = MobileBy.xpath("//*[@text='Account Address']/following-sibling::*");
	private By lblGiftCardName = MobileBy.xpath("//*[@text='Gift Card Name']/following-sibling::*");
	private By lblGrandTotal = MobileBy.xpath("//*[@text='Grand Total']/following-sibling::*[1]");
	private By lblSubTotal = MobileBy.xpath("//*[@text='Sub Total']/following-sibling::*[1]");
	private By lblWithdrawGiftProcessingFee = MobileBy.xpath("//*[@text='Processing Fee']/following-sibling::*[1]");
	private By lblWithdrawID = MobileBy.xpath("//*[@text='Withdraw ID']/following-sibling::*|//*[@text='Withdraw ID']/following-sibling::*/android.widget.TextView");
	private By lblRecipentName = MobileBy.xpath("//*[@text='Recipient Name']/following-sibling::*");
	private By lblRecipentEmail = MobileBy.xpath("//*[@text='Recipient Email']/following-sibling::*");
	private By lblInstantPayAmount = MobileBy.xpath("//*[contains(@resource-id,'withinamount')]");
	private By lblWithdrawInstantPayAmount = MobileBy.xpath("//*[@text='Withdraw Amount']/following-sibling::*");
	private By lblCardHolderName = MobileBy.xpath("//*[@text='Card Holder Name']/following-sibling::*");
	private By lblCardNumber = MobileBy.xpath("//*[@text='Card Number']/following-sibling::*[2]");
	// private By lblBuyTokensCardPurchaseAmount = MobileBy.xpath(""); unable to locate
	private By lblBuyTokenCardDepositID = MobileBy.xpath("//*[@text='Deposit ID']/following-sibling::*[1]/android.widget.TextView");
	private By lblBuyTokenCardDescriptorName = MobileBy.xpath("//*[@text='Descriptor Name']/following-sibling::*");
	private By lblExpirationDate = MobileBy.xpath("//*[@text='Expiration Date']/following-sibling::*");
	private By lblNameOnAccount = MobileBy.xpath("//*[@text='Name on Account']/following-sibling::*");
	private By lblBankName = MobileBy.xpath("//*[@text='Bank Name']/following-sibling::*");
	private By lblBankAccount = MobileBy.xpath("//*[@text='Bank Account #']/following-sibling::*");
	private By lblCancelTransaction = MobileBy.xpath("//*[contains(@resource-id,'cvCancelWB')]|//*[@text='Cancel Transaction']");
	private By lblCancelHeading = MobileBy.xpath("//*[@text='Cancel Transaction?']");
	private By btnYes = MobileBy.xpath("//*[contains(@resource-id,'tvYes')]");
	private By btnNo = MobileBy.xpath("//*[contains(@resource-id,'tvNo')]");
	private By lblWithdrawAmount = MobileBy.xpath("//*[@text='Withdraw Amount']/following-sibling::*[1]");
	public void getTransactionHeading() {
		ExtentTestManager.setInfoMessageInReport("Transaction Heading: " + getText(lblTransactionsHeading));
	}

	public void getTransactions() {
		ExtentTestManager.setInfoMessageInReport("Transactions: " + getText(lblTransactions));
	}

	public void getTransactionAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblTransactionAmount));
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblStatus));
	}

	public void getDateTime() {
		ExtentTestManager.setInfoMessageInReport("Date&Time: " + getText(lblDateTime));
	}

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee: " + getText(lblProcessingFee));
	}
	public void getPurchaseAmount() {
		ExtentTestManager.setInfoMessageInReport("Purchase Amount: " + getText(lblPurchaseAmount));
	}
	public void getDepositID() {
		ExtentTestManager.setInfoMessageInReport("Deposit ID: " + getText(lblDepositID));
	}
	public void getNameOnBank() {
		ExtentTestManager.setInfoMessageInReport("Name on Account: " + getText(lblNameOnAccount));
	}
	public void getBankName() {
		ExtentTestManager.setInfoMessageInReport("Bank Name: " + getText(lblBankName));
	}
	public void getBankAccount() {
		ExtentTestManager.setInfoMessageInReport("Bank Account: " + getText(lblBankAccount));
	}
	public void getCancelTransaction() {
		ExtentTestManager.setInfoMessageInReport("Cancel Transaction: " + getText(lblCancelTransaction));
	}
	public int getNoSize() {
		getElementList(btnNo, "No").size();
		return 0;
	}
	public void clickCancelTransaction() {
		//new CommonFunctions().elementEnabled(lblCancelTransaction, "Enabled");
		//if(getElement(lblCancelTransaction, "Cancel").isEnabled()) {
		click(lblCancelTransaction, "Cancel Transaction");
//		ExtentTestManager.setInfoMessageInReport("Heading is: " + getText(lblCancelHeading));
		if(getNoSize()==1) {
		click(btnNo, "No");
		click(lblCancelTransaction, "Cancel Transaction");
		click(btnYes, "Yes");
		scrollUpToElement(lblStatus, "Status");
		getStatus();
		}else {
		ExtentTestManager.setInfoMessageInReport("Cancel Transaction button is Disabled");
		}
		}
	public void getTotalAmount() {
		ExtentTestManager.setInfoMessageInReport("Total Amount: " + getText(lblTotalAmount));
	}
	public void getWithdrawAmount() {
		ExtentTestManager.setInfoMessageInReport("Withdraw Amount: " + getText(lblWithdrawAmount));
	}
	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport("Account Balance: " + getText(lblAccountBalance));
	}

	public void getReferenceID() {
		ExtentTestManager.setInfoMessageInReport("Reference ID: " + getText(lblReferenceID));
		click(lblReferenceID, "Copied Reference ID");
	}
	public String verifyTransactionReferenceID() {
		String str = getText(lblReferenceID);
		return str;
	}

	public void getUserName() {
		ExtentTestManager.setInfoMessageInReport("User Name: " + getText(lblUserName));
	}

	public void getAccountAddress() {
		ExtentTestManager.setInfoMessageInReport("Account Addresss: " + getText(lblAccountAddress));
	}

	public void getGiftCardName() {
		ExtentTestManager.setInfoMessageInReport("Gift Card Name: " + getText(lblGiftCardName));
	}

	public void getGrandTotal() {
		ExtentTestManager.setInfoMessageInReport("Grand Total: " + getText(lblGrandTotal));
	}

	public void getSubTotal() {
		ExtentTestManager.setInfoMessageInReport("Sub Total: " + getText(lblSubTotal));
	}

	public void getWithdrawID() {
		ExtentTestManager.setInfoMessageInReport("Withdraw ID: " + getText(lblWithdrawID));
	}

	public void getRecipientName() {
		ExtentTestManager.setInfoMessageInReport("Recipient Name: " + getText(lblRecipentName));
	}

	public void getRecipientEmail() {
		ExtentTestManager.setInfoMessageInReport("Recipient Email: " + getText(lblRecipentEmail));
	}

	public void getWithdrawGiftCardProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Gift Card Processing Fee: " + getText(lblWithdrawGiftProcessingFee));
	}

	public void getInstantPayAmount() {
		ExtentTestManager.setInfoMessageInReport("Instant Pay Amount: " + getText(lblInstantPayAmount));
	}

	public void getWithdrawInstantPayAmount() {
		ExtentTestManager
				.setInfoMessageInReport("Instant Pay Withdraw Amount: " + getText(lblWithdrawInstantPayAmount));
	}

	public void getCardHolderName() {
		ExtentTestManager.setInfoMessageInReport("Instant Pay Card Holder Name: " + getText(lblCardHolderName));
	}

	public void getCardNumber() {
		ExtentTestManager.setInfoMessageInReport("Instant Pay Card Number: " + getText(lblCardNumber));
	}

	public void getBuyTokenCardDepositID() {
		ExtentTestManager.setInfoMessageInReport("Buy Token Deposit ID: " + getText(lblBuyTokenCardDepositID));
	}

	public void getBuyTokenCardDescriptorName() {
		ExtentTestManager
				.setInfoMessageInReport("Buy Token Descriptor Name: " + getText(lblBuyTokenCardDescriptorName));
	}

	public void getExpirationDate() {
		ExtentTestManager.setInfoMessageInReport("Expiration Date: " + getText(lblExpirationDate));
	}
 //sent transaction details
	public void getSentTransactionDetails() {
		getTransactionHeading();
		getTransactions();
		getTransactionAmount();
		getStatus();
		getDateTime();
		getWithdrawGiftCardProcessingFee();
		getTotalAmount();
		getAccountBalance();
		getReferenceID();
		getUserName();
		getAccountAddress();
	}
	public String verifyPayTotalAmount() {
		String amount = getText(lblTotalAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		return amount;
	}
//withdrawgiftcard
	public void getWithdrawGiftcardTransactionDetails() {
		getTransactionHeading();
		getTransactions();
		getTransactionAmount();
		getStatus();
		getDateTime();
		getGiftCardName();
		getSubTotal();
		getProcessingFee();
		getGrandTotal();
		getWithdrawID();
		getReferenceID();
		getRecipientName();
		getRecipientEmail();
	}
//withdrawinstantpay
	public void getWithdrawInstantPayDetails() {
		getTransactionHeading();
		getTransactions();
		getInstantPayAmount();
		getStatus();
		getDateTime();
		getWithdrawInstantPayAmount();
		getProcessingFee();
		getTotalAmount();
		getAccountBalance();
		getWithdrawID();
		getReferenceID();
		getCardHolderName();
		getCardNumber();
	}
	public String verifyWithdrawTotalAmount() {
		String amount = getText(lblTotalAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		return amount;
	}
//buytokenscard
////buytokenscard	
	public void getBuyTokenDebitCardDetails() throws InterruptedException {
		getTransactionHeading();
		getTransactions();
		getTransactionAmount();
		getStatus();
		getDateTime();
		// Purchase Amount//
		getProcessingFee();
		getTotalAmount();
		getAccountBalance();
		getBuyTokenCardDepositID();
		Thread.sleep(1000);
		getReferenceID();
		Thread.sleep(1000);
		getBuyTokenCardDescriptorName();
		getCardHolderName();
		getCardNumber();
		Thread.sleep(2000);
		scrollDownToElement(lblExpirationDate, "Expiration date");
		getExpirationDate();
	}
	
//buytokencredit
	public void getBuyTokenCreditCardDetails() {
		getTransactionHeading();
		getTransactions();
		getTransactionAmount();
		getStatus();
		getDateTime();
		getPurchaseAmount();
		getProcessingFee();
		getTotalAmount();
		getAccountBalance();
		getBuyTokenCardDepositID();
		getReferenceID();
		getBuyTokenCardDescriptorName();
		getCardHolderName();
		getCardNumber();
		getExpirationDate();
	}
	//Buy token bank account
	public void getBuyTokenBankAccountDetails() throws InterruptedException {
		getTransactionHeading();
		getTransactions();
		getTransactionAmount();
		getStatus();
		getDateTime();
		getProcessingFee();
		getPurchaseAmount();
		getTotalAmount();
		getDepositID();
		getReferenceID();
		getBuyTokenCardDescriptorName();
		getNameOnBank();
		Thread.sleep(1000);
		scrollDownToElement(lblBankAccount, "Bank Account");
		getBankAccount();
		getBankName();
		scrollDownToElement(lblCancelTransaction, "Cancel Transaction");
		//getCancelTransaction();
		clickCancelTransaction();
		
	}
	//withdraw to bank
	public void getWithdrawTokenBankAccountDetails() throws InterruptedException {
		getTransactionHeading();
		getTransactions();
		getTransactionAmount();
		getStatus();
		getDateTime();
		getWithdrawAmount();
		getProcessingFee();
		getAccountBalance();
		getTotalAmount();	
	//	getDepositID();
		getReferenceID();
	//	getBuyTokenCardDescriptorName();
		getNameOnBank();
		Thread.sleep(1000);
		scrollDownToElement(lblBankAccount, "Bank Account");
		getBankAccount();
		getBankName();
		scrollDownToElement(lblCancelTransaction, "Cancel Transaction");
		//getCancelTransaction();
		clickCancelTransaction();
		
	}
//received transaction
	public void getReceivedTransactionDetails() {
		getTransactionHeading();
		getTransactions();
		getTransactionAmount();
		getStatus();
		getDateTime();
		getAccountBalance();
		getReferenceID();
		getUserName();
		getAccountAddress();
	}
	
//	public void getWithdrawTransactiondetails() {
//		
//	}
	
	public void getTransactionDetails() throws InterruptedException {
	if(getText(lblTransactions).contains("Sent")) {
		    getSentTransactionDetails();
	}else if(getText(lblTransactions).contains("Received")){
		getReceivedTransactionDetails();
	}else if(getText(lblTransactions).contains("Withdraw")&& (getText(lblTransactions).contains("Instant Pay"))) {
		getWithdrawInstantPayDetails();
	} 
	else if(getText(lblTransactions).contains("Buy")&&(getText(lblTransactions).contains("Debit"))){
	getBuyTokenDebitCardDetails();
	}
	else if(getText(lblTransactions).contains("Buy") && (getText(lblTransactions).contains("Credit"))){
		getBuyTokenCreditCardDetails();
	}
	else if(getText(lblTransactions).contains("Withdraw")&& (getText(lblTransactions).contains("Gift Card"))){
		getWithdrawGiftcardTransactionDetails();
	}
	else if(getText(lblTransactions).contains("Buy")&& (getText(lblTransactions).contains("Bank Account"))){
		getBuyTokenBankAccountDetails();
	}
	}
}

