package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.AccountLimitsComponent;
import coyni_mobile_merchant.components.AgreementComponent;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.components.FeesComponent;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.components.PreferencesComponent;
import coyni_mobile_merchant.popups.SetUpTouchIDPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class MerchantProfilePage extends MobileFunctions {
	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'b_nameTV')]");
	private By lblAccountID = MobileBy.xpath("//*[contains(@resource-id,'b_accountIDTV')]");
	private By lblAccountStatus = MobileBy.xpath("//*[contains(@text,'Under Review')]|//*[contains(@resource-id,'AccountStatusTV')]");
	private By imgQRCode = MobileBy.xpath("//*[contains(@resource-id,'imgQRCode')]");
	private By imgUser = MobileBy.xpath("");
	private By lblSettings = MobileBy.xpath("//*[contains(@resource-id,'userSettingsTV')]");
	private By lnkUserDetails = MobileBy.xpath("//*[contains(@resource-id,'business_UserDetailsLL')]");
	private By lnkCompanyInformation = MobileBy.xpath("//*[contains(@resource-id,'companyInformationLL')]");
	private By lnkDBAInformation = MobileBy.xpath("//*[contains(@resource-id,'DBAInformationLL')]");
	private By lnkTeam = MobileBy.xpath("//*[contains(@resource-id,'teamLL')]");
	private By lnkPaymentMethods = MobileBy.xpath("//*[contains(@resource-id,'paymentMethodsLL')]");
	private By lnkPreferences = MobileBy.xpath("//*[contains(@resource-id,'PreferencesLL')]");
	private By lnkFees = MobileBy.xpath("//*[contains(@resource-id,'feesLL')]");
	private By lnkAccountLimits = MobileBy.xpath("//*[contains(@resource-id,'cpAccountLimitsLL')]");
	private By lnkAgreements = MobileBy.xpath("//*[contains(@resource-id,'cpAgreementsLL')]");
	private By lnkResetPinCode = MobileBy.xpath("//*[contains(@resource-id,'businessResetPin')]");
	private By btnFaceIDSetting = MobileBy.xpath("//*[contains(@resource-id,'b_tvBMSetting')]");
	private By btnToggle = MobileBy.xpath("//*[contains(@resource-id,'switchOff')]");
	private By btnChangePassword = MobileBy.xpath("//*[contains(@text,'Change Password')]");
	private By btnLogOut = MobileBy.xpath(
			"//*[contains(@resource-id,'EmailLogoutCV')]|//*[contains(@resource-id,'btnCV')]|//*[contains(@resource-id,'Logout')]");
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'b_nameTV')]");
	private By lblAccId = MobileBy.xpath("//*[contains(@resource-id,'b_accountIDTV')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'back')]");
	private By btnInformation = MobileBy.xpath("//*[contains(@text,'Information')]");
	private By btnGetHelp = MobileBy.xpath("//*[contains(@text,'Get Help')]");
	
	
WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), 30);
	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("//*[contains(@resource-id,'profileSV')]//*[contains(@text,'%s')]", eleName));
	}

	public void clickTogggle() {
		scrollDownToElement(btnFaceIDSetting, "FaceID Setting");
		click(btnToggle, "Toggle");
	}

	public void verifyResetPinCodeView() {
		scrollDownToElement(lnkResetPinCode, "Resetpin");
		new CommonFunctions().elementView(lnkResetPinCode, "Resent pin code");
	}

	public void verifyUserProfile() {
		new CommonFunctions().elementView(lblUserName, "User Name");
		new CommonFunctions().elementView(lblAccountID, "Account ID");
		new CommonFunctions().elementView(lblAccountStatus, "Account Status");
	}
	
	public void clickImg() {
		click(imgUser, "Click Image");
	}

	public void verifyUserName(String expUserName) {
		new CommonFunctions().verifyLabelText(lblUserName, "User Name", expUserName);
	}

	public void verifyAccountID(String expAccountID) {
		new CommonFunctions().verifyLabelText(lblAccountID, "Account ID", expAccountID);
	}

	public void verifyAccountStatus(String expStatus) {
		new CommonFunctions().verifyLabelText(lblAccountStatus, "Account Status", expStatus);
	}

	public void verifyPreferencesView() {
		new CommonFunctions().elementView(lnkPreferences, "Preferences");
	}

	public void verifyAccountLimitsView() {
		new CommonFunctions().elementView(lnkAccountLimits, "Account Limits");
	}

	public void verifyAgreementsView() {
		new CommonFunctions().elementView(lnkAgreements, "Agreements");
	}

	public void clickResetPinCode() {
		scrollDownToElement(btnLogOut, "Log out");
		click(lnkResetPinCode, "Reset Pin Code");
	}

	public void verifyAcccountStatus() {
		if (getText(lblAccountStatus).equalsIgnoreCase("Active")) {
			ExtentTestManager.setPassMessageInReport(getText(lblAccountStatus));
		} else {
			ExtentTestManager.setFailMessageInReport(" Account is in Under Review or Not Active Status. So we can't perform Token actions");
		}
	}
	
	public void clickFaceIDSetting() {
		click(btnFaceIDSetting, "FaceID Setting");
	}

	public void verifyLogOut() {
		scrollDownToElement(btnLogOut, "Log out");
		new CommonFunctions().elementView(btnLogOut, "Log Out");
	}

	public void clickQRImage() {
		click(imgQRCode, "Click QR Code ");
	}

	public void verifyQRImageView() {
		new CommonFunctions().elementView(imgQRCode, "QR Code");
	}

	public void verifyProfilePageView() {
		new CommonFunctions().elementView(lblSettings, "Profile Page");
	}

	public void verifyUserDetailsView() {
		new CommonFunctions().elementView(lnkUserDetails, "User Details");
	}

	public void verifyUserNameView() {
		new CommonFunctions().elementView(lblUserName, "UserName");
	}

	public void verifyImageUserView() {
		new CommonFunctions().elementView(imgUser, "Image User Initials ");
	}

	public void verifyAccountIDView() {
		new CommonFunctions().elementView(lblAccountID, "Account ID ");
	}

	public void verifyAccountStatusView() {
		new CommonFunctions().elementView(lblAccountStatus, "Account ID ");
	}

	public void getAccountDetails() {
		String str = getText(lblHeading);
		ExtentTestManager.setInfoMessageInReport("User Name is : " + str);
	}

	public void getAccountId() {
		new CommonFunctions().elementView(lblAccId, "Merchant Account ID");
		String str = getText(lblAccId);
		ExtentTestManager.setInfoMessageInReport("Merchant Account ID :" + str);
	}

	public void clickUserDetails() {
		click(lnkUserDetails, "User Details");
	}

	public void clickCompanyInformation() {
		click(lnkCompanyInformation, "Company Information");
	}

	public int verifyInformation() {
//		scrollDownToElement(btnInformation, "Next")

		int a = DriverFactory.getDriver().findElements(btnInformation).size();
		ExtentTestManager.setInfoMessageInReport("elements" + a);
		return a;

	}

	public void clickDBAInformation() {
		click(lnkDBAInformation, "DBA Information");
	}

	public void clickBeneficialOwners() {
//		scrollDownToElement(getDashBoardItems("Beneficial Owners"), "Beneficial Owners");
		click(getDashBoardItems("Beneficial Owners"), "Beneficial Owners");
	}

	public void clickTeam() {
		scrollDownToElement(lnkTeam, "Team");
		click(lnkTeam, "Team");
	}

	public void clickPaymentMethods() {
		scrollDownToElement(lnkPaymentMethods, "Payment Methods");
		click(lnkPaymentMethods, "Payment Methods");
	}

	public void clickPreferences() {
		scrollDownToElement(lnkPreferences, "Preferences");
		click(lnkPreferences, "Preferences");
	}

	public void clickFees() {
		scrollDownToElement(lnkFees, "Fees");
		click(lnkFees, "Fees");
	}

	public void clickAccountLimits() {
		scrollDownToElement(lnkAccountLimits, "Account Limits");
		click(lnkAccountLimits, "Account Limits");
	}

	public void clickAgreements() {
		scrollDownToElement(lnkAgreements, "Agreements");
		click(lnkAgreements, "Agreements");
	}

	public void clickResetPINCode() {
		scrollDownToElement(lnkResetPinCode, "Reset PIN Code");
		click(lnkResetPinCode, "Reset Pin");
	}

	public void clickTouchIDSetting() {
		scrollDownToElement(btnFaceIDSetting, "Touch ID Setting");
		click(btnFaceIDSetting, "Touch ID Setting");
	}

	public void clickChangePassword() {
		scrollDownToElement(btnLogOut, "Log Out");
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(btnChangePassword));
		click(btnChangePassword, "Change Password");
	}

	public void clickGetHelp() {
		scrollDownToElement(btnGetHelp, "Get Help");
		click(btnGetHelp, "Get Help");
	}
	
	public void clickLogOut() {
		scrollDownToElement(btnLogOut, "Log Out");
		click(btnLogOut, "Log Out");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public UserDetailsPage userDetailsPage() {
		return new UserDetailsPage();
	}

	public DBAInformationPage dbaInformationPage() {
		return new DBAInformationPage();
	}

	public CompanyInformationPage companyInformationPage() {
		return new CompanyInformationPage();
	}

	public BenificialOwnersPage benificialOwnersPage() {
		return new BenificialOwnersPage();
	}

	public ConfirmPasswordPage confirmPasswordPage() {
		return new ConfirmPasswordPage();
	}

	public TeamPage teamPage() {
		return new TeamPage();
	}

	public LandingPage landingPage() {
		return new LandingPage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public AccountLimitsComponent accountLimitsComponent() {
		return new AccountLimitsComponent();
	}

	public PreferencesComponent preferencesComponent() {
		return new PreferencesComponent();
	}

	public AgreementComponent agreementComponent() {
		return new AgreementComponent();
	}

	public FeesComponent feesComponent() {
		return new FeesComponent();
	}

	public SetUpTouchIDPopup setUpTouchIDPopup() {
		return new SetUpTouchIDPopup();
	}

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}
	
	public GetHelpPage getHelpPage() {
		return new GetHelpPage();
	}

}
