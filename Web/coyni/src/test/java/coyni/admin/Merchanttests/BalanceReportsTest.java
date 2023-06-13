package coyni.admin.Merchanttests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.MerchantServicesPages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BalanceReportsTest {

	HomePage homePage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();

	}

	// sanity test

	@Test
	@Parameters({ "strParams" })
	public void testVerifyBalanceReport(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().clickBalanceReports();
			homePage.sideBarComponent().balanceReportPage().verifyHeading(data.get("expHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBalanceReportsTest Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testVerifyCountAndBalanceReportsTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().clickBalanceReports();
			homePage.sideBarComponent().balanceReportPage().getTotalCustomerCount(data.get("customerCountQuery"));
			homePage.sideBarComponent().balanceReportPage().getTotalBalance(data.get("customerBalanceQuery"));
			homePage.sideBarComponent().balanceReportPage().getPersonalBalance(data.get("personalBalanceCount"));
			homePage.sideBarComponent().balanceReportPage().getBusinessBalance(data.get("businessBalanceQuery"));

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
			homePage.sideBarComponent().balanceReportPage().verifyHeading(data.get("expHeading"));
			homePage.sideBarComponent().balanceReportPage().getAccountBalance();
			Thread.sleep(2000);
			homePage.sideBarComponent().balanceReportPage().getPersonalAccountsTotalBalance();
			homePage.sideBarComponent().balanceReportPage().getAmount();
			homePage.sideBarComponent().balanceReportPage().getTotalCustomer();
			homePage.sideBarComponent().balanceReportPage().getTotalBalance();
			// homePage.sideBarComponent().balanceReportsPage().
			homePage.sideBarComponent().balanceReportPage().getFirstRowHeading();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBalanceReportTest Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			homePage.sideBarComponent().clickBalanceReports();
			Thread.sleep(2000);
			homePage.sideBarComponent().balanceReportPage().clickExport();
			Thread.sleep(2000);
//			if (data.get("dropDown").equalsIgnoreCase("Default (3)")) {
//				homePage.sideBarComponent().exportSelectedTransactionsPopup().verifyHeading(data.get("expHeading"));
//				homePage.sideBarComponent().exportSelectedTransactionsPopup().verifySubHeading(data.get("expSubHeading"));
//				Thread.sleep(2000);
//				homePage.sideBarComponent().exportSelectedTransactionsPopup().clickDropDown(data.get("dropDown"));
//				homePage.sideBarComponent().exportSelectedTransactionsPopup().clickExport();
//			} else {
//				homePage.sideBarComponent().exportSelectedTransactionsPopup().clickDropDown(data.get("dropDown"));
//				// homePage.sideBarComponent().exportSelectedTransactions().columnsSelectedTransactions().clickDeselectAll();
////				homePage.sideBarComponent().exportSelectedTransactions().columnsSelectedTransactions()
////						.clickCheckBox(data.get("checkBox"));
//
//				homePage.sideBarComponent().exportSelectedTransactionsPopup().columnsSelectedTransactions().clickExport();
//
//			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportSelectedTransactions Failed due to Exception " + e);
		}
	}

}
