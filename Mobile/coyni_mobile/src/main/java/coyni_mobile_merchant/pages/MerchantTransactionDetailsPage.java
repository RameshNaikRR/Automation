package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.NavigationComponent;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class MerchantTransactionDetailsPage extends MobileFunctions {

	private By btnDashBoard = MobileBy.xpath("//*[contains(@resource-id,'ll_dashboard_tab')]");

	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'userNameTV')]");

	private By lblAccountVerified = MobileBy.xpath("//*[contains(@resource-id,'tv_officially_verified')]");

	private By btnIcon = MobileBy.xpath("//*[contains(@resource-id,'iv_user_icon')]");

	private By btnCompanyName = MobileBy.xpath("//*[contains(@resource-id,'title')]");

	private By monthlyVolumeLimit = MobileBy.xpath("(//*[contains(@resource-id,'tv_monthly_volume')])[2]");

	private By highTicketLimit = MobileBy.xpath("//*[contains(@resource-id,'tv_high_tickets')]");

	private By lblMerchantBalance = MobileBy.xpath("//*[contains(@resource-id,'merchant_balance_tv')]");

	private By name = MobileBy.xpath("//*[contains(@resource-id,'tvUserInfo')]");

	private By btnNotificationIcon = MobileBy.xpath("//*[contains(@resource-id,'iv_notifications')]");

	private By lblMerchant = MobileBy.xpath("//*[@text='Merchant Balance']");

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

	public void clickNotification() {
		click(btnNotificationIcon, "Notification");
	}

	public void clickIcon() {
		click(btnIcon, "Profile Icon");
	}

	public void clickCompanyName() {
		click(btnCompanyName, "Company Name");
	}

	public void getMonthlyVolumeLimit() {
		String text = getText(monthlyVolumeLimit);
		ExtentTestManager.setInfoMessageInReport("Monthly Volume Limit: " + text);
	}

	public void getHighTicketLimit() {
		String text = getText(highTicketLimit);
		ExtentTestManager.setInfoMessageInReport("High Ticket Limit: " + text);
	}

	public void getName() {
		String text = getText(name);
		ExtentTestManager.setInfoMessageInReport("Name: " + text);
	}

	public void getUserName() {
		String text = getText(lblUserName);
		ExtentTestManager.setInfoMessageInReport("User Name: " + text);
	}

	public void getAccountVerified() {
		String text = getText(lblAccountVerified);
		ExtentTestManager.setInfoMessageInReport("Account Verified: " + text);
	}

	public void getMerchantBalance() {
		String text = getText(lblMerchantBalance);
		ExtentTestManager.setInfoMessageInReport("Merchant Balance " + text);
	}

	public void verifyLabelMerchantBalance(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMerchant, expHeading, "Merchant Balance");

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

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}