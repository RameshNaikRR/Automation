package coyni_mobile_merchant.pages;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.NavigationComponent;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class DashBoardPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'officially_verified')]");

	private By btnDashBoard = MobileBy.xpath("//*[contains(@resource-id,'ll_dashboard_tab')]");

	private By lblDashBoardDesc = MobileBy.xpath("//*[contains(@text,'Merchant Balance = ')]");

	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'user_name')]");

	private By lblAccountVerified = MobileBy.xpath("//*[contains(@resource-id,'tv_officially_verified')]");

	private By btnIcon = MobileBy.xpath("//*[contains(@resource-id,'iv_user_icon')]");

	private By btnCompanyName = MobileBy.xpath("//*[contains(@resource-id,'title')]");

	private By monthlyVolumeLimit = MobileBy.xpath("(//*[contains(@resource-id,'tv_monthly_volume')])[2]");

	private By highTicketLimit = MobileBy.xpath("//*[contains(@resource-id,'tv_high_tickets')]");

	private By lblMerchantBalance = MobileBy.id("com.coyni.mapp:id/merchant_balance_tv");

	private By name = MobileBy.xpath("//*[contains(@resource-id,'tvUserInfo')]");

	private By btnNotificationIcon = MobileBy.xpath("//*[contains(@resource-id,'iv_notifications')]");

	private By lblMerchant = MobileBy.xpath("//*[@text='Merchant Balance']");

	private By lblProcessingVolume = MobileBy.xpath("//*[@text='Processing Volume']");

	private By lblSaleOrderDetails = MobileBy.xpath("//*[contains(@resource-id,'tv_floating_text')]");

	private By lblRefunds = MobileBy.xpath("//*[contains(@resource-id,'gross_amount')]");

	private By lblMISCFees = MobileBy.xpath("//*[contains(@resource-id,'misc_fee')]");

	private By lblNetAmount = MobileBy.id("com.coyni.mapp:id/net_amount");

	private By lblGrossAmount = MobileBy.id("com.coyni.mapp:id/gross_amount");

	private By lblProcessingFees = MobileBy.id("com.coyni.mapp:id/processing_fees");

	private By lblHighTicket = MobileBy.xpath("//*[contains(@resource-id,'highest_ticket')]");

	private By lblAverageTicket = MobileBy.xpath("//*[contains(@resource-id,'average_ticket')]");

	private By lnkViewMerchantTransactions = MobileBy.xpath("//*[contains(@resource-id,'tv_merchant_transactions')]");

	private By lblNextPayout = MobileBy.id("com.coyni.mapp:id/nextPayoutAmountTV");

	private By lblLastPayout = MobileBy.id("com.coyni.mapp:id/lastPayoutAmountTV");

	private By lblReserBalance = MobileBy.id("com.coyni.mapp:id/tv_reserve_balance");

	private By lblReserveRule = MobileBy.id("com.coyni.mapp:id/reserveRuleTV");

	private By lblTransaction = MobileBy.id("com.coyni.mapp:id/transactions");

	public void clickDashBoard() {
		click(btnDashBoard, "DashBoard");
	}

	public void getDashBoardHeading() {
		ExtentTestManager.setInfoMessageInReport("Dash Board Heading " + getText(lblHeading));
	}

	public void getDashBoardDescription() {
		ExtentTestManager.setInfoMessageInReport("Dash Board Description is : " + getText(lblDashBoardDesc));
	}

	public void clickMerchantTransactions() {
		scrollDownToElement(lnkViewMerchantTransactions, "Merchant Transactions");
		click(lnkViewMerchantTransactions, "Merchant Transactions");
	}

	public void clickNotification() {
		click(btnNotificationIcon, "Notification");
	}

	public void VerifyUser() {
		new CommonFunctions().elementView(lblUserName, "User Name");
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
		ExtentTestManager.setInfoMessageInReport("High Ticket Limit : " + text);
	}

	public void getName() {
		String text = getText(name);
		ExtentTestManager.setInfoMessageInReport("Name : " + text);
	}

	public void getUserName() {
		String text = getText(lblUserName);
		ExtentTestManager.setInfoMessageInReport("User Name : " + text);
	}

	public void getAccountVerified() {
		String text = getText(lblAccountVerified);
		ExtentTestManager.setInfoMessageInReport("Account Verified : " + text);
	}

	public void getMerchantBalance() {
		String text = getText(lblMerchantBalance);
		ExtentTestManager.setInfoMessageInReport("Merchant Balance " + text);
	}

	public Double verifyMerchantBalance() {
		Double merchantBalance = Double.parseDouble(getText(lblMerchantBalance));
		System.out.println(merchantBalance);
		return merchantBalance;
	}

	public void validateProcessingVolume() {
		Double grossAmount = Double.parseDouble(getText(lblGrossAmount));
		System.out.println(grossAmount);
		Double netAmount = Double.parseDouble(getText(lblNetAmount));
		System.out.println(netAmount);
		Double processingFees = Double.parseDouble(getText(lblProcessingFees));
		System.out.println(processingFees);
		Double addGrossAmount = netAmount + processingFees;
		System.out.println(addGrossAmount);
		DecimalFormat df = new DecimalFormat("#.##");
		double finalGrossAmount = Double.parseDouble(df.format(addGrossAmount));
		System.out.println(finalGrossAmount);
		if (grossAmount.equals(finalGrossAmount)) {
			ExtentTestManager.setPassMessageInReport("Gross Amount is :" + getText(lblGrossAmount));
			ExtentTestManager.setPassMessageInReport("Net Amount is :" + getText(lblNetAmount));
			ExtentTestManager.setPassMessageInReport("Processing Fees is :" + getText(lblProcessingFees));
			ExtentTestManager.setPassMessageInReport("The Processing Volume Fees is validated");
		} else {
			ExtentTestManager.setFailMessageInReport("The Processing Volume Fees calculation is not valid");
		}
	}

	public double validateBatchPayouts(double befNextPayout, double befReserve) {
		scrollDownToElement(lblNextPayout, "Next Payout");
		DecimalFormat df = new DecimalFormat("#.##");
		Double nextPayout = Double.parseDouble(getText(lblNextPayout));
		Double finalnextPayout = nextPayout - befNextPayout;
		Double fnlnextPayout = Double.parseDouble(df.format(finalnextPayout));
		System.out.println(finalnextPayout);
		scrollDownToElement(lblReserBalance, "Reserve Balance");
		Double reserveBalance = Double.parseDouble(getText(lblReserBalance));
		Double finalreserBalance = reserveBalance - befReserve;
		Double finalreserBal = Double.parseDouble(df.format(finalreserBalance));
		System.out.println(finalreserBal);
		String[] reserveRule = getText(lblReserveRule).replace(" ", "").split(":");
		String[] reserRule = reserveRule[1].split("%");
		Double reserPercentage = Double.parseDouble(reserRule[0]);
		Double tranReserveBalance = (fnlnextPayout / 100) * reserPercentage;
		df.setRoundingMode(RoundingMode.UP);
		Double tranReserveBal = Double.parseDouble(df.format(tranReserveBalance));
//		double roundedReserveBal = Math.ceil(tranReserveBal * 10) / 10;
		System.out.println(tranReserveBal);
		if (finalreserBal.equals(tranReserveBal)) {
			ExtentTestManager.setPassMessageInReport("The Reserve Balance is adding based on reserve rule");
		} else {
			ExtentTestManager.setFailMessageInReport("The Reserve Balance is not adding based on reserve rule");
		}
		Double BatchPlusReserve = finalnextPayout + tranReserveBalance;
		System.out.println(BatchPlusReserve);
		Double BatchReseve = Double.parseDouble(df.format(BatchPlusReserve));
		System.out.println(BatchReseve);
		return BatchReseve;
	}

	public Double verifyBatchPayouts() {
		scrollDownToElement(lblNextPayout, "Next Payout");
		Double nextPayout = Double.parseDouble(getText(lblNextPayout));
		System.out.println(nextPayout);
		return nextPayout;
	}

	public Double verifyReserveBalance() {
		scrollDownToElement(lblReserBalance, "Reserve Balance");
		Double reserveBalance = Double.parseDouble(getText(lblReserBalance));
		System.out.println(reserveBalance);
		return reserveBalance;
	}

	public Double verifyGrossAmount() {
		Double grossAmount = Double.parseDouble(getText(lblGrossAmount));
		System.out.println(grossAmount);
		return grossAmount;

	}

	public Double verifyProcessingFee() {
		Double processingFees = Double.parseDouble(getText(lblProcessingFees));
		System.out.println(processingFees);
		return processingFees;
	}

//	public Double validateReserveBalance() {
//		scrollDownToElement(lblReserBalance, "Reserve Balance");
//		Double reserveBalance = Double.parseDouble(getText(lblReserBalance));
//		String[] reserveRule = getText(lblReserveRule).replace(" ", "").split(":");
//		String[] reserRule = reserveRule[1].split("%");
//		Double reserPercentage = Double.parseDouble(reserRule[0]);
//		Double tranReserveBalance = (nextPayout * 100) / reserPercentage;
//		Double BatchPlusReserve = nextPayout + tranReserveBalance;
//		DecimalFormat df = new DecimalFormat("#.##");
//		Double BatchReseve = Double.parseDouble(df.format(BatchPlusReserve));
//		return BatchReseve;
//	}

	public double verifyNetAmount() {
		Double netAmount = Double.parseDouble(getText(lblNetAmount));
		System.out.println(netAmount);
		return netAmount;
	}

	public int verifyTransacyions() {
		int netAmount = Integer.parseInt(getText(lblTransaction));
		System.out.println(netAmount);
		return netAmount;
	}

	public double verifyNextPayout() {
		Double nextPayout = Double.parseDouble(getText(lblNextPayout));
		System.out.println(nextPayout);
		return nextPayout;
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
		scrollDownToElement(lblSaleOrderDetails, "Sale Order");
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