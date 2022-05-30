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
	public void testBatchPayOuts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().navigationComponent().clickBack();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payOutTransactionsPage()
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
	public void testBatchPayOutResetFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().verifyLabelBatchPayOuts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().getNextPayOut();
			businessTokenAccountPage.batchPayOutComponent().getLastPayOut();
			businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().navigationComponent().clickBack();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutHistory();
			businessTokenAccountPage.batchPayOutComponent().payOutTransactionsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().filterPopup().clickResetAllFilters();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBatchPayOutResetFilters Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFiltersForMerchantTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.merchantTransactionDetailsPage().getMerchantBalance();
			businessTokenAccountPage.merchantTransactionDetailsPage().getRefund();
			businessTokenAccountPage.merchantTransactionDetailsPage().getProcessingFees();
			businessTokenAccountPage.merchantTransactionDetailsPage().getMISCFee();
			businessTokenAccountPage.merchantTransactionDetailsPage().getNetAmount();
			businessTokenAccountPage.merchantTransactionDetailsPage().getSaleOrder();
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage()
					.clickMerchantTransctions();
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.verifyTransactionType(data.get("labeltransactionType"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.selectFilter(data.get("type"));
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
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage()
					.clickMerchantTransctions();
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.verifyTransactionType(data.get("labeltransactionType"));
			businessTokenAccountPage.merchantTransactionDetailsPage().merchantTransactionsPage().filterPopup()
					.clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testResetFiltersForMerchantTransactions Failed due to this Exception" + e);
		}
	}

}