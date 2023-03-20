package coyni_mobile_merchant.pages;

import java.awt.AWTException;
import java.awt.Point;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.FieldValidationsComponent;
import coyni_mobile_merchant.popups.ErrorMessagePopup;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
//import io.appium.java_client.touch.LongPressOptions;
//import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BusinessRecentTokenTransactionsPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'TokenAccount')]");

	private By lblTotalFunds = MobileBy.xpath("//*[contains(@resource-id,'Balance')]");
	private By lblTransHeading = MobileBy.xpath("//*[contains(@text,'Transactions')]");
	private By lblTotalFundsHeading = MobileBy.xpath("//*[contains(@resource-id,'BalHead')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Recent Token ')]");
	private By lblTransactionStatus = MobileBy.xpath("//*[contains(@resource-id,'misc_fee')]");

	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'net_amount')]");

	private By lblRecentTransactionType = MobileBy.xpath("(//*[contains(@resource-id,'latestmessage')])[1]");

	private By btnViewMore = MobileBy.xpath("//*[contains(@text,'View More')]");

	private By lblTokensHeading = MobileBy.xpath("//*[contains(@text,'Transaction')]");

	private By txtSearch = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");

	private By btnFiltersIcon = MobileBy.xpath("//*[contains(@resource-id,'filter')]");

	private By lnkTransaction = MobileBy.xpath("(// *[contains(@resource-id,'message')])[1]");

	private By lblNoTransactions = MobileBy.xpath("//*[contains(@resource-id,'noTransactions')]");

	private By txtFromAmount = MobileBy.xpath("//*[contains(@resource-id,'AmountStart')]");

	private By txtToAmount = MobileBy.xpath("//*[contains(@resource-id,'AmountEnd')]");

	private By recentTransType = MobileBy.xpath("(//*[contains(@resource-id,'message')])[1]|(//*[contains(@resource-id,'latestmessage')])[1]");

	private By recentTranStatus = MobileBy.xpath("(//*[contains(@resource-id,'statusTV')])[1]");

	private By recentTransAmount = MobileBy.xpath("(//*[contains(@resource-id,'amountTV')])[1]");

	private By recentTransBalance = MobileBy.xpath("(//*[contains(@resource-id,'balanceTV')])[1]");

	private By lblNoMoreTransactions = MobileBy.xpath("//*[contains(@resource-id,'noMoreTransactions')]");

	private By lnkSearchTransaction = MobileBy.xpath("(//*[contains(@text,'Merchant Payout')])[1]");

	public void clickSearchTransaction() {
		scrollDownToElement(lnkSearchTransaction, "Transaction");
		click(lnkSearchTransaction, "Transaction");
	}

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Business Recent Token Transactions Heading", expHeading);
	}

	public void verifyPageHeading() {
		new CommonFunctions().elementView(lblTransHeading, "Business Recent Token Transactions Heading");
	}
	
	public void verifyTokenAccount(){
		new CommonFunctions().elementView(lblHeading, "Business Recent Token Transactions Heading");
//		new CommonFunctions().elementView(lblTotalFunds, "Total Availble Funds");
	}
	
	public void verifyTokenPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokensHeading, "Token Transactions Heading", expHeading);

	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", expDescription);

	}

	public void verifyTotalAvailableFunds(String expTotal) {
		new CommonFunctions().verifyLabelText(lblTotalFundsHeading, "Total Availble Funds Heading is :", expTotal);

	}

	public void getTotalAvailableFunds() {
//		scrollDownToElement(lblTotalAmount, "Total Availble Funds : ");
		ExtentTestManager.setInfoMessageInReport("Total Availble Funds is : " + getText(lblTotalFunds));

	}

	public void getTransactionStatus() {
		// scrollDownToElement(lblSaleOrderDetails, "Sale Order");
		ExtentTestManager.setInfoMessageInReport("Recent Transaction Status is " + getText(lblTransactionStatus));
	}

	public void getAmount() {
//		scrollDownToElement(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Recent Transaction Amount is " + getText(lblAmount));
	}

	public void getRecentTransAmount() {
//		scrollDownToElement(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Recent Transaction Amount is " + getText(recentTransAmount));
	}

	public void clickTransaction() {
		click(lnkTransaction, "Transaction");
	}

	public void clickViewMore() {
//		scrollDownToElement(btnViewMore, "View More");
		click(btnViewMore, "View More");
	}

	public int verifyViewMore() throws InterruptedException {
		return DriverFactory.getDriver().findElements(btnViewMore).size();
	}

	public void scrollToNoMoreTransactions() {
		scrollDownToElement(lblNoMoreTransactions, "No More Transactions");
//		ExtentTestManager.setInfoMessageInReport("Transaction list scrolled down to no more transactions");
//		return DriverFactory.getDriver().findElements(lblNoMoreTransactions).size();
	}

	public void verifyNoMoreTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblNoMoreTransactions, "Scrolled down to until", expHeading);
	}

	public void ScrollToViewMore() throws InterruptedException {
		Thread.sleep(1500);
		while (getElementList(btnViewMore, "View More").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (300))).release().perform();
		}
	}

	public void fillSearch() throws AWTException, InterruptedException {
		new CommonFunctions().VerifySearchWithPasteOption(txtSearch);
//		TouchAction action = new TouchAction(DriverFactory.getDriver());
//		WebElement element = DriverFactory.getDriver().findElement(txtSearch);
//		TouchAction touchAction = new TouchAction(DriverFactory.getDriver());
//		MobileElement search = (MobileElement) DriverFactory.getDriver().findElement(txtSearch);
//		Duration duration = Duration.ofSeconds(2);
//		touchAction.longPress(LongPressOptions.longPressOptions()
//		    .withElement(ElementOption.element(search))
//		    .withDuration(duration))
//		    .release()
//		    .perform();
//		touchAction.tap(PointOption.point(140,330)).perform();
//		touchAction.tap(TapOptions.tapOptions()).perform();
		
//		touchAction.tap(TapOptions.tapOptions(txtSearch));
		
//		touchAction.tap(
//		touchAction.press(PointOption.point(140,340));
//		MobileElement lement = (MobileElement) DriverFactory.getDriver().findElement(txtSearch);
//
//		// get the location of the element
//
//		org.openqa.selenium.Point location = lement.getLocation();
//		int x = location.getX();
//		int y = location.getY();
//		System.out.println("Element location: " + x + ", " + y);
//		DriverFactory.getDriver().
	
	
//		Thread.sleep(2000);
//		DriverFactory.getDriver().
//		action.longPress((LongPressOptions) element).release().perform();
//		click(txtSearch,"Search");
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		enterText(txtSearch, getCopiedData(), "Search");
	}

	public void clickFilterIcon() {
		click(btnFiltersIcon, "Filter Icon");
	}

	public int verifyTransactionsCount() throws InterruptedException {
		Thread.sleep(2000);
		return DriverFactory.getDriver().findElements(lblNoTransactions).size();
	}

	public void fillFromAmount(String fromAmount) {
		scrollDownToElement(txtFromAmount, "From Amount");
		enterText(txtFromAmount, fromAmount, "From Amount");
	}

	public void fillToAmount(String toAmount) {
		scrollDownToElement(txtToAmount, "To Amount");
		enterText(txtToAmount, toAmount, "To Amount");
	}

	public void getRecentTransType() {
		// scrollDownToElement(lblSaleOrderDetails, "Sale Order");
		ExtentTestManager.setInfoMessageInReport("Recent Transaction Type is " + getText(recentTransType));
	}

	public void getRecentTranStatus() {
//		scrollDownToElement(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Recent Transaction Method is " + getText(recentTranStatus));
	}

	public void getRecentTransactionType() {
//		scrollDownToElement(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Recent Transaction Type is " + getText(lblRecentTransactionType));
	}

	public void getRecentTransBalance() {
//		scrollDownToElement(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Recent Transaction Balance is " + getText(recentTransBalance));
	}

	public void clickRecentTransaction() {
		click(recentTransType, "Transaction");
	}

//	public void getNetAmount() {
//		scrollDownToElement(lblNetAmount, "Net Amount");
//		ExtentTestManager.setInfoMessageInReport("Net Amount " + getText(lblNetAmount));
//	}
//
//	public void getProcessingFees() {
//		scrollDownToElement(lblProcessingFees, "Processing Fees");
//		ExtentTestManager.setInfoMessageInReport("Processing Fees " + getText(lblProcessingFees));
//	}
//
//	public void getHighTicket() {
//		ExtentTestManager.setInfoMessageInReport("High Ticket " + getText(lblHighTicket));
//	}
//
//	public void getAverageTicket() {
//		ExtentTestManager.setInfoMessageInReport("Average Ticket " + getText(lblAverageTicket));
//	}

//	private void click(WebElement element, String type) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void scrollDownToElement(MobileElement element, String string) {
//		// TODO Auto-generated method stub
//
//	}

	public BusinessTransactionDetailsPage businessTransactionDetailsPage() {
		return new BusinessTransactionDetailsPage();
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}

	public ErrorMessagePopup errorMessagePopup() {
		return new ErrorMessagePopup();
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
	
}
