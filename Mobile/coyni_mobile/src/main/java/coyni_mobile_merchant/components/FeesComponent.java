package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class FeesComponent extends MobileFunctions {

	private By headingFees = MobileBy.xpath("//*[contains(@resource-id,'feesLL')]");
	private By headingTransactions = MobileBy.xpath("//*[@text='Transactions']");
	private By lblSaleOrder = MobileBy.xpath("//*[contains(@text,'Sale Order: Token')]/following-sibling::*[2]");
	private By lblRefund = MobileBy.xpath("//*[contains(@text,'Refund')]/following-sibling::*[2]");
	private By headingTokenAccount = MobileBy.xpath("//*[@text='Token Account']");
	private By headingWithdraw = MobileBy.xpath("//*[@text='Withdraws']");
	private By lblWithdrawInstantPay = MobileBy.xpath("//*[contains(@text,'Instant Pay')]/following-sibling::*[1]");
	private By lblWithdrawGiftCard = MobileBy.xpath("//*[contains(@text,'Gift Card')]/following-sibling::*[1]");
	private By lblWithdrawFailedBank = MobileBy
			.xpath("//*[contains(@text,'Failed Bank Withdraw')]/following-sibling::*[1]");
	private By headingBuyToken = MobileBy.xpath("//*[@text='Buy Token']");
	private By headingOtherFees = MobileBy.xpath("//*[@text='Other Fees']");
	private By lblMonthlyFee = MobileBy.xpath("//*[contains(@text,'Monthly Fee')]/following-sibling::*[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingFees, "Fee Heading", expHeading);
	}

	public void verifyHeadingTransactionsLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(headingTransactions, "Transaction Heading", expHeading);
	}

	public void verifySaleOrderLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSaleOrder, "Label", expHeading);
	}

	public void verifyRefundLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblRefund, "Label", expHeading);
	}

	public void verifyHeadingTokenAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(headingTokenAccount, "TokenAccount Heading", expHeading);
	}

	public void verifyHeadingWithdraw(String expHeading) {
		new CommonFunctions().verifyLabelText(headingWithdraw, "Withdraw Heading", expHeading);
	}

	private By verifyExternalBankAccount(String Value) {
		return By.xpath(String.format("//*[contains(@text,'External Bank Account')]/following-sibling::*[%s]", Value));
	}

	public void getWithdrawsExternalBankAccount() {
		String withdrawsExternalBankAccount = getText(verifyExternalBankAccount("1"));
		ExtentTestManager.setInfoMessageInReport("WithrawsExternalBankAccount: " + withdrawsExternalBankAccount);
	}

	public void getBuyTokenExternalBankAccount() {
		String buyTokenExternalBankAccount = getText(verifyExternalBankAccount("2"));
		ExtentTestManager.setInfoMessageInReport("BuyTokenExternalBankAccount: " + buyTokenExternalBankAccount);
	}

	private By verifySignetAccount(String Value) {
		return By.xpath(String.format("//*[contains(@text,'Signet Account')]/following-sibling::*[%s]", Value));
	}

	public void getWithdrawsSignetAccount() {
		String withdrawsSignetAccount = getText(verifySignetAccount("1"));
		ExtentTestManager.setInfoMessageInReport("WithrawsSignetAccount: " + withdrawsSignetAccount);
	}

	public void getBuyTokenSignetAccount() {
		String buyTokenSignetAccount = getText(verifySignetAccount("2"));
		ExtentTestManager.setInfoMessageInReport("buyToken: " + buyTokenSignetAccount);
	}

	public void verifyWithdrawInstantPayLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawInstantPay, "Label", expHeading);
		String withdrawInstantPay = getText(lblWithdrawInstantPay);
		ExtentTestManager.setInfoMessageInReport("withdrawInstantPay: " + withdrawInstantPay);
	}

	public void verifyWithdrawGiftCardLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawGiftCard, "Label", expHeading);
		String withdrawGiftCard = getText(lblWithdrawGiftCard);
		ExtentTestManager.setInfoMessageInReport("withdrawGiftCard: " + withdrawGiftCard);
	}

	public void verifyWithdrawFailedBankAccountLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawFailedBank, "Label", expHeading);
		String withdrawFailedBank = getText(lblWithdrawFailedBank);
		ExtentTestManager.setInfoMessageInReport("withdrawFailedBank: " + withdrawFailedBank);
	}

	public void verifyHeadingBuyToken(String expHeading) {
		new CommonFunctions().verifyLabelText(headingBuyToken, "Buy Token Heading", expHeading);
	}

	public void verifyOtherFees(String expHeading) {
		new CommonFunctions().verifyLabelText(headingOtherFees, "Other Fees Heading", expHeading);
	}

	public void verifyMonthlyFeeLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblRefund, "Label", expHeading);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
