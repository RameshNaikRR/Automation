package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.components.BuyTokenComponent;
import coyni_mobile.popups.CvvPopup;
import coyni_mobile.popups.RemovingPopup;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.AddNewPaymentComponent;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.components.WithdrawMenuComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PaymentMethodsPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Payment Methods']");
	private By btnAddNewPaymentMethod = MobileBy.xpath("//*[contains(@text,'Add New Payment ')]");
	private By btnExternalBankAccount = MobileBy.xpath("//*[contains(@resource-id,'tvExtBHead')]");
//	private By btnSignetAccount = MobileBy.xpath("//*[contains(@resource-id,'tvSignetHead')]");
	private By btnDebitCard = MobileBy.xpath("//*[contains(@resource-id,'tvCardNumber')]");
	private By lnkBank = MobileBy.xpath("//*[contains(@text,'Bank Account')]");
	private By btnCogentAcc = MobileBy.xpath("//*[contains(@text,'Cogent Account')]");
//	private By btndebitCard = MobileBy.xpath("//*[contains(@resource-id,'tvDCHead')]");
//	private By btnCreditCard = MobileBy.xpath("//*[contains(@resource-id,'tvCCHead')]");
	private By bankAccountBtn = MobileBy.xpath("//*[contains(@resource-id,'lyAddExternal')]");
	private By headingMXBankAccount = MobileBy.xpath("//*[@text='Add Bank Account']|//*[@text='Add Bank Checking Account']");
	private By btnNext = MobileBy.xpath("//*[contains(@text,'Next')]");
	private By headingAddAccount = MobileBy.xpath("//*[contains(@text,'Add Accounts')]");
	private By txtBankName = MobileBy.xpath("//*[contains(@resource-id,'searchbar')]");
	private By selectBank = MobileBy.xpath("//*[contains(@resource-id,'ul-div-id-2')]");
	private By HeadingBankName = MobileBy.xpath("//*[contains(@resource-id,'selectedBankName')]");
	private By txtUserName = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt143:0:login_')]");
	private By txtPassword = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt147:0:password_')]");
	private By chkbxBank = MobileBy.xpath("(//*[contains(@resource-id,'accountCheckbox')])[3]");
	private By deleteBank = MobileBy.xpath("(//*[contains(@text,'Bank Account')])[1]");
	private By deleteCogent = MobileBy.xpath("(//*[contains(@text,'Cogent Account')])[1]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'PayClose')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'layoutClose')]|//*[contains(@resource-id,'ivBack')]|//*[contains(@resource-id,'PayBack')]");
//Verify Added Bank details
	private By lblBank = MobileBy.xpath("(//*[contains(@text,'Bank Account')])[1]");
	private By lblBankType = MobileBy.xpath("(//*[contains(@resource-id,'tvBankName')])[1]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 60);

	public void verifyHeading(String expHeading) {
		if (getElementList(lblHeading, "Heading").size() > 0) {
			new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
		}
	}

	public void verifyPageHeading(String expHeading) {
			new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	
	public int verifyPaymentMethodHeading() {
		return DriverFactory.getDriver().findElements(lblHeading).size();
	}

	public void clickAddNewPaymentMethod() {
		click(btnAddNewPaymentMethod, "Add New Payment Method");
	}

	public int verifyAddNewPaymentMethod() throws InterruptedException {
		Thread.sleep(2000);
		return DriverFactory.getDriver().findElements(btnAddNewPaymentMethod).size();
//		return getElement(btnAddNewPaymentMethod, "").getSize()
	}

	public void clickExternalBankAccount() {
		click(btnExternalBankAccount, "Bank Account");
	}

	public void clickCogentAccount() {
		click(btnCogentAcc, "Cogent Account");
	}

	public void clickDebitCard() {
		wait.until(ExpectedConditions.presenceOfElementLocated(btnDebitCard));
		click(btnDebitCard, "Debit Card");
	}

	public int verifyNumOfCard() throws InterruptedException {
		Thread.sleep(2000);
		return getElementList(btnDebitCard, "Debit Card").size();
	}

	public int verifyNumOfBanks() throws InterruptedException {
		Thread.sleep(2500);
		return getElementList(lnkBank, "Bank Account").size();
	}

	public int verifyNumOfCogentAccounts() throws InterruptedException {
		Thread.sleep(2000);
		return getElementList(btnCogentAcc, "Cogent Account").size();
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public AddNewPaymentComponent addNewPaymentComponent() {
		return new AddNewPaymentComponent();
	}

	public By getPaymentItems(String paymentMethod, String last4digits) {
		return MobileBy.xpath(String.format("//*[contains(@text,'%s')]/following-sibling::*[contains(@text,'%s')]",
				paymentMethod, last4digits));
	}

	public void clickDebitCard(String last4digits) {
		click(getPaymentItems("Debit", last4digits), "Debit");
	}

	public void clickBankAccount(String last4digits) {
		click(getPaymentItems("Bank Account", last4digits), "Bank Account");
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

	public void verifyAddExternalBankAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingMXBankAccount, "Add MX Bank Account Heading is",
				expHeading);
	}

	public void verifyHeadingAddAccount() {
		new CommonFunctions().elementView(headingAddAccount, "Add Accounts");
	}

	public void enterBankName() {
		enterText(txtBankName, "CashEdge Test Bank (Agg) - Retail Non 2FA", "Enter Bank Name");
	}

//	public void verify() {
//		new CommonFunctions().elementView(btnExternalBankAccount, "External Bank Account");
//		new CommonFunctions().elementView(btndebitCard, "Debit Card");
//		new CommonFunctions().elementView(btnCreditCard, "Credit Card");
//	}

	public void clickCreditCard(String last4digits) {
		click(getPaymentItems("Credit", last4digits), "Credit");
	}

	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
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

	public By getSignetItems(String paymentMethod, String last4digits) {
		return MobileBy.xpath(String.format("//*[contains(@text,'%s')]//following::*[contains(@text,'%s')]",
				paymentMethod, last4digits));
	}

	public void clickDeleteCogentAccount() {
		click(deleteCogent, "Cogent Account");
	}

	public void clickBankAccount() {
		click(deleteBank, "Delete Bank");
	}

//	Verify Added Bank
	public void verifyAddedMXBank(String heading) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblHeading));
		new CommonFunctions().verifyLabelText(lblHeading, "heading", heading);
		new CommonFunctions().elementView(lblBank, "Bank Account");
		new CommonFunctions().elementView(lblBankType, "MX Bank");
	}

}
