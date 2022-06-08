package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class MerchantTransactionsPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Merchant Transactions')]");

	private By lblMerchantTansactions = MobileBy.xpath("//*[@text='Merchant Transactions']");

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'payoutSearchET')]");

	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filtericonIV')]");

	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyLabelMerchanTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMerchantTansactions, expHeading, "Merchant Transactions");

	}

	public void clickMerchantTransctions() {
		click(lblMerchantTansactions, "Merchant Transactions");
	}

	public void verifySearchOption() {
		new CommonFunctions().elementView(searchOption, "Search Option");
	}

	public void clickFilterIcon() {
		click(filtersIcon, "Filter Icon");
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}

	public void clickClose() {
		click(btnCloseIcon, "Close Icon");
	}

}