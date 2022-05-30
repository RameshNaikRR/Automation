package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayOutTransactionsPage extends MobileFunctions {

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'payoutSearchET')]");

	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filterIconIV')]");

	private By closeIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");

	private By lblPayOutID = MobileBy.xpath("//*[@text='Payout ID']");

	private By lblPayOutTransactions = MobileBy.xpath("//*[@text='Payout Transactions']");

	public void verifySearchOption() {
		new CommonFunctions().elementView(searchOption, "Search Option");
	}

	public void verifyLabelPayOutTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutTransactions, "Pay Out Transactions", expHeading);
	}

	public void verifyFiltersIcon() {
		new CommonFunctions().elementView(filtersIcon, "Filters Icon");
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}
}