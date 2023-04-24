package coyni.merchant.components;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.merchant.pages.ExportfilesPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class TokensPurchasedDetailsComponent extends BrowserFunctions {

	private By lblTokensPurchased = By.xpath("//span[text()='Tokens Purchased']");

	private By lblTokensPurchaseTransactions = By.xpath("//h1[text()='Tokens Purchased Details']");

	private By lblTranscationsCount = By.cssSelector("");

	private By lblPurchasedCount = By.xpath("(//span[contains(@class,'AccountActivity_balance__IJUnS')])[2]");

	public String getTokensPurchased() {
		return getText(lblTokensPurchased, "Tokens Purchased");
	}

	public String getTransactionsCount() {
		return getText(lblTranscationsCount, "Transactions Count");
	}

	public String getUiCount() {
		return getText(lblPurchasedCount, "Purchased Count");
	}

	public void getTotalTodayCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getUiCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void getTotalYesterdayCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getUiCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void getTotalLast7DaysCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getUiCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void getTotalMonthToDateCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getUiCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void getTotalLastMonthCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getUiCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}
	
	public void getTotalCustomDateRangeCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getUiCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void verifyLabelPurchasedTransactionDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokensPurchaseTransactions, "Tokens Purchased Transactions",
				expHeading);
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

	public TransactionsListComponent transactionsListComponent() {
		return new TransactionsListComponent();
	}

	public ExportfilesPage exportfilesPage() {
		return new ExportfilesPage();
	}
}
