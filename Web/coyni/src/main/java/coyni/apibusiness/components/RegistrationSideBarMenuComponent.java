package coyni.apibusiness.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class RegistrationSideBarMenuComponent extends BrowserFunctions{
	
	private By getRegistrationSideBarComponents(String elementName) {
		return By.xpath(String.format("//span[text()='Business Application']/..//h6[text()='%s']", elementName));
	}
    
	public void clickCompanyInformation() {
		click(getRegistrationSideBarComponents("Company Information"), "Company Information");
	}
	public void clickDBAInformation() {
		click(getRegistrationSideBarComponents("DBA Information"), "DBA Information");
	}
	public void clickBeneficialOwners() {
		click(getRegistrationSideBarComponents("Beneficial Owner(s)"), "Beneficial Owner(s)");
	}
	public void clickBankAccount() {
		click(getRegistrationSideBarComponents("Bank Account"), "Bank Account");
	}
	public void clickProgressingFee() {
		click(getRegistrationSideBarComponents("Processing Fees"), "Processing Fees");
	}
	public void clickAgreements() {
		click(getRegistrationSideBarComponents("Agreements"), "Agreements");
	}
	public void clickApplicationSummary() {
		click(getRegistrationSideBarComponents("Application Summary"), "Application Summary");
	}
}
