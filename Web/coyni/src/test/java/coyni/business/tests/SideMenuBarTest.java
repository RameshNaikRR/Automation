package coyni.business.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.business.components.SideMenuBarComponent;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class SideMenuBarTest {
	SideMenuBarComponent sideMenuBarComponent;

	@BeforeTest
	public void init() {
		sideMenuBarComponent = new SideMenuBarComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testSideMenuBar(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideMenuBarComponent.handSymbolHighlightedTokenAccount(data.get("cssProp"), data.get("value"),
//					data.get("color"));
			sideMenuBarComponent.verifyWallets();
//			sideMenuBarComponent.handSymbolHighlightedExportFiles(data.get("cssProp"), data.get("value"),
//					data.get("color"));
			sideMenuBarComponent.verifyPayments();
			sideMenuBarComponent.verifyExportFilesPushBtn();
//			sideMenuBarComponent.handSymbolHighlightedBusinessSettings(data.get("cssProp"), data.get("value"),
//					data.get("color"));
			sideMenuBarComponent.verifyMerchnatSettingsPushBtn();
//			sideMenuBarComponent.handSymbolHighlightedGetHelp(data.get("cssProp"), data.get("value"),
//					data.get("color"));
			sideMenuBarComponent.verifyGetHelpPushBtn();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSideMenuBar failed due to " + e);
		}
	}

	@Test
	public void testMerchantActivityDrpDwn() {
		try {
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			sideMenuBarComponent.verifyDashboard();
			sideMenuBarComponent.verifyTransactions();
			sideMenuBarComponent.verifyPayoutHistory();
			sideMenuBarComponent.verifyReserveHistory();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantActivityDrpDwn failed due to " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testMerchantActivityDrpDwnBtns(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideMenuBarComponent.clickMerchantActivityDrpDwn();
//			Thread.sleep(2000);
//			sideMenuBarComponent.clickDashboard();
//			sideMenuBarComponent.dashBoardPage().verifyHeading(data.get("dashboardHeading"));
//			sideMenuBarComponent.clickTransactions();
//			sideMenuBarComponent.transactionsPage().verifyHeading(data.get("transactionsHeading"));
//			sideMenuBarComponent.clickPayoutHistory();
//			sideMenuBarComponent.payOutHistoryPage().verifyHeading(data.get("payOutHistoryHeading"));
//			sideMenuBarComponent.clickReserveHistory();
//			sideMenuBarComponent.reserveHistoryPage().verifyHeading(data.get("reserveHistoryHeading"));
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testMerchantActivityDrpDwnBtns failed due to " + e);
//		}
//	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testSideMenuBarBtns(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideMenuBarComponent.clickTokenAccount();
//			sideMenuBarComponent.tokenAccountPage().verifyHeading(data.get("tokenAccountHeading"));
//			sideMenuBarComponent.clickExportFiles();
//			sideMenuBarComponent.exportfilesPage().verifyHeading(data.get("exportFilesHeading"));
//			sideMenuBarComponent.clickMerchantSettings();
//			sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("merchantSettingsHeading"));
//			sideMenuBarComponent.clickGetHelp();
//			sideMenuBarComponent.getHelpPage().verifyHeading(data.get("getHelpHeading"));
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testSideMenuBarBtns failed due to " + e);
//		}
//	}

}
