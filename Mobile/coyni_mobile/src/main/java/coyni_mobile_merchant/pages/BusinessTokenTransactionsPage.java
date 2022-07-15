//package coyni_mobile_merchant.pages;
//
//import org.openqa.selenium.By;
//
//import coyni_mobile.utilities.CommonFunctions;
//import ilabs.MobileFramework.MobileFunctions;
//import ilabs.mobile.reporting.ExtentTestManager;
//import io.appium.java_client.MobileBy;
//
//public class BusinessTokenTransactionsPage extends MobileFunctions {
//	
//	private By lblTokensHeading = MobileBy.xpath("//*[contains(@text,'Transaction')]");
//
//	private By btnSearch = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");
//
//	
//	public void verifyPageHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblHeading, "Business Token Account Heading", expHeading);
//
//	}
//
//	public void verifyPageDescription(String expDescription) {
//		new CommonFunctions().verifyLabelText(lblDescription, "Description", expDescription);
//
//	}
//
//	public void verifyTotalAvailableFunds(String expTotal) {
//		new CommonFunctions().verifyLabelText(lblTotalFunds, expTotal, "Total Availble Funds Heading is :");
//
//	}
//
//	public void getTotalAvailableFunds() {
////		scrollDownToElement(lblTotalAmount, "Total Availble Funds : ");
//		ExtentTestManager.setInfoMessageInReport("Total Availble Funds is : " + getText(lblTotalAmount));
//
//	}
//
//	public void getTransactionStatus() {
//		// scrollDownToElement(lblSaleOrderDetails, "Sale Order");
//		ExtentTestManager.setInfoMessageInReport("Recent Transaction Status is " + getText(lblTransactionStatus));
//	}
//
//}
