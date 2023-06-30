package coyni_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.Direction;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SendRequestPaymentPage extends MobileFunctions {
	private By heading = MobileBy.AccessibilityId(
			"//*[contains(@text, 'Transaction Successful')]|//*[contains(@resource-id, 'payingToTV')]");
	private By lnkCopy = MobileBy.AccessibilityId(" ");
	private By amount = MobileBy
			.AccessibilityId("//*[contains(@resource-id, 'giftCardAmountTV')]|//*[contains(@resource-id, 'amountTV')]");
	private By lblPayingMehtod = MobileBy.AccessibilityId("//*[@text='Paying Method']");
	private By lblRecipientAddress = MobileBy.AccessibilityId("//*[@text='Recipient’s Address']");
	private By lblAvailabelBalance = MobileBy.AccessibilityId("//*[contains(@resource-id, 'balanceTV')]");
	private By senderName = MobileBy.AccessibilityId("//*[contains(@resource-id,'myUserIDTV')]");
	private By message = MobileBy.AccessibilityId("//*[contains(@resource-id,'messageTV')]");
	private By btnConfirm = MobileBy
			.AccessibilityId("//*[contains(@resource-id, 'slideToConfirm')]|//*[contains(@resource-id,'im_lock')]");// *[@name='Slide
	private By lblReferenceID = MobileBy.AccessibilityId("//*[contains(@resource-id,'refIDTV')]");
	private By lock = MobileBy.AccessibilityId("//*[contains(@resource-id, 'im_lock')]");
	// private By lblAvailableBalance = MobileBy.AccessibilityId(" ");
	private By btnDone = MobileBy.AccessibilityId("//*[contains(@resource-id,'doneCV')]|//*[@text='Done']");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Paying", expHeading);
	}

	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Transaction successfull heading");
		new CommonFunctions().elementView(amount, "Amount");
	}

	public void verifyLockSwipe() {
		new CommonFunctions().elementView(lock, "Lock ");
	}

	public String getCopiedReference() {
		String str = getCopiedData();
		return str;
	}

	public void clickCopy() {
		click(lnkCopy, "Copy");
	}

	public void verifyAmount() {
		new CommonFunctions().elementView(amount, "Amount");
	}

	public String verifySlideText() {
		return getText(btnConfirm);

	}

	public void verifyPreview() {
		new CommonFunctions().elementView(lblRecipientAddress, "Recipient Address");
		new CommonFunctions().elementView(lblAvailabelBalance, "Available Balance");
		new CommonFunctions().elementView(senderName, "Sender Name");
		new CommonFunctions().elementView(message, "Message");
	}

	public void clickConfirm() {
		click(btnConfirm, "Confirm");
	}

	public void getAvailableBalance() {

	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
