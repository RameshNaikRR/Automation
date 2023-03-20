package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.FieldValidationsComponent;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class ReserveReleaseTransactionsPage extends MobileFunctions {

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");

	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filterIconIV')]");

	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'close')]");

	private By lblReserveReleases = MobileBy.xpath("//*[@text='Reserve Releases']");

	private By drpdwn = MobileBy.xpath("//*[contains(@resource-id,'tvChangeName')]");// *[contains(@text,'Rolling')]/following-sibling::*[1]

	private By btnRolling = MobileBy.xpath("//*[contains(@resource-id,'rollingTV')]");

	private By btnManual = MobileBy.xpath("//*[contains(@resource-id,'manualTV')]");

	private By btnReserve = MobileBy.xpath("(//*[contains(@resource-id,'rl_base')])[3]");

	private By lblReleaseType = MobileBy.xpath(" //*[contains(@resource-id,'ChangeName')]");

	private By lblTranHeading = MobileBy.xpath("(//*[contains(@resource-id,'name')])[1]");

	private By lblStatus = MobileBy.xpath("(//*[contains(@resource-id,'status')])[1]");

	private By lblAmount = MobileBy.xpath("(//*[contains(@resource-id,'ammont')])[1]");

	private By lblDate = MobileBy.xpath("(//*[contains(@resource-id,'dateTime')])[1]");

	private By lblNoTransactions = MobileBy.xpath("//*[contains(@text,'You have no')]");

	private By lnkTrans = MobileBy.xpath("(//*[contains(@text,'On Hold')])[1]|(//*[contains(@text,'Released')])[1]");

	private By txtReserveID = MobileBy
			.xpath("//*[contains(@resource-id,'tvReserveID')]|//*[contains(@resource-id,'reserveIDLL')]");

	WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), 5);
	
	public void clickReserve() {
		click(btnReserve, "Reserve");
	}

	public void clickTransaction() {
		scrollDownToElement(lnkTrans, "Transaction");
		click(lnkTrans, "Transaction");
	}

	public void fillSearchWithCopiedData() {
		new CommonFunctions().VerifySearchWithPasteOption(searchOption);
//		TouchAction touch = new TouchAction(DriverFactory.getDriver());
//		wait.until(ExpectedConditions.presenceOfElementLocated(searchOption));
//		MobileElement search = (MobileElement) DriverFactory.getDriver().findElement(searchOption);
//		Duration dutarion = Duration.ofMillis(1500);
//		touch.longPress(
//				LongPressOptions.longPressOptions().withElement(ElementOption.element(search)).withDuration(dutarion))
//				.release().perform();
//		touch.tap(PointOption.point(120, 350)).perform();
//		enterText(searchOption, expValue,"Search Option");
//		String a=getReserveID();
//		new CommonFunctions().elementView(searchOption, "Search Option");
//		DriverFactory.getDriver().findElement(searchOption).sendKeys(a);	
	}

	public void verifyReleaseType(String expReleaseType) {
		new CommonFunctions().verifyLabelText(lblReleaseType, "Reserve Release Type", expReleaseType);
	}

	public int verifyTransactionsCount() throws InterruptedException {
		Thread.sleep(1500);
		return DriverFactory.getDriver().findElements(lblNoTransactions).size();
	}

	public void clickDrpDwn() {
		click(drpdwn, "Drop Down");
	}

	public void ClickClose() {
		click(btnCloseIcon, "Close Icon");
	}

	public void clickRolling() {
		click(btnRolling, "Rolling");
	}

	public void clickManual() {
		click(btnManual, "Manual");
	}

	public void verifyLabelReserveReleases(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReserveReleases, "Reserve Release", expHeading);
	}

	public void verifyLabelReserveReleases() {
		new CommonFunctions().elementView(lblReserveReleases, "Reserve Release");
//		new CommonFunctions().elementView(filtersIcon, "Filters Icon");
	}

	public void verifyFiltersIcon() {
		new CommonFunctions().elementView(filtersIcon, "Filters Icon");
	}

	public void getTranHeading() {
		ExtentTestManager.setInfoMessageInReport("Transaction Heading is " + getText(lblTranHeading));
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status is " + getText(lblStatus));
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount is " + getText(lblAmount));
	}

	public void getDate() {
		ExtentTestManager.setInfoMessageInReport("Date is " + getText(lblDate));
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}

	public void youHaveNoTransactions() {
		if (DriverFactory.getDriver().findElements(lblNoTransactions).size() == 0) {

		} else {
			ExtentTestManager.setFailMessageInReport("You Have No Transactions");
		}
	}

	public void verifyNoMoreTransaction(String expValue) {
		scrollDownToElement(lblNoTransactions, "no more transactions");
		new CommonFunctions().verifyLabelText(lblNoTransactions, "Reserve Releases transaction list scroll down to",
				expValue);
	}

	public void getFailedorOpenTransactionDetails() {
		getTranHeading();
		getStatus();
		getAmount();
		getDate();
	}

	public ReserveReleaseDetailsPage reserveReleaseDetailsPage() {
		return new ReserveReleaseDetailsPage();
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}