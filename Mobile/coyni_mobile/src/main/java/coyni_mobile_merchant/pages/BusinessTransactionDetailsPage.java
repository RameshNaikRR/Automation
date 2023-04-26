package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.ErrorMessagePopup;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BusinessTransactionDetailsPage extends ReserveReleaseDetailsPage {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Transaction Details')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Payout Information')]");
	private By lblTransactionType = MobileBy.xpath(
			"//*[contains(@resource-id,'Payoutheader')]|//*[contains(@resource-id,'BankHeader')]|//*[contains(@resource-id,'header')]|//*[contains(@resource-id,'Gifthead')]|//*[contains(@resource-id,'reserve_type')]");
	private By lblAmount = MobileBy.xpath(
			"//*[contains(@resource-id,'merchantamount')]| //*[contains(@resource-id,'bankamount')]|//*[contains(@resource-id,'BankAmount')]|(//*[contains(@resource-id,'amount')])[1]");
	private By lblStatus = MobileBy.xpath("//*[contains(@resource-id,'status')]|//*[contains(@resource-id,'Status')]");
	private By lblDate = MobileBy.xpath(
			"//*[contains(@resource-id,'merchantdate')]|//*[contains(@resource-id,'bankDatetime')]|//*[contains(@resource-id,'dateTime')]|//*[contains(@resource-id,'released_on')]");
	private By lblPayoutID = MobileBy.xpath("//*[contains(@resource-id,'PayoutId')]");
	private By lblReferenceID = MobileBy
			.xpath("//*[contains(@resource-id,'RefundcopyIV')]|//*[@text='Reference ID']/following-sibling::*");

	private By lblPayoutDate = MobileBy.xpath("//*[contains(@resource-id,'merchantPIdate')]");
	private By lblTotalAmount = MobileBy
			.xpath("//*[contains(@resource-id,'totalamount')]|//*[contains(@resource-id,'Total')]");
	private By lblTotalTransactions = MobileBy.xpath("//*[contains(@resource-id,'mPItotaltransactions')]");
	private By lblDepositTo = MobileBy.xpath("//*[contains(@text,'Token Account')]");

	private By lblNameOnAccount = MobileBy
			.xpath("//*[contains(@resource-id,'banknameAC')]|//*[contains(@resource-id,'NameOnAccount')]");
	private By lblBankName = MobileBy
			.xpath("//*[contains(@resource-id,'banknameTV')]|//*[contains(@resource-id,'withBankBanknameTV')]");
	private By lblBankAccount = MobileBy.xpath("//*[contains(@resource-id,'bankaccount')]");
	private By lblPurchaseAmount = MobileBy.xpath("//*[contains(@resource-id,'purchase')]");
	private By lblDepositID = MobileBy.xpath("//*[contains(@resource-id,'DepositIDTV')]");
	private By lblDescriptorName = MobileBy.xpath("//*[contains(@resource-id,'Descrptor')]");
	private By lblProcessingFee = MobileBy.xpath(
			"//*[contains(@resource-id,'processingfee')]|//*[contains(@resource-id,'ProcessFee')]|//*[contains(@resource-id,'profee')]");

	private By lblWithdrawAmount = MobileBy
			.xpath("//*[contains(@resource-id,'WithdrawAmount')]|//*[contains(@resource-id,'withdrawamount')]");
	private By lblWithdrawID = MobileBy.xpath(
			"//*[contains(@resource-id,'withBankWithdrawidTV')]|//*[contains(@resource-id,'withgiftid')]|//*[contains(@resource-id,'withinwithdrawidTV')]");
	private By lblAccountBalance = MobileBy.xpath("//*[contains(@resource-id,'AccBalance')]");

	private By lblCardHolderName = MobileBy
			.xpath("//*[contains(@resource-id,'holdername')]|//*[contains(@resource-id,'withBankNameOnAccountTV')]");
	private By lblCardNumber = MobileBy.xpath("//*[contains(@resource-id,'cardnum')]");
	private By lblExpirationDate = MobileBy.xpath("//*[contains(@resource-id,'expdate')]");

	private By lblGiftCardName = MobileBy.xpath("//*[contains(@resource-id,'Giftcardname')]");
	private By lblSubTotal = MobileBy.xpath("//*[contains(@resource-id,'Giftsubtotatl')]");
	private By lblRecipientName = MobileBy.xpath("//*[contains(@resource-id,'RecipientName')]");
	private By lblRecipientEmail = MobileBy.xpath("//*[contains(@resource-id,'GiftReciEmail')]");

	private By btnCancel = MobileBy.xpath("//*[contains(@text,'Cancel')]");
	private By lblCancelTranHeading = MobileBy.xpath("//*[contains(@text,'Cancel')]");
	private By lblCancelDescription = MobileBy.xpath("//*[contains(@text,'want to cancel this')]");
	private By btnCancelNo = MobileBy.xpath("//*[contains(@resource-id,'No')]");
	private By btnCancelYes = MobileBy.xpath("//*[contains(@resource-id,'Yes')]");
	private By btnReserveRelease = MobileBy.xpath("(//*[contains(@text,'Reserve Release')])[1]");
	private By lblReservedOn = MobileBy.xpath("//*[contains(@resource-id,'reserved_on')]");
	private By lblReserveRelease = MobileBy.xpath("//*[contains(@text,'Reserve Release')]");
	private By btnInstantPayBack = MobileBy.xpath("//*[contains(@resource-id,'withInstantprevious')]");
	private By btnWithBankSignetBack = MobileBy.xpath("//*[contains(@resource-id,'withbankCloseLL')]");
	private By btnBuyBankBack = MobileBy.xpath("//*[contains(@resource-id,'btbankprevious')]");
	private By btnBuyBankReferenceCopy = MobileBy
			.xpath("//*[contains(@resource-id,'btbankrefIV')]|//*[contains(@resource-id,'referenceCopyIV')]");
	private By btnWithBankReferenceCopy = MobileBy.xpath("//*[contains(@resource-id,'withBankReferenceIDIV')]");
//	private By btnWithBankBack = MobileBy.xpath("//*[contains(@resource-id,'withbankCloseLL')]");
	private By btnWithInstaReference = MobileBy.xpath("//*[contains(@resource-id,'withinrefIDIV')]");
//	private By btnWithInstaBack = MobileBy.xpath("//*[contains(@resource-id,'withInstantprevious')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Transaction Details Heading ", expHeading);
	}

	public void verifyTranStatus(String expStatus) {
		new CommonFunctions().verifyLabelText(lblStatus, "Transaction Status ", expStatus);
	}

	public void verifyTransactionType(String expType) {
		new CommonFunctions().verifyLabelText(lblTransactionType, "Transaction Type ", expType);
	}

	public String getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount : " + getText(lblAmount));
		return getText(lblAmount);
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status : " + getText(lblStatus));

	}

	public void getDate() {
		ExtentTestManager.setInfoMessageInReport("Date : " + getText(lblDate));
	}

	public void getPayoutID() {
		ExtentTestManager.setInfoMessageInReport("Payout ID : " + getText(lblPayoutID));
	}

	public String getReferenceID() {
		click(lblReferenceID, "Reference ID");
		ExtentTestManager.setInfoMessageInReport("Reference ID" + getText(lblReferenceID));
		String beforeTranRefernceId = getCopiedData();
		ExtentTestManager.setPassMessageInReport(beforeTranRefernceId);
		return getText(lblReferenceID);
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

	public void clickBuyBankReferenceID() {
		click(btnBuyBankReferenceCopy, "Buy Bank Reference Id Copy");
	}

	public void clickInstantPayReferenceID() {
		click(btnWithInstaReference, " Instant Pay Reference Id Copy");
	}

	public void clickWithBankReferenceID() {
		click(btnWithBankReferenceCopy, "Withdraw Bank Reference Id Copy");
	}

	public void getMerchantPayoutTransactionDetails() {
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

	public void verifySearchTransactionDetails() throws InterruptedException {
		String beforeTranRefernceId = getCopiedData();
		getReferenceID();
		String AfterTranefernceId = getCopiedData();
		if (beforeTranRefernceId.equals(AfterTranefernceId)) {
			ExtentTestManager.setPassMessageInReport("Search is validated it is giving accurate results");
			getAmount();
			getDate();
			getReferenceID();
			getTotalAmout();
		} else {
			ExtentTestManager.setFailMessageInReport("Search filed is not showing copied transaction");
		}
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

	public void verifyBuyTokenBankTransactionDetails() {
		getAmount();
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

	public void VerifyLatestBuyTokenBankTransactionDetails() {
		String transReferId = getCopiedData();
		click(lblReferenceID, "Reference ID");
		String latestTranreferId = getCopiedData();
		if (transReferId.equals(latestTranreferId)) {
			ExtentTestManager.setPassMessageInReport("The latest transaction is updated");
		} else {
			ExtentTestManager.setFailMessageInReport("The latest transaction is not updated");
		}
		this.verifyBuyTokenBankTransactionDetails();
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

	public void VerifyLatestWithdrawTokenBankTransactionDetails() {
		String transReferId = getCopiedData();
		click(lblReferenceID, "Reference ID");
		String latestTranreferId = getCopiedData();
		if (transReferId.equals(latestTranreferId)) {
			ExtentTestManager.setPassMessageInReport("The latest transaction is updated");
		} else {
			ExtentTestManager.setFailMessageInReport("The latest transaction is not updated");
		}
		this.verifyWithdrawTokenBankTransactionDetails();
	}

	public void verifyWithdrawTokenBankTransactionDetails() {
		getAmount();
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
		ExtentTestManager.setInfoMessageInReport("Payment Name is : " + getText(lblCardHolderName));
	}

	public void getCardNumber() {
		ExtentTestManager.setInfoMessageInReport("Card Number is : " + getText(lblCardNumber));
	}

	public void getExpirationDate() {
		ExtentTestManager.setInfoMessageInReport("Expiration Date is : " + getText(lblExpirationDate));
	}

	public void verifyWithdrawTokenInstantPayTransactionDetails() {
		getAmount();
//		getStatus();
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

	public void verifyLatestWithdrawTokenInstantPayTransactionDetails() {
		String transReferId = getCopiedData();
		click(lblReferenceID, "Reference ID");
		String latestTranreferId = getCopiedData();
		if (transReferId.equals(latestTranreferId)) {
			ExtentTestManager.setPassMessageInReport("The latest transaction is updated");
		} else {
			ExtentTestManager.setFailMessageInReport("The latest transaction is not updated");
		}
		this.verifyWithdrawTokenInstantPayTransactionDetails();
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

	public void verifyWithdrawTokenGiftCardTransactionDetails() {
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

	public void verifyLatestWithdrawTokenGiftCardTransactionDetails() {
		String transReferId = getCopiedData();
		System.out.println(transReferId);
		click(lblReferenceID, "Reference ID");
		String latestTranreferId = getCopiedData();
		System.out.println(latestTranreferId);
		if (transReferId.equals(latestTranreferId)) {
			ExtentTestManager.setPassMessageInReport("The latest transaction is updated");
		} else {
			ExtentTestManager.setFailMessageInReport("The latest transaction is not updated");
		}
		this.verifyWithdrawTokenGiftCardTransactionDetails();
	}

	public void getReserveReleaseTransactionDetails() {
		getReserveReleasedDetails();
	}

	public void clickCancelTransaction() {
		click(btnCancel, "Cancel");
	}

	public int verifyCancelTransaction() throws InterruptedException {
		Thread.sleep(1500);
		return getElementList(btnCancel, "Cancel").size();
	}

	public void clickInstantPayBack() {
		click(btnInstantPayBack, "Back");
	}

	public void clickWithBankSignetBack() {
		click(btnWithBankSignetBack, "Back");
	}

	public void clickbtnBuyBankBack() {
		click(btnBuyBankBack, "Back");
	}

	public void verifyCancelTransactionHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCancelTranHeading, "Cancel Transaction Heading ", expHeading);
	}

	public void verifyCancelTransactionDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblCancelDescription, "Cancel Transaction Description ", expDescription);
	}

	public void cancelTransaction() {
		clickCancelTransaction();
	}

	public void clickNo() {
		click(btnCancelNo, "No");
	}

	public void clickYes() {
		click(btnCancelYes, "Yes");
	}

	public void clickReserveRelease() {
		click(btnReserveRelease, "Reserve Release");
	}

	public void getReservedOn() {
		ExtentTestManager.setInfoMessageInReport("Reserved on : " + getText(lblReservedOn));
	}

//	public void getBusinessReserveReleasedDetails() {
//		getTransactionType();
//		getReserveAmount();
//		getStatus();
//		getReleaseOn();
//		getReferenceID();
//		getReserveRule();
//		getDepositTo();
//		getReserveHeld();
//		getReservedOn();
//		getReserveID();
//	}

	public void getBusinessTokenReserveReleaseTransaction(String expHeading, String expType, String expStatus) {
		scrollDownToElement(lblReserveRelease, "Reserve Release");
		clickReserveRelease();
		verifyPageHeading(expHeading);
		verifyTransactionType(expType);
		verifyTranStatus(expStatus);
		getReserveAmount();
		getStatus();
		getReleaseOn();
		getReferenceID();
		getReserveRule();
		getDepositTo();
		getReserveHeld();
		getReservedOn();
		getReserveID();

	}

	public void verifyWithdrawTokenCogentTransactionDetails() {
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
	}

	public void verifyLatestWithdrawTokenCogentTransactionDetails() {
		String transReferId = getCopiedData();
		click(lblReferenceID, "Reference ID");
		String latestTranreferId = getCopiedData();
		if (transReferId.equals(latestTranreferId)) {
			ExtentTestManager.setPassMessageInReport("The latest transaction is updated");
		} else {
			ExtentTestManager.setFailMessageInReport("The latest transaction is not updated");
		}
		this.verifyWithdrawTokenCogentTransactionDetails();
	}

	public ErrorMessagePopup errorMessagePopup() {
		return new ErrorMessagePopup();
	}
}
