package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ControlsPage extends BrowserFunctions {

	private By lblControls = By.xpath("");
	private By btnDisableAll = By.xpath("");
	private By btnEnableAll = By.xpath("");
	private By btnCancel = By.xpath("");
	private By btnSave = By.xpath("");

	public void verifyControls(String expHeading) {
		new CommonFunctions().verifyLabelText(lblControls, "Heading is: ", expHeading);
	}

	public void clickDisableAll() {
		click(btnDisableAll, "Disable All");
	}

	public void clickEnableAll() {
		click(btnEnableAll, "Enable All");
	}

	public void clickCancel() {
		if (getElement(btnCancel, "Cancel").isEnabled()) {
			click(btnCancel, "Cancel");
			ExtentTestManager.setPassMessageInReport("Cancel Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Cancel Button is Disabled");
		}

	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
			ExtentTestManager.setPassMessageInReport("Save Button is Enabled");
		} else {
			ExtentTestManager.setPassMessageInReport("Save Button is Disabled");
		}

	}

}
