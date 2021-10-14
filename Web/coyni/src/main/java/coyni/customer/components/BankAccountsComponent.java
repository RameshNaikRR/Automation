package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BankAccountsComponent extends BrowserFunctions {

	private By lblAccountNumber = By.cssSelector("");

	private By lblBankName =By.cssSelector("");

	private By lblAddress = By.cssSelector("");

	private By iconDelete = By.cssSelector("");

	private By iconRelink = By.cssSelector("");

	public void verifyAccountNumber(String last4digits) {
		new CommonFunctions().verifyLabelText(lblAccountNumber, "Last 4 Digits", last4digits);
	}

	public void verifyBankName(String bankName) {
		new CommonFunctions().verifyLabelText(lblBankName, "Bank Name", bankName);
	}

	public void verifyAddress(String address) {
		new CommonFunctions().verifyLabelText(lblAddress, "Address", address);
	}

	public void clickDelete(String accNumber) {
		click(iconDelete, "Delete icon");
	}

	public void clickRelink(String accNumber) {
		click(iconRelink, "Relink icon");
	}





}
