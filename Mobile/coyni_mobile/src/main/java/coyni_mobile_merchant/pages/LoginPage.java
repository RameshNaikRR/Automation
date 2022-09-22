package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.components.NavigationComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class LoginPage extends MobileFunctions {

	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'etEmail')] | (//*[contains(@name,'Email')])[1]");
	private By txtPassword = MobileBy
			.xpath("//*[contains(@resource-id,'etPassword')] | (//*[contains(@name,'Password')])[1]");
	private By lnkRetrieveEmail = MobileBy
			.xpath("//*[contains(@resource-id,'tvRetEmail')] | (//*[contains(@name,'Retrieve Email')])[1]");
	private By lnkForgotPassword = MobileBy
			.xpath("//*[contains(@resource-id,'forgotpwd')]|(//*[@name ='Forgot Password'])[1]");
	private By chkBxRememberMe = MobileBy
			.xpath("//*[contains(@resource-id,'chkRemember')]| //*[@name='Remember Me']/preceding-sibling::*[1]");
	private By btnLogin = MobileBy.xpath("//*[contains(@resource-id,'nextBtn')]|(//*[@name='Log in'])[1]|//*[contains(@text,'Log in')]");
	private By lblCoyni = MobileBy.xpath("//*[contains(@resource-id,'loginBGIV')]|//*[@name='coyni-logo-full']");
	private By lblerrMsg = MobileBy
			.xpath("(//*[contains(@text,'is incorrect')])[1]|(//*[contains(@label,'is incorrect')])[1]|//*[contains(@resource-id,'tvMessage')]");
	private By popUperror = MobileBy
			.xpath("//*[contains(@resource-id,'design_bottom_sheet')]|(//*[contains(@label,'is incorrect')])[1]/..");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'okBtn')]|(//*[@name='OK'])[1]|//*[contains(@resource-id,'tvAction')]");
	private By btnCross = MobileBy.xpath("");
	private By iconFace = MobileBy.xpath("");

	public void clickOk() {
		click(btnOk, "ok");
	}

	public void clickFace() {
		click(iconFace, "Face Icon");
	}

	public void VerifyFaceView() {
		new CommonFunctions().elementView(iconFace, "Face Icon");
	}

//    public FaceIDnotAvailableComponent faceIDnotAvailableComponent() {
//    	return new FaceIDnotAvailableComponent();
//    }
	public void fillEmail(String email) {
		click(txtEmail, "email");
		enterText(txtEmail, email, "Email ");
	}

	public void clickCross() {
		click(btnCross, "Cross");
	}

	public void verifyEmailview() {
		new CommonFunctions().elementView(txtEmail, "email");
	}

	public void verifyPasswordview() {
		new CommonFunctions().elementView(txtPassword, "password");
	}

	public void verifyRememberMeView() {
		new CommonFunctions().elementView(chkBxRememberMe, "Remember me");
	}

	public void verifyRetrieveView() {
		new CommonFunctions().elementView(lnkRetrieveEmail, "Retrieve email");
	}

	public void verifyPopupMsg(String expText) {
		new CommonFunctions().verifyLabelText(lblerrMsg, "PopupMessage", expText);
	}

	private void minimizePopup() {
		if (DriverFactory.getDriver().findElement(btnLogin).isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Invalid credentials error popup closed");
		} else {
			ExtentTestManager.setFailMessageInReport("Invalid credentilas error popup not closed");
		}
	}

	public void minimizePopupBySwipeDown() {
		swipeOnElement(popUperror, "popUp", SwipeDirection.DOWN);
		minimizePopup();
	}

	public void minimizePopupByClikingOK() {
		click(btnOk, "OK button");
		minimizePopup();
	}

	public void fillPassword(String password) {
		click(txtPassword, "password");
		enterText(txtPassword, password, "password ");
	}

	public void clickEmail() {
		click(txtEmail, "email");
	}

	public void clickPassword() {
		click(txtPassword, "password");
	}

	public void clickRetrieveEmail() {
		click(lnkRetrieveEmail, "Retrieve Email ");

	}

	public void clickForgotEmail() {
		click(lnkRetrieveEmail, "Retrieve Email ");

	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "Forgot Password ");

	}

	public void clickRememberMe() {
		click(chkBxRememberMe, "Remember");
	}

	public void VerifyLoginPageView() {
		new CommonFunctions().elementView(chkBxRememberMe, "Login Page");
	}

//	public void clickEnter() {
//		((AndroidDriver)DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.TAB));
//		
//	}

	public void clickLogin() {
		if (getElement(btnLogin, "login").isEnabled()) {
			click(btnLogin, "login button");
		} else {
			ExtentTestManager.setInfoMessageInReport("login button  is disabled");
		}
	}

	public void ViewCoyni() {
		new CommonFunctions().elementView(lblCoyni, "Coyni");
	}

//	public FaceIDDisabledComponent faceIDDisabledComponent() {
//		return new FaceIDDisabledComponent();
//	}

//	public ForgotPasswordPage forgotPasswordPage() {
//		return new ForgotPasswordPage();
//	}

//	public ForgotPinComponent forgotPinPage() {
//		return new ForgotPinComponent();
//	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

//	public RetrieveEmailPage retrieveEmailPage() {
//		return new RetrieveEmailPage();
//	}
	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public void verifyEmail(String email) {
		String actualEmail = new CommonFunctions().getTextBoxValue(txtEmail);
		if (email.equals(actualEmail)) {
			ExtentTestManager.setPassMessageInReport("Email is verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Email is not verified");
		}

	}

	public void validateEmailField(String singleChar, String maxChar, String moreThanMax) {
		new CommonFunctions().validateField(txtEmail, "Email", singleChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateFieldMaxichar(txtEmail, "Email", moreThanMax);

	}

	public void validatePasswordField(String singleChar, String maxChar, String moreThanMax) {
		new CommonFunctions().validateField(txtPassword, "password", singleChar);
		new CommonFunctions().clearText(txtPassword, "password");
		new CommonFunctions().validateField(txtPassword, "password", maxChar);
		new CommonFunctions().clearText(txtPassword, "password");
		new CommonFunctions().validateFieldMaxichar(txtPassword, "password", moreThanMax);

	}

	public RetrieveEmailPage retrieveEmailPage() {
		return new RetrieveEmailPage();
	}
	public ForgotPasswordPage forgotPasswordPage() {
    	return new ForgotPasswordPage();
    }
	

}
