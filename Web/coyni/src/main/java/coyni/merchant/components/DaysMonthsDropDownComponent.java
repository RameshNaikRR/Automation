package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class DaysMonthsDropDownComponent extends BrowserFunctions {

	private By lblTokensPurchased = By.xpath("//span[text()='Tokens Purchased']");

	private By lblTokensWithdraw = By.xpath("//span[text()='Tokens Withdraw']");

	private By btnToday = By.cssSelector("data[value='Today']");

	private By btnYesterday = By.cssSelector("data[value='Yesterday']");

	private By btnLast7Days = By.cssSelector("data[value='Last-7-Days']");

	private By btnMonthToDate = By.cssSelector("data[value='Month-To-Date']");

	private By btnLastMonth = By.cssSelector("data[value='Last-Month']");

	private By btnCustomDateRange = By.cssSelector("data[value='Custom-Date-Range']");

	private By selectDropDown = By.xpath("//div[@class='h-8 flex items-center space-x-4 cursor-pointer ']");

	// private By selectDropDownforReceive =
	// By.xpath("//div[@class='FloatingDropDown_SmallArrow__xxSi7 w-3 h-1.5']");

	public void clickOnToday() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnToday, "Click Today");

	}

	public void clickOnYesterday() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnYesterday, "Click Yesterday");

	}

	public void clickOnLast7Days() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7Days");

	}

	public void clickOnMonthToDate() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnMonthToDate, "Click MonthToDate");

	}

	public void clickOnLastMonth() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLastMonth, "Click LastMonth");

	}

	public void clickOnCustomDateRange() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click CustomDateRange");

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

	public void clickCustomDateRangeTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblTokensWithdraw, "Tokens Withdraw");
	}
}