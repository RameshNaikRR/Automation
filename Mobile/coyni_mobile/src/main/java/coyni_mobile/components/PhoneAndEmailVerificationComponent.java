package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.SecureAccountPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PhoneAndEmailVerificationComponent extends MobileFunctions {

	private By phoneHeading = MobileBy.xpath("//*[@name='Please Verify your Phone Number']");
	private By emailHeading = MobileBy.xpath("//*[@name='Please Verify your Email']");

	public void verifyPhoneHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(phoneHeading, "Heading", expHeading);
	}

	public void verifyEmailHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(emailHeading, "Heading", expHeading);
	}

	public void fillPin(String pin) {
		new EnterYourPINComponent().fillPin(pin);
	}

	public SecureAccountPage secureAccountPage() {
		return new SecureAccountPage();
	}

}
