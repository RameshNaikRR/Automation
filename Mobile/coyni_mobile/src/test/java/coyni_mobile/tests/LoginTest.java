package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.LoginPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class LoginTest {

	LoginPage loginPage;
	LandingPage landingPage;

	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		System.out.println("before test completed************************");
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
			System.out.println("Login method running");
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			System.out.println(loginData);
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinView();
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().verifyEnableFaceIdView();
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
			landingPage.clickLogin();
			loginPage.verifyImageCoyniView();
			loginPage.verifyRememberMeView();
			loginPage.verifyRetrieveEmailView();
			loginPage.verifyForgotPasswordView();
			loginPage.signUpPage().validateEmail(loginData.get("emailValidations"));
			loginPage.fillEmail(loginData.get("email"));
			loginPage.validateCreatePasswordfields(loginData.get("validatePasswords"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinView();
			loginPage.choosePinComponent().verifyLogoutView();
			loginPage.choosePinComponent().clickLogout();
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.choosePinComponent().verifyForgotPinView();
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().verifyEnableFaceIdView();
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().verifyDontRemindButtonView();
			loginPage.choosePinComponent().enableFaceOrTouchIDpage().clickNotNow();
			loginPage.choosePinComponent().dashboardPage().verifyDashboard();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test LoginNavigation view failed due to Exception " + e);
		}
	}

	/**
	 * testLoginWithInvalidCredentials script is to test by filling invalid email
	 * and password in the text fields and validating error messages in Login
	 * feature.
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })

	public void testLoginWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			System.out.println(loginData.get("validatePassword"));
			if (loginData.get("validatePassword").equalsIgnoreCase("Yes")) {
				if (loginData.get("password").length() <= 8) {
					loginPage.clickEmail();
				}
			}
			Thread.sleep(1000);
			loginPage.clickLogin();
			if (!loginData.get("errMessage").isEmpty()) {
				if (new CommonFunctions().isPlatformiOS()) {
					new CommonFunctions().validateFormErrorMessageIOS(loginData.get("errMessage"),
							loginData.get("elementName"));
				} else {
//					new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"),
//							loginData.get("elementName"));
				}
			}
			if (!loginData.get("popUpMsg").isEmpty()) {
				loginPage.verifyPopupDescription(loginData.get("description"));
				loginPage.minimizePopupByClikingOK();
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
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
			Thread.sleep(1000);
			loginPage.choosePinComponent().clickForgotPin();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationView(loginData.get("emailDescription"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYourPinView();
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyConfirmYourPin(loginData.get("confirmPinHeading"));
			if (loginData.get("validateNavigation").equalsIgnoreCase("Yes")) {
				loginPage.navigationComponent().clickBack();
				loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
						.verifyChooseYourPinView();
				loginPage.navigationComponent().clickBack();
				loginPage.choosePinComponent().verifyEnterYourPinView();
				loginPage.navigationComponent().clickClose();
			}
			if (loginData.get("validatePin").equalsIgnoreCase("Yes")) {
				loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
						.fillPin(loginData.get("pin"));
				loginPage.toastComponent().verifyToastMsg(loginData.get("toastMsg"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Forgot pin is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPinDisabledScenario(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			loginPage.choosePinComponent().verifyEnterYourPinhdg(loginData.get("pinHeading"));
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().viewIncorrectPINHeading();
			loginPage.choosePinComponent().clickTryAgain();
			loginPage.choosePinComponent().clickLogout();
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.choosePinComponent().verifyEnterYourPinView();
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().clickForgotPin();
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent()
					.verifyEmailVerificationView(loginData.get("emailDescription"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.choosePinComponent().phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYourPinView();
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
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().viewIncorrectPINHeading();
			loginPage.choosePinComponent().clickTryAgain();
			loginPage.choosePinComponent().fillPin(loginData.get("pin"));
			loginPage.choosePinComponent().viewDisabledHeading();
			DriverFactory.getDriver().resetApp();
			landingPage.clickLogin();
			loginPage.fillEmail(loginData.get("email"));
			loginPage.fillPassword(loginData.get("password"));
			loginPage.clickLogin();
			loginPage.viewDisabledPINPopup();
			loginPage.clickDisPINOk();
			loginPage.verifyImageCoyniView();
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
			loginPage.navigationComponent().clickClose();
			loginPage.clickForgotPassword();
			loginPage.verifyForgotYourPWdHeading(data.get("expHeading"));
			loginPage.verifyForgotYourPasswordview(data.get("description"));
			loginPage.signUpPage().validateEmail(data.get("emailValidations"));
			loginPage.clickNext();
			Thread.sleep(2000);
			loginPage.phoneAndEmailVerificationComponent().verifyEmailVerificationView(data.get("emailDescription"));
			loginPage.phoneAndEmailVerificationComponent().verifyResendView();
			loginPage.navigationComponent().clickBack();
			loginPage.fillEmail(data.get("email"));
			loginPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().verifyCreateNewPasswordView();
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.validateNewPasswordfield(data.get("validatePasswords"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.validateConfirmPasswordfield(data.get("validatePasswords"));
			loginPage.navigationComponent().clickBack();
			loginPage.fillEmail(data.get("email"));
			loginPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.fillNewPassword(data.get("password"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().clickEye();
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
					.fillConfirmPassword(data.get("password"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().clickEye();
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().clickSave();
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().successFailureComponent()
					.verifyPasswordUpdatedDesc(data.get("passwordDesc"));
			loginPage.phoneAndEmailVerificationComponent().createPasswordComponent().successFailureComponent()
					.clickLogin();
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
	public void testForgotPasswordWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.fillEmail(data.get("email"));
			loginPage.clickNext();
			if (data.get("validatePassword").equalsIgnoreCase("Yes")) {
				loginPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
				loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
						.fillNewPassword(data.get("newPassword"));
				loginPage.phoneAndEmailVerificationComponent().createPasswordComponent()
						.fillConfirmPassword(data.get("confirmPassword"));
				loginPage.signUpPage().verifyPasswordREquirementError(data.get("errMessage"));
			}
			Thread.sleep(3000);
			if (data.get("validateErrorMsg").equalsIgnoreCase("Yes")) {
				if (!data.get("errMessage").isEmpty()) {
					new CommonFunctions().validateFormErrorMessageIOS(data.get("errMessage"), data.get("elementName"));
				}
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testForgotPasswordInvalidOTPCredentials(String strParams) {
//		try {
//			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
//			landingPage.clickLogin();
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
//			loginPage.forgotPasswordPage().verifyContentHeading(loginData.get("forgotContentHeading"));
//			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
//			loginPage.forgotPasswordPage().clickNext();
//			loginPage.forgotPasswordPage().verifyEmailComponent()
//					.verifyEmailOtpHeading(loginData.get("emailOtpHeading"));
//			Thread.sleep(2000);
//			// loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(loginData.get("code"));
//			for (int i = 0; i <= 4; i++) {
//				Thread.sleep(5000);
//				loginPage.forgotPasswordPage().verifyEmailComponent().clickResend();
////				 loginPage.forgotPasswordPage().verifyEmailComponent()
////				 .verifyResentMsg(loginData.get("resendMessage"));
//			}
//			loginPage.forgotPasswordPage().verifyEmailComponent().clickOk();
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
//		}
//	}

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
			loginPage.clickRetrieveEmail();
			loginPage.verifyRetrievEmailhdgView(loginData.get("description"));
			loginPage.selectCountry(loginData.get("country"));
			loginPage.signUpPage().validatePhoneNumber(loginData.get("validatePhoneNumber"));
			loginPage.signUpPage().validateFirstNameField(loginData.get("validateFirstName"));
			loginPage.signUpPage().validateLastNameField(loginData.get("validateLastName"));
			loginPage.navigationComponent().clickClose();
			loginPage.clickRetrieveEmail();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName1"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickNext();
			Thread.sleep(2000);
			loginPage.verifyNoUserFound(loginData.get("noUserFoundDesc"));
			loginPage.clickTryAgain();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName1"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickcancel();
			loginPage.clickRetrieveEmail();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName1"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickNext();
			loginPage.navigationComponent().clickClose();
			loginPage.clickRetrieveEmail();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickNext();
			loginPage.phoneAndEmailVerificationComponent()
					.verifyPhoneVerificationView(loginData.get("PhoneNumberDesc"));
			loginPage.phoneAndEmailVerificationComponent().verifyResendView();
			loginPage.navigationComponent().clickClose();
			loginPage.clickRetrieveEmail();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickNext();
			loginPage.phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.navigationComponent().clickClose();
			loginPage.clickRetrieveEmail();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickNext();
			loginPage.phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.clickThisisNotMe();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickNext();
			loginPage.phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.navigationComponent().clickClose();
			loginPage.clickRetrieveEmail();
			loginPage.selectCountry(loginData.get("country"));
			loginPage.fillPhoneNumber(loginData.get("phoneNumber"));
			loginPage.fillFirstName(loginData.get("firstName"));
			loginPage.fillLastName(loginData.get("lastName"));
			loginPage.clickNext();
			loginPage.phoneAndEmailVerificationComponent().fillOtp(loginData.get("code"));
			loginPage.clickRetrieveLogin();
			loginPage.verifyLoginEmail(loginData.get("email"));

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
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickRetrieveEmail();
			loginPage.selectCountry(data.get("country"));
			loginPage.fillPhoneNumber(data.get("phoneNumber"));
			loginPage.fillFirstName(data.get("firstName"));
			loginPage.fillLastName(data.get("lastName"));
			loginPage.clickNext();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessageIOS(data.get("errMessage"), data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithInvalidCredentials Failed due to exception " + e);
		}
	}

////
////	@Test
////	@Parameters({ "strParams" })
////	public void testRetrieveEmailWithInvalidOTPCredentials(String strParams) {
////		try {
////			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
////			landingPage.clickLogin();
////			loginPage.clickForgotEmail();
////			loginPage.retrieveEmailPage().verifyHeading(loginData.get("retrieveEmailHeading"));
////			loginPage.retrieveEmailPage().fillPhoneNumber(loginData.get("phoneNumber"));
////			loginPage.retrieveEmailPage().fillFirstName(loginData.get("firstName"));
////			loginPage.retrieveEmailPage().fillLastName(loginData.get("lastName"));
////			loginPage.retrieveEmailPage().clickNext();
//////			loginPage.retrieveEmailPage().verifyErrorMessage();
//////			loginPage.retrieveEmailPage().clickOk();
//////			loginPage.retrieveEmailPage().clickNext();
////			// Thread.sleep(5000);
////			loginPage.retrieveEmailPage().verifyPhone(loginData.get("phoneHeading"));
////			for (int i = 0; i <= 4; i++) {
////				Thread.sleep(5000);
////				loginPage.retrieveEmailPage().clickResend();
////			}
////			// loginPage.retrieveEmailPage().verifyErrorMessage();
////			loginPage.retrieveEmailPage().clickOk();
////		} catch (Exception e) {
////			ExtentTestManager
////					.setFailMessageInReport("testRetrieveEmailWithInvalidOTPCredentials Failed due to exception " + e);
////		}
////	}

//
//	@Test
//	@Parameters({ "strParams" })
//	public void testPayRequestScanner(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			if(data.get("validateMenuScan").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.clickMenu();
//				tokenAccountPage.tokenHomePopUp().clickScan();
//		//		tokenAccountPage.clickOK();
//				tokenAccountPage.scanPage().clickScanMe();
//				tokenAccountPage.scanPage().clickCross();
//			}
//			if(data.get("validateDasboardScan").equalsIgnoreCase("Yes")) {
//			tokenAccountPage.clickScan();
//			}
//		//	tokenAccountPage.clickOK();
//			tokenAccountPage.scanPage().clickScanMe();
//			tokenAccountPage.scanPage().scanMePage().verifyUserNameView();
//			tokenAccountPage.scanPage().scanMePage().clickShare();
//			tokenAccountPage.scanPage().scanMePage().clickMsg();
//			Thread.sleep(2000);
//			tokenAccountPage.scanPage().scanMePage().clickCopy();
//			tokenAccountPage.scanPage().scanMePage().verifyPhotosPopup();
//			Thread.sleep(4000);
//			tokenAccountPage.scanPage().scanMePage().clickSaveToAlbum();
//			Thread.sleep(1000);
//			tokenAccountPage.scanPage().scanMePage().verifyPhotosPopup();
//			tokenAccountPage.scanPage().scanMePage().clickSetAmount();
//			if(data.get("validateAmount").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.scanPage().scanMePage().setAmountPopup().validatesetAmount(data.get("amount1"));
//				tokenAccountPage.scanPage().scanMePage().setAmountPopup().clickOK();
//				tokenAccountPage.scanPage().scanMePage().setAmountPopup().verifyMaxLimitErrorMsg(data.get("errMessage"));
//				tokenAccountPage.scanPage().scanMePage().setAmountPopup().clickOK();
//			}
//			tokenAccountPage.scanPage().scanMePage().setAmountPopup().fillAmount(data.get("amount"));
//			tokenAccountPage.scanPage().scanMePage().setAmountPopup().clickOK();
//			Thread.sleep(3000);
//			tokenAccountPage.scanPage().scanMePage().clickSaveToAlbum();
//			tokenAccountPage.scanPage().scanMePage().verifyPhotosPopup();
//			tokenAccountPage.scanPage().scanMePage().clickClearAmount();
//			tokenAccountPage.scanPage().scanMePage().clickSetAmount();
//			tokenAccountPage.scanPage().scanMePage().setAmountPopup().fillAmount(data.get("amount2"));
//			tokenAccountPage.scanPage().scanMePage().setAmountPopup().clickOK();
//			Thread.sleep(3000);
//			tokenAccountPage.scanPage().scanMePage().clickSaveToAlbum();
//			tokenAccountPage.scanPage().scanMePage().clickClose();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Pay Request Scanner failed due to Exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testPayRequestScanAmount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			if(data.get("validateMenuScan").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.clickMenu();
//				tokenAccountPage.tokenHomePopUp().clickScan();
//			}
//			if(data.get("validateDasboardScan").equalsIgnoreCase("Yes")) {
//			tokenAccountPage.clickScan();
//			}
//		//	tokenAccountPage.clickOK();
//			Thread.sleep(2000);
//			tokenAccountPage.scanPage().scanCodePage().clickAlbum();
//			// tokenAccountPage.scanPage().scanCodePage().clickAlbum();
//			Thread.sleep(5000);
//			if (data.get("validateSetAmount").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.scanPage().scanCodePage().clickPhoto3();
//				Thread.sleep(10000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().fillAmount(data.get("amount"));
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().fillMessage(data.get("errMessage"));
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().clickDone();
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().clickPay();
//				Thread.sleep(2000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//						.getRecipientAdd();
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//						.getProcessingFee();
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().getTotal();
//
//			}
//			if (data.get("validateWithAmount").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.scanPage().scanCodePage().clickPhoto2();
//				Thread.sleep(10000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//						.getRecipientAdd();
////				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
////						.getProcessingFee();
//			}
//			if(data.get("validateTransaction").equalsIgnoreCase("Yes")) {
//			tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().swipeConfirm();
//			tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//					.enterYourPINComponent().fillPin(data.get("pin"));
//	String ref1 = tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().verifyReferenceId();
//			tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().clickDone();
//			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
//			Thread.sleep(3000);
//			tokenAccountPage.verifyRecentTransactionsView();
//    		Thread.sleep(3000);
//    //		tokenAccountPage.clickFirstTransactions();
//    		tokenAccountPage.transactionsDetailsComponent().getTransactionDetails();
//    		 String ref2 = tokenAccountPage.transactionsDetailsComponent().verifyReferenceId();
//             if(ref1.equals(ref2)) {
//             	ExtentTestManager.setInfoMessageInReport("reference ID is same");
//             }else {
//             	ExtentTestManager.setWarningMessageInReport("reference ID is not same");
//             }
//    		tokenAccountPage.transactionsDetailsComponent().clickBack();
//			}
//    		if(data.get("validateMoreAmount").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.scanPage().scanCodePage().clickPhoto1();
//				Thread.sleep(10000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//				.getRecipientAdd();
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().swipeConfirm();
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().verifyOOPs();
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().clickBuyTokens();
////				Thread.sleep(1000);
////				tokenAccountPage.scanPage().clickScanMe();
////				tokenAccountPage.scanPage().clickScanMe();
////				tokenAccountPage.scanPage().clickCross();
//			}
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Pay Request Scan Amount failed due to Exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testRequestScannerWithAmount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			if(data.get("validateMenuScan").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.clickMenu();
//				Thread.sleep(1000);
//				tokenAccountPage.tokenHomePopUp().clickScan();
//			}
//			if(data.get("validateDasboardScan").equalsIgnoreCase("Yes")) {
//			tokenAccountPage.clickScan();
//			}
//		//	tokenAccountPage.clickOK();
//			Thread.sleep(2000);
//			tokenAccountPage.scanPage().scanCodePage().clickAlbum();
//			if (data.get("validateSetAmount").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.scanPage().scanCodePage().clickPhoto3();
//				Thread.sleep(10000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().fillAmount(data.get("amount"));
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().fillMessage(data.get("errMessage"));
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().clickDone();
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().clickRequest();
//				Thread.sleep(2000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//						.getRecipientAdd();
//			}
//			tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().swipeConfirm();
//			Thread.sleep(1000);
//			tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().clickDone();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test  Request Scan Amount failed due to Exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testPayRequestScannerInMerchant(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickProfile();
//			Thread.sleep(2000);
//			tokenAccountPage.userDetailsPage().clickQRCode();
////			tokenAccountPage.clickScan();
////			tokenAccountPage.clickOK();
////			tokenAccountPage.scanPage().clickScanMe();
//			tokenAccountPage.scanPage().scanMePage().clickShare();
//			tokenAccountPage.scanPage().scanMePage().clickMsg();
//			Thread.sleep(2000);
//			tokenAccountPage.scanPage().scanMePage().clickCopy();
//			Thread.sleep(6000);
//			tokenAccountPage.scanPage().scanMePage().clickSaveToAlbum();
//			tokenAccountPage.scanPage().scanMePage().verifyPhotosPopup();
//			Thread.sleep(1000);
//			tokenAccountPage.scanPage().scanMePage().clickSetAmount();
//			tokenAccountPage.scanPage().scanMePage().setAmountPopup().fillAmount(data.get("amount"));
//			tokenAccountPage.scanPage().scanMePage().setAmountPopup().clickOK();
//			Thread.sleep(3000);
//			tokenAccountPage.scanPage().scanMePage().clickSaveToAlbum();
//			tokenAccountPage.scanPage().scanMePage().clickClearAmount();
//			tokenAccountPage.scanPage().scanMePage().clickClose();
//		//	tokenAccountPage.customerProfilePage().clickLogOut();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Pay Request Scanner failed due to Exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testPayRequestScanAmountInMerchant(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickScan();
//		//	tokenAccountPage.clickOK();
//			Thread.sleep(2000);
//			tokenAccountPage.scanPage().scanCodePage().clickAlbum();
//			Thread.sleep(5000);
//			if (data.get("validateSetAmount").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.scanPage().scanCodePage().clickPhoto2();
//				Thread.sleep(10000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().fillAmount(data.get("amount"));
//				Thread.sleep(1000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().clickPay();
//				Thread.sleep(2000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//						.getRecipientAdd();
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//						.getPaymentMethod();
//			}
//			if (data.get("validateWithAmount").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.scanPage().scanCodePage().clickPhoto1();
//				Thread.sleep(10000);
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//						.getPaymentMethod();
//				tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//						.getRecipientAdd();
//			}
//			tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().swipeConfirm();
//			tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup()
//					.enterYourPINComponent().fillPin(data.get("pin"));
//			tokenAccountPage.scanPage().scanCodePage().payRequestComponent().payRequestConfirmPopup().clickDone();
//			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Pay Request Scan Amount failed due to Exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testByVerifyingAllLinks(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			landingPage.clickLogin();
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordPage().verifyForgotPasswordView();
//			Thread.sleep(1000);
//			loginPage.clickCross();
//			loginPage.clickRetrieveEmail();
//			loginPage.retrieveEmailPage().verifyRetriveEmailView();
//			// loginPage.retrieveEmailPage().verifyHeading(data.get("retrieveEmailHeading"));
//			Thread.sleep(1000);
//			loginPage.clickCross();
//			loginPage.fillEmail(data.get("email"));
//			loginPage.fillPassword(data.get("password"));
//			loginPage.clickLogin();
//			loginPage.enterYourPINComponent().clickForgotPin();
//			loginPage.enterYourPINComponent().forgotPinComponent().verifyForgotPinView();
//			// loginPage.enterYourPINComponent().forgotPinComponent().verifyHeading(data.get("forgotHeading"));
//			Thread.sleep(1000);
//			loginPage.enterYourPINComponent().forgotPinComponent().navigationComponent().clickBack();
//			loginPage.enterYourPINComponent().fillPin(data.get("pin"));
//			Thread.sleep(2000);
//			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
//			tokenAccountPage.clickProfile();
//			Thread.sleep(1000);
//		//	tokenAccountPage.customerProfilePage().clickUserDetails();
//		//	tokenAccountPage.customerProfilePage().userDetailsPage().verifyUserDetailsPageview();
//			// tokenAccountPage.customerProfilePage().userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
//			Thread.sleep(1000);
//			tokenAccountPage.customerProfilePage().userDetailsPage().navigationComponent().clickBack();
//			tokenAccountPage.customerProfilePage().clickPaymentMethods();
//			tokenAccountPage.customerProfilePage().addNewPaymentComponent().verifyAddPaymentMethodView();
//			Thread.sleep(1000);
//			tokenAccountPage.customerProfilePage().addNewPaymentComponent().clickCross();
//			tokenAccountPage.customerProfilePage().clickPreferences();
//			tokenAccountPage.customerProfilePage().preferencesPage().verifyPreferencesView();
//			// tokenAccountPage.customerProfilePage().preferencesPage().verifyHeading(data.get("preferenceHeading"));
//			Thread.sleep(1000);
//			tokenAccountPage.customerProfilePage().preferencesPage().clickBack();
//			tokenAccountPage.customerProfilePage().clickAccountLimits();
//			Thread.sleep(1000);
//			tokenAccountPage.customerProfilePage().accountLimitsPage().verifyAccountLimitsView();
//			// tokenAccountPage.customerProfilePage().accountLimitsPage().verifyHeading(data.get("accountHeading"));
//		//	Thread.sleep(1000);
//			tokenAccountPage.customerProfilePage().accountLimitsPage().navigationComponent().clickBack();
//			tokenAccountPage.customerProfilePage().clickAgreements();
//	//		tokenAccountPage.customerProfilePage().verifyAgreementsView();
//			tokenAccountPage.customerProfilePage().agreementPage().clickBack();
//			tokenAccountPage.customerProfilePage().clickGetHelp();
//			tokenAccountPage.customerProfilePage().verifyGetHelpView();
//			tokenAccountPage.customerProfilePage().navigationComponent().clickBack();
//			tokenAccountPage.customerProfilePage().clickResetPinCode();
//			tokenAccountPage.customerProfilePage().enterYourPINComponent().verifyEnterYourPinView();
//			tokenAccountPage.customerProfilePage().navigationComponent().clickClose();
//			Thread.sleep(1000);
//		//	tokenAccountPage.customerProfilePage().clickFaceIDSetting();
//			tokenAccountPage.customerProfilePage().faceIDPopup().verifyFaceIDPopupView();
//			tokenAccountPage.customerProfilePage().faceIDPopup().clickNotNow();
//			tokenAccountPage.customerProfilePage().clickChangePassword();
//			tokenAccountPage.customerProfilePage().enterYourPINComponent().verifyEnterYourPinView();
//			tokenAccountPage.customerProfilePage().navigationComponent().clickClose();
//			tokenAccountPage.customerProfilePage().clickBack();
//			tokenAccountPage.clickMenu();
//			tokenAccountPage.tokenHomePopUp().clickScan();
//	//		tokenAccountPage.clickOK();
//			tokenAccountPage.scanPage().clickScanMe();
//			tokenAccountPage.scanPage().clickScanCode();
//			tokenAccountPage.scanPage().clickCross();
//			tokenAccountPage.clickMenu();
//			tokenAccountPage.tokenHomePopUp().clickPayRequest();
//			Thread.sleep(3000);
//			tokenAccountPage.payRequestPage().verifyPayRequestPageView();
//			tokenAccountPage.payRequestPage().navigationComponent().clickClose();
//			tokenAccountPage.clickMenu();
//			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
//			tokenAccountPage.customerProfilePage().addNewPaymentComponent().verifyAddPaymentMethodView();
//			tokenAccountPage.customerProfilePage().addNewPaymentComponent().clickCross();
//			tokenAccountPage.clickMenu();
//			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
//			tokenAccountPage.tokenHomePopUp().selectWithdrawMethodPage().verifyWithdrawMethodPageView();
//			tokenAccountPage.tokenHomePopUp().selectWithdrawMethodPage().navigationComponent().clickClose();
//			tokenAccountPage.clickPayRequest();
//			tokenAccountPage.payRequestPage().verifyPayRequestPageView();
//			tokenAccountPage.payRequestPage().navigationComponent().clickClose();
//			tokenAccountPage.clickScan();
//		//	tokenAccountPage.clickOK();
//			tokenAccountPage.scanPage().clickScanMe();
//			tokenAccountPage.scanPage().clickScanCode();
//			tokenAccountPage.scanPage().clickCross();
//			tokenAccountPage.dashboardPage().clickViewMore();
//			tokenAccountPage.dashboardPage().clickCross();
//			Thread.sleep(1000);
//			tokenAccountPage.clickNotificationsIcon();
//			tokenAccountPage.notificationPage().clickBack();
//			tokenAccountPage.clickProfile();
//	//		tokenAccountPage.customerProfilePage().clickLogOut();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Pay Request Scan Amount failed due to Exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testPayRequest(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			if(data.get("validateMenuPayReq").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.clickMenu();
//				tokenAccountPage.tokenHomePopUp().clickPayRequest();
//				tokenAccountPage.payRequestPage().clickCross();
//				Thread.sleep(1000);
//			}
//			if(data.get("validateDashboardPayReq").equalsIgnoreCase("Yes")) {
//				Thread.sleep(1000);	
//			tokenAccountPage.clickPayRequest();
//			tokenAccountPage.payRequestPage().navigationComponent().clickClose();
//			Thread.sleep(2000);
//			tokenAccountPage.clickPayRequest();
//			}
//			if(data.get("validateSearch").equalsIgnoreCase("Yes")) {
//			tokenAccountPage.payRequestPage().clickSearch();
//			tokenAccountPage.payRequestPage().fillSearchBx(data.get("contactName"));
//			Thread.sleep(1000);
//			tokenAccountPage.payRequestPage().verifyOtherPeopleView();
//			}
//			if(data.get("validateContactList").equalsIgnoreCase("Yes")) {
//			tokenAccountPage.payRequestPage().verifyRecentContactList();
//			Thread.sleep(1000);
//			tokenAccountPage.payRequestPage().verifyRecentContactListSize();
//			Thread.sleep(1000);
//			tokenAccountPage.payRequestPage().verifyContactList();
//			tokenAccountPage.payRequestPage().clickfirstRecentContact();
//			}
//			tokenAccountPage.payRequestPage().payRequestComponet().verifyCynView();
//			if(data.get("validateAmount").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.payRequestPage().payRequestComponet().validateAmount(data.get("amount1"));
//				tokenAccountPage.payRequestPage().payRequestComponet().clearText();
//				tokenAccountPage.payRequestPage().payRequestComponet().fillAmount(data.get("amount2"));
//				tokenAccountPage.payRequestPage().payRequestComponet().verifyMinimumLimitErr(data.get("minError"));
//				tokenAccountPage.payRequestPage().payRequestComponet().clearText();
//				tokenAccountPage.payRequestPage().payRequestComponet().fillAmount(data.get("amount3"));
//				tokenAccountPage.payRequestPage().payRequestComponet().verifyMaxLimitErr(data.get("maxError"));
//			}
//			tokenAccountPage.payRequestPage().payRequestComponet().clearText();
//			tokenAccountPage.payRequestPage().payRequestComponet().fillAmount(data.get("amount"));
//			tokenAccountPage.payRequestPage().payRequestComponet().clickConverter();
//			tokenAccountPage.payRequestPage().payRequestComponet().fillMessage(data.get("errMessage"));
//			tokenAccountPage.payRequestPage().payRequestComponet().clickDone();
//			if(data.get("ValidatePay").equalsIgnoreCase("Yes")) {
//			tokenAccountPage.payRequestPage().payRequestComponet().clickPay();
//			tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().getRecipientAdd();
//			tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().getProcessingFee();
//			tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().swipeConfirm();
//			tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().enterYourPINComponent()
//					.fillPin(data.get("pin"));
//			String ref1 = tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().verifyReferenceId();
//			System.out.println(ref1);
//	//		tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().verifyTransactionSucessScreen();
//			tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().clickDone();
//	    	loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
//	    	Thread.sleep(4000);
//	    	tokenAccountPage.verifyRecentTransactionsView();
//    		Thread.sleep(3000);
//    	//	tokenAccountPage.clickFirstTransactions();
//    		tokenAccountPage.transactionsDetailsComponent().getTransactionDetails();
//            String ref2 = tokenAccountPage.transactionsDetailsComponent().verifyReferenceId();
//            System.out.println(ref2);
//            if(ref1.equals(ref2)) {
//            	ExtentTestManager.setInfoMessageInReport("reference ID is same");
//            }else {
//            	ExtentTestManager.setWarningMessageInReport("reference ID is not same");
//            }
//    		tokenAccountPage.transactionsDetailsComponent().clickBack();
//			}
//			if(data.get("ValidateRequest").equalsIgnoreCase("Yes")) {
//				tokenAccountPage.payRequestPage().payRequestComponet().clickRequest();
//				tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().getRecipientAdd();
//				tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().swipeConfirm();
//				tokenAccountPage.payRequestPage().payRequestComponet().payRequestConfirmPopup().clickDone();
//				}
//			
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Pay Request  failed due to Exception " + e);
//		}
//
//	}

}
