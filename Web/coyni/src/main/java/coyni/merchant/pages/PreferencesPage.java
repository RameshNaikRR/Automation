package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreferencesPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[.='Preferences']");
	private By drpDwnTime = By.xpath("//div[text()='Time Zone']/parent::div");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By localCurrency = By.xpath("//div[text()='Local Currency']/following-sibling::*[1]");
	private By lblDescription = By.xpath("//span[contains(.,'Your merchant batch')]");
	private By drpDwnDefaultAccount = By
			.xpath("//div[text()='Default Account']/../div[contains(@class,'FormField_selected_option')]");
	private By drpDwnTimeZones = By
			.xpath("//div[text()='Time Zone']/../div[contains(@class,'FormField_selected_option')]");

	private By getTimeZones(String timeZone) {
		return By.xpath(String.format("//span[normalize-space()='%s']", timeZone));
	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void verifyhandSymbolHighlightedPreferences(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Preferences"), "Preferences");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "Dba information", cssProp, expValue,
				expColor);
	}

	public void clickEastern() {
		click(getTimeZones("Eastern (EST)"), "Eastern");
	}

	public void selectDefaultAccount(String defaultAccount) {
		click(drpDwnDefaultAccount, "Default Account DropDown");
		new CommonFunctions().selectCustomDropDown(defaultAccount, "Default Account");
	}

	public void selectDefaultTimeZone(String defaultTimeZone) {
		click(drpDwnTimeZones, "Default TimeZone DropDown");
		new CommonFunctions().selectCustomDropDown(defaultTimeZone, "Default TimeZone");
	}

	public void clickPacific() {
		click(getTimeZones("Pacific (PST)"), "Pacific");
	}

	public void clickMountain() {
		click(getTimeZones("Mountain (MST)"), "Mountain");
	}

	public void clickHawaii() {
		click(getTimeZones("Hawaii (HST)"), "Hawaii");
	}

	public void clickAlaskan() {
		click(getTimeZones("Alaskan (AST)"), "Alaskan");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void selectTimeZone(String timeZone) {
		click(drpDwnTime, "Time Zone DropDown");
	}

	public void verifyCurrency(String Currency) {
		new CommonFunctions().verifyLabelText(localCurrency, "Local Currency", Currency);
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", Description);
	}

	public void clickTimeDropdown() {
		click(drpDwnTime, "Time Zone");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

}
