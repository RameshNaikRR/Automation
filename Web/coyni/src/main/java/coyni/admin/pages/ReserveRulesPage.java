package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.DaysMonthsDropDownComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ReserveRulesPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Reserve Summary']");

	private By txtReserveAmount = By.xpath("//input[@name='percentage']");

	private By txtReservePeriod = By.xpath("//input[@name='Period']");

	private By lblReserveType = By.xpath("//p[contains(text(),'Reserve Type')]/following-sibling::*");

	private By lblReserveBalance = By.xpath("//p[contains(text(),'Reserve Balance')]/following-sibling::*[1]");

	private By lblNextRelease = By.xpath("//p[contains(text(),'Next Release')]/following-sibling::*");

	private By lblLastRelease = By.xpath("//p[contains(text(),'Last Release')]/following-sibling::*");

	private By btnActivityLog = By.xpath("//button[contains(text(),'Activity Log')]");

	private By reserveRecords = By.cssSelector(".ReserveManagementDetails_second_table__3bcG0");

	private By btnActivityLogDesc = By.xpath("//div[contains(@class,'ReserveManagementDetails_r')]/div/div/div/div/p");

	private By btnFullReserveReleaseHistory = By
			.xpath("//button[contains(text(),'View Full Reserve Release History')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void fillReserveAmount(String reserveAmount) {
		enterText(txtReserveAmount, reserveAmount, "Reserve Amount");
	}

	public void fillReservePeriod(String reservePeriod) {
		enterText(txtReservePeriod, reservePeriod, "Reserve Period");
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public void clickActivityLog() {
		click(btnActivityLog, "Activity Log");
	}

	public void clickFullReserveReleaseHistory() {
		click(btnFullReserveReleaseHistory, "Full Reserve Release History");
	}

	public void getReserveType() {
		ExtentTestManager.setInfoMessageInReport("Reserve Type " + getText(lblReserveType, "Reserve Type "));
	}

	public void getReserveBalance() {
		ExtentTestManager.setInfoMessageInReport("Reserve Balance " + getText(lblReserveBalance, "Reserve Balance "));
	}

	public void getActivityLog() {
		ExtentTestManager
				.setInfoMessageInReport("Activity Log" + getText(btnActivityLogDesc, "Activity Log Description"));
	}

	public void getNextRelease() {
		ExtentTestManager.setInfoMessageInReport("Next Release " + getText(lblNextRelease, "Next Release "));
	}

	public void getLastRelease() {
		ExtentTestManager.setInfoMessageInReport("Last Release " + getText(lblLastRelease, "Last Release "));
	}

	public void getReserveRecords() {
		ExtentTestManager.setInfoMessageInReport("Reserve Records " + getText(reserveRecords, "Reserve Records "));
	}

}
