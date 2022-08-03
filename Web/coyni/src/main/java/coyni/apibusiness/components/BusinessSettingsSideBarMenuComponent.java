package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.api.business.popups.SecretKeyPopup;
import coyni.apibusiness.pages.AccountLimitsPage;
import coyni.apibusiness.pages.FeesPage;
import coyni.apibusiness.pages.PreferencesPage;
import coyni.apibusiness.pages.RegistrationDBAInformationPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessSettingsSideBarMenuComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Business Settings']");
	private By lblApplication = By.xpath("//span[.='Application ']");
	private By lblIdInformation = By.cssSelector("div[class*='flex flex-col text-xs lg:flex-row text-cgy2 lg:gap-1']");
	private By lblAccountStatus = By.xpath("//div[text()='Account Status:']");
	private By lblActive = By.xpath("//div[.='Active']");

	private By getSideMenuBarItems(String btnNumber) {
		return By.cssSelector(String.format(
				"div[class*='BusinessSettings_container']>div:nth-of-type(1)>div:nth-of-type(2)>a:nth-of-type(%s)",
				btnNumber));
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

	public void clickIpAddresses() {
		click(getSideMenuBarItems("10"), "Ip Addresses");
	}

	public void verifyIpAddressesView() {
		new CommonFunctions().elementView(getSideMenuBarItems("10"), "Ip Addresses");
	}

	public void clickApiKey() {
		click(getSideMenuBarItems("11"), "Api Key");
	}

	public void verifyApiKeyView() {
		new CommonFunctions().elementView(getSideMenuBarItems("11"), "Api Key");
	}

	public void clickWebhooks() {
		click(getSideMenuBarItems("12"), "Webhooks");
	}

	public void verifyWebHooksView() {
		new CommonFunctions().elementView(getSideMenuBarItems("12"), "Webhooks");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyApplication(String Application) {
		new CommonFunctions().verifyLabelText(lblApplication, Application, "Application");
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

	public PreferencesPage preferencesPage() {
		return new PreferencesPage();
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

	public IPAddressComponent ipAddressComponent() {
		return new IPAddressComponent();
	}

	public RegistrationDBAInformationPage registrationDBAInformationPage() {
		return new RegistrationDBAInformationPage();
	}

	public WebhookComponent webhookComponent() {
		return new WebhookComponent();
	}
	public FeesPage feesPage() {
		return new FeesPage();
	}
	public AccountLimitsPage accountLimitsPage() {
		return new AccountLimitsPage();
	}

	

}
