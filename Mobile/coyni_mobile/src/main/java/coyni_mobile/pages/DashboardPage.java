package coyni_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.TransactionsDetailsComponent;
import coyni_mobile.popups.cvvPopup;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import coyni_mobile.components.AddNewPaymentComponent;
import coyni_mobile.components.BuyTokenComponent;

public class DashboardPage extends MobileFunctions {
	private By iconProfile = MobileBy.id("com.coyni.mapp:id/userProfileCV");
	private By btnBuyTokens = MobileBy.AccessibilityId("Buy Tokens");
	private By btnWithdraw = MobileBy.AccessibilityId("withdraws");
	private By iconNotifications = MobileBy.id("com.coyni.mapp:id/notificationIV");
	private By btnSendReq = MobileBy.AccessibilityId("Send/Request");
	private By iconScan = MobileBy.AccessibilityId("Scanner");
	private By iconQRCode = MobileBy.AccessibilityId("QR Code");
	private By lblRecentTransactions = MobileBy.xpath("");
	private By lblFirstTransaction = MobileBy.xpath(
			"//*[@text='Recent transactions']/parent::*/following-sibling::*[contains(@resource-id,'rvLatestTrans')]/descendant::*[contains(@resource-id,'latestmessage')][1]");
	private By lblNotificationCount = MobileBy.xpath("//*[@name='notifications_nobadge']/following-sibling::*[1]");
	private By btnViewAllTransactions = MobileBy.xpath("(//*[@name='View More'])[1]");
	private By btnAddAddress = MobileBy.xpath("//*[contains(@text,'Add an address')]");
	private By lblAddAddressHeading = MobileBy
			.xpath("//*[contains(@text,'Please enter your')]/preceding-sibling::android.widget.TextView");
	private By lblAddresDesc = MobileBy.xpath("//*[contains(@text,'We will need')]");
	private By lnkAddPayment = MobileBy.AccessibilityId("Add Payment Method");
	private By lblAddPaymntDesc = MobileBy.xpath("//*[contains(@text,'Get started by')]");
	private By lblAddPaymntHeading = MobileBy.xpath("//*[@text='Welcome to coyni!']");
	private By lblAddAddress = MobileBy.xpath("//*[@text='Address Required']");
	private By lblUserName = MobileBy.id("com.coyni.mapp:id/tvUserName");
	private By lblAvailBal = MobileBy.id("com.coyni.mapp:id/tvBalance");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 60);

	public double verifyAvailbleBalance() {
		double avlBalance = Double.parseDouble(getText(lblAvailBal));
		ExtentTestManager.setPassMessageInReport("Available Balance : " + getText(lblAvailBal));
		return avlBalance;
	}

	public void viewUserName() {
		new CommonFunctions().elementView(lblUserName, "User Name");
	}

	public void clickProfile() {
		wait.until(ExpectedConditions.presenceOfElementLocated(iconProfile));
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
		new CommonFunctions().elementView(lblRecentTransactions, "recent Transactions");
	}

	public void clickFirstTransaction() {
//		String[] pfName = name.split(",");
//		char fstNameFstCh = pfName[0].charAt(0);
//		char lstNameFstCh = pfName[1].charAt(0);
//		if(getText(lblFirstTransaction).equals("Received funds from "))
		click(lblFirstTransaction, "First Transaction");
	}

	public void clickViewAllTransactions() {
		scrollDownToElement(btnViewAllTransactions, "btnViewAllTransactions");
		click(btnViewAllTransactions, "ViewAllTransactions");
	}

	public void clickAddAddress() {
		click(btnAddAddress, "Add Address");
	}

	public void clickAddPayment() {
		click(lnkAddPayment, "Add Payment");
	}

	public void verifyAddPaymntView() {
		new CommonFunctions().elementView(lblAddPaymntHeading, "Add Payment Heading");
		ExtentTestManager.setPassMessageInReport(getText(lblAddPaymntHeading));
		new CommonFunctions().elementView(lblAddPaymntDesc, "Add Payment Description");
		ExtentTestManager.setFailMessageInReport(getText(lblAddPaymntDesc));
	}

	public void validateAddPaymntView() throws InterruptedException {
		Thread.sleep(800);
		if (getElementList(lblAddPaymntHeading, "").size() == 0 && getElementList(lblAddPaymntDesc, "").size() == 0
				&& getElementList(lnkAddPayment, "").size() == 0) {
			ExtentTestManager
					.setPassMessageInReport("Add Payment method link not visible,after adding the payment method");
		} else {
			ExtentTestManager
					.setFailMessageInReport("Add Payment method link is visible,after adding the payment method");
		}
	}

	public void verifyAddAddressHdg() {
		new CommonFunctions().elementView(lblAddAddressHeading, "Add Address");
		ExtentTestManager.setPassMessageInReport(getText(lblAddAddressHeading));
	}

	public void verifyAddAddressview() {
		new CommonFunctions().elementView(lblAddAddress, "Add Address");
		ExtentTestManager.setPassMessageInReport(getText(lblAddAddress));
		new CommonFunctions().elementView(lblAddresDesc, "Add Address Description");
		ExtentTestManager.setPassMessageInReport(getText(lblAddresDesc));
	}

	public void validateAddAddressview() throws InterruptedException {
		Thread.sleep(800);
		if (getElementList(lblAddAddress, "").size() == 0 && getElementList(lblAddresDesc, "").size() == 0
				&& getElementList(btnAddAddress, "").size() == 0) {
			ExtentTestManager.setPassMessageInReport(
					"After adding the address form profile,address link is not appeared in dash board page");
		} else {
			ExtentTestManager.setPassMessageInReport(
					"After adding the address form profile,address link is appearing in dash board page");
		}
	}

	public void verifyBuyTokensView() {
		new CommonFunctions().elementView(btnBuyTokens, "Buy Tokens");
	}

	public void verifyDashboard() {
		new CommonFunctions().elementView(btnSendReq, "Send/Request");
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

	public WithdrawTokenPage withdrawTokenPage() {
		return new WithdrawTokenPage();
	}

	public ScanPage scanPage() {
		return new ScanPage();
	}

	public MyQRCodePage myQRCodePage() {
		return new MyQRCodePage();
	}
}
