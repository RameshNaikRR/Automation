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
	private By btnApplyfilter = MobileBy.xpath("//*[contains(@resource-id,'applyFilterBtnCV')]");
	private By btnFilterIcon = MobileBy.xpath("//*[contains(@resource-id,'ivFilterIcon')]");

	public void clickApplyfilters() {
		click(btnApplyfilter, "Apply filters");
	}

	public void clickResetAllFilters() {
		click(btnResetAllFilters, "Reset All Filters");
	}

	public void clickFilterIcon() {
		click(btnFilterIcon, "Filter Icon");
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
		return MobileBy.xpath(String.format("//*[contains(@text,'%s')]", elementName));
	}

	public void selectFilter(String type) {
		scrollDownToElement(getElement(type), "");
		click(getElement(type), "type");
	}
}
