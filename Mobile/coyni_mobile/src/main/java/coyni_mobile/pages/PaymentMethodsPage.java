package coyni_mobile.pages;

import org.openqa.selenium.By;
import coyni_mobile.components.AddNewPaymentComponent;
import coyni_mobile.components.BuyTokenComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.WithdrawMenuComponent;
import coyni_mobile.popups.CvvPopup;
import coyni_mobile.popups.RemovingPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PaymentMethodsPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Payment Methods']");
	private By btnAddNewPaymentMethod = MobileBy.xpath("//*[contains(@text,'Add New Payment')]|//*[contains(@resource-id,'cvAddPayment')]");
	private By btnExternalBankAccount = MobileBy.xpath("//*[contains(@resource-id,'tvExtBHead')]");
	private By btndebitCard = MobileBy.xpath("//*[contains(@resource-id,'tvDCHead')]");
	private By btnCreditCard = MobileBy.xpath("//*[contains(@resource-id,'tvCCHead')]");
	private By bankAccountBtn = MobileBy.xpath("//*[contains(@resource-id,'lyAddExternal')]");
	private By headingAddExternalBankAccount = MobileBy.xpath("//*[contains(@text,'Add External Bank Account')]");
	private By btnNext = MobileBy.xpath("//*[contains(@text,'Next')]");
	private By headingAddAccount = MobileBy.xpath("//*[contains(@text,'Add Accounts')]");
	private By txtBankName = MobileBy.xpath("//*[contains(@resource-id,'searchbar')]");
	private By selectBank = MobileBy.xpath("(//*[contains(@text,'Bank Account')])[1]|(//*[contains(@resource-id,'tvBankName')])[1]");
	private By HeadingBankName = MobileBy.xpath("//*[contains(@resource-id,'selectedBankName')]");
	private By txtUserName = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt143:0:login_')]");
	private By txtPassword = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt147:0:password_')]");
	private By chkbxBank = MobileBy.xpath("(//*[contains(@resource-id,'accountCheckbox')])[1]");
	private By btnDebitCard = MobileBy.xpath("(//*[contains(@text,'Debit')])[1]");
	private By btncreditCard = MobileBy.xpath("(//*[contains(@text,'Visa Credit')])[1]");
	private By btnDebitCards = MobileBy.xpath("//*[contains(@resource-id,'tvCardNumber')]");
	private By btncreditCards = MobileBy.xpath("//*[contains(@text,'Credit')]");
	private By btnBank = MobileBy.xpath("//*[contains(@text,'Bank Account')]");
	private By numberOfBankAccounts = MobileBy.xpath("//*[contains(@resource-id,'tvExtBankHead')]");
	private By numberOfDebitCards = MobileBy.xpath("//*[contains(@resource-id,'tvDCardHead')]");
	private By numberOfCreditCards = MobileBy.xpath("//*[contains(@resource-id,'tvCCardHead')]");
	

	public void verifyBankAccounts() {
		ExtentTestManager.setPassMessageInReport("Deleted the All Bank Accounts and Present Bank Account Number is : "+getText(numberOfBankAccounts));	
	}
	
	public void verifyDebitCards() {
		ExtentTestManager.setPassMessageInReport("Deleted the All Debit Cards and Debit Card Number is : "+getText(numberOfDebitCards));	
	}
	
	public void verifyCreditCards() {
		ExtentTestManager.setPassMessageInReport("Deleted the All Credit Cards and Credit Card Number is : "+getText(numberOfCreditCards));	
	}
	
	public int verifyNumOfDebitCards() {
		return getElementList(btnDebitCards, "Debit Card").size();
	}
	
	public int verifyNumOfCreditCards() {
		return getElementList(btncreditCards, "Credit Cards").size();
	}
	
	public int verifyNumOfBanks() {
		return getElementList(btnBank, "Bank Account").size();
	}
	
	public void verifyHeading(String expHeading) {
		if (getElementList(lblHeading, "heading").size() > 0) {
			new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
		}
	}

	public void clickExternalBankAccount() {
		click(bankAccountBtn, "Click External Bank Account");
	}

	public void clickNext() {
//		boolean NextButton = verifyElementDisplayed(btnNext, "Next");
//		if (NextButton) {
//			click(btnNext, "Click Next");
//		} else {
		scrollDownToElement(btnNext, "Next");
		click(btnNext, "Next");
//		}

	}

	public void verifyHeadingAddExternalBankAccount() {
		new CommonFunctions().elementView(headingAddExternalBankAccount, "Add External Bank Account Heading is");
	}

	public void verifyHeadingAddAccount() {
		new CommonFunctions().elementView(headingAddAccount, "Add Accounts");
	}

	public void enterBankName() {
		enterText(txtBankName, "CashEdge Test Bank (Agg) - Retail Non 2FA", "Enter Bank Name");
	}

	public void clickAddNewPaymentMethod() throws InterruptedException {
		Thread.sleep(2000);
		if (getElementList(btnAddNewPaymentMethod, "Add New Payment Method").size() > 0) {
			click(btnAddNewPaymentMethod, "Add New Payment Method");
		}
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

	public void clickCreditCard() {
		click(btncreditCard,"Credit Card");
	}

	public void clickDebitCard() {
		click(btnDebitCard, "Debit Card");
	}

//	public void clickBankAccount(String last4digits) {
//		click(getPaymentItems("Bank", last4digits), "Bank");
//	}

	public void clickBankAccount() {
		click(selectBank, "Bank");
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
		click(selectBank, "click select bank");
	}

	public void clickChkbxBank() {
		click(chkbxBank, "Bank check box");
	}

	public void verifyBankNameHeading() {
		new CommonFunctions().elementView(HeadingBankName, "Bank Name");
	}

	public void fillUserName() {
		enterText(txtUserName, "script1", "User Name");
	}

	public void fillPassword() {
		enterText(txtPassword, "cashedge1", "Password");
		DriverFactory.getDriver().hideKeyboard();
		new CommonFunctions().clickEnter();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public RemovingPopup removingPopup() {
		return new RemovingPopup();
	}

	public CustomerProfilePage customerProfilePage() {
		return new CustomerProfilePage();
	}

	public void AddBankFromBuyToken() throws InterruptedException {
		customerProfilePage().paymentMethodsPage().verifyHeadingAddAccount();
		customerProfilePage().paymentMethodsPage().enterBankName();
		Thread.sleep(2000);
		customerProfilePage().paymentMethodsPage().selectBank();
		Thread.sleep(2000);
		customerProfilePage().paymentMethodsPage().fillUserName();
		customerProfilePage().paymentMethodsPage().fillPassword();
//		customerProfilePage().paymentMethodsPage().clickNext();
		Thread.sleep(30000);
		customerProfilePage().paymentMethodsPage().verifyHeadingAddAccount();
		customerProfilePage().paymentMethodsPage().clickChkbxBank();
		customerProfilePage().paymentMethodsPage().clickNext();
	}
}
