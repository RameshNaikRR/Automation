package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.apibusiness.pages.RegistrationBeneficialOwnersPage;
import ilabs.WebFramework.BrowserFunctions;

public class SideBarMenuComponent extends BrowserFunctions {
	
	private By lnkTokenWallets = 	By.xpath(" ");
	private By lnkEcosystemActivity = By.xpath(" ");
	private By lnkExportFiles = By.xpath(" ");
	private By lnkBusinessSettings = By.xpath(" ");
	private By lnkGethelp = By.xpath(" ");
	private By BusinessApplicationArrow = By.xpath("//div[@class='items-center text-xs -ml-2 4xl:mr-2']");
	private By btnContinueApplication = By.xpath("//button[text()='Continue Application']");
	
	
	
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
	public void clickBusinessApplicationArrow() {
		click(BusinessApplicationArrow, "Business Application Arrow");
	}

	public void clickContinueApplication() {
		click(btnContinueApplication, "Continue Application");
	}

	public RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage() {
		return new RegistrationBeneficialOwnersPage();
	}

	public BusinessSettingsMenuComponent businessSettingsMenuComponent() {
		return new BusinessSettingsMenuComponent();
	}

}

	
	
	
	
	
	
	
	
	


