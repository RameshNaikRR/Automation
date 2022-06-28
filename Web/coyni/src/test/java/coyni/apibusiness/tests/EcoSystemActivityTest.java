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

public class EcoSystemActivityTest {

	SideBarMenuComponent sideBarMenuComponent;
	HomePage homePage;
	ExportFilesPage exportfilesPage;

	@BeforeMethod
	public void init() {

		sideBarMenuComponent = new SideBarMenuComponent();
		homePage = new HomePage();
		exportfilesPage = new ExportFilesPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testEcosysyemActivityDashBoardView(String strParams) {

		homePage.sideBarMenuComponent().clickEcosystemActivity();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyHeading();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyActivityDashBoard();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyTransactionType();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyTransCount();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyVolume();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickDateRange();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickWallets();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickDeposits();
	}

	@Test
	@Parameters({ "strParams" })
	public void testEcoSystemActivityTransactionsListView(String strParams) {

		homePage.sideBarMenuComponent().clickEcosystemActivity();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickTransHistory();
		homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyLabelTransactionListDetails();

	}

	@Test
	@Parameters({ "strParams" })
	public void testEcoSystemActivityTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickEcosystemActivity();
			Thread.sleep(5000);
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickTransHistory();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent()
					.verifyLabelYourTransactions(data.get("expHeading"));
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyAmount();
			ExtentTestManager.setInfoMessageInReport("Available balance is displayed as "
					+ homePage.sideBarMenuComponent().ecoSystemActivityComponent().getAvailableBalance());
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyLabelTransactionListDetails();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent()
					.verifyLabelPostedTransactions(data.get("expPostedTransactionHeading"));
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyTransactionList();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyTableItemsCount(data.get("query"));
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyPostedTransactions(data.get("count"));
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyBracesCount(data.get("query"));
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyPageNumbersWithCount();
			ExtentTestManager.setInfoMessageInReport("Default Entries is displayed as "
					+ homePage.sideBarMenuComponent().ecoSystemActivityComponent().getDefaultEntriesPerPage());
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickDropDownEntriesPage();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent()
					.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
//			homePage.sideBarMenuComponent().ecoSystemActivityComponent().getEntryOptions();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport("Entries is displayed as "
					+ homePage.sideBarMenuComponent().ecoSystemActivityComponent().getEntriesMessage());
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testTransactionList failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testFilter(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().transactionListComponent().clickFilterButton();
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent().calendarComponponent()
					.clickStartDate();
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent().datePickerComponent()
					.setDate(data.get("startDate"));
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent().datePickerComponent()
					.setDate(data.get("endDate"));
			Thread.sleep(5000);
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent().scroolDownToElement();
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent()
					.clickCheckBox(data.get("checkBox"));
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent()
					.fillFromAmount(data.get("fromAmount"));
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent()
					.fillToAmount(data.get("toAmount"));
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent()
					.fillReferenceID(data.get("referenceID"));
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent()
					.clickCheckBox(data.get("checkBox"));
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent().clickApplyFilters();
			Thread.sleep(3000);
			homePage.sideBarMenuComponent().transactionListComponent().filterComponent().getNoRecordsFound();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testExportFiles(String strParams) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			exportfilesPage.clickExportfiles();
			Thread.sleep(1000);
			exportfilesPage.exportIdView();
			exportfilesPage.exportDateView();
			exportfilesPage.dateRangeView();
			exportfilesPage.reportNameView();
			exportfilesPage.statusView();
			exportfilesPage.verifyIdFormat();
			exportfilesPage.clickIconDownload();
			exportfilesPage.successView();
//			exportfilesPage.clickCheckBox();
//			exportfilesPage.clickDownload();
//			exportfilesPage.clickApply();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception ");
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportFilesBulkDownload(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			exportfilesPage.clickExportfiles();
			Thread.sleep(2000);
			exportfilesPage.clickCheckBox();
			exportfilesPage.clickBulkActionDropDown();
			exportfilesPage.clickDownload();
			exportfilesPage.clickApply();
			exportfilesPage.verifyPageNumberHighlighted(data.get("cssCrop"), data.get("expValue"),
					data.get("expColour"));
			// tokenAccountPage.verifyTableItemsCount(data.get("query"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception ");
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportFilesBulkTrash(String strParams) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			exportfilesPage.clickExportfiles();
			Thread.sleep(2000);
			exportfilesPage.clickCheckBox();
			exportfilesPage.clickBulkActionDropDown();
			exportfilesPage.clickTrash();
			exportfilesPage.clickApply();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception ");
		}
	}

	public void testExportSelectedTransactions(String strParams, String strParams1) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().exportfilesPage().clickExport();
			homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup()
					.verifyHeading(data.get("heading"));
			if (strParams1.equalsIgnoreCase("Today")) {
				homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup().clickOnToday();
			} else if (strParams1.equalsIgnoreCase("Yesterday")) {
				homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup().clickOnYesterday();

			} else if (strParams1.equalsIgnoreCase("Last Seven Days")) {
				homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup().clickOn7Days();
			} else if (strParams1.equalsIgnoreCase("Last Month")) {
				homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup().clickOnLastMonth();
			} else {
				homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup().clickMonthTODate();
			}
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup().clickOnExport();
			homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup()
					.verifyTitle(data.get("exportHeading"));
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup().clickExportPage();
			homePage.sideBarMenuComponent().exportfilesPage().exportSelectedTransactionsPopup().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception " + e);

		}
	}

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

	@Test
	@Parameters({ "strParams" })
	public void testEcosystemActivityAPICallHistory(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickEcosystemActivity();
			homePage.sideBarMenuComponent().ecoSystemActivityComponent().verifyAPIHeading(data.get("apiHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception " + e);

		}
	}
}