package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawCoyniToUSDPopup extends BrowserFunctions {

	private By withdrawToUSDHeading = By.xpath("//h1[@class='WithdrawOptionsModal_title__2V2wo']");
	private By btnWithdrawToUSD = By
			.xpath("(//button[@class='group h-28 w-full flex flex-col justify-center items-center '])[3]");
	private By btnExternalBankAccount = By.xpath("(//button[@class='payment-method-button '])[1]");
	private By btnInstantPay = By.xpath("(//button[@class='payment-method-button '])[2]");
	private By btnGiftCard = By.xpath("(//button[@class='payment-method-button '])[3]");
	private By withdrawToUSDColor = By.xpath("//span[contains(text(),'Withdraw to')]/preceding-sibling::div");

	public void clickOnExternalBankAccount() {
		click(btnExternalBankAccount, "click ExternalBankAccount");
	}

	public void cursorhoverWithdrawToUSD() {
		new CommonFunctions().verifyCursorAction(btnGiftCard, "Gift Card");
	}

	public void clickOnInstantPay() {
		click(btnInstantPay, "Click InstantPay");
	}

	public void clickOnGiftCard() {
		click(btnGiftCard, "Click GiftCard");
	}

	public void verifyWithdrawToUSD() {
		new CommonFunctions().elementView(btnExternalBankAccount, "External Bank Account");
		new CommonFunctions().elementView(btnInstantPay, "Instant Pay");
		new CommonFunctions().elementView(btnGiftCard, "Gift Card");
	}

	public void verifyLabelWithdrawToUSDHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(withdrawToUSDHeading, "Withdraw Coyni to USD", expHeading);
	}

	public void verifyWithdrawBackgroundcolor(String cssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(withdrawToUSDColor, "WithdrawToUSD", cssProp, expValue, expColor);
	}

	public WithdrawViaInstantPayPopup withdrawViaInstantPaypopup() {
		return new WithdrawViaInstantPayPopup();
	}

	public WithdrawToBankAccountSelectBankPopup withdrawToBankAccountSelectBankPopup() {
		return new WithdrawToBankAccountSelectBankPopup();
	}

	public GiftCardPurchasePopup giftCardPurchasePopup() {
		return new GiftCardPurchasePopup();
	}
}