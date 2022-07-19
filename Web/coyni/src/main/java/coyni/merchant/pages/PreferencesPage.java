package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreferencesPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='Preferences']");
	private By drpDwnTime = By.xpath("//div[text()='Time Zone']/parent::div");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By localCurrency = By.xpath("//div[text()='Local Currency']/following-sibling::*[1]");
	private By lblDescription = By.xpath("//span[contains(.,'Your merchant batch')]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void selectTimeZone(String timeZone) {
		click(drpDwnTime, "Time Zone DropDown");
		// click(getElement(timeZone), timeZone);
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
