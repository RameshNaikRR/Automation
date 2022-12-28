package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.popups.SaveChangePopUp;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class FeatureControlPage extends BrowserFunctions {
	private By lblActivityHeading = By.xpath("//span[text()='Activity Log']");
	private By lblActivityDescription = By
			.xpath("(// span[contains(@class,'text-sm font-bold tracking-wide text-cgy4')])[1]");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By btnCancel = By.xpath("//div[text()='Cancel']");
	
//	private By  lbl
//	public void verifyFeatureControl(String expHeading) {
//		new CommonFunctions().verifyLabelText(btnCancel, expHeading, expHeading);
//	}

	public void verifyActivityHeading(String expActivityHeading) {
		new CommonFunctions().verifyLabelText(lblActivityHeading, "expActivityHeading", expActivityHeading);
	}

	public void verifyActivityDescription() {
		new CommonFunctions().elementView(lblActivityDescription, "expActivityDescription");
	}

	private By getTransactions(String Transaction) {
		return By.xpath(String.format("(//p[contains(@class,'text-cgy8 font-bold pl-3 pt-3')])[%s]", Transaction));
	}

	public void verifyPayRequest() {
		new CommonFunctions().elementView(getTransactions("1"), "Pay/Request");
	}

	public void verifyWithdrawals() {
		new CommonFunctions().elementView(getTransactions("2"), "Withdrawals");
	}

	public void verifyBuyTokens() {
		new CommonFunctions().elementView(getTransactions("3"), "Buy Tokens");
	}

	public void verifyPaymentMethods() {
		new CommonFunctions().elementView(getTransactions("4"), "ExternalBankAccount");
	}

	private By getTransactionControls(String Control) {
		return By.xpath(String.format("(//div[contains(@class,'react-toggle-track-check')])[%s]", Control));
	}

	public void verifyAllTransactionsControls() {
		new CommonFunctions().elementView(getTransactionControls("1"), "TransactionControls");
		click(getTransactionControls("1"), "TransactionControls");
	}

	public void verifyPay() {
		new CommonFunctions().elementView(getTransactionControls("2"), "Pay");
		click(getTransactionControls("2"), "Pay");
	}

	public void verifyRequest() {
		new CommonFunctions().elementView(getTransactionControls("3"), "Request");
		click(getTransactionControls("3"), "Request");
	}

	public void verifyExternalBankAccount() {
		new CommonFunctions().elementView(getTransactionControls("4"), "ExternalBankAccount");
		click(getTransactionControls("4"), "ExternalBankAccount");
	}

	public void verifyInstantPay() {
		new CommonFunctions().elementView(getTransactionControls("5"), "InstantPay");
		click(getTransactionControls("5"), "InstantPay");
	}

	public void verifyGiftCard() {
		new CommonFunctions().elementView(getTransactionControls("6"), "GiftCard");
		click(getTransactionControls("6"), "GiftCard");
	}

	public void verifySignetAccount() {
		new CommonFunctions().elementView(getTransactionControls("7"), "SignetAccount");
		click(getTransactionControls("7"), "SignetAccount");
	}

	public void verifyCreditCard() {
		// new CommonFunctions().elementView(getTransactionControls("8"), "CreditCard");
		click(getTransactionControls("8"), "CreditCard");
	}

	public void verifyDebitCard() {
		new CommonFunctions().elementView(getTransactionControls("9"), "DebitCard");
		click(getTransactionControls("9"), "DebitCard");
	}

	public void verifyBuyTokensExternalBankAccount() {
		new CommonFunctions().elementView(getTransactionControls("10"), "BuyTokensExternalBankAccount");
		click(getTransactionControls("10"), "BuyTokensExternalBankAccount");
	}

	public void verifyPaymentMethodsCreditCard() {
		new CommonFunctions().elementView(getTransactionControls("11"), "PaymentMethod CreditCard");
		click(getTransactionControls("11"), "PaymentMethod CreditCard");
	}

	public void verifyPaymentMethodsDebitCard() {
		new CommonFunctions().elementView(getTransactionControls("12"), "PaymentMethod DebitCard");
		click(getTransactionControls("12"), "PaymentMethod DebitCard");
	}

	public void verifyPaymentMethodsExternalBankAccount() {
		new CommonFunctions().elementView(getTransactionControls("13"), "PaymentMethodsExternalBankAccount");
		click(getTransactionControls("13"), "PaymentMethodsExternalBankAccount");
	}

	public void clickSave() {
		click(btnSave, "save");
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public SaveChangePopUp saveChangePopUp() {
		return new SaveChangePopUp();
	}
}
