package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.AddNewPaymentComponent;
import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.FieldValidationsComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.PaymentMethodsPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CustomerProfilePage extends MobileFunctions {
	private By lblUserName = MobileBy.id("com.coyni.mapp:id/customerNameTV");
	private By lblAccountID = MobileBy.id("com.coyni.mapp:id/cpAccountIDTV");
	private By lblAccountStatus = MobileBy.id("com.coyni.mapp:id/tvACStatus");
	private By imgQRCode = MobileBy.id("com.coyni.mapp:id/imgQRCode");
	private By lblUserDetails = MobileBy.AccessibilityId("User Details");
	private By lnkProfile = MobileBy.id("com.coyni.mapp:id/profileLL");
	private By lnkPreferences = MobileBy.id("com.coyni.mapp:id/preferencesLL");
	private By lnkAgreements = MobileBy.id("com.coyni.mapp:id/agreementsLL");
	private By lblWalletSettings = MobileBy.id("com.coyni.mapp:id/walletSettingsTV");
	private By lnkPaymentMethods = MobileBy.id("com.coyni.mapp:id/paymentMethodsLL");
	private By lnkAccountLimits = MobileBy.id("com.coyni.mapp:id/accountLimitsLL");
	private By lnkWalletFees = MobileBy.id("com.coyni.mapp:id/walletFeeLL");
	private By lblSecurity = MobileBy.id("com.coyni.mapp:id/securityTV");
	private By lnkLoginSessions = MobileBy.id("com.coyni.mapp:id/loginSessinonsLL");
	private By lnkResetPinCode = MobileBy.id("com.coyni.mapp:id/resetPinLL");
	private By lnkFaceIDtouchID = MobileBy.id("com.coyni.mapp:id/switchOff");
	private By lnkChangePassword = MobileBy.id("com.coyni.mapp:id/changePasswordLL");
	private By lblSupport = MobileBy.id("com.coyni.mapp:id/supportTV");
	private By lnkGetHelp = MobileBy.id("com.coyni.mapp:id/helpLL");
	private By btnLogOut = MobileBy.id("com.coyni.mapp:id/cvLogoutLL");

	public void verifyUserNAmeandStatus() {
		if (getElement(lblUserName, "User Name").isDisplayed() && getElement(lblAccountID, "Account ID").isDisplayed()
				&& getElement(lblAccountStatus, "Account Status").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("The User Name is :" + getText(lblUserName));
			ExtentTestManager.setPassMessageInReport("The Account Id is :" + getText(lblAccountID));
			ExtentTestManager.setPassMessageInReport("The Account Status is:" + getText(lblAccountStatus));
		} else {
			ExtentTestManager.setFailMessageInReport("User dtails not present in Profile" + getText(lblUserName));
		}
	}

	public void viewAccountID() {
		new CommonFunctions().elementView(lblAccountID, "Account ID");
	}

	public void clickimgQRCode() {
		click(imgQRCode, "QRcode");
	}

	public void clickProfile() {
		click(lnkProfile, "Profile");
	}

	public void clickPreferences() {
		click(lnkPreferences, "Preferences");
	}

	public void clickAgreements() {
		click(lnkAgreements, "Agreements");
	}

	public void verifyWalletSettingsView() {
		new CommonFunctions().elementView(lblWalletSettings, "Wallet Settings");
	}

	public void clickPaymentMethods() {
		click(lnkPaymentMethods, "Payment Methods");
	}

	public void clickAccountLimits() {
		click(lnkAccountLimits, "Account Limits");
	}

	public void clickWalletFees() {
		click(lnkWalletFees, "Wallet");
	}

	public void verifySecurityView() {
		scrollDownToElement(lblSecurity, "Security");
		new CommonFunctions().elementView(lblSecurity, "Security");
	}

	public void clickLoginSessions() {
		scrollDownToElement(lnkLoginSessions, "Login sessions");
		click(lnkLoginSessions, "Login sessions");
	}

	public void clickResetPinCode() {
		scrollDownToElement(lnkResetPinCode, "Reset Pin Code");
		click(lnkResetPinCode, "Reset Pin Code");
	}

	public void clickFaceIDTouchID() throws InterruptedException {
		scrollDownToElement(lnkFaceIDtouchID, "FaceID Touch Id");
		Thread.sleep(800);
		click(lnkFaceIDtouchID, "FaceID Touch Id");
	}

	public void clickChangePassword() {
		scrollDownToElement(lnkChangePassword, "Change Password");
		click(lnkChangePassword, "Change Password");
	}

	public void clickGetHelp() {
		scrollDownToElement(lnkGetHelp, "GetHelp");
		click(lnkGetHelp, "Get Help");
	}

	public void clickLogout() {
		scrollDownToElement(btnLogOut, "Log out");
		click(btnLogOut, "Log out");
	}

	public DashboardPage dashboardPage() {
		return new DashboardPage();
	}

	public ProfilePage profilePage() {
		return new ProfilePage();
	}

	public AccountLimitsPage accountLimitsPage() {
		return new AccountLimitsPage();
	}

	public WalletsFeesPage walletsFeesPage() {
		return new WalletsFeesPage();
	}

	public EnableFaceOrTouchIDpage enableFaceOrTouchIDpage() {
		return new EnableFaceOrTouchIDpage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}

	public AddNewPaymentComponent addNewPaymentComponent() {
		return new AddNewPaymentComponent();
	}

	public LogInSessionsPage logInSessionsPage() {
		return new LogInSessionsPage();
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}

	public LandingPage landingPage() {
		return new LandingPage();
	}

	public AgreementPage agreementPage() {
		return new AgreementPage();
	}

	public PreferencesPage preferencesPage() {
		return new PreferencesPage();
	}

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}
}
