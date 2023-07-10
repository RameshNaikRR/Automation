package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class TransactionsDetailsComponent extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Transaction Details']");
	private By lblTransaction = MobileBy.id("");
	private By lblTransactionAmount = MobileBy.id("");
	private By lblStatus = MobileBy.id("");
	private By lblDateAndTime = MobileBy.id("");
	private By lblPurchaseAmount = MobileBy.id("");
	private By lblProcessingFee = MobileBy.id("");
	private By lblTotalAmount = MobileBy.id("");
	private By lblReferenceID = MobileBy.id("");
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

	// withdraw Instant

	private By lblMsg = MobileBy.id("");
	private By lblWithdrawlAmount = MobileBy.id("");
	private By lblWithdrawNumber = MobileBy.id("");

	// Gift Card

	private By lblGiftCardName = MobileBy.id("");
	private By lblGiftCardAmount = MobileBy.id("");
	private By lblReciepentName = MobileBy.id("");
	private By lblReciepentEmail = MobileBy.id("");

	public String verifyfillMessage() {
		String str = getText(lblMsg).trim().replace('"', ' ');
		return str;
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public void getTransaction() {
		ExtentTestManager.setInfoMessageInReport("Transaction label: " + getText(lblTransaction));
	}

	public void getTransactionAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblTransactionAmount));
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

	public void getMessage() {
		if (getElementList(lblMessage, "").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Message: " + getText(lblMessage));
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

	public void getRecipientName() {
		ExtentTestManager.setInfoMessageInReport("Recipient Name: " + getText(lblRecipientName));
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

	public void buyTokenBankTransactionDetails() throws InterruptedException {
		getTransaction();
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

	public void buyTokenCardTransactionDetails() {
		getTransaction();
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

	public void withdrawBankTransactionDetails() throws InterruptedException {
		getTransaction();
		getStatus();
		getDateTime();
		getReferenceID();
		getWithdrawNumber();
		getNameOnBank();
		getBankName();
		getBankAccountNumber();
	}

	public void withdrawInstantTransactionsDetails() {
		getTransaction();
		getStatus();
		getDateTime();
		getReferenceID();
		getWithdrawNumber();
		getCardHolderName();
		getCardBrand();
		getCardNumber();
		getExpiryDate();
	}

	public void withdrawGiftCardTransactionsDetails() {
		getTransaction();
		getStatus();
		getDateTime();
		getGiftCardName();
		getReferenceID();
		getWithdrawNumber();
		getRecipientEmail();
		getRecipientName();
	}

	public void getTransactionDetails() throws InterruptedException {
		if (getText(lblTransaction).contains("Buy")) {
			if (getText(varNameonBank).contains("Name")) {
				buyTokenBankTransactionDetails();
			} else if (getText(varCardHolderName).contains("Cardholder")) {
				buyTokenCardTransactionDetails();
			}
		} else if (getText(lblTransaction).contains("Received")) {
			receivedTransactionDetails();
		} else if (getText(lblTransaction).contains("Sent")) {
			sentTransactionDetails();
		} else if (getText(lblTransaction).contains("Withdraw") && getText(varNameonBank).contains("Name")) {
			withdrawBankTransactionDetails();
		} else if (getText(lblTransaction).contains("Withdraw") && getText(lblTransaction).contains("Instant")) {
			withdrawInstantTransactionsDetails();
		} else if (getText(lblTransaction).contains("Withdraw") && getText(lblGiftCardName).contains("Gift")) {
			withdrawGiftCardTransactionsDetails();
		} else if (getText(lblTransaction).contains("Paid Order") && getText(lblTransaction).contains("Token")) {
			paidOrderDetails();
		} else if (getText(lblTransaction).contains("Pay/Request") && getText(lblTransaction).contains("Sent")) {
			sentTransactionDetails();
		} else {
			ExtentTestManager.setFailMessageInReport("Error in Transactions");
		}

	}

//	public int verifyTransactionAmount() {
//		String str = getText(lblTransactionAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
//		Integer amt=Integer.parseInt(str);
//		return amt;
//	}
//	

//	private By lblDescriptorName = MobileBy.id("");

	private By lblMessage = MobileBy
			.xpath("(//*[@name='Status']/../preceding-sibling::*[1]/XCUIElementTypeStaticText)[3]");

	private By lblSubTotal = MobileBy.xpath("//*[@name='Sub Total']/following-sibling::*[1]");

	private By lblGrandTotal = MobileBy.xpath("//*[@name='Grand Total']/following-sibling::*[1]");
	private By lblWithdrawID = MobileBy.xpath("//*[@name='Withdraw ID']/following-sibling::*[1]");

	private By lblRecipientName = MobileBy.xpath("//*[@name='Recipient Name']/following-sibling::*[1]");
	private By lblRecipientEmail = MobileBy.xpath("//*[@name='Recipient Email']/following-sibling::*[1]");

	private By lblTotalAmount1 = MobileBy.xpath("");

	private By lblAccountBalance = MobileBy.xpath("//*[@name='Account Balance']/following-sibling::*[1]");
	private By lblDepositID = MobileBy.xpath("//*[@name='Deposit ID']/following-sibling::*[1]");

	private By lblExpiryDate = MobileBy.xpath("//*[@name='Expiration Date']/following-sibling::*[1]");

	private By lblNameOnAccount = MobileBy.xpath("//*[@name='Name on Account']/following-sibling::*[1]");

	private By lblUserName = MobileBy.xpath("//*[@name='User Name']/following-sibling::*[1]");
	private By lblAccountAddress = MobileBy.xpath("//*[@name='Account Address']/following-sibling::*[1]");

	private By lblCnacelTransaction = MobileBy.AccessibilityId("Cancel Transaction?");
	private By btnNo = MobileBy.xpath("(//*[@name='NO'])[1]");
	private By btnYes = MobileBy.xpath("(//*[@name='Yes'])[1]");

	private By lblMerchantAccountId = MobileBy.xpath("//*[@name='Merchant Account ID']/following-sibling::*[1]");
	private By lblDBAname = MobileBy.xpath("//*[@name='DBA Name']/following-sibling::*[1]");
	private By lblCustServiceEmail = MobileBy.xpath("//*[@name='Customer Service Email']/following-sibling::*[1]");
	private By lblCustServicePhone = MobileBy.xpath("//*[@name='Customer Service Phone']/following-sibling::*[1]");

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

	public void paidOrderDetails() {
		getTransaction();
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

	public void sentTransactionDetails() {
		getTransaction();
		getTransactionAmount();
		// getMessage();
		//
		getStatus();
		getDateTime();
		// getProcessingFee();
		// getTotalAmount();
		// getAccountBalance();
		getReferenceID();
		//
		// getUserName();
		getAccountAddress();
		getRecipientName();
	}

	public void receivedTransactionDetails() {
		getTransaction();
		getTransactionAmount();
		getMessage();
		//
		getStatus();
		getDateTime();
		getAccountBalance();
		getReferenceID();
		getUserName();
		getAccountAddress();
	}

}
