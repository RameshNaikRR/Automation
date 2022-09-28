package coyni.apibusiness.components;

import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.By;

import coyni.customer.popups.PayingAccountHolderNamePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class NotificationsComponent extends BrowserFunctions {

	// added
	private By notificationsIcon = By.xpath("//button[@class='icon-notification-bold img-notifications']");
	private By notificationCount = By.cssSelector(".notification-count");
	private By btnNotifications = By.xpath("//button[contains(text(),'Notifications')]");
	private By btnRequests = By.xpath("//button[contains(text(),'Pay/Req')]");
	private By btnPay = By.xpath("(//button[text()='Pay'])[1]");
	private By btnDeny = By.xpath("(//div[text()='Deny'])[2]");
	private By btnReminder = By.xpath("(//button[text()='Reminder'])[1]");
	private By btnCancel = By.xpath("(//div[text()='Cancel'])[2]");
	private By lblPayMessage = By.xpath("");
	private By lblReminderMessage = By.xpath("//div[text()='You sent a reminder to ']");
	private By btnclearAll = By.xpath("//span[text()='Clear All']");
	private By initialMsg = By.xpath("(//div[contains(@class,'ReceivedNotificationCard')]/div)[1]/../.");
	private By finalMsg = By.xpath("(//div[contains(@class,'ReceivedNotificationCard')]/div)[1]/../.");
	private By lastMsg = By.xpath("//span[@class='text-xs text-cm3 font-sans font-semibold']");
	private By recievedMsg = By.xpath(
			"//body//div[@id='root']//div[contains(@class,'notification-container')]//div//div//div[1]//div[2]//div[2]//div[1]//span[1]");
	private By ReminderfirstMsg = By.xpath("(//div[contains(@class,'ReceivedNotificationCard')]/div)[1]/../.");
	private By ReminderLastMsg = By.xpath("//div[@class='text-xs text-cm3 font-sans font-semibold']");
	private By CancelMsg = By.xpath("//div[@class='text-xs text-cm3 font-sans font-semibold']");
	private By count = By.xpath("");
	private By btnCross = By.xpath("//span[@class='cross-icon']//img ");
	private By elementList = By.xpath("//div[@class='SingleNotificationCard_firstDiv__2XnAQ w-16']");
	private By dateFormat = By.xpath("(//span[@class='ml-1 font-sans font-semibold text-xs text-cgy2 pt-1'])[3]");
	private By closeIcon = By.xpath("//span[@class='float-right mt-6 mr-8 cursor-pointer icon-close text-cgy2 hover:text-cgy4']");
	// private By notificationCOunt = By.xpath("//span[@class='text']");
	// private By todayNotifications =
	// By.xpath("//span/parent::div[@class=\"parent\"]");

	// added
	public void clickNotificationsIcon() {
		click(notificationsIcon, "NotificationIcon");

	}

	public void clickCloseIcon() {
		click(closeIcon, "Close Icon");
	}

	public String getUiCount() {
		return getText(notificationCount, "NotificationsCount");
	}

	// added
	public void verifyCursorNotification() {
		new CommonFunctions().verifyCursorAction(notificationsIcon, "Notification ");
	}

	// added
	public void verifyNotificationsCount() {
		int lst = getElementsList(elementList, "Notification List").size();
		ExtentTestManager.setPassMessageInReport("Displayed " + lst);
	}

	// added
	public void verifyDateFormatInNotifications() {
		new CommonFunctions().elementView(dateFormat, "date format notifications");
	}

	// added
	public void verifyAllNotifications() {
		int size = getElementsList(elementList, "Notification List").size();
		if (size > 0) {
			ExtentTestManager.setPassMessageInReport("Notifications Viewed");
		} else {
			ExtentTestManager.setFailMessageInReport("Notifications Empty");
		}

	}

	public void verifyMoveToCrossbtn() {
		moveToElement(btnCross, "Cross");
	}

	public void VerifyMousehoverNotificationscolor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(btnNotifications, "Notifications", expCssProp, expValue, expColor);
	}

	public void MousehoverNotificationscolor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(btnNotifications, "notifications", expCssProp, expValue, expColor);
	}

	public void verifyDenyBordercolor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(btnDeny, "Deny", expCssProp, expValue, expColor);
	}

	public void verifyCancelBorderColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(btnCancel, "Cancel", expCssProp, expValue, expColor);
	}

	// added
	public Count count() {
		return new Count();
	}

//	// added
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

	public void clickNotifications() {
		click(notificationsIcon, "Notifications ");
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
		click(btnclearAll, "Clear All");
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

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public void verifyRequestbtnView() {
		new CommonFunctions().elementView(btnRequests, "Requests");
	}

	public void verifyInitialMsg(String expInitialmesssage) {
		new CommonFunctions().verifyLabelTextContains(initialMsg, "Initial msg", expInitialmesssage);
	}

	public void verifyFinalMsg(String expFinalMessage) {
		new CommonFunctions().verifyLabelText(finalMsg, "Final message", expFinalMessage);
	}

	public void verifyLastMsg(String expLastMsg) {
		new CommonFunctions().verifyLabelText(lastMsg, "Last Msg", expLastMsg);
	}

	public void verifyNotificationsIconView() {
		new CommonFunctions().elementView(notificationsIcon, "notifications");
	}

	public void verifyNotificationsbtnView() {
		new CommonFunctions().elementView(btnNotifications, "notification button");
	}

	public void verifyRecievedMsg(String exprecievedMsg) {
		new CommonFunctions().verifyLabelText(recievedMsg, "recieved message", exprecievedMsg);
	}

	public void verifyPaybtnView() {
		new CommonFunctions().elementView(btnPay, "Pay button");
	}

	public void verifyDenybtnView() {
		new CommonFunctions().elementView(btnDeny, "Deny button");
	}

	public void verifyClearallBtnView() {
		new CommonFunctions().elementView(btnclearAll, "clear all");
	}

	public PayingAccountHolderNamePopup payingAccountHolderNamePopup() {
		return new PayingAccountHolderNamePopup();
	}

	public void verifyReminderLastMsg(String expReminderlstMsg) {
		new CommonFunctions().verifyLabelText(ReminderLastMsg, "reminder last msg", expReminderlstMsg);
	}

	public void verifyReminderfirstMsg(String expReminderfstMsg) {
		new CommonFunctions().verifyLabelText(ReminderfirstMsg, "Reminder first Msg", expReminderfstMsg);
	}

	public void verifybtnReminderView() {
		new CommonFunctions().elementView(btnReminder, "Reminder");
	}

	public void verifybtnCancelView() {
		new CommonFunctions().elementView(btnCancel, "Cancel");
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}

	public void verifyCancelMsg(String expCancelMsg) {
		new CommonFunctions().verifyLabelText(CancelMsg, "CancelMsg", expCancelMsg);
	}
}