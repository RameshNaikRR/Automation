package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.UploadDocumentComponent;
import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class SignUpTest {

	SignUpPage signUpPage;
	LandingPage landingPage;
	UploadDocumentComponent uploadDocumentComponent;

	@BeforeMethod
	public void init() {
		signUpPage = new SignUpPage();
		landingPage = new LandingPage();
	}

	@AfterMethod
	public void DenyPermission() throws InterruptedException {
		uploadDocumentComponent.clickDeny();
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
			// DriverFactory.getDriver().hideKeyboard();
			signUpPage.fillPassword(data.get("password"));
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			Thread.sleep(4000);
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().scrollTermsOfService();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickAgreeCheckBox();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickNext();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().scrollPrivacyPolicy();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickAgreeCheckBox();
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
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.accountCreatedPage().clickSkip();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.tokenAccountPage().verifyRegistration();

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
			signUpPage.clickNext();
			if (!data.get("errMessage").isEmpty()) {
				if (new CommonFunctions().isPlatformiOS()) {
					new CommonFunctions().validateFormErrorMessageIOS(data.get("errMessage"), data.get("elementName"));
				} else {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
				}
			}
//			if (!data.get("errorMessage").isEmpty()) {
//				// Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.SECONDS);
//				new CommonFunctions().validateFormErrorMessage(data.get("errorMessage"), data.get("elementName"));
//
//			}
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

	@Test
	@Parameters({ "strParams" })
	public void testIdentityVerificationTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.accountCreatedPage().clickGetStarted();

			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.accountCreatedPage().identityVerificationPage().verifyIdentity(data.get("verifyHeading"),
							data.get("identityHeading"), data.get("SSN"), data.get("addressLine1"),
							data.get("addressLine2"), data.get("city"), data.get("state"), data.get("zipCode"),
							data.get("identitySuccess"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

}
