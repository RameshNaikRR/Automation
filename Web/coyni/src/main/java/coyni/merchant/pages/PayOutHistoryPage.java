package coyni.merchant.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PayOutHistoryPage extends BrowserFunctions {

	private By lblPayOutHistory = By.xpath("//h1[.='Payout History']");

	private By txtSearch = By.xpath("//input[@placeholder='Search By Payout Date or Payout ID']");

	private By payOut = By.cssSelector("tbody>tr:nth-of-type(2)>td:nth-of-type(1)");

	private By lblRecord = By.xpath("//div[text()='Business Token Account']");

	private By lblDateTime = By.xpath("//span[contains(text(),'DATE & TIME')]");

	private By lblPayOutID = By.xpath("//span[contains(text(),'PAYOUT ID')]");

	private By lblSentTo = By.xpath("//span[contains(text(),'SENT TO')]");

	private By lblTransCount = By.xpath("//span[contains(text(),'TRANS. COUNT')]");

	private By lblNetAmount = By.xpath("//span[contains(text(),'NET AMOUNT')]");

	private By lblStatus = By.xpath("(//span[contains(text(),'STATUS')])[1]");

	private By lblNoTrasactons = By.xpath("//span[contains(text(),'You do not have any transactions.')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutHistory, "Pay Out History page heading", expHeading);
	}

	public void fillSearch(String search) throws Exception {
		enterText(txtSearch, search + Keys.ENTER, "Search");

	}

	public void clickTab() throws AWTException {
		new CommonFunctions().clickOutSideElement();
	}

	public void clickRecord() {
		click(lblRecord, "Record displayed");
	}

	public void clickPayOut() {
		if (getElement(payOut, "payout").isEnabled()) {
			// scrollToElement(payOut, "Payout");
			click(payOut, "PayOut");
		} else {
			ExtentTestManager.setPassMessageInReport("Pay button is Disabled");
		}

	}

	public void verifyNoPayOutFound() {
		new CommonFunctions().elementView(lblNoTrasactons, "No Trasactions");
//		return getText(lblNoTrasactons, "No Trasactions");
	}

	public int verifyPayOut() {
		int ele = getElementsList(lblNoTrasactons, "").size();
		return ele;
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
