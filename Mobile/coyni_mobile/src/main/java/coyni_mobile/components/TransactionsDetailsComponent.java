package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class TransactionsDetailsComponent extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Transaction Details']");
	private By lblTransactionType = MobileBy
			.xpath("//*[@text='Transaction Details']/../following-sibling::*/descendant::android.widget.TextView[1]");
	private By lblTransactionTypeAmount = MobileBy
			.xpath("//*[@text='Transaction Details']/../following-sibling::*/descendant::android.widget.TextView[2]");
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

	private By lblMsg = MobileBy
			.xpath("//*[@text='Transaction Details']/../following-sibling::*/descendant::android.widget.TextView[3]");
	private By lblWithdrawlAmount = MobileBy.id("");
	private By lblWithdrawNumber = MobileBy.id("");

	// Gift Card

	private By lblGiftCardName = MobileBy.id("");
	private By lblGiftCardAmount = MobileBy.id("");

//	Sent Details 
	private By lblSubTotal = MobileBy.xpath("//*[@text='Sub Total']/following-sibling::*[1]");
	private By lblGrandTotal = MobileBy.xpath("//*[@text='Grand Total']/following-sibling::*[1]");
	private By lblWithdrawID = MobileBy.xpath("//*[@text='Withdraw ID']/following-sibling::*[1]");
	private By lblName = MobileBy.xpath("//*[contains(@text,'Name')]/following-sibling::*[1]");
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
	private By lblEmail = MobileBy.xpath("//*[contains(@text,'Email')]/following-sibling::*[1]");
	private By lblPhoneNumber = MobileBy.xpath("//*[contains(@text,'Phone')]/following-sibling::*[1]");

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
		new CommonFunctions().elementView(lblTransactionTypeAmount, "Date And Time");
		ExtentTestManager.setPassMessageInReport("Date & Time: " + getText(lblTransactionTypeAmount));
	}

	public void getStatus() {
		new CommonFunctions().elementView(lblStatus, "Status");
		ExtentTestManager.setPassMessageInReport("Status: " + getText(lblStatus));
	}

	public void getDateTime() {
		if (getText(lblDateAndTime).contains(" ")) {
			new CommonFunctions().elementView(lblDateAndTime, "Date And Time");
			ExtentTestManager.setPassMessageInReport("Date & Time: " + getText(lblDateAndTime));
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Its not showing Date & Time or Its showing invalid formatted Date & Time.");
		}
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
		return str;
	}

	public void getReferenceID() {
		if (getText(lblReferenceID).contains("...")) {
			new CommonFunctions().elementView(lblReferenceID, "Reference ID");
			ExtentTestManager.setPassMessageInReport("Reference ID: " + getText(lblReferenceID));
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Its not showing any Reference ID or Its showing invalid formatted Reference ID.");
		}
	}

	public void getDepositNumber() {
		new CommonFunctions().elementView(lblDepositNumber, "Deposit Number");
		ExtentTestManager.setPassMessageInReport("Deposit Number: " + getText(lblDepositNumber));
	}

	public void getCardHolderName() {
		new CommonFunctions().elementView(lblCardHolderName, "Card Holder Name");
		ExtentTestManager.setPassMessageInReport("CardHolderName: " + getText(lblCardHolderName));
	}

	public void getCardBrand() {
		new CommonFunctions().elementView(lblCardBrand, "Card Brand");
		ExtentTestManager.setPassMessageInReport("CardBrand: " + getText(lblCardBrand));
	}

	public void getCardNumber() {
		new CommonFunctions().elementView(lblCardNumber, "Card Number");
		ExtentTestManager.setPassMessageInReport("CardNumber: " + getText(lblCardNumber));
	}

	public void getExpiryDate() {
		scrollDownToElement(lblExpiryDate, "Expiry Date");
		new CommonFunctions().elementView(lblExpiryDate, "Expiry Date");
		ExtentTestManager.setPassMessageInReport("Expiration Date: " + getText(lblExpiryDate));
	}

	public void getNameOnBank() {
		new CommonFunctions().elementView(lblNameOnAccount, "Name On Account");
		ExtentTestManager.setPassMessageInReport("Name on Account: " + getText(lblNameOnAccount));
	}

	public void getBankName() {
		new CommonFunctions().elementView(lblBankName, "Bank Name");
		ExtentTestManager.setPassMessageInReport("Bank Name: " + getText(lblBankName));
	}

	public void getBankAccountNumber() {
		scrollDownToElement(lblBankAccountNumber, "Bank Account Number");
		new CommonFunctions().elementView(lblBankAccountNumber, "Bank Account Number");
		ExtentTestManager.setPassMessageInReport("Bank Account Number: " + getText(lblBankAccountNumber));
	}

	public void getSentRequestMessage() {
		if (getElementList(lblMsg, "").size() > 0) {
			new CommonFunctions().elementView(lblMsg, "Message");
			ExtentTestManager.setPassMessageInReport("Message: " + getText(lblMsg));
		}
	}

	public void getWithdrawNumber() {
		new CommonFunctions().elementView(lblWithdrawNumber, "Withdraw Number");
		ExtentTestManager.setPassMessageInReport("Withdraw Number: " + getText(lblWithdrawNumber));
	}

	public void getGiftCardName() {
		new CommonFunctions().elementView(lblGiftCardName, "Gift Card Name");
		ExtentTestManager.setPassMessageInReport("Gift Card Name: " + getText(lblGiftCardName));
	}

	public String verifyGiftCardNAme() {
		String str = getText(lblGiftCardName).trim().replace('"', ' ');
		return str;
	}

	public void getGiftCardAmount() {
		new CommonFunctions().elementView(lblGiftCardAmount, "Gift Card Amount");
		ExtentTestManager.setPassMessageInReport("Gift Card Amount: " + getText(lblGiftCardAmount));
	}

	public void getRecipientName(String name, String amount) {
//		double Transamt = Double.parseDouble(getText(lblTransactionTypeAmount));
//		&& Transamt == Double.parseDouble(amount)
		System.out.println(amount);
		System.out.println(getText(lblName));
		if (getText(lblName).equals(name)) {
			ExtentTestManager.setPassMessageInReport(
					"The Recent Transaction is Reflected and Recipient Name : " + getText(lblName));
		} else {
			ExtentTestManager.setFailMessageInReport(
					"The Recent Transaction is not Reflected and Recipient Name is wrong : " + getText(lblName));
		}
	}

	public void viewName() {
		if (getText(lblName).contains(" ")) {
			new CommonFunctions().elementView(lblName, "Name");
			ExtentTestManager.setPassMessageInReport("Name" + getText(lblName));
		} else {
			ExtentTestManager.setFailMessageInReport("Its not showing any Name or invalid format Name its showing");
		}

	}

	public void clickCancel() throws InterruptedException {
		if (getElement(btnCancel, "CnacelTransaction").isEnabled()) {
			click(btnCancel, "Cancel Transaction");
			ExtentTestManager.setPassMessageInReport("Cancel Transaction button is enabled");
			new CommonFunctions().elementView(lblCnacelTransaction, "Cnacel Transaction Heading");
			click(btnNo, "No");
			click(btnCancel, "Cancel Transaction");
			click(btnYes, "Yes");
			Thread.sleep(1000);
			getStatus();
		} else {
			ExtentTestManager.setPassMessageInReport("Cancel Transaction button is disabled");
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
		getEmail();
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
			receivedTransactionDetails(expText);
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
		new CommonFunctions().elementView(lblDBAname, "DBA name");
		ExtentTestManager.setPassMessageInReport("DBA Name: " + getText(lblDBAname));
	}

	public void getEmail() {
		if (getText(lblEmail).contains("@")) {
			new CommonFunctions().elementView(lblEmail, "Email");
			ExtentTestManager.setPassMessageInReport("Email: " + getText(lblEmail));
		} else {
			ExtentTestManager
					.setFailMessageInReport("Its not showing any email id or invalid format email its showing");
		}
	}

	public void getPhoneNumber() {
		if (getText(lblPhoneNumber).contains("(")) {
			new CommonFunctions().elementView(lblPhoneNumber, "Phone Number");
			ExtentTestManager.setPassMessageInReport("Phone Number: " + getText(lblPhoneNumber));
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Its not showing any Phone Number or invalid format Phone Number its showing");
		}
	}

	public void getMerchantID() {
		new CommonFunctions().elementView(lblMerchantAccountId, "Merchant Account Id");
		ExtentTestManager.setPassMessageInReport("Merchant Id: " + getText(lblMerchantAccountId));
	}

	public void getSubTotal() {
		new CommonFunctions().elementView(lblSubTotal, "Sub Total");
		ExtentTestManager.setPassMessageInReport("Sub Total: " + getText(lblSubTotal));
	}

	public void getProcessingFee() {
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
		ExtentTestManager.setPassMessageInReport("Processing Fee: " + getText(lblProcessingFee));
	}

	public void getGrandTotal() {
		new CommonFunctions().elementView(lblGrandTotal, "Grand Total");
		ExtentTestManager.setPassMessageInReport("Grand Total: " + getText(lblGrandTotal));
	}

	public void getWithdrawID() {
		new CommonFunctions().elementView(lblWithdrawID, "Withdraw ID");
		ExtentTestManager.setPassMessageInReport("Withdraw ID: " + getText(lblWithdrawID));
	}

	public void getPurchaseAmount() {
		new CommonFunctions().elementView(lblPurchaseAmount, "Purchase Amount");
		ExtentTestManager.setPassMessageInReport("Purchase Amount: " + getText(lblPurchaseAmount));
	}

	public void getTotalAmount() {
		new CommonFunctions().elementView(lblTotalAmount, "Total Amount");
		ExtentTestManager.setPassMessageInReport("Total Amount:	 " + getText(lblTotalAmount));
	}

	public void getAccountBalance() {
		new CommonFunctions().elementView(lblAccountBalance, "Account Balance: ");
		ExtentTestManager.setPassMessageInReport("Account Balance: " + getText(lblAccountBalance));
	}

	public void getDepositID() {
		new CommonFunctions().elementView(lblDepositID, "Deposit ID: ");
		ExtentTestManager.setPassMessageInReport("Deposit ID: " + getText(lblDepositID));
	}

	public void getUserName() {
		new CommonFunctions().elementView(lblUserName, "UserName: ");
		ExtentTestManager.setPassMessageInReport("UserName: " + getText(lblUserName));
	}

	public void getAccountAddress() {
		new CommonFunctions().elementView(lblAccountAddress, "Account Address: ");
		ExtentTestManager.setPassMessageInReport("Account Address: " + getText(lblAccountAddress));
	}

	public void verifyTransactionDetailsHeadingView() {
		new CommonFunctions().elementView(lblHeading, "Heading");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void getSaleOrderTransType() {
		new CommonFunctions().elementView(lblTransactionType, "Transaction Type");
		ExtentTestManager.setPassMessageInReport("Transaction Type" + getText(lblTransactionType));
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
		getEmail();
		getPhoneNumber();

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

	public void filterSentTransactionDetails(String expText) {
		getTransaction(expText);
		getTransactionAmount();
		getSentRequestMessage();
		getStatus();
		getDateTime();
		getReferenceID();
		viewName();
		getAccountAddress();
	}

	public void receivedTransactionDetails(String expText) {
//		getRecipientName(name, amount);
		getTransaction(expText);
		getTransactionAmount();
		getSentRequestMessage();
		getStatus();
		getDateTime();
		viewName();
		getReferenceID();
		getAccountAddress();
	}

	public void RetailMobileTransactionDetails(String expText) {
//		getRecipientName(name, amount);
		getTransaction(expText);
		getTransactionAmount();
		getSentRequestMessage();
		getStatus();
		getDateTime();
		getReferenceID();
		viewName();
		getEmail();
		getPhoneNumber();
	}

}
