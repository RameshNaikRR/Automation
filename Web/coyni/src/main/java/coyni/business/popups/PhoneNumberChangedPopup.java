package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PhoneNumberChangedPopup extends BrowserFunctions {

	private By lblPhoneNumberHeading = By.xpath("");
	private By btnClose = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyPhoneNumberChangedHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPhoneNumberHeading, "Heading is: ", expHeading);
	}

	public void clickClose() {
		if (getElement(btnClose, "Close").isEnabled()) {
			click(btnClose, "Close");
			ExtentTestManager.setPassMessageInReport("Close Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Close Button is Disabled");
		}
	}

	public void clickCrossClose() {
		click(crossClose, "Close");
	}

}
