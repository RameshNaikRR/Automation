package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawCoyniToUSDPopup extends BrowserFunctions {

	private By withdrawToUSDHeading = By.xpath("//h1[text()='Withdraw Coyni to USD']");
	private By btnWithdrawToUSD = By.xpath("//span[text()='Withdraw to USD']");
	private By btnExternalBankAccount = By.xpath("//span[text()='Bank Account']");
	private By btnInstantPay = By.xpath("//span[text()='Instant Pay']");
	private By btnGiftCard = By.xpath("//span[text()='Gift Card']");

	public void clickOnExternalBankAccount() {
		click(btnExternalBankAccount, "click ExternalBankAccount");
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
		new CommonFunctions().verifyChangedColor(btnWithdrawToUSD, "WithdrawToUSD", cssProp, expValue, expColor);
	}

	public WithdrawViaInstantPay withdrawViaInstantPay() {
		return new WithdrawViaInstantPay();
	}

	public WithdrawToBankAccountSelectBankPopup withdrawToBankAccountSelectBankPopup() {
		return new WithdrawToBankAccountSelectBankPopup();
	}
}
