package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AccountLimitsComponent extends MobileFunctions {

	private By btnAccountLimits = MobileBy.xpath("//*[@text='Account Limits']");
	private By lblAccountLimits = MobileBy.xpath("//*[@text='Account Limits']");
	private By lblPayRequest = MobileBy.xpath("//*[@text='Pay/Request (CYN)']");
	private By PayRequestAmountLimit = MobileBy.xpath("//*[contains(@resource-id,'tvPayRequestTransactionLimit')]");
	private By lblVerifyBuyTokens = MobileBy.xpath("//*[@text='Buy Tokens (CYN)']");
	private By BuyTokenBankAccount = MobileBy.xpath("(//*[@text='Bank Account'])[1]");
	private By BuyTokenBankAccountAmountLimit = MobileBy.xpath("//*[contains(@resource-id,'tvBuyTokenBankLimit')]");
	private By lblDebitCardAmount = MobileBy.xpath(" ");
	private By lblCreditCardAmount = MobileBy.xpath(" ");
	private By lblVerifyWithdraw = MobileBy.xpath("//*[@text='Withdraw (CYN)']");
	private By lblWithdrawBankAccount = MobileBy.xpath("(//*[@text='Bank Account'])[2]");
	private By withdrawBankAccountAmountLimit = MobileBy.xpath("//*[contains(@resource-id,'tvBuyTokenBankLimit')]");
	private By lblInstantPay = MobileBy.xpath("//*[@text='Instant Pay']");
	private By withdrawInstantPayAmountLImit = MobileBy.xpath("//*[contains(@resource-id,'tvWithTokenInstantLimit')]");
	private By lblGiftCardAmount = MobileBy.xpath("//*[@text='Gift Card']");
	private By withdrawGiftCardAmountLimit = MobileBy
			.xpath("//*[contains(@resource-id,'tvWithdrawTokenGiftCardLimit')]");
	private By lblAccountHolderName = MobileBy.xpath("//*[contains(@resource-id,'customerNameTV')]");

	public void AccountLimits() {
		scrollDownToElement(btnAccountLimits, "Account Limits");
	}

	public void clickAccountLimits() {
		click(btnAccountLimits, "Account Limits");
	}

	public void VerifyAccountHolderName() {
		new CommonFunctions().elementView(lblAccountHolderName, "Account Holder " + getText(lblAccountHolderName));
	}

	public void verifyLabelAccountLimits(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAccountLimits, "Account Limits", expHeading);
	}

	public void verifyPayRequest(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayRequest, "Pay/Request", expHeading);
	}

	public String getPayRequest() {
		return getText(PayRequestAmountLimit);

	}

	public void verifyBuyTokensHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblVerifyBuyTokens, "Buy Tokens", expHeading);
	}

	public String getBankAccountAmount() {
		return getText(BuyTokenBankAccount);

	}

	public void verifyBuyTokenAmountLimit() {
		new CommonFunctions().elementView(BuyTokenBankAccountAmountLimit, "Buy Token Amount Limit");
	}

	public String getDebitCardAmount() {
		return getText(lblDebitCardAmount);
	}

	public String getCreditCardAmount() {
		return getText(lblCreditCardAmount);
	}

	public void VerifyWithdrawHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblVerifyWithdraw, "Withdraw ", expHeading);
	}

	public String getWithdrawBankAccountAmount() {
		return getText(lblWithdrawBankAccount);

	}

	public void verifyWithdrawBankAccountAmountLimit() {
		new CommonFunctions().elementView(withdrawBankAccountAmountLimit, "Withdraw Bank Account Amount Limit");
	}

	public String getInstantPayAccount() {
		return getText(lblInstantPay);

	}

	public void verifyWithdrawInstantPayAmountLimit() {
		new CommonFunctions().elementView(withdrawInstantPayAmountLImit, "Withdraw Instant Pay Amount Limit");
	}

	public String getGiftCardAmount() {
		return getText(lblGiftCardAmount);

	}

	public void verifyWithdrawGiftCardAmountLimit() {
		new CommonFunctions().elementView(withdrawGiftCardAmountLimit, "Withdraw Gift Card Amount Limit");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
