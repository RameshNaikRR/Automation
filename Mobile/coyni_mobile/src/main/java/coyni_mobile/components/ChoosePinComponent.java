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
	private By lblEnterYourPinHeading = MobileBy.AccessibilityId("Enter Your PIN Heading");
	private By btnLogout = MobileBy.AccessibilityId("Log Out");
	private By btnForgotPin = MobileBy.AccessibilityId("Forgot PIN");
	private By lblChoosePinDes = MobileBy.AccessibilityId("Two-Step Authentication");
	private By lblChooseYourPin = MobileBy.AccessibilityId("Choose Your PIN Heading");
	private By txtPin = MobileBy.xpath("//*[contains(@name,'PIN')]/following-sibling::*[1]");
	private By lblConfirmYourPin = MobileBy.AccessibilityId("Confirm Your PIN Heading");
	private By lblPinErr = MobileBy.AccessibilityId("");
    private By lblPinToastMsg = MobileBy.AccessibilityId("");
    private By txtCvv = MobileBy.AccessibilityId("");
    private By btnBackSpace = MobileBy.AccessibilityId("");

//    Enter your pin screen disabled scenario
    private By lblDisabled = MobileBy.AccessibilityId("Confirm Your PIN Heading");
	private By lblDisableDes = MobileBy.AccessibilityId("");
    private By btnTryAgain = MobileBy.AccessibilityId("");
    private By lblIncorrectPINHeading = MobileBy.AccessibilityId("");
    private By lblIncoPINDesc = MobileBy.AccessibilityId("");
	
	

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	private By getOneNumberOfPin(char num) {
		return MobileBy.xpath(
				String.format("(//*[@text='%s' or @name='%s'])", Character.toString(num), Character.toString(num)));
	}

	public void verifyToastMessage(String toastMsg) {
		new CommonFunctions().verifyLabelText(lblPinToastMsg, "Toast Message", toastMsg);
	}
	public void verifyChooseYourPinView() {
		new CommonFunctions().elementView(lblChooseYourPin, "Choose Your Pin");
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
		new CommonFunctions().clear(txtCvv);
		for (int i = 0; i < field[0].length(); i++) {
			click(getOneNumberOfPin(field[0].charAt(i)), "pin " + field[0].charAt(i));
		}
		System.out.println(field[0].length());
		System.out.println(new CommonFunctions().getTextBoxValue(txtCvv).length());
		if(field[0].length()== new CommonFunctions().getTextBoxValue(txtCvv).length()) {
			System.out.println("for loop i");
			ExtentTestManager.setPassMessageInReport("CVV field is accepting 4 numbers");
		}else {
			ExtentTestManager.setFailMessageInReport("CVV field is not accepting 4 numbers");
		}
		new CommonFunctions().clear(txtCvv);
		click(btnBackSpace, "Backspace");
		for (int j = 0; j < field[1].length(); j++) {	
			click(getOneNumberOfPin(field[1].charAt(j)), "pin " + field[1].charAt(j));	
		}
		System.out.println(field[1].length());
		System.out.println(new CommonFunctions().getTextBoxValue(txtCvv).length());
		if(field[1].length()!= new CommonFunctions().getTextBoxValue(txtCvv).length()) {
			System.out.println("for loop j");
			ExtentTestManager.setPassMessageInReport("CVV field is not accepting 5 numbers");
		}else {
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
		click(btnForgotPin, "forgot Pin");
	}
	
// Enter your pin screen disabled scenario	
	public void viewDisabledHeading() {
		new CommonFunctions().elementView(lblDisabled, "Disabled heading");
		new CommonFunctions().elementView(lblDisableDes, "Disabled description");
	}
	public void clickTryAgain() {
		click(btnTryAgain, "Try Again");
	}
	
	public void viewIncorrectPINHeading() {
		new CommonFunctions().elementView(lblIncorrectPINHeading, "Incorrect PIN heading");
		new CommonFunctions().elementView(lblIncoPINDesc, "Incorrect PIN description");
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
}
