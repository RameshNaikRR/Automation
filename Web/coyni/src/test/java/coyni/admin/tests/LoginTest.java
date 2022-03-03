package coyni.admin.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

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
			loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyPageHeading(data.get("authyHeading"));
			loginPage.authyComponent().verifyPageDescription(data.get("authyDescription"));
			// loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
			loginPage.authyComponent().fillInput(data.get("code"));
			loginPage.authyComponent().verifyMessage(data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().verifyPageHeading(data.get("forgotEmailHeading"));
			loginPage.forgotEmailPage().verifyPageDescription(data.get("forgotEmailDescription"));
			loginPage.forgotEmailPage().fillPhoneNumber("phoneNumber");
			loginPage.forgotEmailPage().clickNext();
			loginPage.forgotEmailPage().forgotEmailNamePage().verifyPageHeading(data.get("ForgotEmailNameHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage()
					.verifyPageDescription(data.get("ForgotEmailNameDescription"));
			loginPage.forgotEmailPage().forgotEmailNamePage().fillFirstName(data.get("firstName"));
			loginPage.forgotEmailPage().forgotEmailNamePage().fillLastName(data.get("lastName"));
			loginPage.forgotEmailPage().forgotEmailNamePage().clickNext();
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
					.verifyPageHeading(data.get("expHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
					.verifyPageDescription(data.get("expDescription"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
					.fillpin(data.get("code"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().clickBackToLogin();
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().chooseAccountPage()
					.verifyPageHeading(data.get("expHeading"));
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().chooseAccountPage()
					.clickUser();
			// loginPage.

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().verifyPageHeading(data.get("forgotEmailHeading"));
			loginPage.forgotEmailPage().validatePhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailPage().clickNext();
			loginPage.forgotEmailPage().forgotEmailNamePage().verifyPageHeading("forgotEmailHeading");
			loginPage.forgotEmailPage().forgotEmailNamePage().validateFirstNameField(data.get("firstName"));
			loginPage.forgotEmailPage().forgotEmailNamePage().validateLastNameField(data.get("lastName"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotEmailWithInvalidPhonenumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().verifyPageHeading("forgotEmailHeading");
			loginPage.forgotEmailPage().verifyPageDescription("forgotEmailDescription");
			loginPage.forgotEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailPage().clickNext();
			if (data.get("validateNames").equalsIgnoreCase("yes")) {
				loginPage.forgotEmailPage().forgotEmailNamePage().verifyPageHeading(data.get("ForgotEmailNameHeading"));
				loginPage.forgotEmailPage().forgotEmailNamePage().fillFirstName(data.get("firstName"));
				loginPage.forgotEmailPage().forgotEmailNamePage().fillLastName(data.get("lastName"));
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
	public void testForgotEmailWithInvalidVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.clickForgotEmail();
			loginPage.forgotEmailPage().verifyPageHeading(data.get("forgotEmailHeading"));
			loginPage.forgotEmailPage().verifyPageDescription(data.get("forgotEmailDescription"));
			loginPage.forgotEmailPage().fillPhoneNumber(data.get("phoneNumber"));
			loginPage.forgotEmailPage().clickNext();
			loginPage.forgotEmailPage().forgotEmailNamePage().fillFirstName("firstName");
			loginPage.forgotEmailPage().forgotEmailNamePage().fillLastName("lastName");
			loginPage.forgotEmailPage().forgotEmailNamePage().clickNext();
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent()
					.verifyPageHeading("expHeading");
			loginPage.forgotEmailPage().forgotEmailNamePage().phoneEmailVerificationComponent().fillpin("code");
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
					.verifyPageDescription(data.get("emailDescription"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageDescription(data.get("createPasswordDescription"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillCreatePassword(data.get("createPassword"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.clickEyeIconCreatePassword();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.clickEyeIconConfirmPassword();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickSubmit();

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
			loginPage.forgotPasswordPage().verifyPageHeading(data.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordWithInvalidPassword(String strParams) {
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
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("createPasswordHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillCreatePassword(data.get("createPassword"));

			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.fillConfirmPassword(data.get("confirmPassword"));

			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage().clickSubmit();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
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
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Email test failed due to exception " + e);

		}
}
	}


