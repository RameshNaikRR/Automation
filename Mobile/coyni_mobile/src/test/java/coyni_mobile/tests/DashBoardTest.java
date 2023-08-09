package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.DashboardPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
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
			ExtentTestManager
					.setPassMessageInReport("Before preform the action on notifications, the count is : " + beforeRead);
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().verifyMesaageTitle();
			dashboardPage.notificationsPage().verifyTime();
			dashboardPage.notificationsPage().swipeNotificationLeft();
			dashboardPage.notificationsPage().verifyRead();
			dashboardPage.notificationsPage().clickBack();
			dashboardPage.viewUserName();
			int afterRead = dashboardPage.notificationsPage().countNotifications();
			if (beforeRead == afterRead + 1) {
				ExtentTestManager.setPassMessageInReport("After Swiping Right the Notification, the count is reducing");
			} else {
				ExtentTestManager
						.setFailMessageInReport("After Swiping Right the Notification, the count is not reducing");
			}
			int beforeUnRead = dashboardPage.notificationsPage().countNotifications();
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().swipeNotificationLeft();
			dashboardPage.notificationsPage().verifyUnRead();
			dashboardPage.notificationsPage().clickBack();
			dashboardPage.viewUserName();
			int afterUnRead = dashboardPage.notificationsPage().countNotifications();
			if (beforeUnRead == afterUnRead - 1) {
				ExtentTestManager
						.setPassMessageInReport("After Swiping Right the Notification, the count is increasing");
			} else {
				ExtentTestManager
						.setFailMessageInReport("After Swiping Right the Notification, the count is not increasing");
			}
			int beforeDelete = dashboardPage.notificationsPage().countNotifications();
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().swipeNotificationRight();
			dashboardPage.notificationsPage().clickBack();
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
			double avlBalDasBoard = dashboardPage.verifyAvailbleBalance();
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().clickNotificSend();
			dashboardPage.sendRequestPage().viewSender();
			double avaBalConfirmPopup = dashboardPage.sendRequestPage().verifyAvailbleBalance();
			if (avlBalDasBoard == avaBalConfirmPopup) {
				ExtentTestManager.setPassMessageInReport(
						"The Same Available Balance is showing in Dash baord and Send Confirm popup");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"The Same Available Balance is not showing in Dash baord and Send Confirm popup");
			}
			dashboardPage.sendRequestPage().clickMessageButton();
			dashboardPage.sendRequestPage().optionalMessagePopup().fillMessage(data.get("message"));
			dashboardPage.sendRequestPage().optionalMessagePopup().validateMessageField();
			dashboardPage.sendRequestPage().optionalMessagePopup().clickDone();
			dashboardPage.sendRequestPage().clickConfirm();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().fillPin(data.get("pin"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifySendRequestPurchase(data.get("heading"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifyAmount(data.get("amount"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().verifySendRequestDesc();
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().clickViewTransaction();
			dashboardPage.transactionsDetailsComponent().verifyHeading(data.get("transDtlsHeading"));
			dashboardPage.transactionsDetailsComponent().sentTransactionDetails(data.get("recipientName"),
					data.get("amount"), data.get("transactionType"));
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
			dashboardPage.notificationsPage().verifyReminderMessage(data.get("name"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestReminder faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestReminderInReceiverAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().clickRequest();
			dashboardPage.notificationsPage().verifyReminderMessage(data.get("name"));
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
			dashboardPage.notificationsPage().verifyCancelMessage(data.get("cancelMsg"));
			dashboardPage.notificationsPage().clickBack();
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
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
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
			String contactName = dashboardPage.sendRequestPage().verifyfirstRecentContact();
			if (data.get("chooseSendMethod").equalsIgnoreCase("withName")) {
				dashboardPage.sendRequestPage().fillSearchBx(data.get("name"));
				dashboardPage.sendRequestPage().selectUser();
			} else if (data.get("chooseSendMethod").equalsIgnoreCase("withAccount")) {
				dashboardPage.sendRequestPage().fillSearchBx(data.get("accountAddress"));
				dashboardPage.sendRequestPage().selectUser();
			} else {
				dashboardPage.sendRequestPage().verifyRecentContactListSize();
				dashboardPage.sendRequestPage().clickfstRcntContact();
			}
//			String Name = dashboardPage.sendRequestPage().verifyName();
//			if (data.get("name").equals(Name) || contactName.equals(Name)) {
////				|| data.get("accountAddress").equals(Name) 
//				ExtentTestManager.setPassMessageInReport(
//						"Selcted contact name is appeared correctly in Send/Request Payment screen");
//			} else {
//				ExtentTestManager.setFailMessageInReport(
//						"Selcted contact name is not appeared correctly in Send/Request Payment screen");
//			}
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().clickMessageButton();
			dashboardPage.sendRequestPage().optionalMessagePopup().fillMessage(data.get("message"));
			dashboardPage.sendRequestPage().optionalMessagePopup().validateMessageField();
			dashboardPage.sendRequestPage().optionalMessagePopup().clickDone();
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().viewSender();
			double avaBalConfirmPopup = dashboardPage.sendRequestPage().verifyAvailbleBalance();
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
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifySendRequestPurchase(data.get("successHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifyAmount(data.get("amount"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().verifySendRequestDesc();
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().clickViewTransaction();
			dashboardPage.transactionsDetailsComponent().verifyHeading(data.get("transDtlsHeading"));
			dashboardPage.transactionsDetailsComponent().sentTransactionDetails(data.get("name"), data.get("amount"),
					data.get("transactionType"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSend  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void verifySentTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().verifySendSentMessage(data.get("name"), data.get("amount"),
					data.get("message"));
			dashboardPage.notificationsPage().clickBack();
			dashboardPage.viewUserName();
			dashboardPage.clickFirstTransaction();
			dashboardPage.transactionsDetailsComponent().verifyHeading(data.get("transDtlsHeading"));
			dashboardPage.transactionsDetailsComponent().receivedTransactionDetails(data.get("transactionType1"),
					data.get("transactionStatus"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSend  failed due to exception " + e);
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
			if (data.get("chooseSendMethod").equalsIgnoreCase("withName")) {
				dashboardPage.sendRequestPage().fillSearchBx(data.get("name"));
				dashboardPage.sendRequestPage().selectUser();
				String Name = dashboardPage.sendRequestPage().verifyName();
				if (data.get("name").equals(Name)) {
					ExtentTestManager.setPassMessageInReport(
							"Entered contact name is appeared correctly in Send/Request Payment screen");
				} else {
					ExtentTestManager.setFailMessageInReport(
							"Entered contact name is not appeared correctly in Send/Request Payment screen");
				}
			} else if (data.get("chooseSendMethod").equalsIgnoreCase("withAccount")) {
				dashboardPage.sendRequestPage().fillSearchBx(data.get("accountAddress"));
				dashboardPage.sendRequestPage().selectUser();
			} else {
				dashboardPage.sendRequestPage().verifyRecentContactListSize();
				String contactName = dashboardPage.sendRequestPage().verifyfirstRecentContact();
				System.out.println(contactName);
				dashboardPage.sendRequestPage().clickfstRcntContact();
				String Name = dashboardPage.sendRequestPage().verifyName();
				System.out.println(Name);
				if (contactName.equals(Name)) {
					ExtentTestManager.setPassMessageInReport(
							"Selcted contact name is appeared correctly in Send/Request Payment screen");
				} else {
					ExtentTestManager.setFailMessageInReport(
							"Selcted contact name is not appeared correctly in Send/Request Payment screen");
				}
			}
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().clickMessageButton();
			dashboardPage.sendRequestPage().optionalMessagePopup().fillMessage(data.get("message"));
			dashboardPage.sendRequestPage().optionalMessagePopup().clickDone();
			String Name = dashboardPage.sendRequestPage().verifyName();
			dashboardPage.sendRequestPage().clickRequest();
			dashboardPage.sendRequestPage().viewRequestingHeading();
			double amtPopup = dashboardPage.sendRequestPage().verifyRqstAmount();
			String recptntName = dashboardPage.sendRequestPage().verifyReceiptentName();
			String message = dashboardPage.sendRequestPage().verifyMessage();
			if (Double.parseDouble(data.get("amount")) == amtPopup || Name.equals(recptntName)
					|| data.get("message").equals(message)) {
				ExtentTestManager.setPassMessageInReport("All the details of Request Confirm popup are accurate");
			} else {
				ExtentTestManager.setFailMessageInReport("All the details of Request Confirm popup are not accurate");
			}
			dashboardPage.sendRequestPage().clickConfirm();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().fillPin(data.get("pin"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifySendRequestPurchase(data.get("successHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifyAmount(data.get("amount"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().verifySendRequestDesc();
			String ReciptentName = dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifyReceiptentName();
			double Amount = dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifyAmount();
			if (Amount == Double.parseDouble(data.get("amount")) && ReciptentName.equals(recptntName)) {
				ExtentTestManager.setPassMessageInReport("All the details of Request Confirm popup are accurate");
			} else {
				ExtentTestManager.setFailMessageInReport("All the details of Request Confirm popup are not accurate");
			}
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().clickDone();
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			Thread.sleep(3000);
			dashboardPage.notificationsPage().clickRequest();
			dashboardPage.notificationsPage().verifySendSentMessage(data.get("name"), data.get("amount"),
					data.get("message"));
			if (!data.get("cancelMsg").isEmpty()) {
				dashboardPage.notificationsPage().clickRemainder();
				dashboardPage.notificationsPage().verifyReminderMessage(data.get("name"));
				dashboardPage.notificationsPage().clickCancel();
				dashboardPage.notificationsPage().verifyCancelMessage(data.get("cancelMsg"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequest  failed due to exception " + e);
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
			dashboardPage.sendRequestPage().fillSearchBx(data.get("name"));
			dashboardPage.sendRequestPage().selectUser();
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			dashboardPage.sendRequestPage().fillAmount(Double.toString(avlBalDasBoard + 15));
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("errPopupHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickNewAmount();
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().reloadPopup().clickReload();
			if (data.get("withoutPaymentMethod").equalsIgnoreCase("yes")) {
				dashboardPage.sendRequestPage().reloadPopup().verifyAddCardReloadHeading(data.get("addCardReloadHead"));
				CustomerProfileTest customerProfileTest = new CustomerProfileTest();
				customerProfileTest.testAddCard(strParams);
				dashboardPage.sendRequestPage().clickSend();
				dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("errPopupHeading"));
				dashboardPage.sendRequestPage().reloadPopup().clickReload();
			}
			dashboardPage.sendRequestPage().reloadPopup().verifyReloadHeading(data.get("reloadAmtHeading"));
			if (!(dashboardPage.withdrawTokenPage().reloadPopup().verifyProcessingFee() == 0)) {
				dashboardPage.withdrawTokenPage().reloadPopup().clickProcessingFee();
				dashboardPage.withdrawTokenPage().reloadPopup().validateProcessingFees("15");
			} else {
				dashboardPage.withdrawTokenPage().reloadPopup().validateWithoutProcessingFee("15");
			}
			dashboardPage.sendRequestPage().reloadPopup().clickLoad();
			dashboardPage.sendRequestPage().reloadPopup().fillCVV(data.get("cvv"));
			dashboardPage.sendRequestPage().reloadPopup().clickOk();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().fillPin(data.get("pin"));
			dashboardPage.sendRequestPage().verifyConfmSendHeading(data.get("confmSendHeading"));
			double transAmt = dashboardPage.sendRequestPage().verifySendCnfmAmount();
			double afterLoadingAvlBal = dashboardPage.sendRequestPage().verifyAvailbleBalance();
//			if (avlBalDasBoard + 2 == afterLoadingAvlBal) {
//				ExtentTestManager.setPassMessageInReport(
//						"The New Available Balance is showing accurately after loading the CYN'S");
//			} else {
//				ExtentTestManager.setFailMessageInReport(
//						"The New Available Balance is not showing accurately after loading the CYN'S");
//			}
			if (transAmt == afterLoadingAvlBal) {
				ExtentTestManager.setPassMessageInReport("Expected Send Amount Reloaded accurately");
			} else {
				ExtentTestManager.setFailMessageInReport("Expected Send Amount not Reloaded accurately");
			}
			dashboardPage.sendRequestPage().clickConfirm();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().fillPin(data.get("pin"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifySendRequestPurchase(data.get("successHeading"));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
					.verifyAmount(Double.toString(avlBalDasBoard + 15));
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().verifySendRequestDesc();
			dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().clickViewTransaction();
			dashboardPage.transactionsDetailsComponent().verifyHeading(data.get("transDtlsHeading"));
			dashboardPage.transactionsDetailsComponent().sentTransactionDetails(data.get("name"),
					Double.toString(avlBalDasBoard + 15), data.get("transactionType"));
			if (data.get("withoutPaymentMethod").equalsIgnoreCase("")) {
				dashboardPage.transactionsDetailsComponent().clickBack();
				dashboardPage.clickProfile();
				customerProfilePage.clickPaymentMethods();
				CustomerProfileTest customerProfileTest = new CustomerProfileTest();
				customerProfileTest.testDeleteDebitCards(strParams);
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testSendWithInsufficientFunds  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSendWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			double avlBalDasBoard = dashboardPage.verifyAvailbleBalance();
			dashboardPage.clickSendRequest();
			dashboardPage.sendRequestPage().verifySendRequestPageView();
			dashboardPage.sendRequestPage().fillSearchBx(data.get("name"));
			dashboardPage.sendRequestPage().selectUser();
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			double limit = dashboardPage.sendRequestPage().verifyLimit();
//			dashboardPage.sendRequestPage().fillAmount(Double.toString(weekLimit + 0.1));
//			new CommonFunctions().validateFormErrorMessage(data.get("errMsg"),"amount field");
			for (int i = 0; i < 4; i++) {
				String[] fieldAmount = data.get("fieldAmount").split(",");
				if (i < 1) {
					dashboardPage.sendRequestPage().fieldValidationsComponent().validateAmountField(fieldAmount[0],
							fieldAmount[1], fieldAmount[2]);
				} else {
					if (i == 1) {
						dashboardPage.sendRequestPage().fillAmount(Double.toString(limit + 0.1));
						new CommonFunctions().validateFormErrorMessage(data.get("amountErrMsg"), "Amount Field");
					} else if (i == 2) {
						dashboardPage.sendRequestPage().fillAmount("4");
						dashboardPage.sendRequestPage().fillAmount("0.1");
						new CommonFunctions().validateDynamicTextMessage("Amount field");
					} else {
						dashboardPage.sendRequestPage().fillAmount(Double.toString(avlBalDasBoard + 2));
						dashboardPage.sendRequestPage().clickSend();
						dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("errPopupHeading"));
						dashboardPage.sendRequestPage().reloadPopup().clickReload();
						dashboardPage.sendRequestPage().reloadPopup().verifyReloadHeading(data.get("reloadAmtHeading"));
						for (int j = 0; j < 2; j++) {
							if (j == 0) {
								double reloadAmount = dashboardPage.sendRequestPage().reloadPopup()
										.verifyReloadAmount();
								dashboardPage.sendRequestPage().reloadPopup()
										.fillAmount(Double.toString(reloadAmount - 0.1));
								dashboardPage.sendRequestPage().reloadPopup()
										.validateReloadTransactionErrorMessage("2");
							} else {
								dashboardPage.sendRequestPage().reloadPopup().fillAmount(Double.toString(0.1));
								new CommonFunctions().validateDynamicTextMessage("Amount field");
							}
						}

					}

				}
			}
//
//			if (!data.get("errMsg").isEmpty()) {
//				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("elementName"));
////			}
//			if (!data.get("errPopupHeading").isEmpty()) {
//				dashboardPage.sendRequestPage().clickSend();
//				dashboardPage.sendRequestPage().verifyPopupHeading(data.get("errPopupHeading"));
//				dashboardPage.sendRequestPage().verifypopupDes(data.get("errPopupDes"));
//				dashboardPage.sendRequestPage().clickReload();
//			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testPayWithInvalidData  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSendRequestNavigations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			double avlBalDasBoard = dashboardPage.verifyAvailbleBalance();
			dashboardPage.clickSendRequest();
			dashboardPage.sendRequestPage().clickScan();
			dashboardPage.sendRequestPage().clickPermission();
			dashboardPage.sendRequestPage().verifyScanCodePage();
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.sendRequestPage().verifySendRequestPageView();
			dashboardPage.sendRequestPage().clickScan();
			dashboardPage.sendRequestPage().clickMyQRCode();
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.sendRequestPage().verifySendRequestPageView();
			dashboardPage.sendRequestPage().clickfstRcntContact();
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			dashboardPage.sendRequestPage().fillAmount(Double.toString(avlBalDasBoard + 2));
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("errPopupHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickNewAmount();
			dashboardPage.sendRequestPage().verifyResetAmount(Double.toString(avlBalDasBoard + 2));
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			dashboardPage.sendRequestPage().fillAmount(Double.toString(avlBalDasBoard + 2));
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
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			dashboardPage.sendRequestPage().clickRequest();
			dashboardPage.sendRequestPage().viewRequestingHeading();
			dashboardPage.sendRequestPage().clickNativeKeyBack();
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			dashboardPage.sendRequestPage().clickRequest();
			dashboardPage.sendRequestPage().viewRequestingHeading();
			dashboardPage.sendRequestPage().clickConfirm();
			dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.sendRequestPage().clickContinue();
			dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
			Thread.sleep(1000);
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
	public void testFiltersWithOneTransactionType(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.viewUserName();
			dashboardPage.clickViewAllTransactions();
			dashboardPage.transactionPage().verifyHeading(data.get("transactionHeading"));
			dashboardPage.transactionPage().clickFilters();
			if (data.get("transactionType").equals("Sent") || data.get("transactionType").equals("Received")) {
				dashboardPage.transactionPage().filtersPopup().clickTransactionType(data.get("transactionType"));
			} else {
				dashboardPage.transactionPage().filtersPopup()
						.clickTransactionTypePlus(data.get("transactionTypePlus"));
				dashboardPage.transactionPage().filtersPopup()
						.clickTransactionSubTypesChkBox(data.get("transactionType1"));
			}
			dashboardPage.transactionPage().filtersPopup().clickTransactionStatus(data.get("transactionStatus"));
			dashboardPage.transactionPage().filtersPopup().fillFromAmount(data.get("fromAmount"));
			dashboardPage.transactionPage().filtersPopup().fillToAmount(data.get("toAmount"));
			dashboardPage.transactionPage().filtersPopup().clickCalendar();
			dashboardPage.transactionPage().filtersPopup().calendarComponent().selectFromDate();
			dashboardPage.transactionPage().filtersPopup().calendarComponent().selectToDate();
			dashboardPage.transactionPage().filtersPopup().calendarComponent().clickDone();
			dashboardPage.transactionPage().filtersPopup().clickApplyFilter();
			if (dashboardPage.transactionPage().verifyTransactions() == 0) {
				dashboardPage.transactionPage().clickFirstTransaction();
				dashboardPage.transactionsDetailsComponent().verifyHeading(data.get("transDtlsHeading"));
				if (data.get("transactionType").equals("Sent")) {
					dashboardPage.transactionsDetailsComponent()
							.filterSentTransactionDetails(data.get("transactionType"), data.get("transactionStatus"));
				} else if (data.get("transactionType").equals("Received")) {
					dashboardPage.transactionsDetailsComponent().receivedTransactionDetails(data.get("transactionType"),
							data.get("transactionStatus"));
				} else if (data.get("transactionType").equals("Sale Order - Retail / Mobile")) {
					dashboardPage.transactionsDetailsComponent()
							.RetailMobileTransactionDetails(data.get("transactionType"));
				} else if (data.get("transactionTypePlus").equals("Buy Tokens")) {
					dashboardPage.transactionsDetailsComponent().buyTokenTransactionDetails(data.get("transactionType"),
							data.get("transactionStatus"), data.get("transactionType1"));
				} else if (data.get("transactionType1").equals("Gift Card")) {
					dashboardPage.transactionsDetailsComponent().withdrawGiftCardTransactionsDetails(
							data.get("transactionType"), data.get("transactionStatus"));
				} else if (data.get("transactionTypePlus").equals("Withdraw")) {
					dashboardPage.transactionsDetailsComponent().buyTokenTransactionDetails(data.get("transactionType"),
							data.get("transactionStatus"), data.get("transactionType1"));
				}
			} else {
				dashboardPage.transactionPage().verifyTransactionsText(data.get("noMoreTrans"));
				ExtentTestManager.setWarningMessageInReport("You have any transactions to verify details");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testfilters  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testTransactionsSearch(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.viewUserName();
			dashboardPage.clickViewAllTransactions();
			dashboardPage.transactionPage().verifyHeading(data.get("transactionHeading"));
			dashboardPage.transactionPage().clickFirstTransaction();
			dashboardPage.transactionsDetailsComponent().verifyHeading(data.get("transDtlsHeading"));
			String beforeTransType = dashboardPage.transactionsDetailsComponent().getTransactionType();
			String beforeTransAmt = dashboardPage.transactionsDetailsComponent().getTransactionAmt();
			String beforeTransStatus = dashboardPage.transactionsDetailsComponent().getTransactionStatus();
			String beforeTransDate = dashboardPage.transactionsDetailsComponent().getTransactionDate();
			dashboardPage.transactionsDetailsComponent().clickReferenceID();
			dashboardPage.navigationComponent().clickBack();
			dashboardPage.transactionsDetailsComponent().verifySearch();
			dashboardPage.transactionPage().getTransactionsCount();
			dashboardPage.transactionPage().clickFirstTransaction();
			String afterTransType = dashboardPage.transactionsDetailsComponent().getTransactionType();
			String afterTransAmt = dashboardPage.transactionsDetailsComponent().getTransactionAmt();
			String afterTransStatus = dashboardPage.transactionsDetailsComponent().getTransactionStatus();
			String afterTransDate = dashboardPage.transactionsDetailsComponent().getTransactionDate();
			if (beforeTransType.equals(afterTransType) && beforeTransAmt.equals(afterTransAmt)
					&& beforeTransStatus.equals(afterTransStatus) && beforeTransDate.equals(afterTransDate)) {
				ExtentTestManager.setPassMessageInReport(
						"Searching a transaction with reference id, its showing accurate transaction details");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"Searching a transaction with reference id, its not showing accurate transaction details");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTransactionsSearch  failed due to exception " + e);
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
			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent().clickViewTransaction();
			dashboardPage.transactionsDetailsComponent().buyTokenTransactionDetails(data.get("transactionType"),
					data.get("transactionStatus"), data.get("transactionType1"));
			dashboardPage.navigationComponent().clickBack();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithCards failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBuyTokenInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickBuyTokens();
			if (data.get("accountType").equals("Bank")) {
				dashboardPage.withdrawTokenPage().clickBank();
			} else if (data.get("accountType").equals("Debit")) {
				dashboardPage.buyTokenComponent().clickDebitCard();
			} else {
				dashboardPage.buyTokenComponent().clickCreditCard();
			}
			if (!data.get("accountType").equals("Bank")) {
				dashboardPage.cvvPopup().verifyPopupHeading(data.get("cvvHeading"));
				dashboardPage.cvvPopup().fillCvv(data.get("cvv"));
				dashboardPage.cvvPopup().clickOk();
			}
			dashboardPage.buyTokenComponent().verifyBuyTokenHeading(data.get("tokensHeading"));
			double transactionLimit = dashboardPage.buyTokenComponent().verifyTransactionLimit();
			String[] fieldAmount = data.get("fieldAmount").split(",");
			dashboardPage.buyTokenComponent().fieldValidationsComponent().validateAmountField(fieldAmount[0],
					fieldAmount[1], fieldAmount[2]);
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					dashboardPage.buyTokenComponent().fillAmount(Double.toString(transactionLimit + 0.1));
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), "Amount field");
				} else {
					dashboardPage.buyTokenComponent().fillAmount(Double.toString(0.1));
					new CommonFunctions().validateDynamicTextMessage("Amount field");
				}
				dashboardPage.buyTokenComponent().verifyBuyToken();
			}
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
			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent().clickViewTransaction();
			dashboardPage.transactionsDetailsComponent().buyTokenTransactionDetails(data.get("transactionType"),
					data.get("transactionStatus"), data.get("transactionType1"));
			dashboardPage.navigationComponent().clickBack();
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
//			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent().clickDone();
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
				dashboardPage.buyTokenComponent().clickInstantPayDebitCard();
			}
			testWithdrawTokenProcedure(strParams);
			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent().clickViewTransaction();
			dashboardPage.transactionsDetailsComponent().buyTokenTransactionDetails(data.get("transactionType"),
					data.get("transactionStatus"), data.get("transactionType1"));
			dashboardPage.navigationComponent().clickBack();
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
			dashboardPage.buyTokenComponent().choosePinComponent().successFailureComponent().clickViewTransaction();
			dashboardPage.transactionsDetailsComponent().buyTokenTransactionDetails(data.get("transactionType"),
					data.get("transactionStatus"), data.get("transactionType1"));
			dashboardPage.navigationComponent().clickBack();
//			businessTransactionDetailsTest.testVerifyBuyTokenBankTransaction(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBuyTokenWithBankAccount  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawTokenInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			double avlBalDasBoard = dashboardPage.verifyAvailbleBalance();
			dashboardPage.clickWithdraw();
			dashboardPage.withdrawTokenPage().verifyWithdrawHeading(data.get("heading"));
			if (data.get("accountType").equals("Bank")) {
				dashboardPage.withdrawTokenPage().clickBankAccounts();
				dashboardPage.withdrawTokenPage().clickBank();
			} else {
				dashboardPage.withdrawTokenPage().clickInstantPay();
				dashboardPage.buyTokenComponent().clickInstantPayDebitCard();
			}
			dashboardPage.withdrawTokenPage().verifyWithdrawTokenHeading(data.get("tokensHeading"));
			dashboardPage.withdrawTokenPage().viewDailyLimits();
			double transactionLimit = dashboardPage.buyTokenComponent().verifyTransactionLimit();
			String[] fieldAmount = data.get("fieldAmount").split(",");
			dashboardPage.buyTokenComponent().fieldValidationsComponent().validateAmountField(fieldAmount[0],
					fieldAmount[1], fieldAmount[2]);
			String[] errMessage = data.get("errMessage").split(",,");
			for (int i = 0; i <= 3; i++) {
				if (transactionLimit < avlBalDasBoard) {
					System.out.println(i);
					dashboardPage.withdrawTokenPage().fillAmount(Double.toString(transactionLimit + 0.1));
					new CommonFunctions().validateFormErrorMessage(errMessage[i], "amount field");
				} else if (i == 1) {
					dashboardPage.withdrawTokenPage().fillAmount(Double.toString(0.1));
					new CommonFunctions().validateDynamicTextMessage("amount field");
				} else if (i > 1 && transactionLimit > avlBalDasBoard + 0.1) {
					if (i == 2) {
						dashboardPage.withdrawTokenPage().fillAmount(Double.toString(avlBalDasBoard));
					} else {
						dashboardPage.withdrawTokenPage().fillAmount(Double.toString(avlBalDasBoard + 0.1));
					}
					new CommonFunctions().validateFormErrorMessage(errMessage[i], "amount field");
				}
				dashboardPage.withdrawTokenPage().verifyWithdrawToken();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawTokenInvalidData failed due to exception " + e);
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
//			dashboardPage.withdrawTokenPage().choosePinComponent().successFailureComponent().clickDone();
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
			dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAmount();
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillAmount(data.get("amount"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAdd();
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
			dashboardPage.transactionsDetailsComponent()
					.withdrawGiftCardTransactionsDetails(data.get("transactionType"), data.get("transactionStatus"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawGiftCard  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testWithdrawGiftCardInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			double avlBal = dashboardPage.verifyAvailbleBalance();
			dashboardPage.clickWithdraw();
			dashboardPage.selectWithdrawMethodPage().verifyHeading(data.get("heading"));
			dashboardPage.selectWithdrawMethodPage().verifyGiftCardDes(data.get("description"));
			dashboardPage.selectWithdrawMethodPage().clickGiftCard();
			dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAmazon();
			dashboardPage.selectWithdrawMethodPage().giftCardPage().verifyWithdrawGiftCard(data.get("tokensHeading"));
			for (int i = 0; i < 3; i++) {
				String[] fieldAmount = data.get("fieldAmount").split(",");
				if (i < 1) {
					dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAmount();
					dashboardPage.selectWithdrawMethodPage().giftCardPage().fieldValidationsComponent()
							.validateAmountField(fieldAmount[0], fieldAmount[1], fieldAmount[2]);
				} else {
					if (i == 1) {
						dashboardPage.selectWithdrawMethodPage().giftCardPage().fillAmount(Double.toString(avlBal));
					} else {
						dashboardPage.selectWithdrawMethodPage().giftCardPage().fillAmount(Double.toString(avlBal + 1));
					}
					dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAdd();
					String[] amountErrMsg = data.get("amountErrMsg").split(",");
					new CommonFunctions().validateFormErrorMessage(amountErrMsg[i - 1], "Amount Field");
					dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAmount();
				}
			}
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillAmount(data.get("amount"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().clickAdd();
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillLastName(data.get("lastName"));
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillEmail(data.get("email"));
			for (int i = 0; i < 3; i++) {
				String[] fieldFirstName = data.get("fieldFirstName").split(",");
				if (i < 1) {
					dashboardPage.selectWithdrawMethodPage().giftCardPage().fieldValidationsComponent()
							.validateFirstNameField(fieldFirstName[0], fieldFirstName[1], fieldFirstName[2],
									fieldFirstName[3], data.get("validateDataType"));
				} else {
					DriverFactory.getDriver().hideKeyboard();
					dashboardPage.selectWithdrawMethodPage().giftCardPage().fillFirstName(fieldFirstName[i + 3]);
					dashboardPage.selectWithdrawMethodPage().giftCardPage().clickLastName();
					DriverFactory.getDriver().hideKeyboard();
					String[] fstNameErrMsg = data.get("fstNameErrMsg").split(",");
					new CommonFunctions().validateFormErrorMessage(fstNameErrMsg[i - 1], "First Name Field");
				}
			}
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillFirstName(data.get("firstName"));
			for (int i = 0; i < 3; i++) {
				String[] fieldLastName = data.get("fieldLastName").split(",");
				if (i < 1) {
					DriverFactory.getDriver().hideKeyboard();
					dashboardPage.selectWithdrawMethodPage().giftCardPage().fieldValidationsComponent()
							.validateLastNameField(fieldLastName[0], fieldLastName[1], fieldLastName[2],
									fieldLastName[3], data.get("validateDataType"));
				} else {
					DriverFactory.getDriver().hideKeyboard();
					dashboardPage.selectWithdrawMethodPage().giftCardPage().fillLastName(fieldLastName[i + 3]);
					dashboardPage.selectWithdrawMethodPage().giftCardPage().clickLastName();
					Thread.sleep(1200);
					dashboardPage.selectWithdrawMethodPage().giftCardPage().clickFirstName();
					DriverFactory.getDriver().hideKeyboard();
					String[] lstNameErrMsg = data.get("lstNameErrMsg").split(",");
					new CommonFunctions().validateFormErrorMessage(lstNameErrMsg[i - 1], "Last Name Field");
				}
			}
			dashboardPage.selectWithdrawMethodPage().giftCardPage().fillLastName(data.get("lastName"));
			for (int i = 0; i < 3; i++) {
				DriverFactory.getDriver().hideKeyboard();
				String[] fieldEmail = data.get("fieldEmail").split(",");
				if (i < 1) {
					dashboardPage.selectWithdrawMethodPage().giftCardPage().fieldValidationsComponent()
							.validateEmailField(fieldEmail[0], fieldEmail[1], fieldEmail[2]);
				} else {
					dashboardPage.selectWithdrawMethodPage().giftCardPage().fillEmail(fieldEmail[i + 2]);
					DriverFactory.getDriver().hideKeyboard();
					dashboardPage.selectWithdrawMethodPage().giftCardPage().clickEmail();
					dashboardPage.selectWithdrawMethodPage().giftCardPage().clickLastName();
					DriverFactory.getDriver().hideKeyboard();
					String[] emailErrMsg = data.get("emailErrMsg").split(",");
					new CommonFunctions().validateFormErrorMessage(emailErrMsg[i - 1], "Email Field");
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testWithdrawGiftCardInvalidData failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testScanSavedAlbum(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			testScanSaveAlbum(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanCode  failed due to exception " + e);
		}
	}

	public void testScanSaveAlbum(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			DashboardPage dashboardPage = new DashboardPage();
			double avlBalDasBoard = dashboardPage.verifyAvailbleBalance();
			dashboardPage.clickScan();
			dashboardPage.scanPage().clickOnWhileUsingApp();
			dashboardPage.scanPage().clickOnAlbum();
			dashboardPage.scanPage().clickAllow();
			dashboardPage.scanPage().clickPhotoFolder();
			dashboardPage.scanPage().clickPhoto();
			if (!data.get("message").isEmpty()) {
				dashboardPage.sendRequestPage().verifySendHeading(data.get("sendRequestHeading"));
				dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
				dashboardPage.sendRequestPage().clickMessageButton();
				dashboardPage.sendRequestPage().optionalMessagePopup().fillMessage(data.get("message"));
				dashboardPage.sendRequestPage().optionalMessagePopup().validateMessageField();
				dashboardPage.sendRequestPage().optionalMessagePopup().clickDone();
				dashboardPage.sendRequestPage().clickSend();
				dashboardPage.sendRequestPage().viewSender();
			}
			dashboardPage.sendRequestPage().verifyConfmSendHeading(data.get("confmSendHeading"));
			double avaBalConfirmPopup = dashboardPage.sendRequestPage().verifyAvailbleBalance();
			double transactionLimit = dashboardPage.sendRequestPage().verifyLimit();
			if (avlBalDasBoard == avaBalConfirmPopup) {
				ExtentTestManager.setPassMessageInReport(
						"The Same Available Balance is showing in Dash baord and Send Confirm popup");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"The Same Available Balance is not showing in Dash baord and Send Confirm popup");
			}
			if (data.get("errorMessage").isEmpty()) {
				dashboardPage.sendRequestPage().clickConfirm();
				dashboardPage.sendRequestPage().choosePinComponent().verifyEnterYourPinheading(data.get("pinHeading"));
				dashboardPage.sendRequestPage().choosePinComponent().fillPin(data.get("pin"));
				dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
						.verifySendRequestPurchase(data.get("successHeading"));
				dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent()
						.verifyAmount(data.get("amount"));
				dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().verifySendRequestDesc();
				dashboardPage.sendRequestPage().choosePinComponent().successFailureComponent().clickViewTransaction();
				dashboardPage.transactionsDetailsComponent().verifyHeading(data.get("transDtlsHeading"));
				dashboardPage.transactionsDetailsComponent().sentTransactionDetails(data.get("name"),
						data.get("amount"), data.get("transactionType"));
			} else {
				String[] errMsg = data.get("errorMessage").split(",");
				if (transactionLimit > avlBalDasBoard) {
					new CommonFunctions().validateFormErrorMessage(errMsg[0], "Sending Amount");
				} else {
					new CommonFunctions().validateFormErrorMessage(errMsg[1], "Sending Amount");
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanSaveAlbum  failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMyQRCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			dashboardPage.clickQRCode();
			dashboardPage.scanPage().clickAllow();
			dashboardPage.myQRCodePage().verifyPageHeading(data.get("heading"));
			dashboardPage.myQRCodePage().getUserNameText();
			if (data.get("message").isEmpty()) {
				dashboardPage.myQRCodePage().clickSetAmount();
				dashboardPage.myQRCodePage().verifyAmountPageHeading(data.get("amountHeading"));
				dashboardPage.myQRCodePage().fillAmount(data.get("amount"));
				dashboardPage.myQRCodePage().clickOk();
				dashboardPage.myQRCodePage().getRequestedAmount(data.get("amount"));
			}
			dashboardPage.myQRCodePage().clickSaveAlbum();
			dashboardPage.scanPage().clickAllow();
			dashboardPage.myQRCodePage().toastComponent().verifyToastMsg(data.get("toastMsg"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReceivePaymentView  failed due to exception " + e);
		}

	}

	public void testReceivePayment(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			DashboardPage dashboardPage = new DashboardPage();
			dashboardPage.clickQRCode();
			dashboardPage.myQRCodePage().verifyPageHeading(data.get("heading"));
			dashboardPage.myQRCodePage().getUserNameText();
			dashboardPage.myQRCodePage().clickSetAmount();
			dashboardPage.myQRCodePage().verifyAmountPageHeading(data.get("amountHeading"));
			dashboardPage.myQRCodePage().fillAmount(data.get("amount"));
			dashboardPage.myQRCodePage().clickOk();
			dashboardPage.myQRCodePage().getRequestedAmount(data.get("amount"));
			dashboardPage.myQRCodePage().clickSaveAlbum();
			dashboardPage.myQRCodePage().clickAllow();
			dashboardPage.myQRCodePage().toastComponent().verifyToastMsg(data.get("saveAlbumToast"));
			dashboardPage.myQRCodePage().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReceivePayment  failed due to exception " + e);
		}

	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testReceivePaymentWithInvalidData(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			dashboardPage.clickQRCode();
//			dashboardPage.myQRCodePage().verifyPageHeading(data.get("heading"));
//			dashboardPage.myQRCodePage().getUserNameText();
//			dashboardPage.myQRCodePage().clickSetAmount();
//			dashboardPage.myQRCodePage().verifyAmountPageHeading(data.get("amountHeading"));
//			dashboardPage.myQRCodePage().fillAmount(data.get("amount"));
//			dashboardPage.myQRCodePage().clickOk();
//			dashboardPage.myQRCodePage().errorMessagePopupComponent()
//					.verifyPopUpMsgHeading(data.get("errPopUpHeading"));
//			dashboardPage.myQRCodePage().errorMessagePopupComponent().verifyPopUpMsg(data.get("errPopUpMsg"));
//			dashboardPage.myQRCodePage().errorMessagePopupComponent().clickOk();
//			businessTokenAccountPage.tokenMenuIconPopUp().receivePaymentPage()
//					.verifyAmountPageHeading(data.get("amountHeading"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testReceivePaymentWithInvalidData  failed due to exception " + e);
//		}
//
//	}

}
