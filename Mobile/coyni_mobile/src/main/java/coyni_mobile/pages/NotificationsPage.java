package coyni_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class NotificationsPage extends MobileFunctions {

	private By btnNotificationIcon = MobileBy.id("com.coyni.mapp:id/notificationIV");
	private By lblHeading = MobileBy.id("com.coyni.mapp:id/notificationsTV");
	private By lblTime = MobileBy.xpath("(//*[contains(@resource-id,'timeTV')])[1]");
	private By lblBody = MobileBy.xpath("(//*[contains(@resource-id,'messageTV')])[1]");
	private By lblTitle = MobileBy.xpath("(//*[contains(@resource-id,'subject')])[1]");
//	private By btnPay = MobileBy.id("//*[@text='Pay']");
	private By countNotification = MobileBy.id("com.coyni.mapp:id/countTV");
	private By viewDot = MobileBy.xpath(
			"//*[@text='Past']/following-sibling::*/descendant::android.widget.FrameLayout[contains(@resource-id,'readStatusCV')]");
	private By notificationSwipe = MobileBy.xpath("(//*[contains(@resource-id,'subject')])[1]");
	private By btnDelete = MobileBy.xpath("//*[contains(@resource-id,'deleteLL')]");
	private By btnNotifications = MobileBy
			.xpath("//*[contains(@resource-id,'notificationsLL')]|//*[contains(@resource-id,'notificationsTV')]");
	private By btnRequest = MobileBy.id("com.coyni.mapp:id/requestsTV");
	private By btnCancel = MobileBy.xpath(
			"//*[@text='Today']/following-sibling::*/descendant::android.widget.LinearLayout[contains(@resource-id,'cancelLL')]");
	private By btnReminder = MobileBy.xpath(
			"//*[@text='Today']/following-sibling::*/descendant::android.widget.LinearLayout[contains(@resource-id,'remindLL')]");
	private By btnDeny = MobileBy.xpath(
			"//*[@text='Today']/following-sibling::*/descendant::android.widget.LinearLayout[contains(@resource-id,'denyLL')]");
	private By btnSend = MobileBy.xpath(
			"//*[@text='Today']/following-sibling::*/descendant::android.widget.LinearLayout[contains(@resource-id,'payLL')]");
	private By btnNotifiDeny = MobileBy.xpath(
			"//*[@text='Today']/parent::*/following-sibling::*[1]/descendant::android.widget.LinearLayout[contains(@resource-id,'denyLL')]");
	private By btnNotifiSend = MobileBy.xpath(
			"//*[@text='Today']/parent::*/following-sibling::*[1]/descendant::android.widget.LinearLayout[contains(@resource-id,'payLL')]");
	private By reminderMessage = MobileBy.xpath(
			"//*[@text='Today']/following-sibling::*/descendant::android.widget.TextView[contains(@resource-id,'messageTV')]");
	private By denyMessage = MobileBy.xpath("//*[@text='You declined this request']");
	private By cancelMessage = MobileBy.xpath(
			"//*[@text='Today']/following-sibling::*/descendant::android.widget.TextView[contains(@text,'You cancelled')]");
	private By lblReadUnRead = MobileBy
			.xpath("//*[@text='READ']|//*[contains(@resource-id,'readStatusTV')]|//*[@text='UNREAD']");
	private By lblNotifDate = MobileBy.xpath("//*[contains(@text,'Today')]");
	private By btnBack = MobileBy.id("com.coyni.mapp:id/notifBackbtn");
	private By lblMessageBody = MobileBy.xpath(
			"//*[@text='Today']/following-sibling::*/descendant::android.widget.TextView[contains(@resource-id,'subject')]");
	private By lblProfile = MobileBy.xpath(
			" //*[@text='Today']/following-sibling::*/descendant::android.widget.ImageView[contains(@resource-id,'imgProfileSmall')]|//*[@text='Today']/following-sibling::*/descendant::android.widget.TextView[contains(@resource-id,'tvUserInfoSmall')]");
	private By lblMessage = MobileBy.xpath(
			"//*[@text='Today']/following-sibling::*/descendant::android.widget.TextView[contains(@resource-id,'messageTV')]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);

	public void verifySendSentMessage(String name, String amount, String message) throws InterruptedException {
//		if (getText(lblMessageBody).equals(name + "  Sent You " + amount + "  CYN")) {
//			ExtentTestManager.setPassMessageInReport("The Sent Message is as exepcted : " + getText(lblMessageBody));
//		} else {
//			ExtentTestManager.setFailMessageInReport(
//					"The Sent Message is not as exepcted that is appearing like this : " + getText(lblMessageBody));
//		}
		Thread.sleep(800);
		if (getText(lblMessage).equals(message)) {
			ExtentTestManager.setPassMessageInReport("The Add Note is Displaying accurately : " + getText(lblMessage));
		} else {
			ExtentTestManager
					.setFailMessageInReport("The Add Note is not Displaying accurately : " + getText(lblMessage));
		}
		String[] pfName = name.split(" ");
		char fstNameFstCh = pfName[0].charAt(0);
		char lstNameFstCh = pfName[1].charAt(0);
		if (getText(lblProfile).equals(Character.toString(fstNameFstCh) + Character.toString(lstNameFstCh))
				|| (getText(lblProfile).equals(""))) {
			ExtentTestManager.setPassMessageInReport(
					"The Profile is showing First letters of First and Last Name or account have a Profile pic");
		} else {
			ExtentTestManager.setFailMessageInReport(
					"The Profile not showing First letters of First and Last Name and as well account don't have a Profile pic");
		}
	}

	public void clickNotifications() {
		click(btnNotificationIcon, "Notifications Icon");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void verifyNotificationHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Notifications", heading);
	}

	public void verifyNotifications() {
		new CommonFunctions().elementView(lblHeading, "Notification");
	}

	public void verifyUnRead() throws InterruptedException {
//		new AndroidCommonFunctions().elementView(lblUnRead, "UNREAD");
		Thread.sleep(1200);
		if (getElementList(viewDot, "Dot").size() == 1) {
			ExtentTestManager.setPassMessageInReport("After Swiping Right the Notification, the dot is visible");
		} else {
			ExtentTestManager.setFailMessageInReport("After Swiping Right the Notification, the dot is not visible");
		}
	}

	public void verifyMessageBody() {
		if (getElementList(lblBody, "Message").size() == 0) {
			new CommonFunctions().elementView(lblBody, "Notification Message");
		}
	}

	public void verifyTime() {
		new CommonFunctions().elementView(lblTime, "Time of Notification Message");
	}

	public void verifyMesaageTitle() throws InterruptedException {
		Thread.sleep(1000);
		new CommonFunctions().elementView(lblTitle, "Title of Notification Message");
	}

	public void verifyRead() throws InterruptedException {
		Thread.sleep(1200);
		if (getElementList(viewDot, "Dot").size() == 0) {
			ExtentTestManager.setPassMessageInReport("After Swiping Right the Notification, the dot is not visible");
		} else {
			ExtentTestManager.setFailMessageInReport("After Swiping Right the Notification, the dot is visible");
		}
	}

	public int countNotifications() throws InterruptedException {
		int count = Integer.parseInt(getText(countNotification));
		ExtentTestManager.setPassMessageInReport("Notification count is " + count);
		return count;
	}

	public void viewDots() {
		scrollDownToElement(viewDot, "view Dot");
		new CommonFunctions().elementView(viewDot, "View Dot");
	}

	public void clickDelete() {
		click(btnDelete, "Delete Notification");
	}

	public void readDot() throws InterruptedException {
		Thread.sleep(1200);
		if (getElementList(viewDot, "read Message").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Dot is present");
		} else {
			ExtentTestManager.setInfoMessageInReport("No Dot present in the Notification");
		}
	}

	public void swipeNotificationRight() {
		swipeOnElement(notificationSwipe, "Swiped Deleted Notification", SwipeDirection.LEFT);
	}

	public void swipeNotificationLeft() {
		swipeOnElement(notificationSwipe, "Swiped Read Notification", SwipeDirection.RIGHT);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public void clickRequest() throws InterruptedException {
		Thread.sleep(2500);
		wait.until(ExpectedConditions.presenceOfElementLocated(btnRequest));
		click(btnRequest, "Request");
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

	public void verifyDenyMessage(String heading) throws InterruptedException {
		new CommonFunctions().verifyLabelText(denyMessage, "Deny Message", heading);
		Thread.sleep(4000);
		if (getElementList(denyMessage, "Deny Message").size() == 0) {
			ExtentTestManager
					.setPassMessageInReport("After Declining the request notification it is disappeared form list");
		} else {
			ExtentTestManager
					.setFailMessageInReport("After Declining the request notification it is not disappeared form list");
		}
	}

	public void verifyReminderMessage(String name) throws InterruptedException {
		Thread.sleep(800);
		System.out.println(getText(reminderMessage));
		System.out.println(name);
		if (getText(reminderMessage).equals("You sent a reminder to " + name)) {
			ExtentTestManager.setPassMessageInReport("Reminder message is verified : " + getText(reminderMessage));
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Reminder message is not as per expected and showing message is : " + getText(reminderMessage));
		}
	}

	public void verifyCancelMessage(String heading) throws InterruptedException {
		new CommonFunctions().verifyLabelText(reminderMessage, "Cancel Message", heading);
		Thread.sleep(4000);
		if (getElementList(cancelMessage, "Cancel Message").size() == 0) {
			ExtentTestManager
					.setPassMessageInReport("After cancelling the request notification it is disappeared form list");
		} else {
			ExtentTestManager.setFailMessageInReport(
					"After cancelling the request notification it is not disappeared form list");
		}
	}

	// Added
	public void clickSend() {
		click(btnSend, "Send");
	}

	public void clickDeny() {
		click(btnDeny, "Deny");
	}

	public void clickNotificSend() {
		click(btnNotifiSend, "Send");
	}

	public void clickNotificDeny() {
		click(btnNotifiDeny, "Deny");
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
