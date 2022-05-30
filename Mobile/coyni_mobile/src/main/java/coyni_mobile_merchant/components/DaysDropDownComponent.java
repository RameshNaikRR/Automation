package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class DaysDropDownComponent extends MobileFunctions {

	private By drpdwn = By.xpath("//*[contains(@resource-id,'tv_processing_volume')]");

	private By btnToday = By.xpath("//*[contains(@resource-id,'tv_today')]");

	private By btnYesterday = By.xpath("//*[contains(@resource-id,'tv_yesterday')]");

	private By btnMonthToDate = By.xpath("//*[contains(@resource-id,'tv_month_to_date')]");

	private By btnLastMonth = By.xpath("//*[contains(@resource-id,'tv_last_month')]");

	private By btnCustomDateRange = By.xpath("//*[contains(@resource-id,'tv_custom_date')]");

	public void clickOnToday() {
		click(drpdwn, "Drop Down");
		click(btnToday, "Click Today");

	}

	public void clickOnYesterday() {
		click(drpdwn, "Drop Down");
		click(btnYesterday, "Click Yesterday");

	}

	public void clickOnMonthToDate() {
		click(drpdwn, "Drop Down");
		click(btnMonthToDate, "Click MonthToDate");

	}

	public void clickOnLastMonth() {
		click(drpdwn, "Drop Down");
		click(btnLastMonth, "Click LastMonth");

	}

	public void clickOnCustomDateRange() {
		click(drpdwn, "Drop Down");
		click(btnCustomDateRange, "Click CustomDateRange");

	}
}
