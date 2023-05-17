package coyni_mobile.pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.components.AgreementComponent;
import coyni_mobile.components.EmailVerificationComponent;
import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.FaceIDDisabledComponent;
import coyni_mobile.components.FaceIDnotAvailableComponent;
import coyni_mobile.components.FieldValidationsComponent;
import coyni_mobile.components.ForgotPinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.popups.CoyniInavlidEmailPopup;
import coyni_mobile.popups.EmailOrPasswordIsIncorrectPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.actions.WaitForElement;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class LoginPage extends MobileFunctions {

	private By txtEmail = MobileBy.//id("etEmail");
			xpath("//*[contains(@resource-id,'etEmail')] | (//*[contains(@name,'Email')])[1]");
	private By txtPassword = MobileBy.//id("etPassword");
			xpath("//*[contains(@resource-id,'etPassword')] | (//*[contains(@name,'Password')])[1]");
	private By lnkRetriveEmail = MobileBy.//id("tvRetEmail");
			xpath("//*[contains(@resource-id,'tvRetEmail')] | (//*[contains(@name,'Retrieve Email')])[1]");
	private By lnkForgotPassword = MobileBy.//id("forgotpwd");
			xpath("//*[contains(@resource-id,'forgotpwd')]|(//*[@name ='Forgot Password'])[1]");
	private By chkBxRememberMe = MobileBy.//id("chkRemember");
			xpath("//*[contains(@resource-id,'chkRemember')]| //*[@name='Remember Me']/preceding-sibling::*[1]");
	private By btnLogin = MobileBy.//id("cvNext");
			xpath("//*[contains(@resource-id,'nextBtn')]/parent::*|//*[contains(@resource-id,'cvNext')]");
	private By lblCoyni = MobileBy.xpath("//*[contains(@resource-id,'loginBGIV')]|//*[@name='coyni-logo-full']");
	private By lblerrMsg = MobileBy
			.xpath("//*[contains(@resource-id,'tvEmailError')]|(//*[contains(@text,'is incorrect')])[1]|(//*[contains(@label,'is incorrect')])[1]|//*[contains(@resource-id,'tvMessage')]");
	private By popUperror = MobileBy
			.xpath("//*[contains(@resource-id,'tvMessage')]|//*[contains(@text,'Either your email or password is incorrect.')]|//*[contains(@resource-id,'design_bottom_sheet')]|(//*[contains(@label,'is incorrect')])[1]/..");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'okBtn')]|(//*[@name='OK'])[1]|//*[contains(@resource-id,'cvAction')]");
	private By btnEyeIconPassword = MobileBy.//id("endIconIV");
			xpath("//*[contains(@resource-id,'endIconIV')]");
	private By fieldBar = MobileBy.xpath(
			"//*[contains(@resource-id, 'layoutIndicator')]/*");
	private By btnCross = MobileBy.xpath("");
	private By iconFace = MobileBy.xpath("");

	WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), 30);
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
		new CommonFunctions().verifyLabelText(popUperror, "PopupMessage", expText);
		
	}
	public int fieldBarCount() {
		return getElementList(fieldBar, "field bar").size();

	}
	private void minimizePopup() {
		if (DriverFactory.getDriver().findElement(btnLogin).isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Popup is closed");
		} else {
			ExtentTestManager.setFailMessageInReport("Popup is not closed");
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
		click(btnEyeIconPassword, "Password Eye Icon");
	}
//	public void clickPasswordEye() {
//		
//	}
	public void clickEmail() {
		click(txtEmail, "email");
	}

	public void clickPassword() {
		click(txtPassword, "password");
		
	}

	public void clickRetrieveEmail() {
		click(lnkRetriveEmail, "Retrieve Email ");

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
    public void verifyEmail(String email) {
    	new CommonFunctions().verifyLabelText(txtEmail, "Email", email);
    }
//	public void clickEnter() {
//		((AndroidDriver)DriverFactory.getDriver()).pressKey(new KeyEvent(AndroidKey.TAB));
//		
//	}

	public void clickLogin() throws InterruptedException {
		click(btnLogin, "Login button");
		Thread.sleep(1500);
		if(getElementList(btnLogin, "login").size() > 0) {
			click(btnLogin, "Login button");
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

	public EmailVerificationComponent verifyEmailComponent() {
		return new EmailVerificationComponent();
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

	public CoyniInavlidEmailPopup coyniInavlidEmailPopup() {
		return new CoyniInavlidEmailPopup();
	}

	public EmailOrPasswordIsIncorrectPopup emailOrPasswordIsIncorrectPopup() {
		return new EmailOrPasswordIsIncorrectPopup();
	}
	
	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
	public AgreementComponent agreementComponent() {
		return new AgreementComponent();
	}
	
}