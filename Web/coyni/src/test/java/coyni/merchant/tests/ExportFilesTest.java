package coyni.merchant.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.pages.ExportfilesPage;
import coyni.merchant.pages.HomePage;

public class ExportFilesTest {

	HomePage homePage;
	ExportfilesPage exportFilesPage;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		exportFilesPage =new ExportfilesPage();
	}

//
//@Test
//	@Parameters({ "strParams" })
//	public void testExportFiles(String strParams) {
//		try {
//			// Map<String, String> data = Runner.getKeywordParameters(strParams);
//			exportfilesPage.clickExportfiles();
//			Thread.sleep(1000);
//			exportfilesPage.exportIdView();
//			exportfilesPage.exportDateView();
//			exportfilesPage.dateRangeView();
//			exportfilesPage.reportNameView();
//			exportfilesPage.statusView();
//			exportfilesPage.verifyIdFormat();
//			exportfilesPage.clickIconDownload();
//			exportfilesPage.successView();
////			exportfilesPage.clickCheckBox();
////			exportfilesPage.clickDownload();
////			exportfilesPage.clickApply();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception ");
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testExportFilesBulkDownload(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			Thread.sleep(2000);
//			exportfilesPage.clickExportfiles();
//			Thread.sleep(2000);
//			exportfilesPage.clickCheckBox();
//			exportfilesPage.clickBulkActionDropDown();
//			exportfilesPage.clickDownload();
//			exportfilesPage.clickApply();
//			exportfilesPage.verifyPageNumberHighlighted(data.get("cssCrop"), data.get("expValue"),
//					data.get("expColour"));
//			// tokenAccountPage.verifyTableItemsCount(data.get("query"));
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception ");
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testExportFilesBulkTrash(String strParams) {
//		try {
//			// Map<String, String> data = Runner.getKeywordParameters(strParams);
//			exportfilesPage.clickExportfiles();
//			Thread.sleep(2000);
//			exportfilesPage.clickCheckBox();
//			exportfilesPage.clickBulkActionDropDown();
//			exportfilesPage.clickTrash();
//			exportfilesPage.clickApply();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception ");
//		}
//	}
//
//	public void testExportSelectedTransactions(String strParams, String strParams1) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			Thread.sleep(2000);
//			tokenAccountPage.exportfilesPage().clickExport();
//			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
//			if (strParams1.equalsIgnoreCase("Today")) {
//				tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnToday();
//			} else if (strParams1.equalsIgnoreCase("Yesterday")) {
//				tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnYesterday();
//
//			} else if (strParams1.equalsIgnoreCase("Last Seven Days")) {
//				tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOn7Days();
//			} else if (strParams1.equalsIgnoreCase("Last Month")) {
//				tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnLastMonth();
//			} else {
//				tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickMonthTODate();
//			}
//			Thread.sleep(2000);
//			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnExport();
//			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().verifyTitle(data.get("exportHeading"));
//			Thread.sleep(2000);
//			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickExportPage();
//			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickClose();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception " + e);
//
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testExportSelectedTransactionToday(String strParams) {
//		testExportSelectedTransactions(strParams, "Today");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testExportSelectedTransactionYesterday(String strParams) {
//		testExportSelectedTransactions(strParams, "Yesterday");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testExportSelectedTransactionLastSevenDays(String strParams) {
//		testExportSelectedTransactions(strParams, "Last Seven Days");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testExportSelectedTransactionLastMonth(String strParams) {
//		testExportSelectedTransactions(strParams, "Last Month");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testExportSelectedTransactionMonthToDate(String strParams) {
//		testExportSelectedTransactions(strParams, "Month to Date");
//	}
}