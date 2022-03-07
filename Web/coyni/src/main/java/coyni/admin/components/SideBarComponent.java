package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.admin.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SideBarComponent extends BrowserFunctions {
	private By handMark = By.cssSelector(".flex.flex-row.items-center.justify-between.gap-1.menu_item_small");

	public void verifyCursorAction() {
		new CommonFunctions().verifyCursorAction(handMark, "Hand Mark");
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getSideBarItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public By getSideBarItems(String elementName) {
		return By.xpath(String.format("//span[(contains(@class,'menu' ) or contains(@class,'label'))and text()='%s']",
				elementName));
	}

	public void clickCoyniPortal() {
		click(getSideBarItems("Coyni Portal"), "Coyni Portal");
	}

	public void clickTransactions() {
		click(getSideBarItems("Transactions"), "Transactions");
	}

	public void clickProfiles() {
		click(getSideBarItems("Profiles"), "Profiles");
	}

	public void clickUnderWriting() {
		click(getSideBarItems("UnderWriting"), "UnderWriting");
	}

	public void clickDisputes() {
		click(getSideBarItems("Disputes"), "Disputes");
	}

	public void clickAccounting() {
		click(getSideBarItems("Accounting"), "Accounting");
	}

	public void clickGatewaySettings() {
		click(getSideBarItems("Gateway Settings"), "Gateway Settings");
	}

	public void clickExportedFiles() {
		click(getSideBarItems("Exported Files"), "Exported Files");
	}

	public void clickBalanceReports() {
		click(getSideBarItems("Balance Reports"), "Balance Reports");
	}

	public void clickSystemSettings() {
		click(getSideBarItems("System Settings"), "System Settings");
	}

	public By getSubMenuItems(String mainItem, String subItem) {
		return By.xpath(String.format("//span[text()='%s']/../../../following-sibling::*[1]//div[text()='%s']",
				mainItem, subItem));

	}

	public void clickTokenAccount() {
		// clickCoyniPortal();
		click(getSubMenuItems("Coyni Portal", "Token Account"), "Token Account");
	}

	public void clickCommissionAccount() {
		// clickCoyniPortal();
		click(getSubMenuItems("Coyni Portal", "Commission Account"), "Commission Account");
	}

	public void clickIndividuals() {
		clickProfiles();
		click(getSubMenuItems("Profiles", "Individuals"), "Individuals");
	}

	public void clickBusinesses() {
		clickProfiles();
		click(getSubMenuItems("Profiles", "Businesses"), "Businesses");
	}

	public void clickCoyniEmployees() {
		clickProfiles();
		click(getSubMenuItems("Profiles", "Coyni Employees"), "Coyni Employees");
	}

	public void clickLedgers() {
		clickProfiles();
		click(getSubMenuItems("Profiles", "Ledgers"), "Ledgers");
	}

	public void clickAPIBusinessess() {
		clickProfiles();
		click(getSubMenuItems("Profiles", "API Users"), "API Businesses");
	}

	public void clickPersonal() {
		clickUnderWriting();
		click(getSubMenuItems("UnderWriting", "Personal"), "Personal");
	}

	public void clickBusiness() {
		clickUnderWriting();
		click(getSubMenuItems("UnderWriting", "Business"), "Business");
	}

	public void clickTotalWithdraw() {
		clickAccounting();
		click(getSubMenuItems("Accounting", "Total Withdraw"), "Total Withdraw");
	}

	public void clickTotalDeposits() {
		clickAccounting();
		click(getSubMenuItems("Accounting", "Total Deposits"), "Total Deposits");
	}

	public void clickPaymentGateways() {
		clickGatewaySettings();
		click(getSubMenuItems("Gateway Settings", "Payment Gateways"), "Payment Gateways");
	}

	public void clickLoadBalancer() {
		clickGatewaySettings();
		click(getSubMenuItems("Gateway Settings", "Load Balancer"), "Load Balancer");
	}

	public void clickAgreements() {
		clickSystemSettings();
		click(getSubMenuItems("System Settings", "Agreements"), "Agreements");
	}

	public void clickFeeStructure() {
		clickSystemSettings();
		click(getSubMenuItems("System Settings", "Fee Sructure"), "Fee Sructure");
	}

	public void clickAccountLimits() {
		clickSystemSettings();
		click(getSubMenuItems("System Settings", "Account Limits"), "Account Limits");
	}

	public void clickPermissions() {
		clickSystemSettings();
		click(getSubMenuItems("System Settings", "Permissions"), "Permissions");
	}

	public void clickFeatureControls() {
		clickSystemSettings();
		click(getSubMenuItems("System Settings", "Feature Controls"), "Feature Controls");
	}

	public void clickCardBlackList() {
		clickSystemSettings();
		click(getSubMenuItems("System Settings", "Card BlackList"), "Card BlackList");
	}

	public void clickPushNotifications() {
		clickSystemSettings();
		click(getSubMenuItems("System Settings", "Push Notifications"), "Push Notifications");
	}

	public void verifyTotalDepositsView() {
		new CommonFunctions().elementView(getSubMenuItems("Accounting", "Total Deposits"), "TotalDeposits");
	}

	public AccountTableComponent accountTableComponent() {
		return new AccountTableComponent();
	}

	public TokenAccountPage tokenAccountPage() {
		return new TokenAccountPage();
	}

	public ProfileComponent profileComponent() {
		return new ProfileComponent();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}
}
