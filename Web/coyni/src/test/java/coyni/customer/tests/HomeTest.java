package coyni.customer.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.components.PhoneVerificationComponent;
import coyni.customer.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class HomeTest {

	HomePage homePage;
	PhoneVerificationComponent phoneVerificationComponent;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		phoneVerificationComponent = new PhoneVerificationComponent();
	}

	@Test
	@Parameters({ "strParams" })

	public void testcreateAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyLandingPageHeading(data.get("landingHeading"));
			homePage.clickPersonalAccount();
			homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			homePage.fillFirstName(data.get("firstName"));
			homePage.fillLastName(data.get("lastName"));
			homePage.fillPhoneNumber(data.get("phoneNumber"));
			homePage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			homePage.fillCreatePassword(data.get("createPassword"));
			homePage.fillConfirmPassword(data.get("confirmPassword"));
			homePage.clickCheckBox();
			homePage.clickNext();
			homePage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));
			homePage.phoneVerificationComponent().verifyPhoneNumber(data.get("verifyPhoneNumber"));
			homePage.phoneVerificationComponent().fillpin(data.get("code"));
			homePage.phoneVerificationComponent().emailVerificationComponent().verifyEmailHeading(data.get("emailHeading"));
			homePage.phoneVerificationComponent().emailVerificationComponent().verifyEmail(data.get("newEmail"));
			homePage.phoneVerificationComponent().emailVerificationComponent().fillpin(data.get("code"));
			homePage.phoneVerificationComponent().emailVerificationComponent().verifyAccountCreated(data.get("createdAccountHeading"));
			
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
			homePage.verifyLandingPageHeading(data.get("landingHeading"));
			homePage.clickPersonalAccount();
			homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			homePage.fillFirstName(data.get("firstName"));
			homePage.fillLastName(data.get("lastName"));
			homePage.fillPhoneNumber(data.get("phoneNumber"));
			homePage.fillEmail(data.get("email"));
			homePage.fillCreatePassword1(data.get("createPassword"));
			homePage.fillConfirmPassword(data.get("confirmPassword"));
			// new CommonFunctions().clickOutSideElement();
			homePage.clickNext();
			homePage.clickCheckBox();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),data.get("elementName"));
			} else if (!data.get("toastMessage").isEmpty()) {
				//homePage.toastComponent().verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}

		}

		catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("testcreateAccountWithInvalidData Failed due to Exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
    public void testcreateAccountPhoneVerification(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyLandingPageHeading(data.get("landingHeading"));
			homePage.clickPersonalAccount();
			homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			homePage.fillFirstName(data.get("firstName"));
			homePage.fillLastName(data.get("lastName"));
			homePage.fillPhoneNumber(data.get("phoneNumber"));
			homePage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			homePage.fillCreatePassword(data.get("createPassword"));
			homePage.fillConfirmPassword(data.get("confirmPassword"));
			homePage.clickCheckBox();
			homePage.clickNext();
			Thread.sleep(3000);
			homePage.phoneVerificationComponent().verifyPhoneVerificationHeading();
			homePage.phoneVerificationComponent().verifPhoneVericationDescription();
			homePage.phoneVerificationComponent().verifyPhoneVerificationNumber(data.get("PhoneVerificationNumber"));
			homePage.phoneVerificationComponent().verifyVerificationCodeBoxAutoFocused();
			homePage.phoneVerificationComponent().authyComponent().validateAuthyField(data.get("code"));
			homePage.phoneVerificationComponent().authyComponent().fillAuthyInputInvalid(data.get("expCode"), data.get("Character"));
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
		}
			homePage.phoneVerificationComponent().clickResend();
			Thread.sleep(3000);
			homePage.phoneVerificationComponent().verifyResendDescrp();
			for(int i =0; i <=5;i++) {
				homePage.phoneVerificationComponent().clickResend();
			}
			
			homePage.phoneVerificationComponent().verifyResendError();
			homePage.phoneVerificationComponent().clickButtonGoBack();
			homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			homePage.getPreviousData();
			homePage.verifyClearAndUpdateAllFileds(data.get("firstName"),data.get("lastName"),data.get("newPhoneNumber"), data.get("newEmail"),data.get("createPassword"),data.get("confirmPassword"));
			
		}
		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testcreateAccountPhoneVerification Failed due to Exception " + e);
		}
	}	
	
	@Test
	@Parameters({ "strParams" })
    public void testcreateAccountEmailVerification(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyLandingPageHeading(data.get("landingHeading"));
			homePage.clickPersonalAccount();
			homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			homePage.fillFirstName(data.get("firstName"));
			homePage.fillLastName(data.get("lastName"));
			homePage.fillPhoneNumber(data.get("phoneNumber"));
			homePage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			homePage.fillCreatePassword(data.get("createPassword"));
			homePage.fillConfirmPassword(data.get("confirmPassword"));
			homePage.clickCheckBox();
			homePage.clickNext();
			Thread.sleep(3000);
			homePage.phoneVerificationComponent().verifyPhoneVerificationHeading();
			homePage.phoneVerificationComponent().verifPhoneVericationDescription();
			homePage.phoneVerificationComponent().verifyVerificationCodeBoxAutoFocused();
			homePage.phoneVerificationComponent().authyComponent().fillInput(data.get("pin"));
			homePage.phoneVerificationComponent().emailVerificationComponent().verifyEmailHeading(data.get("emailHeading"));
			homePage.phoneVerificationComponent().emailVerificationComponent().verifyEmailDescription();
			homePage.phoneVerificationComponent().emailVerificationComponent().verifyEmail(data.get("emailDescrp"));
			homePage.phoneVerificationComponent().emailVerificationComponent().verifyfirstCodeBoxAutoFocused();
			homePage.phoneVerificationComponent().emailVerificationComponent().authyComponent().validateAuthyField(data.get("code"));
			homePage.phoneVerificationComponent().emailVerificationComponent().authyComponent().fillAuthyInputInvalid(data.get("expCode"), data.get("Character"));
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
		}
			homePage.phoneVerificationComponent().emailVerificationComponent().clickResendVerificationCode();
			Thread.sleep(3000);
			homePage.phoneVerificationComponent().emailVerificationComponent().verifyResendDescription();
			for(int i =0; i <=5;i++) {
				homePage.phoneVerificationComponent().emailVerificationComponent().clickResendVerificationCode();
			}
			
			homePage.phoneVerificationComponent().emailVerificationComponent().verifyResendError();			
			homePage.phoneVerificationComponent().emailVerificationComponent().clickGoBack();
			homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			homePage.getPreviousData();
			homePage.verifyClearAndUpdateAllFileds(data.get("firstName"),data.get("lastName"),data.get("newPhoneNumber"), data.get("newEmail"),data.get("createPassword"),data.get("confirmPassword"));
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
			homePage.verifyLandingPageHeading(data.get("landingHeading"));
			homePage.clickPersonalAccount();
			homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			homePage.fillFirstName(data.get("firstName"));
			homePage.fillLastName(data.get("lastName"));
			homePage.fillPhoneNumber(data.get("phoneNumber"));
			homePage.fillEmail(data.get("email"));
			Thread.sleep(1000);
			homePage.fillCreatePassword(data.get("createPassword"));
			homePage.fillConfirmPassword(data.get("confirmPassword"));
			homePage.clickNext();
			homePage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading"));
			homePage.phoneVerificationComponent().verifyPhoneNumber(data.get("verifyPhoneNumber"));
			String[] msg = data.get("errMessage").split(",");
			for(int i=0;i<msg.length;i++) {
				homePage.phoneVerificationComponent().fillpin(data.get("code"));
				homePage.phoneVerificationComponent().verifyMessage(msg[i]);
				//verify screen presence
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
			homePage.verifyLandingPageHeading(data.get("landingHeading"));
			homePage.verifyBusinessAccountView();
			homePage.verifyPersonalAccountView();
			homePage.verifyLoginView();
			homePage.verifyCreateAccountSubTitleView();
			homePage.verifyPersonalAccountSubTitleView();
			homePage.verifyBusinessAccountSubTitleView();
			homePage.clickPersonalAccount();
			homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
			homePage.verifyFirstNameAutoFocus();
		//	homePage.verifyElementOpacity();
			
			
			
			
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
//		
	}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCreateAccountView Failed due to Exception " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })

	public void validateCreateAccountFields(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyLandingPageHeading(data.get("landingHeading"));
			homePage.clickPersonalAccount();
		    homePage.verifyCreateAccountPageHeading(data.get("createAccountHeading"));
            homePage.validateFirstNameField(data.get("firstName"));
            homePage.validateLastNameField(data.get("lastName"));
            homePage.validatePhoneNumber(data.get("phoneNumber"));
            homePage.validatePassword(data.get("createPassword"));
            homePage.validateEmailField(data.get("email"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validateCreateAccountFields Failed due to Exception " + e);
		}
	}
}