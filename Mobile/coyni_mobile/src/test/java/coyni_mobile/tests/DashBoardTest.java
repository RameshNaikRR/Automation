package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.DashboardPage;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class DashBoardTest {

	DashboardPage dashboardPage;

	@BeforeTest
	public void init() {
		dashboardPage = new DashboardPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotifications(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			int beforeRead = dashboardPage.notificationsPage().countNotifications();
			ExtentTestManager.setPassMessageInReport("Before preform the action on notifications, the count is");
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().verifyMesaageTitle();
			dashboardPage.notificationsPage().verifyMessageBody();
			dashboardPage.notificationsPage().verifyTime();
			dashboardPage.notificationsPage().swipeNotificationLeft();
			dashboardPage.notificationsPage().verifyRead();
			dashboardPage.notificationsPage().navigationComponent().clickBack();
			dashboardPage.viewUserName();
			int afterRead = dashboardPage.notificationsPage().countNotifications();
			if (beforeRead == afterRead + 1) {
				ExtentTestManager.setPassMessageInReport("After Reading the notification, the count is reducing");
			} else {
				ExtentTestManager.setFailMessageInReport("After Reading the notification, the count is not reducing");
			}
			int beforeUnRead = dashboardPage.notificationsPage().countNotifications();
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().swipeNotificationLeft();
			dashboardPage.notificationsPage().verifyUnRead();
			dashboardPage.notificationsPage().navigationComponent().clickBack();
			dashboardPage.viewUserName();
			int afterUnRead = dashboardPage.notificationsPage().countNotifications();
			if (beforeUnRead == afterUnRead - 1) {
				ExtentTestManager.setPassMessageInReport("After Un Reading the notification, the count is increasing");
			} else {
				ExtentTestManager
						.setFailMessageInReport("After Un Reading the notification, the count is not increasing");
			}
			int beforeDelete = dashboardPage.notificationsPage().countNotifications();
			dashboardPage.clickNotifications();
			dashboardPage.notificationsPage().verifyNotificationHeading(data.get("notificationsHeading"));
			dashboardPage.notificationsPage().swipeNotificationRight();
			dashboardPage.notificationsPage().navigationComponent().clickBack();
			dashboardPage.viewUserName();
			int afterDelete = dashboardPage.notificationsPage().countNotifications();
			if (beforeDelete == afterDelete + 1) {
				ExtentTestManager.setPassMessageInReport("After Deleting the notification, the count is reducing");
			} else {
				ExtentTestManager
						.setFailMessageInReport("After Un Reading the notification, the count is not reducing");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotifications faield due to exception " + e);
		}

	}
}
