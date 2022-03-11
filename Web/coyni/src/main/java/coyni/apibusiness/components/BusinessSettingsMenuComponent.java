package coyni.apibusiness.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class BusinessSettingsMenuComponent extends BrowserFunctions {

	private By lblAccountStatus = By.xpath(" ");
	private By lnkCompanyInformation = By.xpath(" ");
	private By lnkDBAinformation = By.xpath(" ");
	private By lnkPaymentMethods = By.xpath(" ");
	private By lnkPreferences = By.xpath(" ");
	private By lnkAgreements = By.xpath(" ");
	private By lnkFees = By.xpath(" ");
	private By lnkAccountLimits = By.xpath(" ");
	private By lnkTeam = By.xpath(" ");
	private By lnkIpAddress = By.xpath(" ");
	private By lnkApiKeys = By.xpath(" ");
	private By lnkWebHooks = By.xpath(" ");
	
	public void clickAccountStatus() {
		click(lblAccountStatus, "Account Status");
	}
	public void clickCompanyInformation() {
		click(lnkCompanyInformation, "Company Information");
	}
	public void clickDbaInformation() {
		click(lnkDBAinformation, "DBA information");
	}
	public void clickPaymentMethods() {
		click(lnkPaymentMethods, "Payment Methods");
	}
	public void clickPreferences() {
		click(lnkPreferences, "Preferences");
	}
	public void clickAgreements() {
		click(lnkAgreements, "Agreements");
	}
	public void clickFees() {
		click(lnkFees, "Fees");
	}
	public void clickAccountLimits() {
		click(lnkAccountLimits, "Account limits");
	}
	public void clickTeam() {
		click(lnkTeam, "Team");
	}
	public void clickIpAddres() {
		click(lnkIpAddress, "Ip Address");
	}
	public void clickApiKeys() {
		click(lnkApiKeys, "ApiKeys");
	}
	public void clickWebHooks() {
		click(lnkWebHooks, "WebHooks");
	}	
	
}
