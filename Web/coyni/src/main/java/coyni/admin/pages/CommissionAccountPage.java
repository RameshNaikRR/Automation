package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CommissionAccountPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Commission Account']");
	private By lblCommissionActivity = By.xpath("//span[text()='Commission Activity']");
	private By lblTotalCommissionAccount = By.xpath("");
	private By lblTransactions = By.xpath("");
	private By drpdwnToday = By.xpath("");
	private By drpdwnMonthToDate = By.xpath("");
	private By lblBusinessPerformance = By.xpath("");
	private By drpdwnPayments = By.xpath("");
	private By drpdwnDepositFunds = By.xpath("");
	private By drpdwnWithdrawals = By.xpath("");
	private By drpdwnTransfers = By.xpath("");
	private By drpdwnMiscellaneousFees = By.xpath("");
	private By lblPayoutHeading = By.xpath("");
	private By lblOpenBatchAmount = By.xpath("");
	private By btnBtachNow = By.xpath("");
	private By lnkViewFullPayoutHistory = By.xpath("");
	private By lnkViewFullTransactionHistory = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyCommissionAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCommissionActivity, "Heading", expHeading);
	}

	public String getTotalCommissionAccount() {
		String text = getText(lblTotalCommissionAccount, "Total Commissions Amount");
		ExtentTestManager.setInfoMessageInReport("Total Commissions Amount Earned is : " + text);
		return text;
	}

	public String getTransactions() {
		String text = getText(lblTransactions, "Transactions");
		ExtentTestManager.setInfoMessageInReport("Transactions Count is: " + text);
		return text;
	}

	public void selectToday(String today) {
		selectDropdown(drpdwnToday, today, "Today");
	}

	public void selectMonthToDate(String monthToDate) {
		selectDropdown(drpdwnMonthToDate, monthToDate, "Month To Date");
	}

	public void verifyMonthToDate(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBusinessPerformance, "Heading", expHeading);
	}

	public void clickPayments() {
		click(drpdwnPayments, "Payments");
	}

	public void clickDepositFunds() {
		click(drpdwnDepositFunds, "Deposit Funds");
	}

	public void clickWithdrawals() {
		click(drpdwnWithdrawals, "Withdrawals");
	}

	public void clickTransfers() {
		click(drpdwnTransfers, "Transfers");
	}

	public void clickMiscellaneousFees() {
		click(drpdwnMiscellaneousFees, "Miscellaneous Fees");
	}

	public void verifyPayoutHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayoutHeading, "Heading", expHeading);
	}

	public String getOpenBatchAmount() {
		String text = getText(lblOpenBatchAmount, "Open Batch Amount");
		ExtentTestManager.setInfoMessageInReport("Open Batch Amount is: " + text);
		return text;
	}

	public void clickBatchNow() {
		click(btnBtachNow, "Batch Now");
	}

	public void clickViewFullPayoutHistory() {
		click(lnkViewFullPayoutHistory, "View Full Payout History");
	}

	public void clickViewFullTransactionHistory() {
		click(lnkViewFullTransactionHistory, "View Full Transaction History");
	}

}
