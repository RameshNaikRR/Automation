package coyni.customer.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.customer.components.AuthyComponent;
import coyni.customer.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class LoginTest {
	LoginPage loginPage;
	
	
	 @BeforeMethod
	    public void init() {
	        loginPage = new LoginPage();
	     
	 }
	 
	 @Test
	 @Parameters({"strParams"})
	 public void testLogin(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.fillEmail(data.get("email"));
			 loginPage.fillPassword(data.get("password"));
			 loginPage.clickNext();
			 Thread.sleep(2000);
			 loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
			 loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
			 Thread.sleep(500);
			 loginPage.authyComponent().verifyMessage(data.get("message"));
			 loginPage.authyComponent().verifyLogin();
		 }
		 catch (Exception e) {
	            ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
	        }
	 }
	 
	 @Test
	 @Parameters({"strParams"})
	 public void testLoginInvalidCredentials(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.fillEmail(data.get("email"));
			 loginPage.fillPassword(data.get("password"));
			 loginPage.clickNext();
			 if (!data.get("invalidAttempts").isEmpty()) {
	                loginPage.validateRemainingAttempts(data.get("invalidAttempts"));
	            }
	            if (!data.get("errMessage").isEmpty()) {
	                new CommonFunctions().validateFormErrorMessage(data.get("errMessage"),data.get("colour"));
	            }
	            Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
		 }
		 catch (Exception e) {
	            ExtentTestManager.setFailMessageInReport("Login test with Invalid credentials failed due to exception " + e);
	        }
	 }

	 @Test
		@Parameters({ "strParams" })
		public void testForgotEmail(String strParams) {
			try {
				Map<String, String> data = Runner.getKeywordParameters(strParams);
				loginPage.verifyHeading(data.get("loginHeading"));
				loginPage.clickForgotEmail();
				loginPage.verifyHeading(data.get("ForgotHeading"));
				loginPage.fillPhoneNumber(data.get("phoneNumber"));
				loginPage.clickNext();
				loginPage.fillFirstName(data.get("firstName"));
				loginPage.fillLastName(data.get("lastName"));
				loginPage.clickNext();
				loginPage.verifyHeading(data.get("verificationHeading"));//
				loginPage.fillVerificationInput(data.get("code"));
				if (!data.get("errMessage").isEmpty()) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"));
				}
//				loginPage.clickResend();
//				loginPage.verifyResendMessage(data.get("resendMessage"));
				loginPage.clickGoBack();
				loginPage.verifyHeading(data.get("forgotHeading"));
				loginPage.clickBackToLogin();
				loginPage.verifyHeading(data.get("loginHeading"));
			} catch (Exception e) {
				ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
			}
		}

		@Test
		@Parameters({ "strParams" })
		public void testForgotEmailWithInvalidPhonenumber(String strParams) {
			try {
				Map<String, String> data = Runner.getKeywordParameters(strParams);
				loginPage.verifyHeading(data.get("loginHeading"));
				loginPage.clickForgotEmail();
				loginPage.verifyHeading(data.get("ForgotHeading"));
				loginPage.fillPhoneNumber(data.get("phoneNumber"));
				loginPage.clickNext();
				if (!data.get("errMessage").isEmpty()) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"));
				}
			} catch (Exception e) {
				ExtentTestManager
						.setFailMessageInReport("Forgot email with invalid phone number test failed due to exception " + e);
			}
		}

		@Test
		@Parameters({ "strParams" })
		public void testForgotEmailWithInvalidFirstAndLastName(String strParams) {
			try {
				Map<String, String> data = Runner.getKeywordParameters(strParams);
				loginPage.verifyHeading(data.get("loginHeading"));
				loginPage.clickForgotEmail();
				loginPage.verifyHeading(data.get("ForgotHeading"));
				loginPage.fillPhoneNumber(data.get("phoneNumber"));
				loginPage.clickNext();
				loginPage.fillFirstName(data.get("firstName"));
				loginPage.fillLastName(data.get("lastName"));
				loginPage.clickNext();
				if (!data.get("errMessage").isEmpty()) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"));
				}

			} catch (Exception e) {
				ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
			}
		}

		@Test
		@Parameters({ "strParams" })
		public void testForgotEmailwithBackActions(String strParams) {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.clickForgotEmail();
			loginPage.verifyHeading(data.get("ForgotHeading"));
			loginPage.clickNext();
			loginPage.fillPhoneNumber(data.get("phoneNumber"));
			loginPage.clickBackToLogin();
			loginPage.clickForgotEmail();
			loginPage.fillPhoneNumber(data.get("phoneNumber"));
			loginPage.clickNext();
			loginPage.fillFirstName(data.get("firstName"));
			loginPage.fillLastName(data.get("lastName"));
			loginPage.clickBackToLogin();
			loginPage.verifyHeading(data.get("loginHeading"));
			loginPage.verifyHeading(data.get("ForgotHeading"));
			loginPage.fillPhoneNumber(data.get("phoneNumber"));
			loginPage.clickNext();
			loginPage.fillFirstName(data.get("firstName"));
			loginPage.fillLastName(data.get("lastName"));
			loginPage.clickNext();
			loginPage.clickGoBack();
			loginPage.getTextBoxValue(null, strParams);
			
			try {
			} catch (Exception e) {
				ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
			}
		}

	 
	 @Test
	 @Parameters({"strParams"})
	 public void testForgotPassword(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.clickForgotPassword();
			 loginPage.verifyHeading(data.get("forgotHeading"));
			 loginPage.fillEmail(data.get("email"));
			 loginPage.clickNext();
			 loginPage.verifyHeading(data.get("verificationHeading"));
			 loginPage.verifyEmail(data.get("email")+".");
			 loginPage.fillVerificationInput(data.get("code"));
			 if (!data.get("errMessage").isEmpty()) {
	                new CommonFunctions().validateFormErrorMessage(data.get("errMessage"),data.get("colour"));
	            }
			 loginPage.clickResend();
			 loginPage.verifyResendMessage(data.get("resendMessage"));
			 loginPage.clickGoBack();
			 loginPage.verifyHeading(data.get("forgotHeading"));
			 loginPage.clickBackToLogin();
			 loginPage.verifyHeading(data.get("loginHeading"));
	         
		 }
		 catch (Exception e) {
			 ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		 }
	 }
	 
	 @Test
	 @Parameters({"strParams"})
	 public void testForgotPasswordWithInvalidEmail(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.clickForgotPassword();
			 loginPage.verifyHeading(data.get("forgotHeading"));
			 loginPage.fillEmail(data.get("email"));
			 loginPage.clickNext();
			 if (!data.get("errMessage").isEmpty()) {
	                new CommonFunctions().validateFormErrorMessage(data.get("errMessage"),data.get("colour"));
	            }
		 }
		 catch (Exception e) {
			 ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		 }
	 }
	 
	 
	 
	 @Test
	 @Parameters({"strParams"})
	 public void testSignUp(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.clickSignUp();
			 loginPage.verifyHeading(data.get("createAccountHeading"));
	
		 }
		 catch(Exception e) {
			 ExtentTestManager.setFailMessageInReport("SignIn test failed due to exception" + e);
			 
		 }
	 }
	 
	 @Test
	 @Parameters({"strParams"})
	 public void testLoginWithInvalidAuthy(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.fillEmail(data.get("email"));
			 loginPage.fillPassword(data.get("password"));
			 loginPage.clickNext();
			 loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
			 loginPage.authyComponent().fillAuthyInputInvalid(data.get("code"));
			 if (!data.get("errMessage").isEmpty()) {
				    Thread.sleep(2000);
	                loginPage.authyComponent().verifyMessage(data.get("errMessage"));
	            }
			 Thread.sleep(2000);
			 loginPage.authyComponent().verifyLoginWithInvalidPin();
		 }
		 catch (Exception e) {
	            ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
	        }
	 }
	 
	 @Test
	 @Parameters({"strParams"})
	 public void testLoginWithPhoneNumber(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.fillEmail(data.get("email"));
			 loginPage.fillPassword(data.get("password"));
			 loginPage.clickNext();
			 loginPage.phoneVerificationComponent().verifyHeading(data.get("phoneHeading"));
			 loginPage.phoneVerificationComponent().fillpin(data.get("code"));
			 loginPage.phoneVerificationComponent().verifyMessage(data.get("errMessage"));
			 loginPage.phoneVerificationComponent().clickResend();
			 loginPage.phoneVerificationComponent().verifyResend(data.get("resendMsg"));
			 for(int i=0;i<=3;i++) {
				 Thread.sleep(5000);
				 loginPage.phoneVerificationComponent().clickResend();
				 loginPage.phoneVerificationComponent().verifyResend(data.get("resendMsg"));
			 }
		 }
		 catch (Exception e) {
	            ExtentTestManager.setFailMessageInReport("test login with phone number failed due to exception " + e);
	        }
	 }
	 @Test
	 @Parameters({"strParams"})
	 public void testLoginWithPhoneNumberPin(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.fillEmail(data.get("email"));
			 loginPage.fillPassword(data.get("password"));
			 loginPage.clickNext();
			 loginPage.phoneVerificationComponent().verifyHeading(data.get("phoneHeading"));
			 loginPage.phoneVerificationComponent().fillpin(data.get("code")); 
			 if (!data.get("errMessage").isEmpty()) {
	                loginPage.phoneVerificationComponent().verifyMessage(data.get("errMessage"));
	            }
			 Thread.sleep(2000);
			 loginPage.phoneVerificationComponent().verifyLoginWithInvalidPin();
		 }
		 catch (Exception e) {
	            ExtentTestManager.setFailMessageInReport("test login with phone number pin failed due to exception " + e);
	        }
	 }
}
