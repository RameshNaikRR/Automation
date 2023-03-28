package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawCoyniToUSDPopup extends BrowserFunctions {

	public By lblHeading = By.xpath("//h1[text()='Withdraw coyni to USD']");
	public By btnBankAccount = By.xpath("//span[text()='Bank Account']");
	public By btnInstantPay = By.xpath("//span[text()='Instant Pay']");
	public By btnCogentAccount = By.xpath("//span[text()='Cogent Account']");
	private By withdrawToUSDColor = By.xpath("//span[contains(text(),'Withdraw to')]/preceding-sibling::div");
	private By cogentAccountDesc = By.xpath("//p[contains(text(),'Cogent')]");
	public By txtWithdrawCogentAccount = By.xpath("//h1[text()='Withdraw to Cogent Account']");
	public By btnChange = By.xpath("//span[text()='Change']");
	private By btnBuyCoyni = By.xpath("//button[text()='Buy coyni']");
	public By lblWithdrawCoyni = By.xpath("//h1[text()='Withdraw coyni to USD']");

	public void verifylblHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifylblHeadingWithdraw(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawCoyni, "Heading", expHeading);
	}

	public void clickBuyCoyni() {
		click(btnBuyCoyni, "Buy Coyni");
	}

	public void verifylblDesc(String expDesc) {
		new CommonFunctions().verifyLabelText(cogentAccountDesc, "Signet Account Description", expDesc);
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

	public void clickOnCogentAccount() {
		new CommonFunctions().verifyCursorAction(btnCogentAccount, "Cogent Account");
		click(btnCogentAccount, "Click Cogent Account");
	}

	public void clickOnChange() {
		click(btnChange, "Change");
	}

	public void verifyCogentHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(btnCogentAccount, "Cogent Account", expHeading);
	}

	public void verifyBankAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(btnBankAccount, "Heading", expHeading);
	}

	public void verifyInstantPayHeading(String InstantPayHeading) {
		new CommonFunctions().verifyLabelText(btnInstantPay, "Instant Pay Heading", InstantPayHeading);
	}

	public void verifyCogentAccountHeading(String SignetAccountHeading) {
		new CommonFunctions().verifyLabelText(btnCogentAccount, "Cogent Account Heading", SignetAccountHeading);
	}

	public void verifyWithdrawToUSD() {
		new CommonFunctions().elementView(btnBankAccount, "External Bank Account");
		new CommonFunctions().elementView(btnInstantPay, "Instant Pay");
		new CommonFunctions().elementView(btnCogentAccount, "Cogent Account");
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