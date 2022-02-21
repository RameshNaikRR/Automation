package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionPage extends BrowserFunctions {

	private By headingTransactionList = By.cssSelector(".text");
	private By lblToken = By.xpath("");
	private By lblBusiness = By.xpath("");
	private By lblDateTime = By.xpath("");
	private By lblUserType = By.xpath("");
	private By lblType = By.xpath("");
	private By lblSubType = By.xpath("");
	private By lblDescription = By.xpath("");
	private By lblAmount = By.xpath("");
	private By lblStatus = By.xpath("");

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
