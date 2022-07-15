package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.Direction;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class RefundPopUp extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("");
	private By lblAmount = MobileBy.xpath("");
	private By lblRecipientAdd = MobileBy.xpath("");
	private By lblProcessingFee = MobileBy.xpath("");
	private By lblTotal = MobileBy.xpath("");
	private By lblReason = MobileBy.xpath("");
	private By btnSlideToConfirm = MobileBy.xpath("");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Refund Heading is ", expHeading);
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Transaction Amount is : " + lblAmount);
	}

	public void getRecipientAddress() {
		ExtentTestManager.setInfoMessageInReport("Recipient's Address : " + lblRecipientAdd);
	}

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee : " + lblProcessingFee);
	}

	public void getTotal() {
		ExtentTestManager.setInfoMessageInReport("Total : " + lblTotal);
	}

	public void getReason() {
	ExtentTestManager.setInfoMessageInReport("Reason for Refund is : " + lblReason);
	}

	public void swipeConfirm() {
		new CommonFunctions().swipeElement(btnSlideToConfirm, Direction.RIGHT);
	}
}
