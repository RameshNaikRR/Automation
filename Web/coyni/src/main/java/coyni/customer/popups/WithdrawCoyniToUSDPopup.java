package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class WithdrawCoyniToUSDPopup extends BrowserFunctions{

	private By btnExternalBankAccount = By.cssSelector("");
	private By btnInstantPay = By.cssSelector("");
	private By btnGiftCard = By.cssSelector("");
	
	public void clickOnExternalBankAccount() {
		click(btnExternalBankAccount, "click ExternalBankAccount");
	}
	public void clickOnInstantPay() {
		click(btnInstantPay, "Click InstantPay");
	}
	public void clickOnGiftCard() {
		click(btnGiftCard, "Click GiftCard");
	}
}
