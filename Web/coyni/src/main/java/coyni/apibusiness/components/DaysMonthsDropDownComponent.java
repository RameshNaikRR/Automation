package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class DaysMonthsDropDownComponent extends BrowserFunctions {

	private By btnToday = By.cssSelector("data[value='Today']");

	private By btnYesterday = By.cssSelector("data[value='Yesterday']");

	private By btnLast7Days = By.cssSelector("data[value='Last-7-Days']");

	private By btnMonthToDate = By.cssSelector("data[value='Month-To-Date']");

	private By btnLastMonth = By.cssSelector("data[value='Last-Month']");

	private By btnCustomDateRange = By.cssSelector("data[value='Custom-Date-Range']");

	private By selectDropDown = By.xpath("//div[@class= 'icon-small-arrow text-xs mt-0.5 fill-current hover:text-cm3 text-cm3 FloatingDropDown_upArrow__1K2Pa false']");

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

}