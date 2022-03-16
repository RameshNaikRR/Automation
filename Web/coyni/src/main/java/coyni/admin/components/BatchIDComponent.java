package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;


public class BatchIDComponent extends BrowserFunctions{
	
	private By lblTotalBatchAmount = By.xpath("(//span[text()='Total Batch Amount']//following::span)[1]");
	private By lblInProgressCount = By.xpath("(//span[text()='InProgress']//following::span)[1]");
	private By lblPaidCount = By.xpath("(//span[text()='Paid']//following::span)[1]");
	private By lblFailedCount = By.xpath("(//span[text()='Failed']//following::span)[1]");
	private By lblPendingCount = By.xpath("(//span[text()='Pending']//following::span)[1]");
	private By lblTotalCount = By.xpath("(//span[text()='Total Count']//following::span)[1]");
	private By lblBatchId = By.cssSelector(".text");
	
	
	public void getTotalBatchAmount() {
		ExtentTestManager.setInfoMessageInReport("Total Batch Amount: "+getText(lblTotalBatchAmount, ""));
	}
	public void  getInProgressCount() {
	   ExtentTestManager.setInfoMessageInReport("In Progress Count : "+getText(lblInProgressCount, " "));
	}
	public void getPaidCount() {
		ExtentTestManager.setInfoMessageInReport("Paid Count : "+getText(lblPaidCount, " "));
	}
	public void getFailedCount() {
		ExtentTestManager.setInfoMessageInReport("Failed Count : "+getText(lblFailedCount, " "));
	}
	public void getPendingCount() {
		ExtentTestManager.setInfoMessageInReport("Pending Count : "+getText(lblPendingCount, " "));
	}
	public void getTotalAccount() {
		ExtentTestManager.setInfoMessageInReport("Total Count : "+getText(lblTotalCount, " "));
	}
	public void verifyBatchId(String expBatchId) {
		new CommonFunctions().verifyLabelText(lblBatchId, "Batch ID",expBatchId);
	}
   public void verifyBatchIdView() {
	   new CommonFunctions().elementView(lblBatchId, "Batch Id");
   }
   
}
