package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyEmailPage extends MobileFunctions {
	private By lblCurrEmailHeading = MobileBy.xpath("//*[contains(@name,'your Current')]");
	private By lblNewEmailHeading = MobileBy.xpath("//*[contains(@name,'Verify New ')]");
	private By lblCurrentEmail = MobileBy.xpath("");
	private By lblNewEmail = MobileBy.xpath("");
	private By txtPin = MobileBy.xpath("//*[contains(@name,'the code')]");
	private By lnkResend = MobileBy.xpath("(//*[@name='Resend'])[1]");

	public void verifyCurrentEmailHeading(String expCurrEmailHeading) {
		new CommonFunctions().verifyLabelText(lblCurrEmailHeading, "heading", expCurrEmailHeading);
	}

	public void verifyNewEmailHeading(String expNewEmailHeading) {
		new CommonFunctions().verifyLabelText(lblNewEmailHeading, "heading", expNewEmailHeading);
	}

	public void verifyCurrentEmail(String expCurrEmail) {
		new CommonFunctions().verifyLabelText(lblCurrentEmail, "Current Email", expCurrEmail);
	}

	public void verifyNewEmail(String expNewEmail) {
		new CommonFunctions().verifyLabelText(lblNewEmail, "New Email", expNewEmail);
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
