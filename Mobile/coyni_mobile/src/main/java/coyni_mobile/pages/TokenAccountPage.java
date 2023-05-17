package coyni_mobile.pages;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.components.AddNewPaymentComponent;
import coyni_mobile.components.BuyTokenComponent;
import coyni_mobile.components.MailingAddressComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.NotificationComponent;
import coyni_mobile.components.SuccessFailureComponent;
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
	private By lblLatestTransaction = MobileBy.xpath("(//*[contains(@resource-id,'latestmessageTV')])[1]");
	private By lblUserName = MobileBy.xpath(
			"//*[contains(@resource-id, 'tvUserName')]|(//*[@name='notifications_nobadge'])/following-sibling::*[1]");
	private By lblAvailableBalance = MobileBy.xpath("//*[contains(@resource-id, 'tvBalHead')]");
	private By lblAvailableBal= MobileBy.xpath("//*[contains(@resource-id, 'tvBalance')]");
	private By iconNotifications = MobileBy.xpath("//*[contains(@resource-id,'notificationsLL')]");// *[@name='notifications_nobadge']
	private By btnPayRequest = MobileBy.xpath(" ");
	private By btnScan = MobileBy.xpath("//*[contains(@resource-id,'scanQrLL')]");
	private By btnDashBoard = MobileBy.xpath("//*[@text='Dashboard']");
	private By btnCrypto = MobileBy.xpath(" ");
	private By btnProfile = MobileBy.xpath("//*[@text='Profile']");
	private By btnHome = MobileBy.xpath("//*[contains(@resource-id,'layoutMainMenu')]");
	private By btnIssueCard = MobileBy.xpath(" ");
	private By btnViewMore = MobileBy.xpath("//*[contains(@resource-id,'viewMoreLL')]");
	private By btnImgProfile = MobileBy.xpath("//*[contains(@resource-id, 'tvUserInfo')]|//*[contains(@resource-id, 'imgProfile')]");
	private By btnprofile_img = MobileBy.xpath("//*[contains(@resource-id, 'profile_img')]");
	private By btnprofile_tick = MobileBy.xpath("//*[contains(@resource-id, 'tickIcon')]");
	private By lblAccountStatus = MobileBy.xpath("//*[contains(@text,'Under Review')]");
	////////////// 2.3 ///////////////
	private By btnAddPayment = MobileBy.xpath("//*[@text='Add payment method']");
	private By btnAddAddress = MobileBy.xpath("//*[@text='Add an address']");
	private By btnBuyToken = MobileBy.xpath("//*[@text='Buy Token']");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	
	private float getAmountFromtext(By ele) {
		String text = getText(ele);
		System.out.println(text);
		String texts = text.replace(",", "");
		System.out.println(texts);
		Pattern pattern = Pattern.compile("\\d+.\\d+");
		Matcher match = pattern.matcher(texts);
		while (match.find()) {
			float amount = Float.parseFloat(match.group());
			return amount;
		}
		return 0.0f;
	}

	public float getAvailableBalance() {
//    if(getElementList(lblAvailableBalance, "").size()> 0){
		return this.getAmountFromtext(lblAvailableBal);
	}
	public void verifyTransactionHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(transactionsHeading, "Transaction heading", expHeading);
	}

	public void clickViewMore() {

		while (getElementList(btnViewMore, "View More").size() == 0) {
			Dimension size = DriverFactory.getDriver().manage().window().getSize();
			int x = size.getWidth();
			int y = size.getHeight();
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(x / 2, y / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(x / 2, (int) (y * 0.2))).release().perform();
		}
		click(btnViewMore, "View More");
	}

	public void clickImgProfile() {
		click(btnImgProfile, "Img Profile");
	}

	public void verifyImgProfile() {
		new CommonFunctions().elementView(btnprofile_img, "Profile Img");
//		new CommonFunctions().elementView(btnprofile_img, "btnprofile_tick");

	}

	public void verifyLogin() {
		if (getElement(lblUserName, "UserName").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Login success");
		} else {
			ExtentTestManager.setFailMessageInReport("Login failed");
		}
	}

	public void verifyAcccountStatus() {
		if (getText(lblAccountStatus).equalsIgnoreCase("Active")) {
			ExtentTestManager.setPassMessageInReport(getText(lblAccountStatus));
		} else {
			ExtentTestManager.setFailMessageInReport(
					" Account is in Under Review or Not Active Status. So we can't perform Token actions");
		}
	}

	public void verifyRegistration() {
		if (getElement(iconNotifications, "icon").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport("Registration success");
		} else {
			ExtentTestManager.setFailMessageInReport("Registration failed");
		}
	}

	public String getAvailableBal() {
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
		wait.until(ExpectedConditions.elementToBeClickable(btnHome));
		click(btnHome, "Home");
	}

	public void btnIssueCard() {
		click(btnIssueCard, "IssueCard");
	}

	// added
	public void clickProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(btnProfile));
		click(btnProfile, "Profile");
	}

	public void clickProfileforPayments() {
		if (getElementList(btnProfile, "Profile").size() > 0) {
			click(btnProfile, "Profile");
		}
	}

	public void verifyAddPaymentView() {
		new CommonFunctions().elementView(btnAddPayment, "Add payment method");
	}

	public void verifyAddAddressView() {
		new CommonFunctions().elementView(btnAddAddress, "Add Address");
	}

	public void verifyBuyTokenView() {
		new CommonFunctions().elementView(btnBuyToken, "Buy Token");
	}

	public void clickAddPayment() {
		click(btnAddPayment, "Add payment method");
	}

	public void clickAddAddress() {
		click(btnAddAddress, "Add Address");
	}

	public void clickBuyToken() {
		click(btnBuyToken, "Buy Token");
	}
	public void clickLatestTransaction() {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblLatestTransaction));
		click(lblLatestTransaction, "Recent Transaction");
	}
	
	public void verifyDashBoard() {
		ExtentTestManager.setInfoMessageInReport("Dashboard :  " + getText(lblLatestTransaction));
	}

	public int verifyProfile() throws InterruptedException {
		Thread.sleep(2000);
		int a = getElementList(btnProfile, "Profile").size();
		return a;
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

	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
	}

	public WithdrawMenuComponent withdrawMenuComponent() {
		return new WithdrawMenuComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
    public SuccessFailureComponent successFailureComponent() {
    	return new SuccessFailureComponent();
    }
    public PaymentMethodsPage paymentMethodsPage() {
    	return new PaymentMethodsPage();
    }
    public MailingAddressComponent mailingAddressComponent() {
    	return new MailingAddressComponent();
    }
    public CustomerProfilePage customerProfilePage() {
    	return new CustomerProfilePage();
    }
    public AddNewPaymentComponent addNewPaymentComponent() {
    	return new AddNewPaymentComponent();
    }
    
}
