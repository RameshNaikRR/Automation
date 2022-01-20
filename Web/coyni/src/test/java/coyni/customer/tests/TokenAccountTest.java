package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.components.TokenAccountActivityComponent;
import coyni.customer.pages.LoginPage;
import coyni.customer.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenAccountTest {
	TokenAccountPage tokenAccountPage;
	LoginPage loginPage;
	TokenAccountActivityComponent tokenAccountActivityComponent;

	@BeforeTest
	public void init() {
		tokenAccountPage = new TokenAccountPage();
		loginPage = new LoginPage();
		tokenAccountActivityComponent = new TokenAccountActivityComponent();
	}

	@Test
	public void testAvailableBalance() throws InterruptedException {
		try {
			tokenAccountPage.clickTokenAccount();
			Thread.sleep(2000);
			tokenAccountPage.verifyAmount();
			ExtentTestManager.setInfoMessageInReport(
					"Available balance is displayed as " + tokenAccountPage.getAvailableBalance());

		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testAvailableBalance is failed due to exception " + e);
		}
	}

	@Test
	public void testPayAndRequestTokens() throws InterruptedException {
		try {
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.verifyPay();
		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testPayAnRequestTokens is failed due to exception " + e);
		}
	}

	@Test
	public void testBuyTokens() throws InterruptedException {
		try {
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokens is failed due to exception " + e);
		}
	}

	@Test
	public void testWithdrawToUSD() throws InterruptedException {
		try {
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickWithdrawToUSD();
		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawToUSD is failed due to exception " + e);
		}

	}

	@Test
	public void testPaidOrders() {
		try {
			tokenAccountPage.clickTokenAccount();
			ExtentTestManager.setInfoMessageInReport(
					"Paid orders " + tokenAccountPage.tokenAccountActivityComponent().getPaidOrders());
			tokenAccountPage.tokenAccountActivityComponent().clickPaidOrdersDetails();
		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("test paid orders failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionSentDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensSentDetails();
			// tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent().getTokensSent();
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent().daysMonthsDropDownComponent()
					.clickTodayTokensSent();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryToday"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent().daysMonthsDropDownComponent()
					.clickYesterdayTokensSent();
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryYesterday"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());
			// tokenAccountPage.tokenAccountActivityComponent().verifyPaginations();
			// tokenAccountPage.tokenAccountActivityComponent().clickOnPages();

			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent().daysMonthsDropDownComponent()
					.clickLast7DaysTokensSent();
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryLast7Days"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent().daysMonthsDropDownComponent()
					.clickMonthToDateTokenSent();
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryMonthToDate"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent().daysMonthsDropDownComponent()
					.clickLastMonthTokensSent();
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryLastMonth"));
			// tokenAccountPage.tokenAccountActivityComponent().verifyPageNumbersWithCount();
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());
//			tokenAccountPage.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"),
//					data.get("expColor"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionSentDetailsList is failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testCustomDateRangeSentTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensSentDetails();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent()
					.clickCustomDateRangeTokensSent();
			Thread.sleep(2000);
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent()
					.setDateWithYear(data.get("startDate"));
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("endDate"));
			// verify CustomDateRange

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCustomDateRangeSentTransaction is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionReceiveDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensReceivedDetails();
			// tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent().getTokensReceived();
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayTokensReceive();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.verifyLabelReceiveTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryToday"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayTokensReceive();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.verifyLabelReceiveTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryYesterday"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysTokensReceive();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.verifyLabelReceiveTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryLast7Days"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDateTokensReceive();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.verifyLabelReceiveTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryMonthToDate"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthTokensReceive();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.verifyLabelReceiveTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryLastMonth"));
			// tokenAccountPage.tokenAccountActivityComponent().verifyPageNumbersWithCount();
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());
//			tokenAccountPage.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"),
//					data.get("expColor"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testTransactionReceiveDetailsList is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCustomDateRangeReceiveTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensReceivedDetails();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent()
					.clickCustomDateRangeTokensReceive();
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent()
					.setDateWithYear(data.get("startDate"));
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("endDate"));
			// verify CustomDateRange

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCustomDateRangeReceiveTransaction is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionPurchasedDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensPurchasedDetails();
			// tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent().getTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayTokensPurchased();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryToday"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryYesterday"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());
			// tokenAccountPage.tokenAccountActivityComponent().verifyPaginations();
			// tokenAccountPage.tokenAccountActivityComponent().clickOnPages();

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryLast7Days"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDateTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryMonthToDate"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryLastMonth"));
			// tokenAccountPage.tokenAccountActivityComponent().verifyPageNumbersWithCount();
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());
//			tokenAccountPage.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"),
//					data.get("expColor"));

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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryToday"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryYesterday"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());
			// tokenAccountPage.tokenAccountActivityComponent().verifyPaginations();
			// tokenAccountPage.tokenAccountActivityComponent().clickOnPages();

			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryLast7Days"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDateTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryMonthToDate"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("queryLastMonth"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			// tokenAccountPage.tokenAccountActivityComponent().verifyPageNumbersWithCount();
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());
//			tokenAccountPage.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"),
//					data.get("expColor"));

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
			tokenAccountPage.tokenAccountActivityComponent().clickTokensSentDetails();
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent().getTokensSent();
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensReceivedDetails();
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent().getTokensReceived();
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensPurchasedDetails();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent().getTokensPurchased();
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensWithdrawnDetails();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent().getTokensWithdrawn();
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnToday();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionSentDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionReceivedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionPurchasedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionWithdrawDetailsList();

			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnYesterday();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionSentDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionReceivedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionPurchasedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionWithdrawDetailsList();

			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnLast7Days();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionSentDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionReceivedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionPurchasedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionWithdrawDetailsList();

			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnMonthToDate();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionSentDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionReceivedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionPurchasedDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionWithdrawDetailsList();

			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickOnLastMonth();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionSentDetailsList();
			tokenAccountPage.tokenAccountActivityComponent().getTransactionReceivedDetailsList();
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
			Thread.sleep(5000);
			tokenAccountPage.verifyLabelYourTransactions(data.get("expHeading"));
			tokenAccountPage.verifyAmount();
			ExtentTestManager.setInfoMessageInReport(
					"Available balance is displayed as " + tokenAccountPage.getAvailableBalance());
			tokenAccountPage.verifyLabelTransactionListDetails();
			// tokenAccountPage.verifyLabelPostedTransactions(data.get("expPostedTransactionHeading"));
			// tokenAccountPage.verifyTransactionList();
			tokenAccountPage.verifyTableItemsCount(data.get("query"));
			tokenAccountPage.verifyPostedTransactions(data.get("count"));
			// tokenAccountPage.verifyBracesCount(data.get("query"));
			tokenAccountPage.verifyPageNumbersWithCount();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountPage.getDefaultEntriesPerPage());
			tokenAccountPage.clickDropDownEntriesPage();
			tokenAccountPage.verifyPageNumberHighlighted(data.get("cssProp"), data.get("expValue"),
					data.get("expColor"));
			// tokenAccountPage.getEntryOptions();
			tokenAccountPage.verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport("Entries is displayed as " + tokenAccountPage.getEntriesMessage());
			tokenAccountPage.clickOnPages();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" testTransactionList failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testPayTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.payAndRequestTokensPopup().cursorhoverPayRequest();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			ExtentTestManager.setInfoMessageInReport(
					"Available balance is displayed as " + tokenAccountPage.getAvailableBalance());
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			// tokenAccountPage.payAndRequestTokensPopup().verifyWalletID();
			// tokenAccountPage.payAndRequestTokensPopup().verifyAccountHolderName(data.get("accountHolderName"));
			// tokenAccountPage.payAndRequestTokensPopup().verifyCountMessageToRecipient();
			Thread.sleep(2000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().verifyAmount();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().verifyProcessingFee();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.verifyHeading(data.get("authyPayHeading"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent()
//					.verifyMessage(data.get("message"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().verifyHeading(data.get("successFailureHeading"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().verifyImage();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().verifyMessge(data.get("successMessage"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().verifyReferenceID();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().verifyAccountBalance();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickOnCopyLink();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().clickDone();
			tokenAccountPage.payAndRequestTokensPopup().verifyLabelYourTokenAccount();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayTransaction failed due to exception " + e);
		}
	}

	@Test // added P
	public void testViewPayTransaction() {
		try {
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.payAndRequestTokensPopup().cursorhoverPayRequest();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().verifyAmountView();
			tokenAccountPage.payAndRequestTokensPopup().verifyRecipientsAddressView();
			tokenAccountPage.payAndRequestTokensPopup().verifyMessageToRecipientView();
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountBalanceView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyCloseView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testViewPayTransaction failed due to exception " + e);
		}

	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testPayTransactionsWithInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.payAndRequestTokensPopup().cursorhoverPayRequest();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			Thread.sleep(2000);
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testPayTransactionsWithInvalidAmount failed due to Invalid Amount exception " + e);
		}
	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testPayTransactionsWithInvalidAccountAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.payAndRequestTokensPopup().cursorhoverPayRequest();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			Thread.sleep(2000);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testPayTransactionsWithInvalidAccountAddress failed due to  exception " + e);
		}
	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testPayWithInvalidVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountBalanceView();
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			Thread.sleep(2000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.verifyHeading(data.get("authyPayHeading"));
			// loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
			if (!data.get("code").isEmpty()) {
				loginPage.authyComponent().fillAuthyInputInvalid(data.get("code"), data.get("char"));
			}
			if (!data.get("errMessage").isEmpty()) {
				loginPage.authyComponent().verifyMessage(data.get("errMessage"));

			}

			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayWithInvalidVerificationCode failed due to exception " + e);
		}
	}

	@Test // added P
	@Parameters({ "strParams" })
	//
	public void testPayNavigationIcon(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickTokenAccount();
			// tokenAccountPage.payAndRequestTokensPopup().verifycolor(data.get("color"));
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountBalanceView();
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			Thread.sleep(2000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			// tokenAccountPage.payAndRequestTokensPopup().verifyAmountView();
			// tokenAccountPage.payAndRequestTokensPopup().verifyPayingRecipient();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyBackView();
			// tokenAccountPage.payAndRequestTokensPopup().verifycursorCrossIcon();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickClose();
			tokenAccountPage.payAndRequestTokensPopup().verifyLabelYourTokenAccount();
			// tokenAccountPage.payAndRequestTokensPopup().verifyBackIconView();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayNavigationIcon failed due to exception " + e);
		}

	}

	@Test // added P
	@Parameters({ "strParams" })
	//
	public void testPayNavigations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountBalanceView();
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			Thread.sleep(5000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();

			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyBackView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyCloseView();
			// tokenAccountPage.payAndRequestTokensPopup().verifyCrossIconView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickBack();
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickClose();
			tokenAccountPage.payAndRequestTokensPopup().verifyLabelYourTokenAccount();
			//

			Thread.sleep(3000);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountBalanceView();
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			Thread.sleep(5000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();

			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.verifyHeading(data.get("authyPayHeading"));
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyBackView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyCloseView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickBack();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().verifyAmount();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickPay();
			// tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().getProcessingFee();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickClose();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayNavigations failed due to exception " + e);
		}

	}

//	@Test // added P
//	@Parameters({ "strParams" })
//	public void testNoFundsAvailable(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickTokenAccount();
//			tokenAccountPage.clickPayRequestToken();
//			tokenAccountPage.payAndRequestTokensPopup().isFundsDisplayed("noFundsAvailable");
//			tokenAccountPage.payAndRequestTokensPopup().clickBuyToken();
//			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyCloseView();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testNoFundsAvailable failed due to  exception " + e);
//		}
//	}
//
//	// DOUBT --
//	@Test // added P
//	@Parameters({ "strParams" })
//	public void testTryAgain(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickPayRequestToken();
//			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
//			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
//			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
//			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
//			tokenAccountPage.payAndRequestTokensPopup().clickNext();
//
//			//
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickPay();
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().verifyAmount();
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().verifyProcessingFee();
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
//					.verifyHeading(data.get("authyPayHeading"));
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent()
//					.fillAuthyInput(data.get("securityKey"));
//
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
//					.successFailurePopupCardComponent()
//					.verifyTransactionFailedHeading(data.get("successFailureHeading"));
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
//					.successFailurePopupCardComponent().verifyLabelFailedMessage();
////			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
////					.successFailurePopupCardComponent().verifyImage();
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
//					.successFailurePopupCardComponent().clickTryAgain();
//
//			Thread.sleep(3000);
//			tokenAccountPage.payAndRequestTokensPopup().viewPay();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testTryAgain failed due to exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.payAndRequestTokensPopup().cursorhoverPayRequest();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			// tokenAccountPage.payAndRequestTokensPopup().verifyAccountHolderName(data.get("accountHolderName"));
			Thread.sleep(1000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			tokenAccountPage.payAndRequestTokensPopup().clickCopy();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup()
					.successFailurePopupCardComponent().verifyRequestHeading(data.get("successFailureHeading"));
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup()
					.successFailurePopupCardComponent().verifyImageRequest();
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup()
					.successFailurePopupCardComponent().clickDone();
			tokenAccountPage.payAndRequestTokensPopup().verifyLabelYourTokenAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestTransaction failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testRequestTransactionsWithValidations(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickTokenAccount();
//			tokenAccountPage.payAndRequestTokensPopup().cursorhoverPayRequest();
//			tokenAccountPage.clickPayRequestToken();
//			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
//			String[] amount = data.get("amount").split(",");
//			tokenAccountPage.payAndRequestTokensPopup().validateAmountField(amount[0], amount[1]);
//			ExtentTestManager.setPassMessageInReport("Amount field is not accepting special characters and characters");
//			String[] message = data.get("messageToRecipient").split(",");
//			tokenAccountPage.payAndRequestTokensPopup().validateRecipientField(message[0], message[1]);
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testPayTransaction failed due to Invalid Amount exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestTransactionsWithInvalidAccountAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.payAndRequestTokensPopup().cursorhoverPayRequest();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("messageToRecipient"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testRequestTransactionsWithInvalidAccountAddress failed due to Invalid Recipient Address exception "
							+ e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestTransactionsWithNavigation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.payAndRequestTokensPopup().cursorhoverPayRequest();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyCloseView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickClose();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("messageToRecipient"));
			Thread.sleep(1000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyBackView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickBack();
			tokenAccountPage.payAndRequestTokensPopup().viewAmount();
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyCloseView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickClose();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("messageToRecipient"));
			Thread.sleep(1000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyCloseView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testRequestTransactionsWithNavigation failed due to Back and cross Icon exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickBank();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("Amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.transactionInProgessPopup().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test Buy Token Transaction with bank account failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickCredit();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("Amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.transactionInProgessPopup().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					" test Buy Token Transaction with credit card failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickDebit();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("Amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.transactionInProgessPopup().clickDone();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test Buy Token Transaction with debit card failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.clickDebitCard(data.get("last4digits"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
//			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as "
//					+ tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().getDailyLimit());
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			Thread.sleep(3000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyLabelDebitCardView();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.getPaymentItems(data.get("last4digits"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay()
//					.verifyToggleBackgroundColor(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnConvertLink();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.enterMessage(data.get("transactionalmessage"));

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyOrderPreviewForWithdraw();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup().clickConfirm();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyHeading(data.get("authyVerificationHeading"));
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().orderPreviewPopup().verifyAuthy();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().orderPreviewPopup()
//					.verifyHeading(data.get("expTransactionInProgressHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.successFailurePopupCardComponent().verifyReferenceID();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.successFailurePopupCardComponent().clickDone();
			tokenAccountPage.verifyLabelYourTokenAccount();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawToUSDViaInstantPay failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithInvalidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.clickDebitCard(data.get("last4digits"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
//			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as "
//					+ tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().getDailyLimit());
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyLabelDebitCardView();
			Thread.sleep(4000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.txtMessage(data.get("transactionalmessage"));

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyErrorMessage();

//			if (!data.get("errMessage").isEmpty()) {
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
//			}

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
//			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawBackgroundcolor(data.get("cssProp"),
//					data.get("expValue"), data.get("expColor"));
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().verifyInstantPayDebitCardBackgroundcolor(
//					data.get("cssProp"), data.get("expValue"), data.get("expColor"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().navigationComponent().clickBack();
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().verifyDebitCardFlow();

			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.clickDebitCard(data.get("last4digits"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnDebitCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
//			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as " + tokenAccountPage
//					.withdrawCoyniToUSDPopup().withdrawViaInstantPay().accountLimitsComponent().getInstantPay());
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyLabelDebitCardView();
//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay()
//					.verifyToggleBackgroundColor(data.get("cssProp"), data.get("expValue"), data.get("expColor"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnConvertLink();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.enterMessage(data.get("transactionalmessage"));

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyOrderPreviewForWithdraw();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.navigationComponent().clickBack();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			Thread.sleep(3000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.enterMessage(data.get("transactionalmessage"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();

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
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnAddNewDebitCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyAddNewDebitCard(
					data.get("cardName"), data.get("cardNumber"), data.get("cardExpiry"), data.get("cardCVV"),
					data.get("addressLine1"), data.get("addressLine2"), data.get("city"), data.get("state"),
					data.get("zipCode"), data.get("country"));

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().preAuthorizationPopup()
					.fillAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().preAuthorizationPopup()
					.clickOnVerify();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodEditSuccessfullyPopup()
					.clickWithdrawCoyni();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));

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
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnEdit();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyEditDebitCard(
					data.get("cardName"), data.get("cardExpiry"), data.get("addressLine1"), data.get("addressLine2"),
					data.get("city"), data.get("state"), data.get("zipCode"), data.get("country"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().navigationComponent().clickBack();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnEdit();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyEditDebitCard(
					data.get("cardName"), data.get("cardExpiry"), data.get("addressLine1"), data.get("addressLine2"),
					data.get("city"), data.get("state"), data.get("zipCode"), data.get("country"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().navigationComponent().clickClose();

			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnEdit();
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyEditDebitCard(
					data.get("cardName"), data.get("cardExpiry"), data.get("addressLine1"), data.get("addressLine2"),
					data.get("city"), data.get("state"), data.get("zipCode"), data.get("country"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().mailingAddressComponent()
					.clickSave();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodEditSuccessfullyPopup()
					.verifyHeading(data.get("paymentEditedHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodEditSuccessfullyPopup()
					.clickWithdrawCoyni();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));

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
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().navigationComponent().clickBack();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().navigationComponent().clickClose();

			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnDelete();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().removePaymentMethodPopup()
					.clickOnRemove();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().removePaymentMethodPopup()
					.getRemoveMessage();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().removePaymentMethodPopup()
					.clickWithdrawCoyni();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));

//			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().removePaymentMethodPopup()
//					.navigationComponent().clickClose();

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
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnAddNewDebitCard();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodsComponent()
					.addNewPaymentMethodPopup().addCardComponent().validateNameOnCard(data.get("cardName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodsComponent()
					.addNewPaymentMethodPopup().addCardComponent().validateCardNumber(data.get("cardNumber"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodsComponent()
					.addNewPaymentMethodPopup().addCardComponent().validateCardExpiry(data.get("cardExpiry"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodsComponent()
					.addNewPaymentMethodPopup().addCardComponent().validateCVVorCVC(data.get("cardCVV"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodsComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.validateAddress1(data.get("addressLine1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodsComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.validateAddress1(data.get("addressLine2"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodsComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.validateCity(data.get("city"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().paymentMethodsComponent()
					.addNewPaymentMethodPopup().addCardComponent().mailingAddressComponent()
					.validateZipCode(data.get("zipCode"));

//			if (!data.get("errMessage").isEmpty()) {
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
//						data.get("elementName"));
//			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithDebitCardFieldValidations failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayInvalidVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.clickDebitCard(data.get("last4digits"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
//			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as "
//					+ tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().getDailyLimit());
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			Thread.sleep(3000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyLabelDebitCardView();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnConvertLink();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.enterMessage(data.get("transactionalmessage"));

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();

			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyOrderPreviewForWithdraw();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup().clickConfirm();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup()
					.verifyHeading(data.get("authyVerificationHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().orderPreviewPopup().authyComponent()
					.fillAuthyInputInvalid(data.get("code"), data.get("character"));

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
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addNewDebitCardPopup()
					.verifyAddNewDebitCardHeading(data.get("expHeading"));
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
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithDebitCardFieldValidations failed due to exception " + e);
		}

	}

	public void testWithdrawToUSDGiftCard(String strParams, String giftCard) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().cursorhoverWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			if (giftCard.equalsIgnoreCase("Amazon")) {
				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().enterSearckey(data.get("searchKey"));
				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnAmazon();
			} else {
				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
						.enterSearckey(data.get("searchKey1"));
				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnVisa();
			}
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
					.verifyHeadingOrderPreview(data.get("orderHeading"));

			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnPurchase();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
					.verifyHeading1(data.get("authyHeading1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
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
	public void testWithdrawToUSDGiftCardWithAmazon(String strParams) {
		testWithdrawToUSDGiftCard(strParams, "Amazon");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDGiftCardWithVisa(String strParams) {
		testWithdrawToUSDGiftCard(strParams, "Visa");
	}

	public void testWithdrawToUSD(String strParams, String giftCard) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().cursorhoverWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			if (giftCard.equalsIgnoreCase("Amazon")) {
				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnAmazon();
			} else {
				tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnVisa();
			}
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email1"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnPurchase();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test withdrawn gift card Transaction  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDAmazonInvalidData(String strParams) {
		testWithdrawToUSD(strParams, "Amazon");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDVisaInvalidData(String strParams) {
		testWithdrawToUSD(strParams, "Visa");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDNavigationOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.navigationComponent().clickClose();
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
//			tokenAccountPage.navigationComponent().clickClose();
//			Thread.sleep(2000);
//			tokenAccountPage.clickWithdrawToUSD();
////			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			tokenAccountPage.navigationComponent().clickBack();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			// tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnAmazon();
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
					.verifyHeadingOrderPreview(data.get("orderHeading"));
			tokenAccountPage.navigationComponent().clickBack();
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
//			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnGiftCard();
			// tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().clickOnAmazon();
			// tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().verifyHeading(data.get("giftHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillFirstName(data.get("firstName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillLastName(data.get("lastName"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillEmail(data.get("email"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().fillAmount(data.get("amount"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup()
					.verifyHeadingOrderPreview(data.get("orderHeading"));
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
					.setFailMessageInReport(" test withdrawn gift card Transaction  failed due to exception " + e);
		}
	}

}
