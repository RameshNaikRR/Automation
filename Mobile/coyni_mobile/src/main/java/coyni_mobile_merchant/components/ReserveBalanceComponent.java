package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.PayOutTransactionsPage;
import coyni_mobile_merchant.pages.ReserveReleaseTransactionsPage;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ReserveBalanceComponent extends MobileFunctions {

	private By lblReserveBalance = MobileBy.xpath("//*[@text='Reserve Balance']");

	private By lblNextRelease = MobileBy.xpath("//*[contains(@resource-id,'nextReleaseAmountTV')]");

	private By lblLastRelease = MobileBy.xpath("//*[contains(@resource-id,'lastReleaseAmountTV')]");

	private By lnkViewFullReserveReleaseHistory = MobileBy.xpath("//*[contains(@resource-id,'tv_reserve_list')]");

	public void verifyLabelReserveBalance(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReserveBalance, "Reserve Balance", expHeading);
	}

	public void clickFullReserveReleaseHistory() {
		scrollDownToElement(lblReserveBalance, "Reserve Balance");
		click(lnkViewFullReserveReleaseHistory, "Full Reserve Release History");

	}

	public void getNextRelease() {
		ExtentTestManager.setInfoMessageInReport("Next PayOut " + getText(lblNextRelease));
	}

	public void getLastRelease() {
		ExtentTestManager.setInfoMessageInReport("Last PayOut " + getText(lblLastRelease));
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
