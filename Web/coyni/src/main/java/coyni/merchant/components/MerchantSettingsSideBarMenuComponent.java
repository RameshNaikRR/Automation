package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.merchant.pages.AgreementsPage;
import coyni.merchant.pages.PaymentMethodPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantSettingsSideBarMenuComponent extends BrowserFunctions {

	private By lblMerchantSettings = By.xpath("(//span[text()='Merchant Settings'])[1]");
//	private By lblAccountStatus = By.xpath("//div[text()='Account Status:']");
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

	public void clickMerchantSettings() {
		click(lblMerchantSettings, "Merchant Settings");
	}

	public void verifyAccountId() {
		new CommonFunctions().elementView(lblAccountId, "Account-ID");
	}

	public void verifyLblAccountStatus() {
		new CommonFunctions().elementView(lblAccountStatus, "Label Account Status");
	}

	public void verifyAccountStatus() {
		new CommonFunctions().elementView(getAccountStatus, "accountStatus");
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

	public void clickBeneficiaryOwnerBtn() {
		click(getSideMenuBarItems("Beneficiary Owner(s)"), "Beneficiary Owner");
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

	public PaymentMethodPage paymentMethodPage() {
		return new PaymentMethodPage();
	}

//	public void verifyIdInformation(String Idinformation) {
//		new CommonFunctions().verifyLabelText(lblIdInformation, Idinformation, "Idinformation");
//	}
//
//	public void verifyAccountStatus(String AccountStatus) {
//		new CommonFunctions().verifyLabelText(lblAccountStatus, AccountStatus, "AccountStatus");
//	}

	public AgreementsPage agreementsComponent() {
		return new AgreementsPage();
	}

	public TeamComponent teamComponent() {
		return new TeamComponent();
	}

	public AddTeamMemberComponent addTeamMemberComponent() {
		return new AddTeamMemberComponent();
	}

	public APIKeyComponent apiKeyComponent() {
		return new APIKeyComponent();
	}

}
