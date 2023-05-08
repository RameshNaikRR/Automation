package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.CalendarComponent;
import coyni_mobile_merchant.components.DatePickerComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FilterPopup extends MobileFunctions {

	private By lblTransactionType = MobileBy.xpath("//*[@text='Transaction Type']");
	private By txtFromMerchantAmount = MobileBy.xpath("//*[contains(@resource-id,'transAmountStartET')]");//
	private By txtToMerchantAmount = MobileBy.xpath("//*[contains(@resource-id,'transAmountEndET')]");
	private By txtFromAmount = MobileBy.xpath("//*[@text='To']/following-sibling::*[1]");//
	private By txtToAmount = MobileBy.xpath("//*[@text='Transaction Amount']/preceding-sibling::*[1]");
	private By btnCalender = MobileBy.xpath("//*[@text='Date']/following-sibling::*[1]");
	private By btnResetAllFilters = MobileBy.xpath("//*[contains(@resource-id,'resetFiltersTV')]");
	private By btnApplyfilter = MobileBy.xpath("//*[contains(@resource-id,'applyFilterBtnCV')]");
	private By btnFilterIcon = MobileBy.xpath("//*[contains(@resource-id,'Filter')]|//*[contains(@resource-id,'filter')]");
	private By btnDateRange = MobileBy.xpath("//*[contains(@resource-id,'datePickIV')]");

	public void clickApplyfilters() {
		click(btnApplyfilter, "Apply filters");
	}

	public void verifyFilters() {
		new CommonFunctions().elementView(btnApplyfilter, "Apply filters");
		new CommonFunctions().elementView(btnResetAllFilters, "Reset All Filters");
		click(btnApplyfilter, "Apply filters");
	}
	
	public void clickDateRange() {
		click(btnDateRange, "Date Range");
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

	public void fillFromMerchantAmount(String fromAmount) {
		enterText(txtFromMerchantAmount, fromAmount, "From Amount");
	}

	public void fillToMerchantAmount(String toAmount) {
		enterText(txtToMerchantAmount, toAmount, "To Amount");
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
		System.out.println(elementName);
		if (elementName.equalsIgnoreCase("TransactionTypeRefund")) {
			return MobileBy.xpath("//*[contains(@resource-id,'transTypeRefund')]");
		}
		else if (elementName.equalsIgnoreCase("TransactionStatusRefund")){
			return MobileBy.xpath("//*[contains(@resource-id,'transStatusRefund')]");
		}
		else {
		return MobileBy.xpath(String.format("//*[contains(@text,'%s')]", elementName));
		}
	}

	public void selectFilter(String type) {
//		scrollDownToElement(getElement(type), "");
		click(getElement(type), type);
	}

	public void selectMerchantTransactionsFilter(String type) {
		click(getElement(type), type);
	}

	public void validateReserveBalanceFilters(String type1, String type2, String type3, String type4, String type5) {

		click(getElement(type1), type1);
		click(getElement(type2), type2);
		click(getElement(type3), type3);
		click(getElement(type4), type4);
		click(getElement(type5), type5);

	}
	
	public void validateBusinessTokenFilters(String type1, String type2, String type3) {
		click(getElement(type1), type1);
		click(getElement(type2), type2);
		click(getElement(type3), type3);

	}
	
	public DatePickerComponent  datePickerComponent() {
		return new DatePickerComponent();
	}
	
	public CalendarComponent  calendarComponent() {
		return new CalendarComponent();
	}
}
