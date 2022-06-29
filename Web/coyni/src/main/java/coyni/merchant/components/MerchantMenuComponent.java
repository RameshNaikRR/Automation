package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantMenuComponent extends BrowserFunctions {

	private By lblUserName = By.xpath("//div[contains(@class,'circle-initials')]");

	private By lnkUserDetails = By.xpath("(//span[text()='User Details'])[1]");

	private By lnkPreferences = By.cssSelector("//span[text()='Preferences']");

	private By lnkAgreements = By.cssSelector("//span[text()='Agreements']");

	private By lnkChangePassword = By.xpath("//span[text()='Change Password']");

	private By lblUserDetails = By.cssSelector("div.dropdown-container>div:nth-of-type(2)");

	private By lnkTwoStepAuthentication = By.xpath("//span[text()='2-Step Authentication']");

	public void verifyUserName(String userName) {
		new CommonFunctions().verifyLabelText(lblUserName, "UserName", userName);
	}

	public void clickUserName() {
		click(lblUserName, "Click User Name");
	}

	public void verifyUserDetails(String UserDetails) {
		new CommonFunctions().verifyLabelText(lblUserDetails, "UserDetails", UserDetails);
	}

	public void clickUserDetails() {
		click(lnkUserDetails, "Click UserDetails");
	}

	public void clickPreferences() {
		click(lnkPreferences, "Click Preferences");
	}

	public void clickAgreements() {
		click(lnkAgreements, "Click Agreements");
	}

	public void clickChangePassword() {
		click(lnkChangePassword, "Click Change Password");
	}

	public void clickTwoStepAuthentications() {
		click(lnkTwoStepAuthentication, "Click Two Step Authentication");
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
