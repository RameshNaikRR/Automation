package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class FiltersPage extends BrowserFunctions {

	private By checkBoxActive = By.xpath("//span[text()='Active']");
	private By checkBoxPending = By.xpath("//span[text()='Invitation Pending']");
	private By checkBoxExpired = By.xpath("//span[text()='Invitation Expired']");
	private By lnkClearAll = By.xpath("//button[text()='Clear All']");
	private By resetFilters = By.xpath("(//button[@type='button'])[3]");
	private By applyFilters = By.xpath("//button[text()='Apply Filters']");
	private By msgNoRecords = By.xpath("//div[contains(text(),'No Records Found')]");

	public void verifyClearAll() {
		click(lnkClearAll, "Clear All");
	}

	public void verifyResetFilters() {
		click(resetFilters, "Apply Filters");
	}

	public void verifyApplyFilters() {
		click(applyFilters, "Apply Filters");
	}

	public void verifyActive() {
		click(checkBoxActive, "Active");
	}

	public void verifyPending() {
		click(checkBoxPending, "Pending");
	}

	public void verifyExpired() {
		click(checkBoxExpired, "Expired");
	}

	public int verifyRecords() {
		return getElementsList(msgNoRecords, "").size();
	}

	public String verifyNoRecordsFound() {
		new CommonFunctions().elementView(msgNoRecords, "No Records");
		return getText(msgNoRecords, "No Records");
	}
}
