package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.EnableFaceIDpage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EnterYourPINComponent extends MobileFunctions {
	private By heading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By pinCircles = MobileBy.xpath("//*[contains(@resource-id,'pinLL')]");
	private By lnkForgotPin = MobileBy.xpath("//*[contains(@resource-id,'tvForgot')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'imgBack')]");

	WebDriverWait wait= new WebDriverWait(DriverFactory.getDriver(), 60);
	private By getOneNumberOfPin(char num) {
		return MobileBy.xpath(
				String.format("(//*[@text='%s' or @name='%s'])", Character.toString(num), Character.toString(num)));
	}

	public void fillPin(String pin) {
		System.out.println(pin.length());
		for (int i = 0; i < pin.length(); i++) {
			wait.until(ExpectedConditions.presenceOfElementLocated(getOneNumberOfPin(pin.charAt(i))));
			click(getOneNumberOfPin(pin.charAt(i)), "pin " + pin.charAt(i));
		}
	}

	public void clickForgotPin() {
		click(lnkForgotPin, "click Forgot Pin");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}
	
	public void verifyPinView() {
		new CommonFunctions().elementView(pinCircles, "Circles in Enter your PIN screen");
	}

	public void verifyForgotPinView() {
		new CommonFunctions().elementView(lnkForgotPin, "Forgot Pin");
	}

	public void verifyEnterYourPinView(String pinHeading) {
		wait.until(ExpectedConditions.presenceOfElementLocated(heading));
		new CommonFunctions().verifyLabelText(heading, "Enter Your PIN",pinHeading);
//		new CommonFunctions().elementView(heading, "Enter Your PIN");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
	}

	public EnableFaceIDpage enableFaceIDpage() {
		return new EnableFaceIDpage();
	}

//	public ForgotPinComponent forgotPinComponent() {
//		return new ForgotPinComponent();
//	}

//	public EditEmailPage editEmailPage() {
//		return new EditEmailPage();
//	}
	public ForgotPinComponent forgotPinComponent() {
		return new ForgotPinComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

//
//	public EditPhoneNumberPage editPhoneNumberPage() {
//		return new EditPhoneNumberPage();
//	}
	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
//	public EditAddressPage editAddressPage() {
//		return new EditAddressPage();
//	}

//	public NavigationComponent navigationComponent() {
//		return new NavigationComponent();
//	}
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}
}
