package coyni_mobile_merchant.popups;

import java.sql.Driver;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.graphbuilder.curve.Point;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.Direction;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.components.TransactionSucessFailurePendingComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.touch.offset.PointOption;

public class OrderPreviewPopup extends MobileFunctions {

	private By lblOrderPageHeading = MobileBy.xpath("//*[contains(@text,'Preview')]");
	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'Get')]|//*[contains(@resource-id,'amount')]");
//	private By lblCurrency = MobileBy.xpath("//*[contains(@resource-id,'CYN')]");
	private By lblPaymentMethod = MobileBy
			.xpath("//*[contains(@resource-id,'tvBankName')]|//*[contains(@resource-id,'PayMethod')]");
	private By lblPaymentMethodNumber = MobileBy
			.xpath("//*[contains(@resource-id,'tvAccount')]|//*[contains(@resource-id,'PayMethod')]");
	private By lblPurchaseAmount = MobileBy.xpath("//*[contains(@resource-id,'tvPurchaseAmt')]");
	private By lblProcessingFee = MobileBy
			.xpath("//*[contains(@resource-id,'tvProcessingFee')]|//*[contains(@resource-id,'feeTV')]");
	private By lblTotal = MobileBy.xpath("//*[contains(@resource-id,'tvTotal')]|//*[contains(@resource-id,'totalTV')]");
	private By btnSlideToConfirm = MobileBy.xpath("//*[contains(@resource-id,'slideToConfirm')]");
	private By lblAmazon = MobileBy.xpath("//*[contains(@resource-id,'giftCardTypeTV')]");
	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]");
	private By btnSideView = MobileBy.xpath("//*[contains(@resource-id,'slideToConfirm')]");
	private By lblOrderOverview = MobileBy.xpath("//*[contains(@text,'Order Overview')]");
	private By lblReceiptentAddress = MobileBy.xpath("//*[contains(@resource-id,'recipAddre')]");
	private By lblReasonForRefund = MobileBy.xpath("//*[contains(@resource-id,'messageNoteTV')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblOrderOverview, "Popup Heading", expHeading);
	}

	public void verifyAmazonHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAmazon, "Amazon", expHeading);
	}

	public void verifyRecipentEmail(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReceipentEmail, "Email", expHeading);
	}

//	public String verifySlideText() {
//		return getText(btnConfirm);
//
//	}

	public void getPaymentMethod(String expPaymentMethod) {
		String text = getText(lblPaymentMethod);
		int length = text.length();
		if (length < 9) {
			ExtentTestManager.setInfoMessageInReport("Payment Method: Card Number " + text);
		} else {
			ExtentTestManager.setInfoMessageInReport("Payment method: " + text);
		}
	}

	public void getPurchaseAmount(String expPurchaseAmount) {
		ExtentTestManager.setInfoMessageInReport("Purchase Amount: " + getText(lblPurchaseAmount));
	}

//	public void swipeConfirm() {
//		new CommonFunctions().swipeElement(btnConfirm, Direction.RIGHT);
//
//	}

	public void slideToConfirm() {
		new CommonFunctions().swipeElement(btnSideView, Direction.RIGHT);
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	private By lblHeadingOrderPre = MobileBy.xpath("//*[@text='Order Preview']");// tvTotal
	private By lblProcessingF = MobileBy.xpath("//*[contains(@resource-id,'tvProcessingFee')]");
	private By lblTotalAmount = MobileBy.xpath("//*[contains(@resource-id,'tvTotal')]");

	public void verifyOrderHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeadingOrderPre, "Order Preview", expHeading);
	}

	public void getBankProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee: " + getText(lblProcessingF) + "CYN");
	}

	public void getBankTotal() {
		ExtentTestManager.setInfoMessageInReport("Total: " + getText(lblTotalAmount) + "CYN");
	}

	public void getReceiptentAddress() {
		ExtentTestManager.setInfoMessageInReport("Receiptent Address : " + getText(lblReceiptentAddress));
	}

	public void getReasonForRefund() {
		ExtentTestManager.setInfoMessageInReport("Reason For Refund : " + getText(lblReasonForRefund));
	}

	public By getPaymentItems(String last4digits) {
		return By.xpath(String.format("//*[contains(@text,'%s')]", last4digits));
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblOrderPageHeading, "Page Heading", expHeading);
	}

	public void getAmount() {
		new CommonFunctions().elementView(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Amount : " + getText(lblAmount));
	}

	public void getPaymentMethod() {
		new CommonFunctions().elementView(lblPaymentMethod, "Payment Method");
		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(lblPaymentMethod));
		ExtentTestManager.setInfoMessageInReport("Payment Method Number is : " + getText(lblPaymentMethodNumber));
	}

	public void getPurchaseAmount() {
		new CommonFunctions().elementView(lblPurchaseAmount, "Purchase Amount");
		ExtentTestManager.setInfoMessageInReport("Purchase Amount  : " + getText(lblPurchaseAmount));
	}

	public void getProcessingFee() {
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
		ExtentTestManager.setInfoMessageInReport("Processing Fee : " + getText(lblProcessingFee));
	}

	public void getTotal() {
		new CommonFunctions().elementView(lblTotal, "Total");
		ExtentTestManager.setInfoMessageInReport("Total  : " + getText(lblTotal));
	}

	public void swipeSlideToConfirm() {
		new CommonFunctions().swipeElement(btnSlideToConfirm, Direction.RIGHT);
//		click(btnSlideToConfirm, "Slide To Confirm");
	}
	
//	public PointOption swipeSlideToConfirmLocation() {
//		WebElement element = DriverFactory.getDriver().findElement(By.xpath("//*[contains(@resource-id,'slideToConfirm')]"));
//		location = eleme
//		return (PointOption) location;
//	}

	public void orderPreviewDetails(String expHeading) {
		verifyPageHeading(expHeading);
		getAmount();
		getPaymentMethod();
		getPurchaseAmount();
		getProcessingFee();
		getTotal();
//		swipeSlideToConfirmLocation();
		swipeSlideToConfirm();
		
	}

	public void refundPreviewDetails(String expHeading) {
		verifyPageHeading(expHeading);
		getAmount();
		getReceiptentAddress();
		getProcessingFee();
		getTotal();
		getReasonForRefund();
		swipeSlideToConfirm();
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public TransactionSucessFailurePendingComponent transactionSucessFailurePendingComponent() {
		return new TransactionSucessFailurePendingComponent();
	}

}
