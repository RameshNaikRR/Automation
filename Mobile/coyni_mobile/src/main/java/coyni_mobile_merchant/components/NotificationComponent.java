package coyni_mobile_merchant.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.PayRequestConfirmPopup;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class NotificationComponent extends MobileFunctions {

	private By btnNotifications = MobileBy.xpath("//*[contains(@resource-id,'iv_notifications')]");
	private By btnRequest = MobileBy.xpath("//*[contains(@resource-id,'requestsTV')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'cancelLL')]");
	private By btnReminder = MobileBy.xpath("//*[contains(@resource-id,'remindLL')]");
	private By btnDeny = MobileBy.xpath("//*[contains(@resource-id,'denyLL')]");
	private By btnPay = MobileBy.xpath("//*[@text='Pay']");
	private By countNotification = MobileBy.xpath("//*[contains(@resource-id,'cvNotification')]");
	private By viewDot = MobileBy.xpath("//*[contains(@resource-id,'readStatusCV')]");
	private By notificationSwipe = MobileBy.xpath("//*[contains(@resource-id,'notificationItemLL')]");
	private By btnDelete = MobileBy.xpath("//*[contains(@resource-id,'deleteLL')]");
	private By reminderMessage = MobileBy.xpath("//*[contains(@resource-id,'messageTV')]");
	private By denyMessage = MobileBy.xpath("//*[contains(@resource-id,'messageTV')]");
	private By cancelMessage = MobileBy.xpath("//*[contains(@resource-id,'messageTV')]");
	private By lblRead = MobileBy.xpath("//*[contains(@resource-id,'readStatusTV')]");
	private By lblNotifications = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]");
	
	public void clickNotifications() {
		click(btnNotifications, "Notification");
	}

	public void verifyNotifications() {
		new CommonFunctions().elementView(lblNotifications, "Notification");
	}
	
	public void clickRequest() {
		click(btnRequest, "Request");
	}

	public void clickRead() {
		click(lblRead, "Read");
	}

	public void verifyRead() {
		new CommonFunctions().elementView(lblRead, "Read ");
	}

	public void countNotifications() {
		List<WebElement> elementList = getElementList(countNotification, "Count Elements");
		ExtentTestManager.setInfoMessageInReport("Element List : " + elementList.size());
	}

	public void viewNotification() {
		new CommonFunctions().elementView(btnNotifications, "View Notification");
	}

	public void viewRequest() {
		new CommonFunctions().elementView(btnRequest, "View Request");
	}

	public void viewPay() {
		new CommonFunctions().elementView(btnPay, "View Pay");
	}

	public void viewDots() {
		scrollDownToElement(viewDot, "view Dot");
		new CommonFunctions().elementView(viewDot, "View Dot");

	}

	public void clickDelete() {
		click(btnDelete, "Delete Notification");
	}

	public void viewDeny() {
		new CommonFunctions().elementView(btnDeny, "Deny");
	}

	public void readDot() {
		if (getElementList(viewDot, "read Message").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Dot is present");
		} else {
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
