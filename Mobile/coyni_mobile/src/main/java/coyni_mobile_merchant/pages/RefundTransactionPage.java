package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class RefundTransactionPage extends MobileFunctions{

	private By lblHeading=MobileBy.xpath(getCopiedData());
	private By txtAmount=MobileBy.xpath(getCopiedData());
	private By lblTransactionAmount=MobileBy.xpath(getCopiedData());
	private By btnFullAmount=MobileBy.xpath(getCopiedData());
	private By btnHalfAmount=MobileBy.xpath(getCopiedData());
	private By btnReason=MobileBy.xpath(getCopiedData());
	private By btnCancel=MobileBy.xpath(getCopiedData());
	private By btnDone=MobileBy.xpath(getCopiedData());
	private By txtReason=MobileBy.xpath(getCopiedData());
	private By btnClose=MobileBy.xpath(getCopiedData());
	private By btnRefund=MobileBy.xpath(getCopiedData());

	
	
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
