package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PayOutHistoryPage extends BrowserFunctions {

	private By lblPayOutHistory = By.xpath("//h1[.='Payout History']");

	private By txtSearch = By.xpath("//input[@placeholder='Search By Payout Date or Payout ID']");

	private By payOut = By.cssSelector("tbody>tr:nth-of-type(5)>td:nth-of-type(1)");

	private By lblRecord = By.xpath("//div[text()='Business Token Account']");

	private By lblDateTime = By.xpath("//span[contains(text(),'DATE & TIME')]");

	private By lblPayOutID = By.xpath("//span[contains(text(),'PAYOUT ID')]");

	private By lblSentTo = By.xpath("//span[contains(text(),'SENT TO')]");

	private By lblTransCount = By.xpath("//span[contains(text(),'TRANS. COUNT')]");

	private By lblNetAmount = By.xpath("//span[contains(text(),'NET AMOUNT')]");

	private By lblStatus = By.xpath("(//span[contains(text(),'STATUS')])[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutHistory, "Pay Out History page heading", expHeading);
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public void clickRecord() {
		click(lblRecord, "Record displayed");
	}

	public void clickPayOut() {
		click(payOut, "Pay Out");
	}

	public void verifyLabelPayOutDetails() {
		new CommonFunctions().elementView(lblDateTime, "Date and Time");
		new CommonFunctions().elementView(lblPayOutID, "Pay Out ID");
		new CommonFunctions().elementView(lblSentTo, "Sent To");
		new CommonFunctions().elementView(lblTransCount, "Transc Count");
		new CommonFunctions().elementView(lblNetAmount, "Net Amount");
		new CommonFunctions().elementView(lblStatus, "Status");
	}

	public PayOutIDPage payOutIDPage() {
		return new PayOutIDPage();
	}

}
