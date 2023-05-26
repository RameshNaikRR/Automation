package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.business.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CurrentPhoneNumberVerificationPopup extends BrowserFunctions {

	private By lblCurrentPhoneHeading = By.xpath("");
	private By lblCurrentPhoneDes = By.xpath("");
	private By backArrow = By.xpath("");
	private By crossClose = By.xpath("");
	private By lnkResendCode = By.xpath("");

	public void verifyCurrentPhoneVerificationHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCurrentPhoneHeading, "Heading is: ", expHeading);
	}

	public void verifyCurrentPhoneVerificationDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblCurrentPhoneDes, "Description is: ", expDes);
	}

	public void fillPin(String code) {
		new AuthyComponent().fillInput(code);
	}

	public void clickBackArrow() {
		new CommonFunctions().verifyCursorAction(backArrow, "Back Arrow");
		click(backArrow, "Back Arrow");
	}

	public void clickCrossClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public void clickResendCode() {
		new CommonFunctions().verifyCursorAction(lnkResendCode, "Resend Code");
		click(lnkResendCode, "Resend Code");
	}

	public NewPhoneVerificationPopup newPhoneVerificationPopup() {
		return new NewPhoneVerificationPopup();
	}

}
