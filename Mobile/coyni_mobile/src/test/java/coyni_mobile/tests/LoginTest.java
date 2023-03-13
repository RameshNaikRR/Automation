package coyni_mobile.tests;

import java.util.Map;

import javax.xml.crypto.Data;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.EmailVerificationComponent;
import coyni_mobile.pages.HomePage;
import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.LoginPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class LoginTest {

	LoginPage loginPage;
	HomePage homePage;
	LandingPage landingPage;
	EmailVerificationComponent verifyEmailComponent;
	EnterYourPINComponent enterYourPINComponent;

	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		homePage = new HomePage();
		landingPage = new LandingPage();
		verifyEmailComponent = new EmailVerificationComponent();
		enterYourPINComponent = new EnterYourPINComponent();
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
			DriverFactory.getDriver().hideKeyboard();
			// loginPage.clickRememberMe();
			loginPage.clickLogin();
			// loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyLogin();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginNavigationView(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.verifyLoginbtnView();
			landingPage.clickLogin();
			loginPage.VerifyLoginPageView();
			loginPage.navigationComponent().verifyCloseView();
			// Thread.sleep(2000);
			loginPage.navigationComponent().clickClose();
			// Thread.sleep(2000);
			landingPage.verifyLandingPage();
			// navigation LoginPage - Enter Your PIN Component
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			DriverFactory.getDriver().hideKeyboard();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().navigationComponent().verifyBackView();
			loginPage.enterYourPINComponent().navigationComponent().clickBack();
			loginPage.VerifyLoginPageView();
			loginPage.fillPassword(loginData.get("password"));
			DriverFactory.getDriver().hideKeyboard();
//			// navigation LoginPage - Forgot Your PIN Component
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
//			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotYourPinView();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailHeadingview();
			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickBack();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(loginData.get("pin"));
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIDButtonView();
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyNotNowButtonView();
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyDontRemindButtonView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();

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
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			DriverFactory.getDriver().hideKeyboard();
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
//				loginPage.clickLogin();
//				loginPage.verifyPopupMsg(loginData.get("popUpMsg"));
				// loginPage.minimizePopupBySwipeDown();
			}
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
			loginPage.fieldValidationsComponent().validateEmailField(email[0], email[1], email[2]);
			String[] password = data.get("password").split(",");
			loginPage.fieldValidationsComponent().validatePasswordField(password[0], password[1], password[2],
					password[3]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginFieldValidation failed due to Exception " + e);
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
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.enterYourPINComponent().fillPin(loginData.get("wrongPin"));
			loginPage.enterYourPINComponent().clickForgotPin();
//			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotYourPinView();
//			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmail(loginData.get("email"));
//			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailHeadingview();
//			//loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
//					.fillInputBoxes(loginData.get("pin"));// enter wrong pin
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.verifyResendlbl(loginData.get("resendMsgOld"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().clickResend();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.verifyNewResendlbl(loginData.get("resendMsgNew"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Forgot pin is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {

			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().verifyContentHeading(loginData.get("forgotContentHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent()
					.verifyEmailOtpHeading(loginData.get("emailOtpHeading"));
//			 loginPage.forgotPasswordPage().verifyEmailComponent().verifyEmail(loginData.get("labelEmail"));
			loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(loginData.get("code"));
			loginPage.forgotPasswordPage().createPasswordPage().verifyHeading(loginData.get("createHeading"));
			loginPage.forgotPasswordPage().createPasswordPage().fillNewPassword(loginData.get("newPassword"));
			loginPage.forgotPasswordPage().createPasswordPage().fillConfirmPassword(loginData.get("confirmPassword"));
			// loginPage.forgotPasswordPage().createPasswordPage().verifyPassword();
			// loginPage.forgotPasswordPage().createPasswordPage().scrollDown();
			loginPage.forgotPasswordPage().createPasswordPage().clickSave();
			loginPage.forgotPasswordPage().createPasswordPage().verifyMessage(loginData.get("message"));
			loginPage.forgotPasswordPage().createPasswordPage().clickLogin();
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
			loginPage.forgotPasswordPage().verifyContentHeading(loginData.get("forgotContentHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			DriverFactory.getDriver().hideKeyboard();
			loginPage.forgotPasswordPage().clickNext();
			if (!loginData.get("errMessage").isEmpty()) {
				if (new CommonFunctions().isPlatformiOS()) {
					new CommonFunctions().validateFormErrorMessageIOS(loginData.get("errMessage"),
							loginData.get("elementName"));
				} else {
					new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
							loginData.get("elementName"));
				}
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
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(data.get("forgotHeading"));
			// loginPage.forgotPasswordPage().verifyContentHeading(loginData.get("forgotContentHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();

			if (data.get("validatePopUpMsg").contains("yes")) {
				loginPage.forgotPasswordPage().verifyEmailComponent().verifyEmailHeadingview();
				for (int i = 0; i <= 4; i++) {
					loginPage.forgotPasswordPage().verifyEmailComponent().clickResend();
				}
				loginPage.forgotPasswordPage().verifyEmailComponent().errorMessagePopupComponent()
						.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
				loginPage.forgotPasswordPage().verifyEmailComponent().errorMessagePopupComponent()
						.verifyPopUpMsg(data.get("errPopUpMsg"));
				loginPage.forgotPasswordPage().verifyEmailComponent().errorMessagePopupComponent().clickOk();
				loginPage.forgotPasswordPage().verifyEmailComponent().verifyEmailHeadingview();
			} else {
				loginPage.forgotPasswordPage().verifyEmailComponent().errorMessagePopupComponent()
						.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
				loginPage.forgotPasswordPage().verifyEmailComponent().errorMessagePopupComponent()
						.verifyPopUpMsg(data.get("errPopUpMsg"));
				loginPage.forgotPasswordPage().verifyEmailComponent().errorMessagePopupComponent().clickOk();
				loginPage.forgotPasswordPage().verifyHeading(data.get("forgotHeading"));
			}
//			
////			loginPage.forgotPasswordPage().verifyEmailComponent()
////					.verifyEmailOtpHeading(loginData.get("emailOtpHeading"));
//			Thread.sleep(2000);
//			// loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(loginData.get("code"));
//			for (int i = 0; i <= 4; i++) {
//				Thread.sleep(5000);
//				loginPage.forgotPasswordPage().verifyEmailComponent().clickResend();
//				loginPage.forgotPasswordPage().verifyErrorMessage();
//			}
//			loginPage.forgotPasswordPage().verifyEmailComponent().clickOk();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPasswordInvalidOTPCredentials due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithNavigationOption(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().verifyContentHeading(loginData.get("forgotContentHeading"));
			loginPage.forgotPasswordPage().navigationComponent().clickClose();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
			Thread.sleep(2000);
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent()
					.verifyEmailOtpHeading(loginData.get("emailOtpHeading"));
			loginPage.forgotPasswordPage().navigationComponent().clickClose();
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(loginData.get("code"));
			// loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
//			loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(loginData.get("code"));
			loginPage.forgotPasswordPage().createPasswordPage().verifyHeading(loginData.get("createHeading"));
			loginPage.forgotPasswordPage().createPasswordPage().fillNewPassword(loginData.get("newPassword"));
			loginPage.forgotPasswordPage().createPasswordPage().fillConfirmPassword(loginData.get("confirmPassword"));
			loginPage.forgotPasswordPage().createPasswordPage().verifyPassword();
			// loginPage.forgotPasswordPage().createPasswordPage().scrollDown();
			loginPage.forgotPasswordPage().createPasswordPage().clickSave();
			loginPage.forgotPasswordPage().createPasswordPage().verifyMessage(loginData.get("message"));
			loginPage.forgotPasswordPage().createPasswordPage().clickLogin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Password With Navigation Option due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(data.get("forgotHeading"));
			String[] email = data.get("emailFieldValidations").split(",");
			loginPage.forgotPasswordPage().fieldValidationsComponent().validateEmailField(email[0], email[1], email[2]);
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(data.get("code"));
			loginPage.forgotPasswordPage().createPasswordPage().verifyHeading(data.get("createHeading"));
			String[] newPassword = data.get("newPassword").split(",");
			loginPage.forgotPasswordPage().fieldValidationsComponent().validateNewPasswordField(newPassword[0],
					newPassword[1], newPassword[2]);
			String[] confirmPassword = data.get("newPassword").split(",");
			loginPage.forgotPasswordPage().fieldValidationsComponent().validateConfirmPasswordField(confirmPassword[0],
					confirmPassword[1], confirmPassword[2]);

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmail(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().verifyPhoneNumberHeading(loginData.get("phoneNumberHeading"));
			// loginPage.retrieveEmailPage().pasteOption(loginData.get("code"));
			loginPage.verifyEmailComponent().fillInputBoxes(loginData.get("code"));
			loginPage.retrieveEmailPage().verifyLabelAccountHeading(loginData.get("expAccountHeading"));
			loginPage.retrieveEmailPage().clickCoyniAccount();
			loginPage.VerifyLoginPageView();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmail Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			DriverFactory.getDriver().hideKeyboard();
			loginPage.retrieveEmailPage().clickNext();
			if (!loginData.get("errMessage").isEmpty()) {
				if (new CommonFunctions().isPlatformiOS()) {
					new CommonFunctions().validateFormErrorMessageIOS(loginData.get("errMessage"),
							loginData.get("elementName"));
				} else {
					new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
							loginData.get("elementName"));
				}
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithInvalidCredentials Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailView(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().verifyTryAgain(loginData.get("tryAgain"));
			loginPage.retrieveEmailPage().clickTryAgain();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
//			loginPage.retrieveEmailPage().verifyPhoneNumberHeading(loginData.get("phoneNumberHeading"));
//			loginPage.retrieveEmailPage().navigationComponent().clickBack();
//			DriverFactory.getDriver().hideKeyboard();
//			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
//			loginPage.retrieveEmailPage().navigationComponent().clickClose();
			loginPage.VerifyLoginPageView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmailView Failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailNavigationOptions(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.retrieveEmailPage().navigationComponent().clickBack();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().clickNext();
			loginPage.verifyEmailComponent().fillInputBoxes(loginData.get("code"));
			loginPage.retrieveEmailPage().verifyLabelAccountHeading(loginData.get("expAccountHeading"));
			loginPage.retrieveEmailPage().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmailNavigationOptions Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidOTPCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
			loginPage.retrieveEmailPage().clickNext();
//			loginPage.retrieveEmailPage().verifyPhoneNumberHeading(loginData.get("phoneNumberHeading"));
			for (int i = 0; i <= 4; i++) {
				loginPage.retrieveEmailPage().clickResend();
			}
			loginPage.retrieveEmailPage().verifyErrorMessage();
			loginPage.retrieveEmailPage().clickOk();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithInvalidOTPCredentials Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveWithFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// Retreive email
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
			String[] phoneNumber = data.get("phoneNumber").split(",");
			loginPage.retrieveEmailPage().fieldValidationsComponent().validatePhoneNumberField(phoneNumber[0],
					phoneNumber[1], phoneNumber[2]);
			String[] firstName = data.get("firstName").split(",");
			loginPage.retrieveEmailPage().fieldValidationsComponent().validateFirstNameField(firstName[0], firstName[1],
					firstName[2]);
			String[] lastName = data.get("lastName").split(",");
			loginPage.retrieveEmailPage().fieldValidationsComponent().validateLastNameField(lastName[0], lastName[1],
					lastName[2]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveWithFieldValidations failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testRetrieveEmailFieldValidations(String strParams) {
//		try {
//			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
//			landingPage.clickLogin();
//			loginPage.clickRetrieveEmail();
//			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
//			// String phoneNumber = loginData.get("phoneNumber");
//			// loginPage.retrieveEmailPage().validatePhoneNumberField(phoneNumber);
//			// , phoneNumber[1], phoneNumber[2],phoneNumber[3]);
//			String[] firstName = loginData.get("firstName").split(",");
//			loginPage.retrieveEmailPage().validateFirstNameField(firstName[0], firstName[1], firstName[2], firstName[3],
//					firstName[4]);
//			String[] lastName = loginData.get("lastName").split(",");
//			loginPage.retrieveEmailPage().validateLastNameField(lastName[0], lastName[1], lastName[2], lastName[3],
//					lastName[4]);
//			loginPage.retrieveEmailPage().clickNext();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testRetrieveEmailFieldValidations Failed due to exception " + e);
//		}
//	}

	private EnterYourPINComponent retrieveEmailPage() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testLoginFieldValidation(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//
//			landingPage.clickLogin();
//			loginPage.VerifyLoginPageView();
//			loginPage.verifyEmailview();
//			loginPage.verifyPasswordview();
//			loginPage.verifyRememberMeView();
//			String[] email = data.get("email").split(",");
//			loginPage.validateEmailField(email[0], email[1], email[2]);
//			String[] password = data.get("password").split(",");
//			loginPage.validatePasswordField(password[0], password[1], password[2]);
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPinWithValidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			DriverFactory.getDriver().hideKeyboard();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyHeading(data.get("expEnterYourPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.enterYourPINComponent().fillPin(data.get("wrongPin"));
			loginPage.enterYourPINComponent().clickForgotPin();
//			loginPage.enterYourPINComponent().forgotPinComponent().headingForgotPin(data.get("expForgotPinHeading"));
//			loginPage.enterYourPINComponent().forgotPinComponent().forgotPinDescription(data.get("expForgotPinDescrp"));
//			loginPage.enterYourPINComponent().forgotPinComponent().emailFieldTiltle();
//			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			// verifying email
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailHeadingview();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.verifyEmailOtpHeading(data.get("expVerifyEmailDecrp"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.verifyResendlbl(data.get("resendlbl"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.fillInputBoxes(data.get("otp"));
			// verifying choose pin Component
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyChooseYourPinView();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.enterYourPINComponent().fillPin(data.get("pin"));
			// verifying Confirm pin Component
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("expConfirmYourPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyConfirmYourPinView();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.fillPin(data.get("pin"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyPinMatching(data.get("pinMatchingText"));

			// enterYourPINComponent.forgotPinComponent().crossIconView();
			// enterYourPINComponent.forgotPinComponent().crossIconView();
			// enterYourPINComponent.forgotPinComponent().verifyHeadingClickOnCrossIcon();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPinWithBackNavigation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			DriverFactory.getDriver().hideKeyboard();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyHeading(data.get("expEnterYourPinHeading"));
			loginPage.enterYourPINComponent().clickForgotPin();
//			loginPage.enterYourPINComponent().forgotPinComponent().headingForgotPin(data.get("expForgotPinHeading"));
//			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailHeadingview();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.fillInputBoxes(data.get("otp"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.navigationComponent().clickBack();
			// verifying choose your pin back navigation
//			loginPage.enterYourPINComponent().forgotPinComponent().headingForgotPin(data.get("expForgotPinHeading"));
//			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			loginPage.enterYourPINComponent().verifyHeading(data.get("expEnterYourPinHeading"));
			loginPage.enterYourPINComponent().clickForgotPin();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailHeadingview();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.fillInputBoxes(data.get("otp"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.fillPin(data.get("pin"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("expConfirmYourPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.navigationComponent().clickBack();
			// verifying confirm your pin back navigation
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("expChooseYourPinHeading"));

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPinWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			DriverFactory.getDriver().hideKeyboard();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyHeading(data.get("expEnterYourPinHeading"));

			loginPage.enterYourPINComponent().clickForgotPin();

//			loginPage.enterYourPINComponent().forgotPinComponent().headingForgotPin(data.get("expForgotPinHeading"));
//			loginPage.enterYourPINComponent().forgotPinComponent().clickNext();
			// verifying email
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailHeadingview();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.fillInputBoxes(data.get("otp"));
			// verifying choose pin Component
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.enterYourPINComponent().fillPin(data.get("pin"));
			// verifying Confirm pin Component
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("expConfirmYourPinHeading"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.fillPin(data.get("wrongPin"));
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().choosePinComponent()
					.verifyPinMissMatch();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAllLinksOfCustomer(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.verifyEmailview();
			loginPage.verifyPasswordview();
			loginPage.verifyRememberMeView();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().navigationComponent().clickClose();
			loginPage.clickRetrieveEmail();
			loginPage.retrieveEmailPage().navigationComponent().clickClose();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			DriverFactory.getDriver().hideKeyboard();
			loginPage.clickRememberMe();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().clickForgotPin();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().verifyEmailHeadingview();
			loginPage.enterYourPINComponent().forgotPinComponent().verifyEmailComponent().navigationComponent()
					.clickBack();
			loginPage.enterYourPINComponent().fillPin(data.get("pin"));
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyLogin();
//			tokenAccountPage.btnHome();
		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
		}

	}

}
