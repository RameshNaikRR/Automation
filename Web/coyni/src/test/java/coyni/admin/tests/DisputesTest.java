package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.ExportComponent;
import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class DisputesTest {

	HomePage homePage;
	ExportComponent exportcomponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		exportcomponent = new ExportComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testDisputesTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp", "expValue", "expColor");
			homePage.sideBarComponent().clickDisputes();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDisputesTest Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void VerifyFilter(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickDisputes();
			homePage.sideBarComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().filterComponent().verifyFiltersHeadings(data.get("filterHeadings"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("VerifyFilter Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void VerifyCaseNumFilterWonDispaly(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickDisputes();
			homePage.sideBarComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().filterComponent().enterCaseNum(data.get("caseNum"));
			homePage.sideBarComponent().filterComponent().clickWon();
			homePage.sideBarComponent().filterComponent().clickApplyFilters();
			String caseNum = homePage.sideBarComponent().filterComponent().getCaseNum();
			if (caseNum.contains(data.get("caseNum"))) {
				ExtentTestManager
						.setInfoMessageInReport("Given " + caseNum + " is present in apply filter search results");
			} else {
				ExtentTestManager
						.setFailMessageInReport("Given " + caseNum + " is not present in apply filter search results");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("VerifyCaseNumFilterWonDispaly Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void verifyDisputesExportsStatusCaseID(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(3000);
			exportcomponent.clickExport();
			homePage.sideBarComponent().filterComponent()
					.verifyDisputesExportStatusCaseID(data.get("disputesExportsStatusCaseID"));
			exportcomponent.clickExportButton();
			exportcomponent.clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("verifyDisputesExportsStatusCaseID Failed due to Exception " + e);
		}
	}

}
