package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CustomerMenuComponent extends BrowserFunctions {

	private By lblUserName = By.cssSelector(".internal-header__circle-initials");

	private By lblAccountStatus = By.cssSelector("");

	private By lnkRequests = By.cssSelector("");

	private By lnkUserDetails = By.xpath("(//span[text()='User Details'])[1]");

	private By lnkPaymentMethods = By.cssSelector("");

	private By lnkPreferences = By.cssSelector("");

	private By lnkAccountLimits = By.cssSelector("");

	private By lnkAgreements = By.cssSelector("");

	private By lnkChangePassword = By.cssSelector("div.dropdown-container>div:nth-of-type(7)");

	private By lblUserDetails = By.cssSelector("div.dropdown-container>div:nth-of-type(2)");
	private By lblPaymentMethods = By.cssSelector(" ");
	private By lblPreferences = By.cssSelector(" ");
	private By lblAccountLimits = By.cssSelector(" ");
	private By lblAgreements = By.cssSelector(" ");
	private By lblChangePassword = By.cssSelector(" ");

	public void verifyUserName(String userName) {
		new CommonFunctions().verifyLabelText(lblUserName, "UserName", userName);
	}

	public void clickUserName() {
		click(lblUserName, "Click User Name");
	}

	public void verifyAccountStatus(String accStatus) {
		new CommonFunctions().verifyLabelText(lblAccountStatus, "Account Status", accStatus);
	}

	public void verifyUserDetails(String UserDetails) {
		new CommonFunctions().verifyLabelText(lblUserDetails, "UserDetails", UserDetails);
	}

	public void verifyPaymentMtehods(String PaymentMethods) {
		new CommonFunctions().verifyLabelText(lblPaymentMethods, "PaymentMethods", PaymentMethods);
	}

	public void verifyPreferences(String Preferences) {
		new CommonFunctions().verifyLabelText(lblPreferences, "Preferences", Preferences);
	}

	public void verifyAccountLimits(String AccountLimits) {
		new CommonFunctions().verifyLabelText(lblAccountLimits, "AccountLimits", AccountLimits);
	}

	public void verifyAgreements(String Agreements) {
		new CommonFunctions().verifyLabelText(lblAgreements, "Agreements", Agreements);
	}

	public void verifyChangePassword(String ChangePassword) {
		new CommonFunctions().verifyLabelText(lblChangePassword, "ChangePassword", ChangePassword);
	}

	public void clickRequests() {
		click(lnkRequests, "Click Requests");
	}

	public void clickUserDetails() {
		click(lnkUserDetails, "Click UserDetails");
	}

	public void clickPaymentMethods() {
		click(lnkPaymentMethods, "Click PaymentMethods");
	}

	public void clickPreferences() {
		click(lnkPreferences, "Click Preferences");
	}

	public void clickAccountLimits() {
		click(lnkAccountLimits, "Click Account Limits");
	}

	public void clickAgreements() {
		click(lnkAgreements, "Click Agreements");
	}

	public void clickChangePassword() {
		click(lnkChangePassword, "Click Change Password");
	}
	private By getSidebarItems(String sidebarItems) {
		return By.xpath(String.format("//div[@class='flex flex-col gap-2.5 mt-6']/descendant::a/span[text()='%s']",
		sidebarItems));
		}

	public void verifyUserDetailsView() {
		new CommonFunctions().elementView(getSidebarItems("User Details"), "UserDetails");
	}

	public void verifyPaymentMethodsView() {
		new CommonFunctions().elementView(getSidebarItems("Payment Methods"), "PaymentMethods ");
	}

	public void verifyPreferencesView() {
		new CommonFunctions().elementView(getSidebarItems("Preferences"), "Preferences ");
	}

	public void verifyAccountlimitsView() {
		new CommonFunctions().elementView(getSidebarItems("Account Limits"), "Account limits ");
	}

	public void verifyAgreementsView() {
		new CommonFunctions().elementView(getSidebarItems("Agreements"), "Agreements ");
	}

	public void verifyChangePasswordView() {
		new CommonFunctions().elementView(getSidebarItems("Change Password"), "Change Password ");
	}

}
