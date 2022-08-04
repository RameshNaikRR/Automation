package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import ilabs.MobileFramework.DriverFactory;
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
	private By txtReason=MobileBy.xpath("//*[contains(@resource-id,'addNoteET')]");
	private By btnClose=MobileBy.xpath("//*[contains(@resource-id,'RefundbackIV')]");
	private By btnRefund=MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");
	private By btnBuyToken=MobileBy.xpath("//*[contains(@resource-id,'Buytoken')]");
	private By btnBusinessAccount=MobileBy.xpath("//*[@text='Business Token Account']");
	private By lblBuyTokenInsufficientFundsDsecription=MobileBy.xpath("//*[contains(@resource-id,'Message')]");
	private By lblInsufficientFundsHeading=MobileBy.xpath("//*[contains(@text,'Insufficient Funds')]");
	private By lblBusinessAccountInsufficientFundsDescription=MobileBy.xpath("//*[contains(@text,'Would you like to use your Business ')]");
	
//	private By lblInsufficien=MobileBy.xpath("");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Refund Heading", expHeading);
	}
	
	public void fillTransactionAmount() {
		enterText(txtAmount, getText(lblTransactionAmount), "Amount");
	}
	
	public void fillAmount(String refundAmount) {
		enterText(txtAmount, refundAmount, "Refund Amount");
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
	
	public void clickBuyToken() {
		click(btnBuyToken, "Buy Token");
	}
	
	public void clickBusinessAccount() {
		click(btnBusinessAccount, "Business Account");
	}
	
	public int verifyBuyTokenInsufficientFundsDsecription() {
		 return DriverFactory.getDriver().findElements(lblBuyTokenInsufficientFundsDsecription).size();
	}
	
	
	public int verifyBusinessAccountInsufficientFundsDescription() {
		 return DriverFactory.getDriver().findElements(lblBusinessAccountInsufficientFundsDescription).size();
	}
	
	public void verifyInsufficientFundsHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblInsufficientFundsHeading, "Insufficient Funds Heading", expHeading);
	}
	
	public void verifyBuyTokenInsufficientFundsDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblBuyTokenInsufficientFundsDsecription, "Buy Token Insufficient Funds Description ", expDescription);
	}
	
	public void VerifyBusinessAccountInsufficientFundsDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblBusinessAccountInsufficientFundsDescription, "Business Account Insufficient Funds Description", expDescription);
	}
	
	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	
}
