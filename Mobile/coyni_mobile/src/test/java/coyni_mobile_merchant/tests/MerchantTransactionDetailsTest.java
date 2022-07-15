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
import coyni_mobile_merchant.pages.MerchantProfilePage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class MerchantTransactionDetailsTest {

	MerchantProfilePage merchantProfilePage;
	BusinessTokenAccountPage businessTokenAccountPage;
	BatchPayOutComponent batchPayOutComponent;
	EnterYourPINComponent enterYourPINComponent;
	NavigationComponent navigationComponent;

	@BeforeTest
	public void init() {
		merchantProfilePage = new MerchantProfilePage();
		businessTokenAccountPage = new BusinessTokenAccountPage();
		navigationComponent = new NavigationComponent();
		batchPayOutComponent = new BatchPayOutComponent();
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
	public void testMerchantBalance(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(3000);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.dashBoardPage().getAccountVerified();
			businessTokenAccountPage.dashBoardPage().clickNotification();
			businessTokenAccountPage.dashBoardPage().navigationComponent().clickBack();
			businessTokenAccountPage.dashBoardPage().clickIcon();
			businessTokenAccountPage.dashBoardPage().getName();
			businessTokenAccountPage.dashBoardPage().getUserName();
			businessTokenAccountPage.dashBoardPage().clickCompanyName();
			businessTokenAccountPage.dashBoardPage().navigationComponent().clickBack();
			businessTokenAccountPage.dashBoardPage().getMonthlyVolumeLimit();
			businessTokenAccountPage.dashBoardPage().getHighTicketLimit();
			businessTokenAccountPage.dashBoardPage().verifyLabelMerchantBalance(data.get("label"));
			businessTokenAccountPage.dashBoardPage().getMerchantBalance();

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
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.dashBoardPage().verifyLabelProcessingVolume(data.get("label"));
			businessTokenAccountPage.daysDropDownComponent().clickOnToday();
			businessTokenAccountPage.dashBoardPage().getRefund();
			businessTokenAccountPage.dashBoardPage().getProcessingFees();
			businessTokenAccountPage.dashBoardPage().getNetAmount();
			businessTokenAccountPage.dashBoardPage().getMISCFee();
			businessTokenAccountPage.dashBoardPage().getSaleOrder();
			businessTokenAccountPage.daysDropDownComponent().clickOnYesterday();
			businessTokenAccountPage.dashBoardPage().getRefund();
			businessTokenAccountPage.dashBoardPage().getProcessingFees();
			businessTokenAccountPage.dashBoardPage().getNetAmount();
			businessTokenAccountPage.dashBoardPage().getMISCFee();
			businessTokenAccountPage.dashBoardPage().getSaleOrder();
			businessTokenAccountPage.daysDropDownComponent().clickOnMonthToDate();
			businessTokenAccountPage.dashBoardPage().getRefund();
			businessTokenAccountPage.dashBoardPage().getProcessingFees();
			businessTokenAccountPage.dashBoardPage().getNetAmount();
			businessTokenAccountPage.dashBoardPage().getMISCFee();
			businessTokenAccountPage.daysDropDownComponent().clickOnLastMonth();
			businessTokenAccountPage.dashBoardPage().getRefund();
			businessTokenAccountPage.dashBoardPage().getProcessingFees();
			businessTokenAccountPage.dashBoardPage().getNetAmount();
			businessTokenAccountPage.dashBoardPage().getMISCFee();
			businessTokenAccountPage.dashBoardPage().getHighTicket();
			businessTokenAccountPage.dashBoardPage().getAverageTicket();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProcessingVolume Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFiltersForMerchantTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.dashBoardPage().getMerchantBalance();
			businessTokenAccountPage.dashBoardPage().getRefund();
			businessTokenAccountPage.dashBoardPage().getProcessingFees();
			businessTokenAccountPage.dashBoardPage().getMISCFee();
			businessTokenAccountPage.dashBoardPage().getNetAmount();
			businessTokenAccountPage.dashBoardPage().getSaleOrder();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage()
					.clickMerchantTransctions();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.verifyTransactionType(data.get("labeltransactionType"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.selectFilter(data.get("type"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
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
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage()
					.clickMerchantTransctions();
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
					.verifyTransactionType(data.get("labeltransactionType"));
			businessTokenAccountPage.dashBoardPage().merchantTransactionsPage().filterPopup()
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
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().navigationComponent().clickBack();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			// businessTokenAccountPage.batchPayOutComponent().payOutTransactions().
			// businessTokenAccountPage.batchPayOutComponent().filterPopup().clickPayOutDateRange();
			// businessTokenAccountPage.batchPayOutComponent().filterPopup().clickApplyfilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayOuts Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBatchPayOutApplyFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().navigationComponent().clickBack();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().filterPopup().clickDateRange();
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
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().navigationComponent().clickBack();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payoutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
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
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
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
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
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
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
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
			businessTokenAccountPage.dashBoardPage().clickDashBoard();
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

}