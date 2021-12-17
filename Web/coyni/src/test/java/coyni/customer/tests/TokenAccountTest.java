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
	public void testAvailableBalance() {
		try {
			tokenAccountPage.clickTokenAccount();
			Thread.sleep(2000);
			tokenAccountPage.verifyAmount();
			ExtentTestManager.setInfoMessageInReport(
					"Available balance is displayed as " + tokenAccountPage.getAvailableBalance());

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAvailableBalance is failed due to exception " + e);
		}
	}

	@Test
	public void testPayAndRequestTokens() {
		try {
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.verifyPay();
		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testPayAnRequstTokens is failed due to exception " + e);
		}
	}

	@Test
	public void testBuyTokens() {
		try {
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickBuyTokens();
		} catch (InterruptedException e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokens is failed due to exception " + e);
		}
	}

	@Test
	public void testWithdrawToUSD() {
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
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent().getTokensSent();
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent().daysMonthsDropDownComponent()
					.clickTodayTokensSent();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensSentDetailsComponent()
					.verifyLabelTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsList is failed due to exception " + e);
		}

	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testCustomDateRangeSentTransaction(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickTokenAccount();
//			tokenAccountPage.tokenAccountActivityComponent().clickTokensSentDetails();
//			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent()
//					.clickCustomDateRangeTokensSent();
//			Thread.sleep(2000);
//			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent()
//					.setDateWithYear(data.get("startDate"));
//			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("endDate"));
//			// verify CustomDateRange
//
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport("testCustomDateRangeSentTransaction is failed due to exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionReceiveDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensReceivedDetails();
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent().getTokensReceived();
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayTokensReceive();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensReceivedDetailsComponent()
					.verifyLabelReceiveTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Today Transaction List is failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testCustomDateRangeReceiveTransaction(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickTokenAccount();
//			tokenAccountPage.tokenAccountActivityComponent().clickTokensReceivedDetails();
//			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent()
//					.clickCustomDateRangeTokensReceive();
//			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent()
//					.setDateWithYear(data.get("startDate"));
//			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("endDate"));
//			// verify CustomDateRange
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testCustomDateRange is failed due to exception " + e);
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionPurchasedDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.tokenAccountActivityComponent().clickTokensPurchasedDetails();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent().getTokensPurchased();
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.daysMonthsDropDownComponent().clickTodayTokensPurchased();
			// add Total Amount count
			// add Count of Total Transactions
			tokenAccountPage.tokenAccountActivityComponent().tokensPurchasedDetailsComponent()
					.verifyLabelPurchasedTransactionDetails(data.get("expHeading"));
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
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
			tokenAccountActivityComponent.verifyTableItemsCount(data.get("query"));
			tokenAccountPage.tokenAccountActivityComponent().clickDropDownEntriesPage();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountActivityComponent.getDefaultEntriesPerPage());
			tokenAccountPage.tokenAccountActivityComponent().verifyEntriesMessage();
			ExtentTestManager.setInfoMessageInReport(
					"Entries is displayed as " + tokenAccountActivityComponent.getEntriesMessage());

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionDetailsList is failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.verifyLabelYourTransactions(data.get("expHeading"));
			// tokenAccountPage.verifyLabelTransactionListDetails();
			tokenAccountPage.verifyAmount();
			ExtentTestManager.setInfoMessageInReport(
					"Available balance is displayed as " + tokenAccountPage.getAvailableBalance());
			// tokenAccountPage.verifyLabelPostedTransactions(data.get("expPostedTransactionHeading"));
			// tokenAccountPage.verifyTransactionList();
			ExtentTestManager.setInfoMessageInReport(
					"Default Entries is displayed as " + tokenAccountPage.getDefaultEntriesPerPage());
			tokenAccountPage.clickDropDownEntriesPage();
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
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountBalanceView();
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			// tokenAccountPage.payAndRequestTokensPopup().verifyWalletID();
			// tokenAccountPage.payAndRequestTokensPopup().verifyAccountHolderName(data.get("accountHolderName"));
			// tokenAccountPage.payAndRequestTokensPopup().verifyCountMessageToRecipient();
			Thread.sleep(2000);
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			//
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().verifyAmount();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().verifyProcessingFee();
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

	@Test // added P
	@Parameters({ "strParams" })
	public void testPayAmountFieldWithNullSpecialCharAndChar(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			String[] amount = data.get("amount").split(",");
			tokenAccountPage.payAndRequestTokensPopup().validateAmountField(amount[0], amount[1]);
			ExtentTestManager.setPassMessageInReport("Amount field is not accepting special characters and characters");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testPayAmountFieldWithNullSpecialCharAndChar failed due to  exception " + e);
		}
	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testPayRecipientAddressFieldWithMax(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			Thread.sleep(2000);
			String[] recipient = data.get("recipientMessage").split(",");
			tokenAccountPage.payAndRequestTokensPopup().validateRecipientField(recipient[0], recipient[1]);

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testPayRecipientAddressFieldWithMax failed due to  exception " + e);
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

	// added P
//	@Test
//	@Parameters({ "strParams" })
//	public void testCopyTextAndShare(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickPayRequestToken();
//			tokenAccountPage.payAndRequestTokensPopup().clickPay();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("TestCopyTextAndShare failed due to exception " + e);
//		}
//
//	}

	// added P
//	@Test
//	@Parameters({ "strParams" })
//	public void testCopyPaste(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickPayRequestToken();
//			tokenAccountPage.payAndRequestTokensPopup().clickPay();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testCopyPaste failed due to exception " + e);
//		}
//
//	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testNoFundsAvailable(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().isFundsDisplayed("noFundsAvailable");
			tokenAccountPage.payAndRequestTokensPopup().clickBuyToken();
			tokenAccountPage.payAndRequestTokensPopup().navigationComponent().verifyCloseView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNoFundsAvailable failed due to  exception " + e);
		}
	}

	// DOUBT --
	@Test // added P
	@Parameters({ "strParams" })
	public void testTryAgain(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("recipientMessage"));
			tokenAccountPage.payAndRequestTokensPopup().clickNext();

			//
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().verifyAmount();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().verifyProcessingFee();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.verifyHeading(data.get("authyPayHeading"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));

			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent()
					.verifyTransactionFailedHeading(data.get("successFailureHeading"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().verifyLabelFailedMessage();
//			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
//					.successFailurePopupCardComponent().verifyImage();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().clickTryAgain();

			Thread.sleep(3000);
			tokenAccountPage.payAndRequestTokensPopup().viewPay();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTryAgain failed due to exception " + e);
		}
	}

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
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("messageToRecipient"));
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

	@Test
	@Parameters({ "strParams" })
	public void testRequestTransactionsWithValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickTokenAccount();
			tokenAccountPage.payAndRequestTokensPopup().cursorhoverPayRequest();
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			String[] amount = data.get("amount").split(",");
			tokenAccountPage.payAndRequestTokensPopup().validateAmountField(amount[0], amount[1]);
			ExtentTestManager.setPassMessageInReport("Amount field is not accepting special characters and characters");
			String[] message = data.get("messageToRecipient").split(",");
			tokenAccountPage.payAndRequestTokensPopup().validateRecipientField(message[0], message[1]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayTransaction failed due to Invalid Amount exception " + e);
		}
	}

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
					"testPayTransaction failed due to Invalid Recipient Address exception " + e);
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
			ExtentTestManager
					.setFailMessageInReport("testPayTransaction failed due to Back and cross Icon exception " + e);
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

}
