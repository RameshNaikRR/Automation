package coyni.merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.components.SideMenuBarComponent;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class SideMenuBarTest {
	SideMenuBarComponent sideMenuBarComponent;

	@BeforeTest
	public void init() {
		sideMenuBarComponent = new SideMenuBarComponent();
	}

	@Test
	public void testSideMenuBar() {
		try {
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

	@Test
	@Parameters({ "strParams" })
	public void testMerchantActivityDrpDwnBtns(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			for (int i = 0; i < 1; i++) {
				sideMenuBarComponent.clickMerchantActivityDrpDwn();
				for (int j = 1; j <= 4; j++) {
					if (1 == j) {
						sideMenuBarComponent.clickDashboard();
						sideMenuBarComponent.dashBoardPage().verifyHeading(data.get("dashboardHeading"));
					} else if (2 == j) {
						sideMenuBarComponent.clickTransactions();
						sideMenuBarComponent.transactionsPage().verifyHeading(data.get("transactionsHeading"));
					} else if (3 == j) {
						sideMenuBarComponent.clickPayoutHistory();
						sideMenuBarComponent.payOutHistoryPage().verifyHeading(data.get("payOutHistoryHeading"));
					} else {
						sideMenuBarComponent.clickReserveHistory();
						sideMenuBarComponent.reserveHistoryPage().verifyHeading(data.get("reserveHistoryHeading"));
					}
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantActivityDrpDwnBtns failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSideMenuBarBtns(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			for (int i = 0; i < 4; i++) {
				if (0 == i) {
					sideMenuBarComponent.clickTokenAccount();
					sideMenuBarComponent.tokenAccountPage().verifyHeading(data.get("tokenAccountHeading"));
				} else if (1 == i) {
					sideMenuBarComponent.clickExportFiles();
					sideMenuBarComponent.exportfilesPage().verifyHeading(data.get("exportFilesHeading"));
				} else if (2 == i) {
					sideMenuBarComponent.clickMerchantSettings();
					sideMenuBarComponent.merchantSettingsPage().verifyHeading(data.get("merchantSettingsHeading"));
				} else {
					sideMenuBarComponent.clickGetHelp();
					sideMenuBarComponent.getHelpPage().verifyHeading(data.get("getHelpHeading"));
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSideMenuBarBtns failed due to " + e);
		}
	}
}
