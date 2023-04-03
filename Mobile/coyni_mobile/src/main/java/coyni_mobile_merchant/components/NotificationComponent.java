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
	private By lblHeading = MobileBy.id("com.coyni.mapp:id/headerTV");
	private By lblTime = MobileBy.xpath("(//*[contains(@resource-id,'timeTV')])[1]");
	private By lblBody = MobileBy.xpath("(//*[contains(@resource-id,'messageTV')])[1]");
	private By lblTitle = MobileBy.xpath("(//*[contains(@resource-id,'subject')])[1]");
//	private By btnPay = MobileBy.xpath("//*[@text='Pay']");
	private By countNotification = MobileBy.id("com.coyni.mapp:id/countTV");
	private By viewDot = MobileBy
			.xpath("(//*[contains(@resource-id,'notificationsRV')]//*[contains(@resource-id,'readStatusCV')])[1]");
	private By notificationSwipe = MobileBy.xpath("(//*[contains(@resource-id,'subject')])[1]");
	private By btnDelete = MobileBy.xpath("//*[contains(@resource-id,'deleteLL')]");
//	private By reminderMessage = MobileBy.xpath("//*[contains(@resource-id,'messageTV')]");
//	private By denyMessage = MobileBy.xpath("//*[contains(@resource-id,'messageTV')]");
//	private By cancelMessage = MobileBy.xpath("//*[contains(@resource-id,'messageTV')]");
	private By lblRead = MobileBy.xpath("//*[contains(@text,'READ')]");
	private By lblUnRead = MobileBy.xpath("//*[contains(@text,'UNREAD')]");
//	private By lblNotifications = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]");

	public void clickNotifications() {
		click(btnNotifications, "Notification");
	}

	public void verifyNotificationHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Notifications", heading);
	}

	public void verifyNotifications() {
		new CommonFunctions().elementView(lblHeading, "Notification");
	}

	public void verifyUnRead() throws InterruptedException {
		new CommonFunctions().elementView(lblUnRead, "UNREAD");
		click(lblUnRead, "UNREAD");
		Thread.sleep(1500);
//		if (getElementList(viewDot, "Dot").size() == 1) {
//			ExtentTestManager.setPassMessageInReport("After clickin on READ, the dot is visible");
//		} else {
//			ExtentTestManager.setFailMessageInReport("After clickin on READ, the dot is not visible");
//		}
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
		new CommonFunctions().elementView(lblRead, "READ");
		click(lblRead, "READ");
		Thread.sleep(1500);
//		if (getElementList(viewDot, "Dot").size() == 0) {
//			ExtentTestManager.setPassMessageInReport("After clickin on READ, the dot is not visible");
//		} else {
//			ExtentTestManager.setFailMessageInReport("After clickin on READ, the dot is visible");
//		}
	}
//	public void clickRead() {
//		click(lblRead, "Read");
//	}

//	public void verifyRead() {
//		new CommonFunctions().elementView(lblRead, "Read ");
//	}

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
//		new CommonFunctions().elementView(btnNotifications, "View Notification");
//	}
//
//	public void viewRequest() {
//		new CommonFunctions().elementView(btnRequest, "View Request");
//	}
//
//	public void viewPay() {
//		new CommonFunctions().elementView(btnPay, "View Pay");
//	}

	public void viewDots() {
		scrollDownToElement(viewDot, "view Dot");
		new CommonFunctions().elementView(viewDot, "View Dot");

	}

	public void clickDelete() {
		click(btnDelete, "Delete Notification");
	}

//	public void viewDeny() {
//		new CommonFunctions().elementView(btnDeny, "Deny");
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

	public PayRequestConfirmPopup payRequestConfirmPopup() {
		return new PayRequestConfirmPopup();
	}
}
