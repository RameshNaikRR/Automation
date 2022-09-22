package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class FeesComponent extends MobileFunctions {

	private By headingFees = MobileBy.xpath("//*[contains(@text,'Fes')]");
	private By headingTransactions = MobileBy.xpath("//*[@text='Transactions']");
	private By lblSaleOrderDollr = MobileBy.xpath("//*[contains(@text,'Sale Order: Token')]/following-sibling::*[1]");
	private By lblSaleOrder = MobileBy.xpath("//*[contains(@text,'Sale Order: Token')]/following-sibling::*[2]");
	private By lblRefundDollr = MobileBy.xpath("//*[contains(@text,'Refund')]/following-sibling::*[1]");
	private By lblRefund = MobileBy.xpath("//*[contains(@text,'Refund')]/following-sibling::*[2]");
	private By headingTokenAccount = MobileBy.xpath("//*[@text='Token Account']");
	private By headingWithdraw = MobileBy.xpath("//*[@text='Withdraws']");
	private By lblWithdrawInstantPay = MobileBy.xpath("//*[contains(@text,'Instant Pay')]/following-sibling::*[1]");
	private By lblWithdrawGiftCard = MobileBy.xpath("//*[contains(@text,'Gift Card')]/following-sibling::*[1]");
	private By lblWithdrawInstantPayPer = MobileBy.xpath("//*[contains(@text,'Instant Pay')]/following-sibling::*[2]");
	private By lblWithdrawGiftCardPer = MobileBy.xpath("//*[contains(@text,'Gift Card')]/following-sibling::*[2]");
	private By lblWithdrawFailedBank = MobileBy
			.xpath("//*[contains(@text,'Failed Bank Withdraw')]/following-sibling::*[1]");
	private By lblWithdrawFailedBankPer = MobileBy
			.xpath("//*[contains(@text,'Failed Bank Withdraw')]/following-sibling::*[2]");
	private By headingBuyToken = MobileBy.xpath("//*[@text='Buy Token']");
	private By lblheadingOtherFees = MobileBy.xpath("//*[@text='Other Fees']");
	private By lblMonthlyFee = MobileBy.xpath("//*[contains(@text,'Monthly Fee')]/following-sibling::*[1]");
	private By lblMonthlyFeePer = MobileBy.xpath("//*[contains(@text,'Monthly Fee')]/following-sibling::*[2]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'back')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingFees, "Fee Heading", expHeading);
	}

	public void verifyHeadingTransactionsLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(headingTransactions, "Transaction Heading", expHeading);
	}

	public void getSaleOrder() {
		String saleOrderPer = getText(lblSaleOrder);
		String saleOrderDoll = getText(lblSaleOrderDollr);
		ExtentTestManager.setInfoMessageInReport("Sale Order Percentage : " + saleOrderDoll + "   "+saleOrderPer);
	}
	
//	public void getSaleOrderDoll() {
//		String saleOrder = getText(lblSaleOrderDollr);
//		ExtentTestManager.setInfoMessageInReport("Sale Order Dollar: " + saleOrder);
//	}


//	public void verifySaleOrderLabel(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblSaleOrder, "Label", expHeading);
//	}
	public void getRefund() {
		String refund = getText(lblRefund);
		String refundDoll = getText(lblRefundDollr);
		ExtentTestManager.setInfoMessageInReport("Refund : " + refundDoll+ "   "+ refund);
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

	private By verifyWithdrawExternalBankAccount(String Value) {
		return By.xpath(String.format("(//*[contains(@text,'External Bank Account')])[1]/following-sibling::*[%s]", Value));
	}

	private By verifyBuyTokenExternalBankAccount(String Value) {
		return By.xpath(String.format("(//*[contains(@text,'External Bank Account')])[2]/following-sibling::*[%s]", Value));
	}
	
	public void getWithdrawsExternalBankAccount() {
		String withdrawsExternalBankAccount = getText(verifyWithdrawExternalBankAccount("1"));
		String withdrawsExternalBankAccountPer = getText(verifyWithdrawExternalBankAccount("2"));
		ExtentTestManager.setInfoMessageInReport("Withraws External Bank Account: " + withdrawsExternalBankAccount + "  : "+withdrawsExternalBankAccountPer);
	}


	private By verifyWithdrawSignetAccount(String Value) {
		return By.xpath(String.format("(//*[contains(@text,'Signet Account')])[1]/following-sibling::*[%s]", Value));
	}
	

	public void getWithdrawsSignetAccount() {
		String withdrawsSignetAccount = getText(verifyWithdrawSignetAccount("1"));
		String withdrawsSignetAccountPer = getText(verifyWithdrawSignetAccount("2"));
		ExtentTestManager.setInfoMessageInReport("Withraws Signet Account: " + withdrawsSignetAccount + " :  " +withdrawsSignetAccountPer);
	}

//	public void getWithdrawsSignetAccountPer() {
//		String withdrawsSignetAccount = getText(verifyWithdrawSignetAccount("2"));
//		ExtentTestManager.setInfoMessageInReport("Withraws Signet Account: " + withdrawsSignetAccount);
//	}

	private By verifyBuyTokenSignetAccount(String Value) {
		return By.xpath(String.format("(//*[contains(@text,'Signet Account')])[2]/following-sibling::*[%s]", Value));
	}
	
	public void getBuyTokenSignetAccount() {
		String buyTokenSignetAccount = getText(verifyBuyTokenSignetAccount("1"));
		String buyTokenSignetAccountPer = getText(verifyBuyTokenSignetAccount("2"));
		ExtentTestManager.setInfoMessageInReport("BuyToken Signet Account : " + buyTokenSignetAccount + "   "+buyTokenSignetAccountPer);
	}
	
	public void getBuyTokenExternalBankAccount() {
		String buyTokenExternalBankAccount = getText(verifyBuyTokenExternalBankAccount("1"));
		String buyTokenExternalBankAccountper = getText(verifyBuyTokenExternalBankAccount("2"));
		ExtentTestManager.setInfoMessageInReport("Buy Token External Bank Account: " + buyTokenExternalBankAccount+ "   "+ buyTokenExternalBankAccountper);
	}
//	public void getBuyTokenSignetAccountPer() {
//		String buyTokenSignetAccount = getText(verifyBuyTokenSignetAccount("2"));
//		ExtentTestManager.setInfoMessageInReport("BuyToken Signet Account : " + buyTokenSignetAccount);
//	}

//
//	public void verifyWithdrawInstantPayLabel(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblWithdrawInstantPay, "Label", expHeading);
//		String withdrawInstantPay = getText(lblWithdrawInstantPay);
//		ExtentTestManager.setInfoMessageInReport("withdrawInstantPay: " + withdrawInstantPay);
//	}
	public void getWithdrawInstantPayLabel() {
		String withdrawInstantPay = getText(lblWithdrawInstantPay);
		String withdrawInstantPayPer = getText(lblWithdrawInstantPayPer);
		ExtentTestManager.setInfoMessageInReport("Withdraw Instant Pay : " + withdrawInstantPay+ "   " +withdrawInstantPayPer);
	}

//	public void verifyWithdrawGiftCardLabel(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblWithdrawGiftCard, "Label", expHeading);
//		String withdrawGiftCard = getText(lblWithdrawGiftCard);
//		ExtentTestManager.setInfoMessageInReport("withdrawGiftCard: " + withdrawGiftCard);
//	}
	public void getWithdrawGiftCardLabel() {
		String withdrawGiftCard = getText(lblWithdrawGiftCard);
		String withdrawGiftCardPer = getText(lblWithdrawGiftCardPer);
		ExtentTestManager.setInfoMessageInReport("Withdraw Gift Card: " + withdrawGiftCard+ "   "+withdrawGiftCardPer);
	}

	public void getWithdrawFailedBankAccountLabel() {
		String withdrawFailedBank = getText(lblWithdrawFailedBank);
		String withdrawFailedBankPer = getText(lblWithdrawFailedBankPer);
		ExtentTestManager.setInfoMessageInReport("Failed Bank Withdraw : " + withdrawFailedBank+ "   "+ withdrawFailedBankPer);
	}

	public void getMonthlyFee() {
		scrollDownToElement(lblMonthlyFee, "Monthly Fee");
		String MonthlyFee = getText(lblMonthlyFee);
		String MonthlyFeePer = getText(lblMonthlyFeePer);	
		ExtentTestManager.setInfoMessageInReport(" Monthly Fee : " + MonthlyFee+ "          "+MonthlyFeePer);
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
