package coyni.merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.components.PhoneVerificationComponent;
import coyni.merchant.pages.HomePage;
import coyni.merchant.pages.LoginPage;
import ilabs.WebFramework.Runner;

public class HomeTest {

	HomePage homePage;
	LoginPage loginPage;
	PhoneVerificationComponent phoneVerificationComponent;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		loginPage = new LoginPage();
		phoneVerificationComponent = new PhoneVerificationComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testHomePage(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.clickCoyniLogo();
//		homePage.clickCoyniLogin();
		loginPage.clickSignUp();
		homePage.clickPersonalAccount();
		homePage.clickMerchantAccount();
		homePage.clickLogin();
		loginPage.clickSignUp();
		homePage.verifyHeading(data.get("homePageHeading"));
		homePage.verifyPersonalAccount();
		homePage.verifyPersonalAccountDesription();
		homePage.verifyMerchantAccount();
		homePage.verifyMerchantAccountDesription();
		homePage.verifyAlreadyRegistered();
		homePage.verifyLoginLnk();

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