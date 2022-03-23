package coyni.apibusiness.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class SideBarMenuComponent extends BrowserFunctions {

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("//div[@class='DashboardMenu_menu__3PSTN']//span[text()='%s']", eleName));
	}

	public void clickTokenwallet() {
		click(getDashBoardItems("Token Wallets"), "Token Wallet");
	}

	public void clickEcosystemActivity() {
		click(getDashBoardItems("Ecosystem Activity"), "Ecosystem Activity");
	}
	public void clickExportFiles() {
		click(getDashBoardItems("Export Files"), "Export Files");
	}

	public void clickBusinessSettings() {
		click(getDashBoardItems("Business Settings"), "Business Settings");
	}
	public void clickGetHelp() {
		click(getDashBoardItems("Get Help"), "Get Help");
	}

}
