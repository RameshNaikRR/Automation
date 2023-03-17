package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.ExportFilesPage;
import coyni.apibusiness.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ExportFilesTest {

	HomePage homePage;
	ExportFilesPage exportFilesPage;
	SideBarMenuComponent sideBarMenuComponent;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		exportFilesPage = new ExportFilesPage();
		sideBarMenuComponent = new SideBarMenuComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportFiles(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickExportFiles();
			exportFilesPage.verifyHeading(data.get("heading"));
			Thread.sleep(1000);
			exportFilesPage.exportIdView();
			exportFilesPage.exportDateView();
			exportFilesPage.dateRangeView();
			exportFilesPage.reportNameView();
			exportFilesPage.statusView();
			exportFilesPage.clickIconDownload();
			exportFilesPage.successView();
			exportFilesPage.clickCheckBox();
			exportFilesPage.clickBulkActionDropDown();
			Thread.sleep(2000);
			exportFilesPage.clickDownload();
			Thread.sleep(2000);
			exportFilesPage.clickApply();
			exportFilesPage.toastComponent().verifyToast(data.get("title"), data.get("toastMessage"));
			exportFilesPage.clickCheckBox();
			exportFilesPage.clickBulkActionDropDown();
			Thread.sleep(2000);
			exportFilesPage.clickTrash();
			Thread.sleep(2000);
			exportFilesPage.clickApply();
			exportFilesPage.toastComponent().verifyToast(data.get("title"), data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception ");
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testExportFilesBulkDownload(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarMenuComponent.clickExportFiles();
//			exportFilesPage.verifyHeading(data.get("heading"));
//			Thread.sleep(2000);
//			
////			exportFilesPage.verifyPageNumberHighlighted(data.get("cssCrop"), data.get("expValue"),
////					data.get("expColour"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testExportFilesBulkDownload failed due to exception ");
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testExportFilesBulkTrash(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarMenuComponent.clickExportFiles();
//			exportFilesPage.verifyHeading(data.get("heading"));
//			Thread.sleep(2000);
//			
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testExportFilesBulkTrash failed due to exception ");
//		}
//	}

//
	public void testExportSelectedTransactions(String strParams, String strParams1) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickExportFiles();
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
			Thread.sleep(2000);
			exportFilesPage.exportSelectedTransactionsPopup().clickOnExport();
			exportFilesPage.exportSelectedTransactionsPopup().verifyTitle(data.get("heading"));
			Thread.sleep(2000);
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