package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
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
	private By lblAmount = MobileBy.xpath("(//*[contains(@resource-id,'com.coyni.mapp:id/payoutMoneyTV')])[1]");
	private By lblNoTransactions = MobileBy
			.xpath("//*[@text='You have no transactions']|//*[@text='You have no more transactions']");
	private By lblNoMoreTransactions = MobileBy.xpath("//*[@text='You have no more transactions']");
	private By size = MobileBy.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

	public String getPayoutID() {
		String a = getText(lblPayoutID);
		return a;
	}

	public void fillSearchField(String expValue) {
		new CommonFunctions().elementView(searchOption, "Search Option");
		enterText(searchOption, expValue, "Search Option");

	}

	public String noTransactions() {
		String a = getText(lblNoTransactions);
		return a;

	}

	public void verifyLabelPayOutTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutTransactions, "Pay Out Transactions", expHeading);
	}

	public void verifyFiltersIcon() {
		new CommonFunctions().elementView(btnPayoutTransaction, "Pay Out Transactions");
		new CommonFunctions().elementView(filtersIcon, "Filters Icon");
	}

	public int verifyTransactionsCount() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblNoTransactions));
		return DriverFactory.getDriver().findElements(lblNoTransactions).size();
	}

	public double verifyTransactionAmount() {
		String quantityText = getText(lblAmount);
		double value = Double.parseDouble(quantityText);
		return value;
//		Integer qty = Integer.valueOf(quantityText);
	}
	
	public void clickPayoutTransaction() {
//		if(verifyTransactionAmount()>0.00) {
			click(btnPayoutTransaction, "Payout Transaction");
//		}else {
//			ExtentTestManager.setInfoMessageInReport(getPayoutID());
//		}
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

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PayoutTransactionDetailsPage payoutTransactionDetailsPage() {
		return new PayoutTransactionDetailsPage();
	}
}