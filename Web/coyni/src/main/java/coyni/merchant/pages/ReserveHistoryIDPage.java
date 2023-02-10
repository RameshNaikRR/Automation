package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ReserveHistoryIDPage extends BrowserFunctions {

	private By lblHeadingReserveSummary = By.xpath("//span[contains(text(),'Reserve Summary')]");

	private By lblReserveHeld = By.xpath("//h3[contains(text(),'Reserve Held')]/following-sibling::*");

	private By lblDailyBatchIds = By.xpath("//p[contains(text(),'Daily Batch IDs:')]/following-sibling::*");

	private By lblBatchDate = By.xpath("//p[contains(text(),'Batch Date')]/following-sibling::*");

	private By lblReserveRule = By.xpath("//p[contains(text(),'Reserve Rule')]/following-sibling::*");

	private By lblHeadingReleaseSummary = By.xpath("//span[contains(text(),'Release Summary')]");

	private By lblAmountReleased = By.xpath("//h3[contains(text(),'Amount Released')]/following-sibling::*");

	private By lblReleasedOn = By.xpath("//p[contains(text(),'Released On')]/following-sibling::*");

	private By lblReleaseTransactionId = By
			.xpath("//p[contains(text(),'Release Transaction ID')]/following-sibling::*");

	private By btnDownloadPDF = By.xpath("//div[contains(text(),'Download PDF')]");

	private By lblToTokenAccount = By.xpath("//p[contains(text(),'To Token Account')]/following-sibling::*");

	public void verifyReserveHistory(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeadingReserveSummary, "Reserve Summary", expHeading);
	}

	public void verifyDownloadPDF() {
		new CommonFunctions().elementView(btnDownloadPDF, "Download PDF");

	}

	public void getReserveHeld() {
		ExtentTestManager.setInfoMessageInReport("PayOut Date: " + getText(lblReserveHeld, "Reserve Held"));
	}

	public void getDailyBatchIds() {
		ExtentTestManager.setInfoMessageInReport("PayOut Date: " + getText(lblDailyBatchIds, "Daily Batch Id's"));
	}

	public void getBatchDate() {
		ExtentTestManager.setInfoMessageInReport("PayOut Date: " + getText(lblBatchDate, "Batch Date"));
	}

	public void getReserveRule() {
		ExtentTestManager.setInfoMessageInReport("Reserve Rule: " + getText(lblReserveRule, "Reserve Rule"));
	}

	public void verifyReleaseHistory(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeadingReleaseSummary, "Release Summary", expHeading);
	}

	public void getAmountReleased() {
		ExtentTestManager.setInfoMessageInReport("Amount Released: " + getText(lblAmountReleased, "Amount Released"));
	}

	public void getReleasedOn() {	
		ExtentTestManager.setInfoMessageInReport("Released On: " + getText(lblReleasedOn, "Released On"));
	}

	public void getReleasedTransactionID() {
		ExtentTestManager.setInfoMessageInReport(
				"Released Transaction ID: " + getText(lblReleaseTransactionId, "Release Transaction ID"));
	}

	public void getToTokenAccount() {
		ExtentTestManager.setInfoMessageInReport("To Token Account: " + getText(lblToTokenAccount, "To Token Account"));
	}
}
