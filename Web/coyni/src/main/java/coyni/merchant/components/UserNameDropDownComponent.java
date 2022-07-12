package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class UserNameDropDownComponent extends BrowserFunctions {

	// added
	private By userDetailsNameHeading = By.xpath("//div[contains(@class,'circle-initials')]");
	private By dropwnUserName = By.cssSelector(".down-arrow");
	private By lblRequests = By.xpath("//span[text()='Requests']");
	private By requestdot = By.xpath("//span[contains(@class,'green-dot')]");
	private By lnkUserDetails = By.xpath("(//span[text()='User Details'])[1]");
	private By lnkPaymentMethods = By.xpath("(//span[text()='Payment Methods'])[1]");
	private By lnkPreferences = By.xpath("(//span[text()='Preferences'])[1]");
	private By lnkAccountLimits = By.xpath("//span[text()='Account Limits']");
	private By lnkAgreements = By.xpath("//span[text()='Agreements']");
	private By lnkChangePassword = By.xpath("//span[text()='Change Password']");
	private By lnkSignOut = By.xpath("//span[text()='Sign Out']");

	public void cursorhoverUserName() {
		new CommonFunctions().verifyCursorAction(dropwnUserName, "drop down");

	}

	public void clickDropDown() {
		click(dropwnUserName, "Drop Down");
	}

	public void verifyUserDetailsNameHeading() {
		new CommonFunctions().elementView(userDetailsNameHeading, "user name");
	}

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

	public void clickAccountLimits() {
		click(lnkAccountLimits, "Account Limits");
	}

	public void verifyRequestView() {
		new CommonFunctions().elementView(dropwnUserName, "Request");
	}

//			public void verifysignOutView() {
//				new CommonFunctions().elementView(signOutIcon, "SignOut");
//			}

	public void verifyUserNameView() {
		new CommonFunctions().elementView(dropwnUserName, "UserName");
	}

	public void clickRequest() {
		click(lblRequests, "Request");
	}

	public void verifyRequestDot() {
		new CommonFunctions().elementView(requestdot, "Request Dot");
	}

	public void verifyDropDownElements() {
		new CommonFunctions().elementView(lblRequests, "Requests");
		new CommonFunctions().elementView(lnkUserDetails, "User Details");
		new CommonFunctions().elementView(lnkPaymentMethods, "Payment Methods");
		new CommonFunctions().elementView(lnkPreferences, "Preferences");
		new CommonFunctions().elementView(lnkAccountLimits, "Account Limits");
		new CommonFunctions().elementView(lnkAgreements, "Agreements");
		new CommonFunctions().elementView(lnkChangePassword, "Change Password");
		new CommonFunctions().elementView(lnkSignOut, "Sign Out");

	}

	public NotificationsComponent notificationsComponent() {
		return new NotificationsComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}