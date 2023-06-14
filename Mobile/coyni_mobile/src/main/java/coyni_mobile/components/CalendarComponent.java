package coyni_mobile.components;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CalendarComponent extends MobileFunctions {
	private By btnDone = By.xpath("//*[@name='Choose range']/following-sibling::XCUIElementTypeButton[@name='Done']");
	private By btnClose = By.xpath("//*[@name='Choose range']/preceding-sibling::XCUIElementTypeButton[@name='close']");
	private By iconClear = By.xpath("//*[@name='icon clear']");
	private By lblDateRange = By.xpath("//*[@name='icon clear']/preceding-sibling::*[1]");
	private By lblentirePage = MobileBy.xpath(
			"(//*[@name='Select date range']/../../following-sibling::XCUIElementTypeCollectionView)[1] | //*[@name='icon clear']/../../following-sibling::XCUIElementTypeCollectionView");

	private By lblMonthYear = MobileBy.xpath(
			"//*[@name='Select date range']/../../following-sibling::XCUIElementTypeCollectionView/XCUIElementTypeOther/XCUIElementTypeStaticText | //*[@name='icon clear']/../../following-sibling::XCUIElementTypeCollectionView/XCUIElementTypeOther/XCUIElementTypeStaticText");

	public By getDate(String monthAndYear, String day) {
		return MobileBy.xpath(String.format(
				"(//*[@name='%s']/../following-sibling::XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[@name='%s'])[1]",
				monthAndYear, day));
	}

//	public void selectFromDate(String fromDate) {
//		// 1,January 2022
//		String day = fromDate.split(",")[0];
//		String monthAndYear = fromDate.split(",")[1];
//		System.out.println("day:"+day+"month :"+monthAndYear);
//		//scrollUpToElement(getDate(monthAndYear, day), "");
//		click(getDate(monthAndYear, day), fromDate);
//	}
//	
//	public void selectToDate(String toDate) {
//		// 1,January 2022
//		String day = toDate.split(",")[0];
//		String monthAndYear = toDate.split(",")[1];
//		//scrollDownToElement(getDate(monthAndYear, day), toDate);
//		click(getDate(monthAndYear, day), toDate);
//	}
//	public void selectFromDate(String fromDate) {
//		// 1,January 2022
//		String day = fromDate.split(",")[0];
//		String monthAndYear = fromDate.split(",")[1];
//		System.out.println("day:" + day + "month :" + monthAndYear);
//		for (int i = 0; i < 20; i++) {
//			this.swipeCalenderDown();
//			List<String> monthDayText = getElementList(lblMonthYear, "Month Year Text").stream()
//					.map(ele -> ele.getAttribute("label")).collect(Collectors.toList());
//			System.out.println(monthDayText);
//			if (monthDayText.contains(monthAndYear)) {
//				break;
//			}
//		}
//
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		click(getDate(monthAndYear, day), fromDate);
//	}
//
//	public void selectToDate(String toDate) {
//		// 1,January 2022
//		String day = toDate.split(",")[0];
//		String monthAndYear = toDate.split(",")[1];
//		System.out.println("day:" + day + "month :" + monthAndYear);
////		scrollDownToElement(getDate(monthAndYear, day), toDate);
//		// swipeOnElement(btnClose, monthAndYear, null);
//		for (int i = 0; i < 20; i++) {
//			this.swipeCalenderUp();
//			List<String> monthDayText = getElementList(lblMonthYear, "Month Year Text").stream()
//					.map(ele -> ele.getAttribute("label")).collect(Collectors.toList());
//			System.out.println(monthDayText);
//			if (monthDayText.contains(monthAndYear)) {
//				break;
//			}
//		}
//
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		click(getDate(monthAndYear, day), toDate);
//	}

	public void selectFromDate() throws InterruptedException {
	// 1-January 2022
        LocalDate lodt = LocalDate.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM YYYY");
	 String localFromDate = lodt.minusDays(10).format(formatter);
		 System.out.println(localFromDate);
		String day = localFromDate.split("-")[0];
		 String monthAndYear = localFromDate.split("-")[1];
		//        Thread.sleep(1000);
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
		LocalDate lodt = LocalDate.now();
	 System.out.println(lodt);
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM yyyy");
		 String localToDate = lodt.format(formatter);
      String day = localToDate.split("-")[0];
		 String monthAndYear = localToDate.split("-")[1];
		 System.out.println(day);
	 System.out.println(monthAndYear);
		//        Thread.sleep(1000);
	 while (getElementList(getDate(monthAndYear, day), localToDate).size() == 0) {
		 TouchAction touch = new TouchAction(DriverFactory.getDriver());
		 touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
	 .moveTo(PointOption.point(540, (int) (1000))).release().perform();
}
      click(getDate(monthAndYear, day), localToDate);
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

//	public void selectDate(String fromDate, String toDate) throws InterruptedException {
//		if (getElementList(iconClear, "").size() > 0) {
//			clickClear();
//		}
//		selectFromDate(fromDate);
//		Thread.sleep(5000);
//		selectToDate(toDate);
//		clickDone();
//	}

	public void swipeCalenderDown() {
		WebElement element = getElement(lblentirePage, "Calendars");
		Rectangle rect = element.getRect();
		int x = rect.x + (int) rect.getWidth() / 2;
		int startY = (int) (rect.y + rect.getHeight() * 0.2);
		int endY = (int) (rect.y + rect.getHeight() * 0.5);
		System.out.println(x + "      " + startY + "          " + endY);
		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, startY));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), x, endY));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		DriverFactory.getDriver().perform(Arrays.asList(tap));
	}

	public void swipeCalenderUp() {
		WebElement element = getElement(lblentirePage, "Calendars");
		Rectangle rect = element.getRect();
		int x = rect.x + (int) rect.getWidth() / 2;
		int startY = (int) (rect.y + rect.getHeight() * 0.8);
		int endY = (int) (rect.y + rect.getHeight() * 0.5);
		System.out.println(x + "      " + endY + "          " + startY);
		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, startY));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), x, endY));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		DriverFactory.getDriver().perform(Arrays.asList(tap));
	}

}

