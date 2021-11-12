package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NotificationComponent;
import coyni_mobile.components.TokenHomeComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TokenAccountPage extends MobileFunctions {

	private By lblUserName = MobileBy.xpath(" ");
	private By lblAvailableBalance = MobileBy.xpath(" ");
	private By iconNotifications = MobileBy.xpath(" ");
	private By btnPayRequest = MobileBy.xpath(" ");
	private By btnScan = MobileBy.xpath(" ");
	private By btnDashBoard = MobileBy.xpath(" ");
	private By btnCrypto = MobileBy.xpath(" ");
	private By btnProfile = MobileBy.xpath(" ");
	private By btnHome = MobileBy.xpath(" ");
	private By btnIssueCard = MobileBy.xpath(" ");

	public void verifyUserName(String userName) {
		// new CommonFunctions().verifyLabelText(lblUserName, "userName", userName);
	}

	public String getAvailableBalance() {
		return getText(lblAvailableBalance);// doubt
	}

	public void clickNotificationsIcon() {
		click(iconNotifications, "Notifications");
	}

	public void btnPayRequest() {
		click(btnPayRequest, "PayRequest");
	}

	public void btnScan() {
		click(btnScan, "Scan");
	}

	public void btnDashBoard() {
		click(btnDashBoard, "DashBoard");
	}

	public void btnCrypto() {
		click(btnCrypto, "Crypto");
	}

	public void btnProfile() {
		click(btnProfile, "Profile");
	}

	public void btnHome() {
		click(btnHome, "Home");
	}

	public void btnIssueCard() {
		click(btnIssueCard, "IssueCard");
	}

	// added
	public void clickProfile() {
		click(btnProfile, "Button Profile ");
	}

	public TokenHomeComponent tokenHomeComponent() {
		return new TokenHomeComponent();
	}

	public ScanPage scanPage() {
		return new ScanPage();
	}

	public PayRequestPage payRequestPage() {
		return new PayRequestPage();
	}

	public WithDrawToUSDPage withDrawToUSDPage() {
		return new WithDrawToUSDPage();
	}

	public NotificationComponent notificationComponent() {
		return new NotificationComponent();
	}
}
