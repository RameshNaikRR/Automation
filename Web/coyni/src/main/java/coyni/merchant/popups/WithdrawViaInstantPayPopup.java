package coyni.merchant.popups;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawViaInstantPayPopup extends BrowserFunctions {

	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//h1[.='Withdraw via Instant Pay']");
	private By lblNoDebitCards = By.xpath("//h2[.='No Debit Cards Exist']");
	private By noDebitCardsDescription = By.xpath("//p[starts-with(.,'If')]");
	private By btnAddNewDebitCard = By.id("small-add-payment-button");
	private By lblChooseYourInstantPay = By.xpath("//h3[.='Choose Your Instant Pay Source:']");
	private By lblMsg = By.xpath("//h2[starts-with(.,'Instant')]");

	private By lblDailyLimitMsg = By.xpath("//h2[contains(@class,'font-sans ')]");
	private By txtAmount = By.cssSelector("#amount");
	private By IconCoyni = By.xpath("//input[@id='amount']/following-sibling::span");
	private By IconDollar = By.xpath("//input[@id='amount']/preceding-sibling::span");
	private By btnCoyniConvert = By.cssSelector("#flip-button");
	private By lblErrorMsg = By.xpath("//p[.='Amount is required']");
	private By lblAvailableBlnc = By.xpath("//span[.='Available Balance:']/..");
	private By lblConvertion = By.xpath("//span[.='Available Balance:']/../following-sibling::div");
	private By lblBank = By.xpath("//span[contains(.,'Visa')]/../..");
	private By lnkChange = By.xpath("//span[.='Change']");
	private By txtMsg = By.xpath("#message");
	private By txtPlaceHolder = By.xpath("//label[.='Transaction Description (Optional)']");
	private By lblMsgTransaction = By.xpath("//p[contains(.,'Your transaction')]");
	private By btnNext = By.xpath("//button[.='Next']");

	private By lblTransactions = By.xpath("//span[@class='text-cgy4 text-sm']");
	private By btnConfirm = By.xpath("//button[.='Confirm']");

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyNoDebitCardsExistLbl() {
		String lbl = getText(lblNoDebitCards, "");
		ExtentTestManager.setInfoMessageInReport(lbl + " is displayed");
	}

	public void verifyNoDebitCardsDescription() {
		String lbl = getText(noDebitCardsDescription, "");
		ExtentTestManager.setInfoMessageInReport(lbl + " is displayed");
	}

	public void clickAddNewDebitCard() {
		click(btnAddNewDebitCard, "Add New Debit Card");
	}

	public void verifyChooseYourInstantPaySource() {
		String lbl = getText(lblChooseYourInstantPay, "");
		ExtentTestManager.setInfoMessageInReport(lbl + " is displayed");
	}

	public void verifyChooseYourInstantPaySourceMsg() {
		String lbl = getText(lblMsg, "");
		ExtentTestManager.setInfoMessageInReport(lbl + " is displayed");
	}

	public void verifyDailyLimitMsg() {
		cf.elementView(lblDailyLimitMsg, "Daily Limit Message ");
	}

	public void clickAmount() {
		click(txtAmount, "Amount text field");
	}

	public void verifyCoyniIcon() {
		cf.elementView(IconCoyni, "CYN Icon");
	}

	public void verifyDollarIcon() {
		cf.elementView(IconDollar, "$ Icon");
	}

	public void verifyCoyniConvertion() {
		cf.elementView(btnCoyniConvert, "Coyni Convertion");
	}

	public void clickCoyniConvertion() {
		click(btnCoyniConvert, "Coyni Convertion");
	}

	public void verifyErrorMsg() {
		getText(lblErrorMsg, "Error Message");
	}

	public void verifyAvailableBalncLabel() {
		cf.elementView(lblAvailableBlnc, "Available balance");
	}

	public void verifyCoyniToDollar() {
		cf.elementView(lblConvertion, "Coyni to Dollar");
	}

	public void verifyLblBank() {
		cf.elementView(lblBank, "Bank");
	}

	public void clickTxtMsg() {
		click(txtMsg, "Message text field");
	}

	public void verifyTxtFieldPlaceHolder() {
		String text = getText(txtPlaceHolder, "");
		ExtentTestManager.setInfoMessageInReport(text + "Place Holder is displayed");
	}

	public void verifylblMsgTransaction() {
		String text = getText(lblMsgTransaction, "");
		ExtentTestManager.setInfoMessageInReport(text + "Message is displayed");
	}

	public void verifyNextBtn() {
		cf.elementView(btnNext, "Next");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void verifyTransactions() {
		List<WebElement> list = getElementsList(lblTransactions, "");
		for (WebElement one : list) {
			String text = one.getText();
			String Value = getText(By.xpath(String.format("//span[.='%s']/following-sibling::span", text)), "");
			ExtentTestManager.setInfoMessageInReport(text + " Amount is " + Value);
		}
	}

	public void verifyConfirm() {
		cf.elementView(btnConfirm, "Confirm");
	}

	public void clickConfirm() {
		click(btnConfirm, "Confirm");
	}

	public AddNewDebitCardPopup addNewDebitCardPopup() {
		return new AddNewDebitCardPopup();
	}

	public ChooseYourInstantPaySourcePopup chooseYourInstantPaySourcePopup() {
		return new ChooseYourInstantPaySourcePopup();
	}
	
	public void validateTextFields() {
		
				addNewDebitCardPopup().fillNameOnCard("cardName");
				addNewDebitCardPopup().fillCardNumber("cardNumber");
				new CommonFunctions().validateFormErrorMessage("Name is required");

				addNewDebitCardPopup().fillCardExpiry("cardExpiry");
				new CommonFunctions().validateFormErrorMessage("Card Number");

				addNewDebitCardPopup().fillCardCVVorCVC("cardCVV");
				new CommonFunctions().validateFormErrorMessage("Card Expiry");

				addNewDebitCardPopup().fillBillingAddress1("billingAddress1");
				new CommonFunctions().validateFormErrorMessage("Card CVV");

				addNewDebitCardPopup().fillCity("city");
				new CommonFunctions().validateFormErrorMessage("Billing Address 1");
				
				addNewDebitCardPopup().clickStateDrpDwn();
				new CommonFunctions().validateFormErrorMessage("City");
				
				addNewDebitCardPopup().fillZipCode("zipCode");
				new CommonFunctions().validateFormErrorMessage("State");
				
				new CommonFunctions().clickOutSideElement();
				new CommonFunctions().validateFormErrorMessage("Zip code");
	
	}

//	private By debitCard = By.xpath("(//p[@class='text-sm font-semibold text-cgy4'])[1]");
//	private By txtAmount = By.xpath("//input[@name='amount']");
//	private By lblmsg = By.xpath("//label[text()='Transaction Description (Optional)']");
//	private By txtmsg = By.xpath("//textarea[@name='message']");
//	private By instantPayColor = By.xpath("(//button[@class='payment-method-button '])[2]");
//	private By lnkConvert = By.xpath("//button[@class='group flex flex-col justify-center items-center ']");
//	private By lnkChange = By.xpath("//span[text()='Change']");
//	private By btnNext = By.xpath("//button[text()='Next']");
//	private By lblheading = By.xpath("//h1[text()='Withdraw via Instant Pay']");
//	private By lblChooseHeading = By
//			.xpath("//h3[@class=' mt-10 text-xl font-bold text-center text-cgy4 tracking-wide']");
//	private By editCard = By.xpath("(//button[@class='ml-2 icon-edit BuyTokenPaymentMethod_action_icon__2nonE'])[1]");
//	private By deleteCard = By
//			.xpath("(//button[@class=' ml-2 icon-trash BuyTokenPaymentMethod_action_icon__2nonE'])[1]");
//	private By debitCardView = By.xpath("(//span[@class='text-xs font-semibold text-cgy4'])[2]");
//	private By lbldailyLimit = By.xpath("//h2[@class='text-cgy2 text-xs font-sans text-center mt-3']");
//	private By btnRadioDebit = By.xpath("(//input[@name='buy-token-radio'])[1]");
//	private By btnAddNewDebit = By.xpath("//span[contains(text(),'Add New Debit Card')]");
//	private By toggle = By.xpath("//img[@src='/static/media/Flip-Icon.ec69897c.svg']");
//	private By errMessageforInsufficientFunds = By.xpath("//p[text()='Insufficient funds']");
//
//	public void enterAmount(String Amount) {
//		enterText(txtAmount, Amount, "Amount");
//
//	}
//
//	public void enterMessage(String Message) {
//		enterText(txtmsg, Message, "Message");
//
//	}
//
//	public String getDailyLimit() {
//		return getText(lbldailyLimit, "Daily Limit");
//
//	}
//
//	public void verifyErrorMessage() {
//		new CommonFunctions().elementView(errMessageforInsufficientFunds, "Error Message");
//	}
//
//	public void txtMessage(String txt) {
//		enterText(txtmsg, txt, "TransactionalMessage");
//	}
//
//	public By getPaymentItems(String last4digits) {
//		return By.xpath(String.format("//p[contains(text(),'%s')]", last4digits));
//	}
//
//	public void clickDebitCard(String last4Digits) {
//		//moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", last4Digits)), "Debit");
//		List<WebElement> lst = getElementsList(btnRadioDebit, "Debit");
//		int i = lst.size();
//		if(i<1) {
//		click(By.xpath(String.format("//p[contains(text(),'%s')]", last4Digits)), last4Digits);
//		clickOnNext();
//		ExtentTestManager.setInfoMessageInReport("Button clicked for card " + (last4Digits));
//	}
//		else {
//			clickOnNext();
//		}
//	}
//	public void verifyToggleBackgroundColor(String cssProp, String expValue, String expColor) {
//		new CommonFunctions().verifyChangedColor(toggle, "Toggle", cssProp, expValue, expColor);
//	}
//
//	public void verifyInstantPayDebitCardBackgroundcolor(String cssProp, String expValue, String expColor) {
//		new CommonFunctions().verifyChangedColor(instantPayColor, "Instant Pay", cssProp, expValue, expColor);
//	}
//
//	public void clickEdit() {
//		click(editCard, "Edit Card");
//	}
//
//	public void clickDelete() {
//		click(deleteCard, "Delete Card");
//	}
//
//	public void clickOnDebitCard() {
//		click(debitCard, "Debit card");
//	}
//
//	public void VerifyErrorMessage(String ErrorMessage) {
//		new CommonFunctions().verifyLabelText(lblmsg, ErrorMessage, "ErrorMessage");
//	}
//
//	public void clickOnConvertLink() {
//		click(lnkConvert, "Click Convert");
//	}
//
//	public void verifyLabelDebitCardView() {
//		new CommonFunctions().elementView(debitCardView, "Debit Card");
//	}
//
//	public void verifyLabelHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblheading, "Withdraw Via Instant Pay", expHeading);
//	}
//
//	public void clickOnChangeLink() {
//		click(lnkChange, "Clicked On ChangeDebitCard");
//	}
//
//	public void clickOnNext() {
//		click(btnNext, "Next");
//	}
//
//	public OrderPreviewPopup orderPreviewPopup() {
//		return new OrderPreviewPopup();
//	}
//
//	public AuthyComponent authyComponent() {
//		return new AuthyComponent();
//	}
//
//	public NavigationComponent navigationComponent() {
//		return new NavigationComponent();
//	}
//
//	public PaymentMethodComponent paymentMethodsComponent() {
//		return new PaymentMethodComponent();
//	}
//
//	public AddNewPaymentMethodPopup addNewPaymentMethodPopup() {
//		return new AddNewPaymentMethodPopup();
//	}
//
//	public AddCardComponent addCardComponent() {
//		return new AddCardComponent();
//	}
//
//	public EditandDeleteComponent editandDeleteComponent() {
//		return new EditandDeleteComponent();
//	}
//
//	public MailingAddressComponent mailingAddressComponent() {
//		return new MailingAddressComponent();
//	}
//
//	public PreAuthorizationPopup preAuthorizationPopup() {
//		return new PreAuthorizationPopup();
//	}
//
//	public RemovePaymentMethodPopup removePaymentMethodPopup() {
//		return new RemovePaymentMethodPopup();
//	}
//
//	public PaymentMethodEditSuccessfullyPopup paymentMethodEditSuccessfullyPopup() {
//		return new PaymentMethodEditSuccessfullyPopup();
//	}
//
//	public AccountLimitsComponent accountLimitsComponent() {
//		return new AccountLimitsComponent();
//	}
//
//    public void clickDebitCard() {
//		
//		List<WebElement> lst = getElementsList(btnRadioDebit, "Radio Button");
//	    int i = lst.size();
//	    for(int j=1;j<4;j++) {
//		  if(i==j) {
//		    clickDebitCard("5169");
//		  }
//	   }
//		  clickOnNext();		  
//    }
//	
//	public void verifyAddDebitCard(String expCardName, String expCardNumber, String expCVV, String expiry,
//			String address1, String address2, String city, String state, String zipCode, String country)
//			throws InterruptedException {
//		if (verifyElementDisplayed(btnRadioDebit, "Debit Card")) {
//			verifyDebitCardFlow();
//		} else {
//			click(btnAddNewDebit, "Add New Debit Card");
//			verifyAddNewDebitCard(expCardName, expCardNumber, expCVV, expiry, address1, address2, city, state, zipCode,
//					country);
//			click(btnNext, "Next");
//
//		}
//
//	}
//
//	public void verifyDebitCardFlow() throws InterruptedException {
//		new CommonFunctions().elementView(lblChooseHeading, "Choose Your Instant Pay Source ");
//		moveToElement(btnRadioDebit, "Moved to Radio Button");
//		new CommonFunctions().elementView(deleteCard, "Delete Card");
//		moveToElement(btnRadioDebit, "Moved to Radio Button");
//		Thread.sleep(2000);
//		new CommonFunctions().elementView(editCard, "Edit Card");
//	}
//
//	public void clickOnDelete() {
//		click(deleteCard, "Delete Card");
//	}
//
//	public void clickOnEdit() {
//		click(editCard, "Edit Card");
//	}
//
//	public void clickOnAddNewDebitCard() {
//		click(btnAddNewDebit, "Add New Debit Card");
//
//	}
//
//	public void verifyAddNewDebitCard(String expCardName, String expCardNumber, String expiry, String expCVV,
//			String address1, String address2, String city, String state, String zipCode, String country) {
//		addCardComponent().fillNameOnCard(expCardName);
//		addCardComponent().fillCardNumber(expCardNumber);
//		addCardComponent().fillCardExpiry(expiry);
//		addCardComponent().fillCVVorCVC(expCVV);
//		mailingAddressComponent().fillAddress1(address1);
//		mailingAddressComponent().fillAddress2(address2);
//		mailingAddressComponent().fillCity(city);
//		mailingAddressComponent().selectState(state);
//		mailingAddressComponent().fillZipCode(zipCode);
//		mailingAddressComponent().verifyCountry(country);
//
//	}
//
//	public void verifyEditDebitCard(String expCardName, String expiry, String address1, String address2, String city,
//			String state, String zipCode, String country) {
//		addCardComponent().fillNameOnCard(expCardName);
//		addCardComponent().fillCardExpiry(expiry);
//		mailingAddressComponent().fillAddress1(address1);
//		mailingAddressComponent().fillAddress2(address2);
//		mailingAddressComponent().fillCity(city);
//		mailingAddressComponent().selectState(state);
//		mailingAddressComponent().fillZipCode(zipCode);
//		mailingAddressComponent().verifyCountry(country);
//
//	}

}