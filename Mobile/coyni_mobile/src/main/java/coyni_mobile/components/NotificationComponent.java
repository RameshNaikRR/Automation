package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class NotificationComponent extends MobileFunctions {

	private By btnNotifications = MobileBy.xpath(" ");
	private By btnRequest = MobileBy.xpath(" ");
	private By btnCancel = MobileBy.xpath(" ");
	private By btnRemainder = MobileBy.xpath(" ");
	private By btnDeny = MobileBy.xpath(" ");
	private By btnPay = MobileBy.xpath(" ");
	private By btnBack = MobileBy.xpath(" ");
	private By countNotification = MobileBy.xpath(" ");

	private By viewDot = MobileBy.xpath(" ");
	private By btnDelete = MobileBy.xpath(" ");

	private By verifyDenyHeading = MobileBy.xpath(" ");

	public void clickNotifications() {
		click(btnNotifications, "Notification");
	}

	public void clickRequest() {
		click(btnRequest, "Request");
	}

	public void countNotifications() {
		getElementList(countNotification, "Count Elements");
	}

	public void viewNotification() {
		new CommonFunctions().elementView(btnNotifications, "View Notification");
	}

	public void viewRequest() {
		new CommonFunctions().elementView(btnRequest, "View Request");
	}

	public void viewPay() {
		new CommonFunctions().elementView(btnPay, "View Pay");
	}

	public void viewDots() {
		new CommonFunctions().elementView(viewDot, "View Dot");
	}

	public void clickDelete() {
		click(btnDelete, "Delete Notification");
	}

	public void viewDeny() {
		new CommonFunctions().elementView(btnDeny, "Deny");
	}

	public void readDot() {
		if (getElementList(viewDot, "read Message").size() > 0) {
			ExtentTestManager.setInfoMessageInReport("Dot is present");
		} else {
			ExtentTestManager.setInfoMessageInReport("No Dot present in the Notification");
		}
	}

	public void verifyDenyHeading(String heading) {
		new CommonFunctions().verifyLabelText(verifyDenyHeading, "Deny Heading", heading);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	// Added
	public void clickPay(String senderName) {
		if (getElement(btnPay, "Click Pay").isDisplayed()) {
			click(By.xpath(String.format(" ", senderName)), "Pay  button");
		} else {
			System.out.println();
		}
	}

	public void clickDeny(String senderName) {
		click(By.xpath(String.format(" ", senderName)), "Deny button");
	}

	public void clickRemainder(String senderName) {
		click(By.xpath(String.format(" ", senderName)), "Remainder  button");
	}

	public void clickCancel(String senderName) {
		click(By.xpath(String.format(" ", senderName)), "Cancel  button");
	}

}
