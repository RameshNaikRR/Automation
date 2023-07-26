package coyni.admin.commontest;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.admin.components.SideBarComponent;
import coyni.admin.pages.LoginPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class LoginTest {

	
	LoginPage loginPage;
	SideBarComponent sidebarcomponent;

	@BeforeMethod
	public void init() {

		loginPage = new LoginPage();
		sidebarcomponent = new SideBarComponent();
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
//			loginPage.authyComponent().verifyPageDescription(data.get("authyDescription"));
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
	
}
