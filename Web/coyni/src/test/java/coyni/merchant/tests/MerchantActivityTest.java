package coyni.merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.components.MerchantActivityComponent;
import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.components.TopBarComponent;
import coyni.merchant.pages.ExportfilesPage;
import coyni.merchant.pages.GetHelpPage;
import coyni.merchant.pages.LoginPage;
import coyni.merchant.pages.MerchantSettingsPage;
import coyni.merchant.pages.MerchantTransactionsPage;
import coyni.merchant.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantActivityTest {
	LoginPage loginPage;
	SideMenuBarComponent sideMenuBarComponent;
	MerchantActivityComponent merchantActivityComponent;
	MerchantTransactionsPage merchantTransactionsPage;
	TokenAccountPage tokenAccountPage;
	TopBarComponent topBarComponent;
	ExportfilesPage exportfilesPage;
	MerchantSettingsPage merchantSettingsPage;
	GetHelpPage getHelpPage;

	@BeforeTest
	public void init() {
		loginPage = new LoginPage();
		sideMenuBarComponent = new SideMenuBarComponent();
		merchantActivityComponent = new MerchantActivityComponent();
		merchantTransactionsPage = new MerchantTransactionsPage();
		topBarComponent = new TopBarComponent();
		tokenAccountPage = new TokenAccountPage();
		exportfilesPage = new ExportfilesPage();
		merchantSettingsPage = new MerchantSettingsPage();
		getHelpPage = new GetHelpPage();
		merchantActivityComponent = new MerchantActivityComponent();
		sideMenuBarComponent = new SideMenuBarComponent();

	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantActivityLinks(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickDashBoard();
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
			sideMenuBarComponent.clickMerchantActivityDrpDwn();
			merchantActivityComponent.clickTransactions();
			merchantActivityComponent.transactionPage().verifyTransactionHeading(data.get("transactionHeading"));
			merchantActivityComponent.clickPayOutHistory();
			merchantActivityComponent.payOutHistoryPage().verifyHeading(data.get("payOutHistoryHeading"));
			merchantActivityComponent.clickReserveHistory();
			merchantActivityComponent.reserveHistoryPage().verifyHeading(data.get("reserveHistoryHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testMerchantActivityLinks failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDashBoardProcessingVolume(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickDashBoard();
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnToday();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnYesterday();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnLast7Days();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnMonthToDate();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().daysMonthsDropDownComponent().clickOnLastMonth();
			merchantActivityComponent.dashBoardPage().getTotalCommissionEarned();
			merchantActivityComponent.dashBoardPage().getRefunds();
			merchantActivityComponent.dashBoardPage().getProcessingFees();
			merchantActivityComponent.dashBoardPage().getMiscellaneousFees();
			merchantActivityComponent.dashBoardPage().getNetAmount();
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
			merchantActivityComponent.dashBoardPage().getAccountBalance();
			merchantActivityComponent.dashBoardPage().getBatchPayOuts();
			merchantActivityComponent.dashBoardPage().getNextPayOut();
			merchantActivityComponent.dashBoardPage().getLastPayOut();
			// merchantActivityComponent.dashBoardPage().clickFullPayOutHistory();
//			merchantActivityComponent.clickDashBoard();
//			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
//			// merchantActivityComponent.dashBoardPage().clickFullTransactionHistory();
//			merchantActivityComponent.clickDashBoard();
//			//merchantActivityComponent.dashBoardPage().clickFullReserveReleaseHistory();
//			merchantActivityComponent.clickDashBoard();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testDashBoardProcessingVolume failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			merchantTransactionsPage.verifyTableItemsCount(data.get("query"));
			merchantTransactionsPage.verifyPageNumbersWithCount();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + merchantTransactionsPage.getDefaultEntriesPerPage());
			merchantTransactionsPage.clickDropDownEntriesPage();
			merchantTransactionsPage.verifyEntriesMessage();
			ExtentTestManager
					.setInfoMessageInReport("Entries is displayed as " + merchantTransactionsPage.getEntriesMessage());
			merchantTransactionsPage.clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testTransactionList failed due to exception " + e);
		}
	}

	public void testExportSelectedTransactions(String strParams, String strParams1) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			merchantTransactionsPage.clickExport();
			if (strParams1.equalsIgnoreCase("Today")) {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnToday();
			} else if (strParams1.equalsIgnoreCase("Yesterday")) {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnYesterday();

			} else if (strParams1.equalsIgnoreCase("Last Seven Days")) {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOn7Days();
			} else if (strParams1.equalsIgnoreCase("Last Month")) {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnLastMonth();
			} else {
				merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickMonthTODate();
			}
			Thread.sleep(2000);
			merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnExport();
			merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup()
					.verifyTitle(data.get("heading"));
			Thread.sleep(2000);
			merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickExportPage();
			merchantTransactionsPage.exportfilesPage().exportSelectedTransactionsPopup().clickClose();
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
	public void testFilter(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			if (merchantTransactionsPage.filterComponent().verifyTransactionss() > 0) {
				merchantTransactionsPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				merchantTransactionsPage.filterComponent().verifyMouseAction();
				merchantTransactionsPage.filterComponent().clickFilters();
				// merchantTransactionsPage.filterComponent().datePickerComponent().setDate(data.get("startdate"));
				// merchantTransactionsPage.filterComponent().datePickerComponent().setDate(data.get("enddate"));
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType3"));
				if (!data.get("errMessage").isEmpty()) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
				}

				merchantTransactionsPage.filterComponent().clickApplyFilters();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFilters Failed due to Exception " + e);
		}
	}

	public void testFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			if (merchantTransactionsPage.filterComponent().verifyTransactionss() > 0) {
				merchantTransactionsPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				merchantTransactionsPage.filterComponent().verifyMouseAction();
				merchantTransactionsPage.filterComponent().clickFilters();
				//merchantTransactionsPage.filterComponent().datePickerComponent().setDate(data.get("startdate"));
				//merchantTransactionsPage.filterComponent().datePickerComponent().setDate(data.get("enddate"));
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType"));
				//merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType3"));
				merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
				merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType2"));
				merchantTransactionsPage.filterComponent().fillSender(data.get("senderName"));
				merchantTransactionsPage.filterComponent().clickApplyFilters();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListFilters(String strParams) {
		testFilters(strParams);

	}

	public void testResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			if (merchantTransactionsPage.filterComponent().verifyTransactionss() > 0) {
				merchantTransactionsPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				merchantTransactionsPage.filterComponent().clickFilters();
//			tokenAccountPage.filterComponent().clickStartDate();
//			tokenAccountPage.filterComponent().datePickerComponent().setDate(data.get("startdate"));
//			tokenAccountPage.filterComponent().datePickerComponent().setDate(data.get("enddate"));
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType"));
				merchantTransactionsPage.filterComponent().clickClearAllTransactionType();
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType"));
				merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
				merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
				merchantTransactionsPage.filterComponent().clickClearTransactionAmount();
				merchantTransactionsPage.filterComponent().fillFromAmount(data.get("amount"));
				merchantTransactionsPage.filterComponent().fillToAmount(data.get("toAmount"));
				merchantTransactionsPage.filterComponent().fillSender(data.get("senderName"));
				merchantTransactionsPage.filterComponent().clickClearSenderName();
				merchantTransactionsPage.filterComponent().fillSender(data.get("senderName"));
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType2"));
				merchantTransactionsPage.filterComponent().fillSender(data.get("senderName"));
				merchantTransactionsPage.filterComponent().clickClearSenderName();
				merchantTransactionsPage.filterComponent().clickResetAllFilters();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testResetFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionListResetFilters(String strParams) {
		testResetFilters(strParams);

	}

	@Test
	@Parameters({ "strParams" })
	public void testDashBoardPayOutHistory(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickDashBoard();
			merchantActivityComponent.clickPayOutHistory();
			// merchantActivityComponent.dashBoardPage().getPayOutHistoryRecentTransactions();
			// merchantActivityComponent.dashBoardPage().clickFullPayOutHistory();
			// merchantActivityComponent.payOutHistoryPage().verifyHeading(data.get("heading"));
			if (merchantActivityComponent.payOutHistoryPage().verifyPayOut() > 0) {
				merchantActivityComponent.payOutHistoryPage().verifyNoPayOutFound();
			} else {
				//merchantActivityComponent.payOutHistoryPage().clickPayOut();
//				merchantActivityComponent.payOutHistoryPage().payOutIDPage().getPayOutDate();
//				merchantActivityComponent.payOutHistoryPage().payOutIDPage().getPayOutAmount();
//				merchantActivityComponent.payOutHistoryPage().payOutIDPage().getToTokenAccount();
//				merchantActivityComponent.payOutHistoryPage().payOutIDPage().getTransactionReference();
//				merchantActivityComponent.payOutHistoryPage().payOutIDPage().verifyDownloadPDF();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDashBoardPayOutHistory failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDashBoardReserveHistoryNoRecords(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickReserveHistory();
			merchantActivityComponent.reserveHistoryPage().verifyHeading(data.get("heading"));
			merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();
			merchantActivityComponent.reserveHistoryPage().clickManual();
			merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();
			merchantActivityComponent.reserveHistoryPage().clickRolling();
			merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDashBoardReserveHistory failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDashBoardFullReserveHistory(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.dashBoardPage().verifyHeading(data.get("heading"));
			merchantActivityComponent.dashBoardPage().getReserveBalance();
			merchantActivityComponent.dashBoardPage().getReserveBalanceDescription();
			merchantActivityComponent.dashBoardPage().getNextRelease();
			merchantActivityComponent.dashBoardPage().getLastRelease();
			merchantActivityComponent.dashBoardPage().clickFullReserveReleaseHistory();
			merchantActivityComponent.reserveHistoryPage().clickOnHold();
			merchantActivityComponent.reserveHistoryPage().clickOpen();
			merchantActivityComponent.reserveHistoryPage().clickReleased();
			merchantActivityComponent.reserveHistoryPage().clickManual();
			merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDashBoardFullReserveHistory failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveHistoryExports(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickReserveHistory();
			merchantActivityComponent.reserveHistoryPage().verifyHeading(data.get("heading"));
			if (merchantActivityComponent.reserveHistoryPage().verifyExports() > 0) {
				merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();
			} else {
				merchantActivityComponent.reserveHistoryPage().exportfilesPage().clickReserveExport();
				merchantActivityComponent.reserveHistoryPage().exportfilesPage().exportSelectedTransactionsPopup()
						.clickOnExport();

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveHistoryexports failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveHistoryIDDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickReserveHistory();
			merchantActivityComponent.reserveHistoryPage().verifyHeading(data.get("heading"));
			if (merchantActivityComponent.reserveHistoryPage().verifyExports() > 0) {
				merchantActivityComponent.reserveHistoryPage().verifyNoRecordsFound();
			} else {
				merchantActivityComponent.reserveHistoryPage().clickReserveHistory();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getDailyBatchIds();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getBatchDate();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getReserveRule();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getReleasedOn();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getReleasedTransactionID();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().getToTokenAccount();
				merchantActivityComponent.reserveHistoryPage().reserveHistoryIDPage().verifyDownloadPDF();

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveHistoryIDDetails failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			merchantActivityComponent.clickTransactions();
			if (merchantTransactionsPage.filterComponent().verifyTransactionss() > 0) {
				Thread.sleep(3000);
				merchantTransactionsPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				merchantTransactionsPage.filterComponent().clickFilters();
				merchantTransactionsPage.filterComponent().selectFilter(data.get("filterType"));
				merchantActivityComponent.filterComponent().clickApplyFilters();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsFilters Failed due to Exception " + e);
		}
	}

	public void testRecords(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		Thread.sleep(3000);
		if (merchantActivityComponent.transactionDetailsComponent().verifyRecords() != 0) {
			merchantActivityComponent.transactionDetailsComponent().verifyNoRecordsFound();
		} else {
			// merchantActivityComponent.merchantTransactionsPage().verifyTransactionHeading(data.get("heading"));
			merchantActivityComponent.transactionDetailsComponent().clickRecord();
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsMerchantPayOut(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			// testRecords(strParams);
			Thread.sleep(2000);
//			merchantActivityComponent.transactionDetailsComponent().getTransactionType();
//			merchantActivityComponent.transactionDetailsComponent().getPayOutID();
//			merchantActivityComponent.transactionDetailsComponent().getReferenceID();
//			merchantActivityComponent.transactionDetailsComponent().getCreatedDate();
//			merchantActivityComponent.transactionDetailsComponent().getAmount();
//			merchantActivityComponent.transactionDetailsComponent().getTotalTransctions();
//			merchantActivityComponent.transactionDetailsComponent().getPayOutDate();
//			merchantActivityComponent.transactionDetailsComponent().getDepositTo();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionDetailsMerchantPayOut Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsSaleOrder(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			// testRecords(strParams);
//			merchantActivityComponent.transactionDetailsComponent().getTransactionType();
//			merchantActivityComponent.transactionDetailsComponent().getPayOutID();
//			merchantActivityComponent.transactionDetailsComponent().getReferenceID();
//			merchantActivityComponent.transactionDetailsComponent().getCreatedDate();
//			merchantActivityComponent.transactionDetailsComponent().getAmount();
//			merchantActivityComponent.transactionDetailsComponent().getTotalTransctions();
//			merchantActivityComponent.transactionDetailsComponent().getPayOutDate();
//			merchantActivityComponent.transactionDetailsComponent().getDepositTo();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsSaleOrder Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsRefund(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			// testRecords(strParams);
//			merchantActivityComponent.transactionDetailsComponent().getTransactionType();
//			merchantActivityComponent.transactionDetailsComponent().getPayOutID();
//			merchantActivityComponent.transactionDetailsComponent().getReferenceID();
//			merchantActivityComponent.transactionDetailsComponent().getCreatedDate();
//			merchantActivityComponent.transactionDetailsComponent().getAmount();
//			merchantActivityComponent.transactionDetailsComponent().getTotalTransctions();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsRefund Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsMonthlyServiceFee(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			// testRecords(strParams);
//			merchantActivityComponent.transactionDetailsComponent().getTransactionType();
//			merchantActivityComponent.transactionDetailsComponent().getReferenceID();
//			merchantActivityComponent.transactionDetailsComponent().getCreatedDate();
//			merchantActivityComponent.transactionDetailsComponent().getAmount();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionDetailsMonthlyServiceFee Failed due to Exception " + e);
		}
	}

}
