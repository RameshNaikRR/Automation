package coyni.admin.merchanttests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.Paymentpages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class GatewaySettingsTest {

	HomePage homePage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();

	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testGatewaySettingsTest(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
////			homePage.sideBarComponent().verifyCursorAction();
//			// homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp",
//			// "expValue", "expColor");
////			homePage.sideBarComponent().clickGatewaySettings();
//			homePage.sideBarComponent().clickPaymentGateways();
//			homePage.sideBarComponent().verifyPaymentGateWay(data.get("paymenyMethod"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testGatewaySettingsTest Failed due to Exception " + e);
//		}
//	}
}
