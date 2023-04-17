package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class TransactionSucessFailurePendingComponent extends MobileFunctions {
	private By lblPageHeading = MobileBy
			.xpath("//*[contains(@resource-id,'tvBHeading')]|//*[contains(@resource-id,'tvHeading')]|//*[contains(@text,'Successful')]");
	private By lblPageDescription = MobileBy
			.xpath("//*[contains(@resource-id,'Message')]|//*[contains(@text,'A new refund')]");
	private By lblRefundDescription = MobileBy.xpath("//*[contains(@text,'A new refund')]");
	private By lblAmount = MobileBy
			.xpath("//*[contains(@resource-id,'lyAmount')]|//*[contains(@resource-id,'Amount')]");
	private By lblCurrency = MobileBy.xpath("//*[contains(@text,'CYN')]");
	private By lblReferenceID = MobileBy
			.xpath("//*[contains(@resource-id,'ReferenceID')]|//*[contains(@resource-id,'refIDTV')]");
	private By lblTransactionTimeDescription = MobileBy.xpath("//*[contains(@resource-id,'Description')]");
//	private By lnkLearnMore = MobileBy.xpath("//*[contains(@resource-id,'tvTotal')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'Done')]|//*[contains(@text,'Done')]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);

	public void getPageHeading() {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblPageHeading));
		new CommonFunctions().elementView(lblPageHeading, "Page Heading");
		ExtentTestManager.setPassMessageInReport("Transaction Status : " + getText(lblPageHeading));
	}

	public void getPageDescription() {
		ExtentTestManager.setInfoMessageInReport("Page Description : " + getText(lblPageDescription));
	}

	public void getRefundDescription() {
		ExtentTestManager.setInfoMessageInReport("Refund Description : " + getText(lblRefundDescription));
	}

	public void getAmount() {
		new CommonFunctions().elementView(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("Amount : " + getText(lblAmount) + "CYN");
	}

	public void getCurrency() {
		ExtentTestManager.setInfoMessageInReport("Currency in  : " + getText(lblCurrency));
	}

	public void getReferenceID() {
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		click(lblReferenceID, "Reference ID");
		ExtentTestManager.setInfoMessageInReport("Reference ID : " + getText(lblReferenceID));
	}

	public void getTransactionTimeDescription() {
		ExtentTestManager
				.setInfoMessageInReport("lblTransactionTimeDescription  : " + getText(lblTransactionTimeDescription));
	}

	public void getTokenTransactionStatusDetails() {
		getPageHeading();
		getAmount();
//		getCurrency();
		getPageDescription();
		getReferenceID();
		clickDone();
	}

	public void getRefundTokenTransactionStatusDetails() {
		getPageHeading();
		getAmount();
		getReferenceID();
		getRefundDescription();
		clickDone();
	}

	public void verifyScanPaymentDetails() {
		getPageHeading();
		getAmount();
		getReferenceID();
		clickDone();
	}

//	public void viewLearnMore() {
//		new CommonFunctions().elementView(lnkLearnMore, "Learn More ");
////		click(lnkLearnMore, "Link More");
//	}

	public void clickDone() {
		click(btnDone, "Done");
	}

}
