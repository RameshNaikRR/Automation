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

	private By iconsearch = MobileBy.xpath("com.coyni.mapp:id/searchET");
	private By txtSearch = MobileBy.xpath("(//*[@name='search'])[2]/following-sibling::*[1]");
	private By btnFilter = MobileBy.id("com.coyni.mapp:id/ivFilterIcon");
	private By btnfiltericon = MobileBy.xpath("//*[@name='filter'] | (//*[@name='search']/following-sibling::*[2])[2]");
	private By lblNoMore = MobileBy
			.xpath("//*[contains(@name,'no more transactions')] | //*[contains(@name,'no transactions')]");
	private By lblNoRecent = MobileBy
			.xpath("//*[contains(@name,'no recent transactions')] | //*[contains(@name,'no transactions')]");
	private By copyIcon = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Reference ID']/following-sibling::*[1]");
	private By btnBack = MobileBy.xpath("//XCUIElementTypeButton[@name='Button']");
	private By btnPaste = MobileBy.xpath("//XCUIElementTypeMenuItem[@name='Paste']");
	private By lblTransactions = MobileBy
			.xpath("//*[@name='Transactions']/../following-sibling::*[1]/XCUIElementTypeTable/XCUIElementTypeCell");
	private By btnCross = MobileBy.AccessibilityId("close");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public void fillReferenceID(String referenceID) {
		enterText(txtSearch, "Reference ID", referenceID);
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

	public void ScrollTransactions() {
		if (getElementList(lblNoRecent, "").size() == 0) {
			scrollDownToElement(lblNoMore, "You have no more transactions");
		} else {
			ExtentTestManager.setInfoMessageInReport("You have no recent transactions");
		}
	}

	public By getElement() {
		return MobileBy
				.xpath("//*[@name='Transactions']/../following-sibling::*[1]/XCUIElementTypeTable/XCUIElementTypeCell");
	}

	public int getUITransactionCount() {
		if (getElementList(lblNoRecent, "No Recent Transcations").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Text is : " + getText(lblNoRecent));
		} else {
			if (getElementList(lblTransactions, "").size() > 0) {
				ExtentTestManager
						.setInfoMessageInReport("Transaction Count: " + getElementList(lblTransactions, "").size());
			}
			return getElementList(lblTransactions, "").size();
		}
		return 0;
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
		Thread.sleep(500);
		if (getElementList(lblNoRecent, "").size() == 0) {
			click(frstTransaction, "transaction");
		} else {
			new CommonFunctions().elementView(lblNoRecent, "No Recent Transactions");
			ExtentTestManager.setWarningMessageInReport("We have no recent transactions to proceed further");
		}
	}

	public FiltersPopup filtersPopup() {
		return new FiltersPopup();
	}

}
