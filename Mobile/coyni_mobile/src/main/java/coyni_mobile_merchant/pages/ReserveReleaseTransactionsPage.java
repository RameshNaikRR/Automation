package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ReserveReleaseTransactionsPage extends MobileFunctions {

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'payoutSearchET')]");

	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filterIconIV')]");

	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'close')]");

	private By lblReserveReleases = MobileBy.xpath("//*[@text='Reserve Releases']");

	private By drpdwn = MobileBy.xpath("//*[contains(@resource-id,'tvChangeName')]");// *[contains(@text,'Rolling')]/following-sibling::*[1]

	private By btnRolling = MobileBy.xpath("//*[contains(@resource-id,'rollingTV')]");

	private By btnManual = MobileBy.xpath("//*[contains(@resource-id,'manualTV')]");

	private By btnReserve = MobileBy.xpath("(//*[contains(@resource-id,'rl_base')])[1]");

	private By lblTranHeading = MobileBy.xpath("(//*[contains(@resource-id,'name')])[1]");

	private By lblStatus = MobileBy.xpath("(//*[contains(@resource-id,'status')])[1]");

	private By lblAmount = MobileBy.xpath("(//*[contains(@resource-id,'ammont')])[1]");

	private By lblDate = MobileBy.xpath("(//*[contains(@resource-id,'dateTime')])[1]");

	private By lblNoTransactions = MobileBy.xpath("//*[contains(@resource-id,'noTransactions')]");

	public void clickReserve() {
		click(btnReserve, "Reserve");
	}

	public void verifySearchOption() {
		new CommonFunctions().elementView(searchOption, "Search Option");
	}
	
	public int verifyTransactionsCount() {
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

	public void getFailedorOpenTransactionDetails() {
		getTranHeading();
		getStatus();
		getAmount();
		getDate();
	}

	public ReserveReleaseDetailsPage reserveReleaseDetailsPage() {
		return new ReserveReleaseDetailsPage();
	}
}