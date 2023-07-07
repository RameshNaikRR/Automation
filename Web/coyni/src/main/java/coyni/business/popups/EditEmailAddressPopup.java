package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class EditEmailAddressPopup extends BrowserFunctions {

	private By lblEditEmailAddressHeading = By.xpath("");
	private By lblEditEmailAddressDes = By.xpath("");
	private By lblCurrentEmailAddress = By.xpath("");
	private By txtNewEmailAddress = By.xpath("");
	private By btnSendCode = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyEditEmailHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEditEmailAddressHeading, "Heading is: ", expHeading);
	}

	public void verifyEditEmailDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblEditEmailAddressDes, "Description is: ", expDes);
	}

	public void verifyCurrentEmailAddress() {
		String str = getText(lblCurrentEmailAddress, "current Email Address");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void fillNewEmailAddress(String newEmailAddress) {
		enterText(txtNewEmailAddress, newEmailAddress, "New Email Address");

	}

	public void clickSendCode() {
		new CommonFunctions().verifyCursorAction(btnSendCode, "Send Code");
		if (getElement(btnSendCode, "Send Code").isEnabled()) {
			click(btnSendCode, "Send Code");
			ExtentTestManager.setPassMessageInReport("Send Code Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Send Code Button is Disabled");
		}

	}

	public void clickCrossClose() {
		click(crossClose, "Close");
	}

	public CurrentEmailVerificationPopup currentEmailVerificationPopup() {
		return new CurrentEmailVerificationPopup();
	}

}
