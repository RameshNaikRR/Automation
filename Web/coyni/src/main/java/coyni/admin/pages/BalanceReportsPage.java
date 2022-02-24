package coyni.admin.pages;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BalanceReportsPage extends BrowserFunctions {

	private By lblHeding = By.xpath("");

	private By lblTotalCustomer = By.xpath("");

	private By lblTotalBalance = By.xpath("");

	private By lblPersonalAccountsBalance = By.xpath("");

	private By lblBusinessAccountsBalance = By.xpath("");

	public void getTotalCustomer() {
		ExtentTestManager.setInfoMessageInReport("Total Customer: " + getText(lblTotalCustomer, "Total Customer"));
	}

	public void getTotalBalance() {
		ExtentTestManager.setInfoMessageInReport("Total Balance: " + getText(lblTotalBalance, "Total Balance"));
	}

	public void getPersonalAccountsTotalBalance() {
		ExtentTestManager.setInfoMessageInReport(
				"Personal Accounts Balance: " + getText(lblPersonalAccountsBalance, "Personal Accounts Balance"));
	}

	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport(
				"Business Accounts Balance: " + getText(lblBusinessAccountsBalance, "Business Accounts Balance"));
	}

}
