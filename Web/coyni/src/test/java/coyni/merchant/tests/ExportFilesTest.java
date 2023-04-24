package coyni.merchant.tests;

import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.pages.ExportfilesPage;
import coyni.merchant.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ExportFilesTest {

	HomePage homePage;
	ExportfilesPage exportFilesPage;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		exportFilesPage = new ExportfilesPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportFiles(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			exportFilesPage.clickExportFiles();
			// exportFilesPage.handSymbolHighlightedExportFiles(data.get("cssProp"),data.get("value"),
			// data.get("color"));
			exportFilesPage.verifyHeading(data.get("heading"));
			int verifyTeamMemberRecords = exportFilesPage.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				exportFilesPage.verifyNoRecordsFound();
			} else {
				exportFilesPage.exportIdView();
				exportFilesPage.exportDateView();
				exportFilesPage.dateRangeView();
				exportFilesPage.reportNameView();
				exportFilesPage.statusView();
//				exportFilesPage.verifyIdFormat();
				exportFilesPage.clickIconDownload();
				exportFilesPage.successView();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception ");
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportFilesBulkDownload(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			exportFilesPage.clickExportFiles();
			exportFilesPage.verifyHeading(data.get("heading"));
			int verifyTeamMemberRecords = exportFilesPage.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				exportFilesPage.verifyNoRecordsFound();
			} else {
				exportFilesPage.clickCheckBox();
				exportFilesPage.clickBulkActionDropDown();
				exportFilesPage.clickDownload();
//				exportFilesPage.clickApply();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportFilesBulkDownload failed due to exception ");
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportFilesBulkTrash(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			exportFilesPage.clickExportFiles();
			exportFilesPage.verifyHeading(data.get("heading"));
			int verifyTeamMemberRecords = exportFilesPage.verifyTeamMemberRecords();
			if (verifyTeamMemberRecords > 0) {
				exportFilesPage.verifyNoRecordsFound();
			} else {
				exportFilesPage.clickCheckBox();
				exportFilesPage.clickBulkActionDropDown();
				exportFilesPage.clickTrash();
//				exportFilesPage.clickApply();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportFilesBulkTrash failed due to exception ");
		}
	}

//
	public void testExportSelectedTransactions(String strParams, String strParams1) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			exportFilesPage.clickExportFiles();
			if (strParams1.equalsIgnoreCase("Today")) {
				exportFilesPage.exportSelectedTransactionsPopup().clickOnToday();
			} else if (strParams1.equalsIgnoreCase("Yesterday")) {
				exportFilesPage.exportSelectedTransactionsPopup().clickOnYesterday();

			} else if (strParams1.equalsIgnoreCase("Last Seven Days")) {
				exportFilesPage.exportSelectedTransactionsPopup().clickOn7Days();
			} else if (strParams1.equalsIgnoreCase("Last Month")) {
				exportFilesPage.exportSelectedTransactionsPopup().clickOnLastMonth();
			} else {
				exportFilesPage.exportSelectedTransactionsPopup().clickMonthTODate();
			}
			
			exportFilesPage.exportSelectedTransactionsPopup().clickOnExport();
			exportFilesPage.exportSelectedTransactionsPopup().verifyTitle(data.get("heading"));
			exportFilesPage.exportSelectedTransactionsPopup().clickExportPage();
			exportFilesPage.exportSelectedTransactionsPopup().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportSelectedTransactions failed due to exception " + e);

		}
	}

//
	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionToday(String strParams) {
		testExportSelectedTransactions(strParams, "Today");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionYesterday(String strParams) {
		testExportSelectedTransactions(strParams, "Yesterday");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastSevenDays(String strParams) {
		testExportSelectedTransactions(strParams, "Last Seven Days");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionLastMonth(String strParams) {
		testExportSelectedTransactions(strParams, "Last Month");
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportSelectedTransactionMonthToDate(String strParams) {
		testExportSelectedTransactions(strParams, "Month to Date");
	}
}