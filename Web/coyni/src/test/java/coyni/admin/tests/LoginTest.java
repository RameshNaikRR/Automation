package coyni.admin.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.admin.components.AuthyComponent;
import coyni.admin.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class LoginTest {

	LoginPage loginPage;

	@BeforeMethod
	public void init() {

		loginPage = new LoginPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testAdminLogin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			//loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyPageHeading(data.get("authyHeading"));
			loginPage.authyComponent().verifyPageDescription(data.get("authyDescription"));
			if(data.get("securityKey").equalsIgnoreCase("123456")) {
                loginPage.authyComponent().fillInput(data.get("securityKey"));    
            }else {
                loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
            }
			Thread.sleep(2000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testAdminLoginWithInvalidEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			//loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
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
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			Thread.sleep(2000);
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
	public void testLoginView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.verifyEmail();
			loginPage.verifyPassword();
			loginPage.verifyForgotEmail();
			loginPage.verifyForgotPassword();
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickEyeIcon();
			Thread.sleep(1000);
			loginPage.verifyPasswordMaskedView();
			loginPage.clickEyeIcon();
			Thread.sleep(1000);
			loginPage.verifyPasswordMaskedView();
			loginPage.clickNext();

		} catch (Exception e) {
			// TODO: handle exception
			ExtentTestManager.setFailMessageInReport("Test login view method failed due to this exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginInvalidAuthy(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyPageHeading(data.get("authyHeading"));
			if (!data.get("code").isEmpty()) {
				loginPage.authyComponent().fillAuthyInputInvalid(data.get("code"), data.get("char"));
			}
			if (!data.get("message").isEmpty()) {
				loginPage.authyComponent().verifyMessage(data.get("message"));
			}
			Thread.sleep(2000);
			loginPage.authyComponent().verifyLoginWithInvalidPin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Authy failed due to this exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			//loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().verifyPageHeading(data.get("forgotEmailHeading"));
			loginPage.forgotEmailPage().verifyPageDescription(data.get("forgotEmailDescription"));
			loginPage.forgotEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailPage().clickNext();
			loginPage.forgotEmailPage().forgotEmailNamePage().verifyPageHeading(data.get("forgotEmailNameHeading"));
			Thread.sleep(2000);
			loginPage.forgotEmailPage().forgotEmailNamePage()
					.verifyPageDescription(data.get("forgotEmailNameDescription"));
			loginPage.forgotEmailPage().forgotEmailNamePage().fillFirstName(data.get("firstName"));
			loginPage.forgotEmailPage().forgotEmailNamePage().fillLastName(data.get("lastName"));
			loginPage.forgotEmailPage().forgotEmailNamePage().clickNext();
			Thread.sleep(2000);
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
					.verifyPhoneHeading(data.get("phoneEmailVerificationHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
					.verifyPageDescription(data.get("phoneEmailVerificationDescription"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
					.fillpin(data.get("code"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().verifyMessage(data.get("message"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().chooseAccountPage()
					.verifyPageHeading(data.get("chooseAccountHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().chooseAccountPage()
					.clickUser();
			loginPage.verifyPageHeading(data.get("loginHeading"));
		//	loginPage.viewEmail();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotEmail failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailWithInvalidVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().verifyPageHeading(data.get("forgotEmailHeading"));
			loginPage.forgotEmailPage().verifyPageDescription(data.get("forgotEmailDescription"));
			loginPage.forgotEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailPage().clickNext();
			loginPage.forgotEmailPage().forgotEmailNamePage().verifyPageHeading(data.get("forgotEmailNameHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage().fillFirstName(data.get("firstName"));
			loginPage.forgotEmailPage().forgotEmailNamePage().fillLastName(data.get("lastName"));
			loginPage.forgotEmailPage().forgotEmailNamePage().clickNext();
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
					.verifyPhoneHeading(data.get("phoneEmailVerificationHeading"));
			Thread.sleep(3000);
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().authyComponent()
					.fillInput(data.get("code"));
			if (!data.get("message").isEmpty()) {
				loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().verifyMessage(data.get("message"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Email test failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailNavigationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
		  //  loginPage.forgotEmailPage().verifyForgotEmailunderline();
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().verifyPageHeading(data.get("forgotEmailHeading"));
			loginPage.forgotEmailPage().verifyPageDescription(data.get("forgotEmailDescription"));
			loginPage.forgotEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailPage().forgotEmailNamePage().clickBackToLogin();
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailPage().clickNext();
			loginPage.forgotEmailPage().forgotEmailNamePage().verifyPageHeading(data.get("forgotEmailNameHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage().fillFirstName(data.get("firstName"));
			loginPage.forgotEmailPage().forgotEmailNamePage().fillLastName(data.get("lastName"));
			loginPage.forgotEmailPage().clickNext();
		Thread.sleep(1000);
		loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
		.verifyPhoneHeading(data.get("phoneEmailVerificationHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
					.fillpin(data.get("code"));
			Thread.sleep(1000);
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().chooseAccountPage()
					.verifyPageHeading(data.get("chooseAccountHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().chooseAccountPage()
					.clickReturnToLogin();
			loginPage.verifyPageHeading(data.get("loginHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().verifyPageHeading(data.get("forgotEmailHeading"));
			loginPage.forgotEmailPage().validatePhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailPage().clickNext();
			Thread.sleep(2000);
			//loginPage.forgotEmailPage().forgotEmailNamePage().verifyPageHeading(data.get("forgotEmailNameHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage().validateFirstNameField(data.get("firstName"));
			loginPage.forgotEmailPage().forgotEmailNamePage().validateLastNameField(data.get("lastName"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().verifyPageHeading(data.get("forgotEmailHeading"));
			loginPage.forgotEmailPage().verifyPageDescription(data.get("forgotEmailDescription"));
			loginPage.forgotEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailPage().clickOutside();
			loginPage.forgotEmailPage().clickNext();
			if (data.get("validateNames").equalsIgnoreCase("yes")) {
				loginPage.forgotEmailPage().forgotEmailNamePage().verifyPageHeading(data.get("forgotEmailNameHeading"));
				loginPage.forgotEmailPage().forgotEmailNamePage().fillFirstName(data.get("firstName"));
				loginPage.forgotEmailPage().forgotEmailNamePage().fillLastName(data.get("lastName"));
				loginPage.forgotEmailPage().forgotEmailNamePage().clickOutside();
				loginPage.forgotEmailPage().forgotEmailNamePage().clickNext();
			}
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


	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			// loginPage.forgotPasswordPage().verifyPageHeading("expHeading");
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().verifyPageDescription(data.get("forgotDescription"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyPageHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.getEmailDescription();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageDescription(data.get("createPasswordDescription"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyCreatePasswordAutoFocus();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillCreatePassword(data.get("createPassword"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickSubmit();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().verifySucessHeading(data.get("successHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().verifySucessDescription(data.get("successDescription"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickLogIn();
			loginPage.verifyPageHeading(data.get("loginHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickOutSide();
			loginPage.forgotPasswordPage().clickNext();
			if (data.get("validatePassword").equalsIgnoreCase("yes")) {
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
						.verifyPageHeading(data.get("emailHeading"));
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillpin(data.get("code"));
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
						.verifyPageHeading(data.get("createPasswordHeading"));
				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
						.fillInvalidCreatePassword(data.get("createPassword"));

				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
						.fillConfirmPassword(data.get("confirmPassword"));

				loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickSubmit();
			}
			Thread.sleep(2000);
			if (data.get("errMessage").contains("not registered")) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			} else {
				if (!data.get("errMessage").isEmpty()) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
							data.get("elementName"));
				}
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testForgotPasswordWithInvalidData failed due to exception " + e);
		}

	}
	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidEmailVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyPageHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillpin(data.get("code"));
			Thread.sleep(500);
			if (!data.get("message").isEmpty()) {
				new AuthyComponent().verifyMessage(data.get("message"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Email test failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordNavigation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// Navigation Forgot Password page to Login Page
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().clickBackToLogin();
			// Navigation Email Verification Component To Login Page
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyPageHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().clickBackToLogin();
			// Navigation Create Password Page To Login Page
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyPageHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickBackToLogin();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Email test failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.verifyForgotPassword();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().verifyEmail();
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyPageHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyCreatePassword();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyConfirmPassword();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillInvalidCreatePassword(data.get("createPassword"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.clickEyeIconCreatePassword();
			Thread.sleep(1000);
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyCreatePasswordMaskedView();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.clickEyeIconCreatePassword();
			Thread.sleep(1000);
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyCreatePasswordMaskedView();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.clickEyeIconConfirmPassword();
			Thread.sleep(1000);
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyConfirmPasswordMaskedView();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.clickEyeIconConfirmPassword();
			Thread.sleep(1000);
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyConfirmPasswordMaskedView();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickSubmit();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().verifySucessHeading(data.get("successHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickLogIn();
			loginPage.verifyPageHeading(data.get("loginHeading"));

		} catch (Exception e) {
			// TODO: handle exception
			ExtentTestManager.setFailMessageInReport("Test login view method failed due to this exception " + e);
		}
	}
}
