package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyPhoneNumberPage extends MobileFunctions {
	private By lblCurrPhoneHeading = MobileBy.xpath("//*[contains(@name,'your Current Phone')]");
	private By lblNewPhoneHeading = MobileBy.xpath("//*[contains(@name,'your New Phone')]");
	private By lblCurrPhone = MobileBy.xpath("");
	private By lblNewPhone = MobileBy.xpath("");
	private By txtPin = MobileBy.xpath("//*[contains(@name,'the code')]");
	private By lnkResend = MobileBy.xpath("(//*[@name='Resend'])[1]");

	public void verifyCurrentPhoneHeading(String expCurrPhoneHeading) {
		new CommonFunctions().verifyLabelText(lblCurrPhoneHeading, "heading", expCurrPhoneHeading);
	}

	public void verifyNewPhoneHeading(String expNewPhoneHeading) {
		new CommonFunctions().verifyLabelText(lblNewPhoneHeading, "heading", expNewPhoneHeading);
	}

	public void verifyCurrentPhone(String expCurrPhone) {
		new CommonFunctions().verifyLabelText(lblCurrPhone, "Current Phone", expCurrPhone);
	}

	public void verifyNewPhone(String expNewPhone) {
		new CommonFunctions().verifyLabelText(lblNewPhone, "New Phone", expNewPhone);
	}

	public void fillPin(String pin) {
		new EnterYourPINComponent().fillPin(pin);
	}

	public void verifyPinView() {
		new CommonFunctions().elementView(txtPin, "pin");
	}

	public void clickResend() {
		click(lnkResend, "click Resend");
	}

	public void verifyResendView() {
		new CommonFunctions().elementView(lnkResend, "Resend");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

}
