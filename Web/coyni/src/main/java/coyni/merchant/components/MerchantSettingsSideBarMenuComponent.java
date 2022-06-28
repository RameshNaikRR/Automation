package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantSettingsSideBarMenuComponent extends BrowserFunctions {

	private By lblMerchantSettings = By.xpath("(//span[text()='Merchant Settings'])[1]");
	private By lblAccountStatus = By.xpath("//div[text()='Account Status:']");
	private By lblActive = By.xpath("//div[.='Active']");

	private By getSideMenuBarItems(String btnNumber) {
		return By.xpath(String.format("//button[@type='button']/span[.='%s']", btnNumber));
	}

	private By getAccountInfo(String eleName) {
		return By.xpath(String.format("(//div[@class='px-3 lg:px-1']//div//div)['%s']", eleName));
	}

	public void verifyUserImageView() {
		new CommonFunctions().elementView(getAccountInfo("1"), "User Image");
	}

	public void verifyAccountIdView() {
		new CommonFunctions().elementView(getAccountInfo("5"), "Account-ID");
	}

	public void getAccountStatus(String accountStatus) {
		enterText(getAccountInfo("8"), accountStatus, "accountStatus");
	}

	public void getAccountId(String accountID) {
		enterText(getAccountInfo("6"), accountID, "account ID");
	}

	public void clickCompanyInformation() {
		click(getSideMenuBarItems("1"), "Company Information");
	}

	public void verifyCompanyInformationView() {
		new CommonFunctions().elementView(getSideMenuBarItems("1"), "Company Information");
	}

	public void clickDBAinformation() {
		click(getSideMenuBarItems("2"), "DBA Infromation");
	}

	public void verifyDBAInformationView() {
		new CommonFunctions().elementView(getSideMenuBarItems("2"), "DBA Infromation");
	}

	public void clickBeneficiaryOwner() {
		click(getSideMenuBarItems("3"), "Beneficiary Owner");
	}

	public void verifyBeneficiaryOwnersView() {
		new CommonFunctions().elementView(getSideMenuBarItems("3"), "Beneficiary Owner");
	}

	public void clickPaymentMethods() {
		click(getSideMenuBarItems("4"), "Payment Methods");
	}

	public void verifyPaymentMethodsView() {
		new CommonFunctions().elementView(getSideMenuBarItems("4"), "Payment Methods");
	}

	public void clickPreferences() {
		click(getSideMenuBarItems("5"), "Preferences");
	}

	public void verifyPreferencesView() {
		new CommonFunctions().elementView(getSideMenuBarItems("5"), "Preferences");
	}

	public void clickAgreements() {
		click(getSideMenuBarItems("6"), "Agreements");
	}

	public void verifyAgreementsView() {
		new CommonFunctions().elementView(getSideMenuBarItems("6"), "Agreements");
	}

	public void clickFees() {
		click(getSideMenuBarItems("7"), "Fees");
	}

	public void verifyFeesView() {
		new CommonFunctions().elementView(getSideMenuBarItems("7"), "Fees");
	}

	public void clickAccountLimits() {
		click(getSideMenuBarItems("8"), "Account Limits");
	}

	public void verifyAccountLimitsView() {
		new CommonFunctions().elementView(getSideMenuBarItems("8"), "Account Limits");
	}

	public void clickTeam() {
		click(getSideMenuBarItems("9"), "Team");
	}

	public void verifyTeamView() {
		new CommonFunctions().elementView(getSideMenuBarItems("9"), "Team");
	}

	public void clickApiKey() {
		click(getSideMenuBarItems("10"), "Api Key");
	}

	public void verifyApiKeyView() {
		new CommonFunctions().elementView(getSideMenuBarItems("10"), "Api Key");
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
	public void verifyAccountStatusView() {
		new CommonFunctions().elementView(lblAccountStatus, "Account Status");
	}

	public void verifyAccountStatus(String accountStatus) {
		new CommonFunctions().verifyLabelText(lblActive, accountStatus, "Account status");
	}

	public PreferencesComponent preferencesComponent() {
		return new PreferencesComponent();
	}

	public AgreementsComponent agreementsComponent() {
		return new AgreementsComponent();
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
