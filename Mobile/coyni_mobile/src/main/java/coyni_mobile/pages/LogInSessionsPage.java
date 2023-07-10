package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class LogInSessionsPage extends MobileFunctions {

	private By lblHeader = MobileBy.xpath("//*[@text='Log In Sessions']");
	private By lblDescription = MobileBy.id("com.coyni.mapp:id/changePasswordTV");
	private By lblInactive = MobileBy.xpath("(//*[@text='Inactive'])[1]");
	private By lblActive = MobileBy.xpath("//*[@text='Active Now']");
	private By btnEndAllSessions = MobileBy.xpath("//*[contains(@resource-id,'AllSessions')]");
	private By lblDeviceName = MobileBy.id("com.coyni.mapp:id/appNameTV");
	private By lblDeviceLocation = MobileBy.id("com.coyni.mapp:id/addressTV");
	private By lblDate = MobileBy.id("com.coyni.mapp:id/dateNtimeTV");
	private By lblEndSessionHeading = MobileBy
			.xpath("//*[contains(@text,'All devices will be')]/preceding-sibling::android.widget.TextView");
	private By lblEndSessionDesc = MobileBy.xpath("//*[contains(@text,'All devices will be')]");
	private By btnChangePassword = MobileBy.xpath("//*[@text='Change Password']");

	public void viewLogInSessHeader(String expText) {
		new CommonFunctions().verifyLabelText(lblHeader, "Login Sessions Heading", expText);
		new CommonFunctions().elementView(lblDescription, "Login Sessions Description");
	}

	public void clickLnkChangePassword() {
		click(lblDescription, "Change Password");
	}

	public void clickEndAllSessions() {
		click(btnEndAllSessions, "End All Sessions");
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	public void clickChangePassword() {
		click(btnChangePassword, "Change Password");
	}

	public void verifyDeviceDetails() {
		new CommonFunctions().elementView(lblDeviceName, "Device Name");
		new CommonFunctions().elementView(lblDeviceLocation, "Device Location");
		new CommonFunctions().elementView(lblDate, "Device Login Date");
	}

	public void verifyDeviceStatus(String expText) throws InterruptedException {
		Thread.sleep(500);
		if (getElementList(lblActive, "Status").size() == 1) {
			new CommonFunctions().verifyLabelText(lblActive, "Status", expText);
		} else {
			ExtentTestManager.setFailMessageInReport("The Active Status not as expected");
		}
	}

	public void viewInactiveStatus() {
		new CommonFunctions().elementView(lblInactive, "Inactive Status");
	}

	public void verifyEndSessionsHeading(String expText) {
		new CommonFunctions().verifyLabelText(lblEndSessionHeading, "End Sessions Heading", expText);
	}

	public void viewEndSessionsDesc() {
		new CommonFunctions().elementView(lblEndSessionDesc, "End Session Description");
	}

}
