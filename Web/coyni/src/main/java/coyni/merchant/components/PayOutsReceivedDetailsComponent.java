package coyni.merchant.components;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.merchant.pages.ExportfilesPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class PayOutsReceivedDetailsComponent extends BrowserFunctions {

	private By lblPayOutsReceived = By.xpath("//span[contains(text(),'Payouts Received')]");

	private By lblPayOutsReceivedDetails = By.xpath("//h1[(text()='Payouts Received Details')]");

	private By lblTranscationsCount = By.cssSelector("");

	private By lblPayOutCOunt = By.xpath("(//span[contains(@class,'AccountActivity_balance__IJUnS')])[1]");

	public String getTokensSent() {
		return getText(lblPayOutsReceived, "PayOuts Received");
	}

	public String getTransactionsCount() {
		return getText(lblTranscationsCount, "Transactions Count");
	}

	public String getUiCount() {
		return getText(lblPayOutCOunt, "PayOut Received Count");
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

	public void verifyLabelTransactionDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutsReceivedDetails, "PayOuts Received Details", expHeading);
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
