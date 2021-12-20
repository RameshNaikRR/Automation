package coyni_mobile.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class SignUpTest {

	SignUpPage signUpPage;
	LandingPage landingPage;

	@BeforeMethod
	public void init() {
		signUpPage = new SignUpPage();
		landingPage = new LandingPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUp(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
//			signUpPage.clickCrossMark();
//			signUpPage.clickGetStarted();
			signUpPage.clickPersonalAccount();
//			signUpPage.clickCrossMark();
//			signUpPage.clickGetStarted();
//			signUpPage.clickPersonalAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			//DriverFactory.getDriver().hideKeyboard();
			signUpPage.fillPassword(data.get("password"));
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillPin(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage()
					.verifyHeading(data.get("secureYourAccountHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickNext();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.verifyHeading(data.get("enableFaceIdHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.clickNotNow();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.accountCreatedPage().verifyHeading(data.get("createAccountHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.accountCreatedPage().clickSkip();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.tokenAccountPage().verifyRegistration();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.clickPersonalAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			signUpPage.fillPassword(data.get("password"));
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickNext();
			signUpPage.verifyPhoneHeading(data.get("phoneHeading"));
			if (!data.get("errorMessage").isEmpty()) {
				// Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.SECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errorMessage"), data.get("elementName"));

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCreateAccountInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.clickPersonalAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			signUpPage.fillPassword(data.get("password"));
			if (signUpPage.fieldBarCount() == 3) {
				ExtentTestManager.setPassMessageInReport("Password is valid");
			} else {
				ExtentTestManager.setPassMessageInReport("password is invalid");
			}
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			if (!data.get("errorMessage").isEmpty()) {
				// Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.SECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errorMessage"), data.get("elementName"));

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testFieldValidationCreateAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.clickPersonalAccount();
			String[] firstname = data.get("firstName").split(",");
			String[] lastname = data.get("lastName").split(",");
			String[] email = data.get("email").split(",");
			String[] phonenumber = data.get("phoneNumber").split(",");
			signUpPage.validateFirstName(firstname[0], firstname[1], firstname[2]);
			signUpPage.validateLastName(lastname[0], lastname[1], lastname[2]);
			signUpPage.validateEmailField(email[0], email[1], email[2]);
			signUpPage.validatePhoneNumber(phonenumber[0], phonenumber[1]);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

}
