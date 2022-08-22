package coyni.merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.components.TokenAccountActivityComponent;
import coyni.merchant.pages.ExportfilesPage;
import coyni.merchant.pages.GetHelpPage;
import coyni.merchant.pages.LoginPage;
import coyni.merchant.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenAccountTest {
	TokenAccountPage tokenAccountPage;
	LoginPage loginPage;
	GetHelpPage getHelpPage;
	ExportfilesPage exportfilesPage;
	TokenAccountActivityComponent tokenAccountActivityComponent;
	MerchantSettingsTest merchantSettingTest;
	SideMenuBarComponent sideMenuBarComponent;

	@BeforeTest
	public void init() {
		tokenAccountPage = new TokenAccountPage();
		loginPage = new LoginPage();
		getHelpPage = new GetHelpPage();
		exportfilesPage = new ExportfilesPage();
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
			tokenAccountPage.tokenAccountActivityComponent().exportfilesPage().exportSelectedTransactionsPopup()
					.verifyHeading(data.get("heading"));
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
			// tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent().getTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayPayOutsReceived();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testTodayTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testYesterDayTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testLast7DaysTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDatePayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));

			testMonthToDateTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testLastMonthTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

//					

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
			// tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent().getTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayTokensPurchased();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testTodayTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testYesterDayTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testLast7DaysTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDateTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));

			testMonthToDateTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testLastMonthTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

//					

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
			// tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent().getTokensWithdrawn();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayTokensWithdraw();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testTodayTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testYesterDayTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testLast7DaysTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDateTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testMonthToDateTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testLastMonthTrasactions(strParams, "date");
			exports(strParams);
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

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
			// verify CustomDateRange

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
			// tokenAccountPage.tokenAccountActivityComponent().clickTokensPurchasedDetails();
			// tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent().getTokensPurchased();
			// tokenAccountPage.clickTokenAccount();
			// tokenAccountPage.tokenAccountActivityComponent().clickTokensWithdrawnDetails();
			// tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent().getTokensWithdrawn();
			// tokenAccountPage.clickTokenAccount();
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
			// tokenAccountPage.verifyLabelYourTransactions(data.get("expHeading"));
			tokenAccountPage.verifyAmount();
			ExtentTestManager.setInfoMessageInReport(
					"Available balance is displayed as " + tokenAccountPage.getAvailableBalance());
			tokenAccountPage.verifyLabelTransactionListDetails();
			tokenAccountPage.verifyTableItemsCount(data.get("query"));
			tokenAccountPage.verifyPageNumbersWithCount();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountPage.getDefaultEntriesPerPage());
			tokenAccountPage.clickDropDownEntriesPage();
//			tokenAccountPage.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"),
//					data.get("expColor"));
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
			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickOnExport();
			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().verifyTitle(data.get("heading"));
			Thread.sleep(2000);
			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickExportPage();
			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().clickClose();
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

	public void testFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.filterComponent().clickFilters();
//			tokenAccountPage.filterComponent().clickStartDate();
//			tokenAccountPage.filterComponent().datePickerComponent().setDate(data.get("startdate"));
//			tokenAccountPage.filterComponent().datePickerComponent().setDate(data.get("enddate"));
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType"));
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType1"));
			tokenAccountPage.filterComponent().fillFromAmount(data.get("amount"));
			tokenAccountPage.filterComponent().fillToAmount(data.get("toAmount"));
			tokenAccountPage.filterComponent().selectFilter(data.get("filterType2"));
			tokenAccountPage.filterComponent().clickApplyFilters();

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
//			tokenAccountPage.transactionDetailsComponent().getCreatedDate();

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
			tokenAccountPage.transactionDetailsComponent().getTransactionType();
			tokenAccountPage.transactionDetailsComponent().getReferenceID();
			tokenAccountPage.transactionDetailsComponent().getCreatedDate();

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
//			tokenAccountPage.transactionDetailsComponent().getReferenceID();
//			tokenAccountPage.transactionDetailsComponent().getCreatedDate();

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
//			tokenAccountPage.transactionDetailsComponent().getReferenceID();
//			tokenAccountPage.transactionDetailsComponent().getCreatedDate();

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
//			tokenAccountPage.transactionDetailsComponent().getReferenceID();
//			tokenAccountPage.transactionDetailsComponent().getCreatedDate();

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
//			tokenAccountPage.transactionDetailsComponent().getReferenceID();
//			tokenAccountPage.transactionDetailsComponent().getCreatedDate();

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
//			tokenAccountPage.transactionDetailsComponent().getReferenceID();
//			tokenAccountPage.transactionDetailsComponent().getCreatedDate();

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
//			tokenAccountPage.transactionDetailsComponent().getReferenceID();
//			tokenAccountPage.transactionDetailsComponent().getCreatedDate();

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
//				merchantSettingTest.testAddExternalBankAccount(strParams);
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
			tokenAccountPage.clickBuyTokens();
			// tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
			Thread.sleep(3000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickOutSIde();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.verifyOrderViewHeading();
			// tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().orderPreviewBuyTokenWithBankView();
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
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().verifyBuyCoyniTokenHeading(data.get(""));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickBank();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup()
					.verifyBuyCoyniTokenHeading(data.get(""));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get(""));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test Buy Token Transaction with bank account failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenViewWithOutPaymentMethods(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
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
			// tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().navigationComponent().clickClose();
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
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			merchantSettingsTest.testAddExternalBankAccount(strParams);
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDeleteBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("heading"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
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
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickOutSIde();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.verifyOrderViewHeading();
			// tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().orderPreviewBuyTokenWithBankView();
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
	public void testBuyTokenAddSignet(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			MerchantSettingsTest merchantSettingsTest = new MerchantSettingsTest();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().clickAddSignetAccount();
			merchantSettingsTest.testaddSignet(strParams);
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionSignetAccountWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
			;
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
	public void testRemoveSignetAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
//			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickSignet();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickDelete(data.get("number"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup().clickOnRemove();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);

		}
	}

//	public void testWithdrawToSignetAccount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			System.out.println("--------------------------------------");
//			// tokenAccountPage.clickWithdrawToSignet();
//			tokenAccountPage.withdrawToSignetPopup().verifyPageHeading();
//			tokenAccountPage.withdrawToSignetPopup().fillAmount(data.get("amount"));
//			tokenAccountPage.withdrawToSignetPopup().getAvailableBalance();
//			tokenAccountPage.withdrawToSignetPopup().fillMessage(data.get("description"));
//			tokenAccountPage.withdrawToSignetPopup().clickNext();
//			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup()
//					.verifyPageHeading(data.get("withdrawToSignetPreviewHeading"));
//			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().verifyAmount();
//			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().getWithdrawAmount();
//			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().getProcessingFee();
//			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().getTotal();
//			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().clickConfirm();
//			// tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().authyComponent().verifyPageHeading(data.get("authyHeading1"));
//			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().authyComponent()
//					.fillInput(data.get("code"));
//			tokenAccountPage.withdrawToSignetPopup().withdrawToSignetPreviewPopup().authyComponent()
//					.successFailureComponent();
//			Thread.sleep(2000);
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//
//		}
//	}

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
					.clickStates();
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
	public void testWithdrawToUSDViaInstantPayDeleteDebitCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideMenuBarComponent.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().chooseYourInstantPaySourcePopup()
					.verifyDescription(data.get("description"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().chooseYourInstantPaySourcePopup()
					.clickDelete();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().chooseYourInstantPaySourcePopup()
					.removePaymentMethodPopup().verifyHeading(data.get("removePaymentPopupHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().chooseYourInstantPaySourcePopup()
					.removePaymentMethodPopup().clickOnRemove();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().chooseYourInstantPaySourcePopup()
					.removePaymentMethodPopup().paymentMethodRemovesdSuccessfullyPopup()
					.verifyHeading(data.get("paymentMethodRemovesdSuccessfullyHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().chooseYourInstantPaySourcePopup()
					.removePaymentMethodPopup().paymentMethodRemovesdSuccessfullyPopup().clickWithdrawCoyniBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().chooseYourInstantPaySourcePopup()
					.removePaymentMethodPopup().paymentMethodRemovesdSuccessfullyPopup().withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("heading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithNoDebitCards failed due to exception " + e);
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
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDViaInstantPayWithNavigationOptions(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
////			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawBackgroundcolor(data.get("cssProp"),
////					data.get("expValue"), data.get("expColor"));
//			tokenAccountPage.clickWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup()
//					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
////			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().verifyInstantPayDebitCardBackgroundcolor(
////					data.get("cssProp"), data.get("expValue"), data.get("expColor"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.verifyLabelHeading(data.get("instantPayHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().navigationComponent().clickBack();
//			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().verifyDebitCardFlow();
//
//			// tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
//			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//			// .verifyLabelHeading(data.get("instantPayHeading"));
//
//			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//			// .clickDebitCard(data.get("last4digits"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnDebitCard();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.verifyLabelHeading(data.get("instantPayHeading"));
////			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as " + tokenAccountPage
////					.withdrawCoyniToUSDPopup().withdrawViaInstantPay().accountLimitsComponent().getInstantPay());
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyLabelDebitCardView();
////			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay()
////					.verifyToggleBackgroundColor(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnConvertLink();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.enterMessage(data.get("transactionalmessage"));
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
//					.verifyOrderPreviewForWithdraw();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
//					.navigationComponent().clickBack();
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
//			Thread.sleep(3000);
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.enterMessage(data.get("transactionalmessage"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
//					.navigationComponent().clickClose();
//			tokenAccountPage.verifyLabelYourTokenAccount();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport(
//					"testWithdrawToUSDViaInstantPayWithNavigationOptions failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDViaInstantPayWithAddNewDebitCard(String strParams) {
//
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup()
//					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.verifyLabelHeading(data.get("instantPayHeading"));
////			merchantSettingTest.testAddCard(strParams, "Debit");
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport(
//					"testWithdrawToUSDViaInstantPayWithAddNewDebitCard failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawViaInstantPayEditCard(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup()
//					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
////			merchantSettingTest.testEditCard(strParams);
//
//		} catch (Exception e) {
//
//			ExtentTestManager
//					.setFailMessageInReport("testWithdrawViaInstantPayEditCard Failed due to this Exception" + e);
//
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawViaInstantPayDeleteCard(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup()
//					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
////			merchantSettingTest.testDeleteCard(strParams);
////			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().removePaymentMethodPopup()
////					.navigationComponent().clickClose();
//
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport(" testWithdrawViaInstantPayDeleteCard failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDViaInstantPayWithDebitCardFieldValidations(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup()
//					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.verifyLabelHeading(data.get("instantPayHeading"));
//			Thread.sleep(2000);
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
////			merchantSettingTest.testCardsFieldValidations(strParams, "Debit");
//
//			/*
//			 * if (!data.get("errMessage").isEmpty()) { new
//			 * CommonFunctions().validateFormErrorMessage(data.get("errMessage"),
//			 * data.get("color"), data.get("elementName")); }
//			 */
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport(
//					"testWithdrawToUSDViaInstantPayWithDebitCardFieldValidations failed due to exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDViaInstantPayAddDebritCardWithinvailddata(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup()
//					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
//			Thread.sleep(2000);
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.verifyLabelHeading(data.get("instantPayHeading"));
//			Thread.sleep(2000);
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
////			merchantSettingTest.testAddCardWihInvalidData(strParams, "Debit");
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport(
//					"testWithdrawToUSDViaInstantPayWithDebitCardFieldValidations failed due to exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDViaInstantPayInvalidVerificationCode(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup()
//					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
//			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.verifyLabelHeading(data.get("instantPayHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
//			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
//
//			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//			// .clickDebitCard(data.get("last4digits"));
//			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//			// .verifyLabelHeading(data.get("instantPayHeading"));
////			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as "
////					+ tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().getDailyLimit());
//			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
//			Thread.sleep(3000);
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyLabelDebitCardView();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnConvertLink();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
//					.enterMessage(data.get("transactionalmessage"));
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
//					.verifyOrderPreviewForWithdraw();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup().clickConfirm();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
//					.verifyHeading(data.get("authyVerificationHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup().authyComponent()
//					.fillAuthyInputInvalid(data.get("code"), data.get("character"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport(
//					"testWithdrawToUSDViaInstantPayInvalidVerificationCode failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBuyCoyniTokenDebitCardFieldValidations(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickBuyTokens();
//			tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("expBuyCoyniTokenHeading"));
//			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
//			tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenDescription(data.get("buyCoyniTokenDescrp"));
//			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().verifyAddNewPaymentMethodHeading();
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().clickDebitCard();
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup()
//					.verifyAddNewDebitCardHeading(data.get("expHeading"));
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
//					.validateNameOnCard(data.get("cardName"));
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
//					.validateCardNumber(data.get("cardNumber"));
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
//					.validateCardExpiry(data.get("cardExpiry"));
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
//					.validateCVVorCVC(data.get("cardCVV"));
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
//					.mailingAddressComponent().validateAddress1(data.get("addressLine1"));
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
//					.mailingAddressComponent().validateAddress1(data.get("addressLine2"));
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
//					.mailingAddressComponent().validateCity(data.get("city"));
//			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup().addCardComponent()
//					.mailingAddressComponent().validateZipCode(data.get("zipCode"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport(
//					"testWithdrawToUSDViaInstantPayWithDebitCardFieldValidations failed due to exception " + e);
//		}
//
//	}
//
//	public void testWithdrawToUSDGiftCard(String strParams, String giftCard) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().cursorhoverWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
//			if (giftCard.equalsIgnoreCase("Amazon")) {
//				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().enterSearckey(data.get("searchKey"));
//				Thread.sleep(1000);
//				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnAmazon();
//			} else {
//				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
//						.enterSearckey(data.get("searchKey1"));
//				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnVisa();
//			}
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
//					.verifyHeadingOrderPreview(data.get("orderHeading"));
//
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnPurchase();
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
//					.verifyHeading1(data.get("authyHeading1"));
//			Thread.sleep(2000);
//			// tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
//			// .fillAuthyInput(data.get("securityKey"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
//					.fillInput(data.get("code"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
//					.verifySuccessHeading(data.get("successHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickCopy();
//			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickDone();
//
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport(" test withdrawn gift card Transaction  failed due to exception " + e);
//		}
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDGiftCardWithAmazon(String strParams) {
//		testWithdrawToUSDGiftCard(strParams, "Amazon");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDGiftCardWithVisa(String strParams) {
//		testWithdrawToUSDGiftCard(strParams, "Visa");
//	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDAmazonInvalidData(String strParams) {
//		testWithdrawToUSD(strParams, "Amazon");
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDVisaInvalidData(String strParams) {
//		testWithdrawToUSD(strParams, "Visa");
//	}

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
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("heading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup()
					.verifyHeading(data.get("externalBankHeading"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup()
					.verifyDescription(data.get("externalBankDescription"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickAddNewBankAccountBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.verifyHeading();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.verifyFiservBankDescription();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.verifyLnkLearnMore();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.clickIamReady();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.verifyHeading();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.verifyDoNotNavigateLbl();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.verifyDescription();
			Thread.sleep(10000);
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.switchToWindow();
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.enterBankName(data.get("bankName"));// CashEdge Test Bank (Agg) - Retail Non 2FA
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.clickOnBankName();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.enterUserName(data.get("bankUserName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.enterPassword(data.get("bankPassword"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup().clickNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().addBankAccountPopup()
					.unSelectBank();
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
					.setFailMessageInReport(" test withdrawn External Bank Transaction  failed due to exception " + e);
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
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.clickConfirm();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().verifyHeading(data.get("verifyYourIdentityHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().verifyDescription();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().verifyMsg();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().authyComponent().fillInput(data.get("code"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().transactionInProgessPopup().verifyHeading(data.get("InProgressHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().transactionInProgessPopup().verifyDescription();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().transactionInProgessPopup().verifyLearnMoreLnk();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
					.verifyYourIdentityPopup().transactionInProgessPopup().verifyAmount();
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
					.verifyErrorMsg(data.get("errMessage"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().withdrawToBankAccountPopUp()
//					.getAmount();
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
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup()
					.verifyHeading(data.get("externalBankHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup()
//					.verifyDescription(data.get("externalBankDescription"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().clickDelete();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().removePaymentMethodPopup()
					.verifyHeading(data.get("removePaymentMethodHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().removePaymentMethodPopup()
					.verifyDescription();
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().removePaymentMethodPopup()
					.verifyBank();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().removePaymentMethodPopup()
					.clickOnRemove();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().removePaymentMethodPopup()
					.paymentMethodRemovesdSuccessfullyPopup().verifyHeading(data.get("paymentMethodRemovedHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().removePaymentMethodPopup()
					.paymentMethodRemovesdSuccessfullyPopup().verifyWithdrawCoyniBtn();
			tokenAccountPage.withdrawCoyniToUSDPopup().chooseYourBankAccountPopup().removePaymentMethodPopup()
					.paymentMethodRemovesdSuccessfullyPopup().clickWithdrawCoyniBtn();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWithdrawToUSDRemoveExternalBankAccount  failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawToUSDRemoveExternalBankAccount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().cursorhoverWithdrawToUSD();
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
////			tokenAccountPage.bankAccountsComponent().clickOnBank(data.get("last4Digits"));
////			tokenAccountPage.bankAccountsComponent().ClickNext();
//			tokenAccountPage.bankAccountsComponent().clickDelete();
//			tokenAccountPage.bankAccountsComponent().verifyRemoveHeading(data.get("removeHeading"));
//			tokenAccountPage.bankAccountsComponent().clickRemove();
//			tokenAccountPage.bankAccountsComponent().removeHeading(data.get("removeHeading1"));
//			tokenAccountPage.bankAccountsComponent().navigationComponent().clickClose();
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport(" test Remove External Bank Transaction  failed due to exception " + e);
//		}
//	}
//

}
