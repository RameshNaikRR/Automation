package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.DashboardPage;
import coyni_mobile.pages.EnableFaceOrTouchIDpage;
import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ChoosePinComponent extends MobileFunctions {
	private By lblEnterYourPin = MobileBy.AccessibilityId("");
	private By btnLogout = MobileBy.AccessibilityId("");
	private By btnForgotPin = MobileBy.AccessibilityId("");
	private By lblChoosePinDes = MobileBy.AccessibilityId("");
	private By lblChooseYourPin = MobileBy.AccessibilityId("");
	private By txtPin = MobileBy.xpath("//*[contains(@name,'PIN')]/following-sibling::*[1]");
	private By lblConfirmYourPin = MobileBy.AccessibilityId("");
	private By lblPinErr = MobileBy.AccessibilityId("");

	private By getOneNumberOfPin(char num) {

		return MobileBy.xpath(String.format("(//*[@text='%s' or @name='%s'])", Character.toString(num), Character.toString(num)));

	}

	public void verifyChooseYourPinView() {
		new AndroidCommonFunctions().elementView(lblChooseYourPin, "Choose Your Pin");
		ExtentTestManager.setInfoMessageInReport("The Text is :" + getText(lblChoosePinDes));
	}

	public void fillPin(String pin) {
		enterText(txtPin, pin, "pin");
	}

	public void fillPins(String pin) {

		System.out.println(pin.length());

		for (int i = 0; i < pin.length(); i++) {

			click(getOneNumberOfPin(pin.charAt(i)), "pin " + pin.charAt(i));

		}

	}

	public void verifyConfirmYourPinView() {
		new AndroidCommonFunctions().elementView(lblConfirmYourPin, "Confirm Your Pin");
	}

	public void verifyEnterYourPinView() {
		new AndroidCommonFunctions().elementView(lblEnterYourPin, "Enter Pin");
	}

	public void verifyLogoutView() {
		new AndroidCommonFunctions().elementView(btnLogout, "Logout");
	}

	public void verifyForgotPinView() {
		new AndroidCommonFunctions().elementView(btnForgotPin, "Forgot Pin");
	}

	public void clickLogout() {
		click(btnLogout, "Logout");
	}

	public void clickForgotPin() {
		click(btnForgotPin, "forgot Pin");
	}

	public EnableFaceOrTouchIDpage enableFaceOrTouchIDpage() {
		return new EnableFaceOrTouchIDpage();
	}

	public DashboardPage dashboardPage() {
		return new DashboardPage();
	}
	
	public PhoneAndEmailVerificationComponent  phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}
}
