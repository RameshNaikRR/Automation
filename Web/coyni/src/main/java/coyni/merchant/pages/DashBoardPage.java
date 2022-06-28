package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.admin.components.DaysMonthsDropDownComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DashBoardPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Merchant Dashboard']");

	private By lblProcessingVolume = By.xpath("//span[text()='Processing Volume']");

	private By lblGrossAmountProcessed = By
			.xpath("//span[contains(text(),'Gross Amount Processed')]/following-sibling::*[1]");

	private By lblMerchantBalance = By.xpath("//span[contains(text(),'Merchant Balance')]/following-sibling::*[1]");

	private By lblBatchPayOuts = By.xpath("//span[contains(text(),'Batch Payouts')]/../following-sibling::*[1]");

	private By lblNextPayOut = By.xpath("//span[contains(text(),'Next Payout')]/..");

	private By lblLastPayOut = By.xpath("//span[contains(text(),'Last Payout')]/..");

	private By lnkBatchNow = By.xpath("//button[text()='Batch Now']");

	private By lnkManualBatch = By.xpath("//span[text()='Manual Batch']");

	private By lblViewFullPayOutHistory = By.xpath("//span[contains(text(),'View Full Payout History')]");

	private By lblViewFullTransactionHistory = By.xpath("//span[contains(text(),'View Full Transaction History')]");

	private By lblViewFullReserveReleaseHistory = By
			.xpath("//span[contains(text(),'View Full Reserve Release History')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport("Account Balance: " + getText(lblMerchantBalance, "Merchant Balance"));
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

}
