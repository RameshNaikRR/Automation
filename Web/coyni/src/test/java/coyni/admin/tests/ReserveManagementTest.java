package coyni.admin.tests;

import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import coyni.admin.pages.HomePage;
import coyni.admin.pages.ReserveManagementPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ReserveManagementTest {

	HomePage homePage;
	ReserveManagementPage reserveManagementPage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		reserveManagementPage = new ReserveManagementPage();
	}

	// sanity testing
	@Test
	@Parameters({ "strParams" })
	public void testReserveManagementLinks(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickReserveManagement();
			homePage.sideBarComponent().reserveManagementPage().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().reserveManagementPage().exportComponent().clickExport();
			homePage.sideBarComponent().reserveManagementPage().exportComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveManagement failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveManagement(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickReserveManagement();
			homePage.sideBarComponent().reserveManagementPage().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().reserveManagementPage().clickAllStatuses();
			homePage.sideBarComponent().reserveManagementPage().clickActive();
			homePage.sideBarComponent().reserveManagementPage().clickStopped();
			homePage.sideBarComponent().reserveManagementPage().clickInActive();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveManagement failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveManagementExport(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickReserveManagement();
			homePage.sideBarComponent().reserveManagementPage().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().reserveManagementPage().clickExport();
			homePage.sideBarComponent().reserveManagementPage().exportComponent().clickExportButton();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveManagementExport failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveManagementRecord(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickReserveManagement();
			homePage.sideBarComponent().reserveManagementPage().verifyHeading(data.get("heading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().reserveManagementPage().fillSearch(data.get("search"));
			homePage.sideBarComponent().reserveManagementPage().clickRecord();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().daysMonthsDropDownComponent()
					.clickOnToday();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().daysMonthsDropDownComponent()
					.clickOnYesterday();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().daysMonthsDropDownComponent()
					.clickOnLast7Days();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().daysMonthsDropDownComponent()
					.clickOnMonthToDate();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().daysMonthsDropDownComponent()
					.clickOnLastMonth();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getReserveBalance();
			// homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getReserveRecords();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getNextRelease();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getLastRelease();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().clickActivityLog();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getActivityLog();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().clickFullReserveReleaseHistory();
			homePage.sideBarComponent().clickReserveManagement();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveManagementRecord failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveManagementReserveRules(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickReserveManagement();
			homePage.sideBarComponent().reserveManagementPage().verifyHeading(data.get("heading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().reserveManagementPage().fillSearch(data.get("search"));
			homePage.sideBarComponent().reserveManagementPage().clickRecord();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getReserveBalance();
			// homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getReserveRecords();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getNextRelease();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getLastRelease();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().clickActivityLog();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().getActivityLog();
			homePage.sideBarComponent().reserveManagementPage().reserveRulesPage().clickFullReserveReleaseHistory();
			homePage.sideBarComponent().clickReserveManagement();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveManagementRecord failed due to exception " + e);
		}
	}

}
