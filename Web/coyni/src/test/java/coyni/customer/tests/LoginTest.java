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
			 loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
			 loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
			 loginPage.authyComponent().verifyMessage(data.get("message"));
			 //verify login ?
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
	                new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
	            }
	            Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
		 }
		 catch (Exception e) {
	            ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
	        }
	 }

	 @Test
	 @Parameters({"strParams"})
	 public void testForgotEmail(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.clickForgotEmail();
			 loginPage.verifyHeading(data.get("ForgotEmailHeading"));
			 loginPage.fillPhoneNumber(data.get("phoneNumber"));
			 loginPage.clickBackToLogin();
	         //we can automate up to phone number verification
		 }
		 catch (Exception e) {
			 ExtentTestManager.setFailMessageInReport("Forgot email test failed due to exception " + e);
		 }
	 }

	 @Test
	 @Parameters({"strParams"})
	 public void testForgotPassword(String strParams) {
		 try {
			 Map<String, String> data = Runner.getKeywordParameters(strParams);
			 loginPage.verifyHeading(data.get("loginHeading"));
			 loginPage.clickForgotPassword();
			 loginPage.verifyHeading(data.get("ForgotPasswordHeading"));
			 loginPage.fillEmail(data.get("email"));
			 loginPage.clickNext();
	         //	we can automate up to email verification
		 }
		 catch (Exception e) {
			 ExtentTestManager.setFailMessageInReport("Forgot password test failed due to exception " + e);
		 }
	 }
	 
	 @Test
	 @Parameters({"strParams"})
	 public void testSignIn(String strParams) {
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
	 
}
