package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class NotificationsComponent extends BrowserFunctions{
	
	private By notificationsIcon = By.cssSelector(" ");
	private By btnNotifications = By.cssSelector(" ");
	private By btnRequests = By.cssSelector(" ");
	
	public void clickNotificationsIcon() {
		click(notificationsIcon, "NotificationIcon");
		
	}
	public void clickNotifications() {
		click(btnNotifications, "Notifications");
	}
	public void clickRequests() {
		click(btnRequests, "Requests");
	}
	
	

}
