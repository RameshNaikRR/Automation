package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.UploadDocumentComponent;
import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class SignUpTest {

	SignUpPage signUpPage;
	LandingPage landingPage;
	UploadDocumentComponent uploadDocumentComponent;
	CustomerProfileTest customerProfileTest;

	//@BeforeTest
	
	
	@BeforeMethod
	public void init() {
		DriverFactory.getDriver().resetApp();
		signUpPage = new SignUpPage();
		landingPage = new LandingPage();
	}

	@AfterMethod
	public void DenyPermission() throws InterruptedException {
		uploadDocumentComponent.clickDeny();
	}

	// 2.0//
	@Test
	@Parameters({ "strParams" })
	public void testSignUp(String strParams) {

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
			// signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			// signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage()
					.verifyTermsOfServiceUpdateForSignUp(data.get("termsOfServiceHeading"), data.get("toastMessage"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage()
					.verifyPrivacyPolicyHeadingForSignUp(data.get("privacyPolicyHeading"), data.get("toastMessage"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage()
					.verifyHeading(data.get("secureYourAccountHeading"), data.get("secureAccountDescription"));
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
					.verifyHeading(data.get("enableFaceIdHeading"), data.get("idDescription"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.clickNotNow();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.accountCreatedPage()
					.verifyHeading(data.get("createAccountHeading"));
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.accountCreatedPage().clickSkip();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.tokenAccountPage().verifyRegistration();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	// 2.3//
	@Test
	@Parameters({ "strParams" })
	public void testSignUpTwoDotThree(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.verifyPersonalAccount();
			signUpPage.clickPersonalAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
//			Thread.sleep(2000);
			signUpPage.fillPassword(data.get("password"));
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationPageHeading"),
					data.get("phoneDescription"));
//			signUpPage.phoneAndEmailVerificationComponent()
//			.verifyPhoneHeading(data.get("phoneVerificationPageHeading"), data.get("phoneDescription"),data.get("phoneNumber"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationPageHeading"),
					data.get("emailDescription"), data.get("email"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			Thread.sleep(5000);
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().verifyTermsOfServiceUpdateForSignUp(
					data.get("termsOfServicePageHeading"), data.get("toastMessage"));
			Thread.sleep(5000);
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().verifyPrivacyPolicyHeadingForSignUp(
					data.get("privacyPolicyPageHeading"), data.get("toastMessage"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage()
					.verifyHeading(data.get("secureYourAccountPageHeading"), data.get("secureAccountDescription"));
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
					.verifyHeading(data.get("enableTouchIdPageHeading"), data.get("idDescription"));
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.clickNotNow();
			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
					.accountCreatedPage()
					.verifyHeading(data.get("createAccountPageHeading"));
			if (data.get("validateAddCreditOrDebit").equalsIgnoreCase("Yes")) {
				if (signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().verifyGoToDashboard() == 1) {
					signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
							.enableFaceIDpage().accountCreatedPage().clickGoToDashboard();
					signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
							.enableFaceIDpage().accountCreatedPage().tokenAccountPage().clickAddPayment();
					signUpPage.addNewPaymentComponent().clickDebitCard();
					signUpPage.addNewPaymentComponent().verifyErrHeading();
					signUpPage.addNewPaymentComponent().verifyErrMsg();
					signUpPage.addNewPaymentComponent().clickOk();
				}else {
					signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
							.enableFaceIDpage().accountCreatedPage().clickAddCreditOrDebit();
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
							.verifyHeading(data.get("cardDetailsHeading"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
							.fillNameOnCard(data.get("nameOnCard"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
							.fillCardNumber(data.get("cardNumber"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
							.fillCardExp(data.get("cardExp"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
							.fillCVVorCVC(data.get("cvvOrCVC"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickNext();
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.verifyHeading(data.get("addAddressHeading"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.fillAddressLine1(data.get("addressLine1"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.fillAddressLine2(data.get("addreddLine2"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.fillCity(data.get("city"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.selectState(data.get("state"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.fillZipCode(data.get("zipCode"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage()
							.verifyCountryName(data.get("countryName"));
					if (data.get("validateSaveAddress").equalsIgnoreCase("Yes")) {
						signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
								.clickChkAddress();
					}
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().clickAddCardInAddress();
//				signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
//				.preAuthorizationPage().verifyPreAuthHeading(data.get("preAuthHeading"), data.get("preAuthDescription"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.preAuthorizationPage().fillAmount(data.get("preAuthiAmount"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.preAuthorizationPage().clickVerify();
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.preAuthorizationPage().allDonePage()
							.verifyAllDoneHeading(data.get("successHeading"), data.get("successDescription"));
					signUpPage.paymentMethodsPage().addNewPaymentComponent().addCardPage().mailingAddressComponent()
							.preAuthorizationPage().allDonePage().clickDone();
					if (data.get("viewAddAddress").equalsIgnoreCase("Yes")) {
						signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
								.enableFaceIDpage().accountCreatedPage().tokenAccountPage().verifyAddAddressView();
					}
					if (data.get("viewBuyToken").equalsIgnoreCase("Yes")) {
						signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
								.enableFaceIDpage().accountCreatedPage().tokenAccountPage().verifyBuyTokenView();
					}
				}
			}
			if (data.get("validateSkip").equalsIgnoreCase("Yes")) {
				signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().clickSkip();
				if (data.get("viewAddPayment").equalsIgnoreCase("Yes")) {
					signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
							.enableFaceIDpage().accountCreatedPage().tokenAccountPage().verifyAddPaymentView();
				}
				signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().tokenAccountPage().verifyAddAddressView();
				signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().tokenAccountPage().clickAddPayment();
//				Thread.sleep(2000);
				signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().tokenAccountPage().paymentMethodsPage()
						.verifyPaymentHeading(data.get("addPaymentPageHeading"));
				signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().tokenAccountPage().successFailureComponent()
						.clickClose();
				signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().tokenAccountPage().clickAddAddress();
				signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().tokenAccountPage().mailingAddressComponent()
						.verifyAddress(data.get("addAddressPageHeading"));
				signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
						.enableFaceIDpage().accountCreatedPage().tokenAccountPage().successFailureComponent()
						.clickClose();
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
			signUpPage.clickPasswordEye();
			if (signUpPage.fieldBarCount() == 3) {
				ExtentTestManager.setPassMessageInReport("Password is valid");
			} else {
				ExtentTestManager.setPassMessageInReport("password is invalid");
			}
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickConfirmEye();
			signUpPage.clickNext();
			if (data.get("validateExistingPhoneError").equalsIgnoreCase("Yes")) {
				signUpPage.verifyPhoneError(data.get("phoneError"));
				signUpPage.clickOk();
			}
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
			// signUpPage.clickBusinessAccount();
			signUpPage.clickPersonalAccount();
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
			signUpPage.fieldValidationsComponent().validatePasswordField(password[0], password[1], password[2]);
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

	@Test
	@Parameters({ "strParams" })
	public void testResendPhoneAndEmailOTP(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickGetStarted();
			signUpPage.clickPersonalAccount();
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			signUpPage.fillPassword(data.get("password"));
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickNext();
			signUpPage.phoneAndEmailVerificationComponent().clickResend();
			signUpPage.phoneAndEmailVerificationComponent().verifyNewCodeMsg(data.get("expMessage"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.phoneAndEmailVerificationComponent().clickResend();
			signUpPage.phoneAndEmailVerificationComponent().verifyNewCodeMsg(data.get("expMessage"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

}
