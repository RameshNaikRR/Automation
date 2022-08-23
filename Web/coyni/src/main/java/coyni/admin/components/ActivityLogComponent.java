package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class ActivityLogComponent extends BrowserFunctions {

	private By lblNoActivityLog = By.xpath("//p[text()='No Activity Logs']");
	private By heading = By.xpath("//div[@class='body']//span[text()='Activity Log']");
	private By btnStatuses = By.xpath("//div[contains(text(),'Statuses')]");
	private By btnControls = By.xpath("//div[contains(text(),'Controls')]");
	private By viewActivityLogStatuses = By.xpath("//span[contains(text(),'•')]");
	private By viewActivityLogControls = By.xpath("//span[contains(text(),'•')]");
	
	public String verifyHeading() {
		String str = getText(heading, "Heading");
		ExtentTestManager.setInfoMessageInReport("Heading is "+str);
		return str;
	}
	
	public void clickSatuses() {
		click(btnStatuses, "Statuses");
	}
	
	public void clickControls() {
		click(btnControls, "Controls");
	}
	
	public void verifyActivityLogStatuses() {
		new CommonFunctions().elementView(viewActivityLogStatuses,"Activity log is displayed");
	}
	
	public int verifyNoActivityLog() {
		return DriverFactory.getDriver().findElements(lblNoActivityLog).size();
	}
	
	public void verifyActivityLogControls() {
		new CommonFunctions().elementView(viewActivityLogControls, getCopiedData());
	}
	
	
}
