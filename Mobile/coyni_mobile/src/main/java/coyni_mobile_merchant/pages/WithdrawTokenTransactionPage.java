package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.AddNewPaymentComponent;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WithdrawTokenTransactionPage extends MobileFunctions {

	private By lblPaymentMethodName = MobileBy
			.xpath("//*[contains(@resource-id,'BankName')]|//*[contains(@resource-id,'PayHead')]");
	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By btnOptionaltxt = MobileBy.xpath("//*[contains(@resource-id,'etRemarks')]");
	private By txtmsg = MobileBy.xpath("//*[contains(@resource-id,'addNoteET')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'cancelBtn')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'doneBtn')]");
	private By lnkConvert = MobileBy.xpath("//*[contains(@resource-id,'imgConvert')]");
	private By lbldailyLimit = MobileBy.xpath("//*[contains(@resource-id,'tvLimit')]");
	private By lblAvailableBalance = MobileBy.xpath("//*[contains(@resource-id,'tvAvailableBal')]");
	private By lblWithdrawTokenHeading = MobileBy.xpath("//*[@text='Withdraw Token']");
	private By btnWithdraw = MobileBy.xpath("//*[contains(@resource-id,'keyActionLL')]");
	private By exchangeRate = MobileBy.xpath("//*[contains(@resource-id,'tvExchange')]");
	private By lblInstantPayHeading = MobileBy.xpath("//*[contains(@resource-id,'Head')]");
	private By btnAddNewPaymentMethod = MobileBy.xpath("//*[@text='Add New Payment Method']");
	private By btnChangePaymentMethod = MobileBy
			.xpath("//*[contains(@resource-id,'PayMethod')]|//*[contains(@resource-id,'tvBankName')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'Close')]");

	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("After Convertion Amount is : " + getText(txtAmount));
	}

	public void enterMessage(String Message) {
		click(btnOptionaltxt, "optional message");
		enterText(txtmsg, Message, "message");

	}

	public void clickOnAddNewPaymentMethod() {
		click(btnAddNewPaymentMethod, "Add New Payment Method");
	}

	public void clickChangePaymentMethod() {
		click(btnChangePaymentMethod, "Change Payment Method");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public String getAvailabeBalance() {
		return getText(lblAvailableBalance);
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
		new CommonFunctions().clickEnabledElement(btnWithdraw, "Withdraw");
	}

	public String getDailyLimit() {
		return getText(lbldailyLimit);

	}

	public void getPaymentMethodName() {
		ExtentTestManager.setInfoMessageInReport(getText(lblPaymentMethodName));
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

//	public void clickOnDebitCard() {
//		click(debitCard, "Debit card");
//	}

	public void VerifyErrorMessage(String ErrorMessage) {
		new CommonFunctions().verifyLabelText(txtmsg, ErrorMessage, "ErrorMessage");
	}

	public void clickOnConvertLink() {
		click(lnkConvert, "Click Convert");
	}

	public void withdrawTokenTransaction(String expHeading, String Amount, String Message) {
		verifyWithdrawTokenHeading(expHeading);
		getPaymentMethodName();
		fillAmount(Amount);
		getAmount();
		clickOnConvertLink();
		getAmount();
		getAvailabeBalance();
//		enterMessage(Message);
//		clickCancel();
		enterMessage(Message);
		clickDone();
//		clickWithdraw();

	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public AddNewPaymentComponent addNewPaymentComponent() {
		return new AddNewPaymentComponent();
	}

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}

}