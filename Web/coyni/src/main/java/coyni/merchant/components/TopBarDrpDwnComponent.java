package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.merchant.pages.AgreementsPage;
import coyni.merchant.pages.ChangePasswordPage;
import coyni.merchant.pages.MerchantAccountsPage;
import coyni.merchant.pages.PreferencesPage;
import coyni.merchant.pages.TwoStepAuthenticationPage;
import coyni.merchant.pages.UserDetailsPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TopBarDrpDwnComponent extends BrowserFunctions {

	CommonFunctions Cf = new CommonFunctions();

	private By getDropDownItems(String itemsNum) {
		return By.xpath(String.format("//div[@class='dropdown-container']//span[text()='%s']", itemsNum));
	}

	public void clickUserDetails() {
		click(getDropDownItems("User Details"), "User Details");
	}

	public void verifyUserDetails() {
		Cf.elementView(getDropDownItems("User Details"), "User Details push button ");
	}

	public void clickMerchantAccounts() {
		click(getDropDownItems("Merchant Accounts"), "Merchant Accounts");
	}

	public void verifyMerchantAccounts() {
		Cf.elementView(getDropDownItems("Merchant Accounts"), "Merchant Accounts push button ");
	}

	public void clickPaymentMethods() {
		click(getDropDownItems("Payment Methods"), "Payment Methods");
	}

	public void verifyPaymentMethods() {
		Cf.elementView(getDropDownItems("Payment Methods"), "Payment Methods push button ");
	}

	public void clickPreferences() {
		click(getDropDownItems("Preferences"), "Preferences");
	}

	public void verifyPreferences() {
		Cf.elementView(getDropDownItems("Preferences"), "Preferences push button ");
	}

	public void clickAgreements() {
		click(getDropDownItems("Agreements"), "Agreements");
	}

	public void verifyAgreements() {
		Cf.elementView(getDropDownItems("Agreements"), "Agreements push button ");
	}

	public void clickChangePassword() {
		click(getDropDownItems("Change Password"), "Change Password");
	}

	public void verifyChangePassword() {
		Cf.elementView(getDropDownItems("Change Password"), "Change Password push button ");
	}

	public void clickTwoStepAuthentication() {
		click(getDropDownItems("2-Step Authentication"), "2-Step Authentication");
	}

	public void verifyTwoStepAuthentication() {
		Cf.elementView(getDropDownItems("2-Step Authentication"), "2-Step Authentication push button ");
	}

	public void clickSignOut() {
		click(getDropDownItems("Sign Out"), "Sign Out");
	}

	public void verifySignOut() {
		Cf.elementView(getDropDownItems("Sign Out"), "Sign Out button ");
	}

	public UserDetailsPage userDetailsPage() {
		return new UserDetailsPage();
	}

	public MerchantAccountsPage merchantAccountsPage() {
		return new MerchantAccountsPage();
	}

	public PreferencesPage preferencesPage() {
		return new PreferencesPage();
	}

	public AgreementsPage agreementsPage() {
		return new AgreementsPage();
	}

	public ChangePasswordPage changePasswordPage() {
		return new ChangePasswordPage();
	}

	public TwoStepAuthenticationPage twoStepAuthenticationPage() {
		return new TwoStepAuthenticationPage();
	}
}
