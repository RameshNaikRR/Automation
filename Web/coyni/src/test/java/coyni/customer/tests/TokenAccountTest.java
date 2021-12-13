package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.LoginPage;
import coyni.customer.pages.TokenAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class TokenAccountTest {
	TokenAccountPage tokenAccountPage;
	LoginPage loginPage;

	@BeforeTest
	public void init() {
		tokenAccountPage = new TokenAccountPage();
		loginPage = new LoginPage();
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
	public void testTokenSent() {
		try {
			ExtentTestManager.setInfoMessageInReport(
					"Tokens sent " + tokenAccountPage.tokenAccountActivityComponent().getTokensSent());
			tokenAccountPage.tokenAccountActivityComponent().clickTokensSentDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test token sent failed due to exception " + e);
		}
	}

	@Test
	public void testTokenPurchased() {
		try {
			ExtentTestManager.setInfoMessageInReport(
					"Tokens purchased " + tokenAccountPage.tokenAccountActivityComponent().getTokensPurchased());
			tokenAccountPage.tokenAccountActivityComponent().clickTokensPurchasedDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test token purchased failed due to exception " + e);
		}
	}

	@Test
	public void testTokenReceived() {
		try {
			ExtentTestManager.setInfoMessageInReport(
					"Tokens received " + tokenAccountPage.tokenAccountActivityComponent().getTokensReceived());
			tokenAccountPage.tokenAccountActivityComponent().clickTokensReceivedDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test token received failed due to exception " + e);
		}
	}

	@Test
	public void testTokenWithdrawn() {
		try {
			ExtentTestManager.setInfoMessageInReport(
					"Tokens Withdrawn " + tokenAccountPage.tokenAccountActivityComponent().getTokensWithdrawn());
			tokenAccountPage.tokenAccountActivityComponent().clickTokensWithdrawn();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test token withdrawn failed due to exception " + e);
		}
	}

	@Test
	public void testPaidOrders() {
		try {
			ExtentTestManager.setInfoMessageInReport(
					"Paid orders " + tokenAccountPage.tokenAccountActivityComponent().getPaidOrders());
			tokenAccountPage.tokenAccountActivityComponent().clickPaidOrdersDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test paid orders failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTodayTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickToday();
			// verify today transactions list?

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Today Transaction List is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testYesterdayTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickYesterday();
			// verify yesterday transactions list?

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Yesterday Transaction List is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLast7DaysTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickLast7Days();
			// verify last7Days transactions list ?
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Last7Days TransactionList is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testLastMonthTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickLastMonth();
			// verify lastMonth transactions list?
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test LastMonth TransactionList is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMonthToDate(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickMonthToDate();
			// verify monthToDate
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test MonthToDate TransactionList is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCustomDateRange(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenAccountActivityComponent().daysMonthsDropDownComponent().clickCustomDateRange();
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent()
					.setDateWithYear(data.get("startDate"));
			tokenAccountPage.tokenAccountActivityComponent().datePickerComponent().setDateWithYear(data.get("endDate"));
			// verify CustomDateRange

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test CustomDateRange TransactionList is failed due to exception " + e);
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
