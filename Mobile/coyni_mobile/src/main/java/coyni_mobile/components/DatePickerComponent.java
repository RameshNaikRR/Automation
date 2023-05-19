package coyni_mobile.components;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

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
	public String localDate() {
		LocalDate lodt = LocalDate.now();
		System.out.println(lodt);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM yyyy");

		// Format the local date
		String formattedDate = lodt.format(formatter);
		System.out.println(formattedDate);
//		LocalDate previousDate = lodt.minusDays(17);
		String previousformattedDate = lodt.minusDays(17).format(formatter);
		System.out.println(previousformattedDate);
		return previousformattedDate;
	}

	public void selectFromDate() throws InterruptedException {
		// 1-January 2022

		LocalDate lodt = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM yyyy");
		String localFromDate = lodt.minusDays(30).format(formatter);
		System.out.println(localFromDate);
		String day = localFromDate.split("-")[0];
		String monthAndYear = localFromDate.split("-")[1];
//		Thread.sleep(1000);
		System.out.println(day);
		System.out.println(monthAndYear);
		while (getElementList(getDate(monthAndYear, day), localFromDate).size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1295)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (1600))).release().perform();
		}
		System.out.println(day);
		System.out.println(monthAndYear);
		click(getDate(monthAndYear, day), localFromDate);
	}
	public void selectToDate() throws InterruptedException {
		// 1-January 2022
		LocalDate lodt = LocalDate.now();
		System.out.println(lodt);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM yyyy");
		String localToDate = lodt.format(formatter);
		
		String day = localToDate.split("-")[0];
		String monthAndYear = localToDate.split("-")[1];
		System.out.println(day);
		System.out.println(monthAndYear);
//		Thread.sleep(1000);
		while (getElementList(getDate(monthAndYear, day), localToDate).size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (1000))).release().perform();

		}
		click(getDate(monthAndYear, day), localToDate);
	}
//	public void selectFromDate(String fromDate) {
//		// 1-January 2022
//		String day = fromDate.split("-")[0];
//		String monthAndYear = fromDate.split("-")[1];
//		scrollUpToElement(getDate(monthAndYear, day), fromDate);
//		//scrollDownToElement(getDate(monthAndYear, day), fromDate);
//		System.out.println(day);
//		System.out.println(monthAndYear);
//		click(getDate(monthAndYear, day), fromDate);
//	}

//	public void selectToDate(String toDate) {
//		// 1-January 2022
//		String day = toDate.split("-")[0];
//		String monthAndYear = toDate.split("-")[1];
//		System.out.println(day);
//		System.out.println(monthAndYear);
//		scrollDownToElement(getDate(monthAndYear, day), toDate);
//		click(getDate(monthAndYear, day), toDate);
//	}

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
