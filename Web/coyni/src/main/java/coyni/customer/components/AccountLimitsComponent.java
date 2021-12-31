package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountLimitsComponent extends BrowserFunctions{
	
	private By lblPayAndRequest = By.xpath("//span[@class='font-bold text-cgy4']");
	private By lblSendToken = By.xpath("//div[normalize-space()='Send Token']");
	private By lblSendTokenWallet = By.xpath("//span[contains(text(),'500')]");
	private By lblBuyTokens = By.xpath("//span[normalize-space()='Buy Tokens']");
	private By lblBankAccount = By.xpath("(//div[text()='Bank Account'])[1]");
	private By lblBankAccountWallet = By.xpath("(//span[normalize-space()='10,000.00'])[1]");
	private By lblDebitAndCredit = By.xpath("//div[text()='Debit / Credit Card']");
	private By lblDebitAndCreditWallet = By.xpath("(//span[normalize-space()='70,000.00'])[1]");
	private By lblWithdrawtoUSD = By.xpath("//span[normalize-space()='Withdraw to USD']");
	private By lblBankAccountWithdraw = By.xpath("(//div[text()='Bank Account'])[2]");
	private By lblInstantPay = By.xpath("//div[text()='Instant Pay']");
	private By lblGiftCard = By.xpath("//div[text()='Gift Card']");
	
	public String getPayAndRequest() {
		new CommonFunctions().elementView(lblPayAndRequest, "Pay/Request");
		return getText(lblPayAndRequest, "Pay/Request");
	}
	public String getSendToken() {
		new CommonFunctions().elementView(lblSendToken, "Send Token");
		return getText(lblSendToken, "Send Token");
	}
	public String getBuyTokens() {
		new CommonFunctions().elementView(lblSendTokenWallet, "Buy Tokens");
		return getText(lblSendTokenWallet, "Buy Tokens");
	}
	public String getBankAccount() {
		new CommonFunctions().elementView(lblBankAccount, "Bank Account");
		return getText(lblBankAccount,"Bank Account");
	}
	public String getBankAccountWallet() {
		new CommonFunctions().elementView(lblBankAccountWallet, "Bank Account Wallet");
		return getText(lblBankAccountWallet, "Bank Account Wallet");
	}
	public String getDebitAndCard() {
		new CommonFunctions().elementView(lblDebitAndCredit, "Debit/Credit Card");
		return getText(lblDebitAndCredit, "Debit/Credit Card");
	}
	public String getDebitAndCreditWallet() {
		new CommonFunctions().elementView(lblDebitAndCreditWallet, "Debit/Credit Wallet");
		return getText(lblDebitAndCreditWallet, "Debit/Credit Wallet");
	}
	public String getWithdrawtoUSD() {
		new CommonFunctions().elementView(lblWithdrawtoUSD, "Withdraw To USD");
		return getText(lblWithdrawtoUSD, "Withdraw to USD");
	}
	public String getBankAccountWithdraw() {
		new CommonFunctions().elementView(lblBankAccountWithdraw, "Bank Account");
		return getText(lblBankAccountWithdraw, "Bank Account");
	}
	public String getInstantPay() {
		new CommonFunctions().elementView(lblInstantPay, "Instant Pay");
		return getText(lblInstantPay, "Instant Pay");
	}
	public String getGiftCard() {
		new CommonFunctions().elementView(lblGiftCard, "Gift Card");
		return getText(lblGiftCard,"Gift Card");
	}

}
