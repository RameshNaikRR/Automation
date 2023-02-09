package coyni.admin.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

import coyni.admin.pages.BalanceReportsPage;
import coyni.admin.pages.CommissionAccountPage;
import coyni.admin.pages.FeatureControlPage;
import coyni.admin.pages.FeeStructurePage;
import coyni.admin.pages.HomePage;
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
	// (//label[contains(@class,'text-sm')])
	// (//span[contains(@class,'text-sm')])

	CommonFunctions commonfunctions = new CommonFunctions();

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
		commonfunctions.verifyCursorAction(getSideBarItems("coyni Portal"), "coyni Portal");
		click(getSideBarItems("coyni Portal"), "coyni Portal");
		Thread.sleep(4000);
	}

	public void clickTransactions() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("Transactions"), "Transactions");
		click(getSideBarItems("Transactions"), "Transactions");
		Thread.sleep(4000);
	}

	public void clickProfiles() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("Profiles"), "Profiles");
		click(getSideBarItems("Profiles"), "Profiles");
		Thread.sleep(4000);
	}

	public void clickUnderWriting() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("Underwriting"), "Underwriting ");
		click(getSideBarItems("Underwriting"), "UnderWriting");
		Thread.sleep(4000);
	}

	public void clickDisputes() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("Disputes"), "Disputes");
		click(getSideBarItems("Disputes"), "Disputes");
		Thread.sleep(4000);
	}

	private By lblDisputes = By.xpath("(//span[text()='Disputes'])[2]");

	public void verifyDisputes(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDisputes, "Disputes", expHeading);
	}

	public void clickReserveManagement() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("Reserve Mgmt."), "Reserve Mgmt.");
		click(getSideBarItems("Reserve Mgmt."), "Reserve Management");
		Thread.sleep(4000);
	}

	public void clickAccounting() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("Accounting"), "Accounting");
		click(getSideBarItems("Accounting"), "Accounting");
		Thread.sleep(4000);
	}

	public void clickGatewaySettings() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("Gateway Settings"), "Gateway Settings");
		click(getSideBarItems("Gateway Settings"), "Gateway Settings");
		Thread.sleep(4000);
	}

	public void clickExportedFiles() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("Exported Files"), "Exported Files");
		click(getSideBarItems("Exported Files"), "Exported Files");
		Thread.sleep(4000);
	}
	
	
	private By lblExportFile = By.xpath("//span[text()='Exported Files']");

	public void verifyExportFiles(String exp) {
		new CommonFunctions().verifyLabelText(lblExportFile, "Exported Files", exp);
	}

	public void clickBalanceReports() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("Balance Reports"), "Balance Reports");
		click(getSideBarItems("Balance Reports"), "Balance Reports");
		Thread.sleep(4000);
	}

	public void clickSystemSettings() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSideBarItems("System Settings"), "System Settings");
		click(getSideBarItems("System Settings"), "System Settings");
		Thread.sleep(4000);
	}

	public By getSubMenuItems(String subItem) {
		return By.xpath(String.format("//p[.='%s']", subItem));

	}

	public void clickTokenAccount() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Token Account"), "Token Account");
		click(getSubMenuItems("Token Account"), "Token Account");
		Thread.sleep(5000);
	}

	public void clickCommissionAccount() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Commission Account"), "Commission Account");
		click(getSubMenuItems("Commission Account"), "Commission Account");
		Thread.sleep(5000);
	}

	public void clickPersonals() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Personal"), "Personal");
		click(getSubMenuItems("Personal"), "Personal");
		Thread.sleep(5000);
	}

	public void clickBusinesses() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Businesses"), "Businesses");
		click(getSubMenuItems("Businesses"), "Businesses");
		Thread.sleep(5000);
	}

	public void clickCoyniEmployees() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("coyni Employees"), "coyni Employees");
		click(getSubMenuItems("coyni Employees"), "coyni Employees");
		Thread.sleep(5000);
	}

	public void clickLedgers() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Ledgers"), "Ledgers");
		click(getSubMenuItems("Ledgers"), "Ledgers");
		Thread.sleep(5000);
	}

	public void clickAPIBusinessess() throws InterruptedException {
		//commonfunctions.verifyCursorAction(getSubMenuItems("API Users"), "API Users");
		click(getSubMenuItems("API Business"), "API Businesses");
		Thread.sleep(5000);
	}

	private By lblApiBusinessHeading = By.xpath("//span[text()='Underwriting - API Business']");

	public void verifyApiBusinessHeading(String exp) {
		new CommonFunctions().verifyLabelText(lblApiBusinessHeading, "Underwriting - API Business", exp);
	}

	public void clickPersonal() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Personal"), "Personal");
		click(getSubMenuItems("Personal"), "Personal");
		Thread.sleep(5000);
	}

	public void clickBusiness() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Business"), "Business");
		click(getSubMenuItems("Business"), "Business");
		Thread.sleep(5000);
	}

	public void clickTotalWithdraw() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Total Withdraw"), "Total Withdraw");
		click(getSubMenuItems("Total Withdraw"), "Total Withdraw");
		Thread.sleep(4000);
	}

	public void clickTotalDeposits() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Total Deposits"), "Total Deposits");
		click(getSubMenuItems("Total Deposits"), "Total Deposits");
		Thread.sleep(5000);
	}

	public void clickPaymentGateways() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Payment Gateways"), "Payment Gateways");
		click(getSubMenuItems("Payment Gateways"), "Payment Gateways");
		Thread.sleep(5000);
	}

	private By lblPaymentGateWay = By.xpath("//span[text()='Payment Gateways']");

	public void verifyPaymentGateWay(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPaymentGateWay, "Payment Gateways", expHeading);
	}

	private By lblLoadBalancer = By.xpath("//span[text()='Load Balancer']");

	public void verifyLoadBalancer(String expHeading) {
		new CommonFunctions().verifyLabelText(lblLoadBalancer, "Load Balancer", expHeading);
	}

	public void clickLoadBalancer() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Load Balancer"), "Load Balancer");
		click(getSubMenuItems("Load Balancer"), "Load Balancer");
		Thread.sleep(5000);
	}

	public void clickAgreements() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Agreements"), "Agreements");
		click(getSubMenuItems("Agreements"), "Agreements");
		Thread.sleep(5000);
	}

	public void clickFeeStructure() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Fee Structure"), "Fee Structure");
		click(getSubMenuItems("Fee Structure"), "Fee Structure");
		Thread.sleep(5000);
	}

	public void clickAccountLimits() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Account Limits"), "Account Limits");
		click(getSubMenuItems("Account Limits"), "Account Limits");
		Thread.sleep(5000);
	}

	public void clickPermissions() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Permissions"), "Permissions");
		click(getSubMenuItems("Permissions"), "Permissions");
		Thread.sleep(5000);
	}

	public void clickFeatureControls() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Feature Controls"), "Feature Controls");
		click(getSubMenuItems("Feature Controls"), "Feature Controls");
		Thread.sleep(5000);
	}

	public void clickCardBlackList() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Card Blacklist"), "Card Blacklist");
		click(getSubMenuItems("Card Blacklist"), "Card Blacklist");
		Thread.sleep(5000);
	}

	public void clickPushNotifications() throws InterruptedException {
		commonfunctions.verifyCursorAction(getSubMenuItems("Push Notifications"), "Push Notifications");
		click(getSubMenuItems("Push Notifications"), "Push Notifications");
		Thread.sleep(5000);
	}

	public void clickMerchant() throws InterruptedException {
	//	commonfunctions.verifyCursorAction(getSubMenuItems("Merchant"), "Merchant");
		click(getSubMenuItems("Merchants"), "Merchant");
		Thread.sleep(5000);
	}
	public void clickuderMerchant() throws InterruptedException {
		//	commonfunctions.verifyCursorAction(getSubMenuItems("Merchant"), "Merchant");
			click(getSubMenuItems("Merchant"), "Merchant");
			Thread.sleep(5000);
		}

	public void verifyTotalDepositsView() throws InterruptedException {
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

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	public AddMerchantComponent addMerchantComponent() {
		return new AddMerchantComponent();
	}

}
