package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.LandingPage;
import coyni_mobile_merchant.pages.LoginPage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class LoginTest {

	LoginPage loginPage;
	LandingPage landingPage;

	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
	}

	@AfterTest
	public void hideKeyBoard() {
		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginWithOutPin(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.verifyEmailview();
			loginPage.verifyPasswordview();
			loginPage.verifyRememberMeView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			// loginPage.clickRememberMe();
			loginPage.clickLogin();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
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
			// loginPage.clickRememberMe();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			Thread.sleep(2000);
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			// loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyLogin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testLoginNavigationView(String strParams) {
//		try {
//			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
//			landingPage.verifyLoginbtnView();
//			landingPage.clickLogin();
//			loginPage.VerifyLoginPageView();
//			loginPage.navigationComponent().verifyCloseView();
//			loginPage.navigationComponent().clickClose();
//			landingPage.verifyLandingPage();
//			// navigation LoginPage - Enter Your PIN Component
//			landingPage.clickLogin();
//			loginPage.fillEmail(loginData.get("email"));
//			loginPage.fillPassword(loginData.get("password"));
//			loginPage.clickLogin();
//			loginPage.enterYourPINComponent().verifyEnterYourPinView();
//			loginPage.enterYourPINComponent().navigationComponent().verifyCloseView();
//			loginPage.enterYourPINComponent().navigationComponent().clickClose();
//			loginPage.VerifyLoginPageView();
//			loginPage.fillPassword(loginData.get("password"));
//			// navigation LoginPage - Forgot Your PIN Component
//			loginPage.clickLogin();
//			loginPage.enterYourPINComponent().verifyEnterYourPinView();
//			loginPage.enterYourPINComponent().clickForgotPin();
//			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotYourPinView();
//			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickClose();
//			loginPage.enterYourPINComponent().verifyEnterYourPinView();
//			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
//			Thread.sleep(2000);
//			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
//			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIDButtonView();
//			loginPage.enterYourPINComponent().enableFaceIDpage().verifyNotNowButtonView();
//			loginPage.enterYourPINComponent().enableFaceIDpage().verifyDontRemindButtonView();
//			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test LoginNavigation view failed due to Exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })

	public void testLoginWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			if (loginData.get("password").length() < 8) {
				loginPage.clickEmail();
			}
			loginPage.clickLogin();
			if (!loginData.get("errMessage").isEmpty()) {
				if (new CommonFunctions().isPlatformiOS()) {
					new CommonFunctions().validateFormErrorMessageIOS(loginData.get("errMessage"),
							loginData.get("elementName"));
				} else {
					new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
							loginData.get("elementName"));
				}
			}
			if (!loginData.get("popUpMsg").isEmpty()) {
				loginPage.verifyPopupMsg(loginData.get("popUpMsg"));
				loginPage.minimizePopupByClikingOK();
				// clicking login button once again to verify Swipe down action
				Thread.sleep(2000);
				loginPage.clickLogin();
				loginPage.verifyPopupMsg(loginData.get("popUpMsg"));
//				loginPage.minimizePopupBySwipeDown();

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
			loginPage.enterYourPINComponent().forgotPinComponent().VerifyHeadingForgotPin(data.get("forgotHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotPinDescView();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmail(data.get("email"));
			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("emailVerificationHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailText(data.get("emailText"));
//			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
//					.verifyOtpTextFieldView();
//			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
//					.verifyGetCodeView();
//     		loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
//					.verifyResendView();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.fillPin(data.get("code"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().verifyChoosePinHeading(data.get("choosePinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().fillPin(data.get("pin"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().verifyConfirmPinHeading(data.get("confirmPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().fillPin(data.get("pin"));
			// verify dashboard
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPin failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPinResendOTP(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
			loginPage.enterYourPINComponent().forgotPinComponent()
					.VerifyHeadingForgotPin(loginData.get("forgotHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotPinDescView();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmail(loginData.get("email"));
			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(loginData.get("emailVerificationHeading"));
			for (int i = 0; i < 5; i++) {
				loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
						.clickResend();
				loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
						.verifyNewCodeMsg(loginData.get("NewCodeMsg"));
			}
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyErrorHeading(loginData.get("expHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyErrorDesc(loginData.get("expDesc"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPinResendOTP Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPinNavigationView(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			landingPage.clickLogin();
//			loginPage.fillEmail(loginData.get("email"));
//
//			loginPage.fillPassword(loginData.get("password"));
//
//			loginPage.clickLogin();
//			loginPage.enterYourPINComponent().clickForgotPin();
//			loginPage.enterYourPINComponent().forgotPinComponent()
//			.VerifyHeadingForgotPin(loginData.get("forgotHeading"));
//			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickClose();
//			loginPage.enterYourPINComponent().verifyEnterYourPinView();
//			loginPage.enterYourPINComponent().clickForgotPin();
//			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
//			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
//			.verifyEmailHeading(loginData.get("emailVerificationHeading"));
//			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickBack();
//			loginPage.enterYourPINComponent().forgotPinComponent()
//			.VerifyHeadingForgotPin(loginData.get("forgotHeading"));
//			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Pin Navigation Flow failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.verifyEmailview();
			loginPage.verifyPasswordview();
			loginPage.verifyRememberMeView();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			// loginPage.clickRememberMe();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			loginPage.enterYourPINComponent().enableFaceIDpage().registrationPage()
					.verifyHeading(data.get("RegHeading"));
			loginPage.enterYourPINComponent().enableFaceIDpage().registrationPage().clickStart();
			loginPage.enterYourPINComponent().enableFaceIDpage().registrationPage().registrationCompanyInformationPage()
					.verifyHeading(data.get("companyInfoHeading"));

		} catch (Exception e) {

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().verifyDescription(data.get("retrieveEmailDescription"));
			loginPage.retrieveEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().verifyPhoneVerificationPage();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("phoneHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent()
					.verifyPhoneDescription(data.get("phoneDescription"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().fillPin(data.get("phoneOTP"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage()
					.verifyHeading(data.get("accountPageHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage()
					.verifyDescription(data.get("accountPageDescription"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage().clickCoyniAccount();
			loginPage.verifyEmail(data.get("email"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happens due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.verifyRetrieveView();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().verifyPhoneNumberView();
			loginPage.retrieveEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailPage().verifyFirstNameViewView();
			loginPage.retrieveEmailPage().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailPage().verifyLastNameView();
			loginPage.retrieveEmailPage().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailPage().navigationComponent().verifyCloseView();
			loginPage.retrieveEmailPage().verifyNextButtonView();
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("phoneHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().verifyGetCodeView();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().verifyResendView();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().navigationComponent().verifyBackView();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().fillPin(data.get("phoneOTP"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage()
					.verifyHeading(data.get("accountPageHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage().navigationComponent()
					.verifyCloseView();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage()
					.verifyCoyniAccountView();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage().clickCoyniAccount();
			loginPage.verifyEmailview();
			loginPage.navigationComponent().verifyCloseView();
			loginPage.verifyEmail(data.get("email"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEamilView failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().accountNotFoundPage().verifyHeading(data.get("cantFindHeading"));
			loginPage.retrieveEmailPage().accountNotFoundPage().verifyTryAgainView();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithInvalidCredentials failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveWithInavlidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(data.get("lastName"));
			if (!data.get("errMsg").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("elementName"));
			}
			loginPage.retrieveEmailPage().verifyNextButtonDisabled();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveWithInavlidData failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.navigationComponent().clickClose();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("phoneHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().fillPin(data.get("phoneOTP"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage()
					.verifyHeading(data.get("accountPageHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage().navigationComponent()
					.clickClose();
			Thread.sleep(1000);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("phoneHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().fillPin(data.get("phoneOTP"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage()
					.verifyHeading(data.get("accountPageHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage().clickCoyniAccount();
			loginPage.verifyEmail(data.get("email"));
			loginPage.navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithNavigationView failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidOTP(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent()
					.verifyPhoneHeading(data.get("phoneHeading"));
			for (int i = 0; i <= 4; i++) {
				Thread.sleep(5000);
				loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().clickResend();
			}
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().errorMessagePopup()
					.verifyHeading(data.get("errorMessageHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().errorMessagePopup()
					.verifyDescription(data.get("errorMessageDescription"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().errorMessagePopup().clickOk();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithInvalidOTP failed due to this exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {

			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyForgotPasswordPageView();
			loginPage.forgotPasswordPage().verifyPageHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().verifyPageDescription(loginData.get("forgotDescription"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			Thread.sleep(30000);
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().verifyEmailVerificationPage();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyEmailHeading(loginData.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyEmailText(loginData.get("verifyEmailDescription"));
			Thread.sleep(3000);
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillPin(loginData.get("code"));
			Thread.sleep(3000);
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(loginData.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillNewPassword(loginData.get("newPassword"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillConfirmPassword(loginData.get("confirmPassword"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickSave();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordInvalidData(String strParams) {
		try {

			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			if (loginData.get("validatePassword").equalsIgnoreCase("yes")) {
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
						.verifyEmailHeading(loginData.get("verifyEmailHeading"));
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillPin(loginData.get("code"));
				Thread.sleep(3000);
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
						.verifyPageHeading(loginData.get("createPasswordHeading"));
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
						.fillNewPassword(loginData.get("newPassword"));
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
						.fillConfirmPassword(loginData.get("confirmPassword"));
				if (loginData.get("confirmPassword").equalsIgnoreCase("")) {
					loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
							.clickNewPassword();
				}

				if (loginData.get("expPasswordMessage").contains("Must be 8-12 characters")) {
					loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
							.VerifyPasswordErrMessage(loginData.get("expPasswordMessage"));
				}
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickSave();

			}

			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
						loginData.get("elementName"));

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordNavigation(String strParams) {
		try {

			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			Thread.sleep(3000);
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().verifyEmailVerificationPage();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyEmailHeading(loginData.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillPin(loginData.get("code"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(loginData.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickCloseIcon();
			loginPage.forgotPasswordPage().verifyPageHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
			.verifyEmailHeading(loginData.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().clickCloseIcon();
			loginPage.forgotPasswordPage().verifyPageHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().clickCloseIcon();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password faield due to exception " + e);
		}
	}
}
