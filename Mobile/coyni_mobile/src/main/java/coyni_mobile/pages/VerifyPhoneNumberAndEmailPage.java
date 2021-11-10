package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyPhoneNumberAndEmailPage extends MobileFunctions {

	private By lblPhoneNumber = MobileBy.xpath("");
	private By lblEmail = MobileBy.xpath("");
	private By btnResend = MobileBy.xpath("");
	private By lblResend = MobileBy.xpath("");
	private By txtInputBoxes = MobileBy.xpath("");
	private By txtPin = MobileBy.xpath("");
	private By txtConfirmPin = MobileBy.xpath("");
	private By btnEnable = MobileBy.xpath("");
	private By btnNotNow = MobileBy.xpath("");

	public void verifyPhoneNumber(String expPhoneNumber) {

	}

	public void verifyEmail(String expEmail) {

	}

	public void clickResend() {
		click(btnResend, "Click Resend ");
	}

	public void verifyResend(String expMessage) {

	}

	// DOUBT
	public void fillInputBoxes(String code) {
		enterText(txtInputBoxes, code, "Input Box ");

	}

	// DOUBT
	public void fillPin(String pin) {
		enterText(txtPin, pin, "Fill Pin ");

	}

	// DOUBT
	public void fillConfirmPin(String pin) {
		enterText(txtConfirmPin, pin, "confirm Pin ");

	}

	public void clickEnable() {
		click(btnEnable, "Button Enable ");

	}

	public void clickNotNow() {
		click(btnNotNow, "Button NotNow ");
	}

}
