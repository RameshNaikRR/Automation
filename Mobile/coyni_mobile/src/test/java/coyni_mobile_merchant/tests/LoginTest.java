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
		//	loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyLogin();
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
			loginPage.enterYourPINComponent().forgotPinComponent()
					.VerifyHeadingForgotPin(data.get("forgotHeading"));
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
	public void testCompanyInformation(String strParams) 
	{
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
			loginPage.enterYourPINComponent().enableFaceIDpage().registrationPage().verifyHeading(data.get("RegHeading"));
			loginPage.enterYourPINComponent().enableFaceIDpage().registrationPage().clickStart();
			loginPage.enterYourPINComponent().enableFaceIDpage().registrationPage().registrationCompanyInformationPage().verifyHeading(data.get("companyInfoHeading"));
			
		}catch(Exception e) {
			
		}
	}
}
