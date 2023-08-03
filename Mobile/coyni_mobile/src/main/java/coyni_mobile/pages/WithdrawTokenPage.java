package coyni_mobile.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.popups.OrderPreviewPopup;
import coyni_mobile.popups.ReloadPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WithdrawTokenPage extends MobileFunctions {
	private By lblWithdrawToken = MobileBy.xpath("//*[@text='Withdraw Tokens']");
	private By lblWithdrawTokenDesc = MobileBy.xpath("//*[contains(@text,'an external bank')]");
	private By lblPmntMethodName = MobileBy.id("com.coyni.mapp:id/tvPayHead");
	private By lblCYN = MobileBy.id("com.coyni.mapp:id/tvCYN");
	private By btnDebitCard = MobileBy.xpath("(//*[contains(@text,'Debit')])[1]");
	private By btnCreditCard = MobileBy.xpath("(//*[contains(@text,'Credit')])[1]");
	private By btnBank = MobileBy.xpath("(//*[@text='MX Bank'])[1]");
	private By lblDailylimits = MobileBy.id("com.coyni.mapp:id/tvLimit");
	private By btnChangePayment = MobileBy.id("com.coyni.mapp:id/imgArrow");
	private By txtAmount = MobileBy.id("com.coyni.mapp:id/etAmount");
	private By btnWithdrawToken = MobileBy.id("com.coyni.mapp:id/keyActionLL");
	private By lblExchangeValue = MobileBy.id("com.coyni.mapp:id/tvExchange");
	private By lblAvailableBalance = MobileBy.id("com.coyni.mapp:id/tvAvailableBal");
	private By btnAddNote = MobileBy.id("com.coyni.mapp:id/etRemarks");
	private By btnDone = MobileBy.id("com.coyni.mapp:id/doneBtn");
	private By btnCancel = MobileBy.id("com.coyni.mapp:id/cancelBtn");
	private By txtAddNote = MobileBy.id("com.coyni.mapp:id/addNoteET");
	private By lblAddNoteCount = MobileBy.id("com.coyni.mapp:id/textinput_counter");

//	Withdraw screen 
	private By btnBankAccounts = MobileBy.id("com.coyni.mapp:id/lyBank");
	private By btnInstantPay = MobileBy.id("com.coyni.mapp:id/lyInstantPay");
	private By btnGiftCard = MobileBy.id("com.coyni.mapp:id/lyGiftCard");

	public By getTextOfElements(String xpath) {
		return MobileBy.xpath(String.format("//*[contains(@text,'%s')]", xpath));
	}

	public void verifyCynView() {
		if (getText(lblCYN).equals(" CYN")) {
			new CommonFunctions().elementView(lblCYN, "CYN");
		} else {
			ExtentTestManager.setFailMessageInReport("Coyni currency not as expected");
		}
	}

	public void verifyWithdrawTokenDesc(String expDesc) {
		new CommonFunctions().verifyLabelText(getTextOfElements(expDesc), "Description", expDesc);
	}

	public void verifyWithdrawHeading(String expDesc) {
		new CommonFunctions().verifyLabelText(getTextOfElements(expDesc), "Withdraw Heading", expDesc);
	}

	public void verifyWithdrawTokenHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblWithdrawToken, "Heading", hdg);
	}

	public void verifyChangePaymentView() {
		new CommonFunctions().elementView(btnChangePayment, "ChangePayment");
	}

	public void verifyPayment(String expPayment) {
		String method = getText(lblPmntMethodName);
		if (method.contains(expPayment)) {
			ExtentTestManager.setPassMessageInReport("Payment Method: " + expPayment);
		} else {
			ExtentTestManager.setFailMessageInReport("Payment method is not " + expPayment);
		}
	}

	public void clickChangePayment() {
		click(btnChangePayment, "ChangePayment");
	}

	public void viewDailyLimits() {
		new CommonFunctions().elementView(lblDailylimits, getText(lblDailylimits));
		new CommonFunctions().elementView(lblExchangeValue, getText(lblExchangeValue));
	}

	public void fillAmount(String Amount) {
		click(txtAmount, "amount");
		enterText(txtAmount, Amount, "amount");
	}

	public void fillAddNote(String note) {
		clickAddNote();
		enterText(txtAddNote, note, "amount");
		click(btnDone, "Done");
	}

	public void clickWithdrawToken() {
		click(btnWithdrawToken, "Withdraw Token");
	}

	public void verifyWithdrawToken() {
		new CommonFunctions().verifyDisabledElement(btnWithdrawToken, "Withdraw Token");
	}

	public void clickDebitCard() {
		click(btnDebitCard, "Debit Card");
	}

	public void clickCreditCard() {
		click(btnCreditCard, "Credit Card");
	}

	public void clickBank() {
		click(btnBank, "Bank");
	}

	public void clickBankAccounts() {
		click(btnBankAccounts, "Bank Account");
	}

	public void clickInstantPay() {
		click(btnInstantPay, "Instant Pay");
	}

	public void clickGiftCardPurchase() {
		click(btnGiftCard, "Gift Card");
	}

	public void clickAddNote() {
		click(btnAddNote, "Add Note");
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyAddNote(String inputText) {
		if (inputText.length() == getText(txtAddNote).length()) {
			ExtentTestManager.setPassMessageInReport("The characters count is updating properly in Add Note field");
		} else {
			ExtentTestManager.setFailMessageInReport(inputText);
		}
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}

	public ReloadPopup reloadPopup() {
		return new ReloadPopup();
	}

	public GiftCardPage giftCardPage() {
		return new GiftCardPage();
	}
}
