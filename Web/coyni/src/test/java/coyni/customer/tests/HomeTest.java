package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

			homePage.verifyHomePageOptions(data.get("createAccount"), data.get("personalAccount"), data.get("logIn"),
					data.get("businessAccount"));
			homePage.verifyBusinessAccountText(data.get("businessAccountText"));
			homePage.verifyPersonalAccountText(data.get("personalAccountText"));
			homePage.verifyCreateAccountText(data.get("createAccountText"));
			homePage.verifyHomePageTabNavigation();
			homePage.verifyCreateAPersonalAccountText(data.get("createAPersonAccountText"));
			homePage.verifyBusinessAccountDisabled();
			homePage.verifyBusinessAccountToolTip(data.get("BusinessAccountToolTip"));
			homePage.verifyClickOnLogIn(data.get("LoginText"));
			if (!data.get("invalidAttempts").isEmpty()) {
				homePage.validateRemainingAttempts(data.get("invalidAttempts"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}
	
	@Test
	@Parameters({ "strParams" })

	public void testCreatePersonalAccountFirstNameFields(String strParams) {

		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyCreatePersonalAccountDescriptionText(data.get("CreatePersonalAccountDescriptionText"));
			homePage.verifyFirstNameautoFoucsed();
			homePage.verifySignUpFieldsTabNavigation();
			homePage.verifyFirstNameFieldOpacity();
			homePage.verifyFirstNameValidations(data.get("FirstNameText"), data.get("input"));
			homePage.verifyFirstNameValidations(data.get("FirstNameText"), data.get("input"));
			homePage.verifyFirstNameValidations(data.get("FirstNameText"), data.get("input"));
			homePage.verifyFirstNameValidations(data.get("FirstNameText"), data.get("input"));

			if (!data.get("invalidAttempts").isEmpty()) {
				homePage.validateRemainingAttempts(data.get("invalidAttempts"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}
	
	@Test
	@Parameters({ "strParams" })

	public void testCreatePersonalAccountLastNameFields(String strParams) {

		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyLastNameOpacity();
			homePage.verifyLastNameValidations(data.get("LastNameText"), data.get("input"));
			homePage.verifyLastNameValidations(data.get("LastNameText"), data.get("input"));
			homePage.verifyLastNameValidations(data.get("LastNameText"), data.get("input"));
			homePage.verifyLastNameValidations(data.get("LastNameText"), data.get("input"));

			if (!data.get("invalidAttempts").isEmpty()) {
				homePage.validateRemainingAttempts(data.get("invalidAttempts"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}
      
	@Test
	@Parameters({ "strParams" })
	
	public void testCreatePersonalAccountPhoneNumberField(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyPhonenUmberOpacity();
			homePage.verifyPhoneNumberTenDigitValidations(data.get("Number"));
			homePage.verifyUSLogoDefault();
			homePage.verifyUSnumberForformat(data.get("Number"));
			homePage.verifyPhoneNumberValidations(data.get("PhoneNumber"), data.get("input"));
			homePage.verifyPhoneNumberValidations(data.get("PhoneNumber"), data.get("input"));
			homePage.verifyPhoneNumberValidations(data.get("PhoneNumber"), data.get("input"));

			if (!data.get("invalidAttempts").isEmpty()) {
				homePage.validateRemainingAttempts(data.get("invalidAttempts"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}
	
	@Test
	@Parameters({ "strParams" })
	
	public void testCreatePersonalAccountEmailTextFiled(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyEmailOpacity();
			homePage.verifyEmailAdressFiledwithReqcharc(data.get("Email"));
			homePage.verifyEmailAdressFiledwithReqcharc(data.get("Email"));
			homePage.verifyEmailAdressFiledwithReqcharc(data.get("Email"));
			homePage.verifyEmailAdressFiledWithSpecialCharacters(data.get("Email"));
			homePage.verifyEmailAdressFiledWithSpecialCharacters(data.get("Email"));
			homePage.verifyEmailAdressFiledWithSpecialCharacters(data.get("Email"));

			if (!data.get("invalidAttempts").isEmpty()) {
				homePage.validateRemainingAttempts(data.get("invalidAttempts"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}
	}
	
	@Test
	@Parameters({ "strParams" })
	
	public void testCreatePersonalAccountCreatePasswordFieldText(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyCreatePasswordOpacity();
			homePage.verifyCreatePasswordTextFiled(data.get("createPassword"));
			homePage.verifyCreatePasswordTextFiled(data.get("createPassword"));
			homePage.verifyCreatePasswordTextFiled(data.get("createPassword"));
			homePage.verifyCreatePasswordTextFiled(data.get("createPassword"));
			homePage.verifyCreatePasswordTextFiled(data.get("createPassword"));
			homePage.verifyCreatePasswordRequirementsToolTip(data.get("Createpassword"), data.get("upperCase"), data.get("ToolTipText"));
			homePage.verifyCreatePasswordRequirementsToolTip(data.get("Createpassword"), data.get("lowerCase"), data.get("ToolTipText"));
			homePage.verifyCreatePasswordRequirementsToolTip(data.get("Createpassword"), data.get(""), data.get("ToolTipText"));
			homePage.verifyCreatePasswordRequirementsToolTip(data.get("Createpassword"), data.get("SpecialCharcters"), data.get("ToolTipText"));
			homePage.verifyCreatePasswordRequirementsToolTip(data.get("Createpassword"), data.get("Numbers"), data.get("ToolTipText"));
			homePage.verifyCreatePasswordMaskedWithBlackCircles(data.get("CreatePassword"));
            homePage.verifyCreatePasswordShowIcons();
            homePage.verifyClickOnCreatePasswordShowIcon(data.get("createPassword"));
			if (!data.get("invalidAttempts").isEmpty()) {
				homePage.validateRemainingAttempts(data.get("invalidAttempts"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}
	}
	
	@Test
	@Parameters({ "strParams" })

	public void testCreatePersonalAccountConfirmPasswordFieldText(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyConfirmPaaswordFieldDescription(data.get("confirmPassword"));
			homePage.verifyConfirmPasswordOpacity();
			homePage.verifyConfirmPasswordMaskedWithBlackCircles(data.get("confirmPassword"));
			homePage.verifyConfirmPasswordShowIcon();
			homePage.verifyClickOnConfirmPasswordShowIcon(data.get("confirmPassword"));
			
			if (!data.get("invalidAttempts").isEmpty()) {
				homePage.validateRemainingAttempts(data.get("invalidAttempts"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "");
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
			homePage.verifyClickOnNext(data.get("phoneVerifictionText"));
			homePage.verifyPhoneVerificationPage(data.get("PhoneVerificationDescription"),data.get("ResendText"),data.get("GoBackText"));
			homePage.verifyPhoneNumberTextInPhoneNumberDescription(data.get("phoneNumber"));
			
			
			if (!data.get("invalidAttempts").isEmpty()) {
				homePage.validateRemainingAttempts(data.get("invalidAttempts"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "");
			}

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

		
	}
	
}
