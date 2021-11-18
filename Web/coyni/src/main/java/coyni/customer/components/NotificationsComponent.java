package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class NotificationsComponent extends BrowserFunctions {

	// added
	private By notificationsIcon = By.cssSelector(".icon-notification-bold");
	private By notificationCount = By.cssSelector(".notification-count");
	private By btnNotifications = By.xpath("//button[contains(text(),'Notifications')]");
	private By btnPay = By.xpath("");
	private By btnDeny = By.xpath("");
	private By btnRequests = By.xpath("//button[contains(text(),'Requests')]");
	private By btnDelete = By.xpath("");

	// added
	public void clickNotificationsIcon() {
		click(notificationsIcon, "NotificationIcon");

	}

	public void clickNotifications() {
		click(btnNotifications, "Notifications ");
	}

	public void clickRequests() {
		click(btnRequests, "Requests ");
	}

//		public void clickPay() {
//			click(btnPay, "Pay ");
//		}
	//
//		public void clickDeny() {
//			click(btnDeny, "Deny ");
//		}
	//
//		public void clickDelete() {
//			click(btnDelete, "Delete ");
	//
//		}

	// added
	public void verifyPay() {
		new CommonFunctions().elementView(btnPay, "Pay is viewed");
	}

	// added
	public void verifyDeny() {
		new CommonFunctions().elementView(btnDeny, "Deny is viewed");
	}

	// added
	public CommonFunctions commonFunctions() {
		return new CommonFunctions();
	}

	public void verifyBellIconMouseHoverAction(String background, String border) {
		new CommonFunctions().verifyCursorAction(notificationsIcon, "Notification Icon");
		new CommonFunctions().verifyMouseHoverAction(notificationsIcon, "Notification Icon", background, border);
	}

	// added
	// public Count count() {
	// return new Count();
	// }

	// added
//	public void verifyNotificationsCount() {
//		int actCount = Integer.parseInt(this.count().toString());
//		int notificationsCount = getElementsList(notificationCount, "Count").size();
//		if (actCount == notificationsCount) {
//			ExtentTestManager.setPassMessageInReport("Number of Count in Notifications is " + actCount);
//		} else {
//			ExtentTestManager.setFailMessageInReport(
//					String.format("Number of Count in Notifications is ", notificationsCount, actCount));
//		}
//	}

}
