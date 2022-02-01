package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WithdrawToUSDBankAccountPopup extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblWirhdrawToken = MobileBy.xpath("//*[@text='Withdraw Token']");
	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By lblAvaliableBalance = MobileBy.xpath("//*[@text='Available Balance:']");
	private By lblAvaliableAmount = MobileBy.xpath("//*[contains(@resource-id,'tvAvailableBal')]");
	private By clkMsg = MobileBy.xpath("//*[contains(@resource-id,'etRemarks')]");
	private By txtMSD = MobileBy.xpath("//*[contains(@resource-id,'addNoteET')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'doneBtn')]");
	private By btnWithdraw = MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");
	private By btnToggle = MobileBy.xpath("//*[contains(@resource-id,'ImageView')]");
	private By btnArrow = MobileBy.xpath("//*[contains(@resource-id,'imgArrow')]");
	private By lblPaymentHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By btnExternalbank = MobileBy.xpath("//*[contains(@resource-id,'tvExtBHead')]");
	private By btnAddPayment = MobileBy.xpath("//*[contains(@resource-id,'lyAddPay')]");

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public void verifyPaymentHeading(String expheading) {
		new CommonFunctions().verifyLabelText(lblPaymentHeading, "Payment Method", expheading);

	}

	public void clickAddPaymentMethod() {
		click(btnAddPayment, "Add Payment Method");
	}

	public void clickArrow() {
		click(btnArrow, "Click Arrow");
	}

	public void clickToggle() {
		click(btnToggle, "Toggle");
	}

	public void fillMSG(String msg) {
		click(clkMsg, "Click MSG");
		enterText(txtMSD, msg, "Text");
		click(btnDone, "Done");
	}

	public void clickWithdraw() {
		click(btnWithdraw, "Withdraw");
	}

	public void verifyAvaliableBalance(String expheading) {
		new CommonFunctions().verifyLabelText(lblAvaliableBalance, "Avaliable Balance", expheading);

	}

	public void verifyAmount() {
		ExtentTestManager.setInfoMessageInReport("Available Balance:" + getText(lblAvaliableAmount) + " CYN");
	}

	public void verifyWithdrawMethodHeading(String expheading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Withdraw Method", expheading);

	}

	public void addExternalBank() {
		if (getElement(btnExternalbank, "External Bank").isEnabled()) {
			click(btnExternalbank, "External Bank");
		} else {
			ExtentTestManager.setInfoMessageInReport(" Exrenal Bank limit exceeded");
		}
	}

	public void verifyWithdrawTokenHeading(String expheading) {
		new CommonFunctions().verifyLabelText(lblWirhdrawToken, "Withdraw Method", expheading);

	}

	public By getPaymentItems(String last4digits) {
		return By.xpath(String.format("//*[contains(@text,'%s')]", last4digits));
	}

	public void clickOnBank(String last4Digits) {
		click(By.xpath(String.format("//*[contains(@text,'%s')]", last4Digits)), last4Digits);
		ExtentTestManager.setInfoMessageInReport(" clicked on Bank " + (last4Digits));
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
