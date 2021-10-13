package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CustomerMenuComponent extends BrowserFunctions {
	
	private By lblUserName = By.cssSelector("");
	
	private By lblAccountStatus = By.cssSelector("");
	
	private By lnkRequests = By.cssSelector("");
	
	private By lnkUserDetails =By.cssSelector("");
	
	private By lnkPaymentMethods = By.cssSelector("");
	
	private By lnkPreferences = By.cssSelector("");
	
	private By lnkAccountLimits = By.cssSelector("");
	
	private By lnkAgreements = By.cssSelector("");
	
	private By lnkChangePassword = By.cssSelector("");
	
	public void verifyUserName(String userName) {
		new CommonFunctions().verifyLabelText(lblUserName, "username",userName );
	}
	
	public void verifyAccountStatus(String accStatus) {
		new CommonFunctions().verifyLabelText(lblAccountStatus, "account status", accStatus);
	}
	
	public void clickRequests() {
		click(lnkRequests, "click requests");
	}
	
	public void clickUserDetails() {
		click(lnkUserDetails, "click UserDetails");
	}

	public void clickPaymentMethods() {
		click(lnkPaymentMethods, "click paymentMethods");
	}
	
	public void clickPreferences() {
		click(lnkPreferences, "click preferences");
	}
	
	public void clickAccountLimits() {
		click(lnkAccountLimits, "click account limits");
	}
	
	public void clickAgreements() {
		click(lnkAgreements, "click agreements");
	}
	
	public void clickChangePassword() {
		click(lnkChangePassword, "click change password");
	}















}
