package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class EditPhoneNumberPopup extends BrowserFunctions {

	private By lblEditPhoneNumHeading = By.xpath("");
	private By lblEditPhoneNumberDes = By.xpath("");
	private By lblCurrentPhoneNumber = By.xpath("");
	private By txtNewPhoneNumber = By.xpath("");
	private By btnSendCode = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyEditPhoneNumberHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEditPhoneNumHeading, "Edit Phone Number Heading is: ", expHeading);
	}

	public void verifyEditPhoneNumberDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblEditPhoneNumberDes, "Edit Phone Number Description is: ", expDes);
	}

	public void verifyCurrentPhoneNumber(String expPhoneNum) {
		new CommonFunctions().verifyLabelText(lblCurrentPhoneNumber, "Current Phone Number is: ", expPhoneNum);
	}

	public void fillNewPhoneNumber(String newPhoneNumber) {
		new CommonFunctions().verifyCursorAction(txtNewPhoneNumber, "New Phone Number");
		enterText(txtNewPhoneNumber, newPhoneNumber, "New Phone Number");
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
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public CurrentPhoneNumberVerificationPopup currentPhoneNumberVerificationPopup() {
		return new CurrentPhoneNumberVerificationPopup();
	}

}
