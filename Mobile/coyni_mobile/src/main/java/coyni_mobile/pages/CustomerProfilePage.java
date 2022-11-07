package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.AccountLimitsComponent;
import coyni_mobile.components.AgreementComponent;
import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.PreferencesComponent;
import coyni_mobile.components.ToastComponent;
import coyni_mobile.components.TokenHomePopUp;
import coyni_mobile.popups.SetUpTouchIDPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CustomerProfilePage extends MobileFunctions {
	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'customerNameTV')]");
	private By lblAccountID = MobileBy.xpath("//*[contains(@resource-id,'cpAccountIDTV')]");
	private By lblAccountStatus = MobileBy.xpath("//*[contains(@resource-id,'tvACStatus')]");
	private By imgQRCode = MobileBy.xpath("//*[contains(@resource-id,'imgQRCode')]");
	private By imgUser = MobileBy.xpath("//*[contains(@resource-id,'imageTextTV')]");
	private By lblSettings = MobileBy.xpath("//*[contains(@text,'Settings')]");
	private By lnkUserDetails = MobileBy.xpath("//*[contains(@resource-id,'cpUserDetailsLL')]");
	private By lnkPaymentMethods = MobileBy.xpath("//*[contains(@resource-id,'cpPaymentMethodsLL')]");
	private By lnkPreferences = MobileBy.xpath("//*[contains(@resource-id,'pPreferencesLL')]");
	private By lblAccount = MobileBy.xpath("//*[contains(@resource-id,'accountTV')]");
	private By lnkAccountLimits = MobileBy.xpath("//*[contains(@resource-id,'pAccountLimitsLL')]");
	private By lnkAgreements = MobileBy.xpath("//*[contains(@resource-id,'cpAgreementsLL')]");
	private By lblSecurity = MobileBy.xpath("//*[contains(@resource-id,'securityTV')]");
	private By lnkResetPinCode = MobileBy.xpath("//*[contains(@resource-id,'cpResetPin')]");
	private By btnFaceIDSetting = MobileBy.xpath("//*[contains(@resource-id,'tvBMSetting')]");
	private By btnToggle = MobileBy.xpath("//*[contains(@resource-id,'switchOff')]");
	private By btnChangePassword = MobileBy.xpath("//*[contains(@resource-id,'cpChangePassword')]");
	private By btnLogOut = MobileBy.xpath("//*[contains(@resource-id,'cvLogout')]");

	private By lblMyQRCodeHeading = MobileBy.xpath("//*[@text='My QR Code']");
	private By qrCode = MobileBy.xpath("//*[contains(@resource-id,'idIVQrcode')]");
	private By btnShare = MobileBy.xpath("//*[contains(@resource-id,'imgShare')]");
	private By sharepopup = MobileBy.xpath("//*[@text='Share']");
	private By lblCopyMessage = MobileBy.xpath("//*[contains(@resource-id,'imgCopy')]");
	private By lblAvaliableBalance = MobileBy.xpath("//*[contains(@resource-id,'tvBalHead')]");// tvBalance
	private By viewPayRequestButton = MobileBy.xpath("//*[contains(@resource-id,'cvPayRequest')]");// cvPayRequest
	private By lblRecentTransaction = MobileBy.xpath("//*[contains(@text,'Recent Transactions')]");// Recent
																									// Transactions
	private By lblFirstAndLastName = MobileBy.xpath("//*[contains(@resource-id,'tvUserInfo')]");
	private By lblContact = MobileBy.xpath("//*[contains(@text,'Recent Contacts')]");// Recent Contacts

	private By viewDashboard = MobileBy.xpath("//*[contains(@text,'Dashboard')]");
	private By viewCrypto = MobileBy.xpath("//*[contains(@resource-id,'layoutCrypto')]");// layoutCrypto
	private By viewIssueCard = MobileBy.xpath("//*[contains(@resource-id,'layoutCard')]");// layoutCard
	private By viewProfile = MobileBy.xpath("//*[contains(@resource-id,'layoutProfile')]");// layoutProfile
	private By viewTokenMenu = MobileBy.xpath("//*[contains(@resource-id,'layoutMainMenu')]");// layoutMainMenu
	private By lblCryptoAssets = MobileBy.xpath("//*[@text='Crypto Assets Coming Soon…']");// Crypto Assets //
																							// Coming Soon
	// text
	private By lblIssueCard = MobileBy.xpath("//*[@text='Issuing Card Coming Soon…']");
	private By btnScan = MobileBy.xpath("//*[contains(@text,'scanLL')]");
	private By btnPayRequest = MobileBy.xpath("//*[contains(@text,'Pay/Request')]");// Pay/Request
	private By btnBuyToken = MobileBy.xpath("//*[contains(@text,'Buy Tokens')]");// Buy Tokens
	private By btnWithdrawToUSD = MobileBy.xpath("//*[contains(@text,'Withdraw to USD')]");// Withdraw to USD
	private By popUp = MobileBy.xpath("");
	private By btnGetHelp = MobileBy.xpath("//*[contains(@text,'Get Help')]");
	private By btnViewMore = MobileBy.xpath("//*[contains(@text,'View More')]");

	public void clickViewMore() {
		scrollDownToElement(btnViewMore, "View More");
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

	public void viewPayRequest() {
		new CommonFunctions().elementView(btnPayRequest, "Request");
	}

	public void verifyAvailableBalance() {
		new CommonFunctions().elementView(lblAvaliableBalance, "Available Balance");
	}

	public void verifyAvaliableBlc(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAvaliableBalance, "Avaliable Balance", expHeading);
	}

	public void viewPayRequestMenu() {
		new CommonFunctions().elementView(viewPayRequestButton, "Pay Request");
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

	public void clickPayRequest() {
		click(viewPayRequestButton, "Pay Request");
	}

	public void verifyRecentTransaction(String expHeading) {
		new CommonFunctions().verifyLabelText(lblRecentTransaction, "Recent Transaction", expHeading);
	}

	public void clickImg() {
		click(imgUser, "Click Image");
	}

	public void verifyFirstAndLastName(String firstAndLastName) {
		new CommonFunctions().verifyLabelText(lblFirstAndLastName, "First and Last Name", firstAndLastName);
	}

	public void verifyContactContent(String expHeading) {
		new CommonFunctions().verifyLabelText(lblContact, "Contact Heading", expHeading);
	}

	public void viewDashboard() {
		new CommonFunctions().elementView(viewDashboard, "Dashboard");
	}

	public void viewCrypto() {
		new CommonFunctions().elementView(viewCrypto, "Crypto");
	}

	public void clickIssueCard() {
		click(viewIssueCard, "Issue Card");
	}

	public void viewIssueCard() {
		new CommonFunctions().elementView(viewIssueCard, "Issue Card");
	}

	public void viewProfile() {
		new CommonFunctions().elementView(viewProfile, "Profile");
	}

	public void clickProfile() {
		click(viewProfile, "Profile");
	}

	public void viewTokenAccount() {
		new CommonFunctions().elementView(viewTokenMenu, "Token Account");
	}

	public void clickTokenMenu() {
		click(viewTokenMenu, "Token Menu");
	}

	public void verifyAssets(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCryptoAssets, "Crypto Assets comming soon Heading", expHeading);
	}

	public void verifyIssueCardHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblIssueCard, "Issue Card Heading", expHeading);
	}

	public void clickCrypto() {
		click(viewCrypto, "Crypto");
	}

	private void minimizePopup() {
		if (DriverFactory.getDriver().findElement(lblUserName).isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Invalid credentials error popup closed");
		} else {
			ExtentTestManager.setFailMessageInReport("Invalid credentilas error popup not closed");
		}
	}

//	public void clickOutside() {
//		new CommonFunctions().clickOutSideElement();
//	}

	public void minimizePopupBySwipeDown() {
		swipeOnElement(popUp, "popUp", SwipeDirection.DOWN);
		minimizePopup();

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

	public void clickUserDetails() {
		click(lnkUserDetails, "User Details");
	}

	public void clickPaymentMethods() {
			click(lnkPaymentMethods, "Payment Methods");
	}
	
	public void clickGetHelp() {
		scrollDownToElement(btnGetHelp, "Get Help");
		click(btnGetHelp, "Get Help");
	}

	public void clickPreferences() {
		click(lnkPreferences, "Preferences");
	}

	public void verifyPreferencesView() {
		new CommonFunctions().elementView(lnkPreferences, "Preferences");
	}

	public void clickAccountLimits() {
		click(lnkAccountLimits, "Account Limits");
	}

	public void verifyAccountLimitsView() {
		new CommonFunctions().elementView(lnkAccountLimits, "Account Limits");
	}

	public void clickAgreements() {
		click(lnkAgreements, "Agreements");
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

	public void clickChangePassword() {
		scrollDownToElement(btnChangePassword, "Scrolled to element");
		click(btnChangePassword, "Change Password");
	}

	public void clickLogOut() {
		scrollDownToElement(btnLogOut, "Log out");
		click(btnLogOut, "LogOut");
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

	public void clickShare() {
		click(btnShare, "Share ");
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

	public UserDetailsPage userDetailsPage() {
		return new UserDetailsPage();
	}

	public void clickOnCopy() {
		click(lblCopyMessage, "Copy");

	}

	public void verifyLabelCopyText() {
		new CommonFunctions().elementView(lblCopyMessage, "Copied Message");
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

	public void verifyMyQRCodeHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblMyQRCodeHeading, "QR Heading", heading);
	}

	public void verifyLabelMyQRCodeView() {
		new CommonFunctions().elementView(qrCode, "Image QR ");

	}

	public void verifyPopUp() {
		new CommonFunctions().elementView(sharepopup, "Verify Popup");

	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public ExternalBankAccountPage externalBankAccountPage() {
		return new ExternalBankAccountPage();
	}

	public SignUpPage signUpPage() {
		return new SignUpPage();
	}

	public ChangePasswordPage changePasswordPage() {
		return new ChangePasswordPage();
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

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}

	public TokenHomePopUp tokenHomePopUp() {
		return new TokenHomePopUp();
	}

	public SetUpTouchIDPopup setUpTouchIDPopup() {
		return new SetUpTouchIDPopup();
	}
	
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
	
	public GetHelpPage getHelpPage() {
		return new GetHelpPage();
	}
}
