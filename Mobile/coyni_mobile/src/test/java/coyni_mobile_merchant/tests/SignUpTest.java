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
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class SignUpTest {

	SignUpPage signUpPage;
	LandingPage landingPage;
	RegistrationProcessPage registrationProcessPage;
	RegistrationDBAPage registrationDBAPage;

	@BeforeMethod
	public void init() {
		DriverFactory.getDriver().resetApp();
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
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			Thread.sleep(6000);
			signUpPage.phoneAndEmailVerificationComponent().agreementComponent()
					.verifyTermsOfServiceUpdateForSignUp(data.get("termsOfServiceHeading"));
			Thread.sleep(6000);
			signUpPage.phoneAndEmailVerificationComponent().agreementComponent()
					.verifyPrivacyPolicyHeadingForSignUp(data.get("privacyPolicyHeading"));
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
	public void testSignUpNavigations(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.navigationComponent().clickBack();
			landingPage.clickGetStarted();
			signUpPage.clickBusinessAccount();
//			landingPage.clickGetStarted();
//			signUpPage.clickBusinessAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.clickCreateAccScreenCloseBtn();
			landingPage.clickGetStarted();
			signUpPage.clickBusinessAccount();
//			signUpPage.navigationComponent().clickBack();
//			landingPage.clickGetStarted();
//			signUpPage.clickBusinessAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			signUpPage.fillPassword(data.get("password"));
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().clickResend();
			signUpPage.phoneAndEmailVerificationComponent().verifyNewCodeMsg();
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().navigationComponent().clickBack();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().clickResend();
			signUpPage.phoneAndEmailVerificationComponent().verifyNewCodeMsg();
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().agreementComponent()
					.verifyTermsOfServiceHeading(data.get("termsOfServiceHeading"));
			signUpPage.clickAgreementsCloseBtn();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().agreementComponent()
					.verifyTermsOfServiceUpdateForSignUp(data.get("termsOfServiceHeading"));
			signUpPage.phoneAndEmailVerificationComponent().agreementComponent()
					.verifyPrivacyHeading(data.get("privacyPolicyHeading"));
			signUpPage.clickAgreementsCloseBtn();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().agreementComponent()
					.verifyTermsOfServiceUpdateForSignUp(data.get("termsOfServiceHeading"));
			signUpPage.phoneAndEmailVerificationComponent().agreementComponent()
					.verifyPrivacyPolicyHeadingForSignUp(data.get("privacyPolicyHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage()
					.verifyHeading(data.get("secureYourAccountHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickNext();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			signUpPage.navigationComponent().clickBack();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage()
					.verifyHeading(data.get("secureYourAccountHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickNext();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.verifyChoosePinHeading(data.get("choosePinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
			signUpPage.navigationComponent().clickBack();
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
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
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
			signUpPage.fieldValidationsComponent().validateFirstNameField(firstName[0], firstName[1], firstName[2],
					firstName[3], data.get("keyBoardType"));
			String[] lastName = data.get("lastName").split(",");
			signUpPage.fieldValidationsComponent().validateLastNameField(lastName[0], lastName[1], lastName[2],
					lastName[3], data.get("keyBoardType"));
			String[] email = data.get("email").split(",");
			signUpPage.fieldValidationsComponent().validateEmailField(email[0], email[1], email[2]);
			String[] phoneNumber = data.get("phoneNumber").split(",");
			signUpPage.fieldValidationsComponent().validatePhoneNumberField(phoneNumber[0], phoneNumber[1],
					phoneNumber[2]);
			String[] newPassword = data.get("password").split(",");
			signUpPage.fieldValidationsComponent().validateNewPasswordField(newPassword[0], newPassword[1],
					newPassword[2], newPassword[3], newPassword[4], newPassword[5], newPassword[6], newPassword[7],
					newPassword[8], newPassword[9], newPassword[10], newPassword[11]);
			String[] confirmPassword = data.get("confirmPassword").split(",");
			signUpPage.fieldValidationsComponent().validateConfirmPasswordField(confirmPassword[0], confirmPassword[1],
					confirmPassword[2]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUpFieldValidations Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testHomePage(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			landingPage.verifyTimeLineOfIntroSlides();
			landingPage.verifyFirstSlide();
			landingPage.verifySecondSlide(data.get("introSecondSlideHeading"));
			landingPage.verifyThirdSlide(data.get("introThirdSlideHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSignUpFieldValidations Failed due to this Exception" + e);
		}

	}

}
