package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.HomePage;
import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.LoginPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class LoginTest {

	LoginPage loginPage;
	HomePage homePage;
	LandingPage landingPage;

	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		homePage = new HomePage();
		landingPage = new LandingPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testLogin(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);

			homePage.clickLogIn();
			loginPage.VerifyLoginPageView();
			loginPage.verifyEmailview();
			loginPage.verifyPasswordview();
			loginPage.verifyRememberMeView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickRememberMe();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyAvailableBalanceView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testLoginEnableFaceId(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);

			homePage.clickLogIn();
			loginPage.VerifyLoginPageView();
			loginPage.verifyEmailview();
			loginPage.verifyPasswordview();
			loginPage.verifyRememberMeView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickRememberMe();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickEnableFaceId();
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyCancelView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickCancel();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyAvailableBalanceView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters
	public void testLoginNavigationView(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			// navigation Home Page -login Page
			homePage.clickLogIn();
			loginPage.VerifyLoginPageView();
			loginPage.navigationComponent().verifyCloseView();
			loginPage.navigationComponent().clickClose();
			homePage.verifyCoyniView();
			// navigation LoginPage - Enter Your PIN Component
			homePage.clickLogIn();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().navigationComponent().verifyCloseView();
			loginPage.enterYourPINComponent().navigationComponent().clickClose();
			loginPage.VerifyLoginPageView();
			// navigation LoginPage - Forgot Your PIN Component
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotYourPinView();
			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickClose();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test LoginNavigation view failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testLoginWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			homePage.clickLogIn();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickRememberMe();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyAvailableBalanceView();
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPin(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			homePage.clickLogIn();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotYourPinView();
			loginPage.enterYourPINComponent().forgotPinComponent().fillEmail(loginData.get("email"));
			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			// loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailview();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.fillInputBoxes(loginData.get("Input"));// enter wrong pin
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().clickResend();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Password Page is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDisableFaceIDTouchID(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			loginPage.faceIDDisabledComponent().verifyOkView();
			loginPage.faceIDDisabledComponent().clickOk();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyAvailableBalanceView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Disable FaceID TouchID is failed due to Exception " + e);
		}

	}

	// when user clicks on Enable Face id button
	public void testEnableFaceId(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			loginPage.faceIDDisabledComponent().verifyOkView();
			loginPage.faceIDDisabledComponent().clickOk();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickEnableFaceId();
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyCancelView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickCancel();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyAvailableBalanceView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Disable FaceID TouchID is failed due to Exception " + e);
		}

	}

	@Test
	@Parameters
	public void testDisableFaceIDTouchIDForgotpin(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			loginPage.faceIDDisabledComponent().verifyOkView();
			loginPage.faceIDDisabledComponent().clickOk();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotYourPinView();
			loginPage.enterYourPINComponent().forgotPinComponent().fillEmail(loginData.get("email"));
			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			// loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailview();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.fillInputBoxes(loginData.get("Input"));// enter wrong pin
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().clickResend();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Disable FaceID TouchID is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters
	public void testUserHavingPINEnableOnAppLevel(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			homePage.clickLogIn();
			loginPage.VerifyLoginPageView();
			loginPage.VerifyFaceView();
			loginPage.clickFace();
			loginPage.faceIDnotAvailableComponent().verifyFaceIdNotAvailableView();
			loginPage.faceIDnotAvailableComponent().clickOk();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyAvailableBalanceView();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test User Not Having Any ID On app level failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {

			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent()
					.verifyEmailOtpHeading(loginData.get("emailOtpHeading"));
//			//loginPage.forgotPasswordPage().verifyEmailComponent().verifyEmail(loginData.get("labelEmail"));
			loginPage.forgotPasswordPage().verifyEmailComponent().clickResend();
			Thread.sleep(2000);
			loginPage.forgotPasswordPage().verifyEmailComponent().clickClose();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordInvalidEmailCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordInvalidOTPCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));

			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent()
					.verifyEmailOtpHeading(loginData.get("emailOtpHeading"));

			String[] msg = loginData.get("errMessage").split(",");
			for (int i = 0; i < msg.length; i++) {
				if (!loginData.get("errMessage").isEmpty()) {
					loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(loginData.get("code"));
					loginPage.forgotPasswordPage().verifyEmailComponent().verifyOTPErrorMessage(msg[i]);
				} else {
					loginPage.forgotPasswordPage().verifyEmailComponent().clickResend();
				}
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmail(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			landingPage.clickLogin();
			Thread.sleep(5000);
			// loginPage.retrieveEmailPage().clickRetrieveEmail();
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			Thread.sleep(2000);
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().verifyPhone(loginData.get("phoneHeading"));
			// loginPage.retrieveEmailPage().verifyRegisteredPhoneNum(loginData.get("verifyPhoneNumber"));
			// loginPage.retrieveEmailPage().fillInputBoxes(loginData.get("code"));
			loginPage.retrieveEmailPage().clickResend();
			loginPage.retrieveEmailPage().clickClose();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmail Failed due to exception " + e);
		}

	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithEmptyCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			landingPage.clickLogin();
			Thread.sleep(5000);
			// loginPage.retrieveEmailPage().clickRetrieveEmail();
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"));
			}

			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"));
			}

			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"));
			}

			Thread.sleep(2000);

			loginPage.retrieveEmailPage().clickNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmail Failed due to exception " + e);
		}

	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			landingPage.clickLogin();
			Thread.sleep(5000);
			// loginPage.retrieveEmailPage().clickRetrieveEmail();
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			Thread.sleep(2000);
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().verifyTryAgain(loginData.get("tryAgain"));
			loginPage.retrieveEmailPage().clickTryAgain();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmail Failed due to exception " + e);
		}

	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidFirstAndLastName(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			landingPage.clickLogin();
			Thread.sleep(5000);
			// loginPage.retrieveEmailPage().clickRetrieveEmail();
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			Thread.sleep(2000);
			loginPage.retrieveEmailPage().clickCloseIcon();
			loginPage.retrieveEmailPage().ViewCoyni();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmail Failed due to exception " + e);
		}

	}

}
