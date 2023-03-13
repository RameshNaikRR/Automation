package coyni_mobile.components;
import org.openqa.selenium.By;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class DatePickerComponent extends MobileFunctions {
	private By btnDone = By.xpath("//*[contains(@resource-id,'doneTV')]");
	private By btnClose = By.xpath("//*[@name='Choose range']/preceding-sibling::XCUIElementTypeButton[@name='close']");
	private By iconClear = By.xpath("//*[@name='icon clear']");
	private By lblDateRange = By.xpath("//*[@name='icon clear']/preceding-sibling::*[1]");
	private By btnCalendar = MobileBy.xpath("//*[@text='Date']/following-sibling::*[1]");

	public By getDate(String monthAndYear, String day) {
		return MobileBy.xpath(String.format(
				"(//*[@text = '%s']/../following-sibling::android.widget.FrameLayout/android.widget.TextView[@text='%s'])[1]",
				monthAndYear, day));
	}

	public void selectFromDate(String fromDate) {
		// 1-January 2022
		String day = fromDate.split("-")[0];
		String monthAndYear = fromDate.split("-")[1];
		//scrollUpToElement(getDate(monthAndYear, day), fromDate);
		System.out.println(day);
		System.out.println(monthAndYear);
		click(getDate(monthAndYear, day), fromDate);
	}

	public void selectToDate(String toDate) {
		// 1-January 2022
		String day = toDate.split("-")[0];
		String monthAndYear = toDate.split("-")[1];
		System.out.println(day);
		System.out.println(monthAndYear);
		//scrollDownToElement(getDate(monthAndYear, day), toDate);
		click(getDate(monthAndYear, day), toDate);
	}

	public void clickDone() {
		DriverFactory.getDriver().manage().window().getSize();
        scrollUpToElement(btnDone, "Done");
		click(btnDone, "Done");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void clickClear() {
		click(iconClear, "clear icon");
	}
	public void clickCalendar() {
		scrollDownToElement(btnCalendar, "Calendar");
    	click(btnCalendar, "Calendar");
    }
	

}
