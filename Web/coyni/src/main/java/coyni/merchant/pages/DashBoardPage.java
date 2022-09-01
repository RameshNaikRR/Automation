package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.components.DaysMonthsDropDownComponent;
import coyni.merchant.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DashBoardPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Merchant Dashboard']");

	private By lblProcessingVolume = By.xpath("//span[text()='Processing Volume']");

	private By lblGrossAmountProcessed = By
			.xpath("//span[contains(text(),'Gross Amount Processed')]/following-sibling::*[1]");

	private By lblRefunds = By.xpath("//span[contains(text(),'Refunds')]/following-sibling::*");

	private By lblProcessingFees = By.xpath("//span[contains(text(),'Processing')]/following-sibling::*");

	private By lblMiscellaneousFees = By.xpath("//span[contains(text(),'Miscell')]/following-sibling::*");

	private By lblNetAmount = By.xpath("//span[contains(text(),'Net')]/following-sibling::*");

	private By lblMerchantBalance = By.xpath("//span[contains(text(),'Merchant Balance')]/following-sibling::*[1]");

	private By lblBatchPayOuts = By.xpath("//span[contains(text(),'Batch Payouts')]");

	private By lblNextPayOut = By.xpath("//span[contains(text(),'Next Payout')]/..");

	private By lblLastPayOut = By.xpath("//span[contains(text(),'Last Payout')]/..");

	private By lnkBatchNow = By.xpath("//button[text()='Batch Now']");

	private By lnkManualBatch = By.xpath("//span[text()='Manual Batch']");

	private By lblReserveBalance = By.xpath("(//span[contains(text(),'Reserve Balance')])[2]/following-sibling::*[1]");

	private By lblReserveDescription = By
			.xpath("(//span[contains(text(),'Reserve Balance')])[2]/following-sibling::*[2]");

	private By lblNextRelease = By.xpath("//span[contains(text(),'Next Release')]/following-sibling::*");

	private By lblLastRelease = By.xpath("//span[contains(text(),'Last Release')]/following-sibling::*");

	private By lblViewFullPayOutHistory = By.xpath("//button[contains(text(),'View Full Payout History')]");

	private By lblPayOutHistory = By
			.xpath("//span[contains(text(),'Payout History')]/..//div[contains(@class,'mb-3.5')]");

	private By lblViewFullTransactionHistory = By.xpath("//span[contains(text(),'View Full Transaction History')]");

	private By lblViewFullReserveReleaseHistory = By
			.xpath("//span[contains(text(),'View Full Reserve Release History')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Dashboard page heading", expHeading);
	}

	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport("Account Balance: " + getText(lblMerchantBalance, "Merchant Balance"));
	}

	public void getPayOutHistoryRecentTransactions() {
		ExtentTestManager.setInfoMessageInReport(
				"Pay Out History Recent Transactions: " + getText(lblPayOutHistory, "Pay Out History"));
	}

	public void getReserveBalance() {
		ExtentTestManager.setInfoMessageInReport("Reserve Balance: " + getText(lblReserveBalance, "Reserve Balance"));
	}

	public void getReserveBalanceDescription() {
		ExtentTestManager.setInfoMessageInReport(
				"Reserve Balance Description" + getText(lblReserveDescription, "Reserve Balance Description"));
	}

	public void getNextRelease() {
		ExtentTestManager.setInfoMessageInReport("Next Release: " + getText(lblNextRelease, "Next Release: "));
	}

	public void getLastRelease() {
		ExtentTestManager.setInfoMessageInReport("Last Release: " + getText(lblLastRelease, "Last Release: "));
	}

	public void getRefunds() {
		ExtentTestManager.setInfoMessageInReport("Refunds: " + getText(lblRefunds, "Refunds"));
	}

	public void getProcessingFees() {
		ExtentTestManager.setInfoMessageInReport("ProcessingFees: " + getText(lblProcessingFees, "Processing Fees"));
	}

	public void getMiscellaneousFees() {
		ExtentTestManager
				.setInfoMessageInReport("Miscellaneous Fees: " + getText(lblMiscellaneousFees, "Miscellaneous Fees"));
	}

	public void getNetAmount() {
		ExtentTestManager.setInfoMessageInReport("Net Amount: " + getText(lblNetAmount, "Net Amount"));
	}

	public void getBatchPayOuts() {
		ExtentTestManager.setInfoMessageInReport("Batch PayOuts: " + getText(lblBatchPayOuts, "Batch PayOuts"));
	}

	public void getNextPayOut() {
		ExtentTestManager.setInfoMessageInReport("Next PayOut: " + getText(lblNextPayOut, "Next PayOut"));
	}

	public void getLastPayOut() {
		ExtentTestManager.setInfoMessageInReport("Last PayOut: " + getText(lblLastPayOut, "Last PayOut"));
	}

	public void getTotalCommissionEarned() {
		ExtentTestManager.setInfoMessageInReport(
				"lblGrossAmountPurchased: " + getText(lblGrossAmountProcessed, "Gross Amount Processed"));
	}

	public void clickBatchNow() {
		click(lnkBatchNow, "Batch Now");
	}

	public void clickFullPayOutHistory() {
		scrollToElement(lblViewFullPayOutHistory, "Full PayOut History");
		click(lblViewFullPayOutHistory, "Full PayOut History");
	}

	public void clickFullTransactionHistory() {
		click(lblViewFullTransactionHistory, "Full Transaction History");
	}

	public void clickFullReserveReleaseHistory() {
		click(lblViewFullReserveReleaseHistory, "Full Reserve Release History");
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

}
