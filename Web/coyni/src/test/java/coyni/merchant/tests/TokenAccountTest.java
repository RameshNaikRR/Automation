package coyni.merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.components.TokenAccountActivityComponent;
import coyni.merchant.pages.LoginPage;
import coyni.merchant.pages.TokenAccountPage;
import coyni.reusable.components.ProcessingFeeComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenAccountTest {

	TokenAccountPage tokenAccountPage;
	LoginPage loginPage;
	TokenAccountActivityComponent tokenAccountActivityComponent;
	MerchantSettingsTest merchantSettingTest;
	SideMenuBarComponent sideMenuBarComponent;

	@BeforeTest
	public void init() {
		tokenAccountPage = new TokenAccountPage();
		loginPage = new LoginPage();
		tokenAccountActivityComponent = new TokenAccountActivityComponent();
		merchantSettingTest = new MerchantSettingsTest();
		sideMenuBarComponent = new SideMenuBarComponent();

	}

	@Test
	public void testAvailableBalance() throws InterruptedException {
		try {
			tokenAccountPage.clickTokenAccount();
			Thread.sleep(2000);
			tokenAccountPage.verifyLabelYourTokenAccount();
			tokenAccountPage.verifyAmount();
			ExtentTestManager.setInfoMessageInReport(
					"Available balance is displayed as " + tokenAccountPage.getAvailableBalance());
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().navigationComponent().clickClose();
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().navigationComponent().clickClose();

		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testAvailableBalance is failed due to exception " + e);
		}
	}

	public void exports(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		if (tokenAccountPage.tokenAccountActivityComponent().verifyTransactions() != 0) {
			tokenAccountPage.tokenAccountActivityComponent().verifyNoTrasactionsFound();
		} else {
			tokenAccountPage.tokenAccountActivityComponent().exportfilesPage().clickExport();
//			tokenAccountPage.tokenAccountActivityComponent().exportfilesPage().exportSelectedTransactionsPopup()
//					.verifyHeading(data.get("heading"));
			tokenAccountPage.tokenAccountActivityComponent().exportfilesPage().exportSelectedTransactionsPopup()
					.clickOnExport();
			tokenAccountPage.tokenAccountActivityComponent().exportfilesPage().exportSelectedTransactionsPopup()
					.clickClose();
		}
	}

	public void testTodayTrasactions(String strParams, String today) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			if (tokenAccountPage.tokenAccountActivityComponent().verifyTransactions() != 0) {
				tokenAccountPage.tokenAccountActivityComponent().verifyNoTrasactionsFound();

			} else {
				tokenAccountPage.tokenAccountActivityComponent().verifyTableItemsCount(data.get("queryToday"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test failed due to" + e);
		}
	}

	public void testYesterDayTrasactions(String strParams, String today) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			if (tokenAccountPage.tokenAccountActivityComponent().verifyTransactions() != 0) {
				tokenAccountPage.tokenAccountActivityComponent().verifyNoTrasactionsFound();

			} else {
				tokenAccountPage.tokenAccountActivityComponent().verifyTableItemsCount(data.get("queryYesterday"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test failed due to" + e);
		}
	}

	public void testLast7DaysTrasactions(String strParams, String today) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			if (tokenAccountPage.tokenAccountActivityComponent().verifyTransactions() != 0) {
				tokenAccountPage.tokenAccountActivityComponent().verifyNoTrasactionsFound();

			} else {
				tokenAccountPage.tokenAccountActivityComponent().verifyTableItemsCount(data.get("queryLast7Days"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLast7DaysTrasactions failed due to" + e);
		}
	}

	public void testMonthToDateTrasactions(String strParams, String today) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			if (tokenAccountPage.tokenAccountActivityComponent().verifyTransactions() != 0) {
				tokenAccountPage.tokenAccountActivityComponent().verifyNoTrasactionsFound();

			} else {
				tokenAccountPage.tokenAccountActivityComponent().verifyTableItemsCount(data.get("queryMonthToDate"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test failed due to" + e);
		}
	}

	public void testLastMonthTrasactions(String strParams, String today) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(1000);
			if (tokenAccountPage.tokenAccountActivityComponent().verifyTransactions() != 0) {
				tokenAccountPage.tokenAccountActivityComponent().verifyNoTrasactionsFound();

			} else {
				tokenAccountPage.tokenAccountActivityComponent().verifyTableItemsCount(data.get("queryLastMonth"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test failed due to" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testPayOutsReceivedList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayPayOutsReceived();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testTodayTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testYesterDayTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testLast7DaysTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDatePayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testMonthToDateTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testLastMonthTrasactions(strParams, "date");
			exports(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayOutsReceivedList is failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testCustomDateRangePayOutsReceived(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent()
					.clickCustomDateRangePayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent()
					.setDateWithYear(data.get("startDate"));
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("endDate"));
			// verify CustomDateRange

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCustomDateRangePayOutsReceived is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionPurchasedDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			Thread.sleep(3000);
			tokenAccountPage.tokenAccountActivityComponent().clickTokensPurchasedDetails();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayTokensPurchased();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testTodayTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testYesterDayTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testLast7DaysTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDateTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));

			testMonthToDateTrasactions(strParams, "date");
			exports(strParams);

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testLastMonthTrasactions(strParams, "date");
			exports(strParams);

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionPurchasedDetailsList is failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testCustomDateRangePurchaseTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensPurchasedDetails();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent()
					.clickCustomDateRangeTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent()
					.setDateWithYear(data.get("startDate"));
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("endDate"));
			// verify CustomDateRange

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCustomDateRangePurchaseTransaction is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionWithdrawDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensWithdrawnDetails();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayTokensWithdraw();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testTodayTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testYesterDayTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testLast7DaysTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDateTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testMonthToDateTrasactions(strParams, "date");
			exports(strParams);
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testLastMonthTrasactions(strParams, "date");
			exports(strParams);

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionWithdrawDetailsList is failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testCustomDateRangeWithdrawTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensWithdrawnDetails();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent()
					.clickCustomDateRangeTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent()
					.setDateWithYear(data.get("startDate"));
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("endDate"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCustomDateRangeWithdrawTransaction is failed due to exception " + e);
		}
	}

	@Test
	public void testTokenAccountActivityDetails() throws InterruptedException {
		try {
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().tokenAccountActivityDetails();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnToday();
			tokenAccountPage.tokenAccountActivityComponent().getPayOutsReceivedList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionPurchasedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionWithdrawDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnYesterday();
			tokenAccountPage.tokenAccountActivityComponent().getPayOutsReceivedList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionPurchasedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionWithdrawDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnLast7Days();
			tokenAccountPage.tokenAccountActivityComponent().getPayOutsReceivedList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionPurchasedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionWithdrawDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnMonthToDate();
			tokenAccountPage.tokenAccountActivityComponent().getPayOutsReceivedList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionPurchasedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionWithdrawDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnLastMonth();
			tokenAccountPage.tokenAccountActivityComponent().getPayOutsReceivedList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionPurchasedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionWithdrawDetailsList();

		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountActivityDetails is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.verifyAmount();
			ExtentTestManager.setInfoMessageInReport(
					"Available balance is displayed as " + tokenAccountPage.getAvailableBalance());
			tokenAccountPage.verifyLabelTransactionListDetails();
			tokenAccountPage.verifyTableItemsCount(data.get("query"));
			tokenAccountPage.verifyPageNumbersWithCount();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountPage.getDefaultEntriesPerPage());
			tokenAccountPage.clickDropDownEntriesPage();
			tokenAccountPage.verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport("Entries is displayed as " + tokenAccountPage.getEntriesMessage());
			tokenAccountPage.clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testTransactionList failed due to exception " + e);
		}

	}

	public void testExportSelectedTransactions(String strParams, String strParams1) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			if (tokenAccountPage.verifyTransactions() > 0) {
				tokenAccountPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				tokenAccountPage.clickExport();
				if (strParams1.equalsIgnoreCase("Today")) {
					tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnToday();
				} else if (strParams1.equalsIgnoreCase("Yesterday")) {
					tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnYesterday();

				} else if (strParams1.equalsIgnoreCase("Last Seven Days")) {
					tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOn7Days();
				} else if (strParams1.equalsIgnoreCase("Last Month")) {
					tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnLastMonth();
				} else {
					tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickMonthTODate();
				}
				Thread.sleep(2000);

			}
			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnExport();
			Thread.sleep(2000);
			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().navigationComponent().clickClose();
//				tokenAccountPage.exportfilesPage().notificationsComponent().clickNotificationsIcon();
//				tokenAccountPage.merchantProfilePage().userDetailsComponent().notificationsComponent()
//						.verifyNotificationText(data.get("notificationText"));
		} catch (

		Exception e) {
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

	public void testFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			Thread.sleep(10000);
			tokenAccountPage.clickTokenAccount();
//			Thread.sleep(2000);
			if (tokenAccountPage.filterComponent().verifyTransactionss() > 0) {
				Thread.sleep(3000);
				tokenAccountPage.filterComponent().verifyNoTrasactionsFound();
			} else {
				Thread.sleep(2000);
				tokenAccountPage.filterComponent().clickFilters();
//			    tokenAccountPage.filterComponent().clickStartDate();
//			    tokenAccountPage.filterComponent().datePickerComponent().setDate(data.get("startdate"));
//			   tokenAccountPage.filterComponent().datePickerComponent().setDate(data.get("enddate"));
				tokenAccountPage.filterComponent().selectFilter(data.get("filterType"));
				tokenAccountPage.filterComponent().selectFilter(data.get("filterType1"));
				tokenAccountPage.filterComponent().fillFromAmount(data.get("amount"));
				tokenAccountPage.filterComponent().fillToAmount(data.get("toAmount"));
				tokenAccountPage.filterComponent().selectFilter(data.get("filterType2"));
				tokenAccountPage.filterComponent().clickApplyFilters();
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
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.filterComponent().clickFilters();
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType"));
			tokenAccountPage.filterComponent().clickClearAllTransactionType();
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType"));
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType1"));
			tokenAccountPage.filterComponent().clickClearAllTransactionSubType();
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType1"));
			tokenAccountPage.filterComponent().fillFromAmount(data.get("amount"));
			tokenAccountPage.filterComponent().fillToAmount(data.get("toAmount"));
			tokenAccountPage.filterComponent().clickClearTransactionAmount();
			tokenAccountPage.filterComponent().fillFromAmount(data.get("amount"));
			tokenAccountPage.filterComponent().fillToAmount(data.get("toAmount"));
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType2"));
			tokenAccountPage.filterComponent().clickClearAllTransactionStatus();
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType2"));
			tokenAccountPage.filterComponent().clickResetAllFilters();

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
	public void testTransactionDetailsFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.filterComponent().clickFilters();
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType"));
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType1"));
			tokenAccountPage.filterComponent().clickApplyFilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsReserveMerchantPayOutFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.filterComponent().clickFilters();
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType"));
			tokenAccountPage.filterComponent().clickApplyFilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testTransactionDetailsReserveMerchantPayOutFilters Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsFiltersWithdraw(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.filterComponent().clickFilters();
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType"));
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType1"));
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType2"));
			tokenAccountPage.filterComponent().clickApplyFilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsFilters Failed due to Exception " + e);
		}
	}

	public void testRecords(String strParams) throws InterruptedException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		Thread.sleep(3000);
		if (tokenAccountPage.transactionDetailsComponent().verifyRecords() != 0) {
			tokenAccountPage.transactionDetailsComponent().verifyNoRecordsFound();
		} else {
			tokenAccountPage.verifyHeading(data.get("heading"));
			tokenAccountPage.transactionDetailsComponent().clickRecord();
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsReserveRelease(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsReserveMerchantPayOutFilters(strParams);
			testRecords(strParams);
//			tokenAccountPage.transactionDetailsComponent().getTransactionType();
//			tokenAccountPage.transactionDetailsComponent().getReferenceID();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionDetailsReserveRelease Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsMerchantPayOut(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsReserveMerchantPayOutFilters(strParams);
			testRecords(strParams);
//			tokenAccountPage.transactionDetailsComponent().getTransactionType();
//			tokenAccountPage.transactionDetailsComponent().getReferenceID();
//			tokenAccountPage.transactionDetailsComponent().getCreatedDate();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionDetailsMerchantPayOut Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			testRecords(strParams);
//			tokenAccountPage.transactionDetailsComponent().getTransactionType();
//			tokenAccountPage.transactionDetailsComponent().getReferenceID();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionDetailsSignetAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsBankAccount(String strParams) {
		try {
			testTransactionDetailsFilters(strParams);
			testRecords(strParams);
			Thread.sleep(4000);
			tokenAccountPage.transactionDetailsComponent().getTransactionType();
			tokenAccountPage.transactionDetailsComponent().getTransactionSubType();
			tokenAccountPage.transactionDetailsComponent().getReferenceID();
			tokenAccountPage.transactionDetailsComponent().getCreatedDate();
			tokenAccountPage.transactionDetailsComponent().getAmount();
			tokenAccountPage.transactionDetailsComponent().getBankAccount();
			tokenAccountPage.transactionDetailsComponent().getBankName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsBankAccount Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			testRecords(strParams);
//			tokenAccountPage.transactionDetailsComponent().getTransactionType();
//			tokenAccountPage.transactionDetailsComponent().getTransactionSubType();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			testRecords(strParams);
//			tokenAccountPage.transactionDetailsComponent().getTransactionType();
//			tokenAccountPage.transactionDetailsComponent().getTransactionSubType();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailWithdrawInstantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			testRecords(strParams);
//			tokenAccountPage.transactionDetailsComponent().getTransactionType();
//			tokenAccountPage.transactionDetailsComponent().getTransactionSubType();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawFailedBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFiltersWithdraw(strParams);
			testRecords(strParams);
//			tokenAccountPage.transactionDetailsComponent().getTransactionType();
//			tokenAccountPage.transactionDetailsComponent().getTransactionSubType();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawCancelledBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFiltersWithdraw(strParams);
			testRecords(strParams);
//			tokenAccountPage.transactionDetailsComponent().getTransactionType();
//			tokenAccountPage.transactionDetailsComponent().getTransactionSubType();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test TransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetailsWithdrawGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testTransactionDetailsFilters(strParams);
			testRecords(strParams);
//			tokenAccountPage.transactionDetailsComponent().getTransactionType();
//			tokenAccountPage.transactionDetailsComponent().getTransactionSubType();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionsWithAllPaymentMethods(String strParams, String payment) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			if (payment.equalsIgnoreCase("No")) {
				tokenAccountPage.buyCoyniTokensNoPaymentPopup().clickOnAddNewPayment();
				testBuyTokenTransactionBankAccount(strParams);
				testBuyTokenDeleteBank(strParams);

				payment.equalsIgnoreCase("No");

			}

			else if (payment.equalsIgnoreCase("Change")) {
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickChangeLink();
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickAddNewPaymentMethod();
				tokenAccountPage.clickBuyTokens();
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickChangeLink();
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickAddNewPaymentMethod();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test Buy Token Transaction with bank account failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionsWithoutBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testBuyTokenTransactionsWithAllPaymentMethods(strParams, "No");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenTransactionsWithBank is failed" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			Thread.sleep(3000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickBank(data.get("number"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amount"));
//			String processingFee = tokenAccountPage.buyCoyniTokensPaymentMethodPopup().processingFeeComponent()
//					.getTotalProcessingFee(data.get("amount"));
//			String totalAmount = new ProcessingFeeComponent().getTotalAmount(data.get("amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickOutSIde();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.verifyOrderViewHeading();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.authyComponent().fillInput(data.get("code"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.transactionInProgessPopup().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test Buy Token Transaction with bank account failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionBankAccountWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickBank(data.get("number"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testBuyTokenTransactionBankAccountWithInvalidData failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenViewWithOutPaymentMethods(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenDescrpWithOutPaymentMethods();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().verifyAddNewPaymentMethodHeading();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().navigationComponent().clickBack();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup()
					.verifyBuyCoyniTokenHeading(data.get(""));
			tokenAccountPage.buyCoyniTokensPopup().navigationComponent().clickClose();
			tokenAccountPage.verifyLabelYourTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().clickBankAccount();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addBankAccountPopup().verifyHeading();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addBankAccountPopup()
					.navigationComponent().clickBack();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addBankAccountPopup().verifyHeading();
			tokenAccountPage.verifyLabelYourTokenAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenAddBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsTest merchantSettingsTest = new MerchantSettingsTest();
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			merchantSettingsTest.testAddExternalBankAccount(strParams);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().navigationComponent().clickClose();
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testBuyTokenAddBank(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			MerchantSettingsTest merchantSettingsTest = new MerchantSettingsTest();
//			sideMenuBarComponent.clickTokenAccount();
//			tokenAccountPage.clickBuyTokens();
////			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().clickBankAccount();
////			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addBankAccountPopup()
////					.fillRoutingNumber(data.get("routingNumber"));
////			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addBankAccountPopup()
////					.fillConfirmRoutingNumber(data.get("confirmRoutingNumber"));
////			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addBankAccountPopup()
////					.fillAccountNumber(data.get("accountNumber"));
////			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addBankAccountPopup()
////					.fillConfirmAccountNumber(data.get("confirmAccountNumber"));
////			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addBankAccountPopup().clickAdd();
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addBankAccountPopup()
//					.bankAccountAddedPopup().clickBuyCoyni();
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().navigationComponent().clickClose();
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDeleteBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("heading"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickDelete(data.get("number"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup().clickOnRemove();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenDeleteBank is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenViewWithPaymentMethods(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().viewChangeLink();
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().verifyBuyCoyniTokenDescription();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickDelete();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent()
					.verifyPaymnetRemovedSuccessfulHeading();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent()
					.viewClose();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent()
					.clickClose();
			tokenAccountPage.viewBuyTokens();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.verifyOrderViewHeading();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.authyComponent().fillInput(data.get("code"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.transactionInProgessPopup().clickDone();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testBuyTokenTransactionSignetAccount failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenAddCogent(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsTest merchantSettingsTest = new MerchantSettingsTest();
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			merchantSettingsTest.testaddCogent(strParams);
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionCogentAccountWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testBuyTokenTransactionSignetAccountWithInvalidData failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDDeleteCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnCogentAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickDeleteCogentAccount(data.get("cogentNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().removePaymentMethodPopup().clickOnRemove();
			tokenAccountPage.withdrawCoyniToUSDPopup().removePaymentMethodPopup().successFailurePopupCardComponent()
					.verifyPaymnetRemovedSuccessfulHeading();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDAddCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnCogentAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().clickAddNewCogentAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().addNewCogentAccountPopup()
					.fillName(data.get("newCogentAccount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().addNewCogentAccountPopup()
					.fillCognetWalletId(data.get("walletID"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().addNewCogentAccountPopup()
					.mailingAddressComponent().fillAddress1(data.get("addressLine1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().addNewCogentAccountPopup()
					.mailingAddressComponent().fillAddress2(data.get("addressLine2"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().addNewCogentAccountPopup()
					.mailingAddressComponent().fillCity(data.get("city1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().addNewCogentAccountPopup()
					.mailingAddressComponent().selectState(data.get("state1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().addNewCogentAccountPopup()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().addNewCogentAccountPopup()
					.clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDCogentAccountInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnCogentAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup()
					.clickCogent(data.get("cogentNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().enterAmount(data.get("amount"));
			Thread.sleep(5000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().clickCoyniConvertion();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup()
					.enterMessage(data.get("description"));

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testRemoveCogentAccount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideMenuBarComponent.clickTokenAccount();
//			tokenAccountPage.clickBuyTokens();
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
//			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickDeleteSignetAccount(data.get("signetNumber"));
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup().clickOnRemove();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDCogentAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnCogentAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup()
					.clickCogent(data.get("cogentNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().enterAmount(data.get("amount"));
			String processingFee = tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup()
					.processingFeeComponent().getTotalProcessingFee(data.get("amount"));
			String totalAmount = new ProcessingFeeComponent().getTotalAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().clickTab();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().clickTab();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().clickTab();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().clickTab();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().withdrawToCogentPreviewPopup()
					.getWithdrawAmount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().withdrawToCogentPreviewPopup()
					.getProcessingFee();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().withdrawToCogentPreviewPopup()
					.getTotal();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().withdrawToCogentPreviewPopup()
					.clickConfirm();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().withdrawToCogentPreviewPopup()
					.authyComponent().fillInput(data.get("code1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToCogentAccountPopup().withdrawToCogentPreviewPopup()
					.authyComponent().successFailureComponent();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testRemoveSignetAccount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideMenuBarComponent.clickTokenAccount();
//			tokenAccountPage.clickBuyTokens();
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
//			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickDeleteSignetAccount(data.get("signetNumber"));
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup().clickOnRemove();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnSignetAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup()
					.clickSignet(data.get("signetNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().enterAmount(data.get("amount"));
			String processingFee = tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup()
					.processingFeeComponent().getTotalProcessingFee(data.get("amount"));
			String totalAmount = new ProcessingFeeComponent().getTotalAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().withdrawToSignetPreviewPopup()
					.getWithdrawAmount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().withdrawToSignetPreviewPopup()
					.getProcessingFee();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().withdrawToSignetPreviewPopup()
					.getTotal();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().withdrawToSignetPreviewPopup()
					.clickConfirm();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().withdrawToSignetPreviewPopup()
					.authyComponent().fillInput(data.get("code1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().withdrawToSignetPreviewPopup()
					.authyComponent().successFailureComponent();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDDeleteSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnSignetAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickDeleteSignetAccount(data.get("signetNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().removePaymentMethodPopup().clickOnRemove();
			tokenAccountPage.withdrawCoyniToUSDPopup().removePaymentMethodPopup().successFailurePopupCardComponent()
					.verifyPaymnetRemovedSuccessfulHeading();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDAddSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnSignetAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().clickAddNewSignetAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().addNewSignetAccountPopup()
					.fillName(data.get("newCogentAccount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().addNewSignetAccountPopup()
					.fillSignetWalletId(data.get("walletID"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().addNewSignetAccountPopup()
					.mailingAddressComponent().fillAddress1(data.get("addressLine1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().addNewSignetAccountPopup()
					.mailingAddressComponent().fillAddress2(data.get("addressLine2"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().addNewSignetAccountPopup()
					.mailingAddressComponent().fillCity(data.get("city1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().addNewSignetAccountPopup()
					.mailingAddressComponent().selectState(data.get("state1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().addNewSignetAccountPopup()
					.mailingAddressComponent().fillZipCode(data.get("zipCode"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().addNewSignetAccountPopup()
					.clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDSignetAccountInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnSignetAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup()
					.clickSignet(data.get("signetNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().enterAmount(data.get("amount"));
			Thread.sleep(5000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup().clickCoyniConvertion();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToSignetAccountPopup()
					.enterMessage(data.get("description"));

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithNoDebitCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyHeading(data.get("Heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyNoDebitCardsExistLbl();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyNoDebitCardsExistLbl();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickAddNewDebitCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyNoDebitCardsExistLbl();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.verifyHeading(data.get("Heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.fillNameOnCard(data.get("cardName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.fillCardNumber(data.get("cardNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.fillCardExpiry(data.get("cardExpiry"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.fillCardCVVorCVC(data.get("cardCVV"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.fillBillingAddress1(data.get("billingAddress1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.fillBillingAddress2(data.get("billingAddress2"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.fillCity(data.get("city"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.verifyStateDrpDwn();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.fillZipCode(data.get("zipCode"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.verifyCountryTxtField();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.cardAddedSuccessfullyPopup().verifyHeading(data.get("cardAddedSuccessfullyHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.cardAddedSuccessfullyPopup().verifyDescription();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().addNewDebitCardPopup()
					.cardAddedSuccessfullyPopup().verifyWithdrawCoyniBtn();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithNoDebitCards failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickDebitCard(data.get("number"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
//			String processingFee = tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.processingFeeComponent().getTotalProcessingFee(data.get("amount"));
//			String totalAmount = new ProcessingFeeComponent().getTotalAmount(data.get("amount"));
			Thread.sleep(3000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickTab();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyOrderPreviewForWithdraw();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup().clickConfirm();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyHeading(data.get("authyVerificationHeading"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().authyComponent()
					.fillInput(data.get("code1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.successFailurePopupCardComponent().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawToUSDViaInstantPay failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithInvalidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickDebitCard(data.get("number"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			Thread.sleep(3000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickTab();

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayAddDebitCardWithInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyHeading(data.get("Heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyNoDebitCardsExistLbl();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyNoDebitCardsExistLbl();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickAddNewDebitCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().validateTextFields();

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithInvalidDetails failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithNavigationOptions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().navigationComponent().clickBack();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.clickDebitCard(data.get("last4digits"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyOrderPreviewForWithdraw();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.navigationComponent().clickBack();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			Thread.sleep(3000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.navigationComponent().clickClose();
			tokenAccountPage.verifyLabelYourTokenAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithNavigationOptions failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithAddNewDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			merchantSettingTest.testAddCard(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithAddNewDebitCard failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawViaInstantPayEditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickEdit(data.get("number"));
			Thread.sleep(2000);
			merchantSettingTest.testEditDebitCard(strParams);

		} catch (Exception e) {

			ExtentTestManager
					.setFailMessageInReport("testWithdrawViaInstantPayEditCard Failed due to this Exception" + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawViaInstantPayDeleteCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			merchantSettingTest.testDeleteCard(strParams);

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" testWithdrawViaInstantPayDeleteCard failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithDebitCardFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			Thread.sleep(2000);
			merchantSettingTest.testCardsFieldValidations(strParams, "Debit");

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithDebitCardFieldValidations failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayAddDebritCardWithinvailddata(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			Thread.sleep(2000);
			Thread.sleep(2000);
			merchantSettingTest.testAddCardWihInvalidData(strParams, "Debit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithDebitCardFieldValidations failed due to exception " + e);
		}

	}

//
	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayInvalidVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickDebitCard(data.get("number"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickTab();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickTab();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyOrderPreviewForWithdraw();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup().clickConfirm();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyHeading(data.get("authyVerificationHeading"));

			if (!data.get("code1").isEmpty()) {
				tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().authyComponent()
						.fillAuthyInputInvalid(data.get("code1"), data.get("char"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayInvalidVerificationCode failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyCoyniTokenDebitCardFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("expBuyCoyniTokenHeading"));
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenDescription(data.get("buyCoyniTokenDescrp"));
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().verifyAddNewPaymentMethodHeading();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().clickDebitCard();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
					.validateNameOnCard(data.get("cardName"));
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
					.validateCardNumber(data.get("cardNumber"));
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
					.validateCardExpiry(data.get("cardExpiry"));
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
					.validateCVVorCVC(data.get("cardCVV"));
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
					.mailingAddressComponent().validateAddress1(data.get("addressLine1"));
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
					.mailingAddressComponent().validateAddress1(data.get("addressLine2"));
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
					.mailingAddressComponent().validateCity(data.get("city"));
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
					.mailingAddressComponent().validateZipCode(data.get("zipCode"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testBuyCoyniTokenDebitCardFieldValidations failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDGiftCardWithAmazon(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().enterSearckey(data.get("searchKey"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnAmazon();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnPurchase();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
					.verifyHeading1(data.get("authyHeading1"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
					.fillInput(data.get("code"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
					.verifySuccessHeading(data.get("successHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickCopy();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickDone();

		} catch (

		Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test withdrawn gift card Transaction  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDGiftCardWithVisa(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().enterSearckey(data.get("searchKey1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnVisa();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnPurchase();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
					.verifyHeading1(data.get("authyHeading1"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
					.fillInput(data.get("code"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
					.verifySuccessHeading(data.get("successHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickCopy();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickDone();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test withdrawn gift card Transaction  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDAmazonInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().enterSearckey(data.get("searchKey"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnAmazon();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawToUSDGiftCardInvalid failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDVisaInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().enterSearckey(data.get("searchKey1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnVisa();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawToUSDGiftCardInvalid failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDNavigationOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.navigationComponent().clickClose();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			tokenAccountPage.navigationComponent().clickBack();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnAmazon();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));
			tokenAccountPage.navigationComponent().clickBack();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnAmazon();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnPurchase();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
					.verifyHeading1(data.get("authyHeading1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
					.verifySuccessHeading(data.get("successHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickCopy();
			tokenAccountPage.navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" testWithdrawToUSDNavigationOption  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawCoyniToUSDView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyBtns();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawCoyniToUSDView failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			Thread.sleep(5000);
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickAddNewBankAccountBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.fillRoutingNumber(data.get("routingNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.fillConfirmRoutingNumber(data.get("confirmRoutingNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.fillAccountNumber(data.get("accountNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.fillConfirmAccountNumber(data.get("confirmAccountNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup().clickAdd();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.bankAccountAddedPopup().clickWithdraw();
			Thread.sleep(4000);
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDAddExternalBankAccount failed due to this exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDExternalBankAccountView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup()
					.verifyHeading(data.get("externalBankHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup()
					.verifyDescription(data.get("externalBankDescription"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickBank2RadioBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickNextBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyDailyLimitMsg();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyAmountTxtField();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyCoyniIcon();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyCoyniConvertion();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyAvailableBalncLabel();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyCoyniToDollar();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyLblBank();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyTxtMsgField();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickTxtMsgField(data.get("message"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyTxtFieldPlaceHolder();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifylblMsgTransaction();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyNextBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.getAmount();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyLblBank();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyTransactions();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWithdrawToUSDExternalBankAccountView failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup()
					.verifyHeading(data.get("externalBankHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup()
					.verifyDescription(data.get("externalBankDescription"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickBank2RadioBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickNextBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickTxtMsgField(data.get("message"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.getAmount();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickConfirm();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().authyComponent().fillInput(data.get("code"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().transactionInProgessPopup().clickDone();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test withdrawn External Bank Transaction  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDExternalBankAccountInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			Thread.sleep(5000);
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickBank(data.get("number"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickNextBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickAmount(data.get("amount"));
			Thread.sleep(5000);
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickCoyniConvertion();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickTxtMsgField(data.get("message"));

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDExternalBankAccountInvalidAmount  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDRemoveExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			Thread.sleep(5000);
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickDelete(data.get("number"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().removePaymentMethodPopup()
					.clickOnRemove();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWithdrawToUSDRemoveExternalBankAccount  failed due to exception " + e);
		}
	}

}