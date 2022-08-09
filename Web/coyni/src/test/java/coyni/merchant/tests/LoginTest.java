package coyni.merchant.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.pages.HomePage;
import coyni.merchant.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class LoginTest {
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void init() {
		loginPage = new LoginPage();
		homePage = new HomePage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.verifyEmailView();
			loginPage.verifyPasswordView();
			loginPage.verifyForgotEmailView();
			loginPage.verifyForgotPasswordView();
			loginPage.verifySignUpView();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.verifyPasswordMaskedView(data.get("attribute"), "password");
			loginPage.clickeyeIcon();
			loginPage.verifyPasswordMaskedView(data.get("attribute"), "password");
			loginPage.clickNext();
			// loginPage.authyComponent().validateAuthyField(data.get("code"));
			loginPage.authyComponent().clickGoBack();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login test view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginPageFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.validateEmailTextField(data.get("email"));
			loginPage.validatePasswordText(data.get("password"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginPageFieldValidation failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLogin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
			loginPage.authyComponent().fillInput(data.get("code"));
			Thread.sleep(3000);
			// loginPage.authyComponent().verifyMessage(data.get("message"));
			// loginPage.authyComponent().verifyLogin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickTab();
			loginPage.clickNext();
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
//			 if (!data.get("invalidAttempts").isEmpty()) {
//	                loginPage.validateRemainingAttempts(data.get("invalidAttempts"));
//	            }
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			} else if (!data.get("toastMessage").isEmpty()) {
				loginPage.toastComponent().verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Login test with Invalid credentials failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginWithInvalidAuthy(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
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
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
//			loginPage.authyComponent().clickSms();
			loginPage.phoneVerificationComponent().verifyHeading(data.get("phoneHeading"));
			loginPage.phoneVerificationComponent().fillpin(data.get("code"));
//			String[] msg = data.get("errMessage").split(",");
//			for (int i = 0; i < msg.length; i++) {
//				loginPage.phoneVerificationComponent().fillpin(data.get("code"));
//				loginPage.phoneVerificationComponent().verifyMessage(msg[i]);
//			}
//			loginPage.phoneVerificationComponent().clickResend();
//			loginPage.phoneVerificationComponent().verifyResend(data.get("resendMsg"));
//			for (int i = 0; i <= 3; i++) {
//				Thread.sleep(5000);
//				loginPage.phoneVerificationComponent().clickResend();
//				loginPage.phoneVerificationComponent().verifyResend(data.get("resendMsg"));
//			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test login with phone number failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginWithResendOTP(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().clickSms();
			loginPage.phoneVerificationComponent().verifyHeading(data.get("phoneHeading"));
			String[] msg = data.get("errMessage").split(",");
			for (int i = 0; i < msg.length; i++) {
				loginPage.phoneVerificationComponent().fillpin(data.get("code"));
				loginPage.phoneVerificationComponent().verifyMessage(msg[i]);
			}
			loginPage.phoneVerificationComponent().clickResend();
			loginPage.phoneVerificationComponent().verifyResend(data.get("resendMsg"));
			for (int i = 0; i <= 3; i++) {
				Thread.sleep(5000);
				loginPage.phoneVerificationComponent().clickResend();
				loginPage.phoneVerificationComponent().verifyResend(data.get("resendMsg"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginWithResendOTP failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginWithInvalidPhoneOTP(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().clickSms();
			loginPage.phoneVerificationComponent().verifyHeading(data.get("phoneHeading"));
			loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			if (!data.get("errMessage").isEmpty()) {
				loginPage.phoneVerificationComponent().verifyMessage(data.get("errMessage"));
			}
			Thread.sleep(2000);
			loginPage.phoneVerificationComponent().verifyLoginWithInvalidPin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test login with invalid phone Otp failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailComponent().verifyForgotHeading(data.get("forgotHeading"));
			loginPage.forgotEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.clickNext();
			loginPage.forgotEmailComponent().fillFirstName(data.get("firstName"));
			loginPage.forgotEmailComponent().fillLastName(data.get("lastName"));
			loginPage.clickNext();
			loginPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));//
			loginPage.phoneVerificationComponent().verifyPhoneNumber();
			loginPage.phoneVerificationComponent().clickResend();
			loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			// loginPage.phoneVerificationComponent().verifyChooseHeading(data.get("chooseAccount"));
			loginPage.phoneVerificationComponent().clickEmail();
//			Thread.sleep(1000);
//			loginPage.verifyHeading(data.get("loginHeading"));
//			loginPage.viewEmail();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailWithResendOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailComponent().verifyForgotHeading(data.get("forgotHeading"));
			loginPage.forgotEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.clickNext();
			loginPage.forgotEmailComponent().fillFirstName(data.get("firstName"));
			loginPage.forgotEmailComponent().fillLastName(data.get("lastName"));
			loginPage.clickNext();
			loginPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));//
			loginPage.phoneVerificationComponent().verifyPhoneNumber();
			for (int i = 0; i <= 4; i++) {
				Thread.sleep(3000);
				loginPage.phoneVerificationComponent().clickResend();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailWithValidatePhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailComponent().verifyForgotHeading(data.get("forgotHeading"));
			loginPage.forgotEmailComponent().validatePhoneNumber(data.get("phoneNumber"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailWithValidateFirstAndLastName(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailComponent().verifyForgotHeading(data.get("forgotHeading"));
			loginPage.forgotEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.clickNext();
			Thread.sleep(1000);
			loginPage.forgotEmailComponent().validateFirstNameField(data.get("firstName"));
			loginPage.clickTab();
			loginPage.forgotEmailComponent().validateLastNameField(data.get("lastName"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
		}
	}

//Worked
	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailWithInvalidPhonenumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailComponent().verifyForgotHeading(data.get("forgotHeading"));
			loginPage.forgotEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailComponent().clickforgot();
			Thread.sleep(3000);
			loginPage.clickNext();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot email with invalid phone number test failed due to exception " + e);
		}
	}

// Added worked
	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailWithInvalidFirstAndLastName(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailComponent().verifyForgotHeading(data.get("forgotHeading"));
			loginPage.forgotEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.clickNext();
			loginPage.forgotEmailComponent().fillFirstName(data.get("firstName"));
			Thread.sleep(2000);
			loginPage.forgotEmailComponent().fillLastName(data.get("lastName"));
			loginPage.clickNext();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
		}
	}

//Added now
	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailwithBackActions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailComponent().verifyForgotHeading(data.get("forgotHeading"));
			loginPage.forgotEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailComponent().clickBackToLogin();
			loginPage.clickForgotEmail();
			loginPage.forgotEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.clickNext();
			loginPage.forgotEmailComponent().fillFirstName(data.get("firstName"));
			loginPage.forgotEmailComponent().fillLastName(data.get("lastName"));
			loginPage.clickNext();
			// loginPage.forgotEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
//			loginPage.forgotEmailComponent().clickBackToLogin();
//			loginPage.forgotEmailComponent().verifyFirstName();
//			loginPage.forgotEmailComponent().verifyLastName();
			// loginPage.clickNext();
			Thread.sleep(1000);
			loginPage.forgotEmailComponent().phoneVerificationComponent().authyComponent().fillInput(data.get("code"));
			loginPage.forgotEmailComponent().phoneVerificationComponent()
					.verifyChooseHeading(data.get("chooseAccount"));
			loginPage.forgotEmailComponent().phoneVerificationComponent().clickReturnToLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Email test failed due to exception " + e);
		}
	}

	// Added now
	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailWithPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailComponent().verifyForgotHeading(data.get("forgotHeading"));
			loginPage.forgotEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.clickNext();
			loginPage.forgotEmailComponent().fillFirstName(data.get("firstName"));
			loginPage.forgotEmailComponent().fillLastName(data.get("lastName"));
			loginPage.clickNext();
			loginPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));//
			loginPage.phoneVerificationComponent().verifyPhoneNumber();
			loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Email test failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			// loginPage.forgotPasswordComponent().contentForgotScreen(data.get("content"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("email"));
			loginPage.forgotPasswordComponent().clickNext();
			loginPage.forgotPasswordComponent().verifyEmailVerificationHeading(data.get("verificationHeading"));
			loginPage.forgotPasswordComponent().verifyEmail(data.get("lblEmail") + ".");
			loginPage.forgotPasswordComponent().fillpin(data.get("code"));
			// loginPage.forgotPasswordComponent().verifyMessage(data.get("message"));
			loginPage.forgotPasswordComponent().verifyCreatePasswordHeading(data.get("CreatePasswordHeading"));
			loginPage.forgotPasswordComponent().fillPassword(data.get("enterPassword"));
			loginPage.forgotPasswordComponent().verifyPasswordMaskedView(data.get("attribute"), "password");
			loginPage.forgotPasswordComponent().clickIcon();
			loginPage.forgotPasswordComponent().fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordComponent().clickSubmit();
			loginPage.forgotPasswordComponent().verifySuccessHeading(data.get("successHeading"));
			loginPage.forgotPasswordComponent().clickLogin();
			Thread.sleep(4000);
			loginPage.verifyHeading(data.get("loginHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("email"));
			loginPage.forgotPasswordComponent().clickTab();
			loginPage.forgotPasswordComponent().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(1000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidPhoneOTP(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("email"));
			loginPage.forgotPasswordComponent().clickNext();
			loginPage.forgotPasswordComponent().verifyEmailVerificationHeading(data.get("verificationHeading"));
			loginPage.forgotPasswordComponent().verifyEmail(data.get("lblEmail") + ".");
			loginPage.forgotPasswordComponent().fillpin(data.get("code"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testForgotPasswordWithInvalidPhoneOTpWithSpecialChar(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			loginPage.verifyHeading(data.get("loginHeading"));
//			loginPage.clickForgotPassword();
//			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
//			loginPage.forgotPasswordComponent().fillEmail(data.get("email"));
//			loginPage.forgotPasswordComponent().clickNext();
//			loginPage.forgotPasswordComponent().verifyEmailVerificationHeading(data.get("verificationHeading"));
//			loginPage.forgotPasswordComponent().verifyEmail(data.get("lblEmail") + ".");
//			String[] code = data.get("code").split(",");
//			loginPage.forgotPasswordComponent().validateOTPField(code[0], code[1]);
//			ExtentTestManager.setPassMessageInReport("Amount field is not accepting special characters and Alphabits");
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidPasswordFiled(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordComponent().verifyHeading(data.get("forgotHeading"));
			// loginPage.forgotPasswordComponent().contentForgotScreen(data.get("content"));
			loginPage.forgotPasswordComponent().fillEmail(data.get("email"));
			loginPage.forgotPasswordComponent().clickNext();
			loginPage.forgotPasswordComponent().verifyEmailVerificationHeading(data.get("verificationHeading"));
			loginPage.forgotPasswordComponent().verifyEmail(data.get("lblEmail") + ".");
			loginPage.forgotPasswordComponent().fillpin(data.get("code"));
			// loginPage.forgotPasswordComponent().verifyMessage(data.get("message"));
			loginPage.forgotPasswordComponent().verifyCreatePasswordHeading(data.get("CreatePasswordHeading"));
			loginPage.forgotPasswordComponent().fillPassword(data.get("enterPassword"));
			loginPage.forgotPasswordComponent().fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordComponent().clickTab();
			loginPage.forgotPasswordComponent().clickSubmit();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		}
	}

}
