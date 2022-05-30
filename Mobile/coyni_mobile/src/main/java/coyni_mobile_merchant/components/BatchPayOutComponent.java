package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.PayOutTransactionsPage;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BatchPayOutComponent extends MobileFunctions {

	private By lblBatchPayOuts = MobileBy.xpath("//*[@text='Batch Payouts']");

	private By lblNextPayOut = MobileBy.xpath("//*[contains(@resource-id,'nextPayoutAmountTV')]");

	private By lblLastPayOut = MobileBy.xpath("//*[contains(@resource-id,'lastPayoutAmountTV')]");

	private By lnkViewFullPayOutHistory = MobileBy.xpath("//*[contains(@resource-id,'tv_PayoutFullHistory')]");

	private By btnBatchNow = MobileBy.xpath("");

	public void verifyLabelBatchPayOuts(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBatchPayOuts, "Batch PayOuts", expHeading);
	}

	public void clickBatchNow() {
		scrollDownToElement(btnBatchNow, "Batch Now");
		click(btnBatchNow, "Batch Now");

	}

	public void clickFullPayOutHistory() {
		scrollDownToElement(btnBatchNow, "Batch Now");
		click(lnkViewFullPayOutHistory, "Full PayOut History");

	}

	public void getNextPayOut() {
		ExtentTestManager.setInfoMessageInReport("Next PayOut " + getText(lblNextPayOut));
	}

	public void getLastPayOut() {
		ExtentTestManager.setInfoMessageInReport("Last PayOut " + getText(lblLastPayOut));
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PayOutTransactionsPage payOutTransactionsPage() {
		return new PayOutTransactionsPage();
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}
}
