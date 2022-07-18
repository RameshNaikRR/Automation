package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApplicationCancelledPage extends BrowserFunctions {

	private By lblCancelledDescription = By.xpath("//h1[contains(text(),'Been Cancelled')]");

	private By lblStatus = By.xpath("//p[text()='Cancelled']");

	private By merchnatApplicationTracker = By.xpath("(//div[@class='flex mt-3 h-2.5 justify-around'])[1]");

	public void verifyCancelledDescription() {
		String text = getText(lblCancelledDescription, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void verifyStatus() {
		String text = getText(lblStatus, "Status");
		ExtentTestManager.setInfoMessageInReport("Status " + text);

	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("//p[@class='text-base italic font-bold leading-5 text-crd5']", eleName));
	}

	// added
	public void getMerchantTrackerApplication() {
		new CommonFunctions().verifyCursorAction(merchnatApplicationTracker, "Notification ");
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

}
