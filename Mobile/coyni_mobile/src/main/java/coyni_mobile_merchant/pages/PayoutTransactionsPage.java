package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PayoutTransactionsPage extends MobileFunctions {

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'payoutSearchET')]");

	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filterIconIV')]");

	private By closeIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");

	private By lblPayOutID = MobileBy.xpath("//*[@text='Payout ID']");

	private By lblPayOutTransactions = MobileBy.xpath("//*[@text='Payout Transactions']");

	private By btnPayoutTransaction = MobileBy.xpath("(//*[contains(@resource-id,'payoutSent')])[1]");

	private By lblPayoutID = MobileBy.xpath("//*[contains(@resource-id,'PayoutId')]");

	private By lblNoTransactions = MobileBy.xpath("//*[contains(@resource-id,'payoutNoMore')]");
	
	private By size = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]");

	public String getPayoutID() {
		String a = getText(lblPayoutID);
		return a;
	}

	public void fillSearchField(String expValue) {
		new CommonFunctions().elementView(searchOption, "Search Option");
		Dimension si = DriverFactory.getDriver().findElement(size).getSize();
		int xi = si.getWidth();
		int yi = si.getHeight();
		ExtentTestManager.setInfoMessageInReport("   win x : " + xi + "   win  y: " + yi);
		
		enterText(searchOption, expValue, "Search Option");
//		DriverFactory.getDriver().context("NATIVE_APP");
//		DriverFactory.getDriver().context("CHROMIUM");
	}

	public void fillSearchField() {
		Dimension size = DriverFactory.getDriver().findElement(searchOption).getSize();
		int x = size.getWidth();
		int y = size.getHeight();
		ExtentTestManager.setInfoMessageInReport("    x : " + x + "    y: " + y);
		TouchAction touch = new TouchAction(DriverFactory.getDriver());
		touch.longPress(PointOption.point(550, 530)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).release().perform();
	}

	public void verifyLabelPayOutTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutTransactions, "Pay Out Transactions", expHeading);
	}

	public void verifyFiltersIcon() {
		new CommonFunctions().elementView(filtersIcon, "Filters Icon");
	}

	public void clickPayoutTransaction() {
		click(btnPayoutTransaction, "Payout Transaction");
	}

	public void verifyScroll(String expText) {

		scrollDownToElement(lblNoTransactions, "no more Transactions");
		new CommonFunctions().verifyLabelText(lblNoTransactions, expText,
				"payout transaction list scroll down to until ");
	}

	public void scrollToNoMoreTransactions(String expText) {
		while (getElementList(lblNoTransactions, "no more Transactions").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (300))).release().perform();
		}
		new CommonFunctions().verifyLabelText(lblNoTransactions, "payout transaction list scroll down to until ",
				expText);
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}

	public PayoutTransactionDetailsPage payoutTransactionDetailsPage() {
		return new PayoutTransactionDetailsPage();
	}
}