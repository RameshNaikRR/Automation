package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class WalletFeesPage extends MobileFunctions{

	private By lblWalletFeesHeader = MobileBy.AccessibilityId("");
	private By lblBuyTokenSubHead = MobileBy.AccessibilityId("");
	private By lblBTCredit = MobileBy.AccessibilityId("");
	private By lblBTDebit = MobileBy.AccessibilityId("");
	private By lblWithdrawSubHead = MobileBy.AccessibilityId("");
	private By lblWTBankAcc = MobileBy.AccessibilityId("");
	private By lblWTInstantPay = MobileBy.AccessibilityId("");
	private By lblWTGiftCard = MobileBy.AccessibilityId("");
	private By lblWTFailedBank = MobileBy.AccessibilityId("");

	public void verifyWalletFeesHeading(String heading) {
		new AndroidCommonFunctions().verifyLabelText(lblWalletFeesHeader, "Wallet Fees", heading);
	}

	public void viewBuyTokenFees() {
		new AndroidCommonFunctions().elementView(lblBuyTokenSubHead, "Buy Token Sub Heading");
		new AndroidCommonFunctions().elementView(lblBTCredit, "Buy Token Bank Account Fees");
		new AndroidCommonFunctions().elementView(lblBTCredit, "Buy Token Credit Fees");
		new AndroidCommonFunctions().elementView(lblBTDebit, "Buy Token Debit Fees");
	}

	public void viewWithdrawFees() {
		new AndroidCommonFunctions().elementView(lblWithdrawSubHead, "Withdraw Sub Heading");
		new AndroidCommonFunctions().elementView(lblWTBankAcc, "Withdraw Bank Account Fees");
		new AndroidCommonFunctions().elementView(lblWTInstantPay, "Withdraw Instant Pay Fees");
		new AndroidCommonFunctions().elementView(lblWTGiftCard, "Withdraw Gift Card Fees");
		new AndroidCommonFunctions().elementView(lblWTFailedBank, "Buy Token Failed Bank Fees");
	}
}
