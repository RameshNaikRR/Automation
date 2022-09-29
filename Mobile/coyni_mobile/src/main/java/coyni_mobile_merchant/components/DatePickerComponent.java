package coyni_mobile_merchant.components;
import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class DatePickerComponent extends MobileFunctions {
	private By btnDone = By.xpath("//*[contains(@text,'Done')]");
	private By btnClose = By.xpath("//*[@name='Choose range']/preceding-sibling::XCUIElementTypeButton[@name='close']");
	private By iconClear = By.xpath("//*[@name='icon clear']");
	private By lblDateRange = By.xpath("//*[@name='icon clear']/preceding-sibling::*[1]");
	private By btnCalendar = MobileBy.xpath("//*[contains(@class,'ImageView')]");
//	private By btnCalendar = MobileBy.xpath("//*[contains(@resource-id,'datePickET')]");

	public By getDate(String monthAndYear, String day) {
		return MobileBy.xpath(String.format(
				"(//*[@text = '%s']/../following-sibling::android.widget.FrameLayout/android.widget.TextView[@text='%s'])[1]",
				monthAndYear, day));
	}

	public void selectFromDate(String fromDate) {
		// 1-January 2022
		String day = fromDate.split("-")[0];
		String monthAndYear = fromDate.split("-")[1];
		scrollDownToElement(getDate(monthAndYear, day), "fromDate");
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
		scrollDownToElement(getDate(monthAndYear, day), "toDate");
		click(getDate(monthAndYear, day), toDate);
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void clickClear() {
		click(iconClear, "clear icon");
	}
	public void clickCalendar() throws InterruptedException {
		scrollDownToElement(btnCalendar, "Calendar");
		Thread.sleep(3000);
    	click(btnCalendar, "Calendar");
    }
	

}
