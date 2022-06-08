package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class DashBoardPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'officially_verified')]");

	private By btnDashBoard = MobileBy.xpath("//*[contains(@resource-id,'ll_dashboard_tab')]");

	private By lblMerchantBalance = MobileBy.xpath("//*[contains(@text,'Merchant Balance')]/following-sibling::*[2]");

	private By lblProcessingVolume = MobileBy.xpath("//*[@text='Processing Volume']");

	private By lblSaleOrderDetails = MobileBy.xpath("//*[contains(@resource-id,'tv_floating_text')]");

	private By lblRefunds = MobileBy.xpath("//*[contains(@resource-id,'gross_amount')]");

	private By lblMISCFees = MobileBy.xpath("//*[contains(@resource-id,'misc_fee')]");

	private By lblNetAmount = MobileBy.xpath("//*[contains(@resource-id,'net_amount')]");

	private By lblProcessingFees = MobileBy.xpath("//*[contains(@resource-id,'processing_fees')]");

	private By lblHighTicket = MobileBy.xpath("//*[contains(@resource-id,'highest_ticket')]");

	private By lblAverageTicket = MobileBy.xpath("//*[contains(@resource-id,'average_ticket')]");

	private By lnkViewMerchantTransactions = MobileBy.xpath("//*[contains(@resource-id,'tv_merchant_transactions')]");

	public void clickDashBoard() {
		click(btnDashBoard, "DashBoard");
	}

	public void getDashBoardHeading() {
		ExtentTestManager.setInfoMessageInReport("Dash Board Heading " + getText(lblHeading));
	}

	public void getMerchantBalance() {
		ExtentTestManager.setInfoMessageInReport("Merchant Balance " + getText(lblMerchantBalance));
	}

	public void verifyLabelProcessingVolume(String expHeading) {
		new CommonFunctions().verifyLabelText(lblProcessingVolume, expHeading, "Processing Volume");

	}

	public void getRefund() {
		scrollDownToElement(lblRefunds, "Refunds");
		ExtentTestManager.setInfoMessageInReport("Refund " + getText(lblRefunds));

	}

	public void getSaleOrder() {
		// scrollDownToElement(lblSaleOrderDetails, "Sale Order");
		ExtentTestManager.setInfoMessageInReport("Sale Order " + getText(lblSaleOrderDetails));
	}

	public void getMISCFee() {
		scrollDownToElement(lblMISCFees, "MISC Fees");
		ExtentTestManager.setInfoMessageInReport("MISC Fee " + getText(lblMISCFees));
	}

	public void getNetAmount() {
		scrollDownToElement(lblNetAmount, "Net Amount");
		ExtentTestManager.setInfoMessageInReport("Net Amount " + getText(lblNetAmount));
	}

	public void getProcessingFees() {
		scrollDownToElement(lblProcessingFees, "Processing Fees");
		ExtentTestManager.setInfoMessageInReport("Processing Fees " + getText(lblProcessingFees));
	}

	public void getHighTicket() {
		ExtentTestManager.setInfoMessageInReport("High Ticket " + getText(lblHighTicket));
	}

	public void getAverageTicket() {
		ExtentTestManager.setInfoMessageInReport("Average Ticket " + getText(lblAverageTicket));
	}

	public MerchantTransactionsPage merchantTransactionsPage() {
		return new MerchantTransactionsPage();
	}

}