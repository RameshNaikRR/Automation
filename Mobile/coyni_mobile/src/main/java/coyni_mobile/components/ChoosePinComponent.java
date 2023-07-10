package coyni_mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.pages.DashboardPage;
import coyni_mobile.pages.EnableFaceOrTouchIDpage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ChoosePinComponent extends MobileFunctions {
//	Enter Your PIN Details
	private By lblEnterYourPinHeading = MobileBy.AccessibilityId("Enter Your PIN Heading");
	private By btnLogout = MobileBy.AccessibilityId("logoutLL");
	private By btnForgotPin = MobileBy.xpath("//*[@text='Forgot PIN']");

//	Forgot PIN Details
	private By lblForgotPINHeadi = MobileBy.xpath("//*[@text='Forgot Your PIN?']");
	private By lblForgotDesc = MobileBy.AccessibilityId("Email Verification Text");
	private By btnNext = MobileBy.id("com.coyni.mapp:id/tvButton");
	private By txtEmail = MobileBy.id("com.coyni.mapp:id/emailET");

//	Choose Your PIN Details
	private By lblChoosePinDes = MobileBy.AccessibilityId("Two-Step Authentication");
	private By lblChooseYourPin = MobileBy.AccessibilityId("Choose Your PIN Heading");
	private By txtPin = MobileBy.xpath("//*[contains(@name,'PIN')]/following-sibling::*[1]");
	private By lblConfirmYourPin = MobileBy.AccessibilityId("Confirm Your PIN Heading");
	private By lblPinErr = MobileBy.xpath("");
	private By txtCvv = MobileBy.xpath("");
	private By btnBackSpace = MobileBy.xpath("");

//    Enter your pin screen disabled scenario
	private By lblDisabled = MobileBy.xpath("//*[@text='Disabled']");
	private By lblDisableDes = MobileBy.xpath("//*[@text='Please try again in 10 minutes.']");
	private By btnTryAgain = MobileBy.id("com.coyni.mapp:id/tryAgainTV");
	private By lblIncorrectPINHeading = MobileBy.xpath("//*[@text='Incorrect PIN']");
	private By lblIncoPINDesc = MobileBy.xpath("//*[contains(@text,'Sorry,')]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	private By getOneNumberOfPin(char num) {
		return MobileBy.xpath(
				String.format("(//*[@text='%s' or @name='%s'])", Character.toString(num), Character.toString(num)));
	}

	public void verifyChooseYourPinView(String heading) {
		new CommonFunctions().verifyLabelText(lblChooseYourPin, "Choose Your Pin", heading);
	}

	public void verifyChooseYouPinDes(String desc) {
		new CommonFunctions().verifyLabelText(lblChoosePinDes, "Desc", desc);
	}

	public void fillPin(String pin) {
		System.out.println(pin.length());
		for (int i = 0; i < pin.length(); i++) {
			wait.until(ExpectedConditions.presenceOfElementLocated(getOneNumberOfPin(pin.charAt(i))));
			click(getOneNumberOfPin(pin.charAt(i)), "pin " + pin.charAt(i));
		}

	}

	public void fillPins(String pin) {
		System.out.println(pin.length());
		for (int i = 0; i < pin.length(); i++) {
			click(getOneNumberOfPin(pin.charAt(i)), "pin " + pin.charAt(i));
		}
	}

	public void validateCVVorCVC(String pin) {
		String[] field = pin.split(",");
//		new CommonFunctions().clear(txtCvv);
		for (int i = 0; i < field[0].length(); i++) {
			click(getOneNumberOfPin(field[0].charAt(i)), "pin " + field[0].charAt(i));
		}
		System.out.println(field[0].length());
		System.out.println(new CommonFunctions().getTextBoxValue(txtCvv).length());
		if (field[0].length() == new CommonFunctions().getTextBoxValue(txtCvv).length()) {
			System.out.println("for loop i");
			ExtentTestManager.setPassMessageInReport("CVV field is accepting 4 numbers");
		} else {
			ExtentTestManager.setFailMessageInReport("CVV field is not accepting 4 numbers");
		}
//		new CommonFunctions().cleart(txtCvv);
		click(btnBackSpace, "Backspace");
		for (int j = 0; j < field[1].length(); j++) {
			click(getOneNumberOfPin(field[1].charAt(j)), "pin " + field[1].charAt(j));
		}
		System.out.println(field[1].length());
		System.out.println(new CommonFunctions().getTextBoxValue(txtCvv).length());
		if (field[1].length() != new CommonFunctions().getTextBoxValue(txtCvv).length()) {
			System.out.println("for loop j");
			ExtentTestManager.setPassMessageInReport("CVV field is not accepting 5 numbers");
		} else {
			ExtentTestManager.setFailMessageInReport("CVV field is accepting 5 numbers");
		}
		click(btnBackSpace, "Backspace");
	}

	public void verifyEnterYourPinhdg(String hdg) {
		new CommonFunctions().verifyLabelText(lblEnterYourPinHeading, "Enter Your Pin", hdg);
	}

//	public void verifyConfirmYourPinView() {
//		new CommonFunctions().verifyLabelText(btnForgotPin, getCopiedData(), getCopiedData());
//	}

	public void verifyEnterYourPinView() {
		new CommonFunctions().elementView(lblEnterYourPinHeading, "Enter Your Pin");
	}

	public void verifyEnterYourPinheading(String hdg) {
		new CommonFunctions().verifyLabelText(lblEnterYourPinHeading, "Enter Your Pin", hdg);
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
		click(btnForgotPin, "Forgot Pin");
	}

// Enter your pin screen disabled scenario	
	public void verifyDisabledHeading(String hdg, String desc) {
		new CommonFunctions().verifyLabelText(lblDisabled, "Disabled heading", hdg);
		new CommonFunctions().verifyLabelText(lblDisableDes, "Disabled description", desc);
	}

	public void validateDisabledState() {
		clickLogout();
	}

	public void clickTryAgain() {
		click(btnTryAgain, "Try Again");
	}

	public void viewIncorrectPINHeading() {
		new CommonFunctions().elementView(lblIncorrectPINHeading, "Incorrect PIN heading");
		new CommonFunctions().elementView(lblIncoPINDesc, "Incorrect PIN description");
	}

//	Forgot Pin Screen Details
	public void verifyForgotPINHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblForgotPINHeadi, "Forgot PIN heading", hdg);
	}

	public void verifyForgotPINDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblForgotDesc, "Forgot PIN description", desc);
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void validateNext() {
		new CommonFunctions().verifyDisabledElement(btnNext, "Next");
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public EnableFaceOrTouchIDpage enableFaceOrTouchIDpage() {
		return new EnableFaceOrTouchIDpage();
	}

	public DashboardPage dashboardPage() {
		return new DashboardPage();
	}

	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}

	public CreatePasswordComponent createPasswordComponent() {
		return new CreatePasswordComponent();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
