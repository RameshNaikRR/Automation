package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SideBarMenuComponent extends BrowserFunctions {

	private By drpdwnHello = By.xpath("//div[contains(@class,'DashboardMenu_username')]");

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	private By getMerchantActivity(String Activity) {
		return By.xpath(String.format("//div[.='Reserve History']", Activity));
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public void clickUserdrpdwn() {
		click(drpdwnHello, "User drop down");
	}

	public void clickMerchantActivity() {
		click(getDashBoardItems("Merchant Activity"), "Merchant Activity");
	}

	public void clickTokenAccount() {
		click(getDashBoardItems("Token Account"), "Token Account");
	}

	public void clickExportFiles() {
		click(getDashBoardItems("Export Files"), "Export Files");
	}

	public void clickMerchantSettings() {
		click(getDashBoardItems("Merchant Settingss"), "Merchant Settingss");
	}

	public void clickGetHelp() {
		click(getDashBoardItems("Get Help"), "Get Help");
	}

	public void clickDashboard() {
		click(getMerchantActivity("Dashboard"), "Dashboard");
	}

	public void clickTransactions() {
		click(getMerchantActivity("Transactions"), "Transactions");
	}

	public void clickPayoutHistory() {
		click(getMerchantActivity("Payout History"), "Payout History");
	}

	public void clickReserveHistory() {
		click(getMerchantActivity("Reserve History"), "Reserve History");
	}

}
