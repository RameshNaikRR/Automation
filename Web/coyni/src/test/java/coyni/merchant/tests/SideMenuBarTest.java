package coyni.merchant.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coyni.merchant.components.SideMenuBarComponent;
import ilabs.api.reporting.ExtentTestManager;

public class SideMenuBarTest {
	SideMenuBarComponent sideMenuBarComponent;

	@BeforeTest
	public void init() {
		sideMenuBarComponent = new SideMenuBarComponent();
	}

	@Test
//	@Parameters({"strParams"})
	public void testSideMenuBar() {
		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideMenuBarComponent.verifyUserName();
			sideMenuBarComponent.verifyLblMerchnatApplicationTracker();
			sideMenuBarComponent.verifyMerchnatTracker();
			sideMenuBarComponent.verifyMerchantActivityDrpDwn();
			sideMenuBarComponent.verifyTokenAccountPushBtn();
			sideMenuBarComponent.verifyExportFilesPushBtn();
			sideMenuBarComponent.verifyMerchnatSettingsPushBtn();
			sideMenuBarComponent.verifyGetHelpPushBtn();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSideMenuBar failed due to " + e);
		}
	}
}
