package coyni.customer.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class HomeTest {

	HomePage homePage;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
	}

	@Test
	@Parameters({ "strParams" })

	public void testVerifyHomePageOptions(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.verifyHomePageOptions(data.get("createAccount"), data.get("personalAccount"),
					data.get("businessAccount"), data.get("logIn"));

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}

	@Test

	@Parameters({ "strParams" })

	public void testVerifyHomePageOptionsText(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
				
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
			homePage.verifyCreateAccountText(data.get("createAccountText"));
			homePage.verifyPersonalAccountText(data.get("personalAccountText"));
			homePage.verifyBusinessAccountText(data.get("businessAccountText"));
             
			/*
			 * homePage.verifyHomePageTabNavigation();
			 * 
			 * homePage.verifyBusinessAccountDisabled();
			 * homePage.verifyBusinessAccountToolTip(data.get("BusinessAccountToolTip"));
			 */
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}
	}

	@Test

	@Parameters({ "strParams" })

	public void testVerifyLogInOptions(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyClickLogIn(data.get("loginText"));
			homePage.clickSignUp();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}
	}
	
	@Test
	@Parameters({ "strParams" })

	public void testCreatePersonalAccountText(String strParams) {

		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyCreateAPersonalAccountText(data.get("createAPersonAccountText"));
			homePage.verifyCreatePersonalAccountDescriptionText(data.get("createPersonalAccountDescText"));
            
			/*
			 * if (!data.get("invalidAttempts").isEmpty()) {
			 * homePage.validateRemainingAttempts(data.get("invalidAttempts")); }
			 */

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })

	public void testFirstNameField(String strParams) {

		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyFirstNameFieldOpacity();
            homePage.verifyFirstNameValidations(data.get("firstName"), data.get("input"));
			/*
			 * if (!data.get("invalidAttempts").isEmpty()) {
			 * homePage.validateRemainingAttempts(data.get("invalidAttempts")); }
			 */

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })

	public void testFirstNameFieldsWithInvalidData(String strParams) {

		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyFirstNameValidations(data.get("firstName"));

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })

	public void verifySignUpFieldsWithEmpty  (String strParams) {

		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
			homePage.verifySignUpFieldsWithEmpty(data.get("firstName"), data.get("lastNameText"),
					data.get("phoneNumber"), data.get("email"), data.get("createPassword"),
					data.get("confirmPassword"));

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })

	public void testLastNameField(String strParams) {

		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyLastNameOpacity();
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
			homePage.verifyLastNameValidations(data.get("lastNameText"), data.get("input"));

			/*
			 * if (!data.get("invalidAttempts").isEmpty()) {
			 * homePage.validateRemainingAttempts(data.get("invalidAttempts")); }
			 */
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })

	public void testLastNameFieldWithInvalidData(String strParams) {

		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyLastNameValidations(data.get("lastNameText"));

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })

	public void testPhoneNumberField(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyPhonenUmberOpacity();
			homePage.verifyPhoneNumberTenDigitValidations(data.get("phoneNumberdigits"));

			homePage.verifyUSnumberForformat(data.get("numberFormat"));

			homePage.verifyPhoneNumberValidations(data.get("phoneNumber"), data.get("input"));

			/*
			 * if (!data.get("invalidAttempts").isEmpty()) {
			 * homePage.validateRemainingAttempts(data.get("invalidAttempts")); }
			 */
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}
	
	@Test
	@Parameters({ "strParams" })

	public void testPhoneNumberFieldWithInvalidData(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyPhoneNumberValidations(data.get("phoneNumber"), data.get("input"));

			/*
			 * if (!data.get("invalidAttempts").isEmpty()) {
			 * homePage.validateRemainingAttempts(data.get("invalidAttempts")); }
			 */
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}

	@Test
	@Parameters({ "strParams" })

	public void testEmailTextFiled(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyEmailOpacity();
			homePage.verifyEmailAdressFiledWithSpecialCharacters(data.get("email"), data.get("inputTypes"));

			/*
			 * if (!data.get("invalidAttempts").isEmpty()) {
			 * homePage.validateRemainingAttempts(data.get("invalidAttempts")); }
			 */
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}
	}

	
	
	
	
	@Test
	@Parameters({ "strParams" })

	public void testverifyCreatePasswordTextFiled (String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyCreatePasswordOpacity();

			homePage.verifyCreatePasswordRequirementsToolTip(data.get("createPassword"),data.get("createPasswordToolTip"), data.get("inputTypes"));
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
			

			homePage.verifyCreatePasswordTextFiled(data.get("createPassword"));
			homePage.verifyCreatePasswordShowIcons(data.get("expCreateShowIconType"));
			homePage.verifyClickOnCreatePasswordShowIcon(data.get("createPassword"));
			/*
			 * if (!data.get("invalidAttempts").isEmpty()) {
			 * homePage.validateRemainingAttempts(data.get("invalidAttempts")); }
			 */
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}
	}

	
	
	
	@Test
	@Parameters({ "strParams" })

	public void testConfirmPasswordTextField(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyConfirmPasswordOpacity();
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
			homePage.verifyConfirmPaaswordFieldDescription(data.get("confirmPasswordText"));

			homePage.verifyConfirmPasswordMaskedWithBlackCircles(data.get("confirmPassword"), data.get("expType"));
			//homePage.verifyConfirmPasswordShowIcon();
			homePage.verifyClickOnConfirmPasswordShowIcon(data.get("confirmPassword"));

			/*
			 * if (!data.get("invalidAttempts").isEmpty()) {
			 * homePage.validateRemainingAttempts(data.get("invalidAttempts")); }
			 */
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}
    
	
	@Test
	@Parameters({ "strParams" })

	public void testPhoneVerificationPage(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifyNextButtonEnabled(data.get("firstName"), data.get("lastNameText"), data.get("email"),
					data.get("phoneNumber"), data.get("createPassword"), data.get("confirmPassword"));
			homePage.verifyClickNext(data.get("phoneVerifictionText"));
			homePage.verifyPhoneVerificationPage(data.get("PhoneVerificationDescription"), data.get("ResendText"),
					data.get("GoBackText"));
			homePage.verifyPhoneNumberTextInPhoneNumberDescription(data.get("phoneNumber"));

			/*
			 * if (!data.get("invalidAttempts").isEmpty()) {
			 * homePage.validateRemainingAttempts(data.get("invalidAttempts")); }
			 */
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "", "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);	

		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testVerifySignUpFieldsWithInvalidDetails(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickPersonalAccount();
			homePage.verifySignUpEmailFieldsWithInvalidData(data.get("email"),data.get("inputTypes"));
			homePage.clickTab();
			homePage.verifySignUpFieldCreatePasswordWithInvalidData(data.get("createPassword"));
			homePage.clickTab();
			homePage.verifySignUpFieldConfirmPasswordWithInvalidData(data.get("ConfirmPassword"));
			homePage.clickTab();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}
	}
}