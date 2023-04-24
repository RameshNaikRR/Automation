package coyni.merchant.components;

import java.sql.SQLException;
import java.util.List;

import org.apache.poi.ss.formula.functions.Count;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class NotificationsComponent extends BrowserFunctions {

	private By notificationsIcon = By.xpath("//div[contains(@class,'internal-header__notification')]");
	private By notificationCount = By.cssSelector(".notification-count");
	private By lblNotificationss = By.xpath("//img[contains(@class,'SingleNotificationCard_dotIcon__XeCUH')]");
	private By btnNotifications = By.xpath("//button[contains(@class,'icon-notification-bold')]");
	private By notification = By.xpath("(//span[text()='Export Report Successful'])[1]");
	private By yesterdayNotifications = By.xpath("(//div[contains(@class,'notification-group')])[2]");
	private By olderNotifications = By.xpath("(//div[contains(@class,'notification-group')])[3]");
	private By todayNotifications = By.xpath("(//div[contains(@class,'notification-group')])[1]");
	private By btnCancel = By.xpath("(//div[contains(@class,'SingleNotificationCard_trash__w2Hnj')])[1]");
	private By cursorDeleteNotification = By.xpath("//div[contains(@class,'SingleNotificationCard_firstDiv__cMcd7')]");
	private By btnClearAll = By.xpath("(//span[text()='Clear All'])[1]");
	private By elementList = By.xpath("//div[@class='SingleNotificationCard_firstDiv__2XnAQ w-16']");
	private By dateFormat = By.xpath("(//span[@class='ml-1 font-sans font-semibold text-xs text-cgy2 pt-1'])[3]");
	private By closeIcon = By
			.xpath("//span[@class='float-right mt-6 mr-8 cursor-pointer icon-close text-cgy2 hover:text-cgy4']");
	private By lblnotification = By.xpath("(//span[contains(@class,'text-base font-sans font-bold text-cgy4')]/../..)[1]");

	public void clickNotificationsIcon() {
		click(notificationsIcon, "NotificationIcon");

	}

	public String getYesterdayCount() {
		return getText(yesterdayNotifications, "NotificationsCount");
	}

	public String getOlderCount() {
		return getText(olderNotifications, "NotificationsCount");
	}

	public String getTodayCount() {
		return getText(olderNotifications, "NotificationsCount");
	}

	public void verifyNotificationText(String expText) {
		String actText = getText(lblnotification, "Notification Text");
		if (actText.equals(expText)) {
			ExtentTestManager.setPassMessageInReport("The Heading is " + actText);
		} else {
			ExtentTestManager.setFailMessageInReport("the heading is not matched");
		}

	}

	public void getTotalTodayCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getTodayCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void getTotalOlderCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getOlderCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void getTotalNotificationsCount() throws InterruptedException {
		List<WebElement> list = getElementsList(lblNotificationss, "Notifications ");
		int size = list.size();
		System.out.println("size is " + size);
		ExtentTestManager.setInfoMessageInReport("List size is " + size);
		for (WebElement eles : list) {
			try {
				scrollToElement(lblNotificationss, "Scrolled");

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void getTotalYesterdayCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getYesterdayCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void getTotalCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getUiCount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
		}
	}

	public void clickCloseIcon() {
		click(closeIcon, "Close Icon");
	}

	public void clickClearAll() {
		click(btnClearAll, "Close");
	}

	public String getUiCount() {
		return getText(notificationCount, "NotificationsCount");
	}

	public void verifyCursorNotification() {
		new CommonFunctions().verifyCursorAction(notificationsIcon, "Notification ");
	}

	public void verifyCursorNotifications() {
		// click(notification, "Notification");
		new CommonFunctions().verifyCursorAction(notification, "Notifications");
	}

	// added
	public void verifyNotificationsCount() {
		int lst = getElementsList(elementList, "Notification List").size();
		ExtentTestManager.setPassMessageInReport("Displayed " + lst);
	}

	// added
	public void verifyDateFormatInNotifications() {
		new CommonFunctions().elementView(dateFormat, "date format notifications");
		String text = getText(dateFormat, "Heading ");
		ExtentTestManager.setInfoMessageInReport("Notifications : " + text);

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

	public void VerifyMousehoverNotificationscolor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(btnNotifications, "Notifications", expCssProp, expValue, expColor);
	}

	public void MousehoverNotificationscolor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(btnNotifications, "notifications", expCssProp, expValue, expColor);
	}

	public void verifyCancelBorderColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(btnCancel, "Cancel", expCssProp, expValue, expColor);
	}

	// added
	public Count count() {
		return new Count();
	}

	public void clickNotifications() {
		click(btnNotifications, "Notifications ");
	}

	public void clickDelete() {
		new CommonFunctions().verifyCursorAction(cursorDeleteNotification, "Cursor ");
		click(btnCancel, "Delete ");
	}

	public void verifyBellIconMouseHoverAction(String background, String border) {
		new CommonFunctions().verifyCursorAction(notificationsIcon, "Notification Icon");
		new CommonFunctions().verifyMouseHoverAction(notificationsIcon, "Notification Icon", background, border);
	}

	public void verifyNotificationsIconView() {
		new CommonFunctions().elementView(notificationsIcon, "notifications");
	}

	public void verifyNotificationsbtnView() {
		new CommonFunctions().elementView(btnNotifications, "notification button");
	}

	public void clickCancel() {
		click(btnCancel, "Cancel");
	}
}