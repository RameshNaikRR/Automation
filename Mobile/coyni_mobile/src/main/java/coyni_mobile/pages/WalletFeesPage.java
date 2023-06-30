package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
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
		new CommonFunctions().verifyLabelText(lblWalletFeesHeader, "Wallet Fees", heading);
	}

	public void viewBuyTokenFees() {
		new CommonFunctions().elementView(lblBuyTokenSubHead, "Buy Token Sub Heading");
		new CommonFunctions().elementView(lblBTCredit, "Buy Token Bank Account Fees");
		new CommonFunctions().elementView(lblBTCredit, "Buy Token Credit Fees");
		new CommonFunctions().elementView(lblBTDebit, "Buy Token Debit Fees");
	}

	public void viewWithdrawFees() {
		new CommonFunctions().elementView(lblWithdrawSubHead, "Withdraw Sub Heading");
		new CommonFunctions().elementView(lblWTBankAcc, "Withdraw Bank Account Fees");
		new CommonFunctions().elementView(lblWTInstantPay, "Withdraw Instant Pay Fees");
		new CommonFunctions().elementView(lblWTGiftCard, "Withdraw Gift Card Fees");
		new CommonFunctions().elementView(lblWTFailedBank, "Buy Token Failed Bank Fees");
	}
}
