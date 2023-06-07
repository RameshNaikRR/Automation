package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AccountLimitsPage extends MobileFunctions {

	private By lblAccLimitsHeader = MobileBy.AccessibilityId("");
	private By lblSendRequestSubHead = MobileBy.AccessibilityId("");
	private By lblSendRequest = MobileBy.AccessibilityId("");
	private By lblBuyTokenSubHead = MobileBy.AccessibilityId("");
	private By lblBTBankAcc = MobileBy.AccessibilityId("");
	private By lblBTDebitCredit = MobileBy.AccessibilityId("");
	private By lblWithdrawSubHead = MobileBy.AccessibilityId("");
	private By lblWTBankAcc = MobileBy.AccessibilityId("");
	private By lblWTInstantPay = MobileBy.AccessibilityId("");
	private By lblWTGiftCard = MobileBy.AccessibilityId("");

	public void verifyAccLimitsHeading(String heading) {
		new AndroidCommonFunctions().verifyLabelText(lblAccLimitsHeader, "Account Limits", heading);
	}

	public void viewSendRequestLimit() {
		new AndroidCommonFunctions().elementView(lblSendRequestSubHead, "Send Request Sub Heading");
		new AndroidCommonFunctions().elementView(lblSendRequest, "Send Request Limit");
	}

	public void viewBuyTokenLimit() {
		new AndroidCommonFunctions().elementView(lblBuyTokenSubHead, "Buy Token Sub Heading");
		new AndroidCommonFunctions().elementView(lblBTBankAcc, "Buy Token Bank Account Limit");
		new AndroidCommonFunctions().elementView(lblBTDebitCredit, "Buy Token Debit/Credit Limit");
	}

	public void viewWithdrawLimits() {
		new AndroidCommonFunctions().elementView(lblWithdrawSubHead, "Withdraw Sub Heading");
		new AndroidCommonFunctions().elementView(lblWTBankAcc, "Withdraw Bank Account Limit");
		new AndroidCommonFunctions().elementView(lblWTInstantPay, "Withdraw Instant Pay Limit");
		new AndroidCommonFunctions().elementView(lblWTGiftCard, "Withdraw Gift Card Limit");
	}

}
