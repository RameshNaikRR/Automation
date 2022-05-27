package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.AddNewPaymentComponent;
import coyni_mobile.components.BuyTokenComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.WithdrawMenuComponent;
import coyni_mobile.popups.CvvPopup;
import coyni_mobile.popups.RemovingPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PaymentMethodsPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Payment Methods']");
	private By btnAddNewPaymentMethod = MobileBy.xpath("//*[contains(@resource-id,'cvAddPayment')]");
	private By btnExternalBankAccount = MobileBy.xpath("//*[contains(@resource-id,'tvExtBHead')]");
	private By btndebitCard = MobileBy.xpath("//*[contains(@resource-id,'tvDCHead')]");
	private By btnCreditCard = MobileBy.xpath("//*[contains(@resource-id,'tvCCHead')]");
	private By bankAccountBtn = MobileBy.xpath("//*[contains(@resource-id,'lyAddExternal')]");
	private By headingAddExternalBankAccount = MobileBy.xpath("//*[contains(@text,'Add External Bank Account')]");
    private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
	private By headingAddAccount = MobileBy.xpath("//*[contains(@text,'Add Accounts')]");   
	private By txtBankName = MobileBy.xpath("//*[contains(@resource-id,'searchbar')]");
	private By selectBank = MobileBy.xpath("//*[contains(@text,'CashEdge Test Bank (Agg) - Retail Non 2FA')]");
	private By HeadingBankName = MobileBy.xpath("//*[contains(@resource-id,'selectedBankName')]");
	private By txtUserName = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt143:0:login_')]");
	private By txtPassword = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt147:0:password_')]");

	public void verifyHeading(String expHeading) {
		if (getElementList(lblHeading, "heading").size() > 0) {
			new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
		}
	}
	
	public void clickExternalBankAccount() {
		click(bankAccountBtn,"Click External Bank Account");
	}
	public void clickNext() {
		click(btnNext,"Click Next");
	}
	public void verifyHeadingAddExternalBankAccount() {
		new CommonFunctions().elementView(headingAddExternalBankAccount,"Add External Bank Account Heading is");
		}
	
	public void verifyHeadingAddAccount() {
		new CommonFunctions().elementView(headingAddAccount, "Add Account");
	}
	
	public void enterBankName(String expBankName) {
		enterText(txtBankName,expBankName,"Enter Bank Name");
	}

	public void clickAddNewPaymentMethod() {
			click(btnAddNewPaymentMethod, "Add New Payment Method");
	}

	public By getPaymentItems(String paymentMethod, String last4digits) {
		return MobileBy.xpath(String.format("//*[contains(@text,'%s')]/following-sibling::*[contains(@text,'%s')]",
				paymentMethod, last4digits));
	}

	public void verify() {
		new CommonFunctions().elementView(btnExternalBankAccount, "External Bank Account");
		new CommonFunctions().elementView(btndebitCard, "Debit Card");
		new CommonFunctions().elementView(btnCreditCard, "Credit Card");
	}

	public void clickCreditCard(String last4digits) {
		click(getPaymentItems("Credit", last4digits), "Credit");
	}

	public void clickDebitCard(String last4digits) {
		click(getPaymentItems("Debit", last4digits), "Debit");
	}

	public void clickBankAccount(String last4digits) {
		click(getPaymentItems("Bank", last4digits), "Bank");
	}

	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
	}

	public AddNewPaymentComponent addNewPaymentComponent() {
		return new AddNewPaymentComponent();
	}

	public WithdrawMenuComponent withdrawMenuComponent() {
		return new WithdrawMenuComponent();
	}

	public CvvPopup cvvPopup() {
		return new CvvPopup();
	}
	
	public void selectBank() {
		click(selectBank,"click select bank");
	}
	
	public void verifyBankNameHeading() {
		new CommonFunctions().elementView(HeadingBankName, "Bank Name");
	}
	
	public void fillUserName(String expUserName) {
		enterText(txtUserName, expUserName, "User Name");
	}
	
	public void fillPassword(String expPassword) {
		enterText(txtPassword, expPassword, "Password");
	}
	
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	
	public RemovingPopup removingPopup() {
		return new RemovingPopup();
	}
	
	
}
