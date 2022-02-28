package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ProfileSideBarComponent extends BrowserFunctions{
	private By lblID =By.xpath("//div[@id='admin-customer-details-page']/preceding-sibling::*[1]/span");
	private By drpdwnStatus =By.cssSelector("");
	private By lblUserName =By.cssSelector(".username-label");
	private By lblAccountID =By.cssSelector(".id-label");
	private By btnWebLastSeen =By.cssSelector("");
	private By lblWebLastSeen =By.cssSelector("");
	private By btnMobileLastSeen =By.cssSelector("");
	private By lblMobileLastSeen =By.cssSelector("");
	
	public void verifyID(String expID) {
		new CommonFunctions().verifyLabelText(lblID, "ID", expID);
	}
	public void verifyUserName(String expUserName) {
		new CommonFunctions().verifyLabelText(lblUserName, "User Name", expUserName);
	}
	public void verifyAccountID(String expAccountID) {
		new CommonFunctions().verifyLabelText(lblAccountID, "Account ID", expAccountID);
	}
	public void clickWebIcon() {
		click(btnWebLastSeen, "Web Icon");
	}
	public void getWebLastSeen() {
		ExtentTestManager.setInfoMessageInReport("Web Icon Message: "+getText(lblWebLastSeen, ""));
	}
	public void clickMobileIcon() {
		click(btnMobileLastSeen, "Web Icon");
	}
	public void getMobileLastSeen() {
		ExtentTestManager.setInfoMessageInReport("Mobile Icon Message: "+getText(lblMobileLastSeen, ""));
	}
	public void verifyUserDetailsView() {
	new CommonFunctions().elementView(getMenuItems("User Details"), "User Details");	
	}
	public void verifyPaymentMethodsView() {
		new CommonFunctions().elementView(getMenuItems("Payment Methods"), "Payment Methods");
	}
	public void verifyTokenAccountView() {
		new CommonFunctions().elementView(getMenuItems("Token Account"), "Token Account");
	}
	public void verifyPreferencesControlView() {
		new CommonFunctions().elementView(getMenuItems("Preferences / Controls"), "Preferences / Controls");
	}
	public void verifyAgreementsView() {
		new CommonFunctions().elementView(getMenuItems("Agreements"), "Agreements");
	}
	public void verifyAccountLimitsView() {
		new CommonFunctions().elementView(getMenuItems("Account Limits"), "Account Limits");
	}
	public void verifyActivityLogView() {
		new CommonFunctions().elementView(getMenuItems("Activity Log"), "Activity Log");
	}
	private By getMenuItems(String elementName) {
		return By.xpath(String.format("//div[@class='menu-list-container']/a/span[text()='%s']", elementName));
	}
	public void clickUserDetails() {
		click(getMenuItems("User Details"), "User Details");
	}
	public void clickPaymentMethods() {
		click(getMenuItems("Payment Methods"), "Payment Methods");
	}
	public void clickTokenAccount() {
		click(getMenuItems("Token Account"), "Token Account");
	}
	public void clickPreferencesControl() {
		click(getMenuItems("Preferences / Controls"), "Preferences / Controls");
	}
	public void clickAgreements() {
		click(getMenuItems("Agreements"), "Agreements");
	}
	public void clickAccountLimits() {
		click(getMenuItems("Account Limits"), "Account Limits");
	}
	public  void clickActivityLog() {
		click(getMenuItems("Activity Log"), "Activity Log");
	}
public UserDetailsComponent UserDetailsComponent() {
	return UserDetailsComponent();
}
public PaymentMethodsComponent PaymentMethodsComponent() {
	return PaymentMethodsComponent();
}
}
