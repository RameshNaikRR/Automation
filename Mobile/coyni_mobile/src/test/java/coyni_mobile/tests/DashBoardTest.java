package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.DashboardPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class DashBoardTest {

	DashboardPage dashboardPage;
	CustomerProfilePage customerProfilePage;

	@BeforeTest
	public void init() {
		dashboardPage = new DashboardPage();
		customerProfilePage = new CustomerProfilePage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotifications(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			int beforeRead = dashboardPage.notificationsPage().countNotifications();
			ExtentTestManager.setPassMessageInReport("Before preform the action on notifications, the count is");
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().verifyMesaageTitle();
			dashboardPage.notificationsPage().verifyMessageBody();
			dashboardPage.notificationsPage().verifyTime();
			dashboardPage.notificationsPage().swipeNotificationLeft();
			dashboardPage.notificationsPage().verifyRead();
			dashboardPage.notificationsPage().navigationComponent().clickBack();
			dashboardPage.viewUserName();
			int afterRead = dashboardPage.notificationsPage().countNotifications();
			if (beforeRead == afterRead + 1) {
				ExtentTestManager.setPassMessageInReport("After Reading the notification, the count is reducing");
			} else {
				ExtentTestManager.setFailMessageInReport("After Reading the notification, the count is not reducing");
			}
			int beforeUnRead = dashboardPage.notificationsPage().countNotifications();
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().swipeNotificationLeft();
			dashboardPage.notificationsPage().verifyUnRead();
			dashboardPage.notificationsPage().navigationComponent().clickBack();
			dashboardPage.viewUserName();
			int afterUnRead = dashboardPage.notificationsPage().countNotifications();
			if (beforeUnRead == afterUnRead - 1) {
				ExtentTestManager.setPassMessageInReport("After Un Reading the notification, the count is increasing");
			} else {
				ExtentTestManager
						.setFailMessageInReport("After Un Reading the notification, the count is not increasing");
			}
			int beforeDelete = dashboardPage.notificationsPage().countNotifications();
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().swipeNotificationRight();
			dashboardPage.notificationsPage().navigationComponent().clickBack();
			dashboardPage.viewUserName();
			int afterDelete = dashboardPage.notificationsPage().countNotifications();
			if (beforeDelete == afterDelete + 1) {
				ExtentTestManager.setPassMessageInReport("After Deleting the notification, the count is reducing");
			} else {
				ExtentTestManager
						.setFailMessageInReport("After Un Reading the notification, the count is not reducing");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotifications faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationSend(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().viewSend();
			dashboardPage.notificationsPage().clickSend();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.notificationsPage().sendRequestPaymentPage().verifyAmount();
			dashboardPage.notificationsPage().sendRequestPaymentPage().verifyPreview();
			dashboardPage.notificationsPage().sendRequestPaymentPage().clickConfirm();
			dashboardPage.notificationsPage().sendRequestPaymentPage().choosePinComponent().fillPin(data.get("pin"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationPay faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().viewDeny();
			dashboardPage.notificationsPage().viewSend();
			dashboardPage.notificationsPage().clickDeny();
			dashboardPage.notificationsPage().verifyDenyMessage(data.get("denyMessage"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationDeny faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestReminder(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().clickRequest();
			dashboardPage.notificationsPage().clickRemainder();
			dashboardPage.notificationsPage().verifyReminderMessage(data.get("reminderMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestReminder faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestCancel(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().clickRequest();
			dashboardPage.notificationsPage().clickCancel();
			dashboardPage.notificationsPage().verifyCancelMessage(data.get("cancelMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestCancel faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestSend(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().clickRequest();
			dashboardPage.notificationsPage().clickSend();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.notificationsPage().sendRequestPaymentPage().verifyAmount();
			dashboardPage.notificationsPage().sendRequestPaymentPage().verifyPreview();
			dashboardPage.notificationsPage().sendRequestPaymentPage().verifyLockSwipe();
			dashboardPage.notificationsPage().sendRequestPaymentPage().verifySlideText();
			dashboardPage.notificationsPage().sendRequestPaymentPage().clickConfirm();
			dashboardPage.notificationsPage().sendRequestPaymentPage().choosePinComponent().fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestPay faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().clickRequest();
			dashboardPage.notificationsPage().clickDeny();
			dashboardPage.notificationsPage().verifyDenyMessage(data.get("denyMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestDeny faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testSend(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			double avlBalDasBoard = dashboardPage.verifyAvailbleBalance();
			dashboardPage.clickSendRequest();
			dashboardPage.sendRequestPage().verifySendRequestPageView();
			if (data.get("chooseSendMethod").equalsIgnoreCase("withName")) {
				dashboardPage.sendRequestPage().fillSearchBx(data.get("name"));
				dashboardPage.sendRequestPage().selectUser();
			} else if (data.get("chooseSendMethod").equalsIgnoreCase("withAccount")) {
				dashboardPage.sendRequestPage().fillSearchBx(data.get("accountAddress"));
				dashboardPage.sendRequestPage().selectUser();
			} else {
				dashboardPage.sendRequestPage().verifyRecentContactListSize();
				dashboardPage.sendRequestPage().verifyfirstRecentContact();
			}
			String contactName = dashboardPage.sendRequestPage().verifyfirstRecentContact();
			String Name = dashboardPage.sendRequestPage().verifyName();
			if (data.get("name").equals(Name) || data.get("accountAddress").equals(Name) || contactName.equals(Name)) {
				ExtentTestManager.setPassMessageInReport(
						"Selcted contact name is appeared correctly in Send/Request Payment screen");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"Selcted contact name is not appeared correctly in Send/Request Payment screen");
			}
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().clickMessageButton();
			dashboardPage.sendRequestPage().optionalMessagePopup().fillMessage(data.get("message"));
			dashboardPage.sendRequestPage().optionalMessagePopup().validateMessageField();
			dashboardPage.sendRequestPage().optionalMessagePopup().clickDone();
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().viewSender();
			int avaBalConfirmPopup = dashboardPage.sendRequestPage().verifyAvailbleBalance();
			if (avlBalDasBoard == avaBalConfirmPopup) {
				ExtentTestManager.setPassMessageInReport(
						"The Same Available Balance is showing in Dash baord and Send Confirm popup");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"The Same Available Balance is not showing in Dash baord and Send Confirm popup");
			}
			dashboardPage.sendRequestPage().clickConfirm();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPay  failed due to exception " + e);
		}
	}

	/**
	 * testRequest script is to test requesting amount from other users to pay in
	 * notifications.
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testRequest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickSendRequest();
			dashboardPage.sendRequestPage().verifySendRequestPageView();
			if (data.get("chooseRequestMethod").equalsIgnoreCase("withName")) {
				dashboardPage.sendRequestPage().fillSearchBx(data.get("name"));
				dashboardPage.sendRequestPage().selectUser();
			} else if (data.get("chooseRequestMethod").equalsIgnoreCase("withAccount")) {
				dashboardPage.sendRequestPage().fillSearchBx(data.get("accountAddress"));
				dashboardPage.sendRequestPage().selectUser();
			} else {
				dashboardPage.sendRequestPage().verifyRecentContactListSize();
				dashboardPage.sendRequestPage().verifyfirstRecentContact();
			}
			String contactName = dashboardPage.sendRequestPage().verifyfirstRecentContact();
			String Name = dashboardPage.sendRequestPage().verifyName();
			if (data.get("name").equals(Name) || data.get("accountAddress").equals(Name) || contactName.equals(Name)) {
				ExtentTestManager.setPassMessageInReport(
						"Selcted contact name is appeared correctly in Send/Request Payment screen");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"Selcted contact name is not appeared correctly in Send/Request Payment screen");
			}
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().clickMessageButton();
			dashboardPage.sendRequestPage().optionalMessagePopup().fillMessage(data.get("message"));
			dashboardPage.sendRequestPage().optionalMessagePopup().clickDone();
			dashboardPage.sendRequestPage().clickRequest();
			dashboardPage.sendRequestPage().viewRequestingHeading();
			int amtPopup = dashboardPage.sendRequestPage().verifyAmount();
			String receiptentPopup = dashboardPage.sendRequestPage().verifyReceiptentName();
			String message = dashboardPage.sendRequestPage().verifyMessage();
			if (data.get("amount").equals(amtPopup) || Name.equals(receiptentPopup)
					|| data.get("message").equals(message)) {
				ExtentTestManager.setPassMessageInReport("All the details of Request Confirm popup are accurate");
			} else {
				ExtentTestManager.setFailMessageInReport("All the details of Request Confirm popup are not accurate");
			}
			dashboardPage.sendRequestPage().clickConfirm();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().fillPin(data.get("pin"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifyHeading(data.get("requestSuccHeading"));
			String ReciptentName = dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifyReceiptentName();
			int Amount = dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().verifyAmount();
			if (data.get("amount").equals(Amount) && ReciptentName.equals(receiptentPopup)) {
				ExtentTestManager.setPassMessageInReport("All the details of Request Confirm popup are accurate");
			} else {
				ExtentTestManager.setFailMessageInReport("All the details of Request Confirm popup are not accurate");
			}
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequest  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSendWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickSendRequest();
			dashboardPage.sendRequestPage().verifySendRequestPageView();
			dashboardPage.sendRequestPage().verifyRecentContactListSize();
			dashboardPage.sendRequestPage().verifyfirstRecentContact();
			dashboardPage.sendRequestPage().verifyName();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			if (!data.get("errMsg").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("elementName"));
			}
			if (!data.get("errPopupHeading").isEmpty()) {
				dashboardPage.sendRequestPage().clickSend();
				dashboardPage.sendRequestPage().verifyPopupHeading(data.get("errPopupHeading"));
				dashboardPage.sendRequestPage().verifypopupDes(data.get("errPopupDes"));
				dashboardPage.sendRequestPage().clickReload();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayWithInvalidData  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSendRequestNavigations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickSendRequest();
			dashboardPage.sendRequestPage().clickScan();
			dashboardPage.sendRequestPage().verifyScanCodePage();
			dashboardPage.sendRequestPage().clickCross();
			dashboardPage.sendRequestPage().verifySendRequestPageView();
			dashboardPage.sendRequestPage().clickScan();
			dashboardPage.sendRequestPage().clickMyQRCode();
			dashboardPage.sendRequestPage().clickCross();
			dashboardPage.sendRequestPage().verifySendRequestPageView();
			dashboardPage.sendRequestPage().verifyfirstRecentContact();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("errPopupHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickNewAmount();
			dashboardPage.sendRequestPage().verifyResetAmount();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("errPopupHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickReload();
			dashboardPage.sendRequestPage().reloadPopup().verifyReloadHeading(data.get("reloadAmtHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickPaymentMethod();
			dashboardPage.sendRequestPage().reloadPopup().clickAddPayment();
			dashboardPage.sendRequestPage().reloadPopup().verifyAddPaymnetHeading(data.get("addPaymentHeading"));
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.sendRequestPage().reloadPopup().verifyReloadHeading(data.get("reloadAmtHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickProcessingFee();
			dashboardPage.sendRequestPage().reloadPopup().clickViewFees();
			dashboardPage.sendRequestPage().reloadPopup().viewWalletFees();
			dashboardPage.navigationComponent().clickBack();
			dashboardPage.sendRequestPage().clickNativeKeyBack();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().clickRequest();
			dashboardPage.sendRequestPage().viewRequestingHeading();
			dashboardPage.sendRequestPage().clickNativeKeyBack();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().clickRequest();
			dashboardPage.sendRequestPage().viewRequestingHeading();
			dashboardPage.sendRequestPage().clickConfirm();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.sendRequestPage().clickContinue();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.sendRequestPage().clickDisCard();
			dashboardPage.verifyDashboard();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayWithInvalidData  failed due to exception " + e);
		}
	}

	/**
	 * testfilters script is to test the transactions by applying filters.
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testfilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickViewAllTransactions();
			dashboardPage.transactionPage().verifyHeading(data.get("transactionHeading"));
			dashboardPage.transactionPage().clickFilters();
			if (data.get("validateFilterType").equalsIgnoreCase("Yes")) {
				dashboardPage.transactionPage().filtersPopup().selectFilterPlus(data.get("filterType"));
			}
			dashboardPage.transactionPage().filtersPopup().selectFilter(data.get("filterType1"));
			dashboardPage.transactionPage().filtersPopup().clickApplyfilters();
			Thread.sleep(2000);
			dashboardPage.transactionPage().clickFirstTransaction();
			dashboardPage.transactionPage().ScrollTransactions();
			Thread.sleep(1000);
			dashboardPage.transactionPage().getUITransactionCount();
			dashboardPage.transactionPage().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testfilters  failed due to exception " + e);
		}
	}

	/**
	 * testFilterWithCalendar script is to test the transactions applying filters
	 * with date.
	 * 
	 * @param strParams
	 */

	@Test
	@Parameters({ "strParams" })
	public void testFilterWithCalendar(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2500);
			dashboardPage.clickViewAllTransactions();
			dashboardPage.transactionPage().verifyHeading(data.get("transactionHeading"));
			dashboardPage.transactionPage().clickfilter();
			dashboardPage.transactionPage().filtersPopup().selectFilter(data.get("filterType"));
			dashboardPage.transactionPage().filtersPopup().selectFilter(data.get("filterType1"));
			dashboardPage.transactionPage().filtersPopup().selectFilter(data.get("filterType2"));
			dashboardPage.transactionPage().filtersPopup().selectFilter(data.get("filterType3"));
			dashboardPage.transactionPage().filtersPopup().selectFilter(data.get("filterType4"));
			// dashboardPage.transactionPage().filtersPopup().selectFilter(data.get("filterType5"));
			dashboardPage.transactionPage().filtersPopup().fillFromAmount(data.get("fromAmount"));
			dashboardPage.transactionPage().filtersPopup().fillToAmount(data.get("toAmount"));
			dashboardPage.transactionPage().filtersPopup().clickCalender();
			dashboardPage.transactionPage().filtersPopup().calendarComponent().selectFromDate();
			dashboardPage.transactionPage().filtersPopup().calendarComponent().clickDone();
			dashboardPage.transactionPage().filtersPopup().clickApplyfilters();
			Thread.sleep(2000);
			dashboardPage.transactionPage().ScrollTransactions();
			Thread.sleep(2000);
			dashboardPage.transactionPage().getUITransactionCount();
			Thread.sleep(2000);
			dashboardPage.transactionPage().clickfilter();
			dashboardPage.transactionPage().filtersPopup().clickResetAllFilters();
			dashboardPage.transactionPage().filtersPopup().clickApplyfilters();
			dashboardPage.transactionPage().filtersPopup().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testfilters  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFilterWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2500);
			dashboardPage.clickViewAllTransactions();
			dashboardPage.transactionPage().verifyHeading(data.get("transactionHeading"));
			dashboardPage.transactionPage().clickfilter();
			dashboardPage.transactionPage().filtersPopup().fillFromAmount(data.get("fromAmount"));
			dashboardPage.transactionPage().filtersPopup().fillToAmount(data.get("toAmount"));
			// tokenAccountPage.transactionPage().filtersPopup().clickCalender();
			dashboardPage.transactionPage().filtersPopup().clickApplyfilters();
			// tokenAccountPage.transactionPage().filtersPopup();
			dashboardPage.transactionPage().filtersPopup().verifyErrorMessage1(data.get("errMsg1"));
			dashboardPage.transactionPage().filtersPopup().clickOk();
			dashboardPage.transactionPage().filtersPopup().fillFromAmount(data.get("fromAmount1"));
			dashboardPage.transactionPage().filtersPopup().fillToAmount(data.get("toAmount1"));
			dashboardPage.transactionPage().filtersPopup().clickApplyfilters();
			dashboardPage.transactionPage().filtersPopup().verifyErrorMessage2(data.get("errMsg2"));
			dashboardPage.transactionPage().filtersPopup().clickOk();
			dashboardPage.transactionPage().filtersPopup().fillFromAmount(data.get("fromAmount2"));
			dashboardPage.transactionPage().filtersPopup().fillToAmount(data.get("toAmount2"));
			dashboardPage.transactionPage().filtersPopup().clickApplyfilters();
			dashboardPage.transactionPage().filtersPopup().verifyErrorMessage3(data.get("errMsg3"));
			dashboardPage.transactionPage().filtersPopup().clickOk();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testfilters  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			customerProfileTest.testDeleteDebitCards(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickBuyTokens();
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			if (data.get("verifyBuyTokenWithExistingCard").equalsIgnoreCase("yes")) {
				customerProfileTest.testAddCard(strParams);
			} else {
				if (data.get("cardHeading").equals("Add New Debit Card")) {
					dashboardPage.buyTokenComponent().clickDebitCard();
					dashboardPage.cvvPopup().verifyPopupHeading(data.get("cvvHeading"));
					dashboardPage.cvvPopup().fillCvv(data.get("cvv"));
					dashboardPage.cvvPopup().clickOk();
				} else {
					dashboardPage.buyTokenComponent().clickCreditCard();
					dashboardPage.cvvPopup().verifyPopupHeading(data.get("cvvHeading"));
					dashboardPage.cvvPopup().fillCvv(data.get("cvv"));
					dashboardPage.cvvPopup().clickOk();
				}
			}
			testBuyTokenProcedure(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithCards failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickBuyTokens();
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			if (data.get("verifyBuyTokenWithExistingCard").equalsIgnoreCase("yes")) {
				customerProfileTest.testAddBankAccount(strParams);
			} else {
				dashboardPage.buyTokenComponent().clickBank();
			}
			testBuyTokenProcedure(strParams);
//			businessTransactionDetailsTest.testVerifyBuyTokenBankTransaction(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	public void testBuyTokenProcedure(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.buyTokenComponent().verifyBuyTokenHeading(data.get("tokensHeading"));
			dashboardPage.buyTokenComponent().fillAmount(data.get("amount"));
			dashboardPage.buyTokenComponent().viewDailyLimits();
			dashboardPage.buyTokenComponent().clickBuyToken();
			dashboardPage.buyTokenComponent().reloadPopup().verifyYouWillRecveHeading(data.get("orderPopupHeading"));
			if (!(dashboardPage.buyTokenComponent().reloadPopup().verifyProcessingFee() == 0)) {
				dashboardPage.buyTokenComponent().reloadPopup().clickProcessingFee();
				dashboardPage.buyTokenComponent().reloadPopup().validateProcessingFees(data.get("amount"));
			} else {
				dashboardPage.buyTokenComponent().reloadPopup().validateWithoutProcessingFee(data.get("amount"));
			}
			dashboardPage.buyTokenComponent().reloadPopup().clickConfirm();
			dashboardPage.buyTokenComponent().choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			dashboardPage.buyTokenComponent().choosePinComponent().fillPin(data.get("pin"));
			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent()
					.verifyPurchaseComplete(data.get("successHeading"));
			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent()
					.verifyPurchaseCompleteDesc(data.get("successDescription"));
			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent()
					.verifyAmount(data.get("amount"));
//			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent().clickViewTransaction();
			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			customerProfileTest.testDeleteBanks(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDeleteBankAccount Failed due to this Exception" + e);
		}

	}

//	Withdraw Tokens 

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithCards(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickWithdraw();
			dashboardPage.withdrawTokenPage().verifyWithdrawHeading(data.get("heading"));
			dashboardPage.withdrawTokenPage().clickInstantPay();
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			if (data.get("verifyBuyTokenWithExistingCard").equalsIgnoreCase("yes")) {
				customerProfileTest.testAddCard(strParams);
			} else {
				dashboardPage.buyTokenComponent().clickDebitCard();
			}
			testWithdrawTokenProcedure(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithCards failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickWithdraw();
			dashboardPage.withdrawTokenPage().verifyWithdrawHeading(data.get("heading"));
			dashboardPage.withdrawTokenPage().clickBankAccounts();
			CustomerProfileTest customerProfileTest = new CustomerProfileTest();
			if (data.get("verifyBuyTokenWithExistingCard").equalsIgnoreCase("yes")) {
				customerProfileTest.testAddBankAccount(strParams);
			} else {
				dashboardPage.withdrawTokenPage().clickBank();
			}
			testWithdrawTokenProcedure(strParams);
//			businessTransactionDetailsTest.testVerifyBuyTokenBankTransaction(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	public void testWithdrawTokenProcedure(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.withdrawTokenPage().verifyWithdrawTokenHeading(data.get("tokensHeading"));
			dashboardPage.withdrawTokenPage().fillAmount(data.get("amount"));
			dashboardPage.withdrawTokenPage().viewDailyLimits();
			dashboardPage.withdrawTokenPage().fillAddNote(data.get("noteMsg"));
			dashboardPage.withdrawTokenPage().clickWithdrawToken();
			dashboardPage.withdrawTokenPage().reloadPopup().verifyYouWillRecveHeading(data.get("orderPopupHeading"));
			if (!(dashboardPage.withdrawTokenPage().reloadPopup().verifyProcessingFee() == 0)) {
				dashboardPage.withdrawTokenPage().reloadPopup().clickProcessingFee();
				dashboardPage.withdrawTokenPage().reloadPopup().validateProcessingFees(data.get("amount"));
			} else {
				dashboardPage.withdrawTokenPage().reloadPopup().validateWithoutProcessingFee(data.get("amount"));
			}
			dashboardPage.withdrawTokenPage().reloadPopup().clickConfirm();
			dashboardPage.withdrawTokenPage().choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			dashboardPage.withdrawTokenPage().choosePinComponent().fillPin(data.get("pin"));
			dashboardPage.withdrawTokenPage().choosePinComponent().successFailureComponent()
					.verifyPurchaseComplete(data.get("successHeading"));
			dashboardPage.withdrawTokenPage().choosePinComponent().successFailureComponent()
					.verifyPurchaseCompleteDesc(data.get("successDescription"));
			dashboardPage.withdrawTokenPage().choosePinComponent().successFailureComponent()
					.verifyAmount(data.get("amount"));
//			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent().clickViewTransaction();
			dashboardPage.withdrawTokenPage().choosePinComponent().successFailureComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickWithdraw();
			dashboardPage.selectWithdrawMethodPage().verifyHeading(data.get("heading"));
			dashboardPage.selectWithdrawMethodPage().verifyGiftCardDes(data.get("description"));
			dashboardPage.selectWithdrawMethodPage().clickGiftCard();
			if (data.get("validateVisaGiftCard").equalsIgnoreCase("yes")) {
				dashboardPage.selectWithdrawMethodPage().giftCardPage().clickVisa();
			} else {
				dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAmazon();
			}
			dashboardPage.selectWithdrawMethodPage().giftCardPage().verifyWithdrawGiftCard(data.get("tokensHeading"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillAmount(data.get("amount"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillFirstName(data.get("firstName"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillLastName(data.get("lastName"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillEmail(data.get("email"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().clickNext();
			dashboardPage.withdrawTokenPage().reloadPopup().verifyYouWillRecveHeading(data.get("orderPopupHeading"));
			if (!(dashboardPage.withdrawTokenPage().reloadPopup().verifyProcessingFee() == 0)) {
				dashboardPage.withdrawTokenPage().reloadPopup().clickProcessingFee();
				dashboardPage.withdrawTokenPage().reloadPopup().validateProcessingFees(data.get("amount"));
			} else {
				dashboardPage.withdrawTokenPage().reloadPopup().validateWithoutProcessingFee(data.get("amount"));
			}
			dashboardPage.withdrawTokenPage().reloadPopup().clickConfirm();
			dashboardPage.withdrawTokenPage().choosePinComponent().verifyEnterYourPinhdg(data.get("pinHeading"));
			dashboardPage.withdrawTokenPage().choosePinComponent().fillPin(data.get("pin"));
			dashboardPage.withdrawTokenPage().choosePinComponent().successFailureComponent()
					.verifyPurchaseComplete(data.get("successHeading"));
			dashboardPage.withdrawTokenPage().choosePinComponent().successFailureComponent()
					.verifyGiftCardDesc(data.get("firstName"), data.get("lastName"), data.get("email"));
			dashboardPage.withdrawTokenPage().choosePinComponent().successFailureComponent()
					.verifyAmount(data.get("amount"));
			dashboardPage.withdrawTokenPage().choosePinComponent().successFailureComponent().clickViewTransaction();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawGiftCard  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawGiftCardInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickWithdraw();
			dashboardPage.selectWithdrawMethodPage().verifyHeading(data.get("heading"));
			dashboardPage.selectWithdrawMethodPage().verifyGiftCardDes(data.get("description"));
			dashboardPage.selectWithdrawMethodPage().clickGiftCard();
			if (data.get("validateVisaGiftCard").equalsIgnoreCase("yes")) {
				dashboardPage.selectWithdrawMethodPage().giftCardPage().clickVisa();
			} else {
				dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAmazon();
			}
			dashboardPage.selectWithdrawMethodPage().giftCardPage().verifyWithdrawGiftCard(data.get("tokensHeading"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillAmount(data.get("amount"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillFirstName(data.get("firstName"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillLastName(data.get("lastName"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillEmail(data.get("email"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().clickNext();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
		}
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testWithdrawGiftCardNavigationOption(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			dashboardPage.clickWithdraw();
//			dashboardPage.withdrawTokenPage().verifyWithdrawHeading(data.get("heading"));
//			dashboardPage.withdrawTokenPage().clickGiftCardPurchase();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().navigationComponent().clickClose();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().clickGiftCard();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickAmazon();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
//					.fillAmount(data.get("amount"));
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
//					.fillFirstName(data.get("firstName"));
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
//					.fillLastName(data.get("lastName"));
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage()
//					.fillEmail(data.get("email1"));
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().clickPurchase();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
//					.slideToConfirm();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
//					.enterYourPINComponent().clickForgotPin();
//			businessTokenAccountPage.tokenMenuIconPopUp().withdrawMenuComponent().giftCardPage().orderPreviewPopup()
//					.enterYourPINComponent().navigationComponent().clickBack();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport(" GiftCard  failed due to exception " + e);
//		}
//	}

}
