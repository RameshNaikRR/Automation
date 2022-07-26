package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class RefundTransactionPage extends MobileFunctions{

	private By lblHeading=MobileBy.xpath("//*[contains(@text,'Refund Transaction')]");
	private By txtAmount=MobileBy.xpath("//*[contains(@resource-id,'refundAmount')]");
	private By lblTransactionAmount=MobileBy.xpath("//*[contains(@resource-id,'refundCurrency')]");
	private By btnFullAmount=MobileBy.xpath("//*[contains(@text,'Full Amount')]");
	private By btnHalfAmount=MobileBy.xpath("//*[contains(@text,'1/2 Amount')]");
	private By btnReason=MobileBy.xpath("//*[contains(@text,'Reason for Refund')]");
	private By btnCancel=MobileBy.xpath("//*[contains(@text,'Cancel')]");
	private By btnDone=MobileBy.xpath("//*[contains(@text,'Done')]");
	private By txtReason=MobileBy.xpath("(//*[contains(@resource-id,'Message')])[1]");
	private By btnClose=MobileBy.xpath("//*[contains(@resource-id,'RefundbackIV')]");
	private By btnRefund=MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");

	
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Refund Heading", expHeading);
	}
	
	public void fillAmount(String expAmount) {
		enterText(txtAmount, expAmount, "Amount");
	}
	
	public void getTransactionAmount() {
		ExtentTestManager.setInfoMessageInReport("Transaction Amount is : " + getText(lblTransactionAmount));
	}
	
	public void clickFullAmount() {
		click(btnFullAmount, "Full Amount");
	}
	
	public void clickHalfAmount() {
		click(btnHalfAmount, "Half Amount");
	}
	
	public void clickReason() {
		click(btnReason, "Reason");
	}
	
	public void clickCancel() {
		click(btnCancel, "Cancel");
	}
	
	public void clickDone() {
		click(btnDone, "Done");
	}
	
	public void fillReason(String expReason) {
		enterText(txtReason, expReason, "Reason");
	}
	
	public void clickClose() {
		click(btnClose, "Close");
	}
	
	public void clickRefund() {
		click(btnRefund, "Refund");
	}
}
