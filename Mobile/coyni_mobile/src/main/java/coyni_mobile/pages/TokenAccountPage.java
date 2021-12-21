package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.AccountLimitsComponent;
import coyni_mobile.components.AgreementComponent;
import coyni_mobile.components.BuyTokenMenuComponent;
import coyni_mobile.components.NotificationComponent;
import coyni_mobile.components.TokenHomeComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class TokenAccountPage extends MobileFunctions {

	private By lblUserName = MobileBy.xpath(
			"//*[contains(@resource-id, 'tvUserName')]|(//*[@name='notifications_nobadge'])/following-sibling::*[1]");
	private By lblAvailableBalance = MobileBy.xpath("//*[contains(@resource-id, 'tvBalHead')]");
	private By iconNotifications = MobileBy.xpath("//*[@name='notifications_nobadge']");
	private By btnPayRequest = MobileBy.xpath(" ");
	private By btnScan = MobileBy.xpath(" ");
	private By btnDashBoard = MobileBy.xpath("//*[@text='Dashboard']");
	private By btnCrypto = MobileBy.xpath(" ");
	private By btnProfile = MobileBy.xpath("//*[@text='Profile']");
	private By btnHome = MobileBy.xpath("//*[@name='qucik_bottommenu']");
	private By btnIssueCard = MobileBy.xpath(" ");
	private By btnViewMore = MobileBy.xpath("//*[contains(@resource-id,'viewMoreLL')]");

	public void ViewMore() {
		scrollDownToElement(btnViewMore, "View More");

	}

	public void clickViewMore() {
		click(btnViewMore, "View More");
	}

	public void verifyLogin() {
		if (getElement(lblUserName, "UserName").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Login success");
		} else {
			ExtentTestManager.setFailMessageInReport("Login failed");
		}
	}

	public void verifyRegistration() {
		if (getElement(iconNotifications, "icon").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Registration success");
		} else {
			ExtentTestManager.setFailMessageInReport("Registration failed");
		}
	}

	public String getAvailableBalance() {
		return getText(lblAvailableBalance);// doubt
	}

	public void verifyAvailableBalanceView() {
		new CommonFunctions().elementView(lblAvailableBalance, "AvailableBalance");
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

	public BuyTokenMenuComponent buyTokenMenuComponent() {
		return new BuyTokenMenuComponent();
	}

	public AccountLimitsComponent accountLimitsComponent() {
		return new AccountLimitsComponent();
	}

	public AgreementComponent agreementComponent() {
		return new AgreementComponent();
	}

	public TransactionPage transactionPage() {
		return new TransactionPage();
	}
}
