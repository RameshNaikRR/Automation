package coyni_mobile.components;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class NotificationComponent extends MobileFunctions {

	private By btnNotifications = MobileBy
			.xpath("//*[contains(@resource-id,'notificationsLL')]|//*[contains(@resource-id,'notificationsTV')]");
	private By btnRequest = MobileBy.xpath("//*[contains(@resource-id,'requestsTV')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'cancelLL')]");
	private By btnReminder = MobileBy.xpath("//*[contains(@resource-id,'remindLL')]");
	private By btnDeny = MobileBy.xpath("//*[contains(@resource-id,'denyLL')]");
	private By btnPay = MobileBy.xpath("//*[@text='Pay']");
	private By countNotification = MobileBy.xpath("//*[contains(@resource-id,'countTV')]");//// *[contains(@resource-id,'countTV')]|
	private By viewDot = MobileBy.xpath("//*[contains(@resource-id,'readStatusCV')]");
	private By notificationSwipe = MobileBy.xpath("(//*[contains(@resource-id,'subject')])[1]");
	private By btnDelete = MobileBy.xpath("//*[contains(@resource-id,'deleteLL')]");
	private By reminderMessage = MobileBy.xpath("//*[contains(@resource-id,'messageTV')]");
	private By denyMessage = MobileBy.xpath("//*[contains(@resource-id,'messageTV')]");
	private By cancelMessage = MobileBy.xpath("//*[contains(@resource-id,'messageTV')]");
	private By lblReadUnRead = MobileBy
			.xpath("//*[@text='READ']|//*[contains(@resource-id,'readStatusTV')]|//*[@text='UNREAD']");
	private By lblNotifDate = MobileBy.xpath("//*[contains(@text,'Today')]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void clickNotifications() {
		click(btnNotifications, "Notification");
	}

	public void clickRequest() {
		click(btnRequest, "Request");
		new CommonFunctions().elementView(btnRequest, "Request");
	}

	public void verifyNotifdate() {
		new CommonFunctions().elementView(btnNotifications, "Notifcations");
//		new CommonFunctions().elementView(lblNotifDate, "Today");
	}

	public void clickReadUnRead() {
		click(lblReadUnRead, "Read");
	}

	public void verifyReadUnRead(String expText) {
		new CommonFunctions().verifyLabelText(lblReadUnRead, "Text", expText);
	}

	public void verifyRead() {
		new CommonFunctions().elementView(lblReadUnRead, "Read ");
	}

	public int countNotifications() throws InterruptedException {
//		Thread.sleep();
		String elementList = getText(countNotification);
		// System.out.println(getText(countNotification));
		String list = elementList.replace(" ", "");
//		ExtentTestManager.setPassMessageInReport("Notification count is " + list);
//		int count=Integer.parseInt(elementList);
		int cunt = Integer.parseInt(list);
		ExtentTestManager.setPassMessageInReport("Notification count is " + cunt);
		return cunt;
	}

//	public void countNotifications() {
//		List<WebElement> elementList = getElementList(countNotification, "Count Elements");
//		ExtentTestManager.setInfoMessageInReport("Element List : " + elementList.size());
//	}

	public void viewNotification() {
		new CommonFunctions().elementView(btnNotifications, "View Notification");
	}

	public void viewRequest() {
		new CommonFunctions().elementView(btnRequest, "View Request");
	}

	public void viewPay() throws InterruptedException {
		// wait.until(ExpectedConditions.presenceOfElementLocated(btnPay));
		// scrollDownToElement(btnPay, "Pay");
		new CommonFunctions().elementView(btnPay, "View Pay");
	}

	public void viewDots() {
		scrollDownToElement(viewDot, "view Dot");
		new CommonFunctions().elementView(viewDot, "View Dot");

	}

	public void clickDelete() {
		click(btnDelete, "Delete Notification");
	}

	public void viewDeny() throws InterruptedException {
		// wait.until(ExpectedConditions.presenceOfElementLocated(btnDeny));
		// scrollDownToElement(btnDeny, "Deny");
		new CommonFunctions().elementView(btnDeny, "Deny");
	}

	public void readDot() {
		if (getElementList(viewDot, "read Message").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Dot is present");
			swipeOnElement(notificationSwipe, "Read", SwipeDirection.RIGHT);
			clickReadUnRead();
			swipeOnElement(notificationSwipe, "UnRead", SwipeDirection.RIGHT);
			clickReadUnRead();
			swipeOnElement(notificationSwipe, "Delete", SwipeDirection.LEFT);
			clickDelete();
			ExtentTestManager.setInfoMessageInReport(" Dot present in the Notification");
		} else {
			swipeOnElement(notificationSwipe, "Read", SwipeDirection.RIGHT);
			clickReadUnRead();
			swipeOnElement(notificationSwipe, "UnRead", SwipeDirection.RIGHT);
			clickReadUnRead();
			swipeOnElement(notificationSwipe, "Delete", SwipeDirection.LEFT);
			clickDelete();
			ExtentTestManager.setInfoMessageInReport("No Dot present in the Notification");
		}
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

	public void swipeNotificationRight() {
		if (verifyElementDisplayed(viewDot, "Dot")) {
			swipeOnElement(notificationSwipe, "Swiped Deleted Notification", SwipeDirection.LEFT);
		}
	}

	public void swipeNotificationLeft() {
		if (verifyElementDisplayed(viewDot, "Dot")) {
			swipeOnElement(notificationSwipe, "Swiped Read Notification", SwipeDirection.RIGHT);
		}
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	// Added
	public void clickPay() {
		if (getElement(btnPay, "Click Pay").isDisplayed()) {
			click(btnPay, "Pay");
			// String senderName
			// (By.xpath(String.format("btnPay", senderName)), "Pay button");
		} else {
			System.out.println("Pay button is in disable mode");
		}
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

	public PayRequestConfirmPopup payRequestConfirmPopup() {
		return new PayRequestConfirmPopup();
	}
}
