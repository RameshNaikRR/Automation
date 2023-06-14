package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class TransactionsDetailsComponent extends MobileFunctions {

//	private By lblHeading = MobileBy.xpath("//*[@name='Transaction Details']");
	private By lblHeading = MobileBy.AccessibilityId("Transaction Details");
	private By btnBack = MobileBy.xpath("//*[@name='Transaction Details']/preceding-sibling::*[@name='Button']");

	private By lblTransaction = MobileBy
			.xpath("(//*[@name='Status']/../preceding-sibling::*[1]/XCUIElementTypeStaticText)[1]");
	private By lblTransactionAmount = MobileBy
			.xpath("(//*[@name='Status']/../preceding-sibling::*[1]/XCUIElementTypeStaticText)[2]");
	private By lblMessage = MobileBy
			.xpath("(//*[@name='Status']/../preceding-sibling::*[1]/XCUIElementTypeStaticText)[3]");

	private By lblStatus = MobileBy.xpath("//*[@name='Status']/following-sibling::*[1]");
	private By lblDateAndTime = MobileBy.xpath("//*[@name='Date & Time']/following-sibling::*[1]");
	private By lblGiftCardName = MobileBy.xpath("//*[@name='Gift Card Name']/following-sibling::*[1]");
	private By lblSubTotal = MobileBy.xpath("//*[@name='Sub Total']/following-sibling::*[1]");
	private By lblProcessingFee = MobileBy.xpath("//*[@name='Processing Fee']/following-sibling::*[1]");
	private By lblGrandTotal = MobileBy.xpath("//*[@name='Grand Total']/following-sibling::*[1]");
	private By lblWithdrawID = MobileBy.xpath("//*[@name='Withdraw ID']/following-sibling::*[1]");
	private By lblReferenceID = MobileBy.xpath("//*[@name='Reference ID']/following-sibling::*[1]");
	private By lblRecipientName = MobileBy.xpath("//*[@name='Recipient Name']/following-sibling::*[1]");
	private By lblRecipientEmail = MobileBy.xpath("//*[@name='Recipient Email']/following-sibling::*[1]");

	private By lblPurchaseAmount = MobileBy.xpath("//*[@name='Purchase Amount']/following-sibling::*[1]");
	private By lblTotalAmount1 = MobileBy.xpath("");
	private By lblTotalAmount = MobileBy.xpath(
			"//*[@name='Total Amount']/following-sibling::*[contains(@name,'+ Processing Fee')]/following-sibling::*[1]");
	private By lblAccountBalance = MobileBy.xpath("//*[@name='Account Balance']/following-sibling::*[1]");
	private By lblDepositID = MobileBy.xpath("//*[@name='Deposit ID']/following-sibling::*[1]");
	private By lblDescriptorName = MobileBy.xpath("//*[@name='Descriptor Name']/following-sibling::*[1]");
	private By lblCardHolderName = MobileBy.xpath("//*[@name='Card Holder Name']/following-sibling::*[1]");
	private By lblCardNumber = MobileBy.xpath("//*[@name='Card Number']/following-sibling::*[1]");
	private By lblCardBrand = MobileBy.AccessibilityId("");
	private By lblExpiryDate = MobileBy.xpath("//*[@name='Expiration Date']/following-sibling::*[1]");
	private By lblActivityLog = MobileBy.xpath("//*[@name='Activity Log']/following-sibling::*[1]");

	private By lblNameOnAccount = MobileBy.xpath("//*[@name='Name on Account']/following-sibling::*[1]");
	private By lblBankName = MobileBy.xpath("//*[@name='Bank Name']/following-sibling::*[1]");
	private By lblBankAccountNumber = MobileBy.xpath("//*[@name='Bank Account #']/following-sibling::*[1]");
	private By lblUserName = MobileBy.xpath("//*[@name='User Name']/following-sibling::*[1]");
	private By lblAccountAddress = MobileBy.xpath("//*[@name='Account Address']/following-sibling::*[1]");
	private By btnCancel = MobileBy.xpath("(//*[@name='Cancel Transaction'])[1]");
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

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void getTransaction() {
		ExtentTestManager.setInfoMessageInReport("Transaction label: " + getText(lblTransaction));
	}

	public void getTransactionAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblTransactionAmount));
	}

	public void getMessage() {
		if (getElementList(lblMessage, "").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Message: " + getText(lblMessage));
		}
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblStatus));
	}

	public void getDateTime() {
		ExtentTestManager.setInfoMessageInReport("Date & Time: " + getText(lblDateAndTime));
	}

	public void getGiftCardName() {
		ExtentTestManager.setInfoMessageInReport("Gift Card Name: " + getText(lblGiftCardName));
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

	public void getReferenceID() {
		ExtentTestManager.setInfoMessageInReport("Reference ID: " + getText(lblReferenceID));
	}

	public void getRecipientName() {
		ExtentTestManager.setInfoMessageInReport("Recipient Name: " + getText(lblRecipientName));
	}

	public void getRecipientEmail() {
		ExtentTestManager.setInfoMessageInReport("Recipient Email: " + getText(lblRecipientEmail));
	}

	public void getPurchaseAmount() {
		ExtentTestManager.setInfoMessageInReport("Purchase Amount: " + getText(lblPurchaseAmount));
	}

	public void getTotalAmount() {
		 ExtentTestManager.setInfoMessageInReport("Total Amount:	 " +getText(lblTotalAmount));
	}

	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport("Account Balance: " + getText(lblAccountBalance));
	}

	public void getDepositID() {
		ExtentTestManager.setInfoMessageInReport("Deposit ID: " + getText(lblDepositID));
	}

	public void getDescriptorName() {
		ExtentTestManager.setInfoMessageInReport("Descriptor Name: " + getText(lblDescriptorName));
	}

	public void getCardHolderName() {
		ExtentTestManager.setInfoMessageInReport("CardHolderName: " + getText(lblCardHolderName));
	}

	public void getCardNumber() {
		ExtentTestManager.setInfoMessageInReport("CardNumber: " + getText(lblCardNumber));
	}
	public void getCardBrand() {
		ExtentTestManager.setInfoMessageInReport("CardBrand: " + getText(lblCardBrand));
	}

	public void getExpiryDate() {
		scrollDownToElement(lblExpiryDate, "Expiry Date");
		ExtentTestManager.setInfoMessageInReport("Expiration Date: " + getText(lblExpiryDate));
	}

	public void getNameOnAccount() {
		ExtentTestManager.setInfoMessageInReport("Name on Account: " + getText(lblNameOnAccount));
	}

	public void getBankName() {
		ExtentTestManager.setInfoMessageInReport("Bank Name: " + getText(lblBankName));
	}

	public void getBankAccountNumber() {
		scrollDownToElement(lblBankAccountNumber, "Bank Account Number");
		ExtentTestManager.setInfoMessageInReport("Bank Account Number: " + getText(lblBankAccountNumber));
	}

	public void getUserName() {
		ExtentTestManager.setInfoMessageInReport("UserName: " + getText(lblUserName));
	}

	public void getAccountAddress() {
		ExtentTestManager.setInfoMessageInReport("Account Address: " + getText(lblAccountAddress));
	}

	public void clickCancel() throws InterruptedException {
		if(getElement(btnCancel, "CnacelTransaction").isEnabled()) {
			click(btnCancel, "Cancel Transaction");
			ExtentTestManager.setInfoMessageInReport("Cancel Transaction button is enabled");
			new CommonFunctions().elementView(lblCnacelTransaction, "Cnacel Transaction Heading");
			click(btnNo, "No");
			click(btnCancel, "Cancel Transaction");
			click(btnYes, "Yes");
			Thread.sleep(1000);
			getStatus();
		}else {
			ExtentTestManager.setInfoMessageInReport("Cancel Transaction button is disabled");
		}
		
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
	//	getProcessingFee();
	//    getTotalAmount();
	//	getAccountBalance();
		getReferenceID();
		//
	//	getUserName();
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

	public void buyTokenBankTransactionDetails() throws InterruptedException {
		getTransaction();
		getTransactionAmount();
		getStatus();
		getDateTime();
		getPurchaseAmount();
		getProcessingFee();
		getTotalAmount();
		getDepositID();
		getReferenceID();
		getDescriptorName();
		getNameOnAccount();
		getBankName();
		getBankAccountNumber();
		clickCancel();
		
	}

	public void buyTokenCardTransactionDetails() {
		getTransaction();
	//	getTransactionAmount();
		getStatus();
		getDateTime();
	//	getPurchaseAmount();
	//	getProcessingFee();
	//	getTotalAmount();
		getAccountBalance();
		getDepositID();
		getReferenceID();
		getDescriptorName();
		getCardHolderName();
		getCardNumber();
		getCardBrand();
		getExpiryDate();
	}
	public String verifyReferenceId() {
		String str = getText(lblReferenceID);
		return str;
	}
	
	public String verifyTotalAmount() {
		String str = getText(lblTotalAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");;
		return str;
	}
	
	public int verifyTransactionAmount() {
		String str = getText(lblTransactionAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		Integer amt=Integer.parseInt(str);
		return amt;
	}
	public String verifyPurchaseAmount() {
		String str = getText(lblPurchaseAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		return str;
	}
	public String verifyProcessingFee() {
		String str = getText(lblProcessingFee).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		return str;
	}
	
	public void withdrawBankTransactionDetails() throws InterruptedException {
		getTransaction();
		getTransactionAmount();
		getStatus();
		getDateTime();
		// withdrawAmount
		getProcessingFee();
		getTotalAmount();
		getAccountBalance();
		//
		getWithdrawID();
		getReferenceID();
		//
		getNameOnAccount();
		getBankName();
		getBankAccountNumber();
		clickCancel();
	}

	public void withdrawInstantTransactionsDetails() {
		getTransaction();
		getTransactionAmount();
		getMessage();
		//
		getStatus();
		getDateTime();
		// withdrawAmount
		getProcessingFee();
		getTotalAmount();
		getAccountBalance();
		//
		getWithdrawID();
		getReferenceID();
		//
		getCardHolderName();
		getCardNumber();
		getExpiryDate();

	}

	public void withdrawGiftCardTransactionsDetails() {
		getTransaction();
		getTransactionAmount();
		//
		getStatus();
		getDateTime();
		getGiftCardName();
	    getTotalAmount();
		getProcessingFee();
	//	getGrandTotal();
		//
		getWithdrawID();
		getReferenceID();
		//
		getRecipientName();
		getRecipientEmail();
	}

	public void getTransactionDetails() throws InterruptedException {
		if (getText(lblTransaction).contains("Buy")) {
			if (getText(lblTransaction).contains("Bank")) {
				buyTokenBankTransactionDetails();
			} else if (getText(lblTransaction).contains("Card")) {
				buyTokenCardTransactionDetails();
			}
		} else if (getText(lblTransaction).contains("Received")) {
			receivedTransactionDetails();
		} else if (getText(lblTransaction).contains("Sent")) {
			sentTransactionDetails();
		} else if (getText(lblTransaction).contains("Withdraw") && getText(lblTransaction).contains("Bank")) {
			withdrawBankTransactionDetails();
		} else if (getText(lblTransaction).contains("Withdraw") && getText(lblTransaction).contains("Instant")) {
			withdrawInstantTransactionsDetails();
		} else if (getText(lblTransaction).contains("Gift")) {
			withdrawGiftCardTransactionsDetails();
		} else if (getText(lblTransaction).contains("Paid Order") && getText(lblTransaction).contains("Token")) {
			paidOrderDetails();
		} else if(getText(lblTransaction).contains("Pay/Request") && getText(lblTransaction).contains("Sent")) {
			sentTransactionDetails();
		}
		else {
			ExtentTestManager.setFailMessageInReport("Error in Transactions");
		}

	}

}
