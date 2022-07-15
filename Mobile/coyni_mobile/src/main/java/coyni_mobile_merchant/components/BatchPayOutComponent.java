package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.PayoutTransactionsPage;
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
		scrollDownToElement(lblBatchPayOuts, "Batch PayOuts");
		new CommonFunctions().verifyLabelText(lblBatchPayOuts, "Batch PayOuts", expHeading);
	}
	public void clickBatchNow() {
		scrollDownToElement(btnBatchNow, "Batch Now");
		if (verifyElementDisplayed(btnBatchNow, "Click Batch Now")) {
			click(btnBatchNow, "Batch Now");
		} else {
			ExtentTestManager.setInfoMessageInReport("Batch Now is disabled");
		}
	}

	public void clickFullPayOutHistory() {
		scrollDownToElement(lnkViewFullPayOutHistory, "Full Pay Out History");
		click(lnkViewFullPayOutHistory, "Full PayOut History");

	}

	public void getNextPayOut() {
		scrollDownToElement(lblNextPayOut, "Next PayOut");
		ExtentTestManager.setInfoMessageInReport("Next PayOut " + getText(lblNextPayOut));
	}

	public void getLastPayOut() {
		ExtentTestManager.setInfoMessageInReport("Last PayOut " + getText(lblLastPayOut));
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PayoutTransactionsPage payoutTransactionsPage() {
		return new PayoutTransactionsPage();
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}
}
