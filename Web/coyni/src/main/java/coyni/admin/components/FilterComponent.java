package coyni.admin.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class FilterComponent extends BrowserFunctions {

	private By btnFilters = By.xpath("//button[text()='Filter']");
	private By txtFromAmount = By.xpath("");
	private By txtToAmount = By.xpath("");
	private By btnResetAllFilters = By.xpath("");
	private By btnApplyFilters = By.xpath("");
	private By lnkClear = By.xpath("");
	private By lnkClearAll = By.xpath("");

	public void clickFilters() {
		if (getElement(btnFilters, "Enabled").isEnabled()) {
			click(btnFilters, "Filters");
			ExtentTestManager.setPassMessageInReport("Filters button is Enabled");
		} else {
			ExtentTestManager.setPassMessageInReport("Filters button is Disabled");
		}

	}

	public void fillFromAmount(String fromAmount) {
		enterText(txtFromAmount, fromAmount, "From Amount");
	}

	public void fillToAmount(String toAmount) {
		enterText(txtToAmount, toAmount, "To Amount");
	}

	public void clickClear() {
		click(lnkClear, "Clear");
	}

	public void clickClearAll() {
		click(lnkClearAll, "Clear All");
	}

	private By getCheckBox(String elementName) {
		return By.xpath(String.format("//span[text()='%s']//preceding-sibling::input", elementName));
	}

	public void clickInProgress() {
		click(getCheckBox("In Progress"), "In Progress");
	}

	public void clickCompleted() {
		click(getCheckBox("Completed"), "Completed");
	}

	public void clickAdministrator() {
		click(getCheckBox("Administrator"), "Administrator");
	}

	public void clickPermissionRole() {
		click(getCheckBox("Permission Role"), "Permission Role");
	}

	public void clickActive() {
		click(getCheckBox("Active"), "Active");
	}

	public void clickExpired() {
		click(getCheckBox("Expired"), "Expired");
	}

	public void clickPending() {
		click(getCheckBox("Pending"), "Pending");
	}

	public void clickInactive() {
		click(getCheckBox("Inactive"), "Inactive");
	}

	public void clickBusiness() {
		click(getCheckBox("Business"), "Business");
	}

	public void clickCoyni() {
		click(getCheckBox("coyni"), "coyni");
	}

	public void clickResetAllFilters() {
		click(btnResetAllFilters, "Reset All Filters");
	}

	public void clickApplyFilters() {
		click(btnApplyFilters, "Apply Filters");
	}

}
