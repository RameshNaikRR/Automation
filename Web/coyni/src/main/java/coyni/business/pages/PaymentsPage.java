package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PaymentsPage extends BrowserFunctions {
	private By lblsummary = By.xpath("");
	private By lblachlimits = By.xpath("");
	private By lblachbatch = By.xpath("");
	private By selectdropDown = By.xpath("");
	private By totalACHAmount = By.xpath("");
	private By totalTransactions = By.xpath("");
	private By clickStatuskey = By.xpath("");
	private By clickFilter = By.xpath("");
	private By clickSearch = By.xpath("");
	private By clickNewPayment = By.xpath("");

	public void verifySummary(String summary) {
		new CommonFunctions().verifyLabelText(lblsummary, "Summary is :", summary);
	}

	public void verifyACHLimits(String ach) {
		new CommonFunctions().verifyLabelText(lblachlimits, "ACH Limits:", ach);
	}

	public void verifyACHBatch(String achBatch) {
		new CommonFunctions().verifyLabelText(lblachbatch, "ACH Batch:", achBatch);
	}

	public void getAchAmount() {
		String str = getText(totalACHAmount, "ACH Amount");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void getTotalTransactions() {
		String str = getText(totalTransactions, "Transactions");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void clickStatusKey() {
		click(clickStatuskey, "Status Key");
	}

	public void clickFilter() {
		click(clickFilter, "Filter");
	}

	public void clickSearch() {
		click(clickSearch, "Search");
	}

	public void clickNewPayment() {
		click(clickNewPayment, "New Payment");
	}

	public void SelectDropDown() {
		getElement(selectdropDown, "Drop Down");
		click(selectdropDown, "Drop Down");
	}
}
