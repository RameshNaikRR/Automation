package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class NotificationComponent extends MobileFunctions {

	// private By notificationsIcon = MobileBy.xpath(" ");
	private By btnNotifications = MobileBy.xpath(" ");
	private By btnRequest = MobileBy.xpath(" ");
	private By btnCancel = MobileBy.xpath(" ");
	private By btnRemainder = MobileBy.xpath(" ");
	private By btnDeny = MobileBy.xpath(" ");
	private By btnPay = MobileBy.xpath(" ");
	private By btnBack = MobileBy.xpath(" ");

//	public void clickNotificationsIcon() {
//		click(notificationsIcon, "Notification Icon");
//	}

	public void clickNotifications() {
		click(btnNotifications, "Notification");
	}

	public void clickRequest() {
		click(btnRequest, "Request");
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickRemainder() {
		click(btnRemainder, "Remainder");
	}

	public void clickDeny() {
		click(btnDeny, "Deny");
	}

	public void clickPay() {
		click(btnPay, "Pay");
	}
	public void clickBack() {
		click(btnBack, "Back");
	}

}
