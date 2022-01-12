package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class DaysMonthsDropDownComponent extends BrowserFunctions {

	private By lblTokensSent = By.xpath("//span[text()='Tokens Sent']");

	private By lblTokensReceive = By.xpath("//span[text()='Tokens Received']");

	private By lblTokensPurchased = By.xpath("//span[text()='Token Purchased']");

	private By lblTokensWithdraw = By.xpath("//span[text()='Token Withdraw']");

	private By btnToday = By.cssSelector("data[value='today']");

	private By btnYesterday = By.cssSelector("data[value='yesterday']");

	private By btnLast7Days = By.cssSelector("data[value='last-7-days']");

	private By btnMonthToDate = By.cssSelector("data[value='month-to-date']");

	private By btnLastMonth = By.cssSelector("data[value='last-month']");

	private By btnCustomDateRange = By.cssSelector("data[value='custom-date-range']");

	private By selectDropDown = By.xpath("//div[@class='relative FloatingDropDown_main__1p8if']");

	// private By selectDropDownforReceive =
	// By.xpath("//div[@class='FloatingDropDown_SmallArrow__xxSi7 w-3 h-1.5']");

	public void clickTodayTokensSent() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnToday, "Click Today");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickYesterdayTokensSent() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnYesterday, "yesterday");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickLast7DaysTokensSent() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7days");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickMonthToDateTokenSent() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnMonthToDate, "Click Monthtodate");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickLastMonthTokensSent() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLastMonth, "Click Lastmonth");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickCustomDateRangeTokensSent() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblTokensSent, "Tokens Sent");
	}

	public void clickTodayTokensReceive() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnToday, "Click Today");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickYesterdayTokensReceive() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnYesterday, "yesterday");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickLast7DaysTokensReceive() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7days");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickMonthToDateTokensReceive() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnMonthToDate, "Click Monthtodate");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickLastMonthTokensReceive() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLastMonth, "Click Lastmonth");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickCustomDateRangeTokensReceive() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblTokensReceive, "Tokens Receive");
	}

	public void clickTodayTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnToday, "Click Today");
		new CommonFunctions().elementView(lblTokensPurchased, "Tokens Purchased");
	}

	public void clickYesterdayTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnYesterday, "yesterday");
		new CommonFunctions().elementView(lblTokensPurchased, "Tokens Purchased");
	}

	public void clickLast7DaysTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7days");
		new CommonFunctions().elementView(lblTokensPurchased, "Tokens Purchased");
	}

	public void clickMonthToDateTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnMonthToDate, "Click Monthtodate");
		new CommonFunctions().elementView(lblTokensPurchased, "Tokens Purchased");
	}

	public void clickLastMonthTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLastMonth, "Click Lastmonth");
		new CommonFunctions().elementView(lblTokensPurchased, "Tokens Purchased");
	}

	public void clickCustomDateRangeTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblTokensPurchased, "Tokens Purchased");
	}

	public void clickTodayTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnToday, "Click Today");
		new CommonFunctions().elementView(lblTokensWithdraw, "Tokens Withdraw");
	}

	public void clickYesterdayTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnYesterday, "yesterday");
		new CommonFunctions().elementView(lblTokensWithdraw, "Tokens Withdraw");
	}

	public void clickLast7DaysTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7days");
		new CommonFunctions().elementView(lblTokensWithdraw, "Tokens Withdraw");
	}

	public void clickMonthToDateTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnMonthToDate, "Click Monthtodate");
		new CommonFunctions().elementView(lblTokensWithdraw, "Tokens Withdraw");
	}

	public void clickLastMonthTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLastMonth, "Click Lastmonth");
		new CommonFunctions().elementView(lblTokensWithdraw, "Tokens Withdraw");
	}

	public void clickCustomDateRangeTokensdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblTokensWithdraw, "Tokens Withdraw");
	}
}