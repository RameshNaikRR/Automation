package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.components.TokenAccountActivityComponent;
import coyni.customer.pages.ExportfilesPage;
import coyni.customer.pages.GetHelpPage;
import coyni.customer.pages.LoginPage;
import coyni.customer.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenAccountTest {
	TokenAccountPage tokenAccountPage;
	LoginPage loginPage;
	GetHelpPage getHelpPage;
	ExportfilesPage exportfilesPage;
	TokenAccountActivityComponent tokenAccountActivityComponent;
    PaymentMethodsTest paymentMethodsTest;
	
	@BeforeTest
	public void init() {
		tokenAccountPage = new TokenAccountPage();
		loginPage = new LoginPage();
		getHelpPage = new GetHelpPage();
		exportfilesPage = new ExportfilesPage();
		tokenAccountActivityComponent = new TokenAccountActivityComponent();
		paymentMethodsTest = new PaymentMethodsTest();
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
	public void testGetHelp(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.clickTokenAccount();
			getHelpPage.clickGetHelp();
			// getHelpPage.view();
			Thread.sleep(3000);
			// getHelpPage.fillFullName(data.get("fullName"));
			getHelpPage.fillAccountIDNumber(data.get("accountID"));
			getHelpPage.fillEmail(data.get("email"));
			getHelpPage.selectCountry(data.get("country"));
			getHelpPage.fillPhoneNumber(data.get("phoneNumber"));
			getHelpPage.selectInquiryType(data.get("inquiryType"));
			getHelpPage.selectdrpDwnCustomertopics(data.get("customerTopics"));
			getHelpPage.fillDetails(data.get("details"));
			// getHelpPage.clickOnFiles();
			getHelpPage.clickOnSubmit();
			getHelpPage.verifyMessage(data.get("getHelpmessage"));
			getHelpPage.clickOnSubmitAgain();
			getHelpPage.verifyHeading(data.get("expHeading"));

		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testGetHelp is failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testGetHelpWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			getHelpPage.clickGetHelp();
			// getHelpPage.view();
			getHelpPage.fillFullName(data.get("fullName"));
			getHelpPage.fillAccountIDNumber(data.get("accountID"));
			getHelpPage.fillEmail(data.get("email"));
			getHelpPage.selectCountry(data.get("country"));
			getHelpPage.fillPhoneNumber(data.get("phoneNumber"));
			getHelpPage.selectInquiryType(data.get("inquiryType"));
			getHelpPage.selectdrpDwnCustomertopics(data.get("customerTopics"));
			getHelpPage.fillDetails(data.get("details"));
			// getHelpPage.clickOnFiles();
			getHelpPage.clickOnSubmit();
			getHelpPage.verifyErrorMessage(data.get("errMessage"));
		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testGetHelpWithInvalidData is failed due to exception " + e);
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
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent()
//					.fillAuthyInput(data.get("securityKey"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent().fillInput(data.get("code"));
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
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
//					.successFailurePopupCardComponent().verifyAccountBalance();
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
			if (!data.get("code1").isEmpty()) {
				loginPage.authyComponent().fillAuthyInputInvalid(data.get("code1"), data.get("char"));
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
			//tokenAccountPage.payAndRequestTokensPopup().clickCopy();
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
			Thread.sleep(1000);
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
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
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
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			Thread.sleep(1000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			//tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyCloseView();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testRequestTransactionsWithNavigation failed due to Back and cross Icon exception " + e);
		}
	}

@Test
	
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionsWithAllPaymentMethods(String strParams, String payment) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			if(payment.equalsIgnoreCase("No")) {
				tokenAccountPage.buyCoyniTokensNoPaymentPopup().clickOnAddNewPayment();
				paymentMethodsTest.testAddExternalBankAccount(strParams);
				testBuyTokenTransactionBankAccount(strParams);
				testBuyTokenDeleteBank(strParams);
				
				payment.equalsIgnoreCase("No");
				
				
				
				
			}
			
			else if(payment.equalsIgnoreCase("Change")) {
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickChangeLink();
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickAddNewPaymentMethod();
				paymentMethodsTest.testAddDebitCard(strParams);
				testBuyTokenTransactionDebitCard(strParams);
				tokenAccountPage.clickBuyTokens();
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickChangeLink();
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickAddNewPaymentMethod();
				paymentMethodsTest.testAddCreditCard(strParams);
				testBuyTokenTransactionCreditCard(strParams);
			}
			
			

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test Buy Token Transaction with bank account failed due to exception " + e);
		}
		
	}
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithDebitCardWithOutPayment(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
	tokenAccountPage.clickBuyTokens();
	testBuyCoyniTokenAddDebitCard(strParams);
	testBuyTokenWithDebitCard(strParams);
	testBuyTokenDeleteDebitCard(strParams);
		}
		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithDebitCardWithOutPayment is failed due to "+ e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithCreditCardWithOutPayment(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
	tokenAccountPage.clickBuyTokens();
	testBuyCoyniTokenAddCreditCard(strParams);
	testBuyTokenWithCreditCard(strParams);
	testBuyTokenDeleteCreditCard(strParams);
		}
		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithDebitCardWithOutPayment is failed due to "+ e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDeleteDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().deleteDebit();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup().clickOnRemove();		  
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent().navigationComponent().clickClose();
			
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenTransactionsWithBank is failed" + e);
		}
    }

	
	

    @Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionsWithoutBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testBuyTokenTransactionsWithAllPaymentMethods(strParams, "No");
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenTransactionsWithBank is failed" + e);
		}
    }

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			//tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
			Thread.sleep(3000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickOutSIde();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().verifyOrderViewHeading();
			//tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().orderPreviewBuyTokenWithBankView();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().authyComponent().fillInput(data.get("code"));
			
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.transactionInProgessPopup().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test Buy Token Transaction with bank account failed due to exception " + e);
		}
		
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testBuyCoyniTokenAddDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
		//	tokenAccountPage.clickBuyTokens();
		//	tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
		//	tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenDescription(data.get("buyCoyniTokenDescrp"));
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			paymentMethodsTest.testAddCard(strParams,"Debit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testBuyCoyniTokenAddDebitCard failed due to exception " + e);
		}

	}
	
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithDebitCard(String strParams)
	{
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickDebit();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().fillCvv(data.get("cvvNumber"));
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickNext();
			Thread.sleep(2000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amountCard"));
			//tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickOutSIde();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
		    Thread.sleep(3000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().authyComponent().fillInput(data.get("code"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.clickConfirm();
			Thread.sleep(3000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.transactionInProgessPopup().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testBuyCoyniTokenAddCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			//tokenAccountPage.clickBuyTokens();
			//tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
		//	tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenDescription(data.get("buyCoyniTokenDescrp"));
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			paymentMethodsTest.testAddCard(strParams,"Credit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testBuyCoyniTokenAddDebitCard failed due to exception " + e);
		}

	}
	
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithCreditCard(String strParams)
	{
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickCredit();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().fillCvv(data.get("cvvNumber"));
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickNext();
			Thread.sleep(2000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amountCard"));
			//tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickOutSIde();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
		    Thread.sleep(3000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup().authyComponent().fillInput(data.get("code"));
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.clickConfirm();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.transactionInProgessPopup().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDeleteCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().deleteCredit();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup().clickOnRemove();
		//	tokenAccountPage.buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent().navigationComponent().clickClose();
			
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenTransactionsWithBank is failed" + e);
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
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get(""));
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get(""));
				

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
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickCredit();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amount"));
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
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickDebit();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().clickNext();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().fillAmount(data.get("amount"));
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
	public void testBuyTokenViewWithOutPaymentMethods(String strParams)
	{
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenDescrpWithOutPaymentMethods();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().verifyAddNewPaymentMethodHeading();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().navigationComponent().clickBack();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().verifyBuyCoyniTokenHeading(data.get(""));
			tokenAccountPage.buyCoyniTokensPopup().navigationComponent().clickClose();
			tokenAccountPage.verifyLabelYourTokenAccount();
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().clickaddExternalBankAccount();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addExternalBankAccountPopup().verifyHeading();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addExternalBankAccountPopup().navigationComponent().clickBack();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addExternalBankAccountPopup().verifyHeading();
		//	tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().navigationComponent().clickClose();
			tokenAccountPage.verifyLabelYourTokenAccount();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}

	
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenAddBank(String strParams)
	{
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().clickaddExternalBankAccount();
			paymentMethodsTest.testAddExternalBankAccount(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDeleteBank(String strParams)
	{
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().deleteBank();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup().clickOnRemove();
//			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup().successFailurePopupCardComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
		}
	}
	
	
	
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenViewWithPaymentMethods(String strParams)
	{
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().viewChangeLink();
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().verifyBuyCoyniTokenDescription();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickDelete();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent().verifyPaymnetRemovedSuccessfulHeading();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent().viewClose();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent().clickClose();
			tokenAccountPage.viewBuyTokens();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
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
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
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
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			//tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
				//	.clickDebitCard(data.get("last4digits"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
				.txtMessage(data.get("transactionalmessage"));
		//	tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
		//	tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
			//		.verifyLabelHeading(data.get("instantPayHeading"));
//			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as "
//					+ tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().getDailyLimit());
		//	tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			//tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyLabelDebitCardView();
			Thread.sleep(1000);
		//

			//tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyErrorMessage();

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
				tokenAccountPage.withdrawCoyniToUSDPopup().verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
		        tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
		        tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
		        tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyLabelHeading(data.get("instantPayHeading"));
			    paymentMethodsTest.testAddCard(strParams,"Debit");
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
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
			paymentMethodsTest.testEditCard(strParams);

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
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
			paymentMethodsTest.testDeleteCard(strParams);
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
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
			paymentMethodsTest.testCardsFieldValidations(strParams, "Debit");
			

/*			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
		}
		*/	
			

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
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
			paymentMethodsTest.testAddCardWihInvalidData(strParams, "Debit");
			

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
			//tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			//tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();

		//	tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
			//		.clickDebitCard(data.get("last4digits"));
			//tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
				//	.verifyLabelHeading(data.get("instantPayHeading"));
//			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as "
//					+ tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().getDailyLimit());
		//	tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
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
			//tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
				//	.fillAuthyInput(data.get("securityKey"));
			tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent().fillInput(data.get("code"));
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

	
	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawToBankAccountPopup().verifyHeading();
			paymentMethodsTest.testAddExternalBankAccount(strParams);
			
			
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
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().cursorhoverWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			//tokenAccountPage.bankAccountsComponent().clickOnBank(data.get("last4Digits"));
			//tokenAccountPage.bankAccountsComponent().ClickNext();
			tokenAccountPage.bankAccountsComponent().verifyHeading(data.get("bankHeading"));
			tokenAccountPage.bankAccountsComponent().fillAmount(data.get("amount"));
			tokenAccountPage.bankAccountsComponent().clickToggle();
			//tokenAccountPage.bankAccountsComponent().getPaymentItems(data.get("last4Digits")); // data.get("bankName"),
			tokenAccountPage.bankAccountsComponent().verifyAvalibleBalance();
			tokenAccountPage.bankAccountsComponent().fillMessage(data.get("message"));
			tokenAccountPage.bankAccountsComponent().verifyMsg(data.get("content"));
			tokenAccountPage.bankAccountsComponent().ClickNext();
			tokenAccountPage.bankAccountsComponent().clickConfirm();
			tokenAccountPage.bankAccountsComponent().authyComponent().verifyHeading1(data.get("authyHeading1"));
			tokenAccountPage.bankAccountsComponent().authyComponent().fillInput(data.get("code"));
			//tokenAccountPage.bankAccountsComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
			tokenAccountPage.bankAccountsComponent().verifySuccessHeading(data.get("sucessHeading"));
			tokenAccountPage.bankAccountsComponent().clickCopy();
			tokenAccountPage.bankAccountsComponent().clickDone();
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
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().cursorhoverWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			//tokenAccountPage.bankAccountsComponent().clickOnBank(data.get("last4Digits"));
			tokenAccountPage.bankAccountsComponent().ClickNext();
			tokenAccountPage.bankAccountsComponent().verifyHeading(data.get("bankHeading"));
			tokenAccountPage.bankAccountsComponent().fillAmount(data.get("amount"));
			tokenAccountPage.bankAccountsComponent().clickToggle();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test Remove External Bank Transaction  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDRemoveExternalBankAccount2(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().cursorhoverWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
			tokenAccountPage.bankAccountsComponent().clickOnDelete(data.get("last4Digits"));
			tokenAccountPage.bankAccountsComponent().verifyRemoveHeading(data.get("removeHeading"));
			tokenAccountPage.bankAccountsComponent().clickRemove();
			tokenAccountPage.bankAccountsComponent().removeHeading(data.get("removeHeading1"));
			tokenAccountPage.bankAccountsComponent().clickRemove();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test Remove External Bank Transaction  failed due to exception " + e);
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
			tokenAccountPage.exportfilesPage().clickExport();
			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().verifyHeading(data.get("heading"));
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
			tokenAccountPage.exportfilesPage().exportSelectedTransactionsPopup().verifyTitle(data.get("exportHeading"));
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

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDRemoveExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().cursorhoverWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnExternalBankAccount();
//			tokenAccountPage.bankAccountsComponent().clickOnBank(data.get("last4Digits"));
//			tokenAccountPage.bankAccountsComponent().ClickNext();
			tokenAccountPage.bankAccountsComponent().clickDelete();
			tokenAccountPage.bankAccountsComponent().verifyRemoveHeading(data.get("removeHeading"));
			tokenAccountPage.bankAccountsComponent().clickRemove();
			tokenAccountPage.bankAccountsComponent().removeHeading(data.get("removeHeading1"));
			tokenAccountPage.bankAccountsComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test Remove External Bank Transaction  failed due to exception " + e);
		}
	}

}
