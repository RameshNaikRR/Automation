package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WithdrawToUSDInstantPayPopup extends MobileFunctions {

	private By visaCard = MobileBy.xpath("//*[contains(@resource-id,'imgPayMethod')]");
	private By masterCard =MobileBy.xpath("");
	private By debitCard = MobileBy.xpath("//*[contains(@resource-id,'lyPayClick')]");
	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By txtmsg = MobileBy.xpath("//*[contains(@resource-id,'addNoteET')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'cancelBtn')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'doneBtn')]");
	private By lnkConvert = MobileBy.xpath("//*[contains(@resource-id,'imgConvert')]");
	private By lbldailyLimit = MobileBy.xpath("//*[contains(@resource-id,'tvLimit')]");
	private By lblAvailableBalance = MobileBy.xpath("//*[contains(@resource-id,'tvAvailableBal')]");
	private By errMessageforInsufficientFunds = MobileBy.xpath("//*[contains(@resource-id,'tvError')]");
	private By withdrawTokenHeading = MobileBy.xpath("//*[@text='Withdraw Token']");
	private By withdraw = MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");
	private By exchangeRate = MobileBy.xpath("//*[contains(@resource-id,'tvExchange')]");

	public void fillAmount(String Amount) {
		new EnterYourPINComponent().fillPin(Amount);
		ExtentTestManager.setInfoMessageInReport("Entered Amount: " + Amount);
	}

	public void enterMessage(String Message) {
		enterText(txtmsg, Message, "Message");

	}

	public void verifyCancelAndButton() {
		new CommonFunctions().elementView(btnCancel, "Cancel");
		new CommonFunctions().elementView(btnDone, "Done");
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyExchangeRate() {
		new CommonFunctions().elementView(exchangeRate, "Exchange Rate");
	}

	public void clickWithdraw() {
		click(withdraw, "Withdraw");
	}

	public String getDailyLimit() {
		return getText(lbldailyLimit);

	}

	public void verifyWithdrawTokenHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(debitCard, getCopiedData(), getCopiedData());
	}

	public void verifyErrorMessage() {
		new CommonFunctions().elementView(errMessageforInsufficientFunds, "Error Message");
	}

	public void txtMessage(String txt) {
		enterText(txtmsg, txt, "TransactionalMessage");
	}

	public By getPaymentItems(String last4digits) {
		return By.xpath(String.format("//p[contains(text(),'%s')]", last4digits));
	}

	public void clickDebitCard(String last4Digits) {
		click(By.xpath(String.format("//p[contains(text(),'%s')]", last4Digits)), last4Digits);
		ExtentTestManager.setInfoMessageInReport("Button clicked for card " + (last4Digits));
	}

	public void clickOnDebitCard() {
		click(debitCard, "Debit card");
	}

	public void VerifyErrorMessage(String ErrorMessage) {
		new CommonFunctions().verifyLabelText(txtmsg, ErrorMessage, "ErrorMessage");
	}

	public void clickOnConvertLink() {
		click(lnkConvert, "Click Convert");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}