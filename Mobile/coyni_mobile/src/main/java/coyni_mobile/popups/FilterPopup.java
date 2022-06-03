package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.DatePickerComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FilterPopup extends MobileFunctions{
	
	private By lblTransactions = MobileBy.xpath("//*[@text='Transactions']");
	private By txtFromAmount = MobileBy.xpath("//*[contains(@resource-id,'transAmountStartET')]");
	private By txtToAmount = MobileBy.xpath("//*[contains(@resource-id,'transAmountEndET')]");
	private By btnCalendar = MobileBy.xpath("//*[@text='Date']/following-sibling::*[1]");
	private By btnresetAllFilters = MobileBy.xpath("//*[contains(@resource-id,'resetFiltersTV')]");
	private By btnApplyFilter = MobileBy.xpath("//*[@text='Apply Filter']");
	private By btnDone = MobileBy.xpath("//*[@text='Done']");
	 
    public void verifyHeading(String expHeading) {
    	new CommonFunctions().verifyLabelText(lblTransactions, "Transaction Heading is", expHeading);
    }
    public void fillFromAmount(String fromAmount) {
    	scrollDownToElement(txtFromAmount, "From Amount");
    	enterText(txtFromAmount, fromAmount, "From Amount");
    	click(txtFromAmount, "From Amount");
    }
    public void fillToAmount(String toAmount) {
    	enterText(txtToAmount, toAmount, "To Amount");
    }
    public void clickCalendar() {
    	click(btnCalendar, "Calendar");
    }
    public void clickResetAllFilters() {
    	click(btnresetAllFilters, "Reset All Filters");
    }
    public void clickApplyFilter() {
    	click(btnApplyFilter, "Apply Filter");
    }
    private By getElement(String elementName) {
    	return MobileBy.xpath(String.format("//*[@text='%s']", elementName));
    }
    public void selectFilter(String type) throws InterruptedException {
    	Thread.sleep(2000);
        scrollDownToElement(getElement(type), type);
        Thread.sleep(2000);
    	click(getElement(type), type);
    }
    public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}
    public void clickDone() {
    	click(btnDone, "Done");
    }

}
