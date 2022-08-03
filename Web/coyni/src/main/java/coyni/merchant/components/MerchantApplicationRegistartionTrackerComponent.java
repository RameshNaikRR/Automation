package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantApplicationRegistartionTrackerComponent extends BrowserFunctions {
	private By btnMerchnatApplicationTracker = By
			.xpath("(//span[contains(.,'Merchant')][contains(., 'Application')])[1]");
	private By merchnatApplicationTracker = By.xpath("(//div[@class='flex mt-3 h-2.5 justify-around'])[1]");
	private By merchnatApplicationTrackerSteps = By.xpath("(//div[@class='flex mt-3 h-2.5 justify-around'])[1]/button");
	private By merchnatApplicationTrackerIncompleteToolpTip = By.xpath("merchnatApplicationTrackerToolTip");
	private By merchnatApplicationTrackerToolTip = By.xpath("(//div[text()='Merchant Application step 4 of 6'])[2]");

	public void clickLblMerchantApplicationTracker() {
		click(btnMerchnatApplicationTracker, "Label Merchant Application Tracker");
	}

	public void verifyLblMerchnatApplicationTracker() {
		new CommonFunctions().elementView(btnMerchnatApplicationTracker, "Label Merchant Application Tracker");
	}

	public void getMerchantApplicationTracker() {
		new CommonFunctions().verifyCursorAction(merchnatApplicationTracker, "Merchant Application tracker");
		new CommonFunctions().elementView(merchnatApplicationTracker, "Merchant Application tracker");

//		String toolTip = getText(merchnatApplicationTrackerToolTip, "");
//		ExtentTestManager.setInfoMessageInReport("toolTip for Merchant Application tracker: " + toolTip);
	}

	public void verifyMerchnatTracker() {
		new CommonFunctions().elementView(merchnatApplicationTracker, "Merchant Application tracker");
//		String tracker = getText(merchnatApplicationTracker, "");
//		ExtentTestManager.setInfoMessageInReport("Tracker status is displayed" + tracker);
	}
}
