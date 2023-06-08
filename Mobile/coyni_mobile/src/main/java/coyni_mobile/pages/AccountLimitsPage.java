package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;


public class AccountLimitsPage extends MobileFunctions {

	private By lblAccountLimits = MobileBy.AccessibilityId("");
	private By lblSendReqsub = MobileBy.AccessibilityId("");
	private By lblSendRequest = MobileBy.AccessibilityId("");
	private By lblSendReqAmt = MobileBy.AccessibilityId("");
	private By lblBuyToken = MobileBy.AccessibilityId("");
	private By lblBankAccount = MobileBy.AccessibilityId("");
	private By lblBankAccountAmt = MobileBy.AccessibilityId("");
	private By lblDebCred = MobileBy.AccessibilityId("");
	private By lblDebCredAmt = MobileBy.AccessibilityId("");
	private By lblWithdraw = MobileBy.AccessibilityId("");
	private By lblWithdrawBankAccount = MobileBy.AccessibilityId("");
	private By lblWithdrawBankAmt = MobileBy.AccessibilityId("");
	private By lblWithdrawInstantPay = MobileBy.AccessibilityId("");
	private By lblWithdrawInstantPayAmt = MobileBy.AccessibilityId("");
	private By lblWithdrawGiftCard = MobileBy.AccessibilityId("");
	private By lblWithdrawGiftCardAmt = MobileBy.AccessibilityId("");
	
	public void verifyAccountLimitsHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblAccountLimits, "AccountLimits", hdg);
	}
	public void verifySendRequestHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblSendReqsub, "Send Request", hdg);
	}
	
	public void verifySendRequest() {
		new CommonFunctions().elementView(lblSendRequest, "Send Request");
		ExtentTestManager.setInfoMessageInReport("The amount is :" + getText(lblSendRequest));
	}
	
	public void verifyBuyToken(String hdg) {
		new CommonFunctions().verifyLabelText(lblBuyToken, "Buy Token", hdg);
	}
	public void verifyBankAccountView() {
		new CommonFunctions().elementView(lblBankAccount, "Bank Account");
		ExtentTestManager.setInfoMessageInReport("The amount is :" + getText(lblBankAccountAmt));
	}
	
	public void verifyDebitCredView() {
		new CommonFunctions().elementView(lblDebCred, "Debit/credit Card");
		ExtentTestManager.setInfoMessageInReport("The amount is :" + getText(lblDebCredAmt));
	}
	public void verifyWithdraw(String hdg) {
		new CommonFunctions().verifyLabelText(lblWithdraw, "Withdraw", hdg);
	}
	public void verfiyWithdrawBankView() {
		new CommonFunctions().elementView(lblWithdrawBankAccount, "Withdraw Bank Account");
		ExtentTestManager.setInfoMessageInReport("The amount is :" + getText(lblWithdrawBankAmt));
	}
	public void verfiyWithdrawInstantView() {
		new CommonFunctions().elementView(lblWithdrawInstantPay, "Withdraw Bank Account");
		ExtentTestManager.setInfoMessageInReport("The amount is :" + getText(lblWithdrawInstantPayAmt));
	}
	public void verfiyWithdrawGiftCardView() {
		new CommonFunctions().elementView(lblWithdrawGiftCard, "Withdraw Bank Account");
		ExtentTestManager.setInfoMessageInReport("The amount is :" + getText(lblWithdrawGiftCardAmt));
	}
	

}
