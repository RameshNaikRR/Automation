package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.admin.MerchantServicesPages.BalanceReportPage;
import coyni.admin.MerchantServicesPages.ReserveManagementPage;
import coyni.admin.MerchantServicespopups.ExportSelectedTransactionsPopup;
import coyni.admin.Paymentcomponents.AccountTableComponent;
import coyni.admin.Paymentcomponents.AddMerchantComponent;
import coyni.admin.Paymentcomponents.DisputesDetailsComponent;
import coyni.admin.Paymentcomponents.ExportComponent;
import coyni.admin.Paymentcomponents.FilterComponent;
import coyni.admin.Paymentcomponents.ProfileComponent;
import coyni.admin.Paymentpages.AccountingPage;
import coyni.admin.Paymentpages.CommissionAccountPage;
import coyni.admin.Paymentpages.PaymentReviewPage;
import coyni.admin.Paymentpages.TokenAccountPage;
import coyni.admin.Paymentpages.TransactionsPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SideBarComponent extends BrowserFunctions {
	CommonFunctions commonFunctions = new CommonFunctions();

	private By handMark = By.cssSelector(".flex.flex-row.items-center.justify-between.gap-1.menu_item_small");

	private By record = By.cssSelector("tbody>tr:nth-of-type(3)");

	public By getSideBarItems(String elementName) {
		return By.xpath(String.format(
				"(//span[(contains(@class,'menu' ) or contains(@class,'label') or contains(@class,'Label'))and text()='%s'])[1]",
				elementName));
	}

	private By lblDisputes = By.xpath("(//span[text()='Disputes'])[2]");

	public void verifyDisputes(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDisputes, "Disputes", expHeading);
	}

	public void verifyCursorAction() {
		new CommonFunctions().verifyCursorAction(handMark, "Coyni  Portal");
	}

	public void clickCommissionAccount() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Commission Account"), "Commission Account");
		click(getSideBarItems("Commission Account"), "Commission Account");
		Thread.sleep(4000);
	}

	public void clickDisputes() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Disputes"), "Disputes");
		click(getSideBarItems("Disputes"), "Disputes");
		Thread.sleep(4000);
	}

	public void clickTransactions() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Transactions"), "Transactions");
		click(getSideBarItems("Transactions"), "Transactions");
		Thread.sleep(4000);
	}

	public void clickTransactionTable() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Transaction Table"), "Transaction Table");
		click(getSideBarItems("Transactions"), "Transactions");
		Thread.sleep(4000);
	}

	public void clickTransactionDetails() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Transaction Details"), "Transaction Details");
		click(getSideBarItems("Transactions"), "Transactions");
		Thread.sleep(4000);
	}

	public void clickBusinessProfile() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Business Profiles"), "Business Profiles");
		click(getSideBarItems("Business Profiles"), "Business Profiles");
		Thread.sleep(4000);
	}

	public void clickProfiles() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Profiles"), "Profiles");
		click(getSideBarItems("Profiles"), "Profiles");
		Thread.sleep(4000);
	}

	public void clickInviteNewBusiness() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Invite New Business"), "Invite New Business");
		click(getSideBarItems("Invite New Business"), "Invite New Business");
		Thread.sleep(4000);
	}

	public void clickUnderwriting() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Underwriting"), "Underwriting");
		click(getSideBarItems("Underwriting"), "Underwriting");
		Thread.sleep(4000);
	}

	public void clickCompliance() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Compliance"), "Compliance");
		click(getSideBarItems("Compliance"), "Compliance");
		Thread.sleep(4000);
	}

	public void clickPaymentReview() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Payment Review"), "Payment Review");
		click(getSideBarItems("Payment Review"), "Payment Review");
		Thread.sleep(4000);
	}

	public void clickCountryConfiguration() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Country Configuration"), "Country Configuration");
		click(getSideBarItems("Country Configuration"), "Country Configuration");
		Thread.sleep(4000);
	}

	public void clickAccounting() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Accounting"), "Accounting");
		click(getSideBarItems("Accounting"), "Accounting");
		Thread.sleep(4000);
	}

	public void clickOutgoingPayments() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Outgoing Payments"), "Outgoing Payments");
		click(getSideBarItems("Outgoing Payments"), "Outgoing Payments");
		Thread.sleep(4000);
	}

	public void clickIncomingPayments() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Incoming Payments"), "Incoming Payments");
		click(getSideBarItems("Incoming Payments"), "Incoming Payments");
		Thread.sleep(4000);
	}

	public void clickBankConfiguration() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Bank Configuration"), "Bank Configuration");
		click(getSideBarItems("Bank Configuration"), "Bank Configuration");
		Thread.sleep(4000);
	}

	public void clickBalanceReport() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Balance Report"), "Balance Report");
		click(getSideBarItems("Balance Report"), "Balance Report");
		Thread.sleep(4000);
	}

	public void clickExports() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Exports"), "Exports");
		click(getSideBarItems("Exports"), "Exports");
		Thread.sleep(4000);
	}

	public void clickProductSettings() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Product Settings"), "Product Settings");
		click(getSideBarItems("Product Settings"), "Product Settings");
		Thread.sleep(4000);
	}

	public void clickFeatureControls() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Feature Controls"), "Feature Controls");
		click(getSideBarItems("Feature Controls"), "Feature Contols");
		Thread.sleep(4000);
	}

	public void clickSystemSettings() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("System Settigs"), "System Settings");
		click(getSideBarItems("System Settings"), "System Settings");
		Thread.sleep(4000);
	}

	public void clickCoyniEmployees() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("coyni Employees"), "coyni Employees");
		click(getSideBarItems("coyni Employees"), "coyni Employees");
		Thread.sleep(4000);
	}

	public void clickAgreements() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Agreements"), "Agreements");
		click(getSideBarItems("Agreements"), "Agreements");
		Thread.sleep(4000);
	}

	public void clickMerchantServices() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Merchant Services"), "Merchant Services");
		click(getSideBarItems("Feature Controls"), "Feature Contols");
		Thread.sleep(4000);
	}

	public void clickPayments() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Payments"), "Payments");
		click(getSideBarItems("Payments"), "Payments");
		Thread.sleep(4000);
	}

	public void clickBusinessAPIs() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Business APIs"), "Business APIs");
		click(getSideBarItems("Business APIs"), "Business APIs");
		Thread.sleep(4000);
	}

	public CommissionAccountPage commissionAccountPage() {
		return new CommissionAccountPage();
	}

	public TokenAccountPage tokenAccountPage() {
		return new TokenAccountPage();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}

	public AccountingPage accountingPage() {
		return new AccountingPage();
	}

	public AddMerchantComponent addMerchantComponent() {
		return new AddMerchantComponent();
	}

	public ProfileComponent profileComponent() {
		return new ProfileComponent();
	}

	public void clickPersonal() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSubMenuItems("Personal"), "Personal");
		click(getSubMenuItems("Personal"), "Personal");
		Thread.sleep(5000);
	}

	public void clickBusiness() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSubMenuItems("Business"), "Business");
		click(getSubMenuItems("Business"), "Business");
		Thread.sleep(5000);
	}

	public void clickTotalWithdraw() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSubMenuItems("Total Withdraw"), "Total Withdraw");
		click(getSubMenuItems("Total Withdraw"), "Total Withdraw");
		Thread.sleep(4000);
	}

	public void clickTotalDeposits() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSubMenuItems("Total Deposits"), "Total Deposits");
		click(getSubMenuItems("Total Deposits"), "Total Deposits");
		Thread.sleep(5000);
	}

	public void clickPaymentGateways() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSubMenuItems("Payment Gateways"), "Payment Gateways");
		click(getSubMenuItems("Payment Gateways"), "Payment Gateways");
		Thread.sleep(5000);
	}

	public By getSubMenuItems(String subItem) {
		return By.xpath(String.format("//p[.='%s']", subItem));

	}

	public void clickReserveManagement() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Reserve Mgmt."), "Reserve Mgmt.");
		click(getSideBarItems("Reserve Mgmt."), "Reserve Management");
		Thread.sleep(4000);
	}

	public void clickCardBlackList() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSubMenuItems("Card Blacklist"), "Card Blacklist");
		click(getSubMenuItems("Card Blacklist"), "Card Blacklist");
		Thread.sleep(5000);
	}

	private By lblPaymentGateWay = By.xpath("//span[text()='Payment Gateways']");

	public void verifyPaymentGateWay(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPaymentGateWay, "Payment Gateways", expHeading);
	}

	public void clickExportedFiles() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Exported Files"), "Exported Files");
		click(getSideBarItems("Exported Files"), "Exported Files");
		Thread.sleep(4000);
	}

	public void clickMerchant() throws InterruptedException {
		// commonfunctions.verifyCursorAction(getSubMenuItems("Merchant"), "Merchant");
		click(getSubMenuItems("Merchants"), "Merchant");
		Thread.sleep(2000);
	}

	public void clickBalanceReports() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Balance Reports"), "Balance Reports");
		click(getSideBarItems("Balance Reports"), "Balance Reports");
		Thread.sleep(4000);
	}

	public PaymentReviewPage paymentReviewPage() {
		return new PaymentReviewPage();
	}

	public BalanceReportPage balanceReportPage() {
		return new BalanceReportPage();
	}

	public ReserveManagementPage reserveManagementPage() {
		return new ReserveManagementPage();

	}

	public ExportSelectedTransactionsPopup exportSelectedTransactionsPopup() {
		return new ExportSelectedTransactionsPopup();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public AccountTableComponent accountTableComponent() {
		return new AccountTableComponent();
	}

	public DisputesDetailsComponent disputesDetailsComponent() {
		return new DisputesDetailsComponent();
	}

	public TransactionsPage transactionsPage() {
		return new TransactionsPage();
	}

}
