package coyni_mobile_merchant.components;
import java.time.Duration;

import org.openqa.selenium.By;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

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
		while (getElementList(getDate(monthAndYear, day), "fromDate").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1295)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (1600))).release().perform();
		}
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
			while (getElementList(getDate(monthAndYear, day), "toDate").size() == 0) {
				TouchAction touch = new TouchAction(DriverFactory.getDriver());
				touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(540, (int) (1000))).release().perform();
			
		}
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
