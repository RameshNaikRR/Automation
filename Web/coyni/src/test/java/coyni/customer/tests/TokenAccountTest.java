package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.components.AuthyComponent;
import coyni.customer.pages.LoginPage;
import coyni.customer.pages.TokenAccountPage;
import coyni.customer.popups.PayAndRequestTokensPopup;
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

	// added
	@Test
	public void testPayAndRequestTokens() {
		tokenAccountPage.clickTokenAccount();
		tokenAccountPage.clickPayRequestToken();
		tokenAccountPage.verifyPay();
	}

	// added
	@Test
	public void testBuyTokens() {
		tokenAccountPage.clickTokenAccount();
		tokenAccountPage.clickBuyTokens();
	}

	// added
	@Test
	public void testWithdrawToUSD() {
		tokenAccountPage.clickTokenAccount();
		tokenAccountPage.clickWithdrawToUSD();
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

	@Test // added P
	@Parameters({ "strParams" })
	public void testView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().verifyAmountView();
			tokenAccountPage.payAndRequestTokensPopup().verifyRecipientsAddressView();
			tokenAccountPage.payAndRequestTokensPopup().verifyMessageToRecipientView();
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountBalanceView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testView failed due to exception " + e);
		}

	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testAccountBalanceUpdatedView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountBalanceView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountBalanceUpdatedView failed due to exception " + e);
		}
	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testCrossIcons(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().verifyAmountView();
			tokenAccountPage.payAndRequestTokensPopup().verifyPayingRecipient();
			tokenAccountPage.payAndRequestTokensPopup().verifyCrossIconView();
			tokenAccountPage.payAndRequestTokensPopup().verifyLabelYourTokenAccount();
			tokenAccountPage.payAndRequestTokensPopup().verifyBackIconView();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCrossIcons failed due to exception " + e);
		}

	}

	// added P - Alphabets and Special characters in verification
	@Test
	@Parameters({ "strParams" })
	public void testPayWithInvalidVerificationCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
			if (!data.get("code").isEmpty()) {
				loginPage.authyComponent().fillAuthyInputInvalid(data.get("code"), data.get("char"));
			}
			if (!data.get("errMessage").isEmpty()) {

				loginPage.authyComponent().verifyMessage(data.get("errMessage"));
			}

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayWithInvalidVerificationCode failed due to exception " + e);
		}
	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testCopyTextAndShare(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("TestCopyTextAndShare failed due to exception " + e);
		}

	}

	// added P
	@Test
	@Parameters({ "strParams" })
	public void testCopyPaste(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCopyPaste failed due to exception " + e);
		}

	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testNoFundsAvailable(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().isFundsDisplayed("noFundsAvailable");

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNoFundsAvailable failed due to  exception " + e);
		}
	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testPayFieldsWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountHolderName(data.get("accountHolderName"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("message"));
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("amount"),
						data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayFieldsWithInvalidData failed due to  exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testPayTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountBalanceView();
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountHolderName(data.get("accountHolderName"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("message"));
			tokenAccountPage.payAndRequestTokensPopup().verifyCountMessageToRecipient();
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			//
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent()
					.verifyHeading(data.get("authyHeading"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent()
					.fillAuthyInput(data.get("securityKey"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().authyComponent()
					.verifyMessage(data.get("message"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().verifyHeading(data.get("successFailureHeading"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().verifyImage(data.get("image"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().verifyMessge(data.get("sucessMessage"));
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup().clickOnCopyLink();
			tokenAccountPage.payAndRequestTokensPopup().payingAccountHolderNamePopup()
					.successFailurePopupCardComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayTransaction failed due to exception " + e);
		}
	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testPayTransactionsWithInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			String[] amount = data.get("amount").split(",");
			tokenAccountPage.payAndRequestTokensPopup().validateAmountField(amount[0], amount[1]);

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessageForInvalidAmount"),
						data.get("Invalid Amount"), data.get("elementName"));
			}

			else if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessageForMinimumTransaction"),
						data.get("Minimum Transaction"), data.get("elementName"));
			}

			else {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessageForMaximumTransaction"),
						data.get("Maximum Transaction"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayTransaction failed due to Invalid Amount exception " + e);
		}
	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testPayTransactionsWithInvalidAccountAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			if (!data.get("errMessageForInvalidRecipientAddress").isEmpty()) {
				if (!data.get("errMessageForInvalidRecipientAddress").isEmpty()) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessageForInvalidRecipientAddress"),
							data.get("RecipientAddress"), data.get("elementName"));
				}

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testPayTransaction failed due to Invalid Recipient Address exception " + e);
		}
	}

	@Test // added P
	@Parameters({ "strParams" })
	public void testPayTransactionsWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessageForInvalidAmount"),
						data.get("Invalid Amount"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testPayTransaction failed due to Invalid Recipient Address exception " + e);
		}
	}

	// DOUBT --
	@Test // added P
	@Parameters({ "strParams" })
	public void testTryAgain(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.payAndRequestTokensPopup().verifyButtonPay();
			tokenAccountPage.payAndRequestTokensPopup().verifyTransactionFailed();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTryAgain failed due to exception " + e);
		}
	}

	@Test // added
	@Parameters({ "strParams" })
	public void testVerificationFailed(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.payAndRequestTokensPopup().verifyTransactionFailed();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testVerification failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientMessage(data.get("message"));
			tokenAccountPage.payAndRequestTokensPopup().verifyAccountHolderName(data.get("accountHolderName"));
			tokenAccountPage.payAndRequestTokensPopup().clickNext();
			//
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup().clickRequest();
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup()
					.successFailurePopupCardComponent().verifyHeading(data.get("successFailureHeading"));
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup()
					.successFailurePopupCardComponent().verifyImage(data.get("image"));
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup()
					.successFailurePopupCardComponent().verifyMessge(data.get("sucessMessage"));
			tokenAccountPage.payAndRequestTokensPopup().requestingAccountHolderPopup()
					.successFailurePopupCardComponent().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestTransaction failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestTransactionsWithInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
//			if (!data.get("errMessageForInvalidAmount").isEmpty()) {
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessageForInvalidAmount"), strParams);
//			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayTransaction failed due to Invalid Amount exception " + e);
		}
	}

	// correct or not
	@Test
	@Parameters({ "strParams" })
	public void testRequestTransactionsWithInvalidAccountAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickPayRequestToken();
			tokenAccountPage.payAndRequestTokensPopup().clickPay();
			tokenAccountPage.payAndRequestTokensPopup().fillAmount(data.get("amount"));
			tokenAccountPage.payAndRequestTokensPopup().fillRecipientAddress(data.get("address"));
//			if (!data.get("errMessageForInvalidRecipientAddress").isEmpty()) {
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessageForInvalidRecipientAddress"),
//						strParams);
//			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testPayTransaction failed due to Invalid Recipient Address exception " + e);
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
