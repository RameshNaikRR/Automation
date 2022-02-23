package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionPage extends BrowserFunctions {

	private By headingTransactionList = By.xpath("//span[text()='Transaction List']");
	private By lblToken = By.xpath("//div[text()='Token']");
	private By lblBusiness = By.xpath("//div[text()='Business']");
	private By lblDateTime = By.xpath("//span[text()='Date / Time']");
	private By lblUserType = By.xpath("//span[text()='User Type']");
	private By lblType = By.xpath("//span[text()='Type']");
	private By lblSubType = By.xpath("//span[text()='Sub Type']");
	private By lblDescription = By.xpath("//span[text()='Description']");
	private By lblAmount = By.xpath("//span[text()='Amount(CYN)']");
	private By lblStatus = By.xpath("//span[text()='Status']");

	public void verifyTransactionHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingTransactionList, "Transaction Heading", expHeading);
	}

	public void clickToken() {
		click(lblToken, "Token");
	}

	public void clickBusiness() {
		click(lblBusiness, "Business");
	}

	public void getDateAndTime() {
		ExtentTestManager.setPassMessageInReport("Date/Time is " + getElement(lblDateTime, "Date/Time"));
	}

	public void getUserType() {
		ExtentTestManager.setPassMessageInReport("UserType is " + getElement(lblUserType, "UserType"));
	}

	public void getType() {
		ExtentTestManager.setPassMessageInReport("Type is " + getElement(lblType, "Type"));
	}

	public void getSubType() {
		ExtentTestManager.setPassMessageInReport("Sub Type is " + getElement(lblSubType, "Sub Type"));
	}

	public void getDescription() {
		ExtentTestManager.setPassMessageInReport("Description is " + getElement(lblDescription, "Description"));
	}

	public void getAmount() {
		ExtentTestManager.setPassMessageInReport("Amount is " + getElement(lblAmount, "Amount"));
	}

	public void getStatus() {
		ExtentTestManager.setPassMessageInReport("Status is " + getElement(lblStatus, "Status"));
	}

	public TransactionDetailsPage transactionDetailsPage() {
		return new TransactionDetailsPage();
	}
}
