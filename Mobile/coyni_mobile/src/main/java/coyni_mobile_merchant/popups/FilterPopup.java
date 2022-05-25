package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FilterPopup extends MobileFunctions {

	private By lblTransactionType = MobileBy.xpath("//*[@text='Transaction Type']");
	private By txtFromAmount = MobileBy.xpath("//*[@text='To']/following-sibling::*[1]");
	private By txtToAmount = MobileBy.xpath("//*[@text='Transaction Amount']/preceding-sibling::*[1]");
	private By btnCalender = MobileBy.xpath("//*[@text='Date']/following-sibling::*[1]");
	private By btnResetAllFilters = MobileBy.xpath("//*[contains(@resource-id,'resetFiltersTV')]");
	private By btnApplyfilter = MobileBy.xpath("//*[@text='Apply Filter']");
	private By lblPayOutDateRange = MobileBy.xpath("");

	public void clickApplyfilters() {
		click(btnApplyfilter, "Apply filters");
	}

	public void clickResetAllFilters() {
		click(btnResetAllFilters, "Reset All Filters");
	}

	public void clickPayOutDateRange() {
		click(lblPayOutDateRange, "PayOut Date Range");
	}

	public void clickCalender() {
		click(btnCalender, "Calender");
	}

	public void fillFromAmount(String fromAmount) {
		enterText(txtFromAmount, fromAmount, "From Amount");
	}

	public void fillToAmount(String toAmount) {
		enterText(txtToAmount, toAmount, "To Amount");
	}

	public void verifyTransactionType(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionType, "Page Heading", expHeading);
	}

	public By getElement(String elementName) {
		return MobileBy.xpath(String.format("//XCUIElementTypeCell/*[@name='%s']", elementName));
	}

	public void selectFilter(String type) {
		scrollDownToElement(getElement(type), type);
		click(getElement(type), type);
	}
}
