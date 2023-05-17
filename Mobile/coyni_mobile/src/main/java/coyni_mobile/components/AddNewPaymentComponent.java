package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.AddCardPage;
import coyni_mobile.pages.PaymentMethodsPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddNewPaymentComponent extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Add Payment Method']");
	private By btnExternalBank = MobileBy.xpath("//*[contains(@text,'External Bank')]|//*[contains(@resource-id,'tvExtBankMsg')]");
	private By btnDebitCard = MobileBy.xpath("//*[contains(@resource-id,'layoutDCard')]|//*[contains(@resource-id,'tvPayMethod')]");
	private By btnCreditCard = MobileBy.xpath("//*[contains(@resource-id,'tvCCHead')]");
	private By btnSignetAccount = MobileBy.xpath("//*[contains(@resource-id,'tvSignetHead')]");
   //2.4//
	private By lblCoyni = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblErrorMsg = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By btnOk= MobileBy.xpath("//*[contains(@resource-id,'tvAction')]|//*[@text='OK']");
	private By lblPaymentHeading= MobileBy.xpath("//*[@text='Add Payment Method']");
	private By btnCloseCard = MobileBy.xpath("//*[contains(@resource-id,'closeIV')]");
	private By lblCardHeader= MobileBy.xpath("//*[contains(@resource-id,'tvCardHead')]");
	
	public void verifyHeading(String expHeading) {
		if (getElementList(lblHeading, "Heading").size() > 0) {
			new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);

		}

	}
	public void clickCloseCard() {
		click(btnCloseCard, "Close");
	}

	public void clickExternalBankAcount() {
		click(btnExternalBank, "External Bank Account");
	}

	public void clickDebitCard() {
		click(btnDebitCard, "Debit Card");
	}
    
	public void clickCreditCard() {
		scrollDownToElement(btnCreditCard, "Credit Card");
		click(btnCreditCard, "Credit Card");
	}
	public void VerifyCardHeader() {
		new CommonFunctions().elementView(lblCardHeader, "Heading");
	}
	public int verifyErrHeading() {
		return getElementList(lblCoyni, "coyni").size();
	}
	public void verifyErrMsg() {
		new CommonFunctions().elementView(lblErrorMsg, "Error");
	}
	public int verifyPaymentHeading() throws InterruptedException {
		Thread.sleep(2000);
		return getElementList(lblPaymentHeading, "Add Payment Heading").size();
	}
	public void verifyAddPaymentView() {
		new CommonFunctions().elementView(lblPaymentHeading, "Add Payment Heading");
	}
	public void clickSignetAccount() {
		click(btnSignetAccount, "Signet Account");
	}
	public void clickOk() {
		click(btnOk, "Ok");
	}
	public AddExternalBankAccountComponent addExternalBankAccountComponent() {
		return new AddExternalBankAccountComponent();
	}

	public AddCardPage addCardPage() {
		return new AddCardPage();
	}
	public WithdrawMenuComponent withdrawMenuComponent() {
		return new WithdrawMenuComponent();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
