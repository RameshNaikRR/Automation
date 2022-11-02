package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.BatchPayOutComponent;
import coyni_mobile_merchant.components.DaysDropDownComponent;
import coyni_mobile_merchant.components.NotificationComponent;
import coyni_mobile_merchant.components.ReserveBalanceComponent;
import coyni_mobile_merchant.popups.TokenMenuIconPopUp;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BusinessTokenAccountPage extends MobileFunctions {

	private By btnDashBoard = MobileBy.xpath("//*[contains(@resource-id,'dashboard_tab')]");
	private By btnProfile = MobileBy.xpath("//*[contains(@resource-id,'profile_icon')]");
	private By btnMenuIcon = MobileBy.xpath("//*[contains(@resource-id,'iv_menu_tab')]");
	private By btnAccount = MobileBy.xpath("//*[contains(@resource-id,'account_tab')]");
	private By btnTransactions = MobileBy.xpath("//*[contains(@resource-id,'transactions_tab')]");
	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'businessTrackerCloseIV')]");
	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'tv_user_name')]");
	private By btnNotifications = MobileBy.xpath("");
	private By btnChooseUser = MobileBy.xpath("//*[contains(@resource-id,'iv_user_icon')]");
	private By btnAddDBA = MobileBy.xpath("//*[contains(@resource-id,'addDbaText')]");
	private By btnOpenNewAccount = MobileBy.xpath("//*[@text='Add New Account']");
	private By lnKBusinessAccount = MobileBy.xpath("//*[contains(@resource-id,'id/businessAccontLL')]|//*[contains(@text,'Merchant')]");
	private By lnKPersonalAccount = MobileBy.xpath("//*[@text='Personal']");
	private By btnNewDBA = MobileBy.xpath("//*[contains(@resource-id,'ll_new_dba')]");
	private By btnNewCompany = MobileBy.xpath("//*[contains(@resource-id,'ll_new_company')]");
	private By lnkSelectAccount = MobileBy.xpath("//*[contains(@resource-id,'title')]");
	private By btnAddNewDBA = MobileBy.xpath("//*[contains(@text,'Add DBA')]");

	private By btnSelectAccount = MobileBy.xpath("(//*[contains(@resource-id,'arrow')])[1]");
	private By btnSelectAccount2 = MobileBy.xpath("(//*[contains(@resource-id,'arrow')])[2]");
	private By btnChildAccount1 = MobileBy.xpath("(//*[contains(@resource-id,'ll_child_view')])[1]");
	private By btnEnabledAcc = MobileBy.xpath("(//*[contains(@resource-id,'title')])[+ i +]");

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

	public void clickChooseUser() {
		click(btnChooseUser, "Choose User");
	}

	public void clickAddDBA() {
		click(btnAddDBA, "Add DBA");
	}

	public void clickBusinessAccount() {
		click(lnKBusinessAccount, "Business Account");
	}

	public void clickPersonalAccount() {
		click(lnKPersonalAccount, "Personal Account");
	}
	
	public void clickOpenNewAccount() throws InterruptedException {
		Thread.sleep(1500);
		while (getElementList(btnOpenNewAccount, "Open New Account").size() == 0) {
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(540, (int) (300))).release().perform();
		}
		click(btnOpenNewAccount, "Open New Account");
	}

	public void clickSelectAccount() {
		click(btnSelectAccount, "Select Account");
	}

	public void clickChildAccount1() {
		click(btnChildAccount1, "Child Account 1");
	}

	public void clickPrimaryAccount2() {
		click(btnSelectAccount2, "Primary Account 2");
	}

	public void clickProfile() {
//		WebDriver driver = DriverFactory.getDriver();		
//        WebDriverWait wait = new WebDriverWait(driver, 120);
////        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'profile_icon')]")));
		new CommonFunctions().elementView(btnProfile, "Profile");
		click(btnProfile, "Profile");
	}

	public int verifyProfile() {
		return DriverFactory.getDriver().findElements(btnProfile).size();
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

	public int verifyNumOfAccounts() throws InterruptedException {
		Thread.sleep(2000);
		return DriverFactory.getDriver().findElements(lnkSelectAccount).size();
	}

	private By getAccounts(String num) {
		return By.xpath(String.format("(//*[contains(@resource-id,'title')])[+ i +]",num));
	}
//
//	private By getDashBoardItems(String eleName) {
//		return By.xpath(String.format("//div[@class='DashboardMenu_menu__3PSTN']//span[text()='%s']", eleName));
//	}

	public void clickEnabledAccount() throws InterruptedException {
		
		for (int i = 1; verifyNumOfAccounts() >= i; i++) {
			ExtentTestManager.setInfoMessageInReport("Hiiii"+i);
			Thread.sleep(2000);
			if (DriverFactory.getDriver().findElement(btnEnabledAcc).isEnabled()) {
				ExtentTestManager.setInfoMessageInReport("Hello "+i);
//				String str1 = Integer.toString(i);
//		scrollDownToElement(DriverFactory.getDriver().findElement(By.xpath("(//*[contains(@resource-id,'title')])[%s]")),"");
						
//				scrollDownToElement(getAccounts("+ i +"), "Slected an Account");
				click(btnEnabledAcc, "Slected an Account");
				scrollDownToElement(btnAddNewDBA, "Add New DBA");
				click(btnAddNewDBA, "Add New DBA");
				break;
			}else {
				ExtentTestManager.setInfoMessageInReport(i +" User in disabled mode");	
			}

		}
		ExtentTestManager.setInfoMessageInReport("Tarak Tarak");
	}

//	if (DriverFactory.getDriver().findElement(getAccounts("i")).isEnabled()) {
//		ExtentTestManager.setInfoMessageInReport("Hello "+i);
//		String str1 = Integer.toString(i);
//		scrollDownToElement(getAccounts(str1), "Slected an Account");
//		click(getAccounts(str1), "Slected an Account");
//		scrollDownToElement(btnAddNewDBA, "Add New DBA");
//		click(btnAddNewDBA, "Add New DBA");
//		break;
//	}else {
//		ExtentTestManager.setInfoMessageInReport(i +" User in disabled mode");	
//	}

	
//	for (int i = 1; verifyNumOfAccounts() >= i; i++) {
//	ExtentTestManager.setInfoMessageInReport("Hiiii");
//	Thread.sleep(2000);
//	if (DriverFactory.getDriver().findElement(getAccounts("i")).isEnabled()) {
//		ExtentTestManager.setInfoMessageInReport("Hello "+i);
////		click(lnkSelectAccount,"Choose Account");
//		click(getAccounts("i"), "Slected an Account");
//		click(btnAddNewDBA, "Add New DBA");
//		break;
//	}else {
//		ExtentTestManager.setInfoMessageInReport("User in disabled mode");	
//	}
	
	public void clickNewCompany() {
		click(btnNewCompany, "New Company");
	}

	public void clickNewDBA() {
		click(btnNewDBA, "New DBA");
	}
	
	
	public void chooseDBA() throws InterruptedException {
		for (int i = 1; verifyNumOfAccounts() >= i; i++) {
			clickSelectAccount();

		if(DriverFactory.getDriver().findElement(btnEnabledAcc).isEnabled()) {
		clickAddDBA();	
		}else {
			clickSelectAccount();
		}
		}
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
