package coyni.merchant.popups;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.PhoneVerificationComponent;
import coyni.reusable.components.ProcessingFeeComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawViaInstantPayPopup extends BrowserFunctions {

	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//h1[.='Withdraw via Instant Pay']");
	private By btnDebitCard = By.xpath("(//input[@name='buy-token-radio'])[1]");
	private By lblNoDebitCards = By.xpath("//h2[.='No Debit Cards Exist']");
	private By noDebitCardsDescription = By.xpath("//p[starts-with(.,'If')]");
	private By btnAddNewDebitCard = By.id("small-add-payment-button");
	private By lblChooseYourInstantPay = By.xpath("//h3[.='Choose Your Instant Pay Source:']");
	private By lblMsg = By.xpath("//h2[starts-with(.,'Instant')]");
	private By lblDailyLimitMsg = By.xpath("//h2[contains(@class,'font-sans ')]");
	private By txtAmount = By.cssSelector("#amount");
	private By IconCoyni = By.xpath("//input[@id='amount']/following-sibling::span");
	private By IconDollar = By.xpath("//input[@id='amount']/preceding-sibling::span");
	private By btnConvert = By.xpath("//button[@class='group flex flex-col justify-center items-center ']");
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
	private By btnRadioDebit = By.xpath("(//input[@name='buy-token-radio'])[1]");

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

	public void clickTxtMsgField(String msg) {
		click(txtMsg, "Message text field");
		enterText(txtMsg, "Message", msg);
	}

	public void clickAddNewDebitCard() {
		click(btnAddNewDebitCard, "Add New Debit Card");
	}

	public void clickConvert() {
		click(btnConvert, "Click on Convert");
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

	public void clickTab() throws AWTException {
		new CommonFunctions().clickOutSideElement();
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

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
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

	public void enterAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");

	}

	public void clickDebitCard(String number) {
		click(By.xpath(String.format("//p[contains(text(),'%s')]", number)), number);
		ExtentTestManager.setInfoMessageInReport("button clicked for card " + (number));
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public ProcessingFeeComponent processingFeeComponent() {
		return new ProcessingFeeComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}