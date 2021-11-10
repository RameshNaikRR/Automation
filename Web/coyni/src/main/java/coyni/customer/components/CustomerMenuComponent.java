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
		new CommonFunctions().verifyLabelText(lblUserName, "UserName",userName );
	}
	
	public void verifyAccountStatus(String accStatus) {
		new CommonFunctions().verifyLabelText(lblAccountStatus, "Account Status", accStatus);
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

	public  ChangePasswordComponent changePasswordComponent() {   //added
		 return new ChangePasswordComponent();
		 }



}
