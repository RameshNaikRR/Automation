package coyni.customer.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class UserNameDropDownComponent extends BrowserFunctions {

	// added
	private By dropwnUserName = By.cssSelector(".down-arrow");
	private By lnkUserDetails = By.xpath("//span[text()='User Details']");

	private By lnkPaymentMethods = By.cssSelector(" ");
	private By lnkPreferences = By.cssSelector(" ");
	private By lnkAccountLimits = By.cssSelector(" ");
	private By lnkAgreements = By.cssSelector(" ");
	private By lnkChangePassword = By.cssSelector(" ");
	private By lnkSignOut = By.cssSelector(" ");
	private By lblRequests = By.cssSelector(" ");
	private By signOutIcon = By.cssSelector(" ");

	public void verifyUserDetails() {
		new CommonFunctions().elementView(lnkUserDetails, "User Details");
	}

	public void clickUserName() {
		click(dropwnUserName, "UserName");
	}

	public void clickUserDetails() {
		click(lnkUserDetails, "UserDetails");
	}

	public void clickPaymentMethods() {
		click(lnkPaymentMethods, "PaymentMethods");
	}

	public void clickPreferences() {
		click(lnkPreferences, "Preferences");
	}

	public void clickAgreements() {
		click(lnkAgreements, "Agreements");
	}

	public void clickChangePassword() {
		click(lnkChangePassword, "ChangePassword");
	}

	public void clickSignOut() {
		click(lnkSignOut, "SignOut");
	}

	public void verifyRequestView() {
		new CommonFunctions().elementView(dropwnUserName, "Request");
	}

	public void verifysignOutView() {
		new CommonFunctions().elementView(signOutIcon, "SignOut");
	}

	public void verifyUserNameView() {
		new CommonFunctions().elementView(dropwnUserName, "UserName");
	}

}
