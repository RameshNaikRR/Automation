package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.business.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PreferencesPage extends BrowserFunctions {

	private By btnSave = By.xpath("//button[text()='Save']");
	private By defaultBusiness = By.xpath("");
	private By chooseBusiness = By.xpath("");
	private By dropDownIcon = By.xpath("//img[@src='/static/media/arrow-right.3014e1fb88e2fed86fbb76e783121d86.svg']");

	public By getElement(String timeZone) {
		return By.xpath(String.format("//div[text()='%s']", timeZone));
	}

	public void selectBusiness(String business) {
		new CommonFunctions().verifyCursorAction(chooseBusiness, "Business");
		String str = getElement(chooseBusiness, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(chooseBusiness, "Business");
		// click(getElement(timeZone), timeZone);
	}

	public void dropDownIcon() {
		new CommonFunctions().elementView(dropDownIcon, "DropDown");
	}

	public void defaultBusiness() {
		new CommonFunctions().verifyCursorAction(defaultBusiness, "Default Business");
		click(defaultBusiness, "Default Business");
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
