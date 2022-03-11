package coyni.apibusiness.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class SideBarMenuComponent extends BrowserFunctions {
	
	private By lnkTokenWallets = 	By.xpath(" ");
	private By lnkEcosystemActivity = By.xpath(" ");
	private By lnkExportFiles = By.xpath(" ");
	private By lnkBusinessSettings = By.xpath(" ");
	private By lnkGethelp = By.xpath(" ");
	
	
	public void clickTokenWallets() {
		click(lnkTokenWallets, "Token Wallets");
	}
	public void clickEcosystemActivity() {
		click(lnkEcosystemActivity, "Ecosystem Activity");
	}
	public void clickExportFiles() {
		click(lnkExportFiles, "Export Files"); 
	}
	public void clickBusinessSettings() {
		click(lnkEcosystemActivity, "Business Settings");
	}
	public void clickGetHelp() {
		click(lnkGethelp, "get Help");
	}
	
	
	
	
	
	
	
	
	
	

}
