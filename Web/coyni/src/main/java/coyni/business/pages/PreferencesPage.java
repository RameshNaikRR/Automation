package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PreferencesPage extends BrowserFunctions {

	private By lblPreferences = By.xpath("");
	private By lblDes = By.xpath("");
	private By drpdwnBusiness = By.xpath("");
	private By btnSave = By.xpath("");

	public void verifyPreferencesHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPreferences, "Heading is: ", expHeading);
	}

	public void verifyPreferencesDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description is: ", expDes);
	}

	public void selectDefaultBusiness(String defaultBusiness) {
		click(drpdwnBusiness, "Default Business");
		new CommonFunctions().selectCustomDropDown(defaultBusiness, "Defauilt Business");
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
			ExtentTestManager.setPassMessageInReport("Save Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Save Button is Disabled");
		}
	}

}
