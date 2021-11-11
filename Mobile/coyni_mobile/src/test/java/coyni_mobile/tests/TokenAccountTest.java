package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.NotificationComponent;
import coyni_mobile.pages.TokenAccountPage;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class TokenAccountTest {

	TokenAccountPage tokenAccountPage;
	NotificationComponent notificationComponent;

	@BeforeTest
	public void init() {

		tokenAccountPage = new TokenAccountPage();
		notificationComponent = new NotificationComponent();

	}

	@Test
	@Parameters({ "strParams" })
	public void testNotification(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickNotifications();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickBack();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Notification faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickPay();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Notification pay faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickNotifications();
			tokenAccountPage.notificationComponent().clickDeny();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Notification Deny faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestRemainder(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickRemainder();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Request Remainder  faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestCancel(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickNotificationsIcon();
			tokenAccountPage.notificationComponent().clickRequest();
			tokenAccountPage.notificationComponent().clickCancel();
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Request cancel  faield due to exception " + e);
		}
		
	}
		@Test
		@Parameters({ "strParams" })
		public void testRequestPay(String strParams) {
			try {
				Map<String, String> data = Runner.getKeywordParameters(strParams);
				tokenAccountPage.clickNotificationsIcon();
				tokenAccountPage.notificationComponent().clickRequest();
				tokenAccountPage.notificationComponent().clickPay();
			} catch (Exception e) {
				ExtentTestManager.setFailMessageInReport("Request Pay  faield due to exception " + e);
			}
	
	
	}

	@Test
		@Parameters({ "strParams" })
		public void testRequestDeny(String strParams) {
			try {
				Map<String, String> data = Runner.getKeywordParameters(strParams);
				tokenAccountPage.clickNotificationsIcon();
				tokenAccountPage.notificationComponent().clickRequest();
				tokenAccountPage.notificationComponent().clickDeny();
			} catch (Exception e) {
				ExtentTestManager.setFailMessageInReport("Request Deny  faield due to exception " + e);
			}
	
	
	}
	
	
	
	
}
