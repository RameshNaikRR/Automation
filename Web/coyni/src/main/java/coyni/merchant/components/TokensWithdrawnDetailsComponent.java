package coyni.merchant.components;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class TokensWithdrawnDetailsComponent extends BrowserFunctions {

	private By lblTranscationsCount = By.cssSelector("");

	private By lblTokensWithdrawTransactions = By.xpath("//h1[text()='Token Withdraw Details']");

	private By lblTokensWithdrawn = By.xpath("//span[text='Tokens Withdrawn')]");

	private By lblWithdrawCount = By.xpath("(//span[contains(@class,'AccountActivity_balance__IJUnS')])[3]");

	public String getTokensWithdrawn() {
		return getText(lblTokensWithdrawn, "Tokens Withdrawn");
	}

	public String getTransactionsCount() {
		return getText(lblTranscationsCount, "Transactions Count");
	}

	public void verifyLabelWithdrawTransactionDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokensWithdrawTransactions, "Tokens Withdraw Transactions",
				expHeading);
	}

	public String getUiCount() {
		return getText(lblWithdrawCount, "Withdraw Count");
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

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

	public TransactionsListComponent transactionsListComponent() {
		return new TransactionsListComponent();
	}
}
