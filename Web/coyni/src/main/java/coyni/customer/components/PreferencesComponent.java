package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreferencesComponent extends BrowserFunctions {

	private By lblPreferences = By.xpath("(//span[text()='Preferences'])[2]");
	private By drpDwnTimeZonePST = By.xpath("(//div[text()='Pacific (PST)'])[1]");
	private By drpDwnTimeZoneMST = By.xpath("(//div[text()='Mountain// (MST)'])[1]");
	// private By tickMarksuccessfully = By.className("w-56");
	private By backGroundColorPreferences = By.xpath("(//span[text()='Preferences'])[1]");

	private By drpDwnDefaultAccount = By.xpath("//div[@class=' text-center w-40 truncate']");

	private By txtLocalCurrency = By.cssSelector("");

	private By btnSave = By.xpath("//button[text()='Save']");
	private By lblmessage = By.xpath("//div[text()='Preferences Updated Successfully']");

	public void selectTimeZone(String timeZone) {
		click(drpDwnTimeZonePST, "Time Zone DropDown");
		new CommonFunctions().selectCustomDropDown(timeZone, "Time Zone");
	}

	public void selectDefaultAccount(String defaultAccount) {
		click(drpDwnDefaultAccount, "Default Account DropDown");
		new CommonFunctions().selectCustomDropDown(defaultAccount, "Default Account");
	}

	public void verifyTimeZoneView() {
		new CommonFunctions().elementView(drpDwnTimeZonePST, "drop down for Timezone");

	}

	public void verifyPreferencesBackGroundColor(String cssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(backGroundColorPreferences, "Preferences", cssProp, expValue,
				expColor);
	}

	public void verifyDefaultAccountBackGroundColor(String cssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(drpDwnDefaultAccount, "Default Account", cssProp, expValue, expColor);

	}

	public void verifyTickMarkSuccesfull(String Prefereces) {
		new CommonFunctions().elementView(verifyTickMark("Preferences Updated Successfully"), "TickMark");
	}

//	public void verifyDefaultAccountView() {
//		new CommonFunctions().elementView(drpDwnDefaultAccount, "drop down for Default Account");
//	}

	public void verifyLocalCurrency(String expCurrency) {
		new CommonFunctions().verifyLabelText(txtLocalCurrency, "Local Currency", expCurrency);
	}

	public void clickSave() {
		click(btnSave, "Save");
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

//	public void verifyDefautAccountTickMark() {
//		new CommonFunctions().elementView(verifyTickMark("anudeepG (Personal)"), "TickMark");
//	}
}