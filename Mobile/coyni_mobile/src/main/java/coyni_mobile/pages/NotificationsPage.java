package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class NotificationsPage extends MobileFunctions {

	private By btnNotificationIcon = MobileBy.AccessibilityId("");
	private By lblHeading = MobileBy.AccessibilityId("com.coyni.mapp:id/headerTV");
	private By lblTime = MobileBy.AccessibilityId("(//*[contains(@resource-id,'timeTV')])[1]");
	private By lblBody = MobileBy.AccessibilityId("(//*[contains(@resource-id,'messageTV')])[1]");
	private By lblTitle = MobileBy.AccessibilityId("(//*[contains(@resource-id,'subject')])[1]");
//	private By btnPay = MobileBy.AccessibilityId("//*[@text='Pay']");
	private By countNotification = MobileBy.AccessibilityId("com.coyni.mapp:id/countTV");
	private By viewDot = MobileBy.AccessibilityId(
			"(//*[contains(@resource-id,'notificationsRV')]//*[contains(@resource-id,'readStatusCV')])[1]");
	private By notificationSwipe = MobileBy.AccessibilityId("(//*[contains(@resource-id,'subject')])[1]");
	private By btnDelete = MobileBy.AccessibilityId("//*[contains(@resource-id,'deleteLL')]");
	private By btnNotifications = MobileBy.AccessibilityId(
			"//*[contains(@resource-id,'notificationsLL')]|//*[contains(@resource-id,'notificationsTV')]");
	private By btnRequest = MobileBy.AccessibilityId("//*[contains(@resource-id,'requestsTV')]");
	private By btnCancel = MobileBy.AccessibilityId("//*[contains(@resource-id,'cancelLL')]");
	private By btnReminder = MobileBy.AccessibilityId("//*[contains(@resource-id,'remindLL')]");
	private By btnDeny = MobileBy.AccessibilityId("//*[contains(@resource-id,'denyLL')]");
	private By btnSend = MobileBy.AccessibilityId("//*[@text='Pay']");
	private By reminderMessage = MobileBy.AccessibilityId("//*[contains(@resource-id,'messageTV')]");
	private By denyMessage = MobileBy.AccessibilityId("//*[contains(@resource-id,'messageTV')]");
	private By cancelMessage = MobileBy.AccessibilityId("//*[contains(@resource-id,'messageTV')]");
	private By lblReadUnRead = MobileBy
			.AccessibilityId("//*[@text='READ']|//*[contains(@resource-id,'readStatusTV')]|//*[@text='UNREAD']");
	private By lblNotifDate = MobileBy.AccessibilityId("//*[contains(@text,'Today')]");

	public void clickNotifications() {
		click(btnNotificationIcon, "Notifications Icon");
	}

	public void verifyNotificationHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Notifications", heading);
	}

	public void verifyNotifications() {
		new CommonFunctions().elementView(lblHeading, "Notification");
	}

	public void verifyUnRead() throws InterruptedException {
//		new AndroidCommonFunctions().elementView(lblUnRead, "UNREAD");
		if (getElementList(viewDot, "Dot").size() == 1) {
			ExtentTestManager.setPassMessageInReport("After clickin on READ, the dot is visible");
		} else {
			ExtentTestManager.setFailMessageInReport("After clickin on READ, the dot is not visible");
		}
	}

	public void verifyMessageBody() {
		new CommonFunctions().elementView(lblBody, "Body");
	}

	public void verifyTime() {
		new CommonFunctions().elementView(lblTime, "Time");
	}

	public void verifyMesaageTitle() {
		new CommonFunctions().elementView(lblTitle, "Title");
	}

	public void verifyRead() throws InterruptedException {
		if (getElementList(viewDot, "Dot").size() == 0) {
			ExtentTestManager.setPassMessageInReport("After clickin on READ, the dot is not visible");
		} else {
			ExtentTestManager.setFailMessageInReport("After clickin on READ, the dot is visible");
		}
	}

	public int countNotifications() throws InterruptedException {
//		Thread.sleep();
		String elementList = getText(countNotification);
		ExtentTestManager.setPassMessageInReport("Notification count is " + elementList);
//		int count=Integer.parseInt(elementList);
		int cunt = Integer.parseInt(elementList);
		ExtentTestManager.setPassMessageInReport("Notification count is " + cunt);
		return cunt;
	}

//	public void viewNotification() {
//		new AndroidCommonFunctions().elementView(btnNotifications, "View Notification");
//	}
//
//	public void viewRequest() {
//		new AndroidCommonFunctions().elementView(btnRequest, "View Request");
//	}
//
//	public void viewPay() {
//		new AndroidCommonFunctions().elementView(btnPay, "View Pay");
//	}

	public void viewDots() {
		scrollDownToElement(viewDot, "view Dot");
		new CommonFunctions().elementView(viewDot, "View Dot");
	}

	public void clickDelete() {
		click(btnDelete, "Delete Notification");
	}

//	public void viewDeny() {
//		new AndroidCommonFunctions().elementView(btnDeny, "Deny");
//	}

	public void readDot() {
		if (getElementList(viewDot, "read Message").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Dot is present");
		} else {
			ExtentTestManager.setInfoMessageInReport("No Dot present in the Notification");
		}
	}

	public void swipeNotificationRight() {
//		if (verifyElementDisplayed(viewDot, "Dot")) {
		swipeOnElement(notificationSwipe, "Swiped Deleted Notification", SwipeDirection.LEFT);
//		}
	}

	public void swipeNotificationLeft() {
//		if (verifyElementDisplayed(viewDot, "Dot")) {
		swipeOnElement(notificationSwipe, "Swiped Read Notification", SwipeDirection.RIGHT);
//		}
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

//	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
//
//	public void clickNotifications() {
//		click(btnNotifications, "Notification");
//	}

	public void clickRequest() {
		click(btnRequest, "Request");
		new CommonFunctions().elementView(btnRequest, "Request");
	}

	public void verifyNotifdate() {
		new CommonFunctions().elementView(btnNotifications, "Notifcations");
	}

	public void clickReadUnRead() {
		click(lblReadUnRead, "Read");
	}

	public void verifyReadUnRead(String expText) {
		new CommonFunctions().verifyLabelText(lblReadUnRead, "Text", expText);
	}

	public void viewNotification() {
		new CommonFunctions().elementView(btnNotifications, "View Notification");
	}

	public void viewRequest() {
		new CommonFunctions().elementView(btnRequest, "View Request");
	}

	public void viewSend() throws InterruptedException {
		new CommonFunctions().elementView(btnSend, "Send");
	}

	public void viewDeny() throws InterruptedException {
		new CommonFunctions().elementView(btnDeny, "Deny");
	}

	public void verifyDenyMessage(String heading) {
		new CommonFunctions().verifyLabelText(denyMessage, "Deny Message", heading);
	}

	public void verifyReminderMessage(String heading) {
		new CommonFunctions().verifyLabelText(reminderMessage, "Reminder Message", heading);
	}

	public void verifyCancelMessage(String heading) {
		new CommonFunctions().verifyLabelText(cancelMessage, "Cancel Message", heading);
	}

	// Added
	public void clickSend() {
		click(btnSend, "Send");
	}

	public void clickDeny() {
		click(btnDeny, "Deny");
	}

	public void clickRemainder() {
		click(btnReminder, "Reminder");
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public SendRequestPaymentPage sendRequestPaymentPage() {
		return new SendRequestPaymentPage();
	}
}
