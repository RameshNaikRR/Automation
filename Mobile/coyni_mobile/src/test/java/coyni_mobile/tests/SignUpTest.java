package coyni_mobile.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class SignUpTest {

	SignUpPage signUpPage;

	@BeforeMethod
	public void init() {
		signUpPage = new SignUpPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUp(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			signUpPage.clickGetStarted();
			signUpPage.clickCrossMark();
			signUpPage.clickGetStarted();
			signUpPage.clickPersonalAccount();
//			signUpPage.clickCrossMark();
//			signUpPage.clickGetStarted();
//			signUpPage.clickPersonalAccount();
			signUpPage.verifyCreateAccount(data.get("createAccount"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
			signUpPage.fillPassword(data.get("password"));
			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
			signUpPage.clickNext();
			//signUpPage.verifyPhoneHeading(data.get("phoneHeading"));
			signUpPage.clickBackArrow();
			signUpPage.clickNext();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}
	@Test
	@Parameters({"strParams"})
	public void testSignUpWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			signUpPage.clickGetStarted();
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
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception"  + e);
		}
	}


	@Test
	@Parameters({ "strParams" })
	public void testCreateAccountInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			signUpPage.clickGetStarted();
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
			signUpPage.clickGetStarted();
			signUpPage.clickPersonalAccount();
			String[] firstname = data.get("firstName").split(",");
			String[] lastname = data.get("lastName").split(",");
			String[] email = data.get("email").split(",");
			String[] phonenumber = data.get("phoneNumber").split(",");
			signUpPage.validateFirstName(firstname[0], firstname[1], firstname[2]);
			signUpPage.validateLastName(lastname[0], lastname[1], lastname[2]);
			signUpPage.validateEmailField(email[0], email[1],email[2]);
			signUpPage.validatePhoneNumber(phonenumber[0], phonenumber[1]);
			

		} catch (Exception e) {
            ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

}
