package coyni.admin.MerchantServicescomponents;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessProfileSideBarComponent extends BrowserFunctions {

	CommonFunctions commonFunctions = new CommonFunctions();

	private By getBusinessProfileItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void clickPayments() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Payments"), "Payments");
		click(getBusinessProfileItems("Payments"), "Payments");
	}

	public void clickWallets() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Wallets"), "Wallets");
		click(getBusinessProfileItems("Wallets"), "Wallets");
	}

	public void clickBusinessInformation() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Business Information"), "Business Information");
		click(getBusinessProfileItems("Business Information"), "Business Information");
	}

	public void clicAccountOwner() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Account Owner"), "Account Owner");
		click(getBusinessProfileItems("Account Owner"), "Account Owner");
	}

	public void clickContactInformation() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Contact Information"), "Contact Information");
		click(getBusinessProfileItems("Contact Information"), "Contact Information");
	}

	public void clickAccountFeesAndLimits() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Account Fees & Limits"), "Account Fees & Limits");
		click(getBusinessProfileItems("Account Fees & Limits"), "Account Fees & Limits");
	}

	public void clickPaymentMethods() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Payment Methods"), "Payment Methods");
		click(getBusinessProfileItems("Payment Methods"), "Payment Methods");
	}

	public void clickControls() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Controls"), "Controls");
		click(getBusinessProfileItems("Controls"), "Controls");
	}

	public void clickTeam() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Team"), "Team");
		click(getBusinessProfileItems("Team"), "Team");
	}

	public void clickTeamMember() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Team Member"), "Team Member");
		click(getBusinessProfileItems("Team Member"), "Team Member");
	}

	public void clickPermissionRoles() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Permission Roles"), "Permission Roles");
		click(getBusinessProfileItems("Permission Roles"), "Permission Roles");
	}

	public void clickActivityLog() throws InterruptedException {
		commonFunctions.verifyCursorAction(getBusinessProfileItems("Activity Log"), "Activity Log");
		click(getBusinessProfileItems("Activity Log"), "Activity Log");
	}

}
