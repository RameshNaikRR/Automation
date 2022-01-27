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
	private By masterCard = MobileBy.xpath("//*[contains(@resource-id,'imgPayMethod')]");
	private By debitCard = MobileBy.xpath("//*[contains(@resource-id,'tvPayMethod')]");
	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By optionaltxt = MobileBy.xpath("//*[contains(@resource-id,'etRemarks')]");
	private By txtmsg = MobileBy.xpath("//*[contains(@resource-id,'addNoteET')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'cancelBtn')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'doneBtn')]");
	private By lnkConvert = MobileBy.xpath("//*[contains(@resource-id,'imgConvert')]");
	private By lbldailyLimit = MobileBy.xpath("//*[contains(@resource-id,'tvLimit')]");
	private By lblAvailableBalance = MobileBy.xpath("//*[contains(@resource-id,'tvAvailableBal')]");
	private By withdrawTokenHeading = MobileBy.xpath("//*[@text='Withdraw Token']");
	private By withdraw = MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");
	private By exchangeRate = MobileBy.xpath("//*[contains(@resource-id,'tvExchange')]");
	private By instantPayHeading = MobileBy.xpath("//*[contains(@resource-id,'tvPayHead')]");
	private By addNewPaymentMethod = MobileBy.xpath("//*[@text='Add New Payment Method']");

	public void fillAmount(String Amount) {
		new EnterYourPINComponent().fillPin(Amount);
		ExtentTestManager.setInfoMessageInReport("Entered Amount: " + Amount);
	}

	public void enterMessage(String Message) {
		click(optionaltxt, "optional message");
		enterText(txtmsg, Message, "message");

	}

	public void clickOnAddNewPaymentMethod() {
		click(addNewPaymentMethod, "Add New Payment Method");
	}

	public void verifyAddInstantPayHeading(String expheading) {
		new CommonFunctions().verifyLabelText(instantPayHeading, "Instant Pay Heading", expheading);
	}

	public String getAvailabeBalance() {
		return getText(lblAvailableBalance);
	}

	public String verifyVisaCards() {
		return getText(visaCard);
	}

	public String verifyMasterCards() {
		return getText(masterCard);
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
		new CommonFunctions().verifyLabelText(withdrawTokenHeading, "Withdraw Token", expHeading);
	}

	public void txtMessage(String txt) {
		enterText(txtmsg, txt, "TransactionalMessage");
	}

	public By getPaymentItems(String last4digits) {
		return By.xpath(String.format("//p[contains(text(),'%s')]", last4digits));
	}

	public By getPaymentItems(String paymentMethod, String last4digits) {
		return MobileBy.xpath(String.format("//*[contains(@text,'%s')]/following-sibling::*[contains(@text,'%s')]",
				paymentMethod, last4digits));
	}

	public void clickDebitCard(String last4digits) {
		click(getPaymentItems("Debit", last4digits), "Debit");
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