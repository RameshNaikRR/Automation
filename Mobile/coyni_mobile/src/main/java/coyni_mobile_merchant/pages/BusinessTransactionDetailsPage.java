package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BusinessTransactionDetailsPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Transaction Details')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Payout Information')]");
	private By lblTransactionType = MobileBy.xpath("//*[contains(@resource-id,'Payoutheader')]|//*[contains(@resource-id,'BankHeader')]|//*[contains(@resource-id,'header')]|//*[contains(@resource-id,'Gifthead')]");
	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'merchantamount')]| //*[contains(@resource-id,'bankamount')]|//*[contains(@resource-id,'BankAmount')]");
	private By lblStatus = MobileBy.xpath("//*[contains(@resource-id,'merchantstatus')]|//*[contains(@resource-id,'Status')]");
	private By lblDate = MobileBy.xpath("//*[contains(@resource-id,'merchantdate')]|//*[contains(@resource-id,'bankDatetime')]");
	private By lblPayoutID = MobileBy.xpath("//*[contains(@resource-id,'PayoutId')]");
	private By lblReferenceID = MobileBy.xpath("//*[contains(@resource-id,'RefidTV')]|//*[contains(@resource-id,'withBankReferenceIDTV')]|//*[contains(@resource-id,'mreferenceIdTV')]");
	private By lblPayoutDate = MobileBy.xpath("//*[contains(@resource-id,'merchantPIdate')]");
	private By lblTotalAmount = MobileBy.xpath("//*[contains(@resource-id,'mPItotalamountTV')]|//*[contains(@resource-id,'Total')]");
	private By lblTotalTransactions = MobileBy.xpath("//*[contains(@resource-id,'mPItotaltransactions')]");
	private By lblDepositTo = MobileBy.xpath("//*[contains(@text,'Token Account')]");

	
	private By lblNameOnAccount = MobileBy.xpath("//*[contains(@resource-id,'banknameAC')]|//*[contains(@resource-id,'NameOnAccount')]");
	private By lblBankName = MobileBy.xpath("//*[contains(@resource-id,'banknameTV')]|//*[contains(@resource-id,'withBankBanknameTV')]");
	private By lblBankAccount = MobileBy.xpath("//*[contains(@resource-id,'bankaccount')]");
	private By lblPurchaseAmount = MobileBy.xpath("//*[contains(@resource-id,'purchase')]");
	private By lblDepositID = MobileBy.xpath("//*[contains(@resource-id,'DepositIDTV')]");
	private By lblDescriptorName = MobileBy.xpath("//*[contains(@resource-id,'Descrptor')]");
	private By lblProcessingFee = MobileBy.xpath("//*[contains(@resource-id,'processingfee')]|//*[contains(@resource-id,'ProcessFee')]");

	private By lblWithdrawAmount = MobileBy.xpath("//*[contains(@resource-id,'WithdrawAmount')]");
	private By lblWithdrawID = MobileBy.xpath("//*[contains(@resource-id,'withBankWithdrawidTV')]");
	private By lblAccountBalance = MobileBy.xpath("//*[contains(@resource-id,'AccBalance')]");
	
	private By lblCardHolderName = MobileBy.xpath("//*[contains(@resource-id,'holdername')]");
	private By lblCardNumber = MobileBy.xpath("//*[contains(@resource-id,'cardnum')]");
	private By lblExpirationDate = MobileBy.xpath("//*[contains(@resource-id,'expdate')]");
	
	
	private By lblGiftCardName = MobileBy.xpath("//*[contains(@resource-id,'Giftcardname')]");
	private By lblSubTotal = MobileBy.xpath("//*[contains(@resource-id,'Giftsubtotatl')]");
	private By lblRecipientName = MobileBy.xpath("//*[contains(@resource-id,'RecipientName')]");
	private By lblRecipientEmail = MobileBy.xpath("//*[contains(@resource-id,'GiftReciEmail')]");
	
	
	private By btnCancel = MobileBy.xpath("//*[contains(@text,'Cancel')]");
	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Transaction Details Heading ",expHeading);
	}

	public void getTransactionType() {
//		scrollDownToElement(lblTotalAmount, "Total Availble Funds : ");
		ExtentTestManager.setInfoMessageInReport("Transaction Type : " + getText(lblTransactionType));

	}

	public void getAmount() {
//		scrollDownToElement(lblTotalAmount, "Total Availble Funds : ");
		ExtentTestManager.setInfoMessageInReport("Amount : " + getText(lblAmount));

	}

	public void getStatus() {
//		scrollDownToElement(lblTotalAmount, "Total Availble Funds : ");
		ExtentTestManager.setInfoMessageInReport("Status : " + getText(lblStatus));

	}

	public void getDate() {
		ExtentTestManager.setInfoMessageInReport("Date : " + getText(lblDate));
	}

	public void getPayoutID() {
		// scrollDownToElement(lblSaleOrderDetails, "Sale Order");
		ExtentTestManager.setInfoMessageInReport("Payout ID : " + getText(lblPayoutID));
	}

	public void getReferenceID() {
		ExtentTestManager.setInfoMessageInReport("Reference ID" + getText(lblReferenceID));
	}

	public void getPageDescription() {
		ExtentTestManager.setInfoMessageInReport("Page Description is : " + getText(lblDescription));
	}

	public void getPayoutDate() {
		ExtentTestManager.setInfoMessageInReport("Payout Date : " + getText(lblPayoutDate));
	}

	public void getTotalAmout() {
		ExtentTestManager.setInfoMessageInReport("Total Amout : " + getText(lblTotalAmount));
	}

	public void getTotalTransactions() {
		ExtentTestManager.setInfoMessageInReport("Total Transactions : " + getText(lblTotalTransactions));
	}

	public void getDepositTo() {
		ExtentTestManager.setInfoMessageInReport("Deposit To : " + getText(lblDepositTo));
	}

	public void getMerchantPayoutTransactionDetails() {
		getTransactionType();
		getAmount();
		getDate();
		getPayoutID();
		getReferenceID();
		getPageDescription();
		getPayoutDate();
		getTotalAmout();
		getTotalTransactions();
		getDepositTo();
	}

	public void getNameonAccount() {
		ExtentTestManager.setInfoMessageInReport("Name On Account is : " + getText(lblNameOnAccount));
	}

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee is : " + getText(lblProcessingFee));
	}
	public void getBankName() {
		scrollDownToElement(lblBankName, "Bank Name is : ");
		ExtentTestManager.setInfoMessageInReport("Bank Name is : " + getText(lblBankName));
	}

	public void getBankAccount() {
		scrollDownToElement(lblBankAccount, "Bank Account is : ");
		ExtentTestManager.setInfoMessageInReport("Bank Account is : " + getText(lblBankAccount));
	}

	public void getDepositID() {
		ExtentTestManager.setInfoMessageInReport("Deposit ID is : " + getText(lblDepositID));
	}

	public void getPurchaseAmount() {
		ExtentTestManager.setInfoMessageInReport("Purchase Amount is : " + getText(lblPurchaseAmount));
	}

	public void getDescriptorName() {
		ExtentTestManager.setInfoMessageInReport("Descriptor Name is : " + getText(lblDescriptorName));
	}
	public void getBuyTokenBankTransactionDetails() {
		getTransactionType();
		getAmount();
		getStatus();
		getDate();
		getPurchaseAmount();
		getProcessingFee();
		getTotalAmout();
		getDepositID();
		getReferenceID();
		getDescriptorName();
		getNameonAccount();
		getBankName();
		getBankAccount();
	}
	
	public void getWithdrawAmount() {
		ExtentTestManager.setInfoMessageInReport("Withdraw Amount is : " + getText(lblWithdrawAmount));
	}

	public void getWithdrawID() {
		ExtentTestManager.setInfoMessageInReport("Withdraw ID is : " + getText(lblWithdrawID));
	}
	
	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport("Account Balance is : " + getText(lblAccountBalance));
	}
	
	public void getWithdrawTokenBankTransactionDetails() {
		getTransactionType();
		getAmount();
		getStatus();
		getDate();
		getWithdrawAmount();
		getProcessingFee();
		getTotalAmout();
		getAccountBalance();
		getWithdrawID();
		getReferenceID();
		getNameonAccount();
		getBankName();
		getBankAccount();
	}
	
	public void getCardHolderName() {
		ExtentTestManager.setInfoMessageInReport("Card Holder Name is : " + getText(lblCardHolderName));
	}

	public void getCardNumber() {
		ExtentTestManager.setInfoMessageInReport("Card Number is : " + getText(lblCardNumber));
	}
	
	public void getExpirationDate() {
		ExtentTestManager.setInfoMessageInReport("Expiration Date is : " + getText(lblExpirationDate));
	}
	
	public void getWithdrawTokenInstantPayTransactionDetails() {
		getTransactionType();
		getAmount();
		getStatus();
		getDate();
		getWithdrawAmount();
		getProcessingFee();
		getTotalAmout();
		getWithdrawID();
		getReferenceID();
		getCardHolderName();
		getCardNumber();
		getExpirationDate();
	}

	public void getGiftCardName() {
		ExtentTestManager.setInfoMessageInReport("Gift Card Name is : " + getText(lblGiftCardName));
	}

	public void getSubTotal() {
		ExtentTestManager.setInfoMessageInReport("Sub Total is : " + getText(lblSubTotal));
	}
	
	public void getRecipientName() {
		ExtentTestManager.setInfoMessageInReport("Recipient Name is : " + getText(lblRecipientName));
	}
	public void getRecipientEmail() {
		ExtentTestManager.setInfoMessageInReport("Recipient Email is : " + getText(lblRecipientEmail));
	}

	public void getWithdrawTokenGiftCardTransactionDetails() {
		getTransactionType();
		getAmount();
		getStatus();
		getDate();
		getGiftCardName();
		getSubTotal();
		getProcessingFee();
		getWithdrawID();
		getReferenceID();
		getRecipientName();
		getRecipientEmail();
	}
}
