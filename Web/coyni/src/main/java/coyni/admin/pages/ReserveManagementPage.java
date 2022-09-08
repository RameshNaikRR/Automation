package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.ExportComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ReserveManagementPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Reserves']");

	private By btnReserveManagement = By.xpath("//span[contains(text(),'Reserve Mgmt.')]");

	private By txtSearch = By.xpath("//input[@placeholder='Search By Merchant Name or Merchant ID']");

	private By btnExport = By.xpath("//button[contains(text(),'Export')]");

	private By btnAllStatuses = By.xpath("//div[text()='All Statuses']");

	private By btnStopped = By.xpath("(//div[contains(text(),'Stopped')])[1]");

	private By btnActive = By.xpath("(//div[contains(text(),'Active')])[1]");

	private By btnInActive = By.xpath("(//div[contains(text(),'Inactive')])[1]");

	private By record = By.cssSelector("tbody>tr:nth-of-type(2)>td:nth-of-type(1)");

	public void verifyHeading(String expHeading) {

		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void clickRecord() {
		click(record, "Record");
	}

	public void clickReserveManagement() {
		click(btnReserveManagement, "Reserve Management");
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public void clickExport() {
		click(btnExport, "Export");
	}

	public void clickActive() {
		click(btnActive, "Active");
	}

	public void clickInActive() {
		click(btnInActive, "InActive");
	}

	public void clickStopped() {
		click(btnStopped, "Stopped");
	}

	public void clickAllStatuses() {
		click(btnAllStatuses, "All Statuses");
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}

	public ReserveRulesPage reserveRulesPage() {
		return new ReserveRulesPage();
	}

}
