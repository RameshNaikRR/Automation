package coyni.apibusiness.components;

import java.util.List;

import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.customer.popups.PayingAccountHolderNamePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class NotificationsComponent extends BrowserFunctions {

	// added
	private By notificationsBellIcon = By.xpath("//button[@class='icon-notification-bold img-notifications']");
	private By notificationCount = By.xpath("//span[@class='text']");
	private By btnNotifications = By.xpath("//button[@class='w-full h-full rounded-full']");
	private By btnReminder = By.xpath("(//button[text()='Reminder'])[1]");
	private By btnCancel = By.xpath("(//div[text()='Cancel'])[2]");
	private By lblReminderMessage = By.xpath("//div[text()='You sent a reminder to ']");
	private By btnclearAll = By.xpath("//span[text()='Clear All']");
	private By initialMsg = By.xpath("(//div[contains(@class,'ReceivedNotificationCard')]/div)[1]/../.");
	private By finalMsg = By.xpath("(//div[contains(@class,'ReceivedNotificationCard')]/div)[1]/../.");
	private By lastMsg = By.xpath("//span[@class='text-xs text-cm3 font-sans font-semibold']");
	private By recievedMsg = By.xpath(
			"//body//div[@id='root']//div[contains(@class,'notification-container')]//div//div//div[1]//div[2]//div[2]//div[1]//span[1]");
	private By ReminderfirstMsg = By.xpath("(//div[contains(@class,'ReceivedNotificationCard')]/div)[1]/../.");
	private By today = By.xpath("//span[text()='Today']");
	private By todayNotifications = By.xpath("//div[@class='notifications-wrap'][1]");
	private By yesterday = By.xpath("//span[text()='Yesterday']");
	private By yesterdayNotifications = By.xpath("//div[@class='notifications-wrap'][2]");
	private By older = By.xpath("//span[text()='Older']");
	private By olderNotifications = By.xpath("//div[@class='notifications-wrap'][3]");
	private By ReminderLastMsg = By.xpath("//div[@class='text-xs text-cm3 font-sans font-semibold']");
	private By CancelMsg = By.xpath("//div[@class='text-xs text-cm3 font-sans font-semibold']");
	private By btnCross = By.xpath("//span[@class='cross-icon']//img ");
	private By elementList = By.xpath("//div[@class='SingleNotificationCard_firstDiv__2XnAQ w-16']");
	private By dateFormat = By.xpath("(//span[text()='Export Report Successful'])[1]/following-sibling::span");
	private By closeIcon = By
			.xpath("//span[@class='float-right mt-6 mr-8 cursor-pointer icon-close text-cgy2 hover:text-cgy4']");
	// private By notificationCOunt = By.xpath("//span[@class='text']");
	// private By todayNotifications =
	// By.xpath("//span/parent::div[@class=\"parent\"]");

	// added
	public void clickNotificationsIcon() {
		click(notificationsBellIcon, "Notification Bell Icon");

	}

	public void viewTodayNotifications() {
		try {
			WebElement todayNotify = DriverFactory.getDriver().findElement(today);
//		moveToElement(today, "moved to Today");
			if (todayNotify.isDisplayed()) {
//				String notify = getText(todayNotifications, "Notifications");
				ExtentTestManager.setPassMessageInReport("Today Notifications are displayed");
				String dateFormate = getText(dateFormat, "Date Format");
				ExtentTestManager.setPassMessageInReport(dateFormate + "is displayed");
			} else {
				ExtentTestManager.setInfoMessageInReport("No Today Notifications");
			}
		} catch (Exception E) {
			ExtentTestManager.setInfoMessageInReport("No Today Notifications");
		}
	}

	public void viewYesterdayNotifications() {
		try {
			WebElement todayNotify = DriverFactory.getDriver().findElement(yesterday);
//		moveToElement(yesterday, "moved to Yesterday");
			if (todayNotify.isDisplayed()) {
//			String notify = getText(yesterdayNotifications, "Notifications");
				ExtentTestManager.setPassMessageInReport("Yesterday Notifications are displayed");
				String dateFormate = getText(dateFormat, "Date Format");
				ExtentTestManager.setPassMessageInReport(dateFormate + "is displayed");
			} else {
				ExtentTestManager.setInfoMessageInReport("No yesterday Notifications");
			}
		} catch (Exception E) {
			ExtentTestManager.setInfoMessageInReport("No yesterday Notifications");
		}
	}

	public void viewOlderNotifications() {
		try {
			WebElement todayNotify = DriverFactory.getDriver().findElement(older);
//		moveToElement(older, "moved to older");
			if (todayNotify.isDisplayed()) {
//				String notify = getText(olderNotifications, "Notifications");
				ExtentTestManager.setPassMessageInReport("older Notifications are displayed");
				String dateFormate = getText(dateFormat, "Date Format");
				ExtentTestManager.setPassMessageInReport(dateFormate + " Date Format is displayed");
			} else {
				ExtentTestManager.setInfoMessageInReport("No older Notifications");
			}
		} catch (Exception e) {
			ExtentTestManager.setInfoMessageInReport("No Older Notifications");
		}

	}

	public void clickCloseIcon() {
		click(closeIcon, "Close Icon");
	}

//	public String getUiCount() {
//		return getText(notificationCount, "NotificationsCount");
//	}

	// added
	public void verifyNotificationsCount() {
		new CommonFunctions().verifyCursorAction(notificationCount, "Notification Count ");
		String str = getElement(notificationCount, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		String notifyCount = getText(notificationCount, "Notifications Count");
		ExtentTestManager.setInfoMessageInReport(notifyCount + " Notifications are displayed");
	}

	// added
	public void verifyDateFormatInNotifications() {

		new CommonFunctions().elementView(dateFormat, "date format notifications");
		List<WebElement> rows = getElementsList(dateFormat, "Date Format");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
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
		click(btnCross, "Cross");
	}

	public void verifyNotificationsTextColor() {
		new CommonFunctions().verifyCursorAction(btnNotifications, "Notification Count ");
		String str = getElement(btnNotifications, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
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
		click(notificationsBellIcon, "Notifications ");
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

	// added
	public CommonFunctions commonFunctions() {
		return new CommonFunctions();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
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

	public void verifyNotificationsBellIconView() {
		new CommonFunctions().elementView(notificationsBellIcon, "Notifications Bell icon");
	}

	public void verifyNotificationsbtnView() {
		new CommonFunctions().elementView(btnNotifications, "notification button");
	}

	public void verifyRecievedMsg(String exprecievedMsg) {
		new CommonFunctions().verifyLabelText(recievedMsg, "recieved message", exprecievedMsg);
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