package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.AccountLimitsComponent;
import coyni_mobile_merchant.components.AgreementComponent;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.components.FeesComponent;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.components.PreferencesComponent;
import coyni_mobile_merchant.popups.TokenMenuIconPopUp;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class MerchantProfilePage extends MobileFunctions {
//	private By btnUserDetails = MobileBy.xpath("//*[contains(@resource-id,'business_UserDetailsLL')]");
//	private By btnChangePassword = MobileBy.xpath("//*[contains(@resource-id,'b_cpChangePassword')]");
//	private By btnResetPinCode = MobileBy.xpath("//*[contains(@resource-id,'businessResetPin')]");
//	
	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'b_nameTV')]");
	private By lblAccountID = MobileBy.xpath("//*[contains(@resource-id,'b_accountIDTV')]");
	private By lblAccountStatus = MobileBy.xpath("//*[contains(@resource-id,'AccountStatusTV')]");
	private By imgQRCode = MobileBy.xpath("//*[contains(@resource-id,'imgQRCode')]");
	private By imgUser = MobileBy.xpath("");
	private By lblSettings = MobileBy.xpath("//*[contains(@resource-id,'userSettingsTV')]");
	private By lnkUserDetails = MobileBy.xpath("//*[contains(@resource-id,'business_UserDetailsLL')]");
	private By lblMerchantSettings = MobileBy.xpath("//*[contains(@resource-id,'settingTV')]");
	private By lnkCompanyInformation = MobileBy.xpath("//*[contains(@resource-id,'companyInformationLL')]");
	private By lnkDBAInformation = MobileBy.xpath("//*[contains(@resource-id,'DBAInformationLL')]");
	private By lnkBeneficialOwners = MobileBy.xpath("//*[contains(@resource-id,'beneficialOwnersLL')]");
	private By lnkTeam = MobileBy.xpath("//*[contains(@resource-id,'teamLL')]");
	private By lnkPaymentMethods = MobileBy.xpath("//*[contains(@resource-id,'paymentMethodsLL')]");
	private By lnkPreferences = MobileBy.xpath("//*[contains(@resource-id,'PreferencesLL')]");
	private By lnkFees = MobileBy.xpath("//*[contains(@resource-id,'feesLL')]");
	private By lblAccount = MobileBy.xpath("");
	private By lnkAccountLimits = MobileBy.xpath("//*[contains(@resource-id,'cpAccountLimitsLL')]");
	private By lnkAgreements = MobileBy.xpath("//*[contains(@resource-id,'cpAgreementsLL')]");
	private By lblSecurity = MobileBy.xpath("//*[contains(@resource-id,'securityTV')]");
	private By lnkResetPinCode = MobileBy.xpath("//*[contains(@resource-id,'businessResetPin')]");
	private By btnFaceIDSetting = MobileBy.xpath("//*[contains(@resource-id,'b_tvBMSetting')]");
	private By btnToggle = MobileBy.xpath("//*[contains(@resource-id,'switchOff')]");
	private By btnChangePassword = MobileBy.xpath("//*[contains(@resource-id,'b_cpChangePassword')]");
	private By btnLogOut = MobileBy.xpath("//*[contains(@resource-id,'EmailLogoutCV')]|//*[contains(@resource-id,'btnCV')]|//*[contains(@resource-id,'Logout')]");

	// text
	private By btnScan = MobileBy.xpath("//*[@text='Scan']");
	private By btnReceivePayment = MobileBy.xpath("//*[@text='Receive Payment']");
	private By btnBuyToken = MobileBy.xpath("//*[@text='Buy Tokens']");//
	private By btnWithdrawToUSD = MobileBy.xpath("//*[@text='Withdraw Tokens']");//
	
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'b_nameTV')]");
	private By lblAccId = MobileBy.xpath("//*[contains(@resource-id,'b_accountIDTV')]");

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format(
				"//*[contains(@resource-id,'com.greenbox.coyni:id/profileSV')]//*[contains(@text,'%s')]", eleName));
	}

	public void viewScan() {
		new CommonFunctions().elementView(btnScan, "View Scan");
	}

	public void clickScan() {
		click(btnScan, "Scan");
	}

	public void clickTogggle() {
		scrollDownToElement(btnFaceIDSetting, "FaceID Setting");
		click(btnToggle, "Toggle");
	}

	public void viewReceivePayment() {
		new CommonFunctions().elementView(btnReceivePayment, "Receive");
	}

	public void clickReceivePayment() {
		click(btnReceivePayment, "Pay Request");
	}

	public void viewBuyToken() {
		new CommonFunctions().elementView(btnBuyToken, "Buy Token");
	}

	public void viewWithdrawnToUSD() {
		new CommonFunctions().elementView(btnWithdrawToUSD, "Withdrawn To USD");
	}

	public void verifyResetPinCodeView() {
		scrollDownToElement(lnkResetPinCode, "Resetpin");
		new CommonFunctions().elementView(lnkResetPinCode, "Resent pin code");
	}

	public void clickImg() {
		click(imgUser, "Click Image");
	}

//	private void minimizePopup() {
//		if (DriverFactory.getDriver().findElement(lblUserName).isDisplayed()) {
//			ExtentTestManager.setPassMessageInReport("Invalid credentials error popup closed");
//		} else {
//			ExtentTestManager.setFailMessageInReport("Invalid credentilas error popup not closed");
//		}
//	}

//	public void clickOutside() {
//		new CommonFunctions().clickOutSideElement();
//	}
//
//	public void minimizePopupBySwipeDown() {
//		swipeOnElement(popUp, "popUp", SwipeDirection.DOWN);
//		minimizePopup();
//
//	}

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
		click(lnkResetPinCode, "Reset Pin Code");
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
//
//	public TokenHomePopUp tokenHomePopUp() {
//		return new TokenHomePopUp();
//	}
//
//	public SetUpTouchIDPopup setUpTouchIDPopup() {
//		return new SetUpTouchIDPopup();
//	}

	public FeesComponent feesComponent() {
		return new FeesComponent();
	}

	public void verifySecurityHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSecurity, "Security Heading", expHeading);
	}

	public void verifyUserSettingsHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblUserName, "User Settings", expHeading);
	}

	public void verifyMerchantSettingsHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMerchantSettings, "Merchant’s Settings", expHeading);
	}

	public void getAccountDetails() {
		String str = getText(lblHeading);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getAccountId() {
		String str = getText(lblAccId);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickUserDetails() {
		click(lnkUserDetails, "User Details");
	}

	public void clickCompanyInformation() {
		click(lnkCompanyInformation, "Company Information");
	}

	public void clickDBAInformation() {
		click(lnkDBAInformation, "DBA Information");
	}

	public void clickBeneficialOwners() {
		scrollDownToElement(getDashBoardItems("Beneficial Owners"), "Beneficial Owners");
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
		scrollDownToElement(btnChangePassword, "Change Password");
		click(btnChangePassword, "Change Password");
	}

	public void clickLogOut() {
		scrollDownToElement(btnLogOut, "Log Out");
		click(btnLogOut, "Log Out");
	}

//	public void clickUserDetails() {
//		click(btnUserDetails, "User Details");
//	}
//
//	public void clickChangePassword() {
//		scrollDownToElement(btnChangePassword, "Change Password");
//		click(btnChangePassword, "Change Password");
//	}
//
//	public void clickResetPinCode() {
//		scrollDownToElement(btnResetPinCode, "Reset Pin Code");
//		click(btnResetPinCode, "Reset Pin Code");
//	}

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

	public TokenMenuIconPopUp tokenMenuIconPopUp() {
		return new TokenMenuIconPopUp();
	}

	public LandingPage landingPage() {
		return new LandingPage();
	}

}
