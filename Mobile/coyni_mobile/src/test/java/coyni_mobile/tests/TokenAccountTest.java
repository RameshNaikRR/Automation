package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.FiltersComponent;
import coyni_mobile.components.NotificationComponent;
import coyni_mobile.pages.TokenAccountPage;
import coyni_mobile.pages.TransactionPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class TokenAccountTest {

	TokenAccountPage tokenAccountPage;
	TransactionPage transactionPage;
	FiltersComponent filtersComponent;
	NotificationComponent notificationComponent;

	@BeforeTest
	public void init() {

		tokenAccountPage = new TokenAccountPage();
		transactionPage = new TransactionPage();
		filtersComponent = new FiltersComponent();
		notificationComponent = new NotificationComponent();

	}

	// private By viewDot= MobileBy.xpath("");

	String s1 = "demi";

	@Test
	@Parameters({ "strParams" })
	public void testNotification(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().viewNotification();
			// tokenAccountPage.notificationComponent().clickNotifications();
			tokenAccountPage.notificationComponent().readDot(); // Dot message //read and delete
			tokenAccountPage.notificationComponent().viewPay();
			tokenAccountPage.notificationComponent().navigationComponent().clickBack();
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().viewRequest();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().readDot(); // dot Read
			tokenAccountPage.notificationComponent().navigationComponent().clickBack();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Notification faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().viewPay();
			tokenAccountPage.notificationComponent().clickPay(data.get("senderName"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Notification pay faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().viewDeny();
			tokenAccountPage.notificationComponent().clickDeny(data.get("senderName"));
			tokenAccountPage.notificationComponent().verifyDenyHeading(data.get("denyHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Notification Deny faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestRemainder(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickRemainder(data.get("senderName"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Request Remainder  faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestCancel(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickCancel(data.get("senderName"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Request cancel  faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickPay(data.get("senderName"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Request Pay  faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickDeny(data.get("senderName"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Request Deny  faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnDashBoard();
			tokenAccountPage.buyTokenMenuComponent().btnBuyToken();
			tokenAccountPage.buyTokenMenuComponent()
					.verifyLabelSelectPaymentMethod(data.get("selectPaymentmethodexpHeading"));
			tokenAccountPage.buyTokenMenuComponent().clickBankAccount();
			tokenAccountPage.buyTokenMenuComponent().fillAmount(data.get("amount"));
			tokenAccountPage.buyTokenMenuComponent().btnPaymentBuyToken();
			tokenAccountPage.buyTokenMenuComponent().verifyLabelOrderPreview(data.get("orderPreviewexpHeading"));
			tokenAccountPage.buyTokenMenuComponent().Swipe();
			tokenAccountPage.buyTokenMenuComponent()
					.verifyLabelTransactionPending(data.get("transactionPendingexpHeading"));
			tokenAccountPage.buyTokenMenuComponent().Done();
			tokenAccountPage.buyTokenMenuComponent()
					.verifyLabelAvailableBalance(data.get("availableBalanceExpHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankWithInvalidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnDashBoard();
			tokenAccountPage.buyTokenMenuComponent().btnBuyToken();
			tokenAccountPage.buyTokenMenuComponent().clickBankAccount();
			tokenAccountPage.buyTokenMenuComponent().fillAmount(data.get("amount"));
			tokenAccountPage.buyTokenMenuComponent().crossIcon();
			tokenAccountPage.buyTokenMenuComponent()
					.verifyLabelSelectPaymentMethod(data.get("selectPaymentExpHeading"));
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testBuyTokenBankWithInvalidDetails  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankWithInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnDashBoard();
			tokenAccountPage.buyTokenMenuComponent().btnBuyToken();
			tokenAccountPage.buyTokenMenuComponent().clickBankAccount();
			tokenAccountPage.buyTokenMenuComponent().fillAmount(data.get("amount"));
			if (!data.get("amount").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBankWithInvalidAmount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankTransactionFailed(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnDashBoard();
			tokenAccountPage.buyTokenMenuComponent().btnBuyToken();
			tokenAccountPage.buyTokenMenuComponent().clickBankAccount();
			tokenAccountPage.buyTokenMenuComponent().fillAmount(data.get("amount"));
			tokenAccountPage.buyTokenMenuComponent().verifyLabelOrderPreview(data.get("orderPreviewExpHeading"));
			tokenAccountPage.buyTokenMenuComponent().Swipe();
			tokenAccountPage.buyTokenMenuComponent()
					.verifyLabelTransactionFailed(data.get("tansactionFailedExpHeading"));
			tokenAccountPage.buyTokenMenuComponent().clickTryAgain();
			tokenAccountPage.buyTokenMenuComponent().verifyLabelPaymentMethod(data.get("paymentMethodExpHeadig"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBankTransactionFailed  failed due to exception " + e);
		}

	}

	@Test // added
	@Parameters({ "strParams" })
	public void testView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			// view
			transactionPage.FiltersComponent().verifyFiltersIconView();
			transactionPage.FiltersComponent().verifyLabelFilterView();
			transactionPage.FiltersComponent().verifyResetAllFiltersView();
			transactionPage.FiltersComponent().verifyLabelTransactionTypeView();
			transactionPage.FiltersComponent().verifyLabelTransactionSubTypeView();
			transactionPage.FiltersComponent().verifyLabelTransactionStatusView();
			transactionPage.FiltersComponent().verifyLabelTransactionAmountView();
			transactionPage.FiltersComponent().verifyLabelDateView();

			transactionPage.FiltersComponent().clickFiltersIcon();

			// Transaction Type
			transactionPage.FiltersComponent().clickPayRequest();
			transactionPage.FiltersComponent().clickBuyToken();
			transactionPage.FiltersComponent().clickSalesOrder();
			transactionPage.FiltersComponent().clickWithdrawn();
			transactionPage.FiltersComponent().clickRefund();
			transactionPage.FiltersComponent().clickAccountTransfer();
			transactionPage.FiltersComponent().clickPaidInvoice();
			transactionPage.FiltersComponent().clickAppliedFilters();

			// Transaction Sub Type
			transactionPage.FiltersComponent().clickSent();
			transactionPage.FiltersComponent().clickReceive();
			transactionPage.FiltersComponent().clickBankAccount();
			transactionPage.FiltersComponent().clickCreditCard();
			transactionPage.FiltersComponent().clickDebitCard();
			transactionPage.FiltersComponent().clickSignet();
			transactionPage.FiltersComponent().clickInstantPay();
			transactionPage.FiltersComponent().clickGiftCard();
			transactionPage.FiltersComponent().clickSaleOrderToken();
			transactionPage.FiltersComponent().clickFailedWithdraw();
			transactionPage.FiltersComponent().clickCancelledWithdraw();
			transactionPage.FiltersComponent().clickAppliedFilters();

			// Transaction Status
			transactionPage.FiltersComponent().clickPending();
			transactionPage.FiltersComponent().clickCompleted();
			transactionPage.FiltersComponent().clickCancelled();
			transactionPage.FiltersComponent().clickInProgress();
			transactionPage.FiltersComponent().clickFailed();
			transactionPage.FiltersComponent().clickAppliedFilters();

			// Transaction Amount
			transactionPage.FiltersComponent().fillTransactionAmountFrom(strParams);
			transactionPage.FiltersComponent().fillTransactionAmountTo(strParams);
			transactionPage.FiltersComponent().clickAppliedFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testView failed due to exception " + e);
		}

	}

	@Test // added
	@Parameters({ "strParams" })
	public void testDateRange(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDateRange failed due to exception " + e);
		}

	}

	@Test // added
	@Parameters({ "strParams" })
	public void testCrossIcon(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			transactionPage.FiltersComponent().navigationComponent().clickClose();

		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCrossIcon failed due to exception " + e);
		}
	}

}
