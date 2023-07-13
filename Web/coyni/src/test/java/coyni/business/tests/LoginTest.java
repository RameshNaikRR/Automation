package coyni.business.tests;

import java.util.Map;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.business.components.AuthyComponent;
import coyni.business.pages.ForgotPasswordPage;
import coyni.business.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class LoginTest {

	LoginPage loginPage;
	ForgotPasswordPage forgotpasswordpage;

	@BeforeMethod
	public void init() {
		System.out.println("Inside login class");
		loginPage = new LoginPage();
		forgotpasswordpage = new ForgotPasswordPage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessLogin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			System.out.println(data);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			// loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyPageHeading(data.get("authyHeading"));
			loginPage.authyComponent().verifyPageDescription(data.get("authyDescription"));
			if (data.get("code").equalsIgnoreCase("123456")) {
				loginPage.authyComponent().fillInput(data.get("code"));
			} else {
				loginPage.authyComponent().fillAuthyInput(data.get("code"));
			}
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);

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
			// loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.toastComponent().verifyToast(data.get("title"), data.get("toastMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}

	@Parameters({ "strParams" })
	public void testLoginInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
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
	public void testForgotPassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().verifyPageDescription(data.get("forgotDescription"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().emailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent()
					.verifyEmailVerificationDescription(data.get("emailDescription"));
			loginPage.forgotPasswordPage().emailVerificationComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifyPageDescription(data.get("createPasswordDescription"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifyCreatePasswordAutoFocus();
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.fillCreatePassword(data.get("createPassword"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage().clickSubmit();
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifySucessHeading(data.get("sucessHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifySucessDescription(data.get("sucessDescription"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage().clickLogIn();
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
				loginPage.forgotPasswordPage().emailVerificationComponent()
						.verifyEmailVerificationHeading(data.get("emailHeading"));
				loginPage.forgotPasswordPage().emailVerificationComponent().fillpin(data.get("code"));
				loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
						.verifyPageHeading(data.get("createPasswordHeading"));
				loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
						.fillInvalidCreatePassword(data.get("createPassword"));

				loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
						.fillConfirmPassword(data.get("confirmPassword"));

				loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage().clickSubmit();
			}
			Thread.sleep(2000);
			if (data.get("errMessage").contains("not registered")) {
				new CommonFunctions().validateFormErrorMessageForForgotPassword(data.get("errMessage"));
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
	public void testForgotPasswordWithoutSetPassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickOutSide();
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyErrMessage(data.get("message"));
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testForgotPasswordWithoutSetPassword failed due to exception " + e);
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
			loginPage.forgotPasswordPage().emailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent().fillpin(data.get("code"));
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
			loginPage.forgotPasswordPage().verifyPageDescription(data.get("forgotDescription"));
			loginPage.forgotPasswordPage().clickBackToLogin();
			// Navigation Email Verification Component To Login Page
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().emailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent().clickBacktoLogin();
			// Navigation Create Password Page To Login Page
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().emailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage().clickBackToLogin();
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
			loginPage.forgotPasswordPage().emailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage().verifyCreatePassword();
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage().verifyConfirmPassword();
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.fillInvalidCreatePassword(data.get("createPassword"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.clickEyeIconCreatePassword();
			Thread.sleep(1000);
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifyCreatePasswordMaskedView();
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.clickEyeIconCreatePassword();
			Thread.sleep(1000);
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifyCreatePasswordMaskedView();
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.clickEyeIconConfirmPassword();
			Thread.sleep(1000);
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifyConfirmPasswordMaskedView();
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.clickEyeIconConfirmPassword();
			Thread.sleep(1000);
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifyConfirmPasswordMaskedView();
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage().clickSubmit();
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage()
					.verifySucessHeading(data.get("sucessHeading"));
			loginPage.forgotPasswordPage().emailVerificationComponent().createPasswordPage().clickLogIn();
			loginPage.verifyPageHeading(data.get("loginHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test login view method failed due to this exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("retrieveHeading"));
			loginPage.retrieveEmailComponent().verifyRetrieveEmailDescription(data.get("retrieveDescription"));
			loginPage.retrieveEmailComponent().selectCountryCode();
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().fillFirstName(data.get("firstName"));
			loginPage.retrieveEmailComponent().fillLastName(data.get("lastName"));
			loginPage.clickNext();
			Thread.sleep(2000);
			loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			loginPage.phoneVerificationComponent().clickBacktoLogin();
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
			loginPage.retrieveEmailComponent().verifyRetrieveEmailDescription(data.get("retrieveDescription"));
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
				loginPage.retrieveEmailComponent().phoneVerificationComponent()
						.verifyMessage(data.get("message"));
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
			loginPage.retrieveEmailComponent().phoneVerificationComponent()
					.fillpin(data.get("code"));
			Thread.sleep(1000);
			loginPage.retrieveEmailComponent().phoneVerificationComponent().chooseAccountPage()
					.verifyPageHeading(data.get("chooseAccountHeading"));
			loginPage.retrieveEmailComponent().phoneVerificationComponent().chooseAccountPage()
					.clickReturnToLogin();
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
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("forgotEmailHeading"));
			loginPage.retrieveEmailComponent().validatePhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().clickNext();
			Thread.sleep(3000);
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("forgotEmailNameHeading"));
			loginPage.retrieveEmailComponent().validateFirstNameField(data.get("firstName"));
			loginPage.retrieveEmailComponent().validateLastNameField(data.get("lastName"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Retrieve email test failed due to exception " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testRetrieveEmailWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.clickRetrievemail();
			loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("forgotEmailHeading"));
			loginPage.retrieveEmailComponent().verifyRetrieveEmailDescription(data.get("forgotEmailDescription"));
			loginPage.retrieveEmailComponent().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.retrieveEmailComponent().clickOutside();
			loginPage.retrieveEmailComponent().clickNext();
			if (data.get("validateNames").equalsIgnoreCase("yes")) {
				loginPage.retrieveEmailComponent().verifyRetieveEmailHeading(data.get("forgotEmailNameHeading"));
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

}
