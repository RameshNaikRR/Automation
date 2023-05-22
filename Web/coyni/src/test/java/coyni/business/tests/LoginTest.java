package coyni.business.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.util.concurrent.Uninterruptibles;


import coyni.business.pages.LoginPage;
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
	@Parameters({ "strParams" })
	public void testAdminLogin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			// loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyPageHeading(data.get("authyHeading"));
			loginPage.authyComponent().verifyPageDescription(data.get("authyDescription"));
			if (data.get("securityKey").equalsIgnoreCase("123456")) {
				loginPage.authyComponent().fillInput(data.get("securityKey"));
			} else {
				loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
			}
			Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testAdminLoginWithInvalidEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			// loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickNext();
			loginPage.toastComponent().verifyToast(data.get("title"), data.get("toastMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}
	
	@Parameters({ "strParams" })
	public void testLoginInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.verifyPageHeading(data.get("loginHeading"));
			loginPage.fillEmail(data.get("email"));
			loginPage.fillPassword(data.get("password"));
			loginPage.clickOutSide();
			loginPage.clickNext();
			Thread.sleep(4000);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			ExtentTestManager
					.setFailMessageInReport("Login test with invalid credentials failed due to exception " + e);
		}
	}


}
