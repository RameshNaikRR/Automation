package coyni.customer.popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PayAndRequestTokensPopup extends BrowserFunctions {

	private By payRequest = By.xpath("//span[text()='Pay / Request Tokens']");
	private By payRequestBackground = By.className("p-3 group-hover:bg-cbl5 group-hover:bg-opacity-20 rounded-full");
	private By lblYourTokenAccount = By.xpath("//h1[text()='Your Token Account']");
	private By btnPay = By.xpath("//button[text()='Pay']");
	private By btnRequest = By.xpath("//button[text()='Request']");
	private By btnBuyToken = By.xpath("");
	private By lblNoFundsAvailable = By.xpath("");
	private By lblBuyCoyniTokens = By.xpath("");
	private By txtAmount = By.id("amount");
	private By lblAvailableBalance = By.xpath("//span[text()='Available Balance:']");
	private By txtRecipientMessage = By.xpath("//textarea[@id='message']");
	private By txtRecipientsAddress = By.xpath("//input[@id='wallet-id']");
	private By RecipientID = By.xpath("//label[contains(text(),'Recipient’s')]");
	private By countMsgToRecipient = By.xpath("//span[text()='120']");
	private By lblPayingRecipientName = By.cssSelector(".font-bold.text-cgy4.text-xl.text-center.tracking-wide.mt-2");
	private By btnNext = By.cssSelector(".w-60.h-9.rounded-full");
	private By btnCopy = By.cssSelector(".icon-copy");
	// private By lnkPaste = By.cssSelector("//button[text()='Paste']");
	// private By lblAccountHolderName = By.className("text-sm truncate text-cm3");

	public void verifyCountMessageToRecipient() {
		new CommonFunctions().elementView(countMsgToRecipient, "Message to Recipient");
	}

	public void viewPay() {
		new CommonFunctions().elementView(btnPay, "Click Pay");
	}

	public void verifycolor(String color) {
		new CommonFunctions().verifyTextBoxBorderColor(color);
	}

	public void clickPay() {
		click(btnPay, "Click Pay");

	}

//	public void checkAmountWithSpecialAndNull(String amount) {
//		new CommonFunctions().validateTextFeild(txtAmount, "Amount", amount);
//	}
//	
//
//	public void pasteOption(String address) {
//		copyDataToClipboard(address);
//		click(RecipientID, "Paste");
//		pasteOption(address);
//
//		Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
//	}

	public void viewAmount() {
		new CommonFunctions().elementView(txtAmount, "Amount");
	}

//	public void verifyWalletID() {
//		new CommonFunctions().elementView(RecipientID, "Recipient ID");
//	}

	public void cursorhoverPayRequest() {
		new CommonFunctions().verifyCursorAction(payRequest, "PayRequest");

	}

	public void clickRequest() {
		click(btnRequest, "Click Request");
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "amount");
	}

	public void fillRecipientAddress(String RecipientAddress) {
		enterText(txtRecipientsAddress, RecipientAddress, "RecipientAddress");

	}

	public void clickBuyToken() {
		click(btnBuyToken, "Buy Token");
	}

//	public void clickPasteLink() {
//		click(lnkPaste, "Click Paste");
//	}

	public void fillRecipientMessage(String RecipientMessage) {
		enterText(txtRecipientMessage, RecipientMessage, "RecipientMessage");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}

	}

	public String isFundsDisplayed(String noFundsAvailable) {

		return noFundsAvailable;

	}

//	public void verifyAccountHolderName(String expAccountHolderName) {
//		new CommonFunctions().verifyLabelText(lblAccountHolderName, "Account holder Name", expAccountHolderName);
//	}

	public RequestingAccountHolderPopup requestingAccountHolderPopup() {
		return new RequestingAccountHolderPopup();
	}

	public PayingAccountHolderNamePopup payingAccountHolderNamePopup() {
		return new PayingAccountHolderNamePopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public void verifyAmountView() {
		new CommonFunctions().elementView(txtAmount, "Amount Field");

	}

	public void verifyRecipientsAddressView() {
		new CommonFunctions().elementView(txtRecipientsAddress, "Recipient's Address");

	}

	public void verifyMessageToRecipientView() {
		new CommonFunctions().elementView(txtRecipientsAddress, "Recipient's Address");

	}

	public void verifyAccountBalanceView() {
		new CommonFunctions().elementView(lblAvailableBalance, "Available Balance");

	}

	public void clickCopy() {
		click(btnCopy, "Copy Icon");
	}

	public void verifyPayingRecipient() {
		new CommonFunctions().elementView(lblPayingRecipientName, "Paying Recipient");
	}

	public void verifyButtonPay() {
		new CommonFunctions().elementView(btnPay, "Pay Button");
	}

	public void verifyLabelYourTokenAccount() {
		new CommonFunctions().elementView(lblYourTokenAccount, "Your Token Account");

	}

//	public void validateAmountField(String singleChar, String specialCharacters) {
//		new CommonFunctions().validateFieldWithalphabet(txtAmount, "Amount", singleChar);
//		new CommonFunctions().validateFieldWithSpecialchar(txtAmount, "Amount", specialCharacters);
//
//	}
//
//	public void validateRecipientField(String lessCharLength, String maxiCharLength) {
//		new CommonFunctions().validateFieldWithalphabet(txtRecipientMessage, "Recipient Message", lessCharLength);
//		new CommonFunctions().clearText(txtRecipientMessage, "Recipient Message");
//		new CommonFunctions().validateFieldMaxichar(txtRecipientMessage, "Recipient Message", maxiCharLength);
//		new CommonFunctions().clearText(txtRecipientMessage, "Recipient Message");
//
//	}

}
