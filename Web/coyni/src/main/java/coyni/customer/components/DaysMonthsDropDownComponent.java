package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class DaysMonthsDropDownComponent extends BrowserFunctions {
	
	private By btnToday =By.cssSelector("");
	
	private By btnYesterday =By.cssSelector("");
	
	private By btnLast7Days = By.cssSelector("");
	
	private By btnMonthToDate =By.cssSelector("");
	
	private By btnLastMonth =By.cssSelector("");
	
	private By btnCustomDateRange =By.cssSelector("");
	
	public void clickToday() {
		click(btnToday, "Click Today");
	}
	
	public void clickYesterday() {
		click(btnYesterday, "Click Yesterday");
	}
	
	public void clickLast7Days() {
		click(btnLast7Days, "Click Last7days");
	}
	
	public void clickMonthToDate() {
		click(btnMonthToDate, "Click Monthtodate");
	}
	public void clickLastMonth() {
		click(btnLastMonth, "Click Lastmonth");
	}
	public void clickCustomDateRange() {
		click(btnCustomDateRange, "Click Custom Date Range");
	}

}
