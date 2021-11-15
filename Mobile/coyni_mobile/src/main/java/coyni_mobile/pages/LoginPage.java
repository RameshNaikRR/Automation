package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.FaceIDDisabledComponent;
import coyni_mobile.components.FaceIDnotAvailableComponent;
import coyni_mobile.components.ForgotPinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class LoginPage extends MobileFunctions {

	private By txtEmail = MobileBy.xpath("");
	private By txtPassword = MobileBy.xpath("");
	private By lnkRetriveEmail = MobileBy.xpath("");
	private By lnkForgotPassword = MobileBy.xpath("");
	private By chkBxRememberMe = MobileBy.xpath("");
	private By btnLogin = MobileBy.xpath("");
	private By lblCoyni = MobileBy.xpath(" ");
	private By btnCross = MobileBy.xpath(" ");
	private By iconFace = MobileBy.xpath(" ");
	
	
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
	
	

	public void fillPassword(String password) {
		enterText(txtPassword, password, "password ");
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
	public void VerifyLoginPageView() {
		new CommonFunctions().elementView(chkBxRememberMe ,"Login Page");
	}

	public void clickLogin() {
		click(btnLogin, "login button");
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