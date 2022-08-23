package coyni.admin.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AccountLimitsComponent extends BrowserFunctions {

	private By heading = By.xpath("//div[contains(@class,'card AccountLimits')]//span[text()='Account Limits']");
	private By lblBuyTokenBankAccountDailyLimit = By.xpath("(//div[text()='Bank Account']/..//span[text()='10.00'])[1]");
	private By lblBuyTokenDebitCardDailyLimit = By.xpath("//div[text()='Debit Card']/..//span[text()='10.00']");
	private By lblBuyTokenCreditCardDailyLimit = By.xpath("//div[text()='Credit Card']/..//span[text()='10.00']");
	private By lbWithdrawToUSDBankAccountDailyLimit = By.xpath("(//div[text()='Bank Account']/..//span[text()='10.00'])[2]");
	private By lbWithdrawToUSDInstantPayDailyLimit = By.xpath("(//div[text()='Instant Pay']/..//span[text()='10.00'])[1]");
	private By lbWithdrawToUSDGidtCardDailyLimit = By.xpath("(//div[text()='Gift Card']/..//span[text()='10.00'])[1]");
	
	
	
	public String verifyHeading() {
		String str = getText(heading, "Heading");
		ExtentTestManager.setInfoMessageInReport("Heading is " + str);
		return str;
	}
	
	public String verifyDailyLimitBuyTokenBankAccount() {
		String str = getText(lblBuyTokenBankAccountDailyLimit, "Bak Account");
		ExtentTestManager.setInfoMessageInReport("Daily limit of Buy token Bank Account is " + str);
		return str;
	}
	
	public String verifyDailyLimitBuyTokenDebitCard() {
		String str = getText(lblBuyTokenDebitCardDailyLimit, "Debit Card");
		ExtentTestManager.setInfoMessageInReport("Daily limit of Buy token Debit Card is " + str);
		return str;
	}
	
	public String verifyDailyLimitBuyTokenCreditCard() {
		String str = getText(lblBuyTokenCreditCardDailyLimit, "Credit Card");
		ExtentTestManager.setInfoMessageInReport("Daily limit of Buy token Credit Card is " + str);
		return str;
	}
	
	public String verifyDailyLimitWithdrawToUSDBankAccount() {
		String str = getText(lbWithdrawToUSDBankAccountDailyLimit, "Bank Account");
		ExtentTestManager.setInfoMessageInReport("Daily Limit Withdraw To USD Bank Account is " + str);
		return str;
	}
	
	public String verifyDailyLimitWithdrawToUSDInstantPay() {
		String str = getText(lbWithdrawToUSDInstantPayDailyLimit, "Instant Pay");
		ExtentTestManager.setInfoMessageInReport("Daily Limit Withdraw To USD Instant Pay is " + str);
		return str;
	}
	
	public String verifyDailyLimitWithdrawToUSDGiftCard() {
		String str = getText(lbWithdrawToUSDGidtCardDailyLimit, "Gift Card");
		ExtentTestManager.setInfoMessageInReport("Daily Limit Withdraw To USD Gift Card is " + str);
		return str;
	}

}
