package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class TransactionsDetailsComponent extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Transaction Details']");
	private By lblTransactionType = MobileBy.xpath("//*[@text='Status']/parent::*/preceding-sibling::*[1]");
	private By lblTransactionTypeAmount = MobileBy.xpath("//*[@text='Status']/parent::*/preceding-sibling::*[2]");
	private By lblStatus = MobileBy.xpath("//*[@text='Status']/following-sibling::*[1]");
	private By lblDateAndTime = MobileBy.xpath("//*[@text='Date']/following-sibling::*[1]");
	private By lblPurchaseAmount = MobileBy.id("");
	private By lblProcessingFee = MobileBy.id("");
	private By lblTotalAmount = MobileBy.id("");
	private By lblReferenceID = MobileBy.xpath("//*[@text='Reference ID']/following-sibling::*[1]");
	private By lblDepositNumber = MobileBy.id("");
	// card
	private By lblCardHolderName = MobileBy.id("");
	private By varCardHolderName = MobileBy.id("");
	private By lblCardBrand = MobileBy.id("");
	private By lblCardNumber = MobileBy.id("");
	private By lblExpirationDate = MobileBy.id("");
	private By lblActivityLog = MobileBy.id("");
	// BAnk Account
	private By lblNameonBank = MobileBy.id("");
	private By varNameonBank = MobileBy.id("");
	private By lblBankName = MobileBy.id("");
	private By lblBankAccountNumber = MobileBy.id("");
	private By btnCancel = MobileBy.xpath("(//*[@name='Cancel Transaction'])[1]");
	private By btnBack = MobileBy.AccessibilityId("Back");
	
	// withdraw Instant

	private By lblMsg = MobileBy.id("com.coyni.mapp:id/sentReasonTV");
	private By lblWithdrawlAmount = MobileBy.id("");
	private By lblWithdrawNumber = MobileBy.id("");

	// Gift Card

	private By lblGiftCardName = MobileBy.id("");
	private By lblGiftCardAmount = MobileBy.id("");
	private By lblReciepentName = MobileBy.xpath("//*[@text='Recipient Name']/following-sibling::*[1]");
	private By lblReciepentEmail = MobileBy.id("");

//	Sent Details 
	private By lblSubTotal = MobileBy.xpath("//*[@text='Sub Total']/following-sibling::*[1]");

	private By lblGrandTotal = MobileBy.xpath("//*[@text='Grand Total']/following-sibling::*[1]");
	private By lblWithdrawID = MobileBy.xpath("//*[@text='Withdraw ID']/following-sibling::*[1]");

	private By lblRecipientName = MobileBy.xpath(
			"//*[@text='Sender Name']/following-sibling::*[1]|//*[@text='Recipient Name']/following-sibling::*[1]");
	private By lblRecipientEmail = MobileBy.xpath("//*[@text='Recipient Email']/following-sibling::*[1]");

	private By lblTotalAmount1 = MobileBy.xpath("");

	private By lblAccountBalance = MobileBy.xpath("//*[@text='Account Balance']/following-sibling::*[1]");
	private By lblDepositID = MobileBy.xpath("//*[@text='Deposit ID']/following-sibling::*[1]");

	private By lblExpiryDate = MobileBy.xpath("//*[@text='Expiration Date']/following-sibling::*[1]");

	private By lblNameOnAccount = MobileBy.xpath("//*[@text='Name on Account']/following-sibling::*[1]");

	private By lblUserName = MobileBy.xpath("//*[@text='User Name']/following-sibling::*[1]");
	private By lblAccountAddress = MobileBy.xpath("//*[@text='Account Address']/following-sibling::*[1]");

	private By lblCnacelTransaction = MobileBy.AccessibilityId("Cancel Transaction?");
	private By btnNo = MobileBy.xpath("(//*[@text='NO'])[1]");
	private By btnYes = MobileBy.xpath("(//*[@text='Yes'])[1]");

	private By lblMerchantAccountId = MobileBy.xpath("//*[@text='Merchant Account ID']/following-sibling::*[1]");
	private By lblDBAname = MobileBy.xpath("//*[@text='DBA Name']/following-sibling::*[1]");
	private By lblCustServiceEmail = MobileBy.xpath("//*[@text='Customer Service Email']/following-sibling::*[1]");
	private By lblCustServicePhone = MobileBy.xpath("//*[@text='Customer Service Phone']/following-sibling::*[1]");

	public String verifyfillMessage() {
		String str = getText(lblMsg).trim().replace('"', ' ');
		return str;
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public void getTransaction(String expText) {
		new CommonFunctions().verifyLabelText(lblTransactionType, "Transaction Type", expText);
	}

	public void getTransactionAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblTransactionTypeAmount));
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblStatus));
	}

	public void getDateTime() {
		ExtentTestManager.setInfoMessageInReport("Date & Time: " + getText(lblDateAndTime));
	}

	public String verifyPurchaseAmount() {
		String str = getText(lblPurchaseAmount).trim().replace(" ", "").replace("USD", "").replace("$", "")
				.replace("CYN", "");
		return str;
	}

	public String verifyGiftCardAmount() {
		String str = getText(lblGiftCardAmount).trim().replace(" ", "").replace("USD", "").replace("$", "")
				.replace("CYN", "");
		return str;
	}

	public String verifyWithdrawAmount() {
		String str = getText(lblWithdrawlAmount).trim().replace(" ", "").replace("USD", "").replace("$", "")
				.replace("CYN", "");
		return str;
	}

	public String verifyProcessingFee() {
		String str = getText(lblProcessingFee).trim().replace(" ", "").replace("USD", "").replace("$", "")
				.replace("CYN", "");
		return str;
	}

	public String verifyTotalAmount() {
		String str = getText(lblTotalAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN",
				"");
		;
		return str;
	}

	public void getReferenceID() {
		ExtentTestManager.setInfoMessageInReport("Reference ID: " + getText(lblReferenceID));
	}

	public void getDepositNumber() {
		ExtentTestManager.setInfoMessageInReport("Deposit Number: " + getText(lblDepositNumber));
	}

	public void getCardHolderName() {
		ExtentTestManager.setInfoMessageInReport("CardHolderName: " + getText(lblCardHolderName));
	}

	public void getCardBrand() {
		ExtentTestManager.setInfoMessageInReport("CardBrand: " + getText(lblCardBrand));
	}

	public void getCardNumber() {
		ExtentTestManager.setInfoMessageInReport("CardNumber: " + getText(lblCardNumber));
	}

	public void getExpiryDate() {
		scrollDownToElement(lblExpiryDate, "Expiry Date");
		ExtentTestManager.setInfoMessageInReport("Expiration Date: " + getText(lblExpiryDate));
	}

	public void getNameOnBank() {
		ExtentTestManager.setInfoMessageInReport("Name on Account: " + getText(lblNameOnAccount));
	}

	public void getBankName() {
		ExtentTestManager.setInfoMessageInReport("Bank Name: " + getText(lblBankName));
	}

	public void getBankAccountNumber() {
		scrollDownToElement(lblBankAccountNumber, "Bank Account Number");
		ExtentTestManager.setInfoMessageInReport("Bank Account Number: " + getText(lblBankAccountNumber));
	}

	public void getSentRequestMessage() {
		if (getElementList(lblMsg, "").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Message: " + getText(lblMsg));
		}
	}

	public void getWithdrawNumber() {
		ExtentTestManager.setInfoMessageInReport("Withdraw Number: " + getText(lblWithdrawNumber));
	}

	public void getGiftCardName() {
		ExtentTestManager.setInfoMessageInReport("Gift Card Name: " + getText(lblGiftCardName));
	}

	public String verifyGiftCardNAme() {
		String str = getText(lblGiftCardName).trim().replace('"', ' ');
		return str;
	}

	public void getGiftCardAmount() {
		ExtentTestManager.setInfoMessageInReport("Gift Card Amount: " + getText(lblGiftCardAmount));
	}

	public void getRecipientName(String name, String amount) {
//		double Transamt = Double.parseDouble(getText(lblTransactionTypeAmount));
//		&& Transamt == Double.parseDouble(amount)
		System.out.println(amount);
		System.out.println(getText(lblRecipientName));
		if (getText(lblRecipientName).equals(name)) {
			ExtentTestManager.setPassMessageInReport(
					"The Recent Transaction is Reflected and Recipient Name : " + getText(lblRecipientName));
		} else {
			ExtentTestManager
					.setFailMessageInReport("The Recent Transaction is not Reflected and Recipient Name is wrong : "
							+ getText(lblRecipientName));
		}
	}

	public void getRecipientEmail() {
		ExtentTestManager.setInfoMessageInReport("Recipient Email: " + getText(lblRecipientEmail));
	}

	public void clickCancel() throws InterruptedException {
		if (getElement(btnCancel, "CnacelTransaction").isEnabled()) {
			click(btnCancel, "Cancel Transaction");
			ExtentTestManager.setInfoMessageInReport("Cancel Transaction button is enabled");
			new CommonFunctions().elementView(lblCnacelTransaction, "Cnacel Transaction Heading");
			click(btnNo, "No");
			click(btnCancel, "Cancel Transaction");
			click(btnYes, "Yes");
			Thread.sleep(1000);
			getStatus();
		} else {
			ExtentTestManager.setInfoMessageInReport("Cancel Transaction button is disabled");
		}

	}

	public void buyTokenBankTransactionDetails(String expText) throws InterruptedException {
		getTransaction(expText);
		getTransactionAmount();
		getStatus();
		getDateTime();
		getReferenceID();
		getDepositNumber();
		getNameOnBank();
		getBankName();
		getBankAccountNumber();
		clickCancel();
	}

	public void buyTokenCardTransactionDetails(String expText) {
		getTransaction(expText);
		getTransactionAmount();
		getStatus();
		getDateTime();
		getReferenceID();
		getDepositNumber();
		getCardHolderName();
		getCardNumber();
		getCardBrand();
		getExpiryDate();
	}

	public void withdrawBankTransactionDetails(String expText) throws InterruptedException {
		getTransaction(expText);
		getStatus();
		getDateTime();
		getReferenceID();
		getWithdrawNumber();
		getNameOnBank();
		getBankName();
		getBankAccountNumber();
	}

	public void withdrawInstantTransactionsDetails(String expText) {
		getTransaction(expText);
		getStatus();
		getDateTime();
		getReferenceID();
		getWithdrawNumber();
		getCardHolderName();
		getCardBrand();
		getCardNumber();
		getExpiryDate();
	}

	public void withdrawGiftCardTransactionsDetails(String name, String amount, String expText) {
		getTransaction(expText);
		getStatus();
		getDateTime();
		getGiftCardName();
		getReferenceID();
		getWithdrawNumber();
		getRecipientEmail();
		getRecipientName(name, amount);
	}

	public void getTransactionDetails(String name, String amount, String expText) throws InterruptedException {
		if (getText(lblTransactionType).contains("Buy")) {
			if (getText(varNameonBank).contains("Name")) {
				buyTokenBankTransactionDetails(expText);
			} else if (getText(varCardHolderName).contains("Cardholder")) {
				buyTokenCardTransactionDetails(expText);
			}
		} else if (getText(lblTransactionType).contains("Received")) {
			receivedTransactionDetails(name, amount, expText);
		} else if (getText(lblTransactionType).contains("Sent")) {
			sentTransactionDetails(name, amount, expText);
		} else if (getText(lblTransactionType).contains("Withdraw") && getText(varNameonBank).contains("Name")) {
			withdrawBankTransactionDetails(expText);
		} else if (getText(lblTransactionType).contains("Withdraw")
				&& getText(lblTransactionType).contains("Instant")) {
			withdrawInstantTransactionsDetails(expText);
		} else if (getText(lblTransactionType).contains("Withdraw") && getText(lblGiftCardName).contains("Gift")) {
			withdrawGiftCardTransactionsDetails(name, amount, expText);
		} else if (getText(lblTransactionType).contains("Paid Order")
				&& getText(lblTransactionType).contains("Token")) {
			paidOrderDetails(expText);
		} else if (getText(lblTransactionType).contains("Pay/Request")
				&& getText(lblTransactionType).contains("Sent")) {
			sentTransactionDetails(name, amount, expText);
		} else {
			ExtentTestManager.setFailMessageInReport("Error in Transactions");
		}

	}

//	public int verifyTransactionAmount() {
//		String str = getText(lblTransactionTypeAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
//		Integer amt=Integer.parseInt(str);
//		return amt;
//	}
//	

//	private By lblDescriptorName = MobileBy.id("");

	public void getDBAname() {
		ExtentTestManager.setInfoMessageInReport("DBA Name: " + getText(lblDBAname));
	}

	public void getCustServiceEmail() {
		ExtentTestManager.setInfoMessageInReport("Cust Service Email: " + getText(lblCustServiceEmail));
	}

	public void getCustServicePhone() {
		ExtentTestManager.setInfoMessageInReport("Cust Service Phone: " + getText(lblCustServicePhone));
	}

	public void getMerchantID() {
		ExtentTestManager.setInfoMessageInReport("Merchant Id: " + getText(lblMerchantAccountId));
	}

	public void getSubTotal() {
		ExtentTestManager.setInfoMessageInReport("Sub Total: " + getText(lblSubTotal));
	}

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee: " + getText(lblProcessingFee));
	}

	public void getGrandTotal() {
		ExtentTestManager.setInfoMessageInReport("Grand Total: " + getText(lblGrandTotal));
	}

	public void getWithdrawID() {
		ExtentTestManager.setInfoMessageInReport("Withdraw ID: " + getText(lblWithdrawID));
	}

	public void getPurchaseAmount() {
		ExtentTestManager.setInfoMessageInReport("Purchase Amount: " + getText(lblPurchaseAmount));
	}

	public void getTotalAmount() {
		ExtentTestManager.setInfoMessageInReport("Total Amount:	 " + getText(lblTotalAmount));
	}

	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport("Account Balance: " + getText(lblAccountBalance));
	}

	public void getDepositID() {
		ExtentTestManager.setInfoMessageInReport("Deposit ID: " + getText(lblDepositID));
	}

	public void getUserName() {
		ExtentTestManager.setInfoMessageInReport("UserName: " + getText(lblUserName));
	}

	public void getAccountAddress() {
		ExtentTestManager.setInfoMessageInReport("Account Address: " + getText(lblAccountAddress));
	}

	public void verifyTransactionDetailsHeadingView() {
		new CommonFunctions().elementView(lblHeading, "Heading");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}
	
	public void paidOrderDetails(String expText) {
		getTransaction(expText);
		getTransactionAmount();
		getStatus();
		getDateTime();
		getAccountBalance();
		getReferenceID();
		getMerchantID();
		getDBAname();
		getCustServiceEmail();
		getCustServicePhone();

	}

	public void sentTransactionDetails(String name, String amount, String expText) {
		getRecipientName(name, amount);
		getTransaction(expText);
		getTransactionAmount();
		getSentRequestMessage();
		getStatus();
		getDateTime();
		getReferenceID();
		getAccountAddress();
	}

	public void receivedTransactionDetails(String name, String amount, String expText) {
//		getRecipientName(name, amount);
		getTransaction(expText);
		getTransactionAmount();
		getSentRequestMessage();
		getStatus();
		getDateTime();
		getReferenceID();
		getAccountAddress();
	}

}
