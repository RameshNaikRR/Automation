package coyni_mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
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

	private By lblPurchaseAmount = MobileBy.xpath("//*[contains(@text,'Amount')]/following-sibling::*");
	private By lblProcessingFee = MobileBy.xpath("//*[contains(@text,'Processing')]/following-sibling::*");
	private By lblTotalAmount = MobileBy.xpath("//*[@text='Total']/following-sibling::*");
	private By lblReferenceID = MobileBy.xpath("//*[@text='Reference ID']/following-sibling::*[1]");
	private By lblDepositNumber = MobileBy.xpath(
			"//*[@text='Deposit Number']/following-sibling::android.widget.TextView|//*[@text='Withdraw Number']/following-sibling::android.widget.TextView");
	// card
	private By lblCardHolderName = MobileBy.xpath("//*[@text='Cardholder Name']/following-sibling::*");
	private By lblCardBrand = MobileBy.xpath("(//*[@text='Card Brand']/following-sibling::*)[1]");
	private By lblCardNumber = MobileBy.xpath("(//*[@text='Card Number']/following-sibling::*)[1]");
	// BAnk Account
	private By lblBankName = MobileBy.xpath("//*[@text='Bank Name']/following-sibling::*[1]");
	private By lblBankAccountNumber = MobileBy.xpath("//*[contains(@text,'Account Number')]/following-sibling::*");
	private By btnCancel = MobileBy.xpath("(//*[@name='Cancel Transaction'])[1]");
	private By btnBack = MobileBy.AccessibilityId("Back");

	// withdraw Instant

	private By lblMsg = MobileBy
			.xpath("//*[@text='Transaction Details']/../following-sibling::*/descendant::android.widget.TextView[3]");
	private By lblWithdrawlAmount = MobileBy.id("");
	private By lblWithdrawNumber = MobileBy
			.xpath("//*[@text='Withdraw Number']/following-sibling::android.widget.TextView");

	// Gift Card

	private By lblGiftCardName = MobileBy.xpath("//*[@text='Gift Card Name']/following-sibling::*[1]");
	private By lblGiftCardAmount = MobileBy.xpath("//*[@text='Gift Card Amount']/following-sibling::*[1]");

//	Sent Details 
	private By lblSubTotal = MobileBy.xpath("//*[@text='Sub Total']/following-sibling::*[1]");
	private By lblGrandTotal = MobileBy.xpath("//*[@text='Grand Total']/following-sibling::*[1]");
	private By lblWithdrawID = MobileBy.xpath("//*[@text='Withdraw ID']/following-sibling::*[1]");
	private By lblName = MobileBy.xpath(
			"//*[@text='Recipient Name']/following-sibling::*[1]|//*[contains(@text,'Name')]/following-sibling::*[1]");
	private By lblRecipientName = MobileBy.xpath("//*[@text='Recipient Name']/following-sibling::*[1]");
	private By lblTotalAmount1 = MobileBy.xpath("");

	private By lblAccountBalance = MobileBy.xpath("//*[@text='Account Balance']/following-sibling::*[1]");
	private By lblDepositID = MobileBy.xpath("//*[@text='Deposit ID']/following-sibling::*[1]");

	private By lblExpiryDate = MobileBy.xpath("//*[@text='Expiration Date']/following-sibling::*[1]");

	private By lblNameOnAccount = MobileBy.xpath("//*[contains(@text,'Name on')]/following-sibling::*[1]");

	private By lblUserName = MobileBy.xpath("//*[@text='User Name']/following-sibling::*[1]");
	private By lblAccountAddress = MobileBy.xpath("//*[@text='Account Address']/following-sibling::*[1]");

	private By lblCnacelTransaction = MobileBy.AccessibilityId("Cancel Transaction?");
	private By btnNo = MobileBy.xpath("(//*[@text='NO'])[1]");
	private By btnYes = MobileBy.xpath("(//*[@text='Yes'])[1]");

	private By lblMerchantAccountId = MobileBy.xpath("//*[@text='Merchant Account ID']/following-sibling::*[1]");
	private By lblDBAname = MobileBy.xpath("//*[@text='DBA Name']/following-sibling::*[1]");
	private By lblEmail = MobileBy.xpath("//*[contains(@text,'Email')]/following-sibling::*[1]");
	private By lblPhoneNumber = MobileBy.xpath("//*[contains(@text,'Phone')]/following-sibling::*[1]");

//	Activity log
	private By lblTransSucsfulTime = MobileBy.xpath(
			"//*[contains(@text,'Successful')]/following-sibling::*|//*[contains(@text,'Failed')]/following-sibling::*|(//*[contains(@text,'Successful')]/../following-sibling::*)[1]");
	private By lblTransRequestTime = MobileBy.xpath(
			"//*[contains(@text,'Request')]/following-sibling::*[contains(@resource-id,'Time')]|//*[contains(@text,'Request')]/../following-sibling::*[contains(@resource-id,'Time')]");
	private By lblTransSucsfulDesc = MobileBy.xpath(
			"//*[contains(@text,'Successful')]/../following-sibling::*[contains(@resource-id,'message_tv')]|//*[contains(@text,'Failed')]/../following-sibling::*[contains(@resource-id,'message_tv')]");
	private By lblTransRequestDesc = MobileBy
			.xpath("//*[contains(@text,'Request')]/../following-sibling::*[contains(@resource-id,'message_tv')]");

//	Transactions search functionality 

	private By btnReferenceID = MobileBy.xpath("//*[@text='Reference ID']/following-sibling::*[2]");
	private By txtSearch = MobileBy.id("com.coyni.mapp:id/searchET");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

//	Activity Log Details of Buy Token 
	public int viewTransSuccessfulTime() {
		scrollDownToElement(lblTransSucsfulTime, "Transaction SuccessFul Date & Time");
		if (getText(lblTransSucsfulTime).contains(" ")) {
			new CommonFunctions().elementView(lblTransSucsfulTime, "Transaction SuccessFul Date & Time");
			ExtentTestManager
					.setPassMessageInReport("Transaction SuccessFul Date & Time : " + getText(lblTransSucsfulTime));
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Its not showing Date & Time or Its showing invalid formatted Date & Time for successful transaction");
		}
		return getElementList(lblTransSucsfulTime, "Transaction SuccessFul Date & Time").size();
	}

	public int viewTransInProgress() throws InterruptedException {
		Thread.sleep(600);
		return getElementList(lblTransSucsfulTime, "Transaction SuccessFul Date & Time").size();
	}

	public void viewTransRequestTime() {
		scrollDownToElement(lblTransRequestTime, "Transaction Request Date & Time");
		if (getText(lblTransRequestTime).contains(" ")) {
			new CommonFunctions().elementView(lblTransRequestTime, "Transaction Request Date & Time");
			ExtentTestManager
					.setPassMessageInReport("Transaction Request Date & Time : " + getText(lblTransRequestTime));
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Its not showing Date & Time or Its showing invalid formatted Date & Time for requested transaction");
		}
	}

	public int viewTransSuccessDesc() {
		scrollDownToElement(lblTransSucsfulDesc, "Successful Desc");
		new CommonFunctions().elementView(lblTransSucsfulDesc, "Transaction Successful Desc");
		ExtentTestManager.setPassMessageInReport("Successful Desc : " + getText(lblTransSucsfulDesc));
		return getElementList(lblTransSucsfulDesc, "Successful Desc").size();
	}

	public void viewTransRequestDesc() {
		scrollDownToElement(lblTransRequestDesc, "Request Desc");
		new CommonFunctions().elementView(lblTransRequestDesc, "Transaction Request Desc");
		ExtentTestManager.setPassMessageInReport("Request Desc : " + getText(lblTransRequestDesc));
	}

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
		new CommonFunctions().elementView(lblTransactionTypeAmount, "Transaction Amount");
		ExtentTestManager.setPassMessageInReport("Transaction Amount" + getText(lblTransactionTypeAmount));
	}

	public void verifyTransactionAmount() {
		if (getText(lblTransactionTypeAmount).equals("- -")) {
			ExtentTestManager.setPassMessageInReport("Its not Showing any transaction amount");
		} else {
			ExtentTestManager.setFailMessageInReport("The amount is not as per expcted");
		}
	}

	public void getStatus() {
		new CommonFunctions().elementView(lblStatus, "Status");
		ExtentTestManager.setPassMessageInReport("Status: " + getText(lblStatus));
	}

	public void verifyStatus(String expText) {
		new CommonFunctions().verifyLabelText(lblStatus, "Status", expText);
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

//	public String verifyPurchaseAmount() {
//		String str = getText(lblPurchaseAmount).trim().replace(" ", "").replace("USD", "").replace("$", "")
//				.replace("CYN", "");
//		return str;
//	}
//
//	public String verifyGiftCardAmount() {
//		String str = getText(lblGiftCardAmount).trim().replace(" ", "").replace("USD", "").replace("$", "")
//				.replace("CYN", "");
//		return str;
//	}
//
//	public String verifyWithdrawAmount() {
//		String str = getText(lblWithdrawlAmount).trim().replace(" ", "").replace("USD", "").replace("$", "")
//				.replace("CYN", "");
//		return str;
//	}
//
//	public String verifyProcessingFee() {
//		String str = getText(lblProcessingFee).trim().replace(" ", "").replace("USD", "").replace("$", "")
//				.replace("CYN", "");
//		return str;
//	}
//
//	public String verifyTotalAmount() {
//		String str = getText(lblTotalAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN",
//				"");
//		return str;
//	}

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
		new CommonFunctions().elementView(lblDepositNumber, "ID");
		ExtentTestManager.setPassMessageInReport("ID : " + getText(lblDepositNumber));
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

	public void clickReferenceID() {
		click(btnReferenceID, "Reference ID");
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

	public void viewRecipientName() {
		if (getText(lblRecipientName).contains(" ")) {
			new CommonFunctions().elementView(lblRecipientName, "Recipient Name");
			ExtentTestManager.setPassMessageInReport("Recipient Name" + getText(lblRecipientName));
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

	public void buyTokenTransactionDetails(String expText, String expValue, String type) throws InterruptedException {
		getTransaction(expText);
		if (expValue.equals("Completed")) {
			getTransactionAmount();
		} else {
			verifyTransactionAmount();
		}
		verifyStatus(expValue);
		getDateTime();
		getPurchaseAmount();
		getProcessingFee();
		getTotalAmount();
		getReferenceID();
		getDepositNumber();
		if (type.equals("Bank Account")) {
			getNameOnBank();
			getBankName();
			getBankAccountNumber();
		} else {
			getCardHolderName();
			getCardBrand();
			getCardNumber();
			getExpiryDate();
		}
		if (expValue.equals("In Progress")) {
			if (viewTransInProgress() == 0) {
				viewTransRequestTime();
				viewTransRequestDesc();
			} else {
				ExtentTestManager.setFailMessageInReport(
						"Its showing Transaction successful details,when transaction is In Progress");
			}

		} else {
			viewTransSuccessfulTime();
			viewTransSuccessDesc();
			viewTransRequestTime();
			viewTransRequestDesc();
		}

	}

	public void withdrawGiftCardTransactionsDetails(String expText, String expValue) throws InterruptedException {
		getTransaction(expText);
		if (expValue.equals("Completed")) {
			getTransactionAmount();
		} else {
			verifyTransactionAmount();
		}
		verifyStatus(expValue);
		getDateTime();
		getGiftCardName();
		getGiftCardAmount();
		getProcessingFee();
		getTotalAmount();
		getReferenceID();
		getWithdrawNumber();
		viewRecipientName();
		getEmail();
		if (expValue.equals("In Progress")) {
			if (viewTransInProgress() == 0) {
				viewTransRequestTime();
				viewTransRequestDesc();
			} else {
				ExtentTestManager.setFailMessageInReport(
						"Its showing Transaction successful details,when transaction is In Progress");
			}

		} else {
			viewTransSuccessfulTime();
			viewTransSuccessDesc();
			viewTransRequestTime();
			viewTransRequestDesc();
		}
	}

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

	public String getTransactionType() {
		return getText(lblTransactionType);
	}

	public String getTransactionAmt() {
		return getText(lblTransactionTypeAmount);
	}

	public String getTransactionStatus() {
		return getText(lblStatus);
	}

	public String getTransactionDate() {
		return getText(lblDateAndTime);
	}

	public void verifySearch() {
		wait.until(ExpectedConditions.presenceOfElementLocated(txtSearch));
		new CommonFunctions().VerifySearchWithPasteOption(txtSearch);
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

	public void filterSentTransactionDetails(String expText, String expValue) {
		getTransaction(expText);
		if (expValue.equals("Completed")) {
			getTransactionAmount();
		} else {
			verifyTransactionAmount();
		}
		verifyStatus(expValue);
		getSentRequestMessage();
		getStatus();
		getDateTime();
		getReferenceID();
		viewName();
		getAccountAddress();
	}

	public void receivedTransactionDetails(String expText, String expValue) {
		getTransaction(expText);
		getTransactionAmount();
		verifyStatus(expValue);
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
