package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class TransactionSucessFailurePendingComponent extends MobileFunctions {
	private By lblPageHeading = MobileBy.xpath("//*[contains(@resource-id,'Heading')]");
	private By lblPageDescription = MobileBy.xpath("//*[contains(@resource-id,'Message')]");
	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'Amount')]");
	private By lblCurrency = MobileBy.xpath("//*[contains(@text,'CYN')]");
	private By lblReferenceID = MobileBy.xpath("//*[contains(@resource-id,'ReferenceID')]");
	private By lblTransactionTimeDescription = MobileBy.xpath("//*[contains(@resource-id,'Description')]");
//	private By lnkLearnMore = MobileBy.xpath("//*[contains(@resource-id,'tvTotal')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'Done')]");

	public void getPageHeading() {
		ExtentTestManager.setInfoMessageInReport("Transaction Status : " + getText(lblPageHeading));
	}

	public void getPageDescription() {
		ExtentTestManager.setInfoMessageInReport("Page Description : " + getText(lblPageDescription));
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount : " + getText(lblAmount));
	}

	public void getCurrency() {
		ExtentTestManager.setInfoMessageInReport("Currency in  : " + getText(lblCurrency));
	}

	public void getReferenceID() {
		ExtentTestManager.setInfoMessageInReport("Reference ID : " + getText(lblReferenceID));
	}

	public void getTransactionTimeDescription() {
		ExtentTestManager.setInfoMessageInReport("lblTransactionTimeDescription  : " + getText(lblTransactionTimeDescription));
	}

//	public void viewLearnMore() {
//		new CommonFunctions().elementView(lnkLearnMore, "Learn More ");
////		click(lnkLearnMore, "Link More");
//	}

	public void clickDone() {
		click(btnDone, "Done");
	}

}
