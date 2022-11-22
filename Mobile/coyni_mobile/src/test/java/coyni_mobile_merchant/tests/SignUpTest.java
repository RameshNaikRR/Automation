package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.LandingPage;
import coyni_mobile_merchant.pages.RegistrationDBAPage;
import coyni_mobile_merchant.pages.RegistrationProcessPage;
import coyni_mobile_merchant.pages.SignUpPage;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class SignUpTest {

	SignUpPage signUpPage;
	LandingPage landingPage;
	RegistrationProcessPage registrationProcessPage;
	RegistrationDBAPage registrationDBAPage;

	@BeforeMethod
	public void init() {
		signUpPage = new SignUpPage();
		landingPage = new LandingPage();
		registrationProcessPage = new RegistrationProcessPage();
		registrationDBAPage = new RegistrationDBAPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUp(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.clickBusinessAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			signUpPage.fillPassword(data.get("password"));
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			Thread.sleep(4000);
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			Thread.sleep(8000);
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().scrollTermsOfService();
			signUpPage.clickAgreeCheckBox();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickNext();
			Thread.sleep(6000);
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().scrollPrivacyPolicy();
			signUpPage.clickAgreeCheckBox();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickFinishSignup();
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

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUp Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testCreateAccountInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.clickBusinessAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			signUpPage.fillPassword(data.get("password"));
			if (signUpPage.fieldBarCount() == 3) {
				ExtentTestManager.setPassMessageInReport("Password is valid");
			} else {
				ExtentTestManager.setPassMessageInReport("Password is invalid");
			}
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.scrollUpToFirstName();
			if (!data.get("errMessage").isEmpty()) {
				if (new CommonFunctions().isPlatformiOS()) {
					new CommonFunctions().validateFormErrorMessageIOS(data.get("errMessage"), data.get("elementName"));
				} else {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
				}
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpFieldValidations(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.clickBusinessAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			String[] firstName = data.get("firstName").split(",");
			signUpPage.fieldValidationsComponent().validateFirstNameField(firstName[0], firstName[1], firstName[2]);
			String[] lastName = data.get("lastName").split(",");
			signUpPage.fieldValidationsComponent().validateLastNameField(lastName[0], lastName[1], lastName[2]);
			String[] email = data.get("email").split(",");
			signUpPage.fieldValidationsComponent().validateEmailField(email[0], email[1], email[2]);
			String[] phoneNumber = data.get("phoneNumber").split(",");
			signUpPage.fieldValidationsComponent().validatePhoneNumberField(phoneNumber[0], phoneNumber[1],
					phoneNumber[2]);
			String[] password = data.get("password").split(",");
			signUpPage.fieldValidationsComponent().validatePasswordField(password[0], password[1], password[2],
					password[3]);
			String[] confirmPassword = data.get("confirmPassword").split(",");
			signUpPage.fieldValidationsComponent().validateConfirmPasswordField(confirmPassword[0], confirmPassword[1],
					confirmPassword[2]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUpFieldValidations Failed due to this Exception" + e);
		}

	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testFieldValidationCreateAccount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			landingPage.clickGetStarted();
//			signUpPage.clickBusinessAccount();
//			;
//			signUpPage.verifyCreateAccount(data.get("createAccount"));
//			String[] firstName = data.get("firstName").split(",");
//			signUpPage.fieldValidationsComponent().validateFirstNameField(firstName[0], firstName[1], firstName[2],
//					firstName[3], firstName[4], firstName[5]);
//			String[] lastName = data.get("phoneNumber").split(",");
//			signUpPage.fieldValidationsComponent().validateLastNameField(lastName[0], lastName[1], lastName[2],
//					lastName[3], lastName[4], lastName[5]);
//			String[] email = data.get("email").split(",");
//			signUpPage.fieldValidationsComponent().validateEmailField(email[0], email[1], email[2], email[3], email[4],
//					email[5]);
//			String[] phoneNumber = data.get("phoneNumber").split(",");
//			signUpPage.fieldValidationsComponent().validatePhoneNumberField(phoneNumber[0], phoneNumber[1],
//					phoneNumber[2], phoneNumber[3], phoneNumber[4], phoneNumber[5]);
//			String[] password = data.get("password").split(",");
//			signUpPage.fieldValidationsComponent().validatePasswordField(password[0], password[1], password[2],
//					password[3], password[4], password[5]);
//			String[] confirmPassword = data.get("newPassword").split(",");
//			signUpPage.fieldValidationsComponent().validateConfirmPasswordField(confirmPassword[0],
//					confirmPassword[1], confirmPassword[2], confirmPassword[3], confirmPassword[4], confirmPassword[5]);
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//	}

}
