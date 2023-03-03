package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ReserveHistoryPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[.='Reserve Release History']");

	private By btnRolling = By.xpath("//button[contains(text(),'Rolling')]");

	private By btnManual = By.xpath("//button[contains(text(),'Manual')]");

	private By btnAllStatuses = By.xpath("//p[text()='All Statuses']");

	private By reserveHistory = By.cssSelector("tbody>tr:nth-of-type(3)>td:nth-of-type(2)");

	private By btnOpen = By.xpath("//p[text()='Open']");

	private By btnOnHold = By.xpath("//p[text()='On Hold']");

	private By btnReleased = By.xpath("//p[text()='Released']");

	private By openStatus = By.xpath("(//div[contains(text(),'Open')])[1]");

	private By onHoldStatus = By.xpath("(//div[contains(text(),'On Hold')])[1]");

	private By releaseStatus = By.xpath("(//div[contains(text(),'Released')])[1]");

	private By btnCancelled = By.xpath("//p[text()='Cancelled']");

	private By txtSearch = By.cssSelector("MerchantReserveHistory_search_bar_gbox__PKxFs");

	private By lblNoRecords = By.xpath("//span[contains(text(),'You do not have any records')]");

	private By lnkRolling = By.cssSelector("tbody>tr:nth-of-type(5)>td:nth-of-type(1)");

	private By lnkManual = By.cssSelector("tbody>tr:nth-of-type(5)>td:nth-of-type(1)");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Reserve History page heading", expHeading);
	}

	public void verifyStatus() {
		if (verifyElementDisplayed(openStatus, "Open Status")) {
			clickOpen();
		} else if (verifyElementDisplayed(onHoldStatus, "On Hold Status")) {
			clickOnHold();
		} else {
			clickReleased();
		}
	}

	public void clickReserveHistory() {
		click(reserveHistory, "Reserve History");
	}

	public int verifyExports() {
		return getElementsList(lblNoRecords, "").size();
	}

	public String verifyNoRecordsFound() {
		new CommonFunctions().elementView(lblNoRecords, "No Records");
		return getText(lblNoRecords, "No Records");
	}

	public void fillSearch(String search) {
		enterText(txtSearch, "Search", search);
	}

	public void clickRolling() {
		click(btnRolling, "Rolling");
	}

	public void clickManual() {
		click(btnManual, "Manual");
	}

	public void clickAllStatuses() {
		click(btnAllStatuses, "All Statuses");
	}

	public void clickOpen() {
		click(btnOpen, "Open");
	}

	public void clickOnHold() {
		click(btnOnHold, "On Hold");
	}

	public void clickReleased() {
		click(btnReleased, "Released");
	}

	public void clickCancelled() {
		click(btnCancelled, "Cancelled");
	}

	public ReserveHistoryIDPage reserveHistoryIDPage() {
		return new ReserveHistoryIDPage();
	}

	public ExportfilesPage exportfilesPage() {
		return new ExportfilesPage();
	}

}
