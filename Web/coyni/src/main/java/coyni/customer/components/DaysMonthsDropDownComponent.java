package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class DaysMonthsDropDownComponent extends BrowserFunctions {
	private By btnToday = By.cssSelector("data[value='today']");

	private By lblTokensSent = By.xpath("//span[text()='Tokens Sent']");

	private By btnYesterday = By.cssSelector("data[value='yesterday']");

	private By lblTokensReceive = By.xpath("//span[text()='Tokens Received']");

	private By btnLast7Days = By.cssSelector("data[value='last-7-days']");

	private By btnMonthToDate = By.cssSelector("data[value='month-to-date']");

	private By btnLastMonth = By.cssSelector("data[value='last-month']");

	private By btnCustomDateRange = By.cssSelector("data[value='custom-date-range']");

	private By selectDropDownforSent = By.xpath("//div[@class='FloatingDropDown_SmallArrow__xxSi7 w-3 h-1.5']");

	private By selectDropDownforReceive = By.xpath("//div[@class='FloatingDropDown_SmallArrow__xxSi7 w-3 h-1.5']");

	public void clickTodayTokensSent() {
		click(selectDropDownforSent, "Click Select DropDOwn");
		click(btnToday, "Click Today");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickYesterdayTokensSent(String txnDetails) {
		click(selectDropDownforSent, "Click Select DropDOwn");
		click(btnYesterday, "yesterday");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickLast7DaysTokensSent(String txnDetails) {
		click(selectDropDownforSent, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7days");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickMonthToDateTokenSent() {
		click(selectDropDownforSent, "Click Select DropDOwn");
		click(btnMonthToDate, "Click Monthtodate");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickLastMonthTokensSent() {
		click(selectDropDownforSent, "Click Select DropDOwn");
		click(btnLastMonth, "Click Lastmonth");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickCustomDateRangeTokensSent() {
		click(selectDropDownforSent, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickTodayTokensReceive() {
		click(selectDropDownforReceive, "Click Select DropDOwn");
		click(btnToday, "Click Today");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickYesterdayTokensReceive(String txnDetails) {
		click(selectDropDownforReceive, "Click Select DropDOwn");
		click(btnYesterday, "yesterday");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickLast7DaysTokensReceive(String txnDetails) {
		click(selectDropDownforReceive, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7days");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickMonthToDateTokensReceive() {
		click(selectDropDownforReceive, "Click Select DropDOwn");
		click(btnMonthToDate, "Click Monthtodate");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickLastMonthTokensReceive() {
		click(selectDropDownforReceive, "Click Select DropDOwn");
		click(btnLastMonth, "Click Lastmonth");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickCustomDateRangeTokensReceive() {
		click(selectDropDownforReceive, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

}