package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.DaysMonthsDropDownComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ReserveRulesHistoryPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Reserve Summary']");

	private By txtReserveRecord = By.cssSelector("tbody>tr:nth-of-type(2)>td:nth-of-type(1)");

	private By txtReserveHeld = By.xpath("//p[contains(text(),'Reserve Held')]/parent::div/following-sibling::*[1]");

	private By txtDailyBatchIDs = By.xpath("//p[contains(text(),'Daily')]/following-sibling::*");

	private By txtBatchDate = By.xpath("//p[contains(text(),'Batch ID')]/parent::div/following-sibling::*[1]");

	private By txtReserveRule = By.xpath("(//p[contains(text(),'Reserve Rule')]/following-sibling::*[1])[2]");

	private By txtReserveSummary = By.xpath("//h1[contains(text(),'Reserve Is')]/following-sibling::*[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public void getReserveRecord() {
		ExtentTestManager.setInfoMessageInReport("Reserve Record " + getText(txtReserveRecord, "Reserve Record "));
	}

	public void getReserveHeld() {
		ExtentTestManager.setInfoMessageInReport("Reserve Held " + getText(txtReserveHeld, "Reserve Held "));
	}

	public void getDailyBatchIDs() {
		ExtentTestManager.setInfoMessageInReport("Daily Batch IDs " + getText(txtDailyBatchIDs, "Daily BatchIDs"));
	}

	public void getBatchDate() {
		ExtentTestManager.setInfoMessageInReport("Batch Date" + getText(txtBatchDate, "BatchDate"));
	}

	public void getReserveRule() {
		ExtentTestManager.setInfoMessageInReport("Reserve Rule " + getText(txtReserveRule, "Reserve Rule"));
	}

	public void getReserveSummary() {
		ExtentTestManager.setInfoMessageInReport("Reserve Summary" + getText(txtReserveSummary, "Reserve Summary"));
	}

}
