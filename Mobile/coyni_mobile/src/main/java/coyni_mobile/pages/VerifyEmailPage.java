package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyEmailPage extends MobileFunctions {
	private By lblCurrEmailHeading = MobileBy.xpath("//*[contains(@text,'your Current')]");
	private By lblNewEmailHeading = MobileBy.xpath("//*[contains(@text,'Verify New')]");
	private By lblCurrentEmail = MobileBy.xpath("//*[contains(@resource-id,'subHeader')]");
	private By lblNewEmail = MobileBy.xpath("//*[contains(@resource-id,'subHeader')]");
	private By txtPin = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By lblGetCode= MobileBy.xpath("//*[contains(@text,'the code')]");
	private By lnkResend = MobileBy.xpath("//*[@text='Resend']");

	public void verifyCurrentEmailHeading(String expCurrEmailHeading) {
		new CommonFunctions().verifyLabelText(lblCurrEmailHeading, "heading", expCurrEmailHeading);
	}
	public void verifyCurrentEmailPageView() {
		new CommonFunctions().elementView(lblNewEmailHeading, "verify current email page");
	}
public void verifyGetCodeLabelView() {
	new CommonFunctions().elementView(lblGetCode, "Didn't get the code");
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
		enterText(txtPin, pin, "pin");
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
