package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BankAccountAddedSuccessfull extends BrowserFunctions {
	private By heading = By.xpath("");
	private By clickWithdraw = By.xpath("");
	private By close = By.xpath("");
	private By clickBankAccount = By.xpath("");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is :", Heading);
	}

	public void clickWithdraw() {
		click(clickWithdraw, "Withdraw");
	}

	public void clickAddBankAccount() {
		click(clickBankAccount, "AddBankAccount");
	}

	public void clickClose() {
		click(close, "Close");
	}
}
