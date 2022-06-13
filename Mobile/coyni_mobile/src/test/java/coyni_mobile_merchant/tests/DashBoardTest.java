package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.BatchPayOutComponent;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import coyni_mobile_merchant.pages.LandingPage;
import coyni_mobile_merchant.pages.LoginPage;
import coyni_mobile_merchant.pages.MerchantProfilePage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class DashBoardTest {

	MerchantProfilePage merchantProfilePage;
	BusinessTokenAccountPage businessTokenAccountPage;
	BatchPayOutComponent batchPayOutComponent;
	EnterYourPINComponent enterYourPINComponent;
	NavigationComponent navigationComponent;
	LoginPage loginPage;
	LandingPage landingPage;

	@BeforeTest
	public void init() {
		merchantProfilePage = new MerchantProfilePage();
		businessTokenAccountPage = new BusinessTokenAccountPage();
		navigationComponent = new NavigationComponent();
		batchPayOutComponent = new BatchPayOutComponent();
		loginPage = new LoginPage();
		landingPage = new LandingPage();

		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
	}

	@AfterTest
	public void hideKeyBoard() {
		if (!new CommonFunctions().isPlatformiOS()) {
			DriverFactory.getDriver().hideKeyboard();
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBottomMenuBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickAccount();
			businessTokenAccountPage.businessTransactionsPage().verifyPageHeading(data.get("tokenAccountHeading"));
			businessTokenAccountPage.businessTransactionsPage()
					.verifyPageDescription(data.get("tokenAccountDescription"));
			businessTokenAccountPage.clickProfile();
			businessTokenAccountPage.merchantProfilePage().getAccountDetails();
			businessTokenAccountPage.merchantProfilePage().getAccountId();
			businessTokenAccountPage.merchantProfilePage().clickBack();
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickTransactions();
			businessTokenAccountPage.merchantTransactionsPage().verifyHeading(data.get("merchantHeading"));
			businessTokenAccountPage.merchantTransactionsPage().clickClose();
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.clickDashBoard();
			businessTokenAccountPage.getUserName();
			businessTokenAccountPage.dashBoardPage().getDashBoardHeading();
			businessTokenAccountPage.clickMenuIcon();
			businessTokenAccountPage.tokenMenuIconPopUp().viewScan();
			businessTokenAccountPage.tokenMenuIconPopUp().viewReceivePayment();
			businessTokenAccountPage.tokenMenuIconPopUp().viewBuyTokens();
			businessTokenAccountPage.tokenMenuIconPopUp().viewWithdrawTokens();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testScanCode  failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantBalance(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(3000);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.merchantTransactionDetailsPage().getAccountVerified();
			businessTokenAccountPage.merchantTransactionDetailsPage().clickNotification();
			businessTokenAccountPage.merchantTransactionDetailsPage().navigationComponent().clickBack();
			businessTokenAccountPage.merchantTransactionDetailsPage().clickIcon();
			businessTokenAccountPage.merchantTransactionDetailsPage().getName();
			businessTokenAccountPage.merchantTransactionDetailsPage().getUserName();
			businessTokenAccountPage.merchantTransactionDetailsPage().clickCompanyName();
			businessTokenAccountPage.merchantTransactionDetailsPage().navigationComponent().clickBack();
			businessTokenAccountPage.merchantTransactionDetailsPage().getMonthlyVolumeLimit();
			businessTokenAccountPage.merchantTransactionDetailsPage().getHighTicketLimit();
			businessTokenAccountPage.merchantTransactionDetailsPage().verifyLabelMerchantBalance(data.get("label"));
			businessTokenAccountPage.merchantTransactionDetailsPage().getMerchantBalance();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantBalance Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProcessingVolume(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(3000);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.merchantTransactionDetailsPage().verifyLabelProcessingVolume(data.get("label"));
			businessTokenAccountPage.daysDropDownComponent().clickOnToday();
			businessTokenAccountPage.merchantTransactionDetailsPage().getRefund();
			businessTokenAccountPage.merchantTransactionDetailsPage().getProcessingFees();
			businessTokenAccountPage.merchantTransactionDetailsPage().getNetAmount();
			businessTokenAccountPage.merchantTransactionDetailsPage().getMISCFee();
			businessTokenAccountPage.merchantTransactionDetailsPage().getSaleOrder();
			businessTokenAccountPage.daysDropDownComponent().clickOnYesterday();
			businessTokenAccountPage.merchantTransactionDetailsPage().getRefund();
			businessTokenAccountPage.merchantTransactionDetailsPage().getProcessingFees();
			businessTokenAccountPage.merchantTransactionDetailsPage().getNetAmount();
			businessTokenAccountPage.merchantTransactionDetailsPage().getMISCFee();
			businessTokenAccountPage.merchantTransactionDetailsPage().getSaleOrder();
			businessTokenAccountPage.daysDropDownComponent().clickOnMonthToDate();
			businessTokenAccountPage.merchantTransactionDetailsPage().getRefund();
			businessTokenAccountPage.merchantTransactionDetailsPage().getProcessingFees();
			businessTokenAccountPage.merchantTransactionDetailsPage().getNetAmount();
			businessTokenAccountPage.merchantTransactionDetailsPage().getMISCFee();
			businessTokenAccountPage.daysDropDownComponent().clickOnLastMonth();
			businessTokenAccountPage.merchantTransactionDetailsPage().getRefund();
			businessTokenAccountPage.merchantTransactionDetailsPage().getProcessingFees();
			businessTokenAccountPage.merchantTransactionDetailsPage().getNetAmount();
			businessTokenAccountPage.merchantTransactionDetailsPage().getMISCFee();
			businessTokenAccountPage.merchantTransactionDetailsPage().getHighTicket();
			businessTokenAccountPage.merchantTransactionDetailsPage().getAverageTicket();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProcessingVolume Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFiltersForMerchantTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.merchantTransactionDetailsPage().getRefund();
			businessTokenAccountPage.merchantTransactionDetailsPage().getProcessingFees();
			businessTokenAccountPage.merchantTransactionDetailsPage().getMISCFee();
			businessTokenAccountPage.merchantTransactionDetailsPage().getNetAmount();
			businessTokenAccountPage.merchantTransactionDetailsPage().getSaleOrder();
			businessTokenAccountPage.merchantTransactionDetailsPage().clickMerchantTransactions();
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage()
					.verifyLabelMerchanTransactions(data.get("label"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().clickFilterIcon();
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.selectMerchantTransactionsFilter(data.get("filterTransactiontype"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.selectMerchantTransactionsFilter(data.get("filterTransactionStatus"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.fillFromMerchantAmount(data.get("fromAmount"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.fillToMerchantAmount(data.get("toAmount"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.clickApplyfilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testFiltersForMerchantTransactions Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResetFiltersForMerchantTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.merchantTransactionDetailsPage().clickMerchantTransactions();
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage()
					.verifyLabelMerchanTransactions(data.get("label"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.verifyTransactionType(data.get("label"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.clickFilterIcon();
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.selectMerchantTransactionsFilter(data.get("filterTransactiontype"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.selectMerchantTransactionsFilter(data.get("filterTransactionStatus"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.fillFromAmount(data.get("fromAmount"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.fillToAmount(data.get("toAmount"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testResetFiltersForMerchantTransactions Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBatchPayOuts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			// businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payOutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayOuts Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBatchPayOutApplyFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			// businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().navigationComponent().clickBack();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payOutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().filterPopup().clickFilterIcon();
			businessTokenAccountPage.batchPayOutComponent().filterPopup().selectFilter(data.get("filterType"));
			businessTokenAccountPage.batchPayOutComponent().filterPopup().clickApplyfilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayOutResetFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBatchPayOutResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			// businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().navigationComponent().clickBack();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payOutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().filterPopup().clickFilterIcon();
			businessTokenAccountPage.batchPayOutComponent().filterPopup().selectFilter(data.get("filterType"));
			businessTokenAccountPage.batchPayOutComponent().filterPopup().clickResetAllFilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayOutResetFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveBalance(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.reserveBalanceComponent().getReserveRule();
			businessTokenAccountPage.reserveBalanceComponent().getNextRelease();
			businessTokenAccountPage.reserveBalanceComponent().getLastRelease();
			businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickDrpDwn();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickManual();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickDrpDwn();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickRolling();
			// businessTokenAccountPage.reserveBalanceComponent().navigationComponent().clickClose();
			// businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			// businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickDrpDwn();
			// businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickManual();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveBalance Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveBalanceFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.clickFilterIcon();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.selectFilter(data.get("filterType"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.clickApplyfilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveBalanceFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveBalanceResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.clickFilterIcon();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.selectFilter(data.get("filterType"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().filterPopup()
					.clickResetAllFilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveBalanceResetFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testReserveReleaseDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.reserveBalanceComponent().verifyLabelReserveBalance(data.get("label"));
			businessTokenAccountPage.reserveBalanceComponent().clickFullReserveReleaseHistory();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.verifyLabelReserveReleases(data.get("labelReserveReleaseTransactions"));
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage().clickReserve();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().getReserveID();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().getReserveAmount();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().getStatus();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().getDailyBatchIDs();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().getBatchDate();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().getReserveRule();
			businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
					.reserveReleaseDetailsPage().getReserve();
			// businessTokenAccountPage.reserveBalanceComponent().reserveReleaseTransactionsPage()
			// .reserveReleaseDetailsPage().getRecentTransactionsList();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testReserveReleaseDetails Failed due to this Exception" + e);
		}
	}

	@Test
	public void testNotifications() {
		try {
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().viewNotification();
			businessTokenAccountPage.notificationComponent().countNotifications();
			businessTokenAccountPage.notificationComponent().viewDots();
			businessTokenAccountPage.notificationComponent().navigationComponent().clickBack();
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().viewRequest();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().navigationComponent().clickBack();
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().swipeNotificationLeft();
			// tokenAccountPage.notificationComponent().verifyRead();
			businessTokenAccountPage.notificationComponent().clickRead();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotifications faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testLoginwithNewAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickLogin();
			loginPage.fillEmail(data.get("email1"));
			loginPage.fillPassword(data.get("password1"));
			loginPage.clickLogin();
			loginPage.enterYourPINComponent().verifyEnterYourPinView();
			loginPage.enterYourPINComponent().fillPin(data.get("pin1"));
			Thread.sleep(2000);
			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLoginwithNewAccount failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().viewPay();
			businessTokenAccountPage.notificationComponent().clickPay();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup()
					.verifyHeading(data.get("heading"));
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyAmount();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyPreview();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyLockSwipe();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifySlideText();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().swipeConfirm();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.clickForgotPin();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().forgotPinComponent()
					.navigationComponent().clickBack();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationPay faield due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().viewDeny();
			businessTokenAccountPage.notificationComponent().viewPay();
			businessTokenAccountPage.notificationComponent().clickDeny();
			businessTokenAccountPage.notificationComponent().verifyDenyMessage(data.get("denyMessage"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationDeny faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestReminder(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().clickRemainder();
			businessTokenAccountPage.notificationComponent().verifyReminderMessage(data.get("reminderMessage"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestReminder faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestCancel(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().clickCancel();
			businessTokenAccountPage.notificationComponent().verifyCancelMessage(data.get("cancelMessage"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestCancel faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestPay(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().clickPay();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup()
					.verifyHeading(data.get("heading"));
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyAmount();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyPreview();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifyLockSwipe();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().verifySlideText();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().swipeConfirm();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.clickForgotPin();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().forgotPinComponent()
					.navigationComponent().clickBack();
			businessTokenAccountPage.notificationComponent().payRequestConfirmPopup().enterYourPINComponent()
					.fillPin(data.get("pin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestPay faield due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testRequestDeny(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.clickNotifications();
			businessTokenAccountPage.notificationComponent().clickRequest();
			businessTokenAccountPage.notificationComponent().clickDeny();
			businessTokenAccountPage.notificationComponent().verifyDenyMessage(data.get("denyMessage"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testRequestDeny faield due to exception " + e);
		}

	}

	@Test
	public void testNotificationsDelete() {
		try {
			businessTokenAccountPage.clickNotifications();
			Thread.sleep(2000);
			businessTokenAccountPage.notificationComponent().viewDots();
			businessTokenAccountPage.notificationComponent().swipeNotificationRight();
			businessTokenAccountPage.notificationComponent().clickDelete();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotificationsDelete is failed due to Exception " + e);
		}

	}

}
