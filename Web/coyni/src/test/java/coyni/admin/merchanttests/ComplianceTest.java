package coyni.admin.merchanttests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.Paymentcomponents.AccountTableComponent;
import coyni.admin.components.SideBarComponent;
import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ComplianceTest {

	HomePage homePage;
	SideBarComponent sideBarComponent;
	AccountTableComponent accountTableComponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		sideBarComponent = new SideBarComponent();
		accountTableComponent = new AccountTableComponent();

	}

	@Test
	@Parameters("strParams")
	public void testCompliance(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCompliance();
			homePage.sideBarComponent().clickPaymentReview();
			homePage.sideBarComponent().clickCountryConfiguration();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters("strParams")
	public void testCompliancePaymentReview(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCompliance();
			homePage.sideBarComponent().clickPaymentReview();
			homePage.sideBarComponent().clickCountryConfiguration();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
		}
	}

}
