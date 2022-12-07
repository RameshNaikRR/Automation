package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreferencesPage extends BrowserFunctions {
	private By drpDwnTime = By.xpath("//div[text()='Time Zone']/parent::div");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By localCurrency = By.xpath("//div[text()='Local Currency']/following-sibling::*[1]");
	private By btnMountain = By.xpath("//span[text()='Mountain (MST)']");
	

	public By getElement(String timeZone) {
		return By.xpath(String.format("//div[text()='%s']", timeZone));
	}

	public void selectTimeZone(String timeZone) {
		click(btnMountain, "MST");
	//	click(getElement(timeZone), timeZone);
	}

	public void verifyCurrency(String Currency) {
		new CommonFunctions().verifyLabelText(localCurrency, "Local Currency", Currency);
	}

	public void clickTimeDropdown() {
		click(drpDwnTime, "Time Zone");

	}

	public void clickSave() {
		click(btnSave, "Save");
	}

}