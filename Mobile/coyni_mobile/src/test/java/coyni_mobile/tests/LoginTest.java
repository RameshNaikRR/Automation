package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.HomePage;
import coyni_mobile.pages.LoginPage;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class LoginTest {
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test
	@Parameters({"strParams"})
	public void testLogin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickSignIn();
			loginPage.fillUserName(data.get("username"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickLogin();
			
		} catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("Login test failed due to some exception "+e);
		}
	}

}
