package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class OrderPreviewPopup extends MobileFunctions {

//	private By headingOrderPreview = MobileBy.xpath("//*[@text='Order Overview']");      //  

	private By lblAmazon = MobileBy.xpath("//*[contains(@resource-id,'giftCardTypeTV')]"); //

	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]"); ///

	private By btnSideView = MobileBy.xpath("//*[contains(@resource-id,'slideToConfirm')]"); //

	private By lblOrderPreview = MobileBy.xpath("//*[@text='Order Overview']");

	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'giftCardAmountTV')]");
	private By lblPaymentMethod = MobileBy
			.xpath("(//*[@name='Payment Method']/following-sibling::XCUIElementTypeStaticText)[1]");
	private By lblPurchaseAmount = MobileBy.xpath("//*[@name='Purchase Amount']/following-sibling::*[1]");
	private By lblProcessingFee = MobileBy.xpath("//*[contains(@resource-id,'feeTV')]");
	private By lblTotal = MobileBy.xpath("//*[contains(@resource-id,'totalTV')]");
	private By btnConfirm = MobileBy
			.xpath("//*[contains(@resource-id,'tv_lable')]|//*[contains(@resource-id,'slideToConfirm')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblOrderPreview, "Popup Heading", expHeading);
	}

	public void verifyAmazonHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAmazon, "Amazon", expHeading);
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblAmount) + " CYN");
	}

	public void verifyRecipentEmail(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReceipentEmail, "Email", expHeading);
	}

	public String verifySlideText() {
		return getText(btnConfirm);

	}

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

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee: " + getText(lblProcessingFee));
	}

	public void getTotal() {
		ExtentTestManager.setInfoMessageInReport("Total: " + getText(lblTotal));
	}

	public void swipeConfirm() {
		swipeOnElement(btnConfirm, "Confirm", SwipeDirection.RIGHT);
	}

	public void slideToConfirm() {
		swipeOnElement(btnSideView, "Purchased", SwipeDirection.RIGHT);
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
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

	public By getPaymentItems(String last4digits) {
		return By.xpath(String.format("//*[contains(@text,'%s')]", last4digits));
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
