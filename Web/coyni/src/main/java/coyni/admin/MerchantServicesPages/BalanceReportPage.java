package coyni.admin.MerchantServicesPages;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.EntriesAndPaginationsComponent;
import coyni.admin.Paymentcomponents.ExportComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class BalanceReportPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Balance Reports']");

	private By lblTotalCustomer = By.xpath("//h2[text()='Total Customers']");

	private By lblTotalBalance = By.xpath("//h2[text()='Total Balance']");

	private By lblAmount = By.xpath("(//span[contains(@class,'AccountActivity_balance')])[1]");

	private By lblPersonalAccountsBalance = By
			.xpath("( //div[contains(@class,'w-full flex flex-col items-center cursor-default undefined')])[1]");

	private By lblBusinessAccountsBalance = By
			.xpath("( //div[contains(@class,'w-full flex flex-col items-center cursor-default undefined')])[2]");

	private By btnExport = By.xpath("//div[text()='Export']");

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
//		public void getPersonalAccountsTotalBalance() {
//			ExtentTestManager.setInfoMessageInReport(
//					"Personal Accounts Balance: " + getText(lblPersonalAccountsBalance, "Personal Accounts Balance"));
//		}
	//
	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport(
				"Business Accounts Balance: " + getText(lblBusinessAccountsBalance, "Business Accounts Balance"));
	}

	private By getCount = By.xpath("//span[@class='BalanceReport_customer_count__9gtmr']");
	private By getTotalBalance = By.xpath(
			"//span[contains(@class,'BalanceReport_wallet_balance_larger__2lM5w font-bold cursor-default text-cgy4 ')]");
	private By getPersonalBalance = By
			.cssSelector("(//span[contains(@class,'font-bold text-cgy4 AccountActivity_balance__dRNlX')])[1]");
	private By getBusinessBalance = By
			.cssSelector("(//span[contains(@class,'font-bold text-cgy4 AccountActivity_balance__dRNlX')])[2]");

	public String getCount() {
		String text = getText(getCount, "Users Count");
		return text;
	}

	public String getBusinessBalance() {
		String text = getText(getBusinessBalance, "Business Balance");
		return text;
	}

	public String getPersonalBalance() {
		String text = getText(getPersonalBalance, "Personal Balance");
		return text;
	}

	public String getBalance() {
		String text = getText(getTotalBalance, "Total Balance");
		return text;
	}

	public void getTotalCustomerCount(String query) throws SQLException {

		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("Number of users  matches with number of entries in DB ");
		} else {
			ExtentTestManager.setFailMessageInReport("Number of users not matches with number of entries in DB ");
		}
	}

	public void getTotalBalance(String query) throws SQLException {

		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getBalance());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("Total Balance is matched ");
		} else {
			ExtentTestManager.setFailMessageInReport("Total Balance is not matched");
		}
	}

	public void getPersonalBalance(String query) throws SQLException {

		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getPersonalBalance());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("Total Personal Balance is matched ");
		} else {
			ExtentTestManager.setFailMessageInReport("Total  Personal Balance is not matched");
		}
	}

	public void getBusinessBalance(String query) throws SQLException {

		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getBusinessBalance());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("Total Business Balance is matched ");
		} else {
			ExtentTestManager.setFailMessageInReport("Total Business Balance is not matched");
		}
	}

}
