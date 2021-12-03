package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PayAndRequestTokensPopup extends BrowserFunctions {

	private By PayRequestImage = By.xpath("");
	private By lblYourTokenAccount = By.xpath("//h1[text()='Your Token Account']");
	private By btnPay = By.xpath("//button[text()='Pay']");
	private By btnRequest = By.cssSelector("//button[text()='Request']");
	private By txtAmount = By.id("amount");
	private By lblAvailableBalance = By.cssSelector("//span[text()='Available Balance:']");
	// private By lblErrorMessage = By.cssSelector("");
	private By txtRecipientMessage = By.cssSelector("");
	private By txtRecipientsAddress = By.id("wallet-id");
	private By countMsgToRecipient = By.xpath("//span[text()='120']");
	private By lblPayingRecipientName = By.cssSelector(".font-bold.text-cgy4.text-xl.text-center.tracking-wide.mt-2");
	private By backIcon = By.cssSelector(".self-start");
	private By crossIcon = By.cssSelector(".self-end");
	// private By lnkPaste = By.cssSelector("//button[text()='Paste']");
	private By btnNext = By.cssSelector("//button[text()='Next']");
	// private By lblYourTokenAcount = By.cssSelector("");
	private By lblAccountHolderName = By.cssSelector("");
	private By lblTransactionFailed = By.cssSelector("");

	public void verifyCountMessageToRecipient() {
		new CommonFunctions().elementView(countMsgToRecipient, "Message to Recipient");
	}

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

//	public void clickPasteLink() {
//		click(lnkPaste, "Click Paste");
//	}

	public void fillRecipientMessage(String RecipientMessage) {
		enterText(txtRecipientMessage, RecipientMessage, "RecipientMessage");
	}

	public void clickNext() {
		click(btnNext, "Click Next");
	}

	public String isFundsDisplayed(String noFundsAvailable) {

		return noFundsAvailable;

	}

//	public void verifyErrorMessage(String ErrorMessage) {
//		new CommonFunctions().verifyLabelText(lblErrorMessage, "ErrorMessage", ErrorMessage);
//	}

	public void verifyAccountHolderName(String expAccountHolderName) {
		new CommonFunctions().verifyLabelText(lblAccountHolderName, "Account holder Name", expAccountHolderName);
	}

	public RequestingAccountHolderPopup requestingAccountHolderPopup() {
		return new RequestingAccountHolderPopup();
	}

	public PayingAccountHolderNamePopup payingAccountHolderNamePopup() {
		return new PayingAccountHolderNamePopup();
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
//
//	public void verifyYourTokenAccountView() {
//
//		new CommonFunctions().elementView(lblYourTokenAcount, "Your Token Acccount");
//
//	}

	public void verifyPayingRecipient() {
		new CommonFunctions().elementView(lblPayingRecipientName, "Paying Recipient");
	}

	public void verifyCrossIconView() {
		new CommonFunctions().elementView(crossIcon, "Cross Icon");
	}

	public void verifyBackIconView() {
		new CommonFunctions().elementView(backIcon, "Back Icon");
	}

	public void verifyButtonPay() {
		new CommonFunctions().elementView(btnPay, "Pay Button");
	}

	public void verifyTransactionFailed() {
		new CommonFunctions().elementView(lblTransactionFailed, "Transaction Failed");
	}

	public void verifyLabelYourTokenAccount() {
		new CommonFunctions().elementView(lblYourTokenAccount, "Your Token Account");

	}

	public void validateAmountField(String singleChar, String specialCharacters) {
		new CommonFunctions().validateField(txtAmount, "Amount", singleChar);
		new CommonFunctions().clearText(txtAmount, "Amount");
		new CommonFunctions().validateFieldWithSpecialchar(txtAmount, "Amount", specialCharacters);
		new CommonFunctions().clearText(txtAmount, "Amount");

	}
}
