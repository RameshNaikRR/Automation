package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BusinessRecentTokenTransactionsPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'TokenAccount')]");

	private By lblTotalFunds = MobileBy.xpath("//*[contains(@resource-id,'Balance')]");
	private By lblTotalFundsHeading = MobileBy.xpath("//*[contains(@resource-id,'BalHead')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Recent Token ')]");
	private By lblTransactionStatus = MobileBy.xpath("//*[contains(@resource-id,'misc_fee')]");

	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'net_amount')]");

	private By lblRecentTransactionType = MobileBy.xpath("(//*[contains(@resource-id,'latestmessage')])[1]");

	private By btnViewMore = MobileBy.xpath("//*[contains(@text,'View More')]");

	private By lblTokensHeading = MobileBy.xpath("//*[contains(@text,'Transaction')]");

	private By btnSearch = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");

	private By btnFiltersIcon = MobileBy.xpath("//*[contains(@resource-id,'filter')]");

	private By lnkTransaction = MobileBy.xpath("(// *[contains(@resource-id,'message')])[1]");

	private By lblNoTransactions = MobileBy.xpath("//*[contains(@resource-id,'noTransactions')]");

	private By txtFromAmount = MobileBy.xpath("//*[contains(@resource-id,'AmountStart')]");

	private By txtToAmount = MobileBy.xpath("//*[contains(@resource-id,'AmountEnd')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Business Recent Token Transactions Heading", expHeading);

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

	public void getRecentTransactionType() {
//		scrollDownToElement(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Recent Transaction Type is " + getText(lblRecentTransactionType));
	}

	public void clickTransaction() {
		click(lnkTransaction, "Transaction");
	}

	public void clickViewMore() {
//		scrollDownToElement(btnViewMore, "View More");
		click(btnViewMore, "View More");
	}

	public int verifyViewMore() {
//		scrollDownToElement(btnViewMore, "View More");
		return DriverFactory.getDriver().findElements(btnViewMore).size();
	}

	public void ScrollToViewMore() {
		while (getElementList(btnViewMore, "View More").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (300))).release().perform();
		}
	}

	public void clickSearch() {
		scrollDownToElement(btnSearch, "Search");
		click(btnSearch, "Search");
	}

	public void clickFilterIcon() {
		click(btnFiltersIcon, "Filter Icon");
	}

	public int verifyTransactionsCount() {
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

}
