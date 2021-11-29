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

			landingPage.clickLogin();
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
			Thread.sleep(2000);
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyLogin();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testLoginEnableFaceId(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);

			landingPage.clickLogin();
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
		//	loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyUserName(loginData.get("userName"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginNavigationView(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.navigationComponent().verifyCloseView();
			loginPage.navigationComponent().clickClose();
			landingPage.verifyLandingPage();
			// navigation LoginPage - Enter Your PIN Component
			landingPage.clickLogin();
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
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			Thread.sleep(2000);
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIDButtonView();
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyNotNowButtonView();
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyDontRemindButtonView();
			
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
			loginPage.VerifyLoginPageView();
			if (loginData.get("email").isEmpty()) {
				loginPage.fillEmail(loginData.get("email"));
				// loginPage.clickPassword();
			} else {
				loginPage.fillEmail(loginData.get("email"));
			}

			if (loginData.get("password").isEmpty()) {
				loginPage.fillPassword("");
				loginPage.clickEmail();
			} else {
				loginPage.fillPassword(loginData.get("password"));
				loginPage.clickRememberMe();
				loginPage.clickLogin();
			}
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
						loginData.get("elementName"));
			}
			if (!loginData.get("popUpMsg").isEmpty()) {
				loginPage.verifyPopupMsg(loginData.get("popUpMsg"));
				loginPage.minimizePopupByClikingOK();
				// clicking login button once again to verify Swipe down action
				Thread.sleep(2000);
				loginPage.clickLogin();
				loginPage.verifyPopupMsg(loginData.get("popUpMsg"));
				loginPage.minimizePopupBySwipeDown();
				
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
	Thread.sleep(1000);
	landingPage.clickLogin();
	Thread.sleep(3000);
	loginPage.VerifyLoginPageView();
	loginPage.fillEmail(loginData.get("email"));
	loginPage.fillPassword(loginData.get("password"));
	loginPage.clickLogin();
	loginPage.enterYourPINComponent().verifyEnterYourPinView();
	loginPage.enterYourPINComponent().clickForgotPin();
	loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotYourPinView();
	loginPage.enterYourPINComponent().forgotPinComponent().verifyEmail(loginData.get("email"));
	loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
	loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailview();
	loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().fillInputBoxes(loginData.get("pin"));// enter wrong pin
	loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyResendlbl(loginData.get("resendMsgOld"));
	loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().clickResend();
	Thread.sleep(2000);
	loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyResendlbl(loginData.get("resendMsgNew"));
	Thread.sleep(4000);
	loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyNewResendlbl(loginData.get("resendMsgOld"));
	} catch (Exception e) {
	ExtentTestManager.setFailMessageInReport("test Forgot pin is failed due to Exception " + e);
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
		//	loginPage.enterYourPINComponent().forgotPinComponent().fillEmail(loginData.get("email"));
			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailview();
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
			// homePage.clickLogIn();
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
			// loginPage.forgotPasswordPage().verifyContentHeading(loginData.get("forgotContentHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent()
					.verifyEmailOtpHeading(loginData.get("emailOtpHeading"));
			// loginPage.forgotPasswordPage().verifyEmailComponent().verifyEmail(loginData.get("labelEmail"));
			loginPage.forgotPasswordPage().verifyEmailComponent().clickResend();
			Thread.sleep(2000);
			loginPage.forgotPasswordPage().verifyEmailComponent().clickClose();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password faield due to exception " + e);
		}
	}

	// private By popHeading =
	// MobileBy.xpath("//*[contains(@resource-id,'textTV')]");

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordInvalidEmailCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
			// loginPage.forgotPasswordPage().verifyContentHeading(loginData.get("forgotContentHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			Thread.sleep(2000);
			if (!loginData.get("errMessage").isEmpty()) {

				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
						loginData.get("elementName"));
			}
//			else if (mobileFunctions.getElement(popHeading, "pop heading").isDisplayed()) {
//				loginPage.forgotPasswordPage().verifyPopErrMessa(loginData.get("popUpContent"));
//			}

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
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));

			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent()
					.verifyEmailOtpHeading(loginData.get("emailOtpHeading"));
			Thread.sleep(2000);
			loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(loginData.get("code"));

			// String[] msg = loginData.get("errMessage").split(",");
			// for (int i = 0; i <=6; i++) {
			// loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(loginData.get("code"));
			// loginPage.forgotPasswordPage().verifyEmailComponent().verifyOTPErrorMessage(msg[i]);
			// }
			loginPage.forgotPasswordPage().verifyEmailComponent().clickResend();
			// loginPage.forgotPasswordPage().verifyEmailComponent().verifyResentMsg(loginData.get("resendMessage"));
			for (int i = 0; i <= 2; i++) {
				Thread.sleep(5000);
				loginPage.forgotPasswordPage().verifyEmailComponent().clickResend();
				// loginPage.forgotPasswordPage().verifyEmailComponent()
				// .verifyResentMsg(loginData.get("resendMessage"));
			}
//
			// loginPage.forgotPasswordPage().verifyEmailComponent().clickOk();

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
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			// loginPage.retrieveEmailPage().verifyPhoneNumber(loginData.get("lblPhoneNumber"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			Thread.sleep(2000);
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().verifyPhone(loginData.get("phoneHeading"));
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
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
						loginData.get("elementName"));
			}
			// loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithEmptyCredentials Failed due to exception " + e);
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
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			Thread.sleep(2000);
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().verifyTryAgain(loginData.get("tryAgain"));
			loginPage.retrieveEmailPage().clickTryAgain();
			// loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithInvalidCredentials Failed due to exception " + e);
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
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			Thread.sleep(2000);
			loginPage.retrieveEmailPage().clickCloseIcon();
			loginPage.retrieveEmailPage().ViewCoyni();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testRetrieveEmailWithInvalidFirstAndLastName Failed due to exception " + e);
		}

	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithPhoneNumberMorethanCount(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			landingPage.clickLogin();
			Thread.sleep(5000);
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
						loginData.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testRetrieveEmailWithPhoneNumberMorethanCount Failed due to exception " + e);
		}

	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithFirstLastNameMorethanCount(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			landingPage.clickLogin();
			Thread.sleep(5000);
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			Thread.sleep(3000);
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
						loginData.get("elementName"));
			}
			loginPage.retrieveEmailPage().clickNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testRetrieveEmailWithFirstLastNameMorethanCount Failed due to exception " + e);
		}

	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidOTPCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			landingPage.clickLogin();
			Thread.sleep(5000);
			loginPage.clickForgotEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().fillInputBoxes(loginData.get("code"));
			for (int i = 0; i <= 3; i++) {
				Thread.sleep(5000);
				loginPage.retrieveEmailPage().clickResend();
			}

			loginPage.retrieveEmailPage().clickOk();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testRetrieveEmailWithInvalidFirstAndLastName Failed due to exception " + e);
		}

	}

}
