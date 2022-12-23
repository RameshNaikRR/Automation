package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.FiltersComponent;
import coyni_mobile.components.NotificationComponent;
import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.HomePage;
import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.LoginPage;
import coyni_mobile.pages.TokenAccountPage;
import coyni_mobile.pages.TransactionPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class TokenAccountTest {

	TokenAccountPage tokenAccountPage;
	HomePage homePage;
	TransactionPage transactionPage;
	FiltersComponent filtersComponent;
	NotificationComponent notificationComponent;
	LoginPage loginPage;
	CustomerProfilePage customerProfilePage;
	LandingPage landingPage;
	CustomerProfileTest customerProfileTest;

	@BeforeTest
	public void init() {

		tokenAccountPage = new TokenAccountPage();
		transactionPage = new TransactionPage();
		filtersComponent = new FiltersComponent();
		notificationComponent = new NotificationComponent();
		customerProfilePage = new CustomerProfilePage();
		customerProfileTest = new CustomerProfileTest();
		homePage = new HomePage();
		loginPage = new LoginPage();
		landingPage = new LandingPage();
	}

	@Test
	public void testNotifications() {
		try {
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().viewNotification();
			tokenAccountPage.notificationComponent().countNotifications();
			tokenAccountPage.notificationComponent().viewDots();
			tokenAccountPage.notificationComponent().navigationComponent().clickBack();
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().viewRequest();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().navigationComponent().clickBack();
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().swipeNotificationLeft();
			tokenAccountPage.notificationComponent().clickRead();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotifications faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginwithNewAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(data.get("email1"));
			loginPage.fillPassword(data.get("password1"));
			DriverFactory.getDriver().hideKeyboard();
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(data.get("pin1"));
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
			loginPage.enterYourPINComponent().enableFaceIDpage().tokenAccountPage().verifyLogin();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginwithNewAccount failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().viewPay();
			tokenAccountPage.notificationComponent().clickPay();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyHeading(data.get("heading"));
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyAmount();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyPreview();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyLockSwipe();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifySlideText();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().swipeConfirm();
//			tokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent().clickForgotPin();
//			tokenAccountPage.notificationComponent().payRequestConfirmPopup().forgotPinComponent().navigationComponent()
//					.clickBack();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationPay faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().viewDeny();
			tokenAccountPage.notificationComponent().viewPay();
			tokenAccountPage.notificationComponent().clickDeny();
			tokenAccountPage.notificationComponent().verifyDenyMessage(data.get("denyMessage"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationDeny faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestReminder(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickRemainder();
			tokenAccountPage.notificationComponent().verifyReminderMessage(data.get("reminderMessage"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestReminder faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestCancel(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickCancel();
			tokenAccountPage.notificationComponent().verifyCancelMessage(data.get("cancelMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestCancel faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickPay();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyHeading(data.get("heading"));
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyAmount();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyPreview();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyLockSwipe();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().verifySlideText();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().swipeConfirm();
			tokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestPay faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickDeny();
			tokenAccountPage.notificationComponent().verifyDenyMessage(data.get("denyMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestDeny faield due to exception " + e);
		}

	}

	@Test
	public void testNotificationsDelete() {
		try {
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().viewDots();
			tokenAccountPage.notificationComponent().swipeNotificationRight();
			tokenAccountPage.notificationComponent().clickDelete();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationsDelete is failed due to Exception " + e);
		}

	}

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
			tokenAccountPage.verifyTransactionHeading(data.get("transactionHeading"));
			tokenAccountPage.clickViewMore();
			tokenAccountPage.transactionPage().verifyLabelTransactions(data.get("expHeading"));
			tokenAccountPage.transactionPage().verifySearchOption();
			tokenAccountPage.transactionPage().verifyFiltersIcon();
			tokenAccountPage.transactionPage().verifyCloseView();
			tokenAccountPage.transactionPage().clickOnMessage();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.verifyTransactionHeading(data.get("transactionHeading"));
			tokenAccountPage.clickViewMore();
			tokenAccountPage.transactionPage().verifyLabelTransactions(data.get("expHeading"));
			tokenAccountPage.transactionPage().verifySearchOption();
			tokenAccountPage.transactionPage().verifyFiltersIcon();
			tokenAccountPage.transactionPage().verifyCloseView();
			tokenAccountPage.transactionPage().clickOnMessage();
			tokenAccountPage.transactionPage().transactionDetailsComponent()
					.verifySentTransactionDetails(data.get("transactionSentHeading"));
			tokenAccountPage.transactionPage().transactionDetailsComponent().clickSentBackIcon();
			tokenAccountPage.transactionPage().transactionDetailsComponent()
					.verifyReceiveTransactionDetails(data.get("transactionReceiveHeading"));
			tokenAccountPage.transactionPage().transactionDetailsComponent().clickReceiveBackIcon();
			tokenAccountPage.transactionPage().transactionDetailsComponent()
					.verifyBuyTokenBankTransactionDetails(data.get("transactionBuyTokenBankHeading"));
			tokenAccountPage.transactionPage().transactionDetailsComponent().clickBuyTokenBankBackIcon();
			tokenAccountPage.transactionPage().transactionDetailsComponent()
					.verifyBuyTokenDebitCardTransactionDetails(data.get("transactionBuyTokenDebitCardHeading"));
			tokenAccountPage.transactionPage().transactionDetailsComponent().clickBuyTokenDebitBackIcon();
			tokenAccountPage.transactionPage().transactionDetailsComponent()
					.verifyWithdrawBankTransactionDetails(data.get("transactionWithdrawBankHeading"));
			tokenAccountPage.transactionPage().transactionDetailsComponent().clickWithdrawBankBackIcon();
			tokenAccountPage.transactionPage().transactionDetailsComponent()
					.verifyWithdrawInstantPayTransactionDetails(data.get("transactionWithdrawInstantPayHeading"));
			tokenAccountPage.transactionPage().transactionDetailsComponent().clickWithdrawInstantPayBackIcon();
			tokenAccountPage.transactionPage().transactionDetailsComponent()
					.verifyWithdrawGiftCardTransactionDetails(data.get("transactionWithdrawGiftCardHeading"));
			tokenAccountPage.transactionPage().transactionDetailsComponent().clickWithdrawGiftCardBackIcon();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList faield due to exception " + e);
		}

	}

	@Test
	public void testScanCode() {
		try {
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickScan();
			tokenAccountPage.tokenHomePopUp().scanPage().clickOnWhileUsingApp();
			tokenAccountPage.tokenHomePopUp().scanPage().verifyScanCodeAndScanMe();
			tokenAccountPage.tokenHomePopUp().scanPage().clickScanCode();
			tokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().clickFlashLight();
			tokenAccountPage.tokenHomePopUp().scanPage().navigationComponent().clickClose();
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickScan();
			tokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().clickOnAlbum();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanCode  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testScanMe(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickScan();
			tokenAccountPage.tokenHomePopUp().scanPage().clickOnWhileUsingApp();
			tokenAccountPage.tokenHomePopUp().scanPage().verifyScanCodeAndScanMe();
			tokenAccountPage.tokenHomePopUp().scanPage().clickScanMe();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().verifylblUserName(data.get("userName"));
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().verifylblProfileWithNoImage(data.get("profile"));
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().verifyQrCode();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickSetAmount();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().setAmountComponent()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().setAmountComponent().clickOk();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickClearAmount();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickSaveToAlbum();
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickAllow();
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().verifyReceipientAddress();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickCopy();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanCode  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickPayRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().clickAllow();
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.verifyName();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().enterMessage(data.get("message"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().clickDone();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().clickPay();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.enterYourPINComponent().fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPay  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testPayRequestView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickPayRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().clickAllow();
			tokenAccountPage.tokenHomePopUp().payRequestPage().navigationComponent().clickClose();
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickPayRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.verifyName();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().navigationComponent()
					.clickClose();
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage()
					.verifyFirstAndLastLetter(data.get("firstLastLetterheading"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayRequestView  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testPayInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickPayRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().clickAllow();
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.verifyName();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().clickPay();
			if (!data.get("errMessage").isEmpty()) {
				tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
						.verifyErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayInvalidAmount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickPayRequest();
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().payRequestPage().clickAllow();
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.verifyName();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().enterMessage(data.get("message"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().clickDone();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().clickRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequest  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankWithOutPayments(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().addNewPaymentComponent().clickExternalBankAcount();
//			tokenAccountPage.tokenHomePopUp().addNewPaymentComponent().addExternalBankAccountComponent().clickNext();
//			Thread.sleep(15000);
			customerProfileTest.testAddBankAccoun(strParams);
//			tokenAccountPage.tokenHomePopUp().addNewPaymentComponent().addExternalBankAccountComponent()
//					.paymentMethodsPage().AddBankFromBuyToken();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBankWithOutPayments  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDebitWithOutPayments(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().addNewPaymentComponent().clickDebitCard();
			tokenAccountPage.tokenHomePopUp().addNewPaymentComponent().addCardPage().clickNext();
			customerProfileTest.testAddDebitCard(strParams);
			testBuyTokenDebitCard(strParams);
			customerProfileTest.testDeleteDebitCard(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenCreditWithOutPayments(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().addNewPaymentComponent().clickCreditCard();
			tokenAccountPage.tokenHomePopUp().addNewPaymentComponent().addCardPage().clickNext();
			customerProfileTest.testAddCreditCard(strParams);
			testBuyTokenCreditCard(strParams);
			customerProfileTest.testDeleteCreditCard(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			customerProfileTest.testAddBankAccount(strParams);
//			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup().getAmount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.successFailureComponent().getTokenTransactionStatusDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			customerProfileTest.testAddCardWithNoCards(strParams, "debit");
//			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickDebitCard();
//			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().fillCvv(data.get("cvv"));
//			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().cvvPopup().clickOk();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().successFailureComponent()
					.getTokenTransactionStatusDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			customerProfileTest.testAddCardWithNoCards(strParams, "credit");	
//			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickCreditCard();
//			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().fillCvv(data.get("cvv"));
//			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().cvvPopup().clickOk();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().successFailureComponent()
					.getTokenTransactionStatusDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  failed due to exception " + e);
		}

	}

	public void testBuyTokenwithPayments(String strParams, String method) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (method.equalsIgnoreCase("bank")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount();
			} else if (method.equalsIgnoreCase("credit")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickCreditCard();
			} else {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickDebitCard();
			}
			if (!method.equalsIgnoreCase("bank")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().fillCvv(data.get("cvv"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().clickOk();
			}
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup().getAmount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.successFailureComponent().getTokenTransactionStatusDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenCard  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankAccountWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithCreditCard(String strParams) {
		tokenAccountPage.btnHome();
		tokenAccountPage.tokenHomePopUp().clickBuyTokens();
		testBuyTokenwithPayments(strParams, "credit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithDebitCard(String strParams) {
		tokenAccountPage.btnHome();
		tokenAccountPage.tokenHomePopUp().clickBuyTokens();
		testBuyTokenwithPayments(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDebitCardWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickDebitCard();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().fillCvv(data.get("cvv"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().cvvPopup().clickOk();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenCreditCardWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickCreditCard();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().fillCvv(data.get("cvv"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().cvvPopup().clickOk();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawnToUSDGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickGiftCard();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.verifyGiftCardHeading(data.get("cardHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.verifyBrandHeading(data.get("poplurHeading"));
			Thread.sleep(2000);
			if(data.get("validateGiftCard").equalsIgnoreCase("yes")) {
				tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			}else {
				tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickVisa();
			}
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.verifyWithdrawGiftCard(data.get("giftCardHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.fillFirstName(data.get("firstName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillLastName(data.get("lastName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillEmail(data.get("email1"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.verifyHeading(data.get("orderPreview"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.verifyAmazonHeading(data.get("amazonGift"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.verifyRecipentEmail(data.get("recipentEmail"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.getProcessingFee();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup().getTotal();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.slideToConfirm();
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().fillPin(data.get("pin"));
//			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
//					.enterYourPINComponent().successFailureComponent().verifyRecipentEmail(data.get("content"));
//			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
//					.enterYourPINComponent().successFailureComponent().getReferenceID();
//			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
//					.enterYourPINComponent().successFailureComponent().clickLearnMore();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().successFailureComponent().getGiftCardTransactionDetails();
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
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.verifyGiftCardHeading(data.get("cardHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.verifyBrandHeading(data.get("poplurHeading"));
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.verifyWithdrawGiftCard(data.get("giftCardHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.fillFirstName(data.get("firstName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillLastName(data.get("lastName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillEmail(data.get("email1"));
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
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickGiftCard();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			Thread.sleep(2000);
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.fillFirstName(data.get("firstName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillLastName(data.get("lastName"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillEmail(data.get("email1"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.slideToConfirm();
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
			Thread.sleep(2000);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			if (method.equalsIgnoreCase("bank")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount();
			}

			if (!method.equalsIgnoreCase("bank")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
				
//				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
//						.withdrawToUSDInstantPayPopup().clickDebitCard();
				CustomerProfileTest customerProfileTest = new CustomerProfileTest();
				customerProfileTest.testAddCardWithNoCards(strParams, "debit");	
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().getDailyLimit();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().getAvailabeBalance();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().fillAmount(data.get("amount"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickOnConvertLink();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().enterMessage(data.get("message"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickDone();
				DriverFactory.getDriver().hideKeyboard();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickWithdraw();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.getAmount();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.verifySlideText();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.swipeConfirm();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.enterYourPINComponent().fillPin(data.get("pin"));
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
						.successFailureComponent().getTokenTransactionStatusDetails();
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
		testWithdrawToken(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithInstantPayWithNavigationOptions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().navigationComponent()
					.clickClose();
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyVisaCards();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyMasterCards();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickDebitCard();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().navigationComponent().clickBack();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("withdrawMethodHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickDebitCard();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
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
			DriverFactory.getDriver().hideKeyboard();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickWithdraw();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.getAmount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.enterYourPINComponent().navigationComponent().clickClose();
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
	public void testWithdrawToUSDInstantPayAddDebitCardWithNoCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			customerProfileTest.testAddCardWithNoCards(strParams, "debit");
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDInstantPayAddDebitCardWithNoCards  failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDInstantPayAddDebitCardWithCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickOnAddNewPaymentMethod();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().verify();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().addNewPaymentComponent().clickDebitCard();
			customerProfileTest.testAddCardWithExsistingCards(strParams);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDInstantPayAddDebitCardWithCards  failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithInvalidDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("withdrawMethodHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clickDebitCard();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().getDailyLimit();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fillAmount(data.get("amount"));
			Thread.sleep(2000);
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithInvalidDetails failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaExternalBank(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickWithdrawBankAccount();
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			customerProfileTest.testAddBankAccount(strParams);
//			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
//					.verifyWithdrawMethodHeading(data.get("withdrawMethod"));
//			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
//					.clickOnBank();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.verifyWithdrawTokenHeading(data.get("withdrawToken"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.getPaymentItems(data.get("last4Digits"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.fillMSG(data.get("msg"));
			DriverFactory.getDriver().hideKeyboard();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickWithdraw();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().verifyOrderHeading(data.get("orderPreviw"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().getPaymentItems(data.get("last4Digits"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().getBankProcessingFee();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().getBankTotal();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().slideToConfirm();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().enterYourPINComponent().fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().enterYourPINComponent().successFailureComponent().getTokenTransactionStatusDetails();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test WithdrawToUSDVia External Bank  failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaExternalBankWithInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickWithdrawBankAccount();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.verifyWithdrawMethodHeading(data.get("withdrawMethod"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.clickOnBank();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.verifyWithdrawTokenHeading(data.get("withdrawToken"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.fillAmount(data.get("amount"));
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test WithdrawToUSD Via External Bank  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaExternalBankWithChangePaymentMethod(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickWithdrawBankAccount();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.verifyWithdrawMethodHeading(data.get("withdrawMethod"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.clickOnBank();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.verifyWithdrawTokenHeading(data.get("withdrawToken"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickArrow();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.verifyPaymentHeading(data.get("paymentMethod"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.clickOnBank();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test WithdrawToUSD Via External Bank  failed due to exception " + e);

		}
	}

	@Test
	// @Parameters({ "strParams" })
	public void testWithdrawToUSDViaAddExternalBank() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickWithdrawBankAccount();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.clickAddPaymentMethod();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().addExternalBank();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test WithdrawToUSD Via External Bank  failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaAddExternalBankNavigationOption(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().navigationComponent().clickClose();
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickWithdrawBankAccount();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.clickOnBank();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.navigationComponent().clickBack();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickWithdrawBankAccount();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.clickOnBank();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickWithdraw();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().verifyOrderHeading(data.get("orderPreviw"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().getPaymentItems(data.get("last4Digits"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().getBankProcessingFee();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().getBankTotal();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().slideToConfirm();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test WithdrawToUSD Via External Bank  failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaAddExternalBankWithResetPin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickWithdrawBankAccount();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.clickOnBank();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickWithdraw();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().slideToConfirm();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().enterYourPINComponent().forgotPinComponent().clickForgotPin();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().enterYourPINComponent().forgotPinComponent().verifyEmailComponent()
					.fillInputBoxes(data.get("code"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().enterYourPINComponent().fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.orderPreviewPopup().enterYourPINComponent().fillPin(data.get("pin"));
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test WithdrawToUSD Via External Bank  failed due to exception " + e);

		}
	}
}
