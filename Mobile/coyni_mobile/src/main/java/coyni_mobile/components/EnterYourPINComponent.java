package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.EditAddressPage;
import coyni_mobile.pages.EditEmailPage;
import coyni_mobile.pages.EditPhoneNumberPage;
import coyni_mobile.pages.EnableFaceIDpage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EnterYourPINComponent extends MobileFunctions {
	private By heading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By pinCircles = MobileBy.xpath("//*[contains(@resource-id,'pinLL')]");
	private By lnkForgotPin = MobileBy.xpath("");
	private By lblErrorMsg = MobileBy.xpath("");

	private By getOneNumberOfPin(char num) {
		return MobileBy.xpath(String.format("(//*[@text='%s'])", Character.toString(num)));
	}

	public void fillPin(String pin) {
		System.out.println(pin.length());
		for (int i = 0; i <pin.length(); i++) {
			click(getOneNumberOfPin(pin.charAt(i)), "pin " + i);
		}
	}

	public void clickForgotPin() {
		click(lnkForgotPin, "click Forgot Pin");
	}

	public void verifyPinView() {
		new CommonFunctions().elementView(pinCircles, "Circles in Enter your PIN screen");
	}

	public void verifyForgotPinView() {
		new CommonFunctions().elementView(lnkForgotPin, "Forgot Pin");
	}

	public void verifyEnterYourPinView() {
		new CommonFunctions().elementView(heading, "Enter Your PIN");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
	}

	public EnableFaceIDpage enableFaceIDpage() {
		return new EnableFaceIDpage();
	}

	public ForgotPinComponent forgotPinComponent() {
		return new ForgotPinComponent();
	}

	public EditEmailPage editEmailPage() {
		return new EditEmailPage();
	}

	public EditPhoneNumberPage editPhoneNumberPage() {
		return new EditPhoneNumberPage();
	}

	public EditAddressPage editAddressPage() {
		return new EditAddressPage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
