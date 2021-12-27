package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class OrderPreviewPopup extends MobileFunctions {

	private By lblOrderPreview = MobileBy.xpath("//*[@name='Order Preview']");
	private By lblAmount = MobileBy.xpath("//*[@name='Order Preview']/following-sibling::*[1]");
	private By lblPaymentMethod = MobileBy
			.xpath("(//*[@name='Payment Method']/following-sibling::XCUIElementTypeStaticText)[1]");
	private By lblPurchaseAmount = MobileBy.xpath("//*[@name='Purchase Amount']/following-sibling::*[1]");
	private By lblProcessingFee = MobileBy.xpath("//*[@name='Processing Fee']/following-sibling::*[1]");
	private By lblTotal = MobileBy.xpath("//*[@name='Total']/following-sibling::*[1]");
	private By btnConfirm = MobileBy.xpath("//*[@name='Slide to confirm']/../..");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblOrderPreview, "Popup Heading", expHeading);
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblAmount) + " CYN");
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
	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}
}
