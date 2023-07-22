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
	private By btnDone = By.id("com.coyni.mapp:id/doneTV");

	public By getDate(String monthAndYear, String day) {
		return MobileBy.xpath(String.format(
				"(//*[@text = '%s']/../following-sibling::android.widget.FrameLayout/android.widget.TextView[@text='%s'])[1]",
				monthAndYear, day));
	}

	public void selectFromDate() throws InterruptedException {
		// 1-January 2022
		LocalDate lodt = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM YYYY");
		String localFromDate = lodt.minusDays(20).format(formatter);
		System.out.println(localFromDate);
		String day = localFromDate.split("-")[0];
		String monthAndYear = localFromDate.split("-")[1];
		//         Thread.sleep(1000);
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
		String localToDate = lodt.minusDays(1).format(formatter);
		String day = localToDate.split("-")[0];
		String monthAndYear = localToDate.split("-")[1];
		System.out.println(day);
		System.out.println(monthAndYear);
		//         Thread.sleep(1000);
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

}
