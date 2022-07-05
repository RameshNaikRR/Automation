package coyni.merchant.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.components.PhoneVerificationComponent;
import coyni.merchant.pages.HomePage;
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
	public void testHomePage(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.verifyHeading(data.get("homePageHeading"));
		homePage.verifyDescription(data.get("description"));
		homePage.verifyPersonalAccount();
		homePage.verifyPersonalAccountDesription();
		homePage.verifyMerchantAccount();
		homePage.verifyMerchantAccountDesription();
		homePage.verifyAlreadyRegistered();
		homePage.verifyLoginLnk();
//		homePage.clickLogin();
	}

	@Test
	@Parameters({ "strParams" })
	public void testHomePageMerchantAccView(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.verifyHeading(data.get("homePageHeading"));
		homePage.verifyPersonalAccount();
		homePage.verifyMerchantAccount();
		homePage.verifyLoginLnk();
		homePage.clickMerchantAccount();
		homePage.verifyHeading(data.get("merchantPageHeading"));
	}

	@Test
	@Parameters({ "strParams" })
	public void testHomePagePersonalAccView(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.verifyHeading(data.get("homePageHeading"));
		homePage.verifyPersonalAccount();
		homePage.verifyMerchantAccount();
		homePage.verifyLoginLnk();
		homePage.clickPersonalAccount();
		homePage.verifyHeading(data.get("personalPageHeading"));
	}

	@Test
	@Parameters({ "strParams" })
	public void testHomePageLoginView(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.verifyHeading(data.get("homePageHeading"));
		homePage.verifyPersonalAccount();
		homePage.verifyMerchantAccount();
		homePage.verifyLoginLnk();
		homePage.clickLogin();
		homePage.verifyLoginHeading(data.get("loginPageHeading"));
	}
}