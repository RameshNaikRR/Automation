package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class MerchantTransactionDetailsPage extends MobileFunctions {

	private By btnDashBoard = MobileBy.xpath("//*[contains(@resource-id,'ll_dashboard_tab')]");

	private By lblMerchantBalance = MobileBy.xpath("//*[contains(@text,'Merchant Balance')]/following-sibling::*[2]");

	private By lblProcessingVolume = MobileBy.xpath("//*[@text='Processing Volume']");

	private By lblSaleOrderDetails = MobileBy.xpath("//*[contains(@resource-id,'tv_floating_text')]");

	private By lblRefunds = MobileBy.xpath("//*[contains(@resource-id,'gross_amount')]");

	private By lblMISCFees = MobileBy.xpath("//*[contains(@resource-id,'misc_fee')]");

	private By lblNetAmount = MobileBy.xpath("//*[contains(@resource-id,'net_amount')]");

	private By lblProcessingFees = MobileBy.xpath("//*[contains(@resource-id,'processing_fees')]");

	private By lnkViewMerchantTransactions = MobileBy.xpath("//*[contains(@resource-id,'tv_merchant_transactions')]");

	public void clickDashBoard() {
		click(btnDashBoard, "DashBoard");
	}

	public void getMerchantBalance() {
		ExtentTestManager.setInfoMessageInReport("Merchant Balance " + getText(lblMerchantBalance));
	}

	public void verifyLabelProcessingVolume(String expHeading) {
		new CommonFunctions().verifyLabelText(lblProcessingVolume, "Processing Volume", expHeading);
	}

	public void getRefund() {
		ExtentTestManager.setInfoMessageInReport("Refund " + getText(lblRefunds));

	}

	public void getSaleOrder() {
		ExtentTestManager.setInfoMessageInReport("Sale Order " + getText(lblSaleOrderDetails));
	}

	public void getMISCFee() {
		ExtentTestManager.setInfoMessageInReport("MISC Fee " + getText(lblMISCFees));
	}

	public void getNetAmount() {
		ExtentTestManager.setInfoMessageInReport("Net Amount " + getText(lblNetAmount));
	}

	public void getProcessingFees() {
		ExtentTestManager.setInfoMessageInReport("Processing Fees " + getText(lblProcessingFees));
	}

	public MerchantTransactionsPage merchantTransactionsPage() {
		return new MerchantTransactionsPage();
	}

}