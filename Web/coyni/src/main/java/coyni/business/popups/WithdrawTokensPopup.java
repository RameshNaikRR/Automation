package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawTokensPopup extends BrowserFunctions {

	private By lblWithdrawHeading = By.xpath("");
	private By btnBankAccount = By.xpath("");
	private By btnInstantPay = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyWithdrawTokensHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawHeading, "Withdraw Tokens Heading is: ", expHeading);
	}

	public void clickBankAccount() {
		click(btnBankAccount, "Bank Account");
	}

	public void clickInstantPay() {
		click(btnInstantPay, "Instant Pay");
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public WithdrawToBankAccountPopup withdrawToBankAccountPopup() {
		return new WithdrawToBankAccountPopup();
	}

	public WithdrawToInstantPayPopup withdrawToInstantPayPopup() {
		return new WithdrawToInstantPayPopup();
	}

}
