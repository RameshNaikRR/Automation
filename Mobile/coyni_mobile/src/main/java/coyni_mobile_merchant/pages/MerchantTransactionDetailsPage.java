package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class MerchantTransactionDetailsPage extends MobileFunctions {

	private By btnDashBoard = MobileBy.xpath("//*[contains(@resource-id,'ll_dashboard_tab')]");

	private By lblMerchantTansactions = MobileBy.xpath("//*[contains(@resource-id,'tv_merchant_transactions')]");

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'payoutSearchET')]");

	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filterIconIV')]");

	private By closeIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");

	private By lblPayOutID = MobileBy.xpath("//*[@text='Payout ID']");

	private By lblPayOutTransactions = MobileBy.xpath("//*[@text='Payout Transactions']");

	private By lblSaleOrderDetails = MobileBy.xpath("");

	private By lblRefund = MobileBy.xpath("");

	private By lblMonthlyServiceFee = MobileBy.xpath("");

	private By lblBatchNowwithZeroAmountInReserve = MobileBy.xpath("");

	private By lblBatchNowwithAmountInReserve = MobileBy.xpath("");

	private By lblBuySignetAccount = MobileBy.xpath("");

	private By lblBuyBankAccount = MobileBy.xpath("");

	private By lblWithdawInstantPay = MobileBy.xpath("");

	private By lblWithdawBankAccount = MobileBy.xpath("");

	private By lblFailedWithdawBankAccount = MobileBy.xpath("");

	private By lblCancelledWithdawBankAccount = MobileBy.xpath("");

	private By lblWithdawGiftCard = MobileBy.xpath("");

	private By lblWithdawSignetAccount = MobileBy.xpath("");

	private By lblReserveRelease = MobileBy.xpath("");

	public void clickDashBoard() {
		click(btnDashBoard, "DashBoard");
	}

	public void clickMerchantTransctions() {
		click(lblMerchantTansactions, "Merchant Transactions");
	}

	public void verifySearchOption() {
		new CommonFunctions().elementView(searchOption, "Search Option");
	}

	public void verifyFiltersIcon() {
		new CommonFunctions().elementView(filtersIcon, "Filters Icon");
	}

	public void verifyLabelRefund(String expHeading) {
		new CommonFunctions().verifyLabelText(lblRefund, "Refund", expHeading);
	}

	public void verifyLabelSaleOderDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSaleOrderDetails, "Sale Order", expHeading);
	}

	public void verifyLabelMonthlyServiceFee(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMonthlyServiceFee, "Monthly Service Fee", expHeading);
	}

	public void verifyLabelBatchNowWithZeroAmount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBatchNowwithZeroAmountInReserve, "Batch Now With Zero Amount",
				expHeading);
	}

	public void verifyLabelBatchNowWithAmount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBatchNowwithAmountInReserve, "Batch Now With Amount", expHeading);
	}

	public void verifyLabelPayOutTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutTransactions, "Pay Out Transactions", expHeading);
	}

	public void verifyLabelBuySignetAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBuySignetAccount, "Buy Signet Account", expHeading);
	}

	public void verifyLabelBuyBankAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBuyBankAccount, "Buy Bank Account", expHeading);
	}

	public void verifyLabelWithdawInstantPay(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdawInstantPay, "Withdraw Instant Pay", expHeading);
	}

	public void verifyLabelWithdawBankAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdawBankAccount, "Withdraw Bank Account", expHeading);
	}

	public void verifyLabelWithdawFailedBankAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblFailedWithdawBankAccount, "Failed Withdraw Bank Account", expHeading);
	}

	public void verifyLabelWithdawCancelledBankAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCancelledWithdawBankAccount, "Cancelled Withdraw Bank Account",
				expHeading);
	}

	public void verifyLabelWithdawGiftCard(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdawGiftCard, "Withdraw Gift Card", expHeading);
	}

	public void verifyLabelWithdawSignetAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdawSignetAccount, "Withdraw Signet Account", expHeading);
	}

	public void verifyLabelReserveRelease(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReserveRelease, "Reserve Release", expHeading);
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}
}