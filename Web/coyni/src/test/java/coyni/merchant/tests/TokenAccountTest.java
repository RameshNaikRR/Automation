package coyni.merchant.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

	@BeforeTest
	public void init() {
		tokenAccountPage = new TokenAccountPage();
		loginPage = new LoginPage();
		getHelpPage = new GetHelpPage();
		exportfilesPage = new ExportfilesPage();
		tokenAccountActivityComponent = new TokenAccountActivityComponent();
		merchantSettingTest = new MerchantSettingsTest();
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
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testYesterDayTrasactions(strParams, "date");
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testLast7DaysTrasactions(strParams, "date");
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDatePayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));

			testMonthToDateTrasactions(strParams, "date");
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthPayOutsReceived();
			tokenAccountPage.tokenAccountActivityComponent().payOutsReceivedDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			testLastMonthTrasactions(strParams, "date");
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
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testYesterDayTrasactions(strParams, "date");
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testLast7DaysTrasactions(strParams, "date");
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDateTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));

			testMonthToDateTrasactions(strParams, "date");
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			testLastMonthTrasactions(strParams, "date");
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
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());

			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickYesterdayTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testYesterDayTrasactions(strParams, "date");
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickLast7DaysTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testLast7DaysTrasactions(strParams, "date");
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickMonthToDateTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testMonthToDateTrasactions(strParams, "date");
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as" + tokenAccountActivityComponent.testGetEntriesMessage());
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.daysMonthsDropDownComponent().clickLastMonthTokensWithdraw();
			tokenAccountPage.tokenAccountActivityComponent().tokensWithdrawnDetailsComponent()
					.verifyLabelWithdrawTransactionDetails(data.get("expHeading"));
			testLastMonthTrasactions(strParams, "date");
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
			Thread.sleep(5000);
			tokenAccountPage.verifyLabelYourTransactions(data.get("expHeading"));
			tokenAccountPage.verifyAmount();
			ExtentTestManager.setInfoMessageInReport(
					"Available balance is displayed as " + tokenAccountPage.getAvailableBalance());
			tokenAccountPage.verifyLabelTransactionListDetails();
			// tokenAccountPage.verifyLabelPostedTransactions(data.get("expPostedTransactionHeading"));
			// tokenAccountPage.verifyTransactionList();
			tokenAccountPage.verifyTableItemsCount(data.get("query"));
			// tokenAccountPage.verifyPostedTransactions(data.get("count"));
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
//				merchantSettingTest.testAddDebitCard(strParams);
				testBuyTokenTransactionDebitCard(strParams);
				tokenAccountPage.clickBuyTokens();
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickChangeLink();
				tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickAddNewPaymentMethod();
//				merchantSettingTest.testAddCreditCard(strParams);
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
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithDebitCardWithOutPayment is failed due to " + e);
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
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithDebitCardWithOutPayment is failed due to " + e);
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
			Thread.sleep(1000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent().navigationComponent()
					.clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenTransactionsWithBank is failed" + e);
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
	public void testBuyCoyniTokenAddDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// tokenAccountPage.clickBuyTokens();
			// tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
			// tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenDescription(data.get("buyCoyniTokenDescrp"));
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
//			merchantSettingTest.testAddCard(strParams, "Debit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyCoyniTokenAddDebitCard failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			// tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickDebit();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().fillCvv(data.get("cvvNumber"));
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickNext();
			Thread.sleep(2000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup()
					.fillAmount(data.get("amountCard"));
			// tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickOutSIde();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			Thread.sleep(3000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.authyComponent().fillInput(data.get("code"));
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
			// tokenAccountPage.clickBuyTokens();
			// tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
			// tokenAccountPage.buyCoyniTokensPopup().verifyBuyCoyniTokenDescription(data.get("buyCoyniTokenDescrp"));
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
//			merchantSettingTest.testAddCard(strParams, "Credit");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyCoyniTokenAddDebitCard failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
			// tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().verifyBuyCoyniTokenHeading(data.get("expHeading"));
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickCredit();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().fillCvv(data.get("cvvNumber"));
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().clickNext();
			Thread.sleep(2000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup()
					.fillAmount(data.get("amountCard"));
			// tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickConvert();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickOutSIde();
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().clickNext();
			Thread.sleep(3000);
			tokenAccountPage.buyCoyniTokensPaymentMethodPopup().buyCoyniTokensPopup().orderPreviewPopup()
					.authyComponent().fillInput(data.get("code"));
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
			// tokenAccountPage.buyCoyniTokensPaymentMethodPopup().successFailurePopupCardComponent().navigationComponent().clickClose();

		} catch (Exception e) {
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
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().clickaddExternalBankAccount();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addExternalBankAccountPopup()
					.verifyHeading();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addExternalBankAccountPopup()
					.navigationComponent().clickBack();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().addExternalBankAccountPopup()
					.verifyHeading();
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
			tokenAccountPage.clickBuyTokens();
			tokenAccountPage.buyCoyniTokensPopup().clickAddNewPaymentMethod();
			tokenAccountPage.buyCoyniTokensPopup().addNewPaymentMethodPopup().clickaddExternalBankAccount();
//			merchantSettingTest.testAddExternalBankAccount(strParams);
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
			tokenAccountPage.buyCoyniTokensPopup().clickChangeLink();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().deleteBank();
			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup()
					.clickOnRemove();
//			tokenAccountPage.buyCoyniTokensPopup().buyCoyniTokensPaymentMethodPopup().removePaymentMethodPopup().successFailurePopupCardComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenAddBank is failed due to " + e);
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
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
			// .clickDebitCard(data.get("last4digits"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.txtMessage(data.get("transactionalmessage"));
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnNext();
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
			// .verifyLabelHeading(data.get("instantPayHeading"));
//			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as "
//					+ tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().getDailyLimit());
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyLabelDebitCardView();
			Thread.sleep(1000);
			//

			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyErrorMessage();

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

			// tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
			// .verifyLabelHeading(data.get("instantPayHeading"));

			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
			// .clickDebitCard(data.get("last4digits"));
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
			tokenAccountPage.withdrawCoyniToUSDPopup()
					.verifyLabelWithdrawToUSDHeading(data.get("withdrawToUSDHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().verifyWithdrawToUSD();
			tokenAccountPage.withdrawCoyniToUSDPopup().clickOnInstantPay();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
//			merchantSettingTest.testAddCard(strParams, "Debit");
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
//			merchantSettingTest.testEditCard(strParams);

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
//			merchantSettingTest.testDeleteCard(strParams);
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
//			merchantSettingTest.testCardsFieldValidations(strParams, "Debit");

			/*
			 * if (!data.get("errMessage").isEmpty()) { new
			 * CommonFunctions().validateFormErrorMessage(data.get("errMessage"),
			 * data.get("color"), data.get("elementName")); }
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
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
			Thread.sleep(2000);
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();
//			merchantSettingTest.testAddCardWihInvalidData(strParams, "Debit");

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
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().verifyDebitCardFlow();
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
					.verifyLabelHeading(data.get("instantPayHeading"));
			tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().clickOnChangeLink();

			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
			// .clickDebitCard(data.get("last4digits"));
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup()
			// .verifyLabelHeading(data.get("instantPayHeading"));
//			ExtentTestManager.setInfoMessageInReport("Daily Limit  is displayed as "
//					+ tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPay().getDailyLimit());
			// tokenAccountPage.withdrawCoyniToUSDPopup().withdrawViaInstantPaypopup().enterAmount(data.get("amount"));
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
				Thread.sleep(1000);
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
			Thread.sleep(2000);
			// tokenAccountPage.withdrawCoyniToUSDPopup().giftCardPurchasePopup().authyComponent()
			// .fillAuthyInput(data.get("securityKey"));
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
			// tokenAccountPage.withdrawCoyniToUSDPopup().cursorhoverWithdrawToUSD();
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
//			merchantSettingTest.testAddExternalBankAccount(strParams);

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
			// tokenAccountPage.bankAccountsComponent().clickOnBank(data.get("last4Digits"));
			// tokenAccountPage.bankAccountsComponent().ClickNext();
			tokenAccountPage.bankAccountsComponent().verifyHeading(data.get("bankHeading"));
			tokenAccountPage.bankAccountsComponent().fillAmount(data.get("amount"));
			tokenAccountPage.bankAccountsComponent().clickToggle();
			// tokenAccountPage.bankAccountsComponent().getPaymentItems(data.get("last4Digits"));
			// // data.get("bankName"),
			tokenAccountPage.bankAccountsComponent().verifyAvalibleBalance();
			tokenAccountPage.bankAccountsComponent().fillMessage(data.get("message"));
			tokenAccountPage.bankAccountsComponent().verifyMsg(data.get("content"));
			tokenAccountPage.bankAccountsComponent().ClickNext();
			tokenAccountPage.bankAccountsComponent().clickConfirm();
			tokenAccountPage.bankAccountsComponent().authyComponent().verifyHeading1(data.get("authyHeading1"));
			tokenAccountPage.bankAccountsComponent().authyComponent().fillInput(data.get("code"));
			// tokenAccountPage.bankAccountsComponent().authyComponent().fillAuthyInput(data.get("securityKey"));
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
			// tokenAccountPage.bankAccountsComponent().clickOnBank(data.get("last4Digits"));
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

	@Test
	@Parameters({ "strParams" })
	public void testFilter(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.transactionsListComponent().clickFilterButton();
			tokenAccountPage.transactionsListComponent().filterComponent().calendarComponponent().clickStartDate();
			tokenAccountPage.transactionsListComponent().filterComponent().datePickerComponent()
					.setDate(data.get("startDate"));
			tokenAccountPage.transactionsListComponent().filterComponent().datePickerComponent()
					.setDate(data.get("endDate"));
			Thread.sleep(5000);
			tokenAccountPage.transactionsListComponent().filterComponent().scroolDownToElement();
			tokenAccountPage.transactionsListComponent().filterComponent().clickCheckBox(data.get("checkBox"));
			tokenAccountPage.transactionsListComponent().filterComponent().fillFromAmount(data.get("fromAmount"));
			tokenAccountPage.transactionsListComponent().filterComponent().fillToAmount(data.get("toAmount"));
			tokenAccountPage.transactionsListComponent().filterComponent().fillReferenceID(data.get("referenceID"));
			tokenAccountPage.transactionsListComponent().filterComponent().clickCheckBox(data.get("checkBox"));
			tokenAccountPage.transactionsListComponent().filterComponent().clickApplyFilters();
			Thread.sleep(3000);
			tokenAccountPage.transactionsListComponent().filterComponent().getNoRecordsFound();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

}
