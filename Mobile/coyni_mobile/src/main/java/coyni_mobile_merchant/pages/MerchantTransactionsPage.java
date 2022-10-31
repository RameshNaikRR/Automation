package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.FilterPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class MerchantTransactionsPage extends MobileFunctions {

	private By lblMerchantTansactions = MobileBy.xpath("//*[@text='Merchant Transactions']");

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'payoutSearchET')]");

	private By btnfiltersIcon = MobileBy.xpath("//*[contains(@resource-id,'filter')]");

	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");

	private By lblNoTransactions = MobileBy.xpath("//*[contains(@resource-id,'noTransactions')]");

	private By btnTransaction = MobileBy.xpath("(//*[contains(@resource-id,'message')])[1]");
	
	private By btnRefernceCopy = MobileBy.xpath("");
	
	

	public int verifyTransactionsCount() throws InterruptedException {
		Thread.sleep(3000);
		return DriverFactory.getDriver().findElements(lblNoTransactions).size();
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