package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PayAndRequestTokensPopup extends BrowserFunctions {

	private By btnPay = By.cssSelector("");
	private By btnRequest = By.cssSelector("");
	private By txtAmount = By.cssSelector("");
	private By lblAvailableBalance = By.cssSelector("");
	private By lblErrorMessage = By.cssSelector("");
	private By txtRecipientsAddress = By.cssSelector("");
	private By lnkPaste = By.cssSelector("");
	private By lblYourTokenAcount = By.cssSelector("");
	private By lblPayingRecipientName = By.cssSelector("");
	private By crossIcon = By.cssSelector("");
	private By backIcon = By.cssSelector("");
	private By lblAccountHolderName = By.cssSelector("");
	private By lblTransactionFailed = By.cssSelector("");
	private By txtRecipientMessage = By.cssSelector("");
	private By btnNext = By.cssSelector("");

	public void clickPay() {
		click(btnPay, "Click Pay");

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

	public void clickPasteLink() {
		click(lnkPaste, "Click Paste");
	}

	public void fillRecipientMessage(String RecipientMessage) {
		enterText(txtRecipientMessage, RecipientMessage, "RecipientMessage");
	}

	public void clickNext() {
		click(btnNext, "Click Next");
	}

	public String isFundsDisplayed(String noFundsAvailable) {

		return noFundsAvailable;

	}

	public void VerifyErrorMessage(String ErrorMessage) {
		new CommonFunctions().verifyLabelText(lblErrorMessage, "ErrorMessage", ErrorMessage);
	}

	public void verifyAccountHolderName(String expAccountHolderName) {
		new CommonFunctions().verifyLabelText(lblAccountHolderName, "Account holder Name", expAccountHolderName);
	}

	public RequestingAccountHolderPopup requestingAccountHolderPopup() {
		return new RequestingAccountHolderPopup();
	}

	public PayingAccountHolderNamePopup payingAccountHolderNamePopup() {
		return new PayingAccountHolderNamePopup();
	}

	public void VerifyAmountView() {
		new CommonFunctions().elementView(txtAmount, "Amount Field");

	}

	public void VerifyRecipientsAddressView() {
		new CommonFunctions().elementView(txtRecipientsAddress, "Recipient's Address");

	}

	public void VerifyMessageToRecipientView() {
		new CommonFunctions().elementView(txtRecipientsAddress, "Recipient's Address");

	}

	public void VerifyAccountBalanceView() {
		new CommonFunctions().elementView(lblAvailableBalance, "Available Balance");

	}

	public void VerifyYourTokenAccountView() {

		new CommonFunctions().elementView(lblYourTokenAcount, "Your Token Acccount");

	}

	public void VerifyPayingRecipient() {
		new CommonFunctions().elementView(lblPayingRecipientName, "Paying Recipient");
	}

	public void VerifyCrossIconView() {
		new CommonFunctions().elementView(crossIcon, "Cross Icon");
	}

	public void VerifyBackIconView() {
		new CommonFunctions().elementView(backIcon, "Back Icon");
	}

	public void VerifyButtonPay() {
		new CommonFunctions().elementView(btnPay, "Pay Button");
	}

	public void VerifyTransactionFailed() {
		new CommonFunctions().elementView(lblTransactionFailed, "Transaction Failed");
	}
}
