package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;


public class BatchIDComponent extends BrowserFunctions{
	
	private By lblTotalBatchAmount = By.cssSelector("");
	private By lblInProgressCount = By.cssSelector("");
	private By lblPaidCount = By.cssSelector("");
	private By lblFailedCount = By.cssSelector("");
	private By lblPendingCount = By.cssSelector("");
	private By totalCount = By.cssSelector("");
	private By lblBatchId = By.cssSelector("");
	
	
	public String getTotalBatchAmount() {
		return getText(lblTotalBatchAmount, "Total Batch Amount");
	}
	public String getInProgressCount() {
		return getText(lblInProgressCount, "In Progress Count");
	}
	public String getPaidCount() {
		return getText(lblPaidCount, "Paid Count");
	}
	public String getFailedCount() {
		return getText(lblFailedCount, "Failed Count");
	}
	public String getPendingCount() {
		return getText(lblPendingCount, "Pending Count");
	}
	public String getTotalAccount() {
		return getText(totalCount, "Total Count");
	}
	public void verifyBatchId(String expBatchId) {
		new CommonFunctions().verifyLabelText(lblBatchId, "Batch ID",expBatchId);
	}

}
