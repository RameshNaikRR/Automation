package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.PhoneAndEmailVerificationComponent;
import coyni_mobile.components.ToastComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class LoginPage extends MobileFunctions {
	private By imgCoyni = MobileBy.AccessibilityId("coyni Logo");
	private By txtEmail = MobileBy.AccessibilityId("Email Text Field");
	private By txtPassword = MobileBy.AccessibilityId("Password");
	private By chkBxRememberMe = MobileBy.AccessibilityId("Remember Me");
	private By lblRememberMe = MobileBy.AccessibilityId("");
	private By lnkForgotPassword = MobileBy.AccessibilityId("Forgot Password");
	private By lnkRetrieveEmail = MobileBy.AccessibilityId("Retrieve Email");
	private By btnLogin = MobileBy.AccessibilityId("");
	private By lblForgotYourPassword = MobileBy.AccessibilityId("Forgot Your Password?");
	private By lblForgotPwdDesc = MobileBy.AccessibilityId("Enter your registered email.");
	private By btnNext = MobileBy.AccessibilityId("Next");
	private By lblRetrieveEmail = MobileBy.AccessibilityId("");
	private By retrieveEmailDesc = MobileBy.AccessibilityId("");
	private By imgFlag = MobileBy.AccessibilityId("");
	private By txtPhoneNumber = MobileBy.AccessibilityId("");
	private By txtFirstName = MobileBy.AccessibilityId("");
	private By txtLastName = MobileBy.AccessibilityId("");
	private By imgNoUserFound = MobileBy.AccessibilityId("");
	private By lblNoUserFound = MobileBy.AccessibilityId("");
	private By noUserDesc = MobileBy.AccessibilityId("");
	private By btnTryAgain = MobileBy.AccessibilityId("");
	private By btnCancel = MobileBy.AccessibilityId("");
	private By lblWeFoundAccount = MobileBy.AccessibilityId("");
	private By imgWeFoundAccounnt = MobileBy.AccessibilityId("");
	private By lblUserName = MobileBy.AccessibilityId("");
	private By btnRetrieveLogin = MobileBy.AccessibilityId("");
	private By btnThisisNotMe = MobileBy.AccessibilityId("");
	private By lblInvalidDesc = MobileBy.AccessibilityId("");
	private By popUperror = MobileBy.AccessibilityId("");
	private By btnOkay = MobileBy.AccessibilityId("");
//	PIN disabled popup
	private By lblPINDisHead = MobileBy.AccessibilityId("");
	private By lblPINDisDes = MobileBy.AccessibilityId("");
	private By btnPINDisOk = MobileBy.AccessibilityId("");

	public void verifyImageCoyniView() {
		new CommonFunctions().elementView(imgCoyni, "Coyni");
	}

	public void verifyLoginEmail(String email) {
		new CommonFunctions().verifyLabelText(txtEmail, "email", email);
	}

	public void clickEmail() {
		click(txtEmail, "Email");
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "email");
	}

	public void clcikPassword() {
		click(txtPassword, "password");
	}

	public void verifyLogin(String email, String password) {
		if (getElement(imgCoyni, "coyni image").isDisplayed()) {
			fillEmail(email);
			fillPassword(password);
			clickLogin();
		}
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "password ");
	}

	public void clickRememberMe() {
		click(chkBxRememberMe, "Remember");
	}

	public void verifyRememberMeView() {
		new CommonFunctions().elementView(lblRememberMe, "Rememeber Me");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "Forgot Password ");
	}

	public void clickRetrieveEmail() {
		click(lnkRetrieveEmail, "Retrieve Email ");
	}

	public void verifyRetrieveEmailView() {
		new CommonFunctions().elementView(lnkRetrieveEmail, "Retrieve Email");
	}

	public void verifyRetrievEmailhdgView(String desc) {
		new CommonFunctions().elementView(lblRetrieveEmail, "RetrieveEmail");
		new CommonFunctions().verifyLabelText(retrieveEmailDesc, "retrieve Email desc", desc);
	}

	public void fillPhoneNumber(String phoneNum) {
		new CommonFunctions().elementView(imgFlag, "Flag");
		enterText(txtPhoneNumber, phoneNum, "PhoneNumber");
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
	}

	public void verifyForgotPasswordView() {
		new CommonFunctions().elementView(lnkForgotPassword, "forgotPassword");
	}

	public void verifyNoUserFound(String desc) {
		new CommonFunctions().elementView(imgNoUserFound, "No User found image");
		new CommonFunctions().elementView(lblNoUserFound, "No user Found");
		new CommonFunctions().verifyLabelText(noUserDesc, "No user found desc", desc);
	}

	public void verifyWeFoundYourAccount() {
		new CommonFunctions().elementView(imgWeFoundAccounnt, "image");
		new CommonFunctions().elementView(lblWeFoundAccount, "We found your Account");
		new CommonFunctions().elementView(lblUserName, "userName");
	}

	public void clickRetrieveLogin() {
		if (getElement(btnRetrieveLogin, "Login").isEnabled()) {
			click(btnRetrieveLogin, "Login");
		} else {
			ExtentTestManager.setInfoMessageInReport("Login button is disabled");
		}
	}

	public void clickThisisNotMe() {
		if (getElement(btnThisisNotMe, "This is Not Me").isEnabled()) {
			click(btnThisisNotMe, "ThisisNotMe");
		} else {
			ExtentTestManager.setInfoMessageInReport("ThisisNotMe button is disabled");
		}
	}

	public void clickTryAgain() {
		if (getElement(btnTryAgain, "Tryb Again").isEnabled()) {
			click(btnTryAgain, "Try Again");
		} else {
			ExtentTestManager.setInfoMessageInReport("Try Again Button is disabled");
		}
	}

	public void clickcancel() {
		if (getElement(btnCancel, "Cancel").isEnabled()) {
			click(btnCancel, "btnCancel");
		} else {
			ExtentTestManager.setInfoMessageInReport("Cancel Button is disabled");
		}
	}

	public void verifyForgotYourPasswordview(String desc) {
		new CommonFunctions().elementView(lblForgotYourPassword, "Forgot Your Password");
		new CommonFunctions().verifyLabelText(lblForgotPwdDesc, "Description", desc);
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setInfoMessageInReport("Next button is disabled");
		}
	}

	public void clickLogin() {
		if (getElement(btnLogin, "login").isEnabled()) {
			click(btnLogin, "login button");
		} else {
			ExtentTestManager.setInfoMessageInReport("login button  is disabled");
		}
	}

	public SignUpPage signUpPage() {
		return new SignUpPage();
	}

	/**
	 * Order - minChar, max, MaxiPlus
	 * 
	 * @throws InterruptedException
	 */
	public void validateCreatePasswordfields(String password) {
		String[] field = password.split(",");
		for (int i = 0; i < 2; i++) {
			new CommonFunctions().validateTextFeild(txtPassword, "password", field[i]);
//		new CommonFunctions().validateField(txtNewPassword, "password", field[1]);
		}
		new CommonFunctions().validateFieldMaxichar(txtPassword, "password", field[2]);
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}

	public void verifyPopupDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblInvalidDesc, "PopupMessage", expDescription);
	}

	private void minimizePopup() {
		if (DriverFactory.getDriver().findElement(btnLogin).isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Invalid credentials error popup closed");
		} else {
			ExtentTestManager.setFailMessageInReport("Invalid credentilas error popup not closed");
		}
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}

	public void minimizePopupBySwipeDown() {
		swipeOnElement(popUperror, "popUp", SwipeDirection.DOWN);
		minimizePopup();
	}

	public void minimizePopupByClikingOK() {
		click(btnOkay, "OK button");
		minimizePopup();
	}

	public void verifyForgotYourPWdHeading(String hdg) {
		new CommonFunctions().elementView(lblForgotYourPassword, "Forgot Your Password");
	}

	public void selectCountry(String country) {
		new SignUpPage().clickDopdown();
		new SignUpPage().fillSearch(country);
	}

//	PIN Disabled popup details
	public void viewDisabledPINPopup() {
		new CommonFunctions().elementView(lblPINDisHead, "Disabled popup heading");
		new CommonFunctions().elementView(lblPINDisDes, "Disabled popup description");
	}

	public void clickDisPINOk() {
		click(btnPINDisOk, "Ok");
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}