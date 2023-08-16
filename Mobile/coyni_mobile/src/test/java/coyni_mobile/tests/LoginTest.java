package coyni_mobile.tests;

import java.util.Map;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.LoginPage;
import coyni_mobile.pages.VisualTestingClass;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class LoginTest {
	LoginPage loginPage;
	LandingPage landingPage;
	VisualTestingClass visualTestingClass;

	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		visualTestingClass = new VisualTestingClass();
		DriverFactory.getDriver().resetApp();
		DriverFactory.getDriver().hideKeyboard();
	}

	/**
	 * testLogin Script is to test the Login to the application
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testLogin(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
//			visualTestingClass.testPinScreen();
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().clickNotNow();
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().dashBoardPage().viewUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLogin1ForNotifications(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email1"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().clickNotNow();
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().dashBoardPage().viewUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLogin2ForNotifications(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().clickNotNow();
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().dashBoardPage().viewUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginWithPIN(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().clickNotNow();
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().dashBoardPage().viewUserName();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	/**
	 * testLoginNavigationView script is to test the Navigation flow of Login
	 * Feature.
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testLoginNavigationView(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.verifyLoginView();
			landingPage.verifyCoyniDesc();
			landingPage.clickLogin();
			loginPage.verifyImageCoyniView();
			loginPage.navigationComponent().clickClose();
			landingPage.verifyCoyniDesc();
			landingPage.clickLogin();
			loginPage.verifyLoginScreenView();
			String[] email = loginData.get("fieldEmail").split(",");
			loginPage.fieldValidationsComponent().validateEmailField(email[0], email[1], email[2]);
			loginPage.fillEmail(loginData.get("email"));
			String[] password = loginData.get("fieldPassword").split(",");
			loginPage.fieldValidationsComponent().validatePasswordField(password[0], password[1], password[2]);
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinheading(loginData.get("pinHeading"));
			loginPage.choosePinComponent().verifyLogoutView();
			loginPage.choosePinComponent().clickLogout();
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinheading(loginData.get("pinHeading"));
			loginPage.choosePinComponent().clickForgotPin();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(loginData.get("emailVerification"));
			loginPage.navigationComponent().clickClose();
			loginPage.choosePinComponent().verifyEnterYourPinheading(loginData.get("pinHeading"));
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().enableFaceOrTouchIDpage()
					.verifyEnableFaceIdHeading(loginData.get("enableFaceIDHeading"));
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().verifyEnableFaceIdView();
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().verifyDontRemindButtonView();
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().clickNotNow();
			loginPage.choosePinComponent().dashboardPage().verifyDashboard();
			DriverFactory.getDriver().terminateApp("com.coyni.mapp");
			DriverFactory.getDriver().activateApp("com.coyni.mapp");
			loginPage.choosePinComponent().verifyEnterYourPinheading(loginData.get("pinHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test LoginNavigation view failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testLoginWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.verifyImageCoyniView();
			String[] email = loginData.get("email").split(",");
			String[] pwd = loginData.get("password").split(",");
			loginPage.fillPassword(pwd[0]);
			for (int i = 0; i < 6; i++) {
				String[] fieldEmail = loginData.get("fieldEmail").split(",");
				loginPage.clickEmail();
				loginPage.fillEmail(fieldEmail[i]);
				loginPage.clcikPassword();
				String[] emailErrMsg = loginData.get("emailErrorMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(emailErrMsg[i], "Email");
			}
			loginPage.fillEmail(email[0]);
			for (int i = 0; i < 5; i++) {
				String[] fieldPwd = loginData.get("fieldPassword").split(",");
				loginPage.clcikPassword();
				loginPage.fillPassword(fieldPwd[i]);
				loginPage.clickEmail();
				String[] pwdErrMsg = loginData.get("pwdErrorMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(pwdErrMsg[i], "Password");
			}
			for (int i = 0; i < 2; i++) {
				loginPage.fillEmail(email[i]);
				loginPage.fillPassword(pwd[i]);
				loginPage.clickLogin();
				if (i == 0) {
					loginPage.verifyIncorrectPopupDescription(loginData.get("incorrHeading"),
							loginData.get("incorrDesc"));
					loginPage.minimizePopupByClikingOK();
				} else {
					loginPage.verifyDataNotFoundPopupDescription(loginData.get("dataNotFoundDesc"));
					loginPage.minimizePopupByClikingOK();
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	/**
	 * testForgotPin script is to test the forgot pin feature.
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testForgotPin(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
			loginPage.choosePinComponent().clickForgotPin();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(loginData.get("emailVerification"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerifiDesc(loginData.get("emailVerifiDesc"), loginData.get("email"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYourPinView(loginData.get("choosePinHeading"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYouPinDes(loginData.get("choosePinDesc"));
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyConfirmYourPin(loginData.get("confirmPinHeading"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.fillPin(loginData.get("pin"));
			loginPage.toastComponent().verifyToastMsg(loginData.get("toastMsg"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Forgot pin is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPinDisabledScenario(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
			loginPage.choosePinComponent().fillPin(loginData.get("inValidPin"));
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
//			Pin taking 2.5 seconds time to refresh the pin field
			Thread.sleep(2500);
			loginPage.choosePinComponent().fillPin(loginData.get("inValidPin"));
			loginPage.choosePinComponent().viewIncorrectPINHeading();
			loginPage.choosePinComponent().clickTryAgain();
			loginPage.choosePinComponent().clickLogout();
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
			loginPage.choosePinComponent().fillPin(loginData.get("inValidPin"));
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
			Thread.sleep(2500);
			loginPage.choosePinComponent().fillPin(loginData.get("inValidPin"));
			loginPage.choosePinComponent().clickForgotPin();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(loginData.get("emailVerification"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYourPinView(loginData.get("choosePinHeading"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyConfirmYourPin(loginData.get("confirmPinHeading"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.fillPin(loginData.get("pin"));
			loginPage.toastComponent().verifyToastMsg(loginData.get("toastMsg"));
			loginPage.verifyImageCoyniView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().fillPin(loginData.get("inValidPin"));
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
			Thread.sleep(2500);
			loginPage.choosePinComponent().fillPin(loginData.get("inValidPin"));
			loginPage.choosePinComponent().viewIncorrectPINHeading();
			loginPage.choosePinComponent().clickTryAgain();
			Thread.sleep(1500);
			loginPage.choosePinComponent().fillPin(loginData.get("inValidPin"));
			loginPage.choosePinComponent().verifyDisabledHeading(loginData.get("disableHeading"),
					loginData.get("disableDesc"));
			loginPage.choosePinComponent().clickLogout();
			landingPage.verifyLandingPageView();
			loginPage.choosePinComponent().clickForgotPin();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().verifyEmailVerificationScreen();
			DriverFactory.getDriver().closeApp();
			DriverFactory.getDriver().activateApp("com.coyni.mapp");
			landingPage.verifyLandingPageView();
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.viewDisabledPINPopup();
			loginPage.minimizePopupByClikingOK();
			loginPage.verifyImageCoyniView();
//			loginPage.choosePinComponent().verifyDisabledHeading(loginData.get("disableHeading"),
//					loginData.get("disableDesc"));
			DriverFactory.getDriver().resetApp();
			landingPage.verifyLandingPageView();
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.viewDisabledPINPopup();
			loginPage.minimizePopupByClikingOK();
			loginPage.verifyImageCoyniView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Forgot pin is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPinInvalidAndNavigationView(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
			loginPage.choosePinComponent().clickForgotPin();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(loginData.get("emailVerification"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().fillOtp(loginData.get("invalidCode"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyInvalidCode(loginData.get("invalidCodeMsg"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().clickResend();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().viewNewCodeSentMsg();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYourPinView(loginData.get("choosePinHeading"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyConfirmYourPin(loginData.get("confirmPinHeading"));
			loginPage.navigationComponent().clickBack();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYourPinView(loginData.get("choosePinHeading"));
			loginPage.navigationComponent().clickBack();
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
			loginPage.choosePinComponent().clickForgotPin();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(loginData.get("emailVerification"));
			loginPage.navigationComponent().clickClose();
			loginPage.choosePinComponent().clickLogout();
			landingPage.verifyCoyniView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Forgot pin is failed due to Exception " + e);
		}
	}

	/**
	 * testForgotPassword script is to test the Forgot password feature.
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.verifyForgotYourPWdHeading(data.get("forgotHeading"));
			loginPage.verifyForgotYourPasswordDesc(data.get("forgotDescription"));
			loginPage.fillEmail(data.get("email"));
			loginPage.clickNext();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailVerification"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerifiDesc(data.get("emailVerifiDesc"), data.get("email"));
			loginPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.verifyCreateNewPasswordHeading(data.get("createPwdHeading"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.fillNewPassword(data.get("password"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().clickNewPassIconEye();
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().viewPasswordStrength();
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.fillConfirmPassword(data.get("password"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().clickSave();
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().successFailureComponent()
					.verifyPasswordUpdatedDesc(data.get("sucessPwdDesc"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().successFailureComponent()
					.clickLogin();
			loginPage.verifyImageCoyniView();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPassword failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.verifyForgotYourPWdHeading(data.get("forgotHeading"));
			for (int i = 0; i < 6; i++) {
				String[] fieldEmail = data.get("fieldEmail").split(",");
				loginPage.fillEmail(fieldEmail[i]);
				if (i == 0) {
					loginPage.clickNext();
					new CommonFunctions().validateFormErrorMessage(data.get("emailErrorMsg"), "Email");
				} else {
					loginPage.clickEmail();
					loginPage.verifyDisabledStateNext();
				}
			}
			loginPage.fillEmail(data.get("email"));
			loginPage.clickNext();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailVerification"));
			loginPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.verifyCreateNewPasswordHeading(data.get("createPwdHeading"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.fillConfirmPassword(data.get("password"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().clickNewPassIconEye();
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().clickConfirmPassIconEye();
			for (int i = 0; i < 6; i++) {
				String[] fieldPassword = data.get("fieldPassword").split(",");
				loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
						.fillNewPassword(fieldPassword[i]);
				loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().clickConfirmPassword();
				String[] newPwdErrMsg = data.get("pwdErrorMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(newPwdErrMsg[i], "New Password Field");
				loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().verifyDisableStateSave();
			}
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.fillNewPassword(data.get("password"));
			for (int i = 0; i < 2; i++) {
				String[] fieldConfPwd = data.get("fieldConfPwd").split(",");
				loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
						.fillConfirmPassword(fieldConfPwd[i]);
				loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().clickNewPassword();
				String[] conPwdErrMsg = data.get("confPwdErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(conPwdErrMsg[i], "Confirm Password Field");
				loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().verifyDisableStateSave();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPassword failed due to exception " + e);
		}
	}

	/**
	 * testForgotPasswordInvalidEmailCredentials script is to test By giving Invalid
	 * email and verifying the error Messages for Forgot Password feature.
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordNavigation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.verifyForgotYourPWdHeading(data.get("forgotHeading"));
			String[] email = data.get("fieldEmail").split(",");
			loginPage.fieldValidationsComponent().validateEmailField(email[0], email[1], email[2]);
			loginPage.fillEmail(data.get("email"));
			loginPage.clickNext();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailVerification"));
			loginPage.phoneAndEmailVerificationComponent().fillOtp(data.get("invalidCode"));
			loginPage.phoneAndEmailVerificationComponent().verifyInvalidCode(data.get("invalidCodeMsg"));
			loginPage.phoneAndEmailVerificationComponent().clickResend();
			loginPage.phoneAndEmailVerificationComponent().viewNewCodeSentMsg();
			loginPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.verifyCreateNewPasswordHeading(data.get("createPwdHeading"));
			String[] password = data.get("fieldPassword").split(",");
			loginPage.fieldValidationsComponent().validateNewPasswordField(password[0], password[1], password[2]);
			loginPage.fieldValidationsComponent().validateConfirmPasswordField(password[0], password[1], password[2]);
			loginPage.navigationComponent().clickBack();
			loginPage.verifyForgotYourPWdHeading(data.get("forgotHeading"));
			loginPage.clickNext();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailVerification"));
			loginPage.navigationComponent().clickBack();
			loginPage.verifyForgotYourPWdHeading(data.get("forgotHeading"));
			loginPage.navigationComponent().clickClose();
			loginPage.verifyImageCoyniView();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}

	/**
	 * testRetrieveEmail script is to test the Retrieve Email feature by filling all
	 * the text fields.
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmail(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.verifyRetrievEmailHeading(loginData.get("retrieveHeading"));
			loginPage.verifyRetrievEmailDesc(loginData.get("retrieveDesc"));
			loginPage.clickDrpDwPhNum();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickNext();
			loginPage.phoneAndEmailVerificationComponent()
					.verifyPhoneVerificationHeading(loginData.get("phNumVerifiHeadi"));
//			loginPage.phoneAndEmailVerificationComponent()
//					.verifyLabelTextforPhNumVerifiDesc(loginData.get("phNumVerifiDesc"),loginData.get("phoneNumber"));
			loginPage.phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.verifyWeFoundYourAccount(loginData.get("firstName"), loginData.get("lastName"));
			String retrieveEmail = loginPage.validateRetrieveEmail();
			loginPage.clickRetrieveLogin();
			String loginEmail = loginPage.validateLoginEmail();
			if (retrieveEmail.equals(loginEmail)) {
				ExtentTestManager.setPassMessageInReport("The Valid email is auto populating in email field");
			} else {
				ExtentTestManager.setFailMessageInReport("The Invalid email is auto populating in email field");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmail Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.verifyRetrievEmailHeading(data.get("retrieveHeading"));
			loginPage.fillFirstName(data.get("firstName"));
			for (int i = 0; i < 3; i++) {
				String[] fieldPhoneNumber = data.get("fieldPhoneNumber").split(",");
				loginPage.fillPhoneNumber(fieldPhoneNumber[i]);
				loginPage.clickFirstName();
				String[] phNumErrMsg = data.get("phNumErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(phNumErrMsg[i], "Phone Number Field");
				loginPage.verifyDisabledStateNext();
			}
			loginPage.fillPhoneNumber(data.get("phoneNumber"));
			loginPage.fillLastName(data.get("firstName"));
			for (int i = 0; i < 2; i++) {
				String[] fieldFirstName = data.get("fieldFirstName").split(",");
				loginPage.fillFirstName(fieldFirstName[i]);
				loginPage.clickLastName();
				String[] fstNameErrMsg = data.get("fstNameErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(fstNameErrMsg[i], "First Name Field");
				loginPage.verifyDisabledStateNext();
			}
			loginPage.fillFirstName(data.get("firstName"));
			for (int i = 0; i < 2; i++) {
				String[] fieldLastName = data.get("fieldLastName").split(",");
				loginPage.fillLastName(fieldLastName[i]);
				loginPage.clickFirstName();
				DriverFactory.getDriver().hideKeyboard();
				String[] lstNameErrMsg = data.get("lstNameErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(lstNameErrMsg[i], "Last Name Field");
				loginPage.verifyDisabledStateNext();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPassword failed due to exception " + e);
		}
	}

	public void testRetrieveScreen(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			loginPage.clickDrpDwPhNum();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickNext();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithInvalidCredentials Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailFoundAccountNavigationView(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.verifyRetrievEmailHeading(loginData.get("retrieveHeading"));
			testRetrieveScreen(strParams);
			loginPage.phoneAndEmailVerificationComponent()
					.verifyPhoneVerificationHeading(loginData.get("phNumVerifiHeadi"));
			loginPage.phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.viewWeFoundYourAccount();
			loginPage.clickThisisNotMe();
			loginPage.verifyRetrievEmailHeading(loginData.get("retrieveHeading"));
			loginPage.validateThisIsNotMe();
			testRetrieveScreen(strParams);
			loginPage.phoneAndEmailVerificationComponent()
					.verifyPhoneVerificationHeading(loginData.get("phNumVerifiHeadi"));
			loginPage.phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.viewWeFoundYourAccount();
			loginPage.navigationComponent().clickClose();
			loginPage.verifyImageCoyniView();
			String loginEmail = loginPage.validateLoginEmail();
			if (loginEmail.equals("") || loginEmail.equals("Email")) {
				ExtentTestManager
						.setPassMessageInReport("The Email is not auto populating,After clicking on close button");
			} else {
				ExtentTestManager.setFailMessageInReport("The Email is auto populating,After clicking on close button");
			}
			loginPage.clickRetrieveEmail();
			loginPage.verifyRetrievEmailHeading(loginData.get("retrieveHeading"));
			testRetrieveScreen(strParams);
			loginPage.phoneAndEmailVerificationComponent()
					.verifyPhoneVerificationHeading(loginData.get("phNumVerifiHeadi"));
			loginPage.phoneAndEmailVerificationComponent().clickResend();
			loginPage.phoneAndEmailVerificationComponent().fillOtp(loginData.get("invalidCode"));
			loginPage.phoneAndEmailVerificationComponent().verifyInvalidCode(loginData.get("invalidCodeMsg"));
			loginPage.phoneAndEmailVerificationComponent().clickResend();
			loginPage.phoneAndEmailVerificationComponent().viewNewCodeSentMsg();
//			here until the "new code message" will disappear, then only it allows to do actions on elements
			Thread.sleep(1000);
			loginPage.navigationComponent().clickClose();
			loginPage.verifyImageCoyniView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmail Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailNoUserFoundNavigationView(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.verifyRetrievEmailHeading(loginData.get("retrieveHeading"));
			testRetrieveScreen(strParams);
			loginPage.verifyNoUserFound(loginData.get("noUserDesc"));
			Thread.sleep(1200);
			loginPage.clickTryAgain();
			loginPage.verifyRetrievEmailHeading(loginData.get("retrieveHeading"));
			loginPage.validateThisIsNotMe();
			testRetrieveScreen(strParams);
			loginPage.viewNoUserFound();
			loginPage.clickcancel();
			loginPage.verifyImageCoyniView();
			loginPage.clickRetrieveEmail();
			loginPage.verifyRetrievEmailHeading(loginData.get("retrieveHeading"));
			testRetrieveScreen(strParams);
//			loginPage.viewNoUserFound();
			loginPage.verifyNoUserFound(loginData.get("noUserDesc"));
			loginPage.clickClose();
			loginPage.verifyImageCoyniView();
			String loginemail = loginPage.validateLoginEmail();
			if (loginemail.equals("") || loginemail.equals("Email")) {
				ExtentTestManager
						.setPassMessageInReport("The Email is not auto populating,After clicking on close button");
			} else {
				ExtentTestManager.setFailMessageInReport("The Email is auto populating,After clicking on close button");
			}
			loginPage.clickRetrieveEmail();
			loginPage.verifyRetrievEmailHeading(loginData.get("retrieveHeading"));
			loginPage.clickDrpDwPhNum();
			loginPage.validateSelectCountry(loginData.get("country"));
			String[] phoneNumber = loginData.get("fieldPhoneNumber").split(",");
			loginPage.fieldValidationsComponent().validatePhoneNumberField(phoneNumber[0], phoneNumber[1],
					phoneNumber[2]);
			String[] firstName = loginData.get("fieldFirstName").split(",");
			loginPage.fieldValidationsComponent().validateFirstNameField(firstName[0], firstName[1], firstName[2],
					firstName[3], loginData.get("validateDataType"));
			String[] lastName = loginData.get("fieldLastName").split(",");
			loginPage.fieldValidationsComponent().validateLastNameField(lastName[0], lastName[1], lastName[2],
					lastName[3], loginData.get("validateDataType"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmail Failed due to exception " + e);
		}
	}

	/**
	 * testRetrieveEmailWithInvalidCredentials script is to test By giving invalid
	 * Credentials and verifying the error message in Retrieve Email Feature.
	 * 
	 * @param strParams
	 */

}
