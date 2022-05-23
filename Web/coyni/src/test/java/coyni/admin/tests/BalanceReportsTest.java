package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BalanceReportsTest {

	HomePage homePage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testBalanceReportsTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
			homePage.sideBarComponent().clickBalanceReports();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBalanceReportsTest Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBalanceReportTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBalanceReports();
			homePage.sideBarComponent().balanceReportsPage().verifyHeading(data.get("expHeading"));
			homePage.sideBarComponent().balanceReportsPage().getAccountBalance();
			Thread.sleep(2000);
			homePage.sideBarComponent().balanceReportsPage().getPersonalAccountsTotalBalance();
			homePage.sideBarComponent().balanceReportsPage().getAmount();
			homePage.sideBarComponent().balanceReportsPage().getTotalCustomer();
			homePage.sideBarComponent().balanceReportsPage().getTotalBalance();
			// homePage.sideBarComponent().balanceReportsPage().
			homePage.sideBarComponent().balanceReportsPage().getFirstRowHeading();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBalanceReportTest Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBalanceReports();
			Thread.sleep(1000);
			homePage.sideBarComponent().balanceReportsPage().clickExport();
			Thread.sleep(2000);
			if (data.get("dropDown").equalsIgnoreCase("Default (3)")) {
				homePage.sideBarComponent().exportSelectedTransactions().verifyHeading(data.get("expHeading"));
				homePage.sideBarComponent().exportSelectedTransactions().verifySubHeading(data.get("expSubHeading"));
				Thread.sleep(2000);
				homePage.sideBarComponent().exportSelectedTransactions().clickDropDown(data.get("dropDown"));
				homePage.sideBarComponent().exportSelectedTransactions().clickExport();
			} else {
				homePage.sideBarComponent().exportSelectedTransactions().clickDropDown(data.get("dropDown"));
				//homePage.sideBarComponent().exportSelectedTransactions().columnsSelectedTransactions().clickDeselectAll();
				homePage.sideBarComponent().exportSelectedTransactions().columnsSelectedTransactions()
						.clickCheckBox(data.get("checkBox"));
				
				
		 homePage.sideBarComponent().exportSelectedTransactions().columnsSelectedTransactions().clickExport();

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportSelectedTransactions Failed due to Exception " + e);
		}
	}

}
