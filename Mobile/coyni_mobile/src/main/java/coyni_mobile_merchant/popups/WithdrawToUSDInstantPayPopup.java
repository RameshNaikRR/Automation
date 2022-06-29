package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WithdrawToUSDInstantPayPopup extends MobileFunctions {

	private By visaCard = MobileBy.xpath("//*[contains(@text,'Visa')]");
	private By masterCard = MobileBy.xpath("//*[contains(@text,'Mastercard')]");
	private By debitCard = MobileBy.xpath("//*[contains(@resource-id,'tvPayMethod')]");
	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By optionaltxt = MobileBy.xpath("//*[contains(@resource-id,'etRemarks')]");
	private By txtmsg = MobileBy.xpath("//*[contains(@resource-id,'addNoteET')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'cancelBtn')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'doneBtn')]");
	private By lnkConvert = MobileBy.xpath("//*[contains(@resource-id,'imgConvert')]");
	private By lbldailyLimit = MobileBy.xpath("//*[contains(@resource-id,'tvLimit')]");
	private By lblAvailableBalance = MobileBy.xpath("//*[contains(@resource-id,'tvAvailableBal')]");
	private By lblWithdrawTokenHeading = MobileBy.xpath("//*[@text='Withdraw Token']");
	private By btnWithdraw = MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");
	private By exchangeRate = MobileBy.xpath("//*[contains(@resource-id,'tvExchange')]");
	private By lblInstantPayHeading = MobileBy.xpath("//*[contains(@resource-id,'Head')]");
	private By btnAddNewPaymentMethod = MobileBy.xpath("//*[@text='Add New Payment Method']");

	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Entered Amount: " + Amount);
	}

	public void enterMessage(String Message) {
		click(optionaltxt, "optional message");
		enterText(txtmsg, Message, "message");

	}

	public void clickOnAddNewPaymentMethod() {
		click(btnAddNewPaymentMethod, "Add New Payment Method");
	}

	public void verifyAddInstantPayHeading(String expheading) {
		new CommonFunctions().verifyLabelText(lblInstantPayHeading, "Instant Pay Heading", expheading);
	}

	public String getAvailabeBalance() {
		return getText(lblAvailableBalance);
	}

	public void verifyVisaCards() {
		int size = getElementList(visaCard, "").size();
		ExtentTestManager.setInfoMessageInReport(size + " Visa Card is there.");
	}

	public void verifyMasterCards() {
		int size = getElementList(masterCard, "").size();
		ExtentTestManager.setInfoMessageInReport(size + " Master card is there.");
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
		click(btnWithdraw, "Withdraw");
	}

	public String getDailyLimit() {
		return getText(lbldailyLimit);

	}

	public void verifyWithdrawTokenHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawTokenHeading, "Withdraw Token", expHeading);
	}

	public void txtMessage(String txt) {
		enterText(txtmsg, txt, "TransactionalMessage");
	}

	private By getPaymentItems(String Card) {
		return By.xpath(String.format("//*[contains(@text,'Debit')]", Card));
	}

	public void clickDebitCard() {
		click(getPaymentItems("Debit"), "Debit Card");
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