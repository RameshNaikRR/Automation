package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ReserveReleaseTransactionsPage extends MobileFunctions {

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'payoutSearchET')]");

	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filterIconIV')]");

	private By closeIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");

	private By lblReserveReleases = MobileBy.xpath("//*[@text='Reserve Releases']");

	private By drpdwn = MobileBy.xpath("//*[contains(@resource-id,'tvChangeName')]");// *[contains(@text,'Rolling')]/following-sibling::*[1]

	private By btnRolling = MobileBy.xpath("//*[contains(@resource-id,'rollingTV')]");

	private By btnManual = MobileBy.xpath("//*[contains(@resource-id,'manualTV')]");

	private By btnReserve = MobileBy.xpath("//*[contains(@resource-id,'rl_base')]");

	public void clickReserve() {
		click(btnReserve, "Reserve");
	}

	public void verifySearchOption() {
		new CommonFunctions().elementView(searchOption, "Search Option");
	}

	public void clickDrpDwn() {
		click(drpdwn, "Drop Down");
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

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}

	public ReserveReleaseDetailsPage reserveReleaseDetailsPage() {
		return new ReserveReleaseDetailsPage();
	}
}