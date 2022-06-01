package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class FeesComponent extends MobileFunctions {

	private By headingFees = MobileBy.xpath("//*[contains(@text,'Fees')]");
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
	private By lblheadingOtherFees = MobileBy.xpath("//*[@text='Other Fees']");
	private By lblMonthlyFee = MobileBy.xpath("//*[contains(@text,'Monthly Fee')]/following-sibling::*[1]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'back')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingFees, "Fee Heading", expHeading);
	}

	public void verifyHeadingTransactionsLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(headingTransactions, "Transaction Heading", expHeading);
	}

	public void getSaleOrder() {
		String saleOrder = getText(lblSaleOrder);
		ExtentTestManager.setInfoMessageInReport("Sale Order: " + saleOrder);
	}

//	public void verifySaleOrderLabel(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblSaleOrder, "Label", expHeading);
//	}
	public void getRefund() {
		String refund = getText(lblRefund);
		ExtentTestManager.setInfoMessageInReport("Refund : " + refund);
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
		ExtentTestManager.setInfoMessageInReport("Withraws External Bank Account: " + withdrawsExternalBankAccount);
	}

	public void getBuyTokenExternalBankAccount() {
		String buyTokenExternalBankAccount = getText(verifyExternalBankAccount("2"));
		ExtentTestManager.setInfoMessageInReport("Buy Token External Bank Account: " + buyTokenExternalBankAccount);
	}

	private By verifySignetAccount(String Value) {
		return By.xpath(String.format("//*[contains(@text,'Signet Account')]/following-sibling::*[%s]", Value));
	}

	public void getWithdrawsSignetAccount() {
		String withdrawsSignetAccount = getText(verifySignetAccount("1"));
		ExtentTestManager.setInfoMessageInReport("Withraws Signet Account: " + withdrawsSignetAccount);
	}

	public void getBuyTokenSignetAccount() {
		String buyTokenSignetAccount = getText(verifySignetAccount("2"));
		ExtentTestManager.setInfoMessageInReport("BuyToken Signet Account : " + buyTokenSignetAccount);
	}

//
//	public void verifyWithdrawInstantPayLabel(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblWithdrawInstantPay, "Label", expHeading);
//		String withdrawInstantPay = getText(lblWithdrawInstantPay);
//		ExtentTestManager.setInfoMessageInReport("withdrawInstantPay: " + withdrawInstantPay);
//	}
	public void getWithdrawInstantPayLabel() {
		String withdrawInstantPay = getText(lblWithdrawInstantPay);
		ExtentTestManager.setInfoMessageInReport("Withdraw Instant Pay : " + withdrawInstantPay);
	}

//	public void verifyWithdrawGiftCardLabel(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblWithdrawGiftCard, "Label", expHeading);
//		String withdrawGiftCard = getText(lblWithdrawGiftCard);
//		ExtentTestManager.setInfoMessageInReport("withdrawGiftCard: " + withdrawGiftCard);
//	}
	public void getWithdrawGiftCardLabel() {
		String withdrawGiftCard = getText(lblWithdrawGiftCard);
		ExtentTestManager.setInfoMessageInReport("Withdraw Gift Card: " + withdrawGiftCard);
	}

	public void getWithdrawFailedBankAccountLabel() {
		String withdrawFailedBank = getText(lblWithdrawFailedBank);
		ExtentTestManager.setInfoMessageInReport("Failed Bank Withdraw : " + withdrawFailedBank);
	}

	public void getMonthlyFee() {
		scrollDownToElement(lblMonthlyFee, "Monthly Fee");
		String MonthlyFee = getText(lblMonthlyFee);
		ExtentTestManager.setInfoMessageInReport(" Monthly Fee : " + MonthlyFee);
	}

	public void verifyHeadingBuyToken(String expHeading) {
		new CommonFunctions().verifyLabelText(headingBuyToken, "Buy Token Heading", expHeading);
	}

	public void verifyOtherFees(String expHeading) {
		scrollDownToElement(lblheadingOtherFees, "Other Fees");
		new CommonFunctions().verifyLabelText(lblheadingOtherFees, "Other Fees Heading", expHeading);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public void clickBack() {
		click(btnBack, "Back");

	}

}
