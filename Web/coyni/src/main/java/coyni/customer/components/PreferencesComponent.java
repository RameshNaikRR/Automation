package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreferencesComponent extends BrowserFunctions {

	private By lblPreferences = By.xpath("(//span[text()='Preferences'])[2]");
	// private By lblPreferencesBackGroundcolor =
	// By.xpath("(//span[text()='Preferences'])[1]");
	private By drpDwnTimeZone = By.xpath("(//div[text()='Pacific (PST)'])[1]");
	//private By tickMarksuccessfully = By.className("w-56");

	private By drpDwnDefaultAccount = By.xpath("//div[text()='anudeepG (Personal)']");

	private By txtLocalCurrency = By.cssSelector("");

	// private By backGroundColor = By.className("group-hover:bg-cbl5");

	private By btnSave = By.xpath("//button[text()='Save']");
	private By lblmessage = By.xpath("//div[text()='Preferences Updated Successfully']");

	public void selectTimeZone(String timeZone) {
		click(drpDwnTimeZone, "Time Zone DropDown");
		new CommonFunctions().selectCustomDropDown(timeZone, "Time Zone");
	}

	public void verifyTimeZoneView() {
		new CommonFunctions().elementView(drpDwnTimeZone, "drop down for Timezone");

	}

//	public void verifyLabelPreferencesColor() {
//		new CommonFunctions().verifyChangedColor(lblPreferencesBackGroundcolor, "Preferences", cssProp, expValue,
//				expColor);
//	}

	public void verifyTickMarkSuccesfull(String Prefereces) {
		new CommonFunctions().elementView(verifyTickMark("Preferences Updated Successfully"), "TickMark");
	}

//	public void verifyDefaultAccountView() {
//		new CommonFunctions().elementView(drpDwnDefaultAccount, "drop down for Default Account");
//	}

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

	public void verifyLabelSuccessMessage() {
		new CommonFunctions().elementView(lblmessage, "Preferences Updated successfully");
	}

	public void verifyLabelPreferences(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPreferences, "Prefereces displayed ", expHeading);
	}

	private By verifyTickMark(String timeZone) {
		return By.xpath(String.format("//div[text()='%s']/following-sibling::img", timeZone));
	}

	public void verifyPSTTickMark() {
		new CommonFunctions().elementView(verifyTickMark("Pacific (PST)"), "TickMark");
	}

	public void verifyDefautAccountTickMark() {
		new CommonFunctions().elementView(verifyTickMark("anudeepG (Personal)"), "TickMark");
	}
}