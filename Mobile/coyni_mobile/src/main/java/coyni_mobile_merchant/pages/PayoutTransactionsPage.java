package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;
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
	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'com.coyni.mapp:id/payoutMoneyTV')]");
	private By lblNoTransactions = MobileBy
			.xpath("//*[@text='You have no transactions']|//*[@text='You have no more transactions']");
	private By lblNoMoreTransactions = MobileBy.xpath("//*[@text='You have no more transactions']");
	private By size = MobileBy.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]");
	private By lblPayoutDetailsHeading = MobileBy.xpath("//*[contains(@text,'Payout Details')]");
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

	public void clickValidTransaction() throws InterruptedException {
//		Thread.sleep(1000);
		int noOfTransactionsInPage = getElementList(lblAmount, "No of Transactions").size();
		for (int i = 1; noOfTransactionsInPage - 1 >= i; i++) {
			Thread.sleep(1000);
			By moreThanZero = MobileBy
					.xpath("(//*[contains(@resource-id,'com.coyni.mapp:id/payoutMoneyTV')])[" + i + "]");
			String TransactionAmount = getText(moreThanZero);
			String Amount = TransactionAmount.replace("-", "");
			double amount = Double.parseDouble(Amount);
			if (amount > 0.00) {
				click(moreThanZero, "Greater Than 0.00 Transaction");
			} else if (noOfTransactionsInPage - 1 == i) {
				Thread.sleep(1000);
				for (int t = 1; t <= 6; t++) {
					if (getElementList(lblNoTransactions, "Transactions").size() >= 1) {
						for (int c = 1; c <= 1; c++) {
							Thread.sleep(1000);
							if (getElementList(lblPayoutDetailsHeading, "Transactions Details Heading").size() == 1) {
								break;
							}
							TouchAction touch = new TouchAction(DriverFactory.getDriver());
							touch.press(PointOption.point(540, 1395))
									.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
									.moveTo(PointOption.point(540, (int) (260))).release().perform();
						}
						int noOfTransactionsIn = getElementList(lblAmount, "No of Transactions").size();
						for (int j = 1; noOfTransactionsIn >= j; j++) {
							By moreThanZeroTrans = MobileBy.xpath(
									"(//*[contains(@resource-id,'com.coyni.mapp:id/payoutMoneyTV')])[" + j + "]");
							String TransAmount = getText(moreThanZeroTrans);
							String mount = TransactionAmount.replace("-", "");
							double transAmount = Double.parseDouble(mount);
							if (transAmount > 0.00) {
								click(moreThanZeroTrans, "Greater Than 0.00 Transaction");
								break;
							} else {
								int k = j + i;
								ExtentTestManager.setWarningMessageInReport(
										"Transaction " + k + " has not been greater than 0.00");
							}
						}
					}
					ExtentTestManager
							.setFailMessageInReport("We have no transactions is greater than 0.00, to verify details");
				}

			} else {
				ExtentTestManager.setWarningMessageInReport("Transaction " + i + " has not been greater than 0.00");
			}
			if (getElementList(lblPayoutDetailsHeading, "Transactions Details Heading").size() == 1) {
				break;
			}
		}

	}

	public void verifyLabelPayOutTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutTransactions, "Pay Out Transactions", expHeading);
	}

	public void verifyFiltersIcon() {
		new CommonFunctions().elementView(btnPayoutTransaction, "Pay Out Transactions");
		new CommonFunctions().elementView(filtersIcon, "Filters Icon");
	}

	public int verifyTransactionsCount() throws InterruptedException {
		Thread.sleep(1500);
		return DriverFactory.getDriver().findElements(lblNoTransactions).size();
	}

	public double verifyTransactionAmount() {
		String amount = getText(lblAmount);
		String amountText = amount.replace("-", "");
		double value = Double.parseDouble(amountText);
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