package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class SystemSettingsTest {

	HomePage homePage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testSystemSettings(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
			homePage.sideBarComponent().clickSystemSettings();
			homePage.sideBarComponent().clickAgreements();
			homePage.sideBarComponent().clickFeeStructure();
			homePage.sideBarComponent().clickAccountLimits();
			homePage.sideBarComponent().clickPermissions();
			homePage.sideBarComponent().clickFeatureControls();
			homePage.sideBarComponent().clickCardBlackList();
			homePage.sideBarComponent().clickPushNotifications();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSystemSettings Failed due to Exception " + e);
		}
	}

}
