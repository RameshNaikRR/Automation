package coyni_mobile.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import coyni_mobile.popups.FiltersPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class TransactionsPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Transactions']");
	private By frstTransaction = MobileBy.xpath(
			"//*[@text='In progress']/../../following-sibling::*[1]|//*[@text='Today']/../../following-sibling::*[1]|//*[@text='Past']/../../following-sibling::*[1]");
	private By btnFilter = MobileBy.id("com.coyni.mapp:id/ivFilterIcon");
	private By btnfiltericon = MobileBy.xpath("//*[@name='filter'] | (//*[@name='search']/following-sibling::*[2])[2]");
	private By lblNoMore = MobileBy.id("com.coyni.mapp:id/tvNoTxn");
	private By lblNoRecent = MobileBy.id("com.coyni.mapp:id/tvNoTxn");
	private By btnBack = MobileBy.xpath("//XCUIElementTypeButton[@name='Button']");
	private By btnCross = MobileBy.AccessibilityId("close");
	private By btnTransactions = MobileBy.id("com.coyni.mapp:id/messageTV");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public void clickfilter() {
		click(btnfiltericon, "filter icon");
	}

	public void clickTransaction() {
		click(frstTransaction, "First Transaction");
	}

	public void clickFilters() {
		click(btnFilter, "Filter");
	}

	public int verifyTransactions() throws InterruptedException {
		Thread.sleep(800);
		return getElementList(lblNoMore, "").size();
	}

	public void verifyTransactionsText(String expText) {
		new CommonFunctions().verifyLabelText(lblNoMore, "No More Transactions text is ", expText);
	}

	public void clickClose() {
		click(btnCross, "Close button");
	}

	public void VerifySearchWithPasteOption(By ele) {
		TouchAction action = new TouchAction(DriverFactory.getDriver());
		MobileElement search = (MobileElement) DriverFactory.getDriver().findElement(ele);
		Duration duration = Duration.ofMillis(1000);
		action.longPress(
				LongPressOptions.longPressOptions().withElement(ElementOption.element(search)).withDuration(duration))
				.release().perform();
		action.tap(PointOption.point(120, 350)).perform();
	}

	public void clickFirstTransaction() throws InterruptedException {
		click(frstTransaction, "transaction");
	}

	public void getTransactionsCount() throws InterruptedException {
		Thread.sleep(1200);
		if (getElementList(btnTransactions, "Transactions").size() == 1) {
			ExtentTestManager.setPassMessageInReport("After Search with Reference ID its showing one transaction");
		} else {
			ExtentTestManager
					.setFailMessageInReport("After Search with Reference ID, its showing more than one transaction");
		}
	}

	public FiltersPopup filtersPopup() {
		return new FiltersPopup();
	}

}
