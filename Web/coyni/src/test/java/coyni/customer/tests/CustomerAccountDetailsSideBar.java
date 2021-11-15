package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.CustomerProfilePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CustomerAccountDetailsSideBar  {
	CustomerProfilePage customerProfilePage;
	@BeforeTest
	public void init() {
		customerProfilePage   =  new CustomerProfilePage();

	}
	@Test
	@Parameters({"strParams"})

	public void testViewAccountDetailsSideBar(String strParams) {
		try {
			Map<String, String>  data = Runner.getKeywordParameters(strParams);
			customerProfilePage.verifyViewImage();
			customerProfilePage.verifyViewAccountId();
			customerProfilePage.verifyViewAccountUser();
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Account Details Side Bar is failed due to Exception " +e);
		}

	}
	@Test
	@Parameters({"strParams"})

	public void testUserDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.customerMenuComponent().clickUserDetails();
			customerProfilePage.customerMenuComponent().verifyUserDetails(data.get("UserDetails"));
			customerProfilePage.userDetailsComponent().verifyViewuserImg();
			customerProfilePage.userDetailsComponent().verifyViewUserName();
			customerProfilePage.userDetailsComponent().verifyViewAccountAddress();
			customerProfilePage.userDetailsComponent().verifyviewAccountId();
			customerProfilePage.userDetailsComponent().verifyViewAccountStatus();
			customerProfilePage.userDetailsComponent().verifyViewEmailAddress();
			customerProfilePage.userDetailsComponent().verifyViewPhoneNum();
			
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test User Details is failed due to Exception" +e);
		}
	}
	
	
	@Test
	@Parameters({"strParams"})
	public void testPaymentMethods(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.customerMenuComponent().clickPaymentMethods();
			customerProfilePage.customerMenuComponent().verifyPaymentMtehods(data.get("PaymentMethods"));
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Payment Methods is failed ue to Exception");
		}
	}

	public void testPreferences(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.customerMenuComponent().clickPreferences();
			customerProfilePage.customerMenuComponent().verifyPaymentMtehods(data.get("Preferences"));

		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Prefernces is failed due to Exception" + e);
		}
	}
	public void testAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.customerMenuComponent().clickAccountLimits();
			customerProfilePage.customerMenuComponent().verifyAccountLimits(data.get("AccountLimits"));
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Account Limits is failed due to Exception" + e);
		}
	}
	public  void testAgreements(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.customerMenuComponent().clickAgreements();
			customerProfilePage.customerMenuComponent().verifyAgreements(data.get("Agreements"));

		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Agreements is failed due to Exception" + e);
		}
	}
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.customerMenuComponent().clickChangePassword();
			customerProfilePage.customerMenuComponent().verifyChangePassword(data.get("ChangePassword"));
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Change Password is failed due to Exception"+e);
		}
	}
	}


