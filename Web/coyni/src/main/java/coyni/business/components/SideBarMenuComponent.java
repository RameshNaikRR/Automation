package coyni.business.components;

import org.openqa.selenium.By;

import coyni.admin.MerchantServicespopups.ExportSelectedTransactionsPopup;
import coyni.business.pages.BusinessSettingsPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class SideBarMenuComponent extends BrowserFunctions {
	CommonFunctions commonFunctions = new CommonFunctions();
	private By handMark = By.cssSelector(".flex.flex-row.items-center.justify-between.gap-1.menu_item_small");
	private By businessApplicationArrow = By.xpath("");
	private By businessApplicationTracker = By.xpath("");
	private By btnContinueApplication = By.xpath("");
	private By twoStepAuthy = By.xpath("");

	public By getSideBarItems(String elementName) {
		return By.xpath(String.format(
				"(//span[(contains(@class,'menu' ) or contains(@class,'label') or contains(@class,'Label'))and text()='%s'])[1]",
				elementName));
	}

	public void verifyBusinessApplicationTrackerView() {
		new CommonFunctions().verifyCursorAction(businessApplicationTracker, "Business Application Tracker");
		String str = getElement(businessApplicationTracker, "").getCssValue("color");
		ExtentTestManager.setPassMessageInReport(str);
		new CommonFunctions().elementView(businessApplicationTracker, "Business Application Tracker");
	}

	public void verifyCursorAction() {
		new CommonFunctions().verifyCursorAction(handMark, "Coyni  Portal");
	}

	public void clickTwoStep() {
		click(twoStepAuthy, "Two step Authentication");
	}

	public void clickBusinessSettings() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Business Settings"), "Business Settings");
		if (getElement(getSideBarItems("Business Settings"), "Business Settings").isEnabled()) {
			click(getSideBarItems("Business Settings"), "Business Settings");
		} else {
			ExtentTestManager.setPassMessageInReport("Business Settings button is in disabled mode");
		}
	}

	public void clickExports() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Exports"), "Exports");
		click(getSideBarItems("Exports"), "Exports");
		Thread.sleep(4000);
	}

	public void clickWallets() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Wallets"), "Wallets");
		click(getSideBarItems("Wallets"), "Wallets");
		Thread.sleep(4000);
	}

	public void clickPayments() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Payments"), "Payments");
		click(getSideBarItems("Payments"), "Payments");
		Thread.sleep(4000);
	}

	public void clickGetHelp() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("GetHelp"), "GetHelp");
		click(getSideBarItems("GetHelp"), "GetHelp");
		Thread.sleep(4000);
	}
	public BusinessSettingsPage businessSettingsPage() {
		return new BusinessSettingsPage();
	}

	public ExportSelectedTransactionsPopup exportSelectedTransactionsPopup() {
		return new ExportSelectedTransactionsPopup();
	}

}
