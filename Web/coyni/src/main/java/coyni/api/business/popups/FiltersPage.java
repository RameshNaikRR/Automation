package coyni.api.business.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class FiltersPage extends BrowserFunctions {
	private By checkBoxActive = By.xpath("//span[text()='Active']");
	private By checkBoxPending = By.xpath("//span[text()='Invitation Pending']");
	private By checkBoxExpired = By.xpath("//span[text()='Invitation Expired']");
	private By lnkClearAll = By.xpath("(//button[@type='button'])[1]");
	private By lnkPerClearAll = By.xpath("(//button[@type='button'])[2]");
	private By resetFilters = By.xpath("(//button[@type='button'])[3]");
	private By applyFilters = By.xpath("//button[text()='Apply Filters']");

	public void verifyClearAll() {
		click(lnkClearAll, "Clear All");
	}

	public void verifyPermissionClearAll() {
		click(lnkPerClearAll, "Clear All");
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

}
