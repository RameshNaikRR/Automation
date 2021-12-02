package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class BuyTokenMenuComponent extends MobileFunctions {

	private By btnCreditCards = MobileBy.id("");
	private By btnDebitCards = MobileBy.id("");
	private By btnBankAccount = MobileBy.id("");
	private By btnBuyToken = MobileBy.id("");
	private By lblSelectPaymentMethod = MobileBy.id("");
	private By txtAmount = MobileBy.id("");
	private By crossIcon = MobileBy.id("");
	private By lblDone = MobileBy.id("");
	private By btnPaymentBuyToken = MobileBy.id("");
	private By lblOrderPreview = MobileBy.id("");
	private By btnswipe = MobileBy.id("");
	private By lblTransactionPending = MobileBy.id("");
	private By lblAvailableBalance = MobileBy.id("");
	private By lblTransactionFailed = MobileBy.id("");
	private By btnTryAgain = MobileBy.id("");
	private By lblPaymentMethod = MobileBy.id("");

	// buy token option actions
	public void clickCreditCards() {
		click(btnCreditCards, "Credit/Debit Cards");
	}

	public void clickBankAccount() {
		click(btnBankAccount, "Bank Account");
	}

	public void btnBuyToken() {
		click(btnBuyToken, "Buy Token");
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "amount");
	}

	public void btnPaymentBuyToken() {
		click(btnPaymentBuyToken, "PaymentMethod Buy Token");
	}

	public void Done() {
		click(lblDone, "Done");

	}

	public void crossIcon() {
		click(crossIcon, "Cross Icon");
	}

	public void clickTryAgain() {
		click(btnTryAgain, "Try Again");

	}

	public void Swipe() {
		click(btnswipe, "Swipe");

	}

	public void verifyLabelOrderPreview(String expHeading) {
		new CommonFunctions().verifyLabelText(lblOrderPreview, "Order preview", expHeading);

	}

	public void verifyLabelTransactionPending(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionPending, "Transaction Pending", expHeading);

	}

	public void verifyLabelAvailableBalance(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAvailableBalance, "Available Balance", expHeading);
	}

	public void verifyLabelTransactionFailed(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionFailed, "Transaction Failed", expHeading);
	}

	public void verifyLabelPaymentMethod(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPaymentMethod, "Payment Method", expHeading);
	}

	public void verifyLabelSelectPaymentMethod(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSelectPaymentMethod, "Select Payment Method", expHeading);

	}

}
