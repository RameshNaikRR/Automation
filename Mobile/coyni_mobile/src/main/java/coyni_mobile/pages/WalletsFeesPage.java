package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WalletsFeesPage extends MobileFunctions {
	private By lblWalletFees = MobileBy.xpath("//*[@text='Wallet Fees']");
	private By lblBuyToken = MobileBy.xpath("//*[@text='Buy Token']");
	private By lblWithdraw = MobileBy.xpath("//*[@text='Withdraw']");
	private By lblBankAccount = MobileBy.id("com.coyni.mapp:id/tvBuyTokenBADoll");
	private By lblBankAccountFee = MobileBy.id("com.coyni.mapp:id/tvBuyTokenBAPer");
	private By lblCreditCard = MobileBy.id("com.coyni.mapp:id/tvBuyTokenCreditADoll");
	private By lblCreditCardFee = MobileBy.id("com.coyni.mapp:id/tvBuyTokenCreditPer");
	private By lblDebitCard = MobileBy.id("com.coyni.mapp:id/tvBuyTokenDebitDoll");
	private By lblDebitCardFee = MobileBy.id("com.coyni.mapp:id/tvBuyTokenDebitPer");
	private By lblWithdrawBankAccount = MobileBy.id("com.coyni.mapp:id/tvWBADoll");
	private By lblWithdrawBankAccountFee = MobileBy.id("com.coyni.mapp:id/tvWBAPer");
	private By lblWithdrawInstantPay = MobileBy.id("com.coyni.mapp:id/tvInstantPayDoll");
	private By lblWithdrawInstantPayFee = MobileBy.id("com.coyni.mapp:id/tvInstantPayPer");
	private By lblGiftCard = MobileBy.id("com.coyni.mapp:id/giftCardDollTV");
	private By lblGiftCardFee = MobileBy.id("com.coyni.mapp:id/giftCardPerTV");
	private By lblFailedBankWithdraw = MobileBy.id("com.coyni.mapp:id/fbwDollTV");
	private By lblFailedBankWithdrawFee = MobileBy.id("com.coyni.mapp:id/fbwPerTV");

	public void verifyBuyTokenBankAccountFee() {
		String[] str = getText(lblBankAccount).split(" ");
		String str2 = getText(lblBankAccountFee).replace("%", "");
		if (str[0].equals("$") && getElement(lblBankAccount, "Buy Token Bank Account").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(getText(lblBankAccount) + " + " + getText(lblBankAccountFee)
					+ " is Displayed for Buy Token Bank Account");
		} else {
			ExtentTestManager.setPassMessageInReport(" Fee not displayed for Buy Token Bank Account");
		}
	}

	public void verifyBuyTokenDebitCardFee() {
		String[] str = getText(lblDebitCard).split(" ");
		if (str[0].equals("$") && getElement(lblDebitCardFee, "Buy Token Debit Card").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(
					getText(lblDebitCard) + " + " + getText(lblDebitCardFee) + " is Displayed for Buy Token Debit Card");
		} else {
			ExtentTestManager.setPassMessageInReport(" Fee not displayed for Buy Token Debit Card");
		}
	}

	public void verifyBuyTokenCreditCardFee() {
		String[] str = getText(lblCreditCard).split(" ");
		if (str[0].equals("$") && getElement(lblCreditCardFee, "Buy Token Credit Card").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(getText(lblCreditCard) + " + " + getText(lblCreditCardFee)
					+ " is Displayed for Buy Token Buy Token Credit Card");
		} else {
			ExtentTestManager.setPassMessageInReport(" Fee not displayed for Buy Token Credit Card");
		}
	}

	public void verifyWithdrawTokenBankAccountFee() {
		String[] str = getText(lblWithdrawBankAccount).split(" ");
		if (str[0].equals("$") && getElement(lblWithdrawBankAccountFee, "Withdraw Token Bank Account").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(getText(lblWithdrawBankAccount) + " + "
					+ getText(lblWithdrawBankAccountFee) + " is Displayed for Withdraw Token Bank Account");
		} else {
			ExtentTestManager.setPassMessageInReport(" Fee not displayed for Withdraw Token Bank Account");
		}
	}

	public void verifyWithdrawTokenGiftCard() {
		String[] str = getText(lblGiftCard).split(" ");
		if (str[0].equals("$") && getElement(lblGiftCardFee, "Withdraw Token Gift Card").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(
					getText(lblGiftCard) + " + " + getText(lblGiftCardFee) + " is Displayed for Withdraw Token Gift Card");
		} else {
			ExtentTestManager.setPassMessageInReport(" Fee not displayed for Withdraw Token Gift Card");
		}
	}

	public void verifyWithdrawTokenFailedBank() {
		String[] str = getText(lblFailedBankWithdraw).split(" ");
		if (str[0].equals("$") && getElement(lblFailedBankWithdrawFee, "Withdraw Token Failed Bank").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(getText(lblFailedBankWithdraw) + " + "
					+ getText(lblFailedBankWithdrawFee) + " is Displayed for Withdraw Token Failed Bank");
		} else {
			ExtentTestManager.setPassMessageInReport(" Fee not displayed for Withdraw Token Failed Bank");
		}
	}

	public void verifyWithdrawTokenInstantFee() {
		String[] str = getText(lblWithdrawInstantPay).split(" ");
		if (str[0].equals("$") && getElement(lblWithdrawInstantPayFee, "Withdraw Token Instant Pay").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(getText(lblWithdrawInstantPay) + " + "
					+ getText(lblWithdrawInstantPayFee) + " is Displayed for Withdraw Token Instant Pay");
		} else {
			ExtentTestManager.setPassMessageInReport(" Fee not displayed for Withdraw Token Instant Pay");
		}
	}

	public void verifyWalletFees(String hdg) {
		new CommonFunctions().verifyLabelText(lblWalletFees, "WalletFees", hdg);
	}

	public void verifyBuyToken(String hdg) {
		new CommonFunctions().verifyLabelText(lblBuyToken, "Buy Token", hdg);
	}

	public void verifyWithdraw(String hdg) {
		new CommonFunctions().verifyLabelText(lblWithdraw, "Withdraw", hdg);
	}

}