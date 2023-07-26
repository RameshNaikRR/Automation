package coyni.business.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.business.components.ForgotPasswordComponent;
import coyni.business.components.RetrieveEmailComponent;
import coyni.business.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class LoginTest {

	LoginPage loginPage;
	RetrieveEmailComponent retrieveEmailComponent;
	ForgotPasswordComponent forgotPasswordComponent;

	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		forgotPasswordComponent = new ForgotPasswordComponent();
		retrieveEmailComponent = new RetrieveEmailComponent();

	}

	@Test
	@Parameters({ "strParams" })
	public void testLogin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("businessPassword"));
//			 loginPage.clickeyeIcon();
//			loginPage.verifyPasswordMaskedView(data.get("attribute"), "password");
			loginPage.clickNext();
			Thread.sleep(2000);
			// loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
			if (data.get("securityKey").equalsIgnoreCase("123456")) {
				loginPage.authyComponent().fillInput(data.get("securityKey"));
			} else {
				loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
				ExtentTestManager.setInfoMessageInReport("ok ");
			}
			Thread.sleep(2000);
			if (loginPage.verifyNonMaterialAgrrement() == 0) {
				if (loginPage.verifyTermsOfServicesHeading() == 1) {
					loginPage.scrollToTermsAgree();
					loginPage.clickDone();
				} else {
					loginPage.verifyWelcomeHeading();
				}
				Thread.sleep(3000);
				if (loginPage.verifyPriacyPolicyHeading() == 1) {
					loginPage.scrollToPrivacyAgree();
					loginPage.clickDone();
				}

				else {
					loginPage.verifyWelcomeHeading();
				}
			} else {
				Thread.sleep(3000);
				if (loginPage.verifyPriacyPolicyHeading() == 1) {
					loginPage.scrollToPrivacyAgree();
					loginPage.clickDone();
				}

				else {
					loginPage.verifyWelcomeHeading();
				}
				Thread.sleep(2000);
				if (loginPage.verifyTermsOfServicesHeading() == 1) {
					loginPage.scrollToTermsAgree();
					loginPage.clickDone();
				}

				else {
					loginPage.verifyWelcomeHeading();
				}
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAdminLogin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// loginPage.verifyPageHeading(data.get("loginHeading"));
			// loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyPageHeading(data.get("authyHeading"));
//			loginPage.authyComponent().verifyPageDescription(data.get("authyDescription"));
			if (data.get("securityKey").equalsIgnoreCase("123456")) {
				loginPage.authyComponent().fillInput(data.get("securityKey"));
			} else {
				loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
			}
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickRefresh();
			loginPage.getEmail();
			Thread.sleep(5000);
			loginPage.viewForgotEmail();
			loginPage.viewForgotPassword();
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickEyeIcon();
			loginPage.verifyPasswordMaskedView(data.get("attribute"), "password");
			loginPage.clickNext();
			loginPage.authyComponent().clickGoBack();
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyPageHeading(data.get("authyHeading"));
			if (data.get("securityKey").equalsIgnoreCase("123456")) {
				loginPage.authyComponent().fillInput(data.get("securityKey"));
				Thread.sleep(3000);
			} else {
				loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
				Thread.sleep(3000);
				ExtentTestManager.setInfoMessageInReport("ok ");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAdminLoginWithInvalidEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			loginPage.verifyPageHeading(data.get("loginHeading"));
			// loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("businessPassword"));
			loginPage.clickNext();
			loginPage.toastComponent().verifyToast(data.get("title"), data.get("toastMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("businessPassword"));
			loginPage.clickOutSide();
			loginPage.clickNext();
			Thread.sleep(4000);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			ExtentTestManager
					.setFailMessageInReport("Login test with invalid credentials failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginTerminatedUser(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("businessPassword"));
			loginPage.clickNext();
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
			if (!data.get("toastMessage").isEmpty()) {
				loginPage.toastComponent().verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginTerminatedUser failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginWithUnverifiedUser(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("businessPassword"));
			loginPage.clickNext();
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
			if (!data.get("toastMessage").isEmpty()) {
				loginPage.toastComponent().verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginTerminatedUser failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginWithInvalidAuthy(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("businessPassword"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyPageHeading(data.get("authyHeading"));
			if (!data.get("code").isEmpty()) {
				loginPage.authyComponent().fillAuthyInputInvalid(data.get("code"), data.get("char"));
			}
			if (!data.get("errMessage").isEmpty()) {

				loginPage.authyComponent().verifyMessage(data.get("errMessage"));
			}
			Thread.sleep(2000);
			loginPage.authyComponent().verifyLoginWithInvalidPin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginWithInvalidAuthy failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginWithPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("businessPassword"));
			loginPage.clickNext();
			 loginPage.authyComponent().clickSms();
			loginPage.phoneVerificationComponent().verifyPhoneVerificationHeading(data.get("phoneHeading"));
			if (data.get("code").equalsIgnoreCase("123456")) {
				loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			} else {
				loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test login with phone number failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginWithInvalidPhoneOTP(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("businessEmail"));
			loginPage.fillPassword(data.get("businessPassword"));
			loginPage.clickNext();
			loginPage.authyComponent().clickSms();
//			loginPage.phoneVerificationComponent().verifyHeading(data.get("phoneHeading"));
			loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			if (!data.get("errMessage").isEmpty()) {
				loginPage.phoneVerificationComponent().verifyMessage(data.get("errMessage"));
			}
			Thread.sleep(2000);
//			loginPage.phoneVerificationComponent().verifyLoginWithInvalidPin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test login with invalid phone Otp failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
			loginPage.forgotPasswordComponent().clickNext();
			loginPage.forgotPasswordComponent().verifyEmailVerificationHeading(data.get("verificationHeading"));
			loginPage.forgotPasswordComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordComponent().verifyCreatePasswordHeading(data.get("CreatePasswordHeading"));
			loginPage.forgotPasswordComponent().fillPassword(data.get("enterPassword"));
			loginPage.forgotPasswordComponent().verifyPasswordMaskedView(data.get("attribute"), "password");
			loginPage.forgotPasswordComponent().clickIcon();
			loginPage.forgotPasswordComponent().fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordComponent().clickSubmit();
			loginPage.forgotPasswordComponent().verifySuccessHeading(data.get("successHeading"));
			loginPage.forgotPasswordComponent().clickLogin();
			Thread.sleep(4000);
			loginPage.verifyPageHeading(data.get("loginHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
			loginPage.forgotPasswordComponent().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(1000);
				new CommonFunctions().validateFormErrorMessageForForgotPasswordInvalid(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPasswordWithInvalidEmail failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidPhoneOTP(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
			loginPage.forgotPasswordComponent().clickNext();
			loginPage.forgotPasswordComponent().verifyEmailVerificationHeading(data.get("verificationHeading"));
			loginPage.forgotPasswordComponent().fillpin(data.get("code"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessageForForgotPasswordInvalidPhoneOTP(data.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testForgotPasswordWithInvalidPhoneOTP failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidEmailAlreadyExistsEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
			loginPage.forgotPasswordComponent().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(1000);
				new CommonFunctions()
						.validateFormErrorMessageForForgotPasswordInvalidEmailExists(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPasswordWithInvalidEmail failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testForgotPasswordWithInvalidData(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			loginPage.verifyPageHeading(data.get("loginHeading"));
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordComponent().verifyPageHeading(data.get("forgotPasswordHeading"));
//			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
//			loginPage.forgotPasswordComponent().clickOutSide();
//			loginPage.forgotPasswordComponent().clickNext();
//			if (data.get("validatePassword").equalsIgnoreCase("yes")) {
//				loginPage.forgotPasswordComponent().emailVerificationComponent()
//						.verifyEmailVerificationHeading(data.get("emailHeading"));
//				loginPage.forgotPasswordComponent().emailVerificationComponent().fillpin(data.get("code"));
//				loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//						.verifyPageHeading(data.get("createPasswordHeading"));
//				loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//						.fillInvalidCreatePassword(data.get("createPassword"));
//
//				loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//						.fillConfirmPassword(data.get("confirmPassword"));
//
//				loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage().clickSubmit();
//			}
//			Thread.sleep(2000);
//			if (data.get("errMessage").contains("not registered")) {
//				new CommonFunctions().validateFormErrorMessageForForgotPassword(data.get("errMessage"));
//			} else {
//				if (!data.get("errMessage").isEmpty()) {
//					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
//							data.get("elementName"));
//				}
//			}
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testForgotPasswordWithInvalidData failed due to exception " + e);
//		}
//
//	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testForgotPasswordWithoutSetPassword(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			loginPage.verifyPageHeading(data.get("loginHeading"));
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordComponent().verifyPageHeading(data.get("forgotPasswordHeading"));
//			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
//			loginPage.forgotPasswordComponent().clickOutSide();
//			loginPage.forgotPasswordComponent().clickNext();
//			loginPage.forgotPasswordComponent().verifyErrMessage(data.get("message"));
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport("testForgotPasswordWithoutSetPassword failed due to exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidPasswordFeild(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
			loginPage.forgotPasswordComponent().clickNext();
			loginPage.forgotPasswordComponent().verifyEmailVerificationHeading(data.get("verificationHeading"));
//			loginPage.forgotPasswordComponent().verifyEmail(data.get("lblEmail") + ".");
			loginPage.forgotPasswordComponent().authyComponent().fillInput(data.get("code"));
			Thread.sleep(5000);
			loginPage.forgotPasswordComponent().verifyCreatePasswordHeading(data.get("CreatePasswordHeading"));
			loginPage.forgotPasswordComponent().fillPassword(data.get("enterPassword"));
			loginPage.forgotPasswordComponent().verifyPasswordMaskedView(data.get("attribute"), "password");
			loginPage.forgotPasswordComponent().clickIcon();
			loginPage.forgotPasswordComponent().fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordComponent().verifyPasswordMaskedView(data.get("attribute"), "password");
			loginPage.forgotPasswordComponent().clickIcon();
			loginPage.forgotPasswordComponent().clickSubmit();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessageForForgotPasswordChangePassword(data.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testForgotPasswordWithInvalidPasswordFiled failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithResendOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
			loginPage.forgotPasswordComponent().clickNext();
			for (int i = 0; i <= 4; i++) {
				Thread.sleep(3000);
				// loginPage.phoneVerificationComponent().emailVerificationComponent().clickResendVerificationCode();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPasswordWithResendOption failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testForgotPasswordWithInvalidEmailVerificationCode(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			loginPage.verifyPageHeading(data.get("loginHeading"));
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordComponent().verifyPageHeading(data.get("forgotHeading"));
//			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
//			loginPage.forgotPasswordComponent().clickNext();
//			loginPage.forgotPasswordComponent().emailVerificationComponent()
//					.verifyEmailVerificationHeading(data.get("emailHeading"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().fillpin(data.get("code"));
//			Thread.sleep(500);
//			if (!data.get("message").isEmpty()) {
//				new AuthyComponent().verifyMessage(data.get("message"));
//			}
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Forgot Email test failed due to exception " + e);
//
//		}
//	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testForgotPasswordNavigation(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			// Navigation Forgot Password page to Login Page
//			loginPage.verifyPageHeading(data.get("loginHeading"));
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordComponent().verifyPageHeading(data.get("forgotHeading"));
//			loginPage.forgotPasswordComponent().verifyPageDescription(data.get("forgotDescription"));
//			loginPage.forgotPasswordComponent().clickBackToLogin();
//			// Navigation Email Verification Component To Login Page
//			loginPage.verifyPageHeading(data.get("loginHeading"));
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordComponent().verifyPageHeading(data.get("forgotHeading"));
//			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
//			loginPage.forgotPasswordComponent().clickNext();
//			loginPage.forgotPasswordComponent().emailVerificationComponent()
//					.verifyEmailVerificationHeading(data.get("emailHeading"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().clickBacktoLogin();
//			// Navigation Create Password Page To Login Page
//			loginPage.verifyPageHeading(data.get("loginHeading"));
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordComponent().verifyPageHeading(data.get("forgotHeading"));
//			loginPage.forgotPasswordComponent().fillEmail(data.get("email"));
//			loginPage.forgotPasswordComponent().clickNext();
//			loginPage.forgotPasswordComponent().emailVerificationComponent()
//					.verifyEmailVerificationHeading(data.get("emailHeading"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().fillpin(data.get("code"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.verifyPageHeading(data.get("createPasswordHeading"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage().clickBackToLogin();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Forgot Email test failed due to exception " + e);
//
//		}
//	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testForgotPasswordView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			loginPage.verifyPageHeading(data.get("loginHeading"));
//			loginPage.verifyForgotPassword();
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordComponent().verifyPageHeading(data.get("forgotHeading"));
//			loginPage.forgotPasswordComponent().verifyEmail();
//			loginPage.forgotPasswordComponent().fillEmail(data.get("businessEmail"));
//			loginPage.forgotPasswordComponent().clickNext();
//			loginPage.forgotPasswordComponent().emailVerificationComponent()
//					.verifyEmailVerificationHeading(data.get("emailHeading"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().fillpin(data.get("code"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.verifyPageHeading(data.get("createPasswordHeading"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.verifyCreatePassword();
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.verifyConfirmPassword();
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.fillInvalidCreatePassword(data.get("createPassword"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.clickEyeIconCreatePassword();
//			Thread.sleep(1000);
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.verifyCreatePasswordMaskedView();
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.clickEyeIconCreatePassword();
//			Thread.sleep(1000);
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.verifyCreatePasswordMaskedView();
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.fillConfirmPassword(data.get("confirmPassword"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.clickEyeIconConfirmPassword();
//			Thread.sleep(1000);
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.verifyConfirmPasswordMaskedView();
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.clickEyeIconConfirmPassword();
//			Thread.sleep(1000);
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.verifyConfirmPasswordMaskedView();
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage().clickSubmit();
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage()
//					.verifySucessHeading(data.get("sucessHeading"));
//			loginPage.forgotPasswordComponent().emailVerificationComponent().createPasswordPage().clickLogIn();
//			loginPage.verifyPageHeading(data.get("loginHeading"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Test login view method failed due to this exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailHeading"));
//			loginPage.retrieveEmailComponent().verifyRetrieveEmailDescription(data.get("retrieveDescription"));
			loginPage.retrieveEmailComponent().selectCountryCode();
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailComponent().fillLastName(data.get("lastName"));
			new CommonFunctions().clickTab();
			loginPage.retrieveEmailComponent().clickNext();
			Thread.sleep(2000);
			loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			loginPage.weFoundYourAccountComponent().clickBacktoLogin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Retrieve email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailHeading"));
//			loginPage.retrieveEmailComponent().verifyRetrieveEmailDescription(data.get("retrieveDescription"));
			loginPage.retrieveEmailComponent().selectCountryCode();
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().clickNext();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("forgotEmailNameHeading"));
			loginPage.retrieveEmailComponent().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailComponent().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailComponent().clickNext();
			loginPage.retrieveEmailComponent().phoneVerificationComponent()
					.verifyPhoneVerificationHeading(data.get("phoneEmailVerificationHeading"));
			Thread.sleep(3000);
			loginPage.retrieveEmailComponent().phoneVerificationComponent().authyComponent()
					.fillInput(data.get("code"));
			if (!data.get("message").isEmpty()) {
				loginPage.retrieveEmailComponent().phoneVerificationComponent().verifyMessage(data.get("message"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Retrieve Email test failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailComponent().verifyRetrieveEmailDescription(data.get("retrieveEmailDescription"));
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().clickBacktoLogin();
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().clickNext();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailNameHeading"));
			loginPage.retrieveEmailComponent().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailComponent().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailComponent().clickNext();
			Thread.sleep(1000);
			loginPage.retrieveEmailComponent().phoneVerificationComponent()
					.verifyPhoneVerificationHeading(data.get("phoneEmailVerificationHeading"));
			loginPage.retrieveEmailComponent().phoneVerificationComponent().fillpin(data.get("code"));
			Thread.sleep(1000);
			loginPage.retrieveEmailComponent().phoneVerificationComponent().chooseAccountPage()
					.verifyPageHeading(data.get("chooseAccountHeading"));
			loginPage.retrieveEmailComponent().phoneVerificationComponent().chooseAccountPage().clickReturnToLogin();
			// loginPage.verifyPageHeading(data.get("loginHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Retrieve Email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailComponent().validatePhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().clickNext();
			Thread.sleep(3000);
//			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("forgotEmailNameHeading"));
			loginPage.retrieveEmailComponent().validateFirstNameField(data.get("firstName"));
			loginPage.retrieveEmailComponent().validateLastNameField(data.get("lastName"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Retrieve email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickRetrievemail();
//			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailHeading"));
//			loginPage.retrieveEmailComponent().verifyRetrieveEmailDescription(data.get("forgotEmailDescription"));
			loginPage.retrieveEmailComponent().selectCountryCode();
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			new CommonFunctions().clickTab();
//			loginPage.clickNext();
//			loginPage.retrieveEmailComponent().fillFirstName(data.get("firstName"));
//			loginPage.retrieveEmailComponent().fillLastName(data.get("lastName"));
//			loginPage.clickNext();
//			loginPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));//
//			loginPage.phoneVerificationComponent().verifyPhoneNumber();
//			loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmailWithPhoneNumber failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailHeading"));
//			loginPage.retrieveEmailComponent().verifyRetrieveEmailDescription(data.get("forgotEmailDescription"));
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().clickOutside();
//			loginPage.retrieveEmailComponent().clickNext();
			if (data.get("validateNames").equalsIgnoreCase("yes")) {
				loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailNameHeading"));
				loginPage.retrieveEmailComponent().fillFirstName(data.get("firstName"));
				loginPage.retrieveEmailComponent().fillLastName(data.get("lastName"));
				loginPage.retrieveEmailComponent().clickOutside();
				loginPage.retrieveEmailComponent().clickNext();
			}
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Retrieve email with invalid data test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidFirstAndLastName(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailComponent().selectCountryCode();
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().fillFirstName(data.get("firstName"));
			new CommonFunctions().clickOutSideElement();
			loginPage.retrieveEmailComponent().fillLastName(data.get("lastName"));
			Thread.sleep(2000);
//			loginPage.retrieveEmailComponent().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testRetrieveEmailWithInvalidFirstAndLastName failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithResendOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailComponent().selectCountryCode();
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
//			loginPage.clickNext();
			loginPage.retrieveEmailComponent().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailComponent().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailComponent().clickNext();
			for (int i = 0; i <= 2; i++) {
				Thread.sleep(4000);
				loginPage.phoneVerificationComponent().clickResendCode();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRetrieveEmailWithResendOption failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidFirstAndLastNameDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveEmailHeading"));
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
//			loginPage.clickNext();
			loginPage.retrieveEmailComponent().fillFirstName(data.get("firstName"));
			Thread.sleep(2000);
			loginPage.retrieveEmailComponent().fillLastName(data.get("lastName"));
			loginPage.retrieveEmailComponent().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
				// new
				// CommonFunctions().validateFormErrorMessagesforSpaces(data.get("errMessage"),
				// data.get("colour"),
				// data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testRetrieveEmailWithInvalidFirstAndLastName failed due to exception " + e);
		}
	}

}
