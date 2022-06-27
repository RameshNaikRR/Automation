package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountLimitsComponent extends BrowserFunctions {

	// private By lblMerchantProcessing = By.xpath("//p[text()='Merchant Processing
	// ']");
	private By lblMerchantProcessingVolume = By
			.xpath("//span[text()='Monthly Processing Volume']/following-sibling::*[1]");
	private By lblHighTicket = By.xpath("//span[text()='High Ticket Limit']/following-sibling::*[1]");
	// private By lblBuyToken = By.xpath("//p[text()='Buy Token ']");
	private By lblBuyTokenBankAccount = By.xpath("//span[text()='Bank Account']/following-sibling::*[1]"); //
	private By lblBuyTokenSignetAccount = By.xpath("//span[text()='Signet Account']/following-sibling::*[1]");
	// private By lblWithdraw = By.xpath("//p[text()='Withdraws ']");
	private By lblWithdrawBankAccount = By.xpath("//span[text()='Bank Account']/following-sibling::*[1]");
	private By lblWithdrawSignetAccount = By.xpath("//span[text()='Signet Account']/following-sibling::*[1]");
	private By lblInstantPay = By.xpath("//span[text()='Instant Pay']/following-sibling::*[1]");
	private By lblGiftCard = By.xpath("//span[text()='Gift Card']/following-sibling::*[1]");

	public String getMerchantProcessingVolume() {
		new CommonFunctions().elementView(lblMerchantProcessingVolume, "Merchant Processing Volume");
		return getText(lblMerchantProcessingVolume, "Merchant Processing Volume");
	}

	public String getHighTicket() {
		new CommonFunctions().elementView(lblHighTicket, "High Ticket");
		return getText(lblHighTicket, "High Ticket");
	}

	public String getBuyTokenBankAccount() {
		new CommonFunctions().elementView(lblBuyTokenBankAccount, "Buy Token Bank Account");
		return getText(lblBuyTokenBankAccount, "Buy Token BankAccount");
	}

	public String getBuyTokenSignetAccount() {
		new CommonFunctions().elementView(lblBuyTokenSignetAccount, "Buy Token Signet Account");
		return getText(lblBuyTokenSignetAccount, "Buy Token Signet Account");
	}

	public String getWithdrawBankAccount() {
		new CommonFunctions().elementView(lblWithdrawBankAccount, "Buy Token Bank Account");
		return getText(lblWithdrawBankAccount, "Withdraw Bank Account");
	}

	public String getWithdrawSignetAccount() {
		new CommonFunctions().elementView(lblWithdrawSignetAccount, "Withdraw Signet Account");
		return getText(lblWithdrawSignetAccount, "Withdraw Signet Account");
	}

	public String getInstantPay() {
		new CommonFunctions().elementView(lblInstantPay, "Instant Pay");
		return getText(lblInstantPay, "Instant Pay");
	}

	public String getGiftCard() {
		new CommonFunctions().elementView(lblGiftCard, "Gift Card");
		return getText(lblGiftCard, "Gift Card");
	}

}
