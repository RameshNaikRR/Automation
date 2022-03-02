package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
			//loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
			loginPage.authyComponent().fillInput(data.get("code"));
			loginPage.authyComponent().verifyMessage(data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			// loginPage.forgotPasswordPage().verifyPageHeading("expHeading");

			loginPage.forgotPasswordPage().verifyPageHeading("forgotHeading");
			loginPage.forgotPasswordPage().verifyPageDescription("description");
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyPageHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyPageDescription(data.get("emailDescription"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("passwordHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageDescription(data.get("passwordDescription"));
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
			loginPage.forgotPasswordPage().verifyPageHeading("forgotHeading");
			loginPage.forgotPasswordPage().verifyPageDescription("description");
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
			loginPage.forgotPasswordPage().verifyPageHeading("forgotHeading");
			loginPage.forgotPasswordPage().verifyPageDescription("description");
			loginPage.forgotPasswordPage().fillEmail(data.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyPageHeading(data.get("emailHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent()
					.verifyPageDescription(data.get("emailDescription"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().fillpin(data.get("code"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageHeading(data.get("passwordHeading"));
			loginPage.forgotPasswordPage().phoneEmailVerificationComponent().createPasswordPage()
					.verifyPageDescription(data.get("passwordDescription"));
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
}
