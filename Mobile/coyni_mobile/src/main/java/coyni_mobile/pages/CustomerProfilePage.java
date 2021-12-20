package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CustomerProfilePage extends MobileFunctions {
	
	
	private By imgQRCode = MobileBy.xpath("");
	private By lblMyQRCodeHeading = MobileBy.xpath("");
	private By btnShare = MobileBy.xpath("");
	private By popup = MobileBy.xpath("");
	private By lblCopyMessage = MobileBy.xpath("");
	private By lnkUserDetails = MobileBy.xpath("");
	private By lnkPaymentMethods = MobileBy.xpath("");
	private By lnkPreferences = MobileBy.xpath("");
	private By lnkAccountLimits = MobileBy.xpath("");
	private By lnkAgreements = MobileBy.xpath("");
	private By lnkResetPinCode = MobileBy.xpath("");
	private By btnFaceIDSetting = MobileBy.xpath("");
	private By lnkChangePassword = MobileBy.xpath("");
	private By btnLogOut = MobileBy.xpath("");

	
	private By imgUser = MobileBy.xpath("");
	private By lblUserName = MobileBy.xpath("");
	private By lblAccountID = MobileBy.xpath("");
	private By lblAccountStatus = MobileBy.xpath("");
	private By lblAvaliableBalance = MobileBy.xpath("");
	private By viewPayRequestButton = MobileBy.xpath("");
	private By lblRecentTransaction = MobileBy.xpath("");
	private By lblFirstAndLastName = MobileBy.xpath("");
	private By lblContact = MobileBy.xpath("");

	private By viewDashboard = MobileBy.xpath("");
	private By viewCrypto = MobileBy.xpath("");
	private By viewIssueCard = MobileBy.xpath("");
	private By viewProfile = MobileBy.xpath("");
	private By viewTokenMenu = MobileBy.xpath("");
	private By lblCryptoAssets = MobileBy.xpath("");

	private By btnScan = MobileBy.xpath("");
	private By btnPayRequest = MobileBy.xpath("");
	private By btnBuyToken = MobileBy.xpath("");
	private By btnWithdrawToUSD = MobileBy.xpath("");
	private By popUp = MobileBy.xpath("");

	public void viewScan() {
		new CommonFunctions().elementView(btnScan, "View Scan");
	}

	public void viewPayRequest() {
		new CommonFunctions().elementView(btnPayRequest, "Request");
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
		new CommonFunctions().elementView(viewCrypto, "Dashboard");
	}

	public void viewCrypto() {
		new CommonFunctions().elementView(viewDashboard, "Crypto");
	}

	public void viewIssueCard() {
		new CommonFunctions().elementView(viewIssueCard, "Issue Card");
	}

	public void viewProfile() {
		new CommonFunctions().elementView(viewProfile, "Profile");
	}

	public void viewTokenAccount() {
		new CommonFunctions().elementView(viewTokenMenu, "Token Account");
	}

	public void clickTokenMenu() {
		click(viewTokenMenu, "Token Menu");
	}

	public void verifyAssets(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCryptoAssets, "Crypto Assets comming soon", expHeading);
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

	public void minimizePopupBySwipeDown() {
		swipeOnElementAndroid(popUp, "popUp");
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
		click(lnkUserDetails, " Click User Details");
	}

	public void clickPaymentMethods() {
		click(lnkPaymentMethods, "Click Payment Methods");
	}

	public void clickPreferences() {
		click(lnkPreferences, "Click Preferences");
	}

	public void clickAccountLimits() {
		click(lnkAccountLimits, "click Account limits");
	}

	public void clickAgreements() {
		click(lnkAgreements, "Click Agreements");
	}

	public void clickResetPinCode() {
		click(lnkResetPinCode, "Click Reset Pin Code");
	}

	public void clickFaceIDSetting() {
		click(btnFaceIDSetting, "Click FaceID Setting");
	}

	public void clickChangePassword() {
		click(lnkChangePassword, "Click Change Password");
	}

	public void clickLogOut() {
		click(btnLogOut, "Click LogOut");
	}

	public void clickQRImage() {
		click(imgQRCode, "Click QR Code ");

	}

	public void clickShare() {
		click(btnShare, "Share ");
	}

	public void verifyProfilePageView() {
		new CommonFunctions().elementView(lblUserName, "UserName");
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

	public void verifyLabelMyQRCodeView() {
		new CommonFunctions().elementView(lblMyQRCodeHeading, "Image QR ");

	}

	public void verifyPopUp() {
		new CommonFunctions().elementView(popup, "Verify Popup");

	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public ExternalBankAccountPage externalBankAccountPage() {
		return new ExternalBankAccountPage();
	}
}
