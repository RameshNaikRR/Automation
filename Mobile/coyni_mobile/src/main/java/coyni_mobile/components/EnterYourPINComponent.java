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
	private By heading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]|//*[@name='Enter your PIN']");
	private By pinCircles = MobileBy.xpath("//*[contains(@resource-id,'pinLL')]|(//*[@name='Forgot PIN'])[1]/preceding-sibling::*[1]");
	private By lnkForgotPin = MobileBy.xpath("//*[contains(@resource-id,'tvForgot')]|(//*[@name='Forgot PIN'])[1]");
	private By lblErrorMsg = MobileBy.xpath("");

	private By getOneNumberOfPin(char num) {
		return MobileBy.xpath(String.format("(//*[@text='%s' or @name='%s'])", Character.toString(num),Character.toString(num)));
	}

	public void fillPin(String pin) {
		System.out.println(pin.length());
		for (int i = 0; i <pin.length(); i++) {
			click(getOneNumberOfPin(pin.charAt(i)), "pin " + pin.charAt(i));
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
	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
	public EditAddressPage editAddressPage() {
		return new EditAddressPage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	public SecurePayPopup securePayPopup() {
		return new SecurePayPopup();
	}
}
