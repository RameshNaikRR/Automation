package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AddNewPaymentComponent extends MobileFunctions {
	private By lblHeading = MobileBy
			.xpath("//*[@text='Add Payment Method']|//*[@text='Add Instant Pay']|//*[@text='Add Bank Account']");
	private By lblPaymentMethods = MobileBy.id("");
	private By lblPageDes = MobileBy.id("");
	private By btnExternalBank = MobileBy.id("com.coyni.mapp:id/lyBank");
	private By btnDebitCard = MobileBy.id("com.coyni.mapp:id/tvDCardMsg");
	private By btnCreditCard = MobileBy.id("com.coyni.mapp:id/tvCCardMsg");
	private By numOfBanks = MobileBy.id("com.coyni.mapp:id/tvExtBankHead");
	private By numOfCreditCards = MobileBy.id("com.coyni.mapp:id/tvCCardHead");
	private By numOfDebitCards = MobileBy.id("com.coyni.mapp:id/tvDCardHead");
	private By methodReachdErrMsg = MobileBy.xpath("//*[contains(@text,'maximum')]");
	private By lblBankConten = MobileBy.id("");
	private By lblCreditContent = MobileBy
			.AccessibilityId("Visa, Mastercard, Discover, and American Express credit cards");
	private By lblDebitContent = MobileBy.AccessibilityId("Visa or Mastercard debit cards");
	private By lblError = MobileBy.id("");
	private By lblErrorMesg = MobileBy.id("");
	private By btnOK = MobileBy.id("");
	private By lblMaxLimit = MobileBy.AccessibilityId("This method has reached maximum 4 cards");
	private By lblCoyni = MobileBy.AccessibilityId("coyni");
	private By lblerrorText = MobileBy.id("");
	private By lblAddNewPayment = MobileBy.AccessibilityId("Add Payment Method");
	private By btnAddNewPaymentPlus = MobileBy
			.xpath("//*[contains(@resource-id,'AddPayment')]|//*[contains(@resource-id,'AddPay')]");
	private By btnBank = MobileBy.xpath("//*[contains(@name,'BANK')]");

	private By btnBankOne = MobileBy.xpath("(//*[contains(@name,'BANK')])[1]");
	private By btnCreditOne = MobileBy.xpath("(//*[contains(@name,'Credit Card')])[1]");
	private By btnDebitOne = MobileBy.xpath("(//*[contains(@name,'Debit Card')])[1]");

	private By btnAccountOne = MobileBy.xpath("//*[@name='Add New Payment Method']/../following-sibling::*[1]");
	private By listOfAccounts = MobileBy
			.xpath("//*[@name='Add New Payment Method']/../following-sibling:: XCUIElementTypeCell");

	private By lblCreditExpiry = MobileBy
			.xpath("//*[@name='Visa Credit Card']/following-sibling::*[2] |//*[contains(@name,'Visa Credit')]/../*[1]");
	private By lblDEbitEXpiry = MobileBy.xpath(
			"//*[@name='Visa Debit Card']/following-sibling::*[2]|//*[contains(@name,'Visa Debit')]/../*[1] |(//*[contains(@name,'Mastercard Debit')]/../*[1])[2]");
	private By lblDebitExp = MobileBy.xpath("(//*[contains(@name,'Mastercard Debit')]/../*[1])[3]");

	private By imgEdit = MobileBy.AccessibilityId("edited Green");
	private By imgDelete = MobileBy.AccessibilityId("Icon feather trash");
	private By btnBack = MobileBy.AccessibilityId("back");
	private By lblRemoving = MobileBy.AccessibilityId("Removing");
	private By btnNo = MobileBy.xpath("(//*[contains(@name,'No')])[2]");
	private By btnYes = MobileBy.xpath("(//*[contains(@name,'Yes')])[2]");
	private By lblOOPS = MobileBy.AccessibilityId("Oops");
	private By txtOops = MobileBy.AccessibilityId("Seems like you have an issue with your card");
	private By btnRemove = MobileBy.xpath("(//*[@name='Remove'])[2]");
	private By btnEdit = MobileBy.xpath("(//*[@name='Edit'])[2]");
	private By btnClose = MobileBy.AccessibilityId("close");
	private By lblFee = MobileBy.AccessibilityId("close");
	private By lblNoToken = MobileBy.AccessibilityId("No Token Available");
	private By lblCardView = MobileBy.id("com.coyni.mapp:id/tvCardNumber");

	public Integer getPresentDebitCards() {
		String[] str = getText(numOfDebitCards).replace("(", "").replace(")", "").split("/");
		int num = Integer.parseInt(str[0]);
		return num;
	}

	public Integer getPresentCreditCards() {
		String[] str = getText(numOfCreditCards).replace("(", "").replace(")", "").split("/");
		int num = Integer.parseInt(str[0]);
		return num;
	}

	public Integer getPresentBanks() {
		String[] str = getText(numOfBanks).replace("(", "").replace(")", "").split("/");
		int num = Integer.parseInt(str[0]);
		return num;
	}

	public Integer getAddedDebitCards() {
		String[] str = getText(numOfDebitCards).replace("(", "").replace(")", "").split("/");
		int num = Integer.parseInt(str[1]);
		return num;
	}

	public Integer getAddedCreditCards() {
		String[] str = getText(numOfCreditCards).replace("(", "").replace(")", "").split("/");
		int num = Integer.parseInt(str[1]);
		return num;
	}

	public void verifyErrMsg(String expText) {
		new CommonFunctions().verifyLabelText(methodReachdErrMsg, "Payment methods Reachd Maximum Err Msg", expText);
	}

	public void verifyDebitCards(String expText) {
		new CommonFunctions().verifyLabelText(numOfDebitCards, "Debit Cards", expText);
	}

	public void verifyCreditCards(String expText) {
		new CommonFunctions().verifyLabelText(numOfCreditCards, "Credit Cards", expText);
	}

	public int verifyCoyniView() {
		return getElementList(lblCoyni, "Coyni").size();
	}

	public void viewCard() throws InterruptedException {
		Thread.sleep(500);
		if (getElementList(lblCardView, "Fee").size() == 1) {
			ExtentTestManager.setPassMessageInReport("The Card is added and appeared in Payment Methods");
		} else {
			ExtentTestManager.setFailMessageInReport("The Card is not added and not appeared in Payment Methods");
		}
	}

	public void verifyMaxlimit(String expTxt) {

		new CommonFunctions().verifyLabelText(lblMaxLimit, "Max limit", expTxt);

	}

	public void verifyAddNewPaymentHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddNewPayment, "Heading", expHeading);
	}

	public int verifyAddPaymentSize() {

		return getElementList(lblHeading, "Heading").size();

	}

	public void verifyPaymentMethodsHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblPaymentMethods, "PaymentMethods", hdg);
	}

	public void verifyErrorTextView() {

		new CommonFunctions().elementView(lblerrorText, "ErrorText");

		click(btnOK, "Ok");

	}

	public void verifyAddPaymentMethodView() {

		new CommonFunctions().elementView(lblHeading, "Add Payment method");

	}

	public void clickAddNewPaymentPlusIcon() throws InterruptedException {
		clickAddNewPayment();
	}

	public int verifyAddNewPaymentPlusIcon() throws InterruptedException {
		Thread.sleep(800);
		return getElementList(btnAddNewPaymentPlus, "Add New Payment Method").size();
	}

	public void verifyErrorView() {

		new CommonFunctions().elementView(lblError, "Error");

	}

	public void verifyErrorMessage(String expMessage) {

		new CommonFunctions().verifyLabelText(lblErrorMesg, "Error Message", expMessage);

	}

	public void clickOk() {

		click(btnOK, "Ok");

	}

	public By getNumbersList(String account) {

		return MobileBy
				.xpath(String.format("//*[@name='%s']/following-sibling::XCUIElementTypeStaticText[1]", account));

	}

	public void verifyBankNums() {

		ExtentTestManager.setInfoMessageInReport("Bank Number is " + getText(getNumbersList(("Bank Account"))));

		// new CommonFunctions().verifyLabelText(getNumbersList("Bank Account"),
		// "bankNumbers", bankNumbers);

	}

	public void verifyCardNums(String cardNums) {

		new CommonFunctions().verifyLabelText(getNumbersList("Debit Card"), "cardNums", cardNums);

	}

	public void verifyCreditCardNums(String cardNums) {

		new CommonFunctions().verifyLabelText(getNumbersList("Credit Card"), "cardNums", cardNums);

	}

	public void verifyAddPaymentPage() {

		new CommonFunctions().elementView(lblHeading, "Add Payment Method Page");

	}

	public void verifyAddPaymentHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add Payment Heading", expHeading);
	}

	public void verifyPageText(String expText) {

		new CommonFunctions().verifyLabelText(lblPageDes, "Page Description ", expText);

	}

	public void clickBankAcount() {
		click(btnExternalBank, "Bank Account");
	}

	public void verifyDebitContent(String content) {

		new CommonFunctions().verifyLabelText(lblDebitContent, "Debit card label", content);

	}

	public void clickDebitCard() throws InterruptedException {
		click(btnDebitCard, "Debit Card");
	}

	public void verifyCreditContent(String content) {

		new CommonFunctions().verifyLabelText(lblCreditContent, "Credit card label", content);

	}

	public void clickCreditCard() {

		click(btnCreditCard, "Credit Card");

	}

//    public AddExternalBankAccountComponent addExternalBankAccountComponent() {
//
//        return new AddExternalBankAccountComponent();
//
//    }

	public void verifyExternalBankView() {

		new CommonFunctions().elementView(btnExternalBank, "External Bank Account");

	}

	public void verifyCreditCardView() {

		new CommonFunctions().elementView(btnCreditCard, "Credit card");

	}

	public void verifyCreditCardText(String expCreditText) {

		new CommonFunctions().verifyLabelText(lblCreditContent, "Credit Card Description ", expCreditText);

	}

	public void verifyDebitCardView() {

		new CommonFunctions().elementView(btnDebitCard, "Debit Card");

	}

	public void verifyDebitCardText(String expDebitText) {

		new CommonFunctions().verifyLabelText(lblDebitContent, "Debit Card Description ", expDebitText);

	}

	public NavigationComponent navigationComponent() {

		return new NavigationComponent();

	}

	public AddCardComponent addCardComponent() {

		return new AddCardComponent();

	}

	public void verifyNotOken() {
		new CommonFunctions().elementView(lblNoToken, "No Tokens Available");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void clickBAck() {
		click(btnBack, "Back");
	}

	public void verifyCreditCardExpiry() {
		new CommonFunctions().elementView(lblCreditExpiry, "Credit card Is Expired");
		ExtentTestManager.setInfoMessageInReport("Credit Card is :" + getText(lblCreditExpiry));
	}

	public void verifyWithdrawDebitOOPSCondition() {
		click(lblDebitExp, "DebitExpiry");
		new CommonFunctions().elementView(lblOOPS, "OOPS");
		ExtentTestManager.setInfoMessageInReport("the text is :" + getText(txtOops));
		new CommonFunctions().elementView(btnRemove, "Remove");
		click(btnEdit, "Edit");
		click(btnBack, "Back");
	}

	public void verifyCreditOOPSCondition() {
		click(lblCreditExpiry, "CreditExpiry");
		new CommonFunctions().elementView(lblOOPS, "OOPS");
		ExtentTestManager.setInfoMessageInReport("the text is :" + getText(txtOops));
		new CommonFunctions().elementView(btnRemove, "Remove");
		click(btnEdit, "Edit");
		click(btnBack, "Back");
	}

	public void verifyDebitOOPSCondition() {
		click(lblDEbitEXpiry, "DebitExpiry");
		new CommonFunctions().elementView(lblOOPS, "OOPS");
		ExtentTestManager.setInfoMessageInReport("the text is :" + getText(txtOops));
		new CommonFunctions().elementView(btnRemove, "Remove");
		click(btnEdit, "Edit");
		click(btnBack, "Back");
	}

	public void verifyEditAndDeleteCreditCard() {
		swipeOnElement(lblCreditExpiry, "Credit Card", SwipeDirection.LEFT);
		click(imgEdit, "Edit");
		click(btnBack, "Back");
		swipeOnElement(lblCreditExpiry, "Credit Card", SwipeDirection.LEFT);
		click(imgDelete, "Delete");
		new CommonFunctions().elementView(lblRemoving, "Removing");
		new CommonFunctions().elementView(btnYes, "Yes");
		click(btnNo, "No");
	}

	public void verifyEditAndDeleteDebitCard() {
		swipeOnElement(lblDEbitEXpiry, "Debit Card", SwipeDirection.LEFT);
		click(imgEdit, "Edit");
		click(btnBack, "Back");
		swipeOnElement(lblDEbitEXpiry, "Debit Card", SwipeDirection.LEFT);
		click(imgDelete, "Delete");
		new CommonFunctions().elementView(lblRemoving, "Removing");
		new CommonFunctions().elementView(btnYes, "Yes");
		click(btnNo, "No");
	}

	public void verifyDebitCardExpiry() {
		new CommonFunctions().elementView(lblDEbitEXpiry, "Credit card Is Expired");
		ExtentTestManager.setInfoMessageInReport("Debit Card is :" + getText(lblDEbitEXpiry));
	}

	public void selectAccount() {
		click(btnAccountOne, "account");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPaymentMethodsPageView() {
		new CommonFunctions().elementView(lblHeading, "Payment Methods Page");
	}

	public void clickAddNewPayment() {
		click(btnAddNewPaymentPlus, "Add New Payment Method");
	}

	public By getPaymentItems(String paymentMethod, String last4digits) {
		return MobileBy.xpath(String.format("//*[contains(@name,'%s')]//following-sibling::*[contains(@name,'%s')]",
				paymentMethod, last4digits));
	}

	public int verifyNumofAccounts() {
		return getElementList(listOfAccounts, "list Of Accounts").size();

	}

	public int verifyNumOfDebitCards() {
		return getElementList(btnDebitCard, "Debit Card").size();
	}

	public int verifyNumOfCreditCards() {
		return getElementList(btnCreditCard, "Credit Card").size();
	}

	public int verifyNumOfBanks() {
		return getElementList(btnBank, "Bank").size();
	}

	public void clickCreditCard(String last4digits) {

		click(getPaymentItems("Credit", last4digits), "Credit");
	}

	public void clickDebitCards() {
		click(btnDebitCard, "Debit Card");
	}

	public void clickDebitCard(String last4digits) {
		// click(btnDebitCard, "Debit");
		click(getPaymentItems("Debit", last4digits), "Debit");
	}

	public void clickBankAccount(String last4digits) {
		click(getPaymentItems("Bank", last4digits), "Bank");
	}

	public void clickSignetAccount(String last4digits) {
		click(getPaymentItems("Signet", last4digits), "Signet");
	}

	public void getPaymentPage() {
		if (getElement(lblPaymentMethods, "heading").isDisplayed()) {
			clickAddNewPayment();
		}
	}

	public void getPaymentPages() {
		if (getElementList(lblPaymentMethods, "heading").size() > 0) {
			clickAddNewPayment();
		} else {
			ExtentTestManager.setInfoMessageInReport("no payment methods");
		}
	}

	public MXBankComponent mxBankComponent() {
		return new MXBankComponent();
	}

	public EditCardComponent editCardComponent() {
		return new EditCardComponent();
	}
	///////////////////////////////////////////////////////////

//    public AddManualBankComponent addManualBankComponent() {
//
//        return new AddManualBankComponent();
//
//    }
}
