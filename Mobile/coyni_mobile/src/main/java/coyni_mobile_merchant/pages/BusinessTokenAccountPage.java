package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.BatchPayOutComponent;
import coyni_mobile_merchant.components.DaysDropDownComponent;
import coyni_mobile_merchant.components.NotificationComponent;
import coyni_mobile_merchant.components.ReserveBalanceComponent;
import coyni_mobile_merchant.popups.TokenMenuIconPopUp;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BusinessTokenAccountPage extends MobileFunctions {

	private By btnDashBoard = MobileBy.xpath("//*[contains(@resource-id,'dashboard_tab')]");
	private By btnProfile = MobileBy.xpath("//*[contains(@resource-id,'tv_profile_text')]");
	private By btnMenuIcon = MobileBy.xpath("//*[contains(@resource-id,'iv_menu_tab')]");
	private By btnAccount = MobileBy.xpath("//*[contains(@resource-id,'account_tab')]");
	private By btnTransactions = MobileBy.xpath("//*[contains(@resource-id,'transactions_tab')]");
	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'businessTrackerCloseIV')]");
	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'tv_user_name')]");
	private By btnNotifications = MobileBy.xpath("");

	public void clickAccount() {
		new CommonFunctions().elementView(btnAccount, "Account");
		click(btnAccount, "Account");
	}

	public void clickNotifications() {
		new CommonFunctions().elementView(btnNotifications, "Notifications");
		click(btnNotifications, "Notifications");
	}

	public void clickMenuIcon() {
		new CommonFunctions().elementView(btnMenuIcon, "Menu Icon");
		click(btnMenuIcon, "Home");
	}

	public void clickTransactions() {
		new CommonFunctions().elementView(btnTransactions, "Transactions");
		click(btnTransactions, "Transactions");
	}

	public void clickProfile() {
		new CommonFunctions().elementView(btnProfile, "Profile");
		click(btnProfile, "Profile");
	}

	public void clickDashBoard() {
		new CommonFunctions().elementView(btnDashBoard, "Dash Board");
		click(btnDashBoard, "Dash Board");
	}

	public void getUserName() {
		ExtentTestManager.setInfoMessageInReport("User Name is : " + getText(lblUserName));
	}

	public void clickClose() {
		click(btnCloseIcon, "Close Icon");
	}

	public MerchantProfilePage merchantProfilePage() {
		return new MerchantProfilePage();
	}

	public BatchPayOutComponent batchPayOutComponent() {
		return new BatchPayOutComponent();
	}

	public DashBoardPage dashBoardPage() {
		return new DashBoardPage();
	}

	public DaysDropDownComponent daysDropDownComponent() {
		return new DaysDropDownComponent();
	}

	public ReserveBalanceComponent reserveBalanceComponent() {
		return new ReserveBalanceComponent();
	}

	public TokenMenuIconPopUp tokenMenuIconPopUp() {
		return new TokenMenuIconPopUp();
	}

	public BusinessRecentTokenTransactionsPage businessRecentTokenTransactionsPage() {
		return new BusinessRecentTokenTransactionsPage();
	}

	public MerchantTransactionsPage merchantTransactionsPage() {
		return new MerchantTransactionsPage();
	}

//	public DashBoardPage dashBoardPage() {
//		return new DashBoardPage();
//	}

	public NotificationComponent notificationComponent() {
		return new NotificationComponent();
	}
	public MerchantTransactionDetailsPage merchantTransactionDetailsPage() {
		return new MerchantTransactionDetailsPage();
	}
}
