package coyni.admin.tests;

import java.util.Map;

import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import coyni.admin.pages.CommissionAccountPage;
import coyni.admin.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CommissionAccountTest {
	
	HomePage homePage;
	CommissionAccountPage commissionAccountPage;
	
	@BeforeMethod
	public void init() {
		homePage = new HomePage();
	}
	
	@Test
    @Parameters({ "strParams" })
	public void testCommissionAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			homePage.sideBarComponent().clickCoyniPortal();
//			homePage.sideBarComponent().clickCommissionAccount();
			homePage.sideBarComponent().commissionAccountPage().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().commissionAccountPage().currentDate();
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnToday();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			homePage.sideBarComponent().commissionAccountPage().verifyWithdrawTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyBuyTokenTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyPayRequestTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifySaleOrderTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyRefundTransaction();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnYesterday();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			homePage.sideBarComponent().commissionAccountPage().verifyWithdrawTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyBuyTokenTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyPayRequestTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifySaleOrderTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyRefundTransaction();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnLast7Days();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			homePage.sideBarComponent().commissionAccountPage().verifyWithdrawTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyBuyTokenTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyPayRequestTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifySaleOrderTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyRefundTransaction();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnMonthToDate();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			homePage.sideBarComponent().commissionAccountPage().verifyWithdrawTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyBuyTokenTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyPayRequestTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifySaleOrderTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyRefundTransaction();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			homePage.sideBarComponent().commissionAccountPage().daysMonthsDropDownComponent().clickOnLastMonth();
			homePage.sideBarComponent().commissionAccountPage().getAccountBalance();
			homePage.sideBarComponent().commissionAccountPage().getTotalCommissionEarned();
			homePage.sideBarComponent().commissionAccountPage().getBatchPayOuts();
			homePage.sideBarComponent().commissionAccountPage().getNextPayOut();
			homePage.sideBarComponent().commissionAccountPage().getLastPayOut();
			homePage.sideBarComponent().commissionAccountPage().verifyWithdrawTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyBuyTokenTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyPayRequestTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifySaleOrderTransaction();
			homePage.sideBarComponent().commissionAccountPage().verifyRefundTransaction();
			// homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			// homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("payOutHeading"));
			// homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCommissionAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionAccountManualBatchNow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().commissionAccountPage().verifyHeading(data.get("heading"));
			String getcommissionAmount = homePage.sideBarComponent().commissionAccountPage().getcommissionAmount();
			String totalAmount = homePage.sideBarComponent().commissionAccountPage().getTotalAmount();
			if (getcommissionAmount == totalAmount) {
				ExtentTestManager.setInfoMessageInReport("Total Amount and Commision Amount is same");
				homePage.sideBarComponent().commissionAccountPage().clickBatchNow();
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCommissionAccountManualBatchNow Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionAccountPayOut(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().verifyHeading(data.get("heading"));
			Thread.sleep(3000);
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().fillSearch();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().clickPayOutDate();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getPayOutDate();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getPayOutAmount();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getTransactionReference();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getToTokenAccount();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getTransactionCount();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getVolumeCount();
			String commission = homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage()
					.getCommission();
			String payout = homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage()
					.getPayoutCommission();
			if (commission.contains(payout)) {
				ExtentTestManager.setInfoMessageInReport("Payout Amount and Commission is Same");
				homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage()
						.getTotalTransactionCount();
				homePage.sideBarComponent().commissionAccountPage().payOutsPage().payOutIDPage().getTotalAmount();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCommissionAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedPayOutToday(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
					.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
			testExportSelectedTransactions(strParams, "Today");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCommissionAccount Failed due to Exception " + e);
		}
	}

	
	public void testExportSelectedTransactions(String strParams, String strParams1) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			HomePage homePage = new HomePage();
			if (strParams1.equalsIgnoreCase("Today")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnToday();
			} else if (strParams1.equalsIgnoreCase("Yesterday")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnYesterday();

			} else if (strParams1.equalsIgnoreCase("Last 7 Days")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOn7Days();
			} else if (strParams1.equalsIgnoreCase("Last Month")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnLastMonth();
			} else if (strParams1.equalsIgnoreCase("Month to Date")) {
				homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickMonthTODate();
			} else {
				ExtentTestManager.setInfoMessageInReport("Export is done");
			}
			Thread.sleep(2000);
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnExport();
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
					.verifyTitle(data.get("exportHeading"));
			Thread.sleep(2000);
			// homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickExportPage();
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception " + e);

		}
	}

	
	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedPayOutYesterday(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
					.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
			testExportSelectedTransactions(strParams, "Yesterday");

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCommissionAccountManualBatchNow Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedpayOutLastSevenDays(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
					.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
			testExportSelectedTransactions(strParams, "Last Seven Days");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCommissionAccountManualBatchNow Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedPayOutLastMonth(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
					.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
			testExportSelectedTransactions(strParams, "Last Month");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCommissionAccountManualBatchNow Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedPayOutMonthToDate(String strParams) throws InterruptedException {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			homePage.sideBarComponent().exportComponent().clickExport();
			homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
					.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
			testExportSelectedTransactions(strParams, "Month to Date");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCommissionAccountManualBatchNow Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionAccountTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
			Thread.sleep(300);
			homePage.sideBarComponent().tokenAccountPage().transactionPage().verifyTransaction();
//			homePage.sideBarComponent().tokenAccountPage().transactionPage().paginationAndEntriesComponent()
//					.verifyTableItemsCount(data.get("query"));
			homePage.sideBarComponent().tokenAccountPage().transactionPage().paginationAndEntriesComponent()
					.verifyPageNumbersWithCount();
//			homePage.sideBarComponent().tokenAccountPage().transactionPage().paginationAndEntriesComponent()
//					.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
			homePage.sideBarComponent().tokenAccountPage().transactionPage().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport("Entries is displayed as "
					+ homePage.sideBarComponent().tokenAccountPage().transactionPage().getEntriesMessage());
			homePage.sideBarComponent().tokenAccountPage().transactionPage().clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountTransactionList Failed due to Exception " + e);
		}
	}

	public void testCommissionAccountFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCommissionAccount();
			homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
	//		homePage.sideBarComponent().tokenAccountPage().filterComponent().viewFilters();
	//		homePage.sideBarComponent().tokenAccountPage().filterComponent().selectFilter(data.get("filterType"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("amount"));
			// homePage.sideBarComponent().tokenAccountPage().filterComponent().selectType(data.get("referenceID"));
			// homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyEmployeeName(data.get("empName"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionResetFilters(String strParams) throws InterruptedException {

		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		//testResetFilters(strParams);

	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionToday(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Today");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionYesterday(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Yesterday");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionLastSevenDays(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Last Seven Days");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionLastMonth(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Last Month");
	}

	@Test
	@Parameters({ "strParams" })
	public void testCommissionExportSelectedTransactionMonthToDate(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarComponent().clickCommissionAccount();
		homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		homePage.sideBarComponent().exportComponent().clickExport();
		homePage.sideBarComponent().commissionAccountPage().payOutsPage().exportComponent()
				.exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
		testExportSelectedTransactions(strParams, "Month to Date");
	}

	@Test
	@Parameters({ "strParams" })
	public void testVerifyPayoutTransactionHistory(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		// homePage.sideBarComponent().clickTokenAccount();
		// homePage.sideBarComponent().commissionAccountPage().verifyHeading(data.get("heading"));
		homePage.sideBarComponent().commissionAccountPage().verifyTransactionList();

	}

	

	@Test
	@Parameters({ "strParams" })
	public void testTokenAccountFiltersWithReferenceIdInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
		//	homePage.sideBarComponent().tokenAccountPage().filterComponent().fillReferenceId(data.get("referenceId"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountFilters Failed due to Exception " + e);
		}
	}


	@Test
	public void testPayoutHistoryPaginations() {
		try {
			homePage.sideBarComponent().clickCommissionAccount();
			homePage.sideBarComponent().commissionAccountPage().clickFullPayOutHistory();
			//homePage.sideBarComponent().accountTableComponent().verifyPaginations();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Paginations Failed due to this Exception " + e);
		}

	}

	@Test
	public void testTransactionHistoryPaginations() {
		try {
			homePage.sideBarComponent().clickCommissionAccount();
			homePage.sideBarComponent().commissionAccountPage().clickFullTransactionHistory();
		//	homePage.sideBarComponent().accountTableComponent().verifyPaginations();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Paginations Failed due to this Exception " + e);
		}

	}

	
}
