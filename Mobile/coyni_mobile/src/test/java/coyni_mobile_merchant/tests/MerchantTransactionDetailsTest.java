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
	public void testBatchPayOuts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessTokenAccountPage.merchantTransactionDetailsPage().clickDashBoard();
			businessTokenAccountPage.batchPayOutComponent().veirfyLabelBatchPayouts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().navigationComponent().clickBack();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutsHistory();
			businessTokenAccountPage.batchPayOutComponent().merchantTransactionDetailsPage()
					.verifyLabelPayOutTransactions(data.get("labelPayOutTransactions"));
			businessTokenAccountPage.batchPayOutComponent().filterPopup().clickPayOutDateRange();
			businessTokenAccountPage.batchPayOutComponent().filterPopup().clickApplyfilters();
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
			businessTokenAccountPage.batchPayOutComponent().veirfyLabelBatchPayouts(data.get("label"));
			businessTokenAccountPage.batchPayOutComponent().clickBatchNow();
			businessTokenAccountPage.batchPayOutComponent().navigationComponent().clickBack();
			businessTokenAccountPage.batchPayOutComponent().clickFullPayOutsHistory();
			businessTokenAccountPage.batchPayOutComponent().merchantTransactionDetailsPage()
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
			businessTokenAccountPage.merchantTransactionDetailsPage().clickMerchantTransctions();
			businessTokenAccountPage.merchantTransactionDetailsPage().filterPopup()
					.verifyTransactionType(data.get("labeltransactionType"));
			businessTokenAccountPage.merchantTransactionDetailsPage().filterPopup().selectFilter(data.get("type"));
			businessTokenAccountPage.merchantTransactionDetailsPage().filterPopup().clickApplyfilters();

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
			businessTokenAccountPage.merchantTransactionDetailsPage().clickMerchantTransctions();
			businessTokenAccountPage.merchantTransactionDetailsPage().filterPopup()
					.verifyTransactionType(data.get("labeltransactionType"));
			businessTokenAccountPage.merchantTransactionDetailsPage().filterPopup().clickResetAllFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testResetFiltersForMerchantTransactions Failed due to this Exception" + e);
		}
	}

}