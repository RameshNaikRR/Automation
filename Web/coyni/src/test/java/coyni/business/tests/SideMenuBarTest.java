package coyni.business.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.business.components.SideMenuBarComponent;
import coyni.uitilities.CommonFunctions;
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
			sideMenuBarComponent.verifyWallets();
			sideMenuBarComponent.clickWallets();
			sideMenuBarComponent.verifyPayments();
			Thread.sleep(3000);
//			sideMenuBarComponent.paymentsDropDown();
			sideMenuBarComponent.clickACH();
			sideMenuBarComponent.clickWire();
			sideMenuBarComponent.approvals();
			sideMenuBarComponent.payees();
			sideMenuBarComponent.clickPayments();
			sideMenuBarComponent.verifyExports();
			sideMenuBarComponent.clickExports();
			sideMenuBarComponent.verifyBusinessSettings();
			sideMenuBarComponent.clickBusinessSettings();
			sideMenuBarComponent.verifyGetHelpPushBtn();
			sideMenuBarComponent.clickGetHelp();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSideMenuBar failed due to " + e);
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
