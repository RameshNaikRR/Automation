package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.TransactionsDetailsComponent;
import coyni_mobile.popups.cvvPopup;
import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import coyni_mobile.components.AddNewPaymentComponent;
import coyni_mobile.components.BuyTokenComponent;

public class DashboardPage extends MobileFunctions {
	private By iconProfile = MobileBy.AccessibilityId("");
	private By btnBuyTokens = MobileBy.AccessibilityId("Buy Tokens");
	private By btnWithdraw = MobileBy.AccessibilityId("withdraws");
	private By iconNotifications = MobileBy.AccessibilityId("");
	private By btnSendReq = MobileBy.AccessibilityId("Send/Request");
	private By iconScan = MobileBy.AccessibilityId("Scanner");
	private By iconQRCode = MobileBy.AccessibilityId("QR Code");
	private By lblRecentTransactions = MobileBy.AccessibilityId("");
	private By lblFirstTransaction = MobileBy.AccessibilityId("");
	private By lblNotificationCount = MobileBy.xpath("//*[@name='notifications_nobadge']/following-sibling::*[1]");
	private By btnViewAllTransactions = MobileBy.xpath("(//*[@name='View More'])[1]");
	private By btnAddAddress = MobileBy.AccessibilityId("");
	private By btnAddPayment = MobileBy.AccessibilityId("");
	private By lblAddAddress = MobileBy.AccessibilityId("");
	private By lblUserName = MobileBy.AccessibilityId("");
	private By lblAvailBal = MobileBy.AccessibilityId("");

	public double verifyAvailbleBalance() {
		double avlBalance = Double.parseDouble(getText(lblAvailBal));
		return avlBalance;
	}

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

	public void clickSendRequest() {
		click(btnSendReq, "Send Request");
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

	public void clickViewAllTransactions() {
		scrollDownToElement(btnViewAllTransactions, "btnViewAllTransactions");
		click(btnViewAllTransactions, "ViewAllTransactions");
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
		new AndroidCommonFunctions().elementView(btnSendReq, "Send/Request");
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

	public SendRequestPage sendRequestPage() {
		return new SendRequestPage();
	}
	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
	}
	public SelectWithdrawMethodPage selectWithdrawMethodPage() {
		return new SelectWithdrawMethodPage();
	}
	public TransactionsDetailsComponent transactionsDetailsComponent() {
		return new TransactionsDetailsComponent();
	}
	public TransactionsPage transactionPage() {
		return new TransactionsPage();
	}
	public cvvPopup cvvPopup() {
		return new cvvPopup();
	}
	
	
}
