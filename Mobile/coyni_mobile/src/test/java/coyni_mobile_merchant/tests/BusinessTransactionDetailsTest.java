package coyni_mobile_merchant.tests;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.NavigationComponent;
import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import coyni_mobile_merchant.pages.BusinessTransactionsPage;
import coyni_mobile_merchant.pages.MerchantProfilePage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class BusinessTransactionDetailsTest {

	BusinessTransactionsPage businessTransactionsPage;
	BusinessTokenAccountPage businessTokenAccountPage;

	@BeforeTest
	public void init() {
		businessTransactionsPage = new BusinessTransactionsPage();
		businessTokenAccountPage = new BusinessTokenAccountPage();

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
	public void testBusinessTransactionDetailsWithBankaccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			businessTokenAccountPage.clickAccount();
//			businessTokenAccountPage.
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangeEmailWithValidDetails failed due to Exception " + e);
		}
	}

}
