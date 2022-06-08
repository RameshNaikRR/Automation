package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BusinessTransactionsPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'TokenAccount')]");

	private By lblTotalFunds = MobileBy.xpath("//*[contains(@text,'Merchant Balance')]/following-sibling::*[2]");

	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Recent Token ')]");

	private By lblTotalAmount = MobileBy.xpath("//*[contains(@resource-id,'tv_floating_text')]");

	private By btnTransaction = MobileBy.xpath("//*[contains(@resource-id,'gross_amount')]");

	private By lblTransactionStatus = MobileBy.xpath("//*[contains(@resource-id,'misc_fee')]");

	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'net_amount')]");

	private By lblTransaction = MobileBy.xpath("//*[contains(@resource-id,'processing_fees')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading,"Business Token Account Heading", expHeading);

	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription,"Description" , expDescription);

	}

	public void verifyTotalAvailableFunds(String expTotal) {
		new CommonFunctions().verifyLabelText(lblTotalFunds, expTotal, "Total Availble Funds Heading is :");

	}

	public void getTotalAvailableFunds() {
//		scrollDownToElement(lblTotalAmount, "Total Availble Funds : ");
		ExtentTestManager.setInfoMessageInReport("Total Availble Funds : " + getText(lblTotalAmount));

	}

	public void getTransactionStatus() {
		// scrollDownToElement(lblSaleOrderDetails, "Sale Order");
		ExtentTestManager.setInfoMessageInReport("Transaction Status" + getText(lblTransactionStatus));
	}

	public void getAmount() {
//		scrollDownToElement(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Amount" + getText(lblAmount));
	}

	public void clickTransaction() {
		click(btnTransaction, "Transaction");
	}

//	public void getNetAmount() {
//		scrollDownToElement(lblNetAmount, "Net Amount");
//		ExtentTestManager.setInfoMessageInReport("Net Amount " + getText(lblNetAmount));
//	}
//
//	public void getProcessingFees() {
//		scrollDownToElement(lblProcessingFees, "Processing Fees");
//		ExtentTestManager.setInfoMessageInReport("Processing Fees " + getText(lblProcessingFees));
//	}
//
//	public void getHighTicket() {
//		ExtentTestManager.setInfoMessageInReport("High Ticket " + getText(lblHighTicket));
//	}
//
//	public void getAverageTicket() {
//		ExtentTestManager.setInfoMessageInReport("Average Ticket " + getText(lblAverageTicket));
//	}

	public BusinessTransactionDetailsPage businessTransactionDetailsPage() {
		return new BusinessTransactionDetailsPage();
	}

}
