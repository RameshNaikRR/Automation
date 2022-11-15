package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.admin.pages.BalanceReportsPage;
import coyni.admin.pages.CommissionAccountPage;
import coyni.admin.pages.FeatureControlPage;
import coyni.admin.pages.FeeStructurePage;
import coyni.admin.pages.ReserveManagementPage;
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
		new CommonFunctions().verifyCursorAction(handMark, "Coyni  Portal");
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
	
	public void clickCoyniPortal() throws InterruptedException {
		click(getSideBarItems("Coyni Portal"), "Coyni Portal");
		Thread.sleep(4000);
	}

	public void clickTransactions() throws InterruptedException{
		click(getSideBarItems("Transactions"), "Transactions");
		Thread.sleep(4000);
	}

	public void clickProfiles() throws InterruptedException{
		click(getSideBarItems("Profiles"), "Profiles");
		Thread.sleep(4000);
	}

	public void clickUnderWriting() throws InterruptedException{
		click(getSideBarItems("Underwriting"), "UnderWriting");
		Thread.sleep(4000);
	}

	public void clickDisputes() throws InterruptedException{
		click(getSideBarItems("Disputes"), "Disputes");
		Thread.sleep(4000);
	}

	public void clickReserveManagement() throws InterruptedException{
		click(getSideBarItems("Reserve Mgmt."), "Reserve Management");
		Thread.sleep(4000);
	}

	public void clickAccounting() throws InterruptedException{
		click(getSideBarItems("Accounting"), "Accounting");
		Thread.sleep(4000);
	}

	public void clickGatewaySettings() throws InterruptedException{
		click(getSideBarItems("Gateway Settings"), "Gateway Settings");
		Thread.sleep(4000);
	}

	public void clickExportedFiles() throws InterruptedException{
		click(getSideBarItems("Exported Files"), "Exported Files");
		Thread.sleep(4000);
	}

	public void clickBalanceReports() throws InterruptedException{
		click(getSideBarItems("Balance Reports"), "Balance Reports");
		Thread.sleep(4000);
	}

	public void clickSystemSettings() throws InterruptedException{
		click(getSideBarItems("System Settings"), "System Settings");
		Thread.sleep(4000);
	}

	public By getSubMenuItems(String subItem) {
		return By.xpath(String.format("//p[.='%s']", subItem));

	}

	public void clickTokenAccount() throws InterruptedException{
		// clickCoyniPortal();
		click(getSubMenuItems("Token Account"), "Token Account");
		Thread.sleep(4000);
	}

	public void clickCommissionAccount() throws InterruptedException{
		// clickCoyniPortal();
		click(getSubMenuItems("Commission Account"), "Commission Account");
		Thread.sleep(4000);
	}

	public void clickPersonals() throws InterruptedException{
		// clickProfiles();
		click(getSubMenuItems("Personal"), "Personal");
		Thread.sleep(4000);
	}

	public void clickBusinesses()throws InterruptedException {

		click(getSubMenuItems("Businesses"), "Businesses");
		Thread.sleep(4000);
	}

	public void clickCoyniEmployees() throws InterruptedException{

		click(getSubMenuItems("Coyni Employees"), "Coyni Employees");
		Thread.sleep(4000);
	}

	public void clickLedgers() throws InterruptedException{

		click(getSubMenuItems("Ledgers"), "Ledgers");
		Thread.sleep(4000);
	}

	public void clickAPIBusinessess() throws InterruptedException{

		click(getSubMenuItems("API Users"), "API Businesses");
		Thread.sleep(4000);
	}

	public void clickPersonal() throws InterruptedException{

		click(getSubMenuItems("Personal"), "Personal");
		Thread.sleep(4000);
	}

	public void clickBusiness() throws InterruptedException{

		click(getSubMenuItems("Business"), "Business");
		Thread.sleep(4000);
	}

	public void clickTotalWithdraw() throws InterruptedException{

		click(getSubMenuItems("Total Withdraw"), "Total Withdraw");
		Thread.sleep(4000);
	}

	public void clickTotalDeposits() throws InterruptedException{

		click(getSubMenuItems("Total Deposits"), "Total Deposits");
		Thread.sleep(4000);
	}

	public void clickPaymentGateways() throws InterruptedException{

		click(getSubMenuItems("Payment Gateways"), "Payment Gateways");
		Thread.sleep(4000);
	}

	public void clickLoadBalancer() throws InterruptedException{

		click(getSubMenuItems("Load Balancer"), "Load Balancer");
		Thread.sleep(4000);
	}

	public void clickAgreements() throws InterruptedException{

		click(getSubMenuItems("Agreements"), "Agreements");
		Thread.sleep(4000);
	}

	public void clickFeeStructure() throws InterruptedException{
		// clickSystemSettings();
		click(getSubMenuItems("Fee Structure"), "Fee Structure");
		Thread.sleep(4000);
	}

	public void clickAccountLimits() throws InterruptedException{

		click(getSubMenuItems("Account Limits"), "Account Limits");
		Thread.sleep(4000);
	}

	public void clickPermissions() throws InterruptedException{

		click(getSubMenuItems("Permissions"), "Permissions");
		Thread.sleep(4000);
	}

	public void clickFeatureControls() throws InterruptedException{
		// clickSystemSettings();
		click(getSubMenuItems("Feature Controls"), "Feature Controls");
		Thread.sleep(4000);
	}

	public void clickCardBlackList() throws InterruptedException{

		click(getSubMenuItems("Card BlackList"), "Card BlackList");
		Thread.sleep(4000);
	}

	public void clickPushNotifications() throws InterruptedException{

		click(getSubMenuItems("Push Notifications"), "Push Notifications");
		Thread.sleep(4000);
	}
	public void clickMerchant() throws InterruptedException{

		click(getSubMenuItems("Merchant"), "Merchant");
		Thread.sleep(4000);
	}


	public void verifyTotalDepositsView() throws InterruptedException{
		new CommonFunctions().elementView(getSubMenuItems("Total Deposits"), "TotalDeposits");
		Thread.sleep(4000);
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

	public ReserveManagementPage reserveManagementPage() {
		return new ReserveManagementPage();

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

	public AccountLimitsComponent accountLimitsComponent() {
		return new AccountLimitsComponent();
	}

	public UnderWritingPersonalComponent underWritingPersonalComponent() {
		return new UnderWritingPersonalComponent();
	}

}
