package coyni.admin.MerchantServicescomponents;

import org.openqa.selenium.By;

import coyni.admin.MerchantServicesPages.AccountingPage;
import coyni.admin.MerchantServicesPages.CommissionAccountPage;
import coyni.admin.MerchantServicesPages.PaymentReviewPage;
import coyni.admin.MerchantServicesPages.TokenAccountPage;
import coyni.admin.MerchantServicesPages.TransactionsPage;
import coyni.admin.components.AddBusinessComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SideBarComponent extends BrowserFunctions {
	CommonFunctions commonFunctions = new CommonFunctions();

	public By getSideBarItems(String elementName) {
		return By.xpath(String.format(
				"(//span[(contains(@class,'menu' ) or contains(@class,'label') or contains(@class,'Label'))and text()='%s'])[1]",
				elementName));
	}
	
	

	public void clickCommissionAccount() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Commission Account"), "Commission Account");
		click(getSideBarItems("Commission Account"), "Commission Account");
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

	public void clickExportedFiles() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItems("Exported Files"), "Exported Files");
		click(getSideBarItems("Exported Files"), "Exported Files");
		Thread.sleep(4000);
	}

	public PaymentReviewPage paymentReviewPage() {
		return new PaymentReviewPage();
	}

	public TransactionsPage transactionsPage() {
		return new TransactionsPage();
	}

	// Admin 2.5 ------------------------------------------------------------------------
	
	
	private By lblMerchantService = By.xpath("//span[text()='Merchant Services']");
	private By lblPayments=By.xpath("//p[text()='Payments']");

	public void clickMerchantService() {
		click(lblMerchantService, "MerchantService");
	}

	public AddBusinessComponent addBusinessComponent() {
		return new AddBusinessComponent();
	}
	public By getSideBarItemsForPayments(String elementName) {
		return By.xpath(String.format(
				"//span[text()='%s']",
				elementName));
	}
	

	public void clickPayments() throws InterruptedException {
		commonFunctions.verifyCursorAction(lblPayments, "Payments");
		click(lblPayments, "Payments");
		Thread.sleep(4000);
	}
	public void clickBusinessProfile() throws InterruptedException {
		commonFunctions.verifyCursorAction(getSideBarItemsForPayments("Business Profiles"), "Business Profiles");
		click(getSideBarItemsForPayments("Business Profiles"), "Business Profiles");
		Thread.sleep(4000);
	}


}
