package coyni.admin.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class SideBarComponent extends BrowserFunctions {

	public By getSideBarItems(String elementName) {
		return By.xpath(String.format("//span[(contains(@class,'menu' ) or contains(@class,'label'))and text()='%s']",
				elementName));
	}

	public void getElementsForCoyniPortal(String type) {
		click(getSideBarItems("Coyni Portal"), type);
	}

	public void getElementsForTransactions(String type) {
		click(getSideBarItems("Transactions"), type);
	}

	public void getElementsForProfiles(String type) {
		click(getSideBarItems("Profiles"), type);
	}

	public void getElementsForUnderWriting(String type) {
		click(getSideBarItems("UnderWriting"), type);
	}

	public void getElementsForDisputes(String type) {
		click(getSideBarItems("Disputes"), type);
	}

	public void getElementsForAccounting(String type) {
		click(getSideBarItems("Accounting"), type);
	}

	public void getElementsForGatewaySettings(String type) {
		click(getSideBarItems("Gateway Settings"), type);
	}

	public void getElementsForExportedFiles(String type) {
		click(getSideBarItems("Exported Files"), type);
	}

	public void getElementsForBalanceReports(String type) {
		click(getSideBarItems("Balance Reports"), type);
	}

	public void getElementsForSystemSettings(String type) {
		click(getSideBarItems("System Settings"), type);
	}

	public By getSubMenuItems(String elementName) {
		return By.xpath(String.format("//div[(contains(@class,'flex' ) or contains(@class,'label'))and text()='%s']",
				elementName));

	}

	public void getElementsForTokenAccount(String type) {
		click(getSubMenuItems("Token Account"), type);
	}

	public void getElementsForCommissionAccount(String type) {
		click(getSubMenuItems("Commission Account"), type);
	}

	public void getElementsForIndividuals(String type) {
		click(getSubMenuItems("Individuals"), type);
	}

	public void getElementsForBusinesses(String type) {
		click(getSubMenuItems("Businesses"), type);
	}

	public void getElementsForCoyniEmployees(String type) {
		click(getSubMenuItems("Coyni Employees"), type);
	}

	public void getElementsForAPIBusinesses(String type) {
		click(getSubMenuItems("API Businesses"), type);
	}

	public void getElementsForPersonal(String type) {
		click(getSubMenuItems("Personal"), type);
	}

	public void getElementsForBusiness(String type) {
		click(getSubMenuItems("Business"), type);
	}

	public void getElementsForTotalWithdraw(String type) {
		click(getSubMenuItems("Total Withdraw"), type);
	}

	public void getElementsForTotalDeposits(String type) {
		click(getSubMenuItems("Total Deposits"), type);
	}

	public void getElementsForPaymentGateways(String type) {
		click(getSubMenuItems("Payment Gateways"), type);
	}

	public void getElementsForLoadBalancer(String type) {
		click(getSubMenuItems("Load Balancer"), type);
	}

	public void getElementsForAgreements(String type) {
		click(getSubMenuItems("Agreements"), type);
	}

	public void getElementsForFeeStructure(String type) {
		click(getSubMenuItems("Fee Sructure"), type);
	}

	public void getElementsForAccountLimits(String type) {
		click(getSubMenuItems("Account Limits"), type);
	}

	public void getElementsForPermissions(String type) {
		click(getSubMenuItems("Permissions"), type);
	}

	public void getElementsForFeatureControls(String type) {
		click(getSubMenuItems("Feature Controls"), type);
	}

	public void getElementsForCardBlackList(String type) {
		click(getSubMenuItems("Card BlackList"), type);
	}

	public void getElementsForPushNotifications(String type) {
		click(getSubMenuItems("Push Notifications"), type);
	}
}
