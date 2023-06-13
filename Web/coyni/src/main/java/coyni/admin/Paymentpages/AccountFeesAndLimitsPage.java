package coyni.admin.Paymentpages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AccountFeesAndLimitsPage extends BrowserFunctions {

	private By lblAccountFeesAndLimits = By.xpath("");
	private By lnkEditFeesAndLimits = By.xpath("");
	private By btnCancel = By.xpath("");
	private By btnSave = By.xpath("");

	public void verifyAccountFeesAndLimits(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAccountFeesAndLimits, "Heading is: ", expHeading);
	}

	public void clickEditFeesAndLimits() {
		click(lnkEditFeesAndLimits, "Edit Fees & Limit");
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
