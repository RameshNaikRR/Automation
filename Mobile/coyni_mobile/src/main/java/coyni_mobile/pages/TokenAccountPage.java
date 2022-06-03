package coyni_mobile.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import coyni_mobile.components.NotificationComponent;
import coyni_mobile.components.TokenHomePopUp;
import coyni_mobile.components.WithdrawMenuComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TokenAccountPage extends MobileFunctions {

	private By transactionsHeading = MobileBy.xpath("//*[@text='Recent Transactions']");
	private By lblUserName = MobileBy.xpath(
			"//*[contains(@resource-id, 'tvUserName')]|(//*[@name='notifications_nobadge'])/following-sibling::*[1]");
	private By lblAvailableBalance = MobileBy.xpath("//*[contains(@resource-id, 'tvBalHead')]");
	private By iconNotifications = MobileBy.xpath("//*[contains(@resource-id,'notificationsLL')]");// *[@name='notifications_nobadge']
	private By btnPayRequest = MobileBy.xpath(" ");
	private By btnScan = MobileBy.xpath(" ");
	private By btnDashBoard = MobileBy.xpath("//*[@text='Dashboard']");
	private By btnCrypto = MobileBy.xpath(" ");
	private By btnProfile = MobileBy.xpath("//*[@text='Profile']");
	private By btnHome = MobileBy.xpath("//*[@name='qucik_bottommenu']|//*[contains(@resource-id,'layoutMainMenu')]");
	private By btnIssueCard = MobileBy.xpath(" ");
	private By btnViewMore = MobileBy.xpath("//*[contains(@resource-id,'viewMoreLL')]");

	public void verifyTransactionHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(transactionsHeading, "Transaction heading", expHeading);
	}

	public void clickViewMore() {
		// scrollDownToElement(lblTransactionList, "Trasaction List");
//		for (int i=0; i<10; i++) {
//			new CommonFunctions().clickTab();
//			if (getElement(btnViewMore, "").isDisplayed()) {
//				click(btnViewMore, "View More");
//				break;
//			}
//		}
		// scrollDownToElement(btnViewMore, "View More");
		
		while (getElementList(btnViewMore, "View More").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(720, 2000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(720, 1350)).release().perform();
		}
//		Dimension size = DriverFactory.getDriver().manage().window().getSize();
//		ExtentTestManager.setInfoMessageInReport("Size" + size);
//		scrollDownToElement(btnViewMore, "View More");
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
		click(btnProfile, "Profile");
	}

	public TokenHomePopUp tokenHomePopUp() {
		return new TokenHomePopUp();
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

	public TransactionPage transactionPage() {
		return new TransactionPage();
	}

	public SignUpPage signUpPage() {
		return new SignUpPage();

	}

	public WithdrawMenuComponent withdrawMenuComponent() {
		return new WithdrawMenuComponent();
	}
}
