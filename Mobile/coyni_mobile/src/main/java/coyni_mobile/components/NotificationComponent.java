package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class NotificationComponent extends MobileFunctions {

	private By notificationsIcon = MobileBy.xpath(" ");
	private By btnNotifications = MobileBy.xpath(" ");
	private By btnDeny = MobileBy.xpath(" ");
	private By btnPay = MobileBy.xpath(" ");

	public void clickNotificationsIcon() {
		click(notificationsIcon, "Notification Icon");
	}

	public void clickNotifications() {
		click(btnNotifications, "Notification");
	}

	public void clickDeny() {
		click(btnDeny, "Deny");
	}

	public void clickPay() {
		click(btnPay, "Pay");
	}

}
