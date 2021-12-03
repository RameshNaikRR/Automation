package coyni.customer.components;

import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class NotificationsComponent extends BrowserFunctions {

	// added
	private By notificationsIcon = By.cssSelector(".icon-notification-bold");
	private By notificationCount = By.cssSelector(".notification-count");
	private By btnNotifications = By.xpath("//button[contains(text(),'Notifications')]");
	private By btnRequests = By.xpath("//button[contains(text(),'Requests')]");
	private By btnPay = By.xpath("(//button[text()='Pay'])[1]");
	private By btnDeny = By.xpath("(//div[text()='Deny'])[2]");
	private By btnReminder = By.xpath("(//button[text()='Reminder'])[1]");
	private By btnCancel = By.xpath("(//div[text()='Cancel'])[2]");
	private By lblPayMessage = By.xpath("//span[text()='Pay ']");
	private By lblReminderMessage = By.xpath("//div[text()='You sent a reminder to ']");
	private By clearAll = By.xpath("//span[text()='Clear All']");

	private By count = By.xpath("");

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

	public void clickPay() {
		click(btnPay, "Pay ");
	}

	public void clickDeny() {
		click(btnDeny, "Deny ");
	}

	public void clickReminder() {
		click(btnReminder, "Reminder");
	}

	public void clickDelete() {
		click(btnCancel, "Delete ");
	}

	public void clickClearAll() {
		click(clearAll, "Clear All");
	}

	public void verifyLabelPayMessage() {
		new CommonFunctions().elementView(lblPayMessage, "Pay Message");
	}

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
	public Count count() {
		return new Count();
	}

	// added
	public void verifyNotificationsCount() {
		int actCount = Integer.parseInt(this.count().toString());
		int notificationsCount = getElementsList(notificationCount, "Count").size();
		if (actCount == notificationsCount) {
			ExtentTestManager.setPassMessageInReport("Number of Count in Notifications is " + actCount);
		} else {
			ExtentTestManager.setFailMessageInReport(
					String.format("Number of Count in Notifications is ", notificationsCount, actCount));
		}
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}