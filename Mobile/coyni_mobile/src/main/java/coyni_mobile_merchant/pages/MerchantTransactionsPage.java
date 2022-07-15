package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class MerchantTransactionsPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Merchant Transactions')]");

	private By lblMerchantTansactions = MobileBy.xpath("//*[@text='Merchant Transactions']");

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'payoutSearchET')]");

	private By btnfiltersIcon = MobileBy.xpath("//*[contains(@resource-id,'filter')]");

	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");
	
	private By lblNoTransactions = MobileBy.xpath("//*[contains(@resource-id,'noTransactions')]");
	
	private By btnTransaction= MobileBy.xpath("(//*[contains(@resource-id,'message')])[1]");


	public int verifyTransactionsCount() {
		 return DriverFactory.getDriver().findElements(lblNoTransactions).size();
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyLabelMerchanTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMerchantTansactions, expHeading, "Merchant Transactions");

	}

	public void clickMerchantTransctions() {
		click(btnTransaction, "Transaction");
	}

	public void verifySearchOption() {
		new CommonFunctions().elementView(searchOption, "Search Option");
	}

	public void clickFilterIcon() {
		click(btnfiltersIcon, "Filter Icon");
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}

	public void clickClose() {
		click(btnCloseIcon, "Close Icon");
	}
	public MerchantTransactionDetailsPage merchantTransactionDetailsPage() {
		return new MerchantTransactionDetailsPage();
	}

}