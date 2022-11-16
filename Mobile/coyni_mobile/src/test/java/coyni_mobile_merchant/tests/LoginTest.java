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
			LandingPage landingPage = new LandingPage();
			landingPage.clickLogin();
			LoginPage loginPage = new LoginPage();
			loginPage.VerifyLoginPageView();
			loginPage.verifyEmailview();
			loginPage.verifyPasswordview();
			loginPage.verifyRememberMeView();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
//			loginPage.verifyPasswordMaskedView(data.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginFor(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			LandingPage landingPage = new LandingPage();
			landingPage.clickLogin();
			LoginPage loginPage = new LoginPage();
			loginPage.VerifyLoginPageView();
			loginPage.verifyEmailview();
			loginPage.verifyPasswordview();
			loginPage.verifyRememberMeView();
			loginPage.fillEmail(data.get("newEmail"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.verifyEmailview();
			loginPage.verifyPasswordview();
			loginPage.verifyRememberMeView();	
			String[] email = data.get("email").split(",");
			loginPage.fieldValidationsComponent().validateEmailField(email[0], email[1], email[2], email[3], email[4], email[5]);
			String[] password = data.get("password").split(",");
			loginPage.fieldValidationsComponent().validatePasswordField(password[0], password[1], password[2], password[3], password[4],
					password[5]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginFieldValidation failed due to Exception " + e);
		}
	}

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
			if (!data.get("errMessage").isEmpty()) {
				if (new CommonFunctions().isPlatformiOS()) {
					new CommonFunctions().validateFormErrorMessageIOS(data.get("errMessage"), data.get("elementName"));
				} else {
					DriverFactory.getDriver().hideKeyboard();
//					loginPage.validateLogin();
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
				}
			}
			if (!data.get("popUpMsg").isEmpty()) {
				loginPage.clickLogin();
				loginPage.verifyPopupMsg(data.get("popUpMsg"));
				loginPage.minimizePopupByClikingOK();
				Thread.sleep(2000);
				loginPage.clickLogin();
				loginPage.verifyPopupMsg(data.get("popUpMsg"));
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
					.fillOtp(data.get("code"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().verifyChoosePinHeading(data.get("choosePinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().fillPin(data.get("pin"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().verifyConfirmPinHeading(data.get("confirmPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
					.choosePinComponent().fillPin(data.get("pin"));
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
			if (data.get("validatePopUpMsg").contains("yes")) {
				loginPage.enterYourPINComponent().forgotPinComponent().phoneAndEmailVerificationComponent()
						.verifyEmailHeading(data.get("emailVerificationHeading"));
				for (int i = 0; i <= 4; i++) {
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
			} else {
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
					.fillOtp(data.get("code"));
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
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().fillOtp(data.get("phoneOTP"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage()
					.verifyHeading(data.get("accountPageHeading"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage()
					.verifyDescription(data.get("accountPageDescription"));
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().foundAccountPage().clickCoyniAccount();
			loginPage.verifyEmail(data.get("email"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmail due to this Exception " + e);
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
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().fillOtp(data.get("phoneOTP"));
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
	public void testRetrieveWithFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			//Retreive email
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
//			String[] phoneNumber = data.get("phoneNumber").split(",");
//			loginPage.retrieveEmailPage().fieldValidationsComponent().validatePhoneNumberField(phoneNumber[0], phoneNumber[1], phoneNumber[2]);
			String[] firstName = data.get("firstName").split(",");
			loginPage.retrieveEmailPage().fieldValidationsComponent().validateFirstNameField(firstName[0], firstName[1], firstName[2],data.get("validateDataField"),data.get("validateDataType"),data.get("elementName"));
//			String[] lastName = data.get("phoneNumber").split(",");
//			loginPage.retrieveEmailPage().fieldValidationsComponent().validateFirstNameField(lastName[0], lastName[1], lastName[2],
//					lastName[3], lastName[4], lastName[5]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveWithFieldValidations failed due to exception " + e);
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
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().fillOtp(data.get("phoneOTP"));
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
			loginPage.retrieveEmailPage().phoneAndEmailVerificationComponent().fillOtp(data.get("phoneOTP"));
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
			if (data.get("validatePopUpMsg").contains("yes")) {
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
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().verifyEmailVerificationPage();
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().getEmailText();
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			Thread.sleep(3000);
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
					.fillNewPassword(data.get("newPassword"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
			.verifyPasswordMaskedView(data.get("newPassword"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
					.clickEyeIconNewPassword();
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
					.clickEyeIconConfirmPassword();
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage().clickSave();
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
					.successFailureComponent().verifyPageHeading(data.get("sucessHeading"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
					.successFailureComponent().verifyPageDescription(data.get("sucessDescription"));
//			Thread.sleep(3000);

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
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent()
						.verifyEmailHeading(data.get("verifyEmailHeading"));
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
				Thread.sleep(3000);
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
						.verifyPageHeading(data.get("createPasswordHeading"));
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
						.fillNewPassword(data.get("newPassword"));
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
						.fillConfirmPassword(data.get("confirmPassword"));
				if (data.get("confirmPassword").equalsIgnoreCase("")) {
					loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
							.clickNewPassword();
				}

				if (data.get("expPasswordMessage").contains("Must be 8-12 characters")) {
					loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
							.validateSave();
					loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
							.VerifyPasswordErrMessage(data.get("expPasswordMessage"));
				}

			}

			if (!data.get("errMessage").isEmpty()) {
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage().validateSave();
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
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().verifyEmailVerificationPage();
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage().clickCloseIcon();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().clickCloseIcon();
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
			if (data.get("validatePopUpMsg").contains("yes")) {
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent()
						.verifyEmailHeading(data.get("verifyEmailHeading"));
				Thread.sleep(2000);
				for (int i = 0; i <= 4; i++) {
					Thread.sleep(5000);
					loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().clickResend();
				}
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsg(data.get("errPopUpMsg"));
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.clickOk();
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent()
						.verifyEmailHeading(data.get("verifyEmailHeading"));
			} else {
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
						.verifyPopUpMsg(data.get("errPopUpMsg"));
				loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().errorMessagePopupComponent()
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
			String[] email = data.get("emailFieldValidations").split(",");
			loginPage.forgotPasswordPage().fieldValidationsComponent().validateEmailField(email[0], email[1], email[2],
					email[3], email[4], email[5]);
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent()
					.verifyEmailHeading(data.get("verifyEmailHeading"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			loginPage.forgotPasswordPage().phoneAndEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			String[] newPassword = data.get("newPassword").split(",");
			loginPage.forgotPasswordPage().fieldValidationsComponent().validateNewPasswordField(newPassword[0],
					newPassword[1], newPassword[2], newPassword[3], newPassword[4], newPassword[5]);
			String[] confirmPassword = data.get("newPassword").split(",");
			loginPage.forgotPasswordPage().fieldValidationsComponent().validateConfirmPasswordField(confirmPassword[0],
					confirmPassword[1], confirmPassword[2], confirmPassword[3], confirmPassword[4], confirmPassword[5]);

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}
}
