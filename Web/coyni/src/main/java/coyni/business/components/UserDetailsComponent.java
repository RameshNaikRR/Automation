package coyni.business.components;

import org.openqa.selenium.By;

import coyni.business.pages.ProfilePage;
import coyni.business.popups.EditPhoneNumberPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class UserDetailsComponent extends BrowserFunctions {

	CommonFunctions commonFunctions = new CommonFunctions();

	private By lblUserDetails = By.cssSelector("");
	private By lnkLogOut = By.xpath("");

	public void verifyUserDeatils(String expHeading) {
		new CommonFunctions().verifyLabelText(lblUserDetails, "Heading is: ", expHeading);
	}

	public By getUserDetailsItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void clickProfile() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Profile"), "Profile");
		click(getUserDetailsItems("Profile"), "Profile");
	}

	public void clickPreferences() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Preferences"), "Preferences");
		click(getUserDetailsItems("Preferences"), "Preferences");
	}

	public void clickAgreements() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Agreements"), "Agreements");
		click(getUserDetailsItems("Agreements"), "Agreements");
	}

	public void clickLoginSessions() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Login Sessions"), "Login Sessions");
		click(getUserDetailsItems("Login Sessions"), "Login Sessions");
	}

	public void clickChangePassword() {
		commonFunctions.verifyCursorAction(getUserDetailsItems("Change Password"), "Change Password");
		click(getUserDetailsItems("Change Password"), "Change Password");
	}

	public void clickLogOut() {
		click(lnkLogOut, "Log Out");
	}
	
	public ProfilePage profilePage() {
		return new ProfilePage();
	}

	
}
