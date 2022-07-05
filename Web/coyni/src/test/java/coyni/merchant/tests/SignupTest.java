package coyni.merchant.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.components.PhoneVerificationComponent;
import coyni.merchant.pages.SignupPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class SignupTest {
	SignupPage signupPage;
	PhoneVerificationComponent phoneVerificationComponent;

	@BeforeMethod
	public void init() {
		signupPage = new SignupPage();
		phoneVerificationComponent = new PhoneVerificationComponent();
	}

	@Test
	@Parameters({ "strParams" })

	public void testcreateAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// homePage.verifyLandingPageHeading(data.get("landingHeading"));
			// homePage.clic();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.clickMerchantAccount();
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			signupPage.clickCheckBox();
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));
			signupPage.phoneVerificationComponent().verifyPhoneNumber();
			signupPage.phoneVerificationComponent().fillpin(data.get("code"));
			signupPage.phoneVerificationComponent().emailVerificationComponent()
					.verifyEmailHeading(data.get("emailHeading"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyEmail(data.get("newEmail"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().fillpin(data.get("code"));
			signupPage.phoneVerificationComponent().emailVerificationComponent()
					.verifyAccountCreated(data.get("createdAccountHeading"));

//			if (!data.get("errMessage").isEmpty()) {
//				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
//				homePage.phoneVerificationComponent().verifyMessage(data.get("errMessage"));
//			}
//			homePage.phoneVerificationComponent().clickResend();
//			homePage.phoneVerificationComponent().clickGoBack();
//			homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
//			 verify data presence
		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testcreateAccountWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// homePage.verifyLandingPageHeading(data.get("landingHeading"));
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			signupPage.fillCreatePassword1(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			// new CommonFunctions().clickOutSideElement();
			signupPage.clickNext();
			signupPage.clickCheckBox();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			} else if (!data.get("toastMessage").isEmpty()) {
				// homePage.toastComponent().verifyToast(data.get("toastTitle"),
				// data.get("toastMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccountWithInvalidData Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testcreateAccountPhoneVerification(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// homePage.verifyLandingPageHeading(data.get("landingHeading"));
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			signupPage.clickCheckBox();
			signupPage.clickNext();
			Thread.sleep(3000);
			signupPage.phoneVerificationComponent().verifyPhoneVerificationHeading();
			signupPage.phoneVerificationComponent().verifPhoneVericationDescription();
			signupPage.phoneVerificationComponent().verifyPhoneVerificationNumber(data.get("PhoneVerificationNumber"));
			signupPage.phoneVerificationComponent().verifyVerificationCodeBoxAutoFocused();
			signupPage.phoneVerificationComponent().authyComponent().validateAuthyField(data.get("code"));
			signupPage.phoneVerificationComponent().authyComponent().fillAuthyInputInvalid(data.get("expCode"),
					data.get("Character"));
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
			signupPage.phoneVerificationComponent().clickResend();
			Thread.sleep(3000);
			signupPage.phoneVerificationComponent().verifyResendDescrp();
			for (int i = 0; i <= 5; i++) {
				signupPage.phoneVerificationComponent().clickResend();
			}

			signupPage.phoneVerificationComponent().verifyResendError();
			signupPage.phoneVerificationComponent().clickButtonGoBack();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.getPreviousData(data.get("firstName"), data.get("lastName"), data.get("phoneNumber"),
					data.get("email"), data.get("createPassword"), data.get("confirmPassword"));
			signupPage.verifyClearAndUpdateAllFileds(data.get("firstName"), data.get("lastName"),
					data.get("newPhoneNumber"), data.get("newEmail"), data.get("createPassword"),
					data.get("confirmPassword"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccountPhoneVerification Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testcreateAccountEmailVerification(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// homePage.verifyLandingPageHeading(data.get("landingHeading"));
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			signupPage.clickCheckBox();
			signupPage.clickNext();
			Thread.sleep(3000);
			signupPage.phoneVerificationComponent().verifyPhoneVerificationHeading();
			signupPage.phoneVerificationComponent().verifPhoneVericationDescription();
			signupPage.phoneVerificationComponent().verifyVerificationCodeBoxAutoFocused();
			signupPage.phoneVerificationComponent().authyComponent().fillInput(data.get("pin"));
			signupPage.phoneVerificationComponent().emailVerificationComponent()
					.verifyEmailHeading(data.get("emailHeading"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyEmailDescription();
			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyEmail(data.get("emailDescrp"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyfirstCodeBoxAutoFocused();
			signupPage.phoneVerificationComponent().emailVerificationComponent().authyComponent()
					.validateAuthyField(data.get("code"));
			signupPage.phoneVerificationComponent().emailVerificationComponent().authyComponent()
					.fillAuthyInputInvalid(data.get("expCode"), data.get("Character"));
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
			signupPage.phoneVerificationComponent().emailVerificationComponent().clickResendVerificationCode();
			Thread.sleep(3000);
			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyResendDescription();
			for (int i = 0; i <= 5; i++) {
				signupPage.phoneVerificationComponent().emailVerificationComponent().clickResendVerificationCode();
			}

			signupPage.phoneVerificationComponent().emailVerificationComponent().verifyResendError();
			signupPage.phoneVerificationComponent().emailVerificationComponent().clickGoBack();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.getPreviousData(data.get("firstName"), data.get("lastName"), data.get("phoneNumber"),
					data.get("email"), data.get("createPassword"), data.get("confirmPassword"));
			signupPage.verifyClearAndUpdateAllFileds(data.get("firstName"), data.get("lastName"),
					data.get("newPhoneNumber"), data.get("newEmail"), data.get("createPassword"),
					data.get("confirmPassword"));
		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccountEmailVerification Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpWithInvalidPhoneOTP(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// homePage.verifyLandingPageHeading(data.get("landingHeading"));
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.fillFirstName(data.get("firstName"));
			signupPage.fillLastName(data.get("lastName"));
			signupPage.fillPhoneNumber(data.get("phoneNumber"));
			signupPage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			signupPage.fillCreatePassword(data.get("createPassword"));
			signupPage.fillConfirmPassword(data.get("confirmPassword"));
			signupPage.clickNext();
			signupPage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));
			signupPage.phoneVerificationComponent().verifyPhoneNumber();
			String[] msg = data.get("errMessage").split(",");
			for (int i = 0; i < msg.length; i++) {
				signupPage.phoneVerificationComponent().fillpin(data.get("code"));
				signupPage.phoneVerificationComponent().verifyMessage(msg[i]);
				// verify screen presence
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testCreateAccountView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// homePage.verifyLandingPageHeading(data.get("landingHeading"));
			signupPage.verifyBusinessAccountView();
			// homePage.verifyPersonalAccountView();
			signupPage.verifyLoginView();
			// homePage.verifyCreateAccountSubTitleView();
			// homePage.verifyPersonalAccountSubTitleView();
			// homePage.verifyBusinessAccountSubTitleView();
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.verifyFirstNameAutoFocus();
			// homePage.verifyElementOpacity();

//			
//			homePage.fillFirstName(data.get("firstName"));
//			homePage.fillLastName(data.get("lastName"));
//			homePage.fillPhoneNumber(data.get("phoneNumber"));
//			homePage.fillEmail(data.get("email"));
//			Thread.sleep(1000);
//			homePage.fillCreatePassword(data.get("createPassword"));
//			homePage.fillConfirmPassword(data.get("confirmPassword"));
//			homePage.clickNext();
//			homePage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));
//			homePage.phoneVerificationComponent().verifyPhoneNumber(data.get("verifyPhoneNumber"));
//			String[] msg = data.get("errMessage").split(",");
//			for(int i=0;i<msg.length;i++) {
//				homePage.phoneVerificationComponent().fillpin(data.get("code"));
//				homePage.phoneVerificationComponent().verifyMessage(msg[i]);
//				//verify screen presence
//			}
		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCreateAccountView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })

	public void testValidateCreateAccountFields(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// homePage.verifyLandingPageHeading(data.get("landingHeading"));
			signupPage.clickMerchantAccount();
			signupPage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			signupPage.validateFirstNameField(data.get("firstName"));
			signupPage.validateLastNameField(data.get("lastName"));
			signupPage.validatePhoneNumber(data.get("phoneNumber"));
			signupPage.validateEmailField(data.get("email"));
			signupPage.validatePassword(data.get("createPassword"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateCreateAccountFields Failed due to Exception " + e);
		}
	}

}
