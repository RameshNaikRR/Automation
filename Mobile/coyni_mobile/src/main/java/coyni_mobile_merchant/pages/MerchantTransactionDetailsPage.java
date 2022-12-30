package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.RefundPopUp;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class MerchantTransactionDetailsPage extends MobileFunctions {

	private By lblMerchantTransactionDetailHeading = MobileBy.xpath("//*[contains(@text,'Transaction Details')]");

	private By lblTransactionType = MobileBy.xpath("//*[contains(@resource-id,'header')]");

	private By lblTransactionAmount = MobileBy.xpath("(//*[contains(@resource-id,'amount')])[1]");

	private By lblStatus = MobileBy.xpath("//*[contains(@text,'Status')]/following-sibling::*[1]");

	private By lblDateTime = MobileBy.xpath(
			"//*[contains(@resource-id,'Date')]|//*[contains(@resource-id,'merchantdate')]|//*[contains(@resource-id,'MSFdate')]");

	private By lblPayoutID = MobileBy.xpath("//*[contains(@resource-id,'mPayoutIdTV')]");

	private By lblReferenceID = MobileBy
			.xpath("//*[contains(@resource-id,'mreferenceIdTV')] | //*[contains(@resource-id,'SalesReferenceidTV')]");

	private By lblPayoutInformation = MobileBy.xpath("//*[contains(@text,'Payout Information')]");

	private By lblPayoutdate = MobileBy.xpath("//*[contains(@resource-id,'merchantPIdateTV')]");

	private By lblTotalAmount = MobileBy.xpath(
			"//*[contains(@resource-id,'mPItotalamountTV')] | //*[contains(@resource-id,'refundtotalAmountTV')]");

	private By lblTotalTransactions = MobileBy.xpath("//*[contains(@resource-id,'mPItotaltransactionsTV')]");

	private By lblDepositTo = MobileBy.xpath("//*[contains(@resource-id,'mPIdeposittoTV')]");

	private By lblOriginlTranInfo = MobileBy.xpath("//*[contains(@text,'Original Transaction')]");

	private By lblFees = MobileBy.xpath("//*[contains(@resource-id,'fee')]");

	private By lblRecipientName = MobileBy.xpath("//*[contains(@resource-id,'reciptantName')]");

	private By lblRecipientEmail = MobileBy.xpath("//*[contains(@resource-id,'ReciptantEmail')]");

	private By lblOTIDateTime = MobileBy.xpath("//*[contains(@resource-id,'OTIdate')]");

	private By lblGrossAmount = MobileBy.xpath("//*[contains(@resource-id,'grossamount')]");

	private By lblOTIFees = MobileBy.xpath("//*[contains(@resource-id,'OTIFee')]");

	private By lblNetAmount = MobileBy
			.xpath("//*[contains(@resource-id,'Netamount')]| //*[contains(@resource-id,'SalesnetamountTV')]");

	private By lblOTIReferenceID = MobileBy.xpath("//*[contains(@resource-id,'OTIrefrence')]");

	private By lblSaleTranAmount = MobileBy.xpath("//*[contains(@resource-id,'SalesAmount_TV')]");

	private By lblReserveAmount = MobileBy.xpath("//*[contains(@resource-id,'SalesreserveTV')]");

	private By lblMerchantBalance = MobileBy
			.xpath("//*[contains(@resource-id,'Balance')]|//*[contains(@resource-id,'MSFmerchantbalance')]");

	private By lblSenderName = MobileBy.xpath("//*[contains(@resource-id,'sendername')]");

	private By lblSenderEmail = MobileBy.xpath("//*[contains(@resource-id,'senderemail')]");

	private By btnRefund = MobileBy.xpath("//*[contains(@resource-id,'RefundIV')]");

	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'close')]");

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void verifyMerchantDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMerchantTransactionDetailHeading,
				"Merchant Transaction Details Heading", expHeading);
	}

	public void verifyTransactionDetails() {
		new CommonFunctions().elementView(lblMerchantTransactionDetailHeading, "Merchant Transaction Details Heading");
	}

	public void getTransactionType() {
		ExtentTestManager.setInfoMessageInReport("Transaction Type : " + getText(lblTransactionType));
	}

	public void getTransactionAmount() {
		ExtentTestManager.setInfoMessageInReport("Transaction Amount is : " + getText(lblTransactionAmount));
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status is " + getText(lblStatus));
	}

	public void getDateTime() {
		String text = getText(lblDateTime);
		ExtentTestManager.setInfoMessageInReport("Date and Time is : " + text);
	}

	public void getPayoutID() {
		ExtentTestManager.setInfoMessageInReport("Payout ID is : " + getText(lblPayoutID));
	}

	public void getReferenceID() {
		String text = getText(lblReferenceID);
		ExtentTestManager.setInfoMessageInReport("Reference ID is : " + text);
		click(lblReferenceID, "Reference ID");
	}

	public void getPayoutInformation() {
		String text = getText(lblPayoutInformation);
		ExtentTestManager.setInfoMessageInReport("Payout Information is : " + text);
	}

	public void getPayoutdate() {
		String text = getText(lblPayoutdate);
		ExtentTestManager.setInfoMessageInReport("Payout Date is : " + text);
	}

	public void getTotalAmount() {
		String text = getText(lblTotalAmount);
		ExtentTestManager.setInfoMessageInReport("Total Amount is: " + text);
	}

	public void getTotalTransactions() {
		String text = getText(lblTotalTransactions);
		ExtentTestManager.setInfoMessageInReport("Total Transactions is : " + text);
	}

	public void getDepositTo() {
		String text = getText(lblDepositTo);
		ExtentTestManager.setInfoMessageInReport("Deposit To : " + text);
	}

	public void getMerchantPayoutDetails() {
//		getTransactionType();
//		getTransactionAmount();
		getStatus();
		getDateTime();
		getPayoutID();
		getReferenceID();
		getPayoutInformation();
		getPayoutdate();
		getTotalAmount();
		getTotalTransactions();
		getDepositTo();
	}

//
//	public void verifyRecentTransaction() {
//		if (DriverFactory.getDriver().findElements(lblNoTransactions).size() == 0) {
//			new CommonFunctions().elementView(lblRecentTransaction, "Recent Transaction");
//		} else {
//			ExtentTestManager.setInfoMessageInReport("You Have No Transactions");
//		}
//	}
//
	public void getOriginlTranInfo() {
		ExtentTestManager
				.setInfoMessageInReport("Original transaction information Heading is : " + getText(lblOriginlTranInfo));
	}

	public void getFees() {
		ExtentTestManager.setInfoMessageInReport("Deposit To : " + getText(lblFees));
	}

	public void getRecipientName() {
		ExtentTestManager.setInfoMessageInReport("Recipient Name : " + getText(lblRecipientName));
	}

	public void getRecipientEmail() {
		ExtentTestManager.setInfoMessageInReport("Recipient Email : " + getText(lblRecipientEmail));
	}

	public void getOTIDateTime() {
		ExtentTestManager.setInfoMessageInReport(
				"Original transaction information Date and Time is : " + getText(lblOTIDateTime));
	}

	public void getGrossAmount() {
		scrollDownToElement(lblGrossAmount, "Gross Amount");
		ExtentTestManager.setInfoMessageInReport("Gross Amount : " + getText(lblGrossAmount));
	}

	public void getOTIFees() {
		scrollDownToElement(lblOTIFees, "OTI Fees");
		ExtentTestManager.setInfoMessageInReport("Original transaction information Fees is : " + getText(lblOTIFees));
	}

	public void getNetAmount() {
		scrollDownToElement(lblNetAmount, "Net Amount");
		ExtentTestManager
				.setInfoMessageInReport("Original transaction information Net Amount is : " + getText(lblNetAmount));
	}

	public void getOTIReferenceID() {
		scrollDownToElement(lblOTIReferenceID, "OTI Reference ID");
		ExtentTestManager.setInfoMessageInReport(
				"Original transaction information Reference ID is : " + getText(lblOTIReferenceID));
	}

	public void clickRefund() {
		click(btnRefund, "Refund");
	}

	public void getRefundSentDetails() {
//		getTransactionType();
//		getTransactionAmount();
		getStatus();
		getDateTime();
		getReferenceID();
		getFees();
		getTotalAmount();
		getRecipientName();
		getRecipientEmail();
		getOriginlTranInfo();
		getOTIDateTime();
		getGrossAmount();
		getOTIFees();
		getNetAmount();
		getOTIReferenceID();
	}

	public void getMonthlyServiceFee() {
		getStatus();
		getDateTime();
		getReferenceID();
		getMerchantBalance();
	}

	public void getSaleOrderTokenAmount() {
		ExtentTestManager.setInfoMessageInReport("Sale Order Token Amount : " + getText(lblSaleTranAmount));
	}

	public void getReserveAmount() {

		ExtentTestManager.setInfoMessageInReport("Reserve Amount : " + getText(lblReserveAmount));
	}

	public void getMerchantBalance() {
		ExtentTestManager.setInfoMessageInReport("Merchant Balance is : " + getText(lblMerchantBalance));
	}

	public void getSenderName() {
		scrollDownToElement(lblSenderName, "Sender Name");
		ExtentTestManager.setInfoMessageInReport("Sender Name is : " + getText(lblSenderName));
	}

	public void getSenderEmail() {
		scrollDownToElement(lblSenderEmail, "Sender Email");
		ExtentTestManager.setInfoMessageInReport("Sender Email is : " + getText(lblSenderEmail));
	}

	public void getSaleOrderTokenDetails() {
		getTransactionType();
		getSaleOrderTokenAmount();
		getStatus();
		getDateTime();
		getReferenceID();
		getFees();
		getReserveAmount();
		getNetAmount();
		getMerchantBalance();
		getSenderName();
		getSenderEmail();
	}

	public RefundTransactionPage refundTransactionPage() {
		return new RefundTransactionPage();
	}

	public RefundPopUp refundPopUp() {
		return new RefundPopUp();
	}

}
