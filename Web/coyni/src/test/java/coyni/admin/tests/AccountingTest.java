package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class AccountingTest {

	HomePage homePage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountingTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickAccounting();
			homePage.sideBarComponent().clickTotalWithdraw();
			homePage.sideBarComponent().clickTotalDeposits();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountingTest Failed due to Exception " + e);
		}
	}

}
