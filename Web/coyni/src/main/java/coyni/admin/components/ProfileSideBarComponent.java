package coyni.admin.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class ProfileSideBarComponent extends BrowserFunctions{
	private By lblID =By.xpath("//div[@id='admin-customer-details-page']/preceding-sibling::*[1]/span");
	private By drpdwnStatus =By.cssSelector("");
	private By lblUserName =By.cssSelector(".username-label");
	private By lblAccountID =By.cssSelector(".id-label");
	private By btnWebLastSeen =By.cssSelector("");
	private By lblWebLastSeen =By.cssSelector("");
	private By btnMobileLastSeen =By.cssSelector("");
	private By lblMobileLastSeen =By.cssSelector("");
	
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
		click(getMenuItems(""), getCopiedData());
	}
	public  void clickActivityLog() {
		click(getMenuItems("Activity Log"), "Activity Log");
	}

}
