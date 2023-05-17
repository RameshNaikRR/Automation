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
//		tokenAccountPage.verifyAcccountStatus();
	}

//	@Test
//	public void testNot() {
//		try {
//			tokenAccountPage.notificationComponent().countNotifications();
//		}catch(Exception e) {
//			
//		}
//	}

	@Test
	// @Parameters({ "strParams" })
	public void testNotifications() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(3000);
			int beforeRead = tokenAccountPage.notificationComponent().countNotifications();
			// ExtentTestManager.setPassMessageInReport("Before Reading the notifications,
			// the count is");
			tokenAccountPage.notificationComponent().viewNotification();
			tokenAccountPage.clickNotificationsIcon();
			Thread.sleep(2000);
			// tokenAccountPage.notificationComponent().countNotifications();
			// tokenAccountPage.notificationComponent().viewDots();
			tokenAccountPage.notificationComponent().swipeNotificationLeft();
			tokenAccountPage.notificationComponent().clickReadUnRead();
			tokenAccountPage.notificationComponent().navigationComponent().clickBack();
			Thread.sleep(3000);
			int afterRead = tokenAccountPage.notificationComponent().countNotifications();
			if (afterRead == beforeRead - 1) {
				ExtentTestManager.setPassMessageInReport("After Reading the notification, the count is reducing");
			} else {
				ExtentTestManager.setFailMessageInReport("After Reading the notification, the count is not reducing");
			}
			int beforeUnRead = tokenAccountPage.notificationComponent().countNotifications();
			tokenAccountPage.clickNotificationsIcon();
//			tokenAccountPage.notificationComponent().viewRequest();
//			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().swipeNotificationLeft();
			tokenAccountPage.notificationComponent().clickReadUnRead();
			tokenAccountPage.notificationComponent().navigationComponent().clickBack();
			Thread.sleep(3000);
			int afterUnRead = tokenAccountPage.notificationComponent().countNotifications();
			if (afterUnRead == beforeUnRead + 1) {
				ExtentTestManager.setPassMessageInReport("After Un Reading the notification, the count is increasing");
			} else {
				ExtentTestManager
						.setFailMessageInReport("After Un Reading the notification, the count is not increasing");
			}
			int beforeDelete = tokenAccountPage.notificationComponent().countNotifications();
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().swipeNotificationRight();
			tokenAccountPage.notificationComponent().clickDelete();
			tokenAccountPage.notificationComponent().navigationComponent().clickBack();
			Thread.sleep(3000);
			int afterDelete = tokenAccountPage.notificationComponent().countNotifications();
			if (afterDelete == beforeDelete - 1) {
				ExtentTestManager.setPassMessageInReport("After Deleting notification, the count is reduced");
			} else {
				ExtentTestManager.setFailMessageInReport("After Deleting notification, the count is not reduced");
			}

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
			tokenAccountPage.notificationComponent().clickRequest();
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
			tokenAccountPage.notificationComponent().clickRequest();
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

	@Test // added
	@Parameters({ "strParams" })
	public void testFiltersTypeAndSubType(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.verifyTransactionHeading(data.get("transactionHeading"));
			tokenAccountPage.clickViewMore();
			transactionPage.FiltersComponent().clickFiltersIcon();
			transactionPage.FiltersComponent().clickPayRequest();
			transactionPage.FiltersComponent().clickSent();
			transactionPage.FiltersComponent().fillTransactionAmountFrom(data.get("fromAmount"));
			transactionPage.FiltersComponent().fillTransactionAmountTo(data.get("toAmount"));
			transactionPage.FiltersComponent().datePickerComponent().clickCalendar();
			transactionPage.FiltersComponent().datePickerComponent().selectFromDate(data.get("fromDate"));
			transactionPage.FiltersComponent().datePickerComponent().selectToDate(data.get("toDate"));
			transactionPage.FiltersComponent().datePickerComponent().clickDone();
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
//			tokenAccountPage.clickViewMore();
//			tokenAccountPage.transactionPage().verifyLabelTransactions(data.get("expHeading"));
//			tokenAccountPage.transactionPage().verifySearchOption();
//			tokenAccountPage.transactionPage().verifyFiltersIcon();
//			tokenAccountPage.transactionPage().verifyCloseView();
//			tokenAccountPage.transactionPage().clickOnMessage();
//			if(tokenAccountPage.transactionPage().transactionDetailsComponent()
//					.verifygetSentTransactionDetails().equalsIgnoreCase("Pay / Request - Sent")) {
//				tokenAccountPage.transactionPage().transactionDetailsComponent()
//					.verifySentTransactionDetails(data.get("transactionSentHeading"));
//			tokenAccountPage.transactionPage().transactionDetailsComponent().clickSentBackIcon();	
//			}
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

		} catch (

		Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionList faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionDetails2(String strParams) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickLatestTransaction();
			tokenAccountPage.tokenHomePopUp().transactionDetailsComponent2().getTransactionDetails();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test WithdrawToUSD Via External Bank  failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testScanCode(String strParams) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickScan();
			tokenAccountPage.tokenHomePopUp().scanPage().clickOnWhileUsingApp();
			tokenAccountPage.tokenHomePopUp().scanPage().verifyScanCode();
			tokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().clickFlashLight();
			tokenAccountPage.tokenHomePopUp().scanPage().navigationComponent().clickClose();
//			tokenAccountPage.btnHome();
//			tokenAccountPage.tokenHomePopUp().clickScan();
//			tokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().clickOnAlbum();

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
			tokenAccountPage.tokenHomePopUp().scanPage().verifyScanMe();
			tokenAccountPage.tokenHomePopUp().scanPage().clickScanMe();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().verifylblUserName(data.get("userName"));
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().verifylblProfileWithNoImage(data.get("profile"));
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().verifyQrCode();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickSetAmount();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().setAmountComponent()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().setAmountComponent().clickOk();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickSaveToAlbum();
			Thread.sleep(1000);
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickAllow();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickClearAmount();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickSaveToAlbum();
			Thread.sleep(1000);
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().verifyReceipientAddress();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().clickCopy();
			Thread.sleep(1000);
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanCode  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickPayRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().clickAllow();
			tokenAccountPage.tokenHomePopUp().payRequestPage().verifySearchBx();
			tokenAccountPage.tokenHomePopUp().payRequestPage().verifyRecentContacts();
			tokenAccountPage.tokenHomePopUp().payRequestPage().verifyContactList();
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().verifyName();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().enterMessage(data.get("message"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().clickDone();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().clickPay();
			String amt1 = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.orderPreviewPopup().verifyTransactionTotalAmount();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.enterYourPINComponent().fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.verifyHeading();
			String ref = tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestConfirmPopup().successFailureComponent().getCopiedReference();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.clickDone();
			tokenAccountPage.verifyDashBoard();
			tokenAccountPage.clickLatestTransaction();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().payRequestConfirmPopup()
					.transactionDetailsComponent2().getSentTransactionDetails();
			String amt2 = tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestConfirmPopup().transactionDetailsComponent2().verifyPayTotalAmount();
			if (amt1.equals(amt2)) {
				ExtentTestManager.setInfoMessageInReport("The Total Amount is Same");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Total Amount is not Same");
			}
			String ref1 = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().verifyTransactionReferenceID();
			if (ref.equals(ref1)) {
				ExtentTestManager.setInfoMessageInReport("The Reference ID is Same.");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Reference ID is Different.");
			}
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
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().verifyName();
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
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().verifyName();
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
			tokenAccountPage.tokenHomePopUp().payRequestPage().clickAllow();
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().verifyName();
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
	public void testPayRequestAmountFieldValidationAndMsg(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickPayRequest();
			tokenAccountPage.tokenHomePopUp().payRequestPage().clickAllow();
			tokenAccountPage.tokenHomePopUp().payRequestPage().fillSearchBx(data.get("user"));
			tokenAccountPage.tokenHomePopUp().payRequestPage().selectUser();
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage().verifyName();
			String[] amount = data.get("amount").split(",");
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.fieldValidationsComponent().validateAmount(amount[0], amount[1]);
			tokenAccountPage.tokenHomePopUp().payRequestPage().payandRequestAccountHolderPage()
					.payRequestOptionalPopup().enterMessage(data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayAmountValidation  failed due to exception " + e);
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
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			String total = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.orderPreviewPopup().verifyTransactionTotalAmount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.successFailureComponent().getTokenTransactionStatusDetails();
			String ref = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.successFailureComponent().getCopiedReference();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().successFailureComponent()
					.clickDone();
			Thread.sleep(2000);
			tokenAccountPage.clickLatestTransaction();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().getBuyTokenBankAccountDetails();
			String amt2 = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().verifyWithdrawTotalAmount();
			if (total.equals(amt2)) {
				ExtentTestManager.setInfoMessageInReport("The Total Amount is Same");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Total Amount is not Same");
			}
			String ref1 = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().verifyTransactionReferenceID();
			if (ref.equals(ref1)) {
				ExtentTestManager.setInfoMessageInReport("The Reference ID is Same.");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Reference ID is Different.");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankWithInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			// min amount- 2 CYN
			// exceeds daily limit
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBank  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenBankWithFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			String[] amount = data.get("amount").split(",");
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fieldValidationsComponent()
					.validateAmount(amount[0], amount[1]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenBankFieldValidation  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().successFailureComponent()
					.getTokenTransactionStatusDetails();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().successFailureComponent()
					.clickDone();
			tokenAccountPage.clickLatestTransaction();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().getBuyTokenDebitCardDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenDebit  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokensWithExistingDebitCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickExistingCard();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().fillCvv(data.get("cvv"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().cvvPopup().clickOk();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			String dailyLimitFee = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.orderPreviewPopup().getDailyLimitFeeLabel();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.verifyTotalAmount(dailyLimitFee);
			String total = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.orderPreviewPopup().verifyTransactionTotalAmount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().successFailureComponent()
					.getTokenTransactionStatusDetails();
			String ref = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.successFailureComponent().getCopiedReference();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().successFailureComponent()
					.clickDone();
			Thread.sleep(2000);
			tokenAccountPage.clickLatestTransaction();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().getBuyTokenDebitCardDetails();
			String amt2 = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().verifyWithdrawTotalAmount();
			if (total.equals(amt2)) {
				ExtentTestManager.setInfoMessageInReport("The Total Amount is Same");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Total Amount is not Same");
			}
			String ref1 = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().verifyTransactionReferenceID();
			if (ref.equals(ref1)) {
				ExtentTestManager.setInfoMessageInReport("The Reference ID is Same.");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Reference ID is Different.");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenDebit  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokensWithExistingCardCvvValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickExistingCard();
			String[] cvv = data.get("cvv").split(",");
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().fieldValidationsComponent()
					.validateCardCVVField(cvv[0], cvv[1], cvv[2]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenDebitCvvValidation  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.btnHome();
//			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clickBuyToken();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().enterYourPINComponent()
					.fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().successFailureComponent()
					.getTokenTransactionStatusDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenCredit  failed due to exception " + e);
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
			String errMessage[] = data.get("errMessage").split("-");
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickBuyTokens();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent()
					.verifyHeading(data.get("buyTokenHeading"));
			// min amt//
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fillAmount(data.get("amount"));
			new CommonFunctions().validateErrMsg(errMessage[0]);
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clearText();
			// limit//
			float limit = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().getDailyOrWeeklyLimitAmount();
			String dailyOrWeeklyLimitText = tokenAccountPage.tokenHomePopUp().paymentMethodsPage()
					.withdrawMenuComponent().withdrawToUSDInstantPayPopup().getDailyOrWeeklyLimitText();
			ExtentTestManager.setInfoMessageInReport(String.format("Same Limit", limit));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fillAmount(Float.toString(limit + 1));

			if ((dailyOrWeeklyLimitText).contains("daily")) {
				new CommonFunctions().validateErrMsg(errMessage[1]);
			} else if (dailyOrWeeklyLimitText.contains("weekly")) {
				new CommonFunctions().validateErrMsg(errMessage[2]);
			}

			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clearText();
			String[] amount1 = data.get("amount1").split(",");
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fieldValidationsComponent()
					.validateAmount(amount1[0], amount1[1]);
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
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clearText();
			ExtentTestManager.setInfoMessageInReport("Test Field validation for Buy Token Debit Card");
			String[] amount1 = data.get("amount1").split(",");
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fieldValidationsComponent()
					.validateAmount(amount1[0], amount1[1]);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithDebitCardInvalidData  failed due to exception " + e);
		}

	}

	public void testBuyTokenWithInvalidCardNumber(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (card.equalsIgnoreCase("credit")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickCreditCard();
			} else {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickDebitCard();
			}
			// tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickDebitCard();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().addCardPage().fillNameOnCard(data.get("nameOnCard"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().addCardPage().fillCardNumber(data.get("cardNumber"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().addCardPage().fillCardExp(data.get("cardExp"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().addCardPage().fillCVVorCVC(data.get("cvvOrCVC"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().addCardPage().clickNext();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().addCardPage().verifyCardError(data.get("heading"),
					data.get("errMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithInvalidCardNumber  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithInvalidDebitNumber(String strParams) {
		tokenAccountPage.btnHome();
		tokenAccountPage.tokenHomePopUp().clickBuyTokens();
		testBuyTokenWithInvalidCardNumber(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithInvalidCreditNumber(String strParams) {
		tokenAccountPage.btnHome();
		tokenAccountPage.tokenHomePopUp().clickBuyTokens();
		testBuyTokenWithInvalidCardNumber(strParams, "credit");

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
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().clearText();
			ExtentTestManager.setInfoMessageInReport("Test Field validation for Buy Token Credit Card");
			String[] amount1 = data.get("amount1").split(",");
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().fieldValidationsComponent()
					.validateAmount(amount1[0], amount1[1]);

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
			if (data.get("validateGiftCard").equalsIgnoreCase("yes")) {
				tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			} else {
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
			// Thread.sleep(2000);
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
	public void testWithdrawnToUSDGiftCardInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			String[]errMessage = data.get("errMessage").split("-");
			float availableBal = tokenAccountPage.getAvailableBalance();
			ExtentTestManager.setInfoMessageInReport(String.format("available balance: ", availableBal));
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickGiftCard();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.verifyGiftCardHeading(data.get("cardHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.verifyBrandHeading(data.get("poplurHeading"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
					.verifyWithdrawGiftCard(data.get("giftCardHeading"));
			if (data.get("validateAvailableBalance").equalsIgnoreCase("Yes")) {
				tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
						.fillAmt(Float.toString(availableBal));
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
				tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clearText();
			}
			if (data.get("validateMoreThanAvailable").equalsIgnoreCase("Yes")) {
				tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage()
						.fillAmt(Float.toString(availableBal + 1));
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
				tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clearText();
			}
			if (data.get("validateMinAmount").equalsIgnoreCase("Yes")) {
				tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().fillAmt(data.get("amount"));
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
				tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().clearText();

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
//			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
//					.enterYourPINComponent().clickForgotPin();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
					.enterYourPINComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
		}
	}

	public void testWithdrawToken(String strParams, String method) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (method.equalsIgnoreCase("bank")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().clickBankAccount();
			}

			if (!method.equalsIgnoreCase("bank")) {
				// tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();

//				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
//						.withdrawToUSDInstantPayPopup().clickDebitCard();
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
		tokenAccountPage.btnHome();
		tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
		testWithdrawToken(strParams, "bank");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithInstantPay(String strParams) {
//		tokenAccountPage.btnHome();
//		tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
		testWithdrawToken(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithExistingCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickExistingCard();
			String dailyLimitFee = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.orderPreviewPopup().getDailyLimitFeeLabel();
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
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().buyTokenComponent().orderPreviewPopup()
					.verifyTotalAmount(dailyLimitFee);
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.getAmount();
			String amt1 = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.orderPreviewPopup().verifyTransactionTotalAmount();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.verifySlideText();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.swipeConfirm();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.enterYourPINComponent().fillPin(data.get("pin"));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.successFailureComponent().getTokenTransactionStatusDetails();
			String str = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.orderPreviewPopup().successFailureComponent().getCopiedReference();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().orderPreviewPopup()
					.successFailureComponent().clickDone();
//			Thread.sleep(1000);
			tokenAccountPage.verifyDashBoard();
			// tokenAccountPage.clickViewMore();
//			Thread.sleep(2000);
			tokenAccountPage.clickLatestTransaction();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().getWithdrawInstantPayDetails();
			String amt2 = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().verifyWithdrawTotalAmount();
			if (amt1.equals(amt2)) {
				ExtentTestManager.setInfoMessageInReport("The Total Amount is Same");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Total Amount is not Same");
			}
			String str2 = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.transactionDetailsComponent2().verifyTransactionReferenceID();
			if (str.equals(str2)) {
				ExtentTestManager.setInfoMessageInReport("The Reference ID is Same.");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Reference ID is Different.");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawTokenWithInstantPayWithNavigationOptions  failed due to exception " + e);
		}

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
		//	Map<String, String> data = Runner.getKeywordParameters(strParams);
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
			String errMessage[] = data.get("errMessage").split("-");
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickWithdrawToUSD();
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.verifyWithdrawHeading(data.get("withdrawMethodHeading"));
			if (data.get("validateInstantPay").equalsIgnoreCase("Yes")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent().clickInstantPay();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickOnDebitCard();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			}
			if (data.get("validateBankAccount").equalsIgnoreCase("Yes")) {
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickBank();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().clickBankAccount();
				tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
						.withdrawToUSDInstantPayPopup().verifyWithdrawTokenHeading(data.get("withdrawTokenHeading"));
			}
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fillAmount(data.get("amount"));
			new CommonFunctions().validateErrMsg(errMessage[0]);
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clearText();

			float availableBal = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().getAvailableBalance();
			ExtentTestManager.setInfoMessageInReport(String.format("More than Available Balance", availableBal));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fillAmount(Float.toString(availableBal + 1));
			new CommonFunctions().validateErrMsg(errMessage[1]);
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clearText();

			ExtentTestManager.setInfoMessageInReport(String.format("Same as Available Balance", availableBal));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fillAmount(Float.toString(availableBal));
			new CommonFunctions().validateErrMsg(errMessage[2]);
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clearText();

			float limit = tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().getDailyOrWeeklyLimitAmount();
			String dailyOrWeeklyLimitText = tokenAccountPage.tokenHomePopUp().paymentMethodsPage()
					.withdrawMenuComponent().withdrawToUSDInstantPayPopup().getDailyOrWeeklyLimitText();
			ExtentTestManager.setInfoMessageInReport(String.format("Same Limit", limit));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fillAmount(Float.toString(limit));

			if (availableBal > limit) {
				if ((dailyOrWeeklyLimitText).contains("daily")) {
					new CommonFunctions().validateErrMsg(errMessage[3]);
				} else if (dailyOrWeeklyLimitText.contains("weekly")) {
					new CommonFunctions().validateErrMsg(errMessage[4]);
				} else {
					new CommonFunctions().validateErrMsg(errMessage[5]);
				}
			} else {
				new CommonFunctions().validateErrMsg(errMessage[1]);
			}
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clearText();

			ExtentTestManager.setInfoMessageInReport(String.format("More than Limit", limit));
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fillAmount(Float.toString(limit + 1));

			if (availableBal > limit) {
				if ((dailyOrWeeklyLimitText).contains("daily")) {
					new CommonFunctions().validateErrMsg(errMessage[6]);
				} else if (dailyOrWeeklyLimitText.contains("weekly")) {
					new CommonFunctions().validateErrMsg(errMessage[7]);
				} else {
					new CommonFunctions().validateErrMsg(errMessage[8]);
				}
			} else {
				new CommonFunctions().validateErrMsg(errMessage[1]);
			}
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().clearText();
			ExtentTestManager.setInfoMessageInReport("Test Field validation for Withdraw");
			String[] amount1 = data.get("amount1").split(",");
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fieldValidationsComponent().validateAmount(amount1[0], amount1[1]);
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().enterMessage(data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"testWithdrawToUSDViaInstantPayWithInvalidDetails failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawToUSDViaInstantPayWithMinAmt(String strParams) {
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
					.withdrawToUSDInstantPayPopup().fillAmount(data.get("amount"));
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
	public void testWithdrawViaInstantPayAmtFieldValidationAndMsg(String strParams) {
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
			String[] amount = data.get("amount").split(",");
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().fieldValidationsComponent().validateAmount(amount[0], amount[1]);
			tokenAccountPage.tokenHomePopUp().paymentMethodsPage().withdrawMenuComponent()
					.withdrawToUSDInstantPayPopup().enterMessage(data.get("message"));

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
					.orderPreviewPopup().enterYourPINComponent().successFailureComponent()
					.getTokenTransactionStatusDetails();
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
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickOnBank();
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
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickOnBank();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.verifyWithdrawTokenHeading(data.get("withdrawToken"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickArrow();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.verifyPaymentHeading(data.get("paymentMethod"));
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickOnBank();
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
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickOnBank();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup()
					.navigationComponent().clickBack();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().clickWithdrawBankAccount();
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickOnBank();
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
			tokenAccountPage.tokenHomePopUp().withdrawMenuComponent().withdrawToUSDBankAccountPopup().clickOnBank();
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

	@Test
	@Parameters({ "strParams" })
	public void testfilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// Thread.sleep(2500);
			tokenAccountPage.clickViewMore();
			tokenAccountPage.transactionPage().verifyHeading(data.get("transactionHeading"));
			tokenAccountPage.transactionPage().clickfilter();
			tokenAccountPage.transactionPage().filtersPopup().selectFilterType(data.get("filterType"));
			tokenAccountPage.transactionPage().filtersPopup().clickApplyfilters();
//			tokenAccountPage.transactionPage().ScrollTransactions();
			Thread.sleep(2000);
//          tokenAccountPage.transactionPage().getUITransactionCount();
			tokenAccountPage.transactionPage().clickFirstTransaction();
			// Thread.sleep(2000);
			// tokenAccountPage.transactionPage().getUITransactionCount();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testfilters  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testfilterSubType(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// Thread.sleep(2500);
			tokenAccountPage.clickViewMore();
			tokenAccountPage.transactionPage().verifyHeading(data.get("transactionHeading"));
			tokenAccountPage.transactionPage().clickfilter();
			tokenAccountPage.transactionPage().filtersPopup().selectFilterSubType(data.get("filterSubType"));
			tokenAccountPage.transactionPage().filtersPopup().clickApplyfilters();
//			tokenAccountPage.transactionPage().ScrollTransactions();
			Thread.sleep(2000);
//          tokenAccountPage.transactionPage().getUITransactionCount();
			tokenAccountPage.transactionPage().clickFirstTransaction();
			// Thread.sleep(2000);
			// tokenAccountPage.transactionPage().getUITransactionCount();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testfilters  failed due to exception " + e);
		}
	}

	@Test

	@Parameters({ "strParams" })

	public void testFilterWithCalendar(String strParams) {

		try {

			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2500);
			tokenAccountPage.clickViewMore();
			tokenAccountPage.transactionPage().verifyHeading(data.get("transactionHeading"));
			tokenAccountPage.transactionPage().clickfilter();
			tokenAccountPage.transactionPage().filtersPopup().selectFilterType(data.get("filterType"));
			tokenAccountPage.transactionPage().filtersPopup().selectFilterSubType(data.get("filterType1"));
			tokenAccountPage.transactionPage().filtersPopup().selectFilterSubType(data.get("filterType2"));
			tokenAccountPage.transactionPage().filtersPopup().fillFromAmount(data.get("fromAmount"));
			tokenAccountPage.transactionPage().filtersPopup().fillToAmount(data.get("toAmount"));
			tokenAccountPage.transactionPage().filtersPopup().clickCalender();
			Thread.sleep(2000);
			tokenAccountPage.transactionPage().filtersPopup().datePickerComponent()
					.selectFromDate(data.get("fromDate"));
			tokenAccountPage.transactionPage().filtersPopup().datePickerComponent().selectToDate(data.get("toDate"));
			tokenAccountPage.transactionPage().filtersPopup().clickApplyfilters();
			//Thread.sleep(2000);
			tokenAccountPage.transactionPage().ScrollTransactions();
			//Thread.sleep(2000);
			tokenAccountPage.transactionPage().getUITransactionCount();
			Thread.sleep(2000);
			tokenAccountPage.transactionPage().clickfilter();
			tokenAccountPage.transactionPage().filtersPopup().clickResetAllFilters();
			tokenAccountPage.transactionPage().filtersPopup().clickApplyfilters();
			// tokenAccountPage.transactionPage().filtersPopup().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testfiltersWithCalender failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFilterWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2500);
			tokenAccountPage.clickViewMore();
			tokenAccountPage.transactionPage().verifyHeading(data.get("transactionHeading"));
			tokenAccountPage.transactionPage().clickfilter();
			tokenAccountPage.transactionPage().filtersPopup().fillFromAmount(data.get("fromAmount"));
			Thread.sleep(2000);
			tokenAccountPage.transactionPage().filtersPopup().fillToAmount(data.get("toAmount"));
			transactionPage.FiltersComponent().datePickerComponent().clickCalendar();
			transactionPage.FiltersComponent().datePickerComponent().selectFromDate(data.get("fromDate"));
			transactionPage.FiltersComponent().datePickerComponent().selectToDate(data.get("toDate"));
			transactionPage.FiltersComponent().datePickerComponent().clickDone();
//          tokenAccountPage.transactionPage().filtersPopup().clickCalender();
			tokenAccountPage.transactionPage().filtersPopup().clickApplyfilters();
//          tokenAccountPage.transactionPage().filtersPopup();
			tokenAccountPage.transactionPage().filtersPopup().permissionAlert().verifyErrorMessage(data.get("errMsg"));
			tokenAccountPage.transactionPage().filtersPopup().permissionAlert().clickOk();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testfiltersWithInvalidData  failed due to exception " + e);
		}
	}

	@Test
//	@Parameters({ "strParams" })
	public void testAllLinksDashBoard() {
		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.btnHome();
			tokenAccountPage.tokenHomePopUp().clickScan();
			tokenAccountPage.tokenHomePopUp().scanPage().clickOnWhileUsingApp();
			tokenAccountPage.tokenHomePopUp().scanPage().verifyScanCode();
			tokenAccountPage.tokenHomePopUp().scanPage().scanCodePage().verifyScanCode();
			tokenAccountPage.tokenHomePopUp().scanPage().clickScanMe();
			tokenAccountPage.tokenHomePopUp().scanPage().verifyScanMe();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().verifyQrCode();
			tokenAccountPage.tokenHomePopUp().scanPage().scanMePage().navigationComponent().clickClose();
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().verifyNotifdate();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().navigationComponent().clickBack();
			tokenAccountPage.btnScan();
			tokenAccountPage.navigationComponent().clickClose();
			tokenAccountPage.clickViewMore();
			tokenAccountPage.transactionPage().verifyTransactionsHeading();
			tokenAccountPage.transactionPage().clickOnMessage();
			tokenAccountPage.transactionPage().transactionDetailsComponent().verifyTransactionDetails();
			tokenAccountPage.transactionPage().transactionDetailsComponent().navigationComponent().clickBack();
			tokenAccountPage.transactionPage().navigationComponent().clickClose();
			tokenAccountPage.clickImgProfile();
			tokenAccountPage.verifyImgProfile();
			tokenAccountPage.navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAllLinksDashBoard  failed due to exception " + e);

		}
	}

}
