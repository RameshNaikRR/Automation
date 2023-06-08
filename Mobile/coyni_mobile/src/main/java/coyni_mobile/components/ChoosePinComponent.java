package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.DashboardPage;
import coyni_mobile.pages.EnableFaceOrTouchIDpage;
import coyni_mobile.utilities.CommonFunctions;
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
		new CommonFunctions().elementView(lblChooseYourPin, "Choose Your Pin");
	}
	
	public void verifyChooseYouPinDes(String desc) {
		new CommonFunctions().verifyLabelText(lblChoosePinDes, "Desc", desc);
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
		new CommonFunctions().elementView(lblConfirmYourPin, "Confirm Your Pin");
	}

	public void verifyEnterYourPinView() {
		new CommonFunctions().elementView(lblEnterYourPin, "Enter Pin");
	}

	public void verifyEnterYourPinhdg(String hdg) {
		new CommonFunctions().verifyLabelText(lblEnterYourPin, "Enter Your Pin", hdg);
	}
	public void verifyConfirmYourPin(String hdg) {
		new CommonFunctions().verifyLabelText(lblConfirmYourPin, "Confirm Your Pin", hdg);
	}
	public void verifyChooseYourPin(String hdg) {
		new CommonFunctions().verifyLabelText(lblChooseYourPin, "Choose Your Pin", hdg);
	}
	
	public void verifyLogoutView() {
		new CommonFunctions().elementView(btnLogout, "Logout");
	}

	public void verifyForgotPinView() {
		new CommonFunctions().elementView(btnForgotPin, "Forgot Pin");
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
	public CreatePasswordComponent createPasswordComponent() {
		return new CreatePasswordComponent();
	}
}
