package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.apibusiness.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PreferencesPage extends BrowserFunctions {
	private By drpDwnTime = By.xpath("//div[text()='Time Zone']/parent::div");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By localCurrency = By.xpath("//div[text()='Local Currency']/following-sibling::*[1]");
	private By btnMountain = By.xpath("//span[text()='Mountain (MST)']");
	private By dropDownIcon = By.xpath("//img[@src='/static/media/arrow-right.3014e1fb88e2fed86fbb76e783121d86.svg']");
	private By defaultAccount = By.xpath("//div[@class='FormField_selected_option__7Rw29 text-[10px]  undefined']");

	public By getElement(String timeZone) {
		return By.xpath(String.format("//div[text()='%s']", timeZone));
	}

	public void selectTimeZone(String timeZone) {
		new CommonFunctions().verifyCursorAction(btnMountain, "Mountain (MST)");
		String str = getElement(btnMountain, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(btnMountain, "MST");
		// click(getElement(timeZone), timeZone);
	}

	public void dropDownIcon() {
		new CommonFunctions().elementView(dropDownIcon, "DropDown");
	}

	public void verifyCurrency(String Currency) {
		new CommonFunctions().verifyLabelText(localCurrency, "Local Currency", Currency);
		ExtentTestManager.setInfoMessageInReport(Currency + "is Disabled mode");
	}

	public void clickTimeDropdown() {
		click(drpDwnTime, "Time Zone");
	}

	public void defaultAccount() {
		new CommonFunctions().verifyCursorAction(defaultAccount, "Default Account");
		click(defaultAccount, "Default Account");
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
			ExtentTestManager.setInfoMessageInReport("Preferences Updated Successfully");
		} else {
			ExtentTestManager.setPassMessageInReport("Save button is in disabled mode");
		}
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}