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

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLogin(String strParams) {
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
			// loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyLogin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testLoginNavigationView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			landingPage.verifyLoginbtnView();
//			landingPage.clickLogin();
//			loginPage.VerifyLoginPageView();
//			loginPage.navigationComponent().verifyCloseView();
//			loginPage.navigationComponent().clickClose();
//			landingPage.verifyLandingPage();
//			// navigation LoginPage - Enter Your PIN Component
//			landingPage.clickLogin();
//			loginPage.fillEmail(data.get("email"));
//			loginPage.fillPassword(data.get("password"));
//			loginPage.clickLogin();
//			loginPage.enterYourPINComponent().verifyEnterYourPinView();
//			loginPage.enterYourPINComponent().navigationComponent().verifyCloseView();
//			loginPage.enterYourPINComponent().navigationComponent().clickClose();
//			loginPage.VerifyLoginPageView();
//			loginPage.fillPassword(data.get("password"));
//			// navigation LoginPage - Forgot Your PIN Component
//			loginPage.clickLogin();
//			loginPage.enterYourPINComponent().verifyEnterYourPinView();
//			loginPage.enterYourPINComponent().clickForgotPin();
//			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotYourPinView();
//			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickClose();
//			loginPage.enterYourPINComponent().verifyEnterYourPinView();
//			loginPage.enterYourPINComponent().fillPin(data.get("pin"));
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
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			if (data.get("password").length() < 8) {
				loginPage.clickEmail();
			}
			loginPage.clickLogin();
			if (!data.get("errMessage").isEmpty()) {
				if (new CommonFunctions().isPlatformiOS()) {
					new CommonFunctions().validateFormErrorMessageIOS(data.get("errMessage"), data.get("elementName"));
				} else {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
				}
			}
			if (!data.get("popUpMsg").isEmpty()) {
				loginPage.verifyPopupMsg(data.get("popUpMsg"));
				loginPage.minimizePopupByClikingOK();
				// clicking login button once again to verify Swipe down action
				Thread.sleep(2000);
				loginPage.clickLogin();
				loginPage.verifyPopupMsg(data.get("popUpMsg"));
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
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("emailVerificationHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent().getEmailText();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyOtpTextFieldView();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyGetCodeView();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyResendView();
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
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
			if (data.get("errPopUpMsg").contains("issue with your OTP")) {
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("emailVerificationHeading"));
			for (int i = 0; i < 4; i++) {
				loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
						.clickResend();
			}
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.errorMessagePopupComponent().verifyPopUpMsgHeading(data.get("errPopUpHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.errorMessagePopupComponent().verifyPopUpMsg(data.get("errPopUpMsg"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent().clickOk();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("emailVerificationHeading"));
			}else {
				loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
				.errorMessagePopupComponent().verifyPopUpMsgHeading(data.get("errPopUpHeading"));
		loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
				.errorMessagePopupComponent().verifyPopUpMsg(data.get("errPopUpMsg"));
		loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent().clickOk();
		loginPage.enterYourPINComponent().verifyEnterYourPinView();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPinResendOTP Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPinNavigationView(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);

			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("emailVerificationHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent().getEmailText();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyOtpTextFieldView();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyGetCodeView();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyResendView();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.fillPin(data.get("code"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().verifyChoosePinHeading(data.get("choosePinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().fillPin(data.get("pin"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().verifyConfirmPinHeading(data.get("confirmPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickBack();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().verifyChoosePinHeading(data.get("choosePinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickBack();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("emailVerificationHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickBack();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickBack();
			loginPage.VerifyLoginPageView();

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
			if (data.get("errPopUpMsg").contains("issue with your OTP")) {
				loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent()
						.verifyPhoneHeading(data.get("phoneHeading"));
				for (int i = 0; i <= 4; i++) {
					Thread.sleep(5000);
					loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().clickResend();
				}
				loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
				loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsg(data.get("errPopUpMsg"));
				loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.clickOk();
				loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent()
						.verifyPhoneHeading(data.get("phoneHeading"));
			} else {
				loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
				loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsg(data.get("errPopUpMsg"));
				loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.clickOk();
				loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithInvalidOTP failed due to this exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyForgotPasswordPageView();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().verifyPageDescription(data.get("forgotDescription"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().verifyEmailVerificationPage();
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent()
					.verifyEmailHeading(data.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().getEmailText();
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().fillPin(data.get("code"));
			Thread.sleep(3000);
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
					.fillNewPassword(data.get("newPassword"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
					.clickEyeIconNewPassword();
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
					.clickEyeIconConfirmPassword();
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage().clickSave();
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
					.successFailureComponent().verifyPageHeading(data.get("sucessHeading"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
					.successFailureComponent().verifyPageDescription(data.get("sucessDescription"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
					.successFailureComponent().clickLogin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordInvalidData(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			if (data.get("validatePassword").equalsIgnoreCase("yes")) {
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent()
						.verifyEmailHeading(data.get("verifyEmailHeading"));
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().fillPin(data.get("code"));
				Thread.sleep(3000);
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
						.verifyPageHeading(data.get("createPasswordHeading"));
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
						.fillNewPassword(data.get("newPassword"));
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
						.fillConfirmPassword(data.get("confirmPassword"));
				if (data.get("confirmPassword").equalsIgnoreCase("")) {
					loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
							.clickNewPassword();
				}

				if (data.get("expPasswordMessage").contains("Must be 8-12 characters")) {
					loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
							.VerifyPasswordErrMessage(data.get("expPasswordMessage"));
				}
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage().clickSave();

			}

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordNavigation(String strParams) {
		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			Thread.sleep(3000);
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().verifyEmailVerificationPage();
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent()
					.verifyEmailHeading(data.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().fillPin(data.get("code"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().createPasswordPage().clickCloseIcon();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent()
					.verifyEmailHeading(data.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().clickCloseIcon();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().clickCloseIcon();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordInvalidOTPCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			if (data.get("errPopUpMsg").contains("issue with your OTP")) {
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent()
						.verifyEmailHeading(data.get("verifyEmailHeading"));
				Thread.sleep(2000);
				for (int i = 0; i <= 4; i++) {
					Thread.sleep(5000);
					loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().clickResend();
				}
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsg(data.get("errPopUpMsg"));
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().errorMessagePopupComponent()
						.clickOk();
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent()
						.verifyEmailHeading(data.get("verifyEmailHeading"));
			} else {
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsg(data.get("errPopUpMsg"));
				loginPage.forgotPasswordPage().phoneEmailAndVerificationComponent().errorMessagePopupComponent()
						.clickOk();
				loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			String[] email = data.get("email").split(",");
			loginPage.forgotPasswordPage().validateEmailField(email[0], email[1], email[2], email[3], email[4]);
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}
}
