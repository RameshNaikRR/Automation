package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile_merchant.pages.ReserveReleaseTransactionsPage;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ReserveBalanceComponent extends MobileFunctions {

	private By lblReserveBalance = MobileBy.xpath("//*[contains(@resource-id,'tv_reserve_balance')]");

	private By lblNextRelease = MobileBy.xpath("//*[contains(@resource-id,'nextReleaseAmountTV')]");

	private By lblLastRelease = MobileBy.xpath("//*[contains(@resource-id,'lastReleaseAmountTV')]");

	private By txtReserveRule = MobileBy.xpath("//*[contains(@text,'Reserve')]/following-sibling::*[1]");

	private By lnkViewFullReserveReleaseHistory = MobileBy.xpath("//*[contains(@resource-id,'tv_reserve_list')]");

	public void verifyLabelReserveBalance(String expHeading) {
		scrollDownToElement(lblReserveBalance, "Reserve Release");
		ExtentTestManager.setInfoMessageInReport("Reserve Release " + getText(lblReserveBalance));
		
	}

	public void clickFullReserveReleaseHistory() {
		scrollDownToElement(lnkViewFullReserveReleaseHistory, "Full Reserve Release");
		click(lnkViewFullReserveReleaseHistory, "Full Reserve Release History");

	}

	public void getReserveRule() {
		ExtentTestManager.setInfoMessageInReport("Next Release " + getText(txtReserveRule));

	}

	public void getNextRelease() {
		scrollDownToElement(lblNextRelease, "Next Release");
		ExtentTestManager.setInfoMessageInReport("Next Release " + getText(lblNextRelease));
	}

	public void getLastRelease() {
		ExtentTestManager.setInfoMessageInReport("Last Release " + getText(lblLastRelease));
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public ReserveReleaseTransactionsPage reserveReleaseTransactionsPage() {
		return new ReserveReleaseTransactionsPage();
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}
}
