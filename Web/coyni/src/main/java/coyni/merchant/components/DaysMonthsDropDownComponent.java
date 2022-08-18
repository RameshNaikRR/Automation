package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class DaysMonthsDropDownComponent extends BrowserFunctions {

	private By lblPayOutsReceived = By.xpath("//span[text()='Payouts Received']");

	private By lblPurchased = By.xpath("//span[text()='Tokens Purchased']");

	private By lblWithdraw = By.xpath("//span[text()='Tokens Withdrawn']");

	private By btnToday = By.cssSelector("data[value='Today']");

	private By btnYesterday = By.cssSelector("data[value='Yesterday']");

	private By btnLast7Days = By.cssSelector("data[value='Last-7-Days']");

	private By btnMonthToDate = By.cssSelector("data[value='Month-To-Date']");

	private By btnLastMonth = By.cssSelector("data[value='Last-Month']");

	private By btnCustomDateRange = By.cssSelector("data[value='Custom-Date-Range']");

	private By selectDropDown = By.xpath("//div[contains(@class,'FloatingDropDown_downArrow__LiVFi')]");

	private By selectDropDownToday = By
			.xpath("//div[@class='font-semibold group-hover:text-cgy4 text-cgy3 text-base']");

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

	public void clickTodayPayOutsReceived() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnToday, "Click Today");
		new CommonFunctions().elementView(lblPayOutsReceived, "Payouts Received");
	}

	public void clickYesterdayPayOutsReceived() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnYesterday, "yesterday");
		new CommonFunctions().elementView(lblPayOutsReceived, "Payouts Received");
	}

	public void clickLast7DaysPayOutsReceived() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7days");
		new CommonFunctions().elementView(lblPayOutsReceived, "Payouts Received");
	}

	public void clickMonthToDatePayOutsReceived() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnMonthToDate, "Click Monthtodate");
		new CommonFunctions().elementView(lblPayOutsReceived, "Payouts Received");
	}

	public void clickLastMonthPayOutsReceived() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLastMonth, "Click Lastmonth");
		new CommonFunctions().elementView(lblPayOutsReceived, "Payouts Received");
	}

	public void clickCustomDateRangePayOutsReceived() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblPayOutsReceived, "Payouts Received");
	}

	public void clickTodayTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnToday, "Click Today");
		new CommonFunctions().elementView(lblPurchased, "Tokens Purchased");
	}

	public void clickYesterdayTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnYesterday, "yesterday");
		new CommonFunctions().elementView(lblPurchased, "Tokens Purchased");
	}

	public void clickLast7DaysTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7days");
		new CommonFunctions().elementView(lblPurchased, "Tokens Purchased");
	}

	public void clickMonthToDateTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnMonthToDate, "Click Monthtodate");
		new CommonFunctions().elementView(lblPurchased, "Tokens Purchased");
	}

	public void clickLastMonthTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLastMonth, "Click Lastmonth");
		new CommonFunctions().elementView(lblPurchased, "Tokens Purchased");
	}

	public void clickCustomDateRangeTokensPurchased() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblPurchased, "Tokens Purchased");
	}

	public void clickTodayTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnToday, "Click Today");
		new CommonFunctions().elementView(lblWithdraw, "Tokens Withdraw");
	}

	public void clickYesterdayTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnYesterday, "yesterday");
		new CommonFunctions().elementView(lblWithdraw, "Tokens Withdraw");
	}

	public void clickLast7DaysTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLast7Days, "Click Last7days");
		new CommonFunctions().elementView(lblWithdraw, "Tokens Withdraw");
	}

	public void clickMonthToDateTokensWithdraw() {
		click(selectDropDownToday, "Click Select DropDOwn");
		click(btnMonthToDate, "Click Monthtodate");
		new CommonFunctions().elementView(lblWithdraw, "Tokens Withdraw");
	}

	public void clickLastMonthTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnLastMonth, "Click Lastmonth");
		new CommonFunctions().elementView(lblWithdraw, "Tokens Withdraw");
	}

	public void clickCustomDateRangeTokensWithdraw() {
		click(selectDropDown, "Click Select DropDOwn");
		click(btnCustomDateRange, "Click Custom Date Range");
		new CommonFunctions().elementView(lblWithdraw, "Tokens Withdraw");
	}
}