package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.merchant.pages.AccountLimitsPage;
import coyni.merchant.pages.AgreementsPage;
import coyni.merchant.pages.ApiKeysPage;
import coyni.merchant.pages.BeneficiaryOwnersPage;
import coyni.merchant.pages.CompanyInformationPage;
import coyni.merchant.pages.DBAInformationPage;
import coyni.merchant.pages.FeesPage;
import coyni.merchant.pages.PaymentMethodsPage;
import coyni.merchant.pages.PreferencesPage;
import coyni.merchant.pages.TeamSharedPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantSettingsSideBarMenuComponent extends BrowserFunctions {

	private By lblMerchantSettings = By.xpath("(//span[text()='Merchant Settings'])[1]");
//	private By lblAccountStatus = By.xpath("//div[text()='Account Status:']");
	private By btnBeneficialOwners = By.xpath("//span[text()='Beneficiary Owner(s)']");
//	private By lblActive = By.xpath("//div[.='Active']");
	private By lblUserName = By.xpath("//div[@class='px-3 lg:px-1']/div[1]/div[2]/div[1]");
	private By lblAccountId = By.xpath("//div[@class='px-3 lg:px-1']/div[1]/div[2]/div[2]");
	private By lblAccountStatus = By.xpath("//div[text()='Account Status:']");
	private By getAccountStatus = By.xpath("//div[@class='px-3 lg:px-1']/div[2]/div[1]/div[1]");

	private By getSideMenuBarItems(String btnNumber) {
		return By.xpath(String.format("//button[@type='button']/span[.='%s']", btnNumber));
	}

	public void verifyUserName() {
		new CommonFunctions().elementView(lblUserName, "User Name");
	}

	public void verifyAccountId() {
		new CommonFunctions().elementView(lblAccountId, "Account-ID");
	}

	public void clickMerchantSettings() {
		click(lblMerchantSettings, "Merchant Settings");
	}

	public void verifyLblAccountStatus() {
		new CommonFunctions().elementView(lblAccountStatus, "Label Account Status");
	}

	public void verifyAccountStatus() {
		new CommonFunctions().elementView(getAccountStatus, "accountStatus");
	}

	public void clickBeneficiaryOwnerBtn() {
		click(btnBeneficialOwners, "Beneficial Owners");
		// click(getSideMenuBarItems("Beneficiary Owner(s)"), "Beneficiary Owner");
	}

	public void clickCompanyInformationBtn() {
		click(getSideMenuBarItems("Company Information"), "Company Information");
	}

	public void verifyCompanyInformationBtn() {
		new CommonFunctions().elementView(getSideMenuBarItems("Company Information"), "Company Information");
	}

	public void clickDBAinformationBtn() {
		click(getSideMenuBarItems("DBA Information"), "DBA Infromation");
	}

	public void verifyDBAInformationBtn() {
		new CommonFunctions().elementView(getSideMenuBarItems("DBA Information"), "DBA Infromation");
	}

	public void verifyBeneficiaryOwnersBtn() {
		new CommonFunctions().elementView(getSideMenuBarItems("Beneficiary Owner(s)"), "Beneficiary Owner");
	}

	public void clickPaymentMethodsBtn() {
		click(getSideMenuBarItems("Payment Methods"), "Payment Methods");
	}

	public void verifyPaymentMethodsBtn() {
		new CommonFunctions().elementView(getSideMenuBarItems("Payment Methods"), "Payment Methods");
	}

	public void clickPreferencesBtn() {
		click(getSideMenuBarItems("Preferences"), "Preferences");
	}

	public void verifyPreferencesBtn() {
		new CommonFunctions().elementView(getSideMenuBarItems("Preferences"), "Preferences");
	}

	public void clickAgreementsBtn() {
		click(getSideMenuBarItems("Agreements"), "Agreements");
	}

	public void verifyAgreementsBtn() {
		new CommonFunctions().elementView(getSideMenuBarItems("Agreements"), "Agreements");
	}

	public void clickFeesBtn() {
		click(getSideMenuBarItems("Fees"), "Fees");
	}

	public void verifyFeesBtn() {
		new CommonFunctions().elementView(getSideMenuBarItems("Fees"), "Fees");
	}

	public void clickAccountLimitsBtn() {
		click(getSideMenuBarItems("Account Limits"), "Account Limits");
	}

	public void verifyAccountLimitsBtn() {
		new CommonFunctions().elementView(getSideMenuBarItems("Account Limits"), "Account Limits");
	}

	public void clickTeamSharedBtn() {
		click(getSideMenuBarItems("Team (Shared)"), "Team");
	}

	public void verifyTeamSharedBtn() {
		new CommonFunctions().elementView(getSideMenuBarItems("Team (Shared)"), "Team");
	}

	public void clickApiKeyBtn() {
		click(getSideMenuBarItems("API Keys"), "Api Key");
	}

	public void verifyApiKeyBtn() {
		scrollToElement(getSideMenuBarItems("API Keys"), "API Keys");
		new CommonFunctions().elementView(getSideMenuBarItems("API Keys"), "Api Key");
	}

	public PaymentMethodComponent paymentMethodComponent() {
		return new PaymentMethodComponent();
	}

//	public void verifyIdInformation(String Idinformation) {
//		new CommonFunctions().verifyLabelText(lblIdInformation, Idinformation, "Idinformation");
//	}
//
//	public void verifyAccountStatus(String AccountStatus) {
//		new CommonFunctions().verifyLabelText(lblAccountStatus, AccountStatus, "AccountStatus");
//	}

//	public AgreementsComponent agreementsComponent() {
//		return new AgreementsComponent();
//	}

	public TeamComponent teamComponent() {
		return new TeamComponent();
	}

	public AddTeamMemberComponent addTeamMemberComponent() {
		return new AddTeamMemberComponent();
	}

	public APIKeyComponent apiKeyComponent() {
		return new APIKeyComponent();
	}

	public CompanyInformationPage companyInformationPage() {
		return new CompanyInformationPage();
	}

	public DBAInformationPage dbaInformationPage() {
		return new DBAInformationPage();
	}

	public BeneficiaryOwnersPage beneficiaryOwnersPage() {
		return new BeneficiaryOwnersPage();
	}

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}

	public PreferencesPage preferencesPage() {
		return new PreferencesPage();
	}

	public AgreementsPage agreementsPage() {
		return new AgreementsPage();
	}

	public FeesPage feesPage() {
		return new FeesPage();
	}

	public AccountLimitsPage accountLimitsPage() {
		return new AccountLimitsPage();
	}

	public TeamSharedPage teamSharedPage() {
		return new TeamSharedPage();
	}

	public ApiKeysPage apiKeysPage() {
		return new ApiKeysPage();
	}
}
