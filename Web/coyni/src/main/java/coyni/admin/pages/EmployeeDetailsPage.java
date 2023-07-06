package coyni.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class EmployeeDetailsPage extends BrowserFunctions {
	WebDriver webdriver = DriverFactory.getDriver();
	private By status = By.xpath("");
	private By accountId = By.xpath("");
	private By lnkDeactivateEmployee = By.xpath("");
	private By lnkViewPermission = By.xpath("");
	private By clickSave = By.xpath("");
	private By viewLog = By.xpath("");

	public void getStatus() {
		String str = getText(status, "Status");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void getAccountId() {
		String str = getText(accountId, "AccountID");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void clickDeactivate() {
		click(lnkDeactivateEmployee, "Deactivate Employee");
	}

	public void clickSave() {
		click(clickSave, "Save");
	}

	public void viewLog() {

//		List<WebElement> optionsEles = objBrowserFunctions.getElementsList(options, "options");
//		for (WebElement optionEle : optionsEles) {
//			
	}

	public void clickViewPermission() {
		click(lnkViewPermission, "View Permission");
	}

}
