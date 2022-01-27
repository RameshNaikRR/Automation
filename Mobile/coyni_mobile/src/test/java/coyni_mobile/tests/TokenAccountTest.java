package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.FiltersComponent;
import coyni_mobile.components.NotificationComponent;
import coyni_mobile.pages.CustomerProfilePage;
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
	CustomerProfilePage customerProfilePage;

	@BeforeTest
	public void init() {

		tokenAccountPage = new TokenAccountPage();
		transactionPage = new TransactionPage();
		filtersComponent = new FiltersComponent();
		notificationComponent = new NotificationComponent();
		customerProfilePage = new CustomerProfilePage();
	}

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

//	@Test
//	@Parameters({ "strParams" })
//	public void testBuyTokenBank(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.btnDashBoard();
//			tokenAccountPage.buyTokenMenuComponent().btnBuyToken();
//			tokenAccountPage.buyTokenMenuComponent()
//					.verifyLabelSelectPaymentMethod(data.get("selectPaymentmethodexpHeading"));
//			tokenAccountPage.buyTokenMenuComponent().clickBankAccount();
//			tokenAccountPage.buyTokenMenuComponent().fillAmount(data.get("amount"));
//			tokenAccountPage.buyTokenMenuComponent().btnPaymentBuyToken();
//			tokenAccountPage.buyTokenMenuComponent().verifyLabelOrderPreview(data.get("orderPreviewexpHeading"));
//			tokenAccountPage.buyTokenMenuComponent().Swipe();
//			tokenAccountPage.buyTokenMenuComponent()
//					.verifyLabelTransactionPending(data.get("transactionPendingexpHeading"));
//			tokenAccountPage.buyTokenMenuComponent().Done();
//			tokenAccountPage.buyTokenMenuComponent()
//					.verifyLabelAvailableBalance(data.get("availableBalanceExpHeading"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  faield due to exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBuyTokenBankWithInvalidDetails(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.btnDashBoard();
//			tokenAccountPage.buyTokenMenuComponent().btnBuyToken();
//			tokenAccountPage.buyTokenMenuComponent().clickBankAccount();
//			tokenAccountPage.buyTokenMenuComponent().fillAmount(data.get("amount"));
//			tokenAccountPage.buyTokenMenuComponent().crossIcon();
//			tokenAccountPage.buyTokenMenuComponent()
//					.verifyLabelSelectPaymentMethod(data.get("selectPaymentExpHeading"));
//		} catch (Exception e) {
//			ExtentTestManager
//					.setFailMessageInReport("testBuyTokenBankWithInvalidDetails  failed due to exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBuyTokenBankWithInvalidAmount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.btnDashBoard();
//			tokenAccountPage.buyTokenMenuComponent().btnBuyToken();
//			tokenAccountPage.buyTokenMenuComponent().clickBankAccount();
//			tokenAccountPage.buyTokenMenuComponent().fillAmount(data.get("amount"));
//			if (!data.get("amount").isEmpty()) {
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
//			}
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testBuyTokenBankWithInvalidAmount  failed due to exception " + e);
//		}
//
//	}
//
//	@Test
//	@Parameters({ "strParams" })
//	public void testBuyTokenBankTransactionFailed(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.btnDashBoard();
//			tokenAccountPage.buyTokenMenuComponent().btnBuyToken();
//			tokenAccountPage.buyTokenMenuComponent().clickBankAccount();
//			tokenAccountPage.buyTokenMenuComponent().fillAmount(data.get("amount"));
//			tokenAccountPage.buyTokenMenuComponent().verifyLabelOrderPreview(data.get("orderPreviewExpHeading"));
//			tokenAccountPage.buyTokenMenuComponent().Swipe();
//			tokenAccountPage.buyTokenMenuComponent()
//					.verifyLabelTransactionFailed(data.get("tansactionFailedExpHeading"));
//			tokenAccountPage.buyTokenMenuComponent().clickTryAgain();
//			tokenAccountPage.buyTokenMenuComponent().verifyLabelPaymentMethod(data.get("paymentMethodExpHeadig"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testBuyTokenBankTransactionFailed  failed due to exception " + e);
//		}
//
//	}

	@Test // added
	@Parameters({ "strParams" })
	public void testFilters(String strParams) {
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

	@Test
	@Parameters({ "strParams" })
	public void testTransactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnDashBoard();
			tokenAccountPage.ViewMore();
			tokenAccountPage.clickViewMore();
			tokenAccountPage.transactionPage().verifyLabelTransactions(data.get("expHeading"));
			tokenAccountPage.transactionPage().verifySearchOption();
			tokenAccountPage.transactionPage().verifyFiltersIcon();
			tokenAccountPage.transactionPage().verifyMerchantAndReferenceID();
			tokenAccountPage.transactionPage().verifyMessage();
			tokenAccountPage.transactionPage().verifyAmount();
			tokenAccountPage.transactionPage().verifyCloseView();
			customerProfilePage.clickLogOut();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickPayRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.verifyName(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().clickMessageButton();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().fillMessage(data.get("message"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().clickDone();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().clickPay();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.swipeConfirm();
			// tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup().enterYourPINComponent().verifyHeading("enterPinHeading");
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.enterYourPINComponent().fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.enterYourPINComponent().securePayPopup().clickNotNow();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPay  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickPayRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.verifyName(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().clickMessageButton();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().fillMessage(data.get("message"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().clickDone();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().clickRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.swipeConfirm();
			// tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup().securePayPopup().clickNotNow();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequest  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount(data.get("last4Digits"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyPayment(data.get("paymentMethod"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("Amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.verifyHeading(data.get("previewHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup().getAmount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.successFailureComponent().getStatus();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.successFailureComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  failed due to exception " + e);
		}

	}

	public void testBuyToken(String strParams, String method) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			if (method.equalsIgnoreCase("bank")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount(data.get("last4Digits"));
			} else if (method.equalsIgnoreCase("credit")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickCreditCard(data.get("last4Digits"));
			} else {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickDebitCard(data.get("last4Digits"));
			}
			if (!method.equalsIgnoreCase("bank")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup()
						.verifyPopupHeading(data.get("cvvPopupHeading"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().fillCvv(data.get("cvv"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().clickOk();
			}
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyPayment(data.get("paymentMethod"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("Amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.verifyHeading(data.get("previewHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup().getAmount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.successFailureComponent().getStatus();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.successFailureComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenCard  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithBank(String strParams) {
		testBuyToken(strParams, "bank");
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithCreditCard(String strParams) {
		testBuyToken(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithDebitCard(String strParams) {
		testBuyToken(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawnToUSDGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickGiftCard();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().verifyGiftCardHeading(data.get("cardHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().verifyBrandHeading(data.get("poplurHeading"));
			//tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillSearchBox(data.get("enterCard"));
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().verifyWithdrawGiftCard(data.get("giftCardHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillFirstName(data.get("firstName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillLastName(data.get("lastName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillEmail(data.get("email1"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().verifyHeading(data.get("orderPreview"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().verifyAmazonHeading(data.get("amazonGift"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().verifyRecipentEmail(data.get("recipentEmail"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().getProcessingFee();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().getTotal();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().slideToConfirm();
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().enterYourPINComponent()
					.verifyHeading(data.get(data.get("pinHeading")));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().enterYourPINComponent().fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().enterYourPINComponent().successFailureComponent().verifyRecipentEmail(data.get("content"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().enterYourPINComponent().successFailureComponent().verifyReferenceID();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().enterYourPINComponent().successFailureComponent().clickLearnMore();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().enterYourPINComponent().successFailureComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawnToUSDGiftCardInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickGiftCard();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().verifyGiftCardHeading(data.get("cardHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().verifyBrandHeading(data.get("poplurHeading"));
			//tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillSearchBox(data.get("enterCard"));
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().verifyWithdrawGiftCard(data.get("giftCardHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillFirstName(data.get("firstName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillLastName(data.get("lastName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillEmail(data.get("email1"));
			// tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testWithdrawnToUSDGiftCardNavigationOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().navigationComponent().clickClose();
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickGiftCard();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().navigationComponent().clickClose();
//			tokenAccountPage.btnHome();
//			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickGiftCard();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
//			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().navigationComponent().clickBack();
//			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillFirstName(data.get("firstName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillLastName(data.get("lastName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillEmail(data.get("email1"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().slideToConfirm();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
			.enterYourPINComponent().clickForgotPin();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
			.enterYourPINComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
		}
	}

	public void testWithdrawToken(String strParams, String method) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			if (method.equalsIgnoreCase("bank")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount(data.get("last4Digits"));
			} else if (method.equalsIgnoreCase("debit")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickDebitCard(data.get("last4Digits"));
			}
			// else {
			// tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickDebitCard(data.get(""));
			// }
			if (!method.equalsIgnoreCase("bank")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickDebitCard(data.get("last4Digits"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().getPaymentItems("last4Digits");
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().getDailyLimit();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().fillAmount(data.get("amount"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickOnConvertLink();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().enterMessage(data.get("message"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickDone();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickWithdraw();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.verifyHeading(data.get("previewHeading"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.getAmount();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.verifySlideText();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.swipeConfirm();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().enterYourPINComponent()
						.fillPin(data.get("pin"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().getStatus();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().verifyReferenceID();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().clickLearnMore();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().navigationComponent().clickClose();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().clickDone();
				tokenAccountPage.verifyAvailableBalanceView();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawToken failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithBank(String strParams) {
		testWithdrawToken(strParams, "bank");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithInstantPay(String strParams) {
		testWithdrawToken(strParams, "Debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithInstantPayWithNavigationOptions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().navigationComponent()
					.clickClose();

			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();

			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickDebitCard(data.get("last4Digits"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().navigationComponent().clickBack();

			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("withdrawMethodHeading"));

			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickDebitCard(data.get("last4Digits"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().getPaymentItems("last4Digits");
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().getDailyLimit();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().enterMessage(data.get("message"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyCancelAndButton();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickCancel();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickWithdraw();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.verifyHeading(data.get("previewHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.getAmount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.swipeConfirm();

			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().enterYourPINComponent()
					.navigationComponent().clickClose();

			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));

			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().navigationComponent().clickBack();

			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().navigationComponent()
					.clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawTokenWithInstantPayWithNavigationOptions  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDInstantPayAddDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().navigationComponent()
					.clickClose();

			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.verifyAddInstantPayHeading(data.get("instantPayHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickOnDebitCard();
			// new CustomerProfileTest().testAddDebitCard("Debit");
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testWithdrawToUSDInstantPayAddDebitCard  failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithInvalidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("withdrawMethodHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickDebitCard(data.get("last4Digits"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().getPaymentItems("last4Digits");
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().getDailyLimit();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyExchangeRate();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithInvalidDetails failed due to exception " + e);

		}
	}

}
