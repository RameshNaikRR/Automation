package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreferencesComponent extends BrowserFunctions {

	private By drpDwnTimeZone = By.cssSelector("");

	private By drpDwnDefaultAccount = By.cssSelector("");

	private By txtLocalCurrency = By.cssSelector(""); //

	private By lblPreferences = By.cssSelector("");

	private By btnSave = By.cssSelector("");

	public void selectTimeZone(String timeZone) {
		click(drpDwnTimeZone, "Time Zone DropDown");
		new CommonFunctions().selectCustomDropDown(timeZone, "Time Zone");
	}

	public void selectDefaultAccount(String defaultAccount) {
		click(drpDwnDefaultAccount, "Default Account DropDown");
		new CommonFunctions().selectCustomDropDown(defaultAccount, "Default Account");
	}

	public void verifyLocalCurrency(String expCurrency) {
		new CommonFunctions().verifyLabelText(txtLocalCurrency, "Local Currency", expCurrency);
	}

	public void clickSave() {
		click(btnSave, "Click Save");
	}

	// added
	public void VerifyClickOnAccountDetails() {
		new CommonFunctions().elementView(lblPreferences, "Preferences");

	}

}
