package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FiltersComponent extends MobileFunctions {

	private By lblFilter = MobileBy.xpath("");
	private By btnFilters = MobileBy.xpath("//*[contains(@resource-id,'filterIconIV')]");
	private By lblTransactionType = MobileBy.xpath("");
	private By lblTransactionSubType = MobileBy.xpath("");
	private By lblTransactionStatus = MobileBy.xpath("");
	private By lblTransactionAmount = MobileBy.xpath("");
	private By lblDate = MobileBy.xpath("//*[contains(@resource-id,'datePickET')]");

	private By btnPayRequest = MobileBy.xpath("//*[contains(@resource-id,'transTypePR')]");
	private By btnBuyToken = MobileBy.xpath(" ");
	private By btnSalesOrder = MobileBy.xpath(" ");
	private By btnWithdrawn = MobileBy.xpath(" ");
	private By btnRefund = MobileBy.xpath(" ");
	private By btnAccountTransfer = MobileBy.xpath(" ");
	private By btnPaidInvoice = MobileBy.xpath(" ");

	private By btnSent = MobileBy.xpath("//*[contains(@resource-id,'transSubTypeSent')]");
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

	private By txtTransactionAmountFrom = MobileBy.xpath("//*[contains(@resource-id,'transAmountStartET')]");
	private By txtTransactionAmountTo = MobileBy.xpath("//*[contains(@resource-id,'transAmountEndET')]");

	private By btnResetAllFilters = MobileBy.xpath("");
	private By applyFilter = MobileBy.xpath("//*[contains(@resource-id,'applyFilterBtnCV')]");

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

	public void fillTransactionAmountFrom(String fromAmount) {
		scrollDownToElement(txtTransactionAmountFrom, fromAmount);
		enterText(txtTransactionAmountFrom, fromAmount, "From Amount");
	}

	public void fillTransactionAmountTo(String toAmount) {
		enterText(txtTransactionAmountTo, toAmount, "To Amount");
	}

	public void clickFiltersIcon() {
		click(btnFilters, "Filters Button");

	}

	public void clickResetAllFilters() {
		click(btnResetAllFilters, "Reset All Filters");
	}

	public void clickAppliedFilters() {
		click(applyFilter, "Applied Filters");

	}

	public void verifyResetAllFiltersView() {
		new CommonFunctions().elementView(btnResetAllFilters, "ResetAllFilters");

	}

	public void verifyFiltersIconView() {
		new CommonFunctions().elementView(btnFilters, "Filter");

	}

	public void verifyLabelFilterView() {
		new CommonFunctions().elementView(lblFilter, "Label Filter");

	}

	public void verifyLabelTransactionTypeView() {
		new CommonFunctions().elementView(lblTransactionType, "Label TransactionType");

	}

	public void verifyLabelTransactionSubTypeView() {
		new CommonFunctions().elementView(lblTransactionSubType, "Label TransactionSubType");

	}

	public void verifyLabelTransactionStatusView() {
		new CommonFunctions().elementView(lblTransactionStatus, "Label TransactionStatus");

	}

	public void verifyLabelTransactionAmountView() {
		new CommonFunctions().elementView(lblTransactionAmount, "Label TransactionAmount");

	}

	public void verifyLabelDateView() {
		new CommonFunctions().elementView(lblDate, "Label Date");

	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

}
