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
			dashboardPage.notificationsPage().sendRequestPaymentPage().verifyHeading(data.get("heading"));
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
			dashboardPage.notificationsPage().sendRequestPaymentPage().verifyHeading(data.get("heading"));
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
	public void testNotificationsDelete() {
		try {
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().viewDots();
			dashboardPage.notificationsPage().swipeNotificationRight();
			dashboardPage.notificationsPage().clickDelete();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationsDelete is failed due to Exception " + e);
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
			dashboardPage.sendRequestPage().fillSearchBx(data.get("name"));
			dashboardPage.sendRequestPage().selectUser();
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
					.verifyHeading(data.get("reuestSuccHeading"));
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
			dashboardPage.sendRequestPage().fillSearchBx(data.get("name"));
			dashboardPage.sendRequestPage().selectUser();
			dashboardPage.sendRequestPage().verifyName();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			if (!data.get("errMsg").isEmpty()) {
				new CommonFunctions().validateFormErrMsg(data.get("errMsg"), data.get("elementName"));
				//
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
			dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("insuffHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickNewAmount();
			dashboardPage.sendRequestPage().verifyResetAmount();
			dashboardPage.sendRequestPage().viewSendHeading();
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("insuffHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickReload();
			dashboardPage.sendRequestPage().reloadPopup().verifyReloadHeading(data.get("reloadAmtHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickPaymentMethod();
			dashboardPage.sendRequestPage().reloadPopup().clickAddPayment();
			dashboardPage.sendRequestPage().reloadPopup().verifyAddPaymnetHeading(data.get("addPaymentHeading"));
			dashboardPage.navigationComponent().clickClose();
			dashboardPage.sendRequestPage().reloadPopup().verifyReloadHeading(data.get("reloadAmtHeading"));
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
			double a=dashboardPage.sendRequestPage().verifyWeeklyLimit();
			
			dashboardPage.sendRequestPage().fillAmount(data.get("amount"));
			dashboardPage.sendRequestPage().clickSend();
			dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("insuffHeading"));
			dashboardPage.sendRequestPage().reloadPopup().clickReload();
			if (data.get("WithoutPaymentMethod").equals("yes")) {
				dashboardPage.sendRequestPage().reloadPopup().verifyAddCardReloadHeading(data.get("addCardReloadHead"));
				dashboardPage.sendRequestPage().reloadPopup().clickAddCreditCard();
				CustomerProfileTest customerProfileTest = new CustomerProfileTest();
				customerProfileTest.testAddCardDetails(strParams);
				dashboardPage.sendRequestPage().clickSend();
				dashboardPage.sendRequestPage().reloadPopup().verifyInsuffHeading(data.get("insuffHeading"));
				dashboardPage.sendRequestPage().reloadPopup().clickReload();
			}
			dashboardPage.sendRequestPage().reloadPopup().verifyReloadHeading(data.get("reloadAmtHeading"));
			dashboardPage.sendRequestPage().reloadPopup().fillAmount(data.get("amount"));
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

}
