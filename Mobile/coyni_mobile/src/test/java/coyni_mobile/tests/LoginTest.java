package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.HomePage;
import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.LoginPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class LoginTest {

	LoginPage loginPage;
	HomePage homePage;
	LandingPage landingPage;

	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		homePage = new HomePage();
		landingPage = new LandingPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPassword(String strParams) {
		try {

			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent().verifyEmailOtpHeading(loginData.get("emailOtpHeading"));
			loginPage.forgotPasswordPage().verifyEmailComponent().verifyEmail(loginData.get("labelEmail"));
			loginPage.forgotPasswordPage().verifyEmailComponent().clickResend();
			loginPage.forgotPasswordPage().navigationComponent().clickClose();
			loginPage.verifyLoginView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot password faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordInvalidCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testForgotPasswordInvalidPinCredentials(String strParams) {
		try {
			Map<String, String> loginData = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.clickForgotPassword();
			loginPage.forgotPasswordPage().verifyHeading(loginData.get("forgotHeading"));
			loginPage.forgotPasswordPage().fillEmail(loginData.get("email"));
			loginPage.forgotPasswordPage().clickNext();
			loginPage.forgotPasswordPage().verifyEmailComponent().verifyEmailOtpHeading(loginData.get("emailOtpHeading"));
			loginPage.forgotPasswordPage().verifyEmailComponent().fillInputBoxes(loginData.get("invalidOtp"));
			if (!loginData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(loginData.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Forgot password faield with invalid Credentials due to exception " + e);
		}
	}

}
