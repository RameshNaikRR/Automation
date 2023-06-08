package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import coyni_mobile.components.AddNewPaymentComponent;

public class DashboardPage extends MobileFunctions {
	private By iconProfile = MobileBy.AccessibilityId("");
	private By btnBuyTokens = MobileBy.AccessibilityId("");
	private By btnWithdraw = MobileBy.AccessibilityId("");
	private By iconNotifications = MobileBy.AccessibilityId("");
	private By btnPayReq = MobileBy.AccessibilityId("");
	private By iconScan = MobileBy.AccessibilityId("");
	private By iconQRCode = MobileBy.AccessibilityId("");
	private By lblRecentTransactions = MobileBy.AccessibilityId("");
	private By lblFirstTransaction = MobileBy.AccessibilityId("");
	private By lblNotificationCount = MobileBy.xpath("//*[@name='notifications_nobadge']/following-sibling::*[1]");
	private By btnViewMore = MobileBy.xpath("(//*[@name='View More'])[1]");
	private By btnAddAddress = MobileBy.AccessibilityId("");
	private By btnAddPayment = MobileBy.AccessibilityId("");
	private By lblAddAddress = MobileBy.AccessibilityId("");
	private By lblUserName = MobileBy.AccessibilityId("");

	public void viewUserName() {
		new AndroidCommonFunctions().elementView(lblUserName, "User Name");
	}

	public void clickProfile() {
		click(iconProfile, "Profile ");
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "Buy Tokens");
	}

	public void clickWithdraw() {
		click(btnWithdraw, "Withdraw");
	}

	public void clickNotifications() {
		click(iconNotifications, "Notifications");
	}

	public void clickPayRequest() {
		click(btnPayReq, "Pay Request");
	}

	public void clickScan() {
		click(iconScan, "Scan");
	}

	public void clickQRCode() {
		click(iconQRCode, "QrCode");
	}

	public void verifyRecentTransactionsView() {
		ExtentTestManager.setInfoMessageInReport("Dashboard :" + getText(lblRecentTransactions));
		new AndroidCommonFunctions().elementView(lblRecentTransactions, "recent Transactions");
	}

	public void clickFirstTransaction() {
		click(lblFirstTransaction, "FirstTrnsaction");
	}

	public void clickViewMore() {
		scrollDownToElement(btnViewMore, "view more");
		click(btnViewMore, "View More");
	}

	public void clickAddAddress() {
		click(btnAddAddress, "Add Address");
	}

	public void clickAddPayment() {
		click(btnAddPayment, "Add Payment");
	}

	public void verifyAddAddressview() {
		new AndroidCommonFunctions().elementView(lblAddAddress, "Add Address");
	}

	public void verifyDashboard() {
		new AndroidCommonFunctions().elementView(btnPayReq, "Pay/Request");
	}

	public AddNewPaymentComponent addNewPaymentComponent() {
		return new AddNewPaymentComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public NotificationsPage notificationsPage() {
		return new NotificationsPage();
	}
}
