package coyni.api.business.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class FiltersPage extends BrowserFunctions {
	private By checkBoxActive = By.xpath("//span[text()='Active']");
	private By checkBoxPending = By.xpath("//span[text()='Invitation Pending']");
	private By checkBoxExpired = By.xpath("//span[text()='Invitation Expired']");
	private By lnkClearAll = By.xpath("(//button[@type='button'])[1]");
	private By lnkPerClearAll = By.xpath("(//button[@type='button'])[2]");
	private By resetFilters = By.xpath("(//button[@type='button'])[3]");
	private By applyFilters = By.xpath("//button[text()='Apply Filters']");
	private By PermissionRole = By.xpath("(//div[@class=\"relative flex flex-wrap gap-2\"])[2]/div");
	private By msgNoRecords = By.cssSelector("//p[text()='No Records Found']");

	public void verifyClearAll() {
		click(lnkClearAll, "Clear All");
	}

	public void verifyPermissionClearAll() {
		click(lnkPerClearAll, "Clear All");
	}

	public void verifyResetFilters() {
		click(resetFilters, "Reset Filters");
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

	public void getNoRecordsFound() {
		if (getElementsList(msgNoRecords, "No Records Found").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Table contains Records");
		} else {
			ExtentTestManager.setInfoMessageInReport("Table does not contains any records");
		}
	}

	public void getPermissionsRole(String option, String eleName) {
		try

		{
			By options = By.xpath("//div[@class=\\\"relative flex flex-wrap gap-2\\\"])[2]/div");
			List<WebElement> optionEles = getElementsList(options, "options");
			boolean status = false;
			for (WebElement optionEle : optionEles) {
				if (optionEle.getText().equalsIgnoreCase(option)) {
					optionEle.click();
					status = true;
					break;
				}
			}
			if (status) {
				ExtentTestManager.setInfoMessageInReport(
						option + " selected from " + eleName + "  Permission Role check Boxes ");
			} else {
				ExtentTestManager.setFailMessageInReport(
						option + " not available in " + eleName + "  Permission Role check Boxes");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("select checkBox failed due to exception " + e);
		}
	}
}
