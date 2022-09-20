package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class UnderWritingPersonalComponent extends BrowserFunctions {
	
	private By btnNew = By.xpath("//button//div[contains(text(),'New')]");
	private By btnrow = By.xpath("//tr[@class='  businessRow mb-0']");
	private By lblCaseId = By.xpath("//tr//td[contains(@class,'id')]");
	private By lblDate = By.xpath("//tr//td[contains(@class,'updatedDate')]");
	private By lblCustomerId = By.xpath("//tr//td[contains(@class,'customerId')]");
	private By lblCustomerName = By.xpath("//tr//td[contains(@class,'customerFullName')]");
	private By lblCaseStatus = By.xpath("//tr//div[contains(text(),'New')]");
	private By lblDueDate = By.xpath("//div[contains(@class,'PersonalUsers_dueFont')]");
    private By lblHeading = By.xpath("//span[text()='Underwriting - Personal']");
    private By btnInReview = By.xpath("//button//div[contains(text(),'In Review')]");
	
	
	
		
	
	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Heading");
	}
	
	
	public void clickNew() {
		click(btnNew, "Click Button");
	}
	
	public void clickCustomer() {
		click(btnrow, "Click Customer");
	}
	
	public String verifyCaseID() {
		String str = getText(lblCaseId, "CaseId");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Case id is " + str1);
		return str1;
	}
	
	public String verifyDate() {
		String str = getText(lblDate, "Date");
		ExtentTestManager.setInfoMessageInReport("Date is" + str);
		return str;
	}
	
	public String verifyCustomerID() {
		String str = getText(lblCustomerId, "CustomerId");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Custmoer id is " + str1);
		return str1;
	}
	
	public String verifyCustomerName() {
		String str = getText(lblCustomerName, "Customer Name");
		ExtentTestManager.setInfoMessageInReport("Customer Name is" + str);
		return str;
	}
	
	public String verifyCaseStatus() {
		String str = getText(lblCaseStatus, "Case Status");
		ExtentTestManager.setInfoMessageInReport("Case Status is" + str);
		return str;
	}
	
	public String verifyDueDate() {
		String str = getText(lblDueDate, "Due Date");
		ExtentTestManager.setInfoMessageInReport("Due Date is" + str);
		return str;
	}
	
	public UnderWritingCaseDetailsComponent underWritingCaseDetailsComponent() {
		return new UnderWritingCaseDetailsComponent();
	}
	
	public void clickInReview() {
		click(btnInReview, "In Review");
	}
	
	
	
	

	
       	

}
