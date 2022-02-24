package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class FilterComponent extends BrowserFunctions {
	private By lblDate = By.xpath("//label[text()='Date']");
	private By lnkClear = By.xpath("//label[text()='Date']//button[text()='Clear']");
	private By lblTransactionType = By.xpath("//span[text()='Transaction Type']");
	private By lnkClearAll = By.xpath("//span[text()='Transaction Type']//button[text()='Clear All']");
	private By lblTransactionAmount = By.xpath("//label[text()='Transaction Amount']");
	private By txtFromAmount = By.xpath("//span[text()='From (CYN)']");
	private By txtToAmount = By.xpath("//span[text()='To (CYN)']");
	private By lblReferenceId = By.xpath("//button[text()='Clear']/ancestor::label[text()='Reference ID']");
	private By txtReferenceId = By.xpath("//input[@id='Reference ID']");
	private By lblTransactionStatus = By.xpath("//span[text()='Transaction Status']");
	//private By lnkClaerAll = By.xpath("");
	private By lblEmployeeName = By.xpath("//label[text()='Employee Name']");
	private By drpdwn = By.xpath("div[class*='selected_option']");
	private By lnkResetAllFilters = By.xpath("");
	private By btnApplyFilters = By.xpath("");
	
	public void verifyDate(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDate, "Heading is",expHeading);
	}
	public void clickClear() {
		click(lnkClear, "Clear");
	}
	public void verifyTransactionType(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionType, "Transaction Type Heading is",expHeading);
	}
	public void clickClearAll() {
		click(lnkClearAll, "Claer All");
	}
	public void verifyTrasactionAmount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionAmount, "Transaction Amount Heading is", expHeading);
	}
	public void fillAmount(String fromAmount) {
		enterText(txtFromAmount,fromAmount,"From Amount");
	}
	public void fillToAmount(String toAmount) {
		enterText(txtToAmount, toAmount, "To Amount");
	}
	public void verifyReferenceId(String expGeading) {
		new CommonFunctions().verifyLabelText(lblReferenceId, "Reference ID Heading is" , expGeading);
	}
	public void fillReferenceID(String referenceID) {
		enterText(txtReferenceId, referenceID, "Reference ID");
	}
	public void verifyTransactionStatus(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionStatus, "Transaction Status Heading is", expHeading);
	}
	public void verifyEmployeeName(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmployeeName, "Employee Name Heading is",expHeading);
	}
	public void selectDropDown(String employees) {
		selectDropdown(drpdwn, employees, "Employees");
	}
	public void clickResetAllFilters() {
		click(lnkResetAllFilters, "Reset All Filters");
	}
	public void clickApplyFilters() {
	    click(btnApplyFilters, "Apply Filters");
	}
	private By getCheckBox(String elementName) {
		return By.xpath(String.format("", elementName));
	}
	public void clickInProgress() {
		click(getCheckBox("In Progress"), "In Progress");
	}
	public void clickCompleted() {
		click(getCheckBox("Completed"), "Completed");
	}
	public void clickFailed() {
		click(getCheckBox("Failed"),"Failed");
	}
	public void clickWon() {
		click(getCheckBox("Won"),"Won");
	}
	public void clickLost() {
		click(getCheckBox("Lost"),"Lost");
	}
	
  
}
