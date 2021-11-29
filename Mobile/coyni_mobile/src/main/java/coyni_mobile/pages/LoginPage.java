package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.FaceIDDisabledComponent;
import coyni_mobile.components.FaceIDnotAvailableComponent;
import coyni_mobile.components.ForgotPinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class LoginPage extends MobileFunctions {

	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'etEmail')]");
	private By txtPassword = MobileBy.xpath("//*[contains(@resource-id,'etPassword')]");
	private By lnkRetriveEmail = MobileBy.xpath("//*[contains(@resource-id,'forgotpwd')]");
	private By lnkForgotPassword = MobileBy.xpath("//*[contains(@resource-id,'tvRetEmail')]");
	private By chkBxRememberMe = MobileBy.xpath("//*[contains(@resource-id,'chkRemember')]");
	private By btnLogin = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
	private By lblCoyni = MobileBy.xpath("//*[contains(@resource-id,'loginBGIV')]");
	private By lblerrMsg = MobileBy.xpath("(//*[contains(@text,'is incorrect')])[1]");
	private By popUperror =MobileBy.xpath("//*[contains(@resource-id,'design_bottom_sheet')]");
	private By btnOk =MobileBy.xpath("//*[contains(@resource-id,'okBtn')]");
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
    public FaceIDnotAvailableComponent faceIDnotAvailableComponent() {
    	return new FaceIDnotAvailableComponent();
    }
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
		new CommonFunctions().elementView(lnkRetriveEmail, "Retrieve email");
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
		click(txtPassword,"password");
	}

	public void clickForgotEmail() {
		click(lnkRetriveEmail, "Retrieve Email ");

	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "Forgot Password ");

	}

	public void clickRememberMe() {
		click(chkBxRememberMe, "Remember");
	}
	public void  VerifyLoginPageView() {
		 new CommonFunctions().elementView(chkBxRememberMe ,"Login Page");
	}

//	public void clickEnter() {
//		((AndroidDriver)DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.TAB));
//		
//	}
	
	public void clickLogin() {
		if(getElement(btnLogin, "login").isEnabled()) {
		click(btnLogin, "login button");
		}else {
			ExtentTestManager.setInfoMessageInReport("login button  is disabled");
		}
	}
	public void ViewCoyni() {
		new CommonFunctions().elementView(lblCoyni, "Coyni");
	}
	
		
	
	public FaceIDDisabledComponent faceIDDisabledComponent() {
		return new FaceIDDisabledComponent();
	}

	public ForgotPasswordPage forgotPasswordPage() {
		return new ForgotPasswordPage();
	}
	
	public ForgotPinComponent forgotPinPage() {
		return new ForgotPinComponent();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public RetrieveEmailPage retrieveEmailPage() {
		return new RetrieveEmailPage();
	}
	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}
    public VerifyNewEmailPage verifyNewEmailPage() {
    	return new VerifyNewEmailPage();
    }

	
}