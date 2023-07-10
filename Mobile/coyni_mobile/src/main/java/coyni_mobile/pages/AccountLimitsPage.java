package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AccountLimitsPage extends MobileFunctions {

	private By lblAccountLimits = MobileBy.xpath("//*[@text='Account Limits']");
	private By lblSendReqsub = MobileBy.xpath("(//*[@text='Send/Request'])[1]");
	private By lblSendRequest = MobileBy.xpath("//*[contains(@resource-id,'SendTxn')]/preceding-sibling::*");
	private By lblSendReqAmt = MobileBy.id("com.coyni.mapp:id/tvSendTxnLimit");
	private By lblBuyToken = MobileBy.xpath("//*[@text='Buy Token']");
	private By lblBankAccount = MobileBy.xpath("//*[contains(@resource-id,'BuyTokenBank')]/preceding-sibling::*");
	private By lblBankAccountAmt = MobileBy.id("com.coyni.mapp:id/tvBuyTokenBankLimit");
	private By lblDebCred = MobileBy.xpath("//*[@text='Debit/Credit Card']");
	private By lblDebCredAmt = MobileBy.id("com.coyni.mapp:id/tvBuyTokenCardLimit");
	private By lblWithdraw = MobileBy.xpath("//*[@text='Withdraw']");
	private By lblWithdrawBankAccount = MobileBy
			.xpath("//*[contains(@resource-id,'WithTokenBank')]/preceding-sibling::*");
	private By lblWithdrawBankAmt = MobileBy.id("com.coyni.mapp:id/tvWithTokenBankLimit");
	private By lblWithdrawInstantPay = MobileBy.xpath("//*[@text='Instant Pay']");
	private By lblWithdrawInstantPayAmt = MobileBy.id("com.coyni.mapp:id/tvWithTokenInstantLimit");
	private By lblWithdrawGiftCard = MobileBy.xpath("//*[@text='Gift Card']");
	private By lblWithdrawGiftCardAmt = MobileBy.id("com.coyni.mapp:id/tvWithdrawTokenGiftCardLimit");

	public void verifyAccountLimitsHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblAccountLimits, "AccountLimits", hdg);
	}

	public void verifySendRequestHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblSendReqsub, "Send Request", hdg);
	}

	public void verifySendRequest() {
		new CommonFunctions().elementView(lblSendRequest, "Send Request");
		new CommonFunctions().elementView(lblSendReqAmt, "Send Request Limit");
		ExtentTestManager.setInfoMessageInReport("The Limit is :" + getText(lblSendReqAmt));
	}

	public void verifyBuyToken(String hdg) {
		new CommonFunctions().verifyLabelText(lblBuyToken, "Buy Token", hdg);
	}

	public void verifyBankAccountView() {
		new CommonFunctions().elementView(lblBankAccount, "Buy Token Bank Account");
		new CommonFunctions().elementView(lblBankAccountAmt, "Buy Token Bank Account Limit");
		ExtentTestManager.setInfoMessageInReport("The Limit is :" + getText(lblBankAccountAmt));
	}

	public void verifyDebitCredView() {
		new CommonFunctions().elementView(lblDebCred, "Debit/Credit Card");
		new CommonFunctions().elementView(lblDebCredAmt, "Debit/Credit Card Limit");
		ExtentTestManager.setInfoMessageInReport("The Limit is :" + getText(lblDebCredAmt));
	}

	public void verifyWithdraw(String hdg) {
		new CommonFunctions().verifyLabelText(lblWithdraw, "Withdraw", hdg);
	}

	public void verfiyWithdrawBankView() {
		new CommonFunctions().elementView(lblWithdrawBankAccount, "Withdraw Bank Account");
		new CommonFunctions().elementView(lblWithdrawBankAmt, "Withdraw Bank Account Limit");
		ExtentTestManager.setInfoMessageInReport("The Limit is :" + getText(lblWithdrawBankAmt));
	}

	public void verfiyWithdrawInstantView() {
		new CommonFunctions().elementView(lblWithdrawInstantPay, "Withdraw Instant Pay");
		new CommonFunctions().elementView(lblWithdrawInstantPayAmt, "Withdraw Instant Pay Limit");
		ExtentTestManager.setInfoMessageInReport("The Limit is :" + getText(lblWithdrawInstantPayAmt));
	}

	public void verfiyWithdrawGiftCardView() {
		new CommonFunctions().elementView(lblWithdrawGiftCard, "Withdraw Gift Card");
		new CommonFunctions().elementView(lblWithdrawGiftCardAmt, "Withdraw Gift Card Limit");
		ExtentTestManager.setInfoMessageInReport("The Limit is :" + getText(lblWithdrawGiftCardAmt));
	}

}
