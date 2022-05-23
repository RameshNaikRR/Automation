package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BalanceReportsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Balance Reports']");

	private By lblTotalCustomer = By.xpath("//h2[text()='Total Customers']");

	private By lblTotalBalance = By.xpath("//h2[text()='Total Balance']");
	
	private By lblAmount=By.xpath("(//span[contains(@class,'AccountActivity_balance')])[1]");

	private By lblPersonalAccountsBalance = By
			.xpath("( //div[contains(@class,'w-full flex flex-col items-center cursor-default undefined')])[1]");

	private By lblBusinessAccountsBalance = By
			.xpath("( //div[contains(@class,'w-full flex flex-col items-center cursor-default undefined')])[2]");

	private By btnExport = By.xpath("//button[contains(@class,'Button')]");

	public void verifyHeading(String expHeading) {

		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void clickExport() {
		click(btnExport, "Export");
	}

	private By lblFirstRowHeading = By.xpath("//thead[contains(@class,'rounded-full')]");

	public void getAmount() {
		String str = getText(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport(str);

	}
	public void getFirstRowHeading() {
		String str = getText(lblFirstRowHeading, "FirstRowHeading");
		ExtentTestManager.setInfoMessageInReport(str);
	}
	
	public void getPersonalAccountsTotalBalance() {
		String str = getText(lblPersonalAccountsBalance, "Personal Accounts Balance");
		ExtentTestManager.setInfoMessageInReport(str);

	}

	public void getTotalCustomer() {
		ExtentTestManager.setInfoMessageInReport("Total Customer: " + getText(lblTotalCustomer, "Total Customer"));
	}

	public void getTotalBalance() {
		ExtentTestManager.setInfoMessageInReport("Total Balance: " + getText(lblTotalBalance, "Total Balance"));
	}
//
//	public void getPersonalAccountsTotalBalance() {
//		ExtentTestManager.setInfoMessageInReport(
//				"Personal Accounts Balance: " + getText(lblPersonalAccountsBalance, "Personal Accounts Balance"));
//	}
//
	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport(
				"Business Accounts Balance: " + getText(lblBusinessAccountsBalance, "Business Accounts Balance"));
	}

}
