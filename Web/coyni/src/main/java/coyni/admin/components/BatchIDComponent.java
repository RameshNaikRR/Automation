package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;


public class BatchIDComponent extends BrowserFunctions{
	
	private By lblTotalBatchAmount = By.xpath("(//span[text()='Total Batch Amount']//following::span)[1]");
	private By lblInProgressCount = By.xpath("(//span[text()='InProgress']//following::span)[1]");
	private By lblPaidCount = By.xpath("(//span[text()='Paid']//following::span)[1]");
	private By lblFailedCount = By.xpath("(//span[text()='Failed']//following::span)[1]");
	private By lblPendingCount = By.xpath("(//span[text()='Pending']//following::span)[1]");
	private By totalCount = By.xpath("(//span[text()='Total Count']//following::span)[1]");
	private By lblBatchId = By.cssSelector(".text");
	
	
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
