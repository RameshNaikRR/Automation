package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.DashboardPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class DashBoardTest {

	DashboardPage dashboardPage;

	@BeforeTest
	public void init() {
		dashboardPage = new DashboardPage();
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

	@Test
	@Parameters({ "strParams" })
	public void testSendWithInsufficientFunds(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			double avlBalDasBoard = dashboardPage.verifyAvailbleBalance();
			dashboardPage.clickSendRequest();
			dashboardPage.sendRequestPage().verifySendRequestPageView();
			dashboardPage.sendRequestPage().verifyfirstRecentContact();
			dashboardPage.sendRequestPage().viewSendHeading();
			double a = dashboardPage.sendRequestPage().verifyWeeklyLimit();
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("errPopupHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickReload();
			if (data.get("withoutPaymentMethod").equals("yes")) {
				dashboardPage.sendRequestPage().reloadPopup().verifyAddCardReloadHeading(data.get("addCardReloadHead"));
				dashboardPage.sendRequestPage().reloadPopup().clickAddCreditCard();
				CustomerProfileTest customerProfileTest = new CustomerProfileTest();
				customerProfileTest.testAddCardDetails(strParams);
				dashboardPage.sendRequestPage().clickSend();
				dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("errPopupHeading"));
				dashboardPage.sendRequestPage().reloadPopup().clickReload();
			}
			dashboardPage.sendRequestPage().reloadPopup().verifyReloadHeading(data.get("reloadAmtHeading"));
			dashboardPage.sendRequestPage().reloadPopup().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().reloadPopup().clickProcessingFee();
			dashboardPage.sendRequestPage().reloadPopup().validateProcessingFees();
			dashboardPage.sendRequestPage().reloadPopup().clickLoad();
			dashboardPage.sendRequestPage().reloadPopup().fillCVV(data.get("cvv"));
			dashboardPage.sendRequestPage().reloadPopup().clickOk();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().fillPin(data.get("pin"));
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().viewNewBalance();
			int loadingAmt = dashboardPage.sendRequestPage().verifyAmount();
			int afterLoadingAvlBal = dashboardPage.sendRequestPage().verifyAvailbleBalance();
			if (avlBalDasBoard + loadingAmt == afterLoadingAvlBal) {
				ExtentTestManager.setPassMessageInReport(
						"The New Available Balance is showing accurately after loading the CYN'S");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"The New Available Balance is not showing accurately after loading the CYN'S");
			}
			dashboardPage.sendRequestPage().clickConfirm();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().fillPin(data.get("pin"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSendWithInsufficientFunds  failed due to exception " + e);
		}
	}

	public void testBuyToken(String strParams, String method) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (data.get("validateExistingAccounts").equalsIgnoreCase("Yes")) {
				Thread.sleep(2000);
				dashboardPage.clickBuyTokens();
				dashboardPage.buyTokenComponent().verifyBuyTokenHeading(data.get("expHeading"));
				dashboardPage.buyTokenComponent().verifyBuyTokenDesc(data.get("buyTokenDescription"));
				Thread.sleep(2000);
				if (method.equalsIgnoreCase("bank")) {
//					dashboardPage.addNewPaymentComponent().verifyFee();
					dashboardPage.addNewPaymentComponent().clickBankAccount(data.get("last4Digits"));
				} else if (method.equalsIgnoreCase("credit")) {
//					dashboardPage.addNewPaymentComponent().verifyFee();
					dashboardPage.addNewPaymentComponent().clickCreditCard(data.get("last4Digits"));
				} else {
//					dashboardPage.addNewPaymentComponent().verifyFee();
					dashboardPage.addNewPaymentComponent().clickDebitCard(data.get("last4Digits"));
				}
				if (!method.equalsIgnoreCase("bank")) {
					dashboardPage.cvvPopup().verifyPopupHeading(data.get("cvvPopupHeading"));
					dashboardPage.cvvPopup().fillCvv(data.get("cvvCVC"));
					dashboardPage.cvvPopup().clickOk();
				}
			}
			if (data.get("validateBuyToken").equalsIgnoreCase("Yes")) {
				Thread.sleep(2000);
				dashboardPage.buyTokenComponent().verifyBuyTokensHeading(data.get("expHeading"));
				dashboardPage.buyTokenComponent().verifyPaymentView();
				dashboardPage.buyTokenComponent().verifyChangePaymentView();
				Thread.sleep(1000);
//				String dailyLimitFee = dashboardPage.buyTokenComponent().orderPreviewPopup().getDailyLimitFeeLabel();
				dashboardPage.buyTokenComponent().verifyCynView();
				dashboardPage.buyTokenComponent().fillAmount(data.get("amount"));
				dashboardPage.buyTokenComponent().clickBuyToken();
				dashboardPage.buyTokenComponent().orderPreviewPopup().verifyHeading(data.get("popupHeading"));
				int amount = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyEnteredAmount();
				dashboardPage.buyTokenComponent().orderPreviewPopup().getPaymentMethod();
				String purchaseAmount = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyPurchaseAmount();
				String processingFee = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyProcessingFee();
				dashboardPage.buyTokenComponent().orderPreviewPopup().clickProcessingFee();
				String dailyLimitFee = dashboardPage.buyTokenComponent().orderPreviewPopup().getDailyLimitFeeLabel();
				testFee(method);
				dashboardPage.buyTokenComponent().orderPreviewPopup().verifyTotalAmount(dailyLimitFee);
				String totalAmount = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyTotalAmount();
				dashboardPage.buyTokenComponent().orderPreviewPopup().clickConfirm();
				dashboardPage.buyTokenComponent().orderPreviewPopup().choosePinComponent()
						.verifyEnterYourPinhdg(data.get("pinHeading"));
				dashboardPage.buyTokenComponent().orderPreviewPopup().choosePinComponent().fillPin(data.get("pin"));
				Thread.sleep(10000);
				dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
						.verifyPurchaseComplete(data.get("transactionSuccessHeading"));
				int amount1 = dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
						.verifyAmount();
				dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent().verifyCardName();
				dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
						.verifyTransactionSucessDesc(data.get("transactionSucessDescription"));
				if (data.get("validateViewTransaction").equalsIgnoreCase("Yes")) {
					dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
							.clickViewTransaction();
				}
				if (data.get("validateDone").equalsIgnoreCase("Yes")) {
					dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent().clickDone();
					dashboardPage.verifyRecentTransactionsView();
					dashboardPage.clickFirstTransaction();
				}
				dashboardPage.transactionsDetailsComponent().verifyTransactionDetailsHeadingView();
				dashboardPage.transactionsDetailsComponent().getTransactionDetails();
//				int amount2 = dashboardPage.transactionsDetailsComponent().verifyTransactionAmount();
				String purchaseAmount1 = dashboardPage.transactionsDetailsComponent().verifyPurchaseAmount();
				String processingFee1 = dashboardPage.transactionsDetailsComponent().verifyProcessingFee();
				String totalAmount1 = dashboardPage.transactionsDetailsComponent().verifyTotalAmount();
				if (amount == amount1) {
					ExtentTestManager.setInfoMessageInReport("The Entered Amount is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Entered Amount is not Same");
				}
				if (totalAmount.equals(totalAmount1)) {
					ExtentTestManager.setInfoMessageInReport("The Total Amount is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Total Amount is not Same");
				}
				if (purchaseAmount.equals(purchaseAmount1)) {
					ExtentTestManager.setInfoMessageInReport("The purchase  Amount is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The purchase Amount is not Same");
				}
				if (processingFee.equals(processingFee1)) {
					ExtentTestManager.setInfoMessageInReport("The processing Fee is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The processing Fee is not Same");
				}
				dashboardPage.navigationComponent().clickBack();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenCard  failed due to exception " + e);
		}
	}

	public void testFee(String method) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);

			if (method.equalsIgnoreCase("bank")) {
				String Fee1 = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyProcessingFeeValue();
				dashboardPage.buyTokenComponent().orderPreviewPopup().clickViewFee();
				String Fee2 = dashboardPage.buyTokenComponent().orderPreviewPopup().walletsFeesPage()
						.verifyBuyTokenBankAccountFee();
				if (Fee1 == Fee2) {
					ExtentTestManager.setInfoMessageInReport("The Fee is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Fee is not Same");
				}
			} else if (method.equalsIgnoreCase("credit")) {
				String Fee1 = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyProcessingFeeValue();
				dashboardPage.buyTokenComponent().orderPreviewPopup().clickViewFee();
				String Fee2 = dashboardPage.buyTokenComponent().orderPreviewPopup().walletsFeesPage()
						.verifyBuyTokenCreditCardFee();
				if (Fee1 == Fee2) {
					ExtentTestManager.setInfoMessageInReport("The Fee is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Fee is not Same");
				}
			} else {
				String Fee1 = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyProcessingFeeValue();
				dashboardPage.buyTokenComponent().orderPreviewPopup().clickViewFee();
				String Fee2 = dashboardPage.buyTokenComponent().orderPreviewPopup().walletsFeesPage()
						.verifyBuyTokenDebitCardFee();
				if (Fee1 == Fee2) {
					ExtentTestManager.setInfoMessageInReport("The Fee is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Fee is not Same");
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenCard  failed due to exception " + e);
		}
	}

	/**
	 * testBuyTokenWithBank script is to perform buy token transactions through
	 * Bank.
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithBank(String strParams) {
		testBuyToken(strParams, "bank");

	}

	/**
	 * testBuyTokenWithCreditCard script is to perform buy token transactions
	 * through Credit Card.
	 * 
	 * @param strParams
	 */

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithCreditCard(String strParams) {
		testBuyToken(strParams, "credit");
	}

	/**
	 * testBuyTokenWithDebitCard script is to perform buy token transactions through
	 * Debit Card.
	 * 
	 * @param strParams
	 */

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenWithDebitCard(String strParams) {
		testBuyToken(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithDebitCard(String strParams) {
		testWithDrawTOUSDTokens(strParams, "debit");
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenWithBankAccount(String strParams) {
		testWithDrawTOUSDTokens(strParams, "bank");
	}

	/**
	 * testWithDrawTOUSDBank script is to perform transactions via bank through
	 * withdraw to USD - Bank
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testWithDrawTOUSDTokens(String strParams, String method) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if (data.get("validateExistingAccounts").equalsIgnoreCase("Yes")) {
				dashboardPage.clickWithdraw();
				dashboardPage.selectWithdrawMethodPage().verifyHeading(data.get("expHeading"));
				dashboardPage.selectWithdrawMethodPage().verifyWithdrawDesc(data.get("description"));
				Thread.sleep(1000);
				if (method.equalsIgnoreCase("bank")) {
					dashboardPage.selectWithdrawMethodPage().verifyBankDes(data.get("bankDescription"));
					dashboardPage.selectWithdrawMethodPage().clickExternalBankAccount();
					dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
							.verifyHeading(data.get("withdrawPopupHeading"));
					dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
							.clickBankAccount1(data.get("last4Digits"));
				} else {
					dashboardPage.selectWithdrawMethodPage().verifyInstantDes(data.get("debitDescription"));
					dashboardPage.selectWithdrawMethodPage().clickInstantPay();
					Thread.sleep(1000);
					dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
							.verifyHeading(data.get("withdrawPopupHeading"));
					dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
							.clickDebitCard(data.get("last4Digits"));
				}
			}

			if (data.get("validateWithdrawToken").equalsIgnoreCase("Yes")) {
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.verifyHeading(data.get("withdrawTokenHeading"));
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.verifylblWithdrawView();
				Thread.sleep(4000);
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().verifyCynView();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.fillAmount(data.get("amount"));
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clickMessageButton();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.fillMessage(data.get("message"));
				String mesg1 = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.verifyfillMessage();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clickDone();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clickWithdraw();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().orderPreviewPopup()
						.verifyHeading(data.get("popupHeading"));
				int amount = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.orderPreviewPopup().verifyEnteredAmount();
				String withdrawAmount = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
						.withdrawTokenPage().orderPreviewPopup().verifyWithdrawAmount();
				String processingFee = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
						.withdrawTokenPage().orderPreviewPopup().verifyProcessingFee();
				testWithdrawFee(method);
				String mesg2 = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.orderPreviewPopup().verifyfillMessage();
				String dailyLimitFee = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
						.withdrawTokenPage().orderPreviewPopup().getDailyLimitFeeLabel1();
				String totalAmount = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyTotalAmount();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().orderPreviewPopup()
						.verifyTotalAmount(dailyLimitFee);
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().orderPreviewPopup()
						.clickConfirm();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().orderPreviewPopup()
						.choosePinComponent().verifyChooseYourPin(data.get("pinHeading"));
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().orderPreviewPopup()
						.choosePinComponent().fillPin(data.get("pin"));
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().orderPreviewPopup()
						.successFailureComponent().verifyWithdrawlComplete(data.get("transactionSuccessHeading"));
				int amount1 = dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
						.verifyAmount();
				dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent().verifyCardName();
				dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
						.verifyTransactionSucessDesc(data.get("transactionSucessDescription"));
				if (data.get("validateViewTransaction").equalsIgnoreCase("Yes")) {
					dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
							.clickViewTransaction();
				}
				if (data.get("validateDone").equalsIgnoreCase("Yes")) {
					dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent().clickDone();
					dashboardPage.verifyRecentTransactionsView();
					dashboardPage.clickFirstTransaction();
				}
				dashboardPage.transactionsDetailsComponent().verifyTransactionDetailsHeadingView();
				dashboardPage.transactionsDetailsComponent().getTransactionDetails();
				// int amount2 =
				// dashboardPage.transactionsDetailsComponent().verifyTransactionAmount();
				String mesg3 = dashboardPage.transactionsDetailsComponent().verifyfillMessage();
				String withdrawAmount1 = dashboardPage.transactionsDetailsComponent().verifyWithdrawAmount();
				String processingFee1 = dashboardPage.transactionsDetailsComponent().verifyProcessingFee();
				String totalAmount1 = dashboardPage.transactionsDetailsComponent().verifyTotalAmount();

				if (amount == amount1) {
					ExtentTestManager.setInfoMessageInReport("The Entered Amount is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Entered Amount is not Same");
				}
				if (mesg1 == mesg2 && mesg1 == mesg3) {
					ExtentTestManager.setInfoMessageInReport("The Entered Message is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Entered Message is not Same");
				}
				if (totalAmount.equals(totalAmount1)) {
					ExtentTestManager.setInfoMessageInReport("The Total Amount is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Total Amount is not Same");
				}
				if (withdrawAmount.equals(withdrawAmount1)) {
					ExtentTestManager.setInfoMessageInReport("The purchase  Amount is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The purchase Amount is not Same");
				}
				if (processingFee.equals(processingFee1)) {
					ExtentTestManager.setInfoMessageInReport("The processing Fee is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The processing Fee is not Same");
				}
				dashboardPage.navigationComponent().clickBack();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithDrawTOUSDBank  failed due to exception " + e);
		}
	}

	public void testWithdrawFee(String method) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);

			if (method.equalsIgnoreCase("bank")) {
				String Fee1 = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyProcessingFeeValue();
				dashboardPage.buyTokenComponent().orderPreviewPopup().clickViewFee();
				String Fee2 = dashboardPage.buyTokenComponent().orderPreviewPopup().walletsFeesPage()
						.verifyWithdrawTokenBankAccountFee();
				if (Fee1 == Fee2) {
					ExtentTestManager.setInfoMessageInReport("The Fee is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Fee is not Same");
				}
			} else if (method.equalsIgnoreCase("debit")) {
				String Fee1 = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyProcessingFeeValue();
				dashboardPage.buyTokenComponent().orderPreviewPopup().clickViewFee();
				String Fee2 = dashboardPage.buyTokenComponent().orderPreviewPopup().walletsFeesPage()
						.verifyWithdrawTokenInstantFee();
				if (Fee1 == Fee2) {
					ExtentTestManager.setInfoMessageInReport("The Fee is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Fee is not Same");
				}
			} else {
				String Fee1 = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyProcessingFeeValue();
				dashboardPage.buyTokenComponent().orderPreviewPopup().clickViewFee();
				String Fee2 = dashboardPage.buyTokenComponent().orderPreviewPopup().walletsFeesPage()
						.verifyBuyTokenDebitCardFee();
				if (Fee1 == Fee2) {
					ExtentTestManager.setInfoMessageInReport("The Fee is Same");
				} else {
					ExtentTestManager.setWarningMessageInReport("The Fee is not Same");
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenCard  failed due to exception " + e);
		}
	}

	/**
	 * testGiftCard script is to test transactions through withdraw to USD - Gift
	 * Card
	 * 
	 * @param strParams
	 */
	@Test
	@Parameters({ "strParams" })
	public void testGiftCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickWithdraw();
			dashboardPage.selectWithdrawMethodPage().verifyHeading(data.get("expHeading"));
			dashboardPage.selectWithdrawMethodPage().verifyGiftCardDes(data.get("description"));
			dashboardPage.selectWithdrawMethodPage().clickGiftCard();
			dashboardPage.selectWithdrawMethodPage().giftCardPage()
					.verifyPurchaseGiftCardHeading(data.get("purchaseGiftHeading"));
			Thread.sleep(1000);
			dashboardPage.selectWithdrawMethodPage().giftCardPage().verifyBrandsView();
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillSearchBox(data.get("giftCard"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().clickGiftCard(data.get("giftCard"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().verifyHeading(data.get("expHeading"));
			String dailyLimitFee = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.orderPreviewPopup().getDailyLimitFeeLabel();
			Thread.sleep(1000);
			dashboardPage.selectWithdrawMethodPage().giftCardPage().choosePinComponent().fillPins(data.get("amount"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAdd();
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillFirstName(data.get("firstName"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillLastName(data.get("lastName"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillEmail(data.get("email"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().verifyGiftCardDesc();
			dashboardPage.selectWithdrawMethodPage().giftCardPage().clickNext();
			dashboardPage.selectWithdrawMethodPage().giftCardPage().orderPreviewPopup()
					.verifyGiftCardHeading(data.get("popupHeading"));
			String giftCardName = dashboardPage.selectWithdrawMethodPage().giftCardPage().orderPreviewPopup()
					.verifyGiftCardNAme();
			dashboardPage.selectWithdrawMethodPage().giftCardPage().orderPreviewPopup().getEmail();
			int amount = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyEnteredAmount();
			String purchaseAmount = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyPurchaseAmount();
			String processingFee = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyProcessingFee();
			dashboardPage.buyTokenComponent().orderPreviewPopup().verifyTotalAmount(dailyLimitFee);
			String totalAmount = dashboardPage.buyTokenComponent().orderPreviewPopup().verifyTotalAmount();
			dashboardPage.buyTokenComponent().orderPreviewPopup().clickConfirm();
			dashboardPage.buyTokenComponent().orderPreviewPopup().choosePinComponent()
					.verifyEnterYourPinhdg(data.get("pinHeading"));
			dashboardPage.buyTokenComponent().orderPreviewPopup().choosePinComponent().fillPin(data.get("pin"));
			Thread.sleep(2000);
			dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
					.verifyGiftCardSent(data.get("transactionSuccessHeading"));
			int amount1 = dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
					.verifyAmount();
			dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent().verifyCardName();
			dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent()
					.verifyTransactionSucessDesc(data.get("transactionSucessDescription"));
			if (data.get("validateViewTransaction").equalsIgnoreCase("Yes")) {
				dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent().clickViewTransaction();
			}
			if (data.get("validateDone").equalsIgnoreCase("Yes")) {
				dashboardPage.buyTokenComponent().orderPreviewPopup().successFailureComponent().clickDone();
				dashboardPage.verifyRecentTransactionsView();
				dashboardPage.clickFirstTransaction();
			}
			dashboardPage.transactionsDetailsComponent().verifyTransactionDetailsHeadingView();
			dashboardPage.transactionsDetailsComponent().getTransactionDetails();
			// int amount2 =
			// dashboardPage.transactionsDetailsComponent().verifyTransactionAmount();
			String GiftCard1 = dashboardPage.transactionsDetailsComponent().verifyGiftCardAmount();
			String processingFee1 = dashboardPage.transactionsDetailsComponent().verifyProcessingFee();
			String totalAmount1 = dashboardPage.transactionsDetailsComponent().verifyTotalAmount();
			String GiftCardNAme1 = dashboardPage.transactionsDetailsComponent().verifyGiftCardNAme();
			if (amount == amount1) {
				ExtentTestManager.setInfoMessageInReport("The Entered Amount is Same");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Entered Amount is not Same");
			}
			if (totalAmount.equals(totalAmount1)) {
				ExtentTestManager.setInfoMessageInReport("The Total Amount is Same");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Total Amount is not Same");
			}
			if (purchaseAmount.equals(GiftCard1)) {
				ExtentTestManager.setInfoMessageInReport("The purchase  Amount is Same");
			} else {
				ExtentTestManager.setWarningMessageInReport("The purchase Amount is not Same");
			}
			if (processingFee.equals(processingFee1)) {
				ExtentTestManager.setInfoMessageInReport("The processing Fee is Same");
			} else {
				ExtentTestManager.setWarningMessageInReport("The processing Fee is not Same");
			}
			if (giftCardName.equals(GiftCardNAme1)) {
				ExtentTestManager.setInfoMessageInReport("The Gift card Name is Same");
			} else {
				ExtentTestManager.setWarningMessageInReport("The Gift card Name is not Same");
			}
			dashboardPage.navigationComponent().clickBack();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testGiftCard  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenTransactionErrorMessages(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			String[] errorMsgs = data.get("errMsg").split(",");
			dashboardPage.clickBuyTokens();
			if (data.get("validatebanking").equalsIgnoreCase("Yes")) {
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
						.clickBankAccount(data.get("last4Digits"));
			}
			if (data.get("validateDebitCard").equalsIgnoreCase("Yes")) {
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickDebitCard(data.get("last4Digits"));
				dashboardPage.cvvPopup().fillCvv(data.get("cvvCVC"));
				dashboardPage.cvvPopup().clickOk();
			}
			if (data.get("validateCreditCard").equalsIgnoreCase("Yes")) {
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickCreditCard(data.get("last4Digits"));
				dashboardPage.cvvPopup().fillCvv(data.get("cvvCVC"));
				dashboardPage.cvvPopup().clickOk();

			}
			if (data.get("validateMinimumAmount").equalsIgnoreCase("Yes")) {
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.fillAmount(data.get("amount"));
				ExtentTestManager.setInfoMessageInReport("<b>Testing with minimum amount : %.2f </b>");
				new CommonFunctions().validateErrMsg(errorMsgs[0]);
			}
			if (data.get("validateLimits").equalsIgnoreCase("Yes")) {
				float limit = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.getDailyLimitOrWeeklyLimitAmount();
				System.out.println(limit);
				ExtentTestManager.setInfoMessageInReport(
						String.format("<b>Testing with more than Daily or Weekly Limit : %.2f </b>", limit));
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
						.fillAmount(Float.toString(limit + 1));
				String dailyOrWeeklyTxt = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
						.withdrawTokenPage().getDailyOrWeeklyLimitText();
				if (dailyOrWeeklyTxt.contains("daily")) {
					new CommonFunctions().validateErrMsg(errorMsgs[1]);
				} else if (dailyOrWeeklyTxt.contains("Weekly")) {
					new CommonFunctions().validateErrMsg(errorMsgs[2]);
				} else {
					new CommonFunctions().validateErrMsg(errorMsgs[3]);
				}
			}
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test withdraw amount and message  field validations is failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void verifyWithdrawTokensWithInvalidAmount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			String[] errorMsgs = data.get("errMsg").split("-");
			dashboardPage.clickWithdraw();
			if (data.get("ValidateBank").equalsIgnoreCase("Yes")) {
				dashboardPage.selectWithdrawMethodPage().clickExternalBankAccount();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup()
						.clickBankAccount(data.get("last4Digits"));
			}
			if (data.get("ValidateInstantPay").equalsIgnoreCase("Yes")) {
				dashboardPage.selectWithdrawMethodPage().clickInstantPay();
				dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickDebitCard(data.get("last4Digits"));
			}
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.fillAmount(data.get("amount"));
			ExtentTestManager.setInfoMessageInReport("Testing with Min amount ");
			new CommonFunctions().validateErrMsg(errorMsgs[0]);
			Thread.sleep(1000);
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clearText();
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickBackspace();
			float avaBalance = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.getAvailableBalance();
			ExtentTestManager.setInfoMessageInReport(
					String.format("<b>Testing with more than Available Balance : %.2f </b>", avaBalance));
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.fillAmount(Float.toString(avaBalance + 1));
			new CommonFunctions().validateErrMsg(errorMsgs[1]);
			Thread.sleep(2000);
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clearText();
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickBackspace();
			ExtentTestManager.setInfoMessageInReport(
					String.format("<b>Testing with same Available Balance : %.2f </b>", avaBalance));
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.fillAmount(Float.toString(avaBalance));
			new CommonFunctions().validateErrMsg(errorMsgs[2]);
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clearText();
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickBackspace();
			float limit = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.getDailyLimitOrWeeklyLimitAmount();
			System.out.println(limit);
			ExtentTestManager.setInfoMessageInReport(
					String.format("<b>Testing with same Daily or Weekly Limit : %.2f </b>", limit));
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.fillAmount(Float.toString(limit));
			String dailyOrWeeklyTxt = dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.getDailyOrWeeklyLimitText();
			if (limit < avaBalance) {
				if (dailyOrWeeklyTxt.contains("daily")) {
					new CommonFunctions().validateErrMsg(errorMsgs[3]);
				} else if (dailyOrWeeklyTxt.contains("Weekly")) {
					new CommonFunctions().validateErrMsg(errorMsgs[4]);
				} else {
					new CommonFunctions().validateErrMsg(errorMsgs[5]);
				}
			} else {
				new CommonFunctions().validateErrMsg(errorMsgs[1]);
			}

			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clearText();
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickBackspace();
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.fillAmount(Float.toString(limit + 1));
			ExtentTestManager
					.setInfoMessageInReport(String.format("<b>Testing with more than limit : %.2f </b>", limit));
			if (limit < avaBalance) {
				if (dailyOrWeeklyTxt.contains("daily")) {
					new CommonFunctions().validateErrMsg(errorMsgs[6]);
				} else if (dailyOrWeeklyTxt.contains("Weekly")) {
					new CommonFunctions().validateErrMsg(errorMsgs[7]);
				} else {
					new CommonFunctions().validateErrMsg(errorMsgs[8]);
				}
			} else {
				new CommonFunctions().validateErrMsg(errorMsgs[1]);
			}
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clearText();
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().clickBackspace();
			ExtentTestManager.setInfoMessageInReport("Testing with field validations for amount");
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.validateAmount(data.get("amount1"));
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clickMessageButton();
			ExtentTestManager.setInfoMessageInReport("Testing with field validations for message");
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage()
					.fillMessage(data.get("message"));
			dashboardPage.selectWithdrawMethodPage().withdrawMethodPopup().withdrawTokenPage().clickDone();
			dashboardPage.navigationComponent().clickBack();
			dashboardPage.navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test Withdraw Transcations WithInvalid Amount is failed due to Exception " + e);
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
}
