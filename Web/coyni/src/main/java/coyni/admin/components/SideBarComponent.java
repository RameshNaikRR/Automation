package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.admin.pages.BalanceReportsPage;
import coyni.admin.pages.CommissionAccountPage;
import coyni.admin.pages.FeatureControlPage;
import coyni.admin.pages.FeeStructurePage;
import coyni.admin.pages.TokenAccountPage;
import coyni.admin.pages.TransactionPage;
import coyni.admin.pages.ViewMerchantfeeStructurePage;
import coyni.admin.pages.ViewPersonalFeeStructurePage;
import coyni.admin.popups.ExportSelectedTransactions;
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
		return By.xpath(String.format(
				"(//span[(contains(@class,'menu' ) or contains(@class,'label') or contains(@class,'Label'))and text()='%s'])[1]",
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

	public By getSubMenuItems(String subItem) {
		return By.xpath(String.format("//p[.='%s']", subItem));

	}

	public void clickTokenAccount() {
		// clickCoyniPortal();
		click(getSubMenuItems("Token Account"), "Token Account");
	}

	public void clickCommissionAccount() {
		// clickCoyniPortal();
		click(getSubMenuItems("Commission Account"), "Commission Account");
	}

	public void clickPersonals() {
		//clickProfiles();
		click(getSubMenuItems("Personal"), "Personal");
	}

	public void clickBusinesses() {
		clickProfiles();
		click(getSubMenuItems("Businesses"), "Businesses");
	}

	public void clickCoyniEmployees() {
		clickProfiles();
		click(getSubMenuItems("Coyni Employees"), "Coyni Employees");
	}

	public void clickLedgers() {
		clickProfiles();
		click(getSubMenuItems("Ledgers"), "Ledgers");
	}

	public void clickAPIBusinessess() {
		clickProfiles();
		click(getSubMenuItems("API Users"), "API Businesses");
	}

	public void clickPersonal() {
		clickUnderWriting();
		click(getSubMenuItems("Personal"), "Personal");
	}

	public void clickBusiness() {
		clickUnderWriting();
		click(getSubMenuItems("Business"), "Business");
	}

	public void clickTotalWithdraw() {
		clickAccounting();
		click(getSubMenuItems("Total Withdraw"), "Total Withdraw");
	}

	public void clickTotalDeposits() {
		
		click(getSubMenuItems("Total Deposits"), "Total Deposits");
	}

	public void clickPaymentGateways() {
		clickGatewaySettings();
		click(getSubMenuItems("Payment Gateways"), "Payment Gateways");
	}

	public void clickLoadBalancer() {
		clickGatewaySettings();
		click(getSubMenuItems("Load Balancer"), "Load Balancer");
	}

	public void clickAgreements() {
		clickSystemSettings();
		click(getSubMenuItems("Agreements"), "Agreements");
	}

	public void clickFeeStructure() {
		// clickSystemSettings();
		click(getSubMenuItems("Fee Structure"), "Fee Structure");
	}

	public void clickAccountLimits() {
		clickSystemSettings();
		click(getSubMenuItems("Account Limits"), "Account Limits");
	}

	public void clickPermissions() {
		clickSystemSettings();
		click(getSubMenuItems("Permissions"), "Permissions");
	}

	public void clickFeatureControls() {
		// clickSystemSettings();
		click(getSubMenuItems("Feature Controls"), "Feature Controls");
	}

	public void clickCardBlackList() {
		clickSystemSettings();
		click(getSubMenuItems("Card BlackList"), "Card BlackList");
	}

	public void clickPushNotifications() {
		clickSystemSettings();
		click(getSubMenuItems("Push Notifications"), "Push Notifications");
	}

	public void verifyTotalDepositsView() {
		new CommonFunctions().elementView(getSubMenuItems("Total Deposits"), "TotalDeposits");
	}

	public AccountTableComponent accountTableComponent() {
		return new AccountTableComponent();
	}

	public TokenAccountPage tokenAccountPage() {
		return new TokenAccountPage();
	}

	public CommissionAccountPage commissionAccountPage() {
		return new CommissionAccountPage();
	}

	public ProfileComponent profileComponent() {
		return new ProfileComponent();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public BatchIDComponent batchIDComponent() {
		return new BatchIDComponent();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}

	public TransactionPage transactionPage() {
		return new TransactionPage();
	}

	public FeeStructurePage feeStructurePage() {
		return new FeeStructurePage();
	}

	public ViewPersonalFeeStructurePage viewPersonalFeeStructurePage() {
		return new ViewPersonalFeeStructurePage();
	}

	public ViewMerchantfeeStructurePage viewMerchantfeeStructurePage() {
		return new ViewMerchantfeeStructurePage();
	}

	public FeatureControlPage featureControlPage() {
		return new FeatureControlPage();
	}

	public BalanceReportsPage balanceReportsPage() {
		return new BalanceReportsPage();
	}

	public ExportSelectedTransactions exportSelectedTransactions() {
		return new ExportSelectedTransactions();
	}

}
