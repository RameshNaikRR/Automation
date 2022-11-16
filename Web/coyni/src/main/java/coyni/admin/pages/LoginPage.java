package coyni.admin.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

import coyni.admin.components.AuthyComponent;
import coyni.admin.components.SideBarComponent;
import coyni.admin.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class LoginPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[text()='Log In to coyni Admin']");
	private By lblDescription = By.xpath("//span[text()='Welcome back, let’s log in to your coyni admin account.']");
	private By txtEmail = By.cssSelector("#Email");
	private By txtPassword = By.cssSelector("#Password");
	private By eyeIcon = By.xpath("//button[(@data-for='button')]");
	private By btnNext = By.cssSelector(".business-login__login-button");
	private By lnkForgotEmail = By.xpath("//button[.='Forgot Email?']");
	private By lnkForgotPassword = By.xpath("//button[.='Forgot Password?']");
	private By lnkSignUp = By.xpath("//button[text()='Sign Up']");
	private By btnSms = By.xpath("//button[contains(@class,'text-x')]");
	private By btnResendVerification = By.xpath("//button[contains(@class,'text-cm3 hover:underline mt')]");
	private By btnNewVerification = By.xpath("//div[contains(@class,'text-cgn')]");
	
	CommonFunctions commonfunctions = new CommonFunctions();
	SideBarComponent sidebarcomponent = new SideBarComponent();
	
	
	public By getSideBarItems(String elementName) {
		return By.xpath(String.format(
				"(//span[(contains(@class,'menu' ) or contains(@class,'label') or contains(@class,'Label'))and text()='%s'])[1]",
				elementName));
	}
	public void verifyPageHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", heading);
	}

	public void verifyPageDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", description);
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
	}
	public void clickEyeIcon() {
		click(eyeIcon, "EyeIcon");
	}
	public By getSubMenuItems(String subItem) {
		return By.xpath(String.format("//p[.='%s']", subItem));

	}

	
	public void clickOutSide() throws AWTException {
		new CommonFunctions().clickTab();
	}
	
	public void verifyPasswordMaskedView() {
		new CommonFunctions().verifyPasswordMaskedView(txtPassword, "password");
	}
//	public void clickNext() {
//		click(btnNext, "Next");
//	}
	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next button is Enabled");
		}
		else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}
	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(txtPassword, attribute, password);
		if (attributeValue.contains("password")) {

			ExtentTestManager.setInfoMessageInReport(password + " masked with black circles");
		} else {
			ExtentTestManager.setInfoMessageInReport(password + " not masked with black circles");
		}
	}

	public void clickForgotEmail() {
		click(lnkForgotEmail, "ForgotEmailLink");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPasswordLink");
	}
	public void verifyEmail() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}
	public void verifyPassword()
	{
		new CommonFunctions().elementView(txtPassword, "Password");
	}
	public void verifyForgotEmail() {
		new CommonFunctions().elementView(lnkForgotEmail, "ForgotEmail");
	}
	public void verifyForgotPassword() {
		new CommonFunctions().elementView(lnkForgotPassword, "ForgotPassword");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
	public ForgotPasswordPage forgotPasswordPage() {
		return new ForgotPasswordPage();

	}
	public ForgotEmailPage forgotEmailPage() {
		return new ForgotEmailPage();

	}
	public void clickSignUp() {
		click(lnkSignUp, "SignUp");
	}
	public void clickSms() {
		click(btnSms, "Sms");
	}
	public void clickResendVerification() {
		click(btnResendVerification, "Resend Verification code");
	}
	public void verifyNewVerification() {
	waitForElement(btnNewVerification, waittime, WaitForElement.presence);
	ExtentTestManager.setInfoMessageInReport("New Verification code is sent");
	}
	public void handSymbolHighlightedTransactions(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("Transactions"), "Transactions", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedCoyniPortal(String cssProp,String expValue,String expColor) {
		click(getSideBarItems("coyni Portal"), "coyni Portal");
		commonfunctions.verifyChangedColor(getSideBarItems("coyni Portal"), "coyni Portal", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedProfiles(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("Profiles"), "Profiles", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedUnderwriting(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("Underwriting"), "Underwriting", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedDisputes(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("Disputes"), "Disputes", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedReserveMgmt(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("Reserve Mgmt."), "Reserve Mgmt.", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedAccounting(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("Accounting"), "Accounting", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedGatewaySettings(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("Gateway Settings"), "Gateway Settings", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedExportedFiles(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("Exported Files"), "Exported Files", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedBalanceReports(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("Balance Reports"), "Balance Reports", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedSystemSettings(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSideBarItems("System Settings"), "System Settings", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedTokenAccount(String cssProp,String expValue,String expColor) {
		click(getSideBarItems("coyni Portal"), "coyni Portal");
		commonfunctions.verifyChangedColor(getSubMenuItems("Token Account"), "Token Account", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedCommissionAccount(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Commission Account"), "Commission Account", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedPersonals(String cssProp,String expValue,String expColor) {
		click(getSideBarItems("Profiles"), "Profiles");
		commonfunctions.verifyChangedColor(getSubMenuItems("Personal"), "Personal", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedUnderwritingPersonals(String cssProp,String expValue,String expColor) {
		//click(getSideBarItems("Underwriting"), "Underwriting");
		commonfunctions.verifyChangedColor(getSubMenuItems("Personal"), "Personal", cssProp, expValue, expColor);
	}
	
	public void handSymbolHighlightedBusinesses(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Businesses"), "Businesses", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedCoyniEmployees(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("coyni Employees"), "coyni Employees", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedAPIBusiness(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("API Business"), "API Businesses", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedPersonal(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Personal"), "Personal", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedBusiness(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Business"), "Business", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedTotalWithdraw(String cssProp,String expValue,String expColor) {
		click(getSideBarItems("Accounting"), "Accounting");
		commonfunctions.verifyChangedColor(getSubMenuItems("Total Withdraw"), "Total Withdraw", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedTotalDeposits(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Total Deposits"), "Total Deposits", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedPaymentGateways(String cssProp,String expValue,String expColor) {
		click(getSideBarItems("Gateway Settings"), "Gateway Settings");
		commonfunctions.verifyChangedColor(getSubMenuItems("Payment Gateways"), "Payment Gateways", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedLoadBalancer(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Load Balancer"), "Load Balancer", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedAgreements(String cssProp,String expValue,String expColor) {
		click(getSideBarItems("System Settings"), "System Settings");
		commonfunctions.verifyChangedColor(getSubMenuItems("Agreements"), "Agreements", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedFeeStructure(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Fee Structure"), "Fee Structure", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedAccountLimits(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Account Limits"), "Account Limits", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedPermissions(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Permissions"), "Permissions", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedFeatureControls(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Feature Controls"), "Feature Controls", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedCardBlackList(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Card Blacklist"), "Card Blacklist", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedPushNotifications(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Push Notifications"), "Push Notifications", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedMerchant(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Merchants"), "Merchants", cssProp, expValue, expColor);
	}
	public void handSymbolHighlightedUnderwritingMerchant(String cssProp,String expValue,String expColor) {
		commonfunctions.verifyChangedColor(getSubMenuItems("Merchants"), "Merchants", cssProp, expValue, expColor);
	}
}
