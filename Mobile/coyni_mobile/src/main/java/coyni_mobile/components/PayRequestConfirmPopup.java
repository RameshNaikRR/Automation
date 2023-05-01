package coyni_mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.Direction;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import io.appium.java_client.MobileBy;

public class PayRequestConfirmPopup extends MobileFunctions {

	private By heading = MobileBy
			.xpath("//*[contains(@text, 'Transaction Successful')]|//*[contains(@resource-id, 'payingToTV')]");
	private By lnkCopy = MobileBy.xpath(" ");
	private By amount = MobileBy
			.xpath("//*[contains(@resource-id, 'giftCardAmountTV')]|//*[contains(@resource-id, 'amountTV')]");
	private By lblPayingMehtod = MobileBy.xpath("//*[@text='Paying Method']");
	private By lblRecipientAddress = MobileBy.xpath("//*[@text='Recipient’s Address']");
	private By lblAvailabelBalance = MobileBy.xpath("//*[contains(@resource-id, 'balanceTV')]");
	private By senderName = MobileBy.xpath("//*[contains(@resource-id, 'myUserIDTV')]");
	private By message = MobileBy.xpath("//*[contains(@resource-id, 'messageTV')]");
	private By btnConfirm = MobileBy
			.xpath("//*[contains(@resource-id, 'slideToConfirm')]|//*[contains(@resource-id,'im_lock')]");// *[@name='Slide
																											// to
	// confirm']/../.. ,
	private By lblReferenceID = MobileBy.xpath("//*[contains(@resource-id,'refIDTV')]");
	private By lock = MobileBy.xpath("//*[contains(@resource-id, 'im_lock')]");
	// private By lblAvailableBalance = MobileBy.xpath(" ");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id, 'doneCV')]");

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
		new CommonFunctions().elementView(lblPayingMehtod, "Paying Method");
		new CommonFunctions().elementView(lblRecipientAddress, "Recipient Address");
		new CommonFunctions().elementView(lblAvailabelBalance, "Available Balance");
		new CommonFunctions().elementView(senderName, "Sender Name");
		new CommonFunctions().elementView(message, "Message");
	}

	public void swipeConfirm() {

		//new CommonFunctions().swipeElement(btnConfirm, Direction.RIGHT);
		swipeOnElement(btnConfirm, "Swipe Right", SwipeDirection.RIGHT);
	}

	public void getAvailableBalance() {

	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public ForgotPinComponent forgotPinComponent() {
		return new ForgotPinComponent();
	}

	public SecurePayPopup securePayPopup() {
		return new SecurePayPopup();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	public TransactionDetailsComponent2 transactionDetailsComponent2() {
		return new TransactionDetailsComponent2();
	}
}
