package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawCoyniToUSDPopup extends BrowserFunctions {

	public By lblHeading = By.xpath("//h1[text()='Withdraw coyni to USD']");
	public By btnBankAccount = By.xpath("//span[text()='Bank Account']");
	public By btnInstantPay = By.xpath("//span[text()='Instant Pay']");
	public By btnSignetAccount = By.xpath("//span[text()=' Signet Account']");
	private By withdrawToUSDColor = By.xpath("//span[contains(text(),'Withdraw to')]/preceding-sibling::div");
	private By SignetAccountDesc = By.xpath("//p[contains(text(),'Signet')]");

	public void verifylblHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifylblDesc(String expDesc) {
		new CommonFunctions().verifyLabelText(SignetAccountDesc, "Signet Account Description", expDesc);
	}

	public void clickOnExternalBankAccount() {
		click(btnBankAccount, "click ExternalBankAccount");
	}

	public void cursorhoverWithdrawToUSD() {
		new CommonFunctions().verifyCursorAction(btnBankAccount, "Bank Account");
	}

	public void clickOnInstantPay() {
		click(btnInstantPay, "Click InstantPay");
	}

	public void clickOnSignetAccount() {
		click(btnSignetAccount, "Click Signet Account");
	}

	public void verifySignetHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(btnSignetAccount, "Signet Account", expHeading);
	}

	public void verifyBankAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(btnBankAccount, "Heading", expHeading);
	}

	public void verifyInstantPayHeading(String InstantPayHeading) {
		new CommonFunctions().verifyLabelText(btnInstantPay, "Instant Pay Heading", InstantPayHeading);
	}

	public void verifySignetAccountHeading(String SignetAccountHeading) {
		new CommonFunctions().verifyLabelText(btnSignetAccount, "Signet Account Heading", SignetAccountHeading);
	}

	public void verifyWithdrawToUSD() {
		new CommonFunctions().elementView(btnBankAccount, "External Bank Account");
		new CommonFunctions().elementView(btnInstantPay, "Instant Pay");
		new CommonFunctions().elementView(btnSignetAccount, "Signet Account");
	}

	public WithdrawviaInstantPayPopup withdrawviaInstantPayPopup() {
		return new WithdrawviaInstantPayPopup();
	}

	public WithdrawToBankAccountPopup withdrawToBankAccountPopup() {
		return new WithdrawToBankAccountPopup();
	}

	public void verifyWithdrawBackgroundcolor(String cssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(withdrawToUSDColor, "WithdrawToUSD", cssProp, expValue, expColor);
	}
}