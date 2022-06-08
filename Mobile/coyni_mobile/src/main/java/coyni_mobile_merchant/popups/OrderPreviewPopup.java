package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.Direction;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.components.TransactionSucessFailurePendingComponent;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class OrderPreviewPopup extends MobileFunctions {

	private By lblOrderPageHeading = MobileBy.xpath("//*[contains(@text,'Order Preview')]");
	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'Get')]");
	private By lblCurrency = MobileBy.xpath("//*[contains(@resource-id,'CYN')]");
	private By lblPaymentMethod = MobileBy.xpath("//*[contains(@resource-id,'tvAccount')]");
	private By lblPurchaseAmount = MobileBy.xpath("//*[contains(@resource-id,'tvPurchaseAmt')]");
	private By lblProcessingFee = MobileBy.xpath("//*[contains(@resource-id,'tvProcessingFee')]");
	private By lblTotal = MobileBy.xpath("//*[contains(@resource-id,'tvTotal')]");
	private By btnSlideToConfirm = MobileBy.xpath("//*[contains(@resource-id,'slideToConfirm')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblOrderPageHeading, "Page Heading", expHeading);
	}

	public void getAmount() {
		new CommonFunctions().elementView(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Amount : " + getText(lblAmount));
	}

	public void getCurrency() {
		new CommonFunctions().elementView(lblCurrency, "Currency");
		ExtentTestManager.setInfoMessageInReport("Currency in  : " + getText(lblCurrency));
	}

	public void getPaymentMethod() {
		new CommonFunctions().elementView(lblPaymentMethod, "Payment Method");
		ExtentTestManager.setInfoMessageInReport("Payment Method : " + getText(lblPaymentMethod));
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

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public TransactionSucessFailurePendingComponent transactionSucessFailurePendingComponent() {
		return new TransactionSucessFailurePendingComponent();
	}

}
