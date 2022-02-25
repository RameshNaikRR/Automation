package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ProfilesTest {

	HomePage homePage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickIndividuals();
			homePage.sideBarComponent().clickBusinesses();
			homePage.sideBarComponent().clickCoyniEmployees();
			homePage.sideBarComponent().clickAPIBusinessess();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfileTest Failed due to Exception " + e);
		}
	}

}
