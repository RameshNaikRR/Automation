package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FiltersComponent extends MobileFunctions {

	private By btnPayRequest = MobileBy.xpath(" ");
	private By btnBuyToken = MobileBy.xpath(" ");
	private By btnSalesOrder = MobileBy.xpath(" ");
	private By btnWithdrawn = MobileBy.xpath(" ");
	private By btnRefund = MobileBy.xpath(" ");
	private By btnAccountTransfer = MobileBy.xpath(" ");
	private By btnPaidInvoice = MobileBy.xpath(" ");

	private By btnSent = MobileBy.xpath(" ");
	private By btnReceived = MobileBy.xpath(" ");
	private By btnBankAccount = MobileBy.xpath(" ");
	private By btnCreditCard = MobileBy.xpath(" ");
	private By btnDebitCard = MobileBy.xpath(" ");
	private By btnSignet = MobileBy.xpath(" ");
	private By btnInstantPay = MobileBy.xpath(" ");
	private By btnGiftCard = MobileBy.xpath(" ");
	private By btnSaleOrderToken = MobileBy.xpath(" ");
	private By btnFailedWithdraw = MobileBy.xpath(" ");
	private By btnCancelledWithdraw = MobileBy.xpath(" ");

	private By btnPending = MobileBy.xpath(" ");
	private By btnCompleted = MobileBy.xpath(" ");
	private By btnCancelled = MobileBy.xpath(" ");
	private By btnInProgress = MobileBy.xpath(" ");
	private By btnFailed = MobileBy.xpath(" ");

	private By txtTransactionAmountFrom = MobileBy.xpath(" ");
	private By txtTransactionAmountTo = MobileBy.xpath(" ");

	public void clickPayRequest() {
		click(btnPayRequest, "Click Pay Request");
	}

	public void clickBuyToken() {
		click(btnBuyToken, "Click Buy Token");
	}

	public void clickSalesOrder() {
		click(btnSalesOrder, "Click Sales Order");
	}

	public void clickWithdrawn() {
		click(btnWithdrawn, "Withdrawn");
	}

	public void clickRefund() {
		click(btnRefund, "Refund");
	}

	public void clickAccountTransfer() {
		click(btnAccountTransfer, "Account Transfer");
	}

	public void clickPaidInvoice() {
		click(btnPaidInvoice, "Paid Invoice");
	}

	public void clickSent() {
		click(btnSent, "Sent");
	}

	public void clickReceive() {
		click(btnReceived, "Receive");
	}

	public void clickBankAccount() {
		click(btnBankAccount, "Bank Account");
	}

	public void clickCreditCard() {
		click(btnCreditCard, "Credit card");
	}

	public void clickDebitCard() {
		click(btnDebitCard, "Debit Card");
	}

	public void clickSignet() {
		click(btnSignet, "Signet");
	}

	public void clickInstantPay() {
		click(btnInstantPay, "Instant Pay");
	}

	public void clickGiftCard() {
		click(btnGiftCard, "Gift Card");
	}

	public void clickSaleOrderToken() {
		click(btnSaleOrderToken, "SaleOrder Token");

	}

	public void clickFailedWithdraw() {
		click(btnFailedWithdraw, "Failed Withdraw");
	}

	public void clickCancelledWithdraw() {
		click(btnCancelledWithdraw, "Cancelled Withdraw");
	}

	public void clickPending() {
		click(btnPending, "Pending");
	}

	public void clickCompleted() {
		click(btnCompleted, "Completed");
	}

	public void clickCancelled() {
		click(btnCancelled, "Cancelled");
	}

	public void clickInProgress() {
		click(btnInProgress, "In Progress");
	}

	public void clickFailed() {
		click(btnFailed, "Failed");
	}

	public void fillTransactionAmountFrom(String FromAmount) {
		enterText(txtTransactionAmountFrom, FromAmount, "From Amount");
	}

	public void fillTransactionAmountTo(String ToAmount) {
		enterText(txtTransactionAmountTo, ToAmount, "To Amount");
	}

}
