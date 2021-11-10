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

}
