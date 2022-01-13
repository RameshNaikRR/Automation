package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.AddCardComponent;
import coyni.customer.components.AuthyComponent;
import coyni.customer.components.EditandDeleteComponent;
import coyni.customer.components.MailingAddressComponent;
import coyni.customer.components.NavigationComponent;
import coyni.customer.components.PaymentMethodsComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawViaInstantPay extends BrowserFunctions {
	private By debitCard = By.xpath("(//p[@class='text-sm font-semibold text-cgy4'])[1]");
	private By txtAmount = By.xpath("//input[@class='CynField_cyn_input__31vZ6']");
	private By lblmsg = By.cssSelector("");
	private By txtmsg = By.cssSelector("");
	private By lnkConvert = By.id("flip-button");
	private By lnkChange = By.xpath("//span[text()='Change']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lblheading = By.xpath("//h1[text()='Withdraw via Instant Pay']");
	private By lblChooseHeading = By
			.xpath("//h3[@class=' mt-10 text-xl font-bold text-center text-cgy4 tracking-wide']");
	private By editCard = By.xpath("(//button[@class='ml-2 icon-edit BuyTokenPaymentMethod_action_icon__2nonE'])[1]");
	private By deleteCard = By
			.xpath("(//button[@class=' ml-2 icon-trash BuyTokenPaymentMethod_action_icon__2nonE'])[1]");
	private By debitCardView = By.xpath("(//span[@class='text-xs font-semibold text-cgy4'])[2]");
	private By lbldailyLimit = By.xpath("//h2[@class='text-cgy2 text-xs font-sans text-center mt-3']");
	private By btnRadioDebit = By.xpath("(//input[@name='buy-token-radio'])[1]");
	private By btnAddNewDebit = By.xpath("//span[contains(text(),'Add New Debit Card')]");
	private By toggle = By.xpath("//img[@src='/static/media/Flip-Icon.ec69897c.svg']");

	public void enterAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");

	}

	public void enterMessage(String Message) {
		enterText(txtmsg, Message, "Message");

	}

	public String getDailyLimit() {
		return getText(lbldailyLimit, "Daily Limit");

	}

	public void verifyToggleBackgroundColor(String cssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(toggle, "Toggle", cssProp, expValue, expColor);
	}

	public void verifyInstantPayDebitCardBackgroundcolor(String cssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(debitCard, "Debit Card", cssProp, expValue, expColor);
	}

	public void clickEdit() {
		click(editCard, "Edit Card");
	}

	public void clickDelete() {
		click(deleteCard, "Delete Card");
	}

	public void clickOnDebitCard() {
		click(debitCard, "Debit card");
	}

	public void VerifyErrorMessage(String ErrorMessage) {
		new CommonFunctions().verifyLabelText(lblmsg, ErrorMessage, "ErrorMessage");
	}

	public void clickOnConvertLink() {
		click(lnkConvert, "Click Convert");
	}

	public void verifyLabelDebitCardView() {
		new CommonFunctions().elementView(debitCardView, "Debit Card");
	}

	public void verifyLabelHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblheading, "Withdraw Via Instant Pay", expHeading);
	}

	public void clickOnChangeLink() {
		click(lnkChange, "Click Delete");
	}

	public void clickOnNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PaymentMethodsComponent paymentMethodsComponent() {
		return new PaymentMethodsComponent();
	}

	public AddNewPaymentMethodPopup addNewPaymentMethodPopup() {
		return new AddNewPaymentMethodPopup();
	}

	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}

	public EditandDeleteComponent editandDeleteComponent() {
		return new EditandDeleteComponent();
	}

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}

	public PreAuthorizationPopup preAuthorizationPopup() {
		return new PreAuthorizationPopup();
	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}

	public PaymentMethodEditSuccessfullyPopup paymentMethodEditSuccessfullyPopup() {
		return new PaymentMethodEditSuccessfullyPopup();
	}

	public void verifyAddDebitCard(String expCardName, String expCardNumber, String expCVV, String expiry,
			String address1, String address2, String city, String state, String zipCode, String country) {
		if (verifyElementDisplayed(btnRadioDebit, "Debit Card")) {
			verifyDebitCardFlow();
		} else {
			click(btnAddNewDebit, "Add New Debit Card");
			verifyAddNewDebitCard(expCardName, expCardNumber, expCVV, expiry, address1, address2, city, state, zipCode,
					country);
			click(btnNext, "Next");

		}

	}

	public void verifyDebitCardFlow() {
		new CommonFunctions().elementView(lblChooseHeading, "Choose Your Instant Pay Source ");
		moveToElement(btnRadioDebit, "Moved to Radio Button");
		new CommonFunctions().elementView(deleteCard, "Delete Card");
		new CommonFunctions().elementView(editCard, "Edit Card");
	}

	public void verifyAddNewDebitCard(String expCardName, String expCardNumber, String expiry, String expCVV,
			String address1, String address2, String city, String state, String zipCode, String country) {
		addCardComponent().fillNameOnCard(expCardName);
		addCardComponent().fillCardNumber(expCardNumber);
		addCardComponent().fillCardExpiry(expiry);
		addCardComponent().fillCVVorCVC(expCVV);
		mailingAddressComponent().fillAddress1(address1);
		mailingAddressComponent().fillAddress2(address2);
		mailingAddressComponent().fillCity(city);
		mailingAddressComponent().selectState(state);
		mailingAddressComponent().fillZipCode(zipCode);
		mailingAddressComponent().verifyCountry(country);

	}

	public void verifyEditDebitCard(String expCardName, String expiry, String address1, String address2, String city,
			String state, String zipCode, String country) {
		addCardComponent().fillNameOnCard(expCardName);
		addCardComponent().fillCardExpiry(expiry);
		mailingAddressComponent().fillAddress1(address1);
		mailingAddressComponent().fillAddress2(address2);
		mailingAddressComponent().fillCity(city);
		mailingAddressComponent().selectState(state);
		mailingAddressComponent().fillZipCode(zipCode);
		mailingAddressComponent().verifyCountry(country);

	}

}
